/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.context.annotation;

import java.lang.annotation.Annotation;
import java.util.Set;
import java.util.regex.Pattern;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.parsing.BeanComponentDefinition;
import org.springframework.beans.factory.parsing.CompositeComponentDefinition;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.beans.factory.xml.XmlReaderContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.AspectJTypeFilter;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.lang.Nullable;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

/**
 * Parser for the {@code <context:component-scan/>} element.
 *
 * @author Mark Fisher
 * @author Ramnivas Laddad
 * @author Juergen Hoeller
 * @since 2.5
 */
public class ComponentScanBeanDefinitionParser implements BeanDefinitionParser {

    private static final String BASE_PACKAGE_ATTRIBUTE = "base-package";

    private static final String RESOURCE_PATTERN_ATTRIBUTE = "resource-pattern";

    private static final String USE_DEFAULT_FILTERS_ATTRIBUTE = "use-default-filters";

    private static final String ANNOTATION_CONFIG_ATTRIBUTE = "annotation-config";

    private static final String NAME_GENERATOR_ATTRIBUTE = "name-generator";

    private static final String SCOPE_RESOLVER_ATTRIBUTE = "scope-resolver";

    private static final String SCOPED_PROXY_ATTRIBUTE = "scoped-proxy";

    private static final String EXCLUDE_FILTER_ELEMENT = "exclude-filter";

    private static final String INCLUDE_FILTER_ELEMENT = "include-filter";

    private static final String FILTER_TYPE_ATTRIBUTE = "type";

    private static final String FILTER_EXPRESSION_ATTRIBUTE = "expression";


    @Override
    @Nullable
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        /*
         * 1 首先获取"base-package"属性的值，因为该属性是必须的
         */
        String basePackage = element.getAttribute(BASE_PACKAGE_ATTRIBUTE);
        /*
         * 2 使用环境变量对象的resolvePlaceholders方法来解析basePackage包路径字符串中的占位符，这说明basePackage也可以使用占位符${..:..}
         *
         * resolvePlaceholders将会使用非严格的PropertyPlaceholderHelper模式，忽略没有默认值的无法解析的占位符，直接采用原值而不会抛出异常
         * ${..:..}占位符的解析我们在此前的setConfigLocations部分已经讲过了。注意，这里的占位符只支持environment中的属性。
         */
        basePackage = parserContext.getReaderContext().getEnvironment().resolvePlaceholders(basePackage);
        /*
         * 3 将传递的路径字符串根据分隔符分割为一个路径字符串数组
         *
         * 支持以","、";"、" "、"\t"、"\n"中的任意字符作为分隔符来表示传递了多个包路径
         */
        String[] basePackages = StringUtils.tokenizeToStringArray(basePackage,
                ConfigurableApplicationContext.CONFIG_LOCATION_DELIMITERS);

        /*
         * 4 获取一个配置扫描器ClassPathBeanDefinitionScanner
         * 使用配置扫描器在指定的basePackage包路径中扫描符合规则的bean的定义，并且注册到注册表缓存中
         *
         * 重要
         */
        ClassPathBeanDefinitionScanner scanner = configureScanner(parserContext, element);

        //真正的扫描
        Set<BeanDefinitionHolder> beanDefinitions = scanner.doScan(basePackages);

        /*
         * 重要
         * 5 注册一些组件，比如一些注解后处理器
         *
         * 主要用于解析对应的注解，对Spring容器里已注册的bean进行装配、依赖注入，甚至添加新的bean（比如@Bean注解）
         */
        registerComponents(parserContext.getReaderContext(), beanDefinitions, element);

        return null;
    }

    protected ClassPathBeanDefinitionScanner configureScanner(ParserContext parserContext, Element element) {
        ////useDefaultFilters表示use-default-filters属性的值，默认就是true
        boolean useDefaultFilters = true;
        if (element.hasAttribute(USE_DEFAULT_FILTERS_ATTRIBUTE)) {
            useDefaultFilters = Boolean.parseBoolean(element.getAttribute(USE_DEFAULT_FILTERS_ATTRIBUTE));
        }
        //设置默认的use-type-filter
        //扫描下 META-INF/spring.components
        ClassPathBeanDefinitionScanner scanner = createScanner(parserContext.getReaderContext(), useDefaultFilters);

        scanner.setBeanDefinitionDefaults(parserContext.getDelegate().getBeanDefinitionDefaults());
        scanner.setAutowireCandidatePatterns(parserContext.getDelegate().getAutowireCandidatePatterns());

        if (element.hasAttribute(RESOURCE_PATTERN_ATTRIBUTE)) {
            scanner.setResourcePattern(element.getAttribute(RESOURCE_PATTERN_ATTRIBUTE));
        }

        try {
            //解析name-generator属性
            parseBeanNameGenerator(element, scanner);
        } catch (Exception ex) {
            parserContext.getReaderContext().error(ex.getMessage(), parserContext.extractSource(element), ex.getCause());
        }

        try {
            //解析scope-resolver和scoped-proxy属性
            parseScope(element, scanner);
        } catch (Exception ex) {
            parserContext.getReaderContext().error(ex.getMessage(), parserContext.extractSource(element), ex.getCause());
        }
        /*
         * 2 解析类型过滤器，解析include-filter和exclude-filter子标签
         */
        parseTypeFilters(element, scanner, parserContext);

        return scanner;
    }

    protected ClassPathBeanDefinitionScanner createScanner(XmlReaderContext readerContext, boolean useDefaultFilters) {
        return new ClassPathBeanDefinitionScanner(readerContext.getRegistry(), useDefaultFilters,
                readerContext.getEnvironment(), readerContext.getResourceLoader());
    }

    protected void registerComponents(
            XmlReaderContext readerContext, Set<BeanDefinitionHolder> beanDefinitions, Element element) {

        Object source = readerContext.extractSource(element);

        //使用标签的名称和source构建一个CompositeComponentDefinition
        CompositeComponentDefinition compositeDef = new CompositeComponentDefinition(element.getTagName(), source);

        for (BeanDefinitionHolder beanDefHolder : beanDefinitions) {
            compositeDef.addNestedComponent(new BeanComponentDefinition(beanDefHolder));
        }

        // Register annotation config processors, if necessary.
        boolean annotationConfig = true;
        if (element.hasAttribute(ANNOTATION_CONFIG_ATTRIBUTE)) {
            annotationConfig = Boolean.parseBoolean(element.getAttribute(ANNOTATION_CONFIG_ATTRIBUTE));
        }
        /*
         * 如有必要，注册注解处理器
         * annotationConfig表示是否开启class内部的注解配置支持的标志位，用于通过注解对Spring容器里已注册的bean进行装配、依赖注入，默认true
         *
         * 这就是<context:annotation-config/> 标签的功能，在<context:component-scan/>标签中的annotation-config属性也有这个功能
         * 因此<context:component-scan/>标签具有<context:annotation-config/> 标签的全部功能，所以建议直接配置<context:component-scan/>标签就行了
         */
        if (annotationConfig) {
            /*注册所有注解配置后处理器*/
            Set<BeanDefinitionHolder> processorDefinitions =
                    AnnotationConfigUtils.registerAnnotationConfigProcessors(readerContext.getRegistry(), source);
            /*将每一个注册的注解配置后处理器的BeanDefinition添加到compositeDef的nestedComponents属性中*/
            for (BeanDefinitionHolder processorDefinition : processorDefinitions) {
                compositeDef.addNestedComponent(new BeanComponentDefinition(processorDefinition));
            }
        }
        /*最后发布注册事件，通知相关的监听器，这是一个空实现，留给子类扩展*/
        readerContext.fireComponentRegistered(compositeDef);
    }

    protected void parseBeanNameGenerator(Element element, ClassPathBeanDefinitionScanner scanner) {
        if (element.hasAttribute(NAME_GENERATOR_ATTRIBUTE)) {
            BeanNameGenerator beanNameGenerator = (BeanNameGenerator) instantiateUserDefinedStrategy(
                    element.getAttribute(NAME_GENERATOR_ATTRIBUTE), BeanNameGenerator.class,
                    scanner.getResourceLoader().getClassLoader());
            scanner.setBeanNameGenerator(beanNameGenerator);
        }
    }

    protected void parseScope(Element element, ClassPathBeanDefinitionScanner scanner) {
        // Register ScopeMetadataResolver if class name provided.
        if (element.hasAttribute(SCOPE_RESOLVER_ATTRIBUTE)) {
            if (element.hasAttribute(SCOPED_PROXY_ATTRIBUTE)) {
                throw new IllegalArgumentException(
                        "Cannot define both 'scope-resolver' and 'scoped-proxy' on <component-scan> tag");
            }
            ScopeMetadataResolver scopeMetadataResolver = (ScopeMetadataResolver) instantiateUserDefinedStrategy(
                    element.getAttribute(SCOPE_RESOLVER_ATTRIBUTE), ScopeMetadataResolver.class,
                    scanner.getResourceLoader().getClassLoader());
            scanner.setScopeMetadataResolver(scopeMetadataResolver);
        }

        if (element.hasAttribute(SCOPED_PROXY_ATTRIBUTE)) {
            String mode = element.getAttribute(SCOPED_PROXY_ATTRIBUTE);
            if ("targetClass".equals(mode)) {
                scanner.setScopedProxyMode(ScopedProxyMode.TARGET_CLASS);
            } else if ("interfaces".equals(mode)) {
                scanner.setScopedProxyMode(ScopedProxyMode.INTERFACES);
            } else if ("no".equals(mode)) {
                scanner.setScopedProxyMode(ScopedProxyMode.NO);
            } else {
                throw new IllegalArgumentException("scoped-proxy only supports 'no', 'interfaces' and 'targetClass'");
            }
        }
    }

    protected void parseTypeFilters(Element element, ClassPathBeanDefinitionScanner scanner, ParserContext parserContext) {
        // Parse exclude and include filter elements.
        ClassLoader classLoader = scanner.getResourceLoader().getClassLoader();
        NodeList nodeList = element.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                String localName = parserContext.getDelegate().getLocalName(node);
                try {
                    //include-filter
                    if (INCLUDE_FILTER_ELEMENT.equals(localName)) {
                        TypeFilter typeFilter = createTypeFilter((Element) node, classLoader, parserContext);
                        scanner.addIncludeFilter(typeFilter);
                        //exclude-filter
                    } else if (EXCLUDE_FILTER_ELEMENT.equals(localName)) {
                        TypeFilter typeFilter = createTypeFilter((Element) node, classLoader, parserContext);
                        scanner.addExcludeFilter(typeFilter);
                    }
                } catch (ClassNotFoundException ex) {
                    parserContext.getReaderContext().warning(
                            "Ignoring non-present type filter class: " + ex, parserContext.extractSource(element));
                } catch (Exception ex) {
                    parserContext.getReaderContext().error(
                            ex.getMessage(), parserContext.extractSource(element), ex.getCause());
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    protected TypeFilter createTypeFilter(Element element, @Nullable ClassLoader classLoader,
                                          ParserContext parserContext) throws ClassNotFoundException {

        String filterType = element.getAttribute(FILTER_TYPE_ATTRIBUTE);
        String expression = element.getAttribute(FILTER_EXPRESSION_ATTRIBUTE);
        expression = parserContext.getReaderContext().getEnvironment().resolvePlaceholders(expression);
        if ("annotation".equals(filterType)) {
            //创建一个AnnotationTypeFilter，expression应该是注解的全路径名，通过该注解匹配类或者接口（及其子类、子接口）
            //之前讲的默认类型过滤器：@Component、@ManagedBean、@Named过滤器都是属于AnnotationTypeFilter
            return new AnnotationTypeFilter((Class<Annotation>) ClassUtils.forName(expression, classLoader));
        } else if ("assignable".equals(filterType)) {
            return new AssignableTypeFilter(ClassUtils.forName(expression, classLoader));
        } else if ("aspectj".equals(filterType)) {
            return new AspectJTypeFilter(expression, classLoader);
        } else if ("regex".equals(filterType)) {
            return new RegexPatternTypeFilter(Pattern.compile(expression));
        } else if ("custom".equals(filterType)) {
            Class<?> filterClass = ClassUtils.forName(expression, classLoader);
            if (!TypeFilter.class.isAssignableFrom(filterClass)) {
                throw new IllegalArgumentException(
                        "Class is not assignable to [" + TypeFilter.class.getName() + "]: " + expression);
            }
            return (TypeFilter) BeanUtils.instantiateClass(filterClass);
        } else {
            throw new IllegalArgumentException("Unsupported filter type: " + filterType);
        }
    }

    @SuppressWarnings("unchecked")
    private Object instantiateUserDefinedStrategy(
            String className, Class<?> strategyType, @Nullable ClassLoader classLoader) {

        Object result;
        try {
            result = ReflectionUtils.accessibleConstructor(ClassUtils.forName(className, classLoader)).newInstance();
        } catch (ClassNotFoundException ex) {
            throw new IllegalArgumentException("Class [" + className + "] for strategy [" +
                    strategyType.getName() + "] not found", ex);
        } catch (Throwable ex) {
            throw new IllegalArgumentException("Unable to instantiate class [" + className + "] for strategy [" +
                    strategyType.getName() + "]: a zero-argument constructor is required", ex);
        }

        if (!strategyType.isAssignableFrom(result.getClass())) {
            throw new IllegalArgumentException("Provided class name must be an implementation of " + strategyType);
        }
        return result;
    }

}

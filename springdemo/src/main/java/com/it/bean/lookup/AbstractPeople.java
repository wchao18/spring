package com.it.bean.lookup;

public abstract class AbstractPeople {

    public void say(){
        getPeople().say();
    }

    public abstract People getPeople();
}

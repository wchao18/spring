package com.it.service.impl;

import com.it.bean.bo.HeadLine;
import com.it.bean.dto.Result;
import com.it.service.HeadLineService;
import org.springframework.stereotype.Service;

@Service
public class HeadLineServiceImpl implements HeadLineService {
	@Override
	public Result<Boolean> addHeadLine(HeadLine headLine) {
		System.out.printf("addHeadLine被执行啦, lineName[{%s}],lineLink[{%s}],lineImg[{%s}], priority[{%d}]",
				headLine.getLineName(), headLine.getLineLink(), headLine.getLineImg(), headLine.getPriority());
		Result<Boolean> result = new Result<Boolean>();
		result.setCode(200);
		result.setMsg("请求成功啦");
		result.setData(true);
		return result;
	}
}

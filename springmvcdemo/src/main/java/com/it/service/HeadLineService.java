package com.it.service;

import com.it.bean.bo.HeadLine;
import com.it.bean.dto.Result;

public interface HeadLineService {
	Result<Boolean> addHeadLine(HeadLine headLine);
}

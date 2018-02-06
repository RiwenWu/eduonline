package com.eduonline.service;

import com.eduonline.model.Sort;

public interface SortService {
	
	/**
	 * 添加分类
	 */
	int insertSelective(Sort sort) throws Exception;
	
}

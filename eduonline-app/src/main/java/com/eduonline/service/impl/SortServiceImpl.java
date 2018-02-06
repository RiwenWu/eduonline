package com.eduonline.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduonline.dao.SortMapper;
import com.eduonline.model.Sort;
import com.eduonline.service.SortService;

@Service
public class SortServiceImpl implements SortService{
	
	@Autowired
	private SortMapper sortMapper;

	@Override
	public int insertSelective(Sort sort) throws Exception {
		sort.setCreateTime(new Date());
		return sortMapper.insertSelective(sort);
	}

}

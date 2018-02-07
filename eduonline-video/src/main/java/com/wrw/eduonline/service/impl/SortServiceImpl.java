package com.wrw.eduonline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrw.eduonline.dao.SortMapper;
import com.wrw.eduonline.entity.Sort;
import com.wrw.eduonline.service.SortService;

@Service
public class SortServiceImpl implements SortService{

	@Autowired
	private SortMapper sortMapper;
	
	@Override
	public List<Sort> queryAll() throws Exception {
		return sortMapper.queryAll();
	}

}

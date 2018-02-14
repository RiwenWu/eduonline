package com.wrw.eduonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrw.eduonline.dao.Course_SortMapper;
import com.wrw.eduonline.entity.Course_Sort;
import com.wrw.eduonline.service.CourseSortService;

@Service
public class CourseSortServiceImpl implements CourseSortService{

	@Autowired
	private Course_SortMapper courseSortMapper;

	@Override
	public int insertSelective(Course_Sort cs) throws Exception {
		return courseSortMapper.insertSelective(cs);
	}
	

}

package com.eduonline.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduonline.dao.CourseMapper;
import com.eduonline.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseMapper courseMapper;
	
	@Override
	public List<Map<String, Object>> queryCourseListByPage(Integer start, Integer end) throws Exception {
		return courseMapper.queryCourseListByPage(start, end);
	}

}

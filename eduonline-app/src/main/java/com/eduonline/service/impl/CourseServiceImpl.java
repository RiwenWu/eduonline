package com.eduonline.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduonline.dao.CourseMapper;
import com.eduonline.model.Course;
import com.eduonline.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseMapper courseMapper;
	
	@Override
	public List<Map<String, Object>> queryCourseListByPage(Integer start, Integer end) throws Exception {
		return courseMapper.queryCourseListByPage(start, end);
	}

	@Override
	public Map<String, Object> queryCourseById(Long id) throws Exception {
		return courseMapper.queryCourseById(id);
	}

}

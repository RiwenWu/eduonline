package com.wrw.eduonline.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrw.eduonline.dao.CourseMapper;
import com.wrw.eduonline.entity.Course;
import com.wrw.eduonline.service.CourseService;

@Service
public class CourseServceImpl implements CourseService{
	
	@Autowired
	private CourseMapper courseMapper;
	
	@Override
	public int insertSelective(Course course) throws Exception {
		course.setCreateTime(new Date());
		return courseMapper.insertSelective(course);
	}
	
}

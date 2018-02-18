package com.wrw.eduonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrw.eduonline.dao.CourseVideoMapper;
import com.wrw.eduonline.entity.CourseVideo;
import com.wrw.eduonline.service.CourseVideoService;

@Service
public class CourseVideoServiceImpl implements CourseVideoService{

	@Autowired
	private CourseVideoMapper courseVideoMapper;
	
	@Override
	public int insertSelective(CourseVideo cv) throws Exception {
		return courseVideoMapper.insertSelective(cv);
	}

}

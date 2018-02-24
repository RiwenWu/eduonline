package com.eduonline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduonline.dao.CourseVideoMapper;
import com.eduonline.model.Video;
import com.eduonline.service.CourseVideoService;

@Service
public class CourseVideoServiceImpl implements CourseVideoService{

	@Autowired
	private CourseVideoMapper courseVideoMapper;
	
	@Override
	public List<Video> queryVideoListByCourseId(Long courseId) throws Exception {
		return courseVideoMapper.queryVideoListByCourseId(courseId);
	}

}

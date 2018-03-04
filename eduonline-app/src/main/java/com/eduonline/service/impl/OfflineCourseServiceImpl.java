package com.eduonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduonline.dao.OfflineCourseMapper;
import com.eduonline.model.OfflineCourse;
import com.eduonline.service.OfflineCourseService;

@Service
public class OfflineCourseServiceImpl implements OfflineCourseService{

	@Autowired
	private OfflineCourseMapper offlineCourseMapper;
	
	@Override
	public OfflineCourse selectByPrimaryKey(Long id) {
		return offlineCourseMapper.selectByPrimaryKey(id);
	}

}

package com.wrw.eduonline.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrw.eduonline.dao.OfflineCourseMapper;
import com.wrw.eduonline.entity.OfflineCourse;
import com.wrw.eduonline.service.OfflineCourseService;

@Service
public class OfflineCourseServiceImpl implements OfflineCourseService{

	@Autowired
	private OfflineCourseMapper offlineCourseMapper;
	
	@Override
	public int insertSelective(OfflineCourse record) {
		record.setCretateTime(new Date());
		return offlineCourseMapper.insertSelective(record);
	}

}

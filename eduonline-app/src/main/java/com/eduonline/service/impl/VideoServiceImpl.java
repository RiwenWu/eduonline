package com.eduonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduonline.dao.VideoMapper;
import com.eduonline.model.Video;
import com.eduonline.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService{

	@Autowired
	private VideoMapper videoMapper;
	
	@Override
	public Video selectByPrimaryKey(Long id) {
		return videoMapper.selectByPrimaryKey(id);
	}

}

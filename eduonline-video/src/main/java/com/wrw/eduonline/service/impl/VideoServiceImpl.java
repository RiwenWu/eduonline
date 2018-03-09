package com.wrw.eduonline.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrw.eduonline.dao.VideoMapper;
import com.wrw.eduonline.entity.Video;
import com.wrw.eduonline.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService{

	@Autowired
	private VideoMapper videoMapper;
	
	@Override
	public int insertSelective(Video video) throws Exception {
		video.setCreateTime(new Date());
		return videoMapper.insertSelective(video);
	}

	@Override
	public int updateByPrimaryKeySelective(Video video) throws Exception {
		video.setModifyTime(new Date());
		return videoMapper.updateByPrimaryKeySelective(video);
	}

	@Override
	public List<Map<String, Object>> queryVideoListByCourseId(Long courseId) throws Exception {
		return videoMapper.queryVideoListByCourseId(courseId);
	}

	@Override
	public int updateVideoStateById(Video video) throws Exception {
		return videoMapper.updateByPrimaryKeySelective(video);
	}

}

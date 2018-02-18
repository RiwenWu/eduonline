package com.wrw.eduonline.service;

import com.wrw.eduonline.entity.Video;

public interface VideoService {

	int insertSelective(Video video) throws Exception;
	
	int updateByPrimaryKeySelective(Video video) throws Exception;
}

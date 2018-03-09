package com.wrw.eduonline.service;

import java.util.List;
import java.util.Map;

import com.wrw.eduonline.entity.Video;

public interface VideoService {

	int insertSelective(Video video) throws Exception;
	
	int updateByPrimaryKeySelective(Video video) throws Exception;
	
	List<Map<String, Object>> queryVideoListByCourseId(Long courseId) throws Exception;
	
	int updateVideoStateById(Video video) throws Exception;
}

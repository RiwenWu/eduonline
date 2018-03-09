package com.wrw.eduonline.service;

import java.util.Map;

import com.wrw.eduonline.entity.OfflineCourse;

public interface OfflineCourseService {

	int insertSelective(OfflineCourse record);
	
	Map<String, Object> queryOfflineCourseByCourseId(Long courseId) throws Exception;
	
	int updateByPrimaryKeySelective(OfflineCourse record);
}

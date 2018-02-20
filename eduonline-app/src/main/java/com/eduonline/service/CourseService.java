package com.eduonline.service;

import java.util.List;
import java.util.Map;

import com.eduonline.model.Course;

public interface CourseService {

	/**
	 * 根据分页获取课程列表
	 * @param start
	 * @param end
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> queryCourseListByPage(Integer start, Integer end) throws Exception;
	
	Map<String, Object> queryCourseById(Long id) throws Exception;
}

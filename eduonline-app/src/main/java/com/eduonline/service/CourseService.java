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
	
	/**
	 * 根据LsitIds获取课程列表
	 * @param courseIds
	 * @return
	 * @throws Exception
	 */
	List<Map<Object, Object>> queryCourseListByIds(List<String> courseIds) throws Exception;
	
	/**
	 * 根据搜索内容获取courseList
	 * @param inputValue
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> findCourseByinput(String inputValue) throws Exception;
	
	/**
	 * 根据sortId获取courseList
	 * @param sortId
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> queryCourseListBysortId(Long sortId) throws Exception;
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> queryComnendCourseList() throws Exception;
}

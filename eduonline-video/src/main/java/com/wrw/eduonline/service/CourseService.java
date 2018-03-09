package com.wrw.eduonline.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wrw.eduonline.entity.Course;

public interface CourseService {

	int insertSelective(Course course) throws Exception;
	
	int updateByPrimaryKeySelective(Course course);
	
	/**
	 * 根据commendState / inputValue获取courseList
	 * @param commendState
	 * @param inputValue
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> queryCourseListBycommendState(@Param("commendState") String commendState, @Param("inputValue")String inputValue) throws Exception;

	List<Map<String, Object>> queryCourselistByPage(Integer pageNo, Integer pageSize, String inputValue) throws Exception;
	
	List<Map<String, Object>> queryCourselistByInputValue(String inputValue) throws Exception;

	Map<String, Object> queryCourseById(Long id) throws Exception;
}

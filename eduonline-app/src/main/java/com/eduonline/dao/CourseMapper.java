package com.eduonline.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.eduonline.model.Course;

public interface CourseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
    
    List<Map<String, Object>> queryCourseListByPage(@Param("start")Integer start, @Param("end")Integer end) throws Exception;

	Map<String, Object> queryCourseById(Long id);
	
	Map<Object, Object> queryCourseByIds(Long courseId) throws Exception;
	
	List<Map<String, Object>> findCourseByinput(String inputValue) throws Exception;
	
	List<Map<String, Object>> queryCourseListBysortId(Long sortId) throws Exception;
	
	List<Map<String, Object>> queryComnendCourseList() throws Exception;
}
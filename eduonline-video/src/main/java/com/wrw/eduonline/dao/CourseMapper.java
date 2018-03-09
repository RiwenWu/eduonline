package com.wrw.eduonline.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wrw.eduonline.entity.Course;

public interface CourseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
    
    List<Map<String, Object>> queryCourseListBycommendState(@Param("commendState") String commendState, @Param("inputValue")String inputValue) throws Exception;

    List<Map<String, Object>> queryCourselistByPage(@Param("start")Integer start, @Param("end")Integer end, @Param("inputValue") String inputValue) throws Exception;
    
    List<Map<String, Object>> queryCourselistByInputValue(@Param("inputValue") String inputValue) throws Exception;

    Map<String, Object> queryCourseById(Long id) throws Exception;
}
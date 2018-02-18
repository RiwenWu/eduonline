package com.eduonline.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CourseService {

	List<Map<String, Object>> queryCourseListByPage(Integer start, Integer end) throws Exception;	
}

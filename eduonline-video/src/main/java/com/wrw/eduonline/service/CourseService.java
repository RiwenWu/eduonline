package com.wrw.eduonline.service;

import com.wrw.eduonline.entity.Course;

public interface CourseService {

	int insertSelective(Course course) throws Exception;
}

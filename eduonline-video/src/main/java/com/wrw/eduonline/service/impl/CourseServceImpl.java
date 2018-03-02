package com.wrw.eduonline.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrw.eduonline.dao.CourseMapper;
import com.wrw.eduonline.entity.Course;
import com.wrw.eduonline.service.CourseService;

@Service
public class CourseServceImpl implements CourseService{
	
	@Autowired
	private CourseMapper courseMapper;
	
	@Override
	public int insertSelective(Course course) throws Exception {
		course.setCreateTime(new Date());
		return courseMapper.insertSelective(course);
	}

	/**
	 * 根据commendState / inputValue获取courseList
	 * @param commendState
	 * @param inputValue
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> queryCourseListBycommendState(String commendState, String inputValue)
			throws Exception {
		return courseMapper.queryCourseListBycommendState(commendState, inputValue);
	}

	@Override
	public int updateByPrimaryKeySelective(Course record) {
		record.setModifyTime(new Date());
		return courseMapper.updateByPrimaryKeySelective(record);
	}
	
}

package com.eduonline.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduonline.dao.CourseMapper;
import com.eduonline.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseMapper courseMapper;
	
	@Override
	public List<Map<String, Object>> queryCourseListByPage(Integer start, Integer end) throws Exception {
		return courseMapper.queryCourseListByPage(start, end);
	}

	@Override
	public Map<String, Object> queryCourseById(Long id) throws Exception {
		return courseMapper.queryCourseById(id);
	}

	@Override
	public List<Map<Object, Object>> queryCourseListByIds(List<String> courseIds) throws Exception {
		List<Map<Object, Object>> courseList = new ArrayList<Map<Object, Object>>();
		Map<Object, Object> courseMap = new HashMap<Object, Object>();
		for(String temp_id : courseIds) {
			Long id = Long.parseLong(temp_id);
			courseMap = courseMapper.queryCourseByIds(id);
			courseList.add(courseMap);
		}
		return courseList;
	}

	@Override
	public List<Map<String, Object>> findCourseByinput(String inputValue) throws Exception {
		return courseMapper.findCourseByinput(inputValue);
	}

	/**
	 * 根据sortId获取courseList
	 * @param sortId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> queryCourseListBysortId(Long sortId) throws Exception {
		return courseMapper.queryCourseListBysortId(sortId);
	}

	/**
	 * 获取推荐课程列表并随机选取4个
	 */
	@Override
	public List<Map<String, Object>> queryComnendCourseList() throws Exception {
		List<Map<String, Object>> courseList = new ArrayList<>();
		List<Map<String, Object>> temp_courseList = courseMapper.queryComnendCourseList();
		Map<String, Object> course = new HashMap<String, Object>();
		if(temp_courseList.size() > 4) {
			for(int i = 0; i < 4; i++) {
				course = temp_courseList.get(new Random().nextInt(temp_courseList.size()));
				temp_courseList.remove(course);
				courseList.add(course);
			}
		}else {
			courseList = temp_courseList;
		}
		return courseList;
	}

}

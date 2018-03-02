package com.wrw.eduonline.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wrw.eduonline.entity.Course;
import com.wrw.eduonline.service.CourseService;

@Controller
@RequestMapping("/video/courseManage")
public class courseManage {

	@Autowired
	private CourseService courseService;
	
	/**
	 * 根据commendState / inputValue获取courseList
	 * @param commendState
	 * @param inputValue
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/queryCourseListBycommendState.json")
	public Map<String, Object> queryCourseListBycommendState(
			String commendState, @RequestParam(value = "inputValue", required = false) String inputValue,
			Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		List<Map<String, Object>> courseList = new ArrayList();
		map.put("bool", false);
		try {
			courseList = courseService.queryCourseListBycommendState(commendState, inputValue);
			map.put("code", 0);
			map.put("msg", "更新");
			map.put("data", courseList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 修改推荐状态
	 * @param record
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/changeCommendState.json")
	public Map<String, Object> updateByPrimaryKeySelective(String courseId, String commendState){
		Map<String, Object> map = new HashMap<String, Object>();
		Course course = new Course();
		map.put("bool", false);
		Long cId = Long.parseLong(courseId);
		course.setId(cId);
		course.setCommendState(commendState);
		try {
			courseService.updateByPrimaryKeySelective(course);
			map.put("bool", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}

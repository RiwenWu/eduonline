package com.eduonline.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eduonline.service.CourseService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@ResponseBody
	@RequestMapping(value = "/queryallcourseBypage.json" ,method=RequestMethod.GET)
	public Map<String, Object> QueryAllCourseByPageRecommand(@RequestParam(value = "PAGENO")Integer pageNo) {
		
		System.out.println(pageNo);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> courseList = new ArrayList<Map<String, Object>>();
		//一次加载6个
		Integer pageSize = 6;
		Integer start=(pageNo - 1) * pageSize;
		Integer end = start + pageSize;
		map.put("bool", false);
		
		try {
			courseList = courseService.queryCourseListByPage(start, end);
			if (courseList.size() == 0) {
				map.put("msg", "已全部加载完了");
			}
			map.put("data", courseList);
			map.put("bool", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "应该是service层出错了");
		}
		return map;
	}
}

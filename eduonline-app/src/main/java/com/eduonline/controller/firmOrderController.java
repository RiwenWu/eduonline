package com.eduonline.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eduonline.service.CourseService;

@Controller
public class firmOrderController {

	@Autowired
	private CourseService courseService;
	
	/**
	 * 根据courseIds获取课程列表
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryCourseListByIds.json")
	public Map<String, Object> queryCourseListByIds(String courseIds){
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<Object, Object>> courseList = new ArrayList<Map<Object, Object>>();
		BigDecimal totalSalary = new BigDecimal("0.00");
		map.put("bool", false);
		//数组转list
		List<String> ids = stringToList(sub(courseIds, 2,-2));

		try {
			courseList = courseService.queryCourseListByIds(ids);
			for (Map<Object, Object> temp_map : courseList) {
				System.out.println(temp_map.get("salary"));
				totalSalary = totalSalary.add((BigDecimal) temp_map.get("salary"));
			}
			map.put("data", courseList);
			map.put("totalSalary", totalSalary);
			map.put("bool", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	//选择截取的位置
	public static String sub(String str,int start,int end){
	    String result = null;

	    if(str == null || str.equals(""))
	        return "";

	    int len=str.length();
	    start = start < 0 ? len+start : start-1;
	    end= end < 0 ? len+end+1 :end;

	    return str.substring(start, end);
	}
	
	//12，13，14 转list
	private List<String> stringToList(String strs){
		String str[] = strs.split(",");
		return Arrays.asList(str);
		}
}

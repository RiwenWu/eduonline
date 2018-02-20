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

import com.eduonline.model.UserCollection;
import com.eduonline.model.UserCourse;
import com.eduonline.service.CourseService;
import com.eduonline.service.UserCollectionService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;
	@Autowired
	private UserCollectionService userCollectionService;

	/**
	 * 根据pageNo获取全部课程列表
	 * 
	 * @param pageNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryallcourseBypage.json", method = RequestMethod.GET)
	public Map<String, Object> QueryAllCourseByPageRecommand(@RequestParam(value = "PAGENO") Integer pageNo) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> courseList = new ArrayList<Map<String, Object>>();
		// 一次加载6个
		Integer pageSize = 6;
		Integer start = (pageNo - 1) * pageSize;
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

	/**
	 * 根据Id获取课程
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryCourseById.json", method = RequestMethod.POST)
	public Map<String, Object> queryCourseById(String id) {

		// String转Long
		Long courseId = Long.parseLong(id);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> courseMap = new HashMap<String, Object>();
		map.put("bool", false);
		map.put("msg", "出现未知错误，请联系我们");

		try {
			courseMap = courseService.queryCourseById(courseId);
			map.put("data", courseMap);
			map.put("bool", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * code 0 ：取消收藏 ，1： 收藏成功 
	 * @param userId
	 * @param courseId
	 * @param collection
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/changeCollection.json")
	public Map<String, Object> changeCollection(String userId, String courseId, String collection) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bool", false);
		// String转Long
		Long uId = Long.parseLong(userId);
		Long cId = Long.parseLong(courseId);
		
		UserCollection uc = new UserCollection();

		try {
			uc = userCollectionService.queryUserCouseByIds(uId, cId);
			if (uc == null) {
				UserCollection temp_uc = new UserCollection();
				temp_uc.setCourseId(cId);
				temp_uc.setUserId(uId);
				temp_uc.setCollection("1");
				userCollectionService.insertSelective(temp_uc);
				map.put("code", 1);
				map.put("bool", true);
			}else {
				if (uc.getCollection() != collection) {
					uc.setCollection(collection);
					userCollectionService.updateByPrimaryKeySelective(uc);
				}
				if (collection.equals("0")) {
					map.put("code", 0);
				} else {
					map.put("code", 1);
				}
			}
			map.put("bool", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/queryUserCollectionByIds.json")
	public Map<String, Object> queryUserCollectionByIds(String userId, String courseId){
		
		Map<String, Object> map = new HashMap<String, Object>();
		Long uId = Long.parseLong(userId);
		Long cId = Long.parseLong(courseId);
		map.put("bool", false);
		
		try {
			UserCollection uc = userCollectionService.queryUserCouseByIds(uId, cId);
			map.put("data", uc);
			map.put("bool", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}

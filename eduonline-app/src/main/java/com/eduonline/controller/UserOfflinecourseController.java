package com.eduonline.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eduonline.model.OfflineCourse;
import com.eduonline.model.UserOfflinecourse;
import com.eduonline.service.OfflineCourseService;
import com.eduonline.service.UserOfflinecourseService;

@Controller
public class UserOfflinecourseController {

	@Autowired
	private UserOfflinecourseService userOfflinecourseService;
	@Autowired
	private OfflineCourseService offlineCourseService;
	
	/**
	 * 根据offlineCourseId获取线下课程
	 * @param offlineCourseId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryOfflineCourseById.json")
	public Map<String, Object> queryOfflineCourseById(String offlineCourseId){
		
		Map<String, Object> map = new HashMap<String, Object>();
		OfflineCourse offlineCourse = new OfflineCourse();
		map.put("bool", false);
		Long oId = Long.parseLong(offlineCourseId);
		
		try {
			offlineCourse = offlineCourseService.selectByPrimaryKey(oId);
			map.put("data", offlineCourse);
			map.put("bool", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * code 1:已经加入 2:加入成功
	 * 根据userId 和 offlinecourseId 添加计划
	 * @param userId
	 * @param offlinecourseId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/joinPlan.json")
	public Map<String, Object> joinPlan(String userId, String offlineCourseId){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bool", false);
		Long uId = Long.parseLong(userId);
		Long oId = Long.parseLong(offlineCourseId);
		//初始化
		UserOfflinecourse userOfflinecourse = new UserOfflinecourse();
		UserOfflinecourse temp_userOfflinecourse = new UserOfflinecourse();
		userOfflinecourse.setUserId(uId);
		userOfflinecourse.setOfflinecourseId(oId);
		try {
			//判断是否已经加入或退出该活动
			temp_userOfflinecourse = userOfflinecourseService.selectByIds(uId, oId);
			if(temp_userOfflinecourse != null && temp_userOfflinecourse.getState().equals("0")) {//如果已经存在并且状态为0
				map.put("code", 1);
			} else if(temp_userOfflinecourse != null && temp_userOfflinecourse.getState().equals("1")) {//如果已经存在并且状态为1
				temp_userOfflinecourse.setState("0");
				userOfflinecourseService.updateByPrimaryKeySelective(temp_userOfflinecourse);
				map.put("code", 2);
			} else {
				userOfflinecourseService.insertSelective(userOfflinecourse);
				map.put("code", 2);
			}
			map.put("bool", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 根据userId获取offlinecourseList
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryOfflineCourseList.json")
	private Map<String, Object> queryOfflineCourseList(String userId){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bool", false);
		List<Map<Object, Object>> offlineCourseList = new ArrayList<Map<Object, Object>>();
		Long uId = Long.parseLong(userId);
		try {
			offlineCourseList = userOfflinecourseService.queryOfflineCourseListByuserId(uId);
			map.put("data", offlineCourseList);
			map.put("bool", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 根据userOfflinecourseId修改修改状态
	 * @param offlineCourseId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/changeUserOfflineCourseStateById.json")
	private Map<String, Object> changeUserOfflineCourseState(String userOfflinecourseId, String state){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bool", false);
		//String转Long
		Long uoId = Long.parseLong(userOfflinecourseId);
		//初始化
		UserOfflinecourse userOfflineCourse = new UserOfflinecourse();
		userOfflineCourse.setId(uoId);
		userOfflineCourse.setState(state);
		try {
			userOfflinecourseService.updateByPrimaryKeySelective(userOfflineCourse);
			map.put("bool", true);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}

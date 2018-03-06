package com.eduonline.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eduonline.model.UserJoinPlan;
import com.eduonline.service.UserJoinPlanService;

/**   
 *    
 * 项目名称：eduonline-app   
 * 类名称：UserJoinPlanController   
 * 类描述：   
 * 创建人：wrw   
 * 创建时间：2018年3月5日 上午2:43:35   
 * @version        
 */
@Controller
public class UserJoinPlanController {

	@Autowired
	private UserJoinPlanService userJoinPlanService;
	
	/**
	 * 根据userId获取加入课程列表
	 * @param uId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryJoinCourseListById.json")
	public Map<String, Object> queryJoinCourseListById(String userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Long uId = Long.parseLong(userId);
		map.put("bool", false);
		
		try {
			List<Map<String, Object>> joinCourseList = userJoinPlanService.queryJoinListByuId(uId);
			map.put("data", joinCourseList);
			map.put("bool", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 设置闹钟参数
	 * @param conteng
	 * @param hour
	 * @param minutes
	 * @param daysOfweek
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/setttingClock.json")
	public Map<String, Object> settingClock(String id, String content, String hour, String minutes, String daysOfweek){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bool", false);
		//string 转long
		Long UjpId = Long.parseLong(id);
		UserJoinPlan ujp = new UserJoinPlan();
		ujp.setId(UjpId);
		ujp.setClockState("1");
		ujp.setClocksettingState("1");
		ujp.setContent(content);
		ujp.setHour(hour);
		ujp.setMiuntes(minutes);
		ujp.setDaysofweek(daysOfweek);
		
		try {
			userJoinPlanService.settingClockById(ujp);
			map.put("bool", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 根据UserJoinPlan获取clockList
	 */
	@ResponseBody
	@RequestMapping(value = "/queryClockListByuserId.json")
	public Map<String, Object> queryClockListByUserJoinPlanId(String userId){
		Map<String, Object> map = new HashMap<String, Object>();
		//Sting 转 long
		Long uId = Long.parseLong(userId);
		List<Map<String, Object>> clockList = new ArrayList<Map<String, Object>>();
		map.put("bool", false);
		
		try {
			clockList = userJoinPlanService.queryClockByuserId(uId);
			map.put("data", clockList);
			map.put("bool", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 *  根据id获取userjoinplan
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "selectByPrimaryKey.json")
	public Map<String, Object> selectByPrimaryKey(String id){
		Map<String, Object> map = new HashMap<String ,Object>();
		Long ujpId = Long.parseLong(id);
		map.put("bool", false);
		try {
			UserJoinPlan ujp = userJoinPlanService.selectByPrimaryKey(ujpId);
			map.put("data", ujp);
			map.put("bool", true);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 关闭提示
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/changeClockState.json")
	public Map<String, Object> changeClockState(String id){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bool", false);
		Long ujpId = Long.parseLong(id);
		UserJoinPlan ujp = new UserJoinPlan();
		ujp.setId(ujpId);
		ujp.setClockState("0");
		try {
			userJoinPlanService.updateByPrimaryKeySelective(ujp);
			map.put("bool", true);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}

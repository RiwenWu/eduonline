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
import com.eduonline.model.UserJoinPlan;
import com.eduonline.model.Video;
import com.eduonline.service.CourseService;
import com.eduonline.service.CourseVideoService;
import com.eduonline.service.UserCollectionService;
import com.eduonline.service.UserJoinPlanService;
import com.eduonline.service.VideoService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;
	@Autowired
	private UserCollectionService userCollectionService;
	@Autowired
	private UserJoinPlanService userJoinPlanService;
	@Autowired
	private CourseVideoService courseVideoService;
	@Autowired
	private VideoService videoService;

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
	 * 
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
			} else {
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

	/**
	 * 根据Ids获取收藏情况
	 * 
	 * @param userId
	 * @param courseId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryUserCollectionByIds.json")
	public Map<String, Object> queryUserCollectionByIds(String userId, String courseId) {

		Map<String, Object> map = new HashMap<String, Object>();
		Long uId = Long.parseLong(userId);
		Long cId = Long.parseLong(courseId);
		map.put("bool", false);

		try {
			UserCollection uc = userCollectionService.queryUserCouseByIds(uId, cId);
			if (uc != null) {
				map.put("data", uc);
			}
			map.put("bool", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 根据Id获取收藏课程列表
	 * 
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryCourseListByUserId.json")
	public Map<String, Object> queryCourseListByUserId(String userId) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> courseList = new ArrayList<Map<String, Object>>();
		map.put("bool", false);
		Long uId = Long.parseLong(userId);

		try {
			courseList = userCollectionService.queryCourseListByUserId(uId);
			map.put("data", courseList);
			map.put("bool", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 
	 * @param userId
	 * @param courseId
	 * @param joinState
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/changeJoin.json")
	public Map<String, Object> changeJoin(String userId, String courseId, String joinState) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bool", false);
		// String转Long
		Long uId = Long.parseLong(userId);
		Long cId = Long.parseLong(courseId);

		UserJoinPlan ujp = new UserJoinPlan();

		try {
			ujp = userJoinPlanService.queryUJPByIds(uId, cId);
			if (ujp == null) {
				UserJoinPlan temp_ujp = new UserJoinPlan();
				temp_ujp.setCourseId(cId);
				temp_ujp.setUserId(uId);
				temp_ujp.setJoinState("1");
				userJoinPlanService.insertSelective(temp_ujp);
				map.put("code", 1);
				map.put("bool", true);
			} else {
				if (ujp.getJoinState() != joinState) {
					ujp.setJoinState(joinState);
					userJoinPlanService.updateByPrimaryKeySelective(ujp);
				}
				if (joinState.equals("0")) {
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
	
	/**
	 * 根据Ids课程加入情况
	 * 
	 * @param userId
	 * @param courseId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryUserJoinByIds.json")
	public Map<String, Object> queryUserJoinByIds(String userId, String courseId) {

		Map<String, Object> map = new HashMap<String, Object>();
		Long uId = Long.parseLong(userId);
		Long cId = Long.parseLong(courseId);
		map.put("bool", false);

		try {
			UserJoinPlan ujp = userJoinPlanService.queryUJPByIds(uId, cId);
			if (ujp != null) {
				map.put("data", ujp);
			}
			map.put("bool", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 根据userId获取加入课程列表
	 * @param uId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "queryJoinCourseListById.json")
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
	 * 根据courseId获取视频列表
	 * @param courseId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "queryVideoListByCourseId.json")
	public Map<String, Object> queryVideoListByCourseId(String courseId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Long cId = Long.parseLong(courseId);
		map.put("bool", false);
		try {
			List<Video> videoList = courseVideoService.queryVideoListByCourseId(cId);
			map.put("data", videoList);
			map.put("bool", true);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 根据videoId获取video
	 * @param courseId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "queryVideoById.json")
	public Map<String, Object> queryVideoById(String videoId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bool", false);
		Long vId = Long.parseLong(videoId);
		try {
			Video video = videoService.selectByPrimaryKey(vId);
			map.put("bool", true);
			map.put("data", video);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}

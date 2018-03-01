package com.eduonline.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eduonline.model.Order;
import com.eduonline.model.OrderCourse;
import com.eduonline.model.ShopCar;
import com.eduonline.service.CourseService;
import com.eduonline.service.OrderCourseService;
import com.eduonline.service.OrderService;
import com.eduonline.service.ShopCarService;

@Controller
public class firmOrderController {

	@Autowired
	private CourseService courseService;
	@Autowired
	private ShopCarService shopCarService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderCourseService orderCourseService;

	/**
	 * 根据courseIds获取课程列表
	 * 
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryCourseListByIds.json")
	public Map<String, Object> queryCourseListByIds(String courseIds) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<Object, Object>> courseList = new ArrayList<Map<Object, Object>>();
		BigDecimal totalSalary = new BigDecimal("0.00");
		map.put("bool", false);

		// 数组转list
		List<String> ids = stringToList(sub(courseIds, 3, -3));

		if (ids.size() == 0) {
			map.put("code", 1);
			return map;
		}

		try {
			courseList = courseService.queryCourseListByIds(ids);
			for (Map<Object, Object> temp_map : courseList) {
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

	/**
	 * 加入购物车 code2:已加入购物车，无需重复操作 1:成功加入购物车，请账号 我的购物车中查看
	 * 
	 * @param userId
	 * @param courseId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/insertCourseIntoCar.json")
	public Map<String, Object> insertCourseIntoCar(String userId, String courseId) {
		Map<String, Object> map = new HashMap<String, Object>();
		// String转Long
		Long cId = Long.parseLong(courseId);
		Long uId = Long.parseLong(userId);
		// 初始化
		ShopCar shopCar = new ShopCar();
		shopCar.setCourseId(cId);
		shopCar.setUserId(uId);

		map.put("bool", false);
		try {

			ShopCar temp = shopCarService.selectByShopCar(shopCar);
			if (temp == null) {
				shopCarService.insertSelective(shopCar);
				map.put("code", 1);
				map.put("bool", true);
				return map;
			} else if (temp != null && temp.getState().equals("0") && "0".equals(temp.getOrderState())) {// 判断是否已经加入过，并且状态均为0
				map.put("code", 2);
				map.put("bool", true);
				return map;
			} else if ("1".equals(temp.getState()) || "1".equals(temp.getOrderState())) {// 如果状态是删除或以提交状态 则修改状态
				temp.setState("0");
				temp.setOrderState("0");
				shopCarService.updateByPrimaryKeySelective(temp);
				map.put("code", 1);
				map.put("bool", true);
				return map;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 根据userId获取购物车课程列表
	 * 
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryCourseListByuserId.json")
	public Map<String, Object> queryCourseListByuserId(String userId) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<Object, Object>> courseList = new ArrayList<Map<Object, Object>>();
		map.put("bool", false);
		Long uId = Long.parseLong(userId);
		try {
			courseList = shopCarService.queryCourseListByuserId(uId);
			map.put("bool", true);
			map.put("data", courseList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 根据shopcarId修改状态
	 * 
	 * @param shopcarId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delCourseById.json")
	public Map<String, Object> delCourseByIds(String shopcarId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bool", false);
		// String转Long
		Long scId = Long.parseLong(shopcarId);
		// 初始化
		ShopCar sc = new ShopCar();
		sc.setId(scId);
		sc.setState("1");
		try {
			shopCarService.updateByPrimaryKeySelective(sc);
			map.put("bool", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * !!!!!!!!写得太傻了，有空重写！！！！！！ 提交订单
	 * 
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "firmOrder.json")
	public Map<String, Object> firmOrder(String userId, String courseIds) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bool", false);

		// String转list<String>
		List<String> listId = stringToList(sub(courseIds, 3, -3));
		if (listId.size() == 0) {
			map.put("code", 1);
		}
		Long uId = Long.parseLong(userId);
		// 创建对象
		Order order = new Order();
		OrderCourse orderCourse = new OrderCourse();
		ShopCar sc = new ShopCar();
		order.setUserId(uId);
		sc.setUserId(uId);
		try {
			// 创建订单
			orderService.insertSelective(order);
			orderCourse.setOrderId(order.getId());
			// 创建订单和课程的关联 并 修改购物车的状态
			for (String courseId : listId) {
				Long cId = Long.parseLong(courseId);
				orderCourse.setCourseId(cId);
				orderCourseService.insertSelective(orderCourse);
				// 修改购物车的order_state状态
				sc.setCourseId(cId);
				shopCarService.selectAndUpdate(sc);
			}
			map.put("bool", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 根据userId获取orderList
	 * 
	 * @param userId
	 * @param state
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryOrderListByuserId.json")
	public Map<String, Object> queryOrderListByuserId(String userId,
			@RequestParam(value = "state", required = false) String state) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<Order> orderList = new ArrayList<Order>();
		Long uId = Long.parseLong(userId);
		map.put("bool", false);
		try {
			orderList = orderService.queryOrderListByuserId(uId, state);
			map.put("data", orderList);
			map.put("bool", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 根据订单Id获取courseList
	 * @param orderId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryCourseListByorderId.json")
	public Map<String, Object> queryCourseListByorderId(String orderId){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> courseList = new ArrayList<Map<String, Object>>();
		Long oId = Long.parseLong(orderId);
		BigDecimal totalSalary = new BigDecimal("0.00");
		map.put("bool", false);
		try {
			courseList = orderService.queryCourseListByorderId(oId);
			map.put("data", courseList);
			for(Map<String, Object> temp_map : courseList) {
				totalSalary = totalSalary.add((BigDecimal) temp_map.get("courseSalary"));
			}
			map.put("totalSalary", totalSalary);
			map.put("bool", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 根據orderId改變訂單狀態
	 * @param orderId
	 * @param state
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateByPrimaryKeySelective.json")
	public Map<String, Object> updateByPrimaryKeySelective(String orderId, String state){
		Map<String, Object> map = new HashMap<String, Object>();
		Order order = new Order();
		map.put("boo", false);
		Long oId = Long.parseLong(orderId);
		order.setId(oId);
		order.setState(state);
		try {
			orderService.updateByPrimaryKeySelective(order);
			map.put("bool", true);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	// 选择截取的位置
	public static String sub(String str, int start, int end) {
		String result = null;

		if (str == null || str.equals("")) {
			return "";
		}

		int len = str.length();
		start = start < 0 ? len + start : start - 1;
		end = end < 0 ? len + end + 1 : end;

		return str.substring(start, end);
	}

	// 12，13，14 转list
	private List<String> stringToList(String strs) {
		String[] str = strs.split(",");
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < str.length; i++) {
			if (findSame(list, str[i])) {
				continue;
			} else {
				list.add(str[i]);
			}
		}
		return list;
	}

	// 遍历list 如果有相同的remove
	private boolean findSame(List<String> list, String str) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(str)) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}
}

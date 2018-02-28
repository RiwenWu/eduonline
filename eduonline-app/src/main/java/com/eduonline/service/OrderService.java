package com.eduonline.service;

import java.util.List;
import java.util.Map;

import com.eduonline.model.Order;

public interface OrderService {

	int insertSelective(Order order);
	
	List<Order> queryOrderListByuserId(Long userId, String state) throws Exception;
	
	List<Map<String, Object>> queryCourseListByorderId(Long orderId) throws Exception;
}

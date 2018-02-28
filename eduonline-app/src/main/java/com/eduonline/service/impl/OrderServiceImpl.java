package com.eduonline.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduonline.dao.OrderCourseMapper;
import com.eduonline.dao.OrderMapper;
import com.eduonline.model.Order;
import com.eduonline.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderCourseMapper orderCourseMapper;
	
	@Override
	public int insertSelective(Order order) {
		order.setOrderno(randomInt(12));
		order.setCreateTime(new Date());
		return orderMapper.insertSelective(order);
	}
	
	@Override
	public List<Order> queryOrderListByuserId(Long userId, String state) throws Exception {
		return orderMapper.queryOrderListByuserId(userId, state);
	}
	
	@Override
	public List<Map<String, Object>> queryCourseListByorderId(Long orderId) throws Exception {
		return orderMapper.queryCourseListByorderId(orderId);
	}

	/**
	 * 随机生成数字
	 * @param length
	 * @return
	 */
	public static final String randomInt(int length) {
		if (length < 1) {
			return null;
		}
		Random randGen = new Random();
		char[] numbersAndLetters = "0123456789".toCharArray();

		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(10)];
		}
		return new String(randBuffer);
	}

}

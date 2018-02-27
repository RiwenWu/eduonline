package com.eduonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduonline.dao.OrderCourseMapper;
import com.eduonline.model.OrderCourse;
import com.eduonline.service.OrderCourseService;

@Service
public class OrderCourseServiceImpl implements OrderCourseService{

	@Autowired
	private OrderCourseMapper orderCourseMapper;
	
	@Override
	public int insertSelective(OrderCourse record) {
		return orderCourseMapper.insertSelective(record);
	}

}

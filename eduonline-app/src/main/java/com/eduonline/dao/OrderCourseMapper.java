package com.eduonline.dao;

import com.eduonline.model.OrderCourse;

public interface OrderCourseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderCourse record);

    int insertSelective(OrderCourse record);

    OrderCourse selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderCourse record);

    int updateByPrimaryKey(OrderCourse record);
}
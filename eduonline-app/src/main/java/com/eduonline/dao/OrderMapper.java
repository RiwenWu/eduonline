package com.eduonline.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.eduonline.model.Order;

public interface OrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    
    List<Order> queryOrderListByuserId(@Param("userId")Long userId, @Param("state")String state) throws Exception;
    
    List<Map<String, Object>> queryCourseListByorderId(Long orderId) throws Exception;
}
package com.eduonline.service;

import java.util.List;
import java.util.Map;

import com.eduonline.model.ShopCar;

public interface ShopCarService {

	int insertSelective(ShopCar record);
	
	int updateByPrimaryKeySelective(ShopCar record);
	
	ShopCar selectByShopCar(ShopCar shopCar) throws Exception;
	
	/**
	 * 根据userId获取加入购物车的课程列表
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	List<Map<Object, Object>> queryCourseListByuserId(Long userId) throws Exception;
	
	//有空这条重写，太傻了
	void selectAndUpdate(ShopCar shopCar) throws Exception;
}

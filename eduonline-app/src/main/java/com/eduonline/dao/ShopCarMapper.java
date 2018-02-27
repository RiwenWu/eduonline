package com.eduonline.dao;

import java.util.List;
import java.util.Map;

import com.eduonline.model.ShopCar;

public interface ShopCarMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShopCar record);

    int insertSelective(ShopCar record);

    ShopCar selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShopCar record);

    int updateByPrimaryKey(ShopCar record);
    
    List<Map<Object, Object>> queryCourseListByuserId(Long userId) throws Exception;
    
    ShopCar selectByShopCar(ShopCar shopCar) throws Exception;
    
    //有空这条重写，太傻了
    ShopCar selectByShopCar2(ShopCar shopCar) throws Exception;
}
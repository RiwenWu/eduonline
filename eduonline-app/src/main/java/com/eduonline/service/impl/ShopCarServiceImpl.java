package com.eduonline.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduonline.dao.ShopCarMapper;
import com.eduonline.model.ShopCar;
import com.eduonline.service.ShopCarService;

@Service
public class ShopCarServiceImpl implements ShopCarService{

	@Autowired
	private ShopCarMapper shopCarMapper;
	
	@Override
	public int insertSelective(ShopCar record) {
		record.setCreateTime(new Date());
		return shopCarMapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(ShopCar record) {
		record.setModifyTime(new Date());
		return shopCarMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<Map<Object, Object>> queryCourseListByuserId(Long userId) throws Exception {
		return shopCarMapper.queryCourseListByuserId(userId);
	}

	@Override
	public ShopCar selectByShopCar(ShopCar shopCar) throws Exception {
		return shopCarMapper.selectByShopCar(shopCar);
	}

	@Override
	public void selectAndUpdate(ShopCar shopCar) throws Exception {
		ShopCar sc = shopCarMapper.selectByShopCar2(shopCar);
		if(sc !=null) {
			sc.setOrderState("1");
			shopCarMapper.updateByPrimaryKeySelective(sc);
		}
	}

}

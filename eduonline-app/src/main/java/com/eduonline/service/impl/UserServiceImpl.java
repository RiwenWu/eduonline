package com.eduonline.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eduonline.dao.UserMapper;
import com.eduonline.model.User;
import com.eduonline.service.UserService;

@Transactional  
@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	/**
	 * 添加/注册用户
	 */
	@Override
	public int insertSelective(User user) throws Exception {
		user.setCreateTime(new Date());
		return userMapper.insertSelective(user);
	}

	/**
	 * 根据账号找user
	 */
	@Override
	public User selsectByAccount(String account) {
		return userMapper.selsectByAccount(account);
	}

}

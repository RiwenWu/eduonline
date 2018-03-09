package com.eduonline.service.impl;

import java.util.Date;
import java.util.Random;

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
		user.setUserName(randomInt(12));
		return userMapper.insertSelective(user);
	}

	/**
	 * 根据账号找user
	 */
	@Override
	public User selsectByAccount(String account) {
		return userMapper.selsectByAccount(account);
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

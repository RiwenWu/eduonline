package com.eduonline.service;

import com.eduonline.model.User;

public interface UserService {

	int insertSelective(User user) throws Exception;
	
	/**
	 * 根据账号找user
	 * @param account
	 * @return
	 * @throws Exception
	 */
	User selsectByAccount(String account);
}

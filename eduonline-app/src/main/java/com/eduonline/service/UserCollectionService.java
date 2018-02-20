package com.eduonline.service;

import com.eduonline.model.UserCollection;

public interface UserCollectionService {

	/**
     * 根据用户Id 和 课程Id获取UserCourse 
     * @param userId
     * @param courseId
     * @return
     * @throws Exception
     */
	UserCollection queryUserCouseByIds(Long userId, Long courseId) throws Exception;
	
	int insertSelective(UserCollection uc) throws Exception;
	
	int updateByPrimaryKeySelective(UserCollection uc) throws Exception;
}

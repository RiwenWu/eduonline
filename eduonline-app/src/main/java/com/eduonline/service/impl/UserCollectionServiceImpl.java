package com.eduonline.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduonline.dao.UserCollectionMapper;
import com.eduonline.model.UserCollection;
import com.eduonline.model.UserCourse;
import com.eduonline.service.UserCollectionService;

@Service
public class UserCollectionServiceImpl implements UserCollectionService{

	@Autowired
	private UserCollectionMapper userCollectionMapper;
	
	@Override
	public UserCollection queryUserCouseByIds(Long userId, Long courseId) throws Exception {
		return userCollectionMapper.queryUserCouseByIds(userId, courseId);
	}

	@Override
	public int insertSelective(UserCollection uc) throws Exception {
		uc.setCreateTime(new Date());
		return userCollectionMapper.insertSelective(uc);
	}

	@Override
	public int updateByPrimaryKeySelective(UserCollection uc) throws Exception {
		return userCollectionMapper.updateByPrimaryKey(uc);
	}

	@Override
	public List<Map<String, Object>> queryCourseListByUserId(Long userId) throws Exception {
		return userCollectionMapper.queryCourseListByUserId(userId);
	}

}

package com.eduonline.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduonline.dao.UserJoinPlanMapper;
import com.eduonline.model.UserJoinPlan;
import com.eduonline.service.UserJoinPlanService;

@Service
public class UserJoinPlanServiceImpl implements UserJoinPlanService{

	@Autowired
	private UserJoinPlanMapper userJoinPlanMapper;
	
	@Override
	public int insertSelective(UserJoinPlan ujp) throws Exception {
		ujp.setCreateTime(new Date());
		return userJoinPlanMapper.insertSelective(ujp);
	}

	@Override
	public int updateByPrimaryKeySelective(UserJoinPlan ujp) throws Exception {
		ujp.setModifyTime(new Date());
		return userJoinPlanMapper.updateByPrimaryKey(ujp);
	}

	@Override
	public UserJoinPlan queryUJPByIds(Long uId, Long cId) throws Exception {
		return userJoinPlanMapper.queryUJPByIds(uId, cId);
	}

	@Override
	public List<Map<String, Object>> queryJoinListByuId(Long uId) throws Exception {
		return userJoinPlanMapper.queryJoinListByuId(uId);
	}

}

package com.eduonline.service;

import java.util.List;
import java.util.Map;

import com.eduonline.model.UserJoinPlan;

public interface UserJoinPlanService {

	UserJoinPlan selectByPrimaryKey(Long id);
	
	int insertSelective(UserJoinPlan ujp) throws Exception;
	
	int updateByPrimaryKeySelective(UserJoinPlan ujp) throws Exception;
	
	UserJoinPlan queryUJPByIds(Long uId, Long cId) throws Exception;
	
	List<Map<String, Object>> queryJoinListByuId(Long uId) throws Exception;
	
	int settingClockById(UserJoinPlan record) throws Exception;
	
	List<Map<String, Object>> queryClockByuserId(Long userId) throws Exception;
}

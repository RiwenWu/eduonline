package com.eduonline.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.eduonline.model.UserJoinPlan;

public interface UserJoinPlanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserJoinPlan record);

    int insertSelective(UserJoinPlan record);

    UserJoinPlan selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserJoinPlan record);

    int updateByPrimaryKey(UserJoinPlan record);
    
    /**
     * 根据Ids获取加入情况
     * @param uId
     * @param cId
     * @return
     * @throws Exception
     */
    UserJoinPlan queryUJPByIds(@Param("userId")Long uId, @Param("courseId")Long cId) throws Exception;
    
    /**
     * 根据userId获取课程学习列表
     * @param uId
     * @return
     * @throws Exception
     */
    List<Map<String, Object>> queryJoinListByuId(@Param("userId")Long uId) throws Exception;
    
    int settingClockById(UserJoinPlan record) throws Exception;
    
    List<Map<String ,Object>> queryClockByuserId(Long userId) throws Exception;
}
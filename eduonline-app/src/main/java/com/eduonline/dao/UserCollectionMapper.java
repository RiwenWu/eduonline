package com.eduonline.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.eduonline.model.UserCollection;

public interface UserCollectionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserCollection record);

    int insertSelective(UserCollection record);

    UserCollection selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserCollection record);

    int updateByPrimaryKey(UserCollection record);
    
    /**
     * 根据Ids获取课程收藏情况
     * @param userId
     * @param courseId
     * @return
     * @throws Exception
     */
    UserCollection queryUserCouseByIds(@Param("userId")Long userId, @Param("courseId")Long courseId) throws Exception;
    
    /**
     * 根据UserId获取收藏课程列表
     * @param userId
     * @return
     * @throws Exception
     */
    List<Map<String, Object>> queryCourseListByUserId(@Param("userId")Long userId) throws Exception;
}
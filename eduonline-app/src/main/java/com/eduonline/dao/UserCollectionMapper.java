package com.eduonline.dao;

import org.apache.ibatis.annotations.Param;

import com.eduonline.model.UserCollection;

public interface UserCollectionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserCollection record);

    int insertSelective(UserCollection record);

    UserCollection selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserCollection record);

    int updateByPrimaryKey(UserCollection record);
    
    UserCollection queryUserCouseByIds(@Param("userId")Long userId, @Param("courseId")Long courseId) throws Exception;
}
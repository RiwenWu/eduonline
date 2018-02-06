package com.eduonline.dao;

import com.eduonline.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    /**
     * 根据账号找user
     * @param account
     * @return
     */
    User selsectByAccount(String account);
}
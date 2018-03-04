package com.eduonline.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.eduonline.model.UserOfflinecourse;

public interface UserOfflinecourseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserOfflinecourse record);

    int insertSelective(UserOfflinecourse record);

    UserOfflinecourse selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserOfflinecourse record);

    int updateByPrimaryKey(UserOfflinecourse record);
    
    UserOfflinecourse selectByIds(@Param("userId")Long userId, @Param("offlineCourseId")Long offlineCourseId);
    
    List<Map<Object, Object>> queryOfflineCourseListByuserId(Long userId);
}
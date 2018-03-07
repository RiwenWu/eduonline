package com.eduonline.dao;

import com.eduonline.model.UserOwnCourses;

public interface UserOwnCoursesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserOwnCourses record);

    int insertSelective(UserOwnCourses record);

    UserOwnCourses selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserOwnCourses record);

    int updateByPrimaryKey(UserOwnCourses record);
    
    UserOwnCourses qeuryUOwnCoursesByuserId(Long userId) throws Exception;
}
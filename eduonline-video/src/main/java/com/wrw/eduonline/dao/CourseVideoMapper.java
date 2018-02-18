package com.wrw.eduonline.dao;

import com.wrw.eduonline.entity.CourseVideo;

public interface CourseVideoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CourseVideo record);

    int insertSelective(CourseVideo record);

    CourseVideo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CourseVideo record);

    int updateByPrimaryKey(CourseVideo record);
}
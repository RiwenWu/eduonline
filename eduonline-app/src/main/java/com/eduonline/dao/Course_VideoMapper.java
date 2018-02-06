package com.eduonline.dao;

import com.eduonline.model.Course_Video;

public interface Course_VideoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Course_Video record);

    int insertSelective(Course_Video record);

    Course_Video selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Course_Video record);

    int updateByPrimaryKey(Course_Video record);
}
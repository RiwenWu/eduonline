package com.wrw.eduonline.dao;

import com.wrw.eduonline.entity.Course_Sort;

public interface Course_SortMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Course_Sort record);

    int insertSelective(Course_Sort record);

    Course_Sort selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Course_Sort record);

    int updateByPrimaryKey(Course_Sort record);
}
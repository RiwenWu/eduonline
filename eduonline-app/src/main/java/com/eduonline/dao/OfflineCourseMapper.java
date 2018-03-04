package com.eduonline.dao;

import com.eduonline.model.OfflineCourse;

public interface OfflineCourseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OfflineCourse record);

    int insertSelective(OfflineCourse record);

    OfflineCourse selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OfflineCourse record);

    int updateByPrimaryKey(OfflineCourse record);
}
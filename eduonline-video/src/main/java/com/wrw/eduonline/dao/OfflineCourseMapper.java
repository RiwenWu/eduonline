package com.wrw.eduonline.dao;

import java.util.Map;

import com.wrw.eduonline.entity.OfflineCourse;

public interface OfflineCourseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OfflineCourse record);

    int insertSelective(OfflineCourse record);

    OfflineCourse selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OfflineCourse record);

    int updateByPrimaryKey(OfflineCourse record);
    
    Map<String, Object> queryOfflineCourseByCourseId(Long courseId) throws Exception;
}
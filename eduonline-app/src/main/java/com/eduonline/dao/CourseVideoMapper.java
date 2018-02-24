package com.eduonline.dao;

import java.util.List;

import com.eduonline.model.CourseVideo;
import com.eduonline.model.Video;

public interface CourseVideoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CourseVideo record);

    int insertSelective(CourseVideo record);

    CourseVideo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CourseVideo record);

    int updateByPrimaryKey(CourseVideo record);
    
    /**
     * 根据courseId获取视频列表
     * @param courseId
     * @return
     * @throws Exception
     */
    List<Video> queryVideoListByCourseId(Long courseId) throws Exception;
}
package com.eduonline.service;

import java.util.List;

import com.eduonline.model.Video;

public interface CourseVideoService {

	List<Video> queryVideoListByCourseId(Long courseId) throws Exception;
}

package com.eduonline.service;

import java.util.List;
import java.util.Map;

import com.eduonline.model.UserOfflinecourse;

public interface UserOfflinecourseService {

	int insertSelective(UserOfflinecourse record);

    int updateByPrimaryKeySelective(UserOfflinecourse record);
    
    UserOfflinecourse selectByIds(Long userId, Long offlineCourseId) throws Exception;
    
    List<Map<Object, Object>> queryOfflineCourseListByuserId(Long userId) throws Exception;
}

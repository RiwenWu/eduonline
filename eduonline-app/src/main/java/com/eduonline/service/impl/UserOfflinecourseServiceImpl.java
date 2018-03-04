package com.eduonline.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduonline.dao.OfflineCourseMapper;
import com.eduonline.dao.UserOfflinecourseMapper;
import com.eduonline.model.UserOfflinecourse;
import com.eduonline.service.UserOfflinecourseService;

@Service
public class UserOfflinecourseServiceImpl implements UserOfflinecourseService{

	@Autowired
	private UserOfflinecourseMapper userOfflinecourseMapper;
	
	@Override
	public int insertSelective(UserOfflinecourse record) {
		record.setCreateTime(new Date());
		return userOfflinecourseMapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(UserOfflinecourse record) {
		record.setModifyTime(new Date());
		return userOfflinecourseMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public UserOfflinecourse selectByIds(Long userId, Long offlineCourseId) throws Exception {
		return userOfflinecourseMapper.selectByIds(userId, offlineCourseId);
	}

	@Override
	public List<Map<Object, Object>> queryOfflineCourseListByuserId(Long userId) throws Exception {
		List<Map<Object, Object>> offlinecourseList = new ArrayList<Map<Object, Object>>();
		offlinecourseList = userOfflinecourseMapper.queryOfflineCourseListByuserId(userId);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		for(Map<Object, Object> map : offlinecourseList) {

			//string转Date 用于比较
			Date temp_start = sdf.parse(map.get("offlinecourseStartTime").toString()); 
			Date temp_end = sdf.parse(map.get("offlinecourseEndTime").toString());
			Date temp_now = new Date();
			
			//date 转时间戳
			long startTime = temp_start.getTime();  
			long endTime = temp_end.getTime();
			long nowTime = temp_now.getTime();
			
			int days;
			if(temp_start.after(temp_now)) {//距离课程开始还有?天
				days = (int) ((startTime - nowTime)/(1000 * 60 * 60 * 24)) + 1;
				map.put("distanceBegins", days);
			} else {//距离课程结束还有?天
				days = (int) ((endTime - nowTime)/(1000 * 60 * 60 * 24)) + 1;
				map.put("distanceEnd", days);
			}
		}
		return offlinecourseList;
	}



}

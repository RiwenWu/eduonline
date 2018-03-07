package com.eduonline.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduonline.dao.UserOwnCoursesMapper;
import com.eduonline.model.UserOwnCourses;
import com.eduonline.service.UserOwnCoursesService;

/**
 * 
 * 项目名称：eduonline-app 类名称：UserOwnCoursesServiceImpl 类描述： 创建人：wrw 创建时间：2018年3月7日
 * 上午3:25:51
 * 
 * @version
 */
@Service
public class UserOwnCoursesServiceImpl implements UserOwnCoursesService {

	@Autowired
	private UserOwnCoursesMapper userOwnCoursesMapper;

	/**
	 * 记录用户购买的课程
	 */
	@Override
	public void markUserCourse(Long userId, String courseIds) {

		UserOwnCourses temp_uocs = new UserOwnCourses();
		String ids = null;
		String temp_courseIds = null;
		try {
			temp_uocs = userOwnCoursesMapper.qeuryUOwnCoursesByuserId(userId);
			//处理courseIds
			temp_courseIds = courseIds.replace("\"", "");
			if (temp_uocs != null) {// 如果有就Coursesids字段加数据
				ids = temp_uocs.getCoursesids() + "," + sub(temp_courseIds, 2, -2);
				temp_uocs.setCoursesids(ids);
				temp_uocs.setModityTime(new Date());
				userOwnCoursesMapper.updateByPrimaryKeySelective(temp_uocs);
			} else if (temp_uocs == null) {// 如果没有就创建记录
				UserOwnCourses uocs = new UserOwnCourses();
				uocs.setCoursesids(sub(temp_courseIds, 2, -2));
				uocs.setUserId(userId);
				uocs.setCreateTime(new Date());
				userOwnCoursesMapper.insertSelective(uocs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询用户是否购买了该课程
	 */
	@Override
	public boolean findUserIsOwn(Long userId, String courseId) {
		Boolean result = false;
		UserOwnCourses uocs = new UserOwnCourses();
		List<String> courseIdList = new ArrayList<String>();
		try {
			uocs = userOwnCoursesMapper.qeuryUOwnCoursesByuserId(userId);
			if(uocs == null) {
				return result;
			} else {
				courseIdList = stringToList(uocs.getCoursesids());
				for(String id : courseIdList) {
					if(id.equals(courseId)) {
						result = true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 选择截取的位置
	public static String sub(String str, int start, int end) {
		String result = null;

		if (str == null || str.equals("")) {
			return "";
		}

		int len = str.length();
		start = start < 0 ? len + start : start - 1;
		end = end < 0 ? len + end + 1 : end;

		return str.substring(start, end);
	}

	// 12，13，14 转list
	private List<String> stringToList(String strs) {
		String[] str = strs.split(",");
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < str.length; i++) {
			if (findSame(list, str[i])) {
				continue;
			} else {
				list.add(str[i]);
			}
		}
		return list;
	}

	// 遍历list 如果有相同的remove
	private boolean findSame(List<String> list, String str) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(str)) {
				list.remove(i);
				return true;
			}
		}
		return false;
	}

}

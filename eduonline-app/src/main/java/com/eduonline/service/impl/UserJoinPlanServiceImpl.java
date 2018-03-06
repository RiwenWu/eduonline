package com.eduonline.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduonline.dao.UserJoinPlanMapper;
import com.eduonline.model.UserJoinPlan;
import com.eduonline.service.UserJoinPlanService;

@Service
public class UserJoinPlanServiceImpl implements UserJoinPlanService{

	@Autowired
	private UserJoinPlanMapper userJoinPlanMapper;
	
	@Override
	public int insertSelective(UserJoinPlan ujp) throws Exception {
		ujp.setCreateTime(new Date());
		return userJoinPlanMapper.insertSelective(ujp);
	}

	@Override
	public int updateByPrimaryKeySelective(UserJoinPlan ujp) throws Exception {
		ujp.setModifyTime(new Date());
		return userJoinPlanMapper.updateByPrimaryKeySelective(ujp);
	}

	@Override
	public UserJoinPlan queryUJPByIds(Long uId, Long cId) throws Exception {
		return userJoinPlanMapper.queryUJPByIds(uId, cId);
	}

	@Override
	public List<Map<String, Object>> queryJoinListByuId(Long uId) throws Exception {
		return userJoinPlanMapper.queryJoinListByuId(uId);
	}

	/**
	 * 设置闹钟
	 */
	@Override
	public int settingClockById(UserJoinPlan record) throws Exception {
		record.setModifyTime(new Date());
		return userJoinPlanMapper.settingClockById(record);
	}

	/**
	 * 获取闹钟设置
	 */
	@Override
	public List<Map<String, Object>> queryClockByuserId(Long userId) throws Exception {
		List<Map<String, Object>> clockList = new ArrayList<Map<String, Object>>();
		clockList = userJoinPlanMapper.queryClockByuserId(userId);
		String temp_daysofweek = "";
		List<String> temp_list = new ArrayList<String>();

		for(Map<String, Object> map : clockList) {
			temp_daysofweek = (String) map.get("daysOfweek");
			temp_list = stringToList(sub(temp_daysofweek, 2, -2));
			String weekDay = "周";
			for(String s : temp_list) {
				if(s.equals("0")) {
					weekDay += "日";
				} else if(s.equals("1")) {
					weekDay += " 一";
				} else if(s.equals("2")) {
					weekDay += " 二";
				} else if(s.equals("3")) {
					weekDay += " 三";
				} else if(s.equals("4")) {
					weekDay += " 四";
				} else if(s.equals("5")) {
					weekDay += " 五";
				} else if(s.equals("6")) {
					weekDay += " 六";
				}
			}
			map.put("weekDay", weekDay);
		}

		return clockList;
	}
	
	@Override
	public UserJoinPlan selectByPrimaryKey(Long id) {
		return userJoinPlanMapper.selectByPrimaryKey(id);
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

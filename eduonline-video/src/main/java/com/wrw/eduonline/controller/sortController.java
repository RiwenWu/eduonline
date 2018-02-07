package com.wrw.eduonline.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wrw.eduonline.service.SortService;

@Controller
@RequestMapping("/video/sort")
public class sortController {

	@Autowired
	private SortService sortService;
	
	@ResponseBody
	@RequestMapping("list")
	public Map<String, Object> queryAllSort() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "更新");
		return map;
	}
}

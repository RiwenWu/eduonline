package com.wrw.eduonline.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wrw.eduonline.entity.Sort;
import com.wrw.eduonline.entity.dto.SortDTO;
import com.wrw.eduonline.service.SortService;

@Controller
@RequestMapping("/video/sort")
public class sortController {

	@Autowired
	private SortService sortService;

	@ResponseBody
	@RequestMapping(value = "/list", method=RequestMethod.GET, produces = "application/json")
	public Map<String, Object> queryAllSort(
			HttpServletRequest  request,HttpServletResponse response, 
			Integer page, Integer limit, @RequestParam(value = "searchValue", defaultValue = "") String searchValue, 
			@RequestParam(value = "type", defaultValue = "") String type
			) throws Exception {
		
		
		List<SortDTO> sortDTOList = sortService.queryAll(searchValue, type);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "更新");
		map.put("count", sortDTOList.size());
		map.put("data", sortDTOList);
		return map;
	}
	
	/**
	 * 获取sortList
	 * @param type
	 * @param PId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "querySortList.json")
	public Map<String, Object> querySortList(String type, @RequestParam(value = "PId", required = false)String PId){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Sort> sortList = new ArrayList<Sort>();
		map.put("bool", false);
		try {
			sortList = sortService.queryListByTypeOrPId(type, PId);
			map.put("bool", true);
			map.put("data", sortList);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}

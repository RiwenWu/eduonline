package com.wrw.eduonline.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrw.eduonline.dao.SortMapper;
import com.wrw.eduonline.entity.Sort;
import com.wrw.eduonline.entity.dto.SortDTO;
import com.wrw.eduonline.service.SortService;

@Service
public class SortServiceImpl implements SortService{

	@Autowired
	private SortMapper sortMapper;
	
	/**
	 * 获取全部分类
	 */
	@Override
	public List<SortDTO> queryAll(String search, String type) throws Exception {
		
		List<SortDTO> temp_sortDTOList = new ArrayList<SortDTO>();
		List<SortDTO> sortDTOList = new ArrayList<SortDTO>();
		
		Map<Long, String> firstMenu = new HashMap<Long, String>();
		Map<Long, String> secondtMenu = new HashMap<Long, String>();
		
		List<Sort> sortList = sortMapper.queryAll();
		
		for (Sort sort : sortList) {
			
			SortDTO sortDTO = new SortDTO();
			
			//创建Type = 0  和 1 的集合
			if (sort.getType().equals("0")) {
				firstMenu.put(sort.getId(), sort.getName());
			}
			if (sort.getType().equals("1")) {
				secondtMenu.put(sort.getId(), sort.getName());
			}
			
			//往对象中塞东西
			sortDTO.setId(sort.getId());
			sortDTO.setName(sort.getName());
			sortDTO.setType(sort.getType());
			
			//如果Type = 1 根据parentId在 Type = 1的集合中找
			if (sort.getType().equals("1")) {
				sortDTO.setFirstMenuName(firstMenu.get(sort.getParentId()));
				sortDTO.setFirstMenuNameId(sort.getParentId());
			}
			
			//如过Type = 2 根据parentId在 Type = 2的集合中找
			if (sort.getType().equals("2")) {
				sortDTO.setSecondMenuName(secondtMenu.get(sort.getParentId()));
				sortDTO.setSecondMenuNameId(sort.getParentId());
				for(SortDTO temp : sortDTOList) {
					if (temp.getId() == sort.getParentId()) {
						sortDTO.setFirstMenuName(temp.getFirstMenuName());
						sortDTO.setFirstMenuNameId(temp.getFirstMenuNameId());
					}
				}
			}
			
			sortDTOList.add(sortDTO);
		}
		if(search != null || type != null) {
			for (SortDTO temp1 : sortDTOList) {
				if (temp1.getName().contains(search)) {
					temp_sortDTOList.add(temp1);
				}
				if (temp1.getType().equals(type)) {
					temp_sortDTOList.add(temp1);
				}
			}
		}
		
		return temp_sortDTOList;
	}

}

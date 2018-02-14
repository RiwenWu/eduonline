package com.wrw.eduonline.service;

import java.util.List;

import com.wrw.eduonline.entity.Sort;
import com.wrw.eduonline.entity.dto.SortDTO;

public interface SortService {

	List<SortDTO> queryAll(String name, String type) throws Exception;
	
	List<Sort> querySortListByPId(long PId) throws Exception;
}

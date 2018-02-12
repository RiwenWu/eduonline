package com.wrw.eduonline.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrw.eduonline.dao.CoverMapper;
import com.wrw.eduonline.entity.Cover;
import com.wrw.eduonline.service.CoverService;

@Service
public class CoverServiceImpl implements CoverService{

	@Autowired
	private CoverMapper coverMapper;
	
	@Override
	public int insertSelective(Cover cover) throws Exception {
		cover.setCreatetime(new Date());
		return coverMapper.insertSelective(cover);
	}

}

package com.wrw.eduonline.dao;

import java.util.List;

import com.wrw.eduonline.entity.Sort;

public interface SortMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Sort record);

    int insertSelective(Sort record);

    Sort selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Sort record);

    int updateByPrimaryKey(Sort record);
    
    List<Sort> queryAll();
}
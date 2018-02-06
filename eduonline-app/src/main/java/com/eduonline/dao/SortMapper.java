package com.eduonline.dao;

import com.eduonline.model.Sort;

public interface SortMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Sort record);

    int insertSelective(Sort record);

    Sort selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Sort record);

    int updateByPrimaryKey(Sort record);
}
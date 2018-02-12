package com.wrw.eduonline.dao;

import com.wrw.eduonline.entity.Cover;

public interface CoverMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Cover record);

    int insertSelective(Cover record);

    Cover selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Cover record);

    int updateByPrimaryKey(Cover record);
}
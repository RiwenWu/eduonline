package com.eduonline.dao;

import com.eduonline.model.Cover;

public interface CoverMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Cover record);

    int insertSelective(Cover record);

    Cover selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Cover record);

    int updateByPrimaryKey(Cover record);
}
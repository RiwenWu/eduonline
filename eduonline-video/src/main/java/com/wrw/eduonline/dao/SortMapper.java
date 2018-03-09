package com.wrw.eduonline.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wrw.eduonline.entity.Sort;

public interface SortMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Sort record);

    int insertSelective(Sort record);

    Sort selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Sort record);

    int updateByPrimaryKey(Sort record);
    
    List<Sort> queryAll();
    
    /**
     * 根据PId获取分类列表
     * @param PId
     * @return
     */
    List<Sort> queryListByPId(long PId);
    
    List<Sort> queryListByTypeOrPId(@Param("type")String type, @Param("PId")Long PId);
}
package com.wrw.eduonline.common.dao;

import java.util.List;
import java.util.Map;

/**
 * @author wrw
 * dao基础类
 */
public interface BaseDao<T> {
	
	int deleteByPrimaryKey(Long Id);

    int insert(T clazz);

    int insertSelective(T clazz);

    T selectByPrimaryKey(Long Id);

    int updateByPrimaryKeySelective(T clazz);

    int updateByPrimaryKey(T clazz);
    
    void save(T t);
    
    void save(Map<String, Object> map);
    
    void saveBatch(List<T> list);
    
    int update(T clazz);
    
    int update(Map<String, Object> map);
    
    int delete(Object id);
    
    int delete(Map<String, Object> map);
    
    int deleteBatch(Object[] id);
    
    T queryObject(Object id);
    
    List<T> queryList(Map<String, Object> map);
    
    List<T> queryList(Object id);
    
    int queryTotal(Map<String, Object> map);
    
    int queryTotal();
}

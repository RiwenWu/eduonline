package com.wrw.eduonline.dao;

import java.util.List;

import com.wrw.eduonline.dao.BaseDao;
import com.wrw.eduonline.entity.SysMenuEntity;


/**   
 *    
 * 项目名称：eduonline-shiro   
 * 类名称：SysMenuDao   
 * 类描述：   
 * 创建人：wrw   
 * 创建时间：2017年9月15日 下午8:54:16   
 * @version        
 */
public interface SysMenuDao extends BaseDao<SysMenuEntity>{
    
	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId
	 * @return
	 */
	List<SysMenuEntity> queryListParentId(Long parentId);
	
	/**
	 * 获取不包含按钮的菜单列表
	 * @return
	 */
	List<SysMenuEntity> queryNotButtonList();
	
	/**
	 * 查询用户的权限列表
	 * @param userId
	 * @return
	 */
	List<SysMenuEntity> queryUserList(Long userId);
}
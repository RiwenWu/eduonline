package com.wrw.eduonline.service;

import java.util.List;
import java.util.Map;

import com.wrw.eduonline.entity.SysMenuEntity;

/**   
 *    
 * 项目名称：eduonline-shiro   
 * 类名称：SysMenuService   
 * 类描述：   
 * 创建人：wrw   
 * 创建时间：2017年9月16日 下午7:09:43   
 * @version        
 */
public interface SysMenuService {

	/**
	 * 根据父菜单，查询子菜单
	 * @param parentId
	 * @param menuIdList
	 * @return
	 */
	List<SysMenuEntity> queryListParentId(Long parentId, List<Long> menuIdList);
	
	/**
	 * 获取不包含按钮的菜单列表
	 * @return
	 */
	List<SysMenuEntity> queryNotButtonList();
	
	/**
	 * 获取用户菜单列表
	 * @param userId
	 * @return
	 */
	List<SysMenuEntity> getUserMenuList(Long userId);
	
	/**
	 * 查询菜单
	 * @param menuId
	 * @return
	 */
	SysMenuEntity queryObject(Long menuId);
	
	/**
	 * 查询菜单列表
	 * @param map
	 * @return
	 */
	List<SysMenuEntity> queryList(Map<String, Object> map);
	
	/**
	 * 查询总数
	 * @param map
	 * @return
	 */
	int queryTotal(Map<String, Object> map);
	
	/**
	 * 保存菜单
	 * @param menu
	 */
	void save(SysMenuEntity menu);
	
	/**
	 * 修改
	 * @param menu
	 */
	void update(SysMenuEntity menu);
	
	/**
	 * 删除
	 * @param menuIds
	 */
	void deleteBatch(Long[] menuIds);
	
	/**
	 * 查询用户的权限列表
	 * @param userId
	 * @return
	 */
	List<SysMenuEntity> queryUserList(Long userId);
}

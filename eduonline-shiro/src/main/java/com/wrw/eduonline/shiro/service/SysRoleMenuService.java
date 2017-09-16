package com.wrw.eduonline.shiro.service;

import java.util.List;

/**   
 *    
 * 项目名称：eduonline-shiro   
 * 类名称：SysRoleMenuService   
 * 类描述：   
 * 创建人：wrw   
 * 创建时间：2017年9月16日 下午8:29:02   
 * @version        
 */
public interface SysRoleMenuService {
	
	/**
	 * 根据角色Id，保存或修改菜单关系
	 * @param roleId
	 * @param menuIdList
	 */
	void saveOrUpdate(Long roleId, List<Long> menuIdList);
	
	/**
	 * 根据角色Id,获取菜单Id列表
	 * @param roleId
	 * @return
	 */
	List<Long> queryMenuIdList(Long roleId);
}

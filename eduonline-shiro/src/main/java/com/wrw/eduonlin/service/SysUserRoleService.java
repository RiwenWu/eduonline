package com.wrw.eduonlin.service;

import java.util.List;

/**   
 *    
 * 项目名称：eduonline-shiro   
 * 类名称：SysUserRoleService   
 * 类描述：   
 * 创建人：wrw   
 * 创建时间：2017年9月16日 下午4:07:57   
 * @version        
 */
public interface SysUserRoleService {
	
	/**
	 * 根据用户ID，保存或修改角色
	 * @param userId
	 * @param roleIdList
	 */
	void saveOrUpdate(Long userId, List<Long> roleIdList);
	
	/**
	 * 根据用户ID，获取角色ID列表
	 * @param userId
	 * @return
	 */
	List<Long> queryRoleIdList(Long userId);
	
	/**
	 * 根据用户ID，删除用户和角色关系
	 * @param userId
	 */
	void delete(Long userId);
}

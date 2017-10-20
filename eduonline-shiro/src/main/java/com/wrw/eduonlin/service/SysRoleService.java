package com.wrw.eduonlin.service;

import java.util.List;
import java.util.Map;

import com.wrw.eduonline.entity.SysRoleEntity;

/**   
 *    
 * 项目名称：eduonline-shiro   
 * 类名称：SysRoleService   
 * 类描述：   
 * 创建人：wrw   
 * 创建时间：2017年9月16日 下午2:18:56   
 * @version        
 */
public interface SysRoleService {
	
	/**
	 * 根据角色Id的，查询角色
	 * @param roleId
	 * @return
	 */
	SysRoleEntity queryObject(Long roleId);
	
	/**
	 * 查询角色列表
	 * @param map
	 * @return
	 */
	List<SysRoleEntity> queryList(Map<String, Object> map);
	
	/**
	 * 查询总数
	 * @param map
	 * @return
	 */
	int queryTotal(Map<String, Object> map);
	
	/**
	 * 保存角色
	 * @param role
	 */
	void save(SysRoleEntity role);
	
	/**
	 * 修改角色
	 * @param role
	 */
	void update(SysRoleEntity role);
	
	/**
	 * 删除角色
	 * @param roleIds
	 */
	void deleteBatch(Long[] roleIds);
	
	/**
	 * 查询用户创建的角色ID列表
	 * @param createUserId
	 * @return
	 */
	List<Long> queryRoleIdList(Long createUserId);
}

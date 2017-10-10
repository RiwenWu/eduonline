package com.wrw.eduonline.shiro.service;

import java.util.List;
import java.util.Map;

import com.wrw.eduonline.shiro.entity.SysUserEntity;

/**   
 *    
 * 项目名称：eduonline-shiro   
 * 类名称：SysUserService   
 * 类描述：   
 * 创建人：wrw   
 * 创建时间：2017年9月16日 下午12:34:02   
 * @version        
 */
public interface SysUserService {

	/**
	 * 查询用户的所有权限
	 * @param userId
	 * @return
	 */
	List<String> queryAllPerms(Long userId);
	
	/**
	 * 查询用户的菜单Id
	 * @param userId
	 * @return
	 */
	List<Long> queryAllMenuId(Long userId);
	
	/**
	 * 根据用户名，查询系统用户
	 * @param userName
	 * @return
	 */
	SysUserEntity queryByUserName(String userName);
	
	/**
	 * 根据用户Id，查询用户
	 * @param userId
	 * @return
	 */
	SysUserEntity queryObject(Long userId);
	
	/**
	 * 查询用户列表
	 * @param map
	 * @return
	 */
	List<SysUserEntity> queryList(Map<String, Object> map);
	
	/**
	 * 查询总数
	 * @param map
	 * @return
	 */
	int queryTotal(Map<String, Object> map);
	
	/**
	 * 保存用户
	 * @param user
	 */
	void save(SysUserEntity user);
	
	/**
	 * 修改用户
	 * @param user
	 */
	void update(SysUserEntity user);
	
	/**
	 * 删除用户
	 * @param userIds
	 */
	void deleteBatch(Long[] userIds);
	
	/**
	 * 修改密码
	 * @param user
	 * @return
	 */
	int updatePassword(Long userId, String password, String newPassword);
}

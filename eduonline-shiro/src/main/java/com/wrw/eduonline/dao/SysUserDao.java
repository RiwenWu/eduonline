package com.wrw.eduonline.dao;

import java.util.List;
import java.util.Map;

import com.wrw.eduonline.dao.BaseDao;
import com.wrw.eduonline.entity.SysUserEntity;


/**   
 *    
 * 项目名称：eduonline-shiro   
 * 类名称：SysUserDao   
 * 类描述：   
 * 创建人：wrw   
 * 创建时间：2017年9月14日 下午11:11:53   
 * @version        
 */
public interface SysUserDao extends BaseDao<SysUserEntity>{
	
	/**
	 * 查询用户所有的权限
	 * @param userId
	 * @return
	 */
	List<String> queryAllPerms(Long userId);
	
	/**
	 * 查询用户所有菜单
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
	 * 修改密码
	 * @param map
	 * @return
	 */
	int updatePassword(Map<String, Object> map);
}
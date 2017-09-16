package com.wrw.eduonline.shiro.dao;

import java.util.List;

import com.wrw.eduonline.common.dao.BaseDao;
import com.wrw.eduonline.shiro.entity.SysUserRoleEntity;


/**   
 *    
 * 项目名称：eduonline-shiro   
 * 类名称：SysUserRoleDao   
 * 类描述：   
 * 创建人：wrw   
 * 创建时间：2017年9月15日 上午12:55:12   
 * @version        
 */
public interface SysUserRoleDao extends BaseDao<SysUserRoleEntity>{
    
	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<Long> queryRoleIdList(Long userId);
}
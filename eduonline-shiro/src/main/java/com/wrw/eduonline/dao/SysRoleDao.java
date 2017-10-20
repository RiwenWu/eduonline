package com.wrw.eduonline.dao;

import java.util.List;

import com.wrw.eduonline.dao.BaseDao;
import com.wrw.eduonline.entity.SysRoleEntity;

public interface SysRoleDao extends BaseDao<SysRoleEntity>{
    
	/**
	 * 查询用户创建的角色ID列表
	 * @param createUserId
	 * @return
	 */
	List<Long> queryRoleIdList(Long createUserId);
}
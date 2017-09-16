package com.wrw.eduonline.shiro.dao;

import java.util.List;

import com.wrw.eduonline.common.dao.BaseDao;
import com.wrw.eduonline.shiro.entity.SysRoleMenuEntity;

public interface SysRoleMenuDao extends BaseDao<SysRoleMenuEntity> {
    
	/**
	 * 根据角色ID，获取菜单ID列表
	 * @param roleEd
	 * @return
	 */
	List<Long> queryMenuIdList(Long roleEd);
}
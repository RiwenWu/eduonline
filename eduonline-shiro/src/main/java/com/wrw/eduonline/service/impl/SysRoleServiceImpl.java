package com.wrw.eduonline.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wrw.eduonline.dao.SysRoleDao;
import com.wrw.eduonline.entity.SysRoleEntity;
import com.wrw.eduonline.service.SysRoleMenuService;
import com.wrw.eduonline.service.SysRoleService;
import com.wrw.eduonline.service.SysUserRoleService;
import com.wrw.eduonline.service.SysUserService;
import com.wrw.eduonline.utils.Constant;
import com.wrw.eduonline.utils.RRException;

/**
 * 
 * 项目名称：eduonline-shiro 类名称：SysRoleServiceImpl 类描述： SysRoleService实现类 创建人：wrw
 * 创建时间：2017年9月16日 下午2:26:42
 * 
 * @version
 */

@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	@Autowired
	private SysRoleMenuService sysRoleMenuService;

	@Override
	public SysRoleEntity queryObject(Long roleId) {
		return sysRoleDao.queryObject(roleId);
	}

	@Override
	public List<SysRoleEntity> queryList(Map<String, Object> map) {
		return sysRoleDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return sysRoleDao.queryTotal();
	}

	@Override
	@Transactional
	public void save(SysRoleEntity role) {
		role.setCreateTime(new Date());
		role.setModifiedTime(new Date());
		sysRoleDao.save(role);
		
		//检查权限是否越权
		checkPrems(role);
		
		//保存角色与菜单关系
		sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
	}

	@Override
	@Transactional
	public void update(SysRoleEntity role) {
		role.setModifiedTime(new Date());
		sysRoleDao.update(role);
		
		//检查权限是否越权
		checkPrems(role);
				
		//保存角色与菜单关系
		sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());
	}

	@Override
	@Transactional
	public void deleteBatch(Long[] roleIds) {
		sysRoleDao.deleteBatch(roleIds);
	}

	@Override
	public List<Long> queryRoleIdList(Long createUserId) {
		return sysRoleDao.queryRoleIdList(createUserId);
	}

	/**
	 * 检查是否越权
	 * 
	 * @param role
	 */
	private void checkPrems(SysRoleEntity role) {
		// 如果不是超级管理员，则需要判断角色的权限是否超过自己的权限
		if (role.getCreateUserId() == Constant.SUPER_ADMIN) {
			return;
		}

		// 查询用户所拥有的菜单列表
		List<Long> menuIdList = sysUserService.queryAllMenuId(role.getCreateUserId());

		//判断是否越权
		if (!menuIdList.containsAll(role.getMenuIdList())) {
			throw new RRException("新增角色的权限，超出你的权限范围");
		}
	}

}

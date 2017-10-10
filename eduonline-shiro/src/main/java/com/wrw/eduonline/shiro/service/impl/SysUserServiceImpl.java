package com.wrw.eduonline.shiro.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wrw.eduonline.common.utils.Constant;
import com.wrw.eduonline.common.utils.RRException;
import com.wrw.eduonline.shiro.dao.SysUserDao;
import com.wrw.eduonline.shiro.entity.SysUserEntity;
import com.wrw.eduonline.shiro.service.SysRoleService;
import com.wrw.eduonline.shiro.service.SysUserRoleService;
import com.wrw.eduonline.shiro.service.SysUserService;

/**
 * 
 * 项目名称：eduonline-shiro 类名称：SysUserServiceImpl 类描述： SysUserService实现类 创建人：wrw
 * 创建时间：2017年9月16日 下午12:48:10
 * 
 * @version
 */

@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysUserRoleService sysUserRoleService;

	@Override
	public List<String> queryAllPerms(Long userId) {
		return sysUserDao.queryAllPerms(userId);
	}

	@Override
	public List<Long> queryAllMenuId(Long userId) {
		return sysUserDao.queryAllMenuId(userId);
	}

	@Override
	public SysUserEntity queryByUserName(String userName) {
		return sysUserDao.queryByUserName(userName);
	}

	@Override
	public SysUserEntity queryObject(Long userId) {
		return sysUserDao.queryObject(userId);
	}

	@Override
	public List<SysUserEntity> queryList(Map<String, Object> map) {
		return sysUserDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return sysUserDao.queryTotal(map);
	}

	@Override
	@Transactional
	public void save(SysUserEntity user) {
		user.setCreateTime(new Date());
		user.setModifiedTime(new Date());
		
		//sha256加密
		String pwd = new Sha256Hash(user.getPassword()).toHex();
		user.setPassword(pwd);
		sysUserDao.save(user);
		
		//检查角色是否越权
		checkRole(user);
		
		//保存用户与角色关系
		sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
	}

	@Override
	@Transactional
	public void update(SysUserEntity user) {
		if (StringUtils.isBlank(user.getPassword())) {
			user.setPassword(null);
		} else {
			String pwd = new Sha256Hash(user.getPassword()).toHex();
			user.setPassword(pwd);
		}
		
		sysUserDao.update(user);
		
		//检查角色是否越权
		checkRole(user);
				
		//保存用户与角色关系
		sysUserRoleService.saveOrUpdate(user.getUserId(), user.getRoleIdList());
	}

	@Override
	public void deleteBatch(Long[] userIds) {
		sysUserDao.deleteBatch(userIds);
	}

	@Override
	public int updatePassword(Long userId, String password, String newPassword) {
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("password", password);
		map.put("newPassword", newPassword);
		map.put("modified_time", new Date());
		return sysUserDao.updatePassword(map);
	}

	/**
	 * 检查角色是否越权
	 * @param user
	 */
	private void checkRole(SysUserEntity user) {
		//如果不是超级管理员，则需要判断用户的角色是否自己创建
		if (user.getCreateUserId() == Constant.SUPER_ADMIN) {
			return ;
		}
		
		//查询用户创建的角色列表
		List<Long> roleIdList = sysRoleService.queryRoleIdList(user.getCreateUserId());
		
		//判断是否越权
		if (!roleIdList.containsAll(user.getRoleIdList())) {
			throw new RRException("新增用户所选角色，不是本人创建");
		}
	}

	
}

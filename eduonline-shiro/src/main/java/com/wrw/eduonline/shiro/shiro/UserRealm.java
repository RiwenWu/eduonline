package com.wrw.eduonline.shiro.shiro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.wrw.eduonline.common.utils.Constant;
import com.wrw.eduonline.shiro.dao.SysMenuDao;
import com.wrw.eduonline.shiro.dao.SysUserDao;
import com.wrw.eduonline.shiro.entity.SysMenuEntity;
import com.wrw.eduonline.shiro.entity.SysUserEntity;

/**   
 *    
 * 项目名称：eduonline-shiro   
 * 类名称：UserRealm   
 * 类描述：登陆认证
 * 创建人：wrw   
 * 创建时间：2017年10月8日 下午9:12:07   
 * @version        
 */
public class UserRealm extends AuthorizingRealm{

	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysMenuDao sysMenuDao;
	
	/**
	 * 授权(验证权限时调用)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SysUserEntity user = (SysUserEntity)principals.getPrimaryPrincipal();
		Long userId = user.getUserId();
		
		List<String> permsList = null;
		
		//超级管理员拥有最高权限
		if (userId == Constant.SUPER_ADMIN) {
			List<SysMenuEntity> menuList = sysMenuDao.queryList(new HashMap<String, Object>());
			permsList = new ArrayList<>(menuList.size());
			for(SysMenuEntity menu : menuList) {
				permsList.add(menu.getPerms());
			}
		}else {
			permsList = sysUserDao.queryAllPerms(userId);
		}
		
		//用户权限列表
		Set<String> permsSet = new HashSet<String>();
		for(String perms : permsList) {
			if (StringUtils.isBlank(perms)) {
				continue;
			}
			permsSet.addAll(Arrays.asList(perms.trim().split(",")));
		}

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setStringPermissions(permsSet);
		return info;
	}

	/**
	 * 认证(登陆时调用)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());
		
		//查询用户信息
		SysUserEntity user = sysUserDao.queryByUserName(username);
		
		//账号不存在
		if (user == null) {
			throw new UnknownAccountException("账号不存在不正确");
		}
		//密码错误
		if (!password.equals(user.getPassword())) {
			throw new IncorrectCredentialsException("账号或密码错正确");
		}
		//账号被禁用
		if (user.getStatus() == 0) {
			throw new LockedAccountException("账号被禁用，请联系管理员");
		}
		
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
		return info;
	}

}

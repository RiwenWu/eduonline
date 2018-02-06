package com.eduonline.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.eduonline.model.User;
import com.eduonline.service.UserService;


public class UserRealm extends AuthorizingRealm{

	@Autowired
	private UserService userService;

	/**
	 * 认证(登陆时调用)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String username = token.getUsername();
		String password = new String((char[]) token.getPassword());
		
		//查询用户信息
		User user = userService.selsectByAccount(username);
		
		//账号不存在
		if (user == null) {
			throw new UnknownAccountException("账号不存在");
		}
		//密码错误
		if (!password.equals(user.getPassword())) {
			throw new IncorrectCredentialsException("账号或密码不正确");
		}
		
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
		return info;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

}

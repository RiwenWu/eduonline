package com.eduonline.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eduonline.model.User;
import com.eduonline.service.UserService;


/**   
 *    
 * 项目名称：eduonline-app   
 * 类名称：UserController   
 * 类描述：   
 * 创建人：wrw   
 * 创建时间：2018年3月5日 上午2:43:51   
 * @version        
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 正则表达式：验证手机号
	 */
	public static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
	
	/**
	 * 用户注册
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("regist.json")
	private Map<String, Object> registUesr(HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("bool", false);
		
		try {
			if (user.getAccount() == null || user.getAccount().isEmpty()) {//判断号码输入是否为空
				map.put("message", "手机号码不能为空");
				return map;
			} else if (!Pattern.matches(REGEX_MOBILE, user.getAccount())) {//判断号码是否正确
				map.put("message", "手机号码输入错误");
				return map;
			} else if (userService.selsectByAccount(user.getAccount()) != null) {
				map.put("message", "号码已被注册");
				return map;
			}
			userService.insertSelective(user);
			map.put("bool", true);
		} catch(Exception e) {
			e.printStackTrace();
			map.put("message", "看后台报什么错吧");
		}
		return map;
	}
	
	/**
	 * 登陆
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("login.json")
	private Map<String, Object> loginUser(HttpServletRequest request, HttpServletResponse response, User user) {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("bool", false);
		
		// 创建一个Subject实例，该实例认证要使用上边创建的securityManager进行
		Subject subject = SecurityUtils.getSubject();

		// 创建token令牌，记录用户认证的身份和凭证即账号和密码
		UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(), user.getPassword());
		
		try {
			subject.login(token);
			map.put("bool", true);
			map.put("User", userService.selsectByAccount(user.getAccount()));
		} catch (UnknownAccountException e) {
			map.put("message", e.getMessage());
		} catch (IncorrectCredentialsException e) {
			map.put("message", e.getMessage());
		} catch(Exception e) {
			e.printStackTrace();
			map.put("message", "看后台报什么错吧");
		}
		return map;
	}
}

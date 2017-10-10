package com.wrw.eduonline.shiro.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.wrw.eduonline.shiro.entity.SysUserEntity;

/**   
 *    
 * 项目名称：eduonline-shiro   
 * 类名称：ShiroUtils   
 * 类描述：shiro工具类   
 * 创建人：wrw   
 * 创建时间：2017年9月18日 下午8:43:24   
 * @version        
 */
public class ShiroUtils {

	public static Session getSession() {
		return SecurityUtils.getSubject().getSession();
	}
	
	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}
	
	public static SysUserEntity getUserEntity() {
		return (SysUserEntity)SecurityUtils.getSubject().getPrincipal();
	}
	
	public static Long getUserId() {
		return getUserEntity().getUserId();
	}
	
	public static void setSessionAttribute(Object key, Object value) {
		getSession().setAttribute(key, value);
	}
	
	public static Object getSessionAttribute(Object key) {
		return getSession().getAttribute(key);
	}
	
	public static boolean isLogin() {
		return SecurityUtils.getSubject().getPrincipal() != null;
	}
	
	public static void logout() {
		SecurityUtils.getSubject().logout();
	}
	
	public static String getKaptcha(String key) {
		String kaptche = getSessionAttribute(key).toString();
		getSession().removeAttribute(key);
		return kaptche;
	}
}

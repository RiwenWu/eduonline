package com.wrw.eduonline.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**   
 *    
 * 项目名称：eduonline-shiro   
 * 类名称：VelocityShiro   
 * 类描述：shiro权限标签(Velocity版)
 * 创建人：wrw   
 * 创建时间：2017年10月10日 上午10:12:31   
 * @version        
 */
public class VelocityShiro {

	/**
	 * 是否拥有该权限
	 * @param permission
	 * @return
	 */
	public boolean hasPermission(String permission) {
		Subject subject = SecurityUtils.getSubject();
		return subject != null && subject.isPermitted(permission);
	}
}

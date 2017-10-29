package com.wrw.eduonline.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**   
 *    
 * 项目名称：eduonline-shiro   
 * 类名称：ShiroTag   
 * 类描述： Shiro权限标签
 * 创建人：wrw   
 * 创建时间：2017年10月25日 下午6:25:57   
 * @version        
 */
public class ShiroTag {

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

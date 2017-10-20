package com.wrw.eduonline.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wrw.eduonline.entity.SysUserEntity;
import com.wrw.eduonline.utils.ShiroUtils;

/**   
 *    
 * 项目名称：eduonline-shiro   
 * 类名称：AbstractController   
 * 类描述：Controller公共组件   
 * 创建人：wrw   
 * 创建时间：2017年9月19日 上午12:10:14   
 * @version        
 */
public abstract class AbstractController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected SysUserEntity getUser() {
		return ShiroUtils.getUserEntity();
	}
	
	protected Long getUserId() {
		return getUser().getUserId();
	}
}

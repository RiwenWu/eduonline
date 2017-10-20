package com.wrw.eduonline.validator;

import org.apache.commons.lang.StringUtils;

import com.wrw.eduonline.utils.RRException;

/**
 * 
 *    
 * 项目名称：eduonline-common   
 * 类名称：Assert   
 * 类描述：数据校验
 * 创建人：wrw   
 * 创建时间：2017年9月27日 上午11:21:50   
 * @version
 */
public abstract class Assert {
	
	public static void isBlank(String str, String message) {
		if(StringUtils.isBlank(str)) {
			throw new RRException(message);
		}
	}
	
	public static void isNull(Object object, String message) {
		if (object == null ) {
			throw new RRException(message);
		}
	}
}

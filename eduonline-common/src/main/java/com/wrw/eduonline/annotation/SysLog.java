package com.wrw.eduonline.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**   
 *    
 * 项目名称：eduonline-common   
 * 类名称：SysLog   
 * 类描述：系统日志注释
 * 创建人：wrw   
 * 创建时间：2017年9月27日 上午11:13:04   
 * @version        
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
	
	String value() default "";
}

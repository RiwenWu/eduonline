package com.wrw.eduonline.common.utils;

import java.util.HashMap;
import java.util.Map;

/**   
 *    
 * 项目名称：eduonline-common   
 * 类名称：R   
 * 类描述：返回数据   
 * 创建人：wrw   
 * 创建时间：2017年9月18日 下午9:38:58   
 * @version        
 */
public class R extends HashMap<String, Object> {
	
	private static final long serialVersionUID = 1L;
	
	public R() {
		put("code", 0);
	}
	
	public static R error() {
		return error(500, "未知异常，请找管理员");
	}
	
	public static R error(String msg) {
		return error(500, msg);
	}
	
	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}
	
	public static R ok(String msg ) {
		R r = new R();
		r.put("msg", msg);
		return r;
	}
	
	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}
	
	public static R ok() {
		return new R();
	}
	
	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}

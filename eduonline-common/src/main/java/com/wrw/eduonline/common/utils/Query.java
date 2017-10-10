package com.wrw.eduonline.common.utils;

import java.util.LinkedHashMap;
import java.util.Map;


/**   
 *    
 * 项目名称：eduonline-common   
 * 类名称：Query   
 * 类描述：跳转页数，查询参数类
 * 创建人：wrw   
 * 创建时间：2017年9月27日 上午10:43:34   
 * @version        
 */
public class Query extends LinkedHashMap<String, Object> {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 当前页码
	 */
	private int page;
	
	/**
	 * 每页条数
	 */
	private int limit;
	
	public Query(Map<String, Object> params) {
		this.putAll(params);
		
		//分页参数
		this.page = Integer.parseInt(params.get("page").toString());
		this.limit = Integer.parseInt(params.get("limit").toString());
		this.put("offset", (page - 1) * limit);
		this.put("page", page);
		this.put("limit", limit);
		
		//防止SQL注入（因为sidx.order是通过拼接sql实现排序的，会有sql注入风险）
		String sidx = params.get("sidx").toString();
		String order = params.get("order").toString();
		this.put("offset", (page - 1) * limit);
		this.put("page", page);
		this.put("limit", limit);
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	
}

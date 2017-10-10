package com.wrw.eduonline.common.utils;

import java.io.Serializable;
import java.util.List;

/**   
 *    
 * 项目名称：eduonline-common   
 * 类名称：PageUtils   
 * 类描述： 分页工具类
 * 创建人：wrw   
 * 创建时间：2017年9月27日 上午10:23:07   
 * @version        
 */
public class PageUtils implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 总数
	 */
	private int totalCount;
	
	/**
	 * 每页显示多少
	 */
	private int pageSize;
	
	/**
	 * 总共多少也
	 */
	private int totalPage;
	
	/**
	 * 当前第几页
	 */
	private int currPage;
	
	/**
	 * 列表数据
	 */
	private List<?> list;
	
	/**
	 * 
	 * @param list
	 * @param totalCount
	 * @param pageSize
	 * @param currPage
	 */
	public PageUtils(List<?> list, int totalCount, int pageSize, int currPage) {
		this.list = list;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.currPage = currPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}
	
}

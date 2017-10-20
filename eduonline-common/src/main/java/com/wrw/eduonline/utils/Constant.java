package com.wrw.eduonline.utils;


/**   
 *    
 * 项目名称：eduonline-common   
 * 类名称：Constant   
 * 类描述：   常量
 * 创建人：wrw   
 * 创建时间：2017年9月16日 下午2:01:04   
 * @version        
 */
public class Constant {

	/**
	 * 超级管理员ID
	 */
	public static final int SUPER_ADMIN = 1;
	
	/**
	 * 
	 *    
	 * 项目名称：eduonline-common   
	 * 类名称：MenuType   
	 * 类描述：   菜单描述
	 * 创建人：wrw   
	 * 创建时间：2017年9月16日 下午8:11:32   
	 * @version
	 */
	public enum MenuType {
		/**
		 * 目录
		 */
		CATALOG(0),
		/**
		 * 菜单
		 */
		MENU(1),
		/**
		 * 按钮
		 */
		BUTTON(2);
		
		private int value;
		
		private MenuType(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
	}
}

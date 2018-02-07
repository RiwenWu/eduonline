package com.wrw.eduonline.shiro.verifyForm;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wrw.eduonline.entity.SysMenuEntity;
import com.wrw.eduonline.service.SysMenuService;
import com.wrw.eduonline.utils.Constant.MenuType;
import com.wrw.eduonline.utils.RRException;

/**
 * 
 *    
 * 项目名称：eduonline-shiro   
 * 类名称：test   
 * 类描述：   
 * 创建人：wrw   
 * 创建时间：2017年11月12日 下午5:55:20   
 * @version
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-applicationContext.xml")
@Rollback
public class test {

	@Resource
	private SysMenuService sysMenuService;
	
	/**
	 * 验证参数是否正确
	 */
	private void verifyForm(SysMenuEntity menu) {
		if (StringUtils.isBlank(menu.getName())) {
			throw new RRException("菜单名称不能为空");
		}
		
		if (menu.getParentId() == null) {
			throw new RRException("上级菜单不能为空");
		}
		
		//菜单
		if (menu.getType() == MenuType.MENU.getValue()) {
			if (StringUtils.isBlank(menu.getUrl())) {
				throw new RRException("菜单URL不能为空");
			}
		}
		
		//上级菜单类型
		int parentType = MenuType.CATALOG.getValue();
		if (menu.getParentId() != 0) {
			SysMenuEntity parentMenu = sysMenuService.queryObject(menu.getMenuId());
			System.out.println(parentMenu == null);
			parentType = parentMenu.getType();
		}
		
		//目录，菜单
		if (menu.getType() == MenuType.CATALOG.getValue() ||
				menu.getType() == MenuType.MENU.getValue()) {
			if (parentType != MenuType.CATALOG.getValue()) {
				throw new RRException("上级菜单只能为目录类型");
			}
			return;
		}
		
		//按钮
		if (menu.getType() == MenuType.BUTTON.getValue()) {
			if (parentType != MenuType.MENU.getValue()) {
				throw new RRException("上级菜单只能为菜单类型");
			}
			return;
		}
	}
	
	@Test
	public void verifyFormTest() {
		SysMenuEntity menu = new SysMenuEntity();
		menu.setParentId(31L);
		menu.setName("视频列表");
		menu.setUrl("video/videoList.flt");
		menu.setType(1);
		menu.setIcon("fa fa-file-video-o");
		menu.setOrderNum(2);
		verifyForm(menu);
	}

}

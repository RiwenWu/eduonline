package com.wrw.eduonline.shiro.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wrw.eduonlin.service.SysMenuService;
import com.wrw.eduonline.entity.SysMenuEntity;

/**   
 *    
 * 项目名称：eduonline-shiro   
 * 类名称：SysMenuServiceTest   
 * 类描述： SysMenuService测试类  
 * 创建人：wrw   
 * 创建时间：2017年9月18日 上午1:43:16   
 * @version        
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-applicationContext.xml")
@Rollback
public class SysMenuServiceTest {

	@Resource
	private SysMenuService sysMenuService;
	
	/**
	 * 根据父菜单，查询子菜单
	 */
	@Test
	public void queryListParentIdTest() {
		List<SysMenuEntity> menuList = new ArrayList<SysMenuEntity>();
		List<Long> menuIds = new ArrayList<Long>();
		menuIds.add((long)2);
		menuIds.add((long)3);
		menuIds.add((long)4);
		menuList = sysMenuService.queryListParentId((long)1, menuIds);
		for (SysMenuEntity menu : menuList) {
			System.out.println(menu.toString());
		}
	}
	
	/**
	 * 获取不包含按钮的菜单列表
	 */
	@Test
	public void queryNotButtonListTest() {
		List<SysMenuEntity> menuList = new ArrayList<SysMenuEntity>();
		menuList = sysMenuService.queryNotButtonList();
		for (SysMenuEntity menu : menuList) {
			System.out.println(menu);
		}
	}

	/**
	 * 获取用户菜单列表
	 */
	@Test
	public void getUserMenuListTest() {
		List<SysMenuEntity> menus = new ArrayList<SysMenuEntity>();
		menus = sysMenuService.getUserMenuList((long)1);
		for (SysMenuEntity menu : menus) {
			System.out.println(menu.toString());
		}
	}
	
	/**
	 * 查询菜单
	 */
	@Test
	public void queryObjectTest() {
		SysMenuEntity menu = new SysMenuEntity();
		menu = sysMenuService.queryObject((long)3);
		System.out.println(menu.toString());
	}
	
	/**
	 * 查询菜单列表
	 */
	@Test
	public void queryListTest() {
		Map<String, Object> menuMap = new HashMap<String, Object>();
		menuMap.put("parentId", (long)1);
		List<SysMenuEntity> menuList = new ArrayList<SysMenuEntity>();
		menuList = sysMenuService.queryList(menuMap);
		for (SysMenuEntity menu : menuList) {
			System.out.println(menu.toString());
		}
		System.out.println(menuList.size());
	}
	
	/**
	 * 查询菜单列表
	 */
	@Test
	public void queryListTest1() {
		List<SysMenuEntity> menuList = new ArrayList<SysMenuEntity>();
		menuList = sysMenuService.queryList(new HashMap<String, Object>());
		for (SysMenuEntity menu : menuList) {
			System.out.println(menu.toString());
		}
		System.out.println(menuList.size());
	}
	
	/**
	 * 查询总数
	 */
	@Test
	public void queryTotalTest() {
		Map<String, Object> menuMap = new HashMap<String, Object>();
		menuMap.put("parent_id", (long)1);
		int total = sysMenuService.queryTotal(menuMap);
		System.out.println(total);
	}
	
	/**
	 * 保存菜单
	 */
	@Test
	public void saveTest() {
		SysMenuEntity menu = new SysMenuEntity();
		menu.setParentId((long)0);
		menu.setName("视频管理");
		sysMenuService.save(menu);
	}
	
	/**
	 * 修改菜单
	 */
	@Test
	public void updateTest() {
		SysMenuEntity menu = new SysMenuEntity();
		menu.setMenuId((long)31);
		menu.setName("准备被删除");
		sysMenuService.update(menu);
	}
	
	/**
	 * 删除
	 */
	@Test
	public void deleteBatchTest() {
		Long[] menuIds = {(long)31};
		sysMenuService.deleteBatch(menuIds);
	}
	
	/**
	 * 查询用户的权限列表
	 */
	@Test
	public void queryUserListTest() {
		List<SysMenuEntity> menuList = new ArrayList<SysMenuEntity>();
		menuList = sysMenuService.queryUserList((long)1);
		System.out.println(menuList.size());
	}
}

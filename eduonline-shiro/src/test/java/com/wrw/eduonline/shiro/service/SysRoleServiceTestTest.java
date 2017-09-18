package com.wrw.eduonline.shiro.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wrw.eduonline.shiro.entity.SysRoleEntity;

/**   
 *    
 * 项目名称：eduonline-shiro   
 * 类名称：SysRoleServiceTestTest   
 * 类描述：SysRoleService测试类  
 * 创建人：wrw   
 * 创建时间：2017年9月17日 下午9:06:09   
 * @version        
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-applicationContext.xml")
@Rollback
public class SysRoleServiceTestTest {

	@Resource
	private SysRoleService sysRoleService;
	
	/**
	 * 根据角色Id的，查询角色
	 */
	@Test
	public void queryObject() {
		SysRoleEntity role = new SysRoleEntity();
		role = sysRoleService.queryObject((long)1);
		Assert.assertNotNull(role);
		System.out.println(role.toString());
	}

	/**
	 * 查询角色列表
	 */
	@Test
	public void queryListTest() {
		Map<String, Object> mapList = new HashMap<String, Object>();
		mapList.put("createuserId", (long)1);
		List<SysRoleEntity> role = new ArrayList<>();
		role = sysRoleService.queryList(mapList);
		Assert.assertNotNull(role);
		System.out.println(role.toString());
	}
	
	/**
	 * 查询总数
	 */
	@Test
	public void queryTotalTest() {
		Map<String, Object> mapList = new HashMap<String, Object>();
		mapList.put("createuserId", (long)1);
		int i = sysRoleService.queryTotal(mapList);
		System.out.println(i);
	}
	
	/**
	 * 保存角色
	 */
	@Test
	public void saveTest() {
		SysRoleEntity role = new SysRoleEntity();
		role.setRoleName("普通管理员");
		role.setRemark("等着被删除");
		role.setCreateUserId((long)1);
		List<Long> menuId = new ArrayList<Long>();
		menuId.add((long)1);
		role.setMenuIdList(menuId);
		sysRoleService.save(role);
		
		Map<String, Object> mapList = new HashMap<String, Object>();
		mapList.put("roleName", "普通管理员");
		List<SysRoleEntity> role1 = new ArrayList<>();
		role1 = sysRoleService.queryList(mapList);
		Assert.assertNotNull(role1);
		System.out.println(role1.toString());
	}
	
	/**
	 * 修改角色
	 */
	@Test
	public void updateTest() {
		SysRoleEntity role = new SysRoleEntity();
		role.setRoleId((long)2);
		role.setRemark("快被删除了");
		role.setCreateUserId((long)1);
		role.setCreateUserId((long)1);
		List<Long> menuId = new ArrayList<Long>();
		menuId.add((long)1);
		role.setMenuIdList(menuId);
		sysRoleService.update(role);
	}
	
	/**
	 * 删除角色
	 */
	@Test
	public void deleteBatchTest() {
		Long[] roleIds = {(long) 2};
		sysRoleService.deleteBatch(roleIds);
	}
	
	/**
	 * 查询用户创建的角色ID列表
	 */
	@Test
	public void queryRoleIdListTest() {
		List<Long> roleId = new ArrayList<Long>();
		roleId = sysRoleService.queryRoleIdList((long)1);
		for (Long id : roleId) {
			System.out.println(id);
		}
	}
}

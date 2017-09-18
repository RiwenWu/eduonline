package com.wrw.eduonline.shiro.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wrw.eduonline.shiro.entity.SysUserEntity;

/**   
 *    
 * 项目名称：eduonline-shiro   
 * 类名称：SysUserServiceTest   
 * 类描述：   SysUserServic测试类
 * 创建人：wrw   
 * 创建时间：2017年9月17日 下午9:05:49   
 * @version        
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-applicationContext.xml")
@Rollback
public class SysUserServiceTest {

	@Resource
	private SysUserService sysUserService;

	/**
	 * 用户的权限
	 */
	@Test
	public void queryAllPermsTest() {
		List<String> userList = new ArrayList<String>();
		userList = sysUserService.queryAllPerms((long)1);
		for (String s : userList) {
			System.out.println(s);
		}
	}
	
	/**
	 * 用户的菜单Id
	 */
	@Test
	public void queryAllMenuIdTest() {
		List<Long> userMenu = new ArrayList<Long>();
		userMenu = sysUserService.queryAllMenuId((long)1);
		for (Long L1 : userMenu) {
			System.out.println(L1);
		}
	}
	
	/**
	 * 根据用户名，查询系统用户
	 */
	@Test
	public void queryByUserNameTest() {
		SysUserEntity user = new SysUserEntity();
		user = sysUserService.queryByUserName("admin");
		Assert.assertNotNull(user);
		System.out.println(user.toString());
	}
	
	/**
	 * 根据用户Id，查询用户
	 */
	@Test
	public void queryObjectTest() {
		SysUserEntity user = new SysUserEntity();
		user = sysUserService.queryObject((long)2);
		Assert.assertNotNull(user);
		System.out.println(user.toString());
	}
	
	/**
	 * 查询用户列表
	 */
	@Test
	public void queryListTest() {
		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("status", 1);
		List<SysUserEntity> userList = new ArrayList<SysUserEntity>();
		userList = sysUserService.queryList(userMap);
		Assert.assertNotNull(userList);
		for (SysUserEntity user : userList) {
			System.out.println(user.toString());
		}
	}
	
	/**
	 * 查询总数
	 */
	@Test
	public void queryTotalTest() {
		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("status", 1);
		int total = sysUserService.queryTotal(userMap);
		Assert.assertNotNull(total);
		System.out.println(total);
	}
	
	/**
	 * 保存用户
	 */
	@Test
	public void saveTest() {
		SysUserEntity user = new SysUserEntity();
		user.setUsername("test1");
		user.setPassword("123456");
		user.setEmail("wrw@email.com");
		user.setMobile("15622283782");
		user.setCreateUserId((long)1);
		List<Long> roleList = new ArrayList<Long>();
		roleList.add((long)1);
		user.setRoleIdList(roleList);
		sysUserService.save(user);
		
		SysUserEntity user1 = new SysUserEntity();
		user1 = sysUserService.queryByUserName("test1");
		Assert.assertNotNull(user1);
		System.out.println(user1.toString());
	}
	
	/**
	 * 修改用户
	 */
	@Test
	public void updateTest() {
		SysUserEntity user = new SysUserEntity();
		user.setUserId((long)17);
		user.setEmail("test1@email.com");
		user.setCreateUserId((long)1);
		List<Long> roleList = new ArrayList<Long>();
		roleList.add((long)1);
		user.setRoleIdList(roleList);
		sysUserService.update(user);
		
		SysUserEntity user1 = new SysUserEntity();
		user1 = sysUserService.queryObject((long)17);
		Assert.assertNotNull(user1);
		System.out.println(user1.toString());
	}
	
	/**
	 * 删除用户
	 */
	@Test
	public void deleteBatchTest() {
		Long[] ids = {(long) 17}; 
		sysUserService.deleteBatch(ids);
	}
	
}

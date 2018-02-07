package com.wrw.eduonline.shiro.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wrw.eduonline.service.SysUserRoleService;

/**   
 *    
 * 项目名称：eduonline-shiro   
 * 类名称：SysUserRoleServiceTest   
 * 类描述：SysUserRoleService测试类   
 * 创建人：wrw   
 * 创建时间：2017年9月18日 上午1:28:23   
 * @version        
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-applicationContext.xml")
@Rollback
public class SysUserRoleServiceTest {

	@Resource
	private SysUserRoleService sysUserRoleService;
	
	/**
	 * 根据用户ID，获取角色ID列表
	 */
	@Test
	public void queryRoleIdListTest() {
		List<Long> roleIds = new ArrayList<Long>();
		roleIds = sysUserRoleService.queryRoleIdList((long)1);
		for (Long roleId : roleIds) {
			System.out.println(roleId);
		}
	}

}

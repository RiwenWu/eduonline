package com.wrw.eduonline.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wrw.eduonlin.service.SysRoleMenuService;
import com.wrw.eduonlin.service.SysRoleService;
import com.wrw.eduonline.annotation.SysLog;
import com.wrw.eduonline.entity.SysRoleEntity;
import com.wrw.eduonline.utils.Constant;
import com.wrw.eduonline.utils.PageUtils;
import com.wrw.eduonline.utils.Query;
import com.wrw.eduonline.utils.R;
import com.wrw.eduonline.validator.ValidatorUtils;

/**   
 *    
 * 项目名称：eduonline-shiro   
 * 类名称：SysRoleController   
 * 类描述：系统角色管理
 * 创建人：wrw   
 * 创建时间：2017年9月30日 下午7:21:04   
 * @version        
 */

@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends AbstractController{

	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysRoleMenuService sysRoleMenuService;
	
	/**
	 * 角色列表
	 */
	@RequestMapping("list")
	@RequiresPermissions("sys:role:list")
	public R list(@RequestParam Map<String, Object> params) {
		//如果不是超级管理员，则只查看自己创建的角色列表
		if (getUserId() != Constant.SUPER_ADMIN) {
			params.put("createUserId", getUserId());
		}
		
		//查询列表数据
		Query query = new Query(params);
		List<SysRoleEntity> list = sysRoleService.queryList(query);
		int total = sysRoleService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(list, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	@RequestMapping("/select")
	@RequiresPermissions("sys:role:select")
	public R select() {
		Map<String, Object> map = new HashMap<>();
		
		//如果不是超级管理员，则只查询自己所拥有的角色列表
		if (getUserId() != Constant.SUPER_ADMIN) {
			map.put("createUserId", getUserId());
		}
		List<SysRoleEntity> list = sysRoleService.queryList(map);
		
		return R.ok().put("list", list);
	}
	
	/**
	 * 角色信息
	 */
	@RequestMapping("/info/{roleId}")
	@RequiresPermissions("sys:role:info")
	public R info(@PathVariable("roleId") Long roleId) {
		SysRoleEntity role = sysRoleService.queryObject(roleId);
		
		//查询角色对应的菜单
		List<Long> menuIdList = sysRoleMenuService.queryMenuIdList(roleId);
		role.setMenuIdList(menuIdList);
		
		return R.ok().put("role", role);
	}
	
	/**
	 * 保存角色
	 */
	@SysLog("保存角色")
	@RequestMapping("/save")
	@RequiresPermissions("sys:role:save")
	public R save(@RequestBody SysRoleEntity role) {
		ValidatorUtils.validateEntity(role);
		
		role.setCreateUserId(getUserId());
		role.setCreateTime(new Date());
		sysRoleService.save(role);
		
		return R.ok();
	}
	
	/**
	 * 修改角色
	 */
	@SysLog("修改角色")
	@RequestMapping("/update")
	@RequiresPermissions("sys:role:update")
	public R update(@RequestBody SysRoleEntity role) {
		ValidatorUtils.validateEntity(role);
		
		role.setCreateUserId(getUserId());
		role.setModifiedTime(new Date());
		sysRoleService.update(role);
		
		return R.ok();
	}
	
	/**
	 * 删除角色
	 */
	@SysLog("删除角色")
	@RequestMapping("/delete")
	@RequiresPermissions("sys:role:delete")
	public R delete(@RequestBody Long[] roleIds) {
		
		sysRoleService.deleteBatch(roleIds);
		
		return R.ok();
	}
}

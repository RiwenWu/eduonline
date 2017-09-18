package com.wrw.eduonline.shiro.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wrw.eduonline.common.utils.Constant;
import com.wrw.eduonline.common.utils.Constant.MenuType;
import com.wrw.eduonline.shiro.dao.SysMenuDao;
import com.wrw.eduonline.shiro.entity.SysMenuEntity;
import com.wrw.eduonline.shiro.service.SysMenuService;
import com.wrw.eduonline.shiro.service.SysRoleMenuService;
import com.wrw.eduonline.shiro.service.SysUserService;


/**   
 *    
 * 项目名称：eduonline-shiro   
 * 类名称：SysMenuServiceImpl   
 * 类描述： SysMenuService实现类
 * 创建人：wrw   
 * 创建时间：2017年9月16日 下午7:37:59   
 * @version        
 */

@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService{
	
	@Autowired
	private SysMenuDao sysMenuDao;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysRoleMenuService sysRoleMenuService;

	@Override
	public List<SysMenuEntity> queryListParentId(Long parentId, List<Long> menuIdList) {
		List<SysMenuEntity> menuList = sysMenuDao.queryListParentId(parentId);
		if (menuIdList == null) {
			return menuList;
		}
		
		List<SysMenuEntity> userMenuList = new ArrayList<>();
		for (SysMenuEntity menu : menuList) {
			if (menuIdList.contains(menu.getMenuId())) {
				userMenuList.add(menu);
			}
		}
		return userMenuList;
	}

	@Override
	public List<SysMenuEntity> queryNotButtonList() {
		return sysMenuDao.queryNotButtonList();
	}

	@Override
	public List<SysMenuEntity> getUserMenuList(Long userId) {
		//系统管理员，拥有最高权限
		if (userId == Constant.SUPER_ADMIN) {
			return getAllMenuList(null);
		}
		
		//用户菜单列表
		List<Long> menuIdList = sysUserService.queryAllMenuId(userId);
		return getAllMenuList(menuIdList);
	}

	@Override
	public SysMenuEntity queryObject(Long menuId) {
		return sysMenuDao.queryObject(menuId);
	}

	@Override
	public List<SysMenuEntity> queryList(Map<String, Object> map) {
		return sysMenuDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return sysMenuDao.queryTotal(map);
	}

	@Override
	public void save(SysMenuEntity menu) {
		menu.setCreateTime(new Date());
		menu.setModifiedTime(new Date());
		sysMenuDao.save(menu);
	}

	@Override
	public void update(SysMenuEntity menu) {
		menu.setModifiedTime(new Date());
		sysMenuDao.update(menu);
	}

	@Override
	@Transactional
	public void deleteBatch(Long[] menuIds) {
		sysMenuDao.deleteBatch(menuIds);
	}

	@Override
	public List<SysMenuEntity> queryUserList(Long userId) {
		return sysMenuDao.queryUserList(userId);
	}

	/**
	 * 获取所有菜单列表
	 * @param menuIdList
	 * @return
	 */
	private List<SysMenuEntity> getAllMenuList(List<Long> menuIdList) {
		//查询根菜单列表
		List<SysMenuEntity> menuList = queryListParentId(0L, menuIdList);
		//递归获取子菜单
		getMenuTreeList(menuList, menuIdList);
		
		return menuList;
	}

	/**
	 * 递归
	 * @param menuList
	 * @param menuIdList
	 */
	private List<SysMenuEntity> getMenuTreeList(List<SysMenuEntity> menuList, List<Long> menuIdList) {
		List<SysMenuEntity> subMenuList = new ArrayList<SysMenuEntity>();
		
		for (SysMenuEntity entity : menuList) {
			if (entity.getType() == MenuType.CATALOG.getValue()) {//目录
				entity.setList(getMenuTreeList(queryListParentId(entity.getMenuId(), menuIdList), menuIdList));
			}
			subMenuList.add(entity);
		}
		
		return subMenuList;
	}
}

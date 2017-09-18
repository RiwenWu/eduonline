package com.wrw.eduonline.shiro.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrw.eduonline.shiro.dao.SysRoleMenuDao;
import com.wrw.eduonline.shiro.service.SysRoleMenuService;


/**   
 *    
 * 项目名称：eduonline-shiro   
 * 类名称：SysRoleMenuServiceImpl   
 * 类描述： SysRoleMenuService实现类
 * 创建人：wrw   
 * 创建时间：2017年9月16日 下午8:33:28   
 * @version        
 */

@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl implements SysRoleMenuService{

	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	
	@Override
	public void saveOrUpdate(Long roleId, List<Long> menuIdList) {
		if (menuIdList.size() == 0 ) {
			return ;
		}
		//先删除角色与菜单关系
		sysRoleMenuDao.delete(roleId);
		
		//保存角色与菜单关系
		Map<String, Object> map = new HashMap<>();
		map.put("roleId", roleId);
		map.put("menuIdList", menuIdList);
		sysRoleMenuDao.save(map);
	}

	@Override
	public List<Long> queryMenuIdList(Long roleId) {
		return sysRoleMenuDao.queryMenuIdList(roleId);
	}

}

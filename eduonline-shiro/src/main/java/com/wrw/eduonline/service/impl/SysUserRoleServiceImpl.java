package com.wrw.eduonline.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrw.eduonline.dao.SysUserRoleDao;
import com.wrw.eduonline.service.SysUserRoleService;


/**   
 *    
 * 项目名称：eduonline-shiro   
 * 类名称：SysUserRoleServiceImpl   
 * 类描述：   SysUserRoleService实现类
 * 创建人：wrw   
 * 创建时间：2017年9月16日 下午4:15:19   
 * @version        
 */

@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {

	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	
	@Override
	public void saveOrUpdate(Long userId, List<Long> roleIdList) {
		if (roleIdList.size() == 0) {
			return ;
		}
		
		//先删除用户与角色关系
		sysUserRoleDao.delete(userId);
		
		//保存用户与角色关系
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("roleIdList", roleIdList);
		sysUserRoleDao.save(map);
	}

	@Override
	public void delete(Long userId) {
		sysUserRoleDao.delete(userId);
	}

	@Override
	public List<Long> queryRoleIdList(Long userId) {
		return sysUserRoleDao.queryRoleIdList(userId);
	}

}

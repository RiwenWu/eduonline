package com.wrw.eduonline.shiro.entity;

import java.io.Serializable;


/**   
 *    
 * 项目名称：eduonline-shiro   
 * 类名称：SysUserRoleEntity   
 * 类描述：   
 * 创建人：wrw   
 * 创建时间：2017年9月15日 上午12:55:05   
 * @version        
 */
public class SysUserRoleEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
    private Long id;

    /**
	 * 用户ID
	 */
    private Long userId;

    /**
	 * 角色ID
	 */
    private Long roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
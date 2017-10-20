package com.wrw.eduonline.entity;

import java.io.Serializable;

/**   
 *    
 * 项目名称：eduonline-shiro   
 * 类名称：SysRoleMenuEntity   
 * 类描述：   Menu实体类
 * 创建人：wrw   
 * 创建时间：2017年9月15日 下午9:34:57   
 * @version        
 */
public class SysRoleMenuEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private Long id;
    
	/**
	 * 角色ID
	 */
    private Long roleId;
    
    /**
	 * 菜单ID
	 */
    private Long menuId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}
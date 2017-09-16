package com.wrw.eduonline.shiro.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;


/**   
 *    
 * 项目名称：eduonline-shiro   
 * 类名称：SysRoleEntity   
 * 类描述：   
 * 创建人：wrw   
 * 创建时间：2017年9月15日 上午12:35:01   
 * @version        
 */
public class SysRoleEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 角色ID
	 */
    private Long roleId;

    /**
	 * 角色名称
	 */
    @NotBlank(message="角色名称不能为空")
    private String roleName;

    /**
	 * 备注
	 */
    private String remark;

    /**
	 * 创建者ID
	 */
    private Long createUserId;

    /**
     * 菜单列表Id
     */
    private List<Long> menuIdList;
    
    /**
	 * 创建时间
	 */
    private Date createTime;

    /**
	 * 修改时间
	 */
    private Date modifiedTime;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

	public List<Long> getMenuIdList() {
		return menuIdList;
	}

	public void setMenuIdList(List<Long> menuIdList) {
		this.menuIdList = menuIdList;
	}
}
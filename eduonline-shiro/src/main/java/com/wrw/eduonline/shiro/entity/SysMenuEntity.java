package com.wrw.eduonline.shiro.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**   
 *    
 * 项目名称：eduonline-shiro   
 * 类名称：SysMenuEntity   
 * 类描述：   
 * 创建人：wrw   
 * 创建时间：2017年9月15日 上午1:03:37   
 * @version        
 */
public class SysMenuEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 菜单ID
	 */
    private Long menuId;

    /**
	 * 父菜单ID，一级菜单为0
	 */
    private Long parentId;

    /**
	 * 父菜单名称
	 */
    private String parentName;
    
    /**
	 * 菜单名称
	 */
    private String name;

    /**
	 * 菜单URL
	 */
    private String url;

    /**
	 * 授权(多个用逗号分隔，如：user:list,user:create)
	 */
    private String perms;

    /**
	 * 类型     0：目录   1：菜单   2：按钮
	 */
    private Integer type;

    /**
	 * 菜单图标
	 */
    private String icon;

    /**
	 * 排序
	 */
    private Integer orderNum;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifiedTime;

    /**
	 * ztree属性
	 */
	private Boolean open;
	
	private List<?> list;
	
    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms == null ? null : perms.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
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

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}
}
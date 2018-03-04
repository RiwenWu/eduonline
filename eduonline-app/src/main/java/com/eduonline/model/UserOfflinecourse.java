package com.eduonline.model;

import java.util.Date;

public class UserOfflinecourse {
    private Long id;

    private Long userId;

    private Long offlinecourseId;

    private Date createTime;

    private Date modifyTime;

    private String state;

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

    public Long getOfflinecourseId() {
        return offlinecourseId;
    }

    public void setOfflinecourseId(Long offlinecourseId) {
        this.offlinecourseId = offlinecourseId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}
package com.eduonline.model;

import java.util.Date;

public class UserOwnCourses {
    private Long id;

    private Long userId;

    private String coursesids;

    private Date createTime;

    private Date modityTime;

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

    public String getCoursesids() {
        return coursesids;
    }

    public void setCoursesids(String coursesids) {
        this.coursesids = coursesids == null ? null : coursesids.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModityTime() {
        return modityTime;
    }

    public void setModityTime(Date modityTime) {
        this.modityTime = modityTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}
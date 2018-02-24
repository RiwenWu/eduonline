package com.eduonline.model;

import java.util.Date;

public class UserJoinPlan {
    private Long id;

    private Long userId;

    private Long courseId;

    private Date createTime;

    private Date modifyTime;

    private Date planfinishTime;

    private String joinState;

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

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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

    public Date getPlanfinishTime() {
        return planfinishTime;
    }

    public void setPlanfinishTime(Date planfinishTime) {
        this.planfinishTime = planfinishTime;
    }

    public String getJoinState() {
        return joinState;
    }

    public void setJoinState(String joinState) {
        this.joinState = joinState == null ? null : joinState.trim();
    }
}
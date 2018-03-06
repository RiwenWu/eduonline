package com.eduonline.model;

import java.util.Date;

public class UserJoinPlan {
    private Long id;

    private Long userId;

    private Long courseId;

    private Date createTime;

    private Date modifyTime;

    private String clocksettingState;

    private String joinState;

    private String clockState;

    private String content;

    private String hour;

    private String miuntes;

    private String daysofweek;

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

    public String getClocksettingState() {
        return clocksettingState;
    }

    public void setClocksettingState(String clocksettingState) {
        this.clocksettingState = clocksettingState == null ? null : clocksettingState.trim();
    }

    public String getJoinState() {
        return joinState;
    }

    public void setJoinState(String joinState) {
        this.joinState = joinState == null ? null : joinState.trim();
    }

    public String getClockState() {
        return clockState;
    }

    public void setClockState(String clockState) {
        this.clockState = clockState == null ? null : clockState.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour == null ? null : hour.trim();
    }

    public String getMiuntes() {
        return miuntes;
    }

    public void setMiuntes(String miuntes) {
        this.miuntes = miuntes == null ? null : miuntes.trim();
    }

    public String getDaysofweek() {
        return daysofweek;
    }

    public void setDaysofweek(String daysofweek) {
        this.daysofweek = daysofweek == null ? null : daysofweek.trim();
    }
}
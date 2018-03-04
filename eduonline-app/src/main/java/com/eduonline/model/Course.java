package com.eduonline.model;

import java.math.BigDecimal;
import java.util.Date;

public class Course {
    private Long id;

    private String name;

    private String introduce;

    private Date createTime;

    private Date modifyTime;

    private String picUrl;

    private String freeState;

    private Long coverId;

    private BigDecimal salary;

    private String commendState;

    private Long offlinecourseId;

    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getFreeState() {
        return freeState;
    }

    public void setFreeState(String freeState) {
        this.freeState = freeState == null ? null : freeState.trim();
    }

    public Long getCoverId() {
        return coverId;
    }

    public void setCoverId(Long coverId) {
        this.coverId = coverId;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getCommendState() {
        return commendState;
    }

    public void setCommendState(String commendState) {
        this.commendState = commendState == null ? null : commendState.trim();
    }

    public Long getOfflinecourseId() {
        return offlinecourseId;
    }

    public void setOfflinecourseId(Long offlinecourseId) {
        this.offlinecourseId = offlinecourseId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}
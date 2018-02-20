package com.eduonline.model;

import java.util.Date;

public class UserCourse {
    private Long id;

    private Long userId;

    private Long courseId;

    private Date createTime;

    private String collection;

    private String joinInLearning;

    private String bought;

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

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection == null ? null : collection.trim();
    }

    public String getJoinInLearning() {
        return joinInLearning;
    }

    public void setJoinInLearning(String joinInLearning) {
        this.joinInLearning = joinInLearning == null ? null : joinInLearning.trim();
    }

    public String getBought() {
        return bought;
    }

    public void setBought(String bought) {
        this.bought = bought == null ? null : bought.trim();
    }
}
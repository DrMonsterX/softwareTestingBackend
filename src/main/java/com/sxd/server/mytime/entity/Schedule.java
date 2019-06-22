package com.sxd.server.mytime.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    @Column(name = "schedule_id")
    private Integer scheduleId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "position")
    private Integer position;

    @Column(name = "schedule_name")
    private String scheduleName;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "finish_time")
    private String finishTime;

    @Column(name = "remark")
    private String remark;

    @Column(name = "is_remind")
    private Integer isRemind;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }



    public void setPosition(Integer position) {
        this.position = position;
    }



    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }



    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }



    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }



    public void setRemark(String remark) {
        this.remark = remark;
    }



    public void setIsRemind(Integer isRemind) {
        this.isRemind = isRemind;
    }
}

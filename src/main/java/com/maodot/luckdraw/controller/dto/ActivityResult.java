package com.maodot.luckdraw.controller.dto;

import com.maodot.luckdraw.infrastructure.repository.dto.ActivityDto;

public class ActivityResult {

    private String activityCode;
    private String name;
    private String content;
    private Long beginTime;
    private Long endTime;
    private Integer activityStatus;

    public String getActivityCode() {
        return activityCode;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public Long getBeginTime() {
        return beginTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public Integer getActivityStatus() {
        return activityStatus;
    }

	public void initFromDto(ActivityDto activityDto) {
		this.activityCode = activityDto.getActivityCode();
		this.name = activityDto.getName();
		this.content = activityDto.getContent();
		this.beginTime = activityDto.getBeginTime();
		this.endTime = activityDto.getEndTime();
		this.activityStatus = activityDto.getActivityStatus();
	}
}
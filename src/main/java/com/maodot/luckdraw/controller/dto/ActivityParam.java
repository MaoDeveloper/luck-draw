package com.maodot.luckdraw.controller.dto;
import com.maodot.luckdraw.infrastructure.repository.dto.ActivityDto;

public class ActivityParam {

    private String activityCode;
    private String name;
    private String content;
    private Long beginTime;
    private Long endTime;
    private Integer activityStatus;

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setBeginTime(Long beginTime) {
        this.beginTime = beginTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public void setActivityStatus(Integer activityStatus) {
        this.activityStatus = activityStatus;
    }

    public String getActivityCode() {
        return activityCode;
    }

	public ActivityDto toDto() {
		ActivityDto dto = new ActivityDto();
		if(activityCode != null && !activityCode.trim().equals("")){
            activityCode = (activityCode == null || activityCode.trim().equals("")) ? "" : activityCode;
            name = (name == null || name.trim().equals("")) ? "" : name;
            content = (content == null || content.trim().equals("")) ? "" : content;
            beginTime = (beginTime == null) ? 0l : beginTime;
            endTime = (endTime == null) ? 0l : endTime;
            activityStatus = (activityStatus == null) ? 0 : activityStatus;
		}
		dto.setActivityCode(activityCode);
		dto.setName(name);
		dto.setContent(content);
		dto.setBeginTime(beginTime);
		dto.setEndTime(endTime);
		dto.setActivityStatus(activityStatus);
		return dto;
	}
}
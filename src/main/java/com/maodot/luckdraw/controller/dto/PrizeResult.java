package com.maodot.luckdraw.controller.dto;

import com.maodot.luckdraw.infrastructure.repository.dto.PrizeDto;

public class PrizeResult {

    private String prizeCode;
    private String name;
    private String url;
    private Integer type;
    private String value;
    private Integer prizeStatus;
    private Integer position;
    private Integer phase;

    public String getPrizeCode() {
        return prizeCode;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public Integer getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public Integer getPrizeStatus() {
        return prizeStatus;
    }

    public Integer getPosition() {
        return position;
    }

    public Integer getPhase() {
        return phase;
    }

	public void initFromDto(PrizeDto prizeDto) {
		this.prizeCode = prizeDto.getPrizeCode();
		this.name = prizeDto.getName();
		this.url = prizeDto.getUrl();
		this.type = prizeDto.getType();
		this.value = prizeDto.getValue();
		this.prizeStatus = prizeDto.getPrizeStatus();
		this.position = prizeDto.getPosition();
		this.phase = prizeDto.getPhase();
	}
}
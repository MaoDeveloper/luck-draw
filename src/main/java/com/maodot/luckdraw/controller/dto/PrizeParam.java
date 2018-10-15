package com.maodot.luckdraw.controller.dto;

import com.maodot.luckdraw.infrastructure.repository.dto.PrizeDto;

public class PrizeParam {

    private String prizeCode;
    private String name;
    private String url;
    private Integer type;
    private String value;
    private Integer prizeStatus;
    private Integer position;
    private Integer phase;

    public void setPrizeCode(String prizeCode) {
        this.prizeCode = prizeCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setPrizeStatus(Integer prizeStatus) {
        this.prizeStatus = prizeStatus;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public void setPhase(Integer phase) {
        this.phase = phase;
    }

    public String getPrizeCode() {
        return prizeCode;
    }

	public PrizeDto toDto() {
		PrizeDto dto = new PrizeDto();
		if(prizeCode != null && !prizeCode.trim().equals("")){
            prizeCode = (prizeCode == null || prizeCode.trim().equals("")) ? "" : prizeCode;
            name = (name == null || name.trim().equals("")) ? "" : name;
            url = (url == null || url.trim().equals("")) ? "" : url;
            type = (type == null) ? 0 : type;
            value = (value == null || value.trim().equals("")) ? "" : value;
            prizeStatus = (prizeStatus == null) ? 0 : prizeStatus;
            position = (position == null) ? 0 : position;
            phase = (phase == null) ? 0 : phase;
		}
		dto.setPrizeCode(prizeCode);
		dto.setName(name);
		dto.setUrl(url);
		dto.setType(type);
		dto.setValue(value);
		dto.setPrizeStatus(prizeStatus);
		dto.setPosition(position);
		dto.setPhase(phase);
		return dto;
	}
}
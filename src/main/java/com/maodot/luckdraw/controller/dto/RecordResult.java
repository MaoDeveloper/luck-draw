package com.maodot.luckdraw.controller.dto;
import com.maodot.luckdraw.infrastructure.repository.dto.RecordDto;

public class RecordResult {

    private String recordCode;
    private String memberCode;
    private String memberPhone;
    private String prizeCode;
    private Integer result;

    public String getRecordCode() {
        return recordCode;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public String getPrizeCode() {
        return prizeCode;
    }

    public Integer getResult() {
        return result;
    }

	public void initFromDto(RecordDto recordDto) {
		this.recordCode = recordDto.getRecordCode();
		this.memberCode = recordDto.getMemberCode();
		this.memberPhone = recordDto.getMemberPhone();
		this.prizeCode = recordDto.getPrizeCode();
		this.result = recordDto.getResult();
	}
}
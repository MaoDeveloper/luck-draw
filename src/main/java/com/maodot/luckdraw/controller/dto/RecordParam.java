package com.maodot.luckdraw.controller.dto;
import com.maodot.luckdraw.infrastructure.repository.dto.RecordDto;

public class RecordParam {

    private String recordCode;
    private String memberCode;
    private String memberPhone;
    private String prizeCode;
    private Integer result;

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public void setPrizeCode(String prizeCode) {
        this.prizeCode = prizeCode;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getRecordCode() {
        return recordCode;
    }

	public RecordDto toDto() {
		RecordDto dto = new RecordDto();
		if(recordCode != null && !recordCode.trim().equals("")){
            recordCode = (recordCode == null || recordCode.trim().equals("")) ? "" : recordCode;
            memberCode = (memberCode == null || memberCode.trim().equals("")) ? "" : memberCode;
            memberPhone = (memberPhone == null || memberPhone.trim().equals("")) ? "" : memberPhone;
            prizeCode = (prizeCode == null || prizeCode.trim().equals("")) ? "" : prizeCode;
            result = (result == null) ? 0 : result;
		}
		dto.setRecordCode(recordCode);
		dto.setMemberCode(memberCode);
		dto.setMemberPhone(memberPhone);
		dto.setPrizeCode(prizeCode);
		dto.setResult(result);
		return dto;
	}
}
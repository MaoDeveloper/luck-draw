package com.maodot.luckdraw.controller.dto;
import com.maodot.luckdraw.infrastructure.repository.dto.ProbabilityDto;

public class ProbabilityParam {

    private String probabilityCode;
    private String prizeCode;
    private Integer prizePhase;
    private String probability;
    private Integer frozen;
    private Integer prizeDayMaxTimes;
    private Integer userPrizeMonthMaxTimes;

    public void setProbabilityCode(String probabilityCode) {
        this.probabilityCode = probabilityCode;
    }

    public void setPrizeCode(String prizeCode) {
        this.prizeCode = prizeCode;
    }

    public void setPrizePhase(Integer prizePhase) {
        this.prizePhase = prizePhase;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }

    public void setFrozen(Integer frozen) {
        this.frozen = frozen;
    }

    public void setPrizeDayMaxTimes(Integer prizeDayMaxTimes) {
        this.prizeDayMaxTimes = prizeDayMaxTimes;
    }

    public void setUserPrizeMonthMaxTimes(Integer userPrizeMonthMaxTimes) {
        this.userPrizeMonthMaxTimes = userPrizeMonthMaxTimes;
    }

    public String getProbabilityCode() {
        return probabilityCode;
    }

	public ProbabilityDto toDto() {
		ProbabilityDto dto = new ProbabilityDto();
		if(probabilityCode != null && !probabilityCode.trim().equals("")){
            probabilityCode = (probabilityCode == null || probabilityCode.trim().equals("")) ? "" : probabilityCode;
            prizeCode = (prizeCode == null || prizeCode.trim().equals("")) ? "" : prizeCode;
            prizePhase = (prizePhase == null) ? 0 : prizePhase;
            probability = (probability == null || probability.trim().equals("")) ? "" : probability;
            frozen = (frozen == null) ? 0 : frozen;
            prizeDayMaxTimes = (prizeDayMaxTimes == null) ? 0 : prizeDayMaxTimes;
            userPrizeMonthMaxTimes = (userPrizeMonthMaxTimes == null) ? 0 : userPrizeMonthMaxTimes;
		}
		dto.setProbabilityCode(probabilityCode);
		dto.setPrizeCode(prizeCode);
		dto.setPrizePhase(prizePhase);
		dto.setProbability(probability);
		dto.setFrozen(frozen);
		dto.setPrizeDayMaxTimes(prizeDayMaxTimes);
		dto.setUserPrizeMonthMaxTimes(userPrizeMonthMaxTimes);
		return dto;
	}
}
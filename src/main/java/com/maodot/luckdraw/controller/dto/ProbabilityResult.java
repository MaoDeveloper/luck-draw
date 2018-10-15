package com.maodot.luckdraw.controller.dto;
import com.maodot.luckdraw.infrastructure.repository.dto.ProbabilityDto;

public class ProbabilityResult {

    private String probabilityCode;
    private String prizeCode;
    private Integer prizePhase;
    private String probability;
    private Integer frozen;
    private Integer prizeDayMaxTimes;
    private Integer userPrizeMonthMaxTimes;

    public String getProbabilityCode() {
        return probabilityCode;
    }

    public String getPrizeCode() {
        return prizeCode;
    }

    public Integer getPrizePhase() {
        return prizePhase;
    }

    public String getProbability() {
        return probability;
    }

    public Integer getFrozen() {
        return frozen;
    }

    public Integer getPrizeDayMaxTimes() {
        return prizeDayMaxTimes;
    }

    public Integer getUserPrizeMonthMaxTimes() {
        return userPrizeMonthMaxTimes;
    }

	public void initFromDto(ProbabilityDto probabilityDto) {
		this.probabilityCode = probabilityDto.getProbabilityCode();
		this.prizeCode = probabilityDto.getPrizeCode();
		this.prizePhase = probabilityDto.getPrizePhase();
		this.probability = probabilityDto.getProbability();
		this.frozen = probabilityDto.getFrozen();
		this.prizeDayMaxTimes = probabilityDto.getPrizeDayMaxTimes();
		this.userPrizeMonthMaxTimes = probabilityDto.getUserPrizeMonthMaxTimes();
	}
}
package com.maodot.luckdraw.domain.model;

public class Probability {

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

    public void setProbabilityCode(String probabilityCode) {
        this.probabilityCode = probabilityCode;
    }

    public String getPrizeCode() {
        return prizeCode;
    }

    public void setPrizeCode(String prizeCode) {
        this.prizeCode = prizeCode;
    }

    public Integer getPrizePhase() {
        return prizePhase;
    }

    public void setPrizePhase(Integer prizePhase) {
        this.prizePhase = prizePhase;
    }

    public String getProbability() {
        return probability;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }

    public Integer getFrozen() {
        return frozen;
    }

    public void setFrozen(Integer frozen) {
        this.frozen = frozen;
    }

    public Integer getPrizeDayMaxTimes() {
        return prizeDayMaxTimes;
    }

    public void setPrizeDayMaxTimes(Integer prizeDayMaxTimes) {
        this.prizeDayMaxTimes = prizeDayMaxTimes;
    }

    public Integer getUserPrizeMonthMaxTimes() {
        return userPrizeMonthMaxTimes;
    }

    public void setUserPrizeMonthMaxTimes(Integer userPrizeMonthMaxTimes) {
        this.userPrizeMonthMaxTimes = userPrizeMonthMaxTimes;
    }

}
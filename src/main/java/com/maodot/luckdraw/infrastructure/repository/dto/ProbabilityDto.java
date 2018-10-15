package com.maodot.luckdraw.infrastructure.repository.dto;
import java.util.Date;

public class ProbabilityDto {

    private Long id;
    private String probabilityCode;
    private String prizeCode;
    private Integer prizePhase;
    private String probability;
    private Integer frozen;
    private Integer prizeDayMaxTimes;
    private Integer userPrizeMonthMaxTimes;
    private Integer status;
    private Date createAt;
    private Date updateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

}
package com.tosit.genius.entity;

import java.util.Date;

public class Apply extends ApplyKey {
    private Date applyDate;

    private Boolean ispassed;

    private String statement;

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Boolean getIspassed() {
        return ispassed;
    }

    public void setIspassed(Boolean ispassed) {
        this.ispassed = ispassed;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement == null ? null : statement.trim();
    }
}
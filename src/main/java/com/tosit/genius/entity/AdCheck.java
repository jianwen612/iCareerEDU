package com.tosit.genius.entity;

public class AdCheck extends AdCheckKey {
    private Boolean ispassed;

    private Integer priority;

    public Boolean getIspassed() {
        return ispassed;
    }

    public void setIspassed(Boolean ispassed) {
        this.ispassed = ispassed;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
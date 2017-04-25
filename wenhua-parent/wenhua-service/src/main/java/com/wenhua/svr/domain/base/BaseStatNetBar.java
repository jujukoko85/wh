package com.wenhua.svr.domain.base;

public class BaseStatNetBar extends BaseStatNetBarKey {
    private Integer online;

    private Integer offline;

    private Integer valid;

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public Integer getOffline() {
        return offline;
    }

    public void setOffline(Integer offline) {
        this.offline = offline;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }
}
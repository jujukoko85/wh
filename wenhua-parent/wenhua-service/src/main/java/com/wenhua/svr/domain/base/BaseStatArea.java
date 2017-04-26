package com.wenhua.svr.domain.base;

public class BaseStatArea extends BaseStatAreaKey {
	
    private Integer online;

    private Integer offline;

    private Integer login;

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

    public Integer getLogin() {
        return login;
    }

    public void setLogin(Integer login) {
        this.login = login;
    }
}
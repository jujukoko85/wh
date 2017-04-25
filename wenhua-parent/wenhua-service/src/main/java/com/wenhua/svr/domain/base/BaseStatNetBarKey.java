package com.wenhua.svr.domain.base;

import java.util.Date;

public class BaseStatNetBarKey {
    private String barId;

    private Date statDate;

    public String getBarId() {
        return barId;
    }

    public void setBarId(String barId) {
        this.barId = barId;
    }

    public Date getStatDate() {
        return statDate;
    }

    public void setStatDate(Date statDate) {
        this.statDate = statDate;
    }
}
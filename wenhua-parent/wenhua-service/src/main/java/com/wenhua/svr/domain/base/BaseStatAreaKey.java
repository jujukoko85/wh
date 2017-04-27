package com.wenhua.svr.domain.base;

import java.util.Date;

public class BaseStatAreaKey {
    private String areaCode;

    private Date statDate;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Date getStatDate() {
        return statDate;
    }

    public void setStatDate(Date statDate) {
        this.statDate = statDate;
    }
}
package com.fishs.chat3.case1.examp1.model;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/13 13:08
 */
public sealed class Base permits Person {
    private String version;
    public void setVersion(String version) {
        this.version = version;
    }
    public String getVersion() {
        return version;
    }
}

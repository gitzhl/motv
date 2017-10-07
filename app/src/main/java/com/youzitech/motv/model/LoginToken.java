package com.youzitech.motv.model;

/**
 * Created by Administrator on 2017/10/7 0007.
 */

public class LoginToken {

    private long id;
    private String loginId;
    private String token;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

package com.youzitech.motv.model;

/**
 * Created by Administrator on 2017/10/6 0006.
 */

public class TvCategory {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;

    public TvCategory(String title){
        this.title = title;
    }
}

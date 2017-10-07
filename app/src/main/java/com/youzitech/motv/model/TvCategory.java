package com.youzitech.motv.model;

/**
 * Created by Administrator on 2017/10/6 0006.
 */

public class TvCategory {

    private long id;
    private String categoryName;
    private int type;
    private long ownerId;

    public TvCategory(String categoryName){
        this.categoryName = categoryName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }
}

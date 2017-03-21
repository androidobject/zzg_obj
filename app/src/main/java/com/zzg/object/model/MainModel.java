package com.zzg.object.model;

import java.io.Serializable;

/**
 * Created by apple on 2016/11/15.
 */

public class MainModel implements Serializable {
    private String title;
    private String name;
    //item
    private int code;

    public MainModel(String title, String name, int code) {
        this.title = title;
        this.name = name;
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

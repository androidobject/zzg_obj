package com.zzg.object.model;

import android.view.View;
import android.widget.Toast;

/**
 * @author zzg
 * @time 2018/4/26-16:00
 * @Des
 */
public class DataBindingModel {

    private String username;
    private String nickname;
    private String sex;


    private String age;
    private String date;

    public DataBindingModel(String username, String nickname, String sex, String age, String date) {
        this.username = username;
        this.nickname = nickname;
        this.sex = sex;
        this.age = age;
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public void onclickNick(View view) {
        Toast.makeText(view.getContext(), nickname, Toast.LENGTH_SHORT).show();
    }


    public void onclickUser(View view) {
        Toast.makeText(view.getContext(), username, Toast.LENGTH_SHORT).show();
    }
}

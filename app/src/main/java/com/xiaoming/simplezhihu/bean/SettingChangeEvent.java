package com.xiaoming.simplezhihu.bean;

/**
 * Created by ssthouse on 30/12/2016.
 */

public class SettingChangeEvent {

    private String username;

    private int jokeNum;

    public SettingChangeEvent(String username, int jokeNum) {
        this.username = username;
        this.jokeNum = jokeNum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getJokeNum() {
        return jokeNum;
    }

    public void setJokeNum(int jokeNum) {
        this.jokeNum = jokeNum;
    }
}

package com.xiaoming.simplezhihu.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ssthouse on 16/9/2.
 */
public class PreferUtil {

    private static PreferUtil mInstance;
    private Application mContext;

    private static final String PREFER_FILE_NAME = "preference";
    private static final String KEY_IS_CONY = "isCony";
    private static final String KEY_IS_FIST_IN = "isFistIn";
    private static final String KEY_LAST_SIGN_TIME_IN_MILLIS = "lastSignTimeInMillis";
    private static final String KEY_SHARE_FAST_NOTE = "uploadFastNote";

    private static final String KEY_USER_NAME = "userName";
    private static final String KEY_JOKE_NUM = "jokeNum";

    public static PreferUtil getInstance(Activity context) {
        if (mInstance == null)
            mInstance = new PreferUtil(context);
        return mInstance;
    }

    private PreferUtil(Activity context) {
        this.mContext = context.getApplication();
    }

    /****************
     * 第一次进入
     *****************/
    public boolean isFistIn() {
        return mContext.getSharedPreferences(PREFER_FILE_NAME, Context.MODE_PRIVATE)
                .getBoolean(KEY_IS_FIST_IN, true);
    }

    public void setIsFistIn(boolean isFistIn) {
        setBoolean(KEY_IS_FIST_IN, isFistIn);
    }


    /***********
     * 是不是Cony
     *******************/
    public boolean isCony() {
        return mContext.getSharedPreferences(PREFER_FILE_NAME, Context.MODE_PRIVATE)
                .getBoolean(KEY_IS_CONY, true);
    }

    public void setIsCony(boolean value) {
        setBoolean(KEY_IS_CONY, value);
    }


    /******************
     * 最近一次签到天的时间
     ***************************************/
    public String getLastSignTimeInMillisStr() {
        return getString(KEY_LAST_SIGN_TIME_IN_MILLIS, "0");
    }

    public void setLastSignTimeInMillis(String lastSignTimeInMillisStr) {
        setString(KEY_LAST_SIGN_TIME_IN_MILLIS, lastSignTimeInMillisStr);
    }

    //是否分享fastnote 默认为true
    public boolean isShareFastNote() {
        return getBoolean(KEY_SHARE_FAST_NOTE, true);
    }

    public void setShareFastnNote(boolean isShare) {
        setBoolean(KEY_SHARE_FAST_NOTE, isShare);
    }

    /**********************
     * username
     ***********************/
    public void setUsername(String username) {
        setString(KEY_USER_NAME, username);
    }

    public String getUsername() {
        return getString(KEY_USER_NAME, "username");
    }

    /******************
     * joke num
     ******************************/
    public void setJokeNum(int jokeNum) {
        setInteger(KEY_JOKE_NUM, jokeNum);
    }

    public int getJokeNum() {
        return getInt(KEY_JOKE_NUM, 10);
    }

    /************************
     * base function
     ********************************/
    public boolean getBoolean(String keyStr, boolean defaultValue) {
        return mContext.getSharedPreferences(PREFER_FILE_NAME, Context.MODE_PRIVATE)
                .getBoolean(keyStr, defaultValue);
    }

    public void setBoolean(String keyStr, boolean value) {
        SharedPreferences.Editor editor = mContext.getSharedPreferences(PREFER_FILE_NAME, Context.MODE_PRIVATE)
                .edit();
        editor.putBoolean(keyStr, value)
                .apply();
    }

    public String getString(String keyStr, String defaultValue) {
        return mContext.getSharedPreferences(PREFER_FILE_NAME, Context.MODE_PRIVATE)
                .getString(keyStr, defaultValue);
    }

    public void setString(String keyStr, String value) {
        SharedPreferences.Editor editor = mContext.getSharedPreferences(PREFER_FILE_NAME, Context.MODE_PRIVATE)
                .edit();
        editor.putString(keyStr, value)
                .apply();
    }

    public void setInteger(String keyStr, int value) {
        SharedPreferences.Editor editor = mContext.getSharedPreferences(PREFER_FILE_NAME, Context.MODE_PRIVATE)
                .edit();
        editor.putInt(keyStr, value)
                .apply();
    }

    public int getInt(String keyStr, int defaultValue) {
        return mContext.getSharedPreferences(PREFER_FILE_NAME, Context.MODE_PRIVATE)
                .getInt(keyStr, defaultValue);
    }
}

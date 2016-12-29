package com.xiaoming.simplezhihu.base;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

import timber.log.Timber;

/**
 * Created by ssthouse on 16/5/18.
 */
public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
        ActiveAndroid.initialize(this);
    }
}

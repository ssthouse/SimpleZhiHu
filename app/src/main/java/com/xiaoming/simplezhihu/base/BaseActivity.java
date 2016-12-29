package com.xiaoming.simplezhihu.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by ssthouse on 16/9/2.
 */
public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ButterKnife.bind(this);
        init();
    }

    /**
     * Activity初始化
     */
    public abstract void init();

    /**
     * 获取layout
     *
     * @return layout id
     */
    public abstract int getContentView();


}

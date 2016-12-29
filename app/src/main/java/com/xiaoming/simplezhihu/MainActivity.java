package com.xiaoming.simplezhihu;


import android.support.v7.widget.Toolbar;

import com.xiaoming.simplezhihu.base.BaseActivity;

import butterknife.Bind;

public class MainActivity extends BaseActivity {

    @Bind(R.id.id_tb)
    Toolbar mToolbar;

    private MainFragment mMainFragment;

    @Override
    public void init() {
        initToolbar();

        mMainFragment = new MainFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.id_fragment_container, mMainFragment)
                .commit();
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Simple Daily");
    }

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }
}

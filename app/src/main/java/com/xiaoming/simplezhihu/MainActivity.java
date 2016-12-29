package com.xiaoming.simplezhihu;


import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import com.xiaoming.simplezhihu.base.BaseActivity;

import butterknife.Bind;

public class MainActivity extends BaseActivity {

    @Bind(R.id.id_tb)
    Toolbar mToolbar;

    @Bind(R.id.id_navigation)
    NavigationView mNavigationView;

    @Bind(R.id.id_drawer_view)
    DrawerLayout mDrawerLayout;

    private MainFragment mMainFragment;

    @Override
    public void init() {
        initToolbar();

        initDrawer();

        mMainFragment = new MainFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.id_fragment_container, mMainFragment)
                .commit();
    }

    private void initDrawer() {
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,
                R.string.str_drawer_des_open, R.string.str_drawer_des_close);
        actionBarDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
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

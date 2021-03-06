package com.xiaoming.simplezhihu;


import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.xiaoming.simplezhihu.base.BaseActivity;
import com.xiaoming.simplezhihu.bean.SettingChangeEvent;
import com.xiaoming.simplezhihu.utils.PreferUtil;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements SettingAty.SettingChangeCallback {

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

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.id_menu_setting:
                        SettingAty.setCallback(MainActivity.this);
                        SettingAty.start(MainActivity.this);
                }
                return true;
            }
        });

        TextView tvName = (TextView) mNavigationView.getHeaderView(0).findViewById(R.id.id_tv_name);
        tvName.setText(PreferUtil.getInstance(this).getUsername());
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Simple Daily");
    }

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void settingChangeCallback(SettingChangeEvent event) {
        TextView tvName = (TextView) mNavigationView.getHeaderView(0).findViewById(R.id.id_tv_name);
        tvName.setText(event.getUsername());
        // change joke num setting
        PreferUtil.getInstance(this).setJokeNum(event.getJokeNum());
    }
}

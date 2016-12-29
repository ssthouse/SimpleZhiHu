package com.xiaoming.simplezhihu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;

import com.xiaoming.simplezhihu.base.BaseActivity;

import butterknife.Bind;

/**
 * Created by ssthouse on 29/12/2016.
 */

public class SettingAty extends BaseActivity {

    @Bind(R.id.id_tb)
    Toolbar mTb;

    @Bind(R.id.id_et_name)
    EditText mEtName;

    @Bind(R.id.id_sp_joke_num)
    Spinner mSpJokeNum;

    public static void start(Context context) {
        Intent intent = new Intent(context, SettingAty.class);
        context.startActivity(intent);
    }

    @Override
    public void init() {
        initToolbar();

    }

    private void initToolbar() {
        setSupportActionBar(mTb);
        getSupportActionBar().setTitle("Setting");
    }

    @Override
    public int getContentView() {
        return R.layout.activity_setting;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_setting, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_menu_save:
                //TODO save data close
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

package com.xiaoming.simplezhihu.jokelist;

import android.content.Context;
import android.content.SharedPreferences;

import com.xiaoming.simplezhihu.bean.JuheJokeBean;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

/**
 * save today's joke and joke timestamp
 * Created by ssthouse on 07/12/2016.
 */

public class TodayJokeRecorder {


    private static TodayJokeRecorder instance;

    private Context mContext;

    private static final String PREFER_FILE_NAME = "joke_recorder";

    private static final String KEY_JOKE_TIME_STAMP = "time_stamp";
    private static final String KEY_JOKE_RESULT_BEAN_LIST_PREFIX = "result_bean_list";

    private SharedPreferences mSharedPreference;

    private TodayJokeRecorder(Context context) {
        this.mContext = context;
        mSharedPreference = context.getSharedPreferences(PREFER_FILE_NAME, Context.MODE_PRIVATE);
    }

    public static TodayJokeRecorder getInstance(Context context) {
        if (instance == null)
            instance = new TodayJokeRecorder(context);
        return instance;
    }

    public void setTimeStamp(long timeStamp) {
        SharedPreferences.Editor editor = mSharedPreference.edit();
        editor.putLong(KEY_JOKE_TIME_STAMP, timeStamp)
                .apply();
    }

    /**
     * if not set yet, return an old day timeStamp
     *
     * @return
     */
    public long getTimeStamp() {
        return mSharedPreference.getLong(KEY_JOKE_TIME_STAMP, 1481029208961L);
    }

    public void setJokeResultBeanList(List<JuheJokeBean.ResultBean> resultBeanList) {
        clearFormerList();
        SharedPreferences.Editor editor = mSharedPreference.edit();
        for (int i = 0; i < resultBeanList.size(); i++) {
            editor.putString(KEY_JOKE_RESULT_BEAN_LIST_PREFIX + i, resultBeanList.get(i).getContent());
        }
        editor.apply();
    }

    /**
     * this method will only be called when timestamp is in the equal day
     * in which case the joke list exists
     *
     * @return
     */
    public List<JuheJokeBean.ResultBean> getResultBeanList() {
        Timber.e("get bena list");
        List<JuheJokeBean.ResultBean> resultBeanList = new ArrayList<>();
        int i = 0;
        while (mSharedPreference.contains(KEY_JOKE_RESULT_BEAN_LIST_PREFIX + i)) {
            JuheJokeBean.ResultBean resultBean = new JuheJokeBean.ResultBean();
            resultBean.setContent(mSharedPreference.getString(KEY_JOKE_RESULT_BEAN_LIST_PREFIX + i, null));
            resultBeanList.add(resultBean);
            i++;
        }
        return resultBeanList;
    }

    private void clearFormerList() {
        int i = 0;
        SharedPreferences.Editor editor = mSharedPreference.edit();
        while (mSharedPreference.contains(KEY_JOKE_RESULT_BEAN_LIST_PREFIX + i)) {
            editor.remove(KEY_JOKE_RESULT_BEAN_LIST_PREFIX + i);
            i++;
        }
        editor.apply();
    }
}

package com.xiaoming.simplezhihu.zhihu;

import com.xiaoming.simplezhihu.bean.ZhiHuBean;
import com.xiaoming.simplezhihu.bean.ZhiHuDetailBean;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ssthouse on 06/12/2016.
 */

public class ZhiHuGenerator {

    public static void getStories(Callback<ZhiHuBean> callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://news-at.zhihu.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ZhiHuService zhiHuService = retrofit.create(ZhiHuService.class);
        zhiHuService.getZhiHuBean().enqueue(callback);
    }

    public static void getStortDetailBean(String storyId, Callback<ZhiHuDetailBean> callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://news-at.zhihu.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ZhiHuService zhiHuService = retrofit.create(ZhiHuService.class);
        zhiHuService.getZhiHuDetailBean(storyId).enqueue(callback);
    }
}

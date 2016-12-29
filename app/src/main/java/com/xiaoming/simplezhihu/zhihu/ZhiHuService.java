package com.xiaoming.simplezhihu.zhihu;

import com.xiaoming.simplezhihu.bean.ZhiHuBean;
import com.xiaoming.simplezhihu.bean.ZhiHuDetailBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ssthouse on 06/12/2016.
 */

public interface ZhiHuService {

    @GET("api/4/news/latest")
    Call<ZhiHuBean> getZhiHuBean();

    @GET("api/4/news/{id}")
    Call<ZhiHuDetailBean> getZhiHuDetailBean(@Path("id") String id);
}

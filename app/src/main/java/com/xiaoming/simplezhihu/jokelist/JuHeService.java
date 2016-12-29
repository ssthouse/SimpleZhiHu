package com.xiaoming.simplezhihu.jokelist;

import com.xiaoming.simplezhihu.bean.JuheJokeBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ssthouse on 07/12/2016.
 */

public interface JuHeService {

    String BASIC_URL = "http://v.juhe.cn/";

    String KEY = "682e17f6e34ecdc436465c1e9f4014ec";

    @GET("joke/randJoke.php")
    Call<JuheJokeBean> getJuHeJoke(@Query("key") String key);

}

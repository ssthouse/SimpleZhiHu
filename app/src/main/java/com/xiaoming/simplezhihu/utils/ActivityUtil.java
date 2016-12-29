package com.xiaoming.simplezhihu.utils;

import android.content.Context;
import android.content.Intent;

/**
 * Created by ssthouse on 16/9/2.
 */
public class ActivityUtil {


    /**
     * 启动activity
     * @param context
     * @param atyClass
     */
    public static void startAty(Context context, Class atyClass) {
        Intent intent = new Intent(context, atyClass);
        context.startActivity(intent);

    }
}

package com.xiaoming.simplezhihu.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by ssthouse on 05/11/2016.
 */

public class ToastUtil {

    private static final String COMMON_WRONG_STR = "Something is wrong\n better tell your giant baby";

    public static void show(Context context, String content) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }

    public static void showCommonWrong(Context context) {
        show(context, COMMON_WRONG_STR);
    }
}

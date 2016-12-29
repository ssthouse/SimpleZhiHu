package com.xiaoming.simplezhihu.utils;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by ssthouse on 16/5/9.
 */
public class StringUtils {


    public static String getLoveTimeStr() {
        Calendar beginCalendar = new GregorianCalendar(2016, 2, 14);
        Calendar currentCalendar = GregorianCalendar.getInstance();
        return (currentCalendar.getTimeInMillis() - beginCalendar.getTimeInMillis()) / (1000 * 60 * 60 * 24) + "天";
    }

}

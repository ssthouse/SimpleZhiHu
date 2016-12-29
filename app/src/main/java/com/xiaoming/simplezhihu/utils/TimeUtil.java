package com.xiaoming.simplezhihu.utils;

import java.util.Date;

import timber.log.Timber;

/**
 * Created by ssthouse on 07/12/2016.
 */

public class TimeUtil {


    /**
     * juge if the timeStampAfter is after timeStampBefore more than a day
     *
     * @param timeStampAfter
     * @param timeStampBefore
     * @return
     */
    public static boolean isAfterDays(long timeStampAfter, long timeStampBefore) {
        Date lastSignDate = new Date(timeStampBefore);
        Date currentDate = new Date(timeStampAfter);
        boolean isAfterDays = false;
        if (currentDate.getYear() > lastSignDate.getYear())
            isAfterDays = true;
        if (currentDate.getYear() == lastSignDate.getYear() && currentDate.getMonth() > lastSignDate.getMonth())
            isAfterDays = true;
        if (currentDate.getYear() == lastSignDate.getYear() && currentDate.getMonth() == lastSignDate.getMonth()
                && currentDate.getDate() > lastSignDate.getDate())
            isAfterDays = true;
        return isAfterDays;

    }

    public static int dayInterval(Date fistDate, Date secDate) {
        Date[] dates = {fistDate, secDate};
        for (Date date : dates) {
            Timber.e(date.getYear() + "  " + date.getMonth() + "  " + date.getDate() + "   " + date.getTime());
            int remainder = (int) (date.getTime() - date.getTime() % (24 * 60 * 60 * 1000));
            if (remainder != 0) {
                date.setTime(date.getTime() - date.getTime() % (24 * 60 * 60 * 1000) + (24 * 60 * 60 * 1000));
            }
            Timber.e(date.getYear() + "  " + date.getMonth() + "  " + date.getDate() + "   " + date.getTime());
        }
        return (int) ((fistDate.getTime() - secDate.getTime()) / (24 * 60 * 60 * 1000));
    }

}

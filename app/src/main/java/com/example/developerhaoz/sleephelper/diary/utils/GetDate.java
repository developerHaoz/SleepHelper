package com.example.developerhaoz.sleephelper.diary.utils;

import java.util.Calendar;

/**
 * 获取当前的日期，格式为：2017 年 5 月 4 日
 *
 * Created by developerHaoz on 2017/5/3.
 */

public class GetDate {
    public static StringBuilder getDate(){

        StringBuilder stringBuilder = new StringBuilder();
        Calendar now = Calendar.getInstance();
        stringBuilder.append(now.get(Calendar.YEAR) + " 年 ");
        stringBuilder.append((int)(now.get(Calendar.MONTH) + 1)  + " 月 ");
        stringBuilder.append(now.get(Calendar.DAY_OF_MONTH) + " 日");
        return stringBuilder;
    }
}

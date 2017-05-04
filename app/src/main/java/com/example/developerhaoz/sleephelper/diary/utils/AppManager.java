package com.example.developerhaoz.sleephelper.diary.utils;

import android.support.v7.app.AppCompatActivity;

import java.util.Stack;

/**
 * 所有 Activity 的管理类
 *
 * Created by developerHaoz on 2017/5/3.
 */

public class AppManager {
    private static Stack<AppCompatActivity> activityStack;
    private static AppManager instance;

    private AppManager(){}

    public static AppManager getAppManager(){
        if(instance == null){
            synchronized (AppManager.class){
                if(instance == null){
                    instance = new AppManager();
                }
            }
        }
        return instance;
    }

    public void addActivity(AppCompatActivity activity){
        if(activityStack == null){
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }

//    /**
//     * 获得当前Activity(栈顶Activity)
//     *
//     * @return 当前的 Activity
//     */
//    public AppCompatActivity currentActivity(){
//
//        if(activityStack == null || activityStack.isEmpty()){
//            return null;
//        }
//        AppCompatActivity acitivity = activityStack.lastElement();
//        return acitivity;
//    }

//    public AppCompatActivity findActivity(Class<?> cls){
//        AppCompatActivity activity = null;
//        for (AppCompatActivity appCompatActivity : activityStack) {
//            if(appCompatActivity.getClass().equals(cls)){
//                activity = appCompatActivity;
//                break;
//            }
//        }
//        return activity;
//    }

//    public void finishActivity(){
//        AppCompatActivity activity = activityStack.lastElement();
//        finishActivity(activity);
//    }

//    public void finishActivity(AppCompatActivity activity){
//        if(activity != null){
//            activityStack.remove(activity);
//            activity.finish();
//            activity = null;
//        }
//    }

//    public void finishActivity(Class<?> cls){
//        for (AppCompatActivity activity : activityStack) {
//            if(activity.getClass().equals(cls)){
//                finishActivity(activity);
//            }
//        }
//    }

//    public void finishAllActivity(){
//        for (int i = 0, size = activityStack.size(); i < size; i++) {
//            if (null != activityStack.get(i)) {
//                activityStack.get(i).finish();
//            }
//        }
//        activityStack.clear();
//    }

//    public void AppExit(Context context){
//        try{
//            finishAllActivity();
//            ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
//            activityManager.killBackgroundProcesses(context.getPackageName());
//            System.exit(0);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}

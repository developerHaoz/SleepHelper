package com.example.developerhaoz.sleephelper.common;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.squareup.leakcanary.LeakCanary;

/**
 * 自定义的 Application
 *
 * Created by developerHaoz on 2017/5/3.
 */

public class SleepApplication extends Application {

    private static SleepApplication mContext;
    private static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        requestQueue = Volley.newRequestQueue(mContext);
        if(LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        LeakCanary.install(this);
    }

    public static Context getContext(){
        return mContext;
    }

    public  RequestQueue getRequestQueue(){
        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return requestQueue;
    }
}

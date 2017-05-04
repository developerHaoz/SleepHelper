package com.example.developerhaoz.sleephelper.meizi.utils;

import com.example.developerhaoz.sleephelper.meizi.bean.MeiziBean;
import com.example.developerhaoz.sleephelper.meizi.event.MeiziBeanListEvent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Gson 的处理类
 *
 * Created by developerHaoz on 2017/5/3.
 */

public class GsonHelper {

    public static List<MeiziBean> getMeiziBean(String response){
        List<MeiziBean> meiziBeanList = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(response);
                String meiziArrayStr = jsonObject.getString("results");
                Type meiziListType = new TypeToken<List<MeiziBean>>(){}.getType();
                Gson gson = new Gson();
                meiziBeanList = gson.fromJson(meiziArrayStr, meiziListType);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (meiziBeanList.size() > 0){
            Logger.d(meiziBeanList.size());
            EventBus.getDefault().post(new MeiziBeanListEvent(meiziBeanList));
        }
        return meiziBeanList;
    }

}

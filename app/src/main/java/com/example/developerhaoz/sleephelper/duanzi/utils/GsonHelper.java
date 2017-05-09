package com.example.developerhaoz.sleephelper.duanzi.utils;

import com.example.developerhaoz.sleephelper.duanzi.bean.DuanziBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 用于 Json 解析的帮助类
 *
 * Created by developerHaoz on 2017/5/7.
 */

public class GsonHelper {

    public static List<DuanziBean> getDuanziBeanList(String response){

        List<DuanziBean> mDuanziBeanList = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(response);
            String dataArrayStr = jsonObject.getJSONObject("data").getString("data");
            Type type = new TypeToken<List<DuanziBean>>(){}.getType();
            Gson gson = new Gson();
            mDuanziBeanList = gson.fromJson(dataArrayStr, type);
            return mDuanziBeanList;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mDuanziBeanList;
    }
}

package com.example.developerhaoz.sleephelper.meizi.utils;

import com.example.developerhaoz.sleephelper.meizi.bean.MeiziBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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

    /**
     * 将一个 String 类型的数据解析成一个 List<MeiziBean>
     *
     * @param response 包含妹子信息的 String
     * @return List<MeiziBean>
     */
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
        return meiziBeanList;
    }

}

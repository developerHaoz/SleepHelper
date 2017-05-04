package com.example.developerhaoz.sleephelper.meizi.bean;

import com.google.gson.annotations.SerializedName;

/**
 * 妹子的实体类
 *
 * Created by developerHaoz on 2017/5/3.
 */

public class MeiziBean {


    /**
     * _id : 56cc6d23421aa95caa707b7c
     * createdAt : 2015-06-08T01:03:29.806Z
     * desc : 6.8——（2）
     * publishedAt : 2015-06-09T03:30:26.527Z
     * type : 福利
     * url : http://ww3.sinaimg.cn/large/7a8aed7bgw1eswencfur6j20hq0qodhs.jpg
     * used : true
     * who : 张涵宇
     */

    @SerializedName("_id")
    private String id;
    @SerializedName("url")
    private String imageUrl;
    @SerializedName("who")
    private String who;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public MeiziBean(String imageUrl){
        this.imageUrl = imageUrl;
    }
}

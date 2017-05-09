package com.example.developerhaoz.sleephelper.duanzi.bean;

import com.google.gson.annotations.SerializedName;

/**
 * 段子的实体类
 *
 * Created by developerHaoz on 2017/5/7.
 */

public class DuanziBean {

    @SerializedName("group")
    private GroupBean groupBean;
    private String type;

    public GroupBean getGroupBean() {
        return groupBean;
    }

    public void setGroupBean(GroupBean groupBean) {
        this.groupBean = groupBean;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}

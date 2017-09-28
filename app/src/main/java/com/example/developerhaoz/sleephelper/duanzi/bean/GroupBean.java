package com.example.developerhaoz.sleephelper.duanzi.bean;

/**
 * 段子中实体类
 *
 * Created by developerHaoz on 2017/5/7.
 */

public class GroupBean {

    private String text;
    private long id;
    private UserBean user;

    public String getText() {
        return text;
    }

    public long getId() {
        return id;
    }

    public UserBean getUser() {
        return user;
    }

    public static class UserBean {

        private long user_id;
        private String name;
        private String avatar_url;

        public String getName() {
            return name;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

    }
}

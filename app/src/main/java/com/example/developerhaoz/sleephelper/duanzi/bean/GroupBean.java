package com.example.developerhaoz.sleephelper.duanzi.bean;

/**
 * 段子中实体类
 *
 * Created by developerHaoz on 2017/5/7.
 */

public class GroupBean {

    /**
     * text : 老公姓李，老婆姓周。老婆生了个双胞胎，老丈人向女婿提要求了：1，给孩子取名字一个姓周，一个姓李[害羞][害羞]；2，取名字要有纪念意义；3，两个名字要同一个意思[冷汗][冷汗]！今天女婿告诉老丈人，名字取好了……一个叫周末；一个叫李拜天。老丈人无话可说，开了瓶茅台酒………语重心长的说：祝周末李拜天愉快！[偷笑]哈哈，祝周末愉快[呲牙]
     * neihan_hot_start_time : 00-00-00
     * dislike_reason : [{"type":2,"id":1,"title":"吧:内涵段子"},{"type":4,"id":0,"title":"内容重复"},{"type":3,"id":50249249014,"title":"作者:开心宝贝126087256"}]
     * create_time : 1494033932
     * id : 59853006104
     * favorite_count : 0
     * go_detail_count : 22
     * user_favorite : 0
     * share_type : 1
     * user : {"user_id":50249249014,"name":"开心宝贝126087256","followings":0,"user_verified":false,"ugc_count":14,"avatar_url":"http://p1.pstatp.com/medium/1782000bcdae97400846","followers":33,"is_following":false,"is_pro_user":false}
     * is_can_share : 1
     * category_type : 1
     * share_url : http://m.neihanshequ.com/share/group/59853006104/?iid=3216590132&app=joke_essay
     * label : 4
     * content : 老公姓李，老婆姓周。老婆生了个双胞胎，老丈人向女婿提要求了：1，给孩子取名字一个姓周，一个姓李[害羞][害羞]；2，取名字要有纪念意义；3，两个名字要同一个意思[冷汗][冷汗]！今天女婿告诉老丈人，名字取好了……一个叫周末；一个叫李拜天。老丈人无话可说，开了瓶茅台酒………语重心长的说：祝周末李拜天愉快！[偷笑]哈哈，祝周末愉快[呲牙]
     * comment_count : 0
     * id_str : 59853006104
     * media_type : 0
     * share_count : 1
     * type : 3
     * status : 102
     * has_comments : 0
     * user_bury : 0
     * activity : {}
     * status_desc : 已发表，粉丝第一时间可见
     * quick_comment : false
     * display_type : 0
     * neihan_hot_end_time : 00-00-00
     * user_digg : 0
     * online_time : 1494033932
     * category_name : 内涵段子
     * category_visible : true
     * bury_count : 0
     * is_anonymous : false
     * repin_count : 0
     * is_neihan_hot : false
     * digg_count : 12
     * has_hot_comments : 0
     * allow_dislike : true
     * user_repin : 0
     * neihan_hot_link : {}
     * group_id : 59853006104
     * category_id : 1
     */

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
        /**
         * user_id : 50249249014
         * name : 开心宝贝126087256
         * followings : 0
         * user_verified : false
         * ugc_count : 14
         * avatar_url : http://p1.pstatp.com/medium/1782000bcdae97400846
         * followers : 33
         * is_following : false
         * is_pro_user : false
         */

        private long user_id;
        private String name;
        private int followings;
        private boolean user_verified;
        private int ugc_count;
        private String avatar_url;
        private int followers;
        private boolean is_following;
        private boolean is_pro_user;

        public long getUser_id() {
            return user_id;
        }

        public void setUser_id(long user_id) {
            this.user_id = user_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getFollowings() {
            return followings;
        }

        public void setFollowings(int followings) {
            this.followings = followings;
        }

        public boolean isUser_verified() {
            return user_verified;
        }

        public void setUser_verified(boolean user_verified) {
            this.user_verified = user_verified;
        }

        public int getUgc_count() {
            return ugc_count;
        }

        public void setUgc_count(int ugc_count) {
            this.ugc_count = ugc_count;
        }

        public String getAvatar_url() {
            return avatar_url;
        }

        public void setAvatar_url(String avatar_url) {
            this.avatar_url = avatar_url;
        }

        public int getFollowers() {
            return followers;
        }

        public void setFollowers(int followers) {
            this.followers = followers;
        }

        public boolean isIs_following() {
            return is_following;
        }

        public void setIs_following(boolean is_following) {
            this.is_following = is_following;
        }

        public boolean isIs_pro_user() {
            return is_pro_user;
        }

        public void setIs_pro_user(boolean is_pro_user) {
            this.is_pro_user = is_pro_user;
        }
    }
}

package com.example.developerhaoz.sleephelper.diary.bean;

/**
 * 日记的实体类
 *
 * Created by developerHaoz on 2017/5/3.
 */

public class DiaryBean {
    private String date;
    private String title;
    private String content;
    private String tag;

    public DiaryBean(String date, String title, String content, String tag) {
        this.date = date;
        this.title = title;
        this.content = content;
        this.tag = tag;
    }
    public String getTag() {
        return tag;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

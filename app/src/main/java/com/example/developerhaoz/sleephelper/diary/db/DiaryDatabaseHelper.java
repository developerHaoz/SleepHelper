package com.example.developerhaoz.sleephelper.diary.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 数据库的帮助类
 *
 * Created by developerHaoz on 2017/5/3.
 */

public class DiaryDatabaseHelper extends SQLiteOpenHelper{

    private Context mContext;

    private static final String CREATE_DIARY = "create table Diary("
            + "id integer primary key autoincrement, "
            + "date text, "
            + "title text, "
            + "tag text, "
            + "content text)";



    public DiaryDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        this.mContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DIARY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists Diary");
        onCreate(db);
    }
}

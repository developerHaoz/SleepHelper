package com.example.developerhaoz.sleephelper.diary.ui;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.developerhaoz.sleephelper.R;
import com.example.developerhaoz.sleephelper.common.HomeActivity;
import com.example.developerhaoz.sleephelper.diary.db.DiaryDatabaseHelper;
import com.example.developerhaoz.sleephelper.diary.utils.AppManager;
import com.example.developerhaoz.sleephelper.diary.utils.GetDate;
import com.example.developerhaoz.sleephelper.diary.widget.LinedEditText;
import com.example.developerhaoz.sleephelper.utils.common.StatusBarCompat;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cc.trity.floatingactionbutton.FloatingActionButton;
import cc.trity.floatingactionbutton.FloatingActionsMenu;

/**
 * 添加日记的 Activity
 *
 * Created by developerHaoz on 2017/5/3.
 */

public class AddDiaryActivity extends AppCompatActivity {


    @Bind(R.id.add_diary_tv_date)
    TextView mAddDiaryTvDate;
    @Bind(R.id.add_diary_et_title)
    EditText mAddDiaryEtTitle;
    @Bind(R.id.add_diary_et_content)
    LinedEditText mAddDiaryEtContent;
    @Bind(R.id.add_diary_fab_back)
    FloatingActionButton mAddDiaryFabBack;
    @Bind(R.id.add_diary_fab_add)
    FloatingActionButton mAddDiaryFabAdd;

    @Bind(R.id.right_labels)
    FloatingActionsMenu mRightLabels;


    private DiaryDatabaseHelper mHelper;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, AddDiaryActivity.class);
        context.startActivity(intent);
    }

    public static void startActivity(Context context, String title, String content) {
        Intent intent = new Intent(context, AddDiaryActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("content", content);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_diary);
        AppManager.getAppManager().addActivity(this);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        mAddDiaryEtTitle.setText(intent.getStringExtra("title"));
        StatusBarCompat.compat(this, Color.parseColor("#161414"));

        mAddDiaryTvDate.setText("今天，" + GetDate.getDate());
        mAddDiaryEtContent.setText(intent.getStringExtra("content"));
        mHelper = new DiaryDatabaseHelper(this, "Diary.db", null, 1);
    }


    @OnClick({ R.id.add_diary_et_title, R.id.add_diary_et_content, R.id.add_diary_fab_back, R.id.add_diary_fab_add})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_diary_et_title:
                break;
            case R.id.add_diary_et_content:
                break;
            case R.id.add_diary_fab_back:
                String date = GetDate.getDate().toString();
                String tag = String.valueOf(System.currentTimeMillis());
                String title = mAddDiaryEtTitle.getText().toString() + "";
                String content = mAddDiaryEtContent.getText().toString() + "";
                if (!title.equals("") || !content.equals("")) {
                    SQLiteDatabase db = mHelper.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    values.put("date", date);
                    values.put("title", title);
                    values.put("content", content);
                    values.put("tag", tag);
                    db.insert("Diary", null, values);
                    values.clear();
                }
                HomeActivity.startActivity(AddDiaryActivity.this);
                break;
            case R.id.add_diary_fab_add:
                final String dateBack = GetDate.getDate().toString();
                final String titleBack = mAddDiaryEtTitle.getText().toString();
                final String contentBack = mAddDiaryEtContent.getText().toString();
                if(!titleBack.isEmpty() || !contentBack.isEmpty()){
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                    alertDialogBuilder.setMessage("是否保存日记内容？").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            SQLiteDatabase db = mHelper.getWritableDatabase();
                            ContentValues values = new ContentValues();
                            values.put("date", dateBack);
                            values.put("title", titleBack);
                            values.put("content", contentBack);
                            db.insert("Diary", null, values);
                            values.clear();
                            HomeActivity.startActivity(AddDiaryActivity.this);
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            HomeActivity.startActivity(AddDiaryActivity.this);
                        }
                    }).show();
                }else{
                    HomeActivity.startActivity(AddDiaryActivity.this);
                }

                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        HomeActivity.startActivity(AddDiaryActivity.this);
    }
}

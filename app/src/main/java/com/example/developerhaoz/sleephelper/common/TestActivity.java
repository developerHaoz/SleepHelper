package com.example.developerhaoz.sleephelper.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.developerhaoz.sleephelper.R;

/**
 * 用于测试的 Activity
 *
 * Created by developerHaoz on 2017/5/3.
 */

public class TestActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Button mBtnTest = (Button) findViewById(R.id.test_btn_test);
        mBtnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity.startActivity(TestActivity.this);
            }
        });
    }





}

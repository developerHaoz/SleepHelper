package com.example.developerhaoz.sleephelper.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.developerhaoz.sleephelper.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import uk.co.senab.photoview.PhotoView;

/**
 * 用于测试的 Activity
 * <p>
 * Created by developerHaoz on 2017/5/3.
 */

public class TestActivity extends AppCompatActivity {

    @Bind(R.id.test_pv_show_photo)
    PhotoView mPvShowPhoto;

    private static final String IMAGE_URL = "imageUrl";

    public static void startActivity(Context context, String imageUrl, int position) {
        Intent intent = new Intent(context, TestActivity.class);
        intent.putExtra(IMAGE_URL, imageUrl);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);


    }

}
































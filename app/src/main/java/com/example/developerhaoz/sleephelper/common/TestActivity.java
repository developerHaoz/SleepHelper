package com.example.developerhaoz.sleephelper.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.developerhaoz.sleephelper.R;

import butterknife.ButterKnife;

/**
 * 用于测试的 Activity
 * <p>
 * Created by developerHaoz on 2017/5/3.
 */

public class TestActivity extends AppCompatActivity {

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
        ImageView mIvVideo = (ImageView) findViewById(R.id.test_iv_video);
        Glide.with(this).load("http://p3.pstatp.com/large/1fd90000bdf1766aaa29")
                .into(mIvVideo);

//        Task.call(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                String testUrl = "http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-07-032924.jpg";
//                return GlideHelper.getImagePathFromCache(testUrl,TestActivity.this);
//            }
//        }, Task.BACKGROUND_EXECUTOR).continueWith(new Continuation<String, Object>() {
//            @Override
//            public Object then(Task<String> task) throws Exception {
//                String result = task.getResult();
//                Logger.d(result);
//                Glide.with(TestActivity.this)
//                        .load(result)
//                        .into(mPvShowPhoto);
//                return null;
//            }
//        }, Task.UI_THREAD_EXECUTOR);

    }



}
































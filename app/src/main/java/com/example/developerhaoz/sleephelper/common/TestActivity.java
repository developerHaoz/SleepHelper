package com.example.developerhaoz.sleephelper.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.developerhaoz.sleephelper.R;
import com.example.developerhaoz.sleephelper.common.view.GlideHelper;
import com.orhanobut.logger.Logger;

import java.util.concurrent.Callable;

import bolts.Continuation;
import bolts.Task;
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

        Task.call(new Callable<String>() {
            @Override
            public String call() throws Exception {
                String testUrl = "http://7xi8d6.com1.z0.glb.clouddn.com/2017-02-07-032924.jpg";
                return GlideHelper.getImagePathFromCache(testUrl,TestActivity.this);
            }
        }, Task.BACKGROUND_EXECUTOR).continueWith(new Continuation<String, Object>() {
            @Override
            public Object then(Task<String> task) throws Exception {
                String result = task.getResult();
                Logger.d(result);
                Glide.with(TestActivity.this)
                        .load(result)
                        .into(mPvShowPhoto);
                return null;
            }
        }, Task.UI_THREAD_EXECUTOR);

//        VolleyHelper.sendHttpGet(this, MeiziApi.getMeiziApi(), new VolleyResponseCallback() {
//            @Override
//            public void onSuccess(String s) {
//                String imageUrl = GsonHelper.getMeiziBean(s).get(0).getImageUrl();
//                Logger.d(imageUrl);
//                Glide.with(TestActivity.this)
//                        .load(imageUrl)
//                        .diskCacheStrategy(DiskCacheStrategy.ALL)
//                        .into(mPvShowPhoto);
//            }
//
//            @Override
//            public void onError(VolleyError error) {
//
//            }
//        });
    }



}
































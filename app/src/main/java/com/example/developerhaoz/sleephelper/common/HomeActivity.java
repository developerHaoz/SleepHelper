package com.example.developerhaoz.sleephelper.common;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ContentFrameLayout;

import com.example.developerhaoz.sleephelper.R;


/**
 * Created by developerHaoz
 */
public class HomeActivity extends AppCompatActivity {

    private static final int[] SELECTED_ICONS = new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private static final int[] UN_SELECTED_ICONS = new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private static final String[] TITLES = new String[]{"日记", "段子", "妹子"};

    public static void startActivity(Context context){
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}






























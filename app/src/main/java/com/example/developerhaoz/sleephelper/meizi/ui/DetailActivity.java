package com.example.developerhaoz.sleephelper.meizi.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.developerhaoz.sleephelper.R;
import com.example.developerhaoz.sleephelper.common.CommonPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 查看大图的 Activity
 *
 * Created by developerHaoz on 2017/5/5.
 */

public class DetailActivity extends AppCompatActivity {

    private List<String> mImageUrlList;
    private List<Fragment> mFragments;
    private static final String IMAGE_URL_LIST = "imageUrlList";
    private static final String POSITION = "position";

    @Bind(R.id.detail_vp_show_photo)
    ViewPager mVpShowPhoto;

    public static void startActivity(Context context, ArrayList<String> imageUrlList, int position) {
        Intent intent = new Intent(context, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(IMAGE_URL_LIST, imageUrlList);
        bundle.putInt(POSITION, -1);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();

        mImageUrlList = new ArrayList<>();
        mFragments = new ArrayList<>();
        int position = getIntent().getIntExtra(POSITION, -1);
        mImageUrlList = getIntent().getStringArrayListExtra(IMAGE_URL_LIST);


        for (String imageUrl : mImageUrlList) {
            DetailFragment fragment = DetailFragment.newInstance(imageUrl);
            mFragments.add(fragment);
            CommonPagerAdapter adapter = new CommonPagerAdapter(getSupportFragmentManager(), mFragments);
            mVpShowPhoto.setAdapter(adapter);
        }

    }
}





























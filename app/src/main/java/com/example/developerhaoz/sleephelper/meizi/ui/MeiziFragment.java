package com.example.developerhaoz.sleephelper.meizi.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.VolleyError;
import com.example.developerhaoz.sleephelper.R;
import com.example.developerhaoz.sleephelper.common.net.VolleyHelper;
import com.example.developerhaoz.sleephelper.common.net.VolleyResponseCallback;
import com.example.developerhaoz.sleephelper.meizi.api.MeiziApi;
import com.example.developerhaoz.sleephelper.meizi.bean.MeiziBean;
import com.example.developerhaoz.sleephelper.meizi.utils.GsonHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 有关妹子的 Fragment
 * <p>
 * Created by developerHaoz on 2017/5/2.
 */

public class MeiziFragment extends Fragment {

    @Bind(R.id.meizi_rv_show_meizi)
    RecyclerView mRvShowMeizi;
    @Bind(R.id.meizi_refresh)
    SwipeRefreshLayout mRefresh;

    List<MeiziBean> meiziBeanList = new ArrayList<>();
    private static String response = "";

    public static MeiziFragment newInstance() {
        return new MeiziFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meizi, container, false);
        ButterKnife.bind(this, view);
        initView();
        refreshMeizi();
        return view;
    }

    /**
     * 刷新当前界面
     */
    private void refreshMeizi() {
        mRefresh.setColorSchemeResources(R.color.colorPrimary);
        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initView();
                mRefresh.setRefreshing(false);
            }
        });
    }

    private void initView() {

        VolleyHelper.sendHttpGet(getActivity(), MeiziApi.getMeiziApi(), new VolleyResponseCallback() {
            @Override
            public void onSuccess(String s) {
                response = s;
                meiziBeanList = GsonHelper.getMeiziBean(response);
                mRvShowMeizi.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                mRvShowMeizi.setAdapter(new MeiziAdapter(meiziBeanList, MeiziFragment.this));
            }

            @Override
            public void onError(VolleyError error) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}















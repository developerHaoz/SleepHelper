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

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.developerhaoz.sleephelper.R;
import com.example.developerhaoz.sleephelper.meizi.api.MeiziApi;
import com.example.developerhaoz.sleephelper.meizi.bean.MeiziBean;
import com.example.developerhaoz.sleephelper.meizi.utils.GsonHelper;
import com.orhanobut.logger.Logger;

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

    String testUrl = "http://ww3.sinaimg.cn/large/7a8aed7bgw1eswencfur6j20hq0qodhs.jpg";
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

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(MeiziApi.getMeiziApi(), new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                response = s;
                meiziBeanList = GsonHelper.getMeiziBean(response);
                mRvShowMeizi.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                mRvShowMeizi.setAdapter(new MeiziAdapter(meiziBeanList, MeiziFragment.this));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Logger.d(error);
            }
        });
        requestQueue.add(stringRequest);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}















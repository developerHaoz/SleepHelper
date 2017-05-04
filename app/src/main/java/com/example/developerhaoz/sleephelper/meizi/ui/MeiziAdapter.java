package com.example.developerhaoz.sleephelper.meizi.ui;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.developerhaoz.sleephelper.R;
import com.example.developerhaoz.sleephelper.meizi.bean.MeiziBean;

import java.util.List;

/**
 * Created by developerHaoz on 2017/5/3.
 */

public class MeiziAdapter extends RecyclerView.Adapter<MeiziAdapter.MeiziViewHolder> {

    private List<MeiziBean> mMeiziBeanList;
    private Fragment mFragment;

    public MeiziAdapter(List<MeiziBean> mMeiziBeanList, Fragment mFragment){
        this.mMeiziBeanList = mMeiziBeanList;
        this.mFragment = mFragment;
    }

    @Override
    public MeiziViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meizi, null);
        MeiziViewHolder meiziViewHolder = new MeiziViewHolder(view);
        return meiziViewHolder;
    }

    @Override
    public void onBindViewHolder(MeiziViewHolder holder, int position) {

        ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();

        Glide.with(mFragment)
                .load(mMeiziBeanList.get(position).getImageUrl())
//                .override(200, 100)
                .into(holder.mIvMeizi);


    }

    @Override
    public int getItemCount() {
        if(mMeiziBeanList.size() > 0){
            return mMeiziBeanList.size();
        }
        return 0;
    }

    public static class MeiziViewHolder extends RecyclerView.ViewHolder{

        ImageView mIvMeizi;

        public MeiziViewHolder(View itemView) {
            super(itemView);
            mIvMeizi = (ImageView) itemView.findViewById(R.id.item_iv_meizi);
        }
    }
}

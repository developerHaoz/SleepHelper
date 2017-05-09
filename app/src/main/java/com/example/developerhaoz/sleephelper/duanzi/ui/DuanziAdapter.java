package com.example.developerhaoz.sleephelper.duanzi.ui;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.developerhaoz.sleephelper.R;
import com.example.developerhaoz.sleephelper.duanzi.bean.DuanziBean;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 段子界面的 Adapter
 *
 * Created by developerHaoz on 2017/5/7.
 */

public class DuanziAdapter extends RecyclerView.Adapter<DuanziAdapter.DuanziViewHolder>{

    private Fragment mFragment;
    private List<DuanziBean> mDuanziBeanList;

    public DuanziAdapter(Fragment fragment, List<DuanziBean> duanziBeanList){
        this.mFragment = fragment;
        this.mDuanziBeanList = duanziBeanList;
    }

    @Override
    public DuanziViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_duanzi, null);
        return new DuanziViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DuanziViewHolder holder, int position) {
        try {
            DuanziBean duanziBean = mDuanziBeanList.get(position);
            Glide.with(mFragment).load(duanziBean.getGroupBean().getUser().getAvatar_url()).into(holder.mCivAvatar);
            holder.mTvContent.setText(duanziBean.getGroupBean().getText());
            holder.mTvAuthor.setText(duanziBean.getGroupBean().getUser().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return mDuanziBeanList.size();
    }

    public static class DuanziViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView mCivAvatar;
        private TextView mTvAuthor;
        private TextView mTvContent;

        public DuanziViewHolder(View itemView) {
            super(itemView);
            mCivAvatar = (CircleImageView) itemView.findViewById(R.id.duanzi_civ_avatar);
            mTvAuthor = (TextView) itemView.findViewById(R.id.duanzi_tv_author);
            mTvContent = (TextView) itemView.findViewById(R.id.duanzi_tv_content);
        }
    }


}

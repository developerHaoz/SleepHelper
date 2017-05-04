package com.example.developerhaoz.sleephelper.duanzi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.developerhaoz.sleephelper.R;

/**
 * 有关段子的 Fragment
 *
 * Created by developerHaoz on 2017/5/2.
 */

public class DuanziFragment extends Fragment {

    public static DuanziFragment newInstance(){
        return new DuanziFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_duanzi, container, false);
    }
}

package com.example.developerhaoz.sleephelper.diary.event;

import com.example.developerhaoz.sleephelper.diary.bean.DiaryBean;

/**
 * 打开「修改日记」的界面
 *
 * Created by developerHaoz on 2017/5/3.
 */

public class StartUpdateDiaryEvent {

    private DiaryBean mDiaryBean;

    public StartUpdateDiaryEvent(DiaryBean diaryBean) {
        mDiaryBean = diaryBean;
    }

    public DiaryBean getDiaryBean() {
        return mDiaryBean;
    }
}

package com.example.developerhaoz.sleephelper.common.view;

import com.flyco.tablayout.listener.CustomTabEntity;

/**
 *
 *
 * Created by developerHaoz on 2017/5/3.
 */

public class CommonTabBean implements CustomTabEntity{

    private int selectedIcon;
    private int unselectedIcon;
    private String title;

    public CommonTabBean(String title){
        this.title = title;
    }

    public CommonTabBean(String title, int selectedIcon, int unselectedIcon) {
        this.title = title;
        this.selectedIcon = selectedIcon;
        this.unselectedIcon = unselectedIcon;
    }

    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unselectedIcon;
    }
}



















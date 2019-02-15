package com.github.king.android_stickynavlayout;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by jinxl on 2016/11/18.
 */
public class BaseViewPageAdapter extends FragmentPagerAdapter {
    private List<String> tabs;
    private List<Fragment> pagers;
    private Context context;

    public BaseViewPageAdapter(Context context, FragmentManager fm, List<String> tabs,
                               List<Fragment> pagers) {
        super(fm);
        this.tabs = tabs;
        this.pagers = pagers;
        this.context = context;
    }

    /**
     * 返回每一页需要的fragment
     */
    @Override
    public Fragment getItem(int position) {
        return pagers.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    /**
     * 返回每一页对应的title
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position);
    }

}
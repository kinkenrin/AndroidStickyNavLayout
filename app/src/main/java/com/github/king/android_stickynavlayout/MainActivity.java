package com.github.king.android_stickynavlayout;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.king.android_stickynavlayout.view.SimpleViewPagerIndicator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SimpleViewPagerIndicator mIndicator;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        mIndicator = (SimpleViewPagerIndicator) findViewById(R.id.id_stickynavlayout_indicator);
//        mViewPager = (ViewPager) findViewById(R.id.id_stickynavlayout_viewpager);

        /*List<String> tabNameList = new ArrayList<>();
        tabNameList.add("页面一");
        tabNameList.add("页面二");
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new Pager1());
        fragmentList.add(new Pager1());
        BaseViewPageAdapter adapter = new BaseViewPageAdapter
                (getApplicationContext(), getSupportFragmentManager(), tabNameList, fragmentList);
        mViewPager.setAdapter(adapter);*/

    }

    public void btnClick4(View view) {
        startActivity(new Intent(this, StCoorToolBarActivity.class));
    }
}

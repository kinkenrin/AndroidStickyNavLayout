package com.github.king.android_stickynavlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.github.king.android_stickynavlayout.view.SimpleViewPagerIndicator;

import java.util.ArrayList;
import java.util.List;

public class StCoorToolBarActivity extends AppCompatActivity {

    private LinearLayout mIndicator;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);


        mIndicator =  findViewById(R.id.id_stickynavlayout_indicator);
        mViewPager = (ViewPager) findViewById(R.id.id_stickynavlayout_viewpager);

        List<String> tabNameList = new ArrayList<>();
        tabNameList.add("页面一");
        tabNameList.add("页面二");
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new Pager1());
        fragmentList.add(new Pager1());
        BaseViewPageAdapter adapter = new BaseViewPageAdapter
                (getApplicationContext(), getSupportFragmentManager(), tabNameList, fragmentList);
        mViewPager.setAdapter(adapter);

    }


    public static class Pager1 extends Fragment {
        private RecyclerView mRecyclerView;
        private CommonRecyclerAdapter<String> mAdapter;
        private List<String> mStringList;
        private ViewPager mVp_pager;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = View.inflate(getContext(),R.layout.layout_pager1, null);

            return view;
        }


        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            View rootView = getView();
            if (rootView == null) {
                return;
            }
            mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
            mRecyclerView.setItemAnimator(new DefaultItemAnimator());

            mStringList = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                mStringList.add("测试：" + i);
            }

            mAdapter = new CommonRecyclerAdapter<String>(getContext(), mStringList, R.layout.layout_item) {
                @Override
                public void convert(CommonRecyclerHolder holder, String item, int position, boolean isScrolling) {
                    holder.setText(R.id.item_text, mStringList.get(position));
                }
            };

            mRecyclerView.setAdapter(mAdapter);

            mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        }
    }


}

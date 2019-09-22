package com.github.king.android_stickynavlayout;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class AppBarActivity extends AppCompatActivity {

    private TabLayout mIndicator;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager2);

        mIndicator = findViewById(R.id.id_stickynavlayout_indicator);
        mViewPager = findViewById(R.id.id_stickynavlayout_viewpager);

        List<String> tabNameList = new ArrayList<>();
        tabNameList.add("页面一");
        tabNameList.add("页面二");
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new Pager1());
        fragmentList.add(new Pager1());
        BaseViewPageAdapter adapter = new BaseViewPageAdapter
                (getApplicationContext(), getSupportFragmentManager(), tabNameList, fragmentList);
        mViewPager.setAdapter(adapter);
        mIndicator.setupWithViewPager(mViewPager);
    }


    public static class Pager1 extends Fragment {
        private RecyclerView mRecyclerView;
        private CommonRecyclerAdapter<String> mAdapter;
        private List<String> mStringList;
        private ViewPager mVp_pager;
        private LinearLayoutManager mLinearLayoutManager;
        private View v_tags2;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = View.inflate(getContext(), R.layout.layout_pager1, null);

            return view;
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            View rootView = getView();
            if (rootView == null) {
                return;
            }
            mRecyclerView = rootView.findViewById(R.id.recycler);
            v_tags2 = rootView.findViewById(R.id.v_tags2);
            mRecyclerView.setItemAnimator(new DefaultItemAnimator());
            mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                private int scrollState;
                private int deltaY;

                @Override
                public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                    scrollState = newState;
                }

                @Override
                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                    final int firstVisibleItemPosition = mLinearLayoutManager.findFirstVisibleItemPosition();
                    if (mLinearLayoutManager != null && firstVisibleItemPosition == 0) {
                        View firstView = mLinearLayoutManager.findViewByPosition(0);
                        if (firstView != null) {
                            if (firstView.getBottom() < v_tags2.getBottom()) {
                                v_tags2.setAlpha(1);
                            } else {
                                v_tags2.setAlpha(0);
                            }
                        } else {
                            v_tags2.setAlpha(1);
                        }
                    }

                }
            });

            mStringList = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                if (i == 0) {
                    mStringList.add("标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签标签");
                } else {

                    mStringList.add("测试：" + i);
                }
            }

            mAdapter = new CommonRecyclerAdapter<String>(getContext(), mStringList, R.layout.layout_item) {
                @Override
                public void convert(CommonRecyclerHolder holder, String item, int position, boolean isScrolling) {
                    final ViewGroup.LayoutParams layoutParams = holder.getView(R.id.item_text).getLayoutParams();
                    if (position == 0) {
                        layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 88, getContext().getResources().getDisplayMetrics());
                    } else {
                        layoutParams.height = ActionBar.LayoutParams.WRAP_CONTENT;
                    }
                    holder.setText(R.id.item_text, mStringList.get(position));
                }
            };

            mRecyclerView.setAdapter(mAdapter);
            mLinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            mRecyclerView.setLayoutManager(mLinearLayoutManager);
        }
    }

}

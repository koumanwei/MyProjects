package com.koumanwei.enjoy.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.koumanwei.enjoy.R;
import com.koumanwei.enjoy.adapter.GridViewAdapter;
import com.koumanwei.enjoy.adapter.ViewPagerAdapter;
import com.koumanwei.enjoy.bean.GridData;
import com.koumanwei.enjoy.view.LocalImageHolderView;
import com.koumanwei.enjoy.view.ObservableScrollView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by koumanwei on 2016-06-12.
 */

public class HomeFragment extends Fragment {

    @BindView(R.id.convenientBanner)
    ConvenientBanner convenientBanner;
    @BindView(R.id.scrollView)
    ObservableScrollView scrollView;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.ll_dot)
    LinearLayout llDot;
    private GridView gridView0;
    private GridView gridView1;
    private View homeLayout;
    private List<Integer> localImages = new ArrayList<>();
    private int bannerHeight;
    private int titleHeight;
    /**
     * viewPager需要的view集合
     */
    private List<View> viewList = new ArrayList<>();
    /**
     * viewPager的第一个view
     */
    private View view0;
    /**
     * viewPager的第二个view
     */
    private View view1;
    /**
     * 第一个viewPager中包含的gridView需要的数据集合
     */
    private List<GridData> dataList0 = new ArrayList<>();
    /**
     * 第二个viewPager中包含的gridView需要的数据集合
     */
    private List<GridData> dataList1 = new ArrayList<>();
    private static final String[] texts = new String[]{
            "KTV", "喝酒", "吃饭", "火锅",
            "看电影", "游戏", "放松", "High翻天",
            "游泳", "超市", "下午茶", "咖啡",
            "土豪馆", "抽奖"
    };
    private static final int[] images = new int[]{
            R.mipmap.gv_item0, R.mipmap.gv_item1, R.mipmap.gv_item2, R.mipmap.gv_item3,
            R.mipmap.gv_item4, R.mipmap.gv_item5, R.mipmap.gv_item6, R.mipmap.gv_item7,
            R.mipmap.gv_item8, R.mipmap.gv_item9, R.mipmap.gv_item10, R.mipmap.gv_item11,
            R.mipmap.gv_item12, R.mipmap.gv_item13
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homeLayout = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, homeLayout);
        initView();
        initBanner();
        initScrollView();
        return homeLayout;
    }

    private void initView() {
        view0 = View.inflate(getActivity(), R.layout.view_pager0, null);
        view1 = View.inflate(getActivity(), R.layout.view_pager1, null);
        gridView0 = (GridView) view0.findViewById(R.id.grid_view0);
        gridView1 = (GridView) view1.findViewById(R.id.grid_view1);
        viewList.add(view0);
        viewList.add(view1);
        dataList0.add(new GridData(images[0], texts[0]));
        dataList0.add(new GridData(images[1], texts[1]));
        dataList0.add(new GridData(images[2], texts[2]));
        dataList0.add(new GridData(images[3], texts[3]));
        dataList0.add(new GridData(images[4], texts[4]));
        dataList0.add(new GridData(images[5], texts[5]));
        dataList0.add(new GridData(images[6], texts[6]));
        dataList0.add(new GridData(images[7], texts[7]));
        dataList1.add(new GridData(images[8], texts[8]));
        dataList1.add(new GridData(images[9], texts[9]));
        dataList1.add(new GridData(images[10], texts[10]));
        dataList1.add(new GridData(images[11], texts[11]));
        dataList1.add(new GridData(images[12], texts[12]));
        dataList1.add(new GridData(images[13], texts[13]));
        gridView0.setAdapter(new GridViewAdapter(getActivity(), dataList0));
        gridView1.setAdapter(new GridViewAdapter(getActivity(), dataList1));
        viewPager.setAdapter(new ViewPagerAdapter(viewList));
        initDot();
        updateDot();
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                updateDot();
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 监听滑动改变title的背景和字体的颜色
     */
    private void initScrollView() {
        ViewTreeObserver vto = convenientBanner.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                convenientBanner.getViewTreeObserver().removeOnGlobalLayoutListener(
                        this);
                bannerHeight = convenientBanner.getHeight();
                titleHeight = textView.getHeight();
                scrollView.setScrollViewListener(new ObservableScrollView.ScrollViewListener() {
                    @Override
                    public void onScrollChanged(ObservableScrollView scrollView, int l, int t, int oldl, int oldt) {
                        if (t <= 0) {
                            textView.setBackgroundColor(Color.argb(0, 251, 0, 91));
                            textView.setTextColor(Color.argb(0, 251, 255, 255));
                        } else if (t > 0 && t <= (bannerHeight - titleHeight)) {
                            float scale = (float) t / (bannerHeight - titleHeight);
                            float alpha = (255 * scale);
                            // 设置背景透明
                            textView.setBackgroundColor(Color.argb((int) alpha, 251, 0, 91));
                            textView.setTextColor(Color.argb((int) alpha, 251, 255, 255));
                        } else {
                            textView.setBackgroundColor(Color.argb(255, 251, 0, 91));
                            textView.setTextColor(Color.argb(255, 251, 255, 255));
                        }
                    }
                });
            }
        });
    }

    /**
     * 更新圆点指示器
     */
    private void updateDot() {
        int currentItem = viewPager.getCurrentItem();
        for (int i = 0; i < llDot.getChildCount(); i++) {
            //判断当前的点和viewPager的位置是否对应，对应就选中点
            llDot.getChildAt(i).setEnabled(i == currentItem);
        }
    }

    /**
     * 初始化圆点指示器
     */
    private void initDot() {
        for (int i = 0; i < viewList.size(); i++) {
            View view = new View(getActivity());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(24, 24);
            params.leftMargin = 24;
            view.setLayoutParams(params);
            view.setBackgroundResource(R.drawable.selector_dot);
            llDot.addView(view);
        }
    }

    private void initBanner() {
        localImages.add(R.mipmap.banner0);
        localImages.add(R.mipmap.banner1);
        localImages.add(R.mipmap.banner2);
        localImages.add(R.mipmap.banner3);
        localImages.add(R.mipmap.banner4);
        convenientBanner.setPages(
                new CBViewHolderCreator<LocalImageHolderView>() {
                    @Override
                    public LocalImageHolderView createHolder() {
                        return new LocalImageHolderView();
                    }
                }, localImages)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.drawable.shape_page_indicator, R.drawable.shape_page_indicator_selected})
                //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
    }

    // 开始自动翻页
    @Override
    public void onResume() {
        super.onResume();
        convenientBanner.startTurning(5000);
    }

    // 停止自动翻页
    @Override
    public void onPause() {
        super.onPause();
        convenientBanner.stopTurning();
    }

}
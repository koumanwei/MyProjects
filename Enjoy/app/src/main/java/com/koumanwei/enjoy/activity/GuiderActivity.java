package com.koumanwei.enjoy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.koumanwei.enjoy.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GuiderActivity extends AppCompatActivity {

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.ll_dot)
    LinearLayout llDot;
    @BindView(R.id.btn_start)
    Button btnStart;
    private int[] images = new int[]{
            R.mipmap.main_new_comer_guide_fg_1,
            R.mipmap.main_new_comer_guide_fg_2,
            R.mipmap.main_new_comer_guide_fg_3,
            R.mipmap.main_new_comer_guide_fg_4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guider);
        ButterKnife.bind(this);
        viewPager.setAdapter(new MyPagerAdapter());
        initDot();
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                updateDot();
                if (position == llDot.getChildCount() - 1) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
                    alphaAnimation.setDuration(1000);
                    btnStart.startAnimation(alphaAnimation);
                    btnStart.setVisibility(View.VISIBLE);
                } else {
                    btnStart.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        updateDot();
    }

    @OnClick(R.id.btn_start)
    public void enterMainActivity() {
        startActivity(new Intent(GuiderActivity.this, MainActivity.class));
        finish();
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
        for (int i = 0; i < images.length; i++) {
            View view = new View(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(24, 24);
            params.leftMargin = 24;
            view.setLayoutParams(params);
            view.setBackgroundResource(R.drawable.selector_dot);
            llDot.addView(view);
        }
    }

    /**
     * 自定义ViewPager适配器
     */
    class MyPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(GuiderActivity.this);
            imageView.setImageResource(images[position]);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}

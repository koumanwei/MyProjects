package com.koumanwei.enjoy.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.koumanwei.enjoy.R;
import com.koumanwei.enjoy.fragment.FindFragment;
import com.koumanwei.enjoy.fragment.HomeFragment;
import com.koumanwei.enjoy.fragment.MeFragment;
import com.koumanwei.enjoy.fragment.MessageFragment;
import com.koumanwei.enjoy.fragment.ShopFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.iv_home)
    ImageView ivHome;
    @BindView(R.id.tv_home)
    TextView tvHome;
    @BindView(R.id.ll_tab_home)
    LinearLayout llTabHome;
    @BindView(R.id.iv_message)
    ImageView ivMessage;
    @BindView(R.id.tv_message)
    TextView tvMessage;
    @BindView(R.id.ll_tab_message)
    LinearLayout llTabMessage;
    @BindView(R.id.iv_find)
    ImageView ivFind;
    @BindView(R.id.tv_find)
    TextView tvFind;
    @BindView(R.id.ll_tab_find)
    LinearLayout llTabFind;
    @BindView(R.id.iv_shop)
    ImageView ivShop;
    @BindView(R.id.tv_shop)
    TextView tvShop;
    @BindView(R.id.ll_tab_shop)
    LinearLayout llTabShop;
    @BindView(R.id.iv_me)
    ImageView ivMe;
    @BindView(R.id.tv_me)
    TextView tvMe;
    @BindView(R.id.ll_tab_me)
    LinearLayout llTabMe;
    private Fragment mHomeFragment;
    private Fragment mFindFragment;
    private Fragment mMeFragment;
    private Fragment mMessageFragment;
    private Fragment mShopFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();
        setTabSelection(0);
    }

    @OnClick(R.id.ll_tab_home)
    public void setLlTabHome() {
        setTabSelection(0);
    }

    @OnClick(R.id.ll_tab_message)
    public void setLlTabMessage() {
        setTabSelection(1);
    }

    @OnClick(R.id.ll_tab_find)
    public void setLlTabFind() {
        setTabSelection(2);
    }

    @OnClick(R.id.ll_tab_shop)
    public void setLlTabShop() {
        setTabSelection(3);
    }

    @OnClick(R.id.ll_tab_me)
    public void setLlTabMe() {
        setTabSelection(4);
    }

    /**
     * 根据传入的index来设置选中的tab页
     *
     * @param index
     */
    private void setTabSelection(int index) {
        clearSelection();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (index) {
            case 0:
                ivHome.setImageResource(R.mipmap.pic_home_selected);
                tvHome.setTextColor(ContextCompat.getColor(this, R.color.colorTabSelected));
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                    transaction.add(R.id.fl_content, mHomeFragment);
                } else {
                    transaction.show(mHomeFragment);
                }
                break;
            case 1:
                ivMessage.setImageResource(R.mipmap.pic_message_selected);
                tvMessage.setTextColor(ContextCompat.getColor(this, R.color.colorTabSelected));
                if (mMessageFragment == null) {
                    mMessageFragment = new MessageFragment();
                    transaction.add(R.id.fl_content, mMessageFragment);
                } else {
                    transaction.show(mMessageFragment);
                }
                break;
            case 2:
                ivFind.setImageResource(R.mipmap.pic_find_selected);
                tvFind.setTextColor(ContextCompat.getColor(this, R.color.colorTabSelected));
                if (mFindFragment == null) {
                    mFindFragment = new FindFragment();
                    transaction.add(R.id.fl_content, mFindFragment);
                } else {
                    transaction.show(mFindFragment);
                }
                break;
            case 3:
                ivShop.setImageResource(R.mipmap.pic_shop_selected);
                tvShop.setTextColor(ContextCompat.getColor(this, R.color.colorTabSelected));
                if (mShopFragment == null) {
                    mShopFragment = new ShopFragment();
                    transaction.add(R.id.fl_content, mShopFragment);
                } else {
                    transaction.show(mShopFragment);
                }
                break;
            case 4:
                ivMe.setImageResource(R.mipmap.pic_me_selected);
                tvMe.setTextColor(ContextCompat.getColor(this, R.color.colorTabSelected));
                if (mMeFragment == null) {
                    mMeFragment = new MeFragment();
                    transaction.add(R.id.fl_content, mMeFragment);
                } else {
                    transaction.show(mMeFragment);
                }
                break;
        }
        transaction.commit();
    }

    /**
     * 将所有的Fragment都置为隐藏状态
     *
     * @param transaction
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (mHomeFragment != null) {
            transaction.hide(mHomeFragment);
        }
        if (mFindFragment != null) {
            transaction.hide(mFindFragment);
        }
        if (mMeFragment != null) {
            transaction.hide(mMeFragment);
        }
        if (mMessageFragment != null) {
            transaction.hide(mMessageFragment);
        }
        if (mShopFragment != null) {
            transaction.hide(mShopFragment);
        }
    }

    /**
     * 清除所有的选中状态
     */
    private void clearSelection() {
        ivHome.setImageResource(R.mipmap.pic_home);
        tvHome.setTextColor(ContextCompat.getColor(this, R.color.colorTabNormal));
        ivFind.setImageResource(R.mipmap.pic_find);
        tvFind.setTextColor(ContextCompat.getColor(this, R.color.colorTabNormal));
        ivShop.setImageResource(R.mipmap.pic_shop);
        tvShop.setTextColor(ContextCompat.getColor(this, R.color.colorTabNormal));
        ivMessage.setImageResource(R.mipmap.pic_message);
        tvMessage.setTextColor(ContextCompat.getColor(this, R.color.colorTabNormal));
        ivMe.setImageResource(R.mipmap.pic_me);
        tvMe.setTextColor(ContextCompat.getColor(this, R.color.colorTabNormal));
    }

}

package com.koumanwei.enjoy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koumanwei.enjoy.R;

/**
 * Created by koumanwei on 2016-06-12.
 */

public class ShopFragment extends Fragment {

    private View shopLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        shopLayout = inflater.inflate(R.layout.fragment_shop, container, false);
        return shopLayout;
    }
}

package com.xiaoming.simplezhihu.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by ssthouse on 16/9/2.
 */
public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layoutId = getContentView();
        View rootView = inflater.inflate(layoutId, container, false);
        ButterKnife.bind(this, rootView);
        init();
        return rootView;
    }

    public abstract int getContentView();

    public abstract void init();
}

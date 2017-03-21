package com.zzg.object.fragment;

import android.support.v7.widget.RecyclerView;

import com.zzg.object.R;
import com.zzg.object.annotataion.ViewInject;
import com.zzg.object.base.BaseFragment;

/**
 * Created by apple on 2017/3/21.
 */

public class SecondFragment extends BaseFragment {
    @ViewInject(R.id.recycle)
    RecyclerView mRecycleView;
    @Override
    public int getLayoutId() {
        return R.layout.fragment_sencond;
    }

    @Override
    protected void initMethod() {

    }
}

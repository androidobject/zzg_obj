package com.bu54.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bu54.adapter.MainRecycleAdapter;
import com.bu54.annotataion.ViewInject;
import com.bu54.base.BaseFragment;
import com.bu54.canvas.R;
import com.bu54.interf.OnRecycleItemClickListener;
import com.bu54.model.MainModel;
import com.bu54.ui.CanvasActivity;
import com.bu54.ui.LoadLayoutDemo;
import com.bu54.ui.WaveActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * zzg
 */
public class FirstFragment extends BaseFragment implements OnRecycleItemClickListener {
    @ViewInject(R.id.recycle)
    RecyclerView recyclerView;
    private List<MainModel> mList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.fragment_first;
    }

    @Override
    protected void initMethod() {
        initData();
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        MainRecycleAdapter adapter = new MainRecycleAdapter(mList);
        adapter.setOnRecyclerViewListener(this);
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        mList.add(new MainModel("画板", "", 1));
        mList.add(new MainModel("加载动画", "", 1));
        mList.add(new MainModel("波浪", "", 1));
    }

    @Override
    public void click(int postion, Object o) {
        Intent intent = null;
        if (postion == 0) {
            intent = new Intent(getActivity(), CanvasActivity.class);
        } else if (postion == 1) {
            intent = new Intent(getActivity(), LoadLayoutDemo.class);
        }else if(postion==2){
            intent = new Intent(getActivity(), WaveActivity.class);
        }
        startActivity(intent);
    }
}

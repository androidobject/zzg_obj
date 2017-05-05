package com.zzg.object.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zzg.object.adapter.MainRecycleAdapter;
import com.zzg.object.annotataion.ViewInject;
import com.zzg.object.base.BaseFragment;
import com.zzg.object.R;
import com.zzg.object.interf.OnRecycleItemClickListener;
import com.zzg.object.model.MainModel;
import com.zzg.object.ui.CanvasActivity;
import com.zzg.object.ui.GestureDetectorActivity;
import com.zzg.object.ui.HttpTestActivity;
import com.zzg.object.ui.LoadLayoutDemo;
import com.zzg.object.ui.LoginActivity;
import com.zzg.object.ui.MagicLineActivity;
import com.zzg.object.ui.PatternLockActivity;
import com.zzg.object.ui.ScrollCardPagerActivity;
import com.zzg.object.ui.WaveActivity;

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
        MainRecycleAdapter adapter = new MainRecycleAdapter(mList, getActivity());
        adapter.setOnRecyclerViewListener(this);
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        mList.add(new MainModel("BannerView", "", 2));
        mList.add(new MainModel("画板", "", 1));
        mList.add(new MainModel("加载动画", "", 1));
        mList.add(new MainModel("波浪", "", 1));
        mList.add(new MainModel("魔法线", "", 1));
        mList.add(new MainModel("登陆", "", 1));
        mList.add(new MainModel("垂直滑动pager", "", 1));
        mList.add(new MainModel("手势", "", 1));
        mList.add(new MainModel("http请求", "", 1));
        mList.add(new MainModel("手势锁", "", 1));

    }

    @Override
    public void click(int postion, Object o) {
        Intent intent = null;
        if (postion == 0) {
//            intent = new Intent(getActivity(), CanvasActivity.class);
        }
        if (postion == 1) {
            intent = new Intent(getActivity(), CanvasActivity.class);
        } else if (postion == 2) {
            intent = new Intent(getActivity(), LoadLayoutDemo.class);
        } else if (postion == 3) {
            intent = new Intent(getActivity(), WaveActivity.class);
        } else if (postion == 4) {
            intent = new Intent(getActivity(), MagicLineActivity.class);
        } else if (postion == 5) {
            intent = new Intent(getActivity(), LoginActivity.class);
        } else if (postion == 6) {
            intent = new Intent(getActivity(), ScrollCardPagerActivity.class);
        } else if (postion == 7) {
            intent = new Intent(getActivity(), GestureDetectorActivity.class);
        } else if (postion == 8) {
            intent = new Intent(getActivity(), HttpTestActivity.class);
        }else if(postion==9){
            intent = new Intent(getActivity(), PatternLockActivity.class);
        }
        startActivity(intent);
    }
}

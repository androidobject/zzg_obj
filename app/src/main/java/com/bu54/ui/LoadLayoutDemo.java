package com.bu54.ui;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.bu54.annotataion.ViewInject;
import com.bu54.base.BaseActivity;
import com.bu54.canvas.R;
import com.bu54.view.LoadingLayout;

/**
 * 加载失败，重试
 */

public class LoadLayoutDemo extends BaseActivity {
    LoadingLayout loading;
    @ViewInject(R.id.toolbar)
    Toolbar mToolBar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_load_layout_demo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mToolBar.setTitle("加载失败");
        loading = (LoadingLayout) findViewById(R.id.loading);
        loading.setStatus(LoadingLayout.Loading);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                loading.setStatus(LoadingLayout.Empty);
            }
        }, 2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                loading.setStatus(LoadingLayout.Error);
            }
        }, 4000);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                loading.setStatus(LoadingLayout.No_Network);
            }
        }, 6000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                loading.setStatus(LoadingLayout.Success);
            }
        }, 8000);

    }
}

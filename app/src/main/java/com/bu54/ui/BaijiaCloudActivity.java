package com.bu54.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.bu54.annotataion.ViewInject;
import com.bu54.base.BaseActivity;
import com.bu54.canvas.R;

public class BaijiaCloudActivity extends BaseActivity {
    @ViewInject(R.id.toolbar)
    Toolbar mToolBar;
    @Override
    public int getLayoutId() {
        return R.layout.activity_baijia_cloud;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mToolBar.setTitle("百家云");
    }

}

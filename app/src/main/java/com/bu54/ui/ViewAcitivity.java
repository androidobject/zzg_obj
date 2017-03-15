package com.bu54.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.bu54.annotataion.ViewInject;
import com.bu54.base.BaseActivity;
import com.bu54.canvas.R;

/**
 * Created by apple on 2017/3/3.
 */
public class ViewAcitivity extends BaseActivity {
    @ViewInject(R.id.ll_Root)
    LinearLayout ll_Root;
    View view;
    @Override
    public int getLayoutId() {
        return R.layout.view_activity_layout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}

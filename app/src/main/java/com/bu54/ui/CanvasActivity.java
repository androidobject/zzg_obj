package com.bu54.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.bu54.base.BaseActivity;
import com.bu54.canvas.R;
import com.bu54.annotataion.ViewInject;
import com.bu54.view.CanvasView;

/**
 * 画板
 */
public class CanvasActivity extends BaseActivity {

    @ViewInject(R.id.btn_clear)
    private Button btn_clear;
    @ViewInject(R.id.canvas)
    private CanvasView canvas;
    @ViewInject(R.id.toolbar)
    Toolbar mToolBar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_canvas;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canvas.clear();
            }
        });
        mToolBar.setTitle("画板");
    }
}

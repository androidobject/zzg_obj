package com.zzg.object.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.zzg.object.annotataion.ViewInject;
import com.zzg.object.base.BaseActivity;
import com.zzg.object.R;
import com.zzg.object.view.WaveView;

public class WaveActivity extends BaseActivity {
    @ViewInject(R.id.image)
    private ImageView imageView;
    @ViewInject(R.id.wave_view)
    private WaveView waveView;

    @ViewInject(R.id.toolbar)
    Toolbar mToolBar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_wave;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mToolBar.setTitle("波浪");
        setSupportActionBar(mToolBar);
        final FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-2, -2);
        lp.gravity = Gravity.BOTTOM | Gravity.CENTER;
        waveView.setOnWaveAnimationListener(new WaveView.OnWaveAnimationListener() {
            @Override
            public void OnWaveAnimation(float y) {
                lp.setMargins(0, 0, 0, (int) y + 2);
                imageView.setLayoutParams(lp);
            }
        });
    }

}

package com.zzg.object.fragment;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.zzg.object.annotataion.ViewInject;
import com.zzg.object.base.BaseFragment;
import com.zzg.object.R;
import com.zzg.object.view.DownloadProgressButton;

/**
 * 关于
 */
public class FourFragment extends BaseFragment {
    @ViewInject(R.id.download_btn)
    DownloadProgressButton mDownloadProgressButton;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_four;
    }

    @Override
    protected void initMethod() {
        //显示边框
        mDownloadProgressButton.setShowBorder(true);
        //默认字体
        mDownloadProgressButton.setCurrentText("安装");
        //圆角大小
        mDownloadProgressButton.setButtonRadius(90);
        mDownloadProgressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTheButton();
            }
        });
    }




    private void showTheButton() {

        if (mDownloadProgressButton.getProgress() + 10 > 100) {
            mDownloadProgressButton.setState(DownloadProgressButton.STATE_FINISH);
            mDownloadProgressButton.setCurrentText("安装中");
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    mDownloadProgressButton.setState(DownloadProgressButton.STATE_NORMAL);
                    mDownloadProgressButton.setCurrentText("打开");
                }
            }, 2000);   //2秒

        }

        if (mDownloadProgressButton.getState() == DownloadProgressButton.STATE_NORMAL
                || mDownloadProgressButton.getState() == DownloadProgressButton.STATE_PAUSE) {
            mDownloadProgressButton.setState(DownloadProgressButton.STATE_DOWNLOADING);
            mDownloadProgressButton.setProgressText("下载中", mDownloadProgressButton.getProgress() + 8);
            return;
        }

        if (mDownloadProgressButton.getState() == DownloadProgressButton.STATE_DOWNLOADING) {
            mDownloadProgressButton.setState(DownloadProgressButton.STATE_PAUSE);
            mDownloadProgressButton.setCurrentText("继续");
            return;
        }


    }
}

package com.zzg.object.appcation;

import android.app.Application;
import com.zzg.object.R;
import com.zzg.object.view.LoadingLayout;



/**
 * Created by apple on 2016/11/18.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //网络加载状态初始化
        initConfig();
    }

    private void initConfig() {
        LoadingLayout.getConfig()
                .setErrorText("出错啦~请稍后重试！")
                .setEmptyText("抱歉，暂无数据")
                .setNoNetworkText("无网络连接，请检查您的网络···")
                .setErrorImage(R.mipmap.define_error)
                .setEmptyImage(R.mipmap.define_empty)
                .setNoNetworkImage(R.mipmap.define_nonetwork)
                .setAllTipTextColor(R.color.base_text_color_light)
                .setAllTipTextSize(14)
                .setReloadButtonText("点我重试哦")
                .setReloadButtonTextSize(14)
                .setReloadButtonTextColor(R.color.base_text_color_light)
                .setReloadButtonWidthAndHeight(150, 40)
                .setLoadingPageLayout(R.layout.define_loading_page);
    }


}

package com.bu54.appcation;

import android.app.Application;

//import com.baijiahulian.livecore.LiveSDK;
//import com.baijiahulian.livecore.context.LPConstants;
import com.bu54.canvas.R;
import com.bu54.crash.CrashHandler;
import com.bu54.view.LoadingLayout;
//import com.orhanobut.logger.Logger;
//
//import static com.orhanobut.logger.Logger.init;


/**
 * Created by apple on 2016/11/18.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //网络加载状态初始化
        initConfig();
        // catch捕获的异常
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);
        Thread.setDefaultUncaughtExceptionHandler(crashHandler);
        //初始化百家云直播sdk
//        LiveSDK.init("partnerId", LPConstants.LPDeployType.Product);
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

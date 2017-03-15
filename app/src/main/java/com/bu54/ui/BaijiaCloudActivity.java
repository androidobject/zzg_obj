package com.bu54.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.baijiahulian.common.cache.sp.SharePreferenceUtil;
import com.baijiahulian.common.utils.TimeUtils;
import com.baijiahulian.livecore.LiveSDK;
import com.baijiahulian.livecore.context.LPConstants;
import com.baijiahulian.livecore.utils.LPRxUtils;
import com.bu54.annotataion.ViewInject;
import com.bu54.base.BaseActivity;
import com.bu54.canvas.R;

import java.util.concurrent.TimeUnit;

import rx.Scheduler;
import rx.functions.Action1;

public class BaijiaCloudActivity extends BaseActivity {
    @ViewInject(R.id.toolbar)
    Toolbar mToolBar;
    //参加码
    @ViewInject(R.id.join_Code)
    private EditText joinCode;
    //昵称
    @ViewInject(R.id.pw_join_code)
    private EditText pw_join_code;
    @ViewInject(R.id.btnLogin)
    //进入
    private Button btnLogin;
    private SharePreferenceUtil mSharePreferenceUtil;

    private String JOIN_CODE = "join_code";
    private String USER_NAME = "user_name";

    @Override
    public int getLayoutId() {
        return R.layout.activity_baijia_cloud;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mToolBar.setTitle("百家云");
        initDate();
        //点击进入
        LPRxUtils.clicks(btnLogin)
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                String code = joinCode.getText().toString();
                String name = pw_join_code.getText().toString();
                if (TextUtils.isEmpty(code)) {
                    Toast.makeText(BaijiaCloudActivity.this, "请输入参加码", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(BaijiaCloudActivity.this, "请输入昵称", Toast.LENGTH_SHORT).show();
                    return;
                }
                mSharePreferenceUtil.putString(JOIN_CODE, code);
                mSharePreferenceUtil.putString(USER_NAME, name);
                Intent i = new Intent(BaijiaCloudActivity.this, BaijiayunLiveActivity.class);
                i.putExtra(JOIN_CODE, code);
                i.putExtra(USER_NAME, name);
                startActivity(i);
            }
        });

    }

    private void initDate() {
        mSharePreferenceUtil = new SharePreferenceUtil(this, "liveplayer_demo_sharepreference_file");
        //设置记录的参加吗和昵称
        String code = mSharePreferenceUtil.getStringValue(JOIN_CODE, "");
        if (!TextUtils.isEmpty(code)) {
            joinCode.setText(code);
        }
        String name = mSharePreferenceUtil.getStringValue(USER_NAME, "");
        if (!TextUtils.isEmpty(name)) {
            pw_join_code.setText(name);
        }
    }


}

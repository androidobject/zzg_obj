package com.zzg.object.ui;

import android.os.CountDownTimer;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import com.zzg.object.annotataion.ViewInject;
import com.zzg.object.base.BaseActivity;
import com.zzg.object.R;
import com.zzg.object.util.RegexUtils;
import com.zzg.object.util.ToastUtils;
import com.zzg.object.view.ClearEditTextView;

public class LoginActivity extends BaseActivity implements View.OnClickListener, TextWatcher {
    @ViewInject(R.id.phone_num_et)
    private ClearEditTextView mPhoneNum;
    @ViewInject(R.id.password_et)
    private ClearEditTextView mPassword;
    @ViewInject(R.id.msg_code_et)
    private ClearEditTextView mMsgCode;
    @ViewInject(R.id.msg_code_btn)
    private Button mSendMsgCode;
    @ViewInject(R.id.login_btn)
    private Button mLogin;
    @ViewInject(R.id.toolbar)
    Toolbar toolbar;
    private CountDownTimer mCountDownTimer;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar.setTitle("登陆页面");
        initView();
    }

    private void initView() {
        mSendMsgCode.setOnClickListener(this);
        mLogin.setOnClickListener(this);
        mPhoneNum.addTextChangedListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.msg_code_btn:
                startCountDownTimer(60 * 1000);
                break;
            case R.id.login_btn:
                startLogin();
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s.length() == 11) {
            if (RegexUtils.isMobileExact(s.toString().trim())) {
                mSendMsgCode.setEnabled(true);
            } else {
                mSendMsgCode.setEnabled(false);
                ToastUtils.showShortToast(this, "手机号码格式不正确！");
            }
        } else {
            mSendMsgCode.setEnabled(false);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    /**
     * 开始倒计时
     *
     * @param time (毫秒)
     */
    private void startCountDownTimer(long time) {
        mCountDownTimer = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (millisUntilFinished / 1000 == 55) {
                    mMsgCode.setText(String.valueOf(System.currentTimeMillis()).substring(9, 13));
                    mSendMsgCode.setText("发送验证码");
                    mCountDownTimer.cancel();
                } else {
                    mSendMsgCode.setText(millisUntilFinished / 1000 + " s");
                }
            }

            @Override
            public void onFinish() {
                mSendMsgCode.setText("发送验证码");
            }
        }.start();
    }

    private void startLogin() {
        String phoneNum = mPhoneNum.getText().toString().trim();
        String password = mPassword.getText().toString().trim();
        String msgCode = mMsgCode.getText().toString().trim();

        if (TextUtils.isEmpty(phoneNum) || !RegexUtils.isMobileExact(phoneNum)) {
            ToastUtils.showShortToast(this, "手机号码格式不正确！");
            mPhoneNum.startShake(3);
            return;
        }

        if (TextUtils.isEmpty(password) || password.length() < 6) {
            ToastUtils.showShortToast(this, "密码长度为6到20位字符！");
            mPassword.startShake(3);
            return;
        }

        if (TextUtils.isEmpty(msgCode) || msgCode.length() < 4) {
            ToastUtils.showShortToast(this, "请输入4位验证码！");
            mMsgCode.startShake(3);
            return;
        }
        ToastUtils.showShortToast(this, "登录成功！");

    }

}

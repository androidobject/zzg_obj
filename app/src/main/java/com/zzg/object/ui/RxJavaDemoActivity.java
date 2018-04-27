package com.zzg.object.ui;

import android.os.Bundle;
import android.util.Log;

import com.zzg.object.R;
import com.zzg.object.base.BaseActivity;

import io.reactivex.Observable;


public class RxJavaDemoActivity extends BaseActivity {

    String[] names={"张三","李四","王五","赵6"};

    @Override
    public int getLayoutId() {
        return R.layout.activity_rxjava_demo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    /**
     * rxjava 打印名字
     */
    public void rxjavademo1(){

//        Observable.from(names)
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String name) {
//                        Log.d("zzg", name);
//                    }
//                });






    }



}

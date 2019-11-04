package com.zzg.object.ui;

import android.os.Bundle;
import android.util.Log;

import com.zzg.object.R;
import com.zzg.object.base.BaseActivity;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;


public class RxJavaDemoActivity extends BaseActivity {

    String[] names={"张三","李四","王五","赵6"};

    @Override
    public int getLayoutId() {
        return R.layout.activity_rxjava_demo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rxjavademo1();
    }


    /**
     * rxjava 打印名字
     */
    public void rxjavademo1(){

        Observable<String> observable=Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {

            }
        });






    }



}

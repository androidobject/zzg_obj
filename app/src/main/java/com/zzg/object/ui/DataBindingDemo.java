package com.zzg.object.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zzg.object.R;
import com.zzg.object.databinding.ActivityBinddemoBinding;
import com.zzg.object.model.DataBindingModel;

import java.util.Observable;

import static java.lang.Thread.sleep;

/**
 * @author zzg
 * @time 2018/4/26-15:54
 * @Des 2、DataBinding的优点及不足
 * <p>
 * 优点:
 * <p>
 * 节省代码，省去了findViewById()
 * 兼容性高，兼容到Android2.1(API 7)
 * 支持绝大部分的 Java 写法
 * 支持lambda表达式
 * 不使用反射，保证了性能
 * 数据直接绑定在XML中
 * 最新的支持双向绑定
 * 支持在任意线程更新数据（列表类型除外）
 * 避免了因数据导致的空指针(null)
 * 缺点:
 * IDE支持还不那么完善（xml中代码自动补全大部分需要手写）
 * 报错信息不那么直接
 * 没有重构的支持
 * 需要遵循DataBinding的格式
 */
public class DataBindingDemo extends AppCompatActivity {
    private ActivityBinddemoBinding binddemoBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binddemoBinding = DataBindingUtil.setContentView(DataBindingDemo.this, R.layout.activity_binddemo);
        initView();


    }

    private void initView() {

        binddemoBinding.nickname.setText("112344");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    DataBindingModel model = new DataBindingModel("王三生三世", "sadf", "男", "20", "2017-2-1");

                    binddemoBinding.setUser(model);

                } catch (Exception e) {

                }

            }
        }).start();


    }
}

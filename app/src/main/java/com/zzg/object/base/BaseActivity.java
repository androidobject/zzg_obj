package com.zzg.object.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zzg.object.annotataion.ViewInject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2016/11/16.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private List<Activity> mActivitys = new ArrayList<>();

    /**
     * @return 布局id
     */
    public abstract int getLayoutId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mActivitys.add(this);
        autoInjectAllField();
        String string=new String();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mActivitys.remove(this);
    }

    public void finishAll() {
        for (Activity activity : mActivitys) {
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /**
     * 自动实例化注解view
     */
    public void autoInjectAllField() {
        try {
            Class<?> clazz = this.getClass();
            Field[] fields = clazz.getDeclaredFields();//获得Activity中声明的字段
            for (Field field : fields) {
                // 查看这个字段是否有我们自定义的注解类标志的
                if (field.isAnnotationPresent(ViewInject.class)) {
                    ViewInject inject = field.getAnnotation(ViewInject.class);
                    int id = inject.value();
                    if (id > 0) {
                        field.setAccessible(true);
                        field.set(this, this.findViewById(id));//给我们要找的字段设置值
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}

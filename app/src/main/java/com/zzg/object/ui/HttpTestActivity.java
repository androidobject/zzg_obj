package com.zzg.object.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.converter.GsonDiskConverter;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.model.HttpHeaders;
import com.zzg.object.R;
import com.zzg.object.annotataion.ViewInject;
import com.zzg.object.base.BaseActivity;
import com.zzg.object.util.LogUtils;
import com.zzg.object.util.ToastUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

public class HttpTestActivity extends BaseActivity {

    @ViewInject(R.id.http_button)
    Button http_button;

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private final OkHttpClient client = new OkHttpClient();
    String body = "{\"serviceName\":\"AUTH\",\"ip\":\"\",\"token\":\"\",\"client\":\"app\",\"channel\":\"\",\"" +
            "requestBody\":[\"keepMins\":\"180\",\"password\":\"111111\",\"phoneNumber\":\"18310863952\"]}";

    @Override
    public int getLayoutId() {
        return R.layout.activity_http_test;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        EasyHttp.get("/pl3.json")
                .baseUrl("http://f.apiplus.net/")//设置url
                .writeTimeOut(30 * 1000)//局部写超时30s,单位毫秒
                .readTimeOut(30 * 1000)//局部读超时30s,单位毫秒
//                .connectTimeout(30 * 1000)//局部连接超时30s,单位毫秒
//                .headers(new HttpHeaders("header1", "header1Value"))//添加请求头参数
//                .headers("header2", "header2Value")//支持添加多个请求头同时添加
//                .headers("header3", "header3Value")//支持添加多个请求头同时添加
//                .params("param1", "param1Value")//支持添加多个参数同时添加
//                .params("param2", "param2Value")//支持添加多个参数同时添加
                //.addCookie(new CookieManger(this).addCookies())//支持添加Cookie
//                .cacheTime(300)//缓存300s 单位s
//                .cacheKey("cachekey")//缓存key
//                .cacheMode(CacheMode.CACHEANDREMOTE)//设置请求缓存模式
//                //.okCache()//使用模式缓存模式时，走Okhttp缓存
//                .cacheDiskConverter(new GsonDiskConverter())//GSON-数据转换器
//                //.certificates()添加证书
//                .retryCount(5)//本次请求重试次数
//                .retryDelay(500)//本次请求重试延迟时间500ms
//                .addInterceptor(Interceptor)//添加拦截器
//                .okproxy()//设置代理
//                .removeHeader("header2")//移除头部header2
//                .removeAllHeaders()//移除全部请求头
//                .removeParam("param1")
//                .accessToken(true)//本次请求是否追加token
//                .timeStamp(false)//本次请求是否携带时间戳
//                .sign(false)//本次请求是否需要签名
                .syncRequest(true).execute(new SimpleCallBack<Object>() {
            @Override
            public void onError(ApiException e) {
                e.printStackTrace();
            }

            @Override
            public void onSuccess(Object o) {
                Log.d("zzg",o.toString());
            }
        });//是否是同步请求，默认异步请求。true:同步请求

//                .execute(new CallBack<SkinTestResult>() {
//                    @Override
//                    public void onStart() {
//                        //开始请求
//                    }
//                    @Override
//                    public void onCompleted() {
//                        //请求完成
//                    }
//                    @Override
//                    public void onError(ApiException e) {
//                        //请求错误
//                    }
//                    @Override
//                    public void onSuccess(SkinTestResult response) {
//                        //请求成功
//                    }
//                });


        final Request request = new Request.Builder()
                .url("https://123.56.147.120:442/service-authority/service.soa")
                .post(RequestBody.create(JSON, body))
                .addHeader("methodname", "LOG")
                .build();
        http_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        String error = e.toString();

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        if (response.isSuccessful()) {
                            String body = response.body().string();
                        }


                    }
                });


            }
        });


    }


}

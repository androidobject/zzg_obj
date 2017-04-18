package com.zzg.object.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

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

        final Request request = new Request.Builder()
                .url("https://123.56.147.120:442/service-authority/service.soa")
                .post(RequestBody.create(JSON, body))
                .addHeader("methodname","LOG")
                .build();
        http_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            String  error=e.toString();

                        }
                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            if(response.isSuccessful()){
                              String  body=response.body().string();
                            }


                        }
                    });


            }
        });


    }


}

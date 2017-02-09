package com.bu54.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.bu54.annotataion.ViewInject;
import com.bu54.base.BaseActivity;
import com.bu54.canvas.R;
import com.bu54.util.KeyboardUtils;

import java.util.ArrayList;

public class InputAdjustActivity extends BaseActivity {

    @ViewInject(R.id.toolbar)
    Toolbar toolbar;
    @ViewInject(R.id.listview)
    ListView listview;
    ArrayList mlist = new ArrayList();
    @ViewInject(R.id.button)
    Button button;
    EditText et_test;
    Display d;
    @Override
    public int getLayoutId() {
        return R.layout.activity_input_adjust;
    }

    boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar.setTitle("输入法遮挡");
        WindowManager m = getWindowManager();
         d = m.getDefaultDisplay(); //为获取屏幕宽
        initData();
        initDialog();
        listview.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, mlist));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag){
                    alertDialog.show();
                    Window window = alertDialog.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.width=d.getWidth();
                    window.setAttributes(attributes);
                    window.setGravity(Gravity.BOTTOM);
                    alertDialog.getWindow().setAttributes(attributes);
                    KeyboardUtils.showSoftInput(InputAdjustActivity.this,et_test);

                }else{
                    alertDialog.dismiss();
                }

            }
        });
    }




    private void initData() {
        for (int i = 0; i < 40; i++) {
            mlist.add("你大爷的遮挡我" + i);
        }
    }

    AlertDialog alertDialog;
    public void initDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_edittext_layout, null);
        et_test= (EditText) view.findViewById(R.id.et_test);
        builder.setView(view);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);//需要添加的语句
         alertDialog = builder.create();



    }


}

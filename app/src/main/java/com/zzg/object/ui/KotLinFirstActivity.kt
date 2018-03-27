package com.zzg.`object`.ui

import android.os.Bundle
import android.widget.Toast
import com.zzg.`object`.R
import com.zzg.`object`.base.BaseActivity
import kotlinx.android.synthetic.main.activity_kot_lin_first.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.onClick

class KotLinFirstActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_kot_lin_first;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toolbar.title = "kotlin+anko"
        tvv_wocao.text = "哈哈"
        tvv_wocao.onClick {
            Toast.makeText(this, "我擦擦擦", Toast.LENGTH_SHORT).show();
        }
    }


}

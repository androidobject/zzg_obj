package com.zzg.object.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.zzg.object.base.BaseActivity;
import com.zzg.object.base.BaseFragment;
import com.zzg.object.fragment.FirstFragment;
import com.zzg.object.annotataion.ViewInject;
import com.zzg.object.R;
import com.zzg.object.fragment.FourFragment;
import com.zzg.object.util.SnackBarUtil;

public class MainActivity extends BaseActivity {


    @ViewInject(R.id.navigation)
    NavigationView mNavigation;
    @ViewInject(R.id.drawerLayout)
    DrawerLayout mDrawer;
    @ViewInject(R.id.toolbar)
    Toolbar mToolBar;

    private BaseFragment mCurrentFragmet;
    private MenuItem mCurrentItem;

    private ActionBarDrawerToggle mDrawerToggle;

    private FirstFragment firstFragment;
    private FourFragment fourFragment;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();


    }

    private void initData() {
        firstFragment = new FirstFragment();
        fourFragment = new FourFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fl_main, firstFragment)
                .commit();
        mCurrentFragmet = firstFragment;

        mCurrentItem = mNavigation.getMenu().findItem(R.id.index);
        mCurrentItem.setChecked(true);
        mNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                mCurrentItem.setChecked(false);
                mCurrentItem = item;
                switch (item.getItemId()) {
                    case R.id.index:
                        switchFragment(firstFragment);
                        mCurrentFragmet = firstFragment;
                        mToolBar.setTitle("首页");
                        break;
                    case R.id.drawer_gril:
//                        switchFragment(mGrilFragment);
//                        mCurrentFragmet = mGrilFragment;
                        mToolBar.setTitle("妹纸");
                        break;
                    case R.id.drawer_like:
//                        switchFragment(mLikeFragment);
//                        mCurrentFragmet = mLikeFragment;
                        mToolBar.setTitle("我的收藏");
                        break;
                    case R.id.drawer_about:
                        switchFragment(fourFragment);
                        mCurrentFragmet = fourFragment;
                        mToolBar.setTitle("关于");
                        break;
                }
                item.setChecked(true);
                mDrawer.closeDrawers();
                return true;
            }
        });
    }

    private void initView() {
        mToolBar.setTitle("首页");
        setSupportActionBar(mToolBar);
        //设置toolbar显示左侧按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, mToolBar, R.string.open, R.string.close);
        mDrawerToggle.syncState();
        mDrawer.addDrawerListener(mDrawerToggle);


    }

    private void switchFragment(BaseFragment to) {
        if (mCurrentFragmet != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (to.isAdded()) {
                transaction.hide(mCurrentFragmet).show(to).commit();
            } else {
                transaction.hide(mCurrentFragmet).add(R.id.fl_main, to).commit();
            }

        }

    }

    @Override
    public void onBackPressed() {
        if (mNavigation.isShown()) {
            mDrawer.closeDrawers();
        } else {
//            showExit();
            showSnackbar();
        }
    }

    Snackbar snackbar;
    private void showSnackbar() {
        if(snackbar!=null&&snackbar.isShown()){
            finishAll();
        }else{
            snackbar = SnackBarUtil.LongSnackbar(getWindow().getDecorView(), "再次点击退出", SnackBarUtil.Info);
            snackbar.setAction("点击退出啦", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finishAll();
                }
            }).show();
        }
    }

    /**
     * 退出
     */
    private void showExit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示")
                .setMessage("您确定要退出吗？")
                .setCancelable(true)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finishAll();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .setCanceledOnTouchOutside(false);
        builder.show();

    }
}

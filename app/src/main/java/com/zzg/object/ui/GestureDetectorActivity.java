package com.zzg.object.ui;
/**
 * 手势操作
 */

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.zzg.object.R;
import com.zzg.object.annotataion.ViewInject;
import com.zzg.object.base.BaseActivity;
import com.zzg.object.util.LogUtils;
import com.zzg.object.view.TouchFrameLayout;

public class GestureDetectorActivity extends BaseActivity implements View.OnTouchListener {
    //手势
    private GestureDetector mGestureDetector;
    @ViewInject(R.id.fl_view)
    private TouchFrameLayout fl_view;
    private static final int FLING_MIN_DISTANCE = 50;
    private static final int FLING_MIN_VELOCITY = 0;
    @ViewInject(R.id.toolbar)
    Toolbar mToolBar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_gesture_detector;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mToolBar.setTitle("手势操作");
        mGestureDetector = new GestureDetector(this, onGestureListener);
        fl_view.setOnTouchListener(this);
    }


    GestureDetector.OnGestureListener onGestureListener = new GestureDetector.OnGestureListener() {

        /**用户轻触触摸屏，由1个MotionEvent ACTION_DOWN触发
         * @param e
         * @return
         */
        @Override
        public boolean onDown(MotionEvent e) {
            LogUtils.d("zzg_Log", "down----------");
            return true;
        }

        /**
         * 用户轻触触摸屏，尚未松开或拖动，由一个1个MotionEvent ACTION_DOWN触发, 注意和onDown()的区别，强调的是没有松开或者拖动的状态
         * @param e
         */
        @Override
        public void onShowPress(MotionEvent e) {
            LogUtils.d("zzg_Log", "onShowPress----------");
        }

        /**
         * 用户（轻触触摸屏后）松开，由一个1个MotionEvent ACTION_UP触发
         * @param e
         * @return
         */
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            LogUtils.d("zzg_Log", "onSingleTapUp----------");
            return false;
        }

        /**
         * 无论是用手拖动view，或者是以抛的动作滚动，都会多次触发 ,这个方法在ACTION_MOVE动作发生时就会触发
         * 用户按下触摸屏，并拖动，由1个MotionEvent ACTION_DOWN, 多个ACTION_MOVE触发
         * @param e1
         * @param e2
         * @param distanceX
         * @param distanceY
         * @return
         */
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            LogUtils.d("zzg_Log", "onScroll----------");
            return false;
        }

        /**
         * 用户长按触摸屏，由多个MotionEvent ACTION_DOWN触发
         * @param e
         */
        @Override
        public void onLongPress(MotionEvent e) {
            LogUtils.d("zzg_Log", "onLongPress----------");
        }

        /**
         * 这个方法发生在ACTION_UP时才会触发
         * 用户按下触摸屏、快速移动后松开，由1个MotionEvent ACTION_DOWN, 多个ACTION_MOVE, 1个ACTION_UP触发
         * @param e1
         * @param e2
         * @param velocityX x轴移动速度
         * @param velocityY  y轴移动速度
         * @return
         */
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            LogUtils.d("zzg_Log", "onFling----------");
            if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE
                    && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
                // Fling left
                Toast.makeText(GestureDetectorActivity.this, "向左手势", Toast.LENGTH_SHORT).show();
            } else if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE
                    && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
                // Fling right
                Toast.makeText(GestureDetectorActivity.this, "向右手势", Toast.LENGTH_SHORT).show();
            } else if (e1.getY() - e2.getY() > FLING_MIN_DISTANCE
                    && Math.abs(velocityY) > FLING_MIN_VELOCITY) {
                // Fling up
                Toast.makeText(GestureDetectorActivity.this, "向上手势", Toast.LENGTH_SHORT).show();
            } else if (e1.getY() - e2.getY() > FLING_MIN_DISTANCE
                    && Math.abs(velocityY) > FLING_MIN_VELOCITY) {
                // Fling down
                Toast.makeText(GestureDetectorActivity.this, "向下手势", Toast.LENGTH_SHORT).show();
            }
            return true;
        }

    };


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        LogUtils.d("zzg_Log", "touch----------" + event.getAction());
        return mGestureDetector.onTouchEvent(event);
    }
}

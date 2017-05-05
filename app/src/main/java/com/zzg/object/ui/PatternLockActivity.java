package com.zzg.object.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.zzg.object.R;
import com.zzg.object.annotataion.ViewInject;
import com.zzg.object.base.BaseActivity;
import com.zzg.object.view.patternlockview.PatternLockView;
import com.zzg.object.view.patternlockview.RxPatternLockView;
import com.zzg.object.view.patternlockview.events.PatternLockCompleteEvent;
import com.zzg.object.view.patternlockview.events.PatternLockCompoundEvent;
import com.zzg.object.view.patternlockview.listener.PatternLockViewListener;
import com.zzg.object.view.patternlockview.utils.PatternLockUtils;
import com.zzg.object.view.patternlockview.utils.ResourceUtils;

import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * Created by apple on 2017/5/5.
 */

public class PatternLockActivity extends BaseActivity {
    @ViewInject(R.id.patter_lock_view)
    private PatternLockView mPatternLockView;
    @ViewInject(R.id.toolbar)
    Toolbar toolbar;

    private PatternLockViewListener mPatternLockViewListener = new PatternLockViewListener() {
        @Override
        public void onStarted() {
            Log.d(getClass().getName(), "Pattern drawing started");
        }

        @Override
        public void onProgress(List<PatternLockView.Dot> progressPattern) {
            Log.d(getClass().getName(), "Pattern progress: " +
                    PatternLockUtils.patternToString(mPatternLockView, progressPattern));
        }

        @Override
        public void onComplete(List<PatternLockView.Dot> pattern) {
            Log.d(getClass().getName(), "Pattern complete: " +
                    PatternLockUtils.patternToString(mPatternLockView, pattern));
        }

        @Override
        public void onCleared() {
            Log.d(getClass().getName(), "Pattern has been cleared");
        }
    };

    @Override
    public int getLayoutId() {
        return R.layout.layout_pattern_lock;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar.setTitle("手势锁");
        //一行个数
        mPatternLockView.setDotCount(3);
        //默认点大小
        mPatternLockView.setDotNormalSize((int) ResourceUtils.getDimensionInPx(this, R.dimen.pattern_lock_dot_size));
        //选中点大小
        mPatternLockView.setDotSelectedSize((int) ResourceUtils.getDimensionInPx(this, R.dimen.pattern_lock_dot_selected_size));
        //选择线宽度
        mPatternLockView.setPathWidth((int) ResourceUtils.getDimensionInPx(this, R.dimen.pattern_lock_path_width));
        //方形
        mPatternLockView.setAspectRatioEnabled(true);
        mPatternLockView.setAspectRatio(PatternLockView.AspectRatio.ASPECT_RATIO_HEIGHT_BIAS);
        mPatternLockView.setViewMode(PatternLockView.PatternViewMode.CORRECT);
        mPatternLockView.setDotAnimationDuration(150);
        mPatternLockView.setPathEndAnimationDuration(100);
        mPatternLockView.setCorrectStateColor(ResourceUtils.getColor(this, R.color.white));
        mPatternLockView.setInStealthMode(false);
        mPatternLockView.setTactileFeedbackEnabled(true);
        mPatternLockView.setInputEnabled(true);
        mPatternLockView.addPatternLockListener(mPatternLockViewListener);

        RxPatternLockView.patternComplete(mPatternLockView)
                .subscribe(new Consumer<PatternLockCompleteEvent>() {
                    @Override
                    public void accept(PatternLockCompleteEvent patternLockCompleteEvent) throws Exception {
                        Log.d(getClass().getName(), "Complete: " + patternLockCompleteEvent.getPattern().toString());
                    }
                });

        RxPatternLockView.patternChanges(mPatternLockView)
                .subscribe(new Consumer<PatternLockCompoundEvent>() {
                    @Override
                    public void accept(PatternLockCompoundEvent event) throws Exception {
                        if (event.getEventType() == PatternLockCompoundEvent.EventType.PATTERN_STARTED) {
                            Log.d(getClass().getName(), "Pattern drawing started");
                        } else if (event.getEventType() == PatternLockCompoundEvent.EventType.PATTERN_PROGRESS) {
                            Log.d(getClass().getName(), "Pattern progress: " +
                                    PatternLockUtils.patternToString(mPatternLockView, event.getPattern()));
                        } else if (event.getEventType() == PatternLockCompoundEvent.EventType.PATTERN_COMPLETE) {
                            Log.d(getClass().getName(), "Pattern complete: " +
                                    PatternLockUtils.patternToString(mPatternLockView, event.getPattern()));
                        } else if (event.getEventType() == PatternLockCompoundEvent.EventType.PATTERN_CLEARED) {
                            Log.d(getClass().getName(), "Pattern has been cleared");
                        }
                    }
                });
    }

}


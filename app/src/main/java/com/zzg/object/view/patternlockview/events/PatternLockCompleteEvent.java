package com.zzg.object.view.patternlockview.events;


import com.zzg.object.view.patternlockview.PatternLockView;

import java.util.List;

/**
 * Created by aritraroy on 01/04/17.
 */

public class PatternLockCompleteEvent extends BasePatternLockEvent {

    public PatternLockCompleteEvent(List<PatternLockView.Dot> pattern) {
        super(pattern);
    }
}

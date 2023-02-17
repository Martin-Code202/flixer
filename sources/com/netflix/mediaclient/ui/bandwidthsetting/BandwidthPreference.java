package com.netflix.mediaclient.ui.bandwidthsetting;

import android.content.Context;
import android.support.v7.preference.DialogPreference;
import android.util.AttributeSet;
public class BandwidthPreference extends DialogPreference {
    public BandwidthPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setPersistent(false);
    }

    public BandwidthPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setPersistent(false);
    }
}

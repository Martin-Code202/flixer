package com.netflix.mediaclient.ui.settings;

import android.content.Context;
import android.support.v14.preference.SwitchPreference;
import android.support.v7.preference.PreferenceViewHolder;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import com.netflix.mediaclient.R;
import o.C1457Fr;
public final class NetflixSwitchPreference extends SwitchPreference {

    /* renamed from: ॱ  reason: contains not printable characters */
    private final C0048 f3949 = new C0048();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetflixSwitchPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C1457Fr.m5025(context, "context");
    }

    /* renamed from: com.netflix.mediaclient.ui.settings.NetflixSwitchPreference$ˊ  reason: contains not printable characters */
    final class C0048 implements CompoundButton.OnCheckedChangeListener {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public C0048() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            C1457Fr.m5025(compoundButton, "buttonView");
            if (!NetflixSwitchPreference.this.callChangeListener(Boolean.valueOf(z))) {
                compoundButton.setChecked(!z);
            } else {
                NetflixSwitchPreference.this.setChecked(z);
            }
        }
    }

    @Override // android.support.v14.preference.SwitchPreference, android.support.v7.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        C1457Fr.m5025(preferenceViewHolder, "view");
        super.onBindViewHolder(preferenceViewHolder);
        View findViewById = preferenceViewHolder.findViewById(R.id.netflix_settings_switch);
        if (findViewById instanceof SwitchCompat) {
            ((SwitchCompat) findViewById).setOnCheckedChangeListener(null);
            ((SwitchCompat) findViewById).setChecked(this.mChecked);
            ((SwitchCompat) findViewById).setOnCheckedChangeListener(this.f3949);
        }
    }
}

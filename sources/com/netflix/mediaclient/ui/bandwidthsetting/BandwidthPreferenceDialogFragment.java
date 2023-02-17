package com.netflix.mediaclient.ui.bandwidthsetting;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.preference.PreferenceDialogFragmentCompat;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.netflix.mediaclient.R;
import o.C0577;
import o.C1283;
public class BandwidthPreferenceDialogFragment extends PreferenceDialogFragmentCompat {

    /* renamed from: ˊ  reason: contains not printable characters */
    private RadioGroup f2851;

    /* renamed from: ˋ  reason: contains not printable characters */
    private RadioButton f2852;

    /* renamed from: ˎ  reason: contains not printable characters */
    private RadioButton f2853;

    /* renamed from: ˏ  reason: contains not printable characters */
    private RadioButton f2854;

    /* renamed from: ॱ  reason: contains not printable characters */
    private SwitchCompat f2855;

    /* renamed from: com.netflix.mediaclient.ui.bandwidthsetting.BandwidthPreferenceDialogFragment$ˋ  reason: contains not printable characters */
    public interface AbstractC0031 {
        /* renamed from: ॱ  reason: contains not printable characters */
        void mo1602(Context context);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static BandwidthPreferenceDialogFragment m1588() {
        BandwidthPreferenceDialogFragment bandwidthPreferenceDialogFragment = new BandwidthPreferenceDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key", "nf.bw_save");
        bandwidthPreferenceDialogFragment.setArguments(bundle);
        return bandwidthPreferenceDialogFragment;
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.preference.PreferenceDialogFragmentCompat
    public View onCreateDialogView(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.pref_data_saver_settings_dialog, (ViewGroup) null);
    }

    @Override // android.support.v7.preference.PreferenceDialogFragmentCompat
    public void onBindDialogView(View view) {
        m1591(view, C0577.m14681(getContext()), C0577.m14684(getContext()));
        m1593();
        super.onBindDialogView(view);
    }

    @Override // android.support.v7.preference.PreferenceDialogFragmentCompat
    public void onDialogClosed(boolean z) {
        if (z) {
            C0577.m14690(getContext(), Boolean.valueOf(m1599()), m1587().m1601());
            m1595();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m1595() {
        if (getContext() instanceof AbstractC0031) {
            ((AbstractC0031) getContext()).mo1602(getContext());
        } else {
            C1283.m16854("BandwidthPrefDialogFragment", "notifyCaller: no callback interface!! activity:" + getContext().getClass().getSimpleName());
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m1591(View view, boolean z, int i) {
        this.f2851 = (RadioGroup) view.findViewById(R.id.id_bw_radioGroup);
        this.f2853 = (RadioButton) view.findViewById(R.id.id_bw_rb_off);
        this.f2852 = (RadioButton) view.findViewById(R.id.id_bw_rb_low);
        this.f2854 = (RadioButton) view.findViewById(R.id.id_bw_rb_unlimited);
        this.f2855 = (SwitchCompat) view.findViewById(R.id.id_bw_automatic_switch);
        this.f2855.setChecked(z);
        m1596(!z);
        if (!z) {
            m1597(ManualBwChoice.m1600(i));
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m1593() {
        this.f2853.setOnClickListener(new View$OnClickListenerC0030());
        this.f2852.setOnClickListener(new View$OnClickListenerC0030());
        this.f2854.setOnClickListener(new View$OnClickListenerC0030());
        this.f2855.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.netflix.mediaclient.ui.bandwidthsetting.BandwidthPreferenceDialogFragment.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                C1283.m16854("BandwidthPrefDialogFragment", "bwSwitch toggled state: " + z);
                BandwidthPreferenceDialogFragment.this.m1590();
                BandwidthPreferenceDialogFragment.this.m1596(!z);
                if (!z) {
                    BandwidthPreferenceDialogFragment.this.m1597(ManualBwChoice.m1600(C0577.f13843));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m1596(boolean z) {
        this.f2853.setEnabled(z);
        this.f2852.setEnabled(z);
        this.f2854.setEnabled(z);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m1590() {
        this.f2853.setChecked(false);
        this.f2852.setChecked(false);
        this.f2854.setChecked(false);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m1597(ManualBwChoice manualBwChoice) {
        this.f2851.clearCheck();
        switch (manualBwChoice) {
            case OFF:
                this.f2853.setChecked(true);
                return;
            case LOW:
                this.f2852.setChecked(true);
                return;
            case UNLIMITED:
                this.f2854.setChecked(true);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.netflix.mediaclient.ui.bandwidthsetting.BandwidthPreferenceDialogFragment$ˊ  reason: contains not printable characters */
    public class View$OnClickListenerC0030 implements View.OnClickListener {
        View$OnClickListenerC0030() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BandwidthPreferenceDialogFragment.this.m1599()) {
                C1283.m16854("BandwidthPrefDialogFragment", "ignore manual selection - in auto mode");
                return;
            }
            ManualBwChoice manualBwChoice = ManualBwChoice.UNDEFINED;
            switch (view.getId()) {
                case R.id.id_bw_rb_low /* 2131427870 */:
                    manualBwChoice = ManualBwChoice.LOW;
                    break;
                case R.id.id_bw_rb_off /* 2131427871 */:
                    manualBwChoice = ManualBwChoice.OFF;
                    break;
                case R.id.id_bw_rb_unlimited /* 2131427872 */:
                    manualBwChoice = ManualBwChoice.UNLIMITED;
                    break;
                default:
                    C1283.m16854("BandwidthPrefDialogFragment", "Ignoring click on unknown view");
                    break;
            }
            if (manualBwChoice != ManualBwChoice.UNDEFINED) {
                BandwidthPreferenceDialogFragment.this.m1590();
                BandwidthPreferenceDialogFragment.this.m1597(manualBwChoice);
            }
        }
    }

    public enum ManualBwChoice {
        OFF(0),
        LOW(1),
        MEDIUM(2),
        HIGH(3),
        UNLIMITED(4),
        UNDEFINED(-1);
        

        /* renamed from: ʼ  reason: contains not printable characters */
        private final int f2865;

        private ManualBwChoice(int i) {
            this.f2865 = i;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public int m1601() {
            return this.f2865;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public static ManualBwChoice m1600(int i) {
            ManualBwChoice[] values = values();
            for (ManualBwChoice manualBwChoice : values) {
                if (manualBwChoice.f2865 == i) {
                    return manualBwChoice;
                }
            }
            return UNDEFINED;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m1599() {
        return this.f2855.isChecked();
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private ManualBwChoice m1587() {
        if (this.f2853.isChecked()) {
            return ManualBwChoice.OFF;
        }
        if (this.f2852.isChecked()) {
            return ManualBwChoice.LOW;
        }
        if (this.f2854.isChecked()) {
            return ManualBwChoice.UNLIMITED;
        }
        return ManualBwChoice.LOW;
    }
}

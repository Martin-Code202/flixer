package com.netflix.mediaclient.ui.settings;

import android.content.Context;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceViewHolder;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.util.ViewUtils;
import kotlin.TypeCastException;
import o.AbstractC1853hl;
import o.BG;
import o.C0345;
import o.C1276;
import o.C1283;
import o.C1317As;
import o.C1456Fq;
import o.C1457Fr;
import o.C2059ph;
import o.pY;
import o.pZ;
import o.vH;
public final class StoragePreference extends Preference {

    /* renamed from: ʻ  reason: contains not printable characters */
    private pZ f3951;

    /* renamed from: ʼ  reason: contains not printable characters */
    private View f3952;

    /* renamed from: ʽ  reason: contains not printable characters */
    private View f3953;

    /* renamed from: ˊ  reason: contains not printable characters */
    private TextView f3954;

    /* renamed from: ˋ  reason: contains not printable characters */
    private TextView f3955;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f3956;

    /* renamed from: ˏ  reason: contains not printable characters */
    private TextView f3957;

    /* renamed from: ॱ  reason: contains not printable characters */
    private TextView f3958;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private View f3959;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private TextView f3960;

    public StoragePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    public StoragePreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoragePreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        C1457Fr.m5025(context, "context");
        this.f3956 = "StoragePreference";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StoragePreference(Context context, AttributeSet attributeSet, int i, int i2, int i3, C1456Fq fq) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @Override // android.support.v7.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder preferenceViewHolder) {
        C1457Fr.m5025(preferenceViewHolder, "holder");
        super.onBindViewHolder(preferenceViewHolder);
        m2934(preferenceViewHolder);
        m2933();
        m2939(preferenceViewHolder);
        m2938();
        m2935();
        m2936(preferenceViewHolder);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m2933() {
        C2059ph r0 = C2059ph.m9741((NetflixActivity) C0345.m13893(getContext(), NetflixActivity.class));
        AbstractC1853hl r2 = r0 != null ? r0.m9832() : null;
        if (r2 != null) {
            pY r3 = r2.mo7136();
            C1457Fr.m5016((Object) r3, "volumeList");
            this.f3951 = (pZ) r3.mo4075(r3.mo9597());
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private final void m2938() {
        int i;
        Context context = getContext();
        pZ pZVar = this.f3951;
        if (pZVar == null || !pZVar.mo7008()) {
            i = R.string.offline_message_internal_storage;
        } else {
            i = R.string.offline_message_removable_storage;
        }
        String string = context.getString(i);
        TextView textView = this.f3955;
        if (textView == null) {
            C1457Fr.m5017("deviceName");
        }
        textView.setText(string);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private final void m2935() {
        pZ pZVar = this.f3951;
        if (pZVar != null) {
            TextView textView = this.f3958;
            if (textView == null) {
                C1457Fr.m5017("isDefault");
            }
            ViewUtils.m3002(textView, pZVar.mo7014());
        }
    }

    /* access modifiers changed from: package-private */
    public static final class If implements View.OnClickListener {

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ StoragePreference f3961;

        If(StoragePreference storagePreference) {
            this.f3961 = storagePreference;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            NetflixActivity netflixActivity;
            C2059ph r0;
            if (!C1317As.m3750(this.f3961.getContext()) && (netflixActivity = (NetflixActivity) C0345.m13893(this.f3961.getContext(), NetflixActivity.class)) != null && (r0 = C2059ph.m9741(netflixActivity)) != null && r0.m9824()) {
                this.f3961.getContext().startActivity(vH.m11936(netflixActivity));
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private final void m2936(PreferenceViewHolder preferenceViewHolder) {
        preferenceViewHolder.itemView.setOnClickListener(new If(this));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m2934(PreferenceViewHolder preferenceViewHolder) {
        View findViewById = preferenceViewHolder.findViewById(R.id.storage_netflix_legend);
        if (findViewById == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        this.f3957 = (TextView) findViewById;
        View findViewById2 = preferenceViewHolder.findViewById(R.id.storage_used_legend);
        if (findViewById2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        this.f3954 = (TextView) findViewById2;
        View findViewById3 = preferenceViewHolder.findViewById(R.id.storage_free_legend);
        if (findViewById3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        this.f3960 = (TextView) findViewById3;
        View findViewById4 = preferenceViewHolder.findViewById(R.id.storage_device_name);
        if (findViewById4 == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        this.f3955 = (TextView) findViewById4;
        View findViewById5 = preferenceViewHolder.findViewById(R.id.storage_is_default);
        if (findViewById5 == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        this.f3958 = (TextView) findViewById5;
        View findViewById6 = preferenceViewHolder.findViewById(R.id.storage_netflix);
        C1457Fr.m5016((Object) findViewById6, "holder.findViewById(R.id.storage_netflix)");
        this.f3952 = findViewById6;
        View findViewById7 = preferenceViewHolder.findViewById(R.id.storage_used);
        C1457Fr.m5016((Object) findViewById7, "holder.findViewById(R.id.storage_used)");
        this.f3959 = findViewById7;
        View findViewById8 = preferenceViewHolder.findViewById(R.id.storage_free);
        C1457Fr.m5016((Object) findViewById8, "holder.findViewById(R.id.storage_free)");
        this.f3953 = findViewById8;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m2939(PreferenceViewHolder preferenceViewHolder) {
        C1457Fr.m5025(preferenceViewHolder, "holder");
        try {
            if (C1317As.m3773(getContext()) == null) {
                C1283.m16850(this.f3956, "SettingsActivity:update fileDir is null");
            } else if (this.f3951 == null) {
                C1283.m16850(this.f3956, "SettingsActivity:update volume is null");
            } else {
                pZ pZVar = this.f3951;
                if (pZVar != null) {
                    long r7 = pZVar.mo7011();
                    long r9 = pZVar.mo7013();
                    long r11 = pZVar.mo7012();
                    long j = (r7 - r9) - r11;
                    View view = this.f3952;
                    if (view == null) {
                        C1457Fr.m5017("netflixView");
                    }
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    }
                    ((LinearLayout.LayoutParams) layoutParams).weight = (float) r11;
                    View view2 = this.f3959;
                    if (view2 == null) {
                        C1457Fr.m5017("usedView");
                    }
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    if (layoutParams2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    }
                    ((LinearLayout.LayoutParams) layoutParams2).weight = (float) j;
                    View view3 = this.f3953;
                    if (view3 == null) {
                        C1457Fr.m5017("freeView");
                    }
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    if (layoutParams3 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    }
                    ((LinearLayout.LayoutParams) layoutParams3).weight = (float) r9;
                    String r15 = m2937(r11);
                    String r16 = m2937(j);
                    String r17 = m2937(r9);
                    TextView textView = this.f3957;
                    if (textView == null) {
                        C1457Fr.m5017("netflixViewLegend");
                    }
                    textView.setText(getContext().getString(R.string.download_prefs_storage_label_netflix, r15));
                    TextView textView2 = this.f3954;
                    if (textView2 == null) {
                        C1457Fr.m5017("usedViewLegend");
                    }
                    textView2.setText(getContext().getString(R.string.download_prefs_storage_label_used, r16));
                    TextView textView3 = this.f3960;
                    if (textView3 == null) {
                        C1457Fr.m5017("freeViewLegend");
                    }
                    textView3.setText(getContext().getString(R.string.download_prefs_storage_label_free, r17));
                    preferenceViewHolder.itemView.requestLayout();
                    m2935();
                }
            }
        } catch (IllegalArgumentException e) {
            C1283.m16856(this.f3956, e, "" + e, new Object[0]);
            C1276.m16820().mo5731(e);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String m2937(long j) {
        String r0 = BG.m3861(getContext(), j);
        C1457Fr.m5016((Object) r0, "UIStringUtils.formatShortFileSize(context, size)");
        return r0;
    }
}

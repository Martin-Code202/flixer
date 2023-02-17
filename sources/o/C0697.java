package o;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import o.C0602;
/* renamed from: o.ฯ  reason: contains not printable characters */
public final class C0697 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f14201;

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f14202;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final ViewGroup f14203;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Cif f14204;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final C0673 f14205;

    /* renamed from: o.ฯ$if  reason: invalid class name */
    public interface Cif {
        /* renamed from: ˎ */
        void mo12059(C0697 v);

        /* renamed from: ˏ */
        void mo12060(C0697 v);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static C0697 m14993(Context context, FrameLayout frameLayout, View view, int i, int i2) {
        return new C0697(context, frameLayout, view, Html.fromHtml(context.getResources().getString(i)), Html.fromHtml(context.getResources().getString(i2)));
    }

    private C0697(Context context, FrameLayout frameLayout, View view, CharSequence charSequence, CharSequence charSequence2) {
        this(context, frameLayout, view, charSequence2);
        this.f14205.setTitle(charSequence);
    }

    private C0697(Context context, FrameLayout frameLayout, View view, CharSequence charSequence) {
        this.f14203 = frameLayout;
        this.f14205 = (C0673) LayoutInflater.from(context).inflate(C0602.C0606.tooltip_layout, this.f14203, false);
        this.f14205.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f14205.setOnClickListener(new View.OnClickListener() { // from class: o.ฯ.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                C0697.this.f14205.m14901(C0697.this.f14203);
            }
        });
        this.f14205.setDetail(charSequence);
        this.f14205.m14902(view);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public View m15001() {
        return this.f14205.m14903();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m15000() {
        if (this.f14205.isShown()) {
            Log.d("Tooltip", "Tooltip is already showing");
        } else if (!m15004() && m14995()) {
            this.f14205.m14905(this.f14203);
            this.f14205.m14906(new Cif() { // from class: o.ฯ.1
                @Override // o.C0697.Cif
                /* renamed from: ˎ */
                public void mo12059(C0697 r3) {
                    if (C0697.this.f14204 != null) {
                        C0697.this.f14204.mo12059(C0697.this);
                    }
                }

                @Override // o.C0697.Cif
                /* renamed from: ˏ */
                public void mo12060(C0697 r4) {
                    if (C0697.this.f14201 != null) {
                        C0697.this.m14990().edit().putBoolean(C0697.this.m14999(), true).apply();
                    }
                    if (C0697.this.f14204 != null) {
                        C0697.this.f14204.mo12060(C0697.this);
                    }
                }
            });
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m15004() {
        return this.f14201 != null && m14990().getBoolean(m14999(), false);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m14997(Context context, String str) {
        return context.getSharedPreferences("com.netflix.android.tooltips", 0).getBoolean("consumed." + str, false);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m14995() {
        AccessibilityManager accessibilityManager;
        return this.f14202 || (accessibilityManager = (AccessibilityManager) this.f14203.getContext().getSystemService("accessibility")) == null || !accessibilityManager.isEnabled();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʽ  reason: contains not printable characters */
    private SharedPreferences m14990() {
        return this.f14203.getContext().getSharedPreferences("com.netflix.android.tooltips", 0);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String m14999() {
        return "consumed." + this.f14201;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m15005() {
        if (!m15004() && m14995()) {
            this.f14205.m14901(this.f14203);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m15002(String str) {
        this.f14201 = str;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m15003(Cif ifVar) {
        this.f14204 = ifVar;
    }
}

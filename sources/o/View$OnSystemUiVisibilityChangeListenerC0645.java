package o;

import android.annotation.SuppressLint;
import android.view.View;
@SuppressLint({"NewApi"})
/* renamed from: o.ܬ  reason: contains not printable characters */
public class View$OnSystemUiVisibilityChangeListenerC0645 extends C0653 implements View.OnSystemUiVisibilityChangeListener {

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f13974 = false;

    public View$OnSystemUiVisibilityChangeListenerC0645(AbstractC0931 r2) {
        super(r2);
    }

    @Override // o.C0653
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo14785() {
        C1283.m16854("nf_navbar", "startListening: add itself to listen for navigation bar changes.");
        this.f13996.mo15742().setOnSystemUiVisibilityChangeListener(this);
        this.f13974 = false;
    }

    @Override // o.C0653
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo14786() {
        C1283.m16854("nf_navbar", "stopListening: remove listener");
        this.f13996.mo15742().setOnSystemUiVisibilityChangeListener(null);
    }

    @Override // o.C0653, android.view.View.OnSystemUiVisibilityChangeListener
    public void onSystemUiVisibilityChange(int i) {
        int i2 = i & 1;
        int i3 = i & 0;
        int i4 = i & 4;
        if ((i & 2) != 0) {
            C1283.m16854("nf_navbar", "onSystemUiVisibilityChange Navigation bar is hidden, do nothing");
            this.f13974 = false;
        } else if (i2 != 0) {
            C1283.m16854("nf_navbar", "onSystemUiVisibilityChange Navigation bar is low profile");
            this.f13974 = true;
        } else if (i4 != 0) {
            C1283.m16854("nf_navbar", "onSystemUiVisibilityChange SystemUI is full screen, do nothing");
        } else {
            if (!this.f13974) {
                C1283.m16854("nf_navbar", "onSystemUiVisibilityChange Navigation bar is visible, execute onTouch event");
                this.f13996.mo15743(null);
            }
            this.f13974 = false;
        }
    }
}

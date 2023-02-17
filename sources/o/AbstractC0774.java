package o;

import android.view.View;
/* renamed from: o.ᒎ  reason: contains not printable characters */
public abstract class AbstractC0774 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f14416;

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f14417;

    /* renamed from: ˎ  reason: contains not printable characters */
    private AbstractC0775 f14418;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f14419 = true;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final View f14420;

    /* renamed from: o.ᒎ$ˋ  reason: contains not printable characters */
    protected interface AbstractC0775 {
        /* renamed from: ˋ  reason: contains not printable characters */
        void m15234();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public abstract void mo14538(View view);

    /* access modifiers changed from: protected */
    /* renamed from: ˋ */
    public abstract void mo14539(View view);

    /* access modifiers changed from: protected */
    /* renamed from: ˎ */
    public abstract void mo14540(View view);

    protected AbstractC0774(View view) {
        this.f14420 = view;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m15231(boolean z) {
        if (this.f14419) {
            if (this.f14416 && !z) {
                mo14538(this.f14420);
            } else if (z) {
                this.f14417 = true;
                mo14539(this.f14420);
            } else {
                mo14540(this.f14420);
            }
            this.f14416 = z;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15233(boolean z) {
        this.f14419 = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15232() {
        this.f14417 = false;
        this.f14420.animate().setListener(null);
        if (this.f14418 != null) {
            m15230("Notifying listener of pressed animation complete");
            this.f14418.m15234();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m15230(String str) {
    }
}

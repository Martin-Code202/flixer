package o;

import android.content.Context;
/* access modifiers changed from: package-private */
/* renamed from: o.গ  reason: contains not printable characters */
public class C0653 {

    /* renamed from: ˎ  reason: contains not printable characters */
    protected AbstractC0931 f13996;

    C0653(AbstractC0931 r3) {
        if (r3 == null) {
            throw new IllegalArgumentException("View is null!");
        }
        this.f13996 = r3;
    }

    /* renamed from: ˊ */
    public void mo14785() {
        C1283.m16854("nf_navbar", "startListening: noop");
    }

    /* renamed from: ˏ */
    public void mo14786() {
        C1283.m16854("nf_navbar", "stopListening: noop");
    }

    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    public void onSystemUiVisibilityChange(int i) {
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    static C0653 m14813(Context context, AbstractC0931 r2) {
        return new View$OnSystemUiVisibilityChangeListenerC0645(r2);
    }
}

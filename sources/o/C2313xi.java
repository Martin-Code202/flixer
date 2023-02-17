package o;

import android.os.Build;
/* renamed from: o.xi  reason: case insensitive filesystem */
public class C2313xi {

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f12191;

    public C2313xi() {
        m12936();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m12937() {
        return this.f12191;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m12936() {
        this.f12191 = false;
        if (Build.VERSION.SDK_INT >= 22) {
            this.f12191 = true;
        }
    }
}

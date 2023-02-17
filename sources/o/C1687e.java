package o;

import android.app.Activity;
/* renamed from: o.e  reason: case insensitive filesystem */
public class C1687e extends AbstractRunnableC1740f {

    /* renamed from: ॱ  reason: contains not printable characters */
    private Activity f6442;

    public C1687e(Activity activity) {
        super(activity);
        this.f6442 = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f6442 != null) {
            C1283.m16850("ErrorManager", "Exit");
            this.f6442.finish();
        }
    }
}

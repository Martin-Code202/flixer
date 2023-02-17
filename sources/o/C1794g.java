package o;

import android.content.Context;
import android.content.Intent;
/* renamed from: o.g  reason: case insensitive filesystem */
public class C1794g extends AbstractRunnableC1740f {
    public C1794g(Context context) {
        super(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        C1283.m16850("ErrorManager", "restartApp");
        C1061.m16114().mo14166(this.f6710);
        Intent intent = new Intent();
        intent.setClass(this.f6710, ServiceC0966.class);
        this.f6710.stopService(intent);
    }
}

package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.netflix.mediaclient.service.user.UserAgent;
/* renamed from: o.ᴦ  reason: contains not printable characters */
public class C0961 extends BroadcastReceiver {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final String f14872 = C0961.class.getSimpleName();

    /* renamed from: ˋ  reason: contains not printable characters */
    private UserAgent f14873;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1283.m16854(f14872, "on receive intent " + intent);
        if (this.f14873 != null && "com.netflix.mediaclient.intent.action.LOGOUT".equals(intent.getAction())) {
            this.f14873.mo1360();
        }
    }
}

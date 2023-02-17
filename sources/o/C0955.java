package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
/* renamed from: o.ᴘ  reason: contains not printable characters */
public class C0955 extends BroadcastReceiver {

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final String f14861 = C0955.class.getSimpleName();

    /* renamed from: ˏ  reason: contains not printable characters */
    private C1856ho f14862;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1283.m16854(f14861, "on receive intent " + intent);
        String stringExtra = intent.getStringExtra("playableId");
        String stringExtra2 = intent.getStringExtra("videoType");
        if (this.f14862 != null && this.f14862.r_() && this.f14862.mo7118()) {
            if ("com.netflix.mediaclient.intent.action.offline.STOP_DOWNLOAD".equals(intent.getAction())) {
                this.f14862.mo7123(stringExtra);
            } else if ("com.netflix.mediaclient.intent.action.offline.START_DOWNLOAD".equals(intent.getAction())) {
                this.f14862.mo7141(stringExtra, VideoType.create(stringExtra2), new oB(f14861));
            }
        }
    }
}

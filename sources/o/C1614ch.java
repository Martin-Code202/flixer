package o;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.netflix.mediaclient.android.app.Status;
/* renamed from: o.ch  reason: case insensitive filesystem */
public class C1614ch {
    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m5845(Context context, String str, Status status) {
        m5844(context, C1619cm.f6279, str, AR.m3405(status), AR.m3407(status));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static void m5844(Context context, String str, String str2, String str3, String str4) {
        Intent intent = new Intent(str);
        intent.addCategory(C1619cm.f6281);
        intent.putExtra(C1619cm.f6283, str2);
        intent.putExtra(C1619cm.f6278, str3);
        intent.putExtra(C1619cm.f6276, str4);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }
}

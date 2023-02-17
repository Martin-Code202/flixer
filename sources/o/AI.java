package o;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.netflix.mediaclient.StatusCode;
public final class AI {
    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m3356(StatusCode statusCode) {
        return statusCode == StatusCode.DELETED_PROFILE;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m3355(Context context, StatusCode statusCode) {
        C1283.m16854("nf_fetcherrorutils", "Broadcasting DELETED_PROFILE intent");
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.DELETED_PROFILE"));
    }
}

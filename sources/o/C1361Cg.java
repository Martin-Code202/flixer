package o;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
/* renamed from: o.Cg  reason: case insensitive filesystem */
public class C1361Cg extends AbstractC1358Cd {
    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m4377(Context context, C1580cB cBVar) {
        if (!m4349(context, "Context can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_PUSH_NOTIFICATION_RECEIVED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("event", cBVar);
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m4376(Context context, C1579cA cAVar) {
        if (!m4349(context, "Context can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_PUSH_NOTIFICATION_PRESENTED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("event", cAVar);
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m4378(Context context, C1582cD cDVar) {
        if (!m4349(context, "Context can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_PUSH_NOTIFICATION_RESOLVED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("event", cDVar);
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        }
    }
}

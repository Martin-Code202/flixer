package o;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.content.LocalBroadcastManager;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.player.bladerunnerclient.volley.BladerunnerErrorStatus;
import com.netflix.mediaclient.servicemgr.IClientLogging;
public final class AR {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final int f4296;

    static {
        int i = 0;
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            i++;
            if (stackTraceElement.getClassName().equals(AR.class.getName())) {
                break;
            }
        }
        f4296 = i;
    }

    private AR() {
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m3404(Context context) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.ONSIGNUP");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m3406() {
        return Thread.currentThread().getStackTrace()[f4296].getMethodName();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m3409(IClientLogging iClientLogging, String str, pS pSVar) {
        if (pSVar == null) {
            C1283.m16846("nf_log", "No season details");
        } else {
            iClientLogging.mo1515().mo5714(String.format("For Show Id %s, the Current Season Details Id is empty - %s, see SPY-7455", str, pSVar.toString()));
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m3405(Status status) {
        String valueOf = String.valueOf(status.mo302().m271());
        if (status instanceof BladerunnerErrorStatus) {
            return ((BladerunnerErrorStatus) status).m962();
        }
        return valueOf;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m3407(Status status) {
        String r1 = status.mo307();
        if (status instanceof BladerunnerErrorStatus) {
            return ((BladerunnerErrorStatus) status).m964();
        }
        return r1;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m3408(Context context) {
        if (context != null) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_RESUME_ALL_EVENTS_DELIVERY");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m3403() {
        String str = Build.SERIAL;
        if (str == null) {
            return "";
        }
        return C1324Ax.m3812(str);
    }
}

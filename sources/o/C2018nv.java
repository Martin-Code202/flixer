package o;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.netflix.mediaclient.service.user.UserAgentBroadcastIntents$1;
import java.util.Set;
/* renamed from: o.nv  reason: case insensitive filesystem */
public final class C2018nv {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final Set<String> f9210 = new UserAgentBroadcastIntents$1();

    /* renamed from: ॱ  reason: contains not printable characters */
    public static IntentFilter m9354() {
        IntentFilter intentFilter = new IntentFilter();
        for (String str : f9210) {
            intentFilter.addAction(str);
        }
        return intentFilter;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m9352(Context context) {
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.NOTIFY_USER_ACCOUNT_NOT_LOGGED_IN"));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m9351(Context context) {
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.NOTIFY_USER_ACCOUNT_ACTIVE"));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m9349(Context context) {
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.NOTIFY_USER_ACCOUNT_DEACTIVE"));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m9355(Context context) {
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.NOTIFY_USER_PROFILE_ACTIVE"));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m9353(Context context) {
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.NOTIFY_USER_PROFILE_DEACTIVE"));
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public static void m9357(Context context) {
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.NOTIFY_USER_PROFILE_TYPE_CHANGED"));
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static void m9358(Context context) {
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.NOTIFY_CURRENT_PROFILE_INVALID"));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m9350(Context context, boolean z) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.NOTIFY_USER_PROFILE_READY_TO_SELECT");
        intent.putExtra("com.netflix.mediaclient.intent.action.EXTRA_USER_PROFILE_SELECTION_RESULT_GO_TO_LOLOMO_FOR_SAME_PROFILE", z);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static void m9348(Context context) {
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.NOTIFY_PROFILES_LIST_UPDATED"));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m9356(Context context, int i, String str) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.NOTIFY_USER_PROFILE_SELECTION_RESULT");
        intent.putExtra("com.netflix.mediaclient.intent.action.EXTRA_USER_PROFILE_SELECTION_RESULT_INT", i);
        if (C1349Bv.m4107(str)) {
            intent.putExtra("com.netflix.mediaclient.intent.action.EXTRA_USER_PROFILE_SELECTION_RESULT_STRING", str);
        }
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static void m9347(Context context) {
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.ACCOUNT_DATA_FETCHED"));
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("RefreshUserMessageRequest.ACTION_UMA_MESSAGE_UPDATED"));
    }
}

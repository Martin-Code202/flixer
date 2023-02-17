package o;

import android.content.Context;
import android.content.Intent;
import com.netflix.mediaclient.NetflixApplication;
/* renamed from: o.ﾘ  reason: contains not printable characters */
public class C1282 {
    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m16841(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            char c = 65535;
            switch (action.hashCode()) {
                case -1801228071:
                    if (action.equals("com.netflix.mediaclient.intent.action.NOTIFICATION_BROWSER_REDIRECT")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1038609530:
                    if (action.equals("com.netflix.mediaclient.intent.action.NOTIFICATION_SHOW_DETAILS")) {
                        c = 3;
                        break;
                    }
                    break;
                case -251256769:
                    if (action.equals("com.netflix.mediaclient.intent.action.NOTIFICATION_CANCELED")) {
                        c = 0;
                        break;
                    }
                    break;
                case 673247706:
                    if (action.equals("com.netflix.mediaclient.intent.action.NOTIFICATION_PLAY")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1850083341:
                    if (action.equals("com.netflix.mediaclient.intent.action.NOTIFICATION_MOVIE_DETAILS")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    m16835(context, intent);
                    return;
                case 1:
                    m16834(context, intent);
                    return;
                case 2:
                    m16837(context, intent);
                    return;
                case 3:
                    m16842(context, intent);
                    return;
                case 4:
                    m16839(context, intent);
                    return;
                default:
                    C1283.m16854("nf_push", "Not supported!");
                    return;
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static Class<?> m16838() {
        return NetflixApplication.getInstance().m254() ? ActivityC2125rn.class : ActivityC2132ru.class;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static Class<?> m16836() {
        return NetflixApplication.getInstance().m254() ? ActivityC2126ro.class : ActivityC2121rj.class;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static void m16842(Context context, Intent intent) {
        C1283.m16854("nf_push", "received show SDP from notification");
        m16843(context, intent);
        intent.setClass(context, m16838());
        intent.addFlags(872415232);
        context.startActivity(intent);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static void m16837(Context context, Intent intent) {
        C1283.m16854("nf_push", "received show MDP from notification");
        m16843(context, intent);
        intent.setClass(context, m16836());
        intent.addFlags(872415232);
        context.startActivity(intent);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static void m16839(Context context, Intent intent) {
        C1283.m16854("nf_push", "received play from notification");
        m16843(context, intent);
        intent.setClass(context, ActivityC2280wv.class);
        intent.addFlags(872415232);
        context.startActivity(intent);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m16835(Context context, Intent intent) {
        C1283.m16854("nf_push", "received notification canceled");
        Intent r2 = m16840(context, intent, "com.netflix.mediaclient.intent.action.NOTIFICATION_CANCELED");
        if (r2 != null) {
            context.startService(r2);
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private static void m16834(Context context, Intent intent) {
        C1283.m16854("nf_push", "received notification browser redirect");
        Intent r2 = m16840(context, intent, "com.netflix.mediaclient.intent.action.NOTIFICATION_BROWSER_REDIRECT");
        if (r2 != null) {
            String stringExtra = intent.getStringExtra("target_url");
            if (stringExtra != null) {
                r2.putExtra("target_url", stringExtra);
            }
            context.startService(r2);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static Intent m16840(Context context, Intent intent, String str) {
        Intent intent2 = new Intent(str);
        intent2.setClass(context, ServiceC0966.class);
        intent2.addCategory("com.netflix.mediaclient.intent.category.PUSH");
        String stringExtra = intent.getStringExtra("swiped_notification_id");
        if (!C1349Bv.m4113(stringExtra)) {
            intent2.putExtra("swiped_notification_id", stringExtra);
        }
        C1999nc.m9277(intent2, C1999nc.m9278(intent));
        return intent2;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private static void m16843(Context context, Intent intent) {
        C1283.m16854("nf_push", "calling service to mark notification as read");
        String stringExtra = intent.getStringExtra("g");
        if (C1349Bv.m4107(stringExtra)) {
            Intent intent2 = new Intent("com.netflix.mediaclient.intent.action.NOTIFICATION_MARK_AS_READ");
            intent2.putExtra("g", stringExtra);
            intent2.setClass(context, ServiceC0966.class);
            intent2.addCategory("com.netflix.mediaclient.intent.category.PUSH");
            context.startService(intent2);
            return;
        }
        C1283.m16850("nf_push", "Got empty notification ID inside markSocialNotificationAsRead()");
    }
}

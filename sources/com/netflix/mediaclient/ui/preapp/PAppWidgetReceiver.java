package com.netflix.mediaclient.ui.preapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.netflix.mediaclient.service.pservice.PDiskData;
import com.netflix.mediaclient.service.pservice.logging.PreAppWidgetLogActionData;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import o.C1283;
import o.C1348Bu;
import o.C1349Bv;
import o.mX;
import o.mY;
import o.qN;
import o.yK;
public class PAppWidgetReceiver extends BroadcastReceiver {

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final Integer f3807 = Integer.MIN_VALUE;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final String f3808 = ("nflx://www.netflix.com/Browse?q=source%3DNetflixWidget" + f3809 + "%26action%3D");

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final String f3809 = ("%26trkid%3D" + qN.f9506);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && !C1349Bv.m4113(intent.getAction()) && m2744(intent)) {
            m2748(context, intent, goAsync());
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m2748(final Context context, final Intent intent, BroadcastReceiver.PendingResult pendingResult) {
        mY mYVar = new mY();
        mYVar.getClass();
        final mY.iF iFVar = new mY.iF(mYVar);
        mYVar.m8981(pendingResult, new Runnable() { // from class: com.netflix.mediaclient.ui.preapp.PAppWidgetReceiver.5
            @Override // java.lang.Runnable
            public void run() {
                PAppWidgetReceiver.m2749(context, intent, iFVar);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m2749(Context context, Intent intent, mY.iF iFVar) {
        C1348Bu.m4094();
        String action = intent.getAction();
        char c = 65535;
        switch (action.hashCode()) {
            case -881854046:
                if (action.equals("com.netflix.mediaclient.intent.action.REFRESH_FROM_PREAPP_WIDGET")) {
                    c = 2;
                    break;
                }
                break;
            case -872165703:
                if (action.equals("com.netflix.mediaclient.intent.action.PLAY_3_FROM_PREAPP_WIDGET")) {
                    c = 6;
                    break;
                }
                break;
            case -463341478:
                if (action.equals("com.netflix.mediaclient.intent.action.PLAY_2_FROM_PREAPP_WIDGET")) {
                    c = 5;
                    break;
                }
                break;
            case -186992729:
                if (action.equals("com.netflix.mediaclient.intent.action.DETAILS_3_FROM_PREAPP_WIDGET")) {
                    c = '\t';
                    break;
                }
                break;
            case -54517253:
                if (action.equals("com.netflix.mediaclient.intent.action.PLAY_1_FROM_PREAPP_WIDGET")) {
                    c = 4;
                    break;
                }
                break;
            case 117936931:
                if (action.equals("com.netflix.mediaclient.intent.action.INSTALLED_FROM_PREAPP_WIDGET")) {
                    c = 0;
                    break;
                }
                break;
            case 221831496:
                if (action.equals("com.netflix.mediaclient.intent.action.DETAILS_2_FROM_PREAPP_WIDGET")) {
                    c = '\b';
                    break;
                }
                break;
            case 630655721:
                if (action.equals("com.netflix.mediaclient.intent.action.DETAILS_1_FROM_PREAPP_WIDGET")) {
                    c = 7;
                    break;
                }
                break;
            case 1292326626:
                if (action.equals("com.netflix.mediaclient.intent.action.HOME_FROM_PREAPP_WIDGET")) {
                    c = 3;
                    break;
                }
                break;
            case 1477311290:
                if (action.equals("com.netflix.mediaclient.intent.action.ACTION_RESIZED_FROM_PREAPP_WIDGET")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
                m2739(context, intent, iFVar);
                return;
            case 3:
                m2743(context, intent, iFVar);
                return;
            case 4:
            case 5:
            case 6:
                m2740(context, intent, iFVar);
                return;
            case 7:
            case '\b':
            case '\t':
                m2745(context, intent, iFVar);
                return;
            default:
                C1283.m16854("nf_widget_receiver", "Not supported!");
                return;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static void m2743(Context context, Intent intent, mY.iF iFVar) {
        C1283.m16854("nf_widget_receiver", "launching nflx home - via deeplink");
        m2750(context, m2741("home", null), m2746(intent), PreAppWidgetLogActionData.PreAppWidgetActionName.HOME.getValue());
        iFVar.m8983();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m2740(Context context, Intent intent, mY.iF iFVar) {
        C1283.m16854("nf_widget_receiver", "launching nflx play - via deeplink");
        m2750(context, m2741("play", intent), m2746(intent), PreAppWidgetLogActionData.PreAppWidgetActionName.START_PLAY.getValue());
        iFVar.m8983();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static void m2745(Context context, Intent intent, mY.iF iFVar) {
        C1283.m16854("nf_widget_receiver", "launching nflx details - via deeplink");
        m2750(context, m2741("view_details", intent), m2746(intent), PreAppWidgetLogActionData.PreAppWidgetActionName.VIEW_TITLE_DETAILS.getValue());
        iFVar.m8983();
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private static void m2739(final Context context, final Intent intent, final mY.iF iFVar) {
        C1283.m16854("nf_widget_receiver", "trying to update widget");
        mX.m8972(context, new mX.C1969iF() { // from class: com.netflix.mediaclient.ui.preapp.PAppWidgetReceiver.2
            @Override // o.mX.C1969iF
            /* renamed from: ˏ  reason: contains not printable characters */
            public void mo2751(PDiskData pDiskData) {
                C1283.m16854("nf_widget_receiver", "got new data, valid: " + (pDiskData != null));
                if (!yK.m13191(pDiskData)) {
                    yK.m13187(context, intent, pDiskData, iFVar);
                } else if (intent.hasExtra("videoIndex")) {
                    int intExtra = intent.getIntExtra("videoIndex", 0);
                    C1283.m16851("nf_widget_receiver", "widget refresh with static images start: %d", Integer.valueOf(intExtra));
                    yK.m13204(context, intExtra, iFVar);
                } else {
                    yK.m13176(context, iFVar);
                    C1283.m16854("nf_widget_receiver", "no data for widget - treating as new install case");
                }
            }
        });
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static Uri m2741(String str, Intent intent) {
        if ("home".equals(str)) {
            return Uri.parse(m2742(str));
        }
        String stringExtra = intent.getStringExtra("videoId");
        String stringExtra2 = intent.getStringExtra("playableId");
        VideoType create = VideoType.create(intent.getStringExtra("videoType"));
        StringBuilder sb = new StringBuilder(m2742(str));
        if (VideoType.SHOW.equals(create)) {
            if (C1349Bv.m4107(stringExtra)) {
                sb.append("%26movieid%3Dhttp%3A%2F%2Fapi-global.netflix.com%2Fcatalog%2Ftitles%2Fseries%2F").append(stringExtra);
            }
            if (C1349Bv.m4107(stringExtra2)) {
                sb.append("%26episodeid%3Dhttp%3A%2F%2Fapi-global.netflix.com%2Fcatalog%2Ftitles%2Fprograms%2F").append(stringExtra2);
            }
        } else if (VideoType.MOVIE.equals(create) && C1349Bv.m4107(stringExtra)) {
            sb.append("%26movieid%3Dhttp%3A%2F%2Fapi-global.netflix.com%2Fcatalog%2Ftitles%2Fmovies%2F").append(stringExtra);
        }
        return Uri.parse(sb.toString());
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m2742(String str) {
        return f3808 + str;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m2750(Context context, Uri uri, int i, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.addFlags(268468224);
        intent.putExtra("FROM_PREAPP_WIDGET", "NetflixWidget");
        intent.putExtra("widgetId", i);
        intent.putExtra("actionName", str);
        context.startActivity(intent);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static int m2746(Intent intent) {
        return intent.getExtras() != null ? intent.getExtras().getInt("widgetId", f3807.intValue()) : f3807.intValue();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m2744(Intent intent) {
        if (intent == null) {
            return false;
        }
        String action = intent.getAction();
        if (C1349Bv.m4113(action)) {
            return false;
        }
        if (C1349Bv.m4126("com.netflix.mediaclient.intent.action.HOME_FROM_PREAPP_WIDGET", action) || intent.hasExtra("videoIndex")) {
            return true;
        }
        if (!intent.hasExtra("videoId") || !intent.hasExtra("playableId") || !intent.hasExtra("videoType")) {
            return false;
        }
        return true;
    }
}

package o;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.netflix.cl.Logger;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.protocol.nflx.NflxHandler;
import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.service.pservice.logging.PServiceLogging;
import com.netflix.mediaclient.service.pservice.logging.PreAppWidgetLogActionData;
import com.netflix.mediaclient.service.pservice.logging.PreAppWidgetLogData;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* renamed from: o.ᖾ  reason: contains not printable characters */
public final class C0918 {
    /* renamed from: ˋ  reason: contains not printable characters */
    public static NflxHandler m15721(NetflixActivity netflixActivity, Intent intent, long j) {
        C1328Ba.m3985(netflixActivity.getServiceManager(), intent);
        m15727(netflixActivity.getApplicationContext(), intent, netflixActivity.getServiceManager().m9789());
        C1283.m16854("NflxHandler", "Handle NFLX intent starts...");
        if (intent == null) {
            C1283.m16846("NflxHandler", "null intent");
            return new C0922();
        } else if (!"android.intent.action.VIEW".equalsIgnoreCase(intent.getAction())) {
            C1283.m16846("NflxHandler", "unknown action");
            return new C0922();
        } else if (intent.getData() == null) {
            C1283.m16846("NflxHandler", "no uri");
            return new C0922();
        } else {
            C1283.m16859("NflxHandler", intent);
            return m15722(netflixActivity, intent.getData(), j);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static NflxHandler m15722(NetflixActivity netflixActivity, Uri uri, long j) {
        AB.m3273("NflxHandler", uri);
        if ("http".equalsIgnoreCase(uri.getScheme()) && "movi.es".equalsIgnoreCase(uri.getHost())) {
            return m15728(netflixActivity, uri.toString(), j);
        }
        if (!"nflx".equalsIgnoreCase(uri.getScheme())) {
            C1283.m16846("NflxHandler", "unknown scheme");
            return new C0922();
        } else if (!"www.netflix.com".equalsIgnoreCase(uri.getHost())) {
            C1283.m16846("NflxHandler", "invalid host");
            return new C0922();
        } else if (!"/browse".equalsIgnoreCase(uri.getPath())) {
            C1283.m16846("NflxHandler", "invalid path");
            return new C0922();
        } else {
            String queryParameter = uri.getQueryParameter("q");
            if (!C1349Bv.m4113(queryParameter)) {
                return m15723(netflixActivity, queryParameter, j);
            }
            C1283.m16846("NflxHandler", "no nflx params");
            return new C0922();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static NflxHandler m15723(NetflixActivity netflixActivity, String str, long j) {
        String[] split = str.split("[?&]");
        HashMap hashMap = new HashMap();
        for (String str2 : split) {
            int indexOf = str2.indexOf("=");
            if (indexOf <= 0) {
                C1283.m16865("NflxHandler", "No params found for: " + str2);
            } else {
                hashMap.put(str2.substring(0, indexOf), str2.substring(indexOf + 1));
            }
        }
        return m15720(netflixActivity, hashMap, j, str);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static NflxHandler m15720(NetflixActivity netflixActivity, Map<String, String> map, long j, String str) {
        NflxHandler nflxHandler;
        if (map.size() <= 0) {
            C1283.m16865("NflxHandler", "no params exist");
            return new C0922();
        } else if (map.get("profileGate") != null) {
            return new C0917(netflixActivity, map, j);
        } else {
            String r6 = C1328Ba.m3979(map);
            if (r6 == null) {
                C1283.m16865("NflxHandler", "Action is null!");
                return new C0922();
            }
            String lowerCase = r6.toLowerCase(Locale.US);
            AppView appView = null;
            boolean z = false;
            NflxHandler.Response response = NflxHandler.Response.HANDLING;
            if ("home".equalsIgnoreCase(lowerCase)) {
                C1283.m16846("NflxHandler", "handleHomeAction starts...");
                z = true;
                appView = AppView.browseTitles;
                nflxHandler = new C0875(netflixActivity, map);
            } else if (C1328Ba.m3982(lowerCase)) {
                C1283.m16846("NflxHandler", "handle play starts...");
                appView = AppView.playback;
                nflxHandler = new C0911(netflixActivity, map);
            } else if (C1328Ba.m3989(lowerCase)) {
                C1283.m16846("NflxHandler", "view details starts...");
                C1364Cj.m4436(UIViewLogging.UIViewCommandName.deepLink, IClientLogging.ModalView.movieDetails, (C1359Ce) null, m15725(map));
                C1364Cj.m4432();
                Logger.INSTANCE.m127(new C0711(1.0f, m15725(map)));
                appView = AppView.movieDetails;
                nflxHandler = new C0946(netflixActivity, map);
            } else if (C1328Ba.m3986(lowerCase)) {
                C1283.m16846("NflxHandler", "genre starts...");
                z = true;
                appView = AppView.browseTitles;
                nflxHandler = new C0829(netflixActivity, map);
            } else if ("search".equalsIgnoreCase(lowerCase)) {
                C1283.m16846("NflxHandler", "search starts...");
                appView = AppView.search;
                nflxHandler = new C0919(netflixActivity, map);
            } else if ("sync".equalsIgnoreCase(lowerCase)) {
                C1283.m16846("NflxHandler", "sync starts...");
                z = true;
                appView = AppView.browseTitles;
                nflxHandler = new C0937(netflixActivity, map);
            } else if ("iq".equalsIgnoreCase(lowerCase)) {
                C1283.m16846("NflxHandler", "Add to instant queue starts...");
                C1364Cj.m4436(UIViewLogging.UIViewCommandName.deepLink, IClientLogging.ModalView.movieDetails, (C1359Ce) null, m15725(map));
                C1364Cj.m4432();
                Logger.INSTANCE.m127(new C0711(1.0f, m15725(map)));
                appView = AppView.movieDetails;
                nflxHandler = new C0909(netflixActivity, map);
            } else if ("download".equalsIgnoreCase(lowerCase)) {
                C1283.m16846("NflxHandler", "Add to donwload queue starts...");
                appView = AppView.movieDetails;
                nflxHandler = new C0906(netflixActivity, map);
            } else {
                C1283.m16865("NflxHandler", "Unknown Nflx action: " + lowerCase);
                nflxHandler = new C0922();
                response = NflxHandler.Response.NOT_HANDLING;
            }
            C1328Ba.m3993(netflixActivity, response, z, appView, j);
            return nflxHandler;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static String m15725(Map<String, String> map) {
        String str = map.get("movieid");
        if (C1349Bv.m4107(str)) {
            return str;
        }
        return C1328Ba.m3988(map);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static NflxHandler m15728(NetflixActivity netflixActivity, String str, long j) {
        netflixActivity.getServiceManager().m9825();
        C1283.m16846("NflxHandler", "view details from tiny url starts...");
        Logger.INSTANCE.m127(new C0711(1.0f, str));
        C1364Cj.m4436(UIViewLogging.UIViewCommandName.deepLink, IClientLogging.ModalView.movieDetails, (C1359Ce) null, str);
        C1364Cj.m4432();
        boolean contains = str.contains("source=android");
        if (contains) {
            C1364Cj.m4436(UIViewLogging.UIViewCommandName.shareOpenSheet, IClientLogging.ModalView.movieDetails, (C1359Ce) null, (String) null);
            C1362Ch.m4395(str, (UserActionLogging.CommandName) null, IClientLogging.ModalView.movieDetails);
            C1364Cj.m4432();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("u", str);
        C1328Ba.m3993(netflixActivity, NflxHandler.Response.HANDLING, false, AppView.movieDetails, j);
        if (contains) {
            C1362Ch.m4398(IClientLogging.CompletionReason.success, (Error) null);
        }
        return new C0946(netflixActivity, hashMap);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static void m15727(Context context, Intent intent, boolean z) {
        if (m15726(intent)) {
            C1283.m16854("NflxHandler", String.format("Nflx action from PreappWidget, log events. Intent=%s", intent));
            PServiceLogging.reportStoredLogEvents(context, z);
            C1362Ch.m4403(UserActionLogging.CommandName.androidWidgetCommand, PreAppWidgetLogData.createInstance(context, intent.getIntExtra("widgetId", 0), z), PreAppWidgetLogActionData.createInstance(intent.getStringExtra("actionName")));
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static boolean m15726(Intent intent) {
        return intent != null && "NetflixWidget".equals(intent.getStringExtra(NetflixActivity.EXTRA_SOURCE));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m15724(Context context, Intent intent) {
        if (m15726(intent)) {
            C1362Ch.m4383(IClientLogging.CompletionReason.success, (UIError) null);
        }
    }
}

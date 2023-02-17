package o;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.netflix.cl.Logger;
import com.netflix.cl.model.AppView;
import com.netflix.cl.util.NamedLogSessionLookup;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.protocol.nflx.NflxHandler;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.util.NotificationUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
/* renamed from: o.Ba  reason: case insensitive filesystem */
public final class C1328Ba {
    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m3979(Map<String, String> map) {
        String str = map.get("action");
        if (C1349Bv.m4113(str)) {
            str = map.get("a");
            if (C1349Bv.m4113(str)) {
                if (m3987(map)) {
                    C1283.m16865("NflxHandler", "Action is empty, but video info is available, default action is video detail!");
                    return "view_details";
                }
                C1283.m16865("NflxHandler", "Action is empty and video info is NOT available, default action is home ");
                return "home";
            }
        }
        return str;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m3987(Map<String, String> map) {
        if (C1349Bv.m4107(map.get("movieid"))) {
            return true;
        }
        return C1349Bv.m4107(m3988(map));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static String m3990(Map<String, String> map) {
        return map.get("trkid");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m3988(Map<String, String> map) {
        String str = map.get("target_url");
        if (C1349Bv.m4113(str)) {
            return map.get("u");
        }
        return str;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m3986(String str) {
        return "genre".equalsIgnoreCase(str) || "g".equalsIgnoreCase(str);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m3989(String str) {
        return "view_details".equalsIgnoreCase(str) || "v".equalsIgnoreCase(str);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m3982(String str) {
        return "play".equalsIgnoreCase(str) || "p".equalsIgnoreCase(str);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static C0070 m3991(String str, Map<String, String> map) {
        try {
            str = URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            C1283.m16847("NflxHandler", "Failed to decode URL", e);
        }
        String r2 = m3983(str, "series/");
        if (r2 != null) {
            return C0070.m3994(r2);
        }
        String r22 = m3983(str, "movies/");
        if (r22 != null) {
            return C0070.m3995(r22);
        }
        if (!C1332Be.m4016(str)) {
            C1283.m16850("NflxHandler", "Unable to get video id! This should NOT happen!");
            return null;
        } else if (map.containsKey("episodeid")) {
            return C0070.m3994(str);
        } else {
            return C0070.m3995(str);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m3983(String str, String str2) {
        int lastIndexOf = str.lastIndexOf(str2);
        if (lastIndexOf <= 0) {
            return null;
        }
        String substring = str.substring(lastIndexOf + str2.length());
        if (C1349Bv.m4113(substring)) {
            C1283.m16846("NflxHandler", "empty video id");
            return null;
        }
        int indexOf = substring.indexOf("/");
        if (indexOf > 0) {
            return substring.substring(indexOf + 1);
        }
        return substring;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m3978(String str) {
        if (C1349Bv.m4113(str)) {
            throw new IllegalArgumentException("Tiny URL can not be empty!");
        }
        if (str.contains("source=android")) {
            str = str.substring(0, str.length() - "source=android".length());
        }
        String[] split = str.split("/");
        if (split != null && split.length >= 2) {
            return split[split.length - 1];
        }
        throw new IllegalArgumentException("Movie ID not found in tiny URL " + str);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static oX m3992(String str) {
        if (C1349Bv.m4107(str)) {
            try {
                return new qN(null, Integer.parseInt(str), 0, 0);
            } catch (Exception e) {
                C1283.m16850("NflxHandler", String.format("Error parsing trackId %s", str));
            }
        }
        return qN.f9503;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m3981(Map<String, String> map) {
        String str = map.get("episodeid");
        if (C1349Bv.m4113(str)) {
            C1283.m16846("NflxHandler", "episode id uri doesn't exist in params map");
            return null;
        }
        try {
            str = URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            C1283.m16847("NflxHandler", "Failed to decode URL", e);
        }
        return m3983(str, "programs/");
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m3977(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        return str.substring(str.contains("uuid:") ? str.indexOf("uuid:") + "uuid:".length() : 0, str.contains("::urn") ? str.indexOf("::urn") : str.length());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m3980(NetflixActivity netflixActivity, Map<String, String> map, long j) {
        m3993(netflixActivity, NflxHandler.Response.HANDLING, true, AppView.profilesGate, j);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m3993(NetflixActivity netflixActivity, NflxHandler.Response response, boolean z, AppView appView, long j) {
        if (response == NflxHandler.Response.HANDLING || response == NflxHandler.Response.HANDLING_WITH_DELAY) {
            Logger.INSTANCE.m142(new C0680(System.currentTimeMillis()));
            if (z) {
                NamedLogSessionLookup.INSTANCE.m152("UiBrowseStartupSession", Logger.INSTANCE.m142(new C1224(null, appView)));
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m3984(Activity activity) {
        if (!C1317As.m3750(activity)) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.HANDLER_RESULT");
            intent.addCategory("LocalIntentNflxUi");
            LocalBroadcastManager.getInstance(activity).sendBroadcast(intent);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m3985(C2059ph phVar, Intent intent) {
        if (phVar == null) {
            C1283.m16865("NflxHandler", "Service manager is null, enable to report that user opened notification");
            return;
        }
        C1283.m16853("NflxHandler", "reportIfSourceIsNotification", intent);
        if (NotificationUtils.m2993(intent)) {
            C1283.m16846("NflxHandler", "From push notification, report.");
            C1999nc r6 = C1999nc.m9278(intent);
            if (r6 == null) {
                C1283.m16850("NflxHandler", "Unable to report since message data are missing!");
            } else {
                Logger.INSTANCE.m131(new C1032(new C2000nd(r6), 0));
            }
        } else {
            C1283.m16854("NflxHandler", "Not from push notification, do not report.");
        }
    }

    /* renamed from: o.Ba$ˋ  reason: contains not printable characters */
    public static class C0070 {

        /* renamed from: ˎ  reason: contains not printable characters */
        public static C0070 f4638 = new C0070(true, VideoType.UNAVAILABLE, (String) null);

        /* renamed from: ˊ  reason: contains not printable characters */
        private final VideoType f4639;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final String f4640;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final boolean f4641;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final String f4642;

        private C0070(boolean z, VideoType videoType, String str) {
            this.f4641 = z;
            this.f4639 = videoType;
            this.f4640 = str;
            this.f4642 = null;
        }

        private C0070(boolean z, String str, String str2) {
            this.f4641 = z;
            this.f4639 = VideoType.EPISODE;
            this.f4640 = str2;
            this.f4642 = str;
        }

        private C0070(boolean z, String str) {
            this.f4641 = z;
            this.f4639 = VideoType.SHOW;
            this.f4640 = str;
            this.f4642 = null;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public String m3998() {
            return this.f4640;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public VideoType m3999() {
            return this.f4639;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public boolean m4000() {
            return this.f4641;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public String m3997() {
            return this.f4642;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public static C0070 m3994(String str) {
            return new C0070(false, VideoType.SHOW, str);
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public static C0070 m3995(String str) {
            return new C0070(false, VideoType.MOVIE, str);
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public static C0070 m3996(String str, String str2) {
            if (C1349Bv.m4126(str, str2)) {
                return new C0070(false, str);
            }
            return new C0070(false, str, str2);
        }
    }
}

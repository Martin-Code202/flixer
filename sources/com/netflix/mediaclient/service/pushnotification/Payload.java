package com.netflix.mediaclient.service.pushnotification;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import o.AK;
import o.C1283;
import o.C1349Bv;
import org.json.JSONException;
import org.json.JSONObject;
public class Payload {

    /* renamed from: ʻ  reason: contains not printable characters */
    public String f2127;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    public String f2128;

    /* renamed from: ʼ  reason: contains not printable characters */
    public String f2129;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    public String f2130;

    /* renamed from: ʽ  reason: contains not printable characters */
    public String f2131;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    public String f2132;

    /* renamed from: ʾ  reason: contains not printable characters */
    public String f2133;

    /* renamed from: ʿ  reason: contains not printable characters */
    public long f2134;

    /* renamed from: ˈ  reason: contains not printable characters */
    public String f2135;

    /* renamed from: ˉ  reason: contains not printable characters */
    private String f2136;

    /* renamed from: ˊ  reason: contains not printable characters */
    public String f2137;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private String f2138;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private String f2139;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public String f2140;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    public String f2141;

    /* renamed from: ˋ  reason: contains not printable characters */
    public String f2142;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private String f2143;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public String f2144;

    /* renamed from: ˌ  reason: contains not printable characters */
    private long f2145;

    /* renamed from: ˍ  reason: contains not printable characters */
    private String f2146;

    /* renamed from: ˎ  reason: contains not printable characters */
    public String f2147;

    /* renamed from: ˏ  reason: contains not printable characters */
    public String f2148;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    protected List<If> f2149 = new ArrayList();

    /* renamed from: ͺ  reason: contains not printable characters */
    public String f2150;

    /* renamed from: ॱ  reason: contains not printable characters */
    public int f2151;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public String f2152;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    public String f2153;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    public String f2154;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public String f2155;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public String f2156;

    /* renamed from: ᐝ  reason: contains not printable characters */
    public String f2157;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public String f2158;

    public enum ActionInfoType {
        EVENT_NOTIFICATION_LIST_CHANGED("N"),
        EVENT_NOTIFICATION_READ("NR"),
        UNKNOWN("");
        

        /* renamed from: ˋ  reason: contains not printable characters */
        private String f2163;

        private ActionInfoType(String str) {
            this.f2163 = str;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public String m1202() {
            return this.f2163;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public static boolean m1200(String str) {
            return C1349Bv.m4126(str, EVENT_NOTIFICATION_LIST_CHANGED.m1202());
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public static boolean m1201(String str) {
            return C1349Bv.m4126(str, EVENT_NOTIFICATION_READ.m1202());
        }
    }

    public Payload(Intent intent) {
        if (intent.hasExtra("bigViewPicture")) {
            this.f2155 = intent.getStringExtra("bigViewPicture");
        }
        if (intent.hasExtra("bigViewSummary")) {
            this.f2150 = intent.getStringExtra("bigViewSummary");
        }
        if (intent.hasExtra("bigViewText")) {
            this.f2129 = intent.getStringExtra("bigViewText");
        }
        if (intent.hasExtra("bigViewTitle")) {
            this.f2144 = intent.getStringExtra("bigViewTitle");
        }
        if (intent.hasExtra("defaultActionKey")) {
            this.f2140 = intent.getStringExtra("defaultActionKey");
        }
        if (intent.hasExtra("defaultActionPayload")) {
            this.f2146 = intent.getStringExtra("defaultActionPayload");
        }
        if (intent.hasExtra("info")) {
            this.f2148 = intent.getStringExtra("info");
        }
        if (intent.hasExtra("largeIcon")) {
            this.f2131 = intent.getStringExtra("largeIcon");
        }
        if (intent.hasExtra("smallIcon")) {
            this.f2127 = intent.getStringExtra("smallIcon");
        }
        if (intent.hasExtra("ledColor")) {
            String stringExtra = intent.getStringExtra("ledColor");
            this.f2151 = C1349Bv.m4103(stringExtra) ? Integer.parseInt(stringExtra) : 0;
        }
        if (intent.hasExtra("sound")) {
            this.f2142 = intent.getStringExtra("sound");
        }
        if (intent.hasExtra("subtext")) {
            this.f2147 = intent.getStringExtra("subtext");
        }
        if (intent.hasExtra("text")) {
            this.f2137 = intent.getStringExtra("text");
        }
        if (intent.hasExtra("ticker")) {
            this.f2139 = intent.getStringExtra("ticker");
        }
        if (intent.hasExtra("title")) {
            this.f2138 = intent.getStringExtra("title");
        }
        if (intent.hasExtra("videoTitle")) {
            this.f2136 = intent.getStringExtra("videoTitle");
        }
        if (intent.hasExtra("videoId")) {
            this.f2143 = intent.getStringExtra("videoId");
        }
        if (intent.hasExtra("vibrate")) {
            this.f2157 = intent.getStringExtra("vibrate");
        }
        if (intent.hasExtra("when")) {
            String stringExtra2 = intent.getStringExtra("when");
            this.f2145 = C1349Bv.m4103(stringExtra2) ? Long.parseLong(stringExtra2) : 0;
        }
        if (intent.hasExtra("guid")) {
            this.f2152 = intent.getStringExtra("guid");
        }
        if (intent.hasExtra("messageGuid")) {
            this.f2158 = intent.getStringExtra("messageGuid");
        }
        if (intent.hasExtra("profileId")) {
            this.f2128 = intent.getStringExtra("profileId");
        }
        if (intent.hasExtra("ping")) {
            this.f2153 = intent.getStringExtra("ping");
        }
        if (intent.hasExtra("type")) {
            this.f2156 = intent.getStringExtra("type");
        }
        if (intent.hasExtra("invisiblePayload")) {
            String stringExtra3 = intent.getStringExtra("invisiblePayload");
            if (C1349Bv.m4107(stringExtra3)) {
                try {
                    JSONObject jSONObject = new JSONObject(stringExtra3);
                    String r6 = AK.m3376(jSONObject, "messageAttributes", (String) null);
                    if (!TextUtils.isEmpty(r6)) {
                        this.f2132 = AK.m3376(new JSONObject(r6), "listContext", (String) null);
                    }
                    this.f2135 = AK.m3376(jSONObject, "cause", (String) null);
                    this.f2130 = AK.m3376(jSONObject, "messageGUID", (String) null);
                    this.f2134 = AK.m3388(jSONObject, "creationTS", System.currentTimeMillis());
                    this.f2141 = AK.m3376(jSONObject, "messageType", (String) null);
                    this.f2133 = AK.m3376(jSONObject, "renoMessageId", (String) null);
                } catch (JSONException e) {
                    C1283.m16847("nf_push", String.format("invalid renoPayload %s", stringExtra3), e);
                }
            }
        }
        this.f2154 = m1189(this.f2146);
        int i = 0;
        while (i > -1) {
            String str = "actionKey." + i;
            if (intent.hasExtra(str)) {
                If r62 = new If(this.f2152);
                r62.f2165 = intent.getStringExtra(str);
                String str2 = "actionIcon." + i;
                if (intent.hasExtra(str2)) {
                    r62.f2164 = intent.getStringExtra(str2);
                }
                String str3 = "actionPayload." + i;
                if (intent.hasExtra(str3)) {
                    r62.f2168 = intent.getStringExtra(str3);
                }
                String str4 = "actionText." + i;
                if (intent.hasExtra(str4)) {
                    r62.f2169 = intent.getStringExtra(str4);
                }
                String str5 = "trackingInfo." + i;
                if (intent.hasExtra(str5)) {
                    r62.f2167 = intent.getStringExtra(str5);
                }
                i++;
                if (r62.f2168 == null || r62.f2169 == null || !If.m1203(r62.f2165)) {
                    C1283.m16850("nf_push", "Invalid action: " + r62);
                } else {
                    this.f2149.add(r62);
                }
            } else {
                i = -1;
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m1199(String str) {
        if (this.f2139 != null) {
            return this.f2139;
        }
        return str;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m1195(String str) {
        if (this.f2138 != null) {
            return this.f2138;
        }
        return str;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m1198(String str) {
        return this.f2136 != null ? this.f2136 : str;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m1194() {
        return this.f2143;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public long m1193() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f2145 >= currentTimeMillis) {
            return this.f2145;
        }
        C1283.m16854("nf_push", "Post notification now!");
        return currentTimeMillis;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public Uri m1197() {
        try {
            return m1190(this.f2146, this.f2140);
        } catch (Throwable th) {
            C1283.m16847("nf_push", "defaultActionPayload URI is wrong: " + this.f2146, th);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public static Uri m1190(String str, String str2) {
        if (C1349Bv.m4113(str)) {
            C1283.m16854("nf_push", "Empty payload, return URI that will launch our application to HOME page");
            return Uri.parse("nflx://www.netflix.com/Browse?q=" + URLEncoder.encode("action=home&source=pn", "UTF-8"));
        } else if (str2 != null && "CUSTOM".equalsIgnoreCase(str2.trim())) {
            return Uri.parse(str);
        } else {
            if (str.toLowerCase(Locale.US).startsWith("nflx://")) {
                return Uri.parse("nflx://www.netflix.com/Browse?q=" + URLEncoder.encode("target_url=" + str, "UTF-8"));
            }
            if (str.toLowerCase(Locale.US).startsWith("https://")) {
                return Uri.parse(str);
            }
            if (str.toLowerCase(Locale.US).startsWith("http://")) {
                return Uri.parse("nflx://www.netflix.com/Browse?q=" + URLEncoder.encode("target_url=" + ("nflx://" + str.substring("http://".length())), "UTF-8"));
            }
            C1283.m16854("nf_push", "Unsuported protocol, return URI that will launch our application to HOME page");
            return Uri.parse("nflx://www.netflix.com/Browse?q=" + URLEncoder.encode("action=home&source=pn", "UTF-8"));
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public If[] m1196() {
        return (If[]) this.f2149.toArray(new If[this.f2149.size()]);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m1191(Payload payload) {
        if (UmaAlert.TYPE_INFO.equals(payload.f2140)) {
            return null;
        }
        if (C1349Bv.m4113(payload.f2138)) {
            return "Payload:: title is missing!";
        }
        if (C1349Bv.m4113(payload.f2137)) {
            return "Payload:: text is missing!";
        }
        if (C1349Bv.m4113(payload.f2140)) {
            return "Payload:: defaultActionPayload is missing!";
        }
        return null;
    }

    public static class If {

        /* renamed from: ʼ  reason: contains not printable characters */
        public String f2164;

        /* renamed from: ˊ  reason: contains not printable characters */
        public String f2165;

        /* renamed from: ˋ  reason: contains not printable characters */
        public String f2166;

        /* renamed from: ˎ  reason: contains not printable characters */
        public String f2167;

        /* renamed from: ˏ  reason: contains not printable characters */
        public String f2168;

        /* renamed from: ॱ  reason: contains not printable characters */
        public String f2169;

        public If(String str) {
            this.f2166 = str;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public Uri m1204() {
            try {
                return Payload.m1190(this.f2168, this.f2165);
            } catch (Throwable th) {
                C1283.m16847("nf_push", "Action.Payload URI is wrong: " + this.f2168, th);
                return null;
            }
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public static boolean m1203(String str) {
            if (str == null) {
                return false;
            }
            return "MDP".equals(str) || "PLAY".equals(str) || "ADD2QUEUE".equals(str) || "DOWNLOAD".equals(str) || "SHARE".equals(str) || "CUSTOM".equals(str);
        }

        public String toString() {
            return "Action [key=" + this.f2165 + ", text=" + this.f2169 + ", payload=" + this.f2168 + ", icon=" + this.f2164 + "]";
        }
    }

    public String toString() {
        return "Payload [title=" + this.f2138 + ", text=" + this.f2137 + ", subtext=" + this.f2147 + ", info=" + this.f2148 + ", ticker=" + this.f2139 + ", ledColor=" + this.f2151 + ", sound=" + this.f2142 + ", vibrate=" + this.f2157 + ", when=" + this.f2145 + ", smallIcon=" + this.f2127 + ", largeIcon=" + this.f2131 + ", bigViewText=" + this.f2129 + ", bigViewPicture=" + this.f2155 + ", bigViewTitle=" + this.f2144 + ", bigViewSummary=" + this.f2150 + ", defaultActionKey=" + this.f2140 + ", defaultActionPayload=" + this.f2146 + ", actions=" + this.f2149 + ", guid=" + this.f2152 + ", messageGuid=" + this.f2158 + "]";
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static String m1189(String str) {
        int indexOf;
        int i;
        int i2;
        if (str == null || (indexOf = str.toLowerCase(Locale.ENGLISH).indexOf("source=")) < 0 || (i = indexOf + 7) >= str.length() || indexOf - 1 < 0) {
            return null;
        }
        char charAt = str.charAt(i2);
        if (charAt == '?' || charAt == '&') {
            String substring = str.substring(i);
            int indexOf2 = substring.indexOf(38);
            if (indexOf2 < 0) {
                return substring.trim();
            }
            return substring.substring(0, indexOf2);
        }
        int i3 = indexOf + 7;
        if (i3 >= str.length()) {
            return null;
        }
        return m1189(str.substring(i3));
    }
}

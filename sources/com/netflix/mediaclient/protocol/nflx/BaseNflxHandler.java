package com.netflix.mediaclient.protocol.nflx;

import android.util.SparseArray;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.BackgroundTask;
import com.netflix.mediaclient.protocol.nflx.NflxHandler;
import java.util.Map;
import o.C0875;
import o.C1283;
import o.C1319Au;
import o.C1328Ba;
import o.C1348Bu;
import o.C1349Bv;
public abstract class BaseNflxHandler implements NflxHandler {

    /* renamed from: ˋ  reason: contains not printable characters */
    public NetflixActivity f1040;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected Map<String, String> f1041;

    /* renamed from: ˋ  reason: contains not printable characters */
    public abstract NflxHandler.Response mo485(String str, String str2, String str3);

    /* renamed from: ॱ  reason: contains not printable characters */
    public abstract NflxHandler.Response mo488(String str, String str2, String str3);

    protected BaseNflxHandler(NetflixActivity netflixActivity, Map<String, String> map) {
        this.f1040 = netflixActivity;
        this.f1041 = map;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m487() {
        new C0875(this.f1040, this.f1041).c_();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public C1328Ba.C0070 m489() {
        C1328Ba.C0070 r5;
        String str = this.f1041.get("movieid");
        if (C1349Bv.m4113(str)) {
            return m486();
        }
        C1328Ba.C0070 r3 = C1328Ba.m3991(str, this.f1041);
        String r4 = C1328Ba.m3981(this.f1041);
        return (!C1349Bv.m4107(r4) || r3 == null || (r5 = C1328Ba.C0070.m3996(r3.m3998(), r4)) == null) ? r3 : r5;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public C1328Ba.C0070 m486() {
        final String r2 = C1328Ba.m3988(this.f1041);
        if (C1349Bv.m4113(r2)) {
            C1283.m16846("NflxHandler", "movie id uri and tiny url both doesn't exist in params map");
            return null;
        }
        C1283.m16846("NflxHandler", "movie id uri doesn't exist in params map, but tiny url does. Resolve it");
        new BackgroundTask().m285(new Runnable() { // from class: com.netflix.mediaclient.protocol.nflx.BaseNflxHandler.2
            @Override // java.lang.Runnable
            public void run() {
                C1283.m16854("NflxHandler", "Resolving tiny URL in background");
                BaseNflxHandler.this.m484(r2, C1328Ba.m3977(BaseNflxHandler.this.f1041.get("targetid")), C1328Ba.m3990(BaseNflxHandler.this.f1041));
            }
        });
        return C1328Ba.C0070.f4638;
    }

    public enum TinyTypes {
        NO_TYPE,
        MOVIE_TYPE,
        DISC_TYPE,
        PROGRAM_TYPE,
        SERIES_TYPE,
        SEASON_TYPE,
        CLIP_TYPE,
        PERSON_TYPE;
        

        /* renamed from: ʽ  reason: contains not printable characters */
        private static final SparseArray<TinyTypes> f1046 = new SparseArray<>();

        static {
            TinyTypes[] values = values();
            for (TinyTypes tinyTypes : values) {
                f1046.put(tinyTypes.ordinal(), tinyTypes);
            }
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public static TinyTypes m490(int i) {
            return f1046.get(i);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m484(String str, String str2, String str3) {
        C1348Bu.m4094();
        NflxHandler.Response response = NflxHandler.Response.HANDLING;
        try {
            String valueOf = String.valueOf(C1319Au.m3786(C1328Ba.m3978(str), 62));
            boolean z = TinyTypes.MOVIE_TYPE == TinyTypes.m490(Integer.parseInt(valueOf.substring(0, 1)));
            String substring = valueOf.substring(1);
            if (C1349Bv.m4113(substring)) {
                C1283.m16850("NflxHandler", "No catalog_title in JSON object! Go to LOLOMO.");
                m487();
            } else if (z) {
                C1283.m16854("NflxHandler", "This was a movie url");
                response = mo485(substring, str2, str3);
            } else {
                C1283.m16854("NflxHandler", "This was a TV Show url");
                response = mo488(substring, str2, str3);
            }
        } catch (Throwable th) {
            C1283.m16847("NflxHandler", "We failed to get expanded URL ", th);
            m487();
        }
        if (!NflxHandler.Response.HANDLING_WITH_DELAY.equals(response)) {
            C1328Ba.m3984(this.f1040);
        }
    }
}

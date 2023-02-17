package com.netflix.mediaclient.service.webclient.volley;

import android.content.Context;
import android.os.SystemClock;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.service.logging.logblob.LogBlobType;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.Logblob;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import o.AbstractApplicationC1258;
import o.AbstractC1542bQ;
import o.AbstractC2039oo;
import o.C0681;
import o.C0685;
import o.C0886;
import o.C0950;
import o.C0956;
import o.C1283;
import o.C2034oj;
import o.C2043os;
import org.json.JSONException;
public class FtlController implements AbstractC2039oo {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final long f2349 = TimeUnit.MINUTES.toMillis(5);

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final long f2350 = TimeUnit.SECONDS.toMillis(30);

    /* renamed from: ʻ  reason: contains not printable characters */
    private long f2351;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final AtomicBoolean f2352 = new AtomicBoolean(false);

    /* renamed from: ʽ  reason: contains not printable characters */
    private final AtomicBoolean f2353 = new AtomicBoolean(false);

    /* renamed from: ˋ  reason: contains not printable characters */
    private final IClientLogging f2354;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private long f2355;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f2356 = false;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private C2043os f2357;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Context f2358 = AbstractApplicationC1258.m16692();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private FtlSessionLogblob.SessionType f2359 = FtlSessionLogblob.SessionType.COLD;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f2360 = -1;

    @Override // o.AbstractC2039oo
    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean mo1469() {
        return this.f2356;
    }

    @Override // o.AbstractC2039oo
    /* renamed from: ॱ  reason: contains not printable characters */
    public String mo1470(Context context) {
        return C2034oj.m9657(context);
    }

    public FtlController(IClientLogging iClientLogging) {
        this.f2354 = iClientLogging;
    }

    @Override // o.AbstractC2039oo
    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean mo1467() {
        boolean z = C0681.m14920(this.f2358) || C0685.m14964(this.f2358);
        if (z && m1463() && !this.f2353.getAndSet(true)) {
            Logger.INSTANCE.m127(new C0886());
        }
        return z;
    }

    @Override // o.AbstractC2039oo
    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean mo1471() {
        boolean z = mo1467() && !this.f2356;
        if (z && m1463() && !this.f2352.getAndSet(true)) {
            this.f2354.mo1512().mo5226(new FtlSessionLogblob(this.f2358, this.f2359));
        }
        return z;
    }

    @Override // o.AbstractC2039oo
    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized void mo1468(int i, Logblob logblob) {
        if (!this.f2356) {
            this.f2356 = true;
            this.f2351 = SystemClock.elapsedRealtime();
            this.f2355 = 0;
            this.f2352.set(false);
            this.f2360 = i;
            this.f2354.mo1512().mo5226(logblob);
            Logger.INSTANCE.m127(new C0950());
        }
    }

    @Override // o.AbstractC2039oo
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo1464() {
        if (SystemClock.elapsedRealtime() > this.f2351 + f2349) {
            m1461(FtlSessionLogblob.SessionType.NETWORK);
        }
    }

    @Override // o.AbstractC2039oo
    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized void mo1466(String str) {
        if (m1460()) {
            if (this.f2357 == null || !this.f2357.m9710().equals(str)) {
                C2043os osVar = new C2043os(str);
                if (mo1471() == osVar.m9709()) {
                    m1462(this.f2357, osVar);
                    this.f2357 = osVar;
                } else {
                    return;
                }
            }
            this.f2355 = SystemClock.elapsedRealtime();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private synchronized void m1461(FtlSessionLogblob.SessionType sessionType) {
        if (this.f2356) {
            this.f2356 = false;
            this.f2359 = sessionType;
            Logger.INSTANCE.m137("FtlFallbackMode");
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m1462(C2043os osVar, C2043os osVar2) {
        if (osVar != null && osVar.m9709()) {
            Logger.INSTANCE.m137("FtlConnection");
        }
        if (osVar2 != null && mo1467() && osVar2.m9709()) {
            Logger.INSTANCE.m127(new C0956(osVar2.m9710()));
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean m1460() {
        if (!m1463()) {
            return false;
        }
        if (this.f2357 != null && SystemClock.elapsedRealtime() <= this.f2355 + f2350) {
            return false;
        }
        return true;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean m1463() {
        return (this.f2354.mo1512() == null || this.f2354.mo1520() == null) ? false : true;
    }

    @Override // o.AbstractC2039oo
    /* renamed from: ˋ  reason: contains not printable characters */
    public int mo1465() {
        return this.f2360;
    }

    @Override // o.AbstractC2039oo
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public C2043os mo1472() {
        return this.f2357;
    }

    /* access modifiers changed from: package-private */
    public static class FtlSessionLogblob extends AbstractC1542bQ {

        public enum SessionType {
            COLD("cold"),
            WARM("warm"),
            NETWORK("networkchange");
            

            /* renamed from: ˋ  reason: contains not printable characters */
            private final String f2365;

            private SessionType(String str) {
                this.f2365 = str;
            }

            /* renamed from: ˎ  reason: contains not printable characters */
            public String m1473() {
                return this.f2365;
            }
        }

        public FtlSessionLogblob(Context context, SessionType sessionType) {
            try {
                this.f6134.put("hostname", C2034oj.m9657(context));
                this.f6134.put("proto", "https");
                this.f6134.put("sessiontype", sessionType.m1473());
            } catch (JSONException e) {
                C1283.m16850("FtlController", "unable to create ftlsession logblob");
            }
        }

        @Override // com.netflix.mediaclient.servicemgr.Logblob
        /* renamed from: ˋ */
        public String mo680() {
            return LogBlobType.FTL_SESSION.m602();
        }
    }

    public static class iF extends AbstractC1542bQ {
        public iF(Context context, int i, StatusCode statusCode, String str, String str2, long j, String str3) {
            try {
                this.f6134.put("hostname", C2034oj.m9657(context));
                this.f6134.put("proto", "https");
                this.f6134.put("error_code", i);
                this.f6134.put("pf_error_code", statusCode != null ? statusCode.m271() : 0);
                this.f6134.put(SignupConstants.Mode.FALLBACK, true);
                this.f6134.put("msg", str);
                this.f6134.put("comp", "unified");
                this.f6134.put("via", str2);
                this.f6134.put("time", j);
                this.f6134.put("tag", str3);
            } catch (JSONException e) {
                C1283.m16850("FtlController", "unable to create ftlfallback logblob");
            }
        }

        @Override // com.netflix.mediaclient.servicemgr.Logblob
        /* renamed from: ˋ */
        public String mo680() {
            return LogBlobType.FTL_RECOVERY.m602();
        }
    }
}

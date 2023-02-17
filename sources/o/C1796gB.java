package o;

import android.content.Context;
import com.netflix.mediaclient.service.logging.client.model.Event;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
import com.netflix.mediaclient.service.msl.client.EsnMigrationFailedException;
import com.netflix.mediaclient.service.msl.client.MslErrorException;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.service.webclient.ApiEndpointRegistry;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
import com.netflix.mediaclient.util.net.AuthorizationCredentials;
import com.netflix.msl.MslException;
import com.netflix.msl.MslInternalException;
import com.netflix.msl.msg.MessageContext;
import com.netflix.msl.msg.MslControl;
import com.netflix.msl.util.MslContext;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import o.oD;
/* renamed from: o.gB  reason: case insensitive filesystem */
public final class C1796gB implements CP<DF>, AbstractC2064pm {

    /* renamed from: ʻ  reason: contains not printable characters */
    private AbstractC1221 f6838;

    /* renamed from: ʼ  reason: contains not printable characters */
    private MslControl f6839;

    /* renamed from: ʽ  reason: contains not printable characters */
    private CW f6840;

    /* renamed from: ˊ  reason: contains not printable characters */
    private AtomicBoolean f6841 = new AtomicBoolean(false);

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private UserAgentInterface f6842;

    /* renamed from: ˋ  reason: contains not printable characters */
    private Context f6843;

    /* renamed from: ˎ  reason: contains not printable characters */
    private C1801gG f6844;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC0661 f6845;

    /* renamed from: ॱ  reason: contains not printable characters */
    private CQ f6846;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private DK f6847;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private C1805gK f6848;

    public C1796gB(Context context, AbstractC1221 r7, UserAgentInterface userAgentInterface, AbstractC0661 r9) {
        this.f6845 = r9;
        C1418Ei.m4893(new C1421El());
        this.f6848 = new C1805gK();
        this.f6843 = context;
        this.f6839 = new MslControl(0, new DQ(), C1061.m16114().mo14178(context));
        C1283.m16851("nf_msl", "ESN %s", r7.d_().mo14449());
        this.f6840 = new C1839gy(context);
        this.f6847 = new C1795gA(this.f6848);
        this.f6838 = r7;
        this.f6844 = new C1799gE(context, userAgentInterface, this.f6848);
        this.f6846 = m6466(r7.d_().mo14449(), this.f6840, this.f6844);
        C1283.m16851("nf_msl", "Do we need to clear MSL store (ESN migration is needed: %b): false", Boolean.valueOf(this.f6838.e_()));
        ((C1799gE) this.f6844).m6536(this.f6846, false);
        this.f6842 = userAgentInterface;
        m6478();
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private void m6478() {
        if (this.f6838.e_()) {
            C1283.m16854("nf_msl", "handleEsnMigration:: ESN migration required, start...");
            try {
                this.f6844.m6555();
                m6484();
                this.f6844.m6554();
            } catch (EsnMigrationFailedException e) {
                C1283.m16856("nf_msl", e, "ESN migration failed, blow MSL store and redo all...", new Object[0]);
                m6470();
            }
        }
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private void m6470() {
        C1283.m16854("nf_msl", "handleEsnMigrationFailure:: force clear MSL store to log user out!");
        m6485();
        C1276.m16820().mo5727("ESN migration failed!");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private iF m6477(URL url, byte[] bArr) {
        CS r4 = CS.m4304().m4308((Boolean) true).m4313(this).m4312(bArr).m4311(this.f6847).m4314();
        iF iFVar = new iF();
        iFVar.f6849 = new C1797gC(this.f6845, url);
        iFVar.f6850 = this.f6839.m3158(this.f6846, r4, iFVar.f6849, SubtitleDownloadRetryPolicy.DEFAULT_INITIAL_INTERVAL_MS);
        return iFVar;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private iF m6481(String str, byte[] bArr, String str2, AbstractC1412Ec ec, Boolean bool, Object obj) {
        URL r4 = m6509(str, obj);
        MessageContext r5 = m6471(bArr, str2, ec, bool);
        iF iFVar = new iF();
        iFVar.f6849 = new C1797gC(this.f6845, r4);
        iFVar.f6850 = this.f6839.m3158(this.f6846, r5, iFVar.f6849, SubtitleDownloadRetryPolicy.DEFAULT_INITIAL_INTERVAL_MS);
        return iFVar;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private iF m6480(String str, byte[] bArr, MslContext mslContext, String str2, AbstractC1412Ec ec, Boolean bool, Object obj) {
        URL r3 = m6509(str, obj);
        MessageContext r4 = m6471(bArr, str2, ec, bool);
        iF iFVar = new iF();
        iFVar.f6849 = new C1797gC(this.f6845, r3);
        iFVar.f6850 = this.f6839.m3158(mslContext, r4, iFVar.f6849, SubtitleDownloadRetryPolicy.DEFAULT_INITIAL_INTERVAL_MS);
        return iFVar;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private MessageContext m6471(byte[] bArr, String str, AbstractC1412Ec ec, Boolean bool) {
        if (ec instanceof C1413Ed) {
            return C1798gD.m6517().m6522(ec).m6519(this).m6523(bArr).m6521(str).m6525(bool).m6524(this.f6847).m6518((Boolean) true).m6520();
        }
        return CS.m4304().m4309(ec).m4313(this).m4312(bArr).m4315(str).m4310(bool).m4311(this.f6847).m4314();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private CQ m6466(String str, AbstractC1397Dn dn, AbstractC1417Eh eh) {
        HashMap hashMap = new HashMap();
        hashMap.put(C1391Dh.f5422, new C1395Dl(dn, new C1804gJ()));
        hashMap.put(C1391Dh.f5420, new C1396Dm(new C1840gz(this.f6838.d_())));
        HashMap hashMap2 = new HashMap();
        hashMap2.put(DA.f5246, new C1806gL());
        return CQ.m4291().m4294(new C1393Dj(str)).m4295(eh).m4293(hashMap).m4296(hashMap2).m4297(this.f6848).m4292();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private CQ m6472(String str, C1389Df df, AbstractC1397Dn dn, AbstractC1417Eh eh, DV dv) {
        HashMap hashMap = new HashMap();
        hashMap.put(C1391Dh.f5422, new C1395Dl(dn, new C1804gJ()));
        hashMap.put(C1391Dh.f5420, new C1396Dm(new C1840gz(this.f6838.d_())));
        hashMap.put(C1392Di.f5433, new C1388De(new C1840gz(new C0538(str)), dv));
        HashMap hashMap2 = new HashMap();
        hashMap2.put(DA.f5246, new C1806gL());
        return CQ.m4291().m4294(df).m4295(eh).m4293(hashMap).m4296(hashMap2).m4297(this.f6848).m4292();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C0355 m6493(Long l, Long l2) {
        C0355 r3 = new C0355();
        C0355 r4 = new C0355();
        if (l != null) {
            r4.m13981("hash", l.longValue());
        }
        r3.m13986("msltruststore", r4);
        C0355 r5 = new C0355();
        if (l != null) {
            r5.m13981("hash", l.longValue());
        }
        r3.m13986("ssltruststore", r5);
        r3.m13978("retrystrategy", 1);
        return r3;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m6508(String str, String str2, Map<String, String> map, String str3, String str4) {
        C0355 r2 = new C0355();
        C0355 r3 = new C0355();
        r3.m13986(FalkorPathResult.PATH, str);
        C0355 r4 = new C0355();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                r4.m13986(entry.getKey(), entry.getValue());
            }
        }
        r3.m13986("query", str3 != null ? str3 : new C0355());
        r3.m13986("headers", r4);
        if (C1349Bv.m4107(str4)) {
            C0355 r5 = new C0355();
            r3.m13986("payload", r5);
            r5.m13986(Event.DATA, str4);
        }
        if (C1349Bv.m4107(str2)) {
            r3.m13986("method", str2);
        }
        C0572 r52 = new C0572();
        r52.m14672(r2);
        r52.m14672(r3);
        return r52.toString();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public CR m6496(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        C1283.m16845("nf_msl", "unwrapApiResponse::raw JSON: " + str);
        C0572 r4 = new C0572(str);
        String r6 = r4.m14667(0).m13980("edgemsl-version");
        C0355 r7 = r4.m14667(1);
        Map<String, Object> r8 = C1811gQ.m6590(r7, "headers");
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Object> entry : r8.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue().toString());
        }
        int intValue = Integer.valueOf(r7.m13980("status")).intValue();
        C0355 r13 = r7.m13977("payload");
        byte[] bArr2 = null;
        if (r13.m13991(Event.DATA)) {
            C1283.m16854("nf_msl", "unwrapApiResponse::Base64 received");
            bArr2 = C1418Ei.m4894(r13.m13980(Event.DATA));
        } else if (r13.m13991("json")) {
            C1283.m16854("nf_msl", "unwrapApiResponse::Json received");
            Object r15 = r13.m13984("json");
            if (r15 instanceof String) {
                bArr2 = ((String) r15).getBytes("UTF-8");
            } else if (r15 instanceof C0355) {
                bArr2 = ((C0355) r15).m13990(2).getBytes("UTF-8");
            } else if (r15 instanceof C0572) {
                bArr2 = ((C0572) r15).m14674(2).getBytes("UTF-8");
            } else {
                throw new IllegalStateException("Only String/JSONObject/JSONArray are supported");
            }
        } else {
            C1283.m16865("nf_msl", "No payload contents in data or json");
        }
        return new CR(r6, hashMap, intValue, bArr2);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C0355 m6510(C0355 r10) {
        boolean r5 = this.f6838.mo16547().mo1459();
        URL r6 = this.f6838.mo16547().mo9650(this.f6838.d_().mo14442());
        if (!r5) {
            C1283.m16851("nf_msl", "AppBoot server does NOT support HTTPS, execute by http only %s", r6.toExternalForm());
            return m6473(r6, r10);
        }
        C1283.m16851("nf_msl", "AppBoot server does support HTTPS, execute first by https, url %s", r6.toExternalForm());
        try {
            return m6473(r6, r10);
        } catch (Throwable th) {
            C1283.m16856("nf_msl", th, "Failed to execute appBoot using https! Trying http", new Object[0]);
            String replaceFirst = r6.toExternalForm().replaceFirst("^https", "http");
            C1283.m16851("nf_msl", "AppBoot server execute second time by http, url %s", replaceFirst);
            return m6473(new URL(replaceFirst), r10);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C0355 m6503(String str, C0355 r3) {
        return m6473(m6479(str), r3);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private URL m6479(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("/appboot/").append(this.f6838.d_().mo14442());
        try {
            return new URL(sb.toString());
        } catch (MalformedURLException e) {
            throw new IllegalStateException("Unable to create URL", e);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private C0355 m6473(URL url, C0355 r13) {
        iF iFVar = null;
        try {
            iFVar = m6477(url, r13.toString().getBytes(Charset.forName("UTF-8")));
            String str = new String(m6494(iFVar.f6850), Charset.forName("UTF-8"));
            C1283.m16851("nf_msl", "AppBoot response body: %s", str);
            C0355 r8 = new C0355(str);
            m6483(r8, this.f6840);
            m6475(iFVar);
            return r8;
        } catch (MalformedURLException e) {
            throw new MslInternalException("Unable to parse our own url for " + url, e);
        } catch (Throwable th) {
            m6475(iFVar);
            throw th;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m6483(C0355 r12, CW cw) {
        if (cw == null) {
            C1283.m16865("nf_msl", "extractMslTrustStore:: rsaStore is null!");
        } else if (r12.m13991(ExceptionClEvent.CATEGORY_VALUE)) {
            C1283.m16865("nf_msl", "Error in appboot response, pass whole response to be handled");
        } else if (!r12.m13991("msltruststore")) {
            throw new MslException(CT.f4804, String.format("Unable to find msltruststore in appboot response (%s)", r12));
        } else {
            C0355 r6 = r12.m13977("msltruststore");
            if (r6.m13991(ExceptionClEvent.CATEGORY_VALUE)) {
                throw new MslException(CT.f4804, String.format("Unable to get msltruststore from appboot response because of error (%s)", r12.m13980(ExceptionClEvent.CATEGORY_VALUE)));
            } else if (!r6.m13991("keys")) {
                throw new MslException(CT.f4804, String.format("Unable to find msltruststore keys in appboot response (%s)", r12));
            } else {
                C0355 r7 = r6.m13977("keys");
                Iterator r8 = r7.m13974();
                while (r8.hasNext()) {
                    String str = (String) r8.next();
                    cw.mo4321(str, r7.m13980(str));
                }
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public byte[] m6498(String str, byte[] bArr, String str2, AbstractC1412Ec ec, Boolean bool, Object obj) {
        iF r1 = m6481(str, bArr, str2, ec, bool, obj);
        try {
            return m6494(r1.f6850);
        } finally {
            m6475(r1);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private byte[] m6476(String str, byte[] bArr, MslContext mslContext, String str2, AbstractC1412Ec ec, Boolean bool, Object obj) {
        iF r1 = m6480(str, bArr, mslContext, str2, ec, bool, obj);
        try {
            return m6494(r1.f6850);
        } finally {
            m6475(r1);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m6467(MslContext mslContext, String str, AbstractC1412Ec ec) {
        oD.Cif ifVar = new oD.Cif("/android/6.1/api", "GET", null, "path%3D%5B%27ping%27%5D", null);
        C1283.m16851("nf_msl", "ping:: raw api response: %s", new String(m6496(m6476(this.f6838.mo16547().mo9651("/msl").toExternalForm(), m6508(ifVar.f9230, ifVar.f9229, ifVar.f9228, ifVar.f9226, ifVar.f9227).getBytes("UTF-8"), mslContext, str, ec, Boolean.FALSE, "PING")).m4299(), "UTF-8"));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public URL m6509(String str, Object obj) {
        try {
            URL url = new URL(str);
            URL url2 = new URL(url.getProtocol(), url.getHost(), "msl" + url.getPath());
            if (obj instanceof String) {
                return new URL(url2.toExternalForm() + "/" + ((String) obj));
            }
            if (obj != null) {
                return new URL(url2.toExternalForm() + "/" + obj.toString());
            }
            return url2;
        } catch (MalformedURLException e) {
            C1283.m16867("nf_msl", e, "Failed to add TAG to URL");
            return this.f6838.mo16547().mo9651("/msl");
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public byte[] m6494(Future<MslControl.C0058> future) {
        try {
            MslControl.C0058 r4 = future.get();
            if (r4 == null) {
                throw new IllegalStateException("No MslChannel");
            }
            DP dp = r4.f4194;
            C1283.m16854("nf_msl", "processRequest:: check input stream for error... ");
            DD r42 = dp.m4668();
            if (r42 != null) {
                m6474(r42);
                throw new MslErrorException(r42);
            }
            C1283.m16854("nf_msl", "processRequest:: response received... ");
            return C1419Ej.m4897(dp, 16384);
        } catch (ExecutionException e) {
            C1283.m16856("nf_msl", e, "Execution exception: ", new Object[0]);
            Throwable cause = e.getCause();
            if (cause instanceof MslException) {
                C1283.m16850("nf_msl", "MSL exception found ");
                throw ((MslException) cause);
            } else if (cause instanceof RuntimeException) {
                C1283.m16850("nf_msl", "Runtime exception found ");
                throw ((RuntimeException) cause);
            } else {
                throw new RuntimeException(cause);
            }
        } catch (InterruptedException e2) {
            C1283.m16856("nf_msl", e2, "Interrupted exception found ", new Object[0]);
            throw new RuntimeException(e2);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m6474(DD dd) {
        boolean z = false;
        synchronized (this.f6841) {
            if (this.f6841.get()) {
                C1283.m16865("nf_msl", "Entity mismatch already processed, do nothing!");
                return;
            } else if (dd.m4592() == 106030) {
                C1283.m16850("nf_msl", "Message sender is not the master token entity, log user out!");
                this.f6841.set(true);
                z = true;
            } else {
                this.f6841.set(false);
            }
        }
        if (z) {
            m6468();
        }
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private void m6468() {
        m6485();
        this.f6842.mo1368(true);
        C1276.m16820().mo5727("MSL entity mismatch handled.");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m6475(iF iFVar) {
        if (iFVar == null) {
            throw new IllegalStateException("MSL channel and URL not known! This should NOT happen!");
        } else if (iFVar.f6849 == null) {
            throw new IllegalStateException("MSL URL not known! This should NOT happen!");
        } else {
            iFVar.f6849.m6516();
        }
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private void m6484() {
        DV r6 = this.f6844.mo4884();
        if (r6 == null) {
            m6485();
            return;
        }
        String r7 = C1339Bl.m4045(m6500(), "useragent_current_profile_id", (String) null);
        if (r7 == null) {
            m6485();
            return;
        }
        C1411Eb r8 = this.f6844.mo4889(r7);
        if (r8 == null) {
            m6485();
            return;
        }
        C1389Df df = new C1389Df(this.f6846, r6, new C1393Dj(this.f6838.d_().mo14449()));
        C1801gG gGVar = new C1801gG(this.f6843, this.f6842, this.f6848);
        MslContext r11 = m6472(this.f6838.d_().mo14449(), df, this.f6840, gGVar, r6);
        AbstractC1412Ec dx = new DX(this.f6846, this.f6844.mo4884(), r8, this.f6838.d_().mo14449());
        try {
            m6467(r11, r7, dx);
        } catch (IOException e) {
            C1283.m16856("nf_msl", e, "migrateESN: ping() failed with error, retry", new Object[0]);
            m6467(r11, r7, dx);
        } catch (MslException e2) {
            C1283.m16856("nf_msl", e2, "migrateESN: ping() failed with error: ", new Object[0]);
            throw new EsnMigrationFailedException();
        } catch (MslErrorException e3) {
            C1283.m16856("nf_msl", e3, "migrateESN: ping() failed with error: ", new Object[0]);
            throw new EsnMigrationFailedException();
        } catch (Throwable th) {
            C1283.m16856("nf_msl", e, "migrateESN: ping() failed second time, report", new Object[0]);
            throw new EsnMigrationFailedException();
        }
        this.f6844 = gGVar;
        this.f6846 = m6466(this.f6838.d_().mo14449(), this.f6840, this.f6844);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public ApiEndpointRegistry m6495() {
        return this.f6838.mo16547();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public Context m6500() {
        return this.f6843;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m6490() {
        return this.f6838.mo16547().mo1451("/msl");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C1411Eb m6492(String str) {
        return this.f6844.mo4889(str);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m6506() {
        return this.f6844.m6561();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized void m6511() {
        this.f6844.m6556();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.gB$iF */
    public static class iF {

        /* renamed from: ˎ  reason: contains not printable characters */
        public C1797gC f6849;

        /* renamed from: ॱ  reason: contains not printable characters */
        public Future<MslControl.C0058> f6850;

        private iF() {
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public DF mo4290() {
        C1283.m16854("nf_msl", "WidevineKeyRequestDataProvider::get:");
        return C0480.m14408().mo14354();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private iF m6482(byte[] bArr, Map<String, String> map, String str, AbstractC1412Ec ec, Boolean bool) {
        URL url = new URL(m6489());
        CS r5 = CS.m4304().m4309(ec).m4313(this).m4312(bArr).m4315(str).m4310(bool).m4311(this.f6847).m4314();
        iF iFVar = new iF();
        iFVar.f6849 = new C1797gC(this.f6845, url, map);
        iFVar.f6850 = this.f6839.m3158(this.f6846, r5, iFVar.f6849, SubtitleDownloadRetryPolicy.DEFAULT_INITIAL_INTERVAL_MS);
        return iFVar;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public byte[] m6512(byte[] bArr, Map<String, String> map, String str, AbstractC1412Ec ec) {
        iF r6 = m6482(bArr, map, str, ec, Boolean.FALSE);
        try {
            return m6494(r6.f6850);
        } finally {
            m6475(r6);
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public String m6489() {
        return this.f6838.mo16547().mo1455("/presentationtracking/users/presentationtracking");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private iF m6469(byte[] bArr, Map<String, String> map, String str, AbstractC1412Ec ec, Boolean bool, boolean z) {
        URL url = new URL(m6491(z));
        CS r5 = CS.m4304().m4309(ec).m4313(this).m4312(bArr).m4315(str).m4310(bool).m4311(this.f6847).m4314();
        iF iFVar = new iF();
        iFVar.f6849 = new C1797gC(this.f6845, url, map);
        iFVar.f6850 = this.f6839.m3158(this.f6846, r5, iFVar.f6849, SubtitleDownloadRetryPolicy.DEFAULT_INITIAL_INTERVAL_MS);
        return iFVar;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m6491(boolean z) {
        if (z) {
            return this.f6838.mo16547().mo1455("/ichnaea/cl2");
        }
        return this.f6838.mo16547().mo1455("/ichnaea/log");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public byte[] m6499(byte[] bArr, Map<String, String> map, String str, AbstractC1412Ec ec) {
        iF r7 = m6469(bArr, map, str, ec, Boolean.FALSE, false);
        try {
            return m6494(r7.f6850);
        } finally {
            m6475(r7);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public byte[] m6501(byte[] bArr, Map<String, String> map, String str, AbstractC1412Ec ec) {
        iF r7 = m6469(bArr, map, str, ec, Boolean.FALSE, true);
        try {
            return m6494(r7.f6850);
        } finally {
            m6475(r7);
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public synchronized oD.If m6514() {
        oD.If r1;
        r1 = this.f6844.m6560();
        this.f6844.m6555();
        return r1;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m6505(String str, String str2) {
        this.f6844.m6557(str, str2);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public oD.C0159 m6497(String str) {
        DV r4;
        C1283.m16851("nf_msl", "getMslTokensAndCrypto (from MDX) with userid %s", str);
        if (!C1349Bv.m4107(str) || (r4 = this.f6844.mo4884()) == null) {
            return null;
        }
        C1411Eb r5 = this.f6844.mo4889(str);
        AbstractC1386Dc r6 = this.f6844.mo4888(r4);
        if (r4 == null || r5 == null || r6 == null) {
            return null;
        }
        return new oD.C0159(r4, r5, r6);
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public AbstractC1400Dq m6487() {
        return this.f6848;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public C1407Dx m6513() {
        return C1407Dx.f5471;
    }

    @Override // o.AbstractC2064pm
    /* renamed from: ˏ  reason: contains not printable characters */
    public AuthorizationCredentials mo6502(String str) {
        return this.f6844.mo6502(str);
    }

    @Override // o.AbstractC2064pm
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo6504(String str, AuthorizationCredentials authorizationCredentials) {
        this.f6844.mo6504(str, authorizationCredentials);
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public void m6507() {
        this.f6844.m6558();
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private void m6465() {
        this.f6844.m6556();
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private void m6486() {
        this.f6844.m6559();
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private void m6485() {
        m6507();
        m6465();
        m6486();
        if (this.f6844 instanceof C1799gE) {
            ((C1799gE) this.f6844).m6535();
            return;
        }
        C1283.m16850("nf_msl", "This should NOT happen!");
        C1276.m16820().mo5727("MSL store is NOT AndroidMslStore and we are trying to clear cookies!");
    }
}

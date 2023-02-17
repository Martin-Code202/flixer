package o;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.google.gson.JsonObject;
import com.netflix.falkor.FalkorException;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.NetflixStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.net.NetworkRequestType;
import com.netflix.mediaclient.service.webclient.ApiEndpointRegistry;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.ArrayList;
import java.util.List;
import o.AB;
/* access modifiers changed from: package-private */
/* renamed from: o.ɤ  reason: contains not printable characters */
public abstract class AbstractRunnableC0373 implements Runnable {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static boolean f13287 = C0787.f14445;

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean f13288 = false;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected final long f13289 = -1;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected final C0876 f13290;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C0856 f13291;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected final AbstractC1203 f13292;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f13293;

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public abstract void mo14114(AbstractC1203 v, C0856 v2);

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public abstract void mo14127(List<C0859> list);

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public abstract void mo14128(AbstractC1203 v, Status status);

    AbstractRunnableC0373(C0876<?> r3, AbstractC1203 r4) {
        this.f13290 = r3;
        this.f13292 = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1348Bu.m4094();
        try {
            m14109();
        } catch (Exception e) {
            C1283.m16852("CmpTask", e);
            NetflixStatus netflixStatus = new NetflixStatus(StatusCode.INT_ERR_CMP);
            netflixStatus.m311(false);
            netflixStatus.m312(e.getMessage());
            m14102(m14101(this.f13292, m14112()), netflixStatus);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ʽ  reason: contains not printable characters */
    public String m14112() {
        return getClass().getName();
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private void m14109() {
        mo14133();
        ArrayList arrayList = new ArrayList();
        mo14127(arrayList);
        if (this.f13288) {
            m14099();
        } else if (mo14116() || mo14115() || mo14125()) {
            mo14123(m14103(arrayList));
        } else {
            this.f13291 = this.f13290.m15249(arrayList);
            this.f13291.m15516("CmpTask");
            if (!this.f13291.m15515() || mo14118() || f13287) {
                this.f13293 = true;
                m14099();
                return;
            }
            List<C0859> arrayList2 = new ArrayList<>();
            if (!this.f13291.m15517()) {
                arrayList2.addAll(arrayList);
            } else {
                arrayList2.addAll(this.f13291.f14699);
                if (mo14121(arrayList2)) {
                    C0859.m15520(arrayList2);
                }
            }
            mo14123(m14103(arrayList2));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ᐝ  reason: contains not printable characters */
    public void mo14133() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʼ  reason: contains not printable characters */
    public void m14111() {
        this.f13288 = true;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo14123(NetflixDataRequest netflixDataRequest) {
        C0938.f14820.m15751(netflixDataRequest);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public List<AB.If> mo14120() {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean mo14121(List<C0859> list) {
        return list.size() > 20;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean mo14110() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean mo14115() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public Request.Priority mo14117() {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public boolean mo14131() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋॱ  reason: contains not printable characters */
    public boolean mo14118() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊॱ  reason: contains not printable characters */
    public boolean mo14116() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱˊ  reason: contains not printable characters */
    public boolean m14129() {
        return this.f13293;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ͺ  reason: contains not printable characters */
    public boolean mo14125() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo14113(JsonObject jsonObject) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo14122() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏॱ  reason: contains not printable characters */
    public void m14124() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public Object mo14126() {
        return null;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private NetflixDataRequest m14103(List<C0859> list) {
        if (this.f13290.m15261()) {
            return m14100(list);
        }
        return m14106(list);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private AbstractC1810gP m14100(final List<C0859> list) {
        return new AbstractC1810gP<Void>(ApiEndpointRegistry.ResponsePathFormat.GRAPH) { // from class: o.ɤ.5

            /* renamed from: ʽॱ  reason: contains not printable characters */
            private final boolean f13302 = AbstractRunnableC0373.this.mo14131();

            /* renamed from: ʿ  reason: contains not printable characters */
            private final List<AB.If> f13303 = AbstractRunnableC0373.this.mo14120();

            /* renamed from: ˈ  reason: contains not printable characters */
            private final long f13304 = -1;

            /* renamed from: ॱˎ  reason: contains not printable characters */
            private final boolean f13307 = C1348Bu.m4094();

            /* renamed from: ॱᐝ  reason: contains not printable characters */
            private final List<String> f13308 = AB.m3272(list);

            /* renamed from: ᐝॱ  reason: contains not printable characters */
            private final boolean f13309 = AbstractRunnableC0373.this.mo14115();

            @Override // o.AbstractC1810gP, com.android.volley.Request
            public Request.Priority getPriority() {
                return AbstractRunnableC0373.this.mo14117() != null ? AbstractRunnableC0373.this.mo14117() : Request.Priority.HIGH;
            }

            @Override // o.AbstractC1810gP, com.android.volley.Request
            public Object getTag() {
                return AbstractRunnableC0373.this.mo14126() != null ? AbstractRunnableC0373.this.mo14126() : NetworkRequestType.BROWSE;
            }

            /* access modifiers changed from: protected */
            @Override // o.AbstractC1807gM
            /* renamed from: ˎ */
            public List<String> mo989() {
                return this.f13308;
            }

            /* access modifiers changed from: protected */
            /* renamed from: ˋ  reason: contains not printable characters */
            public Void mo986(String str) {
                C1348Bu.m4094();
                System.currentTimeMillis();
                JsonObject asJsonObject = AbstractRunnableC0373.this.f13290.m15262().parse(str).getAsJsonObject();
                if (C0848.m15511(asJsonObject)) {
                    throw AbstractRunnableC0373.this.mo14119(asJsonObject);
                }
                if (AbstractRunnableC0373.this.mo14125()) {
                    AbstractRunnableC0373.this.mo14113(asJsonObject);
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    C0787.m15246(currentTimeMillis);
                    C1283.m16848("CmpTask", "parseFalkorResponse: current merge time - %d", Long.valueOf(currentTimeMillis));
                    AbstractRunnableC0373.this.m14107(asJsonObject);
                }
                AbstractRunnableC0373.this.m14099();
                return null;
            }

            /* access modifiers changed from: protected */
            @Override // o.AbstractC1807gM
            /* renamed from: ॱ */
            public String mo6583() {
                return this.f13309 ? "call" : "get";
            }

            /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object] */
            /* access modifiers changed from: protected */
            /* JADX WARNING: Unknown variable types count: 2 */
            @Override // o.AbstractC1810gP, o.AbstractC1807gM, com.android.volley.Request
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.Map<java.lang.String, java.lang.String> getParams() {
                /*
                    r5 = this;
                    java.util.Map r2 = super.getParams()
                    o.C1348Bu.m4094()
                    java.util.List<o.AB$If> r0 = r5.f13303
                    if (r0 == 0) goto L_0x0013
                    java.util.List<o.AB$If> r0 = r5.f13303
                    int r0 = r0.size()
                    if (r0 != 0) goto L_0x0014
                L_0x0013:
                    return r2
                L_0x0014:
                    java.util.List<o.AB$If> r0 = r5.f13303
                    java.util.Iterator r3 = r0.iterator()
                L_0x001a:
                    boolean r0 = r3.hasNext()
                    if (r0 == 0) goto L_0x002f
                    java.lang.Object r0 = r3.next()
                    r4 = r0
                    o.AB$If r4 = (o.AB.If) r4
                    java.lang.Object r0 = r4.first
                    java.lang.Object r1 = r4.second
                    r2.put(r0, r1)
                    goto L_0x001a
                L_0x002f:
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: o.AbstractRunnableC0373.AnonymousClass5.getParams():java.util.Map");
            }

            /* access modifiers changed from: protected */
            @Override // o.gV
            /* renamed from: ˋ */
            public boolean mo6620() {
                return true;
            }

            /* access modifiers changed from: protected */
            @Override // o.AbstractC1807gM
            public boolean a_() {
                return true;
            }

            /* access modifiers changed from: protected */
            /* renamed from: ˊ  reason: contains not printable characters */
            public void mo992(Void r2) {
                C1348Bu.m4093();
            }

            /* access modifiers changed from: protected */
            @Override // o.gV
            /* renamed from: ˏ */
            public void mo991(Status status) {
                C1348Bu.m4093();
                AbstractRunnableC0373.this.m14102(AbstractRunnableC0373.this.f13292, status);
            }

            /* access modifiers changed from: protected */
            @Override // com.android.volley.Request
            public void markInFlight(boolean z) {
                super.markInFlight(z);
                if (z) {
                    AbstractRunnableC0373.this.mo14122();
                } else {
                    AbstractRunnableC0373.this.m14124();
                }
            }
        };
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private AbstractC2035ok m14106(final List<C0859> list) {
        return new AbstractC2035ok<Void>(m14132(), ApiEndpointRegistry.ResponsePathFormat.GRAPH) { // from class: o.ɤ.2

            /* renamed from: ʻॱ  reason: contains not printable characters */
            private final List<AB.If> f13294 = AbstractRunnableC0373.this.mo14120();

            /* renamed from: ˋॱ  reason: contains not printable characters */
            private final List<String> f13296 = AB.m3272(list);

            /* renamed from: ॱˊ  reason: contains not printable characters */
            private final boolean f13298 = C1348Bu.m4094();

            /* renamed from: ॱˋ  reason: contains not printable characters */
            private final boolean f13299 = AbstractRunnableC0373.this.mo14131();

            /* renamed from: ॱˎ  reason: contains not printable characters */
            private final long f13300 = -1;

            /* renamed from: ᐝॱ  reason: contains not printable characters */
            private final boolean f13301 = AbstractRunnableC0373.this.mo14115();

            /* access modifiers changed from: protected */
            @Override // o.AbstractC2040op
            /* renamed from: ˋ */
            public boolean mo9689() {
                return AbstractRunnableC0373.this.mo14110();
            }

            @Override // o.AbstractC2040op, com.android.volley.Request
            public Request.Priority getPriority() {
                return AbstractRunnableC0373.this.mo14117() != null ? AbstractRunnableC0373.this.mo14117() : super.getPriority();
            }

            @Override // com.android.volley.Request
            public Object getTag() {
                return AbstractRunnableC0373.this.mo14126() != null ? AbstractRunnableC0373.this.mo14126() : NetworkRequestType.BROWSE;
            }

            /* access modifiers changed from: protected */
            @Override // o.AbstractC2035ok
            /* renamed from: ˎ */
            public List<String> mo9668() {
                return this.f13296;
            }

            /* access modifiers changed from: protected */
            /* renamed from: ˋ  reason: contains not printable characters */
            public Void mo9665(String str) {
                C1348Bu.m4094();
                System.currentTimeMillis();
                JsonObject asJsonObject = AbstractRunnableC0373.this.f13290.m15262().parse(str).getAsJsonObject();
                if (C0848.m15511(asJsonObject)) {
                    throw AbstractRunnableC0373.this.mo14119(asJsonObject);
                }
                if (AbstractRunnableC0373.this.mo14125()) {
                    AbstractRunnableC0373.this.mo14113(asJsonObject);
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    C0787.m15246(currentTimeMillis);
                    C1283.m16848("CmpTask", "parseFalkorResponse: current merge time - %d", Long.valueOf(currentTimeMillis));
                    AbstractRunnableC0373.this.m14107(asJsonObject);
                }
                AbstractRunnableC0373.this.m14099();
                return null;
            }

            /* access modifiers changed from: protected */
            @Override // o.AbstractC2035ok, o.AbstractC2040op
            /* renamed from: ˊ */
            public String mo5781() {
                return this.f13301 ? "call" : "get";
            }

            /* access modifiers changed from: protected */
            @Override // o.AbstractC2040op
            /* renamed from: ˏ */
            public boolean mo9692() {
                return this.f13299;
            }

            /* access modifiers changed from: protected */
            @Override // o.AbstractC2040op
            /* renamed from: ॱ */
            public String mo9695() {
                C1348Bu.m4094();
                if (this.f13294 == null || this.f13294.size() == 0) {
                    return null;
                }
                StringBuilder sb = new StringBuilder();
                for (AB.If r4 : this.f13294) {
                    sb.append("&").append((String) r4.first).append("=").append((String) r4.second);
                }
                return sb.toString();
            }

            /* access modifiers changed from: protected */
            @Override // o.AbstractC2040op
            /* renamed from: ʽ */
            public boolean mo9686() {
                return true;
            }

            /* access modifiers changed from: protected */
            @Override // o.AbstractC2035ok
            /* renamed from: ॱॱ */
            public boolean mo9670() {
                return true;
            }

            /* access modifiers changed from: protected */
            /* renamed from: ॱ  reason: contains not printable characters */
            public void mo5640(Void r2) {
                C1348Bu.m4093();
            }

            /* access modifiers changed from: protected */
            @Override // o.AbstractC2040op
            /* renamed from: ˋ */
            public void mo5637(Status status) {
                C1348Bu.m4093();
                AbstractRunnableC0373.this.m14102(AbstractRunnableC0373.this.f13292, status);
            }

            /* access modifiers changed from: protected */
            @Override // com.android.volley.Request
            public void markInFlight(boolean z) {
                super.markInFlight(z);
                if (z) {
                    AbstractRunnableC0373.this.mo14122();
                } else {
                    AbstractRunnableC0373.this.m14124();
                }
            }
        };
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʻॱ  reason: contains not printable characters */
    private void m14099() {
        C1348Bu.m4094();
        AbstractC1203 r2 = m14101(this.f13292, m14112());
        if (this.f13291 != null || mo14115() || mo14125() || mo14116()) {
            mo14114(r2, this.f13291);
            return;
        }
        C1283.m16865("CmpTask", "GetResult is null - shouldn't happen - forcing failure");
        m14102(r2, AbstractC0367.f13245);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m14102(AbstractC1203 r1, Status status) {
        mo14128(r1, status);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public VolleyError mo14119(JsonObject jsonObject) {
        return new FalkorException("error found in json response - " + C0848.m15514(jsonObject, "CmpTask"));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private synchronized void m14107(JsonObject jsonObject) {
        AbstractC1096 r4 = null;
        try {
            r4 = this.f13290.m15260(true);
            r4.mo16192();
            this.f13290.m15252(jsonObject.getAsJsonObject("value"), this.f13290.m15263(), null, r4);
            r4.mo16197();
            if (r4 != null) {
                r4.close();
            }
        } catch (Throwable th) {
            if (r4 != null) {
                r4.close();
            }
            throw th;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private AbstractC1203 m14101(AbstractC1203 r4, String str) {
        if (r4 != null) {
            return new C1211(this.f13290.m15247(), r4);
        }
        C1276.m16820().mo5725("SPY-12760 : callback should not be null (" + str + ")");
        return AbstractC1222.m16563();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public final Context m14132() {
        return (Context) C1281.m16832(Context.class);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱˋ  reason: contains not printable characters */
    public final void m14130() {
        LocalBroadcastManager.getInstance(m14132()).sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.DETAIL_PAGE_REFRESH"));
        C1283.m16846("CmpTask", "Intent DETAIL_PAGE_REFRESH sent");
    }
}

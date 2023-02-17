package o;

import android.content.Context;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.AUIApiEndpointRegistry;
import com.netflix.mediaclient.service.webclient.ApiEndpointRegistry;
import com.netflix.mediaclient.service.webclient.model.leafs.MoneyballCallData;
import com.netflix.mediaclient.service.webclient.model.leafs.MoneyballData;
import com.netflix.mediaclient.util.ConnectivityUtils;
import java.util.Arrays;
import java.util.List;
/* renamed from: o.ァ  reason: contains not printable characters */
public class C1079 extends AbstractC1052 implements AbstractC1194 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private String f15240 = null;

    /* renamed from: ʽ  reason: contains not printable characters */
    private C1097 f15241;

    /* renamed from: ˊ  reason: contains not printable characters */
    private C1262 f15242;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Context f15243;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Status f15244;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C1260 f15245;

    /* renamed from: ॱ  reason: contains not printable characters */
    private C1056 f15246;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int f15247 = -1;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private C0351 f15248;

    public C1079(Context context, C1260 r7) {
        this.f15247 = C1318At.m3778(context);
        C1283.m16863("nf_moneyball_agent", "Current app version code=%d", Integer.valueOf(this.f15247));
        this.f15240 = C1318At.m3776(context);
        C1283.m16863("nf_moneyball_agent", "Current softwareVersion=%s", this.f15240);
        this.f15248 = new C0351(this.f15247, context, C1318At.m3776(context), AbstractC0488.m14431());
        this.f15242 = new C1262(context, "aui_nrmInfo");
        this.f15243 = context;
        this.f15245 = r7;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1052
    /* renamed from: ʽ */
    public void mo1237() {
        this.f15241 = new C1097(m16093(), this, this.f15245);
        m16160();
        this.f15246 = new C1056(this.f15243, m16085(), this, m16088(), this.f15245);
        m16090(AbstractC0367.f13235);
    }

    @Override // o.AbstractC1194
    /* renamed from: ˊ  reason: contains not printable characters */
    public AUIApiEndpointRegistry mo16162() {
        return this.f15246;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m16160() {
    }

    @Override // o.AbstractC1194
    /* renamed from: ˋ  reason: contains not printable characters */
    public C0351 mo16164() {
        return this.f15248;
    }

    @Override // o.AbstractC1194
    /* renamed from: ˎ  reason: contains not printable characters */
    public ApiEndpointRegistry mo16165() {
        return this.f15246;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m16161(List<String> list, final AbstractC1113 r8) {
        C1283.m16851("nf_moneyball_agent", "fetchData %s", list);
        AnonymousClass4 r4 = new C1185() { // from class: o.ァ.4
            @Override // o.C1185, o.AbstractC1113
            public void onDataFetched(MoneyballData moneyballData, Status status) {
                C1283.m16851("nf_moneyball_agent", "onDataFetched statusCode=%d", Integer.valueOf(status.mo302().m271()));
                C1079.this.f15244 = status;
                if (r8 != null) {
                    r8.onDataFetched(moneyballData, C1079.this.f15244);
                }
            }
        };
        AbstractC1250 t_ = t_();
        if (t_ != null) {
            t_.mo15842(this.f15241.m16200(list, r4));
        } else {
            r8.onDataFetched(null, AbstractC0367.f13241);
        }
    }

    @Override // o.AbstractC1194
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo16167(String str, String str2, final AbstractC1113 r7) {
        C1283.m16851("nf_moneyball_agent", "fetch flow:%s mode:%s", str, str2);
        m16161(Arrays.asList("['aui', '" + str + "', '" + str2 + "']", "['aui','context']"), new C1185() { // from class: o.ァ.1
            /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x004c: APUT  (r1v3 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r2v5 java.lang.Object) */
            @Override // o.C1185, o.AbstractC1113
            public void onDataFetched(MoneyballData moneyballData, Status status) {
                C1283.m16851("nf_moneyball_agent", "onDataFetched statusCode=%d", Integer.valueOf(status.mo302().m271()));
                if (!status.mo298() || moneyballData == null) {
                    C1283.m16844("nf_moneyball_agent", "error in fetching Moneyball data status: %s, moneyballData: %s", status, moneyballData);
                    if (ConnectivityUtils.m2954(C1079.this.f15243)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = status;
                        objArr[1] = moneyballData != null ? moneyballData : "";
                        C1276.m16820().mo5725(String.format("status= %s, moneyballData= %s", objArr));
                    }
                }
                if (r7 != null) {
                    r7.onDataFetched(moneyballData, status);
                }
            }
        });
    }

    @Override // o.AbstractC1194
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo16169(String str, AbstractC1113 r5) {
        C1283.m16854("nf_moneyball_agent", "fetch" + str);
        mo16167(SignupConstants.Flow.SIMPLE_SILVER_SIGN_UP, str, r5);
    }

    @Override // o.AbstractC1194
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo16168(MoneyballCallData moneyballCallData, final AbstractC1113 r6) {
        C1283.m16854("nf_moneyball_agent", "nextMode");
        AnonymousClass5 r2 = new C1185() { // from class: o.ァ.5
            /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0033: APUT  (r1v2 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r2v3 java.lang.Object) */
            @Override // o.C1185, o.AbstractC1113
            public void onDataFetched(MoneyballData moneyballData, Status status) {
                if (!status.mo298() || moneyballData == null) {
                    C1283.m16844("nf_moneyball_agent", "error in calling moneyball next. status: %s, auiData %s", status, moneyballData);
                    if (ConnectivityUtils.m2954(C1079.this.f15243)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = status;
                        objArr[1] = moneyballData != null ? moneyballData : "";
                        C1276.m16820().mo5725(String.format("status= %s, auiData= %s", objArr));
                    }
                }
                if (r6 != null) {
                    r6.onDataFetched(moneyballData, status);
                }
            }
        };
        AbstractC1250 t_ = t_();
        if (t_ != null) {
            t_.mo15842(this.f15241.m16201(moneyballCallData, r2));
        } else {
            r6.onDataFetched(null, AbstractC0367.f13241);
        }
    }

    @Override // o.AbstractC1194
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo16163(AbstractC1113 r4) {
        C1283.m16854("nf_moneyball_agent", "getPath");
        m16161(Arrays.asList("['aui','phoneCodes']"), r4);
    }

    @Override // o.AbstractC1194
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo16166(AbstractC1113 r4) {
        C1283.m16854("nf_moneyball_agent", "getPath");
        m16161(Arrays.asList("['aui','termsOfUse']"), r4);
    }
}

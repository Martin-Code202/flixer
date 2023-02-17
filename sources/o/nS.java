package o;

import android.content.Context;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.netflix.falkor.FalkorException;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.List;
public final class nS extends AbstractC1189<Boolean> {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static final String f9026 = f9026;

    /* renamed from: ʼ  reason: contains not printable characters */
    private static final String f9027 = f9027;

    /* renamed from: ʽ  reason: contains not printable characters */
    private static final String f9028 = f9028;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final C0151 f9029 = new C0151(null);

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static final String f9030 = f9030;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private static final String f9031 = f9031;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC2022nz f9032;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public nS(Context context, NetflixDataRequest.Transport transport, AbstractC2022nz nzVar) {
        super(context, transport);
        C1457Fr.m5025(context, "context");
        C1457Fr.m5025(transport, "transport");
        C1457Fr.m5025(nzVar, "callback");
        this.f9032 = nzVar;
    }

    @Override // o.AbstractC1230
    /* renamed from: ˋ */
    public /* synthetic */ void mo9114(Object obj) {
        m9166(((Boolean) obj).booleanValue());
    }

    /* renamed from: o.nS$ˊ  reason: contains not printable characters */
    public static final class C0151 {
        private C0151() {
        }

        public /* synthetic */ C0151(C1456Fq fq) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˊ  reason: contains not printable characters */
        private final String m9168() {
            return nS.f9031;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˏ  reason: contains not printable characters */
        private final String m9174() {
            return nS.f9028;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˎ  reason: contains not printable characters */
        private final String m9172() {
            return nS.f9026;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ॱ  reason: contains not printable characters */
        private final String m9176() {
            return nS.f9027;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˋ  reason: contains not printable characters */
        private final String m9170() {
            return nS.f9030;
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ᐝ */
    public List<String> mo9118() {
        return EI.m4806("['user', 'retryPayment']");
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˎ */
    public boolean mo9156() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public Boolean mo9112(String str) {
        C1283.m16854(f9029.m9168(), "parseFalkorResponse for retryPayment request = " + str);
        if (str == null) {
            return false;
        }
        JsonObject r3 = C0848.m15512(f9029.m9168(), str);
        if (C0848.m15504(r3)) {
            return false;
        }
        try {
            JsonObject asJsonObject = r3.getAsJsonObject(f9029.m9174());
            if (asJsonObject.has(f9029.m9176())) {
                JsonObject asJsonObject2 = asJsonObject.getAsJsonObject(f9029.m9176());
                if (asJsonObject2.has(f9029.m9172())) {
                    JsonElement jsonElement = asJsonObject2.get(f9029.m9172());
                    C1457Fr.m5016((Object) jsonElement, "userObj.get(FIELD_STATUS)");
                    return Boolean.valueOf(C1457Fr.m5018((Object) jsonElement.getAsString(), (Object) f9029.m9170()));
                }
            }
            return false;
        } catch (Exception e) {
            C1283.m16846(f9029.m9168(), "String response to parse = " + str);
            throw new FalkorException("response missing user json objects", e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m9166(boolean z) {
        this.f9032.mo1388(z ? AbstractC0367.f13235 : AbstractC0367.f13261);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˋ */
    public void mo9113(Status status) {
        C1457Fr.m5025(status, "statusCode");
        this.f9032.mo1388(status);
    }
}

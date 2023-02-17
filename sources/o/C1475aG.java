package o;

import com.netflix.mediaclient.service.logging.client.model.UIError;
/* renamed from: o.aG  reason: case insensitive filesystem */
public final class C1475aG extends AbstractC1523az {
    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "uiBrowseStartup";
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C1492aW m5377(long j, boolean z, UIError uIError) {
        C1492aW aWVar = new C1492aW(System.currentTimeMillis() - this.f6160, j);
        aWVar.setCategory(mo5643());
        aWVar.setSessionId(this.f6158);
        aWVar.m5406(uIError);
        aWVar.m5407(z);
        return aWVar;
    }
}

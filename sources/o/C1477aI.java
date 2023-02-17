package o;

import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.HttpResponse;
import com.netflix.mediaclient.servicemgr.IClientLogging;
/* renamed from: o.aI  reason: case insensitive filesystem */
public final class C1477aI extends AbstractC1523az {

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f5899;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f5900;

    public C1477aI(String str, String str2) {
        this.f5899 = str;
        this.f5900 = str2;
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "uiDataRequest";
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C1493aX m5380(IClientLogging.CompletionReason completionReason, HttpResponse httpResponse, Error error) {
        C1493aX aXVar = new C1493aX(System.currentTimeMillis() - this.f6160);
        aXVar.setCategory(mo5643());
        aXVar.setSessionId(this.f6158);
        aXVar.m5413(this.f5899);
        aXVar.m5409(this.f5900);
        aXVar.m5411(error);
        aXVar.m5412(completionReason);
        aXVar.m5409(this.f5900);
        aXVar.m5408(httpResponse);
        aXVar.m5410(new C1483aO());
        return aXVar;
    }
}

package o;

import com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging;
/* renamed from: o.cZ  reason: case insensitive filesystem */
public class C1606cZ extends AbstractC1604cX {
    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "foreground";
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C1666de m5842(ApplicationPerformanceMetricsLogging.UiStartupTrigger uiStartupTrigger, C1487aS aSVar) {
        C1666de deVar = new C1666de(uiStartupTrigger, aSVar);
        deVar.setCategory(mo5643());
        deVar.setSessionId(this.f6158);
        return deVar;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1667df m5843() {
        C1667df dfVar = new C1667df(System.currentTimeMillis() - this.f6160);
        dfVar.setCategory(mo5643());
        dfVar.setSessionId(this.f6158);
        return dfVar;
    }
}

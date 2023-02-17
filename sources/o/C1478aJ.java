package o;

import com.netflix.mediaclient.service.logging.apm.model.Display;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import java.util.Map;
/* renamed from: o.aJ  reason: case insensitive filesystem */
public final class C1478aJ extends AbstractC1523az {

    /* renamed from: ʻ  reason: contains not printable characters */
    private String f5901;

    /* renamed from: ʼ  reason: contains not printable characters */
    private Display f5902;

    /* renamed from: ʽ  reason: contains not printable characters */
    private Map<String, Integer> f5903;

    /* renamed from: ˎ  reason: contains not printable characters */
    private IClientLogging.ModalView f5904;

    /* renamed from: ˏ  reason: contains not printable characters */
    private ApplicationPerformanceMetricsLogging.UiStartupTrigger f5905;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private C1491aV f5906;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private C1487aS f5907;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f5908;

    public C1478aJ(ApplicationPerformanceMetricsLogging.UiStartupTrigger uiStartupTrigger, IClientLogging.ModalView modalView, Display display, C1487aS aSVar, C1491aV aVVar) {
        this.f5905 = uiStartupTrigger;
        this.f5904 = modalView;
        this.f5902 = display;
        this.f5907 = aSVar;
        this.f5906 = aVVar;
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ˊ */
    public String mo5364() {
        return "uiStartup";
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C1495aZ m5381(boolean z, UIError uIError) {
        C1495aZ aZVar = new C1495aZ(System.currentTimeMillis() - this.f6160, this.f5905, this.f5904, z, this.f5907, this.f5906);
        aZVar.setCategory(mo5643());
        aZVar.m5414("" + this.f5908);
        aZVar.m5416(this.f5903);
        aZVar.m5418(this.f5901);
        aZVar.m5415(uIError);
        aZVar.m5417(this.f5902);
        return aZVar;
    }
}

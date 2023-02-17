package o;

import android.content.Context;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.net.NetworkRequestType;
import com.netflix.mediaclient.service.webclient.model.leafs.ConfigData;
import java.util.List;
/* access modifiers changed from: package-private */
/* renamed from: o.爫  reason: contains not printable characters */
public class C1109 extends AbstractC1094<ConfigData> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC1254 f15325;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final List<String> f15326;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final Context f15327;

    C1109(Context context, List<String> list, AbstractC1254 r3) {
        this.f15327 = context;
        this.f15326 = list;
        this.f15325 = r3;
    }

    @Override // o.AbstractC1094, com.android.volley.Request
    public Object getTag() {
        return NetworkRequestType.CONFIG;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1807gM
    /* renamed from: ˎ */
    public List<String> mo989() {
        return this.f15326;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public ConfigData mo986(String str) {
        return C1098.m16204(this.f15327, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo992(ConfigData configData) {
        if (this.f15325 != null) {
            this.f15325.mo1407(configData, AbstractC0367.f13235);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.gV
    /* renamed from: ˏ */
    public void mo991(Status status) {
        if (this.f15325 != null) {
            this.f15325.mo1407(null, status);
        }
    }
}

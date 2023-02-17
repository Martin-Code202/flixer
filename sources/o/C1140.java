package o;

import android.content.Context;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.Status;
import java.util.Arrays;
import java.util.List;
/* access modifiers changed from: package-private */
/* renamed from: o.ﮉ  reason: contains not printable characters */
public class C1140 extends AbstractC1084<String> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC1254 f15389;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f15390 = new StringBuilder("['dummy']").toString();

    C1140(Context context, AbstractC1254 r4) {
        super(context);
        this.f15389 = r4;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2035ok
    /* renamed from: ˎ */
    public List<String> mo9668() {
        return Arrays.asList(this.f15390);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ˏ */
    public boolean mo9692() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ʻ */
    public boolean mo9685() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public String mo9665(String str) {
        return Integer.toString(StatusCode.OK.m271());
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo5640(String str) {
        if (this.f15389 != null) {
            this.f15389.mo5712(AbstractC0367.f13235);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2040op
    /* renamed from: ˋ */
    public void mo5637(Status status) {
        if (this.f15389 != null) {
            this.f15389.mo5712(status);
        }
    }
}

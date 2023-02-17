package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.List;
import java.util.Map;
/* renamed from: o.ｋ  reason: contains not printable characters */
public abstract class AbstractC1230<T> {

    /* renamed from: ˊ  reason: contains not printable characters */
    protected NetflixDataRequest f15755;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected NetflixDataRequest.Transport f15756;

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public abstract T mo9112(String str);

    /* access modifiers changed from: protected */
    /* renamed from: ˋ */
    public abstract NetflixDataRequest mo16451();

    /* access modifiers changed from: protected */
    /* renamed from: ˋ */
    public abstract void mo9113(Status status);

    /* access modifiers changed from: protected */
    /* renamed from: ˋ */
    public abstract void mo9114(T t);

    /* access modifiers changed from: protected */
    /* renamed from: ᐝ */
    public abstract List<String> mo9118();

    public AbstractC1230(NetflixDataRequest.Transport transport) {
        if (transport == null) {
            throw new IllegalArgumentException("Transport can not be null");
        }
        this.f15756 = transport;
        this.f15755 = mo16451();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public NetflixDataRequest m16567() {
        return this.f15755;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ */
    public String mo9116() {
        return "get";
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ */
    public boolean mo9121() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ */
    public boolean mo9156() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʽ */
    public Map<String, String> mo9111() {
        return new AW();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱॱ */
    public boolean mo9122() {
        return true;
    }
}

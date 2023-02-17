package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.SessionKey;
/* renamed from: o.bi  reason: case insensitive filesystem */
public abstract class AbstractC1560bi implements AbstractC1561bj {

    /* renamed from: ˊ  reason: contains not printable characters */
    protected DeviceUniqueId f6158 = new DeviceUniqueId();

    /* renamed from: ˋ  reason: contains not printable characters */
    protected SessionKey f6159 = new SessionKey(this.f6158, mo5643(), mo5364());

    /* renamed from: ॱ  reason: contains not printable characters */
    protected long f6160 = System.currentTimeMillis();

    /* renamed from: ˋ */
    public abstract String mo5643();

    /* renamed from: ॱ */
    public void mo5386(long j) {
        this.f6158 = new DeviceUniqueId(j);
        this.f6159 = new SessionKey(this.f6158, mo5643(), mo5364());
    }

    @Override // o.AbstractC1561bj
    /* renamed from: ʼ  reason: contains not printable characters */
    public SessionKey mo5776() {
        return this.f6159;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public DeviceUniqueId m5779() {
        return this.f6158;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public long m5777() {
        return this.f6160;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5778(long j) {
        this.f6160 = j;
    }
}

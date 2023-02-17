package o;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
/* renamed from: o.an  reason: case insensitive filesystem */
public class C1509an implements AbstractC1506ak {

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f6042;

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f6043;

    C1509an(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context can not be null");
        }
        AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
        this.f6042 = advertisingIdInfo.getId();
        this.f6043 = advertisingIdInfo.isLimitAdTrackingEnabled();
    }

    @Override // o.AbstractC1506ak
    /* renamed from: ˏ */
    public String mo5605() {
        return this.f6042;
    }

    @Override // o.AbstractC1506ak
    /* renamed from: ॱ */
    public boolean mo5606() {
        return this.f6043;
    }
}

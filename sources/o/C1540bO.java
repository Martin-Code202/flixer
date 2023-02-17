package o;

import android.os.Build;
import com.netflix.mediaclient.service.logging.client.model.Device;
import com.netflix.mediaclient.service.logging.logblob.LogBlobType;
import org.json.JSONException;
/* renamed from: o.bO  reason: case insensitive filesystem */
public class C1540bO extends AbstractC1542bQ {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final Object f6133 = "CronetDisabled";

    public C1540bO() {
        try {
            this.f6134.put("fingerprint", Build.FINGERPRINT);
            this.f6134.put("manufacturer", Build.MANUFACTURER);
            this.f6134.put(Device.MODEL, Build.MODEL);
        } catch (JSONException e) {
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˋ */
    public String mo680() {
        return LogBlobType.CRONET_DISABLED.m602();
    }
}

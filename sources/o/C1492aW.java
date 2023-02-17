package o;

import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import java.util.HashMap;
import org.json.JSONObject;
/* renamed from: o.aW  reason: case insensitive filesystem */
public final class C1492aW extends SessionEndedEvent {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static String f5934 = "STANDARD";

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f5935 = true;

    /* renamed from: ˎ  reason: contains not printable characters */
    private UIError f5936;

    /* renamed from: ॱ  reason: contains not printable characters */
    private long f5937;

    public C1492aW(long j, long j2) {
        super("uiBrowseStartup", new DeviceUniqueId(), j);
        this.f5937 = j2;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        data.put(FalkorPathResult.SUCCESS, this.f5935);
        data.put("timeToBrowseInteractive", this.f5937);
        if (this.f5936 != null) {
            data.put(ExceptionClEvent.CATEGORY_VALUE, this.f5936.toJSONObject());
        }
        return data;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5407(boolean z) {
        this.f5935 = z;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m5406(UIError uIError) {
        this.f5936 = uIError;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getCustomData() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("browseExperience", f5934);
        return new JSONObject(hashMap);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m5405(String str) {
        f5934 = str;
    }
}

package o;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.google.gson.JsonObject;
import com.netflix.falkor.FalkorException;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert;
import com.netflix.mediaclient.service.webclient.model.leafs.User;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.Collections;
import java.util.List;
/* access modifiers changed from: package-private */
public class nR extends AbstractC1189<UmaAlert> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Context f9024;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final User f9025;

    nR(Context context, NetflixDataRequest.Transport transport, User user) {
        super(context, transport);
        this.f9025 = user;
        this.f9024 = context;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ᐝ */
    public List<String> mo9118() {
        return Collections.singletonList("['user', 'uma']");
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˎ */
    public boolean mo9156() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public UmaAlert mo9112(String str) {
        JsonObject r2 = C0848.m15512("RefreshUserMessageRequest", str);
        if (C0848.m15504(r2)) {
            return null;
        }
        try {
            return (UmaAlert) C0848.m15506(r2.getAsJsonObject("user"), "uma", UmaAlert.class);
        } catch (Exception e) {
            throw new FalkorException("response missing user json objects", e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo9114(UmaAlert umaAlert) {
        this.f9025.setUmaAlert(umaAlert);
        LocalBroadcastManager.getInstance(this.f9024).sendBroadcast(new Intent("RefreshUserMessageRequest.ACTION_UMA_MESSAGE_UPDATED"));
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˋ */
    public void mo9113(Status status) {
    }
}

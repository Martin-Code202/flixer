package o;

import android.content.Context;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.netflix.falkor.FalkorException;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.model.leafs.AvatarInfo;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/* access modifiers changed from: package-private */
public class nG extends AbstractC1189<List<AvatarInfo>> {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f8998 = "['availableAvatarsList']";

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC2022nz f8999;

    nG(Context context, NetflixDataRequest.Transport transport, AbstractC2022nz nzVar) {
        super(context, transport);
        this.f8999 = nzVar;
        C1283.m16848("nf_service_user_fetchavailableavatarsrequest", "PQL = %s", this.f8998);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˏ */
    public boolean mo9121() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ᐝ */
    public List<String> mo9118() {
        return Arrays.asList(this.f8998);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public List<AvatarInfo> mo9112(String str) {
        JsonObject r2 = C0848.m15512("nf_service_user_fetchavailableavatarsrequest", str);
        if (C0848.m15504(r2)) {
            throw new FalkorException("Avatars list empty!!!");
        }
        try {
            JsonArray asJsonArray = r2.getAsJsonArray("availableAvatarsList");
            ArrayList arrayList = new ArrayList();
            Iterator<JsonElement> it = asJsonArray.iterator();
            while (it.hasNext()) {
                JsonObject asJsonObject = it.next().getAsJsonObject();
                arrayList.add(new AvatarInfo(asJsonObject.getAsJsonPrimitive("name").getAsString(), asJsonObject.getAsJsonPrimitive("url").getAsString(), asJsonObject.getAsJsonPrimitive("isInDefaultSet").getAsBoolean()));
            }
            return arrayList;
        } catch (Exception e) {
            throw new FalkorException("response missing avatars json objects", e);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1230
    /* renamed from: ˋ */
    public void mo9113(Status status) {
        if (this.f8999 != null) {
            this.f8999.mo1387((List<AvatarInfo>) null, status);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo9114(List<AvatarInfo> list) {
        if (this.f8999 != null) {
            this.f8999.mo1387(list, AbstractC0367.f13235);
        }
    }
}

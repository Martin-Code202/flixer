package o;

import com.google.gson.JsonObject;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.service.logging.client.model.Event;
import java.util.Collection;
import org.json.JSONException;
/* access modifiers changed from: package-private */
public class gW extends AbstractC1542bQ {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f6935;

    public gW(String str, JsonObject jsonObject, Collection<C1846he> collection) {
        this.f6935 = str;
        try {
            this.f6134.put("ctx", AK.m3378(jsonObject));
            this.f6134.put(Event.DATA, AK.m3392(NetflixApplication.m222().toJsonTree(collection)));
        } catch (JSONException e) {
            C1283.m16850("nf_probe", "unable to create probe logblob");
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˋ */
    public String mo680() {
        return this.f6935;
    }
}

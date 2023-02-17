package o;

import android.util.Pair;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.service.logging.client.model.DeepErrorElement;
import com.netflix.mediaclient.service.logging.client.model.Event;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.vb  reason: case insensitive filesystem */
public class C2232vb {

    /* renamed from: ˋ  reason: contains not printable characters */
    private Pair<String, String>[] f11303;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f11304;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f11305;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f11306;

    public C2232vb(JSONObject jSONObject) {
        this.f11305 = "mdxui";
        this.f11306 = AK.m3376(jSONObject, "title", (String) null);
        this.f11304 = AK.m3376(jSONObject, DeepErrorElement.Debug.MESSAGE, (String) null);
        JSONArray r4 = AK.m3377(jSONObject, SignupConstants.Key.PLAN_OPTIONS);
        if (r4 == null) {
            C1283.m16850("mdxui", "Invalid data, no options found!");
            this.f11303 = new Pair[0];
            return;
        }
        this.f11303 = new Pair[r4.length()];
        for (int i = 0; i < r4.length(); i++) {
            JSONObject jSONObject2 = r4.getJSONObject(i);
            this.f11303[i] = Pair.create(AK.m3376(jSONObject2, "name", (String) null), AK.m3376(jSONObject2, Event.DATA, (String) null));
        }
    }

    public C2232vb(String str) {
        this(new JSONObject(str));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m12120() {
        return this.f11306;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public Pair<String, String>[] m12119() {
        return this.f11303;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m12121() {
        return this.f11304;
    }

    public String toString() {
        return "RemoteDialog [ mTitle=" + this.f11306 + ", mMessage=" + this.f11304 + ", options=" + Arrays.toString(this.f11303) + "]";
    }
}

package o;

import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.service.logging.client.model.DeepErrorElement;
import com.netflix.mediaclient.service.logging.client.model.Event;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.fX  reason: case insensitive filesystem */
public class C1764fX extends AbstractC1824gj {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static String f6718 = Event.DATA;

    /* renamed from: ʼ  reason: contains not printable characters */
    private static String f6719 = "name";

    /* renamed from: ˊ  reason: contains not printable characters */
    private static String f6720 = "uid";

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String f6721 = "title";

    /* renamed from: ॱ  reason: contains not printable characters */
    private static String f6722 = DeepErrorElement.Debug.MESSAGE;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static String f6723 = SignupConstants.Key.PLAN_OPTIONS;

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f6724;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private Cif[] f6725;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private String f6726;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private String f6727;

    public C1764fX(JSONObject jSONObject) {
        super("DIALOG_SHOW");
        this.f6727 = jSONObject.getString(f6720);
        this.f6724 = jSONObject.getString(f6721);
        this.f6726 = jSONObject.getString(f6722);
        JSONArray jSONArray = jSONObject.getJSONArray(f6723);
        this.f6725 = new Cif[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            this.f6725[i] = Cif.m6359(jSONArray.getJSONObject(i));
        }
        this.f6980 = jSONObject;
    }

    /* renamed from: o.fX$if  reason: invalid class name */
    public static class Cif {

        /* renamed from: ˎ  reason: contains not printable characters */
        public String f6728;

        /* renamed from: ॱ  reason: contains not printable characters */
        public String f6729;

        public Cif(String str, String str2) {
            this.f6729 = str;
            this.f6728 = str2;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public static Cif m6359(JSONObject jSONObject) {
            return new Cif(jSONObject.getString(C1764fX.f6719), jSONObject.getString(C1764fX.f6718));
        }
    }
}

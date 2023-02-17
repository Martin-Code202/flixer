package o;

import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.pn  reason: case insensitive filesystem */
public final class C2065pn {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final String[] f9413 = {"ComingSoon", "billboard-bigRow", "previews", "branching-tutorial"};

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f9414;

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m9854() {
        return this.f9414;
    }

    public C2065pn(String str) {
        this.f9414 = str;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m9853(JSONObject jSONObject, String str) {
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -1273784917:
                    if (str.equals("previews")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1085510111:
                    if (str.equals("Default")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1027210488:
                    if (str.equals("billboard-bigRow")) {
                        c = 1;
                        break;
                    }
                    break;
                case -407169092:
                    if (str.equals("ComingSoon")) {
                        c = 0;
                        break;
                    }
                    break;
                case -318360489:
                    if (str.equals("preplay")) {
                        c = 5;
                        break;
                    }
                    break;
                case 88381323:
                    if (str.equals("branching-tutorial")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    jSONObject.put("maxBufferingTime", 500);
                    jSONObject.put("minPrebufSize", 4000);
                    jSONObject.put("skipBitrateInUpswitch", true);
                    jSONObject.put("fastDomainSelectionBwThreshold", 150);
                    return;
                case 1:
                    jSONObject.put("maxBufferingTime", 250);
                    jSONObject.put("minPrebufSize", 2000);
                    jSONObject.put("skipBitrateInUpswitch", true);
                    jSONObject.put("fastDomainSelectionBwThreshold", 150);
                    return;
                case 2:
                    jSONObject.put("maxBufferingTime", 500);
                    jSONObject.put("minPrebufSize", 4000);
                    jSONObject.put("skipBitrateInUpswitch", true);
                    jSONObject.put("fastDomainSelectionBwThreshold", 150);
                    return;
                case 3:
                case 4:
                case 5:
                    return;
                default:
                    return;
            }
        } catch (JSONException e) {
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String[] m9852() {
        return f9413;
    }
}

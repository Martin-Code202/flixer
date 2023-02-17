package o;

import java.net.URLDecoder;
import org.json.JSONObject;
/* renamed from: o.fr  reason: case insensitive filesystem */
public class C1785fr {

    /* renamed from: ʻ  reason: contains not printable characters */
    public Cif f6798;

    /* renamed from: ʼ  reason: contains not printable characters */
    public String f6799;

    /* renamed from: ʽ  reason: contains not printable characters */
    public String f6800;

    /* renamed from: ˊ  reason: contains not printable characters */
    public String f6801;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private String f6802 = "9080";

    /* renamed from: ˋ  reason: contains not printable characters */
    public int f6803;

    /* renamed from: ˎ  reason: contains not printable characters */
    public String f6804;

    /* renamed from: ˏ  reason: contains not printable characters */
    public int f6805;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private String f6806;

    /* renamed from: ͺ  reason: contains not printable characters */
    private String f6807 = "0.0.0.0";

    /* renamed from: ॱ  reason: contains not printable characters */
    public String f6808;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public String f6809;

    /* renamed from: ᐝ  reason: contains not printable characters */
    public boolean f6810;

    /* renamed from: o.fr$if  reason: invalid class name */
    public static class Cif {

        /* renamed from: ˋ  reason: contains not printable characters */
        public final int f6811;

        /* renamed from: ˏ  reason: contains not printable characters */
        public final String f6812;

        Cif(String str, int i) {
            this.f6812 = str;
            this.f6811 = i;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        static Cif m6457(String str) {
            String str2 = null;
            int i = 59;
            for (String str3 : str.split(";")) {
                String[] split = str3.split("=");
                if (split.length == 2) {
                    if ("MAC".equals(split[0])) {
                        str2 = split[1];
                    } else if ("Timeout".equals(split[0])) {
                        try {
                            i = Integer.parseInt(split[1]);
                        } catch (Exception e) {
                        }
                    }
                }
            }
            if (C1349Bv.m4107(str2)) {
                return new Cif(str2, i);
            }
            return null;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static C1785fr m6451(JSONObject jSONObject) {
        C1785fr frVar = new C1785fr();
        frVar.f6808 = AK.m3376(jSONObject, "uuid", AK.m3376(jSONObject, "UUID", (String) null));
        frVar.f6804 = AK.m3376(jSONObject, "dialUuid", (String) null);
        frVar.f6810 = AK.m3381(jSONObject, "activated", true);
        frVar.f6806 = AK.m3376(jSONObject, "location", (String) null);
        frVar.f6801 = AK.m3376(jSONObject, "friendlyName", (String) null);
        frVar.f6799 = AK.m3376(jSONObject, "serviceType", (String) null);
        frVar.f6805 = AK.m3386(jSONObject, "registrationAcceptance", 0);
        frVar.f6803 = AK.m3386(jSONObject, "launchStatus", 0);
        frVar.f6809 = AK.m3376(jSONObject, "manufacturer", (String) null);
        frVar.f6800 = AK.m3376(jSONObject, "modelName", (String) null);
        String r4 = AK.m3376(jSONObject, "wolHeader", (String) null);
        try {
            if (frVar.f6801 != null) {
                frVar.f6801 = URLDecoder.decode(frVar.f6801, "UTF-8");
            }
            if (frVar.f6809 != null) {
                frVar.f6809 = URLDecoder.decode(frVar.f6809, "UTF-8");
            }
            if (frVar.f6800 != null) {
                frVar.f6800 = URLDecoder.decode(frVar.f6800, "UTF-8");
            }
            if (frVar.f6808 != null) {
                frVar.f6808 = URLDecoder.decode(frVar.f6808, "UTF-8");
            }
            if (frVar.f6804 != null) {
                frVar.f6804 = URLDecoder.decode(frVar.f6804, "UTF-8");
            }
            if (frVar.f6799 != null) {
                frVar.f6799 = URLDecoder.decode(frVar.f6799, "UTF-8");
            }
            if (frVar.f6806 != null) {
                frVar.f6806 = URLDecoder.decode(frVar.f6806, "UTF-8");
                frVar.m6452();
            }
            if (r4 != null) {
                frVar.f6798 = Cif.m6457(r4);
            }
        } catch (Exception e) {
        }
        return frVar;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m6453(String str) {
        if (str == null || "".equals(str.trim())) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (Throwable th) {
            return str;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m6452() {
        if (C1349Bv.m4107(this.f6806)) {
            String[] split = this.f6806.split("://", 2);
            if (C1349Bv.m4107(split[1])) {
                String[] split2 = split[1].split(":", 2);
                if (C1349Bv.m4107(split2[0])) {
                    this.f6807 = split2[0];
                }
                if (C1349Bv.m4107(split2[1])) {
                    String[] split3 = split2[1].split("/");
                    if (C1349Bv.m4107(split3[0])) {
                        this.f6802 = split3[0];
                    }
                }
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m6455() {
        return this.f6807;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m6456() {
        return this.f6802;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m6454() {
        return this.f6799 != null && this.f6799.contains("mdx-netflix-com:service");
    }

    public String toString() {
        return "RemoteDevice{, uuid='" + this.f6808 + "', location='" + this.f6806 + "', friendlyName='" + this.f6801 + "', dialUuid='" + this.f6804 + "', launchStatus=" + this.f6803 + ", registrationAcceptance=" + this.f6805 + ", activated=" + this.f6810 + ", serviceType='" + this.f6799 + "', manufacturer='" + this.f6809 + "', modelName='" + this.f6800 + "'}";
    }
}

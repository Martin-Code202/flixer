package o;

import android.content.Context;
import org.json.JSONObject;
public class lX {

    /* renamed from: ʽ  reason: contains not printable characters */
    public String f8600;

    /* renamed from: ˊ  reason: contains not printable characters */
    public String f8601;

    /* renamed from: ˋ  reason: contains not printable characters */
    public String f8602;

    /* renamed from: ˎ  reason: contains not printable characters */
    public String f8603;

    /* renamed from: ˏ  reason: contains not printable characters */
    String f8604;

    /* renamed from: ॱ  reason: contains not printable characters */
    public String f8605;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public String f8606;

    /* renamed from: ᐝ  reason: contains not printable characters */
    public JSONObject f8607;

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m8711() {
        return this.f8603;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m8713() {
        return this.f8602;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m8709() {
        return this.f8600;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public JSONObject m8710() {
        return this.f8607 == null ? new JSONObject() : this.f8607;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8714(Context context) {
        if (!C1349Bv.m4107(this.f8603)) {
            String r3 = m8707();
            if (this.f8602.startsWith("3.")) {
                this.f8603 = ((AbstractC2101qu) C1281.m16832(AbstractC2101qu.class)).mo10114(context, "(" + r3 + ")");
            } else {
                this.f8603 = ((AbstractC2101qu) C1281.m16832(AbstractC2101qu.class)).mo10116(context, "(" + r3 + ")");
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m8712() {
        return this.f8601;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public String m8715() {
        return this.f8602;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public String m8716() {
        return this.f8605;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public String m8708() {
        return this.f8604;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private String m8707() {
        if (C1349Bv.m4107(this.f8606) && C1349Bv.m4103(this.f8606)) {
            return this.f8602;
        }
        if (!C1349Bv.m4107(this.f8602)) {
            return "";
        }
        int indexOf = this.f8602.indexOf(".");
        if (indexOf < 0) {
            return this.f8602;
        }
        int indexOf2 = this.f8602.indexOf(".", indexOf + 1);
        if (indexOf2 >= 0) {
            return this.f8602.substring(0, indexOf2);
        }
        return this.f8602;
    }

    public String toString() {
        return "NrdpErr{errorCode='" + this.f8602 + "', errorString='" + this.f8601 + "', deviceSpecificString='" + this.f8605 + "'}";
    }
}

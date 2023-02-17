package o;

import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.ړ  reason: contains not printable characters */
public final class C0614 {

    /* renamed from: ˊ  reason: contains not printable characters */
    public String f13917;

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean f13918;

    /* renamed from: ˏ  reason: contains not printable characters */
    private JSONObject f13919;

    /* renamed from: ॱ  reason: contains not printable characters */
    public String f13920;

    public C0614(JSONObject jSONObject) {
        m14746(jSONObject);
    }

    public C0614(String str, String str2) {
        this.f13920 = str;
        this.f13917 = str2;
        m14747();
    }

    public String toString() {
        return this.f13919.toString();
    }

    public int hashCode() {
        int i;
        int i2;
        if (this.f13920 == null) {
            i = 0;
        } else {
            i = this.f13920.hashCode();
        }
        int i3 = (i + 31) * 31;
        if (this.f13917 == null) {
            i2 = 0;
        } else {
            i2 = this.f13917.hashCode();
        }
        return i3 + i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C0614)) {
            return false;
        }
        C0614 r2 = (C0614) obj;
        if (this.f13920 == null) {
            if (r2.f13920 != null) {
                return false;
            }
        } else if (!this.f13920.equals(r2.f13920)) {
            return false;
        }
        if (this.f13917 == null) {
            if (r2.f13917 != null) {
                return false;
            }
            return true;
        } else if (!this.f13917.equals(r2.f13917)) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m14746(JSONObject jSONObject) {
        this.f13919 = jSONObject;
        if (jSONObject == null) {
            C1283.m16850("nf_reg", "Tokens are null");
            return;
        }
        this.f13920 = AK.m3376(jSONObject, "NetflixId", (String) null);
        this.f13917 = AK.m3376(jSONObject, "SecureNetflixId", (String) null);
        if (this.f13920 == null || this.f13917 == null) {
            throw new JSONException("Tokens cannot be null");
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m14747() {
        if (this.f13920 == null || this.f13917 == null) {
            throw new JSONException("Tokens cannot be null");
        }
        this.f13919 = new JSONObject();
        this.f13919.put("NetflixId", this.f13920);
        this.f13919.put("SecureNetflixId", this.f13917);
    }
}

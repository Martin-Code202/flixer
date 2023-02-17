package o;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONObject;
/* renamed from: o.ᐢ  reason: contains not printable characters */
public class C0738 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f14309;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final JSONObject f14310 = new JSONObject(this.f14311);

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f14311;

    public C0738(String str, String str2) {
        this.f14311 = str;
        this.f14309 = str2;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m15117() {
        return this.f14310.optString("token", this.f14310.optString("purchaseToken"));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m15115() {
        return this.f14311;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m15116() {
        return this.f14309;
    }

    public String toString() {
        return "Purchase. Json: " + this.f14311;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0738)) {
            return false;
        }
        C0738 r2 = (C0738) obj;
        return TextUtils.equals(this.f14311, r2.m15115()) && TextUtils.equals(this.f14309, r2.m15116());
    }

    public int hashCode() {
        return this.f14311.hashCode();
    }

    /* renamed from: o.ᐢ$ˊ  reason: contains not printable characters */
    public static class C0739 {

        /* renamed from: ˊ  reason: contains not printable characters */
        private int f14312;

        /* renamed from: ˏ  reason: contains not printable characters */
        private List<C0738> f14313;

        C0739(int i, List<C0738> list) {
            this.f14313 = list;
            this.f14312 = i;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public int m15119() {
            return this.f14312;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public List<C0738> m15118() {
            return this.f14313;
        }
    }
}

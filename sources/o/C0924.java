package o;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONObject;
/* renamed from: o.ᘁ  reason: contains not printable characters */
public class C0924 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final JSONObject f14802 = new JSONObject(this.f14803);

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f14803;

    public C0924(String str) {
        this.f14803 = str;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m15730() {
        return this.f14802.optString("productId");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m15729() {
        return this.f14802.optString("price");
    }

    public String toString() {
        return "SkuDetails: " + this.f14803;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return TextUtils.equals(this.f14803, ((C0924) obj).f14803);
    }

    public int hashCode() {
        return this.f14803.hashCode();
    }

    /* renamed from: o.ᘁ$ˋ  reason: contains not printable characters */
    static class C0925 {

        /* renamed from: ˎ  reason: contains not printable characters */
        private List<C0924> f14804;

        /* renamed from: ˏ  reason: contains not printable characters */
        private int f14805;

        C0925(int i, List<C0924> list) {
            this.f14804 = list;
            this.f14805 = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˋ  reason: contains not printable characters */
        public List<C0924> m15731() {
            return this.f14804;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˎ  reason: contains not printable characters */
        public int m15732() {
            return this.f14805;
        }
    }
}

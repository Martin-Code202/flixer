package o;

import com.airbnb.lottie.LottieAnimationView;
import java.util.HashMap;
import java.util.Map;
/* renamed from: o.aUx  reason: case insensitive filesystem */
public class C1490aUx {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final C1518aux f5927 = null;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final LottieAnimationView f5928 = null;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f5929 = true;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Map<String, String> f5930 = new HashMap();

    C1490aUx() {
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m5402(String str) {
        return str;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final String m5401(String str) {
        if (this.f5929 && this.f5930.containsKey(str)) {
            return this.f5930.get(str);
        }
        String r1 = m5402(str);
        if (this.f5929) {
            this.f5930.put(str, r1);
        }
        return r1;
    }
}

package o;

import com.netflix.mediaclient.service.logging.client.model.Event;
import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import java.beans.ConstructorProperties;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Map;
public final class CR {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Map<String, String> f5020;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final int f5021;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f5022;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final byte[] f5023;

    @ConstructorProperties({LoggingRequest.VERSION, "headers", "status", Event.DATA})
    public CR(String str, Map<String, String> map, int i, byte[] bArr) {
        this.f5022 = str;
        this.f5020 = map;
        this.f5021 = i;
        this.f5023 = bArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CR)) {
            return false;
        }
        CR cr = (CR) obj;
        String r3 = m4303();
        String r4 = cr.m4303();
        if (r3 == null) {
            if (r4 != null) {
                return false;
            }
        } else if (!r3.equals(r4)) {
            return false;
        }
        Map<String, String> r5 = m4300();
        Map<String, String> r6 = cr.m4300();
        if (r5 == null) {
            if (r6 != null) {
                return false;
            }
        } else if (!r5.equals(r6)) {
            return false;
        }
        return m4301() == cr.m4301() && Arrays.equals(m4299(), cr.m4299());
    }

    public int hashCode() {
        String r4 = m4303();
        int hashCode = r4 == null ? 43 : r4.hashCode();
        Map<String, String> r5 = m4300();
        return ((((((hashCode + 59) * 59) + (r5 == null ? 43 : r5.hashCode())) * 59) + m4301()) * 59) + Arrays.hashCode(m4299());
    }

    public String toString() {
        return "ApiHttpWrapper(version=" + m4303() + ", headers=" + m4300() + ", status=" + m4301() + ", data=" + Arrays.toString(m4299()) + ")";
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m4303() {
        return this.f5022;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public Map<String, String> m4300() {
        return this.f5020;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public int m4301() {
        return this.f5021;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public byte[] m4299() {
        return this.f5023;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m4302() {
        return new String(this.f5023, Charset.forName("UTF-8"));
    }
}

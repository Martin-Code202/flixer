package o;

import com.netflix.mediaclient.service.mdx.protocol.MdxStackNetflix;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* renamed from: o.gn  reason: case insensitive filesystem */
public class C1828gn extends C1832gr {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final long f6986 = TimeUnit.DAYS.toMillis(28);

    /* renamed from: ʻ  reason: contains not printable characters */
    private final String f6987;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final int f6988;

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean f6989;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private boolean f6990;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final String f6991;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private long f6992 = System.currentTimeMillis();

    public C1828gn(String str, String str2, String str3, MdxStackNetflix mdxStackNetflix, C1767fa faVar, String str4, int i, String str5) {
        super(str, str2, str3, mdxStackNetflix, faVar);
        this.f6987 = str4;
        this.f6988 = i;
        this.f6991 = str5;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static C1828gn m6682(JSONObject jSONObject, MdxStackNetflix mdxStackNetflix, C1767fa faVar) {
        String string = jSONObject.getString("uuid");
        String string2 = jSONObject.getString("fn");
        String optString = jSONObject.optString("location");
        String string3 = jSONObject.getString("mac");
        int i = jSONObject.getInt("timeout");
        long j = jSONObject.getLong("lastseen");
        C1828gn gnVar = new C1828gn(string, string2, optString, mdxStackNetflix, faVar, string3, i, jSONObject.getString("ssid"));
        gnVar.m6683(j, false);
        return gnVar;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONObject m6684() {
        return new JSONObject().put("uuid", m6671()).put("fn", m6669()).put("location", m6667()).put("mac", this.f6987).put("timeout", this.f6988).put("lastseen", this.f6992).put("ssid", this.f6991);
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public boolean m6689() {
        return System.currentTimeMillis() <= this.f6992 + f6986;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m6683(long j, boolean z) {
        this.f6992 = j;
        this.f6989 = z;
    }

    @Override // o.AbstractC1823gi
    /* renamed from: ˎ */
    public void mo6672(String str, String str2) {
        super.mo6672(str, str2);
        m6683(System.currentTimeMillis(), true);
    }

    @Override // o.C1832gr, o.AbstractC1830gp
    /* renamed from: ॱ */
    public boolean mo6679(boolean z) {
        this.f6990 = z;
        if (this.f6989) {
            super.mo6679(z);
            return true;
        } else if (!z) {
            return true;
        } else {
            this.f6993.m746(this.f6987, this.f6988, m6671());
            return true;
        }
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public String m6685() {
        return this.f6991;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public void m6688() {
        m6683(System.currentTimeMillis(), false);
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public void m6686() {
        if (this.f6990) {
            super.mo6679(true);
            this.f6990 = false;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m6687(AbstractC1700eM eMVar) {
        if (this.f6990 && !this.f6989) {
            this.f6990 = false;
            eMVar.mo6057(m6671(), 106, m6669());
            m6683(0, false);
        }
    }
}

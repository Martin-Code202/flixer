package o;

import com.netflix.mediaclient.service.mdx.protocol.target.SessionMdxTarget;
/* renamed from: o.gi  reason: case insensitive filesystem */
public abstract class AbstractC1823gi {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static String f6971;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static String f6972;

    /* renamed from: ʼ  reason: contains not printable characters */
    private String f6973;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f6974;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected SessionMdxTarget f6975;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f6976;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected final C1767fa f6977;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected boolean f6978;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private AbstractC1744fD f6979;

    /* renamed from: ॱ */
    public abstract SessionMdxTarget mo791();

    public AbstractC1823gi(String str, String str2, String str3, C1767fa faVar) {
        this.f6974 = str;
        this.f6976 = str2;
        this.f6973 = str3;
        this.f6977 = faVar;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean mo6670(String str) {
        return this.f6974.equals(str);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m6671() {
        return this.f6974;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m6669() {
        return this.f6976;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m6667() {
        return this.f6973;
    }

    /* renamed from: ॱ */
    public void mo792(AbstractC1744fD fDVar) {
        this.f6979 = fDVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public AbstractC1744fD m6673() {
        AbstractC1744fD fDVar = this.f6979;
        this.f6979 = null;
        return fDVar;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m6664(String str) {
        f6971 = str;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m6665(String str) {
        f6972 = str;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    protected static String m6663() {
        return f6971;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected static String m6666() {
        return f6972;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo6672(String str, String str2) {
        this.f6973 = str;
        this.f6976 = str2;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m6668(boolean z) {
        if (z) {
            this.f6978 = false;
        }
        if (this.f6975 != null) {
            this.f6975.m773();
            if ((this instanceof C1825gk) || (this instanceof C1827gm)) {
                this.f6975 = null;
            }
        }
    }
}

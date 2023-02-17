package o;

import org.json.JSONObject;
public class jH extends jG {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final String f7954 = jH.class.getSimpleName();

    /* renamed from: ˏ  reason: contains not printable characters */
    protected String f7955;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f7956;

    public jH(String str) {
        super(str);
        this.f7941 = null;
        this.f7955 = str;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final synchronized void m7939() {
        if (this.f7956 == 0) {
            mo7858();
        }
        this.f7956++;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final synchronized void m7937() {
        this.f7956--;
        if (this.f7956 == 0) {
            m7938();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ */
    public void mo7858() {
        this.f7941 = new JSONObject(this.f7955);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m7938() {
        this.f7941 = null;
    }
}

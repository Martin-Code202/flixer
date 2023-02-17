package o;

import org.json.JSONObject;
/* renamed from: o.eO  reason: case insensitive filesystem */
public class C1702eO implements AbstractC2045ou {

    /* renamed from: ʻ  reason: contains not printable characters */
    protected static String f6564 = "isUHDAHDRSupported";

    /* renamed from: ˊ  reason: contains not printable characters */
    protected static String f6565 = "volumeStep";

    /* renamed from: ˋ  reason: contains not printable characters */
    protected static String f6566 = "is5dot1Supported";

    /* renamed from: ˎ  reason: contains not printable characters */
    protected static String f6567 = "autoAdvanceMax";

    /* renamed from: ˏ  reason: contains not printable characters */
    protected static String f6568 = "isHdSupported";

    /* renamed from: ॱ  reason: contains not printable characters */
    protected static String f6569 = "volumeControl";

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected static String f6570 = "isUltraHdSupported";

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected static String f6571 = "isDVHDRSupported";

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean f6572;

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean f6573;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private boolean f6574;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private boolean f6575;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private int f6576;

    /* renamed from: ͺ  reason: contains not printable characters */
    private boolean f6577;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private boolean f6578;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private int f6579;

    public C1702eO(String str) {
        this(new JSONObject(str));
    }

    public C1702eO(JSONObject jSONObject) {
        this.f6572 = AK.m3381(jSONObject, f6568, false);
        this.f6573 = AK.m3381(jSONObject, f6566, false);
        this.f6577 = AK.m3381(jSONObject, f6570, false);
        this.f6576 = AK.m3386(jSONObject, f6567, 0);
        if (jSONObject.has(f6569)) {
            this.f6575 = jSONObject.getBoolean(f6569);
        }
        if (jSONObject.has(f6565)) {
            this.f6579 = jSONObject.getInt(f6565);
        }
        this.f6574 = AK.m3381(jSONObject, f6564, false);
        this.f6578 = AK.m3381(jSONObject, f6571, false);
    }

    @Override // o.AbstractC2045ou
    /* renamed from: ˎ */
    public boolean mo1711() {
        return this.f6572;
    }

    @Override // o.AbstractC2045ou
    /* renamed from: ˋ */
    public boolean mo1710() {
        return this.f6573;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m6249() {
        return this.f6575;
    }

    @Override // o.AbstractC2045ou
    /* renamed from: ॱ */
    public boolean mo1712() {
        return this.f6577;
    }

    @Override // o.AbstractC2045ou
    /* renamed from: ˊ */
    public boolean mo1709() {
        return this.f6574;
    }

    @Override // o.AbstractC2045ou
    /* renamed from: ʼ */
    public boolean mo1708() {
        return this.f6578;
    }

    public String toString() {
        return "MdxTargetCapabilities [isHdSupported=" + this.f6572 + ", is5dot1Supported=" + this.f6573 + ", autoAdvanceMax=" + this.f6576 + ", volumeControl=" + this.f6575 + ", volumeStep=" + this.f6579 + ", isUltraHdSupported=" + this.f6577 + ", isHdr10Supported=" + this.f6574 + ", isDolbyVisionSupported=" + this.f6578 + "]";
    }
}

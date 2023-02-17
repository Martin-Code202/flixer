package o;

import com.netflix.mediaclient.service.mdx.logging.MdxErrorCode;
import org.json.JSONObject;
/* renamed from: o.fb  reason: case insensitive filesystem */
public class C1768fb {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final String f6740 = C1768fb.class.getSimpleName();

    /* renamed from: ʼ  reason: contains not printable characters */
    private String f6741;

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f6742;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f6743;

    /* renamed from: ˏ  reason: contains not printable characters */
    private MdxErrorCode f6744;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f6745;

    public C1768fb(MdxErrorCode mdxErrorCode, String str, String str2, String str3, String str4) {
        this.f6744 = mdxErrorCode;
        this.f6745 = str;
        this.f6743 = str2;
        this.f6742 = str3;
        this.f6741 = str4;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m6377(JSONObject jSONObject) {
        if (this.f6744 != null) {
            jSONObject.put("errorcode", this.f6744.m679());
        }
        if (C1349Bv.m4107(this.f6745)) {
            jSONObject.put("errorsubcode", this.f6745);
        }
        if (C1349Bv.m4107(this.f6743)) {
            jSONObject.put("errorextcode", this.f6743);
        }
        if (C1349Bv.m4107(this.f6742)) {
            jSONObject.put("errordetails", this.f6742);
        }
        if (C1349Bv.m4107(this.f6741)) {
            jSONObject.put("timeout", this.f6741);
        }
    }
}

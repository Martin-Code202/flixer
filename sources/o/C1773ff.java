package o;

import com.netflix.mediaclient.service.mdx.logging.MdxTargetType;
import org.json.JSONException;
/* renamed from: o.ff  reason: case insensitive filesystem */
public class C1773ff extends AbstractC1769fc {
    public C1773ff(String str, MdxTargetType mdxTargetType, String str2, String str3) {
        super(str);
        try {
            this.f6134.put("targettype", mdxTargetType.m682());
            this.f6134.put("deviceid", str2 != null ? str2 : "");
            this.f6134.put("devicename", str3 != null ? str3 : "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˋ */
    public String mo680() {
        return "mdxplay";
    }
}

package o;

import com.netflix.mediaclient.service.mdx.logging.MdxTargetType;
import org.json.JSONException;
/* renamed from: o.fi  reason: case insensitive filesystem */
public class C1776fi extends AbstractC1775fh {
    public C1776fi(String str, long j, MdxTargetType mdxTargetType, String str2, String str3, boolean z) {
        super(str, j);
        try {
            this.f6134.put("mdxver", "2014.1");
            this.f6134.put("targettype", mdxTargetType.m682());
            this.f6134.put("deviceid", str2 != null ? str2 : "");
            this.f6134.put("devicename", str3 != null ? str3 : "");
            this.f6134.put("usermismatch", String.valueOf(z));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˋ */
    public String mo680() {
        return "reconnect";
    }
}

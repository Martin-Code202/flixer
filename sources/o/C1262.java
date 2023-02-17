package o;

import android.content.Context;
import com.netflix.mediaclient.service.webclient.model.leafs.NonMemberData;
import com.netflix.mediaclient.service.webclient.model.leafs.NrmLanguagesData;
/* renamed from: o.ﾁ  reason: contains not printable characters */
public class C1262 {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static String f15909 = "nf_config_nrm";

    /* renamed from: ˊ  reason: contains not printable characters */
    public NonMemberData f15910;

    /* renamed from: ˋ  reason: contains not printable characters */
    public NrmLanguagesData f15911;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f15912;

    /* renamed from: ॱ  reason: contains not printable characters */
    public Context f15913;

    public C1262(Context context, String str) {
        this.f15913 = context;
        this.f15912 = str != null ? str : "nrmInfo";
        String r3 = C1339Bl.m4045(this.f15913, "nrmLanguages", (String) null);
        this.f15910 = NonMemberData.fromJsonString(C1339Bl.m4045(this.f15913, this.f15912, (String) null));
        this.f15911 = NrmLanguagesData.fromJsonString(r3);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m16759() {
        C1283.m16854(f15909, "clearing nrm cookies");
        this.f15910 = null;
        C1339Bl.m4041(this.f15913, "nrmInfo");
        C1339Bl.m4041(this.f15913, "aui_nrmInfo");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m16760(NonMemberData nonMemberData) {
        if (nonMemberData == null || !nonMemberData.isValid()) {
            C1283.m16850(f15909, "nonMemberData object is null or invalid - ignore overwrite");
            return;
        }
        C1339Bl.m4039(this.f15913, this.f15912, nonMemberData.toJsonString());
        this.f15910 = nonMemberData;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m16758(NrmLanguagesData nrmLanguagesData) {
        if (nrmLanguagesData == null) {
            C1283.m16850(f15909, "nrmLanguagesData object is null - ignore overwrite");
            return;
        }
        C1339Bl.m4039(this.f15913, "nrmLanguages", nrmLanguagesData.toJsonString());
        this.f15911 = nrmLanguagesData;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m16757(Context context) {
        return C1349Bv.m4107(C1339Bl.m4045(context, "nrmLanguages", (String) null));
    }
}

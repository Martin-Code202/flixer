package o;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.netflix.mediaclient.service.mdx.logging.MdxTargetType;
import com.netflix.mediaclient.service.mdx.protocol.MdxStackNetflix;
import com.netflix.mediaclient.service.mdx.protocol.target.SessionMdxTarget;
import o.BJ;
import org.json.JSONArray;
/* renamed from: o.eL  reason: case insensitive filesystem */
public class C1699eL implements AbstractC1689eB {

    /* renamed from: ʻ  reason: contains not printable characters */
    private C1782fo f6540;

    /* renamed from: ʽ  reason: contains not printable characters */
    private MdxStackNetflix f6541;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Looper f6542;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Handler f6543;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC1700eM f6544;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C1767fa f6545;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f6546;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private C1780fm f6547;

    C1699eL(AbstractC1700eM eMVar, String str, Looper looper, Handler handler, C1767fa faVar) {
        this.f6544 = eMVar;
        this.f6546 = str;
        this.f6542 = looper;
        this.f6543 = handler;
        this.f6545 = faVar;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m6215(Context context, C1710eW eWVar, oD oDVar, C1767fa faVar) {
        if (this.f6540 == null) {
            this.f6540 = new C1782fo(context, eWVar, oDVar, this.f6544, this.f6542, faVar);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m6217(Context context, oD oDVar, C1767fa faVar, String str) {
        if (this.f6547 == null) {
            this.f6547 = new C1780fm(context, oDVar, this.f6544, this.f6542, this.f6543, faVar, str);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m6218(Context context, oD oDVar, boolean z, JSONArray jSONArray, C1767fa faVar) {
        if (this.f6541 == null) {
            this.f6541 = new MdxStackNetflix(context, oDVar, this.f6544, this.f6542, z, jSONArray, this.f6546, faVar);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m6222() {
        C1283.m16862("MdxTargetManagerV2", "start MDX");
        if (this.f6540 != null) {
            this.f6540.m6444();
        }
        if (this.f6547 != null) {
            this.f6547.m6436();
        }
        if (this.f6541 != null) {
            this.f6541.m747();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m6214() {
        C1283.m16862("MdxTargetManagerV2", "stop");
        m6216((String) null, true);
        if (this.f6540 != null) {
            this.f6540.m6447();
        }
        if (this.f6547 != null) {
            this.f6547.m6429();
        }
        if (this.f6541 != null) {
            this.f6541.m743();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m6216(String str, boolean z) {
        C1283.m16863("MdxTargetManagerV2", "selectTarget %s %b", str, Boolean.valueOf(z));
        if (this.f6540 != null) {
            this.f6540.m6448(str);
        } else {
            C1283.m16865("MdxTargetManagerV2", "selectTarget, cast mdx is not ready");
        }
        if (this.f6547 != null) {
            this.f6547.m6433(str);
        } else {
            C1283.m16865("MdxTargetManagerV2", "selectTarget, cast CAF MDX is not ready");
        }
        if (this.f6541 != null) {
            this.f6541.m745(str);
        } else {
            C1283.m16865("MdxTargetManagerV2", "selectTarget, netflix mdx is not ready");
        }
        AbstractC1823gi r5 = m6204(str);
        if (r5 == null) {
            return false;
        }
        if (r5 instanceof AbstractC1830gp) {
            C1283.m16862("MdxTargetManagerV2", "selectTarget, need launch");
            ((AbstractC1830gp) r5).mo6679(z);
            return false;
        }
        SessionMdxTarget r6 = m6205(str);
        if (r6 != null) {
            C1283.m16862("MdxTargetManagerV2", "selectTarget, contact mdx target");
            r6.m788(z);
            return false;
        }
        C1283.m16863("MdxTargetManagerV2", "BUG!!! selectTarget failed %s", str);
        return false;
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public void m6220(String str) {
        AbstractC1823gi r1 = m6204(str);
        if (r1 != null) {
            r1.m6668(false);
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public void m6223(String str) {
        AbstractC1823gi r1 = m6204(str);
        if (r1 != null) {
            r1.m6668(true);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m6209() {
        if (this.f6547 != null) {
            this.f6547.m6434();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public Pair<String, String>[] m6219() {
        int i = 0;
        AbstractC1823gi[] giVarArr = new AbstractC1823gi[0];
        if (this.f6540 != null) {
            giVarArr = this.f6540.m6409();
            i = giVarArr.length + 0;
        }
        AbstractC1823gi[] giVarArr2 = new AbstractC1823gi[0];
        if (this.f6547 != null) {
            giVarArr2 = this.f6547.m6409();
            i += giVarArr2.length;
        }
        AbstractC1823gi[] giVarArr3 = new AbstractC1823gi[0];
        if (this.f6541 != null) {
            giVarArr3 = this.f6541.m6409();
            i += giVarArr3.length;
        }
        if (i <= 0) {
            return null;
        }
        Pair<String, String>[] pairArr = new Pair[i];
        int i2 = 0;
        for (AbstractC1823gi giVar : giVarArr) {
            i2++;
            pairArr[i2] = Pair.create(giVar.m6671(), giVar.m6669());
        }
        for (AbstractC1823gi giVar2 : giVarArr2) {
            i2++;
            pairArr[i2] = Pair.create(giVar2.m6671(), giVar2.m6669());
        }
        for (AbstractC1823gi giVar3 : giVarArr3) {
            i2++;
            pairArr[i2] = Pair.create(giVar3.m6671(), giVar3.m6669());
        }
        return pairArr;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m6212(String str, boolean z, String str2, String str3) {
        if (C1349Bv.m4113(str)) {
            str = "UNKNOWN-NAME";
        }
        if (C1349Bv.m4113(str3)) {
            str3 = "UNKNOWN-SSID";
        }
        if (C1349Bv.m4113(str2)) {
            str2 = "0.0.0.0";
        }
        if (this.f6540 != null) {
            this.f6540.m6446(str, z, str2, str3);
        }
        if (this.f6547 != null) {
            this.f6547.m6431(str, z, str2, str3);
        }
        if (this.f6541 != null) {
            this.f6541.m744(str, z, str2, str3);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m6211() {
        if (this.f6540 != null) {
            this.f6540.mo740();
        }
        if (this.f6547 != null) {
            this.f6547.mo740();
        }
        if (this.f6541 != null) {
            this.f6541.mo740();
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m6206() {
        if (this.f6540 != null) {
            this.f6540.m6441();
        }
        if (this.f6547 != null) {
            this.f6547.m6432();
        }
        if (this.f6541 != null) {
            this.f6541.m742();
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m6207() {
        if (this.f6540 != null) {
            this.f6540.m6445();
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m6208() {
        if (this.f6540 != null) {
            this.f6540.m6443();
        }
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private AbstractC1823gi m6204(String str) {
        if (this.f6540 != null) {
            return this.f6540.mo741(str);
        }
        if (this.f6547 != null) {
            return this.f6547.mo741(str);
        }
        if (this.f6541 != null) {
            return this.f6541.mo741(str);
        }
        return null;
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    private SessionMdxTarget m6205(String str) {
        AbstractC1823gi r1 = m6204(str);
        if (r1 != null) {
            return r1.mo791();
        }
        return null;
    }

    @Override // o.AbstractC1689eB
    /* renamed from: ˋ */
    public void mo6038(String str) {
        SessionMdxTarget r1 = m6205(str);
        if (null != r1) {
            r1.mo792(new C1747fG());
        }
    }

    @Override // o.AbstractC1689eB
    /* renamed from: ˎ */
    public void mo6040(String str) {
        SessionMdxTarget r1 = m6205(str);
        if (null != r1) {
            r1.mo792(new C1749fI());
        }
    }

    @Override // o.AbstractC1689eB
    /* renamed from: ॱ */
    public void mo6045(String str, int i) {
        SessionMdxTarget r1 = m6205(str);
        if (null != r1) {
            r1.mo792(new C1758fR(r1.m790(), i));
        }
    }

    @Override // o.AbstractC1689eB
    /* renamed from: ˏ */
    public void mo6043(String str, String str2, int i, String str3, int i2, boolean z) {
        SessionMdxTarget r8 = m6205(str);
        C1750fJ fJVar = new C1750fJ(str2, i, this.f6546, str3, Integer.valueOf(i2), z, Boolean.valueOf(C0908.m15705()));
        if (null != r8) {
            r8.mo792(fJVar);
            this.f6545.m6367(r8.m789() ? MdxTargetType.Cast : MdxTargetType.Nrdp, r8.m6671(), r8.m6669());
            return;
        }
        AbstractC1823gi r10 = m6204(str);
        if (r10 != null) {
            r10.mo792(fJVar);
            this.f6545.m6367(r10 instanceof C1825gk ? MdxTargetType.Cast : MdxTargetType.Nrdp, r10.m6671(), r10.m6669());
        }
    }

    @Override // o.AbstractC1689eB
    /* renamed from: ˏ */
    public void mo6042(String str) {
        SessionMdxTarget r1 = m6205(str);
        if (null != r1) {
            r1.mo792(new C1751fK(r1.m790()));
        }
    }

    @Override // o.AbstractC1689eB
    /* renamed from: ॱ */
    public void mo6044(String str) {
        SessionMdxTarget r1 = m6205(str);
        if (null != r1) {
            r1.mo792(new C1752fL(r1.m790()));
        }
    }

    @Override // o.AbstractC1689eB
    /* renamed from: ˊ */
    public void mo6035(String str) {
        SessionMdxTarget r1 = m6205(str);
        if (null != r1) {
            r1.mo792(new C1756fP(r1.m790()));
        }
    }

    @Override // o.AbstractC1689eB
    /* renamed from: ˊ */
    public void mo6036(String str, int i) {
        SessionMdxTarget r1 = m6205(str);
        if (null != r1) {
            r1.mo792(new C1759fS(r1.m790(), i));
        }
    }

    @Override // o.AbstractC1689eB
    /* renamed from: ʽ */
    public void mo6034(String str) {
        SessionMdxTarget r1 = m6205(str);
        if (null != r1) {
            r1.mo792(new C1755fO(r1.m790()));
        }
    }

    @Override // o.AbstractC1689eB
    /* renamed from: ˋ */
    public void mo6039(String str, int i) {
        SessionMdxTarget r1 = m6205(str);
        if (null != r1) {
            r1.mo792(new C1754fN(r1.m790(), i));
        }
    }

    @Override // o.AbstractC1689eB
    /* renamed from: ˎ */
    public void mo6041(String str, int i) {
        SessionMdxTarget r1 = m6205(str);
        if (null != r1) {
            r1.mo792(new C1753fM(r1.m790(), i));
        }
    }

    @Override // o.AbstractC1689eB
    /* renamed from: ˊ */
    public void mo6037(String str, String str2, String str3) {
        SessionMdxTarget r1 = m6205(str);
        if (null != r1) {
            r1.mo792(new C1763fW(str2, str3));
        }
    }

    @Override // o.AbstractC1689eB
    /* renamed from: ॱ */
    public void mo6046(String str, String str2, String str3) {
        SessionMdxTarget r1 = m6205(str);
        if (null != r1) {
            r1.mo792(new C1742fB(str2, str3));
        }
    }

    @Override // o.AbstractC1689eB
    /* renamed from: ॱ */
    public void mo6047(String str, String str2, String str3, String str4) {
        SessionMdxTarget r1 = m6205(str);
        if (null != r1) {
            r1.mo792(new C1748fH(str2, str3, str4));
        }
    }

    @Override // o.AbstractC1689eB
    /* renamed from: ॱॱ */
    public void mo6048(String str) {
        SessionMdxTarget r1 = m6205(str);
        if (null != r1) {
            r1.mo792(new C1743fC());
        }
    }

    @Override // o.AbstractC1689eB
    /* renamed from: ʼ */
    public void mo6033(String str) {
        SessionMdxTarget r1 = m6205(str);
        if (null != r1) {
            r1.mo792(new C1746fF());
        }
    }

    @Override // o.AbstractC1689eB
    /* renamed from: ʻ */
    public void mo6032(String str) {
        SessionMdxTarget r1 = m6205(str);
        if (null != r1) {
            r1.mo792(new C1745fE());
        }
    }

    @Override // o.AbstractC1689eB
    /* renamed from: ᐝ */
    public void mo6049(String str) {
        SessionMdxTarget r1 = m6205(str);
        if (null != r1) {
            r1.mo792(new C1757fQ(r1.m790()));
        }
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public boolean m6210(String str) {
        SessionMdxTarget r1 = m6205(str);
        return r1 != null && r1.m798();
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public boolean m6213(String str) {
        return m6205(str) != null;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public long m6221(String str) {
        SessionMdxTarget r2 = m6205(str);
        if (r2 != null) {
            return r2.m771().longValue();
        }
        return 0;
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public boolean m6227(String str) {
        return m6205(str) != null;
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public C1702eO m6226(String str) {
        SessionMdxTarget r1 = m6205(str);
        if (null != r1) {
            return r1.m782();
        }
        return null;
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    public BJ.C0067 m6224(String str) {
        SessionMdxTarget r1 = m6205(str);
        if (null != r1) {
            return r1.m795();
        }
        return null;
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    public String m6225(String str) {
        SessionMdxTarget r1 = m6205(str);
        if (r1 != null) {
            return r1.m6671();
        }
        return null;
    }
}

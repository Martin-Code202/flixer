package o;

import java.util.Map;
public interface oD extends AbstractC2004nh {

    /* renamed from: o.oD$iF  reason: case insensitive filesystem */
    public interface AbstractC2024iF {
        /* renamed from: ˎ  reason: contains not printable characters */
        void m9392(String str);
    }

    /* renamed from: o.oD$ˊ  reason: contains not printable characters */
    public interface AbstractC0158 {
        /* renamed from: ˋ  reason: contains not printable characters */
        void m9393(long j);
    }

    /* renamed from: ˉ */
    C1407Dx mo6782();

    /* renamed from: ˊ */
    void mo6784(oO oOVar);

    /* renamed from: ˊᐝ */
    AbstractC1400Dq mo6785();

    /* renamed from: ˋ */
    DY mo6786(String str, String str2);

    /* renamed from: ˋ */
    If mo6787();

    /* renamed from: ˋ */
    boolean mo6788(String str);

    /* renamed from: ˍ */
    void mo6789();

    /* renamed from: ˎ */
    void mo6790();

    /* renamed from: ˏ */
    void mo6792(String str, String str2);

    /* renamed from: ॱ */
    C0159 mo6793();

    /* renamed from: o.oD$if  reason: invalid class name */
    public static class Cif {

        /* renamed from: ˊ  reason: contains not printable characters */
        public String f9226;

        /* renamed from: ˋ  reason: contains not printable characters */
        public String f9227;

        /* renamed from: ˎ  reason: contains not printable characters */
        public Map<String, String> f9228;

        /* renamed from: ˏ  reason: contains not printable characters */
        public String f9229;

        /* renamed from: ॱ  reason: contains not printable characters */
        public String f9230;

        public Cif(String str, String str2, Map<String, String> map, String str3, String str4) {
            this.f9230 = str;
            this.f9229 = str2;
            this.f9228 = map;
            this.f9226 = str3;
            this.f9227 = str4;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("MSLApiUnwrappedParams{ uri=").append(this.f9230).append(", method='").append(this.f9229).append(", additional headers=");
            if (this.f9228 == null || this.f9228.size() < 1) {
                sb.append("null");
            } else {
                sb.append("{");
                boolean z = true;
                for (String str : this.f9228.keySet()) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(str).append('=').append(this.f9228.get(str));
                }
                sb.append("}");
            }
            sb.append(", query='").append(this.f9226).append(", payload='").append(this.f9227).append("}");
            return sb.toString();
        }
    }

    public static class If {

        /* renamed from: ˋ  reason: contains not printable characters */
        public String f9223;

        /* renamed from: ˎ  reason: contains not printable characters */
        public C1411Eb f9224;

        /* renamed from: ˏ  reason: contains not printable characters */
        public DV f9225;

        public If(String str, DV dv, C1411Eb eb) {
            this.f9223 = str;
            this.f9225 = dv;
            this.f9224 = eb;
        }

        public String toString() {
            return "RenewUserAuthenticationData{userId='" + this.f9223 + "', masterToken=" + this.f9225 + ", userIdToken=" + this.f9224 + '}';
        }
    }

    /* renamed from: o.oD$ˋ  reason: contains not printable characters */
    public static class C0159 {

        /* renamed from: ˊ  reason: contains not printable characters */
        public AbstractC1386Dc f9231;

        /* renamed from: ˎ  reason: contains not printable characters */
        public DV f9232;

        /* renamed from: ˏ  reason: contains not printable characters */
        public C1411Eb f9233;

        public C0159(DV dv, C1411Eb eb, AbstractC1386Dc dc) {
            this.f9232 = dv;
            this.f9233 = eb;
            this.f9231 = dc;
        }
    }
}

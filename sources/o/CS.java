package o;

import com.netflix.msl.msg.MessageContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
public final class CS implements MessageContext {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final CP f5024;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final String f5025;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final byte[] f5026;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final boolean f5027;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final DK f5028;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final boolean f5029;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final boolean f5030;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f5031;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final AbstractC1412Ec f5032;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CS)) {
            return false;
        }
        CS cs = (CS) obj;
        if (mo3122() != cs.mo3122() || mo3133() != cs.mo3133() || mo3134() != cs.mo3134()) {
            return false;
        }
        String r3 = mo3125();
        String r4 = cs.mo3125();
        if (r3 == null) {
            if (r4 != null) {
                return false;
            }
        } else if (!r3.equals(r4)) {
            return false;
        }
        DK r5 = mo3128();
        DK r6 = cs.mo3128();
        if (r5 == null) {
            if (r6 != null) {
                return false;
            }
        } else if (!r5.equals(r6)) {
            return false;
        }
        String r7 = mo3124();
        String r8 = cs.mo3124();
        if (r7 == null) {
            if (r8 != null) {
                return false;
            }
        } else if (!r7.equals(r8)) {
            return false;
        }
        AbstractC1412Ec r9 = m4307();
        AbstractC1412Ec r10 = cs.m4307();
        if (r9 == null) {
            if (r10 != null) {
                return false;
            }
        } else if (!r9.equals(r10)) {
            return false;
        }
        if (!Arrays.equals(m4306(), cs.m4306())) {
            return false;
        }
        CP r11 = m4305();
        CP r12 = cs.m4305();
        return r11 == null ? r12 == null : r11.equals(r12);
    }

    public int hashCode() {
        int i = ((((mo3122() ? 79 : 97) + 59) * 59) + (mo3133() ? 79 : 97)) * 59;
        int i2 = mo3134() ? 79 : 97;
        String r4 = mo3125();
        int i3 = (i + i2) * 59;
        int hashCode = r4 == null ? 43 : r4.hashCode();
        DK r5 = mo3128();
        int i4 = (i3 + hashCode) * 59;
        int hashCode2 = r5 == null ? 43 : r5.hashCode();
        String r6 = mo3124();
        int i5 = (i4 + hashCode2) * 59;
        int hashCode3 = r6 == null ? 43 : r6.hashCode();
        AbstractC1412Ec r7 = m4307();
        int i6 = (i5 + hashCode3) * 59;
        int hashCode4 = r7 == null ? 43 : r7.hashCode();
        CP r8 = m4305();
        return ((((i6 + hashCode4) * 59) + Arrays.hashCode(m4306())) * 59) + (r8 == null ? 43 : r8.hashCode());
    }

    public String toString() {
        return "ClientRequestMessageContext(encrypted=" + mo3122() + ", integrityProtected=" + mo3133() + ", nonReplayable=" + mo3134() + ", recipient=" + mo3125() + ", debugContext=" + mo3128() + ", userId=" + mo3124() + ", userAuthData=" + m4307() + ", payload=" + Arrays.toString(m4306()) + ", keyRequestDataProvider=" + m4305() + ")";
    }

    @Override // com.netflix.msl.msg.MessageContext
    /* renamed from: ʻ */
    public boolean mo3122() {
        return this.f5029;
    }

    @Override // com.netflix.msl.msg.MessageContext
    /* renamed from: ॱॱ */
    public boolean mo3133() {
        return this.f5027;
    }

    @Override // com.netflix.msl.msg.MessageContext
    /* renamed from: ᐝ */
    public boolean mo3134() {
        return this.f5030;
    }

    @Override // com.netflix.msl.msg.MessageContext
    /* renamed from: ˋ */
    public DK mo3128() {
        return this.f5028;
    }

    @Override // com.netflix.msl.msg.MessageContext
    /* renamed from: ʽ */
    public String mo3124() {
        return this.f5025;
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public AbstractC1412Ec m4307() {
        return this.f5032;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public byte[] m4306() {
        return this.f5026;
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public CP m4305() {
        return this.f5024;
    }

    /* renamed from: o.CS$ˋ  reason: contains not printable characters */
    public static class C0078 {

        /* renamed from: ʻ  reason: contains not printable characters */
        private AbstractC1412Ec f5033;

        /* renamed from: ʽ  reason: contains not printable characters */
        private String f5034;

        /* renamed from: ˊ  reason: contains not printable characters */
        private String f5035;

        /* renamed from: ˋ  reason: contains not printable characters */
        private Boolean f5036;

        /* renamed from: ˎ  reason: contains not printable characters */
        private Boolean f5037;

        /* renamed from: ˏ  reason: contains not printable characters */
        private DK f5038;

        /* renamed from: ॱ  reason: contains not printable characters */
        private Boolean f5039;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        private CP f5040;

        /* renamed from: ᐝ  reason: contains not printable characters */
        private byte[] f5041;

        C0078() {
        }

        public String toString() {
            return "ClientRequestMessageContext.ClientRequestMessageContextBuilder(encrypted=" + this.f5036 + ", integrityProtected=" + this.f5039 + ", nonReplayable=" + this.f5037 + ", userId=" + this.f5035 + ", debugContext=" + this.f5038 + ", userAuthData=" + this.f5033 + ", payload=" + Arrays.toString(this.f5041) + ", recipient=" + this.f5034 + ", keyRequestDataProvider=" + this.f5040 + ")";
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public C0078 m4308(Boolean bool) {
            this.f5036 = bool;
            return this;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public C0078 m4309(AbstractC1412Ec ec) {
            this.f5033 = ec;
            return this;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public C0078 m4310(Boolean bool) {
            this.f5037 = bool;
            return this;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public C0078 m4311(DK dk) {
            this.f5038 = dk;
            return this;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public C0078 m4312(byte[] bArr) {
            this.f5041 = bArr;
            return this;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public C0078 m4313(CP cp) {
            this.f5040 = cp;
            return this;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public CS m4314() {
            return new CS(this.f5036, this.f5039, this.f5037, this.f5035, this.f5038, this.f5033, this.f5041, this.f5034, this.f5040);
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public C0078 m4315(String str) {
            this.f5035 = str;
            return this;
        }
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public static C0078 m4304() {
        return new C0078();
    }

    private CS(Boolean bool, Boolean bool2, Boolean bool3, String str, DK dk, AbstractC1412Ec ec, byte[] bArr, String str2, CP cp) {
        this.f5029 = bool != null ? bool.booleanValue() : true;
        this.f5027 = bool2 != null ? bool2.booleanValue() : true;
        this.f5030 = bool3 != null ? bool3.booleanValue() : false;
        this.f5025 = str;
        this.f5028 = dk;
        this.f5032 = ec;
        this.f5026 = bArr;
        this.f5031 = str2;
        this.f5024 = cp;
    }

    @Override // com.netflix.msl.msg.MessageContext
    /* renamed from: ˏ */
    public Map<String, AbstractC1386Dc> mo3130() {
        return Collections.emptyMap();
    }

    @Override // com.netflix.msl.msg.MessageContext
    /* renamed from: ˊ */
    public String mo3125() {
        return this.f5031;
    }

    @Override // com.netflix.msl.msg.MessageContext
    /* renamed from: ʼ */
    public boolean mo3123() {
        return false;
    }

    @Override // com.netflix.msl.msg.MessageContext
    /* renamed from: ˏ */
    public AbstractC1412Ec mo3131(MessageContext.ReauthCode reauthCode, boolean z, boolean z2) {
        if (reauthCode != null || !z2) {
            return null;
        }
        return this.f5032;
    }

    @Override // com.netflix.msl.msg.MessageContext
    /* renamed from: ˎ */
    public DW mo3129() {
        return null;
    }

    @Override // com.netflix.msl.msg.MessageContext
    /* renamed from: ॱ */
    public Set<AbstractC1408Dy> mo3132() {
        AbstractC1408Dy r1 = this.f5024.mo4290();
        if (r1 != null) {
            return Collections.singleton(r1);
        }
        return Collections.emptySet();
    }

    @Override // com.netflix.msl.msg.MessageContext
    /* renamed from: ˊ */
    public void mo3127(DR dr, boolean z) {
    }

    @Override // com.netflix.msl.msg.MessageContext
    /* renamed from: ˊ */
    public void mo3126(DO r2) {
        if (this.f5026 != null) {
            r2.write(this.f5026);
            r2.close();
        }
    }
}

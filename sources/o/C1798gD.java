package o;

import com.netflix.msl.msg.MessageContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
/* renamed from: o.gD  reason: case insensitive filesystem */
public class C1798gD implements MessageContext {

    /* renamed from: ʻ  reason: contains not printable characters */
    private byte[] f6859;

    /* renamed from: ʼ  reason: contains not printable characters */
    private String f6860;

    /* renamed from: ʽ  reason: contains not printable characters */
    private AbstractC1412Ec f6861;

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f6862;

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f6863;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f6864;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f6865;

    /* renamed from: ॱ  reason: contains not printable characters */
    DK f6866;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private boolean f6867;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private CP f6868;

    public C1798gD(Boolean bool, Boolean bool2, Boolean bool3, String str, DK dk, AbstractC1412Ec ec, byte[] bArr, String str2, CP cp, Boolean bool4) {
        this.f6862 = bool != null ? bool.booleanValue() : true;
        this.f6863 = bool2 != null ? bool2.booleanValue() : true;
        this.f6864 = bool3 != null ? bool3.booleanValue() : false;
        this.f6860 = str;
        this.f6866 = dk;
        this.f6861 = ec;
        this.f6859 = bArr;
        this.f6865 = str2;
        this.f6868 = cp;
        this.f6867 = bool4 != null ? bool4.booleanValue() : false;
    }

    @Override // com.netflix.msl.msg.MessageContext
    /* renamed from: ˏ */
    public Map<String, AbstractC1386Dc> mo3130() {
        return Collections.emptyMap();
    }

    @Override // com.netflix.msl.msg.MessageContext
    /* renamed from: ˊ */
    public String mo3125() {
        return this.f6865;
    }

    @Override // com.netflix.msl.msg.MessageContext
    /* renamed from: ˏ */
    public AbstractC1412Ec mo3131(MessageContext.ReauthCode reauthCode, boolean z, boolean z2) {
        if (reauthCode != null || !z2) {
            return null;
        }
        return this.f6861;
    }

    @Override // com.netflix.msl.msg.MessageContext
    /* renamed from: ˎ */
    public DW mo3129() {
        return null;
    }

    @Override // com.netflix.msl.msg.MessageContext
    /* renamed from: ॱ */
    public Set<AbstractC1408Dy> mo3132() {
        AbstractC1408Dy r1 = this.f6868.mo4290();
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
        if (this.f6859 != null) {
            r2.write(this.f6859);
            r2.close();
        }
    }

    @Override // com.netflix.msl.msg.MessageContext
    /* renamed from: ˋ */
    public DK mo3128() {
        return null;
    }

    @Override // com.netflix.msl.msg.MessageContext
    /* renamed from: ʻ */
    public boolean mo3122() {
        return this.f6862;
    }

    @Override // com.netflix.msl.msg.MessageContext
    /* renamed from: ॱॱ */
    public boolean mo3133() {
        return this.f6863;
    }

    @Override // com.netflix.msl.msg.MessageContext
    /* renamed from: ᐝ */
    public boolean mo3134() {
        return this.f6864;
    }

    @Override // com.netflix.msl.msg.MessageContext
    /* renamed from: ʼ */
    public boolean mo3123() {
        return this.f6867;
    }

    @Override // com.netflix.msl.msg.MessageContext
    /* renamed from: ʽ */
    public String mo3124() {
        return this.f6860;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1798gD gDVar = (C1798gD) obj;
        if (this.f6862 != gDVar.f6862 || this.f6863 != gDVar.f6863 || this.f6864 != gDVar.f6864 || this.f6867 != gDVar.f6867) {
            return false;
        }
        if (this.f6865 != null) {
            if (!this.f6865.equals(gDVar.f6865)) {
                return false;
            }
        } else if (gDVar.f6865 != null) {
            return false;
        }
        if (this.f6866 != null) {
            if (!this.f6866.equals(gDVar.f6866)) {
                return false;
            }
        } else if (gDVar.f6866 != null) {
            return false;
        }
        if (this.f6860 != null) {
            if (!this.f6860.equals(gDVar.f6860)) {
                return false;
            }
        } else if (gDVar.f6860 != null) {
            return false;
        }
        if (this.f6861 != null) {
            if (!this.f6861.equals(gDVar.f6861)) {
                return false;
            }
        } else if (gDVar.f6861 != null) {
            return false;
        }
        if (!Arrays.equals(this.f6859, gDVar.f6859)) {
            return false;
        }
        if (this.f6868 != null) {
            return this.f6868.equals(gDVar.f6868);
        }
        return gDVar.f6868 == null;
    }

    public int hashCode() {
        return ((((((((((((((((((this.f6862 ? 1 : 0) * 31) + (this.f6863 ? 1 : 0)) * 31) + (this.f6864 ? 1 : 0)) * 31) + (this.f6865 != null ? this.f6865.hashCode() : 0)) * 31) + (this.f6866 != null ? this.f6866.hashCode() : 0)) * 31) + (this.f6860 != null ? this.f6860.hashCode() : 0)) * 31) + (this.f6861 != null ? this.f6861.hashCode() : 0)) * 31) + Arrays.hashCode(this.f6859)) * 31) + (this.f6868 != null ? this.f6868.hashCode() : 0)) * 31) + (this.f6867 ? 1 : 0);
    }

    public String toString() {
        return "AndroidRequestMessageContext{encrypted=" + this.f6862 + ", integrityProtected=" + this.f6863 + ", nonReplayable=" + this.f6864 + ", recipient='" + this.f6865 + "', debugContext=" + this.f6866 + ", userId='" + this.f6860 + "', userAuthData=" + this.f6861 + ", payload=" + Arrays.toString(this.f6859) + ", keyRequestDataProvider=" + this.f6868 + ", requestingTokens=" + this.f6867 + '}';
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public static iF m6517() {
        return new iF();
    }

    /* renamed from: o.gD$iF */
    public static class iF {

        /* renamed from: ʻ  reason: contains not printable characters */
        private CP f6869;

        /* renamed from: ʼ  reason: contains not printable characters */
        private AbstractC1412Ec f6870;

        /* renamed from: ʽ  reason: contains not printable characters */
        private Boolean f6871;

        /* renamed from: ˊ  reason: contains not printable characters */
        private String f6872;

        /* renamed from: ˋ  reason: contains not printable characters */
        private DK f6873;

        /* renamed from: ˎ  reason: contains not printable characters */
        private Boolean f6874;

        /* renamed from: ˏ  reason: contains not printable characters */
        private Boolean f6875;

        /* renamed from: ॱ  reason: contains not printable characters */
        private Boolean f6876;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        private String f6877;

        /* renamed from: ᐝ  reason: contains not printable characters */
        private byte[] f6878;

        iF() {
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public iF m6518(Boolean bool) {
            this.f6871 = bool;
            return this;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public iF m6525(Boolean bool) {
            this.f6874 = bool;
            return this;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public iF m6521(String str) {
            this.f6872 = str;
            return this;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public iF m6524(DK dk) {
            this.f6873 = dk;
            return this;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public iF m6522(AbstractC1412Ec ec) {
            this.f6870 = ec;
            return this;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public iF m6523(byte[] bArr) {
            this.f6878 = bArr;
            return this;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public iF m6519(CP cp) {
            this.f6869 = cp;
            return this;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public C1798gD m6520() {
            return new C1798gD(this.f6876, this.f6875, this.f6874, this.f6872, this.f6873, this.f6870, this.f6878, this.f6877, this.f6869, this.f6871);
        }

        public String toString() {
            return "AndroidRequestMessageContextBuilder{encrypted=" + this.f6876 + ", integrityProtected=" + this.f6875 + ", nonReplayable=" + this.f6874 + ", userId='" + this.f6872 + "', debugContext=" + this.f6873 + ", userAuthData=" + this.f6870 + ", payload=" + Arrays.toString(this.f6878) + ", recipient='" + this.f6877 + "', keyRequestDataProvider=" + this.f6869 + ", requestingTokens=" + this.f6871 + '}';
        }
    }
}

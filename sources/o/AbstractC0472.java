package o;

import android.util.Base64;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.configuration.crypto.CryptoProvider;
/* renamed from: o.ϝ  reason: contains not printable characters */
public interface AbstractC0472 {

    /* renamed from: o.ϝ$ˊ  reason: contains not printable characters */
    public interface AbstractC0473 {
        /* renamed from: ˊ  reason: contains not printable characters */
        void mo14371();

        /* renamed from: ˏ  reason: contains not printable characters */
        void mo14372();

        /* renamed from: ˏ  reason: contains not printable characters */
        void mo14373(Status status);

        /* renamed from: ॱ  reason: contains not printable characters */
        void mo14374();
    }

    /* renamed from: ʻ */
    DF mo14354();

    /* renamed from: ˊ */
    void mo14355();

    /* renamed from: ˊ */
    void mo14356(C0474 v);

    /* renamed from: ˊ */
    byte[] mo14357(C0474 v, Cif ifVar, byte[] bArr, byte[] bArr2);

    /* renamed from: ˎ */
    CryptoProvider mo14358();

    /* renamed from: ˎ */
    C0474 mo14359(DF df, byte[] bArr, Cif ifVar, Cif ifVar2);

    /* renamed from: ˎ */
    C0474 mo14360(Cif ifVar);

    /* renamed from: ˎ */
    byte[] mo14361(C0474 v, Cif ifVar, byte[] bArr, byte[] bArr2);

    /* renamed from: ˏ */
    byte[] mo14362(C0474 v, Cif ifVar, byte[] bArr);

    /* renamed from: ॱ */
    boolean mo14363(C0474 v, Cif ifVar, byte[] bArr, byte[] bArr2);

    /* renamed from: o.ϝ$ˋ  reason: contains not printable characters */
    public static class C0474 {

        /* renamed from: ˊ  reason: contains not printable characters */
        public Cif f13524;

        /* renamed from: ˋ  reason: contains not printable characters */
        public byte[] f13525;

        /* renamed from: ॱ  reason: contains not printable characters */
        public byte[] f13526;

        /* renamed from: ˎ  reason: contains not printable characters */
        public byte[] m14376() {
            return this.f13525;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public String m14375() {
            if (this.f13525 == null) {
                return null;
            }
            return Base64.encodeToString(this.f13525, 2);
        }

        public String toString() {
            return "CryptoSession{keySetId=" + this.f13524 + ", sessionId=" + (this.f13526 != null ? C1324Ax.m3816(this.f13526) : "") + ", keyRequestData=" + m14375() + '}';
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public boolean m14377() {
            return this.f13525 == null || this.f13525.length <= 0;
        }
    }

    /* renamed from: o.ϝ$if  reason: invalid class name */
    public static class Cif {

        /* renamed from: ˊ  reason: contains not printable characters */
        private byte[] f13522;

        /* renamed from: ˋ  reason: contains not printable characters */
        private String f13523;

        public Cif(String str) {
            if (C1349Bv.m4113(str)) {
                throw new IllegalStateException("Key Set ID can not be empty!");
            }
            this.f13523 = str;
            this.f13522 = C1324Ax.m3818(str);
            m14368();
        }

        public Cif(byte[] bArr) {
            this.f13522 = bArr;
            m14368();
            this.f13523 = C1324Ax.m3816(bArr);
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public String m14370() {
            return this.f13523;
        }

        public String toString() {
            return "KeyId{" + this.f13523 + '}';
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public byte[] m14369() {
            return this.f13522;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        private void m14368() {
            if (this.f13522 == null || this.f13522.length == 0) {
                throw new IllegalStateException("Key Set ID can not be empty!");
            }
        }
    }
}

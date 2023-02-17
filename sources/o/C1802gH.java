package o;

import com.netflix.android.org.json.JSONException;
import com.netflix.msl.MslInternalException;
import com.netflix.msl.io.MslEncoderException;
import java.nio.charset.Charset;
/* renamed from: o.gH  reason: case insensitive filesystem */
public class C1802gH extends C1401Dr implements AbstractC0625 {

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final Charset f6892 = Charset.forName("UTF-8");

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AbstractC1400Dq f6893;

    public C1802gH(AbstractC1400Dq dq, C1401Dr dr) {
        this.f6893 = dq;
        for (int i = 0; i < dr.m4732(); i++) {
            try {
                mo4734(i, dr.m4733(i));
            } catch (IllegalArgumentException e) {
                throw new MslEncoderException("Invalid MSL array encoding.", e);
            }
        }
    }

    public C1802gH(AbstractC1400Dq dq, C0572 r5) {
        this.f6893 = dq;
        for (int i = 0; i < r5.m14673(); i++) {
            try {
                mo4734(-1, r5.m14668(i));
            } catch (JSONException e) {
                throw new MslEncoderException("Invalid JSON array encoding.", e);
            } catch (IllegalArgumentException e2) {
                throw new MslEncoderException("Invalid MSL array encoding.", e2);
            }
        }
    }

    @Override // o.C1401Dr
    /* renamed from: ˋ */
    public C1401Dr mo4734(int i, Object obj) {
        Object obj2;
        if (obj instanceof C0355) {
            try {
                obj2 = new C1809gO(this.f6893, (C0355) obj);
            } catch (MslEncoderException e) {
                throw new IllegalArgumentException("Unsupported JSON object or array representation.", e);
            }
        } else if (obj instanceof C0572) {
            obj2 = new C1802gH(this.f6893, (C0572) obj);
        } else {
            obj2 = obj;
        }
        return super.mo4734(i, obj2);
    }

    @Override // o.C1401Dr
    /* renamed from: ˊ */
    public byte[] mo4731(int i) {
        Object r3 = m4737(i);
        if (r3 instanceof byte[]) {
            return (byte[]) r3;
        }
        if (r3 instanceof String) {
            try {
                return C1418Ei.m4894((String) r3);
            } catch (IllegalArgumentException e) {
            }
        }
        throw new MslEncoderException("MslArray[" + i + "] is not binary data.");
    }

    @Override // o.C1401Dr
    /* renamed from: ॱ */
    public byte[] mo4738(int i, byte[] bArr) {
        Object r1 = m4733(i);
        if (r1 instanceof byte[]) {
            return (byte[]) r1;
        }
        if (r1 instanceof String) {
            try {
                return C1418Ei.m4894((String) r1);
            } catch (IllegalArgumentException e) {
            }
        }
        return bArr;
    }

    @Override // o.AbstractC0625
    /* renamed from: ˊ  reason: contains not printable characters */
    public String mo6562() {
        try {
            C0572 r3 = new C0572();
            int r4 = m4732();
            for (int i = 0; i < r4; i++) {
                Object r6 = m4733(i);
                if (r6 instanceof byte[]) {
                    r3.m14671(i, C1418Ei.m4892((byte[]) r6));
                } else if ((r6 instanceof C1809gO) || (r6 instanceof C1802gH)) {
                    r3.m14671(i, r6);
                } else if (r6 instanceof C1405Dv) {
                    r3.m14671(i, new C1809gO(this.f6893, (C1405Dv) r6));
                } else if (r6 instanceof C1401Dr) {
                    r3.m14671(i, new C1802gH(this.f6893, (C1401Dr) r6));
                } else if (r6 instanceof AbstractC1399Dp) {
                    r3.m14671(i, new C1809gO(this.f6893, ((AbstractC1399Dp) r6).mo3114(this.f6893, C1407Dx.f5471)));
                } else {
                    r3.m14671(i, r6);
                }
            }
            return r3.toString();
        } catch (IllegalArgumentException e) {
            throw new MslInternalException("Error encoding MSL object as JSON.", e);
        } catch (MslEncoderException e2) {
            throw new MslInternalException("Error encoding MSL object as JSON.", e2);
        } catch (JSONException e3) {
            throw new MslInternalException("Error encoding MSL object as JSON.", e3);
        }
    }

    @Override // o.C1401Dr
    public String toString() {
        return mo6562();
    }
}

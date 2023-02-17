package o;

import com.netflix.android.org.json.JSONException;
import com.netflix.msl.MslInternalException;
import com.netflix.msl.io.MslEncoderException;
import java.nio.charset.Charset;
/* renamed from: o.gO  reason: case insensitive filesystem */
public class C1809gO extends C1405Dv implements AbstractC0625 {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final Charset f6909 = Charset.forName("UTF-8");

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC1400Dq f6910;

    /* renamed from: ˋ  reason: contains not printable characters */
    public static byte[] m6585(AbstractC1400Dq dq, C1405Dv dv) {
        if (dv instanceof C1809gO) {
            return ((C1809gO) dv).mo6562().getBytes(f6909);
        }
        return new C1809gO(dq, dv).mo6562().getBytes(f6909);
    }

    public C1809gO(AbstractC1400Dq dq, C1405Dv dv) {
        this.f6910 = dq;
        try {
            for (String str : dv.m4758()) {
                mo4754(str, dv.m4751(str));
            }
        } catch (IllegalArgumentException e) {
            throw new MslEncoderException("Invalid MSL object encoding.", e);
        }
    }

    public C1809gO(AbstractC1400Dq dq, C0355 r6) {
        this.f6910 = dq;
        try {
            for (Object obj : r6.m13985()) {
                if (!(obj instanceof String)) {
                    throw new MslEncoderException("Invalid JSON object encoding.");
                }
                mo4754((String) obj, r6.m13970((String) obj));
            }
        } catch (JSONException e) {
            throw new MslEncoderException("Invalid JSON object encoding.", e);
        } catch (IllegalArgumentException e2) {
            throw new MslEncoderException("Invalid MSL object encoding.", e2);
        }
    }

    public C1809gO(AbstractC1400Dq dq, byte[] bArr) {
        this.f6910 = dq;
        try {
            C0355 r3 = new C0355(new String(bArr, f6909));
            for (Object obj : r3.m13985()) {
                if (!(obj instanceof String)) {
                    throw new MslEncoderException("Invalid JSON object encoding.");
                }
                mo4754((String) obj, r3.m13970((String) obj));
            }
        } catch (JSONException e) {
            throw new MslEncoderException("Invalid JSON object encoding.", e);
        } catch (IllegalArgumentException e2) {
            throw new MslEncoderException("Invalid MSL object encoding.", e2);
        }
    }

    @Override // o.C1405Dv
    /* renamed from: ˊ */
    public C1405Dv mo4754(String str, Object obj) {
        Object obj2;
        if (obj instanceof C0355) {
            try {
                obj2 = new C1809gO(this.f6910, (C0355) obj);
            } catch (MslEncoderException e) {
                throw new IllegalArgumentException("Unsupported JSON object or array representation.", e);
            }
        } else if (obj instanceof C0572) {
            obj2 = new C1802gH(this.f6910, (C0572) obj);
        } else {
            obj2 = obj;
        }
        return super.mo4754(str, obj2);
    }

    @Override // o.C1405Dv
    /* renamed from: ॱ */
    public byte[] mo4761(String str) {
        Object r3 = m4753(str);
        if (r3 instanceof byte[]) {
            return (byte[]) r3;
        }
        if (r3 instanceof String) {
            try {
                return C1418Ei.m4894((String) r3);
            } catch (IllegalArgumentException e) {
            }
        }
        throw new MslEncoderException("MslObject[" + C1811gQ.m6588(str) + "] is not binary data.");
    }

    @Override // o.C1405Dv
    /* renamed from: ॱ */
    public byte[] mo4762(String str, byte[] bArr) {
        Object r1 = m4751(str);
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
    /* renamed from: ˊ */
    public String mo6562() {
        try {
            C0355 r3 = new C0355();
            for (String str : m4758()) {
                Object r7 = m4751(str);
                if (r7 instanceof byte[]) {
                    r3.m13986(str, C1418Ei.m4892((byte[]) r7));
                } else if ((r7 instanceof C1809gO) || (r7 instanceof C1802gH)) {
                    r3.m13986(str, r7);
                } else if (r7 instanceof C1405Dv) {
                    r3.m13986(str, new C1809gO(this.f6910, (C1405Dv) r7));
                } else if (r7 instanceof C1401Dr) {
                    r3.m13986(str, new C1802gH(this.f6910, (C1401Dr) r7));
                } else if (r7 instanceof AbstractC1399Dp) {
                    r3.m13986(str, new C1809gO(this.f6910, ((AbstractC1399Dp) r7).mo3114(this.f6910, C1407Dx.f5471)));
                } else {
                    r3.m13986(str, r7);
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

    @Override // o.C1405Dv
    public String toString() {
        return mo6562();
    }
}

package o;

import com.netflix.msl.io.MslEncoderException;
import java.io.InputStream;
import java.util.Set;
/* renamed from: o.gK  reason: case insensitive filesystem */
public class C1805gK extends AbstractC1400Dq {
    @Override // o.AbstractC1400Dq
    /* renamed from: ˎ */
    public C1407Dx mo3177(Set<C1407Dx> set) {
        return C1407Dx.f5471;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1400Dq
    /* renamed from: ˊ */
    public AbstractC1406Dw mo3175(InputStream inputStream, C1407Dx dx) {
        if (C1407Dx.f5471.equals(dx)) {
            return new C1808gN(this, inputStream);
        }
        throw new MslEncoderException("Unsupported encoder format: " + dx + ".");
    }

    @Override // o.AbstractC1400Dq
    /* renamed from: ˋ */
    public C1405Dv mo3176(byte[] bArr) {
        C1407Dx r3 = m4729(bArr);
        if (C1407Dx.f5471.equals(r3)) {
            return new C1809gO(this, bArr);
        }
        throw new MslEncoderException("Unsupported encoder format: " + r3 + ".");
    }

    @Override // o.AbstractC1400Dq
    /* renamed from: ॱ */
    public byte[] mo3178(C1405Dv dv, C1407Dx dx) {
        if (C1407Dx.f5471.equals(dx)) {
            return C1809gO.m6585(this, dv);
        }
        throw new MslEncoderException("Unsupported encoder format: " + dx + ".");
    }
}

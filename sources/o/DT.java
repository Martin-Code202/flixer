package o;

import com.netflix.msl.MslInternalException;
import com.netflix.msl.util.MslContext;
public class DT implements DS {
    @Override // o.DS
    /* renamed from: ˊ */
    public CK mo4672(MslContext mslContext, DV dv) {
        return null;
    }

    @Override // o.DS
    /* renamed from: ˊ */
    public CK mo4673(MslContext mslContext, DV dv, long j) {
        return null;
    }

    @Override // o.DS
    /* renamed from: ˋ */
    public CK mo4675(MslContext mslContext, DV dv) {
        return null;
    }

    @Override // o.DS
    /* renamed from: ˋ */
    public CK mo4676(MslContext mslContext, DV dv, C1411Eb eb) {
        return null;
    }

    @Override // o.DS
    /* renamed from: ˏ */
    public C1411Eb mo4677(MslContext mslContext, DW dw, DV dv) {
        throw new MslInternalException("Creating user ID tokens is unsupported by the token factory.");
    }

    @Override // o.DS
    /* renamed from: ॱ */
    public C1411Eb mo4678(MslContext mslContext, C1411Eb eb, DV dv) {
        throw new MslInternalException("Renewing master tokens is unsupported by the token factory.");
    }

    @Override // o.DS
    /* renamed from: ˊ */
    public DW mo4674(MslContext mslContext, String str) {
        throw new MslInternalException("Creating users is unsupported by the token factory.");
    }
}

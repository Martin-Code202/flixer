package o;

import com.netflix.msl.MslInternalException;
import com.netflix.msl.util.MslContext;
import o.DB;
/* renamed from: o.gL  reason: case insensitive filesystem */
public class C1806gL extends DB {
    public C1806gL() {
        super(DA.f5246);
    }

    /* access modifiers changed from: protected */
    @Override // o.DB
    /* renamed from: ˎ */
    public AbstractC1408Dy mo4582(MslContext mslContext, C1405Dv dv) {
        return new DF(dv);
    }

    /* access modifiers changed from: protected */
    @Override // o.DB
    /* renamed from: ˏ */
    public DC mo4584(MslContext mslContext, DV dv, C1405Dv dv2) {
        return new DG(dv, dv2);
    }

    @Override // o.DB
    /* renamed from: ˋ */
    public DB.C0083 mo4580(MslContext mslContext, C1407Dx dx, AbstractC1408Dy dy, DV dv) {
        throw new MslInternalException("Client will not generate a keyx  response");
    }

    @Override // o.DB
    /* renamed from: ˋ */
    public DB.C0083 mo4581(MslContext mslContext, C1407Dx dx, AbstractC1408Dy dy, AbstractC1385Db db) {
        throw new MslInternalException("Client will not generate a keyx  response");
    }

    @Override // o.DB
    /* renamed from: ˏ */
    public AbstractC1386Dc mo4585(MslContext mslContext, AbstractC1408Dy dy, DC dc, DV dv) {
        return new C1803gI(mslContext, mslContext.mo3168((MslContext.ReauthCode) null).mo4706(), (DF) dy, (DG) dc, dv);
    }
}

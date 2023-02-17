package o;

import com.netflix.msl.MslEntityAuthException;
import com.netflix.msl.MslInternalException;
import com.netflix.msl.util.MslContext;
/* renamed from: o.Dm  reason: case insensitive filesystem */
public class C1396Dm extends AbstractC1390Dg {

    /* renamed from: ॱ  reason: contains not printable characters */
    final AbstractC1414Ee f5442;

    public C1396Dm(AbstractC1414Ee ee) {
        super(C1391Dh.f5420);
        this.f5442 = ee;
    }

    @Override // o.AbstractC1390Dg
    /* renamed from: ˋ */
    public AbstractC1385Db mo4709(MslContext mslContext, C1405Dv dv) {
        return new C1393Dj(dv);
    }

    @Override // o.AbstractC1390Dg
    /* renamed from: ॱ */
    public AbstractC1386Dc mo4710(MslContext mslContext, AbstractC1385Db db) {
        if (!(db instanceof C1393Dj)) {
            throw new MslInternalException("Incorrect authentication data type " + db.getClass().getName() + ".");
        }
        C1393Dj dj = (C1393Dj) db;
        String r5 = dj.mo4706();
        if (this.f5442.mo4875(r5)) {
            throw new MslEntityAuthException(CK.f4926, "none " + r5).mo3077(dj);
        } else if (this.f5442.mo4876(r5, m4714())) {
            return new C1387Dd();
        } else {
            throw new MslEntityAuthException(CK.f4915, "Authentication Scheme for Device Type Not Supported " + r5 + ":" + m4714()).mo3077(dj);
        }
    }
}

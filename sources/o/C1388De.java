package o;

import com.netflix.msl.MslEntityAuthException;
import com.netflix.msl.MslInternalException;
import com.netflix.msl.util.MslContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* renamed from: o.De  reason: case insensitive filesystem */
public class C1388De extends AbstractC1390Dg {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final Logger f5409 = LoggerFactory.getLogger(C1388De.class);

    /* renamed from: ˎ  reason: contains not printable characters */
    final DV f5410;

    /* renamed from: ॱ  reason: contains not printable characters */
    final AbstractC1414Ee f5411;

    public C1388De(AbstractC1414Ee ee, DV dv) {
        super(C1392Di.f5433);
        this.f5410 = dv;
        this.f5411 = ee;
    }

    @Override // o.AbstractC1390Dg
    /* renamed from: ˋ  reason: contains not printable characters */
    public AbstractC1385Db mo4709(MslContext mslContext, C1405Dv dv) {
        return new C1389Df(mslContext, dv);
    }

    @Override // o.AbstractC1390Dg
    /* renamed from: ॱ  reason: contains not printable characters */
    public AbstractC1386Dc mo4710(MslContext mslContext, AbstractC1385Db db) {
        if (!(db instanceof C1389Df)) {
            String format = String.format("expected %s, received %s", C1389Df.class.getName(), db.getClass().getName());
            f5409.error("Incorrect authentication data type: {}", format);
            throw new MslInternalException("Incorrect authentication data type: " + format + ".");
        }
        C1389Df df = (C1389Df) db;
        if (df.m4712() != this.f5410) {
            f5409.info("MasterToken mismatch between entity auth data and MSL context.");
            throw new MslEntityAuthException(CK.f4936);
        }
        AbstractC1385Db r5 = df.m4713();
        C1391Dh r6 = r5.m4707();
        AbstractC1390Dg r7 = mslContext.mo3169(r6);
        if (r7 != null) {
            return r7.mo4710(mslContext, r5);
        }
        f5409.info("Could not find entity auth factory for scheme {}", r6);
        throw new MslEntityAuthException(CK.f4907, r6.m4716()).mo3077(df);
    }
}

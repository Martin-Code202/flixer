package o;

import com.netflix.msl.MslCryptoException;
import com.netflix.msl.MslEncodingException;
import com.netflix.msl.MslEntityAuthException;
import com.netflix.msl.MslException;
import com.netflix.msl.MslMasterTokenException;
import com.netflix.msl.io.MslEncoderException;
import com.netflix.msl.util.MslContext;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* renamed from: o.Df  reason: case insensitive filesystem */
public class C1389Df extends AbstractC1385Db {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final Logger f5412 = LoggerFactory.getLogger(C1389Df.class);

    /* renamed from: ˊ  reason: contains not printable characters */
    private final MslContext f5413;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC1385Db f5414;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final DV f5415;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Map<C1407Dx, C1405Dv> f5416 = new HashMap();

    /* renamed from: ˊ  reason: contains not printable characters */
    private static AbstractC1386Dc m4711(MslContext mslContext, DV dv) {
        AbstractC1386Dc r1 = mslContext.mo3159().mo4888(dv);
        if (r1 != null) {
            return r1;
        }
        return new CZ(mslContext, dv);
    }

    public C1389Df(MslContext mslContext, DV dv, AbstractC1385Db db) {
        super(C1392Di.f5433);
        this.f5413 = mslContext;
        this.f5415 = dv;
        this.f5414 = db;
        try {
            f5412.debug("Target ESN = {}", db.mo4706());
        } catch (MslCryptoException e) {
            f5412.info("Target ESN = Unknown", (Throwable) e);
        }
    }

    public C1389Df(MslContext mslContext, C1405Dv dv) {
        super(C1392Di.f5433);
        this.f5413 = mslContext;
        AbstractC1400Dq r4 = mslContext.mo3174();
        try {
            byte[] r5 = dv.mo4761("authdata");
            byte[] r6 = dv.mo4761("signature");
            try {
                this.f5415 = new DV(mslContext, dv.m4756("mastertoken", r4));
                f5412.debug("Found source MasterToken with ESN {}", this.f5415.m4691());
                try {
                    AbstractC1386Dc r7 = m4711(mslContext, this.f5415);
                    f5412.debug("Got crypto context for MasterToken with ESN {}", this.f5415.m4691());
                    try {
                        if (!r7.mo4324(r5, r6, r4)) {
                            f5412.error("Entity migration received ciphertext that failed verification with current session keys, there is some sort of mismatch");
                            throw new MslEntityAuthException(CK.f4940, "migration authdata " + dv.toString());
                        }
                        C1405Dv r9 = r4.mo3176(r7.mo4322(r5, r4));
                        f5412.debug("Target auth data: {}", r9);
                        this.f5414 = AbstractC1385Db.m4705(mslContext, r9);
                        f5412.debug("Source ESN = {}, Target ESN = {}", this.f5415.m4691(), this.f5414.mo4706());
                    } catch (MslEncoderException e) {
                        f5412.info("Error parsing decrypted data", (Throwable) e);
                        throw new MslEncodingException(CK.f4804, "migration authdata " + dv.toString(), e);
                    }
                } catch (MslMasterTokenException e2) {
                    f5412.info("Unable to get crypto context for this MasterToken", (Throwable) e2);
                    throw new MslEntityAuthException(CK.f4935, e2);
                }
            } catch (MslException e3) {
                f5412.info("Could not create MasterToken", (Throwable) e3);
                throw new MslEntityAuthException(CK.f4936, "migration authdata " + dv.toString(), e3);
            }
        } catch (MslEncoderException e4) {
            f5412.info("Trouble extracting auth data fields", (Throwable) e4);
            throw new MslEncodingException(CK.f4804, "migration protected authdata " + dv.toString(), e4);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public DV m4712() {
        return this.f5415;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public AbstractC1385Db m4713() {
        return this.f5414;
    }

    @Override // o.AbstractC1385Db
    /* renamed from: ˊ */
    public String mo4706() {
        return this.f5414.mo4706();
    }

    @Override // o.AbstractC1385Db
    /* renamed from: ॱ */
    public C1405Dv mo4708(AbstractC1400Dq dq, C1407Dx dx) {
        if (this.f5416.containsKey(dx)) {
            return this.f5416.get(dx);
        }
        try {
            AbstractC1386Dc r2 = m4711(this.f5413, this.f5415);
            try {
                byte[] r4 = r2.mo4323(this.f5414.mo3114(dq, dx), dq, dx);
                Object r5 = r2.mo4325(r4, dq, dx);
                C1405Dv r6 = dq.m4727();
                r6.mo4754("mastertoken", this.f5415);
                r6.mo4754("authdata", r4);
                r6.mo4754("signature", r5);
                C1405Dv r8 = dq.mo3176(dq.mo3178(r6, dx));
                this.f5416.put(dx, r8);
                return r8;
            } catch (MslCryptoException e) {
                throw new MslEncoderException("Error encrypting and signing the authentication data.", e);
            }
        } catch (MslMasterTokenException e2) {
            throw new MslEncoderException("Master token crypto context cannot be retrieved or created.", e2);
        }
    }

    @Override // o.AbstractC1385Db
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1389Df)) {
            return false;
        }
        C1389Df df = (C1389Df) obj;
        return super.equals(obj) && this.f5415.equals(df.f5415) && this.f5414.equals(df.f5414);
    }

    @Override // o.AbstractC1385Db
    public int hashCode() {
        return (super.hashCode() ^ this.f5415.hashCode()) ^ this.f5414.hashCode();
    }
}

package o;

import com.netflix.msl.MslConstants;
import com.netflix.msl.MslCryptoException;
import com.netflix.msl.MslEncodingException;
import com.netflix.msl.MslEntityAuthException;
import com.netflix.msl.MslMessageException;
import com.netflix.msl.io.MslEncoderException;
import com.netflix.msl.util.MslContext;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
public class DD extends DI {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final int f5255;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final String f5256;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final String f5257;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final MslContext f5258;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final C1405Dv f5259;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Long f5260;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f5261;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC1385Db f5262;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final Map<C1407Dx, byte[]> f5263 = new HashMap();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final long f5264;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final MslConstants.ResponseCode f5265;

    protected DD(MslContext mslContext, byte[] bArr, AbstractC1385Db db, byte[] bArr2) {
        MslConstants.ResponseCode responseCode;
        this.f5258 = mslContext;
        AbstractC1400Dq r4 = mslContext.mo3174();
        try {
            this.f5262 = db;
            if (db == null) {
                throw new MslMessageException(CK.f4771);
            }
            C1391Dh r6 = db.m4707();
            AbstractC1390Dg r7 = mslContext.mo3169(r6);
            if (r7 == null) {
                throw new MslEntityAuthException(CK.f4907, r6.m4716());
            }
            AbstractC1386Dc r8 = r7.mo4710(mslContext, db);
            if (!r8.mo4324(bArr, bArr2, r4)) {
                throw new MslCryptoException(CK.f4775).mo3077(db);
            }
            byte[] r5 = r8.mo4322(bArr, r4);
            try {
                this.f5259 = r4.mo3176(r5);
                this.f5264 = this.f5259.m4763("messageid");
                if (this.f5264 < 0 || this.f5264 > 9007199254740992L) {
                    throw new MslMessageException(CK.f4793, "errordata " + this.f5259).mo3077(db);
                }
                try {
                    this.f5261 = this.f5259.m4750("recipient") ? this.f5259.m4752("recipient") : null;
                    this.f5260 = this.f5259.m4750("timestamp") ? Long.valueOf(this.f5259.m4763("timestamp")) : null;
                    MslConstants.ResponseCode responseCode2 = MslConstants.ResponseCode.FAIL;
                    try {
                        responseCode = MslConstants.ResponseCode.m3073(this.f5259.m4755("errorcode"));
                    } catch (IllegalArgumentException e) {
                        responseCode = MslConstants.ResponseCode.FAIL;
                    }
                    this.f5265 = responseCode;
                    if (this.f5259.m4750("internalcode")) {
                        this.f5255 = this.f5259.m4755("internalcode");
                        if (this.f5255 < 0) {
                            throw new MslMessageException(CK.f4787, "errordata " + this.f5259).mo3077(db).mo3085(this.f5264);
                        }
                    } else {
                        this.f5255 = -1;
                    }
                    this.f5257 = this.f5259.m4760("errormsg", (String) null);
                    this.f5256 = this.f5259.m4760("usermsg", (String) null);
                } catch (MslEncoderException e2) {
                    throw new MslEncodingException(CK.f4804, "errordata " + this.f5259, e2).mo3077(db).mo3085(this.f5264);
                }
            } catch (MslEncoderException e3) {
                throw new MslEncodingException(CK.f4804, "errordata " + C1418Ei.m4892(r5), e3).mo3077(db);
            }
        } catch (MslCryptoException e4) {
            e4.mo3077(db);
            throw e4;
        } catch (MslEntityAuthException e5) {
            e5.mo3077(db);
            throw e5;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public AbstractC1385Db m4590() {
        return this.f5262;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public Date m4594() {
        if (this.f5260 != null) {
            return new Date(this.f5260.longValue() * 1000);
        }
        return null;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public long m4591() {
        return this.f5264;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public MslConstants.ResponseCode m4593() {
        return this.f5265;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public int m4592() {
        return this.f5255;
    }

    @Override // o.AbstractC1399Dp
    /* renamed from: ˏ */
    public byte[] mo3114(AbstractC1400Dq dq, C1407Dx dx) {
        if (this.f5263.containsKey(dx)) {
            return this.f5263.get(dx);
        }
        AbstractC1390Dg r3 = this.f5258.mo3169(this.f5262.m4707());
        if (r3 == null) {
            throw new MslEncoderException("No entity authentication factory found for entity.");
        }
        try {
            AbstractC1386Dc r4 = r3.mo4710(this.f5258, this.f5262);
            try {
                byte[] r6 = r4.mo4323(dq.mo3178(this.f5259, dx), dq, dx);
                try {
                    Object r7 = r4.mo4325(r6, dq, dx);
                    C1405Dv r8 = dq.m4727();
                    r8.mo4754("entityauthdata", this.f5262);
                    r8.mo4754("errordata", r6);
                    r8.mo4754("signature", r7);
                    byte[] r9 = dq.mo3178(r8, dx);
                    this.f5263.put(dx, r9);
                    return r9;
                } catch (MslCryptoException e) {
                    throw new MslEncoderException("Error signing the error data.", e);
                }
            } catch (MslCryptoException e2) {
                throw new MslEncoderException("Error encrypting the error data.", e2);
            }
        } catch (MslEntityAuthException e3) {
            throw new MslEncoderException("Error creating the entity crypto context.", e3);
        } catch (MslCryptoException e4) {
            throw new MslEncoderException("Error creating the entity crypto context.", e4);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DD)) {
            return false;
        }
        DD dd = (DD) obj;
        return this.f5262.equals(dd.f5262) && (this.f5261 == dd.f5261 || (this.f5261 != null && this.f5261.equals(dd.f5261))) && (((this.f5260 != null && this.f5260.equals(dd.f5260)) || (this.f5260 == null && dd.f5260 == null)) && this.f5264 == dd.f5264 && this.f5265 == dd.f5265 && this.f5255 == dd.f5255 && ((this.f5257 == dd.f5257 || (this.f5257 != null && this.f5257.equals(dd.f5257))) && (this.f5256 == dd.f5256 || (this.f5256 != null && this.f5256.equals(dd.f5256)))));
    }

    public int hashCode() {
        int i;
        int hashCode = (((((this.f5262.hashCode() ^ (this.f5261 != null ? this.f5261.hashCode() : 0)) ^ (this.f5260 != null ? this.f5260.hashCode() : 0)) ^ Long.valueOf(this.f5264).hashCode()) ^ this.f5265.hashCode()) ^ Integer.valueOf(this.f5255).hashCode()) ^ (this.f5257 != null ? this.f5257.hashCode() : 0);
        if (this.f5256 != null) {
            i = this.f5256.hashCode();
        } else {
            i = 0;
        }
        return hashCode ^ i;
    }
}

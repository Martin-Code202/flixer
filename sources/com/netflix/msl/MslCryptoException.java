package com.netflix.msl;

import o.AbstractC1385Db;
import o.CK;
import o.DV;
public class MslCryptoException extends MslException {
    private static final long serialVersionUID = -7618578454440397528L;

    public MslCryptoException(CK ck) {
        super(ck);
    }

    public MslCryptoException(CK ck, String str) {
        super(ck, str);
    }

    public MslCryptoException(CK ck, String str, Throwable th) {
        super(ck, str, th);
    }

    public MslCryptoException(CK ck, Throwable th) {
        super(ck, th);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public MslCryptoException mo3076(DV dv) {
        super.mo3076(dv);
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public MslCryptoException mo3077(AbstractC1385Db db) {
        super.mo3077(db);
        return this;
    }
}

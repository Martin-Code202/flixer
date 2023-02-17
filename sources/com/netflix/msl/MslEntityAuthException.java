package com.netflix.msl;

import o.AbstractC1385Db;
import o.CK;
import o.DV;
public class MslEntityAuthException extends MslException {
    private static final long serialVersionUID = 5335550727677217303L;

    public MslEntityAuthException(CK ck) {
        super(ck);
    }

    public MslEntityAuthException(CK ck, String str) {
        super(ck, str);
    }

    public MslEntityAuthException(CK ck, String str, Throwable th) {
        super(ck, str, th);
    }

    public MslEntityAuthException(CK ck, Throwable th) {
        super(ck, th);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public MslEntityAuthException mo3076(DV dv) {
        super.mo3076(dv);
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public MslEntityAuthException mo3077(AbstractC1385Db db) {
        super.mo3077(db);
        return this;
    }
}

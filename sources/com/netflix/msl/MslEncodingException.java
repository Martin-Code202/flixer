package com.netflix.msl;

import o.AbstractC1385Db;
import o.AbstractC1412Ec;
import o.C1411Eb;
import o.CK;
import o.DV;
public class MslEncodingException extends MslException {
    private static final long serialVersionUID = -2295976834635986944L;

    public MslEncodingException(CK ck) {
        super(ck);
    }

    public MslEncodingException(CK ck, String str) {
        super(ck, str);
    }

    public MslEncodingException(CK ck, String str, Throwable th) {
        super(ck, str, th);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public MslEncodingException mo3076(DV dv) {
        super.mo3076(dv);
        return this;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public MslEncodingException mo3077(AbstractC1385Db db) {
        super.mo3077(db);
        return this;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public MslEncodingException mo3086(C1411Eb eb) {
        super.mo3086(eb);
        return this;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public MslEncodingException mo3087(AbstractC1412Ec ec) {
        super.mo3087(ec);
        return this;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public MslEncodingException mo3085(long j) {
        super.mo3085(j);
        return this;
    }
}

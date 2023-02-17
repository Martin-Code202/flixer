package com.netflix.msl;

import o.AbstractC1385Db;
import o.C1411Eb;
import o.CK;
import o.DV;
public class MslMessageException extends MslException {
    private static final long serialVersionUID = 8022562525891870639L;

    public MslMessageException(CK ck) {
        super(ck);
    }

    public MslMessageException(CK ck, String str) {
        super(ck, str);
    }

    public MslMessageException(CK ck, String str, Throwable th) {
        super(ck, str, th);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public MslMessageException mo3076(DV dv) {
        super.mo3076(dv);
        return this;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public MslMessageException mo3077(AbstractC1385Db db) {
        super.mo3077(db);
        return this;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public MslMessageException mo3086(C1411Eb eb) {
        super.mo3086(eb);
        return this;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public MslMessageException mo3085(long j) {
        super.mo3085(j);
        return this;
    }
}

package com.netflix.msl;

import o.AbstractC1385Db;
import o.AbstractC1412Ec;
import o.C1411Eb;
import o.CK;
import o.DV;
public class MslException extends Exception {
    private static final long serialVersionUID = -2444322310603180494L;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final CK f4127;

    /* renamed from: ˋ  reason: contains not printable characters */
    private DV f4128 = null;

    /* renamed from: ˎ  reason: contains not printable characters */
    private AbstractC1385Db f4129 = null;

    /* renamed from: ˏ  reason: contains not printable characters */
    private AbstractC1412Ec f4130 = null;

    /* renamed from: ॱ  reason: contains not printable characters */
    private C1411Eb f4131 = null;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private Long f4132 = null;

    public MslException(CK ck) {
        super(ck.m4209());
        this.f4127 = ck;
    }

    public MslException(CK ck, String str) {
        super(ck.m4209() + " [" + str + "]");
        this.f4127 = ck;
    }

    public MslException(CK ck, String str, Throwable th) {
        super(ck.m4209() + " [" + str + "]", th);
        this.f4127 = ck;
    }

    public MslException(CK ck, Throwable th) {
        super(ck.m4209(), th);
        this.f4127 = ck;
    }

    /* renamed from: ˊ */
    public MslException mo3076(DV dv) {
        if (m3090() == null && m3092() == null) {
            this.f4128 = dv;
        }
        return this;
    }

    /* renamed from: ˋ */
    public MslException mo3077(AbstractC1385Db db) {
        if (m3090() == null && m3092() == null) {
            this.f4129 = db;
        }
        return this;
    }

    /* renamed from: ॱ */
    public MslException mo3086(C1411Eb eb) {
        if (m3093() == null && m3094() == null) {
            this.f4131 = eb;
        }
        return this;
    }

    /* renamed from: ॱ */
    public MslException mo3087(AbstractC1412Ec ec) {
        if (m3093() == null && m3094() == null) {
            this.f4130 = ec;
        }
        return this;
    }

    /* renamed from: ॱ */
    public MslException mo3085(long j) {
        if (j < 0 || j > 9007199254740992L) {
            throw new IllegalArgumentException("Message ID " + j + " is outside the valid range.");
        }
        if (m3091() == null) {
            this.f4132 = Long.valueOf(j);
        }
        return this;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public DV m3090() {
        if (this.f4128 != null) {
            return this.f4128;
        }
        Throwable cause = getCause();
        if (cause == null || !(cause instanceof MslException)) {
            return null;
        }
        return ((MslException) cause).m3090();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public AbstractC1385Db m3092() {
        if (this.f4129 != null) {
            return this.f4129;
        }
        Throwable cause = getCause();
        if (cause == null || !(cause instanceof MslException)) {
            return null;
        }
        return ((MslException) cause).m3092();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C1411Eb m3093() {
        if (this.f4131 != null) {
            return this.f4131;
        }
        Throwable cause = getCause();
        if (cause == null || !(cause instanceof MslException)) {
            return null;
        }
        return ((MslException) cause).m3093();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public AbstractC1412Ec m3094() {
        if (this.f4130 != null) {
            return this.f4130;
        }
        Throwable cause = getCause();
        if (cause == null || !(cause instanceof MslException)) {
            return null;
        }
        return ((MslException) cause).m3094();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public Long m3091() {
        if (this.f4132 != null) {
            return this.f4132;
        }
        Throwable cause = getCause();
        if (cause == null || !(cause instanceof MslException)) {
            return null;
        }
        return ((MslException) cause).m3091();
    }
}

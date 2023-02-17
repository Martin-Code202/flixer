package com.netflix.msl.util;

import com.netflix.msl.MslConstants;
import java.util.Date;
import java.util.Random;
import java.util.SortedSet;
import o.AbstractC1385Db;
import o.AbstractC1386Dc;
import o.AbstractC1390Dg;
import o.AbstractC1400Dq;
import o.AbstractC1415Ef;
import o.AbstractC1417Eh;
import o.C1391Dh;
import o.C1409Dz;
import o.C1416Eg;
import o.DB;
import o.DJ;
import o.DS;
public abstract class MslContext {

    /* renamed from: ˋ  reason: contains not printable characters */
    private volatile long f4195 = 0;

    /* renamed from: ॱ  reason: contains not printable characters */
    private volatile boolean f4196 = false;

    /* renamed from: ʻ */
    public abstract AbstractC1417Eh mo3159();

    /* renamed from: ʼ */
    public abstract AbstractC1386Dc mo3160();

    /* renamed from: ʽ */
    public abstract DS mo3161();

    /* renamed from: ˊ */
    public abstract DB mo3162(C1409Dz dz);

    /* renamed from: ˊ */
    public abstract C1391Dh mo3163(String str);

    /* renamed from: ˋ */
    public abstract SortedSet<DB> mo3164();

    /* renamed from: ˋ */
    public abstract C1409Dz mo3165(String str);

    /* renamed from: ˎ */
    public abstract boolean mo3166();

    /* renamed from: ˏ */
    public abstract long mo3167();

    /* renamed from: ˏ */
    public abstract AbstractC1385Db mo3168(ReauthCode reauthCode);

    /* renamed from: ˏ */
    public abstract AbstractC1390Dg mo3169(C1391Dh dh);

    /* renamed from: ॱ */
    public abstract DJ mo3170();

    /* renamed from: ॱ */
    public abstract AbstractC1415Ef mo3171(C1416Eg eg);

    /* renamed from: ॱ */
    public abstract C1416Eg mo3172(String str);

    /* renamed from: ॱॱ */
    public abstract Random mo3173();

    /* renamed from: ᐝ */
    public abstract AbstractC1400Dq mo3174();

    public enum ReauthCode {
        ENTITY_REAUTH(MslConstants.ResponseCode.ENTITY_REAUTH),
        ENTITYDATA_REAUTH(MslConstants.ResponseCode.ENTITYDATA_REAUTH);
        

        /* renamed from: ˎ  reason: contains not printable characters */
        private final MslConstants.ResponseCode f4200;

        /* renamed from: ॱ  reason: contains not printable characters */
        public static ReauthCode m3183(MslConstants.ResponseCode responseCode) {
            ReauthCode[] values = values();
            for (ReauthCode reauthCode : values) {
                if (reauthCode.f4200 == responseCode) {
                    return reauthCode;
                }
            }
            throw new IllegalArgumentException("Unknown reauthentication code value " + responseCode + ".");
        }

        private ReauthCode(MslConstants.ResponseCode responseCode) {
            this.f4200 = responseCode;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m3182(Date date) {
        this.f4195 = (date.getTime() / 1000) - (mo3167() / 1000);
        this.f4196 = true;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public final Date m3181() {
        if (!this.f4196) {
            return null;
        }
        return new Date(1000 * ((mo3167() / 1000) + this.f4195));
    }
}

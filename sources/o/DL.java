package o;

import com.netflix.msl.MslCryptoException;
import com.netflix.msl.MslEncodingException;
import com.netflix.msl.MslEntityAuthException;
import com.netflix.msl.MslException;
import com.netflix.msl.MslInternalException;
import com.netflix.msl.MslKeyExchangeException;
import com.netflix.msl.MslMasterTokenException;
import com.netflix.msl.MslMessageException;
import com.netflix.msl.MslUserAuthException;
import com.netflix.msl.util.MslContext;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import o.DB;
import o.DM;
public class DL {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final byte[] f5273 = new byte[0];

    /* renamed from: ʻ  reason: contains not printable characters */
    private final DB.C0083 f5274;

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean f5275 = false;

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean f5276 = false;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private AbstractC1412Ec f5277 = null;

    /* renamed from: ˋ  reason: contains not printable characters */
    private DV f5278;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private C1411Eb f5279 = null;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final long f5280;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f5281;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private DV f5282 = null;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final Set<AbstractC1408Dy> f5283 = new HashSet();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final MslContext f5284;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final Map<String, DU> f5285 = new HashMap();

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private C1411Eb f5286 = null;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final DJ f5287;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f5288 = false;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final Map<String, DU> f5289 = new HashMap();

    /* renamed from: ˏ  reason: contains not printable characters */
    public static long m4611(long j) {
        if (j < 0 || j > 9007199254740992L) {
            throw new MslInternalException("Message ID " + j + " is outside the valid range.");
        } else if (j == 9007199254740992L) {
            return 0;
        } else {
            return 1 + j;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static DB.C0083 m4612(MslContext mslContext, C1407Dx dx, Set<AbstractC1408Dy> set, DV dv, AbstractC1385Db db) {
        MslCryptoException mslCryptoException = null;
        Iterator<DB> it = mslContext.mo3164().iterator();
        while (it.hasNext()) {
            DB next = it.next();
            Iterator<AbstractC1408Dy> it2 = set.iterator();
            while (true) {
                if (it2.hasNext()) {
                    AbstractC1408Dy next2 = it2.next();
                    if (next.m4583().equals(next2.m4772())) {
                        if (dv == null) {
                            return next.mo4581(mslContext, dx, next2, db);
                        }
                        try {
                            return next.mo4580(mslContext, dx, next2, dv);
                        } catch (MslCryptoException e) {
                            if (!it.hasNext()) {
                                throw e;
                            }
                            mslCryptoException = e;
                        } catch (MslKeyExchangeException e2) {
                            if (!it.hasNext()) {
                                throw e2;
                            }
                            mslCryptoException = e2;
                        } catch (MslEncodingException e3) {
                            if (!it.hasNext()) {
                                throw e3;
                            }
                            mslCryptoException = e3;
                        } catch (MslMasterTokenException e4) {
                            if (!it.hasNext()) {
                                throw e4;
                            }
                            mslCryptoException = e4;
                        } catch (MslEntityAuthException e5) {
                            if (!it.hasNext()) {
                                throw e5;
                            }
                            mslCryptoException = e5;
                        }
                    }
                }
            }
        }
        if (mslCryptoException == null) {
            throw new MslKeyExchangeException(CK.f4834, Arrays.toString(set.toArray()));
        } else if (mslCryptoException instanceof MslCryptoException) {
            throw mslCryptoException;
        } else if (mslCryptoException instanceof MslKeyExchangeException) {
            throw ((MslKeyExchangeException) mslCryptoException);
        } else if (mslCryptoException instanceof MslEncodingException) {
            throw ((MslEncodingException) mslCryptoException);
        } else if (mslCryptoException instanceof MslMasterTokenException) {
            throw ((MslMasterTokenException) mslCryptoException);
        } else if (mslCryptoException instanceof MslEntityAuthException) {
            throw ((MslEntityAuthException) mslCryptoException);
        } else {
            throw new MslInternalException("Unexpected exception caught during key exchange.", mslCryptoException);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static DL m4610(MslContext mslContext, DV dv, C1411Eb eb, String str, long j) {
        if (j >= 0 && j <= 9007199254740992L) {
            return new DL(mslContext, str, j, mslContext.mo3170(), dv, eb, null, null, null, null, null);
        }
        throw new MslInternalException("Message ID " + j + " is outside the valid range.");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static DL m4609(MslContext mslContext, DV dv, C1411Eb eb, String str) {
        Random r15 = mslContext.mo3173();
        while (true) {
            long nextLong = r15.nextLong();
            if (nextLong >= 0 && nextLong <= 9007199254740992L) {
                return new DL(mslContext, str, nextLong, mslContext.mo3170(), dv, eb, null, null, null, null, null);
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static DL m4608(MslContext mslContext, DM dm) {
        DB.C0083 r26;
        DV dv;
        DV r13 = dm.m4636();
        AbstractC1385Db r14 = dm.m4644();
        C1411Eb r15 = dm.m4646();
        AbstractC1412Ec r16 = dm.m4642();
        String r17 = r13 != null ? r13.m4691() : r14.mo4706();
        long r18 = dm.m4648();
        long r20 = m4611(r18);
        DJ r22 = DJ.m4603(dm.m4637(), mslContext.mo3170());
        C1407Dx r25 = mslContext.mo3174().mo3177(r22 != null ? r22.m4604() : null);
        try {
            Set<AbstractC1408Dy> r27 = dm.m4639();
            if (!dm.m4632() || r27.isEmpty()) {
                r26 = null;
            } else if (r13 == null) {
                r26 = m4612(mslContext, r25, r27, null, r14);
            } else if (r13.m4697(null) || r13.m4692(null)) {
                r26 = m4612(mslContext, r25, r27, r13, null);
            } else {
                r26 = null;
            }
            if (r26 != null) {
                dv = r26.f5251.m4587();
            } else {
                dv = r13;
            }
            if (r15 == null || !r15.m4872()) {
                if (!(!dm.m4632() || dv == null || r16 == null)) {
                    DW r29 = dm.m4638();
                    if (r29 == null) {
                        C1416Eg r30 = r16.m4874();
                        AbstractC1415Ef r31 = mslContext.mo3171(r30);
                        if (r31 == null) {
                            throw new MslUserAuthException(CK.f4948, r30.m4880()).mo3076(r13).mo3087(r16).mo3085(r18);
                        }
                        r29 = r31.m4877(mslContext, dv.m4691(), r16, null);
                    }
                    r15 = mslContext.mo3161().mo4677(mslContext, r29, dv);
                }
            } else if ((r15.m4870((Date) null) && dm.m4632()) || r15.m4867(null) || !r15.m4871(dv)) {
                r15 = mslContext.mo3161().mo4678(mslContext, r15, dv);
            }
            DC r292 = dm.m4643();
            Set<DU> r302 = dm.m4633();
            if (mslContext.mo3166()) {
                return new DL(mslContext, r17, r20, r22, r292 != null ? r292.m4587() : dm.m4647(), dm.m4649(), dm.m4651(), r13, r15, r302, r26);
            }
            return new DL(mslContext, r17, r20, r22, r292 != null ? r292.m4587() : r13, r15, r302, null, null, null, r26);
        } catch (MslException e) {
            e.mo3076(r13);
            e.mo3077(r14);
            e.mo3086(r15);
            e.mo3087(r16);
            e.mo3085(r18);
            throw e;
        }
    }

    private DL(MslContext mslContext, String str, long j, DJ dj, DV dv, C1411Eb eb, Set<DU> set, DV dv2, C1411Eb eb2, Set<DU> set2, DB.C0083 r20) {
        DV dv3;
        DV dv4;
        if (mslContext.mo3166() || (dv2 == null && eb2 == null)) {
            this.f5284 = mslContext;
            this.f5281 = str;
            this.f5280 = j;
            this.f5287 = dj;
            this.f5278 = dv;
            this.f5279 = eb;
            this.f5274 = r20;
            if (r20 == null || mslContext.mo3166()) {
                dv3 = dv;
            } else {
                dv3 = r20.f5251.m4587();
            }
            for (DU du : mslContext.mo3159().mo4883(dv3, eb)) {
                this.f5285.put(du.m4685(), du);
            }
            if (set != null) {
                for (DU du2 : set) {
                    this.f5285.put(du2.m4685(), du2);
                }
            }
            if (mslContext.mo3166()) {
                this.f5282 = dv2;
                this.f5286 = eb2;
                if (r20 != null) {
                    dv4 = r20.f5251.m4587();
                } else {
                    dv4 = this.f5282;
                }
                for (DU du3 : mslContext.mo3159().mo4883(dv4, eb2)) {
                    this.f5289.put(du3.m4685(), du3);
                }
                if (set2 != null) {
                    for (DU du4 : set2) {
                        this.f5289.put(du4.m4685(), du4);
                    }
                    return;
                }
                return;
            }
            return;
        }
        throw new MslInternalException("Cannot set peer master token or peer user ID token when not in peer-to-peer mode.");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public DV m4617() {
        return this.f5278;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C1411Eb m4623() {
        return this.f5279;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public DB.C0083 m4619() {
        return this.f5274;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m4629() {
        return this.f5278 != null || this.f5284.mo3168(null).m4707().m4717();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m4625() {
        return this.f5278 != null || (!this.f5284.mo3166() && this.f5274 != null) || this.f5284.mo3168(null).m4707().m4717();
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public boolean m4630() {
        return this.f5278 != null || this.f5284.mo3168(null).m4707().m4718();
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public boolean m4614() {
        return this.f5278 != null || (!this.f5284.mo3166() && this.f5274 != null) || this.f5284.mo3168(null).m4707().m4718();
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public DM m4631() {
        Long l;
        DC dc = this.f5274 != null ? this.f5274.f5251 : null;
        HashSet hashSet = new HashSet(this.f5285.values());
        if (!this.f5276) {
            l = null;
        } else if (this.f5278 == null) {
            throw new MslMessageException(CK.f4811);
        } else {
            l = Long.valueOf(this.f5284.mo3159().mo4882(this.f5278));
        }
        return new DM(this.f5284, this.f5284.mo3168((MslContext.ReauthCode) null), this.f5278, new DM.Cif(this.f5281, this.f5280, l, this.f5288, this.f5275, this.f5287, this.f5283, dc, this.f5277, this.f5279, hashSet), new DM.If(this.f5282, this.f5286, new HashSet(this.f5289.values())));
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public boolean m4615() {
        return this.f5276;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public DL m4622(boolean z) {
        this.f5276 = z;
        if (this.f5276) {
            this.f5275 = false;
        }
        return this;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean m4613() {
        return this.f5288;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public DL m4616(boolean z) {
        this.f5288 = z;
        if (!this.f5288) {
            this.f5275 = false;
        }
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public DL m4627(boolean z) {
        this.f5275 = z;
        if (this.f5275) {
            this.f5276 = false;
            this.f5288 = true;
        }
        return this;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m4618(DV dv, C1411Eb eb) {
        if (eb != null && !eb.m4871(dv)) {
            throw new MslInternalException("User ID token must be bound to master token.");
        } else if (this.f5274 == null || this.f5284.mo3166()) {
            try {
                Set<DU> r2 = this.f5284.mo3159().mo4883(dv, eb);
                for (DU du : this.f5285.values()) {
                    if ((du.m4681() && !du.m4688(eb)) || (du.m4686() && !du.m4684(dv))) {
                        this.f5285.remove(du.m4685());
                    }
                }
                for (DU du2 : r2) {
                    this.f5285.put(du2.m4685(), du2);
                }
                this.f5278 = dv;
                this.f5279 = eb;
                if (this.f5279 != null) {
                    this.f5277 = null;
                }
            } catch (MslException e) {
                throw new MslInternalException("Invalid master token and user ID token combination despite checking above.", e);
            }
        } else {
            throw new MslInternalException("Attempt to set message builder master token when key exchange data exists as a trusted network server.");
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public DL m4621(AbstractC1412Ec ec) {
        this.f5277 = ec;
        return this;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m4624(DW dw) {
        DV dv;
        if ((this.f5284.mo3166() || this.f5279 == null) && (!this.f5284.mo3166() || this.f5286 == null)) {
            if (this.f5274 != null) {
                dv = this.f5274.f5251.m4587();
            } else {
                dv = !this.f5284.mo3166() ? this.f5278 : this.f5282;
            }
            if (dv == null) {
                throw new MslInternalException("User ID token or peer user ID token cannot be created because no corresponding master token exists.");
            }
            C1411Eb r4 = this.f5284.mo3161().mo4677(this.f5284, dw, dv);
            if (!this.f5284.mo3166()) {
                this.f5279 = r4;
                this.f5277 = null;
                return;
            }
            this.f5286 = r4;
            return;
        }
        throw new MslInternalException("User ID token or peer user ID token already exists for the remote user.");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public DL m4620(AbstractC1408Dy dy) {
        this.f5283.add(dy);
        return this;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public C1411Eb m4626() {
        return this.f5286;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m4628(DV dv, C1411Eb eb) {
        if (!this.f5284.mo3166()) {
            throw new MslInternalException("Cannot set peer master token or peer user ID token when not in peer-to-peer mode.");
        } else if (eb != null && dv == null) {
            throw new MslInternalException("Peer master token cannot be null when setting peer user ID token.");
        } else if (eb == null || eb.m4871(dv)) {
            try {
                Set<DU> r4 = this.f5284.mo3159().mo4883(dv, eb);
                for (DU du : this.f5289.values()) {
                    if (du.m4681() && !du.m4688(eb)) {
                        this.f5289.remove(du.m4685());
                    } else if (du.m4686() && !du.m4684(dv)) {
                        this.f5289.remove(du.m4685());
                    }
                }
                for (DU du2 : r4) {
                    if (!this.f5289.containsKey(du2.m4685())) {
                        this.f5289.put(du2.m4685(), du2);
                    }
                }
                this.f5286 = eb;
                this.f5282 = dv;
            } catch (MslException e) {
                throw new MslInternalException("Invalid peer master token and user ID token combination despite proper check.", e);
            }
        } else {
            throw new MslMessageException(CK.f4807, "uit " + eb + "; mt " + dv).mo3076(dv).mo3086(eb);
        }
    }
}

package o;

import com.netflix.msl.MslCryptoException;
import com.netflix.msl.MslEncodingException;
import com.netflix.msl.MslEntityAuthException;
import com.netflix.msl.MslInternalException;
import com.netflix.msl.MslMasterTokenException;
import com.netflix.msl.io.MslEncoderException;
import com.netflix.msl.util.MslContext;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class DM extends DI {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final Long f5290;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private final DV f5291;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final boolean f5292;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final boolean f5293;

    /* renamed from: ʾ  reason: contains not printable characters */
    private final AbstractC1386Dc f5294;

    /* renamed from: ˈ  reason: contains not printable characters */
    private final Map<C1407Dx, byte[]> f5295 = new HashMap();

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AbstractC1385Db f5296;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final DC f5297;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final C1405Dv f5298;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final AbstractC1412Ec f5299;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final DV f5300;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f5301;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final C1411Eb f5302;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final DJ f5303;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f5304;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final Set<AbstractC1408Dy> f5305;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private final Set<DU> f5306;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private final DW f5307;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final Long f5308;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final C1411Eb f5309;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final long f5310;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final Set<DU> f5311;

    /* renamed from: o.DM$if  reason: invalid class name */
    public static class Cif {

        /* renamed from: ʻ  reason: contains not printable characters */
        public final DJ f5315;

        /* renamed from: ʼ  reason: contains not printable characters */
        public final AbstractC1412Ec f5316;

        /* renamed from: ʽ  reason: contains not printable characters */
        public final C1411Eb f5317;

        /* renamed from: ˊ  reason: contains not printable characters */
        public final long f5318;

        /* renamed from: ˋ  reason: contains not printable characters */
        public final boolean f5319;

        /* renamed from: ˎ  reason: contains not printable characters */
        public final boolean f5320;

        /* renamed from: ˏ  reason: contains not printable characters */
        public final Long f5321;

        /* renamed from: ॱ  reason: contains not printable characters */
        public final String f5322;

        /* renamed from: ॱˊ  reason: contains not printable characters */
        public final Set<DU> f5323;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        public final Set<AbstractC1408Dy> f5324;

        /* renamed from: ᐝ  reason: contains not printable characters */
        public final DC f5325;

        public Cif(String str, long j, Long l, boolean z, boolean z2, DJ dj, Set<AbstractC1408Dy> set, DC dc, AbstractC1412Ec ec, C1411Eb eb, Set<DU> set2) {
            this.f5322 = str;
            this.f5318 = j;
            this.f5321 = l;
            this.f5320 = z;
            this.f5319 = z2;
            this.f5315 = dj;
            this.f5324 = set;
            this.f5325 = dc;
            this.f5316 = ec;
            this.f5317 = eb;
            this.f5323 = set2;
        }
    }

    public static class If {

        /* renamed from: ˊ  reason: contains not printable characters */
        public final DV f5312;

        /* renamed from: ˎ  reason: contains not printable characters */
        public final C1411Eb f5313;

        /* renamed from: ˏ  reason: contains not printable characters */
        public final Set<DU> f5314;

        public If(DV dv, C1411Eb eb, Set<DU> set) {
            this.f5312 = dv;
            this.f5313 = eb;
            this.f5314 = set;
        }
    }

    public DM(MslContext mslContext, AbstractC1385Db db, DV dv, Cif ifVar, If r14) {
        boolean z;
        DV dv2;
        DV dv3;
        if (ifVar.f5318 < 0 || ifVar.f5318 > 9007199254740992L) {
            throw new MslInternalException("Message ID " + ifVar.f5318 + " is out of range.");
        } else if (db == null && dv == null) {
            throw new MslInternalException("Message entity authentication data or master token must be provided.");
        } else {
            if (dv != null) {
                z = true;
            } else {
                z = db.m4707().m4717();
            }
            this.f5296 = dv == null ? db : null;
            this.f5300 = dv;
            this.f5290 = ifVar.f5321;
            this.f5292 = ifVar.f5320;
            this.f5293 = ifVar.f5319;
            this.f5303 = ifVar.f5315;
            this.f5301 = this.f5300 != null ? mslContext.mo3168((MslContext.ReauthCode) null).mo4706() : null;
            this.f5304 = z ? ifVar.f5322 : null;
            this.f5308 = Long.valueOf(mslContext.mo3167() / 1000);
            this.f5310 = ifVar.f5318;
            this.f5305 = Collections.unmodifiableSet(ifVar.f5324 != null ? ifVar.f5324 : new HashSet());
            this.f5297 = ifVar.f5325;
            this.f5299 = ifVar.f5316;
            this.f5302 = ifVar.f5317;
            this.f5306 = Collections.unmodifiableSet(ifVar.f5323 != null ? ifVar.f5323 : new HashSet());
            if (mslContext.mo3166()) {
                this.f5291 = r14.f5312;
                this.f5309 = r14.f5313;
                this.f5311 = Collections.unmodifiableSet(r14.f5314 != null ? r14.f5314 : new HashSet());
            } else {
                this.f5291 = null;
                this.f5309 = null;
                this.f5311 = Collections.emptySet();
            }
            if (this.f5297 == null) {
                dv3 = this.f5300;
                dv2 = this.f5291;
            } else if (!mslContext.mo3166()) {
                dv3 = this.f5297.m4587();
                dv2 = this.f5291;
            } else {
                dv3 = this.f5300;
                dv2 = this.f5297.m4587();
            }
            if (this.f5302 != null && (dv3 == null || !this.f5302.m4871(dv3))) {
                throw new MslInternalException("User ID token must be bound to a master token.");
            } else if (this.f5309 == null || (dv2 != null && this.f5309.m4871(dv2))) {
                if (this.f5302 != null) {
                    this.f5307 = this.f5302.m4866();
                } else {
                    this.f5307 = null;
                }
                for (DU du : this.f5306) {
                    if (du.m4686() && (dv3 == null || !du.m4684(dv3))) {
                        throw new MslInternalException("Master token bound service tokens must be bound to the provided master token.");
                    } else if (du.m4681() && (this.f5302 == null || !du.m4688(this.f5302))) {
                        throw new MslInternalException("User ID token bound service tokens must be bound to the provided user ID token.");
                    }
                }
                for (DU du2 : this.f5311) {
                    if (du2.m4686() && (dv2 == null || !du2.m4684(dv2))) {
                        throw new MslInternalException("Master token bound peer service tokens must be bound to the provided peer master token.");
                    } else if (du2.m4681() && (this.f5309 == null || !du2.m4688(this.f5309))) {
                        throw new MslInternalException("User ID token bound peer service tokens must be bound to the provided peer user ID token.");
                    }
                }
                try {
                    this.f5298 = mslContext.mo3174().m4727();
                    if (this.f5301 != null) {
                        this.f5298.mo4754("sender", this.f5301);
                    }
                    if (this.f5304 != null) {
                        this.f5298.mo4754("recipient", this.f5304);
                    }
                    this.f5298.mo4754("timestamp", this.f5308);
                    this.f5298.mo4754("messageid", Long.valueOf(this.f5310));
                    this.f5298.mo4754("nonreplayable", Boolean.valueOf(this.f5290 != null));
                    if (this.f5290 != null) {
                        this.f5298.mo4754("nonreplayableid", this.f5290);
                    }
                    this.f5298.mo4754("renewable", Boolean.valueOf(this.f5292));
                    this.f5298.mo4754("handshake", Boolean.valueOf(this.f5293));
                    if (this.f5303 != null) {
                        this.f5298.mo4754("capabilities", this.f5303);
                    }
                    if (this.f5305.size() > 0) {
                        this.f5298.mo4754("keyrequestdata", C1404Du.m4748(mslContext, this.f5305));
                    }
                    if (this.f5297 != null) {
                        this.f5298.mo4754("keyresponsedata", this.f5297);
                    }
                    if (this.f5299 != null) {
                        this.f5298.mo4754("userauthdata", this.f5299);
                    }
                    if (this.f5302 != null) {
                        this.f5298.mo4754("useridtoken", this.f5302);
                    }
                    if (this.f5306.size() > 0) {
                        this.f5298.mo4754("servicetokens", C1404Du.m4748(mslContext, this.f5306));
                    }
                    if (this.f5291 != null) {
                        this.f5298.mo4754("peermastertoken", this.f5291);
                    }
                    if (this.f5309 != null) {
                        this.f5298.mo4754("peeruseridtoken", this.f5309);
                    }
                    if (this.f5311.size() > 0) {
                        this.f5298.mo4754("peerservicetokens", C1404Du.m4748(mslContext, this.f5311));
                    }
                    if (this.f5300 != null) {
                        AbstractC1386Dc r7 = mslContext.mo3159().mo4888(this.f5300);
                        if (r7 != null) {
                            this.f5294 = r7;
                        } else if (!this.f5300.m4696() || !this.f5300.m4693()) {
                            throw new MslMasterTokenException(CK.f4749, this.f5300).mo3086(this.f5302).mo3087(this.f5299).mo3085(this.f5310);
                        } else {
                            this.f5294 = new CZ(mslContext, this.f5300);
                        }
                    } else {
                        try {
                            C1391Dh r72 = this.f5296.m4707();
                            AbstractC1390Dg r8 = mslContext.mo3169(r72);
                            if (r8 == null) {
                                throw new MslEntityAuthException(CK.f4907, r72.m4716());
                            }
                            this.f5294 = r8.mo4710(mslContext, this.f5296);
                        } catch (MslCryptoException e) {
                            e.mo3077(this.f5296);
                            e.mo3086(this.f5302);
                            e.mo3087(this.f5299);
                            e.mo3085(this.f5310);
                            throw e;
                        } catch (MslEntityAuthException e2) {
                            e2.mo3077(this.f5296);
                            e2.mo3086(this.f5302);
                            e2.mo3087(this.f5299);
                            e2.mo3085(this.f5310);
                            throw e2;
                        }
                    }
                } catch (MslEncoderException e3) {
                    throw new MslEncodingException(CK.f4783, "headerdata", e3).mo3076(this.f5300).mo3077(this.f5296).mo3086(this.f5309).mo3087(this.f5299).mo3085(this.f5310);
                }
            } else {
                throw new MslInternalException("Peer user ID token must be bound to a peer master token.");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0260, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0261, code lost:
        r12.mo3076(r8).mo3086(r14.f5302).mo3087(r14.f5299);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0270, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x027b, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x02aa, code lost:
        throw new com.netflix.msl.MslEncodingException(o.CK.f4804, "headerdata " + r14.f5298, r8).mo3076(r18).mo3077(r17).mo3085(r14.f5310);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03c8, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03c9, code lost:
        r10.mo3076(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x03cc, code lost:
        throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0420, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x045f, code lost:
        throw new com.netflix.msl.MslEncodingException(o.CK.f4804, "headerdata " + r14.f5298.toString(), r8).mo3076(r18).mo3077(r17).mo3086(r14.f5302).mo3087(r14.f5299).mo3085(r14.f5310);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0460, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0461, code lost:
        r8.mo3076(r18);
        r8.mo3077(r17);
        r8.mo3086(r14.f5302);
        r8.mo3087(r14.f5299);
        r8.mo3085(r14.f5310);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x047a, code lost:
        throw r8;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x027b A[ExcHandler: MslEncoderException (r8v4 'e' com.netflix.msl.io.MslEncoderException A[CUSTOM_DECLARE]), Splitter:B:57:0x0139] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0420 A[ExcHandler: MslEncoderException (r8v7 'e' com.netflix.msl.io.MslEncoderException A[CUSTOM_DECLARE]), Splitter:B:119:0x02bc] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected DM(com.netflix.msl.util.MslContext r15, byte[] r16, o.AbstractC1385Db r17, o.DV r18, byte[] r19, java.util.Map<java.lang.String, o.AbstractC1386Dc> r20) {
        /*
        // Method dump skipped, instructions count: 1148
        */
        throw new UnsupportedOperationException("Method not decompiled: o.DM.<init>(com.netflix.msl.util.MslContext, byte[], o.Db, o.DV, byte[], java.util.Map):void");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public AbstractC1386Dc m4640() {
        return this.f5294;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public DW m4638() {
        return this.f5307;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public AbstractC1385Db m4644() {
        return this.f5296;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public DV m4636() {
        return this.f5300;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m4641() {
        return this.f5301;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public String m4634() {
        return this.f5304;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public Date m4650() {
        if (this.f5308 != null) {
            return new Date(this.f5308.longValue() * 1000);
        }
        return null;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public long m4648() {
        return this.f5310;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public Long m4635() {
        return this.f5290;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean m4632() {
        return this.f5292;
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public boolean m4645() {
        return this.f5293;
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public DJ m4637() {
        return this.f5303;
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public Set<AbstractC1408Dy> m4639() {
        return this.f5305;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public DC m4643() {
        return this.f5297;
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public AbstractC1412Ec m4642() {
        return this.f5299;
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    public C1411Eb m4646() {
        return this.f5302;
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    public Set<DU> m4633() {
        return this.f5306;
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    public DV m4647() {
        return this.f5291;
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public C1411Eb m4649() {
        return this.f5309;
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public Set<DU> m4651() {
        return this.f5311;
    }

    @Override // o.AbstractC1399Dp
    /* renamed from: ˏ */
    public byte[] mo3114(AbstractC1400Dq dq, C1407Dx dx) {
        if (this.f5295.containsKey(dx)) {
            return this.f5295.get(dx);
        }
        try {
            byte[] r3 = this.f5294.mo4323(dq.mo3178(this.f5298, dx), dq, dx);
            try {
                Object r4 = this.f5294.mo4325(r3, dq, dx);
                C1405Dv r5 = dq.m4727();
                if (this.f5300 != null) {
                    r5.mo4754("mastertoken", this.f5300);
                } else {
                    r5.mo4754("entityauthdata", this.f5296);
                }
                r5.mo4754("headerdata", r3);
                r5.mo4754("signature", r4);
                byte[] r6 = dq.mo3178(r5, dx);
                this.f5295.put(dx, r6);
                return r6;
            } catch (MslCryptoException e) {
                throw new MslEncoderException("Error signging the header data.", e);
            }
        } catch (MslCryptoException e2) {
            throw new MslEncoderException("Error encrypting the header data.", e2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DM)) {
            return false;
        }
        DM dm = (DM) obj;
        return ((this.f5300 != null && this.f5300.equals(dm.f5300)) || (this.f5296 != null && this.f5296.equals(dm.f5296))) && ((this.f5301 != null && this.f5301.equals(dm.f5301)) || this.f5301 == dm.f5301) && (((this.f5304 != null && this.f5304.equals(dm.f5304)) || this.f5304 == dm.f5304) && (((this.f5308 != null && this.f5308.equals(dm.f5308)) || (this.f5308 == null && dm.f5308 == null)) && this.f5310 == dm.f5310 && (((this.f5290 != null && this.f5290.equals(dm.f5290)) || (this.f5290 == null && dm.f5290 == null)) && this.f5292 == dm.f5292 && this.f5293 == dm.f5293 && (((this.f5303 != null && this.f5303.equals(dm.f5303)) || this.f5303 == dm.f5303) && this.f5305.equals(dm.f5305) && (((this.f5297 != null && this.f5297.equals(dm.f5297)) || this.f5297 == dm.f5297) && (((this.f5299 != null && this.f5299.equals(dm.f5299)) || this.f5299 == dm.f5299) && (((this.f5302 != null && this.f5302.equals(dm.f5302)) || this.f5302 == dm.f5302) && this.f5306.equals(dm.f5306) && (((this.f5291 != null && this.f5291.equals(dm.f5291)) || this.f5291 == dm.f5291) && (((this.f5309 != null && this.f5309.equals(dm.f5309)) || this.f5309 == dm.f5309) && this.f5311.equals(dm.f5311))))))))));
    }

    public int hashCode() {
        return ((((((((((((((((this.f5300 != null ? this.f5300.hashCode() : this.f5296.hashCode()) ^ (this.f5301 != null ? this.f5301.hashCode() : 0)) ^ (this.f5304 != null ? this.f5304.hashCode() : 0)) ^ (this.f5308 != null ? this.f5308.hashCode() : 0)) ^ Long.valueOf(this.f5310).hashCode()) ^ (this.f5290 != null ? this.f5290.hashCode() : 0)) ^ Boolean.valueOf(this.f5292).hashCode()) ^ Boolean.valueOf(this.f5293).hashCode()) ^ (this.f5303 != null ? this.f5303.hashCode() : 0)) ^ this.f5305.hashCode()) ^ (this.f5297 != null ? this.f5297.hashCode() : 0)) ^ (this.f5299 != null ? this.f5299.hashCode() : 0)) ^ (this.f5302 != null ? this.f5302.hashCode() : 0)) ^ this.f5306.hashCode()) ^ (this.f5291 != null ? this.f5291.hashCode() : 0)) ^ (this.f5309 != null ? this.f5309.hashCode() : 0)) ^ this.f5311.hashCode();
    }
}

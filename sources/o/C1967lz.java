package o;

import com.google.gson.annotations.SerializedName;
import o.AbstractC1952kz;
/* renamed from: o.lz  reason: case insensitive filesystem */
class C1967lz extends lC {
    @SerializedName("cdnInfo")
    protected iF[] cdnInfo;
    @SerializedName("fastselthreshold")
    protected Integer fastSelThreshold;
    @SerializedName("oldCdnId")
    protected Integer oldCdnId;
    @SerializedName("pricdnid")
    protected Integer primaryCdnId;
    @SerializedName("selreason")
    protected String selReason;
    @SerializedName("selcdnbw")
    protected Integer selectedCdnBandwidth;
    @SerializedName("cdnbwdata")
    protected Cif[] selectedCdnBandwidthData;
    @SerializedName("selcdnid")
    protected Integer selectedCdnId;
    @SerializedName("selcdnrtt")
    protected Integer selectedCdnRtt;
    @SerializedName("testreason")
    protected String testreason;

    protected C1967lz() {
    }

    public C1967lz(String str) {
        super("cdnsel", str);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1967lz m8775(long j) {
        m8547(j);
        return this;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C1967lz m8773(AbstractC1952kz.If r2) {
        if (r2 != null) {
            this.oldCdnId = Integer.valueOf(r2.f8472);
        }
        return this;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C1967lz m8774(AbstractC1952kz.If r9) {
        this.fastSelThreshold = Integer.valueOf(r9.f8468);
        this.primaryCdnId = Integer.valueOf(r9.f8470);
        this.selectedCdnBandwidth = Integer.valueOf(r9.f8469);
        this.selectedCdnId = Integer.valueOf(r9.f8472);
        this.selectedCdnRtt = Integer.valueOf(r9.f8471);
        this.selReason = r9.f8465;
        this.testreason = r9.f8464;
        if (r9.f8466 != null) {
            this.selectedCdnBandwidthData = new Cif[r9.f8466.length];
            int i = 0;
            for (AbstractC1952kz.Cif ifVar : r9.f8466) {
                i++;
                this.selectedCdnBandwidthData[i] = Cif.m8777(ifVar);
            }
        }
        if (r9.f8467 != null) {
            this.cdnInfo = new iF[r9.f8467.length];
            int i2 = 0;
            for (AbstractC1952kz.C0141 r7 : r9.f8467) {
                i2++;
                this.cdnInfo[i2] = iF.m8776(r7);
            }
        }
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: o.lz$iF */
    public static class iF {
        @SerializedName("id")
        protected String id;
        @SerializedName("level")
        protected Integer level;
        @SerializedName("locid")
        protected String locationId;
        @SerializedName("lowg")
        protected boolean lowgrade;
        @SerializedName("nm")
        protected String name;
        @SerializedName("rk")
        protected Integer rank;
        @SerializedName("wt")
        protected Integer weight;

        protected iF() {
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public static iF m8776(AbstractC1952kz.C0141 r2) {
            iF iFVar = new iF();
            iFVar.id = r2.f8480;
            iFVar.name = r2.f8483;
            iFVar.rank = Integer.valueOf(r2.f8481);
            iFVar.weight = Integer.valueOf(r2.f8482);
            iFVar.locationId = r2.f8484;
            iFVar.level = Integer.valueOf(r2.f8478);
            iFVar.lowgrade = r2.f8486;
            return iFVar;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: o.lz$if  reason: invalid class name */
    public static class Cif {
        @SerializedName("bw")
        protected Integer bandwidth;
        @SerializedName("id")
        protected String id;
        @SerializedName("ip")
        protected String ip;
        @SerializedName("locid")
        protected String locid;
        @SerializedName("rtt")
        protected Integer rtt;

        protected Cif() {
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public static Cif m8777(AbstractC1952kz.Cif ifVar) {
            Cif ifVar2 = new Cif();
            ifVar2.id = ifVar.f8474;
            ifVar2.locid = ifVar.f8473;
            ifVar2.ip = ifVar.f8477;
            ifVar2.rtt = Integer.valueOf(ifVar.f8475);
            ifVar2.bandwidth = Integer.valueOf(ifVar.f8476);
            return ifVar2;
        }
    }
}

package o;
/* renamed from: o.kz  reason: case insensitive filesystem */
public interface AbstractC1952kz {

    /* renamed from: o.kz$iF  reason: case insensitive filesystem */
    public interface AbstractC1953iF {
        /* renamed from: ˊ  reason: contains not printable characters */
        void mo8458(int[] iArr, int i, long j, long j2, int i2, int i3);

        /* renamed from: ˋ  reason: contains not printable characters */
        void mo8459(C0142 v);

        /* renamed from: ˎ  reason: contains not printable characters */
        void mo8460();

        /* renamed from: ˏ  reason: contains not printable characters */
        void mo8461(If v);
    }

    /* renamed from: o.kz$if  reason: invalid class name */
    public static class Cif {

        /* renamed from: ˊ  reason: contains not printable characters */
        public String f8473;

        /* renamed from: ˋ  reason: contains not printable characters */
        public String f8474;

        /* renamed from: ˎ  reason: contains not printable characters */
        public int f8475;

        /* renamed from: ˏ  reason: contains not printable characters */
        public int f8476;

        /* renamed from: ॱ  reason: contains not printable characters */
        public String f8477;
    }

    /* renamed from: ˊ */
    C0143 mo8355();

    /* renamed from: ˎ */
    void mo8357(AbstractC1953iF iFVar);

    /* renamed from: o.kz$ˊ  reason: contains not printable characters */
    public static class C0141 {

        /* renamed from: ʼ  reason: contains not printable characters */
        public int f8478;

        /* renamed from: ʽ  reason: contains not printable characters */
        public int f8479;

        /* renamed from: ˊ  reason: contains not printable characters */
        public String f8480;

        /* renamed from: ˋ  reason: contains not printable characters */
        public int f8481;

        /* renamed from: ˎ  reason: contains not printable characters */
        public int f8482;

        /* renamed from: ˏ  reason: contains not printable characters */
        public String f8483;

        /* renamed from: ॱ  reason: contains not printable characters */
        public String f8484;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        public int f8485;

        /* renamed from: ᐝ  reason: contains not printable characters */
        public boolean f8486;

        public C0141(String str, String str2, String str3, int i, int i2, int i3, boolean z, int i4, int i5) {
            this.f8480 = str;
            this.f8484 = str2;
            this.f8483 = str3;
            this.f8481 = i;
            this.f8482 = i2;
            this.f8478 = i3;
            this.f8486 = z;
            this.f8485 = i4;
            this.f8479 = i5;
        }
    }

    /* renamed from: o.kz$If */
    public static class If {

        /* renamed from: ʻ  reason: contains not printable characters */
        public String f8464;

        /* renamed from: ʼ  reason: contains not printable characters */
        public String f8465;

        /* renamed from: ˊ  reason: contains not printable characters */
        public Cif[] f8466;

        /* renamed from: ˋ  reason: contains not printable characters */
        public C0141[] f8467;

        /* renamed from: ˎ  reason: contains not printable characters */
        public int f8468;

        /* renamed from: ˏ  reason: contains not printable characters */
        public int f8469;

        /* renamed from: ॱ  reason: contains not printable characters */
        public int f8470;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        public int f8471;

        /* renamed from: ᐝ  reason: contains not printable characters */
        public int f8472;

        public If(Cif[] ifVarArr, C0141[] r2, int i, int i2, int i3, int i4, int i5, String str, String str2) {
            this.f8466 = ifVarArr;
            this.f8467 = r2;
            this.f8468 = i;
            this.f8470 = i2;
            this.f8469 = i3;
            this.f8472 = i4;
            this.f8471 = i5;
            this.f8465 = str;
            this.f8464 = str2;
        }

        public String toString() {
            return "CdnSwitchData{pricdnid=" + this.f8470 + ", selcdnbw=" + this.f8469 + ", selcdnid=" + this.f8472 + ", selcdnrtt=" + this.f8471 + ", selreason='" + this.f8465 + "', testreason='" + this.f8464 + "'}";
        }
    }

    /* renamed from: o.kz$ˋ  reason: contains not printable characters */
    public static class C0142 {

        /* renamed from: ˊ  reason: contains not printable characters */
        public int f8487;

        /* renamed from: ˋ  reason: contains not printable characters */
        public int f8488;

        /* renamed from: ˎ  reason: contains not printable characters */
        public long f8489;

        /* renamed from: ˏ  reason: contains not printable characters */
        public String f8490;

        /* renamed from: ॱ  reason: contains not printable characters */
        public int f8491;

        public C0142(String str, int i, int i2, int i3, long j) {
            this.f8490 = str;
            this.f8487 = i;
            this.f8488 = i2;
            this.f8491 = i3;
            this.f8489 = j;
        }

        public String toString() {
            return "StreamSwitchData{vdlid='" + this.f8490 + "', vbitrate=" + this.f8491 + ", moffms=" + this.f8489 + '}';
        }
    }

    /* renamed from: o.kz$ˎ  reason: contains not printable characters */
    public static class C0143 {

        /* renamed from: ˊ  reason: contains not printable characters */
        public double f8492;

        /* renamed from: ˋ  reason: contains not printable characters */
        public int f8493;

        /* renamed from: ˎ  reason: contains not printable characters */
        public int f8494;

        /* renamed from: ˏ  reason: contains not printable characters */
        public int f8495;

        /* renamed from: ॱ  reason: contains not printable characters */
        public int f8496;

        public C0143(int i, double d, int i2, int i3, int i4) {
            this.f8493 = i;
            this.f8492 = d;
            this.f8495 = i2;
            this.f8496 = i3;
            this.f8494 = i4;
        }
    }
}

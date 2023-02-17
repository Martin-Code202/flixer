package o;

import o.vI;
/* renamed from: o.vz  reason: case insensitive filesystem */
final class C2256vz extends vI {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final boolean f11373;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final int f11374;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f11375;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final int f11376;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final int f11377;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final int f11378;

    private C2256vz(int i, int i2, int i3, int i4, int i5, boolean z) {
        this.f11375 = i;
        this.f11378 = i2;
        this.f11376 = i3;
        this.f11377 = i4;
        this.f11374 = i5;
        this.f11373 = z;
    }

    @Override // o.vI
    /* renamed from: ˋ */
    public int mo11944() {
        return this.f11375;
    }

    @Override // o.vI
    /* renamed from: ˊ */
    public int mo11943() {
        return this.f11378;
    }

    @Override // o.vI
    /* renamed from: ˏ */
    public int mo11946() {
        return this.f11376;
    }

    @Override // o.vI
    /* renamed from: ˎ */
    public int mo11945() {
        return this.f11377;
    }

    @Override // o.vI
    /* renamed from: ॱ */
    public int mo11947() {
        return this.f11374;
    }

    @Override // o.vI
    /* renamed from: ᐝ */
    public boolean mo11948() {
        return this.f11373;
    }

    public String toString() {
        return "DownloadsSummary{currentActive=" + this.f11375 + ", error=" + this.f11378 + ", completed=" + this.f11376 + ", paused=" + this.f11377 + ", overallProgress=" + this.f11374 + ", wifiOnly=" + this.f11373 + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof vI)) {
            return false;
        }
        vI vIVar = (vI) obj;
        return this.f11375 == vIVar.mo11944() && this.f11378 == vIVar.mo11943() && this.f11376 == vIVar.mo11946() && this.f11377 == vIVar.mo11945() && this.f11374 == vIVar.mo11947() && this.f11373 == vIVar.mo11948();
    }

    public int hashCode() {
        return ((((((((((1000003 ^ this.f11375) * 1000003) ^ this.f11378) * 1000003) ^ this.f11376) * 1000003) ^ this.f11377) * 1000003) ^ this.f11374) * 1000003) ^ (this.f11373 ? 1231 : 1237);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.vz$If */
    public static final class If extends vI.Cif {

        /* renamed from: ʻ  reason: contains not printable characters */
        private Boolean f11379;

        /* renamed from: ˊ  reason: contains not printable characters */
        private Integer f11380;

        /* renamed from: ˋ  reason: contains not printable characters */
        private Integer f11381;

        /* renamed from: ˎ  reason: contains not printable characters */
        private Integer f11382;

        /* renamed from: ˏ  reason: contains not printable characters */
        private Integer f11383;

        /* renamed from: ॱ  reason: contains not printable characters */
        private Integer f11384;

        If() {
        }

        @Override // o.vI.Cif
        /* renamed from: ˎ */
        public vI.Cif mo11952(int i) {
            this.f11384 = Integer.valueOf(i);
            return this;
        }

        @Override // o.vI.Cif
        /* renamed from: ॱ */
        public vI.Cif mo11954(int i) {
            this.f11380 = Integer.valueOf(i);
            return this;
        }

        @Override // o.vI.Cif
        /* renamed from: ˋ */
        public vI.Cif mo11951(int i) {
            this.f11383 = Integer.valueOf(i);
            return this;
        }

        @Override // o.vI.Cif
        /* renamed from: ˊ */
        public vI.Cif mo11949(int i) {
            this.f11382 = Integer.valueOf(i);
            return this;
        }

        @Override // o.vI.Cif
        /* renamed from: ˏ */
        public vI.Cif mo11953(int i) {
            this.f11381 = Integer.valueOf(i);
            return this;
        }

        @Override // o.vI.Cif
        /* renamed from: ˊ */
        public vI.Cif mo11950(boolean z) {
            this.f11379 = Boolean.valueOf(z);
            return this;
        }

        @Override // o.vI.Cif
        /* renamed from: ॱ */
        public vI mo11955() {
            String str = "";
            if (this.f11384 == null) {
                str = str + " currentActive";
            }
            if (this.f11380 == null) {
                str = str + " error";
            }
            if (this.f11383 == null) {
                str = str + " completed";
            }
            if (this.f11382 == null) {
                str = str + " paused";
            }
            if (this.f11381 == null) {
                str = str + " overallProgress";
            }
            if (this.f11379 == null) {
                str = str + " wifiOnly";
            }
            if (str.isEmpty()) {
                return new C2256vz(this.f11384.intValue(), this.f11380.intValue(), this.f11383.intValue(), this.f11382.intValue(), this.f11381.intValue(), this.f11379.booleanValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}

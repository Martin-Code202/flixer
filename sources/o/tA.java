package o;

import com.netflix.mediaclient.servicemgr.UiLocation;
import o.tU;
final class tA extends tU {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final UiLocation f10308;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final int f10309;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final pC f10310;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f10311;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final int f10312;

    private tA(pC pCVar, String str, UiLocation uiLocation, int i, int i2) {
        this.f10310 = pCVar;
        this.f10311 = str;
        this.f10308 = uiLocation;
        this.f10312 = i;
        this.f10309 = i2;
    }

    /* access modifiers changed from: package-private */
    @Override // o.tU
    /* renamed from: ॱ  reason: contains not printable characters */
    public pC mo10878() {
        return this.f10310;
    }

    /* access modifiers changed from: package-private */
    @Override // o.tU
    /* renamed from: ˎ  reason: contains not printable characters */
    public String mo10876() {
        return this.f10311;
    }

    /* access modifiers changed from: package-private */
    @Override // o.tU
    /* renamed from: ˊ  reason: contains not printable characters */
    public UiLocation mo10874() {
        return this.f10308;
    }

    /* access modifiers changed from: package-private */
    @Override // o.tU
    /* renamed from: ˏ  reason: contains not printable characters */
    public int mo10877() {
        return this.f10312;
    }

    /* access modifiers changed from: package-private */
    @Override // o.tU
    /* renamed from: ˋ  reason: contains not printable characters */
    public int mo10875() {
        return this.f10309;
    }

    public String toString() {
        return "LomoContext{lomo=" + this.f10310 + ", lolomoId=" + this.f10311 + ", uiLocation=" + this.f10308 + ", positionInLolomo=" + this.f10312 + ", positionInUi=" + this.f10309 + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof tU)) {
            return false;
        }
        tU tUVar = (tU) obj;
        return this.f10310.equals(tUVar.mo10878()) && (this.f10311 != null ? this.f10311.equals(tUVar.mo10876()) : tUVar.mo10876() == null) && this.f10308.equals(tUVar.mo10874()) && this.f10312 == tUVar.mo10877() && this.f10309 == tUVar.mo10875();
    }

    public int hashCode() {
        return ((((((((1000003 ^ this.f10310.hashCode()) * 1000003) ^ (this.f10311 == null ? 0 : this.f10311.hashCode())) * 1000003) ^ this.f10308.hashCode()) * 1000003) ^ this.f10312) * 1000003) ^ this.f10309;
    }

    @Override // o.tU
    /* renamed from: ʽ  reason: contains not printable characters */
    public tU.If mo10873() {
        return new iF(this);
    }

    /* access modifiers changed from: package-private */
    public static final class iF extends tU.If {

        /* renamed from: ˊ  reason: contains not printable characters */
        private Integer f10313;

        /* renamed from: ˋ  reason: contains not printable characters */
        private pC f10314;

        /* renamed from: ˎ  reason: contains not printable characters */
        private UiLocation f10315;

        /* renamed from: ˏ  reason: contains not printable characters */
        private String f10316;

        /* renamed from: ॱ  reason: contains not printable characters */
        private Integer f10317;

        iF() {
        }

        iF(tU tUVar) {
            this.f10314 = tUVar.mo10878();
            this.f10316 = tUVar.mo10876();
            this.f10315 = tUVar.mo10874();
            this.f10313 = Integer.valueOf(tUVar.mo10877());
            this.f10317 = Integer.valueOf(tUVar.mo10875());
        }

        @Override // o.tU.If
        /* renamed from: ˎ  reason: contains not printable characters */
        public tU.If mo10882(pC pCVar) {
            this.f10314 = pCVar;
            return this;
        }

        @Override // o.tU.If
        /* renamed from: ˋ  reason: contains not printable characters */
        public tU.If mo10880(String str) {
            this.f10316 = str;
            return this;
        }

        @Override // o.tU.If
        /* renamed from: ˋ  reason: contains not printable characters */
        public tU.If mo10879(UiLocation uiLocation) {
            this.f10315 = uiLocation;
            return this;
        }

        @Override // o.tU.If
        /* renamed from: ॱ  reason: contains not printable characters */
        public tU.If mo10884(int i) {
            this.f10313 = Integer.valueOf(i);
            return this;
        }

        @Override // o.tU.If
        /* renamed from: ˎ  reason: contains not printable characters */
        public tU.If mo10881(int i) {
            this.f10317 = Integer.valueOf(i);
            return this;
        }

        @Override // o.tU.If
        /* renamed from: ˎ  reason: contains not printable characters */
        public tU mo10883() {
            String str = "";
            if (this.f10314 == null) {
                str = str + " lomo";
            }
            if (this.f10315 == null) {
                str = str + " uiLocation";
            }
            if (this.f10313 == null) {
                str = str + " positionInLolomo";
            }
            if (this.f10317 == null) {
                str = str + " positionInUi";
            }
            if (str.isEmpty()) {
                return new tA(this.f10314, this.f10316, this.f10315, this.f10313.intValue(), this.f10317.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}

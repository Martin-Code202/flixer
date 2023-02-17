package o;

import android.os.Bundle;
/* renamed from: o.ᐥ  reason: contains not printable characters */
public final class C0742 implements AbstractC0639 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final boolean f14339;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final C0986 f14340;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f14341;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final boolean f14342;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f14343;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C0897 f14344;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f14345;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final Bundle f14346;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final int[] f14347;

    private C0742(C0743 r2) {
        this.f14345 = r2.f14354;
        this.f14343 = r2.f14355;
        this.f14344 = r2.f14352;
        this.f14340 = r2.f14348;
        this.f14342 = r2.f14353;
        this.f14341 = r2.f14351;
        this.f14347 = r2.f14350;
        this.f14346 = r2.f14349;
        this.f14339 = r2.f14356;
    }

    @Override // o.AbstractC0639
    /* renamed from: ʽ */
    public String mo14602() {
        return this.f14343;
    }

    @Override // o.AbstractC0639
    /* renamed from: ˏ */
    public String mo14606() {
        return this.f14345;
    }

    @Override // o.AbstractC0639
    /* renamed from: ʻ */
    public C0897 mo14601() {
        return this.f14344;
    }

    @Override // o.AbstractC0639
    /* renamed from: ᐝ */
    public int mo14609() {
        return this.f14341;
    }

    @Override // o.AbstractC0639
    /* renamed from: ॱॱ */
    public boolean mo14608() {
        return this.f14342;
    }

    @Override // o.AbstractC0639
    /* renamed from: ॱ */
    public int[] mo14607() {
        return this.f14347;
    }

    @Override // o.AbstractC0639
    /* renamed from: ˎ */
    public Bundle mo14605() {
        return this.f14346;
    }

    @Override // o.AbstractC0639
    /* renamed from: ˊ */
    public C0986 mo14603() {
        return this.f14340;
    }

    @Override // o.AbstractC0639
    /* renamed from: ˋ */
    public boolean mo14604() {
        return this.f14339;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ᐥ$ˋ  reason: contains not printable characters */
    public static final class C0743 {

        /* renamed from: ʻ  reason: contains not printable characters */
        private C0986 f14348;

        /* renamed from: ʼ  reason: contains not printable characters */
        private final Bundle f14349 = new Bundle();

        /* renamed from: ʽ  reason: contains not printable characters */
        private int[] f14350;

        /* renamed from: ˊ  reason: contains not printable characters */
        private int f14351;

        /* renamed from: ˋ  reason: contains not printable characters */
        private C0897 f14352;

        /* renamed from: ˎ  reason: contains not printable characters */
        private boolean f14353;

        /* renamed from: ˏ  reason: contains not printable characters */
        private String f14354;

        /* renamed from: ॱ  reason: contains not printable characters */
        private String f14355;

        /* renamed from: ᐝ  reason: contains not printable characters */
        private boolean f14356;

        C0743() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˏ  reason: contains not printable characters */
        public C0742 m15155() {
            if (this.f14354 != null && this.f14355 != null && this.f14352 != null) {
                return new C0742(this);
            }
            throw new IllegalArgumentException("Required fields were not populated.");
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public C0743 m15151(String str) {
            this.f14354 = str;
            return this;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public C0743 m15156(String str) {
            this.f14355 = str;
            return this;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public C0743 m15148(C0897 r1) {
            this.f14352 = r1;
            return this;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public C0743 m15154(boolean z) {
            this.f14353 = z;
            return this;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public C0743 m15147(int i) {
            this.f14351 = i;
            return this;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public C0743 m15150(int[] iArr) {
            this.f14350 = iArr;
            return this;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public C0743 m15153(Bundle bundle) {
            if (bundle != null) {
                this.f14349.putAll(bundle);
            }
            return this;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public C0743 m15149(C0986 r1) {
            this.f14348 = r1;
            return this;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public C0743 m15152(boolean z) {
            this.f14356 = z;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        C0742 r2 = (C0742) obj;
        return this.f14345.equals(r2.f14345) && this.f14343.equals(r2.f14343) && this.f14344.equals(r2.f14344);
    }

    public int hashCode() {
        return (((this.f14345.hashCode() * 31) + this.f14343.hashCode()) * 31) + this.f14344.hashCode();
    }
}

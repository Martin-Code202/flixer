package o;

import android.support.v7.widget.RecyclerView;
import o.AbstractC0954;
/* renamed from: o.ᐞ  reason: contains not printable characters */
final class C0733 extends AbstractC0954 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final int f14273;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final int f14274;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final float f14275;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f14276;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final boolean f14277;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final float f14278;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final int f14279;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final int f14280;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final int f14281;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final boolean f14282;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final boolean f14283;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final int f14284;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final int f14285;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final RecyclerView.RecycledViewPool f14286;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final int f14287;

    private C0733(int i, float f, int i2, int i3, int i4, int i5, float f2, int i6, RecyclerView.RecycledViewPool recycledViewPool, int i7, boolean z, boolean z2, boolean z3, int i8, int i9) {
        this.f14284 = i;
        this.f14278 = f;
        this.f14280 = i2;
        this.f14276 = i3;
        this.f14281 = i4;
        this.f14273 = i5;
        this.f14275 = f2;
        this.f14287 = i6;
        this.f14286 = recycledViewPool;
        this.f14274 = i7;
        this.f14283 = z;
        this.f14277 = z2;
        this.f14282 = z3;
        this.f14279 = i8;
        this.f14285 = i9;
    }

    @Override // o.AbstractC0954
    /* renamed from: ˋ  reason: contains not printable characters */
    public int mo15082() {
        return this.f14284;
    }

    @Override // o.AbstractC0954
    /* renamed from: ˏ  reason: contains not printable characters */
    public float mo15085() {
        return this.f14278;
    }

    @Override // o.AbstractC0954
    /* renamed from: ॱ  reason: contains not printable characters */
    public int mo15088() {
        return this.f14280;
    }

    @Override // o.AbstractC0954
    /* renamed from: ˊ  reason: contains not printable characters */
    public int mo15080() {
        return this.f14276;
    }

    @Override // o.AbstractC0954
    /* renamed from: ˎ  reason: contains not printable characters */
    public int mo15084() {
        return this.f14281;
    }

    @Override // o.AbstractC0954
    /* renamed from: ʻ  reason: contains not printable characters */
    public int mo15076() {
        return this.f14273;
    }

    @Override // o.AbstractC0954
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public float mo15090() {
        return this.f14275;
    }

    @Override // o.AbstractC0954
    /* renamed from: ᐝ  reason: contains not printable characters */
    public int mo15091() {
        return this.f14287;
    }

    @Override // o.AbstractC0954
    /* renamed from: ʽ  reason: contains not printable characters */
    public RecyclerView.RecycledViewPool mo15079() {
        return this.f14286;
    }

    @Override // o.AbstractC0954
    /* renamed from: ʼ  reason: contains not printable characters */
    public int mo15078() {
        return this.f14274;
    }

    @Override // o.AbstractC0954
    /* renamed from: ͺ  reason: contains not printable characters */
    public boolean mo15087() {
        return this.f14283;
    }

    @Override // o.AbstractC0954
    /* renamed from: ॱˊ  reason: contains not printable characters */
    public boolean mo15089() {
        return this.f14277;
    }

    @Override // o.AbstractC0954
    /* renamed from: ˏॱ  reason: contains not printable characters */
    public boolean mo15086() {
        return this.f14282;
    }

    @Override // o.AbstractC0954
    /* renamed from: ˋॱ  reason: contains not printable characters */
    public int mo15083() {
        return this.f14279;
    }

    @Override // o.AbstractC0954
    /* renamed from: ˊॱ  reason: contains not printable characters */
    public int mo15081() {
        return this.f14285;
    }

    public String toString() {
        return "RowConfig{numberOfItemsPerPage=" + this.f14284 + ", aspectRatio=" + this.f14278 + ", numberOfPagesToScrollOnFling=" + this.f14280 + ", millisecondsPerInch=" + this.f14276 + ", itemPadding=" + this.f14281 + ", listPadding=" + this.f14273 + ", peekRatio=" + this.f14275 + ", maxHeight=" + this.f14287 + ", recycledViewPool=" + this.f14286 + ", viewType=" + this.f14274 + ", freeScroll=" + this.f14283 + ", lightTheme=" + this.f14277 + ", hasCirclePlaceholder=" + this.f14282 + ", rowCount=" + this.f14279 + ", adjustStrategy=" + this.f14285 + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC0954)) {
            return false;
        }
        AbstractC0954 r2 = (AbstractC0954) obj;
        return this.f14284 == r2.mo15082() && Float.floatToIntBits(this.f14278) == Float.floatToIntBits(r2.mo15085()) && this.f14280 == r2.mo15088() && this.f14276 == r2.mo15080() && this.f14281 == r2.mo15084() && this.f14273 == r2.mo15076() && Float.floatToIntBits(this.f14275) == Float.floatToIntBits(r2.mo15090()) && this.f14287 == r2.mo15091() && (this.f14286 != null ? this.f14286.equals(r2.mo15079()) : r2.mo15079() == null) && this.f14274 == r2.mo15078() && this.f14283 == r2.mo15087() && this.f14277 == r2.mo15089() && this.f14282 == r2.mo15086() && this.f14279 == r2.mo15083() && this.f14285 == r2.mo15081();
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((1000003 ^ this.f14284) * 1000003) ^ Float.floatToIntBits(this.f14278)) * 1000003) ^ this.f14280) * 1000003) ^ this.f14276) * 1000003) ^ this.f14281) * 1000003) ^ this.f14273) * 1000003) ^ Float.floatToIntBits(this.f14275)) * 1000003) ^ this.f14287) * 1000003) ^ (this.f14286 == null ? 0 : this.f14286.hashCode())) * 1000003) ^ this.f14274) * 1000003) ^ (this.f14283 ? 1231 : 1237)) * 1000003) ^ (this.f14277 ? 1231 : 1237)) * 1000003) ^ (this.f14282 ? 1231 : 1237)) * 1000003) ^ this.f14279) * 1000003) ^ this.f14285;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0954
    /* renamed from: ʻॱ  reason: contains not printable characters */
    public AbstractC0954.Cif mo15077() {
        return new C0734(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ᐞ$ˋ  reason: contains not printable characters */
    public static final class C0734 extends AbstractC0954.Cif {

        /* renamed from: ʻ  reason: contains not printable characters */
        private Float f14288;

        /* renamed from: ʼ  reason: contains not printable characters */
        private RecyclerView.RecycledViewPool f14289;

        /* renamed from: ʽ  reason: contains not printable characters */
        private Integer f14290;

        /* renamed from: ˊ  reason: contains not printable characters */
        private Integer f14291;

        /* renamed from: ˊॱ  reason: contains not printable characters */
        private Integer f14292;

        /* renamed from: ˋ  reason: contains not printable characters */
        private Float f14293;

        /* renamed from: ˋॱ  reason: contains not printable characters */
        private Boolean f14294;

        /* renamed from: ˎ  reason: contains not printable characters */
        private Integer f14295;

        /* renamed from: ˏ  reason: contains not printable characters */
        private Integer f14296;

        /* renamed from: ˏॱ  reason: contains not printable characters */
        private Boolean f14297;

        /* renamed from: ͺ  reason: contains not printable characters */
        private Integer f14298;

        /* renamed from: ॱ  reason: contains not printable characters */
        private Integer f14299;

        /* renamed from: ॱˊ  reason: contains not printable characters */
        private Boolean f14300;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        private Integer f14301;

        /* renamed from: ᐝ  reason: contains not printable characters */
        private Integer f14302;

        C0734() {
        }

        private C0734(AbstractC0954 r2) {
            this.f14296 = Integer.valueOf(r2.mo15082());
            this.f14293 = Float.valueOf(r2.mo15085());
            this.f14299 = Integer.valueOf(r2.mo15088());
            this.f14291 = Integer.valueOf(r2.mo15080());
            this.f14295 = Integer.valueOf(r2.mo15084());
            this.f14290 = Integer.valueOf(r2.mo15076());
            this.f14288 = Float.valueOf(r2.mo15090());
            this.f14301 = Integer.valueOf(r2.mo15091());
            this.f14289 = r2.mo15079();
            this.f14302 = Integer.valueOf(r2.mo15078());
            this.f14297 = Boolean.valueOf(r2.mo15087());
            this.f14300 = Boolean.valueOf(r2.mo15089());
            this.f14294 = Boolean.valueOf(r2.mo15086());
            this.f14292 = Integer.valueOf(r2.mo15083());
            this.f14298 = Integer.valueOf(r2.mo15081());
        }

        @Override // o.AbstractC0954.Cif
        /* renamed from: ˏ  reason: contains not printable characters */
        public AbstractC0954.Cif mo15102(int i) {
            this.f14296 = Integer.valueOf(i);
            return this;
        }

        @Override // o.AbstractC0954.Cif
        /* renamed from: ˊ  reason: contains not printable characters */
        public AbstractC0954.Cif mo15095(float f) {
            this.f14293 = Float.valueOf(f);
            return this;
        }

        @Override // o.AbstractC0954.Cif
        /* renamed from: ˊ  reason: contains not printable characters */
        public AbstractC0954.Cif mo15096(int i) {
            this.f14299 = Integer.valueOf(i);
            return this;
        }

        @Override // o.AbstractC0954.Cif
        /* renamed from: ˋ  reason: contains not printable characters */
        public AbstractC0954.Cif mo15098(int i) {
            this.f14291 = Integer.valueOf(i);
            return this;
        }

        @Override // o.AbstractC0954.Cif
        /* renamed from: ˎ  reason: contains not printable characters */
        public AbstractC0954.Cif mo15100(int i) {
            this.f14295 = Integer.valueOf(i);
            return this;
        }

        @Override // o.AbstractC0954.Cif
        /* renamed from: ॱ  reason: contains not printable characters */
        public AbstractC0954.Cif mo15106(int i) {
            this.f14290 = Integer.valueOf(i);
            return this;
        }

        @Override // o.AbstractC0954.Cif
        /* renamed from: ˋ  reason: contains not printable characters */
        public AbstractC0954.Cif mo15097(float f) {
            this.f14288 = Float.valueOf(f);
            return this;
        }

        @Override // o.AbstractC0954.Cif
        /* renamed from: ʽ  reason: contains not printable characters */
        public AbstractC0954.Cif mo15094(int i) {
            this.f14301 = Integer.valueOf(i);
            return this;
        }

        @Override // o.AbstractC0954.Cif
        /* renamed from: ˏ  reason: contains not printable characters */
        public AbstractC0954.Cif mo15103(RecyclerView.RecycledViewPool recycledViewPool) {
            this.f14289 = recycledViewPool;
            return this;
        }

        @Override // o.AbstractC0954.Cif
        /* renamed from: ᐝ  reason: contains not printable characters */
        public AbstractC0954.Cif mo15107(int i) {
            this.f14302 = Integer.valueOf(i);
            return this;
        }

        @Override // o.AbstractC0954.Cif
        /* renamed from: ˏ  reason: contains not printable characters */
        public AbstractC0954.Cif mo15104(boolean z) {
            this.f14297 = Boolean.valueOf(z);
            return this;
        }

        @Override // o.AbstractC0954.Cif
        /* renamed from: ˎ  reason: contains not printable characters */
        public AbstractC0954.Cif mo15101(boolean z) {
            this.f14300 = Boolean.valueOf(z);
            return this;
        }

        @Override // o.AbstractC0954.Cif
        /* renamed from: ˋ  reason: contains not printable characters */
        public AbstractC0954.Cif mo15099(boolean z) {
            this.f14294 = Boolean.valueOf(z);
            return this;
        }

        @Override // o.AbstractC0954.Cif
        /* renamed from: ʻ  reason: contains not printable characters */
        public AbstractC0954.Cif mo15092(int i) {
            this.f14292 = Integer.valueOf(i);
            return this;
        }

        @Override // o.AbstractC0954.Cif
        /* renamed from: ʼ  reason: contains not printable characters */
        public AbstractC0954.Cif mo15093(int i) {
            this.f14298 = Integer.valueOf(i);
            return this;
        }

        @Override // o.AbstractC0954.Cif
        /* renamed from: ˏ  reason: contains not printable characters */
        public AbstractC0954 mo15105() {
            String str = "";
            if (this.f14296 == null) {
                str = str + " numberOfItemsPerPage";
            }
            if (this.f14293 == null) {
                str = str + " aspectRatio";
            }
            if (this.f14299 == null) {
                str = str + " numberOfPagesToScrollOnFling";
            }
            if (this.f14291 == null) {
                str = str + " millisecondsPerInch";
            }
            if (this.f14295 == null) {
                str = str + " itemPadding";
            }
            if (this.f14290 == null) {
                str = str + " listPadding";
            }
            if (this.f14288 == null) {
                str = str + " peekRatio";
            }
            if (this.f14301 == null) {
                str = str + " maxHeight";
            }
            if (this.f14302 == null) {
                str = str + " viewType";
            }
            if (this.f14297 == null) {
                str = str + " freeScroll";
            }
            if (this.f14300 == null) {
                str = str + " lightTheme";
            }
            if (this.f14294 == null) {
                str = str + " hasCirclePlaceholder";
            }
            if (this.f14292 == null) {
                str = str + " rowCount";
            }
            if (this.f14298 == null) {
                str = str + " adjustStrategy";
            }
            if (str.isEmpty()) {
                return new C0733(this.f14296.intValue(), this.f14293.floatValue(), this.f14299.intValue(), this.f14291.intValue(), this.f14295.intValue(), this.f14290.intValue(), this.f14288.floatValue(), this.f14301.intValue(), this.f14289, this.f14302.intValue(), this.f14297.booleanValue(), this.f14300.booleanValue(), this.f14294.booleanValue(), this.f14292.intValue(), this.f14298.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}

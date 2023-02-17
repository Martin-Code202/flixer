package o;

import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.view.View;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
/* renamed from: o.ӌ  reason: contains not printable characters */
final class C0525 extends NetflixActionBar.iF {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final int f13678;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final String f13679;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final boolean f13680;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final boolean f13681;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final boolean f13682;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final View f13683;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final int f13684;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final int f13685;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final NetflixActionBar.LogoType f13686;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final Drawable f13687;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final CharSequence f13688;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final ActionBar.LayoutParams f13689;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private final CharSequence f13690;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private final int f13691;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final Drawable f13692;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final boolean f13693;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final int f13694;

    private C0525(CharSequence charSequence, boolean z, int i, int i2, int i3, boolean z2, Drawable drawable, String str, boolean z3, NetflixActionBar.LogoType logoType, View view, ActionBar.LayoutParams layoutParams, Drawable drawable2, boolean z4, CharSequence charSequence2, int i4, int i5) {
        this.f13688 = charSequence;
        this.f13682 = z;
        this.f13685 = i;
        this.f13684 = i2;
        this.f13678 = i3;
        this.f13693 = z2;
        this.f13692 = drawable;
        this.f13679 = str;
        this.f13680 = z3;
        this.f13686 = logoType;
        this.f13683 = view;
        this.f13689 = layoutParams;
        this.f13687 = drawable2;
        this.f13681 = z4;
        this.f13690 = charSequence2;
        this.f13691 = i4;
        this.f13694 = i5;
    }

    @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF
    /* renamed from: ˋ */
    public CharSequence mo373() {
        return this.f13688;
    }

    @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF
    /* renamed from: ˏ */
    public boolean mo376() {
        return this.f13682;
    }

    @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF
    /* renamed from: ˊ */
    public int mo371() {
        return this.f13685;
    }

    @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF
    /* renamed from: ˎ */
    public int mo375() {
        return this.f13684;
    }

    @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF
    /* renamed from: ॱ */
    public int mo379() {
        return this.f13678;
    }

    @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF
    /* renamed from: ʻ */
    public boolean mo368() {
        return this.f13693;
    }

    @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF
    /* renamed from: ᐝ */
    public Drawable mo383() {
        return this.f13692;
    }

    @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF
    /* renamed from: ʼ */
    public String mo369() {
        return this.f13679;
    }

    @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF
    /* renamed from: ʽ */
    public boolean mo370() {
        return this.f13680;
    }

    @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF
    /* renamed from: ॱॱ */
    public NetflixActionBar.LogoType mo382() {
        return this.f13686;
    }

    @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF
    /* renamed from: ॱˊ */
    public View mo380() {
        return this.f13683;
    }

    @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF
    /* renamed from: ˋॱ */
    public ActionBar.LayoutParams mo374() {
        return this.f13689;
    }

    @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF
    /* renamed from: ͺ */
    public Drawable mo378() {
        return this.f13687;
    }

    @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF
    /* renamed from: ˊॱ */
    public boolean mo372() {
        return this.f13681;
    }

    @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF
    /* renamed from: ˏॱ */
    public CharSequence mo377() {
        return this.f13690;
    }

    @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF
    /* renamed from: ॱˋ */
    public int mo381() {
        return this.f13691;
    }

    @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF
    /* renamed from: ᐝॱ */
    public int mo384() {
        return this.f13694;
    }

    public String toString() {
        return "State{title=" + ((Object) this.f13688) + ", titleVisible=" + this.f13682 + ", titleAlignment=" + this.f13685 + ", titleColor=" + this.f13684 + ", titleAppearance=" + this.f13678 + ", upActionVisible=" + this.f13693 + ", upDrawable=" + this.f13692 + ", upContentDescription=" + this.f13679 + ", logoVisible=" + this.f13680 + ", logoType=" + this.f13686 + ", customView=" + this.f13683 + ", customLayoutParams=" + this.f13689 + ", background=" + this.f13687 + ", hideOnScroll=" + this.f13681 + ", subtitle=" + ((Object) this.f13690) + ", subtitleColor=" + this.f13691 + ", subtitleAppearance=" + this.f13694 + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NetflixActionBar.iF)) {
            return false;
        }
        NetflixActionBar.iF iFVar = (NetflixActionBar.iF) obj;
        if (this.f13688 != null ? this.f13688.equals(iFVar.mo373()) : iFVar.mo373() == null) {
            if (this.f13682 == iFVar.mo376() && this.f13685 == iFVar.mo371() && this.f13684 == iFVar.mo375() && this.f13678 == iFVar.mo379() && this.f13693 == iFVar.mo368() && (this.f13692 != null ? this.f13692.equals(iFVar.mo383()) : iFVar.mo383() == null) && (this.f13679 != null ? this.f13679.equals(iFVar.mo369()) : iFVar.mo369() == null) && this.f13680 == iFVar.mo370() && this.f13686.equals(iFVar.mo382()) && (this.f13683 != null ? this.f13683.equals(iFVar.mo380()) : iFVar.mo380() == null) && (this.f13689 != null ? this.f13689.equals(iFVar.mo374()) : iFVar.mo374() == null) && (this.f13687 != null ? this.f13687.equals(iFVar.mo378()) : iFVar.mo378() == null) && this.f13681 == iFVar.mo372() && (this.f13690 != null ? this.f13690.equals(iFVar.mo377()) : iFVar.mo377() == null) && this.f13691 == iFVar.mo381() && this.f13694 == iFVar.mo384()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((1000003 ^ (this.f13688 == null ? 0 : this.f13688.hashCode())) * 1000003) ^ (this.f13682 ? 1231 : 1237)) * 1000003) ^ this.f13685) * 1000003) ^ this.f13684) * 1000003) ^ this.f13678) * 1000003) ^ (this.f13693 ? 1231 : 1237)) * 1000003) ^ (this.f13692 == null ? 0 : this.f13692.hashCode())) * 1000003) ^ (this.f13679 == null ? 0 : this.f13679.hashCode())) * 1000003) ^ (this.f13680 ? 1231 : 1237)) * 1000003) ^ this.f13686.hashCode()) * 1000003) ^ (this.f13683 == null ? 0 : this.f13683.hashCode())) * 1000003) ^ (this.f13689 == null ? 0 : this.f13689.hashCode())) * 1000003) ^ (this.f13687 == null ? 0 : this.f13687.hashCode())) * 1000003) ^ (this.f13681 ? 1231 : 1237)) * 1000003) ^ (this.f13690 == null ? 0 : this.f13690.hashCode())) * 1000003) ^ this.f13691) * 1000003) ^ this.f13694;
    }

    /* renamed from: o.ӌ$ˋ  reason: contains not printable characters */
    public static final class C0526 extends NetflixActionBar.iF.AbstractC0010 {

        /* renamed from: ʻ  reason: contains not printable characters */
        private Boolean f13695;

        /* renamed from: ʼ  reason: contains not printable characters */
        private NetflixActionBar.LogoType f13696;

        /* renamed from: ʽ  reason: contains not printable characters */
        private Boolean f13697;

        /* renamed from: ˊ  reason: contains not printable characters */
        private Boolean f13698;

        /* renamed from: ˊॱ  reason: contains not printable characters */
        private CharSequence f13699;

        /* renamed from: ˋ  reason: contains not printable characters */
        private Integer f13700;

        /* renamed from: ˋॱ  reason: contains not printable characters */
        private Drawable f13701;

        /* renamed from: ˎ  reason: contains not printable characters */
        private Integer f13702;

        /* renamed from: ˏ  reason: contains not printable characters */
        private Integer f13703;

        /* renamed from: ˏॱ  reason: contains not printable characters */
        private View f13704;

        /* renamed from: ͺ  reason: contains not printable characters */
        private Boolean f13705;

        /* renamed from: ॱ  reason: contains not printable characters */
        private CharSequence f13706;

        /* renamed from: ॱˊ  reason: contains not printable characters */
        private ActionBar.LayoutParams f13707;

        /* renamed from: ॱˋ  reason: contains not printable characters */
        private Integer f13708;

        /* renamed from: ॱˎ  reason: contains not printable characters */
        private Integer f13709;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        private String f13710;

        /* renamed from: ᐝ  reason: contains not printable characters */
        private Drawable f13711;

        @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF.AbstractC0010
        /* renamed from: ˎ */
        public NetflixActionBar.iF.AbstractC0010 mo394(CharSequence charSequence) {
            this.f13706 = charSequence;
            return this;
        }

        @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF.AbstractC0010
        /* renamed from: ˎ */
        public NetflixActionBar.iF.AbstractC0010 mo396(boolean z) {
            this.f13698 = Boolean.valueOf(z);
            return this;
        }

        @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF.AbstractC0010
        /* renamed from: ˊ */
        public NetflixActionBar.iF.AbstractC0010 mo386(int i) {
            this.f13702 = Integer.valueOf(i);
            return this;
        }

        @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF.AbstractC0010
        /* renamed from: ˎ */
        public NetflixActionBar.iF.AbstractC0010 mo393(int i) {
            this.f13700 = Integer.valueOf(i);
            return this;
        }

        @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF.AbstractC0010
        /* renamed from: ˏ */
        public NetflixActionBar.iF.AbstractC0010 mo397(int i) {
            this.f13703 = Integer.valueOf(i);
            return this;
        }

        @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF.AbstractC0010
        /* renamed from: ॱ */
        public NetflixActionBar.iF.AbstractC0010 mo403(boolean z) {
            this.f13695 = Boolean.valueOf(z);
            return this;
        }

        @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF.AbstractC0010
        /* renamed from: ˏ */
        public NetflixActionBar.iF.AbstractC0010 mo398(Drawable drawable) {
            this.f13711 = drawable;
            return this;
        }

        @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF.AbstractC0010
        /* renamed from: ˎ */
        public NetflixActionBar.iF.AbstractC0010 mo395(String str) {
            this.f13710 = str;
            return this;
        }

        @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF.AbstractC0010
        /* renamed from: ˏ */
        public NetflixActionBar.iF.AbstractC0010 mo399(boolean z) {
            this.f13697 = Boolean.valueOf(z);
            return this;
        }

        @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF.AbstractC0010
        /* renamed from: ॱ */
        public NetflixActionBar.iF.AbstractC0010 mo401(NetflixActionBar.LogoType logoType) {
            this.f13696 = logoType;
            return this;
        }

        @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF.AbstractC0010
        /* renamed from: ˋ */
        public NetflixActionBar.iF.AbstractC0010 mo391(View view) {
            this.f13704 = view;
            return this;
        }

        @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF.AbstractC0010
        /* renamed from: ˊ */
        public NetflixActionBar.iF.AbstractC0010 mo388(ActionBar.LayoutParams layoutParams) {
            this.f13707 = layoutParams;
            return this;
        }

        @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF.AbstractC0010
        /* renamed from: ˊ */
        public NetflixActionBar.iF.AbstractC0010 mo387(Drawable drawable) {
            this.f13701 = drawable;
            return this;
        }

        @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF.AbstractC0010
        /* renamed from: ˊ */
        public NetflixActionBar.iF.AbstractC0010 mo389(boolean z) {
            this.f13705 = Boolean.valueOf(z);
            return this;
        }

        @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF.AbstractC0010
        /* renamed from: ॱ */
        public NetflixActionBar.iF.AbstractC0010 mo402(CharSequence charSequence) {
            this.f13699 = charSequence;
            return this;
        }

        @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF.AbstractC0010
        /* renamed from: ˋ */
        public NetflixActionBar.iF.AbstractC0010 mo390(int i) {
            this.f13708 = Integer.valueOf(i);
            return this;
        }

        @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF.AbstractC0010
        /* renamed from: ॱ */
        public NetflixActionBar.iF.AbstractC0010 mo400(int i) {
            this.f13709 = Integer.valueOf(i);
            return this;
        }

        @Override // com.netflix.mediaclient.android.widget.NetflixActionBar.iF.AbstractC0010
        /* renamed from: ˋ */
        public NetflixActionBar.iF mo392() {
            String str = "";
            if (this.f13698 == null) {
                str = str + " titleVisible";
            }
            if (this.f13702 == null) {
                str = str + " titleAlignment";
            }
            if (this.f13700 == null) {
                str = str + " titleColor";
            }
            if (this.f13703 == null) {
                str = str + " titleAppearance";
            }
            if (this.f13695 == null) {
                str = str + " upActionVisible";
            }
            if (this.f13697 == null) {
                str = str + " logoVisible";
            }
            if (this.f13696 == null) {
                str = str + " logoType";
            }
            if (this.f13705 == null) {
                str = str + " hideOnScroll";
            }
            if (this.f13708 == null) {
                str = str + " subtitleColor";
            }
            if (this.f13709 == null) {
                str = str + " subtitleAppearance";
            }
            if (str.isEmpty()) {
                return new C0525(this.f13706, this.f13698.booleanValue(), this.f13702.intValue(), this.f13700.intValue(), this.f13703.intValue(), this.f13695.booleanValue(), this.f13711, this.f13710, this.f13697.booleanValue(), this.f13696, this.f13704, this.f13707, this.f13701, this.f13705.booleanValue(), this.f13699, this.f13708.intValue(), this.f13709.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }
}

package o;

import android.os.Bundle;
import com.firebase.jobdispatcher.ValidationEnforcer;
/* renamed from: o.ז  reason: contains not printable characters */
public final class C0552 implements AbstractC0639 {

    /* renamed from: ʼ  reason: contains not printable characters */
    private Bundle f13772;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final int[] f13773;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f13774;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final int f13775;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final C0986 f13776;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C0897 f13777;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final String f13778;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final boolean f13779;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final boolean f13780;

    private C0552(Cif ifVar) {
        this.f13778 = ifVar.f13787 != null ? ifVar.f13787.getName() : null;
        this.f13772 = ifVar.f13788;
        this.f13774 = ifVar.f13786;
        this.f13777 = ifVar.f13784;
        this.f13776 = ifVar.f13782;
        this.f13775 = ifVar.f13783;
        this.f13780 = ifVar.f13781;
        this.f13773 = ifVar.f13790 != null ? ifVar.f13790 : new int[0];
        this.f13779 = ifVar.f13789;
    }

    @Override // o.AbstractC0639
    /* renamed from: ॱ  reason: contains not printable characters */
    public int[] mo14607() {
        return this.f13773;
    }

    @Override // o.AbstractC0639
    /* renamed from: ˎ  reason: contains not printable characters */
    public Bundle mo14605() {
        return this.f13772;
    }

    @Override // o.AbstractC0639
    /* renamed from: ˊ  reason: contains not printable characters */
    public C0986 mo14603() {
        return this.f13776;
    }

    @Override // o.AbstractC0639
    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean mo14604() {
        return this.f13779;
    }

    @Override // o.AbstractC0639
    /* renamed from: ˏ  reason: contains not printable characters */
    public String mo14606() {
        return this.f13774;
    }

    @Override // o.AbstractC0639
    /* renamed from: ʻ  reason: contains not printable characters */
    public C0897 mo14601() {
        return this.f13777;
    }

    @Override // o.AbstractC0639
    /* renamed from: ᐝ  reason: contains not printable characters */
    public int mo14609() {
        return this.f13775;
    }

    @Override // o.AbstractC0639
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public boolean mo14608() {
        return this.f13780;
    }

    @Override // o.AbstractC0639
    /* renamed from: ʽ  reason: contains not printable characters */
    public String mo14602() {
        return this.f13778;
    }

    /* renamed from: o.ז$if  reason: invalid class name */
    public static final class Cif implements AbstractC0639 {

        /* renamed from: ʻ  reason: contains not printable characters */
        private boolean f13781 = false;

        /* renamed from: ʼ  reason: contains not printable characters */
        private C0986 f13782 = C0986.f15039;

        /* renamed from: ʽ  reason: contains not printable characters */
        private int f13783 = 1;

        /* renamed from: ˊ  reason: contains not printable characters */
        private C0897 f13784 = C0821.f14612;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final ValidationEnforcer f13785;

        /* renamed from: ˎ  reason: contains not printable characters */
        private String f13786;

        /* renamed from: ˏ  reason: contains not printable characters */
        private Class<? extends AbstractServiceC0766> f13787;

        /* renamed from: ॱ  reason: contains not printable characters */
        private Bundle f13788;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        private boolean f13789 = false;

        /* renamed from: ᐝ  reason: contains not printable characters */
        private int[] f13790;

        Cif(ValidationEnforcer validationEnforcer) {
            this.f13785 = validationEnforcer;
        }

        /* renamed from: ʼ  reason: contains not printable characters */
        public C0552 m14619() {
            this.f13785.m94(this);
            return new C0552(this);
        }

        @Override // o.AbstractC0639
        /* renamed from: ʽ */
        public String mo14602() {
            return this.f13787.getName();
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public Cif m14622(Class<? extends AbstractServiceC0766> cls) {
            this.f13787 = cls;
            return this;
        }

        @Override // o.AbstractC0639
        /* renamed from: ˏ */
        public String mo14606() {
            return this.f13786;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public Cif m14621(String str) {
            this.f13786 = str;
            return this;
        }

        @Override // o.AbstractC0639
        /* renamed from: ʻ */
        public C0897 mo14601() {
            return this.f13784;
        }

        @Override // o.AbstractC0639
        /* renamed from: ᐝ */
        public int mo14609() {
            return this.f13783;
        }

        @Override // o.AbstractC0639
        /* renamed from: ॱॱ */
        public boolean mo14608() {
            return this.f13781;
        }

        @Override // o.AbstractC0639
        /* renamed from: ॱ */
        public int[] mo14607() {
            return this.f13790 == null ? new int[0] : this.f13790;
        }

        @Override // o.AbstractC0639
        /* renamed from: ˎ */
        public Bundle mo14605() {
            return this.f13788;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public Cif m14620(Bundle bundle) {
            this.f13788 = bundle;
            return this;
        }

        @Override // o.AbstractC0639
        /* renamed from: ˊ */
        public C0986 mo14603() {
            return this.f13782;
        }

        @Override // o.AbstractC0639
        /* renamed from: ˋ */
        public boolean mo14604() {
            return this.f13789;
        }
    }
}

package o;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.model.leafs.advisory.ExpiringContentAdvisory;
import io.reactivex.subjects.PublishSubject;
import o.xF;
/* renamed from: o.yw  reason: case insensitive filesystem */
public class C2358yw extends yJ implements AbstractC2343yh {

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final C0311 f12507 = new C0311(null);

    /* renamed from: ʻ  reason: contains not printable characters */
    private final TextView f12508;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final DecelerateInterpolator f12509 = new DecelerateInterpolator();

    /* renamed from: ʽ  reason: contains not printable characters */
    private final View f12510;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final View f12511;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final View f12512;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final View f12513;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private boolean f12514;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final AccelerateInterpolator f12515 = new AccelerateInterpolator();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final PublishSubject<xJ> f12516;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final ViewGroup f12517;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final int f12518 = this.f12517.getResources().getDimensionPixelSize(R.dimen.content_advisory_translation_y);

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final TextView f12519;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2358yw(ViewGroup viewGroup) {
        super(viewGroup);
        C1457Fr.m5025(viewGroup, "parent");
        this.f12517 = viewGroup;
        View inflate = LayoutInflater.from(this.f12517.getContext()).inflate(R.layout.two_line_advisory_layout, this.f12517, true);
        C1457Fr.m5016((Object) inflate, "LayoutInflater.from(pare…ory_layout, parent, true)");
        this.f12513 = inflate;
        View findViewById = this.f12513.findViewById(R.id.content_advisory_container);
        C1457Fr.m5016((Object) findViewById, "rootUI.findViewById(R.id…ntent_advisory_container)");
        this.f12512 = findViewById;
        PublishSubject<xJ> create = PublishSubject.create();
        C1457Fr.m5016((Object) create, "PublishSubject.create<PlayerUIEvent>()");
        this.f12516 = create;
        View findViewById2 = this.f12513.findViewById(R.id.view_netflix_bar);
        C1457Fr.m5016((Object) findViewById2, "rootUI.findViewById(R.id.view_netflix_bar)");
        this.f12511 = findViewById2;
        View findViewById3 = this.f12513.findViewById(R.id.content_advisory);
        C1457Fr.m5016((Object) findViewById3, "rootUI.findViewById(R.id.content_advisory)");
        this.f12510 = findViewById3;
        View findViewById4 = this.f12513.findViewById(R.id.message);
        C1457Fr.m5016((Object) findViewById4, "rootUI.findViewById(R.id.message)");
        this.f12508 = (TextView) findViewById4;
        View findViewById5 = this.f12513.findViewById(R.id.secondary_message);
        C1457Fr.m5016((Object) findViewById5, "rootUI.findViewById(R.id.secondary_message)");
        this.f12519 = (TextView) findViewById5;
    }

    @Override // o.yJ
    public View aj_() {
        return this.f12512;
    }

    /* renamed from: o.yw$ˊ  reason: contains not printable characters */
    public static final class C0311 {
        private C0311() {
        }

        public /* synthetic */ C0311(C1456Fq fq) {
            this();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public PublishSubject<xJ> mo13082() {
        return this.f12516;
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ʽ */
    public void mo13079() {
        aj_().setVisibility(8);
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ॱॱ */
    public void mo13088() {
        aj_().setVisibility(0);
    }

    @Override // o.AbstractC2343yh
    /* renamed from: ˊ */
    public void mo13336(String str) {
        C1457Fr.m5025(str, "text");
        this.f12508.setText(str);
    }

    @Override // o.AbstractC2343yh
    /* renamed from: ˋ */
    public void mo13337(String str) {
        C1457Fr.m5025(str, "text");
        this.f12514 = !C1457Fr.m5018((Object) str, (Object) "");
        this.f12519.setText(str);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m13362() {
        this.f12511.setTranslationY((float) this.f12511.getMeasuredHeight());
        this.f12508.setTranslationY((float) this.f12518);
        if (this.f12514) {
            this.f12519.setTranslationY((float) this.f12518);
        }
        this.f12510.setTranslationY((float) this.f12518);
    }

    @Override // o.AbstractC2343yh
    /* renamed from: ॱ */
    public void mo13341(boolean z, String str) {
        C1457Fr.m5025(str, "videoId");
        mo13088();
        m13362();
        this.f12510.setAlpha(1.0f);
        this.f12511.setAlpha(1.0f);
        this.f12511.animate().translationYBy((float) (-this.f12511.getMeasuredHeight())).setInterpolator(this.f12509).setDuration(660);
        this.f12508.animate().alpha(1.0f).translationYBy((float) (-this.f12518)).setInterpolator(this.f12509).setDuration(660);
        if (this.f12514) {
            this.f12519.animate().alpha(1.0f).translationYBy((float) (-this.f12518)).setInterpolator(this.f12509).setDuration(660);
        }
        this.f12510.animate().translationYBy((float) (-this.f12518)).setInterpolator(this.f12509).setDuration(660).withEndAction(new RunnableC0312(this, z, str));
    }

    /* renamed from: o.yw$ˋ  reason: contains not printable characters */
    static final class RunnableC0312 implements Runnable {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ String f12523;

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ C2358yw f12524;

        /* renamed from: ॱ  reason: contains not printable characters */
        final /* synthetic */ boolean f12525;

        RunnableC0312(C2358yw ywVar, boolean z, String str) {
            this.f12524 = ywVar;
            this.f12525 = z;
            this.f12523 = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f12525) {
                this.f12524.f12516.onNext(new xF.C0261(this.f12523, ExpiringContentAdvisory.ContentAction.LOG_WHEN_SHOWN));
            }
        }
    }

    @Override // o.AbstractC2343yh
    /* renamed from: ˎ */
    public void mo13339(boolean z, String str) {
        C1457Fr.m5025(str, "videoId");
        this.f12511.animate().translationYBy((float) (-this.f12511.getMeasuredHeight())).setInterpolator(this.f12515).setDuration(400);
        this.f12508.animate().alpha(0.0f).translationYBy((float) (-this.f12518)).setInterpolator(this.f12515).setDuration(500);
        if (this.f12514) {
            this.f12519.animate().alpha(0.0f).translationYBy((float) (-this.f12518)).setInterpolator(this.f12515).setDuration(500);
        }
        this.f12510.animate().translationYBy((float) (-this.f12518)).setInterpolator(this.f12515).setDuration(833).withEndAction(new If(this, z, str));
    }

    /* renamed from: o.yw$If */
    static final class If implements Runnable {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ String f12520;

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ C2358yw f12521;

        /* renamed from: ॱ  reason: contains not printable characters */
        final /* synthetic */ boolean f12522;

        If(C2358yw ywVar, boolean z, String str) {
            this.f12521 = ywVar;
            this.f12522 = z;
            this.f12520 = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f12522) {
                this.f12521.f12516.onNext(new xF.C0261(this.f12520, ExpiringContentAdvisory.ContentAction.NEVER_SHOW_AGAIN));
            }
            this.f12521.m13360();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ᐝ  reason: contains not printable characters */
    private final void m13360() {
        this.f12510.setAlpha(0.0f);
        this.f12511.setAlpha(0.0f);
        this.f12511.setTranslationY(0.0f);
        this.f12508.setTranslationY(0.0f);
        if (this.f12514) {
            this.f12519.setTranslationY(0.0f);
        }
        this.f12510.setTranslationY(0.0f);
    }

    @Override // o.AbstractC2343yh
    /* renamed from: ˎ */
    public void mo13338() {
        this.f12511.animate().cancel();
        this.f12508.animate().cancel();
        if (this.f12514) {
            this.f12519.animate().cancel();
        }
        this.f12510.animate().cancel();
    }

    @Override // o.AbstractC2343yh
    /* renamed from: ˏ */
    public long mo13340() {
        return 660;
    }
}

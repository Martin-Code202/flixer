package o;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.LinearLayout;
import com.netflix.mediaclient.R;
import io.reactivex.subjects.PublishSubject;
import java.nio.ByteBuffer;
public final class yH extends yJ implements AbstractC2345yj {

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final iF f12376 = new iF(null);

    /* renamed from: ʻ  reason: contains not printable characters */
    private final C0553 f12377;

    /* renamed from: ʼ  reason: contains not printable characters */
    private qB f12378;

    /* renamed from: ʽ  reason: contains not printable characters */
    private ViewPropertyAnimator f12379;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final View f12380;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final C0716 f12381;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final LinearLayout f12382;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final ViewGroup f12383;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final ViewGroup f12384;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private qB f12385;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final int f12386;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public yH(ViewGroup viewGroup) {
        super(viewGroup);
        C1457Fr.m5025(viewGroup, "parent");
        this.f12383 = viewGroup;
        View inflate = LayoutInflater.from(this.f12383.getContext()).inflate(R.layout.player_seekbar_bif, this.f12383, true);
        C1457Fr.m5016((Object) inflate, "LayoutInflater.from(pare…eekbar_bif, parent, true)");
        this.f12380 = inflate;
        View findViewById = this.f12380.findViewById(R.id.player_seekbar_bif_container);
        C1457Fr.m5016((Object) findViewById, "rootUI.findViewById(R.id…er_seekbar_bif_container)");
        this.f12384 = (ViewGroup) findViewById;
        View findViewById2 = aj_().findViewById(R.id.bif_current_time_label);
        C1457Fr.m5016((Object) findViewById2, "uiView.findViewById(R.id.bif_current_time_label)");
        this.f12381 = (C0716) findViewById2;
        View findViewById3 = aj_().findViewById(R.id.bif_image_view_container);
        C1457Fr.m5016((Object) findViewById3, "uiView.findViewById(R.id.bif_image_view_container)");
        this.f12382 = (LinearLayout) findViewById3;
        View findViewById4 = aj_().findViewById(R.id.bif_image_view);
        C1457Fr.m5016((Object) findViewById4, "uiView.findViewById(R.id.bif_image_view)");
        this.f12377 = (C0553) findViewById4;
        Context context = this.f12383.getContext();
        C1457Fr.m5016((Object) context, "parent.context");
        this.f12386 = (int) context.getResources().getDimension(R.dimen.player_big_margin_bottom);
    }

    public static final class iF {
        private iF() {
        }

        public /* synthetic */ iF(C1456Fq fq) {
            this();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public ViewGroup aj_() {
        return this.f12384;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public PublishSubject<xJ> mo13082() {
        PublishSubject<xJ> create = PublishSubject.create();
        C1457Fr.m5016((Object) create, "PublishSubject.create<PlayerUIEvent>()");
        return create;
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ॱॱ */
    public void mo13088() {
        aj_().setVisibility(0);
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ʽ */
    public void mo13079() {
        mo13133();
        m13131();
    }

    @Override // o.yJ
    public int ai_() {
        return aj_().getId();
    }

    @Override // o.AbstractC2345yj
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo13136(String str, int i) {
        C1457Fr.m5025(str, "bifCurrentTime");
        this.f12381.setText(str);
        this.f12381.setTranslationX((float) m13130(this.f12381, i));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private final int m13130(View view, int i) {
        Window window;
        View decorView;
        view.measure(0, 0);
        int paddingStart = aj_().getPaddingStart();
        int paddingEnd = aj_().getPaddingEnd();
        int measuredWidth = (i - (view.getMeasuredWidth() / 2)) + paddingStart;
        Activity activity = (Activity) C0345.m13893(this.f12383.getContext(), Activity.class);
        Integer valueOf = (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) ? null : Integer.valueOf(decorView.getMeasuredWidth());
        if (measuredWidth < 0 || valueOf == null) {
            return 0;
        }
        if (C1457Fr.m5021(view.getMeasuredWidth() + measuredWidth + paddingStart + paddingEnd, valueOf.intValue()) > 0) {
            return (valueOf.intValue() - view.getMeasuredWidth()) - paddingEnd;
        }
        return measuredWidth;
    }

    @Override // o.AbstractC2345yj
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo13134(ByteBuffer byteBuffer, int i) {
        C1457Fr.m5025(byteBuffer, "byteBufferForBif");
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit());
        if (decodeByteArray != null) {
            this.f12377.setImageBitmap(decodeByteArray);
        }
        this.f12382.setTranslationX((float) m13130(this.f12382, i));
    }

    @Override // o.AbstractC2345yj
    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean mo13132() {
        return this.f12382.getVisibility() == 0;
    }

    @Override // o.AbstractC2345yj
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo13137() {
        BQ.m3916(this.f12382, true);
    }

    @Override // o.AbstractC2345yj
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo13133() {
        if (this.f12379 != null) {
            ViewPropertyAnimator viewPropertyAnimator = this.f12379;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
            }
            this.f12379 = null;
            this.f12382.setAlpha(0.0f);
            return;
        }
        BQ.m3916(this.f12382, false);
    }

    @Override // o.AbstractC2345yj
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo13138() {
        C1283.m16854("PlayerSeekbarUIView", "Show Current time label");
        BQ.m3916(this.f12381, true);
        C1283.m16854("PlayerSeekbarUIView", "Animate UP the elevation of Current time Label");
        if (this.f12385 == null) {
            this.f12385 = new qB(this.f12381, 0, -this.f12386);
        }
        qB qBVar = this.f12385;
        if (qBVar != null) {
            qBVar.m9860();
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m13131() {
        qB qBVar;
        C1283.m16854("PlayerSeekbarUIView", "Animate DOWN the elevation of Current time Label");
        if (this.f12385 == null || (qBVar = this.f12385) == null || !qBVar.m9859()) {
            if (this.f12378 == null) {
                this.f12378 = new qB(this.f12381, -this.f12386, 0);
            }
            qB qBVar2 = this.f12378;
            if (qBVar2 != null) {
                qBVar2.m9860();
            }
        } else {
            C1283.m16854("PlayerSeekbarUIView", "Animate UP elevation Current Time label is not complete yet - cancelling it");
            qB qBVar3 = this.f12385;
            if (qBVar3 != null) {
                qBVar3.m9862();
            }
            this.f12381.setTranslationY(0.0f);
        }
        C1283.m16854("PlayerSeekbarUIView", "Hide Current time label");
        BQ.m3916(this.f12381, false);
    }
}

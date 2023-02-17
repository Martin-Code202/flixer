package o;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import io.reactivex.subjects.PublishSubject;
import o.xJ;
public final class yM extends yJ implements AbstractC2353yr {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final PublishSubject<xJ> f12395;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final View f12396;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final View f12397;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public yM(ViewGroup viewGroup) {
        super(viewGroup);
        C1457Fr.m5025(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.player_tappable_view, (ViewGroup) null, false);
        C1457Fr.m5016((Object) inflate, "LayoutInflater.from(pare…ppable_view, null, false)");
        this.f12397 = inflate;
        View findViewById = this.f12397.findViewById(R.id.player_tappable_view);
        C1457Fr.m5016((Object) findViewById, "rootUI.findViewById(R.id.player_tappable_view)");
        this.f12396 = findViewById;
        PublishSubject<xJ> create = PublishSubject.create();
        C1457Fr.m5016((Object) create, "PublishSubject.create<PlayerUIEvent>()");
        this.f12395 = create;
        viewGroup.addView(this.f12397, 1);
        aj_().setOnTouchListener(new View.OnTouchListener(this, viewGroup) { // from class: o.yM.2

            /* renamed from: ˊ  reason: contains not printable characters */
            private final ScaleGestureDetector f12398 = new ScaleGestureDetector(NetflixApplication.getInstance(), new iF(this));

            /* renamed from: ˋ  reason: contains not printable characters */
            final /* synthetic */ yM f12399;

            /* renamed from: ˎ  reason: contains not printable characters */
            private final GestureDetector f12400;

            /* renamed from: ˏ  reason: contains not printable characters */
            final /* synthetic */ ViewGroup f12401;

            /* renamed from: o.yM$2$ˋ  reason: contains not printable characters */
            public static final class C0301 extends GestureDetector.SimpleOnGestureListener {

                /* renamed from: ˋ  reason: contains not printable characters */
                private final int f12405 = 20;

                /* renamed from: ˏ  reason: contains not printable characters */
                private final int f12406 = C1004.m15954(NetflixApplication.getInstance(), this.f12405);

                /* renamed from: ॱ  reason: contains not printable characters */
                final /* synthetic */ AnonymousClass2 f12407;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                C0301(AnonymousClass2 r3) {
                    this.f12407 = r3;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    C1457Fr.m5025(motionEvent, "event");
                    this.f12407.f12399.f12395.onNext(xJ.C0280.f12028);
                    return true;
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public boolean onDoubleTap(MotionEvent motionEvent) {
                    Window window;
                    View decorView;
                    C1457Fr.m5025(motionEvent, "event");
                    Activity activity = (Activity) C0345.m13893(this.f12407.f12401.getContext(), Activity.class);
                    if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
                        return false;
                    }
                    int measuredWidth = decorView.getMeasuredWidth();
                    if (motionEvent.getX() < ((float) ((measuredWidth / 2) - this.f12406))) {
                        this.f12407.f12399.f12395.onNext(new xJ.Con(true));
                        return true;
                    } else if (motionEvent.getX() <= ((float) ((measuredWidth / 2) + this.f12406))) {
                        return false;
                    } else {
                        this.f12407.f12399.f12395.onNext(new xJ.Con(false));
                        return true;
                    }
                }
            }

            {
                this.f12399 = r4;
                this.f12401 = r5;
                this.f12400 = new GestureDetector(r5.getContext(), new C0301(this));
            }

            /* renamed from: o.yM$2$iF */
            public static final class iF implements ScaleGestureDetector.OnScaleGestureListener {

                /* renamed from: ˋ  reason: contains not printable characters */
                final /* synthetic */ AnonymousClass2 f12402;

                /* renamed from: ˎ  reason: contains not printable characters */
                private float f12403;

                /* renamed from: ॱ  reason: contains not printable characters */
                private float f12404;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                iF(AnonymousClass2 r1) {
                    this.f12402 = r1;
                }

                @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
                public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                    C1457Fr.m5025(scaleGestureDetector, "detector");
                    this.f12404 = scaleGestureDetector.getScaleFactor();
                    return true;
                }

                @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
                public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                    C1457Fr.m5025(scaleGestureDetector, "detector");
                    this.f12403 = scaleGestureDetector.getScaleFactor();
                    return true;
                }

                @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
                public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
                    C1457Fr.m5025(scaleGestureDetector, "detector");
                    if (this.f12403 > this.f12404) {
                        this.f12402.f12399.f12395.onNext(xJ.C0287.f12038);
                    } else {
                        this.f12402.f12399.f12395.onNext(xJ.IF.f12017);
                    }
                }
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                C1457Fr.m5025(view, "view");
                C1457Fr.m5025(motionEvent, "event");
                this.f12400.onTouchEvent(motionEvent);
                this.f12398.onTouchEvent(motionEvent);
                view.performClick();
                return true;
            }
        });
    }

    @Override // o.yJ
    public View aj_() {
        return this.f12396;
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ॱॱ */
    public void mo13088() {
    }

    @Override // o.AbstractC2351yp
    /* renamed from: ʽ */
    public void mo13079() {
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public PublishSubject<xJ> mo13082() {
        return this.f12395;
    }

    @Override // o.AbstractC2353yr
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo13218() {
        this.f12395.onNext(xJ.C2298If.f12018);
    }

    @Override // o.AbstractC2353yr
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo13220() {
        this.f12395.onNext(xJ.C2300auX.f12021);
    }

    @Override // o.AbstractC2353yr
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo13219(boolean z, boolean z2) {
        this.f12395.onNext(new xJ.C2299aUx(z, z2));
    }
}

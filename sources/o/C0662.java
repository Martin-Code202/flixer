package o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
/* renamed from: o.ব  reason: contains not printable characters */
public final class C0662 extends LottieAnimationView {

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private static final int f14008 = 1;

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final C0663 f14009 = new C0663(null);

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private static final String f14010 = f14010;

    /* renamed from: ʻ  reason: contains not printable characters */
    private List<C0926> f14011;

    /* renamed from: ʼ  reason: contains not printable characters */
    private int f14012;

    /* renamed from: ʽ  reason: contains not printable characters */
    private int f14013;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int[] f14014;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private AbstractC0664 f14015;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final GestureDetectorCompat f14016;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Paint f14017;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C0676 f14018;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private float f14019;

    /* renamed from: ͺ  reason: contains not printable characters */
    private AnimatorListenerAdapter f14020;

    /* renamed from: ॱ  reason: contains not printable characters */
    private List<C0926> f14021;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private boolean f14022;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private boolean f14023;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private Rect f14024;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private int f14025;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private float f14026;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private int f14027;

    /* renamed from: o.ব$ˋ  reason: contains not printable characters */
    public interface AbstractC0664 {
        /* renamed from: ˎ  reason: contains not printable characters */
        void mo14857(String str);

        /* renamed from: ॱ  reason: contains not printable characters */
        void mo14858(String str);
    }

    public C0662(Context context) {
        this(context, null, 0, 6, null);
    }

    public C0662(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0662(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C1457Fr.m5025(context, "context");
        this.f14017 = new Paint();
        this.f14014 = new int[2];
        this.f14021 = new ArrayList();
        this.f14011 = new ArrayList();
        this.f14024 = new Rect();
        this.f14017.setColor(-16711936);
        this.f14017.setStyle(Paint.Style.STROKE);
        this.f14017.setStrokeWidth(1.5f);
        this.f14016 = new GestureDetectorCompat(context, new Cif(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0662(Context context, AttributeSet attributeSet, int i, int i2, C1456Fq fq) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @SuppressLint({"RestrictedApi"})
    /* renamed from: o.ব$ˊ  reason: contains not printable characters */
    public static final class C0663 {
        private C0663() {
        }

        public /* synthetic */ C0663(C1456Fq fq) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ॱ  reason: contains not printable characters */
        private final String m14856() {
            return C0662.f14010;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˏ  reason: contains not printable characters */
        private final int m14855() {
            return C0662.f14008;
        }
    }

    @SuppressLint({"RestrictedApi"})
    public final void setNetflixLottieComposition(Context context, C0676 r20) {
        C1457Fr.m5025(context, "context");
        C1457Fr.m5025(r20, "sceneModel");
        setComposition(r20.m14912());
        for (T t : r20.m14913()) {
            this.f14021.add(C0926.m15733(t, null, 0, 0, 0, 0, new Rect(t.m15740()), 31, null));
            this.f14011.add(C0926.m15733(t, null, 0, 0, 0, 0, new Rect(t.m15740()), 31, null));
        }
        Rect r0 = r20.m14912().m14263();
        C1457Fr.m5016((Object) r0, "sceneModel.composition.bounds");
        this.f14024 = r0;
        this.f14013 = r20.m14914().optInt("w");
        this.f14012 = r20.m14914().optInt("h");
        this.f14025 = (int) ((r20.m14912().m14257() * 1000.0f) / ((float) r20.m14912().m14267()));
        this.f14027 = (int) ((r20.m14912().m14268() - r20.m14912().m14269()) + 1);
        C1283.m16854(f14009.m14856(), "composition - " + r20.m14912().m14269() + " -> " + r20.m14912().m14268() + ", duration = " + r20.m14912().m14267() + ", durationFrames=" + r20.m14912().m14257());
        Point point = new Point();
        Object systemService = context.getSystemService("window");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
        }
        ((WindowManager) systemService).getDefaultDisplay().getSize(point);
        setScale(Math.min(((float) point.x) / ((float) r20.m14912().m14263().width()), 1.0f));
        this.f14018 = r20;
    }

    /* renamed from: o.ব$if  reason: invalid class name */
    static final class Cif extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: ॱ  reason: contains not printable characters */
        private final C0662 f14030;

        public Cif(C0662 r2) {
            C1457Fr.m5025(r2, "netflixLottieAnimationView");
            this.f14030 = r2;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            C1457Fr.m5025(motionEvent, "e");
            return this.f14030.m14838(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            C1457Fr.m5025(motionEvent, "e");
            return this.f14030.m14847(motionEvent);
        }
    }

    public final void setAnimationListener(AbstractC0664 r1) {
        this.f14015 = r1;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public final AbstractC0664 m14852() {
        return this.f14015;
    }

    public final void setShowTapAreaBorder(boolean z) {
        this.f14022 = z;
    }

    public final void setTotalNumFrames(int i) {
        this.f14027 = i;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public final int m14844() {
        return this.f14027;
    }

    public final void setTargetFps(int i) {
        this.f14025 = i;
    }

    public final void setResetViewScaleFactor(boolean z) {
        this.f14023 = z;
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public final int m14849() {
        return (int) (m17() * ((float) this.f14027));
    }

    public final void setStartingFrame(int i) {
        setProgress(((float) (f14009.m14855() + i)) / ((float) this.f14027));
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = ((float) getWidth()) / ((float) this.f14013);
        float height = ((float) getHeight()) / ((float) this.f14012);
        if (!(this.f14026 == width && this.f14019 == height && !this.f14023)) {
            this.f14026 = width;
            this.f14019 = height;
            C1283.m16854(f14009.m14856(), "Updating scaleCompensatedTapList - " + this.f14021.size() + " --> " + this.f14011.size());
            int i = 0;
            for (T t : this.f14021) {
                i++;
                this.f14011.get(i).m15740().left = (int) (((float) t.m15740().left) * this.f14026);
                this.f14011.get(i).m15740().right = (int) (((float) t.m15740().right) * this.f14026);
                this.f14011.get(i).m15740().top = (int) (((float) t.m15740().top) * this.f14019);
                this.f14011.get(i).m15740().bottom = (int) (((float) t.m15740().bottom) * this.f14019);
            }
            this.f14023 = false;
        }
        if (this.f14022) {
            for (C0926 r5 : this.f14011) {
                if (canvas != null) {
                    canvas.drawRect(r5.m15740(), this.f14017);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private final boolean m14838(MotionEvent motionEvent) {
        getLocationOnScreen(this.f14014);
        return m14836(this, m14837(motionEvent.getRawX() - ((float) this.f14014[0]), motionEvent.getRawY() - ((float) this.f14014[1])), 0, 2, null);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        C1457Fr.m5025(motionEvent, "event");
        return this.f14016.onTouchEvent(motionEvent);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final boolean m14847(MotionEvent motionEvent) {
        C1457Fr.m5025(motionEvent, "event");
        return m14846(motionEvent) != null;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final C0926 m14846(MotionEvent motionEvent) {
        C1457Fr.m5025(motionEvent, "event");
        getLocationOnScreen(this.f14014);
        return m14837(motionEvent.getRawX() - ((float) this.f14014[0]), motionEvent.getRawY() - ((float) this.f14014[1]));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final C0926 m14845(float f, float f2) {
        getLocationOnScreen(this.f14014);
        return m14837(f - ((float) this.f14014[0]), f2 - ((float) this.f14014[1]));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static /* synthetic */ boolean m14843(C0662 r1, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        return r1.m14848(str, i);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final boolean m14848(String str, int i) {
        C1457Fr.m5025(str, "tag");
        return m14839(m14851(str), i);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    static /* synthetic */ boolean m14836(C0662 r1, C0926 r2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        return r1.m14839(r2, i);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private final boolean m14839(C0926 r3, int i) {
        if (r3 == null) {
            return false;
        }
        m15(this.f14020);
        this.f14020 = new If(this, r3);
        m12(this.f14020);
        m14835(i != -1 ? r3.m15737() + i : r3.m15737(), r3.m15736());
        AbstractC0664 r0 = this.f14015;
        if (r0 == null) {
            return true;
        }
        r0.mo14857(r3.m15734());
        return true;
    }

    /* renamed from: o.ব$If */
    public static final class If extends AnimatorListenerAdapter {

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ C0926 f14028;

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ C0662 f14029;

        If(C0662 r1, C0926 r2) {
            this.f14029 = r1;
            this.f14028 = r2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC0664 r0 = this.f14029.m14852();
            if (r0 != null) {
                r0.mo14858(this.f14028.m15734());
            }
            C1283.m16854(C0662.f14009.m14856(), "onEnd = " + this.f14029.m14849());
            int r02 = this.f14029.m14844();
            int r3 = this.f14028.m15735();
            if (0 <= r3 && r02 >= r3) {
                this.f14029.setMinAndMaxFrame(0, this.f14029.m14844());
                this.f14029.setStartingFrame(this.f14028.m15735());
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private final void m14835(int i, int i2) {
        C1283.m16854(f14009.m14856(), "playing animation between " + i + " -> " + i2);
        m7(f14009.m14855() + i, i2);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C0926 m14837(float f, float f2) {
        int r3 = m14849();
        for (C0926 r4 : this.f14011) {
            if (r4.m15738() == r3 && r4.m15740().contains((int) f, (int) f2)) {
                return r4;
            }
        }
        return null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final C0926 m14851(String str) {
        C1457Fr.m5025(str, "tag");
        C1283.m16854(f14009.m14856(), "getValidTapItemByTag: checking for frame " + str + " in list -> " + this.f14011.size());
        for (C0926 r5 : this.f14011) {
            if (Ge.m5105(r5.m15734(), str, false, 2, null)) {
                C1283.m16854(f14009.m14856(), "getValidTapItemByTag: found " + r5.m15734() + " => " + r5);
                return r5;
            }
        }
        C1283.m16854(f14009.m14856(), "getValidTapItemByTag: not found " + str);
        return null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static /* synthetic */ List m14841(C0662 r1, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = r1.m14849();
        }
        return r1.m14850(i);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final List<C0926> m14850(int i) {
        List<C0926> list = this.f14011;
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            if (i == t.m15738()) {
                arrayList.add(t);
            }
        }
        return EI.m4841((Iterable) arrayList);
    }

    /* access modifiers changed from: protected */
    @Override // com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m6();
        if (this.f14020 != null) {
            m15(this.f14020);
        }
    }
}

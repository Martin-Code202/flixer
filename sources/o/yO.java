package o;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UiLocation;
import com.netflix.mediaclient.servicemgr.interface_.LoMoType;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.WeakHashMap;
import o.C1348Bu;
import org.json.JSONObject;
public final class yO {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final boolean f12410 = false;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final yO f12411 = new yO();

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final int[] f12412 = new int[2];

    private yO() {
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final RecyclerView.OnScrollListener m13227() {
        return C0302.f12419.m13238();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    static /* synthetic */ void m13230(yO yOVar, Context context, yQ yQVar, AbstractC2072pu puVar, JSONObject jSONObject, int i, AppView appView, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            appView = AppView.boxArt;
        }
        yOVar.m13228(context, yQVar, puVar, jSONObject, i, appView);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private final void m13228(Context context, yQ yQVar, AbstractC2072pu puVar, JSONObject jSONObject, int i, AppView appView) {
        AbstractC2087qh r11;
        Integer r13;
        AbstractC2063pl r0;
        C1464Fy fy = C1464Fy.f5682;
        Locale locale = Locale.US;
        C1457Fr.m5016((Object) locale, "Locale.US");
        Object[] objArr = {yQVar.mo11031(), puVar.getId(), Integer.valueOf(i)};
        int length = objArr.length;
        String format = String.format(locale, "%s-%s-%d", Arrays.copyOf(objArr, 3));
        C1457Fr.m5016((Object) format, "java.lang.String.format(locale, format, *args)");
        NetflixActivity netflixActivity = (NetflixActivity) C0345.m13893(context, NetflixActivity.class);
        if (netflixActivity != null && !C1317As.m3750(netflixActivity)) {
            C2059ph serviceManager = netflixActivity.getServiceManager();
            C1457Fr.m5016((Object) serviceManager, "serviceManager");
            if (serviceManager.mo9519() && (r11 = yQVar.mo11028()) != null && (r13 = yQVar.mo11031()) != null) {
                int intValue = r13.intValue();
                if (VideoType.isPresentationTrackingType(puVar.getType())) {
                    String str = null;
                    if (r11 instanceof AbstractC2071pt) {
                        if (LoMoType.m1572(((AbstractC2071pt) r11).getType()) && (puVar instanceof pJ)) {
                            str = ((pJ) puVar).getBoxartId();
                        } else if (C1457Fr.m5018(LoMoType.ROAR, ((AbstractC2071pt) r11).getType()) && (puVar instanceof CH)) {
                            str = ((CH) puVar).getTallPanelArtImageTypeIdentifier();
                        }
                        C1283.m16854("VideoPresentationTracking", "Tracking [" + format + "] " + puVar.getTitle() + " in " + ((AbstractC2071pt) r11).getTitle() + " (" + ((AbstractC2071pt) r11).getClass().getName() + ')');
                    } else {
                        C1283.m16854("VideoPresentationTracking", "Tracking [" + format + "] " + puVar.getTitle() + "  (" + r11.getClass().getName() + ')');
                    }
                    List<String> r16 = EI.m4806(puVar.getId());
                    List<String> r17 = str != null ? EI.m4806(str) : EI.m4805();
                    UiLocation r18 = yQVar.mo11034();
                    if (r18 == null) {
                        C1283.m16854("VideoPresentationTracking", "Invalid CLv1, we are missing the uiLocation for [" + format + "] " + puVar.getTitle() + "  (" + r11.getClass().getName() + ')');
                    }
                    IClientLogging r02 = serviceManager.m9825();
                    if (!(r02 == null || (r0 = r02.mo1509()) == null)) {
                        r0.mo5354(yQVar.mo11028(), r16, r17, intValue, i, r18);
                    }
                    AbstractC2087qh qhVar = r11;
                    if (!(qhVar instanceof AbstractC2071pt)) {
                        qhVar = null;
                    }
                    AbstractC2071pt ptVar = (AbstractC2071pt) qhVar;
                    C1300Ac.m3523(ptVar != null ? ptVar.getId() : null, r11, r16, r17, jSONObject, i, appView);
                }
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final void m13231(yQ yQVar) {
        Integer r4;
        C1457Fr.m5025(yQVar, "presentable");
        AbstractC2072pu r3 = yQVar.mo11030();
        if (r3 != null && yQVar.mo11028() != null && (r4 = yQVar.mo11029()) != null) {
            yQVar.m13243(new If(r4.intValue(), r3, yQVar, r3));
            C1348Bu.If.m4100(yQVar.m13240(), 500);
        }
    }

    public static final class If extends AbstractRunnableC0303 {

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ AbstractC2072pu f12413;

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ yQ f12414;

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ int f12415;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        If(int i, Object obj, yQ yQVar, AbstractC2072pu puVar) {
            super(obj);
            this.f12415 = i;
            this.f12414 = yQVar;
            this.f12413 = puVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                if (m13239() == this.f12414.mo11030() && this.f12414.mo11028() != null && this.f12414.mo11032().isAttachedToWindow()) {
                    Resources resources = this.f12414.mo11032().getResources();
                    C1457Fr.m5016((Object) resources, "presentable.view().resources");
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    float measuredHeight = ((float) this.f12414.mo11032().getMeasuredHeight()) * 0.5f;
                    View r0 = this.f12414.mo11032();
                    yO yOVar = yO.f12411;
                    r0.getLocationInWindow(yO.f12412);
                    yO yOVar2 = yO.f12411;
                    if (((float) yO.f12412[1]) >= (-measuredHeight)) {
                        yO yOVar3 = yO.f12411;
                        if (((float) yO.f12412[1]) <= ((float) displayMetrics.heightPixels) - measuredHeight) {
                            float measuredWidth = ((float) this.f12414.mo11032().getMeasuredWidth()) * 0.5f;
                            if (this.f12414.mo11032().isAttachedToWindow()) {
                                yO yOVar4 = yO.f12411;
                                if (((float) yO.f12412[0]) > (-measuredWidth)) {
                                    yO yOVar5 = yO.f12411;
                                    if (((float) yO.f12412[0]) < ((float) displayMetrics.widthPixels) - measuredWidth) {
                                        z = true;
                                        if (!this.f12414.m13241()) {
                                            yO yOVar6 = yO.f12411;
                                            Context context = this.f12414.mo11032().getContext();
                                            C1457Fr.m5016((Object) context, "presentable.view().context");
                                            yO.m13230(yOVar6, context, this.f12414, this.f12413, this.f12414.mo11027(), this.f12415, null, 32, null);
                                            if (yO.f12410) {
                                                this.f12414.m13242(-1);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } finally {
                this.f12414.m13244(z);
                this.f12414.m13243(null);
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final void m13229(yQ yQVar) {
        C1457Fr.m5025(yQVar, "presentable");
        yQVar.m13245();
    }

    /* renamed from: o.yO$ˋ  reason: contains not printable characters */
    public static abstract class AbstractRunnableC0303 implements Runnable {

        /* renamed from: ॱ  reason: contains not printable characters */
        private final Object f12420;

        public AbstractRunnableC0303(Object obj) {
            C1457Fr.m5025(obj, "originatedFrom");
            this.f12420 = obj;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final Object m13239() {
            return this.f12420;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.yO$ˊ  reason: contains not printable characters */
    public static final class C0302 {

        /* renamed from: ˊ  reason: contains not printable characters */
        private static final WeakHashMap<RecyclerView, PointF> f12416 = new WeakHashMap<>();

        /* renamed from: ˋ  reason: contains not printable characters */
        private static final RecyclerView.OnScrollListener f12417 = new If();

        /* renamed from: ˎ  reason: contains not printable characters */
        private static final float f12418;

        /* renamed from: ॱ  reason: contains not printable characters */
        public static final C0302 f12419 = new C0302();

        static {
            NetflixApplication instance = NetflixApplication.getInstance();
            C1457Fr.m5016((Object) instance, "NetflixApplication.getInstance()");
            Resources resources = instance.getResources();
            C1457Fr.m5016((Object) resources, "NetflixApplication.getInstance().resources");
            f12418 = (float) resources.getDisplayMetrics().densityDpi;
        }

        private C0302() {
        }

        /* renamed from: o.yO$ˊ$If */
        public static final class If extends RecyclerView.OnScrollListener {
            If() {
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                C1457Fr.m5025(recyclerView, "recyclerView");
                if (i == 1) {
                    C0302.f12419.m13232(recyclerView);
                } else if (i == 0) {
                    C0302.f12419.m13237(recyclerView);
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                C1457Fr.m5025(recyclerView, "recyclerView");
                C0302.f12419.m13235(recyclerView, i, i2);
            }
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final RecyclerView.OnScrollListener m13238() {
            return f12417;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˊ  reason: contains not printable characters */
        private final void m13232(RecyclerView recyclerView) {
            if (f12416.get(recyclerView) == null) {
                f12416.put(recyclerView, new PointF());
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ॱ  reason: contains not printable characters */
        private final void m13237(RecyclerView recyclerView) {
            IClientLogging r0;
            AbstractC2063pl r02;
            PointF remove = f12416.remove(recyclerView);
            if (remove != null) {
                NetflixActivity netflixActivity = (NetflixActivity) C0345.m13893(recyclerView.getContext(), NetflixActivity.class);
                if (netflixActivity != null && !C1317As.m3750(netflixActivity)) {
                    C2059ph serviceManager = netflixActivity.getServiceManager();
                    C1457Fr.m5016((Object) serviceManager, "serviceManager");
                    if (!(!serviceManager.mo9519() || (r0 = serviceManager.m9825()) == null || (r02 = r0.mo1509()) == null)) {
                        r02.mo5351((double) remove.x, (double) remove.y);
                    }
                }
                remove.x = 0.0f;
                remove.y = 0.0f;
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˏ  reason: contains not printable characters */
        private final void m13235(RecyclerView recyclerView, int i, int i2) {
            PointF pointF = f12416.get(recyclerView);
            if (pointF != null) {
                pointF.x += ((float) Math.abs(i)) / f12418;
                pointF.y += ((float) Math.abs(i2)) / f12418;
            }
        }
    }
}

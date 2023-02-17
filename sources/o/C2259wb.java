package o;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.FragmentActivity;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.ui.player.PlayerFragment;
import java.util.Iterator;
import java.util.List;
import o.C1348Bu;
import o.C2275wq;
/* renamed from: o.wb  reason: case insensitive filesystem */
public final class C2259wb extends vY {

    /* renamed from: ʽॱ  reason: contains not printable characters */
    public static final C0252 f11586 = new C0252(null);

    /* renamed from: ˉ  reason: contains not printable characters */
    private List<? extends Button> f11587;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private ConstraintLayout f11588;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private ImageView f11589;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private ViewGroup f11590;

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private final Runnable f11591 = new iF(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2259wb(PlayerFragment playerFragment, View view, C2275wq.C0256 r4) {
        super(playerFragment, view, r4);
        C1457Fr.m5025(playerFragment, "fragment");
        C1457Fr.m5025(view, "playerView");
        C1457Fr.m5025(r4, "listeners");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final /* synthetic */ ImageView m12415(C2259wb wbVar) {
        ImageView imageView = wbVar.f11589;
        if (imageView == null) {
            C1457Fr.m5017("fullscreenButton");
        }
        return imageView;
    }

    /* renamed from: o.wb$iF */
    static final class iF implements Runnable {

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ C2259wb f11592;

        iF(C2259wb wbVar) {
            this.f11592 = wbVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FragmentActivity activity;
            PlayerFragment playerFragment = this.f11592.f11438;
            if (playerFragment != null && (activity = playerFragment.getActivity()) != null && !C1317As.m3750(activity)) {
                C1457Fr.m5016((Object) activity, "activity");
                activity.setRequestedOrientation(-1);
            }
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0050: APUT  (r0v14 android.widget.Button[]), (0 ??[int, short, byte, char]), (r1v3 android.widget.Button) */
    /* access modifiers changed from: protected */
    @Override // o.vY
    /* renamed from: ॱ */
    public void mo12108(View view, C2275wq.C0256 r5) {
        C1457Fr.m5025(view, "playerView");
        C1457Fr.m5025(r5, "listeners");
        super.mo12108(view, r5);
        View findViewById = view.findViewById(R.id.background);
        C1457Fr.m5016((Object) findViewById, "playerView.findViewById(R.id.background)");
        this.f11588 = (ConstraintLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.time_bar_container);
        C1457Fr.m5016((Object) findViewById2, "playerView.findViewById(R.id.time_bar_container)");
        this.f11590 = (ViewGroup) findViewById2;
        this.f11562 = vZ.m12109(this.f11438);
        View findViewById3 = view.findViewById(R.id.fullscreen);
        C1457Fr.m5016((Object) findViewById3, "playerView.findViewById(R.id.fullscreen)");
        this.f11589 = (ImageView) findViewById3;
        Button[] buttonArr = new Button[3];
        Button button = this.f11286;
        if (button == null) {
            C1457Fr.m5019();
        }
        buttonArr[0] = button;
        Button button2 = this.f11285;
        if (button2 == null) {
            C1457Fr.m5019();
        }
        buttonArr[1] = button2;
        Button button3 = this.f11283;
        if (button3 == null) {
            C1457Fr.m5019();
        }
        buttonArr[2] = button3;
        this.f11587 = EI.m4802(buttonArr);
    }

    /* access modifiers changed from: protected */
    @Override // o.vY
    /* renamed from: ˎ */
    public void mo12100(C2275wq.C0256 r5) {
        C1457Fr.m5025(r5, "listeners");
        super.mo12100(r5);
        if (C0889.f14766.m15607()) {
            ImageView imageView = this.f11589;
            if (imageView == null) {
                C1457Fr.m5017("fullscreenButton");
            }
            imageView.setVisibility(0);
            ImageView imageView2 = this.f11589;
            if (imageView2 == null) {
                C1457Fr.m5017("fullscreenButton");
            }
            imageView2.setOnClickListener(new Cif(this));
        } else {
            ImageView imageView3 = this.f11589;
            if (imageView3 == null) {
                C1457Fr.m5017("fullscreenButton");
            }
            imageView3.setVisibility(8);
        }
        PlayerFragment playerFragment = this.f11438;
        C1457Fr.m5016((Object) playerFragment, "playerFragment");
        FragmentActivity activity = playerFragment.getActivity();
        if (activity != null) {
            C1457Fr.m5016((Object) activity, "it");
            Resources resources = activity.getResources();
            C1457Fr.m5016((Object) resources, "it.resources");
            Configuration configuration = resources.getConfiguration();
            C1457Fr.m5016((Object) configuration, "it.resources.configuration");
            m12417(configuration);
        }
    }

    /* renamed from: o.wb$if  reason: invalid class name */
    static final class Cif implements View.OnClickListener {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ C2259wb f11593;

        Cif(C2259wb wbVar) {
            this.f11593 = wbVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PlayerFragment playerFragment = this.f11593.f11438;
            C1457Fr.m5016((Object) playerFragment, "playerFragment");
            FragmentActivity activity = playerFragment.getActivity();
            if (activity != null) {
                C1457Fr.m5016((Object) activity, "activity");
                if (activity.getRequestedOrientation() == 6) {
                    C2259wb.m12415(this.f11593).setImageResource(R.drawable.ic_coming_soon_fullscreen_on);
                    Resources resources = activity.getResources();
                    C1457Fr.m5016((Object) resources, "activity.resources");
                    if (resources.getConfiguration().orientation == 2) {
                        activity.setRequestedOrientation(1);
                        C1348Bu.If.m4100(this.f11593.f11591, 3000);
                        return;
                    }
                    activity.setRequestedOrientation(-1);
                    return;
                }
                C2259wb.m12415(this.f11593).setImageResource(R.drawable.ic_coming_soon_fullscreen_off);
                activity.setRequestedOrientation(6);
                C1348Bu.If.m4099(this.f11593.f11591);
            }
        }
    }

    @Override // o.vY, o.C2258wa
    /* renamed from: ˎ */
    public synchronized void mo12099() {
        super.mo12099();
        this.f11279.m12592(this.f11567, true, true);
        this.f11279.m12592(this.f11565, true, true);
        if (C0889.f14766.m15607()) {
            C2282wx wxVar = this.f11279;
            ImageView imageView = this.f11589;
            if (imageView == null) {
                C1457Fr.m5017("fullscreenButton");
            }
            wxVar.m12592(imageView, true, true);
        }
        List<? extends Button> list = this.f11587;
        if (list == null) {
            C1457Fr.m5017("bottomButtons");
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            this.f11279.m12592(it.next(), true, true);
        }
    }

    @Override // o.vY, o.C2258wa
    /* renamed from: ॱ */
    public synchronized void mo12107() {
        super.mo12107();
        this.f11279.m12592(this.f11567, false, true);
        this.f11279.m12592(this.f11565, false, true);
        if (C0889.f14766.m15607()) {
            C2282wx wxVar = this.f11279;
            ImageView imageView = this.f11589;
            if (imageView == null) {
                C1457Fr.m5017("fullscreenButton");
            }
            wxVar.m12592(imageView, false, true);
        }
        List<? extends Button> list = this.f11587;
        if (list == null) {
            C1457Fr.m5017("bottomButtons");
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            this.f11279.m12592(it.next(), false, true);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2258wa
    /* renamed from: ᐝ */
    public void mo12413() {
        C1081 r0 = this.f11567;
        C1457Fr.m5016((Object) r0, "timeline");
        if (r0.getAlpha() > 0.0f) {
            this.f11562.m12113();
        }
    }

    @Override // o.C2258wa
    /* renamed from: ˎ */
    public void mo12406(Configuration configuration) {
        C1457Fr.m5025(configuration, "newConfig");
        super.mo12406(configuration);
        m12417(configuration);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private final void m12417(Configuration configuration) {
        int i;
        int i2;
        ConstraintSet constraintSet = new ConstraintSet();
        ConstraintLayout constraintLayout = this.f11588;
        if (constraintLayout == null) {
            C1457Fr.m5017("mainLayout");
        }
        constraintSet.clone(constraintLayout);
        constraintSet.clear(R.id.player_bottom_buttons_bar, 3);
        constraintSet.clear(R.id.player_bottom_buttons_bar, 4);
        constraintSet.clear(R.id.time_bar_container, 4);
        switch (configuration.orientation) {
            case 2:
                List<? extends Button> list = this.f11587;
                if (list == null) {
                    C1457Fr.m5017("bottomButtons");
                }
                for (T t : list) {
                    m12418((Button) t);
                    C1004.m15952(t, 1, 0);
                }
                ImageView imageView = this.f11589;
                if (imageView == null) {
                    C1457Fr.m5017("fullscreenButton");
                }
                if (imageView.getVisibility() == 0) {
                    ConstraintLayout constraintLayout2 = this.f11588;
                    if (constraintLayout2 == null) {
                        C1457Fr.m5017("mainLayout");
                    }
                    Context context = constraintLayout2.getContext();
                    C1457Fr.m5016((Object) context, "mainLayout.context");
                    i2 = context.getResources().getDimensionPixelSize(R.dimen.moderate_padding);
                    ConstraintLayout constraintLayout3 = this.f11588;
                    if (constraintLayout3 == null) {
                        C1457Fr.m5017("mainLayout");
                    }
                    Context context2 = constraintLayout3.getContext();
                    C1457Fr.m5016((Object) context2, "mainLayout.context");
                    i = context2.getResources().getDimensionPixelSize(R.dimen.moderate_padding);
                } else {
                    ConstraintLayout constraintLayout4 = this.f11588;
                    if (constraintLayout4 == null) {
                        C1457Fr.m5017("mainLayout");
                    }
                    Context context3 = constraintLayout4.getContext();
                    C1457Fr.m5016((Object) context3, "mainLayout.context");
                    i2 = context3.getResources().getDimensionPixelSize(R.dimen.content_padding);
                    ConstraintLayout constraintLayout5 = this.f11588;
                    if (constraintLayout5 == null) {
                        C1457Fr.m5017("mainLayout");
                    }
                    Context context4 = constraintLayout5.getContext();
                    C1457Fr.m5016((Object) context4, "mainLayout.context");
                    i = context4.getResources().getDimensionPixelSize(R.dimen.large_padding);
                }
                constraintSet.connect(R.id.player_bottom_buttons_bar, 4, 0, 4);
                constraintSet.connect(R.id.time_bar_container, 4, R.id.player_bottom_buttons_bar, 3);
                break;
            default:
                List<? extends Button> list2 = this.f11587;
                if (list2 == null) {
                    C1457Fr.m5017("bottomButtons");
                }
                for (T t2 : list2) {
                    m12414((Button) t2);
                    C1281 r14 = C1281.f15992;
                    Resources resources = ((Context) C1281.m16832(Context.class)).getResources();
                    C1457Fr.m5016((Object) resources, "Lookup.get<Context>().resources");
                    C1004.m15952(t2, 1, (int) TypedValue.applyDimension(1, 16.0f, resources.getDisplayMetrics()));
                }
                i2 = 0;
                ImageView imageView2 = this.f11589;
                if (imageView2 == null) {
                    C1457Fr.m5017("fullscreenButton");
                }
                if (imageView2.getVisibility() == 0) {
                    i = 0;
                } else {
                    ConstraintLayout constraintLayout6 = this.f11588;
                    if (constraintLayout6 == null) {
                        C1457Fr.m5017("mainLayout");
                    }
                    Context context5 = constraintLayout6.getContext();
                    C1457Fr.m5016((Object) context5, "mainLayout.context");
                    i = context5.getResources().getDimensionPixelSize(R.dimen.moderate_padding);
                }
                constraintSet.connect(R.id.time_bar_container, 4, R.id.video_bottom, 4);
                constraintSet.connect(R.id.player_bottom_buttons_bar, 3, R.id.time_bar_container, 4);
                break;
        }
        ConstraintLayout constraintLayout7 = this.f11588;
        if (constraintLayout7 == null) {
            C1457Fr.m5017("mainLayout");
        }
        constraintSet.applyTo(constraintLayout7);
        ViewGroup viewGroup = this.f11590;
        if (viewGroup == null) {
            C1457Fr.m5017("timeBarContainer");
        }
        C1004.m15959(viewGroup, 0, i2);
        ViewGroup viewGroup2 = this.f11590;
        if (viewGroup2 == null) {
            C1457Fr.m5017("timeBarContainer");
        }
        C1004.m15959(viewGroup2, 2, i2);
        C1004.m15959(this.f11565, 2, i);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m12414(Button button) {
        Drawable[] compoundDrawablesRelative = button.getCompoundDrawablesRelative();
        if (compoundDrawablesRelative[0] != null) {
            button.setCompoundDrawablesRelative(null, compoundDrawablesRelative[0], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private final void m12418(Button button) {
        Drawable[] compoundDrawablesRelative = button.getCompoundDrawablesRelative();
        if (compoundDrawablesRelative[1] != null) {
            button.setCompoundDrawablesRelative(compoundDrawablesRelative[1], null, compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
        }
    }

    /* renamed from: o.wb$ˊ  reason: contains not printable characters */
    public static final class C0252 {
        private C0252() {
        }

        public /* synthetic */ C0252(C1456Fq fq) {
            this();
        }
    }
}

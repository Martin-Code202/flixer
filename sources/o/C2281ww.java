package o;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageButton;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.ui.player.PlayerFragment;
import com.netflix.mediaclient.ui.player.PlayerUiState;
import com.netflix.mediaclient.ui.player.PostPlayFactory;
import o.C0942;
import o.C2275wq;
/* renamed from: o.ww  reason: case insensitive filesystem */
public final class C2281ww extends C2274wp {

    /* renamed from: ʼॱ  reason: contains not printable characters */
    public static final C0257 f11717 = new C0257(null);

    /* renamed from: ʾ  reason: contains not printable characters */
    private ConstraintLayout f11718;

    /* renamed from: ʿ  reason: contains not printable characters */
    private View f11719;

    /* renamed from: ˈ  reason: contains not printable characters */
    private View f11720;

    /* renamed from: ˉ  reason: contains not printable characters */
    private View f11721;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private View f11722;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private View f11723;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2281ww(PlayerFragment playerFragment, View view, C2275wq.C0256 r5, PostPlayFactory.PostPlayType postPlayType) {
        super(playerFragment, view, r5, postPlayType);
        C1457Fr.m5025(playerFragment, "playerFragment");
        C1457Fr.m5025(view, "playerView");
        C1457Fr.m5025(postPlayType, "postPlayType");
        m12489().setSurfaceMeasureListener(new C0942.If(this) { // from class: o.ww.4

            /* renamed from: ॱ  reason: contains not printable characters */
            final /* synthetic */ C2281ww f11724;

            {
                this.f11724 = r1;
            }

            @Override // o.C0942.If
            /* renamed from: ˏ  reason: contains not printable characters */
            public final void mo12578(int i, int i2) {
                this.f11724.m12489().post(new Runnable(this) { // from class: o.ww.4.3

                    /* renamed from: ˏ  reason: contains not printable characters */
                    final /* synthetic */ AnonymousClass4 f11725;

                    {
                        this.f11725 = r1;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        C0942 r0 = this.f11725.f11724.m12489();
                        C1457Fr.m5016((Object) r0, "surfaceView");
                        if (r0.getHeight() > 0) {
                            C0942 r02 = this.f11725.f11724.m12489();
                            C1457Fr.m5016((Object) r02, "surfaceView");
                            if (r02.m15760() > 0) {
                                C0942 r03 = this.f11725.f11724.m12489();
                                C1457Fr.m5016((Object) r03, "surfaceView");
                                int height = r03.getHeight();
                                C0942 r1 = this.f11725.f11724.m12489();
                                C1457Fr.m5016((Object) r1, "surfaceView");
                                int r12 = r1.m15760();
                                C0942 r2 = this.f11725.f11724.m12489();
                                C1457Fr.m5016((Object) r2, "surfaceView");
                                int height2 = r12 * r2.getHeight();
                                C0942 r22 = this.f11725.f11724.m12489();
                                C1457Fr.m5016((Object) r22, "surfaceView");
                                int r4 = (height - (height2 / r22.m15758())) / 2;
                                C1004.m15959(C2281ww.m12573(this.f11725.f11724), 1, r4);
                                C1004.m15959(C2281ww.m12571(this.f11725.f11724), 3, r4);
                            }
                        }
                    }
                });
            }
        });
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final /* synthetic */ View m12571(C2281ww wwVar) {
        View view = wwVar.f11723;
        if (view == null) {
            C1457Fr.m5017("videoBottom");
        }
        return view;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final /* synthetic */ View m12573(C2281ww wwVar) {
        View view = wwVar.f11721;
        if (view == null) {
            C1457Fr.m5017("videoTop");
        }
        return view;
    }

    /* access modifiers changed from: protected */
    @Override // o.C2274wp, o.C2275wq
    /* renamed from: ˋ */
    public void mo12459(PlayerFragment playerFragment, View view, C2275wq.C0256 r8) {
        Resources resources;
        Configuration configuration;
        C1457Fr.m5025(playerFragment, "playerFragment");
        C1457Fr.m5025(view, "playerView");
        C1457Fr.m5025(r8, "listeners");
        View findViewById = view.findViewById(R.id.background);
        C1457Fr.m5016((Object) findViewById, "playerView.findViewById(R.id.background)");
        this.f11718 = (ConstraintLayout) findViewById;
        this.f11665 = view.findViewById(R.id.background);
        View findViewById2 = view.findViewById(R.id.playoutSplash);
        C1457Fr.m5016((Object) findViewById2, "playerView.findViewById(R.id.playoutSplash)");
        this.f11719 = findViewById2;
        View findViewById3 = view.findViewById(R.id.skip_backward_container);
        C1457Fr.m5016((Object) findViewById3, "playerView.findViewById(….skip_backward_container)");
        this.f11722 = findViewById3;
        View findViewById4 = view.findViewById(R.id.skip_forward_container);
        C1457Fr.m5016((Object) findViewById4, "playerView.findViewById(…d.skip_forward_container)");
        this.f11720 = findViewById4;
        super.mo12459(playerFragment, view, r8);
        this.f11665.setOnTouchListener(r8.f11698);
        FragmentActivity activity = playerFragment.getActivity();
        if (activity != null && (resources = activity.getResources()) != null && (configuration = resources.getConfiguration()) != null) {
            m12570(configuration);
            m12572(this, configuration, false, 2, null);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2274wp
    /* renamed from: ˋ */
    public void mo12458(PlayerFragment playerFragment, View view) {
        C1457Fr.m5025(playerFragment, "playerFragment");
        C1457Fr.m5025(view, "playerView");
        this.f11670 = new C2314xj(playerFragment, view, this.f11677);
        C2275wq.C0256 r1 = this.f11677;
        C1457Fr.m5016((Object) r1, "listeners");
        this.f11675 = new C2259wb(playerFragment, view, r1);
        this.f11638 = view.findViewById(R.id.center_panel);
        View findViewById = view.findViewById(R.id.video_top);
        C1457Fr.m5016((Object) findViewById, "playerView.findViewById(R.id.video_top)");
        this.f11721 = findViewById;
        View findViewById2 = view.findViewById(R.id.video_bottom);
        C1457Fr.m5016((Object) findViewById2, "playerView.findViewById(R.id.video_bottom)");
        this.f11723 = findViewById2;
    }

    /* access modifiers changed from: protected */
    @Override // o.C2274wp
    /* renamed from: ͺॱ */
    public boolean mo12469() {
        return true;
    }

    @Override // o.C2275wq
    /* renamed from: ˎ */
    public void mo12517(Configuration configuration) {
        super.mo12517(configuration);
        if (configuration != null) {
            m12570(configuration);
            m12572(this, configuration, false, 2, null);
            m12574(configuration);
            C2306xb xbVar = this.f11670;
            if (xbVar != null) {
                xbVar.mo12885(configuration);
            }
            this.f11675.mo12406(configuration);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2274wp, o.C2275wq
    /* renamed from: ˊ */
    public void mo12435(boolean z) {
        super.mo12435(z);
        mo12463(z);
    }

    /* access modifiers changed from: protected */
    @Override // o.C2274wp, o.C2275wq
    /* renamed from: ˎ */
    public void mo12463(boolean z) {
        PlayerFragment r0 = m12496();
        C1457Fr.m5016((Object) r0, "playerFragment");
        FragmentActivity activity = r0.getActivity();
        if (activity != null) {
            C1457Fr.m5016((Object) activity, "activity");
            Resources resources = activity.getResources();
            C1457Fr.m5016((Object) resources, "activity.resources");
            Configuration configuration = resources.getConfiguration();
            C1457Fr.m5016((Object) configuration, "activity.resources.configuration");
            m12575(configuration, z);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    static /* synthetic */ void m12572(C2281ww wwVar, Configuration configuration, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = C1457Fr.m5018(wwVar.m12493(), PlayerUiState.PlayingWithTrickPlayOverlay);
        }
        wwVar.m12575(configuration, z);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private final void m12575(Configuration configuration, boolean z) {
        int i;
        int i2;
        wY r4 = m12518();
        if (r4 != null) {
            ConstraintSet constraintSet = new ConstraintSet();
            ConstraintLayout constraintLayout = this.f11718;
            if (constraintLayout == null) {
                C1457Fr.m5017("mainLayout");
            }
            constraintSet.clone(constraintLayout);
            constraintSet.clear(R.id.skip_credits_button, 3);
            constraintSet.clear(R.id.skip_credits_button, 4);
            switch (configuration.orientation) {
                case 2:
                    if (z) {
                        constraintSet.connect(R.id.skip_credits_button, 4, R.id.time_bar_container, 3);
                        i2 = 0;
                    } else {
                        constraintSet.connect(R.id.skip_credits_button, 4, 0, 4);
                        ConstraintLayout constraintLayout2 = this.f11718;
                        if (constraintLayout2 == null) {
                            C1457Fr.m5017("mainLayout");
                        }
                        Context context = constraintLayout2.getContext();
                        C1457Fr.m5016((Object) context, "mainLayout.context");
                        i2 = context.getResources().getDimensionPixelSize(R.dimen.player_skip_credits_bottom_margin) * 2;
                    }
                    ConstraintLayout constraintLayout3 = this.f11718;
                    if (constraintLayout3 == null) {
                        C1457Fr.m5017("mainLayout");
                    }
                    Context context2 = constraintLayout3.getContext();
                    C1457Fr.m5016((Object) context2, "mainLayout.context");
                    i = context2.getResources().getDimensionPixelSize(R.dimen.large_padding);
                    break;
                default:
                    constraintSet.connect(R.id.skip_credits_button, 3, R.id.video_top, 3);
                    ConstraintLayout constraintLayout4 = this.f11718;
                    if (constraintLayout4 == null) {
                        C1457Fr.m5017("mainLayout");
                    }
                    Context context3 = constraintLayout4.getContext();
                    C1457Fr.m5016((Object) context3, "mainLayout.context");
                    i2 = context3.getResources().getDimensionPixelSize(R.dimen.player_skip_credits_bottom_margin);
                    ConstraintLayout constraintLayout5 = this.f11718;
                    if (constraintLayout5 == null) {
                        C1457Fr.m5017("mainLayout");
                    }
                    Context context4 = constraintLayout5.getContext();
                    C1457Fr.m5016((Object) context4, "mainLayout.context");
                    i = context4.getResources().getDimensionPixelSize(R.dimen.moderate_padding);
                    break;
            }
            ConstraintLayout constraintLayout6 = this.f11718;
            if (constraintLayout6 == null) {
                C1457Fr.m5017("mainLayout");
            }
            constraintSet.applyTo(constraintLayout6);
            C1004.m15959(r4, 2, i);
            C1004.m15959(r4, 4, i2);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m12570(Configuration configuration) {
        float f;
        switch (configuration.orientation) {
            case 2:
                f = 1.0f;
                break;
            default:
                f = 0.73f;
                break;
        }
        View view = this.f11722;
        if (view == null) {
            C1457Fr.m5017("skipBackwardContainer");
        }
        m12569(view, f);
        ImageButton imageButton = this.f11616;
        if (imageButton != null) {
            C1457Fr.m5016((Object) imageButton, "it");
            m12569(imageButton, f);
        }
        View view2 = this.f11720;
        if (view2 == null) {
            C1457Fr.m5017("skipForwardContainer");
        }
        m12569(view2, f);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final void m12569(View view, float f) {
        view.setScaleX(f);
        view.setScaleY(f);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private final void m12574(Configuration configuration) {
        PlayerFragment r0 = m12496();
        C1457Fr.m5016((Object) r0, "playerFragment");
        FragmentActivity activity = r0.getActivity();
        if (activity != null) {
            switch (configuration.orientation) {
                case 2:
                    mo12471(activity);
                    return;
                default:
                    m12466(activity);
                    return;
            }
        }
    }

    @Override // o.C2274wp, o.C2275wq
    /* renamed from: ॱ */
    public void mo12471(Activity activity) {
        Resources resources;
        Configuration configuration;
        if (activity != null && (resources = activity.getResources()) != null && (configuration = resources.getConfiguration()) != null && configuration.orientation == 2 && (!C1457Fr.m5018(m12493(), PlayerUiState.PostPlay))) {
            super.mo12471(activity);
        }
    }

    /* renamed from: ˎˏ  reason: contains not printable characters */
    public void mo12436() {
    }

    /* renamed from: ˑ  reason: contains not printable characters */
    public void mo12437() {
    }

    /* access modifiers changed from: protected */
    @Override // o.C2275wq
    /* renamed from: ॱˊ */
    public void mo12528() {
        View view = this.f11719;
        if (view == null) {
            C1457Fr.m5017("loadingView");
        }
        view.setVisibility(8);
        super.mo12528();
    }

    /* renamed from: o.ww$ˊ  reason: contains not printable characters */
    public static final class C0257 {
        private C0257() {
        }

        public /* synthetic */ C0257(C1456Fq fq) {
            this();
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final C2275wq m12579(PlayerFragment playerFragment, View view, C2275wq.C0256 r4, PostPlayFactory.PostPlayType postPlayType) {
            C1457Fr.m5025(playerFragment, "fragment");
            C1457Fr.m5025(view, "playerView");
            C1457Fr.m5025(postPlayType, "postPlayType");
            return new C2281ww(playerFragment, view, r4, postPlayType);
        }
    }
}

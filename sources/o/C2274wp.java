package o;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.service.configuration.persistent.Config_Ab9454_InPlayerPivots;
import com.netflix.mediaclient.service.logging.uiview.model.CommandEndedEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.IPlayer;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import com.netflix.mediaclient.ui.player.IPlayerFragment;
import com.netflix.mediaclient.ui.player.PlayerFragment;
import com.netflix.mediaclient.ui.player.PlayerUiState;
import com.netflix.mediaclient.ui.player.PostPlayFactory;
import com.netflix.mediaclient.util.ViewUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import o.C2275wq;
/* renamed from: o.wp  reason: case insensitive filesystem */
public class C2274wp extends C2275wq {

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private final C2282wx f11615 = new C2282wx();

    /* renamed from: ʽॱ  reason: contains not printable characters */
    protected ImageButton f11616;

    /* renamed from: ʾ  reason: contains not printable characters */
    private ImageButton f11617;

    /* renamed from: ʿ  reason: contains not printable characters */
    private TextView f11618;

    /* renamed from: ˈ  reason: contains not printable characters */
    private ImageButton f11619;

    /* renamed from: ˉ  reason: contains not printable characters */
    private View f11620;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private View f11621;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private ImageButton f11622;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private TextView f11623;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private ImageButton f11624;

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private View f11625;

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private View f11626;

    /* renamed from: ˌ  reason: contains not printable characters */
    private View f11627;

    /* renamed from: ˍ  reason: contains not printable characters */
    private View f11628;

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private View f11629;

    /* renamed from: ˎˏ  reason: contains not printable characters */
    private View f11630;

    /* renamed from: ˏˎ  reason: contains not printable characters */
    private TextView f11631;

    /* renamed from: ˏˏ  reason: contains not printable characters */
    private View f11632;

    /* renamed from: ˑ  reason: contains not printable characters */
    private View f11633;

    /* renamed from: ͺॱ  reason: contains not printable characters */
    private TextView f11634;

    /* renamed from: ॱʻ  reason: contains not printable characters */
    private int f11635 = 0;

    /* renamed from: ॱʼ  reason: contains not printable characters */
    private C2322xq f11636;

    /* renamed from: ॱͺ  reason: contains not printable characters */
    private boolean f11637 = false;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    protected View f11638;

    /* renamed from: ॱ  reason: contains not printable characters */
    static /* synthetic */ int m12446(C2274wp wpVar) {
        int i = wpVar.f11635;
        wpVar.f11635 = i + 1;
        return i;
    }

    C2274wp(PlayerFragment playerFragment, View view, C2275wq.C0256 r5, PostPlayFactory.PostPlayType postPlayType) {
        super(playerFragment, view, r5, postPlayType);
        if (!mo12469()) {
            playerFragment.m2498().getDecorView().setSystemUiVisibility(1792);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    static C2275wq m12438(PlayerFragment playerFragment, C2275wq.C0256 r4, PostPlayFactory.PostPlayType postPlayType) {
        View view = playerFragment.getView();
        if (view != null) {
            return new C2274wp(playerFragment, view, r4, postPlayType);
        }
        throw new IllegalStateException("PlayerFragment view was null");
    }

    /* access modifiers changed from: protected */
    /* renamed from: ͺॱ  reason: contains not printable characters */
    public boolean mo12469() {
        return C0650.m14802() || Config_Ab9454_InPlayerPivots.m518();
    }

    /* access modifiers changed from: protected */
    @Override // o.C2275wq
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo12454(C0942 r2) {
        if (mo12469()) {
            r2.setOnTouchListener(this.f11677.f11698);
        } else {
            r2.m15759(this.f11677.f11688);
        }
    }

    @Override // o.C2275wq
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo12471(Activity activity) {
        if (mo12469() && activity != null && !C1317As.m3750(activity)) {
            activity.getWindow().getDecorView().setSystemUiVisibility(4102);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m12466(Activity activity) {
        if (activity != null && !C1317As.m3750(activity)) {
            activity.getWindow().getDecorView().setSystemUiVisibility(0);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m12442(View view) {
        if (view != null) {
            view.performHapticFeedback(1);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2275wq
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo12452(PlayerFragment playerFragment, View view, C2275wq.C0256 r3) {
        mo12459(playerFragment, view, r3);
    }

    /* access modifiers changed from: protected */
    @Override // o.C2275wq
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo12459(PlayerFragment playerFragment, View view, C2275wq.C0256 r7) {
        mo12458(playerFragment, view);
        this.f11620 = view.findViewById(R.id.background_gradient);
        if (C0650.m14796() || Config_Ab9454_InPlayerPivots.m519()) {
            this.f11622 = (ImageButton) view.findViewById(R.id.skip_back_arrow);
            this.f11624 = (ImageButton) view.findViewById(R.id.skip_forward_arrow);
            this.f11626 = view.findViewById(R.id.skip_back_highlight1);
            this.f11628 = view.findViewById(R.id.skip_back_highlight2);
            this.f11630 = view.findViewById(R.id.skip_forward_highlight1);
            this.f11633 = view.findViewById(R.id.skip_forward_highlight2);
            this.f11631 = (TextView) view.findViewById(R.id.skip_back_arrow_label);
            this.f11634 = (TextView) view.findViewById(R.id.skip_forward_arrow_label);
            if (this.f11622 != null && (this.f11622.getParent() instanceof View)) {
                this.f11627 = (View) this.f11622.getParent();
            }
            if (this.f11624 != null && (this.f11624.getParent() instanceof View)) {
                this.f11629 = (View) this.f11624.getParent();
            }
        } else {
            this.f11619 = (ImageButton) view.findViewById(R.id.skip_back);
            this.f11617 = (ImageButton) view.findViewById(R.id.skip_forward);
            if (this.f11619 != null && (this.f11619.getParent() instanceof View)) {
                this.f11627 = (View) this.f11619.getParent();
            }
            if (this.f11617 != null && (this.f11617.getParent() instanceof View)) {
                this.f11629 = (View) this.f11617.getParent();
            }
        }
        this.f11618 = (TextView) view.findViewById(R.id.skip_back_label);
        this.f11623 = (TextView) view.findViewById(R.id.skip_forward_label);
        this.f11621 = view.findViewById(R.id.skip_back_circle);
        this.f11625 = view.findViewById(R.id.skip_forward_circle);
        this.f11632 = view.findViewById(R.id.player_bottom_bar_without_bif);
        this.f11616 = this.f11675.f11573;
        m12457(playerFragment);
        if (Config_Ab9454_InPlayerPivots.m517() && this.f11636 == null && this.f11632 != null) {
            this.f11636 = new C2322xq((ViewGroup) this.f11632, playerFragment.f3537, this.f11675, playerFragment);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo12458(PlayerFragment playerFragment, View view) {
        this.f11670 = new C2312xh(playerFragment, view, this.f11677);
        this.f11675 = new vY(playerFragment, view, this.f11677);
        this.f11638 = view.findViewById(R.id.center_panel);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m12457(PlayerFragment playerFragment) {
        if (C0650.m14796() || Config_Ab9454_InPlayerPivots.m519()) {
            ViewUtils.m3000(this.f11622);
            ViewUtils.m3000(this.f11624);
        } else {
            ViewUtils.m3000(this.f11619);
            ViewUtils.m3000(this.f11617);
        }
        m12449(playerFragment, this.f11677);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m12449(PlayerFragment playerFragment, C2275wq.C0256 r10) {
        if (this.f11619 != null) {
            m12439(this.f11638, this.f11619, this.f11618, this.f11621, true, playerFragment);
        }
        if (this.f11617 != null) {
            m12439(this.f11638, this.f11617, this.f11623, this.f11625, false, playerFragment);
        }
        if (this.f11622 != null) {
            m12448(this.f11638, this.f11622, this.f11631, this.f11626, this.f11628, true, playerFragment);
        }
        if (this.f11624 != null) {
            m12448(this.f11638, this.f11624, this.f11634, this.f11630, this.f11633, false, playerFragment);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m12448(View view, View view2, TextView textView, View view3, View view4, boolean z, PlayerFragment playerFragment) {
        m12447(view, view2, textView, null, view3, view4, z, playerFragment);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m12439(View view, View view2, TextView textView, View view3, boolean z, PlayerFragment playerFragment) {
        m12447(view, view2, textView, view3, null, null, z, playerFragment);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m12447(final View view, final View view2, final TextView textView, final View view3, final View view4, final View view5, final boolean z, final PlayerFragment playerFragment) {
        C0965.m15783(view2).takeUntil(C0965.m15784(view2)).doOnNext(new Consumer<Object>() { // from class: o.wp.5
            @Override // io.reactivex.functions.Consumer
            public void accept(Object obj) {
                C2274wp.m12446(C2274wp.this);
                playerFragment.mo2234().m12287(SystemClock.elapsedRealtime());
                if (view3 != null) {
                    C2274wp.this.f11615.m12589(view2, textView, view3, z, view, C2274wp.this.f11616);
                } else {
                    C2274wp.this.f11615.m12586(view2, textView, view4, view5, z, view, C2274wp.this.f11616);
                }
            }
        }).debounce(300, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Object>() { // from class: o.wp.2
            @Override // io.reactivex.functions.Consumer
            public void accept(Object obj) {
                C1283.m16848("PlayScreen_Ab8579", "seeking to %d", Integer.valueOf(C2274wp.this.f11635 * 10 * 1000));
                C2274wp.this.m12440(playerFragment, view2, C2274wp.this.f11635);
                C2274wp.this.f11635 = 0;
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m12440(PlayerFragment playerFragment, View view, int i) {
        if ((playerFragment instanceof wB) && view != null) {
            if ((this.f11619 != null && view.getId() == this.f11619.getId()) || (this.f11622 != null && view.getId() == this.f11622.getId())) {
                if (this.f11637) {
                    C1283.m16846("PlayScreen_Ab8579", "skipBack with double tap");
                } else {
                    C1283.m16846("PlayScreen_Ab8579", "skipBack with single tap");
                }
                C1364Cj.m4434(UIViewLogging.UIViewCommandName.skipBack, IClientLogging.ModalView.playbackControls, CommandEndedEvent.InputMethod.gesture, this.f11637 ? CommandEndedEvent.InputValue.doubleTap : CommandEndedEvent.InputValue.tap);
                this.f11637 = false;
                ((wB) playerFragment).m12260(i);
            } else if ((this.f11617 != null && view.getId() == this.f11617.getId()) || (this.f11624 != null && view.getId() == this.f11624.getId())) {
                if (this.f11637) {
                    C1283.m16846("PlayScreen_Ab8579", "skipForward with double tap");
                } else {
                    C1283.m16846("PlayScreen_Ab8579", "skipForward with single tap");
                }
                C1364Cj.m4434(UIViewLogging.UIViewCommandName.skipAhead, IClientLogging.ModalView.playbackControls, CommandEndedEvent.InputMethod.gesture, this.f11637 ? CommandEndedEvent.InputValue.doubleTap : CommandEndedEvent.InputValue.tap);
                this.f11637 = false;
                ((wB) playerFragment).m12259(i);
            }
        }
    }

    @Override // o.C2275wq
    /* renamed from: ˏˎ  reason: contains not printable characters */
    public boolean mo12467() {
        if (this.f11617 != null) {
            this.f11637 = true;
            this.f11617.callOnClick();
            return true;
        } else if (this.f11624 == null) {
            return false;
        } else {
            this.f11637 = true;
            this.f11624.callOnClick();
            return true;
        }
    }

    @Override // o.C2275wq
    /* renamed from: ˌ  reason: contains not printable characters */
    public boolean mo12461() {
        if (this.f11619 != null) {
            this.f11637 = true;
            this.f11619.callOnClick();
            return true;
        } else if (this.f11622 == null) {
            return false;
        } else {
            this.f11637 = true;
            this.f11622.callOnClick();
            return true;
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2275wq
    /* renamed from: ˊ */
    public void mo12435(boolean z) {
        super.mo12435(z);
        this.f11615.m12587(this.f11620, z);
        m12464(z, true);
        this.f11615.m12593(this.f11627, this.f11629, z);
        if (z) {
            mo12437();
        } else {
            mo12436();
        }
    }

    @Override // o.C2275wq
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo12470() {
        mo12471(m12496().getActivity());
        if (this.f11675 != null) {
            this.f11675.mo12107();
        }
        if (m12508() != null) {
            m12508().m12900();
        }
        m12464(false, false);
        if (this.f11620 != null) {
            BQ.m3916(this.f11620, false);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12464(boolean z, boolean z2) {
        if (this.f11638 == null) {
            return;
        }
        if (z2) {
            this.f11615.m12587(this.f11638, z);
        } else {
            this.f11638.setVisibility(z ? 0 : 8);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // o.C2275wq
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo12465() {
        super.mo12465();
    }

    @Override // o.C2275wq
    /* renamed from: ॱˊ  reason: contains not printable characters */
    public void mo12473(boolean z) {
        super.mo12473(z);
        m12464(z, false);
        if (this.f11620 != null) {
            BQ.m3916(this.f11620, z);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // o.C2275wq
    /* renamed from: ˋˊ */
    public void mo12436() {
        if (!mo12469()) {
            this.f11654.m2498().getDecorView().setSystemUiVisibility(1795);
            m12488();
        }
    }

    /* access modifiers changed from: package-private */
    @Override // o.C2275wq
    /* renamed from: ˋᐝ */
    public void mo12437() {
        if (!mo12469()) {
            this.f11654.m2498().getDecorView().setSystemUiVisibility(1792);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.C2275wq
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo12460(boolean z) {
        switch (this.f11662) {
            case Loading:
            case Interrupter:
            default:
                return;
            case Playing:
                m12496().f3537.onNext(IPlayerFragment.PublisherEvents.ON_SHOW_PLAYER_CONTROLS);
                if (m12496().m2458().m12375()) {
                    mo12453(PlayerUiState.PrePlay);
                    return;
                } else {
                    mo12453(PlayerUiState.PlayingWithTrickPlayOverlay);
                    return;
                }
            case SkipCredits:
            case PlayingWithTrickPlayOverlay:
            case PrePlay:
                m12496().f3537.onNext(IPlayerFragment.PublisherEvents.ON_HIDE_PLAYER_CONTROLS);
                mo12453(PlayerUiState.Playing);
                return;
            case PostPlay:
                if (this.f11664.m2594()) {
                    C1283.m16854("PlayScreen_Ab8579", "PostPlay was dismissed before, stay in it!");
                    if (!this.f11664.m2588()) {
                        this.f11664.m2582();
                        return;
                    }
                    return;
                }
                C1283.m16854("PlayScreen_Ab8579", "Move to PlayingWithTrickPlayOverlay from post play");
                mo12453(PlayerUiState.Playing);
                this.f11664.m2582();
                mo12436();
                return;
        }
    }

    /* access modifiers changed from: package-private */
    @Override // o.C2275wq
    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized void mo12453(PlayerUiState playerUiState) {
        super.mo12453(playerUiState);
        if (playerUiState != PlayerUiState.Loading) {
            mo12471(m12496().getActivity());
        }
        if (playerUiState == PlayerUiState.PostPlay) {
            m12466(m12496().getActivity());
        }
    }

    @Override // o.C2275wq
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo12455(boolean z, boolean z2) {
        super.mo12455(z, z2);
    }

    @Override // o.C2275wq
    /* renamed from: ˊॱ  reason: contains not printable characters */
    public void mo12456() {
        mo12455(false, false);
        this.f11675.m12411();
    }

    @Override // o.C2275wq
    /* renamed from: ˏॱ  reason: contains not printable characters */
    public void mo12468() {
        this.f11675.m12405();
    }

    /* access modifiers changed from: protected */
    @Override // o.C2275wq
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo12463(boolean z) {
        if (this.f11673 != null && this.f11632 != null) {
            int dimension = (int) m12496().getResources().getDimension(R.dimen.player_skip_credits_bottom_margin);
            if (z) {
                this.f11673.setBottomMargin(this.f11632.getMeasuredHeight() + dimension);
            } else {
                this.f11673.setBottomMargin(dimension * 2);
            }
        }
    }

    @Override // o.C2275wq
    /* renamed from: ˈ  reason: contains not printable characters */
    public void mo12451() {
        super.mo12451();
        this.f11675.m12398().m12110();
    }

    @Override // o.C2275wq
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo12462(ByteBuffer byteBuffer) {
        if (this.f11654 != null && this.f11654.m14535()) {
            this.f11675.m12398().m12115();
            this.f11675.m12398().m12117(byteBuffer != null);
            if (byteBuffer != null && this.f11672 != null) {
                int dimension = (int) this.f11654.getResources().getDimension(R.dimen.player_big_margin_bottom);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f11666.getLayoutParams();
                marginLayoutParams.setMargins(this.f11675.mo12106(this.f11666), 0, 0, dimension);
                this.f11666.setLayoutParams(marginLayoutParams);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit());
                if (null != decodeByteArray) {
                    this.f11672.setImageBitmap(decodeByteArray);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // o.C2275wq
    /* renamed from: ʻ  reason: contains not printable characters */
    public void mo12450(boolean z) {
        this.f11675.f11573.setVisibility(z ? 4 : 0);
        super.mo12450(z);
    }

    @Override // o.C2275wq
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo12472(pT pTVar, IPlayer.PlaybackType playbackType) {
        super.mo12472(pTVar, playbackType);
        View view = m12496().getView();
        if (view != null) {
            mo12452(m12496(), view, this.f11677);
            CH r3 = C1841h.m6800(pTVar);
            if (r3 != null) {
                this.f11675.mo12103((pT) r3, true);
            } else {
                this.f11675.mo12103((pT) r3, false);
            }
        }
    }
}

package o;

import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.service.configuration.persistent.Config_Ab9454_InPlayerPivots;
import com.netflix.mediaclient.service.logging.uiview.model.CommandEndedEvent;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.player.IPlayerFragment;
import com.netflix.mediaclient.ui.player.PlayerFragment;
import com.netflix.mediaclient.ui.player.PostPlayFactory;
import com.netflix.mediaclient.util.l10n.BidiMarker;
import o.C2275wq;
public class wB extends PlayerFragment {

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private final View.OnTouchListener f11410 = new View.OnTouchListener() { // from class: o.wB.1

        /* renamed from: ˎ  reason: contains not printable characters */
        private GestureDetector f11413 = new GestureDetector(NetflixApplication.getInstance(), new GestureDetector.SimpleOnGestureListener() { // from class: o.wB.1.5

            /* renamed from: ˊ  reason: contains not printable characters */
            final int f11414 = C1004.m15954(NetflixApplication.getInstance(), 20);

            /* renamed from: ˎ  reason: contains not printable characters */
            final int f11416 = 20;

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if ((!C0650.m14798() && !Config_Ab9454_InPlayerPivots.m520()) || wB.this.mo2226() == null || wB.this.mo2226().m12489() == null) {
                    return false;
                }
                if (motionEvent.getX() < ((float) ((wB.this.mo2226().m12489().getWidth() / 2) - this.f11414))) {
                    return wB.this.mo2226().mo12461();
                }
                if (motionEvent.getX() > ((float) ((wB.this.mo2226().m12489().getWidth() / 2) + this.f11414))) {
                    return wB.this.mo2226().mo12467();
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                return wB.this.m12255(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                int r3 = C1004.m15954(NetflixApplication.getInstance(), 100);
                float y = motionEvent2.getY() - motionEvent.getY();
                if (Math.abs(motionEvent2.getX() - motionEvent.getX()) >= Math.abs(y) || Math.abs(y) <= 100.0f || Math.abs(f2) <= ((float) r3)) {
                    return false;
                }
                if (y > 0.0f) {
                    wB.this.f3537.onNext(IPlayerFragment.PublisherEvents.INTENT_ON_PLAYER_TOUCH_FLING_DOWN);
                    return false;
                }
                wB.this.f3537.onNext(IPlayerFragment.PublisherEvents.INTENT_ON_PLAYER_TOUCH_FLING_UP);
                return false;
            }
        });

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f11413.onTouchEvent(motionEvent);
            wB.this.f11411.onTouchEvent(motionEvent);
            return true;
        }
    };

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private ScaleGestureDetector f11411 = new ScaleGestureDetector(NetflixApplication.getInstance(), new ScaleGestureDetector.OnScaleGestureListener() { // from class: o.wB.2

        /* renamed from: ˊ  reason: contains not printable characters */
        float f11417;

        /* renamed from: ॱ  reason: contains not printable characters */
        float f11419;

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            C1364Cj.m4434(UIViewLogging.UIViewCommandName.zoom, IClientLogging.ModalView.playbackControls, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.swipe);
            this.f11419 = scaleGestureDetector.getScaleFactor();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.f11417 = scaleGestureDetector.getScaleFactor();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            C1364Cj.m4434(UIViewLogging.UIViewCommandName.zoom, IClientLogging.ModalView.playbackControls, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.swipe);
            if (this.f11417 > this.f11419) {
                wB.this.mo2521();
            } else {
                wB.this.mo2524();
            }
        }
    });

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PlayerFragment
    /* renamed from: ʻˋ */
    public void mo2455() {
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PlayerFragment
    /* renamed from: ʻᐝ */
    public C2275wq.C0256 mo2456() {
        C2275wq.C0256 r1 = super.mo2456();
        r1.f11698 = this.f11410;
        return r1;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean m12255(MotionEvent motionEvent) {
        if (this.f3532.f11442 || this.f3532.f11444 || this.f3534.m12515()) {
            return false;
        }
        boolean z = motionEvent != null;
        this.f3532.m12287(SystemClock.elapsedRealtime());
        m2502();
        m2477(z);
        return true;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static PlayerFragment m12257(String str, VideoType videoType, oX oXVar, int i, int i2) {
        wB wBVar = new wB();
        wBVar.setArguments(m2410(str, videoType, oXVar, i, i2));
        return wBVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PlayerFragment
    /* renamed from: ˏ */
    public int mo2492(PostPlayFactory.PostPlayType postPlayType) {
        return R.layout.playout_ab8579;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PlayerFragment
    /* renamed from: ˋ */
    public C2275wq mo2474(C2275wq.C0256 r2, PostPlayFactory.PostPlayType postPlayType) {
        return C2274wp.m12438(this, r2, postPlayType);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m12260(int i) {
        m2493(i * -10000);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʽ  reason: contains not printable characters */
    public void m12259(int i) {
        m2493(i * SubtitleDownloadRetryPolicy.DEFAULT_INITIAL_INTERVAL_MS);
    }

    @Override // com.netflix.mediaclient.ui.player.PlayerFragment
    /* renamed from: ॱ */
    public String mo2509(pF pFVar) {
        String r5 = BX.m3956(pFVar.getParentTitle(), BidiMarker.FORCED_RTL);
        String r6 = BX.m3956(pFVar.getPlayableTitle(), BidiMarker.FORCED_RTL);
        if (!pFVar.isPlayableEpisode()) {
            return getResources().getString(R.string.title_movie_string, r6);
        }
        String string = getResources().getString(R.string.title_episode_string_player, pFVar.getSeasonAbbrSeqLabel(), Integer.valueOf(pFVar.getEpisodeNumber()), r6);
        if (pFVar.isNSRE() || pFVar.isEpisodeNumberHidden()) {
            return getResources().getString(R.string.title_episode_string_basic, r5, r6);
        }
        return string;
    }
}

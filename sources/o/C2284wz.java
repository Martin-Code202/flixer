package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Surface;
import android.view.View;
import android.widget.SeekBar;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.media.Language;
import com.netflix.mediaclient.service.configuration.persistent.Config_Ab9454_InPlayerPivots;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.IPlayer;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.common.PlaybackLauncher;
import com.netflix.mediaclient.ui.player.IPlayerFragment;
import com.netflix.mediaclient.ui.player.NetflixVideoView;
import com.netflix.mediaclient.ui.player.PlayerFragment;
import com.netflix.mediaclient.ui.player.PlayerUiState;
import com.netflix.mediaclient.ui.player.PostPlayFactory;
import o.C2275wq;
/* renamed from: o.wz  reason: case insensitive filesystem */
public class C2284wz extends PlayerFragment {

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private static final String f11898 = C2278wt.class.getName();

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private NetflixVideoView f11899;

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    private final IPlayer.AbstractC1291iF f11900 = new IPlayer.AbstractC1291iF() { // from class: o.wz.3
        @Override // com.netflix.mediaclient.servicemgr.IPlayer.AbstractC1291iF
        /* renamed from: ˋ */
        public void mo1528() {
            C2284wz.this.f11899 = null;
            C2284wz.this.m2481();
            if (C2284wz.this.f3534 != null && !C2284wz.this.f3534.m12497()) {
                C1283.m16854(C2284wz.f11898, "onCompletion, In PostPlay, allow screen to lock after timeout...");
                C2284wz.this.f3494.postDelayed(C2284wz.this.f3529, 120000);
            } else if (C2284wz.this.f3530.m12375()) {
                C1283.m16854(C2284wz.f11898, "OnCompletion of preplay.");
                C2279wu r9 = C2284wz.this.f3530.m12373();
                if (C2284wz.this.mo2265()) {
                    C2284wz.this.m2529();
                } else {
                    C2284wz.this.mo2248();
                }
                if (r9 != null) {
                    PlaybackLauncher.m1610(C2284wz.this.m14534(), r9.m12545(), r9.m12546(), r9.m12563(), r9.m12555(), true, r9.m12550(), r9.m12559(), true);
                }
            } else {
                C1283.m16854(C2284wz.f11898, "OnCompletion - exiting.");
                C2284wz.this.m2487((C2279wu) null, PlaybackLauncher.PlayLaunchedBy.LaunchActivity);
                if (C2284wz.this.mo2265()) {
                    C2284wz.this.m2529();
                } else {
                    C2284wz.this.mo2248();
                }
            }
        }
    };

    /* renamed from: ˌ  reason: contains not printable characters */
    private final IPlayer.IF f11901 = new IPlayer.IF() { // from class: o.wz.5
        @Override // com.netflix.mediaclient.servicemgr.IPlayer.IF
        /* renamed from: ˋ */
        public void mo1523() {
            C2278wt wtVar = (C2278wt) C2284wz.this.f3534;
            if (!(wtVar == null || wtVar.m12544() == null)) {
                C2284wz.this.f11899 = wtVar.m12544();
                C2284wz.this.f11899.setSubtitleVisiblity(true);
            }
            C2284wz.this.m2526();
            C1283.m16861((C2284wz.this.mo2255() ? "Offline" : "Streaming") + " playback started");
            Language r4 = C2284wz.this.m2501();
            if (r4 == null && C2284wz.this.f11899 != null) {
                r4 = C1344Bq.m4069(C2284wz.this.getContext(), C2284wz.this.f11899.m2333());
            }
            C2284wz.this.m2475(r4);
            C2284wz.this.getActivity().invalidateOptionsMenu();
        }
    };

    /* renamed from: ˍ  reason: contains not printable characters */
    private final IPlayer.Cif f11902 = new IPlayer.Cif() { // from class: o.wz.2
        @Override // com.netflix.mediaclient.servicemgr.IPlayer.Cif
        /* renamed from: ॱ */
        public void mo1529(long j) {
            C2284wz.this.m2486(j);
        }
    };

    /* renamed from: ˎˎ  reason: contains not printable characters */
    private final IPlayer.AbstractC0024 f11903 = new IPlayer.AbstractC0024() { // from class: o.wz.4
        @Override // com.netflix.mediaclient.servicemgr.IPlayer.AbstractC0024
        /* renamed from: ˎ */
        public void mo1530(final IPlayer.aux aux) {
            C2059ph r4;
            if (aux instanceof C1935kf) {
                C2284wz.this.mo2235(new Runnable() { // from class: o.wz.4.3
                    @Override // java.lang.Runnable
                    public void run() {
                        final NetflixActivity r1 = C2284wz.this.m14534();
                        if (r1 != null && !C2284wz.this.isDetached()) {
                            r1.runWhenManagerIsReady(new NetflixActivity.If() { // from class: o.wz.4.3.2
                                @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
                                public void run(C2059ph phVar) {
                                    vV r2 = vV.f11264.m12080((C1935kf) aux);
                                    r2.onManagerReady(C2284wz.this.m14536(), AbstractC0367.f13235);
                                    r2.setCancelable(true);
                                    r1.showDialog(r2);
                                    C2284wz.this.mo2266();
                                }
                            });
                        }
                    }
                });
            } else if (aux instanceof C1931kb) {
                C2284wz.this.mo2235(new Runnable() { // from class: o.wz.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NetflixActivity r3 = C2284wz.this.m14534();
                        if (r3 != null && !C2284wz.this.isDetached()) {
                            if (!C2284wz.this.f3520) {
                                r3.setRequestedOrientation(1);
                            }
                            zW r42 = zW.f12754.m13575(C2284wz.this.m14534(), ((C1931kb) aux).m8375());
                            r42.setCancelable(true);
                            r42.m13570(new DialogInterface() { // from class: o.wz.4.1.1
                                @Override // android.content.DialogInterface
                                public void cancel() {
                                    C2284wz.this.mo2248();
                                }

                                @Override // android.content.DialogInterface
                                public void dismiss() {
                                    C2284wz.this.mo2248();
                                }
                            });
                            r3.showDialog(r42);
                        }
                    }
                });
            } else {
                C2284wz.this.m2520();
                AbstractC1268 r2 = C2316xl.m12949(C2284wz.this, aux);
                if (r2 != null && r2.mo10135() != null && (r4 = C2284wz.this.m14536()) != null && r4.m9756() != null) {
                    r4.m9756().mo5362(r2);
                }
            }
        }
    };

    /* renamed from: ˎˏ  reason: contains not printable characters */
    private final IPlayer.AbstractC0027 f11904 = new IPlayer.AbstractC0027() { // from class: o.wz.10
        @Override // com.netflix.mediaclient.servicemgr.IPlayer.AbstractC0027
        /* renamed from: ˏ */
        public void mo1533() {
            if (C2284wz.this.f11899 != null) {
                if (C2284wz.this.mo2463() && !C2284wz.this.mo2265()) {
                    C2284wz.this.m2512(true);
                    C2284wz.this.f11899.m2333().mo906((Surface) null);
                } else if (!C2284wz.this.f3534.m12497()) {
                    C1283.m16854(C2284wz.f11898, "In postplay when surface is destroyed, do not exit");
                } else if (C2284wz.this.f3532.f11448 == PlayerFragment.PlayerFragmentState.ACTIVITY_PLAYER_LOADING_NEXT) {
                    C1283.m16854(C2284wz.f11898, "refreshing UI for new playback.");
                } else {
                    C1283.m16854(C2284wz.f11898, "Surface destroyed, exit if we are not already in it");
                    C2284wz.this.mo2248();
                }
            }
        }
    };

    /* renamed from: ˏˏ  reason: contains not printable characters */
    private final IPlayer.AbstractC1290If f11905 = new IPlayer.AbstractC1290If() { // from class: o.wz.1
        @Override // com.netflix.mediaclient.servicemgr.IPlayer.AbstractC1290If
        /* renamed from: ˋ */
        public void mo1524() {
            if (C2284wz.this.m2462() && C2284wz.this.f11899 != null) {
                C2284wz.this.f11899.setSurface();
                C2284wz.this.mo2247();
            }
        }
    };

    /* renamed from: o.wz$ˋ  reason: contains not printable characters */
    public class C0258 extends PlayerFragment.C0040 {
        public C0258() {
            super();
        }

        @Override // com.netflix.mediaclient.ui.player.PlayerFragment.C0040, android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (C0650.m14806() || (Config_Ab9454_InPlayerPivots.m525() && C2284wz.this.f3532.f11440 && Math.abs(seekBar.getProgress() - i) <= this.f3592)) {
                if (this.f3595) {
                    this.f3595 = false;
                } else {
                    C2274wp.m12442(seekBar);
                }
            }
            if (z && C2284wz.this.f3532.f11440 && C2284wz.this.f3534 != null && C2284wz.this.f11899 != null && C2284wz.this.f11899.m2333() != null) {
                C2284wz.this.f3534.m12500(i, -1, false);
                C2284wz.this.f3534.mo12462(C2284wz.this.f11899.m2333().mo905((long) i));
            } else if (!z && C2284wz.this.f3532.f11440 && C2284wz.this.f3534 != null) {
                C2284wz.this.f3534.m12500(i, -1, false);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PlayerFragment
    /* renamed from: ʻᐝ */
    public C2275wq.C0256 mo2456() {
        C2275wq.C0256 r1 = new C2275wq.C0256();
        r1.f11691 = new C0258();
        r1.f11695 = this.f3492;
        r1.f11688 = this.f3510;
        r1.f11692 = this.f3506;
        r1.f11693 = this.f3497;
        r1.f11694 = this.f3502;
        r1.f11689 = this.f3500;
        r1.f11690 = this.f3504;
        r1.f11696 = this.f3503;
        return r1;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static PlayerFragment m12720(String str, VideoType videoType, oX oXVar, int i, int i2) {
        C2284wz wzVar = new C2284wz();
        wzVar.setArguments(m2410(str, videoType, oXVar, i, i2));
        return wzVar;
    }

    @Override // com.netflix.mediaclient.ui.player.PlayerFragment, o.AbstractC0517, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PlayerFragment
    /* renamed from: ˏ */
    public int mo2492(PostPlayFactory.PostPlayType postPlayType) {
        return R.layout.playout_ab9691;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PlayerFragment
    /* renamed from: ˋ */
    public C2275wq mo2474(C2275wq.C0256 r2, PostPlayFactory.PostPlayType postPlayType) {
        return C2278wt.m12541(this, r2, postPlayType);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PlayerFragment
    /* renamed from: ॱʻ */
    public void mo2513() {
        if (m2516()) {
            C2278wt wtVar = (C2278wt) this.f3534;
            if (this.f11901 != null) {
                wtVar.m12544().setOnStartedListener(this.f11901);
            }
            if (this.f11902 != null) {
                wtVar.m12544().setOnPlayProgressListener(this.f11902);
            }
            if (this.f11900 != null) {
                wtVar.m12544().setOnCompletionListener(this.f11900);
            }
            if (this.f11903 != null) {
                wtVar.m12544().setOnErrorListener(this.f11903);
            }
            if (this.f11905 != null) {
                wtVar.m12544().setPlayerSurfaceAvailableListener(this.f11905);
            }
            if (this.f11904 != null) {
                wtVar.m12544().setPlayerSurfaceDestroyedListener(this.f11904);
            }
            wtVar.m12544().setViewInFocus(true);
            wtVar.m12544().mo2340(m2514(), C1349Bv.m4108(m2507().getPlayableId()), m2460(), AbstractC2055pd.f9383, mo1635(), (long) m2508(), true);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PlayerFragment
    /* renamed from: ʼˊ */
    public void mo2457() {
        m2503();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PlayerFragment
    /* renamed from: ᐝˋ */
    public long mo2518() {
        if (this.f11899 == null) {
            return 0;
        }
        this.f11899.m2350();
        return this.f11899.m2334();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PlayerFragment
    /* renamed from: ˊ */
    public void mo2468(int i, boolean z) {
        if (this.f11899 != null && this.f11899.m2333() != null) {
            if (z) {
                this.f11899.m2337(this.f11899.m2334() + ((long) i));
            } else {
                this.f11899.m2337((long) i);
            }
        }
    }

    @Override // com.netflix.mediaclient.ui.player.PlayerFragment
    /* renamed from: ʻˊ */
    public boolean mo2454() {
        if (this.f11899 != null) {
            return this.f11899.m2347();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PlayerFragment
    /* renamed from: ᐝˊ */
    public long mo2517() {
        if (this.f11899 == null) {
            return 0;
        }
        this.f11899.m2345();
        return this.f11899.m2334();
    }

    @Override // com.netflix.mediaclient.ui.player.PlayerFragment
    /* renamed from: ˊʼ */
    public boolean mo2471() {
        if (this.f11899 != null) {
            return this.f11899.m2331();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PlayerFragment
    /* renamed from: ᐝᐝ */
    public void mo2519() {
        if (mo2500() != null) {
            mo2500().mo919(-5000, 5000);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PlayerFragment
    /* renamed from: ˋ */
    public boolean mo2478(pT pTVar) {
        if (!super.mo2478(pTVar)) {
            return false;
        }
        C2278wt wtVar = (C2278wt) this.f3534;
        if (this.f3534 != null) {
            this.f11899 = wtVar.m12544();
            if (this.f11899 == null) {
                return true;
            }
            m2515();
            return true;
        }
        C1283.m16854(f11898, "Unable to update UI because NetflixVideoView is not available");
        m2504();
        return false;
    }

    @Override // com.netflix.mediaclient.ui.player.PlayerFragment
    /* renamed from: ˑ */
    public oM mo2500() {
        if (this.f11899 != null) {
            return this.f11899.m2333();
        }
        return null;
    }

    @Override // com.netflix.mediaclient.ui.player.PlayerFragment
    /* renamed from: ᐨ */
    public void mo2521() {
        C1283.m16862(f11898, "doZoomIn: start");
        C2278wt wtVar = (C2278wt) this.f3534;
        if (wtVar != null) {
            wtVar.mo12507(false);
            wtVar.m12492(true);
        }
    }

    @Override // com.netflix.mediaclient.ui.player.PlayerFragment
    /* renamed from: ꓸ */
    public void mo2524() {
        C1283.m16854(f11898, "doZoomOut: start");
        C2278wt wtVar = (C2278wt) this.f3534;
        if (wtVar != null) {
            wtVar.mo12507(true);
            wtVar.m12492(false);
        }
    }

    @Override // com.netflix.mediaclient.ui.player.PlayerFragment, com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ˊ */
    public void mo2236(boolean z) {
        if (m14535() && m2497()) {
            C2275wq wqVar = this.f3534;
            if (wqVar == null || PlayerUiState.Loading == wqVar.m12493()) {
                C1283.m16854(f11898, "UI is not in focus on splash screen. Do NOT pause, ignore.");
                return;
            }
            if (z) {
                mo2247();
            } else {
                mo2240();
            }
            C1283.m16854(f11898, "onWindowFocusChanged done");
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PlayerFragment
    /* renamed from: ʾॱ */
    public boolean mo2463() {
        return m14535() && this.f11899 != null && this.f11899.m2332() && !m2466() && this.f3534 != null && this.f3534.m12493() != PlayerUiState.PostPlay && this.f3498 != null && !this.f3498.mo16548() && this.f3498.mo16520().mo14183();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PlayerFragment
    /* renamed from: ʽˋ */
    public boolean mo2461() {
        return m14535() && C1317As.m3742(getActivity()) && this.f11899 != null && this.f11899.m2332() && !m2466() && this.f3534 != null && this.f3534.m12493() != PlayerUiState.PostPlay;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PlayerFragment
    /* renamed from: ꜞ */
    public void mo2525() {
        m2476(IClientLogging.CompletionReason.success);
        if (m2462()) {
            m2512(false);
        }
        m12723();
        m2481();
    }

    @Override // com.netflix.mediaclient.ui.player.PlayerFragment
    /* renamed from: ॱ */
    public void mo2511(Language language) {
        C1348Bu.m4093();
        if (language != null) {
            m2475(language);
            if (this.f11899 != null) {
                this.f11899.setAudioTrack(language.getSelectedAudio());
                this.f11899.setSubtitleTrack(language.getSelectedSubtitle());
            }
            language.commit();
        }
        C1283.m16854(f11898, "Language change should be completed");
    }

    @Override // com.netflix.mediaclient.ui.player.PlayerFragment, com.netflix.mediaclient.ui.player.IPlayerFragment
    /* renamed from: ॱˎ */
    public void mo2266() {
        if (this.f11899 != null) {
            this.f11899.m2350();
            this.f11899.m2328();
        }
        m2520();
        m2465();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PlayerFragment
    /* renamed from: ˍ */
    public void mo2483() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.f3508 = new BroadcastReceiver() { // from class: o.wz.9
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (!C2284wz.this.isDetached()) {
                        C2284wz.this.mo2513();
                    }
                }
            };
            activity.registerReceiver(this.f3508, new IntentFilter("ACTION_RELOAD_VIDEO"));
        }
    }

    /* renamed from: ՙ  reason: contains not printable characters */
    private void m12723() {
        if (this.f11899 != null) {
            this.f11899.m2327();
            this.f11899.setViewInFocus(false);
            this.f11899 = null;
        }
        m2520();
        if (this.f3534 != null) {
            this.f3534.m12532(false);
        }
        this.f3537.onNext(IPlayerFragment.PublisherEvents.ON_PLAYER_STOPPED);
        if (this.f3512 != null) {
            m2530();
        }
        this.f3512 = null;
        if (this.f3528 != null) {
            this.f3528.m12280();
        }
    }
}

package com.netflix.mediaclient.ui.player;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.configuration.persistent.Config_Ab9454_InPlayerPivots;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
import com.netflix.mediaclient.servicemgr.PlayerPrefetchSource;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.common.PlaybackLauncher;
import com.netflix.mediaclient.ui.player.PostPlayFactory;
import com.netflix.model.leafs.PostPlayAction;
import com.netflix.model.leafs.PostPlayExperience;
import com.netflix.model.leafs.PostPlayItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import o.AD;
import o.AbstractC2089qj;
import o.C0910;
import o.C1004;
import o.C1276;
import o.C1283;
import o.C1317As;
import o.C1352By;
import o.C1362Ch;
import o.C2059ph;
import o.C2279wu;
import o.oP;
import o.oX;
import o.pF;
import o.pN;
import o.pO;
import o.qK;
import o.wL;
public abstract class PostPlay {

    /* renamed from: ʻ  reason: contains not printable characters */
    protected View f3607;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private boolean f3608;

    /* renamed from: ʼ  reason: contains not printable characters */
    public LinearLayout f3609;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private String f3610;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected View f3611;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private final Runnable f3612;

    /* renamed from: ʾ  reason: contains not printable characters */
    private final Runnable f3613;

    /* renamed from: ʿ  reason: contains not printable characters */
    private PlayLocationType f3614;

    /* renamed from: ˈ  reason: contains not printable characters */
    private VideoType f3615;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected final NetflixActivity f3616;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    protected boolean f3617;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected IPlayerFragment f3618;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    protected C1352By.C0072 f3619;

    /* renamed from: ˎ  reason: contains not printable characters */
    public PostPlayExperience f3620;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected boolean f3621;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    protected View f3622;

    /* renamed from: ͺ  reason: contains not printable characters */
    protected boolean f3623;

    /* renamed from: ॱ  reason: contains not printable characters */
    public LinearLayout f3624;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    protected View f3625;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private boolean f3626;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    protected PostPlayDataFetchStatus f3627;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected View f3628;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    protected C0041 f3629;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected View f3630;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    protected boolean f3631;

    /* access modifiers changed from: protected */
    public enum PostPlayDataFetchStatus {
        notStarted,
        started
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public abstract UserActionLogging.PostPlayExperience mo2556();

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public abstract void mo2572();

    /* renamed from: ˏ  reason: contains not printable characters */
    public abstract void mo2579();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public abstract int mo2591();

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public abstract void mo2592();

    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo2574(Configuration configuration) {
    }

    protected PostPlay(NetflixActivity netflixActivity) {
        this.f3626 = false;
        this.f3612 = new Runnable() { // from class: com.netflix.mediaclient.ui.player.PostPlay.10
            @Override // java.lang.Runnable
            public void run() {
                if (PostPlay.this.f3618 == null) {
                    C1283.m16850("nf_postplay", "onInterrupterStart() - called with null PlayerFragment!");
                } else if (!PostPlay.this.f3618.mo2234().m12289()) {
                    C1283.m16854("nf_postplay", "Interrupter process, there was user interaction in meantime. Do nothing");
                } else if (PostPlay.this.f3618.mo2226().m12493() == PlayerUiState.Loading) {
                    C1283.m16854("nf_postplay", "This is 3rd consecutive auto play with no user interaction, but after 2 minutes we are still loading, postpone for 2 more minutes");
                    PostPlay.this.f3618.mo2238().postDelayed(this, PostPlay.this.m2551(true));
                } else if (PostPlay.this.f3630 != null) {
                    C1283.m16854("nf_postplay", "This is 3rd consecutive auto play with no user interaction, after 2 minutes start interrupter mode");
                    PostPlay.this.f3618.mo2240();
                    PostPlay.this.f3630.setVisibility(0);
                    PostPlay.this.f3618.mo2226().mo12453(PlayerUiState.Interrupter);
                    PostPlay.this.f3618.mo2238().postDelayed(PostPlay.this.f3613, PostPlay.this.m2551(false));
                    PostPlay.this.f3618.mo2234().m12291(0);
                } else {
                    C1283.m16865("nf_postplay", "Interrupter UI NOT found, this should not happen!");
                }
            }
        };
        this.f3613 = new Runnable() { // from class: com.netflix.mediaclient.ui.player.PostPlay.6
            @Override // java.lang.Runnable
            public void run() {
                if (PostPlay.this.f3618 == null) {
                    C1283.m16850("nf_postplay", "onInterrupterDismiss() - called with null PlayerFragment!");
                    return;
                }
                C1283.m16854("nf_postplay", "After 60 minutes of waiting for user input, close player ui");
                if (PostPlay.this.f3618.m2250()) {
                    PostPlay.this.f3618.mo2248();
                }
            }
        };
        this.f3616 = netflixActivity;
        mo2561();
        mo2579();
        m2568();
        this.f3627 = PostPlayDataFetchStatus.notStarted;
    }

    protected PostPlay(IPlayerFragment iPlayerFragment) {
        this(iPlayerFragment.m2242());
        this.f3618 = iPlayerFragment;
        C2279wu r4 = this.f3618.mo2239();
        if (r4 != null && r4.m12545() != null) {
            this.f3621 = this.f3618.mo2237(PlaybackLauncher.PlayLaunchedBy.LaunchActivity);
            int autoPlayMaxCount = r4.m12545().getAutoPlayMaxCount();
            if (this.f3618.mo2234().m12283() >= (autoPlayMaxCount <= -1 ? 3 : autoPlayMaxCount) && this.f3618.mo2234().m12289()) {
                C1283.m16854("nf_postplay", "This is 3rd consecutive auto play with no user interaction, start interrupter timeout");
                this.f3618.mo2238().postDelayed(this.f3612, m2551(true));
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private long m2551(boolean z) {
        return z ? 120000 : 3600000;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m2568() {
        if (this.f3625 != null) {
            this.f3625.setOnTouchListener(new View.OnTouchListener() { // from class: com.netflix.mediaclient.ui.player.PostPlay.1
                @Override // android.view.View.OnTouchListener
                @SuppressLint({"ClickableViewAccessibility"})
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    C1283.m16854("nf_postplay", "Hijacking tap, do nothing");
                    return true;
                }
            });
        }
        if (!C0910.m15708()) {
            if (this.f3628 != null) {
                this.f3628.setOnClickListener(new View.OnClickListener() { // from class: com.netflix.mediaclient.ui.player.PostPlay.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        C1283.m16854("nf_postplay", "Interrupter mode, continue");
                        PostPlay.this.m2570(false);
                    }
                });
            }
            if (this.f3607 != null) {
                this.f3607.setOnClickListener(new View.OnClickListener() { // from class: com.netflix.mediaclient.ui.player.PostPlay.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!C0910.m15708()) {
                            C1283.m16854("nf_postplay", "Interrupter mode, close");
                            if (PostPlay.this.f3618 != null) {
                                if (PostPlay.this.f3618.mo2238() != null) {
                                    PostPlay.this.f3618.mo2238().removeCallbacks(PostPlay.this.f3613);
                                }
                                if (PostPlay.this.f3618.m2250()) {
                                    PostPlay.this.f3618.mo2248();
                                }
                            }
                        }
                    }
                });
            } else {
                C1283.m16850("nf_postplay", "setClickListeners() - mInterrupterStop handler was not set!");
            }
            if (this.f3611 != null) {
                this.f3611.setOnClickListener(new View.OnClickListener() { // from class: com.netflix.mediaclient.ui.player.PostPlay.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        PostPlay.this.m2570(true);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo2561() {
        this.f3611 = this.f3616.findViewById(R.id.postplay_playFromBeginning);
        this.f3628 = this.f3616.findViewById(R.id.postplay_continueWatching);
        this.f3624 = (LinearLayout) this.f3616.findViewById(R.id.postplay_bgd_container);
        this.f3609 = (LinearLayout) this.f3616.findViewById(R.id.post_play_items);
        this.f3607 = this.f3616.findViewById(R.id.postplay_stopWatching);
        this.f3625 = this.f3616.findViewById(R.id.postplay_ignore_tap);
        this.f3630 = this.f3616.findViewById(R.id.interrupter);
        this.f3622 = this.f3616.findViewById(R.id.postplay);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public int m2573(pF pFVar) {
        int endtime = ((this.f3620 == null || !this.f3626) ? pFVar.getEndtime() : this.f3620.getSeamlessEnd()) * 1000;
        if (!pFVar.isSupplementalVideo() && pFVar.getRuntime() != endtime) {
            return endtime;
        }
        C1283.m16851("nf_postplay", "adjusting startOfCredits - isSupplemental: %b", Boolean.valueOf(pFVar.isSupplementalVideo()));
        return (int) TimeUnit.SECONDS.toMillis((long) (pFVar.getRuntime() - 2));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized void m2586(boolean z) {
        this.f3608 = z;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized boolean m2587() {
        return this.f3608;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.netflix.mediaclient.ui.player.PostPlay$ˋ  reason: contains not printable characters */
    public class C0042 extends oP {
        public C0042() {
            super("nf_postplay");
        }

        @Override // o.oP, o.oU
        public void onPostPlayImpressionLogged(boolean z, Status status) {
            super.onPostPlayImpressionLogged(z, status);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m2569(String str, VideoType videoType, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            C1283.m16854("nf_postplay", "Logging post play impression");
            this.f3616.getServiceManager().m9764().mo9482(str, videoType, str2, str3, new C0042());
            return;
        }
        C1283.m16850("nf_postplay", "Unable to log post play impression!");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized void mo2585(String str, VideoType videoType, PlayLocationType playLocationType) {
        if (!C1317As.m3750(this.f3616)) {
            if (!TextUtils.isEmpty(str)) {
                C1283.m16854("nf_postplay", "Fetch post_play videos...");
                C0041 r3 = new C0041();
                C1276.m16820().mo5728("nf_postplay: Requesting post play response for video ID: " + str + " Type: " + videoType);
                this.f3616.getServiceManager().m9764().mo9502(str, videoType, playLocationType, r3);
                this.f3629 = r3;
            } else {
                C1283.m16850("nf_postplay", "Unable to fetch post_play videos!");
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m2549(String str, VideoType videoType, PlayLocationType playLocationType) {
        C1283.m16854("nf_postplay", "fetchPostPlayVideosIfNeeded starts");
        this.f3610 = str;
        this.f3615 = videoType;
        this.f3614 = playLocationType;
        if (this.f3627 != PostPlayDataFetchStatus.started) {
            C1283.m16854("nf_postplay", "fetchPostPlayVideosIfNeeded: ready to fetch post_play, attempt to fetch it...");
            mo2585(str, videoType, playLocationType);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m2576(boolean z) {
        C1283.m16854("nf_postplay", "Transition to post play execute!");
        this.f3623 = true;
        if (this.f3622 != null && (this.f3618 == null || !this.f3618.mo2241())) {
            this.f3622.setFitsSystemWindows(true);
        }
        if (this.f3620 != null) {
            if (this.f3622 != null) {
                this.f3622.setVisibility(z ? 8 : 0);
            }
            if (m2552()) {
                C1362Ch.m4396(mo2554(), mo2591(), mo2556());
                PostPlayItem postPlayItem = this.f3620.getItems().get(0);
                m2569(String.valueOf(postPlayItem.getVideoId()), VideoType.create(postPlayItem.getType()), postPlayItem.getImpressionData(), this.f3620.getImpressionToken());
            }
            mo2572();
            return;
        }
        C1276.m16820().mo5727("SPY-10544 - Error transitioning to post play. No post play experience defined.");
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m2575(PlayLocationType playLocationType) {
        if (this.f3618 != null && this.f3618.m2250()) {
            this.f3619 = new C1352By.C0072(this.f3616);
            this.f3619.m4148(this.f3620.getAutoplaySeconds());
            if (this.f3620.getItems() == null || this.f3620.getItems().isEmpty()) {
                C1276.m16820().mo5725("No items in the post play experience.");
                return;
            }
            Integer itemsInitialIndex = this.f3620.getItemsInitialIndex();
            if (itemsInitialIndex == null) {
                C1276.m16820().mo5725("PostPlay initial Index is missing. Setting a default value.");
                itemsInitialIndex = 0;
            }
            PostPlayItem postPlayItem = this.f3620.getItems().get(itemsInitialIndex.intValue());
            if (postPlayItem == null || postPlayItem.getPlayAction() == null) {
                C1276.m16820().mo5725("no autoplay action found in postplay experience.");
                return;
            }
            final wL wLVar = new wL(this.f3616, this.f3618, postPlayItem.getPlayAction(), playLocationType);
            this.f3619.m4147(new Runnable() { // from class: com.netflix.mediaclient.ui.player.PostPlay.5
                @Override // java.lang.Runnable
                public void run() {
                    if (PostPlay.this.f3623 && !PostPlay.this.f3608) {
                        wLVar.m12337(true);
                    }
                }
            });
            this.f3619.m4149(new Runnable() { // from class: com.netflix.mediaclient.ui.player.PostPlay.9
                @Override // java.lang.Runnable
                public void run() {
                    PostPlay.this.mo2583(PostPlay.this.f3619.m4146());
                }
            });
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo2583(int i) {
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public boolean mo2554() {
        return m2588();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean m2552() {
        String type;
        if (this.f3620 == null || (type = this.f3620.getType()) == null) {
            return false;
        }
        if (type.equalsIgnoreCase("originalsPostPlay") || type.equalsIgnoreCase("kidsOriginalsPostPlay")) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ᐝ  reason: contains not printable characters */
    public boolean m2593() {
        return true;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public void m2582() {
        C1283.m16854("nf_postplay", "Transition from post play execute!");
        this.f3623 = false;
        mo2589();
        if (this.f3622 != null) {
            this.f3622.setVisibility(4);
            this.f3622.setFitsSystemWindows(false);
        }
        if (m2593()) {
            C1283.m16854("nf_postplay", "User dismissed post_play, report as such");
            C1362Ch.m4392(IClientLogging.CompletionReason.canceled, IClientLogging.ModalView.playback, null, true, false, null, null, 0);
        }
        mo2567();
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public void mo2567() {
    }

    @Deprecated
    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m2578(long j, long j2) {
        if (this.f3618 == null) {
            C1283.m16850("nf_postplay", "updatePlaybackPosition() - called with null PlayerFragment!");
            return false;
        } else if (!m2581()) {
            return false;
        } else {
            boolean r2 = m2548(j, j2);
            if (this.f3623 && r2) {
                C1283.m16854("nf_postplay", "Already in post play");
                return true;
            } else if (this.f3618.mo2226().m12493() == PlayerUiState.Interrupter) {
                C1283.m16854("nf_postplay", "In Interrupter mode, do nothing");
                return false;
            } else if (this.f3623 && !r2) {
                C1283.m16854("nf_postplay", "Transition from post play to normal");
                m2582();
                return false;
            } else if (this.f3623 || !r2) {
                C1283.m16854("nf_postplay", "Not in in post play");
                return false;
            } else {
                C1283.m16854("nf_postplay", "Transition to post play");
                if (this.f3618.mo2265() || Config_Ab9454_InPlayerPivots.m521()) {
                    return true;
                }
                this.f3618.mo2226().mo12453(PlayerUiState.PostPlay);
                return true;
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m2562(long j, long j2) {
        if (this.f3618 == null) {
            C1283.m16850("nf_postplay", "updatePlaybackPosition() - called with null PlayerFragment!");
        } else if (m2581()) {
            boolean r2 = m2548(j, j2);
            if (this.f3623 && r2) {
                C1283.m16854("nf_postplay", "Already in post play");
            } else if (this.f3618.mo2234().m12290()) {
                C1283.m16854("nf_postplay", "In Interrupter mode, do nothing");
            } else if (this.f3623 && !r2) {
                C1283.m16854("nf_postplay", "Transition from post play to normal");
                m2582();
            } else if (this.f3623 || !r2) {
                C1283.m16854("nf_postplay", "Not in in post play");
            } else {
                C1283.m16854("nf_postplay", "Transition to post play");
                if (!this.f3618.mo2265() && !Config_Ab9454_InPlayerPivots.m521()) {
                    this.f3618.mo2249();
                }
            }
        }
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public boolean m2581() {
        if (mo2577() && !this.f3617) {
            return true;
        }
        return false;
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public boolean m2588() {
        AbstractC2089qj r4;
        if (this.f3618 == null) {
            C1283.m16850("nf_postplay", "isAutoPlayEnabled() - called with null PlayerFragment!");
            return false;
        } else if (!this.f3618.m2250()) {
            C1283.m16850("nf_postplay", "Activity not found! Auto post_play is NOT enabled. This should NOT happen!");
            return false;
        } else {
            pF r2 = this.f3618.mo2239().m12545();
            if (r2 == null) {
                C1283.m16850("nf_postplay", "playable not found! Auto post_play is NOT enabled. This should NOT happen!");
                return false;
            } else if (!r2.isAutoPlayEnabled()) {
                C1283.m16854("nf_postplay", "Autoplay is disabled for this title");
                return false;
            } else {
                C2059ph r3 = this.f3618.m2257();
                if (r3 == null || (r4 = r3.m9826()) == null) {
                    return false;
                }
                if (r4.isAutoPlayEnabled()) {
                    C1283.m16854("nf_postplay", "Autoplay is enabled for this profile");
                    return true;
                }
                C1283.m16854("nf_postplay", "Autoplay is disabled for this profile");
                return false;
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean mo2577() {
        return this.f3631;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m2548(long j, long j2) {
        pF r5;
        if (this.f3618 == null) {
            C1283.m16850("nf_postplay", "inPostPlay() - called with null PlayerFragment!");
            return false;
        } else if (!this.f3618.m2250() || (r5 = this.f3618.mo2239().m12545()) == null) {
            return false;
        } else {
            long r6 = (long) m2573(r5);
            C1283.m16851("nf_postplay", "Duration %d, startOfCredits: %d, currentPosition: %d", Long.valueOf(j2), Long.valueOf(r6), Long.valueOf(j));
            return j > 0 && j >= r6;
        }
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    public boolean m2590() {
        return this.f3623;
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    public void m2553() {
        if (this.f3622 != null) {
            this.f3622.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.netflix.mediaclient.ui.player.PostPlay$ˊ  reason: contains not printable characters */
    public class C0041 extends oP {
        public C0041() {
            super("nf_postplay");
            PostPlay.this.f3627 = PostPlayDataFetchStatus.started;
        }

        @Override // o.oP, o.oU
        public void onPostPlayVideosFetched(pO pOVar, Status status) {
            super.onPostPlayVideosFetched(pOVar, status);
            PostPlay.this.f3627 = PostPlayDataFetchStatus.notStarted;
            if (!C1317As.m3750(PostPlay.this.f3616)) {
                synchronized (PostPlay.this) {
                    if (PostPlay.this.f3629 != this) {
                        C1283.m16865("nf_postplay", "Not current callback");
                        return;
                    }
                }
                if (status.mo301() || pOVar == null) {
                    C1283.m16865("nf_postplay", "Error loading post play data");
                    PostPlay.this.f3631 = false;
                    if (NetflixApplication.m223()) {
                        C1004.m15961(PostPlay.this.f3616, "[DEBUG] loading post play data failed", 1);
                        return;
                    }
                    return;
                }
                PostPlay.this.m2584(pOVar.getPostPlayExperienceData());
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m2584(PostPlayExperience postPlayExperience) {
        this.f3620 = postPlayExperience;
        this.f3631 = (this.f3620 == null || this.f3620.getItems() == null || this.f3620.getItems().isEmpty()) ? false : true;
        if (this.f3631) {
            boolean z = false;
            oX r6 = ((qK) this.f3616).mo1635();
            if (this.f3620.getAutoplay() && this.f3620.getAutoplaySeconds() > 0) {
                PostPlayItem postPlayItem = this.f3620.getItems().get(this.f3620.getItemsInitialIndex().intValue());
                if (postPlayItem != null) {
                    postPlayItem.setAutoPlay(true);
                    this.f3626 = this.f3620.getType().equals("nextEpisodeSeamless");
                    if (this.f3626) {
                        C1283.m16854("nf_postplay", "Entering post play next episode seamless experience");
                        this.f3620.setAutoplaySeconds(this.f3620.getSeamlessCountdownSeconds());
                        postPlayItem.setNextEpisodeSeamless(true);
                        postPlayItem.setAutoPlaySeconds(this.f3620.getAutoplaySeconds());
                        if (postPlayItem.getPlayAction() != null) {
                            postPlayItem.setSeamlessStart(postPlayItem.getPlayAction().getSeamlessStart());
                        } else {
                            postPlayItem.setSeamlessStart(0);
                        }
                    } else {
                        C1283.m16854("nf_postplay", "Entering post play next episode experience");
                        postPlayItem.setAutoPlaySeconds(this.f3620.getAutoplaySeconds());
                        postPlayItem.setNextEpisodeAutoPlay(this.f3620.getType().equals("nextEpisode"));
                    }
                    pF pFVar = null;
                    Iterator<PostPlayAction> it = postPlayItem.getActions().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        pN playBackVideo = it.next().getPlayBackVideo();
                        if (!(playBackVideo == null || playBackVideo.isPreRelease())) {
                            pFVar = playBackVideo.getPlayable();
                            break;
                        }
                    }
                    if (pFVar != null) {
                        C1283.m16863("nf_postplay", "prepare for initial index %d", this.f3620.getItemsInitialIndex());
                        this.f3616.playerPrepare(pFVar, PlayerPrefetchSource.PostPlay, r6);
                        z = true;
                    }
                } else {
                    C1283.m16850("nf_postplay", "Could not find autoplay item");
                }
            }
            int i = 0;
            for (int i2 = 0; i2 < this.f3620.getItems().size(); i2++) {
                PostPlayItem postPlayItem2 = this.f3620.getItems().get(i2);
                if (postPlayItem2 != null) {
                    C1276.m16820().mo5728("nf_postplay: Processing post play response for item video ID: " + postPlayItem2.getVideoId());
                    postPlayItem2.setExperienceType(this.f3620.getType());
                    for (PostPlayAction postPlayAction : postPlayItem2.getActions()) {
                        postPlayAction.setItemIndex(i2);
                        postPlayAction.setRequestId(this.f3620.getRequestId());
                        postPlayAction.setAncestorTitle(postPlayItem2.getAncestorTitle());
                        if (!z) {
                            pN playBackVideo2 = postPlayAction.getPlayBackVideo();
                            pF playable = (playBackVideo2 == null || playBackVideo2.isPreRelease()) ? null : playBackVideo2.getPlayable();
                            if (playable != null) {
                                C1283.m16863("nf_postplay", "prepare for index=%d", Integer.valueOf(i2));
                                this.f3616.playerPrepare(playable, PlayerPrefetchSource.PostPlay, r6);
                                z = true;
                            }
                        }
                    }
                    if (m2564(postPlayItem2)) {
                        i++;
                    }
                }
            }
            if (i == 0) {
                C1283.m16850("nf_postplay", "No playable items in post play response");
                this.f3631 = false;
            }
        }
        mo2592();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m2564(PostPlayItem postPlayItem) {
        PostPlayAction playAction;
        if (postPlayItem == null || (playAction = postPlayItem.getPlayAction()) == null) {
            return false;
        }
        C1276.m16820().mo5728("nf_postplay: Checking post play play action video ID: " + playAction.getVideoId());
        return (playAction.getPlayBackVideo() == null || playAction.getPlayBackVideo().getPlayable() == null) ? false : true;
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    public void mo2589() {
        this.f3617 = true;
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public boolean m2594() {
        return this.f3617;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo2563(boolean z) {
        if (this.f3624 == null) {
            return;
        }
        if (z) {
            this.f3624.setVisibility(0);
        } else {
            this.f3624.setVisibility(4);
        }
    }

    /* renamed from: ʼॱ  reason: contains not printable characters */
    public void m2555() {
        if (this.f3619 != null) {
            this.f3619.m4150();
        }
        if (!(this.f3618 == null || this.f3618.mo2238() == null)) {
            this.f3618.mo2238().removeCallbacks(this.f3612);
            this.f3618.mo2238().removeCallbacks(this.f3613);
        }
        C1283.m16854("nf_postplay", "User exits playback and post_play if it was in progress, report as such");
        C1362Ch.m4392(IClientLogging.CompletionReason.canceled, IClientLogging.ModalView.playback, null, true, false, null, null, 0);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m2570(boolean z) {
        if (!C0910.m15708()) {
            if (this.f3618 == null || this.f3618.mo2238() == null) {
                C1283.m16850("nf_postplay", "moveFromInterruptedToPlaying() - called with null PlayerFragment!");
                return;
            }
            this.f3618.mo2238().removeCallbacks(this.f3613);
            this.f3630.setVisibility(8);
            this.f3618.mo2226().m12498();
            this.f3618.mo2245().mo9033(true);
            if (z) {
                C1283.m16854("nf_postplay", "Interrupter mode, play from start");
                this.f3618.mo2258(0);
                return;
            }
            C1283.m16854("nf_postplay", "Interrupter mode, continue");
            this.f3618.mo2247();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static PostPlayFactory.PostPlayType m2546(NetflixActivity netflixActivity, pF pFVar, VideoType videoType) {
        boolean r2 = netflixActivity.getServiceManager().m9758();
        boolean r3 = AD.m3299();
        boolean z = videoType == VideoType.MOVIE;
        if (r2) {
            if (r3) {
                C1283.m16854("nf_postplay", "SignupForTablet post_play layout");
                return PostPlayFactory.PostPlayType.SignupForTablet;
            }
            C1283.m16854("nf_postplay", "SignupForPhone post_play layout");
            return PostPlayFactory.PostPlayType.SignupForPhone;
        } else if (r3) {
            if (z) {
                C1283.m16854("nf_postplay", "RecommendationForTablet post_play layout");
                return PostPlayFactory.PostPlayType.RecommendationForTablet;
            } else if (pFVar.isNextPlayableEpisode()) {
                C1283.m16854("nf_postplay", "EpisodesForTablet post_play layout");
                return PostPlayFactory.PostPlayType.EpisodesForTablet;
            } else {
                C1283.m16854("nf_postplay", "RecommendationForTablet post_play layout");
                return PostPlayFactory.PostPlayType.RecommendationForTablet;
            }
        } else if (z) {
            C1283.m16854("nf_postplay", "Phone recommendation (no) post_play layout");
            return PostPlayFactory.PostPlayType.RecommendationForPhone;
        } else if (pFVar.isNextPlayableEpisode()) {
            C1283.m16854("nf_postplay", "Phone episodes post_play layout");
            return PostPlayFactory.PostPlayType.EpisodesForPhone;
        } else {
            C1283.m16854("nf_postplay", "There will be no next episode, use phone recommendation (no) post_play layout");
            return PostPlayFactory.PostPlayType.RecommendationForPhone;
        }
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    public void mo2559() {
        if (this.f3618 == null) {
            C1283.m16850("nf_postplay", "endOfPlay() - called with null PlayerFragment!");
        } else if (!C0910.m15708()) {
            this.f3618.mo2245().mo9027();
        }
    }

    /* renamed from: ʽॱ  reason: contains not printable characters */
    public void m2557() {
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public void m2558() {
        m2544();
    }

    /* renamed from: ˉ  reason: contains not printable characters */
    private void m2544() {
        if (!(this.f3620 == null || this.f3610 == null || this.f3615 == null || this.f3614 == null)) {
            ArrayList arrayList = new ArrayList();
            for (PostPlayItem postPlayItem : this.f3620.getItems()) {
                PostPlayAction playAction = postPlayItem.getPlayAction();
                if (playAction != null && playAction.getPlayBackVideo() == null) {
                    arrayList.add(playAction);
                }
            }
            if (arrayList.size() > 0) {
                m2549(this.f3610, this.f3615, this.f3614);
            }
        }
    }

    /* renamed from: ˈ  reason: contains not printable characters */
    public void m2560() {
    }

    /* renamed from: ˊˋ  reason: contains not printable characters */
    public void m2566() {
    }

    /* renamed from: ˋˊ  reason: contains not printable characters */
    public void m2571() {
        this.f3620 = null;
        this.f3608 = false;
        this.f3627 = PostPlayDataFetchStatus.notStarted;
        this.f3631 = false;
        this.f3617 = false;
        this.f3623 = false;
    }

    @Deprecated
    /* renamed from: ˊˊ  reason: contains not printable characters */
    public void m2565() {
        if (this.f3618 != null) {
            C2279wu r3 = this.f3618.mo2239();
            if (r3 != null) {
                m2549(r3.m12545().getPlayableId(), r3.m12546(), r3.m12563().mo9590());
            } else {
                C1283.m16850("nf_postplay", "Illegal State : Unable to fetch postplay information for a null Playable.");
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m2580(C2279wu wuVar) {
        if (wuVar.m12545() != null) {
            m2549(wuVar.m12545().getPlayableId(), wuVar.m12546(), wuVar.m12563().mo9590());
        } else {
            C1283.m16850("nf_postplay", "Illegal State : Unable to fetch postplay information for a null Playable.");
        }
    }
}

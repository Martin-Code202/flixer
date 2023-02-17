package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.IPlayer;
import com.netflix.mediaclient.servicemgr.PlayerPrefetchSource;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.player.IPlayerFragment;
import com.netflix.model.leafs.PrePlayExperiences;
import com.netflix.model.leafs.blades.PrePlayItem;
import com.netflix.model.leafs.blades.PreplayItemAction;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
public final class wV {

    /* renamed from: ʻ  reason: contains not printable characters */
    private String f11536;

    /* renamed from: ʽ  reason: contains not printable characters */
    private PrePlayItem f11537;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final IPlayerFragment f11538;

    /* renamed from: ˋ  reason: contains not printable characters */
    private C2279wu f11539;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AtomicBoolean f11540 = new AtomicBoolean(false);

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AtomicBoolean f11541 = new AtomicBoolean(false);

    /* renamed from: ॱ  reason: contains not printable characters */
    private C2279wu f11542;

    public wV(IPlayerFragment iPlayerFragment) {
        this.f11538 = iPlayerFragment;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m12372() {
        return this.f11542 == null && this.f11539 != null && this.f11539.m12545() != null && this.f11539.m12545().supportsPrePlay();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m12378() {
        return this.f11542 != null;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized boolean m12375() {
        return this.f11541.get();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m12377(pT pTVar) {
        if (this.f11539 != null) {
            this.f11540.set(true);
            this.f11538.m2257().m9764().mo9512(this.f11539.m12545().getPlayableId(), this.f11539.m12546(), new Cif(pTVar));
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C2279wu m12373() {
        return this.f11539;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C2279wu m12376() {
        return this.f11542;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m12379() {
        if (this.f11539 == null) {
            C1283.m16850("PrePlayManager", "Unable to start preplay with a main Content item that is null.");
            return;
        }
        this.f11541.set(true);
        if (C0910.m15708()) {
            this.f11542 = null;
        }
        m12369();
        AnonymousClass4 r3 = new oP("PrePlayManager") { // from class: o.wV.4
            @Override // o.oP, o.oU
            public void onMovieDetailsFetched(pP pPVar, Status status) {
                super.onMovieDetailsFetched(pPVar, status);
                if (status.mo298() && pPVar != null) {
                    m12380(pPVar);
                }
            }

            @Override // o.oP, o.oU
            public void onEpisodeDetailsFetched(pI pIVar, Status status) {
                super.onEpisodeDetailsFetched(pIVar, status);
                if (status.mo298() && pIVar != null) {
                    m12380(pIVar);
                }
            }

            /* renamed from: ˏ  reason: contains not printable characters */
            private void m12380(pT pTVar) {
                if (wV.this.f11538.m2250()) {
                    wV.this.f11538.m2242().playerPrepare(pTVar.getPlayable(), PlayerPrefetchSource.PrePlay, wV.this.f11539.m12563());
                }
            }
        };
        if (!this.f11538.m2250()) {
            return;
        }
        if (this.f11539.m12546() == VideoType.MOVIE) {
            this.f11538.m2257().m9764().mo9513(this.f11539.m12545().getPlayableId(), (String) null, r3);
        } else {
            this.f11538.m2257().m9764().mo9484(this.f11539.m12545().getPlayableId(), null, r3);
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m12369() {
        if (this.f11542 != null && this.f11537 != null) {
            C1283.m16854("PrePlayManager", "logging preplay impression");
            this.f11538.m2257().m9764().mo9470(this.f11542.m12545().getPlayableId(), this.f11537.impressionData(), new oP("PrePlayManager") { // from class: o.wV.5
                @Override // o.oP, o.oU
                public void onPrePlayImpressionLogged(boolean z, Status status) {
                    super.onPrePlayImpressionLogged(z, status);
                }
            });
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m12370() {
        this.f11541.set(false);
        this.f11542 = null;
        this.f11539 = null;
        this.f11540.set(false);
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public boolean m12371() {
        return this.f11540.get();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12374(C2279wu wuVar) {
        this.f11539 = wuVar;
        if (!C0910.m15708()) {
            this.f11542 = null;
        }
    }

    /* renamed from: o.wV$if  reason: invalid class name */
    class Cif extends oP {

        /* renamed from: ˊ  reason: contains not printable characters */
        private pT f11545;

        /* renamed from: ˏ  reason: contains not printable characters */
        private oX f11547 = new oB("PrePlayManager");

        public Cif(pT pTVar) {
            super("PrePlayManager");
            this.f11545 = pTVar;
        }

        @Override // o.oP, o.oU
        public void onPreplayVideoFetched(PrePlayExperiences prePlayExperiences, Status status) {
            super.onPreplayVideoFetched(prePlayExperiences, status);
            if (prePlayExperiences != null) {
                List<PrePlayItem> experiences = prePlayExperiences.getExperiences();
                if (wV.this.f11538.m2250()) {
                    if (status.mo301() || experiences == null || experiences.size() == 0) {
                        C1283.m16865("PrePlayManager", "No preplay information for the current title.");
                    } else {
                        wV.this.f11537 = experiences.get(0);
                        wV.this.f11536 = prePlayExperiences.getUiLabel();
                        if (wV.this.f11537 != null) {
                            PreplayItemAction preplayItemAction = (wV.this.f11537.actions() == null || wV.this.f11537.actions().size() == 0) ? null : wV.this.f11537.actions().get(0);
                            if (preplayItemAction != null) {
                                this.f11547 = new qN(prePlayExperiences.getType(), preplayItemAction.trackId(), 0, 0);
                                this.f11547.mo9591(prePlayExperiences.isAutoplay());
                                wV.this.f11538.m2257().m9764().mo9513(preplayItemAction.videoId(), (String) null, this);
                                return;
                            }
                        }
                    }
                    wV.this.f11542 = null;
                    wV.this.f11540.set(false);
                    wV.this.f11538.mo2262(this.f11545, status, IPlayer.PlaybackType.StreamingPlayback);
                }
            }
        }

        @Override // o.oP, o.oU
        public void onMovieDetailsFetched(pP pPVar, Status status) {
            super.onMovieDetailsFetched(pPVar, status);
            wV.this.f11540.set(false);
            if (status.mo301() || pPVar == null) {
                C1283.m16865("PrePlayManager", "Error loading video details for video playback");
                wV.this.f11542 = null;
            } else {
                C1283.m16846("PrePlayManager", "Retrieved details: " + pPVar.getTitle() + ", " + pPVar);
                wV.this.f11542 = new C2279wu(pPVar.getPlayable(), pPVar.getType(), this.f11547, pPVar.getPlayable().getPlayableBookmarkPosition(), new wS(wV.this.f11536));
            }
            wV.this.f11538.mo2262(pPVar, status, IPlayer.PlaybackType.StreamingPlayback);
        }
    }
}

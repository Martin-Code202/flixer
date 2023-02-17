package o;

import com.netflix.falkor.task.CmpTaskMode;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.BillboardInteractionType;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import com.netflix.model.leafs.FlatGenreListOfVideosSummary;
import com.netflix.model.leafs.LoLoMoSummary;
import com.netflix.model.leafs.PrePlayExperiences;
import com.netflix.model.leafs.TrailersFeedItemSummary;
import com.netflix.model.leafs.Video;
import com.netflix.model.leafs.advisory.Advisory;
import com.netflix.model.leafs.advisory.ExpiringContentAdvisory;
import com.netflix.model.leafs.social.IrisNotificationSummary;
import java.io.File;
import java.util.List;
import java.util.Map;
import o.ServiceC0966;
/* renamed from: o.l  reason: case insensitive filesystem */
public class C1954l implements AbstractC2050oz {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C1926k f8497;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final ServiceC0966.Cif f8498;

    public C1954l(C1926k kVar, ServiceC0966.Cif ifVar) {
        this.f8497 = kVar;
        this.f8498 = ifVar;
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo8517(AbstractC0487 r4, int i, int i2) {
        this.f8497.m8154(r4, m8462(new If(i, i2)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo8509(int i, String str, int i2, int i3) {
        this.f8497.m8162(i, str, false, m8462(new If(i2, i3)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo8488(String str, int i, int i2, int i3, int i4, boolean z, int i5, int i6, int i7) {
        this.f8497.m8164(str, i, i2, i3, i4, z, i5, m8462(new If(i6, i7)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo8499(String str, int i, int i2, int i3, int i4) {
        this.f8497.mo7816(str, i, i2, m8462(new If(i3, i4)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo8483(pC pCVar, int i, int i2, boolean z, boolean z2, boolean z3, int i3, int i4) {
        this.f8497.m8144(pCVar, i, i2, z, z2, z3, m8462(new If(i3, i4)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo8493(pC pCVar, int i, int i2, boolean z, int i3, int i4) {
        this.f8497.m8143(pCVar, i, i2, z, m8462(new If(i3, i4)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo8489(String str, CmpTaskMode cmpTaskMode, VideoType videoType, int i, int i2, int i3, int i4) {
        this.f8497.mo7810(str, cmpTaskMode, videoType, i, i2, m8462(new If(i3, i4)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo8511(String str, CmpTaskMode cmpTaskMode, int i, int i2) {
        this.f8497.m8156(str, cmpTaskMode, m8462(new If(i, i2)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo8466(int i, int i2, String str, int i3, int i4) {
        this.f8497.m8149(i, i2, str, m8462(new If(i3, i4)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo8496(int i, int i2, String str, int i3, int i4) {
        this.f8497.m8135(i, i2, str, m8462(new If(i3, i4)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo8507(int i, int i2, String str, int i3, int i4) {
        this.f8497.m8127(i, i2, str, m8462(new If(i3, i4)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo8465(int i, int i2, int i3) {
        this.f8497.m8163(i, m8462(new If(i2, i3)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo8475(VideoType videoType, String str, boolean z, int i, int i2) {
        this.f8497.m8151(videoType, str, z, m8462(new If(i, i2)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo8481(String str, VideoType videoType, PlayLocationType playLocationType, int i, int i2) {
        this.f8497.mo7821(str, videoType, playLocationType, m8462(new If(i, i2)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo8480(String str, VideoType videoType, int i, int i2) {
        this.f8497.m8140(str, videoType, m8462(new If(i, i2)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo8482(String str, String str2, int i, int i2) {
        this.f8497.m8141(str, str2, m8462(new If(i, i2)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo8502(String str, VideoType videoType, String str2, String str3, int i, int i2) {
        this.f8497.m8139(str, videoType, str2, str3, m8462(new If(i, i2)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo8508(int i, int i2, pC pCVar, boolean z, int i3, int i4) {
        this.f8497.m8161(i, i2, pCVar, z, m8462(new If(i3, i4)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo8477(String str, int i, int i2) {
        this.f8497.m8142(str, m8462(new If(i, i2)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo8510(String str, int i, int i2) {
        this.f8497.m8132(str, m8462(new If(i, i2)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo8486(String str, int i, int i2) {
        this.f8497.m8153(str, m8462(new If(i, i2)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo8504(String str, String str2, int i, int i2) {
        this.f8497.mo7805(str, str2, m8462(new If(i, i2)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo8515(List<? extends AbstractC2072pu> list, int i, int i2) {
        this.f8497.m8171(list, m8462(new If(i, i2)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo8468(String str, int i, int i2) {
        this.f8497.m8159(str, m8462(new If(i, i2)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo8472(String str, String str2, int i, int i2) {
        this.f8497.mo7817(str, str2, m8462(new If(i, i2)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo8467(VideoType videoType, String str, String str2, int i, int i2) {
        this.f8497.m8155(videoType, str, str2, m8462(new If(i, i2)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo8491(String str, String str2, int i, int i2) {
        this.f8497.m8168(str, str2, m8462(new If(i, i2)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo8514(String str, String str2, boolean z, int i, int i2) {
        this.f8497.mo7806(str, str2, z, m8462(new If(i, i2)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo8506(int i, int i2) {
        this.f8497.m8146(m8462(new If(i, i2)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo8500(String str, CmpTaskMode cmpTaskMode, int i, int i2) {
        this.f8497.m8138(str, cmpTaskMode, m8462(new If(i, i2)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo8469(String str, int i, int i2, int i3, int i4) {
        this.f8497.m8137(str, i, i2, m8462(new If(i3, i4)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo8501(String str, VideoType videoType, int i, int i2, int i3, int i4) {
        this.f8497.m8130(str, videoType, i, i2, m8462(new If(i3, i4)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo8490(String str, VideoType videoType, int i, String str2, int i2, int i3) {
        this.f8497.m8167(str, videoType, i, str2, m8462(new If(i2, i3)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo8513(String str, VideoType videoType, String str2, int i, int i2) {
        this.f8497.m8158(str, videoType, str2, m8462(new If(i, i2)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo8516(pJ pJVar, BillboardInteractionType billboardInteractionType, Map<String, String> map) {
        this.f8497.m8145(pJVar, billboardInteractionType, map);
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo8479(String str, CmpTaskMode cmpTaskMode, boolean z, int i, int i2) {
        this.f8497.m8165(str, cmpTaskMode, z, m8462(new If(i, i2)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo8478(String str, CmpTaskMode cmpTaskMode, int i, int i2, int i3, int i4, boolean z) {
        this.f8497.m8129(str, cmpTaskMode, i3, i4, z, m8462(new If(i, i2)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo8487(String str, int i, int i2, int i3, int i4) {
        this.f8497.m8170(str, m8462(new If(i, i2)), i3, i4);
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo8484() {
        this.f8497.m8147(true);
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo8476(File file) {
        this.f8497.m8136(file);
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo8494(boolean z, String str) {
        this.f8497.m8172(z, str);
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo8473() {
        this.f8497.A_();
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo8464() {
        this.f8497.m8148();
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo8470(String str, VideoType videoType) {
        this.f8497.m8166(str, videoType);
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo8471(String str, VideoType videoType, int i) {
        this.f8497.m8152(str, videoType, i);
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo8474(int i, int i2, int i3, int i4) {
        this.f8497.m8128(i, i2, m8462(new If(i3, i4)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo8497(int i, int i2, boolean z, int i3, int i4) {
        this.f8497.m8150(i, i2, z, m8462(new If(i3, i4)));
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo8495(boolean z, boolean z2, boolean z3, C1999nc ncVar) {
        this.f8497.mo7807(z, z2, z3, ncVar);
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo8485(IrisNotificationSummary irisNotificationSummary) {
        this.f8497.mo7814(irisNotificationSummary);
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo8492(List<IrisNotificationSummary> list) {
        this.f8497.m8133(list);
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo8503(String str, ExpiringContentAdvisory.ContentAction contentAction) {
        this.f8497.m8131(str, contentAction);
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo8498(String str, int i, int i2) {
        this.f8497.m8169(str, new If(i, i2));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private AbstractC1203 m8462(AbstractC1203 r2) {
        return new C1204(r2);
    }

    /* renamed from: o.l$If */
    class If implements AbstractC1203 {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final int f8499;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final int f8501;

        If(int i, int i2) {
            this.f8499 = i;
            this.f8501 = i2;
        }

        @Override // o.AbstractC1203
        /* renamed from: ˎ */
        public void mo7402(LoLoMoSummary loLoMoSummary, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for client onLoLoMoPrefetched");
            } else {
                oLVar.mo9556(this.f8501, loLoMoSummary, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo8528(LoLoMoSummary loLoMoSummary, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for client onGenreLoLoMoPrefetched");
            } else {
                oLVar.mo9532(this.f8501, loLoMoSummary, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ˎ */
        public void mo7393(List<pC> list, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onLoMosFetched");
            } else {
                oLVar.mo9525(this.f8501, list, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ॱॱ */
        public void mo7398(List<pJ> list, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onVideosFetched");
            } else {
                oLVar.mo9551(this.f8501, list, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ʼ */
        public void mo7394(List<pK> list, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onTallPanelVideosFetched");
            } else {
                oLVar.mo9545(this.f8501, list, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo8538(FlatGenreListOfVideosSummary flatGenreListOfVideosSummary, List<pJ> list, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onFlatGenreVideosFetched");
            } else {
                oLVar.mo9550(this.f8501, flatGenreListOfVideosSummary, list, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo8531(pA pAVar, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onLoLoMoSummaryFetched");
            } else {
                oLVar.mo9552(this.f8501, pAVar, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ˎ  reason: contains not printable characters */
        public void mo8525(Video.Summary summary, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onVideoSummaryFetched");
            } else {
                oLVar.mo9534(this.f8501, summary, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ˊ */
        public void mo8177(CH ch, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onFalkorVideoFetched");
            } else {
                oLVar.mo9561(this.f8501, ch, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ˏ */
        public void mo6200(pP pPVar, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onMovieDetailsFetched");
            } else {
                oLVar.mo9537(this.f8501, pPVar, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo8532(pL pLVar, Boolean bool, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onKidsCharacterDetailsFetched");
            } else {
                oLVar.mo9526(this.f8501, pLVar, bool, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ˎ */
        public void mo6203(pI pIVar, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onEpisodeDetailsFetched");
            } else {
                oLVar.mo9553(this.f8501, pIVar, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ˊ */
        public void mo7395(List<AbstractC2074pw> list, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onCWVideosFetched");
            } else {
                oLVar.mo9522(this.f8501, list, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo8539(List<Object> list, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onShortFormVideosFetched");
            } else {
                oLVar.mo9523(this.f8501, list, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo8530(List<pD> list, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onPreviewsFetched");
            } else {
                oLVar.mo9521(this.f8501, list, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ˋ */
        public void mo7396(List<AbstractC2077pz> list, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for oBBVideosFetched");
            } else {
                oLVar.mo9570(this.f8501, list, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ʽ  reason: contains not printable characters */
        public void mo8519(List<CH> list, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onWatchHistoryVideosFetched");
            } else {
                oLVar.mo9567(this.f8501, list, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ˏ */
        public void mo6199(pO pOVar, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onPostPlayVideosFetched");
            } else {
                oLVar.mo9536(this.f8501, pOVar, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo8529(PrePlayExperiences prePlayExperiences, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onPostPlayVideosFetched");
            } else {
                oLVar.mo9557(this.f8501, prePlayExperiences, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ˊ  reason: contains not printable characters */
        public void mo8521(boolean z, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onPostPlayImpressionLogged");
            } else {
                oLVar.mo9528(this.f8501, z, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo8533(boolean z, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onPostPlayImpressionLogged");
            } else {
                oLVar.mo9548(this.f8501, z, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ᐝ */
        public void mo7347(List<pI> list, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onEpisodesFetched");
            } else {
                oLVar.mo9535(this.f8501, list, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ʻ  reason: contains not printable characters */
        public void mo8518(List<pS> list, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onSeasonsFetched");
            } else {
                oLVar.mo9560(this.f8501, list, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ˊ */
        public void mo8175(pR pRVar, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onShowDetailsFetched");
            } else {
                oLVar.mo9563(this.f8501, pRVar, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ˎ */
        public void mo7346(pR pRVar, List<pS> list, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onShowDetailsAndSeasonsFetched");
            } else {
                oLVar.mo9538(this.f8501, pRVar, list, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ˏॱ  reason: contains not printable characters */
        public void mo8534(List<GenreList> list, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onGenreListsFetched");
            } else {
                oLVar.mo9565(this.f8501, list, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ͺ  reason: contains not printable characters */
        public void mo8535(List<pW> list, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onGenresFetched");
            } else {
                oLVar.mo9540(this.f8501, list, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo8540(pE pEVar, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onVideoRatingSet");
            } else {
                oLVar.mo9546(this.f8501, pEVar, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo8537(Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onQueueAdd");
            } else {
                oLVar.mo9524(this.f8501, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ˎ  reason: contains not printable characters */
        public void mo8524(Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onQueueRemove");
            } else {
                oLVar.mo9531(this.f8501, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo8527(Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onVideoHide");
            } else {
                oLVar.mo9566(this.f8501, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ˎ  reason: contains not printable characters */
        public void mo8526(AbstractC2080qa qaVar, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onSearchResultsFetched");
            } else {
                oLVar.mo9527(this.f8501, qaVar, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ˏ */
        public void mo8174(AbstractC2082qc qcVar, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onIrisNotificationsListFetched");
            } else {
                oLVar.mo9547(this.f8501, qcVar, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ˊ */
        public void mo8173(Status status) {
        }

        @Override // o.AbstractC1203
        /* renamed from: ˎ */
        public void mo7348(Map<String, Boolean> map, Status status) {
        }

        @Override // o.AbstractC1203
        /* renamed from: ˋॱ */
        public void mo7397(List<AbstractC2070ps> list, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onAdvisoriesFetched");
            } else {
                oLVar.mo9554(this.f8501, list, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ˋ  reason: contains not printable characters */
        public void mo8523(boolean z, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onAdvisoriesFetched");
            } else {
                oLVar.mo9564(this.f8501, z, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo8536(int i, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onScenePositionFetched");
            } else {
                oLVar.mo9530(this.f8501, i, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ˊॱ  reason: contains not printable characters */
        public void mo8522(List<Advisory> list, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onAdvisoriesFetched");
            } else {
                oLVar.mo9529(this.f8501, list, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ˊ  reason: contains not printable characters */
        public void mo8520(TrailersFeedItemSummary trailersFeedItemSummary, List<pH> list, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onTrailersFetched");
            } else {
                oLVar.mo9558(this.f8501, trailersFeedItemSummary, list, status);
            }
        }

        @Override // o.AbstractC1203
        /* renamed from: ॱˊ  reason: contains not printable characters */
        public void mo8541(List<CH> list, Status status) {
            oL oLVar = (oL) C1954l.this.f8498.get(this.f8499);
            if (oLVar == null) {
                C1283.m16865("FalkorAccess", "No client callback found for onTrailersFetched");
            } else {
                oLVar.mo9568(this.f8501, list, status);
            }
        }
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo8512(String str, VideoType videoType) {
        this.f8497.m8157(str, videoType);
    }

    @Override // o.AbstractC2050oz
    /* renamed from: ॱ  reason: contains not printable characters */
    public AbstractC0929<?> mo8505() {
        return this.f8497.m8134();
    }
}

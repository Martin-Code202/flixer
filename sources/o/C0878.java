package o;

import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfig;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.model.leafs.advisory.Advisory;
import com.netflix.model.leafs.blades.CreditMarks;
import java.util.ArrayList;
import java.util.List;
/* renamed from: o.ᔱ  reason: contains not printable characters */
public final class C0878 extends AbstractC1067 {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final C0879 f14760 = new C0879(null);

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final boolean m15589() {
        return f14760.m15590();
    }

    /* renamed from: o.ᔱ$ˋ  reason: contains not printable characters */
    public static final class C0879 {
        private C0879() {
        }

        public /* synthetic */ C0879(C1456Fq fq) {
            this();
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final boolean m15590() {
            return !C1457Fr.m5018(m15592(), ABTestConfig.Cell.CELL_1);
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final boolean m15593() {
            return m15590() && (C1457Fr.m5018(m15592(), ABTestConfig.Cell.CELL_7) ^ true);
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public final ABTestConfig.Cell m15592() {
            ABTestConfig.Cell r0 = C1272.m16803(C0878.class);
            C1457Fr.m5016((Object) r0, "PersistentConfig.getCell…tFormContent::class.java)");
            return r0;
        }

        /* renamed from: o.ᔱ$ˋ$If */
        public static final class If implements AbstractC2074pw {
            If() {
            }

            @Override // o.AbstractC2075px
            public String getCleanBoxshotUrl() {
                return "";
            }

            @Override // o.pJ
            public String getBoxshotUrl() {
                return "";
            }

            @Override // o.AbstractC2073pv
            public String getStoryDispUrl() {
                return "";
            }

            @Override // o.AbstractC2074pw
            public String getInterestingUrl() {
                return "";
            }

            @Override // o.AbstractC2074pw, o.pR
            public String getCurrentEpisodeTitle() {
                return "";
            }

            @Override // o.AbstractC2074pw
            public String getTrickplayImgBaseUrl() {
                return "";
            }

            @Override // o.AbstractC2074pw
            public String getTrickplayBigImgBaseUrl() {
                return "";
            }

            @Override // o.pJ
            public VideoType getErrorType() {
                return VideoType.UNAVAILABLE;
            }

            @Override // o.pJ
            public boolean isOriginal() {
                return false;
            }

            @Override // o.AbstractC2074pw
            public String createModifiedStillUrl() {
                return "";
            }

            @Override // o.pJ
            public boolean isPreRelease() {
                return false;
            }

            @Override // o.AbstractC2074pw
            public String createModifiedSmallStillUrl() {
                return "";
            }

            @Override // o.pF
            public String getPlayableId() {
                return "";
            }

            @Override // o.pF
            public String getPlayableTitle() {
                return "";
            }

            @Override // o.pF
            public boolean isPlayableEpisode() {
                return false;
            }

            @Override // o.pF
            public long getPlayableBookmarkUpdateTime() {
                return 0;
            }

            @Override // o.pF
            public int getPlayableBookmarkPosition() {
                return 0;
            }

            @Override // o.pF
            public String getParentTitle() {
                return "";
            }

            @Override // o.pF
            public String getTopLevelId() {
                return "";
            }

            @Override // o.pF
            public int getRuntime() {
                return 0;
            }

            @Override // o.pF
            public int getEndtime() {
                return 0;
            }

            @Override // o.pF
            public int getLogicalStart() {
                return 0;
            }

            @Override // o.pF
            public int getEpisodeNumber() {
                return 0;
            }

            @Override // o.pF, o.pS
            public int getSeasonNumber() {
                return 0;
            }

            @Override // o.pF
            public boolean isAutoPlayEnabled() {
                return false;
            }

            @Override // o.pF
            public int getAutoPlayMaxCount() {
                return 0;
            }

            @Override // o.pF
            public boolean isNextPlayableEpisode() {
                return false;
            }

            @Override // o.pF
            public boolean isAgeProtected() {
                return false;
            }

            @Override // o.pF
            public boolean isPinProtected() {
                return false;
            }

            @Override // o.pF
            public boolean isPreviewProtected() {
                return false;
            }

            @Override // o.pF
            public long getExpirationTime() {
                return 0;
            }

            @Override // o.pF
            public List<Advisory> getAdvisories() {
                return new ArrayList();
            }

            @Override // o.pF
            public boolean isAdvisoryDisabled() {
                return true;
            }

            @Override // o.pF
            public String getSeasonAbbrSeqLabel() {
                return "";
            }

            @Override // o.pF
            public boolean isAvailableToStream() {
                return false;
            }

            @Override // o.pF
            public boolean isNSRE() {
                return false;
            }

            @Override // o.pF
            public boolean isEpisodeNumberHidden() {
                return true;
            }

            @Override // o.pF
            public boolean isSupplementalVideo() {
                return false;
            }

            @Override // o.pF
            public boolean supportsPrePlay() {
                return false;
            }

            @Override // o.pF
            public CreditMarks getCreditMarks() {
                return null;
            }

            @Override // o.pF
            public boolean isAvailableOffline() {
                return false;
            }

            @Override // o.pJ
            public String getBoxartId() {
                return "";
            }

            @Override // o.AbstractC2073pv
            public String getHorzDispSmallUrl() {
                return "";
            }

            @Override // o.AbstractC2073pv
            public String getHorzDispUrl() {
                return "";
            }

            @Override // o.AbstractC2072pu
            public String getId() {
                return "";
            }

            @Override // o.AbstractC2072pu
            public String getTitle() {
                return "";
            }

            @Override // o.AbstractC2072pu
            public VideoType getType() {
                return VideoType.UNAVAILABLE;
            }
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final AbstractC2074pw m15591() {
            return new If();
        }
    }

    @Override // o.AbstractC1067
    /* renamed from: ˎ */
    public String mo510() {
        return "persistent_ab" + mo511();
    }

    @Override // o.AbstractC1067
    /* renamed from: ˏ */
    public String mo511() {
        return "9296";
    }
}

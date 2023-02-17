package o;

import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.model.branches.SummarizedList;
import com.netflix.model.leafs.KidsCharacter;
import com.netflix.model.leafs.TrackableListSummary;
import com.netflix.model.leafs.Video;
import com.netflix.model.leafs.advisory.Advisory;
import com.netflix.model.leafs.blades.CreditMarks;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class CD extends AbstractC1381Cx implements pL, pF {

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static final Comparator<CH> f4704 = new Comparator<CH>() { // from class: o.CD.3
        /* renamed from: ˎ  reason: contains not printable characters */
        public int compare(CH ch, CH ch2) {
            if (ch.getYear() < ch2.getYear()) {
                return 1;
            }
            if (ch.getYear() > ch2.getYear()) {
                return -1;
            }
            return 0;
        }
    };

    /* renamed from: ˊ  reason: contains not printable characters */
    public KidsCharacter.Summary f4705;

    /* renamed from: ˋ  reason: contains not printable characters */
    private Video.Advisories f4706;

    /* renamed from: ˎ  reason: contains not printable characters */
    public SummarizedList<C1049, TrackableListSummary> f4707;

    /* renamed from: ˏ  reason: contains not printable characters */
    public KidsCharacter.Detail f4708;

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1049 f4709;

    public CD(AbstractC0929<? extends AbstractC0730> r1) {
        super(r1);
    }

    @Override // o.AbstractC0730
    public Object get(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1857640538:
                if (str.equals("summary")) {
                    c = 1;
                    break;
                }
                break;
            case -1335224239:
                if (str.equals("detail")) {
                    c = 2;
                    break;
                }
                break;
            case -938102371:
                if (str.equals("rating")) {
                    c = 3;
                    break;
                }
                break;
            case -648601833:
                if (str.equals("advisories")) {
                    c = 0;
                    break;
                }
                break;
            case -280837022:
                if (str.equals("watchNext")) {
                    c = 4;
                    break;
                }
                break;
            case -196315310:
                if (str.equals("gallery")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return this.f4706;
            case 1:
                return this.f4705;
            case 2:
                return this.f4708;
            case 3:
                return C1128.m16280();
            case 4:
                return this.f4709;
            case 5:
                return this.f4707;
            default:
                return null;
        }
    }

    @Override // o.AbstractC0730
    public Object getOrCreate(String str) {
        Object obj = get(str);
        if (obj != null) {
            return obj;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1857640538:
                if (str.equals("summary")) {
                    c = 1;
                    break;
                }
                break;
            case -1335224239:
                if (str.equals("detail")) {
                    c = 2;
                    break;
                }
                break;
            case -938102371:
                if (str.equals("rating")) {
                    c = 3;
                    break;
                }
                break;
            case -648601833:
                if (str.equals("advisories")) {
                    c = 0;
                    break;
                }
                break;
            case -280837022:
                if (str.equals("watchNext")) {
                    c = 4;
                    break;
                }
                break;
            case -196315310:
                if (str.equals("gallery")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                Video.Advisories advisories = new Video.Advisories();
                this.f4706 = advisories;
                return advisories;
            case 1:
                KidsCharacter.Summary summary = new KidsCharacter.Summary();
                this.f4705 = summary;
                return summary;
            case 2:
                KidsCharacter.Detail detail = new KidsCharacter.Detail();
                this.f4708 = detail;
                return detail;
            case 3:
                return C1128.m16280();
            case 4:
                C1049 r0 = new C1049();
                this.f4709 = r0;
                return r0;
            case 5:
                SummarizedList<C1049, TrackableListSummary> summarizedList = new SummarizedList<>(CO.f4967, CO.f4970);
                this.f4707 = summarizedList;
                return summarizedList;
            default:
                return null;
        }
    }

    @Override // o.AbstractC0730
    public void set(String str, Object obj) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1857640538:
                if (str.equals("summary")) {
                    c = 1;
                    break;
                }
                break;
            case -1335224239:
                if (str.equals("detail")) {
                    c = 2;
                    break;
                }
                break;
            case -648601833:
                if (str.equals("advisories")) {
                    c = 0;
                    break;
                }
                break;
            case -280837022:
                if (str.equals("watchNext")) {
                    c = 3;
                    break;
                }
                break;
            case -196315310:
                if (str.equals("gallery")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.f4706 = (Video.Advisories) obj;
                return;
            case 1:
                this.f4705 = (KidsCharacter.Summary) obj;
                return;
            case 2:
                this.f4708 = (KidsCharacter.Detail) obj;
                return;
            case 3:
                this.f4709 = (C1049) obj;
                return;
            case 4:
                this.f4707 = (SummarizedList) obj;
                return;
            default:
                return;
        }
    }

    @Override // o.AbstractC0730
    public void remove(String str) {
        set(str, null);
    }

    @Override // o.pJ
    public String getBoxshotUrl() {
        if (this.f4705 == null) {
            return null;
        }
        return this.f4705.getBoxshotUrl();
    }

    @Override // o.pJ
    public String getBoxartId() {
        if (this.f4705 == null) {
            return null;
        }
        return this.f4705.getBoxartId();
    }

    @Override // o.AbstractC2072pu
    public VideoType getType() {
        return this.f4705 == null ? VideoType.UNKNOWN : this.f4705.getType();
    }

    @Override // o.pJ
    public VideoType getErrorType() {
        if (this.f4705 == null) {
            return null;
        }
        return this.f4705.getErrorType();
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public String m4176() {
        if (this.f4705 == null) {
            return null;
        }
        return this.f4705.getId();
    }

    @Override // o.pL
    /* renamed from: ˋ  reason: contains not printable characters */
    public String mo4179() {
        if (this.f4705 == null) {
            return null;
        }
        return this.f4705.getTitle();
    }

    @Override // o.pL
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public String mo4183() {
        if (this.f4705 == null) {
            return null;
        }
        return this.f4705.getCharacterImageUrl();
    }

    @Override // o.pJ
    public boolean isOriginal() {
        return false;
    }

    @Override // o.pF
    public boolean isNSRE() {
        return false;
    }

    @Override // o.pF
    public boolean isEpisodeNumberHidden() {
        return false;
    }

    @Override // o.pF
    public boolean isAvailableOffline() {
        CH r1 = m4174();
        if (r1 == null) {
            return false;
        }
        return r1.isAvailableOffline();
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

    @Override // o.pJ
    public boolean isPreRelease() {
        return false;
    }

    @Override // o.pL
    /* renamed from: ॱ  reason: contains not printable characters */
    public String mo4182() {
        Video.Detail r1 = m4173();
        if (r1 == null) {
            return null;
        }
        return r1.storyImgUrl;
    }

    @Override // o.pL
    /* renamed from: ˏ  reason: contains not printable characters */
    public List<pJ> mo4181() {
        if (C1349Bv.m4113(m4176())) {
            C1283.m16850("FalkorKidsCharacter", "getGallery() kidsCharacterId is null");
            return Collections.EMPTY_LIST;
        }
        List<I> r5 = getModelProxy().mo15259(C0506.m14506(m4176()));
        ArrayList arrayList = new ArrayList(r5.size());
        ArrayList arrayList2 = new ArrayList(r5.size());
        for (I i : r5) {
            if (VideoType.SHOW.equals(i.getType())) {
                arrayList.add(i);
            } else if (VideoType.MOVIE.equals(i.getType())) {
                arrayList2.add(i);
            } else {
                C1283.m16865("FalkorKidsCharacter", String.format("unexpected videoType=%s in getGallery", i.getType()));
            }
        }
        Collections.sort(arrayList, f4704);
        Collections.sort(arrayList2, f4704);
        ArrayList arrayList3 = new ArrayList(r5.size());
        arrayList3.addAll(arrayList);
        arrayList3.addAll(arrayList2);
        return arrayList3;
    }

    @Override // o.pL
    /* renamed from: ˊ  reason: contains not printable characters */
    public int mo4178() {
        TrackableListSummary r1 = m4170();
        if (r1 == null) {
            return 0;
        }
        return r1.getTrackId();
    }

    @Override // o.pL
    /* renamed from: ˎ  reason: contains not printable characters */
    public int mo4180() {
        return 0;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private TrackableListSummary m4170() {
        if (this.f4707 == null) {
            return null;
        }
        return (TrackableListSummary) this.f4707.get("summary");
    }

    @Override // o.pL
    /* renamed from: ʼ  reason: contains not printable characters */
    public String mo4177() {
        TrackableListSummary r1 = m4170();
        if (r1 == null) {
            return null;
        }
        return r1.getRequestId();
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public pF m4184() {
        return this;
    }

    @Override // o.AbstractC2072pu
    public String getId() {
        return m4176();
    }

    @Override // o.AbstractC2072pu
    public String getTitle() {
        return mo4179();
    }

    @Override // o.pF
    public String getPlayableId() {
        if (m4174() == null) {
            return null;
        }
        return m4174().getId();
    }

    @Override // o.pF
    public String getPlayableTitle() {
        if (m4174() == null) {
            return null;
        }
        return m4174().getTitle();
    }

    @Override // o.pF
    public boolean isPlayableEpisode() {
        if (m4174() == null) {
            return false;
        }
        return m4174().isEpisode();
    }

    @Override // o.pF
    public long getPlayableBookmarkUpdateTime() {
        if (m4171() == null) {
            return 0;
        }
        return m4171().getLastModified();
    }

    @Override // o.pF
    public int getPlayableBookmarkPosition() {
        return C1352By.m4135(m4171() == null ? 0 : m4171().getBookmarkPosition(), getEndtime(), getRuntime());
    }

    @Override // o.pF
    public String getParentTitle() {
        if (!VideoType.EPISODE.equals(m4175()) || m4172() == null) {
            return null;
        }
        return m4172().m4568();
    }

    @Override // o.pF
    public String getTopLevelId() {
        if (!VideoType.EPISODE.equals(m4175()) || m4172() == null) {
            return null;
        }
        return m4172().mo4565();
    }

    @Override // o.pF
    public int getRuntime() {
        Video.Detail r1 = m4173();
        if (r1 == null) {
            return -1;
        }
        return r1.runtime;
    }

    @Override // o.pF
    public int getEndtime() {
        Video.Detail r1 = m4173();
        if (r1 == null) {
            return -1;
        }
        return r1.endtime;
    }

    @Override // o.pF
    public int getLogicalStart() {
        Video.Detail r1 = m4173();
        if (r1 == null) {
            return 0;
        }
        return r1.logicalStart;
    }

    @Override // o.pF
    public int getEpisodeNumber() {
        if (!VideoType.EPISODE.equals(m4175()) || m4172() == null) {
            return 0;
        }
        return m4172().getEpisodeNumber();
    }

    @Override // o.pF, o.pS
    public int getSeasonNumber() {
        if (!VideoType.EPISODE.equals(m4175()) || m4172() == null) {
            return 0;
        }
        return m4172().getSeasonNumber();
    }

    @Override // o.pF
    public boolean isAutoPlayEnabled() {
        Video.Detail r1 = m4173();
        if (r1 == null) {
            return false;
        }
        return r1.isAutoPlayEnabled;
    }

    @Override // o.pF
    public int getAutoPlayMaxCount() {
        Video.Detail r1 = m4173();
        if (r1 == null) {
            return -1;
        }
        return r1.autoPlayMaxCount;
    }

    @Override // o.pF
    public boolean isNextPlayableEpisode() {
        Video.Detail r1 = m4173();
        if (r1 == null) {
            return false;
        }
        return r1.isNextPlayableEpisode;
    }

    @Override // o.pF
    public boolean isPinProtected() {
        Video.Detail r1 = m4173();
        if (r1 == null) {
            return false;
        }
        return r1.isPinProtected;
    }

    @Override // o.pF
    public boolean isPreviewProtected() {
        Video.Detail r1 = m4173();
        if (r1 == null) {
            return false;
        }
        return r1.isPreviewProtected;
    }

    @Override // o.pF
    public long getExpirationTime() {
        return -1;
    }

    @Override // o.pF
    public List<Advisory> getAdvisories() {
        return this.f4706 == null ? new ArrayList(0) : this.f4706.getAdvisoryList();
    }

    @Override // o.pF
    public boolean isAgeProtected() {
        Video.Detail r1 = m4173();
        if (r1 == null) {
            return false;
        }
        return r1.isAgeProtected;
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private Video.Detail m4173() {
        CH r1 = m4174();
        if (r1 == null) {
            return null;
        }
        return r1.getDetail();
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private CH m4174() {
        if (this.f4709 == null) {
            return null;
        }
        return (CH) this.f4709.m16078(getModelProxy());
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private Video.Bookmark m4171() {
        CH r1 = m4174();
        if (r1 == null) {
            return null;
        }
        return r1.bookmark;
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private C1383Cz m4172() {
        CH r1 = m4174();
        if (r1 == null) {
            return null;
        }
        return (C1383Cz) r1;
    }

    public String toString() {
        return "FalkorKidsCharacter [getType()=" + getType() + ", getCharacterId()=" + m4176() + ", getCharacterTitle()=" + mo4179() + "]";
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private VideoType m4175() {
        CH r1 = m4174();
        return r1 == null ? VideoType.UNKNOWN : r1.getType();
    }

    @Override // o.pF
    public boolean isAdvisoryDisabled() {
        return false;
    }

    @Override // o.pF
    public String getSeasonAbbrSeqLabel() {
        if (VideoType.EPISODE.equals(m4175())) {
            return m4172() == null ? "" : m4172().getSeasonAbbrSeqLabel();
        }
        return null;
    }

    @Override // o.pF
    public boolean isAvailableToStream() {
        pF r1 = m4184();
        if (r1 != null) {
            return r1.isAvailableToStream();
        }
        return false;
    }
}

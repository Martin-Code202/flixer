package o;

import android.text.TextUtils;
import android.util.Pair;
import com.netflix.falkor.BranchMap;
import com.netflix.mediaclient.servicemgr.interface_.LoMoType;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import com.netflix.model.branches.SummarizedList;
import com.netflix.model.leafs.LoLoMoSummary;
import com.netflix.model.leafs.Video;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.List;
import o.AbstractC0730;
/* renamed from: o.ᔭ  reason: contains not printable characters */
public final class C0876<T extends AbstractC0730> extends C0787<T> {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final If f14753;

    /* renamed from: o.ᔭ$If */
    public interface If {
        /* renamed from: ˏ */
        boolean mo8176();
    }

    public C0876(T t, boolean z, AbstractC1261 r3, If r4) {
        super(t, z, r3);
        this.f14753 = r4;
    }

    /* renamed from: o.ᔭ$if  reason: invalid class name */
    public static class Cif {

        /* renamed from: ˊ  reason: contains not printable characters */
        public final pC f14754;

        /* renamed from: ˋ  reason: contains not printable characters */
        public final String f14755;

        /* renamed from: ॱ  reason: contains not printable characters */
        public final String f14756;

        Cif(String str, pC pCVar, String str2) {
            this.f14755 = str;
            this.f14754 = pCVar;
            this.f14756 = str2;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public Pair<String, String> m15583(LoMoType loMoType) {
        Pair<pC, String> r1 = m15579(loMoType);
        return new Pair<>(r1 == null ? null : ((pC) r1.first).getId(), r1 == null ? String.valueOf(-1) : (String) r1.second);
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public synchronized String m15575() {
        C1049 r3 = (C1049) mo15251(C0859.m15528("lolomo"));
        if (r3 == null) {
            return null;
        }
        C0859 r4 = r3.m16080();
        if (r4 == null || r4.m15541() < 2) {
            return null;
        }
        return (String) r4.m15533().get(1);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized Pair<pC, String> m15579(LoMoType loMoType) {
        pC pCVar;
        C1049 r4 = (C1049) mo15251(C0859.m15528("lolomo"));
        if (r4 == null) {
            return null;
        }
        BranchMap branchMap = (BranchMap) mo15251(r4.m16080());
        if (branchMap == null) {
            return null;
        }
        try {
            for (String str : branchMap.keySet()) {
                if (TextUtils.isDigitsOnly(str) && (pCVar = (pC) mo15251(r4.m16080().m15535(C0859.m15528(str, "summary")))) != null && pCVar.getType() == loMoType) {
                    return new Pair<>(pCVar, str);
                }
            }
        } catch (ConcurrentModificationException e) {
            C1276.m16820().mo5729("SPY-13393: Catch CME in getCurrLomoByType", e);
        }
        return null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized List<Cif> m15588(String str) {
        Cif r8;
        Cif r9;
        C1049 r3 = (C1049) mo15251(C0859.m15528("lolomo"));
        if (r3 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            if (this.f14753.mo8176()) {
                BranchMap branchMap = (BranchMap) mo15251(C0859.m15528("lolomos"));
                for (String str2 : branchMap.keySet()) {
                    SummarizedList summarizedList = (SummarizedList) branchMap.get(str2);
                    if (!(summarizedList == null || (r9 = m15574(str2, summarizedList, str)) == null)) {
                        arrayList.add(r9);
                    }
                }
            } else {
                C0859 r5 = r3.m16080();
                BranchMap<SummarizedList<C1049, LoLoMoSummary>> branchMap2 = (BranchMap) mo15251(r5);
                if (!(branchMap2 == null || (r8 = m15574((String) r5.m15533().get(r5.m15533().size() - 1), branchMap2, str)) == null)) {
                    arrayList.add(r8);
                }
            }
        } catch (ConcurrentModificationException e) {
            C1276.m16820().mo5729("SPY-13393: Catch CME in getListsByContext", e);
        }
        return arrayList;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public pC m15581(String str) {
        String r1 = m15575();
        List<Cif> r2 = m15588(str);
        if (r2 == null) {
            return null;
        }
        for (Cif ifVar : r2) {
            if (TextUtils.equals(ifVar.f14755, r1)) {
                return ifVar.f14754;
            }
        }
        return null;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private synchronized Cif m15574(String str, BranchMap<SummarizedList<C1049, LoLoMoSummary>> branchMap, String str2) {
        C1049 r8;
        C0859 r9;
        C0859 r6;
        LoLoMoSummary loLoMoSummary = (LoLoMoSummary) ((SummarizedList) branchMap).m3069();
        if (loLoMoSummary == null || loLoMoSummary.getExpiryTimeStamp() < System.currentTimeMillis()) {
            return null;
        }
        Object obj = branchMap.get(str2);
        if (!(!(obj instanceof C1049) || ((C1049) obj).m16080() == null || (r6 = ((C1049) obj).m16080()) == null)) {
            Object r7 = mo15251(r6.m15535(C0859.m15528("summary")));
            if (r7 instanceof pC) {
                List<Object> r82 = r6.m15533();
                return new Cif(str, (pC) r7, (String) r82.get(r82.size() - 1));
            }
        }
        if (this.f14753.mo8176() && ("continueWatching".equals(str2) || "queue".equals(str2))) {
            return null;
        }
        for (K k : branchMap.keySet()) {
            if (!(!TextUtils.isDigitsOnly(k) || (r8 = (C1049) branchMap.get((String) k)) == null || (r9 = r8.m16080()) == null)) {
                Object r10 = mo15251(r9.m15535(C0859.m15528("summary")));
                if (r10 instanceof pC) {
                    pC pCVar = (pC) r10;
                    if (TextUtils.equals(pCVar.getListContext(), str2)) {
                        return new Cif(str, pCVar, k);
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized <LT extends pC> List<LT> m15580(int i, Collection<C0859> collection) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (C0859 r0 : collection) {
            int i2 = i;
            for (C0859 r10 : r0.m15536()) {
                Object r11 = mo15251(r10);
                if (r11 instanceof pC) {
                    pC pCVar = (pC) r11;
                    if (!TextUtils.isEmpty(pCVar.getId())) {
                        i2++;
                        pCVar.setListPos(i2);
                        arrayList.add(pCVar);
                    } else {
                        C1283.m16855("NetflixModelProxy", "got unidentified lomo - pql: %s, lomo: %s", r10, pCVar);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public List<GenreList> m15576() {
        Object r3 = mo15251(C0859.m15528("genreList"));
        if (r3 != null) {
            return new ArrayList((List) ((C0993) r3).m15933());
        }
        return null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized AbstractC0851 m15584(C0859 r7) {
        for (C0859 r0 : r7.m15536()) {
            Object r4 = mo15251(r0);
            if (r4 instanceof AbstractC0851) {
                return (AbstractC0851) r4;
            }
        }
        return null;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m15582(String str, VideoType videoType, int i) {
        Video.Bookmark bookmark;
        if (C1349Bv.m4113(str)) {
            C1283.m16865("NetflixModelProxy", "Can't update bookmark position - videoID is null");
        } else if (videoType == null || !(videoType == VideoType.EPISODE || videoType == VideoType.MOVIE)) {
            C1283.m16865("NetflixModelProxy", "Can't update bookmark position - invalid videoType");
        } else {
            CH ch = (CH) m15584(C0859.m15528(videoType.getValue(), str, "bookmark"));
            if (ch != null && (bookmark = ch.getBookmark()) != null) {
                bookmark.setBookmarkPosition(i);
                bookmark.setLastModified(System.currentTimeMillis());
            }
        }
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public boolean m15578() {
        String r2 = m15577(LoMoType.CONTINUE_WATCHING.m1575());
        Pair<String, String> r3 = m15583(LoMoType.CONTINUE_WATCHING);
        if (C1349Bv.m4113(r2)) {
            C1283.m16854("NetflixModelProxy", "CW doesn't exist - lolomoId is empty");
            return false;
        } else if (C1349Bv.m4113((String) r3.first)) {
            C1283.m16854("NetflixModelProxy", "CW doesn't exist - lomo id is empty");
            return false;
        } else if (!String.valueOf(-1).equals(r3.second)) {
            return true;
        } else {
            C1283.m16854("NetflixModelProxy", "CW doesn't exist - lomo index is invalid");
            return false;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15585(String str, VideoType videoType) {
        m15254(C0859.m15528(videoType.getValue(), str, "episodes"));
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public void m15587() {
        m15254(C0859.m15528("lolomo"));
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public void m15586() {
        m15254(C0859.m15528("newSearch"));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public String m15577(String str) {
        String r3 = m15575();
        if (!C1349Bv.m4113(r3)) {
            return r3;
        }
        m15249(Collections.singleton(C0859.m15528("lolomo", str, "summary")));
        return m15575();
    }
}

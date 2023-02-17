package o;

import com.netflix.falkor.BranchMap;
import com.netflix.model.branches.FalkorList;
import com.netflix.model.branches.SummarizedList;
import com.netflix.model.leafs.FlatGenreListOfVideosSummary;
import com.netflix.model.leafs.ListOfListOfGenres;
import com.netflix.model.leafs.LoLoMoSummary;
import com.netflix.model.leafs.SearchTrackableListSummary;
import com.netflix.model.leafs.TrailersFeedItemSummary;
import com.netflix.model.leafs.social.IrisNotificationsListSummary;
import java.io.Flushable;
import java.util.LinkedHashSet;
import java.util.Set;
/* renamed from: o.Cv  reason: case insensitive filesystem */
public class C1379Cv implements AbstractC0730, Flushable {

    /* renamed from: ʻ  reason: contains not printable characters */
    private C0993<ListOfListOfGenres> f5202;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private BranchMap<CE> f5203;

    /* renamed from: ʼ  reason: contains not printable characters */
    private BranchMap<SummarizedList<C1049, FlatGenreListOfVideosSummary>> f5204;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private BranchMap<SummarizedList<CN, SearchTrackableListSummary>> f5205;

    /* renamed from: ʽ  reason: contains not printable characters */
    private BranchMap<C1049> f5206;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private BranchMap<SummarizedList<CN, SearchTrackableListSummary>> f5207;

    /* renamed from: ʾ  reason: contains not printable characters */
    private BranchMap<C1049> f5208;

    /* renamed from: ʿ  reason: contains not printable characters */
    private BranchMap<CD> f5209;

    /* renamed from: ˈ  reason: contains not printable characters */
    private BranchMap<CI> f5210;

    /* renamed from: ˉ  reason: contains not printable characters */
    private AbstractC0929<? extends AbstractC0730> f5211;

    /* renamed from: ˊ  reason: contains not printable characters */
    private BranchMap<SummarizedList<C1049, LoLoMoSummary>> f5212;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    private BranchMap<C1049> f5213;

    /* renamed from: ˊˋ  reason: contains not printable characters */
    private SummarizedList<CG, TrailersFeedItemSummary> f5214;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private BranchMap<CH> f5215;

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private SummarizedList<C1049, IrisNotificationsListSummary> f5216;

    /* renamed from: ˋ  reason: contains not printable characters */
    private C1049 f5217;

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private BranchMap<C1382Cy> f5218;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private BranchMap<C1049> f5219;

    /* renamed from: ˎ  reason: contains not printable characters */
    private BranchMap<FalkorList<C1049>> f5220;

    /* renamed from: ˏ  reason: contains not printable characters */
    private BranchMap<SummarizedList<C1049, LoLoMoSummary>> f5221;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private BranchMap<C1049> f5222;

    /* renamed from: ͺ  reason: contains not printable characters */
    private BranchMap<C1383Cz> f5223;

    /* renamed from: ॱ  reason: contains not printable characters */
    private BranchMap<C1049> f5224;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private BranchMap<CH> f5225;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private BranchMap<CF> f5226;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private BranchMap<C1380Cw> f5227;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private BranchMap<C0993<ListOfListOfGenres>> f5228;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private BranchMap<CB> f5229;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private BranchMap<FalkorList<C1049>> f5230;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private BranchMap<CC> f5231;

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m4559(AbstractC0929<? extends AbstractC0730> r1) {
        this.f5211 = r1;
    }

    @Override // o.AbstractC0730
    public Object get(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1554643546:
                if (str.equals("notificationsList")) {
                    c = 27;
                    break;
                }
                break;
            case -1525769378:
                if (str.equals("trailersFeed")) {
                    c = 7;
                    break;
                }
                break;
            case -1525319953:
                if (str.equals("suggestions")) {
                    c = 24;
                    break;
                }
                break;
            case -1206595391:
                if (str.equals("searchSuggestionByEntityId")) {
                    c = 20;
                    break;
                }
                break;
            case -1148592758:
                if (str.equals("flatGenre")) {
                    c = '\b';
                    break;
                }
                break;
            case -1097180568:
                if (str.equals("lolomo")) {
                    c = 1;
                    break;
                }
                break;
            case -1068259517:
                if (str.equals("movies")) {
                    c = 14;
                    break;
                }
                break;
            case -991808881:
                if (str.equals("people")) {
                    c = 22;
                    break;
                }
                break;
            case -834636875:
                if (str.equals("postPlayExperiences")) {
                    c = 17;
                    break;
                }
                break;
            case -816678056:
                if (str.equals("videos")) {
                    c = '\f';
                    break;
                }
                break;
            case -739475259:
                if (str.equals("watchHistory")) {
                    c = 6;
                    break;
                }
                break;
            case -632946216:
                if (str.equals("episodes")) {
                    c = 15;
                    break;
                }
                break;
            case -610057368:
                if (str.equals("newSearch")) {
                    c = 18;
                    break;
                }
                break;
            case -582369019:
                if (str.equals("topGenres")) {
                    c = 11;
                    break;
                }
                break;
            case -557099315:
                if (str.equals("searchLists")) {
                    c = 5;
                    break;
                }
                break;
            case -84881872:
                if (str.equals("searchLolomo")) {
                    c = 3;
                    break;
                }
                break;
            case -17544705:
                if (str.equals("nonMemberVideos")) {
                    c = 28;
                    break;
                }
                break;
            case 102982549:
                if (str.equals("lists")) {
                    c = 2;
                    break;
                }
                break;
            case 109413654:
                if (str.equals("shows")) {
                    c = '\r';
                    break;
                }
                break;
            case 347140875:
                if (str.equals("lolomos")) {
                    c = 0;
                    break;
                }
                break;
            case 643818181:
                if (str.equals("videoCastStills")) {
                    c = 23;
                    break;
                }
                break;
            case 646493377:
                if (str.equals("genreList")) {
                    c = '\t';
                    break;
                }
                break;
            case 960849002:
                if (str.equals("filteredGenreList")) {
                    c = '\n';
                    break;
                }
                break;
            case 1065679688:
                if (str.equals("searchSuggestionByReference")) {
                    c = 21;
                    break;
                }
                break;
            case 1245424234:
                if (str.equals("characters")) {
                    c = 25;
                    break;
                }
                break;
            case 1272354024:
                if (str.equals("notifications")) {
                    c = 26;
                    break;
                }
                break;
            case 1385360876:
                if (str.equals("searchByReference")) {
                    c = 19;
                    break;
                }
                break;
            case 1663629379:
                if (str.equals("searchLolomos")) {
                    c = 4;
                    break;
                }
                break;
            case 1968370160:
                if (str.equals("seasons")) {
                    c = 16;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return this.f5212;
            case 1:
                return this.f5217;
            case 2:
                return this.f5220;
            case 3:
                return this.f5224;
            case 4:
                return this.f5221;
            case 5:
                return this.f5230;
            case 6:
                return this.f5206;
            case 7:
                return this.f5214;
            case '\b':
                return this.f5204;
            case '\t':
                return this.f5202;
            case '\n':
                return this.f5228;
            case 11:
                return this.f5222;
            case '\f':
                return this.f5219;
            case '\r':
                return this.f5225;
            case 14:
                return this.f5215;
            case 15:
                return this.f5223;
            case 16:
                return this.f5229;
            case 17:
                return this.f5226;
            case 18:
                return this.f5210;
            case 19:
                return this.f5205;
            case 20:
                return this.f5208;
            case 21:
                return this.f5207;
            case 22:
                return this.f5231;
            case 23:
                return this.f5227;
            case 24:
                return this.f5203;
            case 25:
                return this.f5209;
            case 26:
                return this.f5218;
            case 27:
                return this.f5216;
            case 28:
                return this.f5213;
            default:
                C1283.m16854("Root", "Could not find key: " + str);
                return null;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // o.AbstractC0730
    public void set(String str, Object obj) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1554643546:
                if (str.equals("notificationsList")) {
                    c = 28;
                    break;
                }
                break;
            case -1525769378:
                if (str.equals("trailersFeed")) {
                    c = 7;
                    break;
                }
                break;
            case -1525319953:
                if (str.equals("suggestions")) {
                    c = 24;
                    break;
                }
                break;
            case -1206595391:
                if (str.equals("searchSuggestionByEntityId")) {
                    c = 20;
                    break;
                }
                break;
            case -1148592758:
                if (str.equals("flatGenre")) {
                    c = '\b';
                    break;
                }
                break;
            case -1097180568:
                if (str.equals("lolomo")) {
                    c = 1;
                    break;
                }
                break;
            case -1068259517:
                if (str.equals("movies")) {
                    c = 14;
                    break;
                }
                break;
            case -991808881:
                if (str.equals("people")) {
                    c = 22;
                    break;
                }
                break;
            case -834636875:
                if (str.equals("postPlayExperiences")) {
                    c = 17;
                    break;
                }
                break;
            case -816678056:
                if (str.equals("videos")) {
                    c = '\f';
                    break;
                }
                break;
            case -739475259:
                if (str.equals("watchHistory")) {
                    c = 6;
                    break;
                }
                break;
            case -632946216:
                if (str.equals("episodes")) {
                    c = 15;
                    break;
                }
                break;
            case -610057368:
                if (str.equals("newSearch")) {
                    c = 18;
                    break;
                }
                break;
            case -582369019:
                if (str.equals("topGenres")) {
                    c = 11;
                    break;
                }
                break;
            case -557099315:
                if (str.equals("searchLists")) {
                    c = 5;
                    break;
                }
                break;
            case -84881872:
                if (str.equals("searchLolomo")) {
                    c = 3;
                    break;
                }
                break;
            case -17544705:
                if (str.equals("nonMemberVideos")) {
                    c = 26;
                    break;
                }
                break;
            case 102982549:
                if (str.equals("lists")) {
                    c = 2;
                    break;
                }
                break;
            case 109413654:
                if (str.equals("shows")) {
                    c = '\r';
                    break;
                }
                break;
            case 347140875:
                if (str.equals("lolomos")) {
                    c = 0;
                    break;
                }
                break;
            case 643818181:
                if (str.equals("videoCastStills")) {
                    c = 23;
                    break;
                }
                break;
            case 646493377:
                if (str.equals("genreList")) {
                    c = '\t';
                    break;
                }
                break;
            case 960849002:
                if (str.equals("filteredGenreList")) {
                    c = '\n';
                    break;
                }
                break;
            case 1065679688:
                if (str.equals("searchSuggestionByReference")) {
                    c = 21;
                    break;
                }
                break;
            case 1245424234:
                if (str.equals("characters")) {
                    c = 25;
                    break;
                }
                break;
            case 1272354024:
                if (str.equals("notifications")) {
                    c = 27;
                    break;
                }
                break;
            case 1385360876:
                if (str.equals("searchByReference")) {
                    c = 19;
                    break;
                }
                break;
            case 1663629379:
                if (str.equals("searchLolomos")) {
                    c = 4;
                    break;
                }
                break;
            case 1968370160:
                if (str.equals("seasons")) {
                    c = 16;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.f5212 = (BranchMap) obj;
                return;
            case 1:
                this.f5217 = (C1049) obj;
                return;
            case 2:
                this.f5220 = (BranchMap) obj;
                return;
            case 3:
                this.f5224 = (BranchMap) obj;
                return;
            case 4:
                this.f5221 = (BranchMap) obj;
                return;
            case 5:
                this.f5230 = (BranchMap) obj;
                return;
            case 6:
                this.f5206 = (BranchMap) obj;
                return;
            case 7:
                this.f5214 = (SummarizedList) obj;
                return;
            case '\b':
                this.f5204 = (BranchMap) obj;
                return;
            case '\t':
                this.f5202 = (C0993) obj;
                return;
            case '\n':
                this.f5228 = (BranchMap) obj;
                return;
            case 11:
                this.f5222 = (BranchMap) obj;
                return;
            case '\f':
                this.f5219 = (BranchMap) obj;
                return;
            case '\r':
                this.f5225 = (BranchMap) obj;
                return;
            case 14:
                this.f5215 = (BranchMap) obj;
                return;
            case 15:
                this.f5223 = (BranchMap) obj;
                return;
            case 16:
                this.f5229 = (BranchMap) obj;
                return;
            case 17:
                this.f5226 = (BranchMap) obj;
                return;
            case 18:
                this.f5210 = (BranchMap) obj;
                return;
            case 19:
                this.f5205 = (BranchMap) obj;
                return;
            case 20:
                this.f5208 = (BranchMap) obj;
                return;
            case 21:
                this.f5207 = (BranchMap) obj;
                return;
            case 22:
                this.f5231 = (BranchMap) obj;
                return;
            case 23:
                this.f5227 = (BranchMap) obj;
                return;
            case 24:
                this.f5203 = (BranchMap) obj;
                return;
            case 25:
                this.f5209 = (BranchMap) obj;
                return;
            case 26:
                this.f5213 = (BranchMap) obj;
                return;
            case 27:
                this.f5218 = (BranchMap) obj;
                break;
            case 28:
                break;
            default:
                C1283.m16854("Root", "Don't know how to set key: " + str);
                return;
        }
        this.f5216 = (SummarizedList) obj;
    }

    @Override // o.AbstractC0730
    public void remove(String str) {
        set(str, null);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public Set<String> m4560() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (this.f5217 != null) {
            linkedHashSet.add("lolomo");
        }
        if (this.f5212 != null) {
            linkedHashSet.add("lolomos");
        }
        if (this.f5220 != null) {
            linkedHashSet.add("lists");
        }
        if (this.f5224 != null) {
            linkedHashSet.add("searchLolomo");
        }
        if (this.f5221 != null) {
            linkedHashSet.add("searchLolomos");
        }
        if (this.f5230 != null) {
            linkedHashSet.add("searchLists");
        }
        if (this.f5206 != null) {
            linkedHashSet.add("watchHistory");
        }
        if (this.f5214 != null) {
            linkedHashSet.add("trailersFeed");
        }
        if (this.f5204 != null) {
            linkedHashSet.add("flatGenre");
        }
        if (this.f5202 != null) {
            linkedHashSet.add("genreList");
        }
        if (this.f5228 != null) {
            linkedHashSet.add("filteredGenreList");
        }
        if (this.f5222 != null) {
            linkedHashSet.add("topGenres");
        }
        if (this.f5219 != null) {
            linkedHashSet.add("videos");
        }
        if (this.f5215 != null) {
            linkedHashSet.add("movies");
        }
        if (this.f5225 != null) {
            linkedHashSet.add("shows");
        }
        if (this.f5223 != null) {
            linkedHashSet.add("episodes");
        }
        if (this.f5229 != null) {
            linkedHashSet.add("seasons");
        }
        if (this.f5226 != null) {
            linkedHashSet.add("postPlayExperiences");
        }
        if (this.f5210 != null) {
            linkedHashSet.add("newSearch");
        }
        if (this.f5205 != null) {
            linkedHashSet.add("searchByReference");
        }
        if (this.f5208 != null) {
            linkedHashSet.add("searchSuggestionByEntityId");
        }
        if (this.f5207 != null) {
            linkedHashSet.add("searchSuggestionByReference");
        }
        if (this.f5231 != null) {
            linkedHashSet.add("people");
        }
        if (this.f5227 != null) {
            linkedHashSet.add("videoCastStills");
        }
        if (this.f5203 != null) {
            linkedHashSet.add("suggestions");
        }
        if (this.f5209 != null) {
            linkedHashSet.add("characters");
        }
        if (this.f5218 != null) {
            linkedHashSet.add("notifications");
        }
        if (this.f5216 != null) {
            linkedHashSet.add("notificationsList");
        }
        if (this.f5213 != null) {
            linkedHashSet.add("nonMemberVideos");
        }
        return linkedHashSet;
    }

    @Override // o.AbstractC0730
    public Object getOrCreate(String str) {
        Object obj = get(str);
        if (obj != null) {
            return obj;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1554643546:
                if (str.equals("notificationsList")) {
                    c = 27;
                    break;
                }
                break;
            case -1525769378:
                if (str.equals("trailersFeed")) {
                    c = 7;
                    break;
                }
                break;
            case -1525319953:
                if (str.equals("suggestions")) {
                    c = 20;
                    break;
                }
                break;
            case -1206595391:
                if (str.equals("searchSuggestionByEntityId")) {
                    c = 23;
                    break;
                }
                break;
            case -1148592758:
                if (str.equals("flatGenre")) {
                    c = '\b';
                    break;
                }
                break;
            case -1097180568:
                if (str.equals("lolomo")) {
                    c = 0;
                    break;
                }
                break;
            case -1068259517:
                if (str.equals("movies")) {
                    c = 14;
                    break;
                }
                break;
            case -991808881:
                if (str.equals("people")) {
                    c = 18;
                    break;
                }
                break;
            case -834636875:
                if (str.equals("postPlayExperiences")) {
                    c = 17;
                    break;
                }
                break;
            case -816678056:
                if (str.equals("videos")) {
                    c = '\f';
                    break;
                }
                break;
            case -739475259:
                if (str.equals("watchHistory")) {
                    c = 6;
                    break;
                }
                break;
            case -632946216:
                if (str.equals("episodes")) {
                    c = 15;
                    break;
                }
                break;
            case -610057368:
                if (str.equals("newSearch")) {
                    c = 21;
                    break;
                }
                break;
            case -582369019:
                if (str.equals("topGenres")) {
                    c = 11;
                    break;
                }
                break;
            case -557099315:
                if (str.equals("searchLists")) {
                    c = 5;
                    break;
                }
                break;
            case -84881872:
                if (str.equals("searchLolomo")) {
                    c = 3;
                    break;
                }
                break;
            case -17544705:
                if (str.equals("nonMemberVideos")) {
                    c = 28;
                    break;
                }
                break;
            case 102982549:
                if (str.equals("lists")) {
                    c = 2;
                    break;
                }
                break;
            case 109413654:
                if (str.equals("shows")) {
                    c = '\r';
                    break;
                }
                break;
            case 347140875:
                if (str.equals("lolomos")) {
                    c = 1;
                    break;
                }
                break;
            case 643818181:
                if (str.equals("videoCastStills")) {
                    c = 19;
                    break;
                }
                break;
            case 646493377:
                if (str.equals("genreList")) {
                    c = '\t';
                    break;
                }
                break;
            case 960849002:
                if (str.equals("filteredGenreList")) {
                    c = '\n';
                    break;
                }
                break;
            case 1065679688:
                if (str.equals("searchSuggestionByReference")) {
                    c = 24;
                    break;
                }
                break;
            case 1245424234:
                if (str.equals("characters")) {
                    c = 25;
                    break;
                }
                break;
            case 1272354024:
                if (str.equals("notifications")) {
                    c = 26;
                    break;
                }
                break;
            case 1385360876:
                if (str.equals("searchByReference")) {
                    c = 22;
                    break;
                }
                break;
            case 1663629379:
                if (str.equals("searchLolomos")) {
                    c = 4;
                    break;
                }
                break;
            case 1968370160:
                if (str.equals("seasons")) {
                    c = 16;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                C1049 r0 = new C1049();
                this.f5217 = r0;
                return r0;
            case 1:
                BranchMap<SummarizedList<C1049, LoLoMoSummary>> branchMap = new BranchMap<>(CO.f4958);
                this.f5212 = branchMap;
                return branchMap;
            case 2:
                BranchMap<FalkorList<C1049>> branchMap2 = new BranchMap<>(CO.m4225(this.f5211));
                this.f5220 = branchMap2;
                return branchMap2;
            case 3:
                BranchMap<C1049> branchMap3 = new BranchMap<>(CO.f4967);
                this.f5224 = branchMap3;
                return branchMap3;
            case 4:
                BranchMap<SummarizedList<C1049, LoLoMoSummary>> branchMap4 = new BranchMap<>(CO.f4958);
                this.f5221 = branchMap4;
                return branchMap4;
            case 5:
                BranchMap<FalkorList<C1049>> branchMap5 = new BranchMap<>(CO.m4225(this.f5211));
                this.f5230 = branchMap5;
                return branchMap5;
            case 6:
                BranchMap<C1049> branchMap6 = new BranchMap<>(CO.f4967);
                this.f5206 = branchMap6;
                return branchMap6;
            case 7:
                SummarizedList<CG, TrailersFeedItemSummary> r02 = CO.m4234(this.f5211);
                this.f5214 = r02;
                return r02;
            case '\b':
                BranchMap<SummarizedList<C1049, FlatGenreListOfVideosSummary>> branchMap7 = new BranchMap<>(CO.f4973);
                this.f5204 = branchMap7;
                return branchMap7;
            case '\t':
                C0993<ListOfListOfGenres> r03 = C0993.m15932(new ListOfListOfGenres());
                this.f5202 = r03;
                return r03;
            case '\n':
                BranchMap<C0993<ListOfListOfGenres>> branchMap8 = new BranchMap<>(CO.f4975);
                this.f5228 = branchMap8;
                return branchMap8;
            case 11:
                BranchMap<C1049> branchMap9 = new BranchMap<>(CO.f4967);
                this.f5222 = branchMap9;
                return branchMap9;
            case '\f':
                BranchMap<C1049> branchMap10 = new BranchMap<>(CO.f4967);
                this.f5219 = branchMap10;
                return branchMap10;
            case '\r':
                BranchMap<CH> branchMap11 = new BranchMap<>(CO.m4232(this.f5211));
                this.f5225 = branchMap11;
                return branchMap11;
            case 14:
                BranchMap<CH> branchMap12 = new BranchMap<>(CO.m4232(this.f5211));
                this.f5215 = branchMap12;
                return branchMap12;
            case 15:
                BranchMap<C1383Cz> branchMap13 = new BranchMap<>(CO.m4227(this.f5211));
                this.f5223 = branchMap13;
                return branchMap13;
            case 16:
                BranchMap<CB> branchMap14 = new BranchMap<>(CO.m4244(this.f5211));
                this.f5229 = branchMap14;
                return branchMap14;
            case 17:
                BranchMap<CF> branchMap15 = new BranchMap<>(CO.m4241(this.f5211));
                this.f5226 = branchMap15;
                return branchMap15;
            case 18:
                BranchMap<CC> branchMap16 = new BranchMap<>(CO.m4228(this.f5211));
                this.f5231 = branchMap16;
                return branchMap16;
            case 19:
                BranchMap<C1380Cw> branchMap17 = new BranchMap<>(CO.m4243(this.f5211));
                this.f5227 = branchMap17;
                return branchMap17;
            case 20:
                BranchMap<CE> branchMap18 = new BranchMap<>(CO.m4238(this.f5211));
                this.f5203 = branchMap18;
                return branchMap18;
            case 21:
                BranchMap<CI> branchMap19 = new BranchMap<>(CO.f4971);
                this.f5210 = branchMap19;
                return branchMap19;
            case 22:
                BranchMap<SummarizedList<CN, SearchTrackableListSummary>> branchMap20 = new BranchMap<>(CO.f4963);
                this.f5205 = branchMap20;
                return branchMap20;
            case 23:
                BranchMap<C1049> branchMap21 = new BranchMap<>(CO.f4967);
                this.f5208 = branchMap21;
                return branchMap21;
            case 24:
                BranchMap<SummarizedList<CN, SearchTrackableListSummary>> branchMap22 = new BranchMap<>(CO.f4963);
                this.f5207 = branchMap22;
                return branchMap22;
            case 25:
                BranchMap<CD> branchMap23 = new BranchMap<>(CO.m4230(this.f5211));
                this.f5209 = branchMap23;
                return branchMap23;
            case 26:
                BranchMap<C1382Cy> branchMap24 = new BranchMap<>(CO.m4242(this.f5211));
                this.f5218 = branchMap24;
                return branchMap24;
            case 27:
                SummarizedList<C1049, IrisNotificationsListSummary> r04 = CO.m4233(this.f5211);
                this.f5216 = r04;
                return r04;
            case 28:
                BranchMap<C1049> branchMap25 = new BranchMap<>(CO.f4967);
                this.f5213 = branchMap25;
                return branchMap25;
            default:
                throw new IllegalArgumentException("Unknown key: " + str);
        }
    }

    @Override // java.lang.Object
    public String toString() {
        return "Root{lolomo=" + this.f5217 + ", lolomos=" + this.f5212 + ", lists=" + this.f5220 + ", searchLolomoRefs=" + this.f5224 + ", searchLolomos=" + this.f5221 + ", searchLists=" + this.f5230 + ", watchHistory=" + this.f5206 + ", trailersFeed=" + this.f5214 + ", flastGenres=" + this.f5204 + ", genreList=" + this.f5202 + ", filteredGenreList=" + this.f5228 + ", topGenres=" + this.f5222 + ", videos=" + this.f5219 + ", movies=" + this.f5215 + ", shows=" + this.f5225 + ", episodes=" + this.f5223 + ", seasons=" + this.f5229 + ", postPlayExperiences=" + this.f5226 + ", people=" + this.f5231 + ", actorVideoStills=" + this.f5227 + ", suggestions=" + this.f5203 + ", characters=" + this.f5209 + ", newSearch=" + this.f5210 + ", notifications=" + this.f5218 + ", notificationsList=" + this.f5216 + ", nonMemberVideos=" + this.f5213 + ", proxy=" + this.f5211 + '}';
    }

    @Override // java.io.Flushable
    public void flush() {
        for (String str : m4560()) {
            remove(str);
        }
    }
}

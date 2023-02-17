package o;

import com.netflix.falkor.BranchMap;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.model.leafs.Season;
import java.util.HashSet;
import java.util.Set;
public class CB extends CH implements pS {

    /* renamed from: ˎ  reason: contains not printable characters */
    private BranchMap<C1049> f4689;

    /* renamed from: ˏ  reason: contains not printable characters */
    public Season.Detail f4690;

    public CB(AbstractC0929<? extends AbstractC0730> r1) {
        super(r1);
    }

    @Override // o.CH, o.AbstractC0730
    public Object get(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1335224239:
                if (str.equals("detail")) {
                    c = 0;
                    break;
                }
                break;
            case -632946216:
                if (str.equals("episodes")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return this.f4690;
            case 1:
                return this.f4689;
            default:
                return super.get(str);
        }
    }

    @Override // o.CH, o.AbstractC0730
    public Object getOrCreate(String str) {
        Object obj = get(str);
        if (obj != null) {
            return obj;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1335224239:
                if (str.equals("detail")) {
                    c = 0;
                    break;
                }
                break;
            case -632946216:
                if (str.equals("episodes")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                Season.Detail detail = new Season.Detail();
                this.f4690 = detail;
                return detail;
            case 1:
                BranchMap<C1049> branchMap = new BranchMap<>(CO.f4967);
                this.f4689 = branchMap;
                return branchMap;
            default:
                return super.getOrCreate(str);
        }
    }

    @Override // o.CH, o.AbstractC0730
    public void set(String str, Object obj) {
        if ("detail".equals(str)) {
            this.f4690 = (Season.Detail) obj;
        } else if ("episodes".equals(str)) {
            this.f4689 = (BranchMap) obj;
        } else {
            super.set(str, obj);
        }
    }

    @Override // o.CH, o.AbstractC0730
    public void remove(String str) {
        set(str, null);
    }

    @Override // o.CH
    public Set<String> getKeys() {
        HashSet hashSet = new HashSet();
        if (this.f4690 != null) {
            hashSet.add("detail");
        }
        if (this.f4689 != null) {
            hashSet.add("episodes");
        }
        return hashSet;
    }

    @Override // o.CH, o.AbstractC2072pu
    public String getId() {
        if (super.getId() != null) {
            return super.getId();
        }
        if (this.f4690 == null) {
            return null;
        }
        return this.f4690.id;
    }

    @Override // o.CH, o.AbstractC2072pu
    public String getTitle() {
        if (this.f4690 == null) {
            return null;
        }
        return this.f4690.getTitle();
    }

    @Override // o.CH, o.AbstractC2072pu
    public VideoType getType() {
        if (this.f4690 == null) {
            return null;
        }
        return this.f4690.getType();
    }

    @Override // o.CH, o.pS
    public int getNumOfEpisodes() {
        if (this.f4690 == null) {
            return -1;
        }
        return this.f4690.episodeCount;
    }

    @Override // o.CH, o.pF, o.pS
    public int getSeasonNumber() {
        if (this.f4690 == null) {
            return -1;
        }
        return this.f4690.number;
    }

    @Override // o.CH, o.pT
    public int getYear() {
        if (this.f4690 == null) {
            return 0;
        }
        return this.f4690.year;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m4169() {
        if (this.f4690 == null) {
            return null;
        }
        return this.f4690.showId;
    }

    @Override // o.CH, o.pF
    public String getTopLevelId() {
        return m4169();
    }

    @Override // o.CH
    public String toString() {
        return "FalkorSeason [getKeys()=" + getKeys() + ", getId()=" + getId() + ", getTitle()=" + getTitle() + ", getType()=" + getType() + ", getNumOfEpisodes()=" + getNumOfEpisodes() + ", getSeasonNumber()=" + getSeasonNumber() + ", getYear()=" + getYear() + ", showId=" + m4169() + "]";
    }
}

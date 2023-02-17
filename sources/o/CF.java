package o;

import com.netflix.falkor.BranchMap;
import com.netflix.model.leafs.PostPlayExperience;
public class CF implements AbstractC0730 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private PostPlayExperience f4711;

    /* renamed from: ˋ  reason: contains not printable characters */
    private BranchMap<BranchMap<C1049>> f4712;

    /* renamed from: ॱ  reason: contains not printable characters */
    private AbstractC0929<? extends AbstractC0730> f4713;

    public CF(AbstractC0929<? extends AbstractC0730> r1) {
        this.f4713 = r1;
    }

    @Override // o.AbstractC0730
    public Object get(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case 67631156:
                if (str.equals("experienceData")) {
                    c = 0;
                    break;
                }
                break;
            case 1305017683:
                if (str.equals("playbackVideos")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return this.f4711;
            case 1:
                return this.f4712;
            default:
                C1283.m16854("PostPlayExperienceMap", "Could not find key: " + str);
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
            case 67631156:
                if (str.equals("experienceData")) {
                    c = 0;
                    break;
                }
                break;
            case 1305017683:
                if (str.equals("playbackVideos")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                PostPlayExperience postPlayExperience = new PostPlayExperience(this.f4713);
                this.f4711 = postPlayExperience;
                return postPlayExperience;
            case 1:
                BranchMap<BranchMap<C1049>> branchMap = new BranchMap<>(new AbstractC1264<BranchMap<C1049>>() { // from class: o.CF.1
                    /* renamed from: ˎ  reason: contains not printable characters */
                    public BranchMap<C1049> mo4186() {
                        return new BranchMap<>(CO.f4967);
                    }
                });
                this.f4712 = branchMap;
                return branchMap;
            default:
                throw new IllegalArgumentException("Unknown key: " + str);
        }
    }

    @Override // o.AbstractC0730
    public void set(String str, Object obj) {
        char c = 65535;
        switch (str.hashCode()) {
            case 67631156:
                if (str.equals("experienceData")) {
                    c = 0;
                    break;
                }
                break;
            case 1305017683:
                if (str.equals("playbackVideos")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.f4711 = (PostPlayExperience) obj;
                return;
            case 1:
                this.f4712 = obj instanceof BranchMap ? (BranchMap) obj : null;
                return;
            default:
                C1283.m16854("PostPlayExperienceMap", "Don't know how to set key: " + str);
                return;
        }
    }

    @Override // o.AbstractC0730
    public void remove(String str) {
        set(str, null);
    }
}

package o;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.model.leafs.originals.ListOfTagSummary;
import java.util.Date;
import java.util.Map;
import java.util.Set;
public class CG extends AbstractC1381Cx implements pH {

    /* renamed from: ʻ  reason: contains not printable characters */
    private C0075 f4715;

    /* renamed from: ˋ  reason: contains not printable characters */
    private C1049 f4716;

    /* renamed from: ˎ  reason: contains not printable characters */
    private C1049 f4717;

    /* renamed from: ˏ  reason: contains not printable characters */
    private If f4718;

    /* renamed from: ॱ  reason: contains not printable characters */
    private Boolean f4719 = null;

    public static class If extends AbstractC0847 implements AbstractC0852 {

        /* renamed from: ˋ  reason: contains not printable characters */
        private Date f4720;

        /* renamed from: ˎ  reason: contains not printable characters */
        private String f4721;

        /* renamed from: ˏ  reason: contains not printable characters */
        private String f4722;

        @Override // o.AbstractC0852
        public void populate(JsonElement jsonElement) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            if (asJsonObject.has("releaseDate") && !asJsonObject.get("releaseDate").isJsonNull()) {
                this.f4720 = new Date(asJsonObject.get("releaseDate").getAsLong());
            }
            if (asJsonObject.has("releaseDateText") && !asJsonObject.get("releaseDateText").isJsonNull()) {
                this.f4721 = asJsonObject.get("releaseDateText").getAsString();
            }
            if (asJsonObject.has("seasonLabel") && !asJsonObject.get("seasonLabel").isJsonNull()) {
                this.f4722 = asJsonObject.get("seasonLabel").getAsString();
            }
        }

        public String toString() {
            return super.toString();
        }
    }

    /* renamed from: o.CG$ˋ  reason: contains not printable characters */
    public static class C0075 extends AbstractC0847 implements AbstractC0852 {

        /* renamed from: ˊ  reason: contains not printable characters */
        private ListOfTagSummary[] f4723;

        @Override // o.AbstractC0852
        public void populate(JsonElement jsonElement) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            if (asJsonObject.has("values") && !asJsonObject.get("values").isJsonNull()) {
                JsonArray asJsonArray = asJsonObject.get("values").getAsJsonArray();
                this.f4723 = new ListOfTagSummary[asJsonArray.size()];
                for (int i = 0; i < asJsonArray.size(); i++) {
                    Set<Map.Entry<String, JsonElement>> entrySet = asJsonArray.get(i).getAsJsonObject().entrySet();
                    if (entrySet.size() == 1) {
                        Map.Entry<String, JsonElement> next = entrySet.iterator().next();
                        this.f4723[i] = new ListOfTagSummary(next.getValue().getAsString(), next.getKey(), i);
                    } else {
                        C1276.m16820().mo5725("invalid tag found, got " + entrySet.size() + " values");
                    }
                }
            }
        }

        public String toString() {
            return super.toString();
        }
    }

    public CG(AbstractC0929<? extends AbstractC0730> r2) {
        super(r2);
    }

    @Override // o.AbstractC0730
    public Object get(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1335224239:
                if (str.equals("detail")) {
                    c = 1;
                    break;
                }
                break;
            case -1325622620:
                if (str.equals("supplemental")) {
                    c = 3;
                    break;
                }
                break;
            case 3552281:
                if (str.equals("tags")) {
                    c = 0;
                    break;
                }
                break;
            case 112202875:
                if (str.equals("video")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return this.f4715;
            case 1:
                return this.f4718;
            case 2:
                return this.f4717;
            case 3:
                return this.f4716;
            default:
                C1283.m16851("FalkorTrailerFeedItem", "Could not find key: %s", str);
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
            case -1335224239:
                if (str.equals("detail")) {
                    c = 1;
                    break;
                }
                break;
            case -1325622620:
                if (str.equals("supplemental")) {
                    c = 3;
                    break;
                }
                break;
            case 3552281:
                if (str.equals("tags")) {
                    c = 0;
                    break;
                }
                break;
            case 112202875:
                if (str.equals("video")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                C0075 r0 = new C0075();
                this.f4715 = r0;
                return r0;
            case 1:
                If r02 = new If();
                this.f4718 = r02;
                return r02;
            case 2:
                C1049 r03 = new C1049();
                this.f4717 = r03;
                return r03;
            case 3:
                C1049 r04 = new C1049();
                this.f4716 = r04;
                return r04;
            default:
                throw new IllegalArgumentException("Unknown key: " + str);
        }
    }

    @Override // o.AbstractC0730
    public void set(String str, Object obj) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1335224239:
                if (str.equals("detail")) {
                    c = 1;
                    break;
                }
                break;
            case -1325622620:
                if (str.equals("supplemental")) {
                    c = 3;
                    break;
                }
                break;
            case 3552281:
                if (str.equals("tags")) {
                    c = 0;
                    break;
                }
                break;
            case 112202875:
                if (str.equals("video")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (!(obj instanceof C1128)) {
                    this.f4715 = (C0075) obj;
                    return;
                } else {
                    this.f4715 = null;
                    return;
                }
            case 1:
                if (!(obj instanceof C1128)) {
                    this.f4718 = (If) obj;
                    return;
                } else {
                    this.f4718 = null;
                    return;
                }
            case 2:
                if (!(obj instanceof C1128)) {
                    this.f4717 = (C1049) obj;
                    return;
                } else {
                    this.f4717 = null;
                    return;
                }
            case 3:
                if (!(obj instanceof C1128)) {
                    this.f4716 = (C1049) obj;
                    return;
                } else {
                    this.f4716 = null;
                    return;
                }
            default:
                C1283.m16851("FalkorTrailerFeedItem", "Don't know how to set key: %s", str);
                return;
        }
    }

    @Override // o.AbstractC0730
    public void remove(String str) {
        set(str, null);
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private CH m4188() {
        if (this.f4717 != null) {
            return (CH) this.f4717.m16078(this.proxy);
        }
        return null;
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private CH m4189() {
        if (this.f4716 != null) {
            return (CH) this.f4716.m16078(this.proxy);
        }
        return null;
    }

    @Override // o.pH
    /* renamed from: ˎ  reason: contains not printable characters */
    public Date mo4196() {
        if (this.f4718 != null) {
            return this.f4718.f4720;
        }
        return null;
    }

    @Override // o.pH
    /* renamed from: ˊ  reason: contains not printable characters */
    public String mo4193() {
        if (this.f4718 != null) {
            return this.f4718.f4721;
        }
        return null;
    }

    @Override // o.pH
    /* renamed from: ˏ  reason: contains not printable characters */
    public CharSequence mo4198() {
        CH r1 = m4188();
        if (r1 != null) {
            return r1.getTitle();
        }
        return null;
    }

    @Override // o.pH
    /* renamed from: ॱ  reason: contains not printable characters */
    public CharSequence mo4200() {
        CH r1 = m4188();
        if (r1 != null) {
            return r1.getSynopsis();
        }
        return null;
    }

    @Override // o.pH
    /* renamed from: ˋ  reason: contains not printable characters */
    public String mo4195() {
        CH r1 = m4188();
        if (r1 != null) {
            return r1.getHorzDispUrl();
        }
        return null;
    }

    @Override // o.pH
    /* renamed from: ʼ  reason: contains not printable characters */
    public ListOfTagSummary[] mo4191() {
        if (this.f4715 != null) {
            return this.f4715.f4723;
        }
        return null;
    }

    @Override // o.pH
    /* renamed from: ʽ  reason: contains not printable characters */
    public pF mo4192() {
        return m4189();
    }

    @Override // o.pH
    /* renamed from: ͺ  reason: contains not printable characters */
    public String mo4199() {
        CH r1 = m4188();
        if (r1 != null) {
            return r1.getId();
        }
        return null;
    }

    @Override // o.pH
    /* renamed from: ᐝ  reason: contains not printable characters */
    public String mo4203() {
        CH r1 = m4188();
        if (r1 != null) {
            return r1.getBoxartId();
        }
        return null;
    }

    @Override // o.pH
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public String mo4202() {
        if (this.f4718 != null) {
            return this.f4718.f4722;
        }
        return null;
    }

    @Override // o.pH
    /* renamed from: ॱˊ  reason: contains not printable characters */
    public VideoType mo4201() {
        CH r1 = m4188();
        if (r1 != null) {
            return r1.getType();
        }
        return null;
    }

    @Override // o.pH
    /* renamed from: ˊॱ  reason: contains not printable characters */
    public boolean mo4194() {
        if (this.f4719 != null) {
            return this.f4719.booleanValue();
        }
        CH r1 = m4188();
        if (r1 != null) {
            return r1.isInQueue();
        }
        return false;
    }

    @Override // o.pH
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo4197(boolean z) {
        this.f4719 = Boolean.valueOf(z);
    }

    @Override // o.pH
    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean mo4190() {
        return mo4192() != null;
    }

    public String toString() {
        return super.toString();
    }
}

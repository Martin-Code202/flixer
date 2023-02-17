package o;

import android.text.TextUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.netflix.model.leafs.SearchPerson;
import com.netflix.model.leafs.Video;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class CC extends AbstractC1381Cx implements AbstractC2081qb {

    /* renamed from: ˊ  reason: contains not printable characters */
    public C0073 f4691;

    /* renamed from: ˋ  reason: contains not printable characters */
    public SearchPerson f4692;

    /* renamed from: ˎ  reason: contains not printable characters */
    public Video.Summary f4693;

    /* renamed from: ॱ  reason: contains not printable characters */
    public C0074 f4694;

    public CC(AbstractC0929<? extends AbstractC0730> r1) {
        super(r1);
    }

    @Override // o.AbstractC0730
    public Object get(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1857640538:
                if (str.equals("summary")) {
                    c = 0;
                    break;
                }
                break;
            case -1335224239:
                if (str.equals("detail")) {
                    c = 2;
                    break;
                }
                break;
            case -549710448:
                if (str.equals("searchTitle")) {
                    c = 1;
                    break;
                }
                break;
            case 1838044613:
                if (str.equals("videoListForPerson")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return this.f4693;
            case 1:
                return this.f4692;
            case 2:
                return this.f4694;
            case 3:
                return this.f4691;
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
                    c = 0;
                    break;
                }
                break;
            case -1335224239:
                if (str.equals("detail")) {
                    c = 2;
                    break;
                }
                break;
            case -549710448:
                if (str.equals("searchTitle")) {
                    c = 1;
                    break;
                }
                break;
            case 1838044613:
                if (str.equals("videoListForPerson")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                Video.Summary summary = new Video.Summary();
                this.f4693 = summary;
                return summary;
            case 1:
                SearchPerson searchPerson = new SearchPerson();
                this.f4692 = searchPerson;
                return searchPerson;
            case 2:
                C0074 r0 = new C0074();
                this.f4694 = r0;
                return r0;
            case 3:
                C0073 r02 = new C0073();
                this.f4691 = r02;
                return r02;
            default:
                return null;
        }
    }

    @Override // o.AbstractC0730
    public void set(String str, Object obj) {
        if ("searchTitle".equals(str)) {
            this.f4692 = (SearchPerson) obj;
        } else if ("summary".equals(str)) {
            this.f4693 = (Video.Summary) obj;
        } else if ("detail".equals(str)) {
            this.f4694 = (C0074) obj;
        } else if ("videoListForPerson".equals(str)) {
            this.f4691 = (C0073) obj;
        } else {
            throw new IllegalStateException("Can't set key: " + str);
        }
    }

    @Override // o.AbstractC0730
    public void remove(String str) {
        set(str, null);
    }

    /* renamed from: o.CC$ˋ  reason: contains not printable characters */
    public static final class C0074 implements AbstractC0852 {

        /* renamed from: ʻ  reason: contains not printable characters */
        public String f4697;

        /* renamed from: ʼ  reason: contains not printable characters */
        public String f4698;

        /* renamed from: ˊ  reason: contains not printable characters */
        public String f4699;

        /* renamed from: ˋ  reason: contains not printable characters */
        public Set<String> f4700 = new HashSet();

        /* renamed from: ˎ  reason: contains not printable characters */
        public String f4701;

        /* renamed from: ˏ  reason: contains not printable characters */
        public String f4702;

        /* renamed from: ॱ  reason: contains not printable characters */
        public String f4703;

        @Override // o.AbstractC0852
        public void populate(JsonElement jsonElement) {
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                JsonElement value = entry.getValue();
                String key = entry.getKey();
                char c = 65535;
                switch (key.hashCode()) {
                    case -1185088852:
                        if (key.equals("imgUrl")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -895757675:
                        if (key.equals("spouse")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -365615482:
                        if (key.equals("knownFor")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 3355:
                        if (key.equals("id")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 3029833:
                        if (key.equals("born")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 3373707:
                        if (key.equals("name")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 344945940:
                        if (key.equals("characterRoles")) {
                            c = 6;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.f4701 = AK.m3375(value);
                        break;
                    case 1:
                        this.f4702 = value.getAsString();
                        break;
                    case 2:
                        this.f4698 = AK.m3375(value);
                        break;
                    case 3:
                        this.f4703 = AK.m3375(value);
                        break;
                    case 4:
                        this.f4697 = value.getAsString();
                        break;
                    case 5:
                        this.f4699 = value.getAsString();
                        break;
                    case 6:
                        this.f4700.clear();
                        if (!value.isJsonNull()) {
                            String asString = value.getAsString();
                            if (!TextUtils.isEmpty(asString)) {
                                Collections.addAll(this.f4700, asString.split(","));
                                break;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                }
            }
        }
    }

    /* renamed from: o.CC$ˊ  reason: contains not printable characters */
    public class C0073 implements AbstractC0852 {

        /* renamed from: ˎ  reason: contains not printable characters */
        public List<String> f4695 = new ArrayList();

        public C0073() {
        }

        @Override // o.AbstractC0852
        public void populate(JsonElement jsonElement) {
            this.f4695.clear();
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                JsonElement value = entry.getValue();
                if (value.isJsonArray()) {
                    JsonArray asJsonArray = value.getAsJsonArray();
                    if (asJsonArray.get(1) != null) {
                        this.f4695.add(asJsonArray.get(1).getAsString());
                    }
                }
            }
        }
    }
}

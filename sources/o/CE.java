package o;

import com.netflix.model.leafs.SearchSuggestion;
public class CE extends AbstractC1381Cx implements AbstractC2083qd {

    /* renamed from: ˋ  reason: contains not printable characters */
    public SearchSuggestion f4710;

    public CE(AbstractC0929<? extends AbstractC0730> r1) {
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
            case -549710448:
                if (str.equals("searchTitle")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return this.f4710;
            case 1:
                return null;
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
            case -549710448:
                if (str.equals("searchTitle")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                SearchSuggestion searchSuggestion = new SearchSuggestion();
                this.f4710 = searchSuggestion;
                return searchSuggestion;
            case 1:
                return null;
            default:
                return null;
        }
    }

    @Override // o.AbstractC0730
    public void set(String str, Object obj) {
        if ("searchTitle".equals(str)) {
            this.f4710 = (SearchSuggestion) obj;
        } else if (!"summary".equals(str)) {
            throw new IllegalStateException("Can't set key: " + str);
        }
    }

    @Override // o.AbstractC0730
    public void remove(String str) {
        set(str, null);
    }

    @Override // o.AbstractC2083qd
    public String getTitle() {
        if (this.f4710 == null) {
            return null;
        }
        return this.f4710.getTitle();
    }

    @Override // o.AbstractC2083qd
    public String getEntityId() {
        if (this.f4710 == null) {
            return null;
        }
        return this.f4710.getEntityId();
    }
}

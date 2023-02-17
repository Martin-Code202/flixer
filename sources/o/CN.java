package o;

import com.netflix.model.leafs.SearchCollectionEntity;
public class CN implements AbstractC0730 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private C1049 f4955;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f4956;

    /* renamed from: ˏ  reason: contains not printable characters */
    private SearchCollectionEntity f4957;

    @Override // o.AbstractC0730
    public Object get(String str) {
        if (this.f4956) {
            return C1128.m16280();
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1857640538:
                if (str.equals("summary")) {
                    c = 0;
                    break;
                }
                break;
            case 3242771:
                if (str.equals("item")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return this.f4957;
            case 1:
                return this.f4955;
            default:
                C1283.m16854("SearchByReferenceMap", "Could not find key: " + str);
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
            case 3242771:
                if (str.equals("item")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                SearchCollectionEntity searchCollectionEntity = new SearchCollectionEntity();
                this.f4957 = searchCollectionEntity;
                return searchCollectionEntity;
            case 1:
                C1049 r0 = new C1049();
                this.f4955 = r0;
                return r0;
            default:
                throw new IllegalArgumentException("Unknown key: " + str);
        }
    }

    @Override // o.AbstractC0730
    public void set(String str, Object obj) {
        if (obj instanceof C1128) {
            this.f4956 = true;
            return;
        }
        this.f4956 = false;
        char c = 65535;
        switch (str.hashCode()) {
            case -1857640538:
                if (str.equals("summary")) {
                    c = 0;
                    break;
                }
                break;
            case 3242771:
                if (str.equals("item")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.f4957 = (SearchCollectionEntity) obj;
                return;
            case 1:
                this.f4955 = (C1049) obj;
                return;
            default:
                C1283.m16854("SearchByReferenceMap", "Don't know how to set key: " + str);
                return;
        }
    }

    @Override // o.AbstractC0730
    public void remove(String str) {
        set(str, null);
    }
}

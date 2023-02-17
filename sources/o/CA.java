package o;

import com.netflix.model.leafs.SceneSummary;
public class CA extends AbstractC1381Cx {

    /* renamed from: ॱ  reason: contains not printable characters */
    public SceneSummary f4688;

    public CA(AbstractC0929<? extends AbstractC0730> r1) {
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
        }
        switch (c) {
            case 0:
                return this.f4688;
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
        }
        switch (c) {
            case 0:
                SceneSummary sceneSummary = new SceneSummary();
                this.f4688 = sceneSummary;
                return sceneSummary;
            default:
                return null;
        }
    }

    @Override // o.AbstractC0730
    public void set(String str, Object obj) {
        if ("summary".equals(str)) {
            this.f4688 = (SceneSummary) obj;
        }
    }

    @Override // o.AbstractC0730
    public void remove(String str) {
        set(str, null);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public int m4168() {
        if (this.f4688 == null) {
            return 0;
        }
        return this.f4688.position;
    }

    public String toString() {
        return "FalkorScene{sceneSummary=" + this.f4688 + '}';
    }
}

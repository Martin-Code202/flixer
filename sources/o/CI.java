package o;
public class CI implements AbstractC0730 {

    /* renamed from: ˏ  reason: contains not printable characters */
    private C1049 f4724;

    /* renamed from: ॱ  reason: contains not printable characters */
    private C1049 f4725;

    @Override // o.AbstractC0730
    public Object get(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -873453285:
                if (str.equals("titles")) {
                    c = 0;
                    break;
                }
                break;
            case 443716983:
                if (str.equals("titleSuggestions")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return this.f4724;
            case 1:
                return this.f4725;
            default:
                C1283.m16854("NewSearchMap", "Could not find key: " + str);
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
            case -873453285:
                if (str.equals("titles")) {
                    c = 0;
                    break;
                }
                break;
            case 443716983:
                if (str.equals("titleSuggestions")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                C1049 r0 = new C1049();
                this.f4724 = r0;
                return r0;
            case 1:
                C1049 r02 = new C1049();
                this.f4725 = r02;
                return r02;
            default:
                throw new IllegalArgumentException("Unknown key: " + str);
        }
    }

    @Override // o.AbstractC0730
    public void set(String str, Object obj) {
        char c = 65535;
        switch (str.hashCode()) {
            case -873453285:
                if (str.equals("titles")) {
                    c = 0;
                    break;
                }
                break;
            case 443716983:
                if (str.equals("titleSuggestions")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.f4724 = (C1049) obj;
                return;
            case 1:
                this.f4725 = (C1049) obj;
                return;
            default:
                C1283.m16854("NewSearchMap", "Don't know how to set key: " + str);
                return;
        }
    }

    @Override // o.AbstractC0730
    public void remove(String str) {
        set(str, null);
    }
}

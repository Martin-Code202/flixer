package o;
public class CJ implements AbstractC0730 {

    /* renamed from: ʽ  reason: contains not printable characters */
    public String f4726;

    /* renamed from: ˊ  reason: contains not printable characters */
    public String f4727;

    /* renamed from: ˋ  reason: contains not printable characters */
    public String f4728;

    /* renamed from: ˎ  reason: contains not printable characters */
    public String f4729;

    /* renamed from: ˏ  reason: contains not printable characters */
    public String f4730;

    /* renamed from: ॱ  reason: contains not printable characters */
    public String f4731;

    /* renamed from: ᐝ  reason: contains not printable characters */
    public String f4732;

    @Override // o.AbstractC0730
    public Object get(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1775293087:
                if (str.equals("storyArtUrl")) {
                    c = 6;
                    break;
                }
                break;
            case -1709132411:
                if (str.equals("firstVideoType")) {
                    c = 4;
                    break;
                }
                break;
            case -1443969683:
                if (str.equals("firstVideoTitle")) {
                    c = 2;
                    break;
                }
                break;
            case 237517239:
                if (str.equals("boxArtUrl")) {
                    c = 5;
                    break;
                }
                break;
            case 310779465:
                if (str.equals("collectionName")) {
                    c = 0;
                    break;
                }
                break;
            case 373639718:
                if (str.equals("firstVideoId")) {
                    c = 3;
                    break;
                }
                break;
            case 1636075609:
                if (str.equals("collectionId")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return this.f4730;
            case 1:
                return this.f4727;
            case 2:
                return this.f4728;
            case 3:
                return this.f4729;
            case 4:
                return this.f4732;
            case 5:
                return this.f4731;
            case 6:
                return this.f4726;
            default:
                C1283.m16854("MementoVideoSwatch", "Could not find key: " + str);
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
            case -1775293087:
                if (str.equals("storyArtUrl")) {
                    c = 6;
                    break;
                }
                break;
            case -1709132411:
                if (str.equals("firstVideoType")) {
                    c = 4;
                    break;
                }
                break;
            case -1443969683:
                if (str.equals("firstVideoTitle")) {
                    c = 2;
                    break;
                }
                break;
            case 237517239:
                if (str.equals("boxArtUrl")) {
                    c = 5;
                    break;
                }
                break;
            case 310779465:
                if (str.equals("collectionName")) {
                    c = 0;
                    break;
                }
                break;
            case 373639718:
                if (str.equals("firstVideoId")) {
                    c = 3;
                    break;
                }
                break;
            case 1636075609:
                if (str.equals("collectionId")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new String();
            case 1:
                return new String();
            case 2:
                return new String();
            case 3:
                return new String();
            case 4:
                return new String();
            case 5:
                return new String();
            case 6:
                return new String();
            default:
                throw new IllegalArgumentException("Unknown key: " + str);
        }
    }

    @Override // o.AbstractC0730
    public void set(String str, Object obj) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1775293087:
                if (str.equals("storyArtUrl")) {
                    c = 6;
                    break;
                }
                break;
            case -1709132411:
                if (str.equals("firstVideoType")) {
                    c = 4;
                    break;
                }
                break;
            case -1443969683:
                if (str.equals("firstVideoTitle")) {
                    c = 2;
                    break;
                }
                break;
            case 237517239:
                if (str.equals("boxArtUrl")) {
                    c = 5;
                    break;
                }
                break;
            case 310779465:
                if (str.equals("collectionName")) {
                    c = 0;
                    break;
                }
                break;
            case 373639718:
                if (str.equals("firstVideoId")) {
                    c = 3;
                    break;
                }
                break;
            case 1636075609:
                if (str.equals("collectionId")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.f4730 = (String) obj;
                return;
            case 1:
                this.f4727 = (String) obj;
                return;
            case 2:
                this.f4728 = (String) obj;
                return;
            case 3:
                this.f4729 = (String) obj;
                return;
            case 4:
                this.f4732 = (String) obj;
                return;
            case 5:
                this.f4731 = (String) obj;
                return;
            case 6:
                this.f4726 = (String) obj;
                return;
            default:
                C1283.m16854("MementoVideoSwatch", "Don't know how to set key: " + str);
                return;
        }
    }

    @Override // o.AbstractC0730
    public void remove(String str) {
        set(str, null);
    }
}

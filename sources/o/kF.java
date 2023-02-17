package o;

import java.util.Map;
import java.util.Set;
public class kF {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Map<String, kD[]> f8156;

    public kF(Map<String, kD[]> map) {
        this.f8156 = map;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public kD[] m8200(String str) {
        return this.f8156.get(str);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public Set<String> m8199() {
        return this.f8156.keySet();
    }

    public String toString() {
        return "NetflixLocationMap{locationMap=" + this.f8156 + '}';
    }
}

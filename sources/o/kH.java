package o;

import java.util.Map;
public class kH {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Map<String, Cif> f8160;

    public kH(Map<String, Cif> map) {
        this.f8160 = map;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public Cif m8201(String str) {
        return this.f8160.get(str);
    }

    /* renamed from: o.kH$if  reason: invalid class name */
    public static class Cif {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final int f8161;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final String f8162;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final int f8163;

        public Cif(int i, int i2, String str) {
            this.f8163 = i;
            this.f8161 = i2;
            this.f8162 = str;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public int m8204() {
            return this.f8163;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public int m8202() {
            return this.f8161;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public String m8203() {
            return this.f8162;
        }
    }
}

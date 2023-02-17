package o;
public class AT {
    /* renamed from: ॱ  reason: contains not printable characters */
    public static int m3414(int i, int i2) {
        return (int) ((((float) i) / ((float) i2)) + 0.5f);
    }

    public static class iF {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final int f4297;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final int f4298;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final int f4299;

        public iF(int i, int i2) {
            this.f4299 = i;
            this.f4298 = i2;
            this.f4297 = AT.m3414(i + i2, 2);
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public boolean m3415(int i) {
            return i >= this.f4299 && i <= this.f4298;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public int m3416() {
            return this.f4297;
        }

        public String toString() {
            return "Range [start=" + this.f4299 + ", end=" + this.f4298 + "]";
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static int m3413(int i, int i2, int i3) {
        if (i < i2) {
            return i2;
        }
        if (i > i3) {
            return i3;
        }
        return i;
    }
}

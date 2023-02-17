package o;
/* renamed from: o.ᵖ  reason: contains not printable characters */
public class C1021 {
    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m15987(float f, float f2) {
        return (Float.isNaN(f) || Float.isNaN(f2)) ? Float.isNaN(f) && Float.isNaN(f2) : Math.abs(f2 - f) < 1.0E-5f;
    }
}

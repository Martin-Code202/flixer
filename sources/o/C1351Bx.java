package o;

import java.util.Formatter;
import java.util.Locale;
/* renamed from: o.Bx  reason: case insensitive filesystem */
public class C1351Bx {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final StringBuilder f4665 = new StringBuilder();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Formatter f4666 = new Formatter(this.f4665, Locale.getDefault());

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m4134(int i) {
        this.f4665.setLength(0);
        if (i < 0) {
            C1283.m16865("TimeFormatterHelper", "Received negative time: " + i);
            return this.f4666.format("%02d:%02d", 0, 0).toString();
        }
        int i2 = i % 60;
        int i3 = (i / 60) % 60;
        int i4 = i / 3600;
        if (i4 > 0) {
            return this.f4666.format("%d:%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2)).toString();
        }
        return this.f4666.format("%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i2)).toString();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m4133(int i) {
        return m4134(i / 1000);
    }
}

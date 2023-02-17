package o;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* renamed from: o.os  reason: case insensitive filesystem */
public class C2043os {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final Pattern f9363 = Pattern.compile("^([\\d.]+)\\s.*?\\s\\(([^;)]*)(?:;.*?|)\\).*?(?:,\\s?([\\d.]+)\\s?(c\\d{3}\\.?([a-z0-9.]+)\\.nflxvideo\\.net)\\s?\\((FTL)\\))?$");

    /* renamed from: ˊ  reason: contains not printable characters */
    private Matcher f9364 = f9363.matcher(this.f9365);

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f9365;

    public C2043os(String str) {
        this.f9365 = str;
        if (!this.f9364.matches()) {
            C1283.m16844("ViaHeaderParser", "unable to parse Via header: %s", this.f9365);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m9709() {
        if (this.f9364.groupCount() >= 6) {
            return "FTL".equals(this.f9364.group(6));
        }
        return false;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m9710() {
        return this.f9365;
    }
}

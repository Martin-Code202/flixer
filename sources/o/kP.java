package o;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class kP {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final Pattern f8267 = Pattern.compile("^([0-9]*)\\.([0-9]*)\\.([0-9]*)$");

    /* renamed from: ॱ  reason: contains not printable characters */
    public static C0134 m8293(String str) {
        Matcher matcher = f8267.matcher(str);
        if (matcher.find()) {
            try {
                return new C0134(Integer.parseInt(matcher.group(1)), matcher.group(2), matcher.group(3));
            } catch (NumberFormatException e) {
                C1283.m16844("nf_cache", "unable to parse track type %s", matcher.group(1));
                return null;
            }
        } else {
            C1283.m16844("nf_cache", "unable to parse key %s", str);
            return null;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m8292(String str, String str2, Long l) {
        int i = 0;
        if (str != null && str.length() > 1) {
            String substring = str.substring(0, 1);
            char c = 65535;
            switch (substring.hashCode()) {
                case 65:
                    if (substring.equals("A")) {
                        c = 0;
                        break;
                    }
                    break;
                case 86:
                    if (substring.equals("V")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    i = 1;
                    break;
                case 1:
                    i = 2;
                    break;
            }
        }
        return i + "." + str2 + "." + l;
    }

    /* renamed from: o.kP$ˋ  reason: contains not printable characters */
    public static final class C0134 {

        /* renamed from: ˊ  reason: contains not printable characters */
        public final int f8268;

        /* renamed from: ˎ  reason: contains not printable characters */
        public final String f8269;

        /* renamed from: ॱ  reason: contains not printable characters */
        public final String f8270;

        C0134(int i, String str, String str2) {
            this.f8268 = i;
            this.f8270 = str;
            this.f8269 = str2;
        }
    }
}

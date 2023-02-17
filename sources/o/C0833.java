package o;

import java.util.Map;
import o.AbstractC1001;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;
/* renamed from: o.ᓪ  reason: contains not printable characters */
public class C0833 {
    /* renamed from: ˊ  reason: contains not printable characters */
    public static AbstractC1001.Cif m15449(C1181 r21) {
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = r21.f15528;
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        boolean z = false;
        String str = map.get("Date");
        if (str != null) {
            j = m15450(str);
        }
        String str2 = map.get("Cache-Control");
        if (str2 != null) {
            z = true;
            String[] split = str2.split(",");
            for (int i = 0; i < split.length; i++) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j4 = Long.parseLong(trim.substring(8));
                    } catch (Exception e) {
                    }
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    j4 = 0;
                }
            }
        }
        String str3 = map.get("Expires");
        if (str3 != null) {
            j2 = m15450(str3);
        }
        String str4 = map.get("ETag");
        if (z) {
            j3 = currentTimeMillis + (1000 * j4);
        } else if (j > 0 && j2 >= j) {
            j3 = currentTimeMillis + (j2 - j);
        }
        AbstractC1001.Cif ifVar = new AbstractC1001.Cif();
        ifVar.f15077 = r21.f15530;
        ifVar.f15078 = str4;
        ifVar.f15080 = j3;
        ifVar.f15076 = ifVar.f15080;
        ifVar.f15079 = j;
        ifVar.f15075 = map;
        return ifVar;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static long m15450(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException e) {
            return 0;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m15448(Map<String, String> map) {
        String str = map.get("Content-Type");
        if (str == null) {
            return "ISO-8859-1";
        }
        String[] split = str.split(";");
        for (int i = 1; i < split.length; i++) {
            String[] split2 = split[i].trim().split("=");
            if (split2.length == 2 && split2[0].equals("charset")) {
                return split2[1];
            }
        }
        return "ISO-8859-1";
    }
}

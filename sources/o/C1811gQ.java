package o;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* renamed from: o.gQ  reason: case insensitive filesystem */
public class C1811gQ {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final Charset f6911 = Charset.forName("UTF-8");

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Map<String, Object> m6590(C0355 r1, String str) {
        return m6589(r1.m13977(str));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static Map<String, Object> m6589(C0355 r4) {
        HashMap hashMap = new HashMap();
        Iterator r2 = r4.m13974();
        while (r2.hasNext()) {
            String str = (String) r2.next();
            hashMap.put(str, m6587(r4.m13984(str)));
        }
        return hashMap;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static List m6591(C0572 r3) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < r3.m14673(); i++) {
            arrayList.add(m6587(r3.m14670(i)));
        }
        return arrayList;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static Object m6587(Object obj) {
        if (obj == C0355.f13107) {
            return null;
        }
        if (obj instanceof C0355) {
            return m6589((C0355) obj);
        }
        if (obj instanceof C0572) {
            return m6591((C0572) obj);
        }
        return obj;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    static String m6588(String str) {
        StringBuilder sb = new StringBuilder();
        if (str == null || str.length() == 0) {
            sb.append("\"\"");
            return sb.toString();
        }
        char c = 0;
        int length = str.length();
        sb.append('\"');
        for (int i = 0; i < length; i++) {
            c = str.charAt(i);
            switch (c) {
                case '\b':
                    sb.append("\\b");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case '\"':
                case '\\':
                    sb.append('\\');
                    sb.append(c);
                    break;
                case '/':
                    if (c == '<') {
                        sb.append('\\');
                    }
                    sb.append(c);
                    break;
                default:
                    if (c < ' ' || ((c >= 128 && c < 160) || (c >= 8192 && c < 8448))) {
                        sb.append("\\u");
                        String hexString = Integer.toHexString(c);
                        sb.append((CharSequence) "0000", 0, 4 - hexString.length());
                        sb.append(hexString);
                        break;
                    } else {
                        sb.append(c);
                        break;
                    }
            }
        }
        sb.append('\"');
        return sb.toString();
    }
}

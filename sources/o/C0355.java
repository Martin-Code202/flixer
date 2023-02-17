package o;

import com.netflix.android.org.json.JSONException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* renamed from: o.ƚ  reason: contains not printable characters */
public class C0355 {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final Object f13107 = new C0356();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Map f13108;

    /* renamed from: o.ƚ$ˊ  reason: contains not printable characters */
    static final class C0356 {
        private C0356() {
        }

        /* access modifiers changed from: protected */
        public final Object clone() {
            return this;
        }

        public boolean equals(Object obj) {
            return obj == null || obj == this;
        }

        public String toString() {
            return "null";
        }
    }

    public C0355() {
        this.f13108 = new HashMap();
    }

    public C0355(C0608 r5) {
        this();
        if (r5.m14737() != '{') {
            throw r5.m14744("A JSONObject text must begin with '{'");
        }
        while (true) {
            switch (r5.m14737()) {
                case 0:
                    throw r5.m14744("A JSONObject text must end with '}'");
                case '}':
                    return;
                default:
                    r5.m14739();
                    String obj = r5.m14736().toString();
                    if (r5.m14737() != ':') {
                        throw r5.m14744("Expected a ':' after a key");
                    }
                    m13979(obj, r5.m14736());
                    switch (r5.m14737()) {
                        case ',':
                        case ';':
                            if (r5.m14737() != '}') {
                                r5.m14739();
                            } else {
                                return;
                            }
                        case '}':
                            return;
                        default:
                            throw r5.m14744("Expected a ',' or '}'");
                    }
            }
        }
    }

    public C0355(Map map) {
        this.f13108 = new HashMap();
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                Object value = entry.getValue();
                if (value != null) {
                    this.f13108.put(entry.getKey(), m13966(value));
                }
            }
        }
    }

    public C0355(Object obj) {
        this();
        m13965(obj);
    }

    public C0355(String str) {
        this(new C0608(str));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public Object m13984(String str) {
        if (str == null) {
            throw new JSONException("Null key.");
        }
        Object r3 = m13970(str);
        if (r3 != null) {
            return r3;
        }
        throw new JSONException("JSONObject[" + m13964(str) + "] not found.");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public int m13988(String str) {
        Object r3 = m13984(str);
        if (!(r3 instanceof Number)) {
            return Integer.parseInt((String) r3);
        }
        try {
            return ((Number) r3).intValue();
        } catch (Exception e) {
            throw new JSONException("JSONObject[" + m13964(str) + "] is not an int.");
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C0355 m13977(String str) {
        Object r3 = m13984(str);
        if (r3 instanceof C0355) {
            return (C0355) r3;
        }
        throw new JSONException("JSONObject[" + m13964(str) + "] is not a JSONObject.");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public long m13973(String str) {
        Object r3 = m13984(str);
        if (!(r3 instanceof Number)) {
            return Long.parseLong((String) r3);
        }
        try {
            return ((Number) r3).longValue();
        } catch (Exception e) {
            throw new JSONException("JSONObject[" + m13964(str) + "] is not a long.");
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m13980(String str) {
        Object r3 = m13984(str);
        if (r3 instanceof String) {
            return (String) r3;
        }
        throw new JSONException("JSONObject[" + m13964(str) + "] not a string.");
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public boolean m13991(String str) {
        return this.f13108.containsKey(str);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public Iterator m13974() {
        return m13985().iterator();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public Set m13985() {
        return this.f13108.keySet();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public int m13975() {
        return this.f13108.size();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m13961(Number number) {
        if (number == null) {
            throw new JSONException("Null pointer");
        }
        m13963(number);
        String obj = number.toString();
        if (obj.indexOf(46) <= 0 || obj.indexOf(101) >= 0 || obj.indexOf(69) >= 0) {
            return obj;
        }
        while (obj.endsWith("0")) {
            obj = obj.substring(0, obj.length() - 1);
        }
        if (obj.endsWith(".")) {
            return obj.substring(0, obj.length() - 1);
        }
        return obj;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public Object m13970(String str) {
        if (str == null) {
            return null;
        }
        return this.f13108.get(str);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public int m13989(String str, int i) {
        try {
            return m13988(str);
        } catch (Exception e) {
            return i;
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public C0572 m13971(String str) {
        Object r1 = m13970(str);
        if (r1 instanceof C0572) {
            return (C0572) r1;
        }
        return null;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public C0355 m13992(String str) {
        Object r1 = m13970(str);
        if (r1 instanceof C0355) {
            return (C0355) r1;
        }
        return null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public long m13982(String str, long j) {
        try {
            return m13973(str);
        } catch (Exception e) {
            return j;
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public String m13972(String str) {
        return m13976(str, "");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m13976(String str, String str2) {
        Object r1 = m13970(str);
        return f13107.equals(r1) ? str2 : r1.toString();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m13965(Object obj) {
        Method[] methodArr;
        Class<?> cls = obj.getClass();
        if (cls.getClassLoader() != null) {
            methodArr = cls.getMethods();
        } else {
            methodArr = cls.getDeclaredMethods();
        }
        for (int i = 0; i < methodArr.length; i++) {
            try {
                Method method = methodArr[i];
                if (Modifier.isPublic(method.getModifiers())) {
                    String name = method.getName();
                    String str = "";
                    if (name.startsWith("get")) {
                        if ("getClass".equals(name) || "getDeclaringClass".equals(name)) {
                            str = "";
                        } else {
                            str = name.substring(3);
                        }
                    } else if (name.startsWith("is")) {
                        str = name.substring(2);
                    }
                    if (str.length() > 0 && Character.isUpperCase(str.charAt(0)) && method.getParameterTypes().length == 0) {
                        if (str.length() == 1) {
                            str = str.toLowerCase();
                        } else if (!Character.isUpperCase(str.charAt(1))) {
                            str = str.substring(0, 1).toLowerCase() + str.substring(1);
                        }
                        Object invoke = method.invoke(obj, null);
                        if (invoke != null) {
                            this.f13108.put(str, m13966(invoke));
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C0355 m13978(String str, int i) {
        m13986(str, new Integer(i));
        return this;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C0355 m13981(String str, long j) {
        m13986(str, new Long(j));
        return this;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C0355 m13986(String str, Object obj) {
        if (str == null) {
            throw new NullPointerException("Null key.");
        }
        if (obj != null) {
            m13963(obj);
            this.f13108.put(str, obj);
        } else {
            m13987(str);
        }
        return this;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C0355 m13979(String str, Object obj) {
        if (!(str == null || obj == null)) {
            if (m13970(str) != null) {
                throw new JSONException("Duplicate key \"" + str + "\"");
            }
            m13986(str, obj);
        }
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        return "";
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* renamed from: ˋॱ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m13964(java.lang.String r5) {
        /*
            java.io.StringWriter r1 = new java.io.StringWriter
            r1.<init>()
            java.lang.StringBuffer r2 = r1.getBuffer()
            monitor-enter(r2)
            java.io.Writer r0 = m13962(r5, r1)     // Catch:{ IOException -> 0x0014, all -> 0x0019 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0014, all -> 0x0019 }
            monitor-exit(r2)
            return r0
        L_0x0014:
            r3 = move-exception
            java.lang.String r0 = ""
            monitor-exit(r2)
            return r0
        L_0x0019:
            r4 = move-exception
            monitor-exit(r2)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C0355.m13964(java.lang.String):java.lang.String");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Writer m13962(String str, Writer writer) {
        if (str == null || str.length() == 0) {
            writer.write("\"\"");
            return writer;
        }
        char c = 0;
        int length = str.length();
        writer.write(34);
        for (int i = 0; i < length; i++) {
            c = str.charAt(i);
            switch (c) {
                case '\b':
                    writer.write("\\b");
                    break;
                case '\t':
                    writer.write("\\t");
                    break;
                case '\n':
                    writer.write("\\n");
                    break;
                case '\f':
                    writer.write("\\f");
                    break;
                case '\r':
                    writer.write("\\r");
                    break;
                case '\"':
                case '\\':
                    writer.write(92);
                    writer.write(c);
                    break;
                case '/':
                    if (c == '<') {
                        writer.write(92);
                    }
                    writer.write(c);
                    break;
                default:
                    if (c < ' ' || ((c >= 128 && c < 160) || (c >= 8192 && c < 8448))) {
                        writer.write("\\u");
                        String hexString = Integer.toHexString(c);
                        writer.write("0000", 0, 4 - hexString.length());
                        writer.write(hexString);
                        break;
                    } else {
                        writer.write(c);
                        break;
                    }
            }
        }
        writer.write(34);
        return writer;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public Object m13987(String str) {
        return this.f13108.remove(str);
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public static Object m13969(String str) {
        if (str.equals("")) {
            return str;
        }
        if (str.equalsIgnoreCase("true")) {
            return Boolean.TRUE;
        }
        if (str.equalsIgnoreCase("false")) {
            return Boolean.FALSE;
        }
        if (str.equalsIgnoreCase("null")) {
            return f13107;
        }
        char charAt = str.charAt(0);
        if ((charAt >= '0' && charAt <= '9') || charAt == '-') {
            try {
                if (str.indexOf(46) > -1 || str.indexOf(101) > -1 || str.indexOf(69) > -1) {
                    Double valueOf = Double.valueOf(str);
                    if (!valueOf.isInfinite() && !valueOf.isNaN()) {
                        return valueOf;
                    }
                } else {
                    Long l = new Long(str);
                    if (str.equals(l.toString())) {
                        if (l.longValue() == ((long) l.intValue())) {
                            return new Integer(l.intValue());
                        }
                        return l;
                    }
                }
            } catch (Exception e) {
            }
        }
        return str;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m13963(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Double) {
            if (((Double) obj).isInfinite() || ((Double) obj).isNaN()) {
                throw new JSONException("JSON does not allow non-finite numbers.");
            }
        } else if (!(obj instanceof Float)) {
        } else {
            if (((Float) obj).isInfinite() || ((Float) obj).isNaN()) {
                throw new JSONException("JSON does not allow non-finite numbers.");
            }
        }
    }

    public String toString() {
        try {
            return m13990(0);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m13990(int i) {
        String obj;
        StringWriter stringWriter = new StringWriter();
        synchronized (stringWriter.getBuffer()) {
            obj = m13983(stringWriter, i, 0).toString();
        }
        return obj;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static Object m13966(Object obj) {
        if (obj == null) {
            try {
                return f13107;
            } catch (Exception e) {
                return null;
            }
        } else if ((obj instanceof C0355) || (obj instanceof C0572) || f13107.equals(obj) || (obj instanceof AbstractC0625) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof String)) {
            return obj;
        } else {
            if (obj instanceof Collection) {
                return new C0572((Collection) obj);
            }
            if (obj.getClass().isArray()) {
                return new C0572(obj);
            }
            if (obj instanceof Map) {
                return new C0355((Map) obj);
            }
            Package r2 = obj.getClass().getPackage();
            String name = r2 != null ? r2.getName() : "";
            if (name.startsWith("java.") || name.startsWith("javax.") || obj.getClass().getClassLoader() == null) {
                return obj.toString();
            }
            return new C0355(obj);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    static final Writer m13967(Writer writer, Object obj, int i, int i2) {
        if (obj == null || obj.equals(null)) {
            writer.write("null");
        } else if (obj instanceof C0355) {
            ((C0355) obj).m13983(writer, i, i2);
        } else if (obj instanceof C0572) {
            ((C0572) obj).m14666(writer, i, i2);
        } else if (obj instanceof Map) {
            new C0355((Map) obj).m13983(writer, i, i2);
        } else if (obj instanceof Collection) {
            new C0572((Collection) obj).m14666(writer, i, i2);
        } else if (obj.getClass().isArray()) {
            new C0572(obj).m14666(writer, i, i2);
        } else if (obj instanceof Number) {
            writer.write(m13961((Number) obj));
        } else if (obj instanceof Boolean) {
            writer.write(obj.toString());
        } else if (obj instanceof AbstractC0625) {
            try {
                String r2 = ((AbstractC0625) obj).mo6562();
                writer.write(r2 != null ? r2.toString() : m13964(obj.toString()));
            } catch (Exception e) {
                throw new JSONException(e);
            }
        } else {
            m13962(obj.toString(), writer);
        }
        return writer;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    static final void m13968(Writer writer, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            writer.write(32);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public Writer m13983(Writer writer, int i, int i2) {
        boolean z = false;
        try {
            int r2 = m13975();
            Iterator r3 = m13974();
            writer.write(123);
            if (r2 == 1) {
                Object next = r3.next();
                writer.write(m13964(next.toString()));
                writer.write(58);
                if (i > 0) {
                    writer.write(32);
                }
                m13967(writer, this.f13108.get(next), i, i2);
            } else if (r2 != 0) {
                int i3 = i2 + i;
                while (r3.hasNext()) {
                    Object next2 = r3.next();
                    if (z) {
                        writer.write(44);
                    }
                    if (i > 0) {
                        writer.write(10);
                    }
                    m13968(writer, i3);
                    writer.write(m13964(next2.toString()));
                    writer.write(58);
                    if (i > 0) {
                        writer.write(32);
                    }
                    m13967(writer, this.f13108.get(next2), i, i3);
                    z = true;
                }
                if (i > 0) {
                    writer.write(10);
                }
                m13968(writer, i2);
            }
            writer.write(125);
            return writer;
        } catch (IOException e) {
            throw new JSONException(e);
        }
    }
}

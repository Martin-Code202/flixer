package o;

import com.netflix.android.org.json.JSONException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
/* renamed from: o.ױ  reason: contains not printable characters */
public class C0572 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final ArrayList f13836;

    public C0572() {
        this.f13836 = new ArrayList();
    }

    public C0572(C0608 r3) {
        this();
        if (r3.m14737() != '[') {
            throw r3.m14744("A JSONArray text must start with '['");
        } else if (r3.m14737() != ']') {
            r3.m14739();
            while (true) {
                if (r3.m14737() == ',') {
                    r3.m14739();
                    this.f13836.add(C0355.f13107);
                } else {
                    r3.m14739();
                    this.f13836.add(r3.m14736());
                }
                switch (r3.m14737()) {
                    case ',':
                        if (r3.m14737() != ']') {
                            r3.m14739();
                        } else {
                            return;
                        }
                    case ']':
                        return;
                    default:
                        throw r3.m14744("Expected a ',' or ']'");
                }
            }
        }
    }

    public C0572(String str) {
        this(new C0608(str));
    }

    public C0572(Collection collection) {
        this.f13836 = new ArrayList();
        if (collection != null) {
            for (Object obj : collection) {
                this.f13836.add(C0355.m13966(obj));
            }
        }
    }

    public C0572(Object obj) {
        this();
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                m14672(C0355.m13966(Array.get(obj, i)));
            }
            return;
        }
        throw new JSONException("JSONArray initial value should be a string or collection or array.");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public Object m14670(int i) {
        Object r3 = m14668(i);
        if (r3 != null) {
            return r3;
        }
        throw new JSONException("JSONArray[" + i + "] not found.");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C0355 m14667(int i) {
        Object r3 = m14670(i);
        if (r3 instanceof C0355) {
            return (C0355) r3;
        }
        throw new JSONException("JSONArray[" + i + "] is not a JSONObject.");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m14669(int i) {
        Object r3 = m14670(i);
        if (r3 instanceof String) {
            return (String) r3;
        }
        throw new JSONException("JSONArray[" + i + "] not a string.");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public int m14673() {
        return this.f13836.size();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public Object m14668(int i) {
        if (i < 0 || i >= m14673()) {
            return null;
        }
        return this.f13836.get(i);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C0572 m14672(Object obj) {
        this.f13836.add(obj);
        return this;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C0572 m14671(int i, Object obj) {
        C0355.m13963(obj);
        if (i < 0) {
            throw new JSONException("JSONArray[" + i + "] not found.");
        }
        if (i < m14673()) {
            this.f13836.set(i, obj);
        } else {
            while (i != m14673()) {
                m14672(C0355.f13107);
            }
            m14672(obj);
        }
        return this;
    }

    public String toString() {
        try {
            return m14674(0);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m14674(int i) {
        String obj;
        StringWriter stringWriter = new StringWriter();
        synchronized (stringWriter.getBuffer()) {
            obj = m14666(stringWriter, i, 0).toString();
        }
        return obj;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public Writer m14666(Writer writer, int i, int i2) {
        boolean z = false;
        try {
            int r3 = m14673();
            writer.write(91);
            if (r3 == 1) {
                C0355.m13967(writer, this.f13836.get(0), i, i2);
            } else if (r3 != 0) {
                int i3 = i2 + i;
                for (int i4 = 0; i4 < r3; i4++) {
                    if (z) {
                        writer.write(44);
                    }
                    if (i > 0) {
                        writer.write(10);
                    }
                    C0355.m13968(writer, i3);
                    C0355.m13967(writer, this.f13836.get(i4), i, i3);
                    z = true;
                }
                if (i > 0) {
                    writer.write(10);
                }
                C0355.m13968(writer, i2);
            }
            writer.write(93);
            return writer;
        } catch (IOException e) {
            throw new JSONException(e);
        }
    }
}

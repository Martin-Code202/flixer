package o;

import com.netflix.android.org.json.JSONException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
/* renamed from: o.ڍ  reason: contains not printable characters */
public class C0608 {

    /* renamed from: ʼ  reason: contains not printable characters */
    private Reader f13904;

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean f13905;

    /* renamed from: ˊ  reason: contains not printable characters */
    private long f13906;

    /* renamed from: ˋ  reason: contains not printable characters */
    private char f13907;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f13908;

    /* renamed from: ˏ  reason: contains not printable characters */
    private long f13909;

    /* renamed from: ॱ  reason: contains not printable characters */
    private long f13910;

    public C0608(Reader reader) {
        this.f13904 = reader.markSupported() ? reader : new BufferedReader(reader);
        this.f13908 = false;
        this.f13905 = false;
        this.f13907 = 0;
        this.f13906 = 0;
        this.f13910 = 1;
        this.f13909 = 1;
    }

    public C0608(String str) {
        this(new StringReader(str));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m14739() {
        if (this.f13905 || this.f13906 <= 0) {
            throw new JSONException("Stepping back two steps is not supported");
        }
        this.f13906--;
        this.f13910--;
        this.f13905 = true;
        this.f13908 = false;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m14742() {
        return this.f13908 && !this.f13905;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m14740() {
        m14743();
        if (m14742()) {
            return false;
        }
        m14739();
        return true;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public char m14743() {
        int i;
        if (this.f13905) {
            this.f13905 = false;
            i = this.f13907;
        } else {
            try {
                i = this.f13904.read();
                if (i <= 0) {
                    this.f13908 = true;
                    i = 0;
                }
            } catch (IOException e) {
                throw new JSONException(e);
            }
        }
        this.f13906++;
        if (this.f13907 == '\r') {
            this.f13909++;
            this.f13910 = i == 10 ? 0 : 1;
        } else if (i == 10) {
            this.f13909++;
            this.f13910 = 0;
        } else {
            this.f13910++;
        }
        this.f13907 = (char) i;
        return this.f13907;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m14741(int i) {
        if (i == 0) {
            return "";
        }
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = m14743();
            if (m14742()) {
                throw m14744("Substring bounds error");
            }
        }
        return new String(cArr);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public char m14737() {
        char r1;
        do {
            r1 = m14743();
            if (r1 == 0) {
                break;
            }
        } while (r1 <= ' ');
        return r1;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m14738(char c) {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            char r2 = m14743();
            switch (r2) {
                case 0:
                case '\n':
                case '\r':
                    throw m14744("Unterminated string");
                case '\\':
                    char r22 = m14743();
                    switch (r22) {
                        case '\"':
                        case '\'':
                        case '/':
                        case '\\':
                            stringBuffer.append(r22);
                            continue;
                        case 'b':
                            stringBuffer.append('\b');
                            continue;
                        case 'f':
                            stringBuffer.append('\f');
                            continue;
                        case 'n':
                            stringBuffer.append('\n');
                            continue;
                        case 'r':
                            stringBuffer.append('\r');
                            continue;
                        case 't':
                            stringBuffer.append('\t');
                            continue;
                        case 'u':
                            stringBuffer.append((char) Integer.parseInt(m14741(4), 16));
                            continue;
                        default:
                            throw m14744("Illegal escape.");
                    }
                default:
                    if (r2 != c) {
                        stringBuffer.append(r2);
                        break;
                    } else {
                        return stringBuffer.toString();
                    }
            }
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public Object m14736() {
        char r1 = m14737();
        switch (r1) {
            case '\"':
            case '\'':
                return m14738(r1);
            case '[':
                m14739();
                return new C0572(this);
            case '{':
                m14739();
                return new C0355(this);
            default:
                StringBuffer stringBuffer = new StringBuffer();
                while (r1 >= ' ' && ",:]}/\\\"[{;=#".indexOf(r1) < 0) {
                    stringBuffer.append(r1);
                    r1 = m14743();
                }
                m14739();
                String trim = stringBuffer.toString().trim();
                if (!"".equals(trim)) {
                    return C0355.m13969(trim);
                }
                throw m14744("Missing value");
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public JSONException m14744(String str) {
        return new JSONException(str + toString());
    }

    public String toString() {
        return " at " + this.f13906 + " [character " + this.f13910 + " line " + this.f13909 + "]";
    }
}

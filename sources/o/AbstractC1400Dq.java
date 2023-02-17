package o;

import com.netflix.msl.io.MslEncoderException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* renamed from: o.Dq  reason: case insensitive filesystem */
public abstract class AbstractC1400Dq {
    /* renamed from: ˊ */
    public abstract AbstractC1406Dw mo3175(InputStream inputStream, C1407Dx dx);

    /* renamed from: ˋ */
    public abstract C1405Dv mo3176(byte[] bArr);

    /* renamed from: ˎ */
    public abstract C1407Dx mo3177(Set<C1407Dx> set);

    /* renamed from: ॱ */
    public abstract byte[] mo3178(C1405Dv dv, C1407Dx dx);

    /* renamed from: ˊ  reason: contains not printable characters */
    static String m4723(String str) {
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

    /* renamed from: ॱ  reason: contains not printable characters */
    static String m4724(Object obj) {
        if (obj == null || obj.equals(null)) {
            return "null";
        }
        if ((obj instanceof C1405Dv) || (obj instanceof C1401Dr)) {
            return obj.toString();
        }
        if (obj instanceof Map) {
            return new C1405Dv((Map) obj).toString();
        }
        if (obj instanceof Collection) {
            return new C1401Dr((Collection) obj).toString();
        }
        if (obj instanceof Object[]) {
            return new C1401Dr((Object[]) obj).toString();
        }
        if ((obj instanceof Number) || (obj instanceof Boolean)) {
            return obj.toString();
        }
        if (obj instanceof byte[]) {
            return C1418Ei.m4892((byte[]) obj);
        }
        return m4723(obj.toString());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public AbstractC1406Dw m4728(InputStream inputStream) {
        InputStream bufferedInputStream = inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream);
        try {
            bufferedInputStream.mark(1);
            C1407Dx r3 = C1407Dx.m4768((byte) bufferedInputStream.read());
            bufferedInputStream.reset();
            return mo3175(bufferedInputStream, r3);
        } catch (IOException e) {
            throw new MslEncoderException("Failure reading the byte stream identifier.", e);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C1405Dv m4727() {
        return m4725((Map<String, Object>) null);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C1405Dv m4725(Map<String, Object> map) {
        return new C1405Dv(map);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C1407Dx m4729(byte[] bArr) {
        if (bArr.length < 1) {
            throw new MslEncoderException("No encoding identifier found.");
        }
        byte b = bArr[0];
        C1407Dx r4 = C1407Dx.m4768(b);
        if (r4 != null) {
            return r4;
        }
        throw new MslEncoderException("Unidentified encoder format ID: (byte)" + ((int) b) + ".");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1401Dr m4730() {
        return m4726((Collection<?>) null);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C1401Dr m4726(Collection<?> collection) {
        return new C1401Dr(collection);
    }
}

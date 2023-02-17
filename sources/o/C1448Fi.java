package o;

import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
/* renamed from: o.Fi  reason: case insensitive filesystem */
public final class C1448Fi {
    /* renamed from: ॱ  reason: contains not printable characters */
    public static final String m5009(Reader reader) {
        C1457Fr.m5025(reader, "$receiver");
        StringWriter stringWriter = new StringWriter();
        m5008(reader, stringWriter, 0, 2, null);
        String stringWriter2 = stringWriter.toString();
        C1457Fr.m5016((Object) stringWriter2, "buffer.toString()");
        return stringWriter2;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static /* synthetic */ long m5008(Reader reader, Writer writer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return m5007(reader, writer, i);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final long m5007(Reader reader, Writer writer, int i) {
        C1457Fr.m5025(reader, "$receiver");
        C1457Fr.m5025(writer, "out");
        long j = 0;
        char[] cArr = new char[i];
        int read = reader.read(cArr);
        while (read >= 0) {
            writer.write(cArr, 0, read);
            j += (long) read;
            read = reader.read(cArr);
        }
        return j;
    }
}

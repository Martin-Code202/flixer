package o;

import com.google.android.exoplayer2.util.Util;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
public class hV {

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final int f7181 = Util.getIntegerCodeForString("sidx");

    public static class iF {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final long f7182;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final long f7183;

        iF(long j, long j2) {
            this.f7183 = j;
            this.f7182 = j2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˏ  reason: contains not printable characters */
        public long m6986() {
            return this.f7182;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˎ  reason: contains not printable characters */
        public long m6985() {
            return this.f7183;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    static iF m6984(String str) {
        RandomAccessFile randomAccessFile = null;
        long j = 0;
        try {
            boolean z = new File(str).exists();
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "r");
            randomAccessFile2.length();
            while (true) {
                int readInt = randomAccessFile2.readInt();
                if (randomAccessFile2.readInt() == f7181) {
                    randomAccessFile2.close();
                    C1283.m16851("NetflixFMP4Parser", "sidx offset=%d size=%d", Long.valueOf(j), Integer.valueOf(readInt));
                    return new iF((long) readInt, j);
                }
                randomAccessFile2.skipBytes(readInt - 8);
                j = ((long) readInt) + j;
            }
        } catch (IOException e) {
            if (0 != 0) {
                try {
                    C1283.m16854("NetflixFMP4Parser", "closing RandomAccessFile");
                    randomAccessFile.close();
                } catch (Exception e2) {
                    C1283.m16847("NetflixFMP4Parser", "exception while closing RandomAccessFile:", e2);
                }
            }
            C1283.m16855("NetflixFMP4Parser", "ParseSidxInfo fileName=%s fileSize=%d offsetInFile=%d fileExists=%d exception=%s", str, -1L, 0L, -1, e);
            throw new Exception("filename=" + str + " fileSize=-1 offsetInFile=0 fileExists=-1  exception=" + e);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m6983(String str) {
        iF iFVar = null;
        try {
            iFVar = m6984(str);
        } catch (Exception e) {
        }
        return iFVar == null;
    }
}

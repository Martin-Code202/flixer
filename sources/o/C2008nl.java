package o;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* renamed from: o.nl  reason: case insensitive filesystem */
public class C2008nl {

    /* renamed from: ॱ  reason: contains not printable characters */
    final C0763 f9161;

    /* renamed from: o.nl$if  reason: invalid class name */
    public class Cif {

        /* renamed from: ˋ  reason: contains not printable characters */
        final long f9163;

        /* renamed from: ˎ  reason: contains not printable characters */
        final String f9164;

        /* renamed from: ॱ  reason: contains not printable characters */
        final long f9165;

        public Cif(String str, long j, long j2) {
            this.f9165 = j2;
            this.f9164 = str;
            this.f9163 = j;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public long m9317() {
            return this.f9165;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public String m9315() {
            return this.f9164;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public long m9316() {
            return this.f9163;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m9314() {
        if (this.f9161 != null) {
            this.f9161.m15204();
        }
    }

    public C2008nl(C0763 r1) {
        this.f9161 = r1;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public Cif m9313(String str) {
        File r9 = this.f9161.m15199(str);
        if (!r9.exists()) {
            return null;
        }
        C0155 r10 = null;
        try {
            r10 = new C0155(new FileInputStream(r9));
            m9312(r10);
            Cif ifVar = new Cif(r9.getAbsolutePath(), (long) r10.f9166, r9.length() - ((long) r10.f9166));
            if (r10 != null) {
                try {
                    r10.close();
                } catch (IOException e) {
                    C1283.m16854("VolleyCacheWrapper", String.format("%s: %s", r9.getAbsolutePath(), e.toString()));
                }
            }
            return ifVar;
        } catch (IOException e2) {
            C1283.m16854("VolleyCacheWrapper", String.format("%s: %s", r9.getAbsolutePath(), e2.toString()));
            if (r10 == null) {
                return null;
            }
            try {
                r10.close();
                return null;
            } catch (IOException e3) {
                C1283.m16854("VolleyCacheWrapper", String.format("%s: %s", r9.getAbsolutePath(), e3.toString()));
                return null;
            }
        } catch (Throwable th) {
            if (r10 != null) {
                try {
                    r10.close();
                } catch (IOException e4) {
                    C1283.m16854("VolleyCacheWrapper", String.format("%s: %s", r9.getAbsolutePath(), e4.toString()));
                }
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.nl$ˋ  reason: contains not printable characters */
    public static class C0155 extends FilterInputStream {

        /* renamed from: ॱ  reason: contains not printable characters */
        private int f9166;

        private C0155(InputStream inputStream) {
            super(inputStream);
            this.f9166 = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() {
            int read = super.read();
            if (read != -1) {
                this.f9166++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f9166 += read;
            }
            return read;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m9312(InputStream inputStream) {
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        objectInputStream.readByte();
        objectInputStream.readUTF();
        objectInputStream.readUTF();
        objectInputStream.readLong();
        objectInputStream.readLong();
        objectInputStream.readLong();
        int readInt = objectInputStream.readInt();
        Map emptyMap = readInt == 0 ? Collections.emptyMap() : new HashMap(readInt);
        for (int i = 0; i < readInt; i++) {
            emptyMap.put(objectInputStream.readUTF().intern(), objectInputStream.readUTF().intern());
        }
    }
}

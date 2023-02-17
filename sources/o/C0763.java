package o;

import android.os.SystemClock;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import o.AbstractC1001;
/* renamed from: o.ᑋ  reason: contains not printable characters */
public class C0763 implements AbstractC1001 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private long f14382;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Map<String, C0764> f14383;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final int f14384;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final File f14385;

    public C0763(File file, int i) {
        this.f14383 = new LinkedHashMap(16, 0.75f, true);
        this.f14382 = 0;
        this.f14385 = file;
        this.f14384 = i;
    }

    public C0763(File file) {
        this(file, 5242880);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized void m15204() {
        File[] listFiles = this.f14385.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                file.delete();
            }
        }
        this.f14383.clear();
        this.f14382 = 0;
        C0509.m14520("Cache cleared.", new Object[0]);
    }

    @Override // o.AbstractC1001
    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized AbstractC1001.Cif mo15202(String str) {
        C0764 r4 = this.f14383.get(str);
        if (r4 == null) {
            return null;
        }
        File r5 = m15199(str);
        iF iFVar = null;
        try {
            iFVar = new iF(new FileInputStream(r5));
            C0764.m15208(iFVar);
            AbstractC1001.Cif r8 = r4.m15209(m15194(iFVar, (int) (r5.length() - ((long) iFVar.f14386))));
            if (iFVar != null) {
                try {
                    iFVar.close();
                } catch (IOException e) {
                    return null;
                }
            }
            return r8;
        } catch (IOException e2) {
            C0509.m14520("%s: %s", r5.getAbsolutePath(), e2.toString());
            m15200(str);
            if (iFVar != null) {
                try {
                    iFVar.close();
                } catch (IOException e3) {
                    return null;
                }
            }
            return null;
        } catch (Throwable th) {
            if (iFVar != null) {
                try {
                    iFVar.close();
                } catch (IOException e4) {
                    return null;
                }
            }
            throw th;
        }
    }

    @Override // o.AbstractC1001
    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized void mo15203() {
        if (!this.f14385.exists()) {
            if (!this.f14385.mkdirs()) {
                C0509.m14519("Unable to create cache dir %s", this.f14385.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = this.f14385.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                FileInputStream fileInputStream = null;
                try {
                    fileInputStream = new FileInputStream(file);
                    C0764 r10 = C0764.m15208(fileInputStream);
                    r10.f14389 = file.length();
                    m15197(r10.f14392, r10);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (IOException e2) {
                    if (file != null) {
                        file.delete();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (Throwable th) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            }
        }
    }

    @Override // o.AbstractC1001
    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized void mo15201(String str, AbstractC1001.Cif ifVar) {
        m15195(ifVar.f15077.length);
        File r4 = m15199(str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(r4);
            C0764 r6 = new C0764(str, ifVar);
            r6.m15210(fileOutputStream);
            fileOutputStream.write(ifVar.f15077);
            fileOutputStream.close();
            m15197(str, r6);
        } catch (IOException e) {
            if (!r4.delete()) {
                C0509.m14520("Could not clean up file %s", r4.getAbsolutePath());
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized void m15200(String str) {
        boolean delete = m15199(str).delete();
        m15198(str);
        if (!delete) {
            C0509.m14520("Could not delete cache entry for key=%s, filename=%s", str, m15196(str));
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private String m15196(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public File m15199(String str) {
        return new File(this.f14385, m15196(str));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m15195(int i) {
        if (this.f14382 + ((long) i) >= ((long) this.f14384)) {
            long j = this.f14382;
            int i2 = 0;
            SystemClock.elapsedRealtime();
            Iterator<Map.Entry<String, C0764>> it = this.f14383.entrySet().iterator();
            while (it.hasNext()) {
                C0764 value = it.next().getValue();
                if (m15199(value.f14392).delete()) {
                    this.f14382 -= value.f14389;
                } else {
                    C0509.m14520("Could not delete cache entry for key=%s, filename=%s", value.f14392, m15196(value.f14392));
                }
                it.remove();
                i2++;
                if (((float) (this.f14382 + ((long) i))) < ((float) this.f14384) * 0.9f) {
                    return;
                }
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m15197(String str, C0764 r9) {
        if (!this.f14383.containsKey(str)) {
            this.f14382 += r9.f14389;
        } else {
            this.f14382 += r9.f14389 - this.f14383.get(str).f14389;
        }
        this.f14383.put(str, r9);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m15198(String str) {
        C0764 r4 = this.f14383.get(str);
        if (r4 != null) {
            this.f14382 -= r4.f14389;
            this.f14383.remove(str);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static byte[] m15194(InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ᑋ$ˊ  reason: contains not printable characters */
    public static class C0764 {

        /* renamed from: ʼ  reason: contains not printable characters */
        public Map<String, String> f14387;

        /* renamed from: ˊ  reason: contains not printable characters */
        public String f14388;

        /* renamed from: ˋ  reason: contains not printable characters */
        public long f14389;

        /* renamed from: ˎ  reason: contains not printable characters */
        public long f14390;

        /* renamed from: ˏ  reason: contains not printable characters */
        public long f14391;

        /* renamed from: ॱ  reason: contains not printable characters */
        public String f14392;

        /* renamed from: ᐝ  reason: contains not printable characters */
        public long f14393;

        private C0764() {
        }

        public C0764(String str, AbstractC1001.Cif ifVar) {
            this.f14392 = str;
            this.f14389 = (long) ifVar.f15077.length;
            this.f14388 = ifVar.f15078;
            this.f14391 = ifVar.f15079;
            this.f14390 = ifVar.f15076;
            this.f14393 = ifVar.f15080;
            this.f14387 = ifVar.f15075;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public static C0764 m15208(InputStream inputStream) {
            C0764 r2 = new C0764();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            if (objectInputStream.readByte() != 2) {
                throw new IOException();
            }
            r2.f14392 = objectInputStream.readUTF();
            r2.f14388 = objectInputStream.readUTF();
            if (r2.f14388.equals("")) {
                r2.f14388 = null;
            }
            r2.f14391 = objectInputStream.readLong();
            r2.f14390 = objectInputStream.readLong();
            r2.f14393 = objectInputStream.readLong();
            r2.f14387 = m15206(objectInputStream);
            return r2;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public AbstractC1001.Cif m15209(byte[] bArr) {
            AbstractC1001.Cif ifVar = new AbstractC1001.Cif();
            ifVar.f15077 = bArr;
            ifVar.f15078 = this.f14388;
            ifVar.f15079 = this.f14391;
            ifVar.f15076 = this.f14390;
            ifVar.f15080 = this.f14393;
            ifVar.f15075 = this.f14387;
            return ifVar;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public boolean m15210(OutputStream outputStream) {
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeByte(2);
                objectOutputStream.writeUTF(this.f14392);
                objectOutputStream.writeUTF(this.f14388 == null ? "" : this.f14388);
                objectOutputStream.writeLong(this.f14391);
                objectOutputStream.writeLong(this.f14390);
                objectOutputStream.writeLong(this.f14393);
                m15207(this.f14387, objectOutputStream);
                objectOutputStream.flush();
                return true;
            } catch (IOException e) {
                C0509.m14520("%s", e.toString());
                return false;
            }
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        private static void m15207(Map<String, String> map, ObjectOutputStream objectOutputStream) {
            if (map != null) {
                objectOutputStream.writeInt(map.size());
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    objectOutputStream.writeUTF(entry.getKey());
                    objectOutputStream.writeUTF(entry.getValue());
                }
                return;
            }
            objectOutputStream.writeInt(0);
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        private static Map<String, String> m15206(ObjectInputStream objectInputStream) {
            int readInt = objectInputStream.readInt();
            Map<String, String> emptyMap = readInt == 0 ? Collections.emptyMap() : new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
            for (int i = 0; i < readInt; i++) {
                emptyMap.put(objectInputStream.readUTF().intern(), objectInputStream.readUTF().intern());
            }
            return emptyMap;
        }
    }

    /* renamed from: o.ᑋ$iF */
    static class iF extends FilterInputStream {

        /* renamed from: ˋ  reason: contains not printable characters */
        private int f14386;

        private iF(InputStream inputStream) {
            super(inputStream);
            this.f14386 = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() {
            int read = super.read();
            if (read != -1) {
                this.f14386++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f14386 += read;
            }
            return read;
        }
    }
}

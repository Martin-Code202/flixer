package o;

import android.os.SystemClock;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import o.BP;
public class BO implements BP {

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean f4597;

    /* renamed from: ˊ  reason: contains not printable characters */
    private long f4598;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final File f4599;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Map<String, BP.If> f4600;

    /* renamed from: ˏ  reason: contains not printable characters */
    private int f4601;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final int f4602;

    private BO(File file, int i, int i2, boolean z) {
        this.f4600 = new HashMap();
        this.f4598 = 0;
        this.f4599 = file;
        this.f4602 = i;
        this.f4597 = z;
    }

    public BO(File file) {
        this(file, 5242880, 1024, false);
    }

    public BO(File file, boolean z) {
        this(file, 5242880, 1024, z);
    }

    @Override // o.BP
    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized void mo3900(BP.AbstractC1327iF iFVar) {
        if (!this.f4599.exists()) {
            if (!this.f4599.mkdirs()) {
                C1283.m16850("nf_log_fs", "Unable to create cache dir " + this.f4599.getAbsolutePath());
            }
            if (iFVar != null) {
                iFVar.mo3905(null);
            }
            return;
        }
        this.f4598 = 0;
        m3885(this.f4599);
        if (iFVar != null) {
            Collection<BP.If> values = this.f4600.values();
            iFVar.mo3905((BP.If[]) values.toArray(new BP.If[values.size()]));
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private int m3885(File file) {
        int i = 0;
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0;
        }
        for (File file2 : listFiles) {
            if (file2 != null && file2.exists()) {
                if (file2.isDirectory()) {
                    i += m3885(file2);
                } else {
                    m3894(file2);
                    i++;
                }
            }
        }
        return i;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m3894(File file) {
        BN bn = new BN(BN.m3880(this.f4599, file), file);
        this.f4600.put(file.getName(), bn);
        this.f4598 += bn.mo3884();
    }

    @Override // o.BP
    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized String mo3895(String str, byte[] bArr, String str2) {
        return mo3902(str, bArr, str2, null);
    }

    @Override // o.BP
    /* renamed from: ˋ  reason: contains not printable characters */
    public String mo3897(String str, byte[] bArr, String str2, boolean z) {
        return m3888(str, bArr, str2, null, z);
    }

    @Override // o.BP
    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized String mo3902(String str, byte[] bArr, String str2, BP.Cif ifVar) {
        return m3888(str, bArr, str2, ifVar, false);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private synchronized String m3888(String str, byte[] bArr, String str2, BP.Cif ifVar, boolean z) {
        BN bn;
        m3893(bArr.length);
        long r5 = AH.m3342(this.f4599);
        if (r5 < ((long) bArr.length)) {
            C1283.m16855("nf_log_fs", "Even after pruning, we may NOT have enough space available. Free space: %d vs entry space %d", Long.valueOf(r5), Integer.valueOf(bArr.length));
        }
        File r9 = m3890(str2, BN.m3879(str, z ? "_trailers" : null));
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(r9));
            bufferedOutputStream.write(bArr);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            bn = new BN(str2, r9);
            this.f4600.put(r9.getName(), bn);
            this.f4598 += bn.mo3884();
            if (ifVar != null) {
                ifVar.mo3906(bn.mo3882());
            }
        } catch (IOException e) {
            C1283.m16847("nf_log_fs", "Failed to save data to file system!", e);
            if (!r9.delete()) {
                C1283.m16850("nf_log_fs", "Failed to save data. Could not clean up file " + r9.getAbsolutePath());
            }
            if (ifVar != null) {
                ifVar.mo3906(null);
            }
            return null;
        }
        return bn.mo3882();
    }

    @Override // o.BP
    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized void mo3899(String str, BP.AbstractC0068 r15) {
        BP.If r6 = this.f4600.get(str);
        if (r6 == null) {
            C1283.m16854("nf_log_fs", "Entry not found!");
            if (r15 != null) {
                r15.mo3907(str, null, null, 0);
            }
            return;
        }
        C1283.m16854("nf_log_fs", "Entry found!");
        File r7 = m3890(r6.mo3881(), str);
        Cif ifVar = null;
        try {
            Cif ifVar2 = new Cif(new FileInputStream(r7));
            byte[] r9 = m3892(ifVar2, (int) (r7.length() - ((long) ifVar2.f4604)));
            if (r15 != null) {
                r15.mo3907(str, r6.mo3881(), r9, r7.lastModified());
            }
            if (ifVar2 != null) {
                try {
                    ifVar2.close();
                } catch (IOException e) {
                }
            }
        } catch (IOException e2) {
            C1283.m16847("nf_log_fs", " Failed to load file " + r7.getAbsolutePath(), e2);
            mo3898(str);
            if (0 != 0) {
                try {
                    ifVar.close();
                } catch (IOException e3) {
                }
            }
            if (r15 != null) {
                r15.mo3907(str, null, null, 0);
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    ifVar.close();
                } catch (IOException e4) {
                }
            }
            throw th;
        }
    }

    @Override // o.BP
    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized void mo3898(String str) {
        BP.If remove = this.f4600.remove(str);
        if (remove != null && m3890(remove.mo3881(), str).delete() && this.f4598 >= remove.mo3884()) {
            this.f4598 -= remove.mo3884();
        }
    }

    @Override // o.BP
    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized void mo3896() {
        m3889(this.f4599, false);
        this.f4600.clear();
        this.f4598 = 0;
        C1283.m16854("nf_log_fs", "Cache cleared.");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m3889(File file, boolean z) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    m3889(file2, true);
                } else {
                    file2.delete();
                }
            }
        }
        if (z) {
            file.delete();
        }
    }

    @Override // o.BP
    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized BP.If[] mo3901() {
        return (BP.If[]) this.f4600.values().toArray(new BP.If[this.f4600.size()]);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private File m3890(String str, String str2) {
        String r4 = m3886(str);
        if (r4 == null) {
            return new File(this.f4599, str2);
        }
        File file = new File(this.f4599, r4);
        if (!file.exists()) {
            try {
                file.mkdir();
                return new File(file, str2);
            } catch (Throwable th) {
                C1283.m16856("nf_log_fs", th, "Unable to create profile log directory!", new Object[0]);
                return new File(this.f4599, str2);
            }
        } else if (file.isDirectory()) {
            return new File(file, str2);
        } else {
            C1283.m16844("nf_log_fs", "File %s exists and it is not directory!", file);
            return new File(this.f4599, str2);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private String m3886(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        return C1324Ax.m3812(str);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static byte[] m3892(InputStream inputStream, int i) {
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

    /* renamed from: o.BO$if  reason: invalid class name */
    static class Cif extends FilterInputStream {

        /* renamed from: ˊ  reason: contains not printable characters */
        private int f4604;

        private Cif(InputStream inputStream) {
            super(inputStream);
            this.f4604 = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() {
            int read = super.read();
            if (read != -1) {
                this.f4604++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f4604 += read;
            }
            return read;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m3893(int i) {
        if (i > this.f4601) {
            this.f4601 = i;
        }
        if (m3887(i) || m3891(i)) {
            C1283.m16854("nf_log_fs", "Pruning oldest entries.");
            long j = this.f4598;
            int i2 = 0;
            SystemClock.elapsedRealtime();
            ArrayList<BP.If> arrayList = new ArrayList(this.f4600.values());
            Collections.sort(arrayList, new Comparator<BP.If>() { // from class: o.BO.4
                /* renamed from: ˋ  reason: contains not printable characters */
                public int compare(BP.If r5, BP.If r6) {
                    if (r5.mo3883() == r6.mo3883()) {
                        return 0;
                    }
                    if (r5.mo3883() < r6.mo3883()) {
                        return -1;
                    }
                    return 1;
                }
            });
            for (BP.If r11 : arrayList) {
                File r12 = m3890(r11.mo3881(), r11.mo3882());
                long length = r12.length();
                if (!r12.delete()) {
                    C1283.m16850("nf_log_fs", "Could not delete entry " + r12.getName());
                } else if (this.f4598 >= length) {
                    this.f4598 -= length;
                }
                this.f4600.remove(r11.mo3882());
                i2++;
                if (this.f4598 + ((long) i) < ((long) this.f4602)) {
                    return;
                }
            }
            return;
        }
        C1283.m16854("nf_log_fs", "No need to prune oldest entries.");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean m3887(int i) {
        boolean z = this.f4598 + ((long) i) > ((long) this.f4602);
        C1283.m16851("nf_log_fs", "Need to prune based on using too much space: %b", Boolean.valueOf(z));
        return z;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean m3891(int i) {
        long r5 = AH.m3342(this.f4599);
        boolean z = ((long) i) > r5;
        C1283.m16851("nf_log_fs", "Used space %d in bytes. Need to prune based on not having enough space (%d in bytes) on device: %b", Long.valueOf(this.f4598), Long.valueOf(r5), Boolean.valueOf(z));
        return z;
    }
}

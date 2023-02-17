package o;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* renamed from: o.ŧ  reason: contains not printable characters */
public final class C0348 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private long f13065 = 0;

    /* renamed from: ʼ  reason: contains not printable characters */
    private Writer f13066;

    /* renamed from: ʽ  reason: contains not printable characters */
    private long f13067;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f13068;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final File f13069;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private long f13070 = 0;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final File f13071;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final File f13072;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final ThreadPoolExecutor f13073 = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: ͺ  reason: contains not printable characters */
    private final Callable<Void> f13074 = new Callable<Void>() { // from class: o.ŧ.5
        /* renamed from: ˋ  reason: contains not printable characters */
        public Void call() {
            m13930();
            return null;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private void m13930() {
            synchronized (C0348.this) {
                if (C0348.this.f13066 != null) {
                    C0348.this.m13918();
                    if (C0348.this.m13903()) {
                        C0348.this.m13902();
                        C0348.this.f13078 = 0;
                    }
                }
            }
        }
    };

    /* renamed from: ॱ  reason: contains not printable characters */
    private final File f13075;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final Cif f13076;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final LinkedHashMap<String, C0349> f13077 = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f13078;

    /* renamed from: o.ŧ$if  reason: invalid class name */
    public interface Cif {
        /* renamed from: ˊ */
        void mo180(String str, If v);
    }

    private C0348(File file, int i, long j, Cif ifVar) {
        this.f13072 = file;
        this.f13068 = i;
        this.f13075 = new File(file, "journal");
        this.f13069 = new File(file, "journal.tmp");
        this.f13071 = new File(file, "journal.bkp");
        this.f13067 = j;
        this.f13076 = ifVar;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static C0348 m13914(File file, int i, long j, Cif ifVar) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                m13911(file2, file3, false);
            }
        }
        C0348 r0 = new C0348(file, i, j, ifVar);
        if (r0.f13075.exists()) {
            try {
                r0.m13920();
                r0.m13904();
                return r0;
            } catch (IOException e) {
                C1283.m16850("DiskLruJournal", "DiskLruJournal " + file + " is corrupt: " + e.getMessage() + ", removing");
                r0.m13925();
            }
        }
        file.mkdirs();
        C0348 r02 = new C0348(file, i, j, ifVar);
        r02.m13902();
        return r02;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c5, code lost:
        r15 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c6, code lost:
        if (r7 != null) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c8, code lost:
        if (r9 != null) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ce, code lost:
        r16 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00cf, code lost:
        r9.addSuppressed(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d5, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d8, code lost:
        throw r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00e3, code lost:
        r17 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e4, code lost:
        if (r5 != null) goto L_0x00e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e6, code lost:
        if (r7 != null) goto L_0x00e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ec, code lost:
        r18 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ed, code lost:
        r7.addSuppressed(r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f3, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f6, code lost:
        throw r17;
     */
    /* renamed from: ᐝ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m13920() {
        /*
        // Method dump skipped, instructions count: 248
        */
        throw new UnsupportedOperationException("Method not decompiled: o.C0348.m13920():void");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m13912(String str) {
        if (str.indexOf(32) == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        String substring = str.substring(str.indexOf(" ") + 1);
        C0349 r5 = this.f13077.get(substring);
        if (r5 == null) {
            r5 = new C0349(substring);
            this.f13077.put(substring, r5);
        }
        if (str.startsWith("CLEAN")) {
            r5.f13087 = true;
            r5.f13088 = null;
        } else if (str.startsWith("DIRTY")) {
            r5.f13088 = new C2395iF(r5);
        } else if (!str.startsWith("READ")) {
            if (str.startsWith("REMOVE")) {
                this.f13077.remove(substring);
                return;
            }
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m13904() {
        m13907(this.f13069);
        Iterator<C0349> it = this.f13077.values().iterator();
        while (it.hasNext()) {
            C0349 next = it.next();
            if (next.f13088 != null) {
                next.f13088 = null;
                it.remove();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʻ  reason: contains not printable characters */
    private synchronized void m13902() {
        if (this.f13066 != null) {
            this.f13066.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f13069), C1280.f15990));
        try {
            bufferedWriter.write("com.netflix.falkor.cache.lru.DiskLruJournal");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f13068));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (C0349 r7 : this.f13077.values()) {
                if (r7.f13088 != null) {
                    bufferedWriter.write("DIRTY " + r7.f13089 + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + r7.f13089 + '\n');
                }
            }
            if (this.f13075.exists()) {
                m13911(this.f13075, this.f13071, true);
            }
            m13911(this.f13069, this.f13075, false);
            this.f13071.delete();
            this.f13066 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f13075, true), C1280.f15990));
        } finally {
            bufferedWriter.close();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m13907(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static void m13911(File file, File file2, boolean z) {
        if (z) {
            m13907(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized If m13922(String str) {
        m13919();
        C0349 r6 = this.f13077.get(str);
        if (r6 == null) {
            return null;
        }
        if (!r6.f13087) {
            return null;
        }
        this.f13078++;
        this.f13066.append((CharSequence) "READ").append((CharSequence) " ").append((CharSequence) str).append('\n');
        if (m13903()) {
            this.f13073.submit(this.f13074);
        }
        return new If(str, r6.f13091);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C2395iF m13928(String str) {
        return m13910(str, -1);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private synchronized C2395iF m13910(String str, long j) {
        m13919();
        C0349 r3 = this.f13077.get(str);
        if (j != -1 && (r3 == null || r3.f13091 != j)) {
            return null;
        }
        if (r3 == null) {
            r3 = new C0349(str);
            this.f13077.put(str, r3);
        } else if (r3.f13088 != null) {
            return null;
        }
        C2395iF iFVar = new C2395iF(r3);
        r3.f13088 = iFVar;
        this.f13066.write("DIRTY " + str + '\n');
        this.f13066.flush();
        return iFVar;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public File m13921() {
        return this.f13072;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public int m13926() {
        return this.f13077.size();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized void m13927(String str) {
        If r3 = m13922(str);
        C2395iF r4 = r3 != null ? r3.m13932() : m13928(str);
        if (r4 != null) {
            r4.m13935();
        } else {
            throw new IllegalStateException("DiskLruJournal.markEdit(" + str + ") -> cannot get an editor");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private synchronized void m13915(C2395iF iFVar, boolean z) {
        m13919();
        C0349 r4 = iFVar.f13083;
        if (r4.f13088 != iFVar) {
            throw new IllegalStateException("Editor is not current");
        }
        this.f13078++;
        r4.f13088 = null;
        if (r4.f13087 || z) {
            r4.f13087 = true;
            this.f13066.write("CLEAN " + r4.f13089 + '\n');
            if (z) {
                long j = this.f13070;
                this.f13070 = 1 + j;
                r4.f13091 = j;
            }
        } else {
            this.f13077.remove(r4.f13089);
            this.f13066.write("REMOVE " + r4.f13089 + '\n');
        }
        this.f13066.flush();
        if (((long) this.f13077.size()) > this.f13067 || m13903()) {
            this.f13073.submit(this.f13074);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean m13903() {
        return this.f13078 >= 2000 && this.f13078 >= this.f13077.size();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized boolean m13924(String str) {
        m13919();
        C0349 r2 = this.f13077.get(str);
        if (r2 == null || r2.f13088 != null) {
            return false;
        }
        this.f13078++;
        this.f13066.append((CharSequence) "REMOVE").append((CharSequence) " ").append((CharSequence) str).append((CharSequence) "\n");
        If r3 = m13922(str);
        this.f13077.remove(str);
        if (this.f13076 != null) {
            this.f13076.mo180(str, r3);
        }
        if (m13903()) {
            this.f13073.submit(this.f13074);
        }
        return true;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m13919() {
        if (this.f13066 == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized void m13923() {
        if (this.f13066 != null) {
            Iterator it = new ArrayList(this.f13077.values()).iterator();
            while (it.hasNext()) {
                C0349 r3 = (C0349) it.next();
                if (r3.f13088 != null) {
                    r3.f13088.m13934();
                }
            }
            m13918();
            this.f13066.close();
            this.f13066 = null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱˊ  reason: contains not printable characters */
    private void m13918() {
        while (((long) this.f13077.size()) > this.f13067) {
            m13924(this.f13077.entrySet().iterator().next().getKey());
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized void m13925() {
        m13923();
        C1280.m16831(this.f13072);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public synchronized void m13929() {
        this.f13077.clear();
        if (this.f13066 != null) {
            this.f13066.close();
            this.f13066 = null;
        }
        C1280.m16831(this.f13072);
    }

    /* renamed from: o.ŧ$If */
    public final class If {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final long f13080;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final String f13081;

        private If(String str, long j) {
            this.f13081 = str;
            this.f13080 = j;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public C2395iF m13932() {
            return C0348.this.m13910(this.f13081, this.f13080);
        }
    }

    /* renamed from: o.ŧ$iF  reason: case insensitive filesystem */
    public final class C2395iF {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final C0349 f13083;

        /* renamed from: ˎ  reason: contains not printable characters */
        private boolean f13085;

        /* renamed from: ˏ  reason: contains not printable characters */
        private boolean f13086;

        private C2395iF(C0349 r2) {
            this.f13083 = r2;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public void m13935() {
            if (this.f13085) {
                C0348.this.m13915(this, false);
                C0348.this.m13924(this.f13083.f13089);
            } else {
                C0348.this.m13915(this, true);
            }
            this.f13086 = true;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public void m13934() {
            C0348.this.m13915(this, false);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ŧ$ˊ  reason: contains not printable characters */
    public final class C0349 {

        /* renamed from: ˊ  reason: contains not printable characters */
        private boolean f13087;

        /* renamed from: ˋ  reason: contains not printable characters */
        private C2395iF f13088;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final String f13089;

        /* renamed from: ॱ  reason: contains not printable characters */
        private long f13091;

        private C0349(String str) {
            this.f13089 = str;
        }
    }
}

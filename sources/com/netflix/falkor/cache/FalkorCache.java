package com.netflix.falkor.cache;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import com.netflix.mediaclient.service.logging.client.model.FalkorPathResult;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmModel;
import io.realm.RealmResults;
import io.realm.exceptions.RealmFileException;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import o.AbstractC0457;
import o.AbstractC1326Az;
import o.C0348;
import o.C1147;
import o.C1276;
import o.C1283;
import o.C1341Bn;
public final class FalkorCache {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static FalkorCacheMonitor f534 = new FalkorCacheMonitor();

    /* renamed from: ˋ  reason: contains not printable characters */
    private static AbstractC0005 f535;

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean f536 = true;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static RealmConfiguration f537;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static boolean f538 = false;

    public interface If extends RealmModel {
        long getLastModifiedTime();

        String getPayload();

        boolean getSentinel();

        void setExpiry(Date date);

        void setLastModifiedTime(long j);

        void setPath(String str);

        void setPayload(String str);

        void setSentinel(boolean z);
    }

    /* renamed from: com.netflix.falkor.cache.FalkorCache$if  reason: invalid class name */
    public interface Cif extends RealmModel {
        String getPath();
    }

    /* renamed from: com.netflix.falkor.cache.FalkorCache$ˋ  reason: contains not printable characters */
    public interface AbstractC0005 {
        /* renamed from: ˊ  reason: contains not printable characters */
        long mo192();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m163(Context context, AbstractC0457 r8, AbstractC1326Az az, AbstractC0005 r10) {
        if (!f538) {
            f537 = new RealmConfiguration.Builder().name("falkor.realm").modules(new FalkorRealmModule(), new Object[0]).schemaVersion(601).deleteRealmIfMigrationNeeded().build();
            f535 = r10;
            long freeSpace = context.getFilesDir().getFreeSpace();
            if (freeSpace < 104857600) {
                C1276.m16820().mo5728("FalkorCache.init skipped free space = " + freeSpace);
                return;
            }
            try {
                LruBackup.m175(context, 601);
                f534.m205(context, r8, az);
                f538 = true;
            } catch (IOException e) {
                C1276.m16820().mo5729("FalkorCache.init", e);
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m164() {
        return f538;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static long m166() {
        AbstractC0005 r2 = f535;
        if (r2 != null) {
            return r2.mo192();
        }
        return 0;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m167() {
        return m166() > 0;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static FalkorCacheMonitor m165() {
        return f534;
    }

    /* renamed from: com.netflix.falkor.cache.FalkorCache$ˊ  reason: contains not printable characters */
    public static class C0004 {

        /* renamed from: ˊ  reason: contains not printable characters */
        private static final AtomicInteger f546 = new AtomicInteger(0);

        /* renamed from: ॱ  reason: contains not printable characters */
        private static final ThreadLocal<Boolean> f547 = new ThreadLocal<>();

        /* renamed from: ˏ  reason: contains not printable characters */
        public static Realm m186() {
            try {
                return C1341Bn.m4056(FalkorCache.f537);
            } catch (RealmFileException | IllegalArgumentException e) {
                C1276.m16820().mo5729("FalkorCache instance ", e);
                Realm.deleteRealm(FalkorCache.f537);
                return C1341Bn.m4056(FalkorCache.f537);
            }
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public static void m184(Realm realm) {
            realm.close();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0074, code lost:
            if (r5 != null) goto L_0x0076;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0076, code lost:
            if (r7 != null) goto L_0x0078;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            r5.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x007c, code lost:
            r9 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x007d, code lost:
            r7.addSuppressed(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0081, code lost:
            r5.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0084, code lost:
            throw r8;
         */
        /* renamed from: ॱ  reason: contains not printable characters */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void m188() {
            /*
                boolean r0 = com.netflix.falkor.cache.FalkorCache.m164()
                if (r0 != 0) goto L_0x0010
                o.ｕ r0 = o.C1276.m16820()
                java.lang.String r1 = "Skip purge cache due to !sInit"
                r0.mo5728(r1)
                return
            L_0x0010:
                java.lang.String r0 = "FalkorCache.RealmAccess"
                java.lang.String r1 = "purging cache"
                o.C1283.m16854(r0, r1)
            L_0x0017:
                java.util.concurrent.atomic.AtomicInteger r0 = com.netflix.falkor.cache.FalkorCache.C0004.f546
                int r0 = r0.get()
                if (r0 <= 0) goto L_0x0045
                java.lang.String r0 = "FalkorCache.RealmAccess"
                java.lang.String r1 = "Purge waiting due to accessCount=%d"
                r2 = 1
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ InterruptedException -> 0x003c }
                java.util.concurrent.atomic.AtomicInteger r3 = com.netflix.falkor.cache.FalkorCache.C0004.f546     // Catch:{ InterruptedException -> 0x003c }
                int r3 = r3.get()     // Catch:{ InterruptedException -> 0x003c }
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ InterruptedException -> 0x003c }
                r4 = 0
                r2[r4] = r3     // Catch:{ InterruptedException -> 0x003c }
                o.C1283.m16863(r0, r1, r2)     // Catch:{ InterruptedException -> 0x003c }
                r0 = 5
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x003c }
                goto L_0x0017
            L_0x003c:
                r5 = move-exception
                java.lang.String r0 = "FalkorCache.RealmAccess"
                java.lang.String r1 = "Purge wait interrupted"
                o.C1283.m16862(r0, r1)
                goto L_0x0017
            L_0x0045:
                io.realm.RealmConfiguration r0 = com.netflix.falkor.cache.FalkorCache.f537
                io.realm.Realm r5 = io.realm.Realm.getInstance(r0)
                r6 = 0
                com.netflix.falkor.cache.FalkorCache$ˊ$1 r0 = new com.netflix.falkor.cache.FalkorCache$ˊ$1     // Catch:{ Throwable -> 0x0070 }
                r0.<init>()     // Catch:{ Throwable -> 0x0070 }
                r5.executeTransaction(r0)     // Catch:{ Throwable -> 0x0070 }
                java.lang.String r0 = "FalkorCache.RealmAccess"
                java.lang.String r1 = "purged cache empty=%b"
                r2 = 1
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Throwable -> 0x0070 }
                boolean r3 = r5.isEmpty()     // Catch:{ Throwable -> 0x0070 }
                java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ Throwable -> 0x0070 }
                r4 = 0
                r2[r4] = r3     // Catch:{ Throwable -> 0x0070 }
                o.C1283.m16863(r0, r1, r2)     // Catch:{ Throwable -> 0x0070 }
                if (r5 == 0) goto L_0x0085
                r5.close()
                goto L_0x0085
            L_0x0070:
                r7 = move-exception
                r6 = r7
                throw r7     // Catch:{ all -> 0x0073 }
            L_0x0073:
                r8 = move-exception
                if (r5 == 0) goto L_0x0084
                if (r6 == 0) goto L_0x0081
                r5.close()     // Catch:{ Throwable -> 0x007c }
                goto L_0x0084
            L_0x007c:
                r9 = move-exception
                r6.addSuppressed(r9)
                goto L_0x0084
            L_0x0081:
                r5.close()
            L_0x0084:
                throw r8
            L_0x0085:
                com.netflix.falkor.cache.FalkorCache.LruBackup.m174()
                com.netflix.falkor.cache.FalkorCacheMonitor r0 = com.netflix.falkor.cache.FalkorCache.m162()
                r0.m202()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.netflix.falkor.cache.FalkorCache.C0004.m188():void");
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public static void m189(Realm realm) {
            realm.beginTransaction();
            f547.set(true);
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public static void m185(Realm realm) {
            realm.commitTransaction();
            f547.set(false);
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public static void m187(Realm realm) {
            C1283.m16862("FalkorCache.RealmAccess", "cancelled a transaction");
            realm.cancelTransaction();
            f547.set(false);
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public static void m190(Realm realm, Realm.Transaction transaction) {
            m191(realm, transaction, m183());
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        private static void m191(Realm realm, Realm.Transaction transaction, boolean z) {
            f546.incrementAndGet();
            if (!z) {
                try {
                    realm.executeTransaction(transaction);
                } catch (Throwable th) {
                    f546.decrementAndGet();
                    throw th;
                }
            } else {
                transaction.execute(realm);
            }
            f546.decrementAndGet();
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private static boolean m183() {
            return f547.get() != null && f547.get().booleanValue();
        }
    }

    public static class LruBackup {

        /* renamed from: ʻ  reason: contains not printable characters */
        private static volatile LinkedList<String> f539 = new LinkedList<>();

        /* renamed from: ˊ  reason: contains not printable characters */
        private static File f540 = null;

        /* renamed from: ˋ  reason: contains not printable characters */
        private static final Object[] f541 = new Object[0];

        /* renamed from: ˎ  reason: contains not printable characters */
        private static int f542 = 0;

        /* renamed from: ˏ  reason: contains not printable characters */
        private static If f543 = null;

        /* renamed from: ॱ  reason: contains not printable characters */
        private static C0348 f544;

        LruBackup() {
        }

        /* access modifiers changed from: package-private */
        public static class If extends Thread {

            /* renamed from: ˊ  reason: contains not printable characters */
            private Handler f545;

            private If() {
                super("FalkorCache.LruBackup");
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Looper.prepare();
                this.f545 = new HandlerC0003();
                Looper.loop();
            }
        }

        /* access modifiers changed from: package-private */
        public static class DiskLruJournalException extends IOException {
            public DiskLruJournalException(Throwable th) {
                super(th);
            }
        }

        /* renamed from: com.netflix.falkor.cache.FalkorCache$LruBackup$ˋ  reason: contains not printable characters */
        static class HandlerC0003 extends Handler {
            private HandlerC0003() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    m182();
                }
            }

            /* renamed from: ˎ  reason: contains not printable characters */
            private void m182() {
                LinkedList linkedList;
                synchronized (LruBackup.f541) {
                    linkedList = LruBackup.f539;
                    LinkedList unused = LruBackup.f539 = new LinkedList();
                }
                boolean z = false;
                try {
                    Realm r0 = C0004.m186();
                    int size = r0.where(C1147.class).findAll().size();
                    int i = 0;
                    while (!linkedList.isEmpty()) {
                        RealmResults findAll = r0.where(C1147.class).equalTo(FalkorPathResult.PATH, (String) linkedList.remove()).findAll();
                        if (findAll.size() > 0) {
                            if (!z) {
                                C0004.m189(r0);
                                z = true;
                            }
                            i += findAll.size();
                            FalkorCache.m165().m203(findAll.size());
                            findAll.deleteAllFromRealm();
                        }
                    }
                    if (z) {
                        C0004.m185(r0);
                    }
                    C1283.m16851("FalkorCache.LruBackup", "Entries deleted : %d (%d -> %d)", Integer.valueOf(i), Integer.valueOf(size), Integer.valueOf(r0.where(C1147.class).findAll().size()));
                    if (r0 != null) {
                        C0004.m184(r0);
                    }
                } catch (RuntimeException e) {
                    if (0 != 0) {
                        C0004.m187(null);
                    }
                    throw e;
                } catch (Throwable th) {
                    if (0 != 0) {
                        C0004.m184(null);
                    }
                    throw th;
                }
            }
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public static void m175(Context context, int i) {
            f543 = new If();
            f543.start();
            f542 = i;
            f540 = new File(context.getFilesDir(), "falkor.realm.lru_backup");
            m171();
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        private static void m171() {
            f544 = C0348.m13914(f540, f542, 15000, new C0348.Cif() { // from class: com.netflix.falkor.cache.FalkorCache.LruBackup.4
                @Override // o.C0348.Cif
                /* renamed from: ˊ  reason: contains not printable characters */
                public void mo180(String str, C0348.If r7) {
                    synchronized (LruBackup.f541) {
                        LruBackup.f539.push(str);
                    }
                    Message obtain = Message.obtain(LruBackup.f543.f545, 1);
                    LruBackup.f543.f545.removeMessages(1);
                    LruBackup.f543.f545.sendMessageDelayed(obtain, 500);
                }
            });
        }

        /* renamed from: ᐝ  reason: contains not printable characters */
        private static C0348 m179() {
            if (f544 != null) {
                return f544;
            }
            throw new IllegalStateException("Falkor cache accessed without calling FalkorCache.init(context)");
        }

        /* access modifiers changed from: private */
        /* renamed from: ʻ  reason: contains not printable characters */
        public static void m168() {
            try {
                m179().m13929();
                m171();
            } catch (IOException e) {
                C1276.m16820().mo5729("RealmAccess.purge exception", e);
            }
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public static void m169(Cif ifVar) {
            String str;
            try {
                m179().m13927(m172(ifVar));
            } catch (IllegalStateException e) {
                C1276.m16820().mo5730(e);
            } catch (IOException e2) {
                C0348 r7 = m179();
                if (new StatFs(r7.m13921().getPath()).getAvailableBytes() > 0) {
                    str = String.format(Locale.US, "FalkorCache.LruBackup.push() csize=%d, lrucount=%d", Long.valueOf(new File(FalkorCache.f537.getPath()).length() / 1024), Integer.valueOf(r7.m13926()));
                } else {
                    str = "FalkorCache.LruBackup.push() out of space";
                }
                C1276.m16820().mo5729(str, new DiskLruJournalException(e2));
            }
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        private static String m172(Cif ifVar) {
            if (!(ifVar instanceof C1147)) {
                C1276.m16820().mo5725("FalkorCache.LruBackup.push(" + ifVar.getClass() + ") -> not managed");
            }
            return ifVar.getPath();
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public static void m178(Cif ifVar) {
            try {
                if (m179().m13922(m172(ifVar)) == null) {
                    m169(ifVar);
                }
            } catch (IOException e) {
                C1276.m16820().mo5729("FalkorCache.LruBackup.markAccessed()", e);
            }
        }
    }
}

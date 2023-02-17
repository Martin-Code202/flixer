package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.os.storage.StorageManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* renamed from: o.ib  reason: case insensitive filesystem */
public class C1875ib {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final long f7702 = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final long f7703 = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: ʼ  reason: contains not printable characters */
    private final iF f7704;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final Runnable f7705 = new Runnable() { // from class: o.ib.1
        @Override // java.lang.Runnable
        public void run() {
            C1875ib.this.m7646();
        }
    };

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Context f7706;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f7707;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Handler f7708;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final BroadcastReceiver f7709 = new BroadcastReceiver() { // from class: o.ib.5
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                boolean r6 = C1875ib.this.f7710.m4022();
                C1283.m16863("offlineStorageMonitor", "mExtStorageMountReceiver tooFast=%b action=%s mData=%s", Boolean.valueOf(r6), action, intent.getData());
                if (!r6) {
                    C1875ib.this.f7708.removeCallbacks(C1875ib.this.f7705);
                    if ("android.intent.action.MEDIA_EJECT".equals(action) || "android.intent.action.MEDIA_UNMOUNTED".equals(action)) {
                        C1875ib.this.f7708.postDelayed(C1875ib.this.f7705, C1875ib.f7703);
                    } else {
                        C1875ib.this.f7708.postDelayed(C1875ib.this.f7705, C1875ib.f7702);
                    }
                }
            }
        }
    };

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final C1336Bi f7710;

    /* renamed from: o.ib$iF */
    public interface iF {
        /* renamed from: ˎ */
        void mo7290();
    }

    public C1875ib(Context context, Looper looper, iF iFVar) {
        this.f7704 = iFVar;
        this.f7706 = context;
        this.f7708 = new Handler(looper);
        this.f7710 = new C1336Bi(5, TimeUnit.MINUTES.toMillis(5));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m7656() {
        m7654();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7655() {
        m7645();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public List<C1876ic> m7657() {
        C1283.m16862("offlineStorageMonitor", "buildOfflineStorageVolumeInfoList");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        File[] externalFilesDirs = this.f7706.getExternalFilesDirs(Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDirs != null) {
            StorageManager storageManager = (StorageManager) this.f7706.getSystemService("storage");
            int i = 0;
            while (i < externalFilesDirs.length) {
                C1283.m16863("offlineStorageMonitor", "\n i=%d", Integer.valueOf(i));
                File file = externalFilesDirs[i];
                if (file == null) {
                    C1283.m16862("offlineStorageMonitor", "downloadDir null, ignore");
                } else {
                    if (!file.exists()) {
                        C1283.m16863("offlineStorageMonitor", "mkdirsResult=%b", Boolean.valueOf(file.mkdirs()));
                        if (!file.exists()) {
                            C1283.m16862("offlineStorageMonitor", "downloadDir still doesn't exist, ignore");
                        }
                    }
                    if (hashSet.contains(file.getAbsolutePath())) {
                        C1283.m16863("offlineStorageMonitor", "downloadDir duplicate %s", file.getAbsolutePath());
                    } else {
                        hashSet.add(file.getAbsolutePath());
                        StatFs r12 = C1330Bc.m4008(file);
                        if (r12 == null) {
                            C1283.m16862("offlineStorageMonitor", "statFs null, ignore");
                        } else if (!m7652(file)) {
                            C1283.m16862("offlineStorageMonitor", "downloadDir not writable, ignore");
                        } else {
                            try {
                                arrayList.add(new C1876ic(this.f7706, storageManager, file, r12, i == 0));
                            } catch (Exception e) {
                                C1283.m16863("offlineStorageMonitor", "OfflineStorageVolumeInfo constructor returned ", e);
                            }
                        }
                    }
                }
                i++;
            }
        }
        return arrayList;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m7645() {
        if (this.f7707) {
            this.f7706.unregisterReceiver(this.f7709);
        }
        this.f7707 = false;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m7654() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_NOFS");
        intentFilter.addAction("android.intent.action.MEDIA_REMOVED");
        intentFilter.addAction("android.intent.action.MEDIA_SHARED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTABLE");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        this.f7707 = true;
        this.f7706.registerReceiver(this.f7709, intentFilter);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʽ  reason: contains not printable characters */
    private void m7646() {
        this.f7704.mo7290();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static boolean m7652(File file) {
        File file2 = new File(file.getAbsolutePath() + "nf.test");
        try {
            if (file2.exists()) {
                boolean delete = file2.delete();
                C1283.m16863("offlineStorageMonitor", "passesNfWriteTest first deleteResult=%b", Boolean.valueOf(delete));
                if (!delete) {
                    return false;
                }
            }
            C1283.m16863("offlineStorageMonitor", "passesNfWriteTest createNewFile=%b", Boolean.valueOf(file2.createNewFile()));
            boolean exists = file2.exists();
            C1283.m16863("offlineStorageMonitor", "passesNfWriteTest file exists=%b", Boolean.valueOf(exists));
            C1283.m16863("offlineStorageMonitor", "passesNfWriteTest delete=%b", Boolean.valueOf(file2.delete()));
            return exists;
        } catch (IOException e) {
            C1283.m16863("offlineStorageMonitor", "passesNfWriteTest IOException ", e);
            return false;
        } catch (Exception e2) {
            C1283.m16863("offlineStorageMonitor", "passesNfWriteTest Exception ", e2);
            return false;
        }
    }
}

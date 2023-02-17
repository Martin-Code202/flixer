package o;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import java.io.File;
/* renamed from: o.ic  reason: case insensitive filesystem */
public class C1876ic {

    /* renamed from: ʽ  reason: contains not printable characters */
    private long f7713;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final File f7714;

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f7715;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f7716;

    /* renamed from: ˏ  reason: contains not printable characters */
    private long f7717;

    /* renamed from: ॱ  reason: contains not printable characters */
    private long f7718;

    public C1876ic(Context context, StorageManager storageManager, File file, StatFs statFs, boolean z) {
        this.f7714 = file;
        m7662(statFs);
        this.f7715 = !z;
        if (Build.VERSION.SDK_INT >= 21) {
            this.f7715 = Environment.isExternalStorageRemovable(file);
            this.f7716 = Environment.isExternalStorageEmulated(file);
        }
        m7658();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m7660() {
        return this.f7715;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public File m7664() {
        return this.f7714;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public long m7663() {
        return this.f7717;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public long m7661() {
        return this.f7718;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public long m7659() {
        return this.f7713;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m7662(StatFs statFs) {
        this.f7717 = statFs.getTotalBytes();
        this.f7718 = statFs.getFreeBytes();
        this.f7713 = AH.m3346(this.f7714.getParentFile());
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m7658() {
        C1283.m16863("offlineStorageVolInfo", "\nmDownloadDirPath=%s mTotalSpace=%d mFreeSpace=%d mNetflixUsedSpace=%d mIsRemovable=%b mIsEmulated=%b", this.f7714.getAbsolutePath(), Long.valueOf(this.f7717), Long.valueOf(this.f7718), Long.valueOf(this.f7713), Boolean.valueOf(this.f7715), Boolean.valueOf(this.f7716));
    }
}

package o;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.system.Os;
import android.system.StructStat;
import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* renamed from: o.Bw  reason: case insensitive filesystem */
public class C1350Bw {
    /* renamed from: ˎ  reason: contains not printable characters */
    public static If m4131(Context context) {
        If r6 = null;
        File[] externalFilesDirs = context.getExternalFilesDirs(Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDirs != null) {
            r6 = new If(externalFilesDirs.length);
            int i = 0;
            while (i < externalFilesDirs.length) {
                File file = externalFilesDirs[i];
                if (file == null) {
                    C1283.m16862("StorageStateUtils", "externalFilesDirs null, ignore");
                } else {
                    boolean z = true;
                    if (!file.exists()) {
                        C1283.m16863("StorageStateUtils", "mkdirsResult=%b", Boolean.valueOf(file.mkdirs()));
                        if (!file.exists()) {
                            z = false;
                        }
                    }
                    String str = "";
                    boolean z2 = i != 0;
                    boolean z3 = false;
                    try {
                        if (Build.VERSION.SDK_INT >= 21) {
                            z2 = Environment.isExternalStorageRemovable(file);
                            z3 = Environment.isExternalStorageEmulated(file);
                            if (!z) {
                                int myUid = Process.myUid();
                                StructStat stat = Os.stat(file.getAbsolutePath());
                                str = "appUid=" + myUid + " dirUid=" + stat.st_uid + " dirGid=" + stat.st_gid;
                                C1283.m16863("StorageStateUtils", "dbgInfo=%s", str);
                            }
                        }
                    } catch (Exception e) {
                    }
                    r6.mExternalStorageInfoList.add(new C0071(z2, i == 0, z, z3, str));
                }
                i++;
            }
        }
        return r6;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m4130(Context context) {
        If r1 = m4131(context);
        return r1 != null ? AE.m3322().toJson(r1) : "";
    }

    /* renamed from: o.Bw$ˊ  reason: contains not printable characters */
    public static class C0071 {
        @SerializedName("dbgInfo")
        public final String mDebugInfo;
        @SerializedName("emulated")
        public final boolean mIsEmulated;
        @SerializedName("primary")
        public final boolean mIsPrimaryStorage;
        @SerializedName("removable")
        public final boolean mIsRemovable;
        @SerializedName("writable")
        public final boolean mIsWritable;

        public C0071(boolean z, boolean z2, boolean z3, boolean z4, String str) {
            this.mIsRemovable = z;
            this.mIsPrimaryStorage = z2;
            this.mIsWritable = z3;
            this.mIsEmulated = z4;
            this.mDebugInfo = str;
        }
    }

    /* renamed from: o.Bw$If */
    public static class If {
        @SerializedName("storageInfoList")
        public final List<C0071> mExternalStorageInfoList = new ArrayList();
        @SerializedName("storageCount")
        public final int mNumberOfExternalStorage;

        public If(int i) {
            this.mNumberOfExternalStorage = i;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public boolean m4132(Activity activity) {
            return this.mExternalStorageInfoList != null && this.mExternalStorageInfoList.size() > 0 && !this.mExternalStorageInfoList.get(0).mIsWritable && C1317As.m3751(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        }
    }
}

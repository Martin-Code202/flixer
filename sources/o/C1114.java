package o;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
/* renamed from: o.ﭔ  reason: contains not printable characters */
public class C1114 {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final FileFilter f15331 = new FileFilter() { // from class: o.ﭔ.5
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i = 3; i < name.length(); i++) {
                if (!Character.isDigit(name.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    };

    /* renamed from: ˋ  reason: contains not printable characters */
    public static int m16242() {
        if (Build.VERSION.SDK_INT <= 10) {
            return 1;
        }
        try {
            return new File("/sys/devices/system/cpu/").listFiles(f15331).length;
        } catch (SecurityException e) {
            return -1;
        } catch (NullPointerException e2) {
            return -1;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static int m16241() {
        int i = -1;
        for (int i2 = 0; i2 < m16242(); i2++) {
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i2 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists()) {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        int i3 = 0;
                        while (Character.isDigit(bArr[i3])) {
                            int length = bArr.length;
                            if (i3 >= 128) {
                                break;
                            }
                            i3++;
                        }
                        Integer valueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i3)));
                        if (valueOf.intValue() > i) {
                            i = valueOf.intValue();
                        }
                    } catch (NumberFormatException e) {
                    } finally {
                        fileInputStream.close();
                    }
                }
            } catch (IOException e2) {
                return -1;
            }
        }
        if (i != -1) {
            return i;
        }
        FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
        try {
            int r4 = m16244("cpu MHz", fileInputStream2) * 1000;
            if (r4 > i) {
                i = r4;
            }
            return i;
        } finally {
            fileInputStream2.close();
        }
    }

    @TargetApi(16)
    /* renamed from: ˋ  reason: contains not printable characters */
    public static long m16243(Context context) {
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            if (memoryInfo != null) {
                return memoryInfo.totalMem;
            }
            return -1;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/meminfo");
            try {
                return 1024 * ((long) m16244("MemTotal", fileInputStream));
            } finally {
                fileInputStream.close();
            }
        } catch (IOException e) {
            return -1;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int m16244(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int read = fileInputStream.read(bArr);
            int i = 0;
            while (i < read) {
                if (bArr[i] == 10 || i == 0) {
                    if (bArr[i] == 10) {
                        i++;
                    }
                    int i2 = i;
                    while (true) {
                        if (i2 >= read) {
                            continue;
                            break;
                        }
                        int i3 = i2 - i;
                        if (bArr[i2] != str.charAt(i3)) {
                            break;
                        } else if (i3 == str.length() - 1) {
                            return m16245(bArr, i2);
                        } else {
                            i2++;
                        }
                    }
                }
                i++;
            }
            return -1;
        } catch (IOException | NumberFormatException e) {
            return -1;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int m16245(byte[] bArr, int i) {
        while (i < bArr.length && bArr[i] != 10) {
            if (Character.isDigit(bArr[i])) {
                while (true) {
                    i++;
                    if (i >= bArr.length || !Character.isDigit(bArr[i])) {
                        break;
                    }
                }
                return Integer.parseInt(new String(bArr, 0, i, i - i));
            }
            i++;
        }
        return -1;
    }
}

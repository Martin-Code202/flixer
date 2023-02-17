package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public final class zzq {
    private static String zzfze = null;
    private static final int zzfzf = Process.myPid();

    public static String zzall() {
        if (zzfze == null) {
            zzfze = zzch(zzfzf);
        }
        return zzfze;
    }

    private static String zzch(int i) {
        if (i <= 0) {
            return null;
        }
        BufferedReader bufferedReader = null;
        try {
            StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
            try {
                bufferedReader = new BufferedReader(new FileReader(new StringBuilder(25).append("/proc/").append(i).append("/cmdline").toString()));
                return bufferedReader.readLine().trim();
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        } catch (IOException unused) {
            return null;
        } finally {
            zzm.closeQuietly(bufferedReader);
        }
    }
}

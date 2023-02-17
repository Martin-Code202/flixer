package org.chromium.base;

import android.app.ActivityManager;
import android.os.StrictMode;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.chromium.base.annotations.CalledByNative;
public class SysUtils {
    static final /* synthetic */ boolean $assertionsDisabled = (!SysUtils.class.desiredAssertionStatus());
    private static Boolean sLowEndDevice;

    private SysUtils() {
    }

    private static int amountOfPhysicalMemoryKB() {
        Pattern compile = Pattern.compile("^MemTotal:\\s+([0-9]+) kB$");
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            FileReader fileReader = new FileReader("/proc/meminfo");
            try {
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            Log.w("SysUtils", "/proc/meminfo lacks a MemTotal entry?");
                            break;
                        }
                        Matcher matcher = compile.matcher(readLine);
                        if (matcher.find()) {
                            int parseInt = Integer.parseInt(matcher.group(1));
                            if (parseInt <= 1024) {
                                Log.w("SysUtils", "Invalid /proc/meminfo total size in kB: " + matcher.group(1));
                            } else {
                                bufferedReader.close();
                                fileReader.close();
                                StrictMode.setThreadPolicy(allowThreadDiskReads);
                                return parseInt;
                            }
                        }
                    } finally {
                        bufferedReader.close();
                    }
                }
                return 0;
            } finally {
                fileReader.close();
            }
        } catch (Exception e) {
            Log.w("SysUtils", "Cannot get total physical size from /proc/meminfo", e);
            return 0;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    @CalledByNative
    public static boolean isLowEndDevice() {
        if (sLowEndDevice == null) {
            sLowEndDevice = Boolean.valueOf(detectLowEndDevice());
        }
        return sLowEndDevice.booleanValue();
    }

    @CalledByNative
    private static boolean isCurrentlyLowMemory() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) ContextUtils.getApplicationContext().getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.lowMemory;
    }

    private static boolean detectLowEndDevice() {
        int amountOfPhysicalMemoryKB;
        if (!$assertionsDisabled && !CommandLine.isInitialized()) {
            throw new AssertionError();
        } else if (CommandLine.getInstance().hasSwitch("enable-low-end-device-mode")) {
            return true;
        } else {
            if (!CommandLine.getInstance().hasSwitch("disable-low-end-device-mode") && (amountOfPhysicalMemoryKB = amountOfPhysicalMemoryKB()) > 0) {
                return BuildInfo.isAtLeastO() ? amountOfPhysicalMemoryKB / 1024 <= 1024 : amountOfPhysicalMemoryKB / 1024 <= 512;
            }
            return false;
        }
    }
}

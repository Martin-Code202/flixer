package org.chromium.base;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import org.chromium.base.annotations.CalledByNative;
public class BuildInfo {
    private BuildInfo() {
    }

    @CalledByNative
    private static String[] getAll() {
        String str;
        try {
            String packageName = ContextUtils.getApplicationContext().getPackageName();
            PackageManager packageManager = ContextUtils.getApplicationContext().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            String num = packageInfo.versionCode <= 0 ? "" : Integer.toString(packageInfo.versionCode);
            String str2 = packageInfo.versionName == null ? "" : packageInfo.versionName;
            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
            String charSequence = applicationLabel == null ? "" : applicationLabel.toString();
            String installerPackageName = packageManager.getInstallerPackageName(packageName);
            if (installerPackageName == null) {
                installerPackageName = "";
            }
            if (Build.VERSION.SDK_INT >= 21) {
                str = TextUtils.join(", ", Build.SUPPORTED_ABIS);
            } else {
                str = "ABI1: " + Build.CPU_ABI + ", ABI2: " + Build.CPU_ABI2;
            }
            return new String[]{Build.BRAND, Build.DEVICE, Build.ID, Build.MANUFACTURER, Build.MODEL, String.valueOf(Build.VERSION.SDK_INT), Build.TYPE, charSequence, packageName, num, str2, getAndroidBuildFingerprint(), getGMSVersionCode(packageManager), installerPackageName, str, String.format("@%s", Long.toHexString(packageInfo.versionCode > 10 ? (long) packageInfo.versionCode : packageInfo.lastUpdateTime))};
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getAndroidBuildFingerprint() {
        return Build.FINGERPRINT.substring(0, Math.min(Build.FINGERPRINT.length(), 128));
    }

    private static String getGMSVersionCode(PackageManager packageManager) {
        try {
            return Integer.toString(packageManager.getPackageInfo("com.google.android.gms", 0).versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            Log.d("BuildInfo", "GMS package is not found.", e);
            return "gms versionCode not available.";
        }
    }

    public static boolean isAtLeastO() {
        return Build.VERSION.SDK_INT >= 26;
    }
}

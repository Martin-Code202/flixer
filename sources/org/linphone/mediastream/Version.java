package org.linphone.mediastream;

import android.content.Context;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;
public class Version {
    public static final int API03_CUPCAKE_15 = 3;
    public static final int API04_DONUT_16 = 4;
    public static final int API05_ECLAIR_20 = 5;
    public static final int API06_ECLAIR_201 = 6;
    public static final int API07_ECLAIR_21 = 7;
    public static final int API08_FROYO_22 = 8;
    public static final int API09_GINGERBREAD_23 = 9;
    public static final int API10_GINGERBREAD_MR1_233 = 10;
    public static final int API11_HONEYCOMB_30 = 11;
    public static final int API12_HONEYCOMB_MR1_31X = 12;
    public static final int API13_HONEYCOMB_MR2_32 = 13;
    public static final int API14_ICE_CREAM_SANDWICH_40 = 14;
    public static final int API15_ICE_CREAM_SANDWICH_403 = 15;
    public static final int API16_JELLY_BEAN_41 = 16;
    public static final int API17_JELLY_BEAN_42 = 17;
    public static final int API18_JELLY_BEAN_43 = 18;
    public static final int API19_KITKAT_44 = 19;
    public static final int API21_LOLLIPOP_50 = 21;
    public static final int API22_LOLLIPOP_51 = 22;
    public static final int API23_MARSHMALLOW_60 = 23;
    public static final int API24_NOUGAT_70 = 24;
    public static final int API25_NOUGAT_71 = 25;
    public static final int API26_O_80 = 26;
    private static final int buildVersion = Build.VERSION.SDK_INT;
    private static Boolean hasNeon = null;
    private static Boolean sCacheHasZrtp = null;

    private static native boolean nativeHasNeon();

    private static native boolean nativeHasZrtp();

    public static boolean isXLargeScreen(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 4;
    }

    public static final boolean sdkAboveOrEqual(int i) {
        return buildVersion >= i;
    }

    public static final boolean sdkStrictlyBelow(int i) {
        return buildVersion < i;
    }

    public static int sdk() {
        return buildVersion;
    }

    public static List<String> getCpuAbis() {
        ArrayList arrayList = new ArrayList();
        if (sdkAboveOrEqual(21)) {
            try {
                for (String str : (String[]) Build.class.getField("SUPPORTED_ABIS").get(null)) {
                    arrayList.add(str);
                }
            } catch (Throwable th) {
                Log.e(th);
            }
        } else {
            arrayList.add(Build.CPU_ABI);
            arrayList.add(Build.CPU_ABI2);
        }
        return arrayList;
    }

    private static boolean isArm64() {
        try {
            return getCpuAbis().get(0).startsWith("arm64-v8a");
        } catch (Throwable th) {
            Log.e(th);
            return false;
        }
    }

    private static boolean isArmv7() {
        try {
            return getCpuAbis().get(0).startsWith("armeabi-v7");
        } catch (Throwable th) {
            Log.e(th);
            return false;
        }
    }

    private static boolean isX86() {
        try {
            return getCpuAbis().get(0).startsWith("x86");
        } catch (Throwable th) {
            Log.e(th);
            return false;
        }
    }

    private static boolean isArmv5() {
        try {
            return getCpuAbis().get(0).equals("armeabi");
        } catch (Throwable th) {
            Log.e(th);
            return false;
        }
    }

    public static boolean hasNeon() {
        if (hasNeon == null) {
            hasNeon = Boolean.valueOf(nativeHasNeon());
        }
        return hasNeon.booleanValue();
    }

    public static boolean hasFastCpu() {
        return !isArmv5();
    }

    public static boolean hasFastCpuWithAsmOptim() {
        return isX86() || isArm64() || (!isArmv5() && hasNeon());
    }

    public static boolean isVideoCapable() {
        return !sdkStrictlyBelow(5) && hasFastCpu();
    }

    public static boolean isHDVideoCapable() {
        return isVideoCapable() && hasFastCpuWithAsmOptim() && Runtime.getRuntime().availableProcessors() > 1;
    }

    public static boolean hasZrtp() {
        if (sCacheHasZrtp == null) {
            sCacheHasZrtp = Boolean.valueOf(nativeHasZrtp());
        }
        return sCacheHasZrtp.booleanValue();
    }

    public static void dumpCapabilities() {
        StringBuilder sb = new StringBuilder(" ==== Capabilities dump ====\n");
        if (isArmv7()) {
            sb.append("Has neon: ").append(Boolean.toString(hasNeon())).append("\n");
        }
        sb.append("Has ZRTP: ").append(Boolean.toString(hasZrtp())).append("\n");
        Log.i(sb.toString());
    }
}

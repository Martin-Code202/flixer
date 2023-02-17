package com.ibm.icu.impl;

import com.ibm.icu.util.VersionInfo;
public final class ICUDebug {
    private static boolean debug = (params != null);
    private static boolean help = (debug && (params.equals("") || params.indexOf("help") != -1));
    public static final boolean isJDK14OrHigher = (javaVersion.compareTo(VersionInfo.getInstance("1.4.0")) >= 0);
    public static final VersionInfo javaVersion = getInstanceLenient(javaVersionString);
    public static final String javaVersionString = System.getProperty("java.version", "0");
    private static String params;

    static {
        try {
            params = System.getProperty("ICUDebug");
        } catch (SecurityException e) {
        }
        if (debug) {
            System.out.println("\nICUDebug=" + params);
        }
    }

    public static VersionInfo getInstanceLenient(String str) {
        int[] iArr = new int[4];
        boolean z = false;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= str.length()) {
                break;
            }
            i++;
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                if (!z) {
                    continue;
                } else if (i2 == 3) {
                    break;
                } else {
                    z = false;
                    i2++;
                }
            } else if (z) {
                iArr[i2] = (iArr[i2] * 10) + (charAt - '0');
                if (iArr[i2] > 255) {
                    iArr[i2] = 0;
                    break;
                }
            } else {
                z = true;
                iArr[i2] = charAt - '0';
            }
        }
        return VersionInfo.getInstance(iArr[0], iArr[1], iArr[2], iArr[3]);
    }

    public static boolean enabled(String str) {
        if (!debug) {
            return false;
        }
        boolean z = params.indexOf(str) != -1;
        if (help) {
            System.out.println("\nICUDebug.enabled(" + str + ") = " + z);
        }
        return z;
    }

    public static String value(String str) {
        String str2 = "false";
        if (debug) {
            int indexOf = params.indexOf(str);
            if (indexOf != -1) {
                int length = indexOf + str.length();
                if (params.length() <= length || params.charAt(length) != '=') {
                    str2 = "true";
                } else {
                    int i = length + 1;
                    int indexOf2 = params.indexOf(",", i);
                    str2 = params.substring(i, indexOf2 == -1 ? params.length() : indexOf2);
                }
            }
            if (help) {
                System.out.println("\nICUDebug.value(" + str + ") = " + str2);
            }
        }
        return str2;
    }
}

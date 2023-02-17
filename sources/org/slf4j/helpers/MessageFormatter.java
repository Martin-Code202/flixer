package org.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;
public final class MessageFormatter {
    public static final String format(String str, Object obj, Object obj2) {
        return arrayFormat(str, new Object[]{obj, obj2});
    }

    public static final String arrayFormat(String str, Object[] objArr) {
        if (str == null) {
            return null;
        }
        if (objArr == null) {
            return str;
        }
        int i = 0;
        StringBuffer stringBuffer = new StringBuffer(str.length() + 50);
        int i2 = 0;
        while (i2 < objArr.length) {
            int indexOf = str.indexOf("{}", i);
            if (indexOf != -1) {
                if (!isEscapedDelimeter(str, indexOf)) {
                    stringBuffer.append(str.substring(i, indexOf));
                    deeplyAppendParameter(stringBuffer, objArr[i2], new HashMap());
                    i = indexOf + 2;
                } else if (!isDoubleEscaped(str, indexOf)) {
                    i2--;
                    stringBuffer.append(str.substring(i, indexOf - 1));
                    stringBuffer.append('{');
                    i = indexOf + 1;
                } else {
                    stringBuffer.append(str.substring(i, indexOf - 1));
                    deeplyAppendParameter(stringBuffer, objArr[i2], new HashMap());
                    i = indexOf + 2;
                }
                i2++;
            } else if (i == 0) {
                return str;
            } else {
                stringBuffer.append(str.substring(i, str.length()));
                return stringBuffer.toString();
            }
        }
        stringBuffer.append(str.substring(i, str.length()));
        return stringBuffer.toString();
    }

    static final boolean isEscapedDelimeter(String str, int i) {
        if (i != 0 && str.charAt(i - 1) == '\\') {
            return true;
        }
        return false;
    }

    static final boolean isDoubleEscaped(String str, int i) {
        if (i < 2 || str.charAt(i - 2) != '\\') {
            return false;
        }
        return true;
    }

    private static void deeplyAppendParameter(StringBuffer stringBuffer, Object obj, Map map) {
        if (obj == null) {
            stringBuffer.append("null");
        } else if (!obj.getClass().isArray()) {
            safeObjectAppend(stringBuffer, obj);
        } else if (obj instanceof boolean[]) {
            booleanArrayAppend(stringBuffer, (boolean[]) obj);
        } else if (obj instanceof byte[]) {
            byteArrayAppend(stringBuffer, (byte[]) obj);
        } else if (obj instanceof char[]) {
            charArrayAppend(stringBuffer, (char[]) obj);
        } else if (obj instanceof short[]) {
            shortArrayAppend(stringBuffer, (short[]) obj);
        } else if (obj instanceof int[]) {
            intArrayAppend(stringBuffer, (int[]) obj);
        } else if (obj instanceof long[]) {
            longArrayAppend(stringBuffer, (long[]) obj);
        } else if (obj instanceof float[]) {
            floatArrayAppend(stringBuffer, (float[]) obj);
        } else if (obj instanceof double[]) {
            doubleArrayAppend(stringBuffer, (double[]) obj);
        } else {
            objectArrayAppend(stringBuffer, (Object[]) obj, map);
        }
    }

    private static void safeObjectAppend(StringBuffer stringBuffer, Object obj) {
        try {
            stringBuffer.append(obj.toString());
        } catch (Throwable th) {
            System.err.println("SLF4J: Failed toString() invocation on an object of type [" + obj.getClass().getName() + "]");
            th.printStackTrace();
            stringBuffer.append("[FAILED toString()]");
        }
    }

    private static void objectArrayAppend(StringBuffer stringBuffer, Object[] objArr, Map map) {
        stringBuffer.append('[');
        if (!map.containsKey(objArr)) {
            map.put(objArr, null);
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                deeplyAppendParameter(stringBuffer, objArr[i], map);
                if (i != length - 1) {
                    stringBuffer.append(", ");
                }
            }
            map.remove(objArr);
        } else {
            stringBuffer.append("...");
        }
        stringBuffer.append(']');
    }

    private static void booleanArrayAppend(StringBuffer stringBuffer, boolean[] zArr) {
        stringBuffer.append('[');
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(zArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    private static void byteArrayAppend(StringBuffer stringBuffer, byte[] bArr) {
        stringBuffer.append('[');
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append((int) bArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    private static void charArrayAppend(StringBuffer stringBuffer, char[] cArr) {
        stringBuffer.append('[');
        int length = cArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(cArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    private static void shortArrayAppend(StringBuffer stringBuffer, short[] sArr) {
        stringBuffer.append('[');
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append((int) sArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    private static void intArrayAppend(StringBuffer stringBuffer, int[] iArr) {
        stringBuffer.append('[');
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(iArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    private static void longArrayAppend(StringBuffer stringBuffer, long[] jArr) {
        stringBuffer.append('[');
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(jArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    private static void floatArrayAppend(StringBuffer stringBuffer, float[] fArr) {
        stringBuffer.append('[');
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(fArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }

    private static void doubleArrayAppend(StringBuffer stringBuffer, double[] dArr) {
        stringBuffer.append('[');
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(dArr[i]);
            if (i != length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(']');
    }
}

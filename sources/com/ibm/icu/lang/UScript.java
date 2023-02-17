package com.ibm.icu.lang;

import com.ibm.icu.impl.UCharacterProperty;
public final class UScript {
    private static final ScriptUsage[] usageValues = ScriptUsage.values();

    public enum ScriptUsage {
        NOT_ENCODED,
        UNKNOWN,
        EXCLUDED,
        LIMITED_USE,
        ASPIRATIONAL,
        RECOMMENDED
    }

    public static final int getScript(int i) {
        if ((i >= 0) && (i <= 1114111)) {
            int additional = UCharacterProperty.INSTANCE.getAdditional(i, 0) & 12583167;
            if (additional < 4194304) {
                return additional;
            }
            if (additional < 8388608) {
                return 0;
            }
            if (additional < 12582912) {
                return 1;
            }
            return UCharacterProperty.INSTANCE.m_scriptExtensions_[additional & 255];
        }
        throw new IllegalArgumentException(Integer.toString(i));
    }

    public static final boolean hasScript(int i, int i2) {
        int additional = UCharacterProperty.INSTANCE.getAdditional(i, 0) & 12583167;
        if (additional < 4194304) {
            return i2 == additional;
        }
        char[] cArr = UCharacterProperty.INSTANCE.m_scriptExtensions_;
        int i3 = additional & 255;
        char c = i3;
        if (additional >= 12582912) {
            c = cArr[i3 + 1];
        }
        int i4 = c;
        if (i2 > 32767) {
            return false;
        }
        while (i2 > cArr[i4 == 1 ? 1 : 0]) {
            i4 = (i4 == 1 ? 1 : 0) + 1;
        }
        return i2 == (cArr[i4] & 32767);
    }
}

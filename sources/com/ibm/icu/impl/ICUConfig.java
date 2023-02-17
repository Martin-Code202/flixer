package com.ibm.icu.impl;

import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.HashMap;
import java.util.Map;
public class ICUConfig {
    private static final Map<String, String> PROPERTIES = new HashMap();

    static {
        PROPERTIES.put("com.ibm.icu.util.TimeZone.DefaultTimeZoneType", "ICU");
        PROPERTIES.put("com.ibm.icu.text.MessagePattern.ApostropheMode", "DOUBLE_OPTIONAL");
        PROPERTIES.put("com.ibm.icu.text.DecimalFormat.SkipExtendedSeparatorParsing", "false");
        PROPERTIES.put("com.ibm.icu.impl.ICUBinary.dataPath", "");
        PROPERTIES.put("com.ibm.icu.impl.ICUResourceBundle.skipRuntimeLocaleResourceScan", "false");
    }

    public static String get(String str) {
        return get(str, null);
    }

    public static String get(final String str, String str2) {
        String str3 = null;
        if (System.getSecurityManager() != null) {
            try {
                str3 = (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: com.ibm.icu.impl.ICUConfig.1
                    @Override // java.security.PrivilegedAction
                    public String run() {
                        return System.getProperty(str);
                    }
                });
            } catch (AccessControlException e) {
            }
        } else {
            str3 = System.getProperty(str);
        }
        if (str3 != null) {
            return str3;
        }
        String str4 = PROPERTIES.get(str);
        return str4 == null ? str2 : str4;
    }
}

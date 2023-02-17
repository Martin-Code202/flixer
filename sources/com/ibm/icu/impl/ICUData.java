package com.ibm.icu.impl;

import java.io.InputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.MissingResourceException;
import java.util.logging.Logger;
public final class ICUData {
    private static final Logger logger = null;

    static InputStream getStream(final ClassLoader classLoader, final String str, boolean z) {
        InputStream inputStream;
        if (System.getSecurityManager() != null) {
            inputStream = (InputStream) AccessController.doPrivileged(new PrivilegedAction<InputStream>() { // from class: com.ibm.icu.impl.ICUData.3
                @Override // java.security.PrivilegedAction
                public InputStream run() {
                    return classLoader.getResourceAsStream(str);
                }
            });
        } else {
            inputStream = classLoader.getResourceAsStream(str);
        }
        if (inputStream != null || !z) {
            checkStreamForBinaryData(inputStream, str);
            return inputStream;
        }
        throw new MissingResourceException("could not locate data", classLoader.toString(), str);
    }

    private static void checkStreamForBinaryData(InputStream inputStream, String str) {
    }

    public static InputStream getStream(ClassLoader classLoader, String str) {
        return getStream(classLoader, str, false);
    }
}

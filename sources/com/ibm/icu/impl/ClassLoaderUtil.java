package com.ibm.icu.impl;

import java.security.AccessController;
import java.security.PrivilegedAction;
public class ClassLoaderUtil {
    private static volatile ClassLoader BOOTSTRAP_CLASSLOADER;

    /* access modifiers changed from: package-private */
    public static class BootstrapClassLoader extends ClassLoader {
        BootstrapClassLoader() {
            super(Object.class.getClassLoader());
        }
    }

    private static ClassLoader getBootstrapClassLoader() {
        ClassLoader classLoader;
        if (BOOTSTRAP_CLASSLOADER == null) {
            synchronized (ClassLoaderUtil.class) {
                if (BOOTSTRAP_CLASSLOADER == null) {
                    if (System.getSecurityManager() != null) {
                        classLoader = (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: com.ibm.icu.impl.ClassLoaderUtil.1
                            /* Return type fixed from 'com.ibm.icu.impl.ClassLoaderUtil$BootstrapClassLoader' to match base method */
                            @Override // java.security.PrivilegedAction
                            public ClassLoader run() {
                                return new BootstrapClassLoader();
                            }
                        });
                    } else {
                        classLoader = new BootstrapClassLoader();
                    }
                    BOOTSTRAP_CLASSLOADER = classLoader;
                }
            }
        }
        return BOOTSTRAP_CLASSLOADER;
    }

    public static ClassLoader getClassLoader(Class<?> cls) {
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            return getClassLoader();
        }
        return classLoader;
    }

    public static ClassLoader getClassLoader() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != null) {
            return contextClassLoader;
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        if (systemClassLoader == null) {
            return getBootstrapClassLoader();
        }
        return systemClassLoader;
    }
}

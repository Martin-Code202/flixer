package org.slf4j;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import org.slf4j.helpers.SubstituteLoggerFactory;
import org.slf4j.helpers.Util;
import org.slf4j.impl.StaticLoggerBinder;
public final class LoggerFactory {
    private static final String[] API_COMPATIBILITY_LIST = {"1.5.5", "1.5.6", "1.5.7", "1.5.8"};
    static int GET_SINGLETON_METHOD = 0;
    static int INITIALIZATION_STATE = 0;
    private static String STATIC_LOGGER_BINDER_PATH = "org/slf4j/impl/StaticLoggerBinder.class";
    static SubstituteLoggerFactory TEMP_FACTORY = new SubstituteLoggerFactory();

    private LoggerFactory() {
    }

    private static final void performInitialization() {
        bind();
        versionSanityCheck();
        singleImplementationSanityCheck();
    }

    private static final void bind() {
        try {
            getSingleton();
            INITIALIZATION_STATE = 3;
            emitSubstitureLoggerWarning();
        } catch (NoClassDefFoundError e) {
            INITIALIZATION_STATE = 2;
            String message = e.getMessage();
            if (!(message == null || message.indexOf("org/slf4j/impl/StaticLoggerBinder") == -1)) {
                Util.reportFailure("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                Util.reportFailure("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
            }
            throw e;
        } catch (Exception e2) {
            INITIALIZATION_STATE = 2;
            Util.reportFailure("Failed to instantiate logger [" + getSingleton().getLoggerFactoryClassStr() + "]", e2);
        }
    }

    private static final void emitSubstitureLoggerWarning() {
        List loggerNameList = TEMP_FACTORY.getLoggerNameList();
        if (loggerNameList.size() != 0) {
            Util.reportFailure("The following loggers will not work becasue they were created");
            Util.reportFailure("during the default configuration phase of the underlying logging system.");
            Util.reportFailure("See also http://www.slf4j.org/codes.html#substituteLogger");
            for (int i = 0; i < loggerNameList.size(); i++) {
                Util.reportFailure((String) loggerNameList.get(i));
            }
        }
    }

    private static final void versionSanityCheck() {
        try {
            String str = StaticLoggerBinder.REQUESTED_API_VERSION;
            boolean z = false;
            for (int i = 0; i < API_COMPATIBILITY_LIST.length; i++) {
                if (API_COMPATIBILITY_LIST[i].equals(str)) {
                    z = true;
                }
            }
            if (!z) {
                Util.reportFailure("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(API_COMPATIBILITY_LIST).toString());
                Util.reportFailure("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
            }
        } catch (NoSuchFieldError e) {
        } catch (Throwable th) {
            Util.reportFailure("Unexpected problem occured during version sanity check", th);
        }
    }

    private static void singleImplementationSanityCheck() {
        try {
            Enumeration<URL> resources = LoggerFactory.class.getClassLoader().getResources(STATIC_LOGGER_BINDER_PATH);
            ArrayList arrayList = new ArrayList();
            while (resources.hasMoreElements()) {
                arrayList.add(resources.nextElement());
            }
            if (arrayList.size() > 1) {
                Util.reportFailure("Class path contains multiple SLF4J bindings.");
                for (int i = 0; i < arrayList.size(); i++) {
                    Util.reportFailure("Found binding in [" + arrayList.get(i) + "]");
                }
                Util.reportFailure("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
            }
        } catch (IOException e) {
            Util.reportFailure("Error getting resources from path", e);
        }
    }

    private static final StaticLoggerBinder getSingleton() {
        return StaticLoggerBinder.getSingleton();
    }

    public static Logger getLogger(String str) {
        return getILoggerFactory().getLogger(str);
    }

    public static Logger getLogger(Class cls) {
        return getLogger(cls.getName());
    }

    public static ILoggerFactory getILoggerFactory() {
        if (INITIALIZATION_STATE == 0) {
            INITIALIZATION_STATE = 1;
            performInitialization();
        }
        switch (INITIALIZATION_STATE) {
            case 1:
                return TEMP_FACTORY;
            case 2:
                throw new IllegalStateException("org.slf4j.LoggerFactory could not be successfully initialized. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
            case 3:
                return getSingleton().getLoggerFactory();
            default:
                throw new IllegalStateException("Unreachable code");
        }
    }
}

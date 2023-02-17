package com.ibm.icu.text;

import com.ibm.icu.impl.ICUConfig;
import com.ibm.icu.util.ULocale;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
public abstract class LocaleDisplayNames {
    private static final Method FACTORY_DIALECTHANDLING;
    private static final Method FACTORY_DISPLAYCONTEXT;

    public enum DialectHandling {
        STANDARD_NAMES,
        DIALECT_NAMES
    }

    public abstract String localeDisplayName(ULocale uLocale);

    public abstract String regionDisplayName(String str);

    public static LocaleDisplayNames getInstance(ULocale uLocale) {
        return getInstance(uLocale, DialectHandling.STANDARD_NAMES);
    }

    public static LocaleDisplayNames getInstance(ULocale uLocale, DialectHandling dialectHandling) {
        LocaleDisplayNames localeDisplayNames = null;
        if (FACTORY_DIALECTHANDLING != null) {
            try {
                localeDisplayNames = (LocaleDisplayNames) FACTORY_DIALECTHANDLING.invoke(null, uLocale, dialectHandling);
            } catch (IllegalAccessException | InvocationTargetException e) {
            }
        }
        if (localeDisplayNames == null) {
            return new LastResortLocaleDisplayNames(uLocale, dialectHandling);
        }
        return localeDisplayNames;
    }

    @Deprecated
    protected LocaleDisplayNames() {
    }

    static {
        Method method = null;
        Method method2 = null;
        try {
            Class<?> cls = Class.forName(ICUConfig.get("com.ibm.icu.text.LocaleDisplayNames.impl", "com.ibm.icu.impl.LocaleDisplayNamesImpl"));
            try {
                method = cls.getMethod("getInstance", ULocale.class, DialectHandling.class);
            } catch (NoSuchMethodException e) {
            }
            try {
                method2 = cls.getMethod("getInstance", ULocale.class, DisplayContext[].class);
            } catch (NoSuchMethodException e2) {
            }
        } catch (ClassNotFoundException e3) {
        }
        FACTORY_DIALECTHANDLING = method;
        FACTORY_DISPLAYCONTEXT = method2;
    }

    /* access modifiers changed from: package-private */
    public static class LastResortLocaleDisplayNames extends LocaleDisplayNames {
        private DisplayContext[] contexts;
        private ULocale locale;

        private LastResortLocaleDisplayNames(ULocale uLocale, DialectHandling dialectHandling) {
            this.locale = uLocale;
            this.contexts = new DisplayContext[]{dialectHandling == DialectHandling.DIALECT_NAMES ? DisplayContext.DIALECT_NAMES : DisplayContext.STANDARD_NAMES};
        }

        @Override // com.ibm.icu.text.LocaleDisplayNames
        public String localeDisplayName(ULocale uLocale) {
            return uLocale.getName();
        }

        @Override // com.ibm.icu.text.LocaleDisplayNames
        public String regionDisplayName(String str) {
            return str;
        }
    }
}

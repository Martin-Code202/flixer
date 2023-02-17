package com.ibm.icu.impl;

import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
public final class ResourceBundleWrapper extends UResourceBundle {
    private static CacheBase<String, ResourceBundleWrapper, Loader> BUNDLE_CACHE = new SoftCache<String, ResourceBundleWrapper, Loader>() { // from class: com.ibm.icu.impl.ResourceBundleWrapper.1
        /* access modifiers changed from: protected */
        public ResourceBundleWrapper createInstance(String str, Loader loader) {
            return loader.load();
        }
    };
    private static final boolean DEBUG = ICUDebug.enabled("resourceBundleWrapper");
    private String baseName;
    private ResourceBundle bundle;
    private List<String> keys;
    private String localeID;

    /* access modifiers changed from: package-private */
    public static abstract class Loader {
        /* access modifiers changed from: package-private */
        public abstract ResourceBundleWrapper load();

        private Loader() {
        }
    }

    private ResourceBundleWrapper(ResourceBundle resourceBundle) {
        this.bundle = null;
        this.localeID = null;
        this.baseName = null;
        this.keys = null;
        this.bundle = resourceBundle;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.UResourceBundle, java.util.ResourceBundle
    public Object handleGetObject(String str) {
        ResourceBundleWrapper resourceBundleWrapper = this;
        Object obj = null;
        while (true) {
            if (resourceBundleWrapper == null) {
                break;
            }
            try {
                obj = resourceBundleWrapper.bundle.getObject(str);
                break;
            } catch (MissingResourceException e) {
                resourceBundleWrapper = (ResourceBundleWrapper) resourceBundleWrapper.getParent();
            }
        }
        if (obj != null) {
            return obj;
        }
        throw new MissingResourceException("Can't find resource for bundle " + this.baseName + ", key " + str, getClass().getName(), str);
    }

    @Override // com.ibm.icu.util.UResourceBundle, java.util.ResourceBundle
    public Enumeration<String> getKeys() {
        return Collections.enumeration(this.keys);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void initKeysVector() {
        this.keys = new ArrayList();
        for (ResourceBundleWrapper resourceBundleWrapper = this; resourceBundleWrapper != null; resourceBundleWrapper = (ResourceBundleWrapper) resourceBundleWrapper.getParent()) {
            Enumeration<String> keys2 = resourceBundleWrapper.bundle.getKeys();
            while (keys2.hasMoreElements()) {
                String nextElement = keys2.nextElement();
                if (!this.keys.contains(nextElement)) {
                    this.keys.add(nextElement);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.UResourceBundle
    public String getLocaleID() {
        return this.localeID;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.UResourceBundle
    public String getBaseName() {
        return this.bundle.getClass().getName().replace('.', '/');
    }

    @Override // com.ibm.icu.util.UResourceBundle
    public ULocale getULocale() {
        return new ULocale(this.localeID);
    }

    @Override // com.ibm.icu.util.UResourceBundle
    public UResourceBundle getParent() {
        return (UResourceBundle) this.parent;
    }

    public static ResourceBundleWrapper getBundleInstance(String str, String str2, ClassLoader classLoader, boolean z) {
        ResourceBundleWrapper resourceBundleWrapper;
        if (classLoader == null) {
            classLoader = ClassLoaderUtil.getClassLoader();
        }
        if (z) {
            resourceBundleWrapper = instantiateBundle(str, str2, null, classLoader, z);
        } else {
            resourceBundleWrapper = instantiateBundle(str, str2, ULocale.getDefault().getBaseName(), classLoader, z);
        }
        if (resourceBundleWrapper != null) {
            return resourceBundleWrapper;
        }
        String str3 = "_";
        if (str.indexOf(47) >= 0) {
            str3 = "/";
        }
        throw new MissingResourceException("Could not find the bundle " + str + str3 + str2, "", "");
    }

    /* access modifiers changed from: private */
    public static boolean localeIDStartsWithLangSubtag(String str, String str2) {
        return str.startsWith(str2) && (str.length() == str2.length() || str.charAt(str2.length()) == '_');
    }

    /* access modifiers changed from: private */
    public static ResourceBundleWrapper instantiateBundle(final String str, final String str2, final String str3, final ClassLoader classLoader, final boolean z) {
        final String str4 = str2.isEmpty() ? str : str + '_' + str2;
        return BUNDLE_CACHE.getInstance(z ? str4 : str4 + '#' + str3, new Loader() { // from class: com.ibm.icu.impl.ResourceBundleWrapper.2
            @Override // com.ibm.icu.impl.ResourceBundleWrapper.Loader
            public ResourceBundleWrapper load() {
                ResourceBundleWrapper resourceBundleWrapper = null;
                int lastIndexOf = str2.lastIndexOf(95);
                boolean z2 = false;
                boolean z3 = false;
                if (lastIndexOf != -1) {
                    resourceBundleWrapper = ResourceBundleWrapper.instantiateBundle(str, str2.substring(0, lastIndexOf), str3, classLoader, z);
                } else if (!str2.isEmpty()) {
                    resourceBundleWrapper = ResourceBundleWrapper.instantiateBundle(str, "", str3, classLoader, z);
                    z3 = true;
                }
                ResourceBundleWrapper resourceBundleWrapper2 = null;
                try {
                    resourceBundleWrapper2 = new ResourceBundleWrapper((ResourceBundle) classLoader.loadClass(str4).asSubclass(ResourceBundle.class).newInstance());
                    if (resourceBundleWrapper != null) {
                        resourceBundleWrapper2.setParent(resourceBundleWrapper);
                    }
                    resourceBundleWrapper2.baseName = str;
                    resourceBundleWrapper2.localeID = str2;
                } catch (ClassNotFoundException e) {
                    z2 = true;
                } catch (NoClassDefFoundError e2) {
                    z2 = true;
                } catch (Exception e3) {
                    if (ResourceBundleWrapper.DEBUG) {
                        System.out.println("failure");
                    }
                    if (ResourceBundleWrapper.DEBUG) {
                        System.out.println(e3);
                    }
                }
                if (z2) {
                    try {
                        final String str5 = str4.replace('.', '/') + ".properties";
                        InputStream inputStream = (InputStream) AccessController.doPrivileged(new PrivilegedAction<InputStream>() { // from class: com.ibm.icu.impl.ResourceBundleWrapper.2.1
                            @Override // java.security.PrivilegedAction
                            public InputStream run() {
                                return classLoader.getResourceAsStream(str5);
                            }
                        });
                        if (inputStream != null) {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                            try {
                                resourceBundleWrapper2 = new ResourceBundleWrapper(new PropertyResourceBundle(bufferedInputStream));
                                if (resourceBundleWrapper != null) {
                                    resourceBundleWrapper2.setParent(resourceBundleWrapper);
                                }
                                resourceBundleWrapper2.baseName = str;
                                resourceBundleWrapper2.localeID = str2;
                                try {
                                    bufferedInputStream.close();
                                } catch (Exception e4) {
                                }
                            } catch (Exception e5) {
                                try {
                                    bufferedInputStream.close();
                                } catch (Exception e6) {
                                }
                            } catch (Throwable th) {
                                try {
                                    bufferedInputStream.close();
                                } catch (Exception e7) {
                                }
                                throw th;
                            }
                        }
                        if (resourceBundleWrapper2 == null && !z && !str2.isEmpty() && str2.indexOf(95) < 0 && !ResourceBundleWrapper.localeIDStartsWithLangSubtag(str3, str2)) {
                            resourceBundleWrapper2 = ResourceBundleWrapper.instantiateBundle(str, str3, str3, classLoader, z);
                        }
                        if (resourceBundleWrapper2 == null && (!z3 || !z)) {
                            resourceBundleWrapper2 = resourceBundleWrapper;
                        }
                    } catch (Exception e8) {
                        if (ResourceBundleWrapper.DEBUG) {
                            System.out.println("failure");
                        }
                        if (ResourceBundleWrapper.DEBUG) {
                            System.out.println(e8);
                        }
                    }
                }
                if (resourceBundleWrapper2 != null) {
                    resourceBundleWrapper2.initKeysVector();
                } else if (ResourceBundleWrapper.DEBUG) {
                    System.out.println("Returning null for " + str + "_" + str2);
                }
                return resourceBundleWrapper2;
            }
        });
    }
}

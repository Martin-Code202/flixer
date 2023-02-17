package com.ibm.icu.util;

import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.ICUResourceBundleReader;
import com.ibm.icu.impl.ResourceBundleWrapper;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
public abstract class UResourceBundle extends ResourceBundle {
    private static Map<String, RootType> ROOT_CACHE = new ConcurrentHashMap();

    /* access modifiers changed from: package-private */
    public enum RootType {
        MISSING,
        ICU,
        JAVA
    }

    public abstract String getBaseName();

    public abstract String getLocaleID();

    public abstract UResourceBundle getParent();

    public abstract ULocale getULocale();

    public static UResourceBundle getBundleInstance(String str, String str2) {
        return getBundleInstance(str, str2, ICUResourceBundle.ICU_DATA_CLASS_LOADER, false);
    }

    public static UResourceBundle getBundleInstance(String str, String str2, ClassLoader classLoader) {
        return getBundleInstance(str, str2, classLoader, false);
    }

    protected static UResourceBundle getBundleInstance(String str, String str2, ClassLoader classLoader, boolean z) {
        return instantiateBundle(str, str2, classLoader, z);
    }

    public static UResourceBundle getBundleInstance(String str) {
        if (str == null) {
            str = "com/ibm/icu/impl/data/icudt59b";
        }
        return getBundleInstance(str, ULocale.getDefault().getBaseName(), ICUResourceBundle.ICU_DATA_CLASS_LOADER, false);
    }

    public static UResourceBundle getBundleInstance(String str, ULocale uLocale) {
        if (str == null) {
            str = "com/ibm/icu/impl/data/icudt59b";
        }
        if (uLocale == null) {
            uLocale = ULocale.getDefault();
        }
        return getBundleInstance(str, uLocale.getBaseName(), ICUResourceBundle.ICU_DATA_CLASS_LOADER, false);
    }

    public static UResourceBundle getBundleInstance(String str, ULocale uLocale, ClassLoader classLoader) {
        if (str == null) {
            str = "com/ibm/icu/impl/data/icudt59b";
        }
        if (uLocale == null) {
            uLocale = ULocale.getDefault();
        }
        return getBundleInstance(str, uLocale.getBaseName(), classLoader, false);
    }

    @Override // java.util.ResourceBundle
    public Locale getLocale() {
        return getULocale().toLocale();
    }

    private static RootType getRootType(String str, ClassLoader classLoader) {
        RootType rootType = ROOT_CACHE.get(str);
        if (rootType == null) {
            String str2 = str.indexOf(46) == -1 ? "root" : "";
            try {
                ICUResourceBundle.getBundleInstance(str, str2, classLoader, true);
                rootType = RootType.ICU;
            } catch (MissingResourceException e) {
                try {
                    ResourceBundleWrapper.getBundleInstance(str, str2, classLoader, true);
                    rootType = RootType.JAVA;
                } catch (MissingResourceException e2) {
                    rootType = RootType.MISSING;
                }
            }
            ROOT_CACHE.put(str, rootType);
        }
        return rootType;
    }

    private static void setRootType(String str, RootType rootType) {
        ROOT_CACHE.put(str, rootType);
    }

    protected static UResourceBundle instantiateBundle(String str, String str2, ClassLoader classLoader, boolean z) {
        switch (getRootType(str, classLoader)) {
            case ICU:
                return ICUResourceBundle.getBundleInstance(str, str2, classLoader, z);
            case JAVA:
                return ResourceBundleWrapper.getBundleInstance(str, str2, classLoader, z);
            case MISSING:
            default:
                try {
                    ICUResourceBundle bundleInstance = ICUResourceBundle.getBundleInstance(str, str2, classLoader, z);
                    setRootType(str, RootType.ICU);
                    return bundleInstance;
                } catch (MissingResourceException e) {
                    ResourceBundleWrapper bundleInstance2 = ResourceBundleWrapper.getBundleInstance(str, str2, classLoader, z);
                    setRootType(str, RootType.JAVA);
                    return bundleInstance2;
                }
        }
    }

    public ByteBuffer getBinary() {
        throw new UResourceTypeMismatchException("");
    }

    public String getString() {
        throw new UResourceTypeMismatchException("");
    }

    public String[] getStringArray() {
        throw new UResourceTypeMismatchException("");
    }

    public byte[] getBinary(byte[] bArr) {
        throw new UResourceTypeMismatchException("");
    }

    public int[] getIntVector() {
        throw new UResourceTypeMismatchException("");
    }

    public int getInt() {
        throw new UResourceTypeMismatchException("");
    }

    public UResourceBundle get(String str) {
        UResourceBundle findTopLevel = findTopLevel(str);
        if (findTopLevel != null) {
            return findTopLevel;
        }
        throw new MissingResourceException("Can't find resource for bundle " + ICUResourceBundleReader.getFullName(getBaseName(), getLocaleID()) + ", key " + str, getClass().getName(), str);
    }

    @Deprecated
    public UResourceBundle findTopLevel(String str) {
        for (UResourceBundle uResourceBundle = this; uResourceBundle != null; uResourceBundle = uResourceBundle.getParent()) {
            UResourceBundle handleGet = uResourceBundle.handleGet(str, (HashMap<String, String>) null, this);
            if (handleGet != null) {
                return handleGet;
            }
        }
        return null;
    }

    public String getString(int i) {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) get(i);
        if (iCUResourceBundle.getType() == 0) {
            return iCUResourceBundle.getString();
        }
        throw new UResourceTypeMismatchException("");
    }

    public UResourceBundle get(int i) {
        UResourceBundle handleGet = handleGet(i, (HashMap<String, String>) null, this);
        if (handleGet == null) {
            handleGet = getParent();
            if (handleGet != null) {
                handleGet = handleGet.get(i);
            }
            if (handleGet == null) {
                throw new MissingResourceException("Can't find resource for bundle " + getClass().getName() + ", key " + getKey(), getClass().getName(), getKey());
            }
        }
        return handleGet;
    }

    @Override // java.util.ResourceBundle
    public Enumeration<String> getKeys() {
        return Collections.enumeration(keySet());
    }

    @Override // java.util.ResourceBundle
    @Deprecated
    public Set<String> keySet() {
        TreeSet treeSet;
        Set<String> set = null;
        ICUResourceBundle iCUResourceBundle = null;
        if (isTopLevelResource() && (this instanceof ICUResourceBundle)) {
            iCUResourceBundle = (ICUResourceBundle) this;
            set = iCUResourceBundle.getTopLevelKeySet();
        }
        if (set == null) {
            if (!isTopLevelResource()) {
                return handleKeySet();
            }
            if (this.parent == null) {
                treeSet = new TreeSet();
            } else if (this.parent instanceof UResourceBundle) {
                treeSet = new TreeSet(((UResourceBundle) this.parent).keySet());
            } else {
                treeSet = new TreeSet();
                Enumeration<String> keys = this.parent.getKeys();
                while (keys.hasMoreElements()) {
                    treeSet.add(keys.nextElement());
                }
            }
            treeSet.addAll(handleKeySet());
            set = Collections.unmodifiableSet(treeSet);
            if (iCUResourceBundle != null) {
                iCUResourceBundle.setTopLevelKeySet(set);
            }
        }
        return set;
    }

    /* access modifiers changed from: protected */
    @Override // java.util.ResourceBundle
    @Deprecated
    public Set<String> handleKeySet() {
        return Collections.emptySet();
    }

    public int getSize() {
        return 1;
    }

    public int getType() {
        return -1;
    }

    public UResourceBundleIterator getIterator() {
        return new UResourceBundleIterator(this);
    }

    public String getKey() {
        return null;
    }

    public UResourceBundle handleGet(String str, HashMap<String, String> hashMap, UResourceBundle uResourceBundle) {
        return null;
    }

    public UResourceBundle handleGet(int i, HashMap<String, String> hashMap, UResourceBundle uResourceBundle) {
        return null;
    }

    public String[] handleGetStringArray() {
        return null;
    }

    @Override // java.util.ResourceBundle
    public Object handleGetObject(String str) {
        return handleGetObjectImpl(str, this);
    }

    private Object handleGetObjectImpl(String str, UResourceBundle uResourceBundle) {
        Object resolveObject = resolveObject(str, uResourceBundle);
        if (resolveObject == null) {
            UResourceBundle parent = getParent();
            if (parent != null) {
                resolveObject = parent.handleGetObjectImpl(str, uResourceBundle);
            }
            if (resolveObject == null) {
                throw new MissingResourceException("Can't find resource for bundle " + getClass().getName() + ", key " + str, getClass().getName(), str);
            }
        }
        return resolveObject;
    }

    private Object resolveObject(String str, UResourceBundle uResourceBundle) {
        if (getType() == 0) {
            return getString();
        }
        UResourceBundle handleGet = handleGet(str, (HashMap<String, String>) null, uResourceBundle);
        if (handleGet != null) {
            if (handleGet.getType() == 0) {
                return handleGet.getString();
            }
            try {
                if (handleGet.getType() == 8) {
                    return handleGet.handleGetStringArray();
                }
            } catch (UResourceTypeMismatchException e) {
                return handleGet;
            }
        }
        return handleGet;
    }

    @Deprecated
    public boolean isTopLevelResource() {
        return true;
    }
}

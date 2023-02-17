package com.ibm.icu.impl;

import com.ibm.icu.impl.ICUResourceBundleImpl;
import com.ibm.icu.impl.ICUResourceBundleReader;
import com.ibm.icu.impl.URLHandler;
import com.ibm.icu.impl.UResource;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import com.ibm.icu.util.UResourceBundleIterator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;
public class ICUResourceBundle extends UResourceBundle {
    static final /* synthetic */ boolean $assertionsDisabled = (!ICUResourceBundle.class.desiredAssertionStatus());
    private static CacheBase<String, ICUResourceBundle, Loader> BUNDLE_CACHE = new SoftCache<String, ICUResourceBundle, Loader>() { // from class: com.ibm.icu.impl.ICUResourceBundle.1
        /* access modifiers changed from: protected */
        public ICUResourceBundle createInstance(String str, Loader loader) {
            return loader.load();
        }
    };
    private static final boolean DEBUG = ICUDebug.enabled("localedata");
    private static CacheBase<String, AvailEntry, ClassLoader> GET_AVAILABLE_CACHE = new SoftCache<String, AvailEntry, ClassLoader>() { // from class: com.ibm.icu.impl.ICUResourceBundle.3
        /* access modifiers changed from: protected */
        public AvailEntry createInstance(String str, ClassLoader classLoader) {
            return new AvailEntry(str, classLoader);
        }
    };
    public static final ClassLoader ICU_DATA_CLASS_LOADER = ClassLoaderUtil.getClassLoader(ICUData.class);
    private ICUResourceBundle container;
    protected String key;
    WholeBundle wholeBundle;

    public enum OpenType {
        LOCALE_DEFAULT_ROOT,
        LOCALE_ROOT,
        LOCALE_ONLY,
        DIRECT
    }

    /* access modifiers changed from: protected */
    public static final class WholeBundle {
        String baseName;
        ClassLoader loader;
        String localeID;
        ICUResourceBundleReader reader;
        Set<String> topLevelKeys;
        ULocale ulocale;

        WholeBundle(String str, String str2, ClassLoader classLoader, ICUResourceBundleReader iCUResourceBundleReader) {
            this.baseName = str;
            this.localeID = str2;
            this.ulocale = new ULocale(str2);
            this.loader = classLoader;
            this.reader = iCUResourceBundleReader;
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class Loader {
        /* access modifiers changed from: package-private */
        public abstract ICUResourceBundle load();

        private Loader() {
        }
    }

    public ICUResourceBundle getWithFallback(String str) {
        ICUResourceBundle findResourceWithFallback = findResourceWithFallback(str, this, null);
        if (findResourceWithFallback == null) {
            throw new MissingResourceException("Can't find resource for bundle " + getClass().getName() + ", key " + getType(), str, getKey());
        } else if (findResourceWithFallback.getType() != 0 || !findResourceWithFallback.getString().equals("∅∅∅")) {
            return findResourceWithFallback;
        } else {
            throw new MissingResourceException("Encountered NO_INHERITANCE_MARKER", str, getKey());
        }
    }

    public ICUResourceBundle at(int i) {
        return (ICUResourceBundle) handleGet(i, (HashMap<String, String>) null, this);
    }

    public ICUResourceBundle at(String str) {
        if (this instanceof ICUResourceBundleImpl.ResourceTable) {
            return (ICUResourceBundle) handleGet(str, (HashMap<String, String>) null, this);
        }
        return null;
    }

    @Override // com.ibm.icu.util.UResourceBundle
    public ICUResourceBundle findTopLevel(String str) {
        return (ICUResourceBundle) super.findTopLevel(str);
    }

    public ICUResourceBundle findWithFallback(String str) {
        return findResourceWithFallback(str, this, null);
    }

    public String findStringWithFallback(String str) {
        return findStringWithFallback(str, this, null);
    }

    public String getStringWithFallback(String str) {
        String findStringWithFallback = findStringWithFallback(str, this, null);
        if (findStringWithFallback == null) {
            throw new MissingResourceException("Can't find resource for bundle " + getClass().getName() + ", key " + getType(), str, getKey());
        } else if (!findStringWithFallback.equals("∅∅∅")) {
            return findStringWithFallback;
        } else {
            throw new MissingResourceException("Encountered NO_INHERITANCE_MARKER", str, getKey());
        }
    }

    public void getAllItemsWithFallback(String str, UResource.Sink sink) {
        ICUResourceBundle iCUResourceBundle;
        int countPathKeys = countPathKeys(str);
        if (countPathKeys == 0) {
            iCUResourceBundle = this;
        } else {
            int resDepth = getResDepth();
            String[] strArr = new String[(resDepth + countPathKeys)];
            getResPathKeys(str, countPathKeys, strArr, resDepth);
            iCUResourceBundle = findResourceWithFallback(strArr, resDepth, this, null);
            if (iCUResourceBundle == null) {
                throw new MissingResourceException("Can't find resource for bundle " + getClass().getName() + ", key " + getType(), str, getKey());
            }
        }
        iCUResourceBundle.getAllItemsWithFallback(new UResource.Key(), new ICUResourceBundleReader.ReaderValue(), sink);
    }

    private void getAllItemsWithFallback(UResource.Key key2, ICUResourceBundleReader.ReaderValue readerValue, UResource.Sink sink) {
        ICUResourceBundle iCUResourceBundle;
        ICUResourceBundleImpl iCUResourceBundleImpl = (ICUResourceBundleImpl) this;
        readerValue.reader = iCUResourceBundleImpl.wholeBundle.reader;
        readerValue.res = iCUResourceBundleImpl.getResource();
        key2.setString(this.key != null ? this.key : "");
        sink.put(key2, readerValue, this.parent == null);
        if (this.parent != null) {
            ICUResourceBundle iCUResourceBundle2 = (ICUResourceBundle) this.parent;
            int resDepth = getResDepth();
            if (resDepth == 0) {
                iCUResourceBundle = iCUResourceBundle2;
            } else {
                String[] strArr = new String[resDepth];
                getResPathKeys(strArr, resDepth);
                iCUResourceBundle = findResourceWithFallback(strArr, 0, iCUResourceBundle2, null);
            }
            if (iCUResourceBundle != null) {
                iCUResourceBundle.getAllItemsWithFallback(key2, readerValue, sink);
            }
        }
    }

    public static Set<String> getFullLocaleNameSet(String str, ClassLoader classLoader) {
        return getAvailEntry(str, classLoader).getFullLocaleNameSet();
    }

    @Override // com.ibm.icu.util.UResourceBundle, java.util.ResourceBundle
    public Locale getLocale() {
        return getULocale().toLocale();
    }

    private static final void addLocaleIDsFromIndexBundle(String str, ClassLoader classLoader, Set<String> set) {
        try {
            UResourceBundleIterator iterator = ((ICUResourceBundle) ((ICUResourceBundle) UResourceBundle.instantiateBundle(str, "res_index", classLoader, true)).get("InstalledLocales")).getIterator();
            iterator.reset();
            while (iterator.hasNext()) {
                set.add(iterator.next().getKey());
            }
        } catch (MissingResourceException e) {
            if (DEBUG) {
                System.out.println("couldn't find " + str + "/res_index.res");
                Thread.dumpStack();
            }
        }
    }

    private static final void addBundleBaseNamesFromClassLoader(final String str, final ClassLoader classLoader, final Set<String> set) {
        AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: com.ibm.icu.impl.ICUResourceBundle.2
            @Override // java.security.PrivilegedAction
            public Void run() {
                try {
                    Enumeration<URL> resources = classLoader.getResources(str);
                    if (resources == null) {
                        return null;
                    }
                    AnonymousClass1 r4 = new URLHandler.URLVisitor() { // from class: com.ibm.icu.impl.ICUResourceBundle.2.1
                        @Override // com.ibm.icu.impl.URLHandler.URLVisitor
                        public void visit(String str2) {
                            if (str2.endsWith(".res")) {
                                set.add(str2.substring(0, str2.length() - 4));
                            }
                        }
                    };
                    while (resources.hasMoreElements()) {
                        URL nextElement = resources.nextElement();
                        URLHandler uRLHandler = URLHandler.get(nextElement);
                        if (uRLHandler != null) {
                            uRLHandler.guide(r4, false);
                        } else if (ICUResourceBundle.DEBUG) {
                            System.out.println("handler for " + nextElement + " is null");
                        }
                    }
                    return null;
                } catch (IOException e) {
                    if (!ICUResourceBundle.DEBUG) {
                        return null;
                    }
                    System.out.println("ouch: " + e.getMessage());
                    return null;
                }
            }
        });
    }

    private static void addLocaleIDsFromListFile(String str, ClassLoader classLoader, Set<String> set) {
        try {
            InputStream resourceAsStream = classLoader.getResourceAsStream(str + "fullLocaleNames.lst");
            if (resourceAsStream != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, "ASCII"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            return;
                        }
                        if (readLine.length() != 0 && !readLine.startsWith("#")) {
                            set.add(readLine);
                        }
                    } finally {
                        bufferedReader.close();
                    }
                }
            }
        } catch (IOException e) {
        }
    }

    /* access modifiers changed from: private */
    public static Set<String> createFullLocaleNameSet(String str, ClassLoader classLoader) {
        String str2;
        String str3 = str.endsWith("/") ? str : str + "/";
        HashSet hashSet = new HashSet();
        if (!ICUConfig.get("com.ibm.icu.impl.ICUResourceBundle.skipRuntimeLocaleResourceScan", "false").equalsIgnoreCase("true")) {
            addBundleBaseNamesFromClassLoader(str3, classLoader, hashSet);
            if (str.startsWith("com/ibm/icu/impl/data/icudt59b")) {
                if (str.length() == "com/ibm/icu/impl/data/icudt59b".length()) {
                    str2 = "";
                } else if (str.charAt("com/ibm/icu/impl/data/icudt59b".length()) == '/') {
                    str2 = str.substring("com/ibm/icu/impl/data/icudt59b".length() + 1);
                } else {
                    str2 = null;
                }
                if (str2 != null) {
                    ICUBinary.addBaseNamesInFileFolder(str2, ".res", hashSet);
                }
            }
            hashSet.remove("res_index");
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                String str4 = (String) it.next();
                if (str4.length() == 1 || str4.length() > 3) {
                    if (str4.indexOf(95) < 0) {
                        it.remove();
                    }
                }
            }
        }
        if (hashSet.isEmpty()) {
            if (DEBUG) {
                System.out.println("unable to enumerate data files in " + str);
            }
            addLocaleIDsFromListFile(str3, classLoader, hashSet);
        }
        if (hashSet.isEmpty()) {
            addLocaleIDsFromIndexBundle(str, classLoader, hashSet);
        }
        hashSet.remove("root");
        hashSet.add(ULocale.ROOT.toString());
        return Collections.unmodifiableSet(hashSet);
    }

    /* access modifiers changed from: package-private */
    public static final class AvailEntry {
        private volatile Set<String> fullNameSet;
        private ClassLoader loader;
        private String prefix;

        AvailEntry(String str, ClassLoader classLoader) {
            this.prefix = str;
            this.loader = classLoader;
        }

        /* access modifiers changed from: package-private */
        public Set<String> getFullLocaleNameSet() {
            if (this.fullNameSet == null) {
                synchronized (this) {
                    if (this.fullNameSet == null) {
                        this.fullNameSet = ICUResourceBundle.createFullLocaleNameSet(this.prefix, this.loader);
                    }
                }
            }
            return this.fullNameSet;
        }
    }

    private static AvailEntry getAvailEntry(String str, ClassLoader classLoader) {
        return GET_AVAILABLE_CACHE.getInstance(str, classLoader);
    }

    private static final ICUResourceBundle findResourceWithFallback(String str, UResourceBundle uResourceBundle, UResourceBundle uResourceBundle2) {
        if (str.length() == 0) {
            return null;
        }
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) uResourceBundle;
        int resDepth = iCUResourceBundle.getResDepth();
        int countPathKeys = countPathKeys(str);
        if ($assertionsDisabled || countPathKeys > 0) {
            String[] strArr = new String[(resDepth + countPathKeys)];
            getResPathKeys(str, countPathKeys, strArr, resDepth);
            return findResourceWithFallback(strArr, resDepth, iCUResourceBundle, uResourceBundle2);
        }
        throw new AssertionError();
    }

    private static final ICUResourceBundle findResourceWithFallback(String[] strArr, int i, ICUResourceBundle iCUResourceBundle, UResourceBundle uResourceBundle) {
        if (uResourceBundle == null) {
            uResourceBundle = iCUResourceBundle;
        }
        while (true) {
            i++;
            ICUResourceBundle iCUResourceBundle2 = (ICUResourceBundle) iCUResourceBundle.handleGet(strArr[i], (HashMap<String, String>) null, uResourceBundle);
            if (iCUResourceBundle2 == null) {
                int i2 = i - 1;
                ICUResourceBundle parent = iCUResourceBundle.getParent();
                if (parent == null) {
                    return null;
                }
                int resDepth = iCUResourceBundle.getResDepth();
                if (i2 != resDepth) {
                    String[] strArr2 = new String[((strArr.length - i2) + resDepth)];
                    System.arraycopy(strArr, i2, strArr2, resDepth, strArr.length - i2);
                    strArr = strArr2;
                }
                iCUResourceBundle.getResPathKeys(strArr, resDepth);
                iCUResourceBundle = parent;
                i = 0;
            } else if (i == strArr.length) {
                return iCUResourceBundle2;
            } else {
                iCUResourceBundle = iCUResourceBundle2;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00d6 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.lang.String findStringWithFallback(java.lang.String r18, com.ibm.icu.util.UResourceBundle r19, com.ibm.icu.util.UResourceBundle r20) {
        /*
        // Method dump skipped, instructions count: 228
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.ICUResourceBundle.findStringWithFallback(java.lang.String, com.ibm.icu.util.UResourceBundle, com.ibm.icu.util.UResourceBundle):java.lang.String");
    }

    private int getResDepth() {
        if (this.container == null) {
            return 0;
        }
        return this.container.getResDepth() + 1;
    }

    private void getResPathKeys(String[] strArr, int i) {
        ICUResourceBundle iCUResourceBundle = this;
        while (i > 0) {
            i--;
            strArr[i] = iCUResourceBundle.key;
            iCUResourceBundle = iCUResourceBundle.container;
            if (!$assertionsDisabled) {
                if ((i == 0) != (iCUResourceBundle.container == null)) {
                    throw new AssertionError();
                }
            }
        }
    }

    private static int countPathKeys(String str) {
        if (str.isEmpty()) {
            return 0;
        }
        int i = 1;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == '/') {
                i++;
            }
        }
        return i;
    }

    private static void getResPathKeys(String str, int i, String[] strArr, int i2) {
        if (i != 0) {
            if (i == 1) {
                strArr[i2] = str;
                return;
            }
            int i3 = 0;
            while (true) {
                int indexOf = str.indexOf(47, i3);
                if ($assertionsDisabled || indexOf >= i3) {
                    i2++;
                    strArr[i2] = str.substring(i3, indexOf);
                    if (i != 2) {
                        i3 = indexOf + 1;
                        i--;
                    } else if ($assertionsDisabled || str.indexOf(47, indexOf + 1) < 0) {
                        strArr[i2] = str.substring(indexOf + 1);
                        return;
                    } else {
                        throw new AssertionError();
                    }
                } else {
                    throw new AssertionError();
                }
            }
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ICUResourceBundle)) {
            return false;
        }
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) obj;
        if (!getBaseName().equals(iCUResourceBundle.getBaseName()) || !getLocaleID().equals(iCUResourceBundle.getLocaleID())) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        if ($assertionsDisabled) {
            return 42;
        }
        throw new AssertionError("hashCode not designed");
    }

    public static ICUResourceBundle getBundleInstance(String str, String str2, ClassLoader classLoader, boolean z) {
        return getBundleInstance(str, str2, classLoader, z ? OpenType.DIRECT : OpenType.LOCALE_DEFAULT_ROOT);
    }

    public static ICUResourceBundle getBundleInstance(String str, ULocale uLocale, OpenType openType) {
        if (uLocale == null) {
            uLocale = ULocale.getDefault();
        }
        return getBundleInstance(str, uLocale.getBaseName(), ICU_DATA_CLASS_LOADER, openType);
    }

    public static ICUResourceBundle getBundleInstance(String str, String str2, ClassLoader classLoader, OpenType openType) {
        ICUResourceBundle iCUResourceBundle;
        if (str == null) {
            str = "com/ibm/icu/impl/data/icudt59b";
        }
        String baseName = ULocale.getBaseName(str2);
        if (openType == OpenType.LOCALE_DEFAULT_ROOT) {
            iCUResourceBundle = instantiateBundle(str, baseName, ULocale.getDefault().getBaseName(), classLoader, openType);
        } else {
            iCUResourceBundle = instantiateBundle(str, baseName, null, classLoader, openType);
        }
        if (iCUResourceBundle != null) {
            return iCUResourceBundle;
        }
        throw new MissingResourceException("Could not find the bundle " + str + "/" + baseName + ".res", "", "");
    }

    /* access modifiers changed from: private */
    public static boolean localeIDStartsWithLangSubtag(String str, String str2) {
        return str.startsWith(str2) && (str.length() == str2.length() || str.charAt(str2.length()) == '_');
    }

    /* access modifiers changed from: private */
    public static ICUResourceBundle instantiateBundle(final String str, final String str2, final String str3, final ClassLoader classLoader, final OpenType openType) {
        if (!$assertionsDisabled && str2.indexOf(64) >= 0) {
            throw new AssertionError();
        } else if ($assertionsDisabled || str3 == null || str3.indexOf(64) < 0) {
            final String fullName = ICUResourceBundleReader.getFullName(str, str2);
            char ordinal = (char) (openType.ordinal() + 48);
            return BUNDLE_CACHE.getInstance(openType != OpenType.LOCALE_DEFAULT_ROOT ? fullName + '#' + ordinal : fullName + '#' + ordinal + '#' + str3, new Loader() { // from class: com.ibm.icu.impl.ICUResourceBundle.4
                @Override // com.ibm.icu.impl.ICUResourceBundle.Loader
                public ICUResourceBundle load() {
                    if (ICUResourceBundle.DEBUG) {
                        System.out.println("Creating " + fullName);
                    }
                    String str4 = str.indexOf(46) == -1 ? "root" : "";
                    String str5 = str2.isEmpty() ? str4 : str2;
                    ICUResourceBundle createBundle = ICUResourceBundle.createBundle(str, str5, classLoader);
                    if (ICUResourceBundle.DEBUG) {
                        System.out.println("The bundle created is: " + createBundle + " and openType=" + openType + " and bundle.getNoFallback=" + (createBundle != null && createBundle.getNoFallback()));
                    }
                    if (openType == OpenType.DIRECT || (createBundle != null && createBundle.getNoFallback())) {
                        return createBundle;
                    }
                    if (createBundle == null) {
                        int lastIndexOf = str5.lastIndexOf(95);
                        if (lastIndexOf != -1) {
                            return ICUResourceBundle.instantiateBundle(str, str5.substring(0, lastIndexOf), str3, classLoader, openType);
                        } else if (openType == OpenType.LOCALE_DEFAULT_ROOT && !ICUResourceBundle.localeIDStartsWithLangSubtag(str3, str5)) {
                            return ICUResourceBundle.instantiateBundle(str, str3, str3, classLoader, openType);
                        } else {
                            if (openType == OpenType.LOCALE_ONLY || str4.isEmpty()) {
                                return createBundle;
                            }
                            return ICUResourceBundle.createBundle(str, str4, classLoader);
                        }
                    } else {
                        ICUResourceBundle iCUResourceBundle = null;
                        String localeID = createBundle.getLocaleID();
                        int lastIndexOf2 = localeID.lastIndexOf(95);
                        String findString = ((ICUResourceBundleImpl.ResourceTable) createBundle).findString("%%Parent");
                        if (findString != null) {
                            iCUResourceBundle = ICUResourceBundle.instantiateBundle(str, findString, str3, classLoader, openType);
                        } else if (lastIndexOf2 != -1) {
                            iCUResourceBundle = ICUResourceBundle.instantiateBundle(str, localeID.substring(0, lastIndexOf2), str3, classLoader, openType);
                        } else if (!localeID.equals(str4)) {
                            iCUResourceBundle = ICUResourceBundle.instantiateBundle(str, str4, str3, classLoader, openType);
                        }
                        if (createBundle.equals(iCUResourceBundle)) {
                            return createBundle;
                        }
                        createBundle.setParent(iCUResourceBundle);
                        return createBundle;
                    }
                }
            });
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    public ICUResourceBundle get(String str, HashMap<String, String> hashMap, UResourceBundle uResourceBundle) {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) handleGet(str, hashMap, uResourceBundle);
        if (iCUResourceBundle == null) {
            iCUResourceBundle = getParent();
            if (iCUResourceBundle != null) {
                iCUResourceBundle = iCUResourceBundle.get(str, hashMap, uResourceBundle);
            }
            if (iCUResourceBundle == null) {
                throw new MissingResourceException("Can't find resource for bundle " + ICUResourceBundleReader.getFullName(getBaseName(), getLocaleID()) + ", key " + str, getClass().getName(), str);
            }
        }
        return iCUResourceBundle;
    }

    public static ICUResourceBundle createBundle(String str, String str2, ClassLoader classLoader) {
        ICUResourceBundleReader reader = ICUResourceBundleReader.getReader(str, str2, classLoader);
        if (reader == null) {
            return null;
        }
        return getBundle(reader, str, str2, classLoader);
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.UResourceBundle
    public String getLocaleID() {
        return this.wholeBundle.localeID;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.UResourceBundle
    public String getBaseName() {
        return this.wholeBundle.baseName;
    }

    @Override // com.ibm.icu.util.UResourceBundle
    public ULocale getULocale() {
        return this.wholeBundle.ulocale;
    }

    public boolean isRoot() {
        return this.wholeBundle.localeID.isEmpty() || this.wholeBundle.localeID.equals("root");
    }

    @Override // com.ibm.icu.util.UResourceBundle
    public ICUResourceBundle getParent() {
        return (ICUResourceBundle) this.parent;
    }

    /* access modifiers changed from: protected */
    @Override // java.util.ResourceBundle
    public void setParent(ResourceBundle resourceBundle) {
        this.parent = resourceBundle;
    }

    @Override // com.ibm.icu.util.UResourceBundle
    public String getKey() {
        return this.key;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean getNoFallback() {
        return this.wholeBundle.reader.getNoFallback();
    }

    private static ICUResourceBundle getBundle(ICUResourceBundleReader iCUResourceBundleReader, String str, String str2, ClassLoader classLoader) {
        int rootResource = iCUResourceBundleReader.getRootResource();
        if (ICUResourceBundleReader.URES_IS_TABLE(ICUResourceBundleReader.RES_GET_TYPE(rootResource))) {
            ICUResourceBundleImpl.ResourceTable resourceTable = new ICUResourceBundleImpl.ResourceTable(new WholeBundle(str, str2, classLoader, iCUResourceBundleReader), rootResource);
            String findString = resourceTable.findString("%%ALIAS");
            if (findString != null) {
                return (ICUResourceBundle) UResourceBundle.getBundleInstance(str, findString);
            }
            return resourceTable;
        }
        throw new IllegalStateException("Invalid format error");
    }

    protected ICUResourceBundle(WholeBundle wholeBundle2) {
        this.wholeBundle = wholeBundle2;
    }

    protected ICUResourceBundle(ICUResourceBundle iCUResourceBundle, String str) {
        this.key = str;
        this.wholeBundle = iCUResourceBundle.wholeBundle;
        this.container = iCUResourceBundle;
        this.parent = iCUResourceBundle.parent;
    }

    protected static ICUResourceBundle getAliasedResource(ICUResourceBundle iCUResourceBundle, String[] strArr, int i, String str, int i2, HashMap<String, String> hashMap, UResourceBundle uResourceBundle) {
        String str2;
        String str3;
        int i3;
        int indexOf;
        WholeBundle wholeBundle2 = iCUResourceBundle.wholeBundle;
        ClassLoader classLoader = wholeBundle2.loader;
        String str4 = null;
        String alias = wholeBundle2.reader.getAlias(i2);
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        if (hashMap.get(alias) != null) {
            throw new IllegalArgumentException("Circular references in the resource bundles");
        }
        hashMap.put(alias, "");
        if (alias.indexOf(47) == 0) {
            int indexOf2 = alias.indexOf(47, 1);
            int indexOf3 = alias.indexOf(47, indexOf2 + 1);
            str2 = alias.substring(1, indexOf2);
            if (indexOf3 < 0) {
                str3 = alias.substring(indexOf2 + 1);
            } else {
                str3 = alias.substring(indexOf2 + 1, indexOf3);
                str4 = alias.substring(indexOf3 + 1, alias.length());
            }
            if (str2.equals("ICUDATA")) {
                str2 = "com/ibm/icu/impl/data/icudt59b";
                classLoader = ICU_DATA_CLASS_LOADER;
            } else if (str2.indexOf("ICUDATA") > -1 && (indexOf = str2.indexOf(45)) > -1) {
                str2 = "com/ibm/icu/impl/data/icudt59b/" + str2.substring(indexOf + 1, str2.length());
                classLoader = ICU_DATA_CLASS_LOADER;
            }
        } else {
            int indexOf4 = alias.indexOf(47);
            if (indexOf4 != -1) {
                str3 = alias.substring(0, indexOf4);
                str4 = alias.substring(indexOf4 + 1);
            } else {
                str3 = alias;
            }
            str2 = wholeBundle2.baseName;
        }
        ICUResourceBundle iCUResourceBundle2 = null;
        if (str2.equals("LOCALE")) {
            String str5 = wholeBundle2.baseName;
            String substring = alias.substring("LOCALE".length() + 2, alias.length());
            ICUResourceBundle iCUResourceBundle3 = (ICUResourceBundle) uResourceBundle;
            while (iCUResourceBundle3.container != null) {
                iCUResourceBundle3 = iCUResourceBundle3.container;
            }
            iCUResourceBundle2 = findResourceWithFallback(substring, iCUResourceBundle3, null);
        } else {
            ICUResourceBundle bundleInstance = getBundleInstance(str2, str3, classLoader, false);
            if (str4 != null) {
                i3 = countPathKeys(str4);
                if (i3 > 0) {
                    strArr = new String[i3];
                    getResPathKeys(str4, i3, strArr, 0);
                }
            } else if (strArr != null) {
                i3 = i;
            } else {
                int resDepth = iCUResourceBundle.getResDepth();
                i3 = resDepth + 1;
                strArr = new String[i3];
                iCUResourceBundle.getResPathKeys(strArr, resDepth);
                strArr[resDepth] = str;
            }
            if (i3 > 0) {
                iCUResourceBundle2 = bundleInstance;
                int i4 = 0;
                while (iCUResourceBundle2 != null && i4 < i3) {
                    iCUResourceBundle2 = iCUResourceBundle2.get(strArr[i4], hashMap, uResourceBundle);
                    i4++;
                }
            }
        }
        if (iCUResourceBundle2 != null) {
            return iCUResourceBundle2;
        }
        throw new MissingResourceException(wholeBundle2.localeID, wholeBundle2.baseName, str);
    }

    @Deprecated
    public final Set<String> getTopLevelKeySet() {
        return this.wholeBundle.topLevelKeys;
    }

    @Deprecated
    public final void setTopLevelKeySet(Set<String> set) {
        this.wholeBundle.topLevelKeys = set;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.UResourceBundle
    public boolean isTopLevelResource() {
        return this.container == null;
    }
}

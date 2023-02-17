package com.ibm.icu.impl.locale;

import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.util.Output;
import com.ibm.icu.util.UResourceBundle;
import com.ibm.icu.util.UResourceBundleIterator;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.regex.Pattern;
public class KeyTypeData {
    static final /* synthetic */ boolean $assertionsDisabled = (!KeyTypeData.class.desiredAssertionStatus());
    private static Map<String, Set<String>> BCP47_KEYS;
    static Set<String> DEPRECATED_KEYS = Collections.emptySet();
    static Map<String, Set<String>> DEPRECATED_KEY_TYPES = Collections.emptyMap();
    private static final Map<String, KeyData> KEYMAP = new HashMap();
    private static final Object[][] KEY_DATA = new Object[0][];
    static Map<String, ValueType> VALUE_TYPES = Collections.emptyMap();

    /* access modifiers changed from: package-private */
    public enum KeyInfoType {
        deprecated,
        valueType
    }

    /* access modifiers changed from: package-private */
    public enum TypeInfoType {
        deprecated
    }

    public enum ValueType {
        single,
        multiple,
        incremental,
        any
    }

    static {
        initFromResourceBundle();
    }

    /* access modifiers changed from: package-private */
    public static abstract class SpecialTypeHandler {
        /* access modifiers changed from: package-private */
        public abstract boolean isWellFormed(String str);

        private SpecialTypeHandler() {
        }

        /* access modifiers changed from: package-private */
        public String canonicalize(String str) {
            return AsciiUtil.toLowerString(str);
        }
    }

    static class CodepointsTypeHandler extends SpecialTypeHandler {
        private static final Pattern pat = Pattern.compile("[0-9a-fA-F]{4,6}(-[0-9a-fA-F]{4,6})*");

        private CodepointsTypeHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.locale.KeyTypeData.SpecialTypeHandler
        public boolean isWellFormed(String str) {
            return pat.matcher(str).matches();
        }
    }

    static class ReorderCodeTypeHandler extends SpecialTypeHandler {
        private static final Pattern pat = Pattern.compile("[a-zA-Z]{3,8}(-[a-zA-Z]{3,8})*");

        private ReorderCodeTypeHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.locale.KeyTypeData.SpecialTypeHandler
        public boolean isWellFormed(String str) {
            return pat.matcher(str).matches();
        }
    }

    static class RgKeyValueTypeHandler extends SpecialTypeHandler {
        private static final Pattern pat = Pattern.compile("([a-zA-Z]{2}|[0-9]{3})[zZ]{4}");

        private RgKeyValueTypeHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.locale.KeyTypeData.SpecialTypeHandler
        public boolean isWellFormed(String str) {
            return pat.matcher(str).matches();
        }
    }

    static class SubdivisionKeyValueTypeHandler extends SpecialTypeHandler {
        private static final Pattern pat = Pattern.compile("([a-zA-Z]{2}|[0-9]{3})");

        private SubdivisionKeyValueTypeHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.locale.KeyTypeData.SpecialTypeHandler
        public boolean isWellFormed(String str) {
            return pat.matcher(str).matches();
        }
    }

    static class PrivateUseKeyValueTypeHandler extends SpecialTypeHandler {
        private static final Pattern pat = Pattern.compile("[a-zA-Z0-9]{3,8}(-[a-zA-Z0-9]{3,8})*");

        private PrivateUseKeyValueTypeHandler() {
            super();
        }

        /* access modifiers changed from: package-private */
        @Override // com.ibm.icu.impl.locale.KeyTypeData.SpecialTypeHandler
        public boolean isWellFormed(String str) {
            return pat.matcher(str).matches();
        }
    }

    /* access modifiers changed from: package-private */
    public enum SpecialType {
        CODEPOINTS(new CodepointsTypeHandler()),
        REORDER_CODE(new ReorderCodeTypeHandler()),
        RG_KEY_VALUE(new RgKeyValueTypeHandler()),
        SUBDIVISION_CODE(new SubdivisionKeyValueTypeHandler()),
        PRIVATE_USE(new PrivateUseKeyValueTypeHandler());
        
        SpecialTypeHandler handler;

        private SpecialType(SpecialTypeHandler specialTypeHandler) {
            this.handler = specialTypeHandler;
        }
    }

    /* access modifiers changed from: package-private */
    public static class KeyData {
        String bcpId;
        String legacyId;
        EnumSet<SpecialType> specialTypes;
        Map<String, Type> typeMap;

        KeyData(String str, String str2, Map<String, Type> map, EnumSet<SpecialType> enumSet) {
            this.legacyId = str;
            this.bcpId = str2;
            this.typeMap = map;
            this.specialTypes = enumSet;
        }
    }

    /* access modifiers changed from: package-private */
    public static class Type {
        String bcpId;
        String legacyId;

        Type(String str, String str2) {
            this.legacyId = str;
            this.bcpId = str2;
        }
    }

    public static String toBcpKey(String str) {
        KeyData keyData = KEYMAP.get(AsciiUtil.toLowerString(str));
        if (keyData != null) {
            return keyData.bcpId;
        }
        return null;
    }

    public static String toLegacyKey(String str) {
        KeyData keyData = KEYMAP.get(AsciiUtil.toLowerString(str));
        if (keyData != null) {
            return keyData.legacyId;
        }
        return null;
    }

    public static String toBcpType(String str, String str2, Output<Boolean> output, Output<Boolean> output2) {
        if (output != null) {
            output.value = (T) false;
        }
        if (output2 != null) {
            output2.value = (T) false;
        }
        String lowerString = AsciiUtil.toLowerString(str);
        String lowerString2 = AsciiUtil.toLowerString(str2);
        KeyData keyData = KEYMAP.get(lowerString);
        if (keyData == null) {
            return null;
        }
        if (output != null) {
            output.value = (T) Boolean.TRUE;
        }
        Type type = keyData.typeMap.get(lowerString2);
        if (type != null) {
            return type.bcpId;
        }
        if (keyData.specialTypes == null) {
            return null;
        }
        Iterator it = keyData.specialTypes.iterator();
        while (it.hasNext()) {
            SpecialType specialType = (SpecialType) it.next();
            if (specialType.handler.isWellFormed(lowerString2)) {
                if (output2 != null) {
                    output2.value = (T) true;
                }
                return specialType.handler.canonicalize(lowerString2);
            }
        }
        return null;
    }

    public static String toLegacyType(String str, String str2, Output<Boolean> output, Output<Boolean> output2) {
        if (output != null) {
            output.value = (T) false;
        }
        if (output2 != null) {
            output2.value = (T) false;
        }
        String lowerString = AsciiUtil.toLowerString(str);
        String lowerString2 = AsciiUtil.toLowerString(str2);
        KeyData keyData = KEYMAP.get(lowerString);
        if (keyData == null) {
            return null;
        }
        if (output != null) {
            output.value = (T) Boolean.TRUE;
        }
        Type type = keyData.typeMap.get(lowerString2);
        if (type != null) {
            return type.legacyId;
        }
        if (keyData.specialTypes == null) {
            return null;
        }
        Iterator it = keyData.specialTypes.iterator();
        while (it.hasNext()) {
            SpecialType specialType = (SpecialType) it.next();
            if (specialType.handler.isWellFormed(lowerString2)) {
                if (output2 != null) {
                    output2.value = (T) true;
                }
                return specialType.handler.canonicalize(lowerString2);
            }
        }
        return null;
    }

    private static void initFromResourceBundle() {
        Set<String> set;
        Set<String> set2;
        UResourceBundle bundleInstance = UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b", "keyTypeData", ICUResourceBundle.ICU_DATA_CLASS_LOADER);
        getKeyInfo(bundleInstance.get("keyInfo"));
        getTypeInfo(bundleInstance.get("typeInfo"));
        UResourceBundle uResourceBundle = bundleInstance.get("keyMap");
        UResourceBundle uResourceBundle2 = bundleInstance.get("typeMap");
        UResourceBundle uResourceBundle3 = null;
        UResourceBundle uResourceBundle4 = null;
        try {
            uResourceBundle3 = bundleInstance.get("typeAlias");
        } catch (MissingResourceException e) {
        }
        try {
            uResourceBundle4 = bundleInstance.get("bcpTypeAlias");
        } catch (MissingResourceException e2) {
        }
        UResourceBundleIterator iterator = uResourceBundle.getIterator();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (iterator.hasNext()) {
            UResourceBundle next = iterator.next();
            String key = next.getKey();
            String string = next.getString();
            boolean z = false;
            if (string.length() == 0) {
                string = key;
                z = true;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            linkedHashMap.put(string, Collections.unmodifiableSet(linkedHashSet));
            boolean equals = key.equals("timezone");
            HashMap hashMap = null;
            if (uResourceBundle3 != null) {
                UResourceBundle uResourceBundle5 = null;
                try {
                    uResourceBundle5 = uResourceBundle3.get(key);
                } catch (MissingResourceException e3) {
                }
                if (uResourceBundle5 != null) {
                    hashMap = new HashMap();
                    UResourceBundleIterator iterator2 = uResourceBundle5.getIterator();
                    while (iterator2.hasNext()) {
                        UResourceBundle next2 = iterator2.next();
                        String key2 = next2.getKey();
                        String string2 = next2.getString();
                        if (equals) {
                            key2 = key2.replace(':', '/');
                        }
                        Set set3 = (Set) hashMap.get(string2);
                        if (set3 == null) {
                            set3 = new HashSet();
                            hashMap.put(string2, set3);
                        }
                        set3.add(key2);
                    }
                }
            }
            HashMap hashMap2 = null;
            if (uResourceBundle4 != null) {
                UResourceBundle uResourceBundle6 = null;
                try {
                    uResourceBundle6 = uResourceBundle4.get(string);
                } catch (MissingResourceException e4) {
                }
                if (uResourceBundle6 != null) {
                    hashMap2 = new HashMap();
                    UResourceBundleIterator iterator3 = uResourceBundle6.getIterator();
                    while (iterator3.hasNext()) {
                        UResourceBundle next3 = iterator3.next();
                        String key3 = next3.getKey();
                        String string3 = next3.getString();
                        Set set4 = (Set) hashMap2.get(string3);
                        if (set4 == null) {
                            set4 = new HashSet();
                            hashMap2.put(string3, set4);
                        }
                        set4.add(key3);
                    }
                }
            }
            HashMap hashMap3 = new HashMap();
            EnumSet enumSet = null;
            UResourceBundle uResourceBundle7 = null;
            try {
                uResourceBundle7 = uResourceBundle2.get(key);
            } catch (MissingResourceException e5) {
                if (!$assertionsDisabled) {
                    throw new AssertionError();
                }
            }
            if (uResourceBundle7 != null) {
                UResourceBundleIterator iterator4 = uResourceBundle7.getIterator();
                while (iterator4.hasNext()) {
                    UResourceBundle next4 = iterator4.next();
                    String key4 = next4.getKey();
                    String string4 = next4.getString();
                    char charAt = key4.charAt(0);
                    if ('9' < charAt && charAt < 'a' && string4.length() == 0) {
                        if (enumSet == null) {
                            enumSet = EnumSet.noneOf(SpecialType.class);
                        }
                        enumSet.add(SpecialType.valueOf(key4));
                        linkedHashSet.add(key4);
                    } else {
                        if (equals) {
                            key4 = key4.replace(':', '/');
                        }
                        boolean z2 = false;
                        if (string4.length() == 0) {
                            string4 = key4;
                            z2 = true;
                        }
                        linkedHashSet.add(string4);
                        Type type = new Type(key4, string4);
                        hashMap3.put(AsciiUtil.toLowerString(key4), type);
                        if (!z2) {
                            hashMap3.put(AsciiUtil.toLowerString(string4), type);
                        }
                        if (!(hashMap == null || (set2 = (Set) hashMap.get(key4)) == null)) {
                            for (String str : set2) {
                                hashMap3.put(AsciiUtil.toLowerString(str), type);
                            }
                        }
                        if (!(hashMap2 == null || (set = (Set) hashMap2.get(string4)) == null)) {
                            for (String str2 : set) {
                                hashMap3.put(AsciiUtil.toLowerString(str2), type);
                            }
                        }
                    }
                }
            }
            KeyData keyData = new KeyData(key, string, hashMap3, enumSet);
            KEYMAP.put(AsciiUtil.toLowerString(key), keyData);
            if (!z) {
                KEYMAP.put(AsciiUtil.toLowerString(string), keyData);
            }
        }
        BCP47_KEYS = Collections.unmodifiableMap(linkedHashMap);
    }

    private static void getKeyInfo(UResourceBundle uResourceBundle) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        UResourceBundleIterator iterator = uResourceBundle.getIterator();
        while (iterator.hasNext()) {
            UResourceBundle next = iterator.next();
            KeyInfoType valueOf = KeyInfoType.valueOf(next.getKey());
            UResourceBundleIterator iterator2 = next.getIterator();
            while (iterator2.hasNext()) {
                UResourceBundle next2 = iterator2.next();
                String key = next2.getKey();
                String string = next2.getString();
                switch (valueOf) {
                    case deprecated:
                        linkedHashSet.add(key);
                        break;
                    case valueType:
                        linkedHashMap.put(key, ValueType.valueOf(string));
                        break;
                }
            }
        }
        DEPRECATED_KEYS = Collections.unmodifiableSet(linkedHashSet);
        VALUE_TYPES = Collections.unmodifiableMap(linkedHashMap);
    }

    private static void getTypeInfo(UResourceBundle uResourceBundle) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        UResourceBundleIterator iterator = uResourceBundle.getIterator();
        while (iterator.hasNext()) {
            UResourceBundle next = iterator.next();
            TypeInfoType valueOf = TypeInfoType.valueOf(next.getKey());
            UResourceBundleIterator iterator2 = next.getIterator();
            while (iterator2.hasNext()) {
                UResourceBundle next2 = iterator2.next();
                String key = next2.getKey();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                UResourceBundleIterator iterator3 = next2.getIterator();
                while (iterator3.hasNext()) {
                    String key2 = iterator3.next().getKey();
                    switch (valueOf) {
                        case deprecated:
                            linkedHashSet.add(key2);
                            break;
                    }
                }
                linkedHashMap.put(key, Collections.unmodifiableSet(linkedHashSet));
            }
        }
        DEPRECATED_KEY_TYPES = Collections.unmodifiableMap(linkedHashMap);
    }
}

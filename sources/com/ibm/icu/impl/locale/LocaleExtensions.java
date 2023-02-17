package com.ibm.icu.impl.locale;

import com.ibm.icu.impl.locale.InternalLocaleBuilder;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
public class LocaleExtensions {
    static final /* synthetic */ boolean $assertionsDisabled = (!LocaleExtensions.class.desiredAssertionStatus());
    public static final LocaleExtensions CALENDAR_JAPANESE = new LocaleExtensions();
    public static final LocaleExtensions EMPTY_EXTENSIONS = new LocaleExtensions();
    private static final SortedMap<Character, Extension> EMPTY_MAP = Collections.unmodifiableSortedMap(new TreeMap());
    public static final LocaleExtensions NUMBER_THAI = new LocaleExtensions();
    private String _id;
    private SortedMap<Character, Extension> _map;

    static {
        EMPTY_EXTENSIONS._id = "";
        EMPTY_EXTENSIONS._map = EMPTY_MAP;
        CALENDAR_JAPANESE._id = "u-ca-japanese";
        CALENDAR_JAPANESE._map = new TreeMap();
        CALENDAR_JAPANESE._map.put('u', UnicodeLocaleExtension.CA_JAPANESE);
        NUMBER_THAI._id = "u-nu-thai";
        NUMBER_THAI._map = new TreeMap();
        NUMBER_THAI._map.put('u', UnicodeLocaleExtension.NU_THAI);
    }

    private LocaleExtensions() {
    }

    LocaleExtensions(Map<InternalLocaleBuilder.CaseInsensitiveChar, String> map, Set<InternalLocaleBuilder.CaseInsensitiveString> set, Map<InternalLocaleBuilder.CaseInsensitiveString, String> map2) {
        boolean z = map != null && map.size() > 0;
        boolean z2 = set != null && set.size() > 0;
        boolean z3 = map2 != null && map2.size() > 0;
        if (z || z2 || z3) {
            this._map = new TreeMap();
            if (z) {
                for (Map.Entry<InternalLocaleBuilder.CaseInsensitiveChar, String> entry : map.entrySet()) {
                    char lower = AsciiUtil.toLower(entry.getKey().value());
                    String value = entry.getValue();
                    if (!LanguageTag.isPrivateusePrefixChar(lower) || (value = InternalLocaleBuilder.removePrivateuseVariant(value)) != null) {
                        this._map.put(Character.valueOf(lower), new Extension(lower, AsciiUtil.toLowerString(value)));
                    }
                }
            }
            if (z2 || z3) {
                TreeSet treeSet = null;
                TreeMap treeMap = null;
                if (z2) {
                    treeSet = new TreeSet();
                    for (InternalLocaleBuilder.CaseInsensitiveString caseInsensitiveString : set) {
                        treeSet.add(AsciiUtil.toLowerString(caseInsensitiveString.value()));
                    }
                }
                if (z3) {
                    treeMap = new TreeMap();
                    for (Map.Entry<InternalLocaleBuilder.CaseInsensitiveString, String> entry2 : map2.entrySet()) {
                        treeMap.put(AsciiUtil.toLowerString(entry2.getKey().value()), AsciiUtil.toLowerString(entry2.getValue()));
                    }
                }
                this._map.put('u', new UnicodeLocaleExtension(treeSet, treeMap));
            }
            if (this._map.size() == 0) {
                this._map = EMPTY_MAP;
                this._id = "";
                return;
            }
            this._id = toID(this._map);
            return;
        }
        this._map = EMPTY_MAP;
        this._id = "";
    }

    public Set<Character> getKeys() {
        return Collections.unmodifiableSet(this._map.keySet());
    }

    public Extension getExtension(Character ch) {
        return this._map.get(Character.valueOf(AsciiUtil.toLower(ch.charValue())));
    }

    public String getUnicodeLocaleType(String str) {
        Extension extension = this._map.get('u');
        if (extension == null) {
            return null;
        }
        if ($assertionsDisabled || (extension instanceof UnicodeLocaleExtension)) {
            return ((UnicodeLocaleExtension) extension).getUnicodeLocaleType(AsciiUtil.toLowerString(str));
        }
        throw new AssertionError();
    }

    private static String toID(SortedMap<Character, Extension> sortedMap) {
        StringBuilder sb = new StringBuilder();
        Extension extension = null;
        for (Map.Entry<Character, Extension> entry : sortedMap.entrySet()) {
            char charValue = entry.getKey().charValue();
            Extension value = entry.getValue();
            if (LanguageTag.isPrivateusePrefixChar(charValue)) {
                extension = value;
            } else {
                if (sb.length() > 0) {
                    sb.append("-");
                }
                sb.append(value);
            }
        }
        if (extension != null) {
            if (sb.length() > 0) {
                sb.append("-");
            }
            sb.append(extension);
        }
        return sb.toString();
    }

    public String toString() {
        return this._id;
    }

    public int hashCode() {
        return this._id.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocaleExtensions)) {
            return false;
        }
        return this._id.equals(((LocaleExtensions) obj)._id);
    }
}

package com.ibm.icu.impl.locale;
public final class BaseLocale {
    private static final Cache CACHE = new Cache();
    public static final BaseLocale ROOT = getInstance("", "", "", "");
    private volatile transient int _hash;
    private String _language;
    private String _region;
    private String _script;
    private String _variant;

    private BaseLocale(String str, String str2, String str3, String str4) {
        this._language = "";
        this._script = "";
        this._region = "";
        this._variant = "";
        this._hash = 0;
        if (str != null) {
            this._language = AsciiUtil.toLowerString(str).intern();
        }
        if (str2 != null) {
            this._script = AsciiUtil.toTitleString(str2).intern();
        }
        if (str3 != null) {
            this._region = AsciiUtil.toUpperString(str3).intern();
        }
        if (str4 != null) {
            this._variant = AsciiUtil.toUpperString(str4).intern();
        }
    }

    public static BaseLocale getInstance(String str, String str2, String str3, String str4) {
        return (BaseLocale) CACHE.get(new Key(str, str2, str3, str4));
    }

    public String getLanguage() {
        return this._language;
    }

    public String getScript() {
        return this._script;
    }

    public String getRegion() {
        return this._region;
    }

    public String getVariant() {
        return this._variant;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseLocale)) {
            return false;
        }
        BaseLocale baseLocale = (BaseLocale) obj;
        return hashCode() == baseLocale.hashCode() && this._language.equals(baseLocale._language) && this._script.equals(baseLocale._script) && this._region.equals(baseLocale._region) && this._variant.equals(baseLocale._variant);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this._language.length() > 0) {
            sb.append("language=");
            sb.append(this._language);
        }
        if (this._script.length() > 0) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("script=");
            sb.append(this._script);
        }
        if (this._region.length() > 0) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("region=");
            sb.append(this._region);
        }
        if (this._variant.length() > 0) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("variant=");
            sb.append(this._variant);
        }
        return sb.toString();
    }

    public int hashCode() {
        int i = this._hash;
        if (i == 0) {
            for (int i2 = 0; i2 < this._language.length(); i2++) {
                i = (i * 31) + this._language.charAt(i2);
            }
            for (int i3 = 0; i3 < this._script.length(); i3++) {
                i = (i * 31) + this._script.charAt(i3);
            }
            for (int i4 = 0; i4 < this._region.length(); i4++) {
                i = (i * 31) + this._region.charAt(i4);
            }
            for (int i5 = 0; i5 < this._variant.length(); i5++) {
                i = (i * 31) + this._variant.charAt(i5);
            }
            this._hash = i;
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public static class Key implements Comparable<Key> {
        private volatile int _hash;
        private String _lang = "";
        private String _regn = "";
        private String _scrt = "";
        private String _vart = "";

        public Key(String str, String str2, String str3, String str4) {
            if (str != null) {
                this._lang = str;
            }
            if (str2 != null) {
                this._scrt = str2;
            }
            if (str3 != null) {
                this._regn = str3;
            }
            if (str4 != null) {
                this._vart = str4;
            }
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            return this == obj || ((obj instanceof Key) && AsciiUtil.caseIgnoreMatch(((Key) obj)._lang, this._lang) && AsciiUtil.caseIgnoreMatch(((Key) obj)._scrt, this._scrt) && AsciiUtil.caseIgnoreMatch(((Key) obj)._regn, this._regn) && AsciiUtil.caseIgnoreMatch(((Key) obj)._vart, this._vart));
        }

        public int compareTo(Key key) {
            int caseIgnoreCompare = AsciiUtil.caseIgnoreCompare(this._lang, key._lang);
            if (caseIgnoreCompare != 0) {
                return caseIgnoreCompare;
            }
            int caseIgnoreCompare2 = AsciiUtil.caseIgnoreCompare(this._scrt, key._scrt);
            if (caseIgnoreCompare2 != 0) {
                return caseIgnoreCompare2;
            }
            int caseIgnoreCompare3 = AsciiUtil.caseIgnoreCompare(this._regn, key._regn);
            if (caseIgnoreCompare3 == 0) {
                return AsciiUtil.caseIgnoreCompare(this._vart, key._vart);
            }
            return caseIgnoreCompare3;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i = this._hash;
            if (i == 0) {
                for (int i2 = 0; i2 < this._lang.length(); i2++) {
                    i = (i * 31) + AsciiUtil.toLower(this._lang.charAt(i2));
                }
                for (int i3 = 0; i3 < this._scrt.length(); i3++) {
                    i = (i * 31) + AsciiUtil.toLower(this._scrt.charAt(i3));
                }
                for (int i4 = 0; i4 < this._regn.length(); i4++) {
                    i = (i * 31) + AsciiUtil.toLower(this._regn.charAt(i4));
                }
                for (int i5 = 0; i5 < this._vart.length(); i5++) {
                    i = (i * 31) + AsciiUtil.toLower(this._vart.charAt(i5));
                }
                this._hash = i;
            }
            return i;
        }

        public static Key normalize(Key key) {
            return new Key(AsciiUtil.toLowerString(key._lang).intern(), AsciiUtil.toTitleString(key._scrt).intern(), AsciiUtil.toUpperString(key._regn).intern(), AsciiUtil.toUpperString(key._vart).intern());
        }
    }

    /* access modifiers changed from: package-private */
    public static class Cache extends LocaleObjectCache<Key, BaseLocale> {
        /* access modifiers changed from: protected */
        public Key normalizeKey(Key key) {
            return Key.normalize(key);
        }

        /* access modifiers changed from: protected */
        public BaseLocale createObject(Key key) {
            return new BaseLocale(key._lang, key._scrt, key._regn, key._vart);
        }
    }
}

package com.ibm.icu.impl.locale;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public final class InternalLocaleBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = (!InternalLocaleBuilder.class.desiredAssertionStatus());
    private static final CaseInsensitiveChar PRIVUSE_KEY = new CaseInsensitiveChar("x".charAt(0));
    private HashMap<CaseInsensitiveChar, String> _extensions;
    private String _language = "";
    private String _region = "";
    private String _script = "";
    private HashSet<CaseInsensitiveString> _uattributes;
    private HashMap<CaseInsensitiveString, String> _ukeywords;
    private String _variant = "";

    public InternalLocaleBuilder addUnicodeLocaleAttribute(String str) {
        if (str == null || !UnicodeLocaleExtension.isAttribute(str)) {
            throw new LocaleSyntaxException("Ill-formed Unicode locale attribute: " + str);
        }
        if (this._uattributes == null) {
            this._uattributes = new HashSet<>(4);
        }
        this._uattributes.add(new CaseInsensitiveString(str));
        return this;
    }

    public InternalLocaleBuilder setUnicodeLocaleKeyword(String str, String str2) {
        if (!UnicodeLocaleExtension.isKey(str)) {
            throw new LocaleSyntaxException("Ill-formed Unicode locale keyword key: " + str);
        }
        CaseInsensitiveString caseInsensitiveString = new CaseInsensitiveString(str);
        if (str2 != null) {
            if (str2.length() != 0) {
                StringTokenIterator stringTokenIterator = new StringTokenIterator(str2.replaceAll("_", "-"), "-");
                while (!stringTokenIterator.isDone()) {
                    if (!UnicodeLocaleExtension.isTypeSubtag(stringTokenIterator.current())) {
                        throw new LocaleSyntaxException("Ill-formed Unicode locale keyword type: " + str2, stringTokenIterator.currentStart());
                    }
                    stringTokenIterator.next();
                }
            }
            if (this._ukeywords == null) {
                this._ukeywords = new HashMap<>(4);
            }
            this._ukeywords.put(caseInsensitiveString, str2);
        } else if (this._ukeywords != null) {
            this._ukeywords.remove(caseInsensitiveString);
        }
        return this;
    }

    public InternalLocaleBuilder setExtension(char c, String str) {
        boolean z;
        boolean isPrivateusePrefixChar = LanguageTag.isPrivateusePrefixChar(c);
        if (isPrivateusePrefixChar || LanguageTag.isExtensionSingletonChar(c)) {
            boolean z2 = str == null || str.length() == 0;
            CaseInsensitiveChar caseInsensitiveChar = new CaseInsensitiveChar(c);
            if (!z2) {
                String replaceAll = str.replaceAll("_", "-");
                StringTokenIterator stringTokenIterator = new StringTokenIterator(replaceAll, "-");
                while (!stringTokenIterator.isDone()) {
                    String current = stringTokenIterator.current();
                    if (isPrivateusePrefixChar) {
                        z = LanguageTag.isPrivateuseSubtag(current);
                    } else {
                        z = LanguageTag.isExtensionSubtag(current);
                    }
                    if (!z) {
                        throw new LocaleSyntaxException("Ill-formed extension value: " + current, stringTokenIterator.currentStart());
                    }
                    stringTokenIterator.next();
                }
                if (UnicodeLocaleExtension.isSingletonChar(caseInsensitiveChar.value())) {
                    setUnicodeLocaleExtension(replaceAll);
                } else {
                    if (this._extensions == null) {
                        this._extensions = new HashMap<>(4);
                    }
                    this._extensions.put(caseInsensitiveChar, replaceAll);
                }
            } else if (UnicodeLocaleExtension.isSingletonChar(caseInsensitiveChar.value())) {
                if (this._uattributes != null) {
                    this._uattributes.clear();
                }
                if (this._ukeywords != null) {
                    this._ukeywords.clear();
                }
            } else if (this._extensions != null && this._extensions.containsKey(caseInsensitiveChar)) {
                this._extensions.remove(caseInsensitiveChar);
            }
            return this;
        }
        throw new LocaleSyntaxException("Ill-formed extension key: " + c);
    }

    private InternalLocaleBuilder setExtensions(List<String> list, String str) {
        clearExtensions();
        if (list != null && list.size() > 0) {
            HashSet hashSet = new HashSet(list.size());
            for (String str2 : list) {
                CaseInsensitiveChar caseInsensitiveChar = new CaseInsensitiveChar(str2.charAt(0));
                if (!hashSet.contains(caseInsensitiveChar)) {
                    if (UnicodeLocaleExtension.isSingletonChar(caseInsensitiveChar.value())) {
                        setUnicodeLocaleExtension(str2.substring(2));
                    } else {
                        if (this._extensions == null) {
                            this._extensions = new HashMap<>(4);
                        }
                        this._extensions.put(caseInsensitiveChar, str2.substring(2));
                    }
                }
            }
        }
        if (str != null && str.length() > 0) {
            if (this._extensions == null) {
                this._extensions = new HashMap<>(1);
            }
            this._extensions.put(new CaseInsensitiveChar(str.charAt(0)), str.substring(2));
        }
        return this;
    }

    public InternalLocaleBuilder setLanguageTag(LanguageTag languageTag) {
        clear();
        if (languageTag.getExtlangs().size() > 0) {
            this._language = languageTag.getExtlangs().get(0);
        } else {
            String language = languageTag.getLanguage();
            if (!language.equals(LanguageTag.UNDETERMINED)) {
                this._language = language;
            }
        }
        this._script = languageTag.getScript();
        this._region = languageTag.getRegion();
        List<String> variants = languageTag.getVariants();
        if (variants.size() > 0) {
            StringBuilder sb = new StringBuilder(variants.get(0));
            for (int i = 1; i < variants.size(); i++) {
                sb.append("_").append(variants.get(i));
            }
            this._variant = sb.toString();
        }
        setExtensions(languageTag.getExtensions(), languageTag.getPrivateuse());
        return this;
    }

    public InternalLocaleBuilder setLocale(BaseLocale baseLocale, LocaleExtensions localeExtensions) {
        int checkVariants;
        String language = baseLocale.getLanguage();
        String script = baseLocale.getScript();
        String region = baseLocale.getRegion();
        String variant = baseLocale.getVariant();
        if (language.length() > 0 && !LanguageTag.isLanguage(language)) {
            throw new LocaleSyntaxException("Ill-formed language: " + language);
        } else if (script.length() > 0 && !LanguageTag.isScript(script)) {
            throw new LocaleSyntaxException("Ill-formed script: " + script);
        } else if (region.length() > 0 && !LanguageTag.isRegion(region)) {
            throw new LocaleSyntaxException("Ill-formed region: " + region);
        } else if (variant.length() <= 0 || (checkVariants = checkVariants(variant, "_")) == -1) {
            this._language = language;
            this._script = script;
            this._region = region;
            this._variant = variant;
            clearExtensions();
            Set<Character> keys = localeExtensions == null ? null : localeExtensions.getKeys();
            if (keys != null) {
                for (Character ch : keys) {
                    Extension extension = localeExtensions.getExtension(ch);
                    if (extension instanceof UnicodeLocaleExtension) {
                        UnicodeLocaleExtension unicodeLocaleExtension = (UnicodeLocaleExtension) extension;
                        for (String str : unicodeLocaleExtension.getUnicodeLocaleAttributes()) {
                            if (this._uattributes == null) {
                                this._uattributes = new HashSet<>(4);
                            }
                            this._uattributes.add(new CaseInsensitiveString(str));
                        }
                        for (String str2 : unicodeLocaleExtension.getUnicodeLocaleKeys()) {
                            if (this._ukeywords == null) {
                                this._ukeywords = new HashMap<>(4);
                            }
                            this._ukeywords.put(new CaseInsensitiveString(str2), unicodeLocaleExtension.getUnicodeLocaleType(str2));
                        }
                    } else {
                        if (this._extensions == null) {
                            this._extensions = new HashMap<>(4);
                        }
                        this._extensions.put(new CaseInsensitiveChar(ch.charValue()), extension.getValue());
                    }
                }
            }
            return this;
        } else {
            throw new LocaleSyntaxException("Ill-formed variant: " + variant, checkVariants);
        }
    }

    public InternalLocaleBuilder clear() {
        this._language = "";
        this._script = "";
        this._region = "";
        this._variant = "";
        clearExtensions();
        return this;
    }

    public InternalLocaleBuilder clearExtensions() {
        if (this._extensions != null) {
            this._extensions.clear();
        }
        if (this._uattributes != null) {
            this._uattributes.clear();
        }
        if (this._ukeywords != null) {
            this._ukeywords.clear();
        }
        return this;
    }

    public BaseLocale getBaseLocale() {
        String str;
        String str2 = this._language;
        String str3 = this._script;
        String str4 = this._region;
        String str5 = this._variant;
        if (!(this._extensions == null || (str = this._extensions.get(PRIVUSE_KEY)) == null)) {
            StringTokenIterator stringTokenIterator = new StringTokenIterator(str, "-");
            boolean z = false;
            int i = -1;
            while (true) {
                if (stringTokenIterator.isDone()) {
                    break;
                } else if (z) {
                    i = stringTokenIterator.currentStart();
                    break;
                } else {
                    if (AsciiUtil.caseIgnoreMatch(stringTokenIterator.current(), "lvariant")) {
                        z = true;
                    }
                    stringTokenIterator.next();
                }
            }
            if (i != -1) {
                StringBuilder sb = new StringBuilder(str5);
                if (sb.length() != 0) {
                    sb.append("_");
                }
                sb.append(str.substring(i).replaceAll("-", "_"));
                str5 = sb.toString();
            }
        }
        return BaseLocale.getInstance(str2, str3, str4, str5);
    }

    public LocaleExtensions getLocaleExtensions() {
        if ((this._extensions == null || this._extensions.size() == 0) && ((this._uattributes == null || this._uattributes.size() == 0) && (this._ukeywords == null || this._ukeywords.size() == 0))) {
            return LocaleExtensions.EMPTY_EXTENSIONS;
        }
        return new LocaleExtensions(this._extensions, this._uattributes, this._ukeywords);
    }

    static String removePrivateuseVariant(String str) {
        StringTokenIterator stringTokenIterator = new StringTokenIterator(str, "-");
        int i = -1;
        boolean z = false;
        while (true) {
            if (stringTokenIterator.isDone()) {
                break;
            } else if (i != -1) {
                z = true;
                break;
            } else {
                if (AsciiUtil.caseIgnoreMatch(stringTokenIterator.current(), "lvariant")) {
                    i = stringTokenIterator.currentStart();
                }
                stringTokenIterator.next();
            }
        }
        if (!z) {
            return str;
        }
        if (!$assertionsDisabled && i != 0 && i <= 1) {
            throw new AssertionError();
        } else if (i == 0) {
            return null;
        } else {
            return str.substring(0, i - 1);
        }
    }

    private int checkVariants(String str, String str2) {
        StringTokenIterator stringTokenIterator = new StringTokenIterator(str, str2);
        while (!stringTokenIterator.isDone()) {
            if (!LanguageTag.isVariant(stringTokenIterator.current())) {
                return stringTokenIterator.currentStart();
            }
            stringTokenIterator.next();
        }
        return -1;
    }

    private void setUnicodeLocaleExtension(String str) {
        if (this._uattributes != null) {
            this._uattributes.clear();
        }
        if (this._ukeywords != null) {
            this._ukeywords.clear();
        }
        StringTokenIterator stringTokenIterator = new StringTokenIterator(str, "-");
        while (!stringTokenIterator.isDone() && UnicodeLocaleExtension.isAttribute(stringTokenIterator.current())) {
            if (this._uattributes == null) {
                this._uattributes = new HashSet<>(4);
            }
            this._uattributes.add(new CaseInsensitiveString(stringTokenIterator.current()));
            stringTokenIterator.next();
        }
        CaseInsensitiveString caseInsensitiveString = null;
        int i = -1;
        int i2 = -1;
        while (!stringTokenIterator.isDone()) {
            if (caseInsensitiveString != null) {
                if (!UnicodeLocaleExtension.isKey(stringTokenIterator.current())) {
                    if (i == -1) {
                        i = stringTokenIterator.currentStart();
                    }
                    i2 = stringTokenIterator.currentEnd();
                } else if ($assertionsDisabled || i == -1 || i2 != -1) {
                    String substring = i == -1 ? "" : str.substring(i, i2);
                    if (this._ukeywords == null) {
                        this._ukeywords = new HashMap<>(4);
                    }
                    this._ukeywords.put(caseInsensitiveString, substring);
                    CaseInsensitiveString caseInsensitiveString2 = new CaseInsensitiveString(stringTokenIterator.current());
                    caseInsensitiveString = this._ukeywords.containsKey(caseInsensitiveString2) ? null : caseInsensitiveString2;
                    i2 = -1;
                    i = -1;
                } else {
                    throw new AssertionError();
                }
            } else if (UnicodeLocaleExtension.isKey(stringTokenIterator.current())) {
                caseInsensitiveString = new CaseInsensitiveString(stringTokenIterator.current());
                if (this._ukeywords != null && this._ukeywords.containsKey(caseInsensitiveString)) {
                    caseInsensitiveString = null;
                }
            }
            if (stringTokenIterator.hasNext()) {
                stringTokenIterator.next();
            } else if (caseInsensitiveString == null) {
                return;
            } else {
                if ($assertionsDisabled || i == -1 || i2 != -1) {
                    String substring2 = i == -1 ? "" : str.substring(i, i2);
                    if (this._ukeywords == null) {
                        this._ukeywords = new HashMap<>(4);
                    }
                    this._ukeywords.put(caseInsensitiveString, substring2);
                    return;
                }
                throw new AssertionError();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class CaseInsensitiveString {
        private String _s;

        CaseInsensitiveString(String str) {
            this._s = str;
        }

        public String value() {
            return this._s;
        }

        public int hashCode() {
            return AsciiUtil.toLowerString(this._s).hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CaseInsensitiveString)) {
                return false;
            }
            return AsciiUtil.caseIgnoreMatch(this._s, ((CaseInsensitiveString) obj).value());
        }
    }

    /* access modifiers changed from: package-private */
    public static class CaseInsensitiveChar {
        private char _c;

        CaseInsensitiveChar(char c) {
            this._c = c;
        }

        public char value() {
            return this._c;
        }

        public int hashCode() {
            return AsciiUtil.toLower(this._c);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CaseInsensitiveChar) && this._c == AsciiUtil.toLower(((CaseInsensitiveChar) obj).value());
        }
    }
}

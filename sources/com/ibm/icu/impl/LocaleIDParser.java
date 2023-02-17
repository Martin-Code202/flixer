package com.ibm.icu.impl;

import com.ibm.icu.impl.locale.AsciiUtil;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
public final class LocaleIDParser {
    String baseName;
    private StringBuilder buffer;
    private boolean canonicalize;
    private boolean hadCountry;
    private char[] id;
    private int index;
    Map<String, String> keywords;

    public LocaleIDParser(String str) {
        this(str, false);
    }

    public LocaleIDParser(String str, boolean z) {
        this.id = str.toCharArray();
        this.index = 0;
        this.buffer = new StringBuilder(this.id.length + 5);
        this.canonicalize = z;
    }

    private void reset() {
        this.index = 0;
        this.buffer = new StringBuilder(this.id.length + 5);
    }

    private void append(char c) {
        this.buffer.append(c);
    }

    private void addSeparator() {
        append('_');
    }

    private String getString(int i) {
        return this.buffer.substring(i);
    }

    private void set(int i, String str) {
        this.buffer.delete(i, this.buffer.length());
        this.buffer.insert(i, str);
    }

    private void append(String str) {
        this.buffer.append(str);
    }

    private char next() {
        if (this.index == this.id.length) {
            this.index++;
            return 65535;
        }
        char[] cArr = this.id;
        int i = this.index;
        this.index = i + 1;
        return cArr[i];
    }

    private void skipUntilTerminatorOrIDSeparator() {
        do {
        } while (!isTerminatorOrIDSeparator(next()));
        this.index--;
    }

    private boolean atTerminator() {
        return this.index >= this.id.length || isTerminator(this.id[this.index]);
    }

    private boolean isTerminator(char c) {
        return c == '@' || c == 65535 || c == '.';
    }

    private boolean isTerminatorOrIDSeparator(char c) {
        return c == '_' || c == '-' || isTerminator(c);
    }

    private boolean haveExperimentalLanguagePrefix() {
        if (this.id.length <= 2) {
            return false;
        }
        char c = this.id[1];
        if (c != '-' && c != '_') {
            return false;
        }
        char c2 = this.id[0];
        return c2 == 'x' || c2 == 'X' || c2 == 'i' || c2 == 'I';
    }

    private boolean haveKeywordAssign() {
        for (int i = this.index; i < this.id.length; i++) {
            if (this.id[i] == '=') {
                return true;
            }
        }
        return false;
    }

    private int parseLanguage() {
        String threeToTwoLetterLanguage;
        int length = this.buffer.length();
        if (haveExperimentalLanguagePrefix()) {
            append(AsciiUtil.toLower(this.id[0]));
            append('-');
            this.index = 2;
        }
        while (true) {
            char next = next();
            if (isTerminatorOrIDSeparator(next)) {
                break;
            }
            append(AsciiUtil.toLower(next));
        }
        this.index--;
        if (this.buffer.length() - length != 3 || (threeToTwoLetterLanguage = LocaleIDs.threeToTwoLetterLanguage(getString(0))) == null) {
            return 0;
        }
        set(0, threeToTwoLetterLanguage);
        return 0;
    }

    private void skipLanguage() {
        if (haveExperimentalLanguagePrefix()) {
            this.index = 2;
        }
        skipUntilTerminatorOrIDSeparator();
    }

    private int parseScript() {
        if (atTerminator()) {
            return this.buffer.length();
        }
        int i = this.index;
        this.index++;
        int length = this.buffer.length();
        boolean z = true;
        while (true) {
            char next = next();
            if (isTerminatorOrIDSeparator(next) || !AsciiUtil.isAlpha(next)) {
                break;
            } else if (z) {
                addSeparator();
                append(AsciiUtil.toUpper(next));
                z = false;
            } else {
                append(AsciiUtil.toLower(next));
            }
        }
        this.index--;
        if (this.index - i == 5) {
            return length + 1;
        }
        this.index = i;
        this.buffer.delete(length, this.buffer.length());
        return length;
    }

    private void skipScript() {
        char next;
        if (!atTerminator()) {
            int i = this.index;
            this.index++;
            do {
                next = next();
                if (isTerminatorOrIDSeparator(next)) {
                    break;
                }
            } while (AsciiUtil.isAlpha(next));
            this.index--;
            if (this.index - i != 5) {
                this.index = i;
            }
        }
    }

    private int parseCountry() {
        String threeToTwoLetterRegion;
        if (atTerminator()) {
            return this.buffer.length();
        }
        int i = this.index;
        this.index++;
        int length = this.buffer.length();
        boolean z = true;
        while (true) {
            char next = next();
            if (isTerminatorOrIDSeparator(next)) {
                break;
            }
            if (z) {
                this.hadCountry = true;
                addSeparator();
                length++;
                z = false;
            }
            append(AsciiUtil.toUpper(next));
        }
        this.index--;
        int length2 = this.buffer.length() - length;
        if (length2 == 0) {
            return length;
        }
        if (length2 < 2 || length2 > 3) {
            this.index = i;
            int i2 = length - 1;
            this.buffer.delete(i2, this.buffer.length());
            this.hadCountry = false;
            return i2;
        } else if (length2 != 3 || (threeToTwoLetterRegion = LocaleIDs.threeToTwoLetterRegion(getString(length))) == null) {
            return length;
        } else {
            set(length, threeToTwoLetterRegion);
            return length;
        }
    }

    private void skipCountry() {
        if (!atTerminator()) {
            if (this.id[this.index] == '_' || this.id[this.index] == '-') {
                this.index++;
            }
            int i = this.index;
            skipUntilTerminatorOrIDSeparator();
            int i2 = this.index - i;
            if (i2 < 2 || i2 > 3) {
                this.index = i;
            }
        }
    }

    private int parseVariant() {
        int length = this.buffer.length();
        boolean z = true;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = true;
        while (true) {
            char next = next();
            if (next == 65535) {
                break;
            } else if (next == '.') {
                z = false;
                z3 = true;
            } else if (next == '@') {
                if (haveKeywordAssign()) {
                    break;
                }
                z3 = false;
                z = false;
                z2 = true;
            } else if (z) {
                z = false;
                if (!(next == '_' || next == '-')) {
                    this.index--;
                }
            } else if (!z3) {
                if (z2) {
                    z2 = false;
                    if (z4 && !this.hadCountry) {
                        addSeparator();
                        length++;
                    }
                    addSeparator();
                    if (z4) {
                        length++;
                        z4 = false;
                    }
                }
                char upper = AsciiUtil.toUpper(next);
                if (upper == '-' || upper == ',') {
                    upper = '_';
                }
                append(upper);
            }
        }
        this.index--;
        return length;
    }

    public String getLanguage() {
        reset();
        return getString(parseLanguage());
    }

    public String getScript() {
        reset();
        skipLanguage();
        return getString(parseScript());
    }

    public String getCountry() {
        reset();
        skipLanguage();
        skipScript();
        return getString(parseCountry());
    }

    public String getVariant() {
        reset();
        skipLanguage();
        skipScript();
        skipCountry();
        return getString(parseVariant());
    }

    public String[] getLanguageScriptCountryVariant() {
        reset();
        return new String[]{getString(parseLanguage()), getString(parseScript()), getString(parseCountry()), getString(parseVariant())};
    }

    public void setBaseName(String str) {
        this.baseName = str;
    }

    public void parseBaseName() {
        if (this.baseName != null) {
            set(0, this.baseName);
            return;
        }
        reset();
        parseLanguage();
        parseScript();
        parseCountry();
        parseVariant();
        int length = this.buffer.length();
        if (length > 0 && this.buffer.charAt(length - 1) == '_') {
            this.buffer.deleteCharAt(length - 1);
        }
    }

    public String getBaseName() {
        if (this.baseName != null) {
            return this.baseName;
        }
        parseBaseName();
        return getString(0);
    }

    public String getName() {
        parseBaseName();
        parseKeywords();
        return getString(0);
    }

    private boolean setToKeywordStart() {
        for (int i = this.index; i < this.id.length; i++) {
            if (this.id[i] == '@') {
                if (this.canonicalize) {
                    int i2 = i + 1;
                    for (int i3 = i2; i3 < this.id.length; i3++) {
                        if (this.id[i3] == '=') {
                            this.index = i2;
                            return true;
                        }
                    }
                    return false;
                } else {
                    int i4 = i + 1;
                    if (i4 >= this.id.length) {
                        return false;
                    }
                    this.index = i4;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isDoneOrKeywordAssign(char c) {
        return c == 65535 || c == '=';
    }

    private static boolean isDoneOrItemSeparator(char c) {
        return c == 65535 || c == ';';
    }

    private String getKeyword() {
        int i = this.index;
        do {
        } while (!isDoneOrKeywordAssign(next()));
        this.index--;
        return AsciiUtil.toLowerString(new String(this.id, i, this.index - i).trim());
    }

    private String getValue() {
        int i = this.index;
        do {
        } while (!isDoneOrItemSeparator(next()));
        this.index--;
        return new String(this.id, i, this.index - i).trim();
    }

    private Comparator<String> getKeyComparator() {
        return new Comparator<String>() { // from class: com.ibm.icu.impl.LocaleIDParser.1
            public int compare(String str, String str2) {
                return str.compareTo(str2);
            }
        };
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
        if (r2.containsKey(r3) != false) goto L_0x0045;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.String, java.lang.String> getKeywordMap() {
        /*
            r6 = this;
            java.util.Map<java.lang.String, java.lang.String> r0 = r6.keywords
            if (r0 != 0) goto L_0x0057
            r2 = 0
            boolean r0 = r6.setToKeywordStart()
            if (r0 == 0) goto L_0x004d
        L_0x000b:
            java.lang.String r3 = r6.getKeyword()
            int r0 = r3.length()
            if (r0 != 0) goto L_0x0016
            goto L_0x004d
        L_0x0016:
            char r4 = r6.next()
            r0 = 61
            if (r4 == r0) goto L_0x0024
            r0 = 65535(0xffff, float:9.1834E-41)
            if (r4 != r0) goto L_0x0045
            goto L_0x004d
        L_0x0024:
            java.lang.String r5 = r6.getValue()
            int r0 = r5.length()
            if (r0 != 0) goto L_0x002f
            goto L_0x0045
        L_0x002f:
            if (r2 != 0) goto L_0x003b
            java.util.TreeMap r2 = new java.util.TreeMap
            java.util.Comparator r0 = r6.getKeyComparator()
            r2.<init>(r0)
            goto L_0x0042
        L_0x003b:
            boolean r0 = r2.containsKey(r3)
            if (r0 == 0) goto L_0x0042
            goto L_0x0045
        L_0x0042:
            r2.put(r3, r5)
        L_0x0045:
            char r0 = r6.next()
            r1 = 59
            if (r0 == r1) goto L_0x000b
        L_0x004d:
            if (r2 == 0) goto L_0x0051
            r0 = r2
            goto L_0x0055
        L_0x0051:
            java.util.Map r0 = java.util.Collections.emptyMap()
        L_0x0055:
            r6.keywords = r0
        L_0x0057:
            java.util.Map<java.lang.String, java.lang.String> r0 = r6.keywords
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.LocaleIDParser.getKeywordMap():java.util.Map");
    }

    private int parseKeywords() {
        int length = this.buffer.length();
        Map<String, String> keywordMap = getKeywordMap();
        if (keywordMap.isEmpty()) {
            return length;
        }
        boolean z = true;
        for (Map.Entry<String, String> entry : keywordMap.entrySet()) {
            append(z ? '@' : ';');
            z = false;
            append(entry.getKey());
            append('=');
            append(entry.getValue());
        }
        if (!z) {
            return length + 1;
        }
        return length;
    }

    public Iterator<String> getKeywords() {
        Map<String, String> keywordMap = getKeywordMap();
        if (keywordMap.isEmpty()) {
            return null;
        }
        return keywordMap.keySet().iterator();
    }

    public String getKeywordValue(String str) {
        Map<String, String> keywordMap = getKeywordMap();
        if (keywordMap.isEmpty()) {
            return null;
        }
        return keywordMap.get(AsciiUtil.toLowerString(str.trim()));
    }

    public void defaultKeywordValue(String str, String str2) {
        setKeywordValue(str, str2, false);
    }

    public void setKeywordValue(String str, String str2) {
        setKeywordValue(str, str2, true);
    }

    private void setKeywordValue(String str, String str2, boolean z) {
        if (str != null) {
            String lowerString = AsciiUtil.toLowerString(str.trim());
            if (lowerString.length() == 0) {
                throw new IllegalArgumentException("keyword must not be empty");
            }
            if (str2 != null) {
                str2 = str2.trim();
                if (str2.length() == 0) {
                    throw new IllegalArgumentException("value must not be empty");
                }
            }
            Map<String, String> keywordMap = getKeywordMap();
            if (keywordMap.isEmpty()) {
                if (str2 != null) {
                    this.keywords = new TreeMap(getKeyComparator());
                    this.keywords.put(lowerString, str2.trim());
                }
            } else if (!z && keywordMap.containsKey(lowerString)) {
            } else {
                if (str2 != null) {
                    keywordMap.put(lowerString, str2);
                    return;
                }
                keywordMap.remove(lowerString);
                if (keywordMap.isEmpty()) {
                    this.keywords = Collections.emptyMap();
                }
            }
        } else if (z) {
            this.keywords = Collections.emptyMap();
        }
    }
}

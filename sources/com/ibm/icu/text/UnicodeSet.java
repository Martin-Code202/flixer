package com.ibm.icu.text;

import com.ibm.icu.impl.BMPSet;
import com.ibm.icu.impl.Norm2AllModes;
import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.impl.RuleCharacterIterator;
import com.ibm.icu.impl.StringRange;
import com.ibm.icu.impl.UBiDiProps;
import com.ibm.icu.impl.UCaseProps;
import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.impl.UPropertyAliases;
import com.ibm.icu.impl.UnicodeSetStringSpan;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.lang.CharSequences;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.lang.UScript;
import com.ibm.icu.util.Freezable;
import com.ibm.icu.util.ICUUncheckedIOException;
import com.ibm.icu.util.OutputInt;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.VersionInfo;
import java.io.IOException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
public class UnicodeSet extends UnicodeFilter implements Iterable<String>, Comparable<UnicodeSet>, Freezable<UnicodeSet> {
    static final /* synthetic */ boolean $assertionsDisabled = (!UnicodeSet.class.desiredAssertionStatus());
    public static final UnicodeSet ALL_CODE_POINTS = new UnicodeSet(0, 1114111).freeze();
    public static final UnicodeSet EMPTY = new UnicodeSet().freeze();
    private static UnicodeSet[] INCLUSIONS = null;
    private static final VersionInfo NO_VERSION = VersionInfo.getInstance(0, 0, 0, 0);
    private static XSymbolTable XSYMBOL_TABLE = null;
    private volatile BMPSet bmpSet;
    private int[] buffer;
    private int len;
    private int[] list;
    private String pat;
    private int[] rangeList;
    private volatile UnicodeSetStringSpan stringSpan;
    TreeSet<String> strings;

    public enum ComparisonStyle {
        SHORTER_FIRST,
        LEXICOGRAPHIC,
        LONGER_FIRST
    }

    /* access modifiers changed from: package-private */
    public interface Filter {
        boolean contains(int i);
    }

    public enum SpanCondition {
        NOT_CONTAINED,
        CONTAINED,
        SIMPLE,
        CONDITION_COUNT
    }

    public UnicodeSet() {
        this.strings = new TreeSet<>();
        this.pat = null;
        this.list = new int[17];
        int[] iArr = this.list;
        int i = this.len;
        this.len = i + 1;
        iArr[i] = 1114112;
    }

    public UnicodeSet(UnicodeSet unicodeSet) {
        this.strings = new TreeSet<>();
        this.pat = null;
        set(unicodeSet);
    }

    public UnicodeSet(int i, int i2) {
        this();
        complement(i, i2);
    }

    public UnicodeSet(int... iArr) {
        this.strings = new TreeSet<>();
        this.pat = null;
        if ((iArr.length & 1) != 0) {
            throw new IllegalArgumentException("Must have even number of integers");
        }
        this.list = new int[(iArr.length + 1)];
        this.len = this.list.length;
        int i = -1;
        int i2 = 0;
        while (i2 < iArr.length) {
            int i3 = iArr[i2];
            if (i >= i3) {
                throw new IllegalArgumentException("Must be monotonically increasing.");
            }
            int i4 = i2 + 1;
            this.list[i2] = i3;
            int i5 = iArr[i4] + 1;
            if (i3 >= i5) {
                throw new IllegalArgumentException("Must be monotonically increasing.");
            }
            i2 = i4 + 1;
            i = i5;
            this.list[i4] = i5;
        }
        this.list[i2] = 1114112;
    }

    public UnicodeSet(String str) {
        this();
        applyPattern(str, (ParsePosition) null, (SymbolTable) null, 1);
    }

    @Override // java.lang.Object
    public Object clone() {
        if (isFrozen()) {
            return this;
        }
        UnicodeSet unicodeSet = new UnicodeSet(this);
        unicodeSet.bmpSet = this.bmpSet;
        unicodeSet.stringSpan = this.stringSpan;
        return unicodeSet;
    }

    public UnicodeSet set(int i, int i2) {
        checkFrozen();
        clear();
        complement(i, i2);
        return this;
    }

    public UnicodeSet set(UnicodeSet unicodeSet) {
        checkFrozen();
        this.list = (int[]) unicodeSet.list.clone();
        this.len = unicodeSet.len;
        this.pat = unicodeSet.pat;
        this.strings = new TreeSet<>((SortedSet<String>) unicodeSet.strings);
        return this;
    }

    public final UnicodeSet applyPattern(String str) {
        checkFrozen();
        return applyPattern(str, (ParsePosition) null, (SymbolTable) null, 1);
    }

    private static void appendCodePoint(Appendable appendable, int i) {
        if (!$assertionsDisabled && (0 > i || i > 1114111)) {
            throw new AssertionError();
        } else if (i <= 65535) {
            try {
                appendable.append((char) i);
            } catch (IOException e) {
                throw new ICUUncheckedIOException(e);
            }
        } else {
            appendable.append(UTF16.getLeadSurrogate(i)).append(UTF16.getTrailSurrogate(i));
        }
    }

    private static void append(Appendable appendable, CharSequence charSequence) {
        try {
            appendable.append(charSequence);
        } catch (IOException e) {
            throw new ICUUncheckedIOException(e);
        }
    }

    private static <T extends Appendable> T _appendToPat(T t, String str, boolean z) {
        int i = 0;
        while (i < str.length()) {
            int codePointAt = str.codePointAt(i);
            _appendToPat(t, codePointAt, z);
            i += Character.charCount(codePointAt);
        }
        return t;
    }

    private static <T extends Appendable> T _appendToPat(T t, int i, boolean z) {
        if (z) {
            try {
                if (Utility.isUnprintable(i) && Utility.escapeUnprintable(t, i)) {
                    return t;
                }
            } catch (IOException e) {
                throw new ICUUncheckedIOException(e);
            }
        }
        switch (i) {
            case 36:
            case 38:
            case 45:
            case 58:
            case 91:
            case 92:
            case 93:
            case 94:
            case 123:
            case 125:
                t.append('\\');
                break;
            default:
                if (PatternProps.isWhiteSpace(i)) {
                    t.append('\\');
                    break;
                }
                break;
        }
        appendCodePoint(t, i);
        return t;
    }

    public String toPattern(boolean z) {
        if (this.pat == null || z) {
            return ((StringBuilder) _toPattern(new StringBuilder(), z)).toString();
        }
        return this.pat;
    }

    private <T extends Appendable> T _toPattern(T t, boolean z) {
        if (this.pat == null) {
            return (T) appendNewPattern(t, z, true);
        }
        if (!z) {
            try {
                t.append(this.pat);
                return t;
            } catch (IOException e) {
                throw new ICUUncheckedIOException(e);
            }
        } else {
            boolean z2 = false;
            int i = 0;
            while (i < this.pat.length()) {
                int codePointAt = this.pat.codePointAt(i);
                i += Character.charCount(codePointAt);
                if (Utility.isUnprintable(codePointAt)) {
                    Utility.escapeUnprintable(t, codePointAt);
                    z2 = false;
                } else if (z2 || codePointAt != 92) {
                    if (z2) {
                        t.append('\\');
                    }
                    appendCodePoint(t, codePointAt);
                    z2 = false;
                } else {
                    z2 = true;
                }
            }
            if (z2) {
                t.append('\\');
            }
            return t;
        }
    }

    private <T extends Appendable> T appendNewPattern(T t, boolean z, boolean z2) {
        try {
            t.append('[');
            int rangeCount = getRangeCount();
            if (rangeCount > 1 && getRangeStart(0) == 0 && getRangeEnd(rangeCount - 1) == 1114111) {
                t.append('^');
                for (int i = 1; i < rangeCount; i++) {
                    int rangeEnd = getRangeEnd(i - 1) + 1;
                    int rangeStart = getRangeStart(i) - 1;
                    _appendToPat(t, rangeEnd, z);
                    if (rangeEnd != rangeStart) {
                        if (rangeEnd + 1 != rangeStart) {
                            t.append('-');
                        }
                        _appendToPat(t, rangeStart, z);
                    }
                }
            } else {
                for (int i2 = 0; i2 < rangeCount; i2++) {
                    int rangeStart2 = getRangeStart(i2);
                    int rangeEnd2 = getRangeEnd(i2);
                    _appendToPat(t, rangeStart2, z);
                    if (rangeStart2 != rangeEnd2) {
                        if (rangeStart2 + 1 != rangeEnd2) {
                            t.append('-');
                        }
                        _appendToPat(t, rangeEnd2, z);
                    }
                }
            }
            if (z2 && this.strings.size() > 0) {
                Iterator<String> it = this.strings.iterator();
                while (it.hasNext()) {
                    t.append('{');
                    _appendToPat(t, it.next(), z);
                    t.append('}');
                }
            }
            t.append(']');
            return t;
        } catch (IOException e) {
            throw new ICUUncheckedIOException(e);
        }
    }

    public int size() {
        int i = 0;
        int rangeCount = getRangeCount();
        for (int i2 = 0; i2 < rangeCount; i2++) {
            i += (getRangeEnd(i2) - getRangeStart(i2)) + 1;
        }
        return this.strings.size() + i;
    }

    public boolean isEmpty() {
        return this.len == 1 && this.strings.size() == 0;
    }

    public UnicodeSet add(int i, int i2) {
        checkFrozen();
        return add_unchecked(i, i2);
    }

    private UnicodeSet add_unchecked(int i, int i2) {
        if (i < 0 || i > 1114111) {
            throw new IllegalArgumentException("Invalid code point U+" + Utility.hex((long) i, 6));
        } else if (i2 < 0 || i2 > 1114111) {
            throw new IllegalArgumentException("Invalid code point U+" + Utility.hex((long) i2, 6));
        } else {
            if (i < i2) {
                add(range(i, i2), 2, 0);
            } else if (i == i2) {
                add(i);
            }
            return this;
        }
    }

    public final UnicodeSet add(int i) {
        checkFrozen();
        return add_unchecked(i);
    }

    private final UnicodeSet add_unchecked(int i) {
        if (i < 0 || i > 1114111) {
            throw new IllegalArgumentException("Invalid code point U+" + Utility.hex((long) i, 6));
        }
        int findCodePoint = findCodePoint(i);
        if ((findCodePoint & 1) != 0) {
            return this;
        }
        if (i == this.list[findCodePoint] - 1) {
            this.list[findCodePoint] = i;
            if (i == 1114111) {
                ensureCapacity(this.len + 1);
                int[] iArr = this.list;
                int i2 = this.len;
                this.len = i2 + 1;
                iArr[i2] = 1114112;
            }
            if (findCodePoint > 0 && i == this.list[findCodePoint - 1]) {
                System.arraycopy(this.list, findCodePoint + 1, this.list, findCodePoint - 1, (this.len - findCodePoint) - 1);
                this.len -= 2;
            }
        } else if (findCodePoint <= 0 || i != this.list[findCodePoint - 1]) {
            if (this.len + 2 > this.list.length) {
                int[] iArr2 = new int[(this.len + 2 + 16)];
                if (findCodePoint != 0) {
                    System.arraycopy(this.list, 0, iArr2, 0, findCodePoint);
                }
                System.arraycopy(this.list, findCodePoint, iArr2, findCodePoint + 2, this.len - findCodePoint);
                this.list = iArr2;
            } else {
                System.arraycopy(this.list, findCodePoint, this.list, findCodePoint + 2, this.len - findCodePoint);
            }
            this.list[findCodePoint] = i;
            this.list[findCodePoint + 1] = i + 1;
            this.len += 2;
        } else {
            int[] iArr3 = this.list;
            int i3 = findCodePoint - 1;
            iArr3[i3] = iArr3[i3] + 1;
        }
        this.pat = null;
        return this;
    }

    public final UnicodeSet add(CharSequence charSequence) {
        checkFrozen();
        int singleCP = getSingleCP(charSequence);
        if (singleCP < 0) {
            this.strings.add(charSequence.toString());
            this.pat = null;
        } else {
            add_unchecked(singleCP, singleCP);
        }
        return this;
    }

    private static int getSingleCP(CharSequence charSequence) {
        if (charSequence.length() < 1) {
            throw new IllegalArgumentException("Can't use zero-length strings in UnicodeSet");
        } else if (charSequence.length() > 2) {
            return -1;
        } else {
            if (charSequence.length() == 1) {
                return charSequence.charAt(0);
            }
            int charAt = UTF16.charAt(charSequence, 0);
            if (charAt > 65535) {
                return charAt;
            }
            return -1;
        }
    }

    public UnicodeSet remove(int i, int i2) {
        checkFrozen();
        if (i < 0 || i > 1114111) {
            throw new IllegalArgumentException("Invalid code point U+" + Utility.hex((long) i, 6));
        } else if (i2 < 0 || i2 > 1114111) {
            throw new IllegalArgumentException("Invalid code point U+" + Utility.hex((long) i2, 6));
        } else {
            if (i <= i2) {
                retain(range(i, i2), 2, 2);
            }
            return this;
        }
    }

    public final UnicodeSet remove(int i) {
        return remove(i, i);
    }

    public UnicodeSet complement(int i, int i2) {
        checkFrozen();
        if (i < 0 || i > 1114111) {
            throw new IllegalArgumentException("Invalid code point U+" + Utility.hex((long) i, 6));
        } else if (i2 < 0 || i2 > 1114111) {
            throw new IllegalArgumentException("Invalid code point U+" + Utility.hex((long) i2, 6));
        } else {
            if (i <= i2) {
                xor(range(i, i2), 2, 0);
            }
            this.pat = null;
            return this;
        }
    }

    public UnicodeSet complement() {
        checkFrozen();
        if (this.list[0] == 0) {
            System.arraycopy(this.list, 1, this.list, 0, this.len - 1);
            this.len--;
        } else {
            ensureCapacity(this.len + 1);
            System.arraycopy(this.list, 0, this.list, 1, this.len);
            this.list[0] = 0;
            this.len++;
        }
        this.pat = null;
        return this;
    }

    public boolean contains(int i) {
        if (i < 0 || i > 1114111) {
            throw new IllegalArgumentException("Invalid code point U+" + Utility.hex((long) i, 6));
        } else if (this.bmpSet != null) {
            return this.bmpSet.contains(i);
        } else {
            if (this.stringSpan != null) {
                return this.stringSpan.contains(i);
            }
            return (findCodePoint(i) & 1) != 0;
        }
    }

    private final int findCodePoint(int i) {
        if (i < this.list[0]) {
            return 0;
        }
        if (this.len >= 2 && i >= this.list[this.len - 2]) {
            return this.len - 1;
        }
        int i2 = 0;
        int i3 = this.len - 1;
        while (true) {
            int i4 = (i2 + i3) >>> 1;
            if (i4 == i2) {
                return i3;
            }
            if (i < this.list[i4]) {
                i3 = i4;
            } else {
                i2 = i4;
            }
        }
    }

    public boolean containsAll(String str) {
        int i = 0;
        while (i < str.length()) {
            int charAt = UTF16.charAt(str, i);
            if (contains(charAt)) {
                i += UTF16.getCharCount(charAt);
            } else if (this.strings.size() == 0) {
                return false;
            } else {
                return containsAll(str, 0);
            }
        }
        return true;
    }

    private boolean containsAll(String str, int i) {
        if (i >= str.length()) {
            return true;
        }
        int charAt = UTF16.charAt(str, i);
        if (contains(charAt) && containsAll(str, UTF16.getCharCount(charAt) + i)) {
            return true;
        }
        Iterator<String> it = this.strings.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (str.startsWith(next, i) && containsAll(str, next.length() + i)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsNone(int i, int i2) {
        if (i < 0 || i > 1114111) {
            throw new IllegalArgumentException("Invalid code point U+" + Utility.hex((long) i, 6));
        } else if (i2 < 0 || i2 > 1114111) {
            throw new IllegalArgumentException("Invalid code point U+" + Utility.hex((long) i2, 6));
        } else {
            int i3 = -1;
            do {
                i3++;
            } while (i >= this.list[i3]);
            return (i3 & 1) == 0 && i2 < this.list[i3];
        }
    }

    public final boolean containsSome(int i, int i2) {
        return !containsNone(i, i2);
    }

    public UnicodeSet addAll(UnicodeSet unicodeSet) {
        checkFrozen();
        add(unicodeSet.list, unicodeSet.len, 0);
        this.strings.addAll(unicodeSet.strings);
        return this;
    }

    public UnicodeSet retainAll(UnicodeSet unicodeSet) {
        checkFrozen();
        retain(unicodeSet.list, unicodeSet.len, 0);
        this.strings.retainAll(unicodeSet.strings);
        return this;
    }

    public UnicodeSet removeAll(UnicodeSet unicodeSet) {
        checkFrozen();
        retain(unicodeSet.list, unicodeSet.len, 2);
        this.strings.removeAll(unicodeSet.strings);
        return this;
    }

    public UnicodeSet clear() {
        checkFrozen();
        this.list[0] = 1114112;
        this.len = 1;
        this.pat = null;
        this.strings.clear();
        return this;
    }

    public int getRangeCount() {
        return this.len / 2;
    }

    public int getRangeStart(int i) {
        return this.list[i * 2];
    }

    public int getRangeEnd(int i) {
        return this.list[(i * 2) + 1] - 1;
    }

    public UnicodeSet compact() {
        checkFrozen();
        if (this.len != this.list.length) {
            int[] iArr = new int[this.len];
            System.arraycopy(this.list, 0, iArr, 0, this.len);
            this.list = iArr;
        }
        this.rangeList = null;
        this.buffer = null;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        try {
            UnicodeSet unicodeSet = (UnicodeSet) obj;
            if (this.len != unicodeSet.len) {
                return false;
            }
            for (int i = 0; i < this.len; i++) {
                if (this.list[i] != unicodeSet.list[i]) {
                    return false;
                }
            }
            if (!this.strings.equals(unicodeSet.strings)) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = this.len;
        for (int i2 = 0; i2 < this.len; i2++) {
            i = (i * 1000003) + this.list[i2];
        }
        return i;
    }

    @Override // java.lang.Object
    public String toString() {
        return toPattern(true);
    }

    @Deprecated
    public UnicodeSet applyPattern(String str, ParsePosition parsePosition, SymbolTable symbolTable, int i) {
        boolean z = parsePosition == null;
        if (z) {
            parsePosition = new ParsePosition(0);
        }
        StringBuilder sb = new StringBuilder();
        RuleCharacterIterator ruleCharacterIterator = new RuleCharacterIterator(str, symbolTable, parsePosition);
        applyPattern(ruleCharacterIterator, symbolTable, sb, i);
        if (ruleCharacterIterator.inVariable()) {
            syntaxError(ruleCharacterIterator, "Extra chars in variable value");
        }
        this.pat = sb.toString();
        if (z) {
            int index = parsePosition.getIndex();
            if ((i & 1) != 0) {
                index = PatternProps.skipWhiteSpace(str, index);
            }
            if (index != str.length()) {
                throw new IllegalArgumentException("Parse of \"" + str + "\" failed at " + index);
            }
        }
        return this;
    }

    private void applyPattern(RuleCharacterIterator ruleCharacterIterator, SymbolTable symbolTable, Appendable appendable, int i) {
        UnicodeMatcher lookupMatcher;
        int i2 = 3;
        if ((i & 1) != 0) {
            i2 = 7;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = null;
        boolean z = false;
        UnicodeSet unicodeSet = null;
        Object obj = null;
        char c = 0;
        int i3 = 0;
        char c2 = 0;
        char c3 = 0;
        boolean z2 = false;
        clear();
        String str = null;
        while (true) {
            if (c2 != 2 && !ruleCharacterIterator.atEnd()) {
                int i4 = 0;
                boolean z3 = false;
                UnicodeSet unicodeSet2 = null;
                char c4 = 0;
                if (resemblesPropertyPattern(ruleCharacterIterator, i2)) {
                    c4 = 2;
                } else {
                    obj = ruleCharacterIterator.getPos(obj);
                    i4 = ruleCharacterIterator.next(i2);
                    z3 = ruleCharacterIterator.isEscaped();
                    if (i4 != 91 || z3) {
                        if (!(symbolTable == null || (lookupMatcher = symbolTable.lookupMatcher(i4)) == null)) {
                            try {
                                unicodeSet2 = (UnicodeSet) lookupMatcher;
                                c4 = 3;
                            } catch (ClassCastException e) {
                                syntaxError(ruleCharacterIterator, "Syntax error");
                            }
                        }
                    } else if (c2 == 1) {
                        ruleCharacterIterator.setPos(obj);
                        c4 = 1;
                    } else {
                        c2 = 1;
                        sb.append('[');
                        obj = ruleCharacterIterator.getPos(obj);
                        i4 = ruleCharacterIterator.next(i2);
                        boolean isEscaped = ruleCharacterIterator.isEscaped();
                        if (i4 == 94 && !isEscaped) {
                            z2 = true;
                            sb.append('^');
                            obj = ruleCharacterIterator.getPos(obj);
                            i4 = ruleCharacterIterator.next(i2);
                            ruleCharacterIterator.isEscaped();
                        }
                        if (i4 == 45) {
                            z3 = true;
                        } else {
                            ruleCharacterIterator.setPos(obj);
                        }
                    }
                }
                if (c4 != 0) {
                    if (c == 1) {
                        if (c3 != 0) {
                            syntaxError(ruleCharacterIterator, "Char expected after operator");
                        }
                        add_unchecked(i3, i3);
                        _appendToPat(sb, i3, false);
                        c3 = 0;
                    }
                    if (c3 == '-' || c3 == '&') {
                        sb.append(c3);
                    }
                    if (unicodeSet2 == null) {
                        if (unicodeSet == null) {
                            unicodeSet = new UnicodeSet();
                        }
                        unicodeSet2 = unicodeSet;
                    }
                    switch (c4) {
                        case 1:
                            unicodeSet2.applyPattern(ruleCharacterIterator, symbolTable, sb, i);
                            break;
                        case 2:
                            ruleCharacterIterator.skipIgnored(i2);
                            unicodeSet2.applyPropertyPattern(ruleCharacterIterator, sb, symbolTable);
                            break;
                        case 3:
                            unicodeSet2._toPattern(sb, false);
                            break;
                    }
                    z = true;
                    if (c2 == 0) {
                        set(unicodeSet2);
                        c2 = 2;
                    } else {
                        switch (c3) {
                            case 0:
                                addAll(unicodeSet2);
                                break;
                            case '&':
                                retainAll(unicodeSet2);
                                break;
                            case '-':
                                removeAll(unicodeSet2);
                                break;
                        }
                        c3 = 0;
                        c = 2;
                    }
                } else {
                    if (c2 == 0) {
                        syntaxError(ruleCharacterIterator, "Missing '['");
                    }
                    if (!z3) {
                        switch (i4) {
                            case 36:
                                obj = ruleCharacterIterator.getPos(obj);
                                i4 = ruleCharacterIterator.next(i2);
                                boolean z4 = i4 == 93 && !ruleCharacterIterator.isEscaped();
                                if (symbolTable != null || z4) {
                                    if (z4 && c3 == 0) {
                                        if (c == 1) {
                                            add_unchecked(i3, i3);
                                            _appendToPat(sb, i3, false);
                                        }
                                        add_unchecked(65535);
                                        z = true;
                                        sb.append('$').append(']');
                                        c2 = 2;
                                        break;
                                    } else {
                                        syntaxError(ruleCharacterIterator, "Unquoted '$'");
                                        break;
                                    }
                                } else {
                                    i4 = 36;
                                    ruleCharacterIterator.setPos(obj);
                                    break;
                                }
                                break;
                            case 38:
                                if (c != 2 || c3 != 0) {
                                    syntaxError(ruleCharacterIterator, "'&' not after set");
                                    break;
                                } else {
                                    c3 = (char) i4;
                                    break;
                                }
                                break;
                            case 45:
                                if (c3 == 0) {
                                    if (c == 0) {
                                        if (str == null) {
                                            add_unchecked(i4, i4);
                                            i4 = ruleCharacterIterator.next(i2);
                                            boolean isEscaped2 = ruleCharacterIterator.isEscaped();
                                            if (i4 == 93 && !isEscaped2) {
                                                sb.append("-]");
                                                c2 = 2;
                                                break;
                                            }
                                        } else {
                                            c3 = (char) i4;
                                            break;
                                        }
                                    } else {
                                        c3 = (char) i4;
                                        break;
                                    }
                                }
                                syntaxError(ruleCharacterIterator, "'-' not after char, string, or set");
                                break;
                            case 93:
                                if (c == 1) {
                                    add_unchecked(i3, i3);
                                    _appendToPat(sb, i3, false);
                                }
                                if (c3 == '-') {
                                    add_unchecked(c3, c3);
                                    sb.append(c3);
                                } else if (c3 == '&') {
                                    syntaxError(ruleCharacterIterator, "Trailing '&'");
                                }
                                sb.append(']');
                                c2 = 2;
                                break;
                            case 94:
                                syntaxError(ruleCharacterIterator, "'^' not after '['");
                                break;
                            case 123:
                                if (!(c3 == 0 || c3 == '-')) {
                                    syntaxError(ruleCharacterIterator, "Missing operand after operator");
                                }
                                if (c == 1) {
                                    add_unchecked(i3, i3);
                                    _appendToPat(sb, i3, false);
                                }
                                c = 0;
                                if (sb2 == null) {
                                    sb2 = new StringBuilder();
                                } else {
                                    sb2.setLength(0);
                                }
                                boolean z5 = false;
                                while (true) {
                                    if (!ruleCharacterIterator.atEnd()) {
                                        int next = ruleCharacterIterator.next(i2);
                                        boolean isEscaped3 = ruleCharacterIterator.isEscaped();
                                        if (next != 125 || isEscaped3) {
                                            appendCodePoint(sb2, next);
                                        } else {
                                            z5 = true;
                                        }
                                    }
                                }
                                if (sb2.length() < 1 || !z5) {
                                    syntaxError(ruleCharacterIterator, "Invalid multicharacter string");
                                }
                                String sb3 = sb2.toString();
                                if (c3 == '-') {
                                    int singleCodePoint = CharSequences.getSingleCodePoint(str == null ? "" : str);
                                    int singleCodePoint2 = CharSequences.getSingleCodePoint(sb3);
                                    if (singleCodePoint == Integer.MAX_VALUE || singleCodePoint2 == Integer.MAX_VALUE) {
                                        try {
                                            StringRange.expand(str, sb3, true, this.strings);
                                        } catch (Exception e2) {
                                            syntaxError(ruleCharacterIterator, e2.getMessage());
                                        }
                                    } else {
                                        add(singleCodePoint, singleCodePoint2);
                                    }
                                    str = null;
                                    c3 = 0;
                                } else {
                                    add(sb3);
                                    str = sb3;
                                }
                                sb.append('{');
                                _appendToPat(sb, sb3, false);
                                sb.append('}');
                                break;
                        }
                    }
                    switch (c) {
                        case 0:
                            if (c3 == '-' && str != null) {
                                syntaxError(ruleCharacterIterator, "Invalid range");
                            }
                            c = 1;
                            i3 = i4;
                            str = null;
                            continue;
                        case 1:
                            if (c3 != '-') {
                                add_unchecked(i3, i3);
                                _appendToPat(sb, i3, false);
                                i3 = i4;
                                break;
                            } else {
                                if (str != null) {
                                    syntaxError(ruleCharacterIterator, "Invalid range");
                                }
                                if (i3 >= i4) {
                                    syntaxError(ruleCharacterIterator, "Invalid range");
                                }
                                add_unchecked(i3, i4);
                                _appendToPat(sb, i3, false);
                                sb.append(c3);
                                _appendToPat(sb, i4, false);
                                c = 0;
                                c3 = 0;
                                continue;
                            }
                        case 2:
                            if (c3 != 0) {
                                syntaxError(ruleCharacterIterator, "Set expected after operator");
                            }
                            i3 = i4;
                            c = 1;
                            continue;
                    }
                }
            }
        }
        if (c2 != 2) {
            syntaxError(ruleCharacterIterator, "Missing ']'");
        }
        ruleCharacterIterator.skipIgnored(i2);
        if ((i & 2) != 0) {
            closeOver(2);
        }
        if (z2) {
            complement();
        }
        if (z) {
            append(appendable, sb.toString());
        } else {
            appendNewPattern(appendable, false, true);
        }
    }

    private static void syntaxError(RuleCharacterIterator ruleCharacterIterator, String str) {
        throw new IllegalArgumentException("Error: " + str + " at \"" + Utility.escape(ruleCharacterIterator.toString()) + '\"');
    }

    private void ensureCapacity(int i) {
        if (i > this.list.length) {
            int[] iArr = new int[(i + 16)];
            System.arraycopy(this.list, 0, iArr, 0, this.len);
            this.list = iArr;
        }
    }

    private void ensureBufferCapacity(int i) {
        if (this.buffer == null || i > this.buffer.length) {
            this.buffer = new int[(i + 16)];
        }
    }

    private int[] range(int i, int i2) {
        if (this.rangeList == null) {
            this.rangeList = new int[]{i, i2 + 1, 1114112};
        } else {
            this.rangeList[0] = i;
            this.rangeList[1] = i2 + 1;
        }
        return this.rangeList;
    }

    private UnicodeSet xor(int[] iArr, int i, int i2) {
        int i3;
        ensureBufferCapacity(this.len + i);
        int i4 = 0;
        int i5 = 0;
        int i6 = 0 + 1;
        int i7 = this.list[0];
        if (i2 == 1 || i2 == 2) {
            i3 = 0;
            if (iArr[0] == 0) {
                i4 = 0 + 1;
                i3 = iArr[i4];
            }
        } else {
            i4 = 0 + 1;
            i3 = iArr[0];
        }
        while (true) {
            if (i7 < i3) {
                i5++;
                this.buffer[i5] = i7;
                i6++;
                i7 = this.list[i6];
            } else if (i3 < i7) {
                i5++;
                this.buffer[i5] = i3;
                i4++;
                i3 = iArr[i4];
            } else if (i7 != 1114112) {
                i6++;
                i7 = this.list[i6];
                i4++;
                i3 = iArr[i4];
            } else {
                this.buffer[i5] = 1114112;
                this.len = i5 + 1;
                int[] iArr2 = this.list;
                this.list = this.buffer;
                this.buffer = iArr2;
                this.pat = null;
                return this;
            }
        }
    }

    private UnicodeSet add(int[] iArr, int i, int i2) {
        ensureBufferCapacity(this.len + i);
        int i3 = 0;
        int i4 = 0 + 1;
        int i5 = this.list[0];
        int i6 = 0 + 1;
        int i7 = iArr[0];
        while (true) {
            switch (i2) {
                case 0:
                    if (i5 < i7) {
                        if (i3 <= 0 || i5 > this.buffer[i3 - 1]) {
                            i3++;
                            this.buffer[i3] = i5;
                            i5 = this.list[i4];
                        } else {
                            i3--;
                            i5 = max(this.list[i4], this.buffer[i3]);
                        }
                        i4++;
                        i2 ^= 1;
                    } else if (i7 < i5) {
                        if (i3 <= 0 || i7 > this.buffer[i3 - 1]) {
                            i3++;
                            this.buffer[i3] = i7;
                            i7 = iArr[i6];
                        } else {
                            i3--;
                            i7 = max(iArr[i6], this.buffer[i3]);
                        }
                        i6++;
                        i2 ^= 2;
                    } else if (i5 == 1114112) {
                        break;
                    } else {
                        if (i3 <= 0 || i5 > this.buffer[i3 - 1]) {
                            i3++;
                            this.buffer[i3] = i5;
                            i5 = this.list[i4];
                        } else {
                            i3--;
                            i5 = max(this.list[i4], this.buffer[i3]);
                        }
                        i4++;
                        i6++;
                        i7 = iArr[i6];
                        i2 = (i2 ^ 1) ^ 2;
                    }
                    break;
                case 1:
                    if (i5 < i7) {
                        i3++;
                        this.buffer[i3] = i5;
                        i4++;
                        i5 = this.list[i4];
                        i2 ^= 1;
                    } else if (i7 < i5) {
                        i6++;
                        i7 = iArr[i6];
                        i2 ^= 2;
                    } else if (i5 == 1114112) {
                        break;
                    } else {
                        i4++;
                        i5 = this.list[i4];
                        i6++;
                        i7 = iArr[i6];
                        i2 = (i2 ^ 1) ^ 2;
                    }
                case 2:
                    if (i7 < i5) {
                        i3++;
                        this.buffer[i3] = i7;
                        i6++;
                        i7 = iArr[i6];
                        i2 ^= 2;
                    } else if (i5 < i7) {
                        i4++;
                        i5 = this.list[i4];
                        i2 ^= 1;
                    } else if (i5 == 1114112) {
                        break;
                    } else {
                        i4++;
                        i5 = this.list[i4];
                        i6++;
                        i7 = iArr[i6];
                        i2 = (i2 ^ 1) ^ 2;
                    }
                case 3:
                    if (i7 <= i5) {
                        if (i5 == 1114112) {
                            break;
                        } else {
                            i3++;
                            this.buffer[i3] = i5;
                        }
                    } else if (i7 == 1114112) {
                        break;
                    } else {
                        i3++;
                        this.buffer[i3] = i7;
                    }
                    i4++;
                    i5 = this.list[i4];
                    i6++;
                    i7 = iArr[i6];
                    i2 = (i2 ^ 1) ^ 2;
            }
        }
        this.buffer[i3] = 1114112;
        this.len = i3 + 1;
        int[] iArr2 = this.list;
        this.list = this.buffer;
        this.buffer = iArr2;
        this.pat = null;
        return this;
    }

    private UnicodeSet retain(int[] iArr, int i, int i2) {
        ensureBufferCapacity(this.len + i);
        int i3 = 0;
        int i4 = 0 + 1;
        int i5 = this.list[0];
        int i6 = 0 + 1;
        int i7 = iArr[0];
        while (true) {
            switch (i2) {
                case 0:
                    if (i5 < i7) {
                        i4++;
                        i5 = this.list[i4];
                        i2 ^= 1;
                    } else if (i7 < i5) {
                        i6++;
                        i7 = iArr[i6];
                        i2 ^= 2;
                    } else if (i5 == 1114112) {
                        break;
                    } else {
                        i3++;
                        this.buffer[i3] = i5;
                        i4++;
                        i5 = this.list[i4];
                        i6++;
                        i7 = iArr[i6];
                        i2 = (i2 ^ 1) ^ 2;
                    }
                case 1:
                    if (i5 < i7) {
                        i4++;
                        i5 = this.list[i4];
                        i2 ^= 1;
                    } else if (i7 < i5) {
                        i3++;
                        this.buffer[i3] = i7;
                        i6++;
                        i7 = iArr[i6];
                        i2 ^= 2;
                    } else if (i5 == 1114112) {
                        break;
                    } else {
                        i4++;
                        i5 = this.list[i4];
                        i6++;
                        i7 = iArr[i6];
                        i2 = (i2 ^ 1) ^ 2;
                    }
                case 2:
                    if (i7 < i5) {
                        i6++;
                        i7 = iArr[i6];
                        i2 ^= 2;
                    } else if (i5 < i7) {
                        i3++;
                        this.buffer[i3] = i5;
                        i4++;
                        i5 = this.list[i4];
                        i2 ^= 1;
                    } else if (i5 == 1114112) {
                        break;
                    } else {
                        i4++;
                        i5 = this.list[i4];
                        i6++;
                        i7 = iArr[i6];
                        i2 = (i2 ^ 1) ^ 2;
                    }
                case 3:
                    if (i5 < i7) {
                        i3++;
                        this.buffer[i3] = i5;
                        i4++;
                        i5 = this.list[i4];
                        i2 ^= 1;
                    } else if (i7 < i5) {
                        i3++;
                        this.buffer[i3] = i7;
                        i6++;
                        i7 = iArr[i6];
                        i2 ^= 2;
                    } else if (i5 == 1114112) {
                        break;
                    } else {
                        i3++;
                        this.buffer[i3] = i5;
                        i4++;
                        i5 = this.list[i4];
                        i6++;
                        i7 = iArr[i6];
                        i2 = (i2 ^ 1) ^ 2;
                    }
            }
        }
        this.buffer[i3] = 1114112;
        this.len = i3 + 1;
        int[] iArr2 = this.list;
        this.list = this.buffer;
        this.buffer = iArr2;
        this.pat = null;
        return this;
    }

    private static final int max(int i, int i2) {
        return i > i2 ? i : i2;
    }

    /* access modifiers changed from: package-private */
    public static class NumericValueFilter implements Filter {
        double value;

        NumericValueFilter(double d) {
            this.value = d;
        }

        @Override // com.ibm.icu.text.UnicodeSet.Filter
        public boolean contains(int i) {
            return UCharacter.getUnicodeNumericValue(i) == this.value;
        }
    }

    /* access modifiers changed from: package-private */
    public static class GeneralCategoryMaskFilter implements Filter {
        int mask;

        GeneralCategoryMaskFilter(int i) {
            this.mask = i;
        }

        @Override // com.ibm.icu.text.UnicodeSet.Filter
        public boolean contains(int i) {
            return ((1 << UCharacter.getType(i)) & this.mask) != 0;
        }
    }

    /* access modifiers changed from: package-private */
    public static class IntPropertyFilter implements Filter {
        int prop;
        int value;

        IntPropertyFilter(int i, int i2) {
            this.prop = i;
            this.value = i2;
        }

        @Override // com.ibm.icu.text.UnicodeSet.Filter
        public boolean contains(int i) {
            return UCharacter.getIntPropertyValue(i, this.prop) == this.value;
        }
    }

    /* access modifiers changed from: package-private */
    public static class ScriptExtensionsFilter implements Filter {
        int script;

        ScriptExtensionsFilter(int i) {
            this.script = i;
        }

        @Override // com.ibm.icu.text.UnicodeSet.Filter
        public boolean contains(int i) {
            return UScript.hasScript(i, this.script);
        }
    }

    /* access modifiers changed from: package-private */
    public static class VersionFilter implements Filter {
        VersionInfo version;

        VersionFilter(VersionInfo versionInfo) {
            this.version = versionInfo;
        }

        @Override // com.ibm.icu.text.UnicodeSet.Filter
        public boolean contains(int i) {
            VersionInfo age = UCharacter.getAge(i);
            return !Utility.sameObjects(age, UnicodeSet.NO_VERSION) && age.compareTo(this.version) <= 0;
        }
    }

    private static synchronized UnicodeSet getInclusions(int i) {
        UnicodeSet unicodeSet;
        synchronized (UnicodeSet.class) {
            if (INCLUSIONS == null) {
                INCLUSIONS = new UnicodeSet[12];
            }
            if (INCLUSIONS[i] == null) {
                UnicodeSet unicodeSet2 = new UnicodeSet();
                switch (i) {
                    case 1:
                        UCharacterProperty.INSTANCE.addPropertyStarts(unicodeSet2);
                        INCLUSIONS[i] = unicodeSet2;
                        break;
                    case 2:
                        UCharacterProperty.INSTANCE.upropsvec_addPropertyStarts(unicodeSet2);
                        INCLUSIONS[i] = unicodeSet2;
                        break;
                    case 3:
                        throw new IllegalStateException("UnicodeSet.getInclusions(unknown src " + i + ")");
                    case 4:
                        UCaseProps.INSTANCE.addPropertyStarts(unicodeSet2);
                        INCLUSIONS[i] = unicodeSet2;
                        break;
                    case 5:
                        UBiDiProps.INSTANCE.addPropertyStarts(unicodeSet2);
                        INCLUSIONS[i] = unicodeSet2;
                        break;
                    case 6:
                        UCharacterProperty.INSTANCE.addPropertyStarts(unicodeSet2);
                        UCharacterProperty.INSTANCE.upropsvec_addPropertyStarts(unicodeSet2);
                        INCLUSIONS[i] = unicodeSet2;
                        break;
                    case 7:
                        Norm2AllModes.getNFCInstance().impl.addPropertyStarts(unicodeSet2);
                        UCaseProps.INSTANCE.addPropertyStarts(unicodeSet2);
                        INCLUSIONS[i] = unicodeSet2;
                        break;
                    case 8:
                        Norm2AllModes.getNFCInstance().impl.addPropertyStarts(unicodeSet2);
                        INCLUSIONS[i] = unicodeSet2;
                        break;
                    case 9:
                        Norm2AllModes.getNFKCInstance().impl.addPropertyStarts(unicodeSet2);
                        INCLUSIONS[i] = unicodeSet2;
                        break;
                    case 10:
                        Norm2AllModes.getNFKC_CFInstance().impl.addPropertyStarts(unicodeSet2);
                        INCLUSIONS[i] = unicodeSet2;
                        break;
                    case 11:
                        Norm2AllModes.getNFCInstance().impl.addCanonIterPropertyStarts(unicodeSet2);
                        INCLUSIONS[i] = unicodeSet2;
                        break;
                    default:
                        throw new IllegalStateException("UnicodeSet.getInclusions(unknown src " + i + ")");
                }
            }
            unicodeSet = INCLUSIONS[i];
        }
        return unicodeSet;
    }

    private UnicodeSet applyFilter(Filter filter, int i) {
        clear();
        int i2 = -1;
        UnicodeSet inclusions = getInclusions(i);
        int rangeCount = inclusions.getRangeCount();
        for (int i3 = 0; i3 < rangeCount; i3++) {
            int rangeStart = inclusions.getRangeStart(i3);
            int rangeEnd = inclusions.getRangeEnd(i3);
            for (int i4 = rangeStart; i4 <= rangeEnd; i4++) {
                if (filter.contains(i4)) {
                    if (i2 < 0) {
                        i2 = i4;
                    }
                } else if (i2 >= 0) {
                    add_unchecked(i2, i4 - 1);
                    i2 = -1;
                }
            }
        }
        if (i2 >= 0) {
            add_unchecked(i2, 1114111);
        }
        return this;
    }

    private static String mungeCharName(String str) {
        String trimWhiteSpace = PatternProps.trimWhiteSpace(str);
        StringBuilder sb = null;
        for (int i = 0; i < trimWhiteSpace.length(); i++) {
            char charAt = trimWhiteSpace.charAt(i);
            if (PatternProps.isWhiteSpace(charAt)) {
                if (sb == null) {
                    sb = new StringBuilder().append((CharSequence) trimWhiteSpace, 0, i);
                } else if (sb.charAt(sb.length() - 1) == ' ') {
                }
                charAt = ' ';
            }
            if (sb != null) {
                sb.append(charAt);
            }
        }
        return sb == null ? trimWhiteSpace : sb.toString();
    }

    public UnicodeSet applyIntPropertyValue(int i, int i2) {
        checkFrozen();
        if (i == 8192) {
            applyFilter(new GeneralCategoryMaskFilter(i2), 1);
        } else if (i == 28672) {
            applyFilter(new ScriptExtensionsFilter(i2), 2);
        } else {
            applyFilter(new IntPropertyFilter(i, i2), UCharacterProperty.INSTANCE.getSource(i));
        }
        return this;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public UnicodeSet applyPropertyAlias(String str, String str2, SymbolTable symbolTable) {
        int i;
        int i2;
        checkFrozen();
        boolean z = false;
        if (symbolTable != null && (symbolTable instanceof XSymbolTable) && ((XSymbolTable) symbolTable).applyPropertyAlias(str, str2, this)) {
            return this;
        }
        if (XSYMBOL_TABLE != null && XSYMBOL_TABLE.applyPropertyAlias(str, str2, this)) {
            return this;
        }
        if (str2.length() > 0) {
            i2 = UCharacter.getPropertyEnum(str);
            if (i2 == 4101) {
                i2 = 8192;
            }
            if ((i2 < 0 || i2 >= 61) && ((i2 < 4096 || i2 >= 4118) && (i2 < 8192 || i2 >= 8193))) {
                switch (i2) {
                    case 12288:
                        applyFilter(new NumericValueFilter(Double.parseDouble(PatternProps.trimWhiteSpace(str2))), 1);
                        return this;
                    case 16384:
                        applyFilter(new VersionFilter(VersionInfo.getInstance(mungeCharName(str2))), 2);
                        return this;
                    case 16389:
                        int charFromExtendedName = UCharacter.getCharFromExtendedName(mungeCharName(str2));
                        if (charFromExtendedName == -1) {
                            throw new IllegalArgumentException("Invalid character name");
                        }
                        clear();
                        add_unchecked(charFromExtendedName);
                        return this;
                    case 16395:
                        throw new IllegalArgumentException("Unicode_1_Name (na1) not supported");
                    case 28672:
                        i = UCharacter.getPropertyValueEnum(4106, str2);
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported property");
                }
            } else {
                try {
                    i = UCharacter.getPropertyValueEnum(i2, str2);
                } catch (IllegalArgumentException e) {
                    if (i2 == 4098 || i2 == 4112 || i2 == 4113) {
                        i = Integer.parseInt(PatternProps.trimWhiteSpace(str2));
                        if (i < 0 || i > 255) {
                            throw e;
                        }
                    } else {
                        throw e;
                    }
                }
            }
        } else {
            UPropertyAliases uPropertyAliases = UPropertyAliases.INSTANCE;
            i2 = 8192;
            i = uPropertyAliases.getPropertyValueEnum(8192, str);
            if (i == -1) {
                i2 = 4106;
                i = uPropertyAliases.getPropertyValueEnum(4106, str);
                if (i == -1) {
                    i2 = uPropertyAliases.getPropertyEnum(str);
                    if (i2 == -1) {
                        i2 = -1;
                    }
                    if (i2 >= 0 && i2 < 61) {
                        i = 1;
                    } else if (i2 != -1) {
                        throw new IllegalArgumentException("Missing property value");
                    } else if (0 == UPropertyAliases.compare("ANY", str)) {
                        set(0, 1114111);
                        return this;
                    } else if (0 == UPropertyAliases.compare("ASCII", str)) {
                        set(0, 127);
                        return this;
                    } else if (0 == UPropertyAliases.compare("Assigned", str)) {
                        i2 = 8192;
                        i = 1;
                        z = true;
                    } else {
                        throw new IllegalArgumentException("Invalid property alias: " + str + "=" + str2);
                    }
                }
            }
        }
        applyIntPropertyValue(i2, i);
        if (z) {
            complement();
        }
        return this;
    }

    private static boolean resemblesPropertyPattern(RuleCharacterIterator ruleCharacterIterator, int i) {
        boolean z = false;
        int i2 = i & -3;
        Object pos = ruleCharacterIterator.getPos(null);
        int next = ruleCharacterIterator.next(i2);
        if (next == 91 || next == 92) {
            int next2 = ruleCharacterIterator.next(i2 & -5);
            z = next == 91 ? next2 == 58 : next2 == 78 || next2 == 112 || next2 == 80;
        }
        ruleCharacterIterator.setPos(pos);
        return z;
    }

    private UnicodeSet applyPropertyPattern(String str, ParsePosition parsePosition, SymbolTable symbolTable) {
        int i;
        String str2;
        String str3;
        int index = parsePosition.getIndex();
        if (index + 5 > str.length()) {
            return null;
        }
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        if (str.regionMatches(index, "[:", 0, 2)) {
            z = true;
            i = PatternProps.skipWhiteSpace(str, index + 2);
            if (i < str.length() && str.charAt(i) == '^') {
                i++;
                z3 = true;
            }
        } else if (!str.regionMatches(true, index, "\\p", 0, 2) && !str.regionMatches(index, "\\N", 0, 2)) {
            return null;
        } else {
            char charAt = str.charAt(index + 1);
            z3 = charAt == 'P';
            z2 = charAt == 'N';
            int skipWhiteSpace = PatternProps.skipWhiteSpace(str, index + 2);
            if (skipWhiteSpace == str.length()) {
                return null;
            }
            i = skipWhiteSpace + 1;
            if (str.charAt(skipWhiteSpace) != '{') {
                return null;
            }
        }
        int indexOf = str.indexOf(z ? ":]" : "}", i);
        if (indexOf < 0) {
            return null;
        }
        int indexOf2 = str.indexOf(61, i);
        if (indexOf2 < 0 || indexOf2 >= indexOf || z2) {
            str3 = str.substring(i, indexOf);
            str2 = "";
            if (z2) {
                str2 = str3;
                str3 = "na";
            }
        } else {
            str3 = str.substring(i, indexOf2);
            str2 = str.substring(indexOf2 + 1, indexOf);
        }
        applyPropertyAlias(str3, str2, symbolTable);
        if (z3) {
            complement();
        }
        parsePosition.setIndex((z ? 2 : 1) + indexOf);
        return this;
    }

    private void applyPropertyPattern(RuleCharacterIterator ruleCharacterIterator, Appendable appendable, SymbolTable symbolTable) {
        String lookahead = ruleCharacterIterator.lookahead();
        ParsePosition parsePosition = new ParsePosition(0);
        applyPropertyPattern(lookahead, parsePosition, symbolTable);
        if (parsePosition.getIndex() == 0) {
            syntaxError(ruleCharacterIterator, "Invalid property pattern");
        }
        ruleCharacterIterator.jumpahead(parsePosition.getIndex());
        append(appendable, lookahead.substring(0, parsePosition.getIndex()));
    }

    private static final void addCaseMapping(UnicodeSet unicodeSet, int i, StringBuilder sb) {
        if (i < 0) {
            return;
        }
        if (i > 31) {
            unicodeSet.add(i);
            return;
        }
        unicodeSet.add(sb.toString());
        sb.setLength(0);
    }

    public UnicodeSet closeOver(int i) {
        checkFrozen();
        if ((i & 6) != 0) {
            UCaseProps uCaseProps = UCaseProps.INSTANCE;
            UnicodeSet unicodeSet = new UnicodeSet(this);
            ULocale uLocale = ULocale.ROOT;
            if ((i & 2) != 0) {
                unicodeSet.strings.clear();
            }
            int rangeCount = getRangeCount();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < rangeCount; i2++) {
                int rangeStart = getRangeStart(i2);
                int rangeEnd = getRangeEnd(i2);
                if ((i & 2) != 0) {
                    for (int i3 = rangeStart; i3 <= rangeEnd; i3++) {
                        uCaseProps.addCaseClosure(i3, unicodeSet);
                    }
                } else {
                    for (int i4 = rangeStart; i4 <= rangeEnd; i4++) {
                        addCaseMapping(unicodeSet, uCaseProps.toFullLower(i4, null, sb, 1), sb);
                        addCaseMapping(unicodeSet, uCaseProps.toFullTitle(i4, null, sb, 1), sb);
                        addCaseMapping(unicodeSet, uCaseProps.toFullUpper(i4, null, sb, 1), sb);
                        addCaseMapping(unicodeSet, uCaseProps.toFullFolding(i4, sb, 0), sb);
                    }
                }
            }
            if (!this.strings.isEmpty()) {
                if ((i & 2) != 0) {
                    Iterator<String> it = this.strings.iterator();
                    while (it.hasNext()) {
                        String foldCase = UCharacter.foldCase(it.next(), 0);
                        if (!uCaseProps.addStringCaseClosure(foldCase, unicodeSet)) {
                            unicodeSet.add(foldCase);
                        }
                    }
                } else {
                    BreakIterator wordInstance = BreakIterator.getWordInstance(uLocale);
                    Iterator<String> it2 = this.strings.iterator();
                    while (it2.hasNext()) {
                        String next = it2.next();
                        unicodeSet.add(UCharacter.toLowerCase(uLocale, next));
                        unicodeSet.add(UCharacter.toTitleCase(uLocale, next, wordInstance));
                        unicodeSet.add(UCharacter.toUpperCase(uLocale, next));
                        unicodeSet.add(UCharacter.foldCase(next, 0));
                    }
                }
            }
            set(unicodeSet);
        }
        return this;
    }

    public static abstract class XSymbolTable implements SymbolTable {
        public boolean applyPropertyAlias(String str, String str2, UnicodeSet unicodeSet) {
            return false;
        }
    }

    public boolean isFrozen() {
        return (this.bmpSet == null && this.stringSpan == null) ? false : true;
    }

    public UnicodeSet freeze() {
        if (!isFrozen()) {
            this.buffer = null;
            if (this.list.length > this.len + 16) {
                int i = this.len == 0 ? 1 : this.len;
                int[] iArr = this.list;
                this.list = new int[i];
                int i2 = i;
                while (true) {
                    i2--;
                    if (i2 <= 0) {
                        break;
                    }
                    this.list[i2] = iArr[i2];
                }
            }
            if (!this.strings.isEmpty()) {
                this.stringSpan = new UnicodeSetStringSpan(this, new ArrayList(this.strings), 127);
            }
            if (this.stringSpan == null || !this.stringSpan.needsStringSpanUTF16()) {
                this.bmpSet = new BMPSet(this.list, this.len);
            }
        }
        return this;
    }

    public int span(CharSequence charSequence, SpanCondition spanCondition) {
        return span(charSequence, 0, spanCondition);
    }

    public int span(CharSequence charSequence, int i, SpanCondition spanCondition) {
        int length = charSequence.length();
        if (i < 0) {
            i = 0;
        } else if (i >= length) {
            return length;
        }
        if (this.bmpSet != null) {
            return this.bmpSet.span(charSequence, i, spanCondition, null);
        }
        if (this.stringSpan != null) {
            return this.stringSpan.span(charSequence, i, spanCondition);
        }
        if (!this.strings.isEmpty()) {
            UnicodeSetStringSpan unicodeSetStringSpan = new UnicodeSetStringSpan(this, new ArrayList(this.strings), spanCondition == SpanCondition.NOT_CONTAINED ? 33 : 34);
            if (unicodeSetStringSpan.needsStringSpanUTF16()) {
                return unicodeSetStringSpan.span(charSequence, i, spanCondition);
            }
        }
        return spanCodePointsAndCount(charSequence, i, spanCondition, null);
    }

    @Deprecated
    public int spanAndCount(CharSequence charSequence, int i, SpanCondition spanCondition, OutputInt outputInt) {
        if (outputInt == null) {
            throw new IllegalArgumentException("outCount must not be null");
        }
        int length = charSequence.length();
        if (i < 0) {
            i = 0;
        } else if (i >= length) {
            return length;
        }
        if (this.stringSpan != null) {
            return this.stringSpan.spanAndCount(charSequence, i, spanCondition, outputInt);
        }
        if (this.bmpSet != null) {
            return this.bmpSet.span(charSequence, i, spanCondition, outputInt);
        }
        if (this.strings.isEmpty()) {
            return spanCodePointsAndCount(charSequence, i, spanCondition, outputInt);
        }
        return new UnicodeSetStringSpan(this, new ArrayList(this.strings), (spanCondition == SpanCondition.NOT_CONTAINED ? 33 : 34) | 64).spanAndCount(charSequence, i, spanCondition, outputInt);
    }

    private int spanCodePointsAndCount(CharSequence charSequence, int i, SpanCondition spanCondition, OutputInt outputInt) {
        boolean z = spanCondition != SpanCondition.NOT_CONTAINED;
        int i2 = i;
        int length = charSequence.length();
        int i3 = 0;
        do {
            int codePointAt = Character.codePointAt(charSequence, i2);
            if (z != contains(codePointAt)) {
                break;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        } while (i2 < length);
        if (outputInt != null) {
            outputInt.value = i3;
        }
        return i2;
    }

    public int spanBack(CharSequence charSequence, int i, SpanCondition spanCondition) {
        if (i <= 0) {
            return 0;
        }
        if (i > charSequence.length()) {
            i = charSequence.length();
        }
        if (this.bmpSet != null) {
            return this.bmpSet.spanBack(charSequence, i, spanCondition);
        }
        if (this.stringSpan != null) {
            return this.stringSpan.spanBack(charSequence, i, spanCondition);
        }
        if (!this.strings.isEmpty()) {
            UnicodeSetStringSpan unicodeSetStringSpan = new UnicodeSetStringSpan(this, new ArrayList(this.strings), spanCondition == SpanCondition.NOT_CONTAINED ? 17 : 18);
            if (unicodeSetStringSpan.needsStringSpanUTF16()) {
                return unicodeSetStringSpan.spanBack(charSequence, i, spanCondition);
            }
        }
        boolean z = spanCondition != SpanCondition.NOT_CONTAINED;
        int i2 = i;
        do {
            int codePointBefore = Character.codePointBefore(charSequence, i2);
            if (z != contains(codePointBefore)) {
                break;
            }
            i2 -= Character.charCount(codePointBefore);
        } while (i2 > 0);
        return i2;
    }

    public UnicodeSet cloneAsThawed() {
        UnicodeSet unicodeSet = new UnicodeSet(this);
        if ($assertionsDisabled || !unicodeSet.isFrozen()) {
            return unicodeSet;
        }
        throw new AssertionError();
    }

    private void checkFrozen() {
        if (isFrozen()) {
            throw new UnsupportedOperationException("Attempt to modify frozen object");
        }
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return new UnicodeSetIterator2(this);
    }

    static class UnicodeSetIterator2 implements Iterator<String> {
        private char[] buffer;
        private int current;
        private int item;
        private int len;
        private int limit;
        private int[] sourceList;
        private TreeSet<String> sourceStrings;
        private Iterator<String> stringIterator;

        UnicodeSetIterator2(UnicodeSet unicodeSet) {
            this.len = unicodeSet.len - 1;
            if (this.len > 0) {
                this.sourceStrings = unicodeSet.strings;
                this.sourceList = unicodeSet.list;
                int[] iArr = this.sourceList;
                int i = this.item;
                this.item = i + 1;
                this.current = iArr[i];
                int[] iArr2 = this.sourceList;
                int i2 = this.item;
                this.item = i2 + 1;
                this.limit = iArr2[i2];
                return;
            }
            this.stringIterator = unicodeSet.strings.iterator();
            this.sourceList = null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.sourceList != null || this.stringIterator.hasNext();
        }

        @Override // java.util.Iterator
        public String next() {
            if (this.sourceList == null) {
                return this.stringIterator.next();
            }
            int i = this.current;
            this.current = i + 1;
            if (this.current >= this.limit) {
                if (this.item >= this.len) {
                    this.stringIterator = this.sourceStrings.iterator();
                    this.sourceList = null;
                } else {
                    int[] iArr = this.sourceList;
                    int i2 = this.item;
                    this.item = i2 + 1;
                    this.current = iArr[i2];
                    int[] iArr2 = this.sourceList;
                    int i3 = this.item;
                    this.item = i3 + 1;
                    this.limit = iArr2[i3];
                }
            }
            if (i <= 65535) {
                return String.valueOf((char) i);
            }
            if (this.buffer == null) {
                this.buffer = new char[2];
            }
            int i4 = i - 65536;
            this.buffer[0] = (char) ((i4 >>> 10) + 55296);
            this.buffer[1] = (char) ((i4 & 1023) + 56320);
            return String.valueOf(this.buffer);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public int compareTo(UnicodeSet unicodeSet) {
        return compareTo(unicodeSet, ComparisonStyle.SHORTER_FIRST);
    }

    public int compareTo(UnicodeSet unicodeSet, ComparisonStyle comparisonStyle) {
        int compare;
        int size;
        if (comparisonStyle == ComparisonStyle.LEXICOGRAPHIC || (size = size() - unicodeSet.size()) == 0) {
            int i = 0;
            while (true) {
                int i2 = this.list[i] - unicodeSet.list[i];
                if (0 != i2) {
                    if (this.list[i] == 1114112) {
                        if (this.strings.isEmpty()) {
                            return 1;
                        }
                        return compare(this.strings.first(), unicodeSet.list[i]);
                    } else if (unicodeSet.list[i] != 1114112) {
                        return (i & 1) == 0 ? i2 : -i2;
                    } else {
                        if (!unicodeSet.strings.isEmpty() && (compare = compare(unicodeSet.strings.first(), this.list[i])) <= 0) {
                            return compare < 0 ? 1 : 0;
                        }
                        return -1;
                    }
                } else if (this.list[i] == 1114112) {
                    return compare(this.strings, unicodeSet.strings);
                } else {
                    i++;
                }
            }
        } else {
            return (size < 0) == (comparisonStyle == ComparisonStyle.SHORTER_FIRST) ? -1 : 1;
        }
    }

    public static int compare(CharSequence charSequence, int i) {
        return CharSequences.compare(charSequence, i);
    }

    public static <T extends Comparable<T>> int compare(Iterable<T> iterable, Iterable<T> iterable2) {
        return compare(iterable.iterator(), iterable2.iterator());
    }

    @Deprecated
    public static <T extends Comparable<T>> int compare(Iterator<T> it, Iterator<T> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext()) {
                return 1;
            }
            int compareTo = it.next().compareTo(it2.next());
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return it2.hasNext() ? -1 : 0;
    }
}

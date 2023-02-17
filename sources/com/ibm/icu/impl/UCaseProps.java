package com.ibm.icu.impl;

import com.ibm.icu.impl.ICUBinary;
import com.ibm.icu.impl.Trie2;
import com.ibm.icu.text.UTF16;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.ICUUncheckedIOException;
import com.ibm.icu.util.ULocale;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
public final class UCaseProps {
    public static final UCaseProps INSTANCE;
    public static final StringBuilder dummyStringBuilder = new StringBuilder();
    private static final byte[] flagsOffset = {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 4, 5, 5, 6, 5, 6, 6, 7, 5, 6, 6, 7, 6, 7, 7, 8};
    private String exceptions;
    private int[] indexes;
    private Trie2_16 trie;
    private char[] unfold;

    public interface ContextIterator {
        int next();

        void reset(int i);
    }

    private UCaseProps() {
        readData(ICUBinary.getRequiredData("ucase.icu"));
    }

    private final void readData(ByteBuffer byteBuffer) {
        ICUBinary.readHeader(byteBuffer, 1665225541, new IsAcceptable());
        int i = byteBuffer.getInt();
        if (i < 16) {
            throw new IOException("indexes[0] too small in ucase.icu");
        }
        this.indexes = new int[i];
        this.indexes[0] = i;
        for (int i2 = 1; i2 < i; i2++) {
            this.indexes[i2] = byteBuffer.getInt();
        }
        this.trie = Trie2_16.createFromSerialized(byteBuffer);
        int i3 = this.indexes[2];
        int serializedLength = this.trie.getSerializedLength();
        if (serializedLength > i3) {
            throw new IOException("ucase.icu: not enough bytes for the trie");
        }
        ICUBinary.skipBytes(byteBuffer, i3 - serializedLength);
        int i4 = this.indexes[3];
        if (i4 > 0) {
            this.exceptions = ICUBinary.getString(byteBuffer, i4, 0);
        }
        int i5 = this.indexes[4];
        if (i5 > 0) {
            this.unfold = ICUBinary.getChars(byteBuffer, i5, 0);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class IsAcceptable implements ICUBinary.Authenticate {
        private IsAcceptable() {
        }

        @Override // com.ibm.icu.impl.ICUBinary.Authenticate
        public boolean isDataVersionAcceptable(byte[] bArr) {
            return bArr[0] == 3;
        }
    }

    public final void addPropertyStarts(UnicodeSet unicodeSet) {
        Iterator<Trie2.Range> it = this.trie.iterator();
        while (it.hasNext()) {
            Trie2.Range next = it.next();
            if (!next.leadSurrogate) {
                unicodeSet.add(next.startCodePoint);
            } else {
                return;
            }
        }
    }

    private static final int getExceptionsOffset(int i) {
        return i >> 5;
    }

    private static final boolean propsHasException(int i) {
        return (i & 16) != 0;
    }

    static {
        try {
            INSTANCE = new UCaseProps();
        } catch (IOException e) {
            throw new ICUUncheckedIOException(e);
        }
    }

    private static final boolean hasSlot(int i, int i2) {
        return ((1 << i2) & i) != 0;
    }

    private static final byte slotOffset(int i, int i2) {
        return flagsOffset[((1 << i2) - 1) & i];
    }

    private final long getSlotValueAndOffset(int i, int i2, int i3) {
        int i4;
        long j;
        if ((i & 256) == 0) {
            i4 = i3 + slotOffset(i, i2);
            j = (long) this.exceptions.charAt(i4);
        } else {
            int slotOffset = i3 + (slotOffset(i, i2) * 2);
            i4 = slotOffset + 1;
            j = (((long) this.exceptions.charAt(slotOffset)) << 16) | ((long) this.exceptions.charAt(i4));
        }
        return (((long) i4) << 32) | j;
    }

    private final int getSlotValue(int i, int i2, int i3) {
        if ((i & 256) == 0) {
            return this.exceptions.charAt(i3 + slotOffset(i, i2));
        }
        int slotOffset = i3 + (slotOffset(i, i2) * 2);
        return (this.exceptions.charAt(slotOffset) << 16) | this.exceptions.charAt(slotOffset + 1);
    }

    public final void addCaseClosure(int i, UnicodeSet unicodeSet) {
        int i2;
        int i3;
        int delta;
        switch (i) {
            case 73:
                unicodeSet.add(105);
                return;
            case 105:
                unicodeSet.add(73);
                return;
            case 304:
                unicodeSet.add("i̇");
                return;
            case 305:
                return;
            default:
                int i4 = this.trie.get(i);
                if (propsHasException(i4)) {
                    int exceptionsOffset = getExceptionsOffset(i4);
                    int i5 = exceptionsOffset + 1;
                    char charAt = this.exceptions.charAt(exceptionsOffset);
                    for (int i6 = 0; i6 <= 3; i6++) {
                        if (hasSlot(charAt, i6)) {
                            unicodeSet.add(getSlotValue(charAt, i6, i5));
                        }
                    }
                    if (hasSlot(charAt, 6)) {
                        long slotValueAndOffset = getSlotValueAndOffset(charAt, 6, i5);
                        i2 = ((int) slotValueAndOffset) & 15;
                        i3 = ((int) (slotValueAndOffset >> 32)) + 1;
                    } else {
                        i2 = 0;
                        i3 = 0;
                    }
                    if (hasSlot(charAt, 7)) {
                        long slotValueAndOffset2 = getSlotValueAndOffset(charAt, 7, i5);
                        int i7 = ((int) slotValueAndOffset2) & 65535;
                        int i8 = ((int) (slotValueAndOffset2 >> 32)) + 1 + (i7 & 15);
                        int i9 = i7 >> 4;
                        int i10 = i9 & 15;
                        if (i10 != 0) {
                            unicodeSet.add(this.exceptions.substring(i8, i8 + i10));
                            i8 += i10;
                        }
                        int i11 = i9 >> 4;
                        i3 = i8 + (i11 & 15) + (i11 >> 4);
                    }
                    int i12 = i3 + i2;
                    int i13 = i3;
                    while (i13 < i12) {
                        int codePointAt = this.exceptions.codePointAt(i13);
                        unicodeSet.add(codePointAt);
                        i13 += UTF16.getCharCount(codePointAt);
                    }
                    return;
                } else if (getTypeFromProps(i4) != 0 && (delta = getDelta(i4)) != 0) {
                    unicodeSet.add(i + delta);
                    return;
                } else {
                    return;
                }
        }
    }

    private final int strcmpMax(String str, int i, int i2) {
        int length = str.length();
        int i3 = i2 - length;
        int i4 = 0;
        do {
            i4++;
            char charAt = str.charAt(i4);
            i++;
            char c = this.unfold[i];
            if (c == 0) {
                return 1;
            }
            int i5 = charAt - c;
            if (i5 != 0) {
                return i5;
            }
            length--;
        } while (length > 0);
        if (i3 == 0 || this.unfold[i] == 0) {
            return 0;
        }
        return -i3;
    }

    public final boolean addStringCaseClosure(String str, UnicodeSet unicodeSet) {
        int length;
        if (this.unfold == null || str == null || (length = str.length()) <= 1) {
            return false;
        }
        char c = this.unfold[0];
        char c2 = this.unfold[1];
        char c3 = this.unfold[2];
        if (length > c3) {
            return false;
        }
        int i = 0;
        char c4 = c;
        while (i < c4) {
            int i2 = (i + c4) / 2;
            int i3 = (i2 + 1) * c2;
            int strcmpMax = strcmpMax(str, i3, c3);
            if (strcmpMax == 0) {
                int i4 = c3;
                while (i4 < c2 && this.unfold[i3 + i4] != 0) {
                    int charAt = UTF16.charAt(this.unfold, i3, this.unfold.length, i4);
                    unicodeSet.add(charAt);
                    addCaseClosure(charAt, unicodeSet);
                    i4 += UTF16.getCharCount(charAt);
                }
                return true;
            } else if (strcmpMax < 0) {
                c4 = i2;
            } else {
                i = i2 + 1;
            }
        }
        return false;
    }

    public final int getType(int i) {
        return getTypeFromProps(this.trie.get(i));
    }

    public final int getTypeOrIgnorable(int i) {
        return getTypeAndIgnorableFromProps(this.trie.get(i));
    }

    public final int getDotType(int i) {
        int i2 = this.trie.get(i);
        if (!propsHasException(i2)) {
            return i2 & 96;
        }
        return (this.exceptions.charAt(getExceptionsOffset(i2)) >> 7) & 96;
    }

    public final boolean isSoftDotted(int i) {
        return getDotType(i) == 32;
    }

    public final boolean isCaseSensitive(int i) {
        return (this.trie.get(i) & 8) != 0;
    }

    public static final int getCaseLocale(ULocale uLocale) {
        return getCaseLocale(uLocale.getLanguage());
    }

    private static final int getCaseLocale(String str) {
        if (str.length() == 2) {
            if (str.equals("en") || str.charAt(0) > 't') {
                return 1;
            }
            if (str.equals("tr") || str.equals("az")) {
                return 2;
            }
            if (str.equals("el")) {
                return 4;
            }
            if (str.equals("lt")) {
                return 3;
            }
            if (str.equals("nl")) {
                return 5;
            }
            return 1;
        } else if (str.length() != 3) {
            return 1;
        } else {
            if (str.equals("tur") || str.equals("aze")) {
                return 2;
            }
            if (str.equals("ell")) {
                return 4;
            }
            if (str.equals("lit")) {
                return 3;
            }
            if (str.equals("nld")) {
                return 5;
            }
            return 1;
        }
    }

    private final boolean isFollowedByCasedLetter(ContextIterator contextIterator, int i) {
        int typeOrIgnorable;
        if (contextIterator == null) {
            return false;
        }
        contextIterator.reset(i);
        do {
            int next = contextIterator.next();
            if (next < 0) {
                return false;
            }
            typeOrIgnorable = getTypeOrIgnorable(next);
        } while ((typeOrIgnorable & 4) != 0);
        if (typeOrIgnorable != 0) {
            return true;
        }
        return false;
    }

    private final boolean isPrecededBySoftDotted(ContextIterator contextIterator) {
        int dotType;
        if (contextIterator == null) {
            return false;
        }
        contextIterator.reset(-1);
        do {
            int next = contextIterator.next();
            if (next < 0) {
                return false;
            }
            dotType = getDotType(next);
            if (dotType == 32) {
                return true;
            }
        } while (dotType == 96);
        return false;
    }

    private final boolean isPrecededBy_I(ContextIterator contextIterator) {
        int next;
        if (contextIterator == null) {
            return false;
        }
        contextIterator.reset(-1);
        do {
            next = contextIterator.next();
            if (next < 0) {
                return false;
            }
            if (next == 73) {
                return true;
            }
        } while (getDotType(next) == 96);
        return false;
    }

    private final boolean isFollowedByMoreAbove(ContextIterator contextIterator) {
        int dotType;
        if (contextIterator == null) {
            return false;
        }
        contextIterator.reset(1);
        do {
            int next = contextIterator.next();
            if (next < 0) {
                return false;
            }
            dotType = getDotType(next);
            if (dotType == 64) {
                return true;
            }
        } while (dotType == 96);
        return false;
    }

    private final boolean isFollowedByDotAbove(ContextIterator contextIterator) {
        int next;
        if (contextIterator == null) {
            return false;
        }
        contextIterator.reset(1);
        do {
            next = contextIterator.next();
            if (next < 0) {
                return false;
            }
            if (next == 775) {
                return true;
            }
        } while (getDotType(next) == 96);
        return false;
    }

    public final int toFullLower(int i, ContextIterator contextIterator, Appendable appendable, int i2) {
        int i3 = i;
        int i4 = this.trie.get(i);
        if (propsHasException(i4)) {
            int exceptionsOffset = getExceptionsOffset(i4);
            int i5 = exceptionsOffset + 1;
            char charAt = this.exceptions.charAt(exceptionsOffset);
            if ((charAt & 16384) != 0) {
                if (i2 == 3 && (((i == 73 || i == 74 || i == 302) && isFollowedByMoreAbove(contextIterator)) || i == 204 || i == 205 || i == 296)) {
                    switch (i) {
                        case 73:
                            try {
                                appendable.append("i̇");
                                return 2;
                            } catch (IOException e) {
                                throw new ICUUncheckedIOException(e);
                            }
                        case 74:
                            appendable.append("j̇");
                            return 2;
                        case 204:
                            appendable.append("i̇̀");
                            return 3;
                        case 205:
                            appendable.append("i̇́");
                            return 3;
                        case 296:
                            appendable.append("i̇̃");
                            return 3;
                        case 302:
                            appendable.append("į̇");
                            return 2;
                        default:
                            return 0;
                    }
                } else if (i2 == 2 && i == 304) {
                    return 105;
                } else {
                    if (i2 == 2 && i == 775 && isPrecededBy_I(contextIterator)) {
                        return 0;
                    }
                    if (i2 == 2 && i == 73 && !isFollowedByDotAbove(contextIterator)) {
                        return 305;
                    }
                    if (i == 304) {
                        try {
                            appendable.append("i̇");
                            return 2;
                        } catch (IOException e2) {
                            throw new ICUUncheckedIOException(e2);
                        }
                    } else if (i == 931 && !isFollowedByCasedLetter(contextIterator, 1) && isFollowedByCasedLetter(contextIterator, -1)) {
                        return 962;
                    }
                }
            } else if (hasSlot(charAt, 7)) {
                long slotValueAndOffset = getSlotValueAndOffset(charAt, 7, i5);
                int i6 = ((int) slotValueAndOffset) & 15;
                if (i6 != 0) {
                    int i7 = ((int) (slotValueAndOffset >> 32)) + 1;
                    try {
                        appendable.append(this.exceptions, i7, i7 + i6);
                        return i6;
                    } catch (IOException e3) {
                        throw new ICUUncheckedIOException(e3);
                    }
                }
            }
            if (hasSlot(charAt, 0)) {
                i3 = getSlotValue(charAt, 0, i5);
            }
        } else if (getTypeFromProps(i4) >= 2) {
            i3 = i + getDelta(i4);
        }
        return i3 == i ? i3 ^ -1 : i3;
    }

    private final int toUpperOrTitle(int i, ContextIterator contextIterator, Appendable appendable, int i2, boolean z) {
        int i3;
        int i4;
        int i5 = i;
        int i6 = this.trie.get(i);
        if (propsHasException(i6)) {
            int exceptionsOffset = getExceptionsOffset(i6);
            int i7 = exceptionsOffset + 1;
            char charAt = this.exceptions.charAt(exceptionsOffset);
            if ((charAt & 16384) != 0) {
                if (i2 == 2 && i == 105) {
                    return 304;
                }
                if (i2 == 3 && i == 775 && isPrecededBySoftDotted(contextIterator)) {
                    return 0;
                }
            } else if (hasSlot(charAt, 7)) {
                long slotValueAndOffset = getSlotValueAndOffset(charAt, 7, i7);
                int i8 = ((int) slotValueAndOffset) & 65535;
                int i9 = i8 >> 4;
                int i10 = ((int) (slotValueAndOffset >> 32)) + 1 + (i8 & 15) + (i9 & 15);
                int i11 = i9 >> 4;
                if (z) {
                    i4 = i11 & 15;
                } else {
                    i10 += i11 & 15;
                    i4 = (i11 >> 4) & 15;
                }
                if (i4 != 0) {
                    try {
                        appendable.append(this.exceptions, i10, i10 + i4);
                        return i4;
                    } catch (IOException e) {
                        throw new ICUUncheckedIOException(e);
                    }
                }
            }
            if (!z && hasSlot(charAt, 3)) {
                i3 = 3;
            } else if (!hasSlot(charAt, 2)) {
                return i ^ -1;
            } else {
                i3 = 2;
            }
            i5 = getSlotValue(charAt, i3, i7);
        } else if (getTypeFromProps(i6) == 1) {
            i5 = i + getDelta(i6);
        }
        return i5 == i ? i5 ^ -1 : i5;
    }

    public final int toFullUpper(int i, ContextIterator contextIterator, Appendable appendable, int i2) {
        return toUpperOrTitle(i, contextIterator, appendable, i2, true);
    }

    public final int toFullTitle(int i, ContextIterator contextIterator, Appendable appendable, int i2) {
        return toUpperOrTitle(i, contextIterator, appendable, i2, false);
    }

    public final int fold(int i, int i2) {
        int i3;
        int i4 = this.trie.get(i);
        if (propsHasException(i4)) {
            int exceptionsOffset = getExceptionsOffset(i4);
            int i5 = exceptionsOffset + 1;
            char charAt = this.exceptions.charAt(exceptionsOffset);
            if ((32768 & charAt) != 0) {
                if ((i2 & 255) == 0) {
                    if (i == 73) {
                        return 105;
                    }
                    if (i == 304) {
                        return i;
                    }
                } else if (i == 73) {
                    return 305;
                } else {
                    if (i == 304) {
                        return 105;
                    }
                }
            }
            if (hasSlot(charAt, 1)) {
                i3 = 1;
            } else if (!hasSlot(charAt, 0)) {
                return i;
            } else {
                i3 = 0;
            }
            return getSlotValue(charAt, i3, i5);
        } else if (getTypeFromProps(i4) >= 2) {
            return i + getDelta(i4);
        } else {
            return i;
        }
    }

    public final int toFullFolding(int i, Appendable appendable, int i2) {
        int i3;
        int i4 = i;
        int i5 = this.trie.get(i);
        if (propsHasException(i5)) {
            int exceptionsOffset = getExceptionsOffset(i5);
            int i6 = exceptionsOffset + 1;
            char charAt = this.exceptions.charAt(exceptionsOffset);
            if ((32768 & charAt) != 0) {
                if ((i2 & 255) == 0) {
                    if (i == 73) {
                        return 105;
                    }
                    if (i == 304) {
                        try {
                            appendable.append("i̇");
                            return 2;
                        } catch (IOException e) {
                            throw new ICUUncheckedIOException(e);
                        }
                    }
                } else if (i == 73) {
                    return 305;
                } else {
                    if (i == 304) {
                        return 105;
                    }
                }
            } else if (hasSlot(charAt, 7)) {
                long slotValueAndOffset = getSlotValueAndOffset(charAt, 7, i6);
                int i7 = ((int) slotValueAndOffset) & 65535;
                int i8 = ((int) (slotValueAndOffset >> 32)) + 1 + (i7 & 15);
                int i9 = (i7 >> 4) & 15;
                if (i9 != 0) {
                    try {
                        appendable.append(this.exceptions, i8, i8 + i9);
                        return i9;
                    } catch (IOException e2) {
                        throw new ICUUncheckedIOException(e2);
                    }
                }
            }
            if (hasSlot(charAt, 1)) {
                i3 = 1;
            } else if (!hasSlot(charAt, 0)) {
                return i ^ -1;
            } else {
                i3 = 0;
            }
            i4 = getSlotValue(charAt, i3, i6);
        } else if (getTypeFromProps(i5) >= 2) {
            i4 = i + getDelta(i5);
        }
        return i4 == i ? i4 ^ -1 : i4;
    }

    public final boolean hasBinaryProperty(int i, int i2) {
        switch (i2) {
            case 22:
                return 1 == getType(i);
            case 23:
            case 24:
            case 25:
            case 26:
            case 28:
            case 29:
            case 31:
            case 32:
            case 33:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 54:
            default:
                return false;
            case 27:
                return isSoftDotted(i);
            case 30:
                return 2 == getType(i);
            case 34:
                return isCaseSensitive(i);
            case 49:
                return 0 != getType(i);
            case 50:
                return (getTypeOrIgnorable(i) >> 2) != 0;
            case 51:
                dummyStringBuilder.setLength(0);
                return toFullLower(i, null, dummyStringBuilder, 1) >= 0;
            case 52:
                dummyStringBuilder.setLength(0);
                return toFullUpper(i, null, dummyStringBuilder, 1) >= 0;
            case 53:
                dummyStringBuilder.setLength(0);
                return toFullTitle(i, null, dummyStringBuilder, 1) >= 0;
            case 55:
                dummyStringBuilder.setLength(0);
                return toFullLower(i, null, dummyStringBuilder, 1) >= 0 || toFullUpper(i, null, dummyStringBuilder, 1) >= 0 || toFullTitle(i, null, dummyStringBuilder, 1) >= 0;
        }
    }

    private static final int getTypeFromProps(int i) {
        return i & 3;
    }

    private static final int getTypeAndIgnorableFromProps(int i) {
        return i & 7;
    }

    private static final int getDelta(int i) {
        return ((short) i) >> 7;
    }
}

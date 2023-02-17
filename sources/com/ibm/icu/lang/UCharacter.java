package com.ibm.icu.lang;

import com.ibm.icu.impl.CaseMapImpl;
import com.ibm.icu.impl.IllegalIcuArgumentException;
import com.ibm.icu.impl.UCaseProps;
import com.ibm.icu.impl.UCharacterName;
import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.impl.UPropertyAliases;
import com.ibm.icu.text.BreakIterator;
import com.ibm.icu.text.Edits;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.VersionInfo;
public final class UCharacter {
    public static int digit(int i, int i2) {
        if (2 > i2 || i2 > 36) {
            return -1;
        }
        int digit = digit(i);
        if (digit < 0) {
            digit = UCharacterProperty.getEuropeanDigit(i);
        }
        if (digit < i2) {
            return digit;
        }
        return -1;
    }

    public static int digit(int i) {
        return UCharacterProperty.INSTANCE.digit(i);
    }

    public static double getUnicodeNumericValue(int i) {
        return UCharacterProperty.INSTANCE.getUnicodeNumericValue(i);
    }

    public static int getType(int i) {
        return UCharacterProperty.INSTANCE.getType(i);
    }

    public static boolean isDigit(int i) {
        return getType(i) == 9;
    }

    public static boolean isLowerCase(int i) {
        return getType(i) == 2;
    }

    public static int getCharFromExtendedName(String str) {
        return UCharacterName.INSTANCE.getCharFromName(2, str);
    }

    public static int getPropertyEnum(CharSequence charSequence) {
        int propertyEnum = UPropertyAliases.INSTANCE.getPropertyEnum(charSequence);
        if (propertyEnum != -1) {
            return propertyEnum;
        }
        throw new IllegalIcuArgumentException("Invalid name: " + ((Object) charSequence));
    }

    public static int getPropertyValueEnum(int i, CharSequence charSequence) {
        int propertyValueEnum = UPropertyAliases.INSTANCE.getPropertyValueEnum(i, charSequence);
        if (propertyValueEnum != -1) {
            return propertyValueEnum;
        }
        throw new IllegalIcuArgumentException("Invalid name: " + ((Object) charSequence));
    }

    private static int getCaseLocale(ULocale uLocale) {
        if (uLocale == null) {
            uLocale = ULocale.getDefault();
        }
        return UCaseProps.getCaseLocale(uLocale);
    }

    private static String toLowerCase(int i, String str) {
        if (str.length() > 100) {
            return ((StringBuilder) CaseMapImpl.toLower(i, 0, str, new StringBuilder(str.length()), null)).toString();
        }
        if (str.isEmpty()) {
            return str;
        }
        Edits edits = new Edits();
        return applyEdits(str, (StringBuilder) CaseMapImpl.toLower(i, 16384, str, new StringBuilder(), edits), edits);
    }

    private static String toUpperCase(int i, String str) {
        if (str.length() > 100) {
            return ((StringBuilder) CaseMapImpl.toUpper(i, 0, str, new StringBuilder(str.length()), null)).toString();
        }
        if (str.isEmpty()) {
            return str;
        }
        Edits edits = new Edits();
        return applyEdits(str, (StringBuilder) CaseMapImpl.toUpper(i, 16384, str, new StringBuilder(), edits), edits);
    }

    private static String toTitleCase(int i, int i2, BreakIterator breakIterator, String str) {
        if (str.length() > 100) {
            return ((StringBuilder) CaseMapImpl.toTitle(i, i2, breakIterator, str, new StringBuilder(str.length()), null)).toString();
        }
        if (str.isEmpty()) {
            return str;
        }
        Edits edits = new Edits();
        return applyEdits(str, (StringBuilder) CaseMapImpl.toTitle(i, i2 | 16384, breakIterator, str, new StringBuilder(), edits), edits);
    }

    private static String applyEdits(String str, StringBuilder sb, Edits edits) {
        if (!edits.hasChanges()) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(str.length() + edits.lengthDelta());
        Edits.Iterator coarseIterator = edits.getCoarseIterator();
        while (coarseIterator.next()) {
            if (coarseIterator.hasChange()) {
                int replacementIndex = coarseIterator.replacementIndex();
                sb2.append((CharSequence) sb, replacementIndex, coarseIterator.newLength() + replacementIndex);
            } else {
                int sourceIndex = coarseIterator.sourceIndex();
                sb2.append((CharSequence) str, sourceIndex, coarseIterator.oldLength() + sourceIndex);
            }
        }
        return sb2.toString();
    }

    public static String toUpperCase(ULocale uLocale, String str) {
        return toUpperCase(getCaseLocale(uLocale), str);
    }

    public static String toLowerCase(ULocale uLocale, String str) {
        return toLowerCase(getCaseLocale(uLocale), str);
    }

    public static String toTitleCase(ULocale uLocale, String str, BreakIterator breakIterator) {
        return toTitleCase(uLocale, str, breakIterator, 0);
    }

    public static String toTitleCase(ULocale uLocale, String str, BreakIterator breakIterator, int i) {
        if (breakIterator == null) {
            if (uLocale == null) {
                uLocale = ULocale.getDefault();
            }
            breakIterator = BreakIterator.getWordInstance(uLocale);
        }
        breakIterator.setText(str);
        return toTitleCase(getCaseLocale(uLocale), i, breakIterator, str);
    }

    public static int foldCase(int i, boolean z) {
        return foldCase(i, z ? 0 : 1);
    }

    public static String foldCase(String str, boolean z) {
        return foldCase(str, z ? 0 : 1);
    }

    public static int foldCase(int i, int i2) {
        return UCaseProps.INSTANCE.fold(i, i2);
    }

    public static final String foldCase(String str, int i) {
        if (str.length() > 100) {
            return ((StringBuilder) CaseMapImpl.fold(i, str, new StringBuilder(str.length()), null)).toString();
        }
        if (str.isEmpty()) {
            return str;
        }
        Edits edits = new Edits();
        return applyEdits(str, (StringBuilder) CaseMapImpl.fold(i | 16384, str, new StringBuilder(), edits), edits);
    }

    public static VersionInfo getAge(int i) {
        if (i >= 0 && i <= 1114111) {
            return UCharacterProperty.INSTANCE.getAge(i);
        }
        throw new IllegalArgumentException("Codepoint out of bounds");
    }

    public static boolean hasBinaryProperty(int i, int i2) {
        return UCharacterProperty.INSTANCE.hasBinaryProperty(i, i2);
    }

    public static boolean isUAlphabetic(int i) {
        return hasBinaryProperty(i, 0);
    }

    public static boolean isUWhiteSpace(int i) {
        return hasBinaryProperty(i, 31);
    }

    public static int getIntPropertyValue(int i, int i2) {
        return UCharacterProperty.INSTANCE.getIntPropertyValue(i, i2);
    }
}

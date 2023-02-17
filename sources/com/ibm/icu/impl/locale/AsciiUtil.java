package com.ibm.icu.impl.locale;

import com.ibm.icu.impl.Utility;
public final class AsciiUtil {
    public static boolean caseIgnoreMatch(String str, String str2) {
        if (Utility.sameObjects(str, str2)) {
            return true;
        }
        int length = str.length();
        if (length != str2.length()) {
            return false;
        }
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            char charAt2 = str2.charAt(i);
            if (charAt != charAt2 && toLower(charAt) != toLower(charAt2)) {
                break;
            }
            i++;
        }
        return i == length;
    }

    public static int caseIgnoreCompare(String str, String str2) {
        if (Utility.sameObjects(str, str2)) {
            return 0;
        }
        return toLowerString(str).compareTo(toLowerString(str2));
    }

    public static char toUpper(char c) {
        if (c < 'a' || c > 'z') {
            return c;
        }
        return (char) (c - ' ');
    }

    public static char toLower(char c) {
        if (c < 'A' || c > 'Z') {
            return c;
        }
        return (char) (c + ' ');
    }

    public static String toLowerString(String str) {
        int i = 0;
        while (i < str.length() && ((r2 = str.charAt(i)) < 'A' || r2 > 'Z')) {
            i++;
        }
        if (i == str.length()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.substring(0, i));
        while (i < str.length()) {
            sb.append(toLower(str.charAt(i)));
            i++;
        }
        return sb.toString();
    }

    public static String toUpperString(String str) {
        int i = 0;
        while (i < str.length() && ((r2 = str.charAt(i)) < 'a' || r2 > 'z')) {
            i++;
        }
        if (i == str.length()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.substring(0, i));
        while (i < str.length()) {
            sb.append(toUpper(str.charAt(i)));
            i++;
        }
        return sb.toString();
    }

    public static String toTitleString(String str) {
        if (str.length() == 0) {
            return str;
        }
        int i = 0;
        char charAt = str.charAt(0);
        if (charAt < 'a' || charAt > 'z') {
            i = 1;
            while (i < str.length() && (charAt < 'A' || charAt > 'Z')) {
                i++;
            }
        }
        if (i == str.length()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.substring(0, i));
        if (i == 0) {
            sb.append(toUpper(str.charAt(i)));
            i++;
        }
        while (i < str.length()) {
            sb.append(toLower(str.charAt(i)));
            i++;
        }
        return sb.toString();
    }

    public static boolean isAlpha(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    public static boolean isAlphaString(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!isAlpha(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumeric(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean isNumericString(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!isNumeric(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphaNumeric(char c) {
        return isAlpha(c) || isNumeric(c);
    }

    public static boolean isAlphaNumericString(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!isAlphaNumeric(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static class CaseInsensitiveKey {
        private int _hash;
        private String _key;

        public CaseInsensitiveKey(String str) {
            this._key = str;
            this._hash = AsciiUtil.toLowerString(str).hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CaseInsensitiveKey) {
                return AsciiUtil.caseIgnoreMatch(this._key, ((CaseInsensitiveKey) obj)._key);
            }
            return false;
        }

        public int hashCode() {
            return this._hash;
        }
    }
}

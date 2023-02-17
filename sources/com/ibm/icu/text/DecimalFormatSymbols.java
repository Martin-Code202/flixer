package com.ibm.icu.text;

import com.ibm.icu.impl.CacheBase;
import com.ibm.icu.impl.CurrencyData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.SoftCache;
import com.ibm.icu.impl.UResource;
import com.ibm.icu.util.Currency;
import com.ibm.icu.util.ICUCloneNotSupportedException;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Locale;
import java.util.MissingResourceException;
public class DecimalFormatSymbols implements Cloneable, Serializable {
    private static final char[] DEF_DIGIT_CHARS_ARRAY = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static final String[] DEF_DIGIT_STRINGS_ARRAY = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static final String[] SYMBOL_DEFAULTS = {String.valueOf('.'), String.valueOf(','), ";", String.valueOf('%'), String.valueOf('-'), String.valueOf('+'), "E", String.valueOf((char) 8240), "∞", "NaN", null, null, "×"};
    private static final String[] SYMBOL_KEYS = {"decimal", "group", "list", "percentSign", "minusSign", "plusSign", "exponential", "perMille", "infinity", "nan", "currencyDecimal", "currencyGroup", "superscriptingExponent"};
    private static final CacheBase<ULocale, CacheData, Void> cachedLocaleData = new SoftCache<ULocale, CacheData, Void>() { // from class: com.ibm.icu.text.DecimalFormatSymbols.1
        /* access modifiers changed from: protected */
        public CacheData createInstance(ULocale uLocale, Void r3) {
            return DecimalFormatSymbols.loadData(uLocale);
        }
    };
    private static final long serialVersionUID = 5772796243397350300L;
    private String NaN;
    private ULocale actualLocale;
    private transient Currency currency;
    private String currencyPattern = null;
    private String[] currencySpcAfterSym;
    private String[] currencySpcBeforeSym;
    private String currencySymbol;
    private char decimalSeparator;
    private String decimalSeparatorString;
    private char digit;
    private String[] digitStrings;
    private char[] digits;
    private String exponentMultiplicationSign = null;
    private String exponentSeparator;
    private char exponential;
    private char groupingSeparator;
    private String groupingSeparatorString;
    private String infinity;
    private String intlCurrencySymbol;
    private char minusSign;
    private String minusString;
    private char monetaryGroupingSeparator;
    private String monetaryGroupingSeparatorString;
    private char monetarySeparator;
    private String monetarySeparatorString;
    private char padEscape;
    private char patternSeparator;
    private char perMill;
    private String perMillString;
    private char percent;
    private String percentString;
    private char plusSign;
    private String plusString;
    private Locale requestedLocale;
    private int serialVersionOnStream = 8;
    private char sigDigit;
    private ULocale ulocale;
    private ULocale validLocale;
    private char zeroDigit;

    public DecimalFormatSymbols() {
        initialize(ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public DecimalFormatSymbols(ULocale uLocale) {
        initialize(uLocale);
    }

    public static DecimalFormatSymbols getInstance() {
        return new DecimalFormatSymbols();
    }

    public char[] getDigits() {
        return (char[]) this.digits.clone();
    }

    public String[] getDigitStrings() {
        return (String[]) this.digitStrings.clone();
    }

    @Deprecated
    public String[] getDigitStringsLocal() {
        return this.digitStrings;
    }

    public void setDigitStrings(String[] strArr) {
        if (strArr == null) {
            throw new NullPointerException("The input digit string array is null");
        } else if (strArr.length != 10) {
            throw new IllegalArgumentException("Number of digit strings is not 10");
        } else {
            String[] strArr2 = new String[10];
            char[] cArr = new char[10];
            for (int i = 0; i < 10; i++) {
                if (strArr[i] == null) {
                    throw new IllegalArgumentException("The input digit string array contains a null element");
                }
                strArr2[i] = strArr[i];
                if (cArr == null || strArr[i].length() != 1) {
                    cArr = null;
                } else {
                    cArr[i] = strArr[i].charAt(0);
                }
            }
            this.digitStrings = strArr2;
            if (cArr == null) {
                this.zeroDigit = DEF_DIGIT_CHARS_ARRAY[0];
                this.digits = DEF_DIGIT_CHARS_ARRAY;
                return;
            }
            this.zeroDigit = cArr[0];
            this.digits = cArr;
        }
    }

    public String getGroupingSeparatorString() {
        return this.groupingSeparatorString;
    }

    public void setGroupingSeparatorString(String str) {
        if (str == null) {
            throw new NullPointerException("The input grouping separator is null");
        }
        this.groupingSeparatorString = str;
        if (str.length() == 1) {
            this.groupingSeparator = str.charAt(0);
        } else {
            this.groupingSeparator = ',';
        }
    }

    public char getDecimalSeparator() {
        return this.decimalSeparator;
    }

    public String getDecimalSeparatorString() {
        return this.decimalSeparatorString;
    }

    public void setDecimalSeparatorString(String str) {
        if (str == null) {
            throw new NullPointerException("The input decimal separator is null");
        }
        this.decimalSeparatorString = str;
        if (str.length() == 1) {
            this.decimalSeparator = str.charAt(0);
        } else {
            this.decimalSeparator = '.';
        }
    }

    public String getPerMillString() {
        return this.perMillString;
    }

    public void setPerMillString(String str) {
        if (str == null) {
            throw new NullPointerException("The input permille string is null");
        }
        this.perMillString = str;
        if (str.length() == 1) {
            this.perMill = str.charAt(0);
        } else {
            this.perMill = 8240;
        }
    }

    public String getPercentString() {
        return this.percentString;
    }

    public void setPercentString(String str) {
        if (str == null) {
            throw new NullPointerException("The input percent sign is null");
        }
        this.percentString = str;
        if (str.length() == 1) {
            this.percent = str.charAt(0);
        } else {
            this.percent = '%';
        }
    }

    public String getInfinity() {
        return this.infinity;
    }

    public void setInfinity(String str) {
        this.infinity = str;
    }

    public String getNaN() {
        return this.NaN;
    }

    public void setNaN(String str) {
        this.NaN = str;
    }

    public String getMinusSignString() {
        return this.minusString;
    }

    public void setMinusSignString(String str) {
        if (str == null) {
            throw new NullPointerException("The input minus sign is null");
        }
        this.minusString = str;
        if (str.length() == 1) {
            this.minusSign = str.charAt(0);
        } else {
            this.minusSign = '-';
        }
    }

    public String getPlusSignString() {
        return this.plusString;
    }

    public void setPlusSignString(String str) {
        if (str == null) {
            throw new NullPointerException("The input plus sign is null");
        }
        this.plusString = str;
        if (str.length() == 1) {
            this.plusSign = str.charAt(0);
        } else {
            this.plusSign = '+';
        }
    }

    public String getCurrencySymbol() {
        return this.currencySymbol;
    }

    public void setCurrencySymbol(String str) {
        this.currencySymbol = str;
    }

    public String getInternationalCurrencySymbol() {
        return this.intlCurrencySymbol;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public void setCurrency(Currency currency2) {
        if (currency2 == null) {
            throw new NullPointerException();
        }
        this.currency = currency2;
        this.intlCurrencySymbol = currency2.getCurrencyCode();
        this.currencySymbol = currency2.getSymbol(this.requestedLocale);
    }

    public String getMonetaryDecimalSeparatorString() {
        return this.monetarySeparatorString;
    }

    public void setMonetaryDecimalSeparatorString(String str) {
        if (str == null) {
            throw new NullPointerException("The input monetary decimal separator is null");
        }
        this.monetarySeparatorString = str;
        if (str.length() == 1) {
            this.monetarySeparator = str.charAt(0);
        } else {
            this.monetarySeparator = '.';
        }
    }

    public String getMonetaryGroupingSeparatorString() {
        return this.monetaryGroupingSeparatorString;
    }

    public void setMonetaryGroupingSeparatorString(String str) {
        if (str == null) {
            throw new NullPointerException("The input monetary grouping separator is null");
        }
        this.monetaryGroupingSeparatorString = str;
        if (str.length() == 1) {
            this.monetaryGroupingSeparator = str.charAt(0);
        } else {
            this.monetaryGroupingSeparator = ',';
        }
    }

    /* access modifiers changed from: package-private */
    public String getCurrencyPattern() {
        return this.currencyPattern;
    }

    public void setExponentMultiplicationSign(String str) {
        this.exponentMultiplicationSign = str;
    }

    public String getExponentSeparator() {
        return this.exponentSeparator;
    }

    public void setExponentSeparator(String str) {
        this.exponentSeparator = str;
    }

    public ULocale getULocale() {
        return this.ulocale;
    }

    @Override // java.lang.Object
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new ICUCloneNotSupportedException(e);
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof DecimalFormatSymbols)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        DecimalFormatSymbols decimalFormatSymbols = (DecimalFormatSymbols) obj;
        for (int i = 0; i <= 2; i++) {
            if (!(this.currencySpcBeforeSym[i].equals(decimalFormatSymbols.currencySpcBeforeSym[i]) && this.currencySpcAfterSym[i].equals(decimalFormatSymbols.currencySpcAfterSym[i]))) {
                return false;
            }
        }
        if (decimalFormatSymbols.digits == null) {
            for (int i2 = 0; i2 < 10; i2++) {
                if (this.digits[i2] != decimalFormatSymbols.zeroDigit + i2) {
                    return false;
                }
            }
        } else if (!Arrays.equals(this.digits, decimalFormatSymbols.digits)) {
            return false;
        }
        return this.groupingSeparator == decimalFormatSymbols.groupingSeparator && this.decimalSeparator == decimalFormatSymbols.decimalSeparator && this.percent == decimalFormatSymbols.percent && this.perMill == decimalFormatSymbols.perMill && this.digit == decimalFormatSymbols.digit && this.minusSign == decimalFormatSymbols.minusSign && this.minusString.equals(decimalFormatSymbols.minusString) && this.patternSeparator == decimalFormatSymbols.patternSeparator && this.infinity.equals(decimalFormatSymbols.infinity) && this.NaN.equals(decimalFormatSymbols.NaN) && this.currencySymbol.equals(decimalFormatSymbols.currencySymbol) && this.intlCurrencySymbol.equals(decimalFormatSymbols.intlCurrencySymbol) && this.padEscape == decimalFormatSymbols.padEscape && this.plusSign == decimalFormatSymbols.plusSign && this.plusString.equals(decimalFormatSymbols.plusString) && this.exponentSeparator.equals(decimalFormatSymbols.exponentSeparator) && this.monetarySeparator == decimalFormatSymbols.monetarySeparator && this.monetaryGroupingSeparator == decimalFormatSymbols.monetaryGroupingSeparator && this.exponentMultiplicationSign.equals(decimalFormatSymbols.exponentMultiplicationSign);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (((this.digits[0] * '%') + this.groupingSeparator) * 37) + this.decimalSeparator;
    }

    /* access modifiers changed from: package-private */
    public static final class DecFmtDataSink extends UResource.Sink {
        private String[] numberElements;

        public DecFmtDataSink(String[] strArr) {
            this.numberElements = strArr;
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                int i2 = 0;
                while (true) {
                    if (i2 >= DecimalFormatSymbols.SYMBOL_KEYS.length) {
                        break;
                    } else if (!key.contentEquals(DecimalFormatSymbols.SYMBOL_KEYS[i2])) {
                        i2++;
                    } else if (this.numberElements[i2] == null) {
                        this.numberElements[i2] = value.toString();
                    }
                }
            }
        }
    }

    private void initialize(ULocale uLocale) {
        this.requestedLocale = uLocale.toLocale();
        this.ulocale = uLocale;
        CacheData instance = cachedLocaleData.getInstance(uLocale, null);
        setLocale(instance.validLocale, instance.validLocale);
        setDigitStrings(instance.digits);
        String[] strArr = instance.numberElements;
        setDecimalSeparatorString(strArr[0]);
        setGroupingSeparatorString(strArr[1]);
        this.patternSeparator = strArr[2].charAt(0);
        setPercentString(strArr[3]);
        setMinusSignString(strArr[4]);
        setPlusSignString(strArr[5]);
        setExponentSeparator(strArr[6]);
        setPerMillString(strArr[7]);
        setInfinity(strArr[8]);
        setNaN(strArr[9]);
        setMonetaryDecimalSeparatorString(strArr[10]);
        setMonetaryGroupingSeparatorString(strArr[11]);
        setExponentMultiplicationSign(strArr[12]);
        this.digit = '#';
        this.padEscape = '*';
        this.sigDigit = '@';
        CurrencyData.CurrencyDisplayInfo instance2 = CurrencyData.provider.getInstance(uLocale, true);
        this.currency = Currency.getInstance(uLocale);
        if (this.currency != null) {
            this.intlCurrencySymbol = this.currency.getCurrencyCode();
            this.currencySymbol = this.currency.getName(uLocale, 0, null);
            CurrencyData.CurrencyFormatInfo formatInfo = instance2.getFormatInfo(this.intlCurrencySymbol);
            if (formatInfo != null) {
                this.currencyPattern = formatInfo.currencyPattern;
                setMonetaryDecimalSeparatorString(formatInfo.monetarySeparator);
                setMonetaryGroupingSeparatorString(formatInfo.monetaryGroupingSeparator);
            }
        } else {
            this.intlCurrencySymbol = "XXX";
            this.currencySymbol = "¤";
        }
        initSpacingInfo(instance2.getSpacingInfo());
    }

    /* access modifiers changed from: private */
    public static CacheData loadData(ULocale uLocale) {
        String str;
        NumberingSystem instance = NumberingSystem.getInstance(uLocale);
        String[] strArr = new String[10];
        if (instance == null || instance.getRadix() != 10 || instance.isAlgorithmic() || !NumberingSystem.isValidDigitString(instance.getDescription())) {
            strArr = DEF_DIGIT_STRINGS_ARRAY;
            str = "latn";
        } else {
            String description = instance.getDescription();
            int i = 0;
            for (int i2 = 0; i2 < 10; i2++) {
                int charCount = i + Character.charCount(description.codePointAt(i));
                strArr[i2] = description.substring(i, charCount);
                i = charCount;
            }
            str = instance.getName();
        }
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b", uLocale);
        ULocale uLocale2 = iCUResourceBundle.getULocale();
        String[] strArr2 = new String[SYMBOL_KEYS.length];
        DecFmtDataSink decFmtDataSink = new DecFmtDataSink(strArr2);
        try {
            iCUResourceBundle.getAllItemsWithFallback("NumberElements/" + str + "/symbols", decFmtDataSink);
        } catch (MissingResourceException e) {
        }
        boolean z = false;
        int length = strArr2.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            } else if (strArr2[i3] == null) {
                z = true;
                break;
            } else {
                i3++;
            }
        }
        if (z && !str.equals("latn")) {
            iCUResourceBundle.getAllItemsWithFallback("NumberElements/latn/symbols", decFmtDataSink);
        }
        for (int i4 = 0; i4 < SYMBOL_KEYS.length; i4++) {
            if (strArr2[i4] == null) {
                strArr2[i4] = SYMBOL_DEFAULTS[i4];
            }
        }
        if (strArr2[10] == null) {
            strArr2[10] = strArr2[0];
        }
        if (strArr2[11] == null) {
            strArr2[11] = strArr2[1];
        }
        return new CacheData(uLocale2, strArr, strArr2);
    }

    private void initSpacingInfo(CurrencyData.CurrencySpacingInfo currencySpacingInfo) {
        this.currencySpcBeforeSym = currencySpacingInfo.getBeforeSymbols();
        this.currencySpcAfterSym = currencySpacingInfo.getAfterSymbols();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        if (this.serialVersionOnStream < 1) {
            this.monetarySeparator = this.decimalSeparator;
            this.exponential = 'E';
        }
        if (this.serialVersionOnStream < 2) {
            this.padEscape = '*';
            this.plusSign = '+';
            this.exponentSeparator = String.valueOf(this.exponential);
        }
        if (this.serialVersionOnStream < 3) {
            this.requestedLocale = Locale.getDefault();
        }
        if (this.serialVersionOnStream < 4) {
            this.ulocale = ULocale.forLocale(this.requestedLocale);
        }
        if (this.serialVersionOnStream < 5) {
            this.monetaryGroupingSeparator = this.groupingSeparator;
        }
        if (this.serialVersionOnStream < 6) {
            if (this.currencySpcBeforeSym == null) {
                this.currencySpcBeforeSym = new String[3];
            }
            if (this.currencySpcAfterSym == null) {
                this.currencySpcAfterSym = new String[3];
            }
            initSpacingInfo(CurrencyData.CurrencySpacingInfo.DEFAULT);
        }
        if (this.serialVersionOnStream < 7) {
            if (this.minusString == null) {
                this.minusString = String.valueOf(this.minusSign);
            }
            if (this.plusString == null) {
                this.plusString = String.valueOf(this.plusSign);
            }
        }
        if (this.serialVersionOnStream < 8 && this.exponentMultiplicationSign == null) {
            this.exponentMultiplicationSign = "×";
        }
        if (this.serialVersionOnStream < 9) {
            if (this.digitStrings == null) {
                this.digitStrings = new String[10];
                if (this.digits == null || this.digits.length != 10) {
                    char c = this.zeroDigit;
                    if (this.digits == null) {
                        this.digits = new char[10];
                    }
                    for (int i = 0; i < 10; i++) {
                        this.digits[i] = c;
                        this.digitStrings[i] = String.valueOf(c);
                        c = (char) (c + 1);
                    }
                } else {
                    this.zeroDigit = this.digits[0];
                    for (int i2 = 0; i2 < 10; i2++) {
                        this.digitStrings[i2] = String.valueOf(this.digits[i2]);
                    }
                }
            }
            if (this.decimalSeparatorString == null) {
                this.decimalSeparatorString = String.valueOf(this.decimalSeparator);
            }
            if (this.groupingSeparatorString == null) {
                this.groupingSeparatorString = String.valueOf(this.groupingSeparator);
            }
            if (this.percentString == null) {
                this.percentString = String.valueOf(this.percent);
            }
            if (this.perMillString == null) {
                this.perMillString = String.valueOf(this.perMill);
            }
            if (this.monetarySeparatorString == null) {
                this.monetarySeparatorString = String.valueOf(this.monetarySeparator);
            }
            if (this.monetaryGroupingSeparatorString == null) {
                this.monetaryGroupingSeparatorString = String.valueOf(this.monetaryGroupingSeparator);
            }
        }
        this.serialVersionOnStream = 8;
        this.currency = Currency.getInstance(this.intlCurrencySymbol);
    }

    public final ULocale getLocale(ULocale.Type type) {
        return type == ULocale.ACTUAL_LOCALE ? this.actualLocale : this.validLocale;
    }

    /* access modifiers changed from: package-private */
    public final void setLocale(ULocale uLocale, ULocale uLocale2) {
        if ((uLocale == null) != (uLocale2 == null)) {
            throw new IllegalArgumentException();
        }
        this.validLocale = uLocale;
        this.actualLocale = uLocale2;
    }

    /* access modifiers changed from: package-private */
    public static class CacheData {
        final String[] digits;
        final String[] numberElements;
        final ULocale validLocale;

        public CacheData(ULocale uLocale, String[] strArr, String[] strArr2) {
            this.validLocale = uLocale;
            this.digits = strArr;
            this.numberElements = strArr2;
        }
    }
}

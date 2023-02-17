package com.ibm.icu.impl;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.NumberFormat;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.MissingResourceException;
public final class DateNumberFormat extends NumberFormat {
    private static SimpleCache<ULocale, char[]> CACHE = new SimpleCache<>();
    private static final long serialVersionUID = -6315692826916346953L;
    private transient char[] decimalBuf = new char[20];
    private char[] digits;
    private int maxIntDigits;
    private int minIntDigits;
    private char minusSign;
    private boolean positiveOnly = false;
    private char zeroDigit;

    public DateNumberFormat(ULocale uLocale, String str, String str2) {
        initialize(uLocale, str, str2);
    }

    private void initialize(ULocale uLocale, String str, String str2) {
        String str3;
        char[] cArr = CACHE.get(uLocale);
        if (cArr == null) {
            ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b", uLocale);
            try {
                str3 = iCUResourceBundle.getStringWithFallback("NumberElements/" + str2 + "/symbols/minusSign");
            } catch (MissingResourceException e) {
                if (!str2.equals("latn")) {
                    try {
                        str3 = iCUResourceBundle.getStringWithFallback("NumberElements/latn/symbols/minusSign");
                    } catch (MissingResourceException e2) {
                        str3 = "-";
                    }
                } else {
                    str3 = "-";
                }
            }
            cArr = new char[11];
            for (int i = 0; i < 10; i++) {
                cArr[i] = str.charAt(i);
            }
            cArr[10] = str3.charAt(0);
            CACHE.put(uLocale, cArr);
        }
        this.digits = new char[10];
        System.arraycopy(cArr, 0, this.digits, 0, 10);
        this.zeroDigit = this.digits[0];
        this.minusSign = cArr[10];
    }

    @Override // com.ibm.icu.text.NumberFormat
    public void setMaximumIntegerDigits(int i) {
        this.maxIntDigits = i;
    }

    @Override // com.ibm.icu.text.NumberFormat
    public void setMinimumIntegerDigits(int i) {
        this.minIntDigits = i;
    }

    public void setParsePositiveOnly(boolean z) {
        this.positiveOnly = z;
    }

    public void setZeroDigit(char c) {
        this.zeroDigit = c;
        if (this.digits == null) {
            this.digits = new char[10];
        }
        this.digits[0] = c;
        for (int i = 1; i < 10; i++) {
            this.digits[i] = (char) (c + i);
        }
    }

    public char[] getDigits() {
        return (char[]) this.digits.clone();
    }

    @Override // com.ibm.icu.text.NumberFormat
    public StringBuffer format(double d, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        throw new UnsupportedOperationException("StringBuffer format(double, StringBuffer, FieldPostion) is not implemented");
    }

    @Override // com.ibm.icu.text.NumberFormat
    public StringBuffer format(long j, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (j < 0) {
            stringBuffer.append(this.minusSign);
            j = -j;
        }
        int i = (int) j;
        int length = this.decimalBuf.length < this.maxIntDigits ? this.decimalBuf.length : this.maxIntDigits;
        int i2 = length - 1;
        while (true) {
            this.decimalBuf[i2] = this.digits[i % 10];
            i /= 10;
            if (i2 == 0 || i == 0) {
                break;
            }
            i2--;
        }
        for (int i3 = this.minIntDigits - (length - i2); i3 > 0; i3--) {
            i2--;
            this.decimalBuf[i2] = this.digits[0];
        }
        int i4 = length - i2;
        stringBuffer.append(this.decimalBuf, i2, i4);
        fieldPosition.setBeginIndex(0);
        if (fieldPosition.getField() == 0) {
            fieldPosition.setEndIndex(i4);
        } else {
            fieldPosition.setEndIndex(0);
        }
        return stringBuffer;
    }

    @Override // com.ibm.icu.text.NumberFormat
    public StringBuffer format(BigInteger bigInteger, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        throw new UnsupportedOperationException("StringBuffer format(BigInteger, StringBuffer, FieldPostion) is not implemented");
    }

    @Override // com.ibm.icu.text.NumberFormat
    public StringBuffer format(BigDecimal bigDecimal, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        throw new UnsupportedOperationException("StringBuffer format(BigDecimal, StringBuffer, FieldPostion) is not implemented");
    }

    @Override // com.ibm.icu.text.NumberFormat
    public StringBuffer format(com.ibm.icu.math.BigDecimal bigDecimal, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        throw new UnsupportedOperationException("StringBuffer format(BigDecimal, StringBuffer, FieldPostion) is not implemented");
    }

    @Override // com.ibm.icu.text.NumberFormat
    public Number parse(String str, ParsePosition parsePosition) {
        long j = 0;
        boolean z = false;
        boolean z2 = false;
        int index = parsePosition.getIndex();
        int i = 0;
        while (index + i < str.length()) {
            char charAt = str.charAt(index + i);
            if (i != 0 || charAt != this.minusSign) {
                int i2 = charAt - this.digits[0];
                if (i2 < 0 || 9 < i2) {
                    i2 = UCharacter.digit(charAt);
                }
                if (i2 < 0 || 9 < i2) {
                    i2 = 0;
                    while (i2 < 10 && charAt != this.digits[i2]) {
                        i2++;
                    }
                }
                if (0 > i2 || i2 > 9 || j >= 922337203685477579L) {
                    break;
                }
                z = true;
                j = (10 * j) + ((long) i2);
            } else if (this.positiveOnly) {
                break;
            } else {
                z2 = true;
            }
            i++;
        }
        if (!z) {
            return null;
        }
        Long valueOf = Long.valueOf(z2 ? -1 * j : j);
        parsePosition.setIndex(index + i);
        return valueOf;
    }

    @Override // com.ibm.icu.text.NumberFormat, java.lang.Object
    public boolean equals(Object obj) {
        if (obj == null || !super.equals(obj) || !(obj instanceof DateNumberFormat)) {
            return false;
        }
        DateNumberFormat dateNumberFormat = (DateNumberFormat) obj;
        return this.maxIntDigits == dateNumberFormat.maxIntDigits && this.minIntDigits == dateNumberFormat.minIntDigits && this.minusSign == dateNumberFormat.minusSign && this.positiveOnly == dateNumberFormat.positiveOnly && Arrays.equals(this.digits, dateNumberFormat.digits);
    }

    @Override // com.ibm.icu.text.NumberFormat, java.lang.Object
    public int hashCode() {
        return super.hashCode();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        if (this.digits == null) {
            setZeroDigit(this.zeroDigit);
        }
        this.decimalBuf = new char[20];
    }

    @Override // com.ibm.icu.text.NumberFormat, java.text.Format, java.lang.Object
    public Object clone() {
        DateNumberFormat dateNumberFormat = (DateNumberFormat) super.clone();
        dateNumberFormat.digits = (char[]) this.digits.clone();
        dateNumberFormat.decimalBuf = new char[20];
        return dateNumberFormat;
    }
}

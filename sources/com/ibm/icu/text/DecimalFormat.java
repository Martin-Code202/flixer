package com.ibm.icu.text;

import com.ibm.icu.impl.number.AffixPatternUtils;
import com.ibm.icu.impl.number.Endpoint;
import com.ibm.icu.impl.number.Format;
import com.ibm.icu.impl.number.FormatQuantity4;
import com.ibm.icu.impl.number.Parse;
import com.ibm.icu.impl.number.PatternString;
import com.ibm.icu.impl.number.Properties;
import com.ibm.icu.impl.number.formatters.CurrencyFormat;
import com.ibm.icu.impl.number.formatters.PaddingFormat;
import com.ibm.icu.math.MathContext;
import com.ibm.icu.text.PluralRules;
import com.ibm.icu.util.Currency;
import com.ibm.icu.util.CurrencyAmount;
import com.ibm.icu.util.ULocale;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.AttributedCharacterIterator;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
public class DecimalFormat extends NumberFormat {
    static final /* synthetic */ boolean $assertionsDisabled = (!DecimalFormat.class.desiredAssertionStatus());
    private static final long serialVersionUID = 864413376551465018L;
    private static final ThreadLocal<Properties> threadLocalProperties = new ThreadLocal<Properties>() { // from class: com.ibm.icu.text.DecimalFormat.1
        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Properties initialValue() {
            return new Properties();
        }
    };
    volatile transient Properties exportedProperties;
    volatile transient Format.SingularFormat formatter;
    private transient int icuMathContextForm = 0;
    transient Properties properties;
    private final int serialVersionOnStream = 5;
    volatile transient DecimalFormatSymbols symbols;

    @Deprecated
    public enum SignificantDigitsMode {
        OVERRIDE_MAXIMUM_FRACTION,
        RESPECT_MAXIMUM_FRACTION,
        ENSURE_MINIMUM_SIGNIFICANT
    }

    public DecimalFormat() {
        String pattern = getPattern(ULocale.getDefault(ULocale.Category.FORMAT), 0);
        this.symbols = getDefaultSymbols();
        this.properties = new Properties();
        this.exportedProperties = new Properties();
        setPropertiesFromPattern(pattern, AffixPatternUtils.hasCurrencySymbols(pattern));
        refreshFormatter();
    }

    public DecimalFormat(String str, DecimalFormatSymbols decimalFormatSymbols) {
        this.symbols = (DecimalFormatSymbols) decimalFormatSymbols.clone();
        this.properties = new Properties();
        this.exportedProperties = new Properties();
        setPropertiesFromPattern(str, AffixPatternUtils.hasCurrencySymbols(str));
        refreshFormatter();
    }

    DecimalFormat(String str, DecimalFormatSymbols decimalFormatSymbols, int i) {
        this.symbols = (DecimalFormatSymbols) decimalFormatSymbols.clone();
        this.properties = new Properties();
        this.exportedProperties = new Properties();
        if (i == 1 || i == 5 || i == 7 || i == 8 || i == 9 || i == 6 || AffixPatternUtils.hasCurrencySymbols(str)) {
            setPropertiesFromPattern(str, true);
        } else {
            setPropertiesFromPattern(str, false);
        }
        refreshFormatter();
    }

    private static DecimalFormatSymbols getDefaultSymbols() {
        return DecimalFormatSymbols.getInstance();
    }

    public synchronized void applyPattern(String str) {
        setPropertiesFromPattern(str, false);
        this.properties.setPositivePrefix(null);
        this.properties.setNegativePrefix(null);
        this.properties.setPositiveSuffix(null);
        this.properties.setNegativeSuffix(null);
        this.properties.setCurrencyPluralInfo(null);
        refreshFormatter();
    }

    @Override // com.ibm.icu.text.NumberFormat, java.text.Format, java.lang.Object
    public Object clone() {
        DecimalFormat decimalFormat = (DecimalFormat) super.clone();
        decimalFormat.symbols = (DecimalFormatSymbols) this.symbols.clone();
        decimalFormat.properties = this.properties.clone();
        decimalFormat.exportedProperties = new Properties();
        decimalFormat.refreshFormatter();
        return decimalFormat;
    }

    private synchronized void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(0);
        objectOutputStream.writeObject(this.properties);
        objectOutputStream.writeObject(this.symbols);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        ObjectInputStream.GetField readFields = objectInputStream.readFields();
        ObjectStreamField[] fields = readFields.getObjectStreamClass().getFields();
        int i = readFields.get("serialVersionOnStream", -1);
        if (i > 5) {
            throw new IOException("Cannot deserialize newer com.ibm.icu.text.DecimalFormat (v" + i + ")");
        } else if (i != 5) {
            this.properties = new Properties();
            String str = null;
            String str2 = null;
            String str3 = null;
            String str4 = null;
            String str5 = null;
            String str6 = null;
            String str7 = null;
            String str8 = null;
            int length = fields.length;
            for (int i2 = 0; i2 < length; i2++) {
                String name = fields[i2].getName();
                if (name.equals("decimalSeparatorAlwaysShown")) {
                    setDecimalSeparatorAlwaysShown(readFields.get("decimalSeparatorAlwaysShown", false));
                } else if (name.equals("exponentSignAlwaysShown")) {
                    setExponentSignAlwaysShown(readFields.get("exponentSignAlwaysShown", false));
                } else if (name.equals("formatWidth")) {
                    setFormatWidth(readFields.get("formatWidth", 0));
                } else if (name.equals("groupingSize")) {
                    setGroupingSize(readFields.get("groupingSize", (byte) 3));
                } else if (name.equals("groupingSize2")) {
                    setSecondaryGroupingSize(readFields.get("groupingSize2", (byte) 0));
                } else if (name.equals("maxSignificantDigits")) {
                    setMaximumSignificantDigits(readFields.get("maxSignificantDigits", 6));
                } else if (name.equals("minExponentDigits")) {
                    setMinimumExponentDigits(readFields.get("minExponentDigits", (byte) 0));
                } else if (name.equals("minSignificantDigits")) {
                    setMinimumSignificantDigits(readFields.get("minSignificantDigits", 1));
                } else if (name.equals("multiplier")) {
                    setMultiplier(readFields.get("multiplier", 1));
                } else if (name.equals("pad")) {
                    setPadCharacter(readFields.get("pad", ' '));
                } else if (name.equals("padPosition")) {
                    setPadPosition(readFields.get("padPosition", 0));
                } else if (name.equals("parseBigDecimal")) {
                    setParseBigDecimal(readFields.get("parseBigDecimal", false));
                } else if (name.equals("parseRequireDecimalPoint")) {
                    setDecimalPatternMatchRequired(readFields.get("parseRequireDecimalPoint", false));
                } else if (name.equals("roundingMode")) {
                    setRoundingMode(readFields.get("roundingMode", 0));
                } else if (name.equals("useExponentialNotation")) {
                    setScientificNotation(readFields.get("useExponentialNotation", false));
                } else if (name.equals("useSignificantDigits")) {
                    setSignificantDigitsUsed(readFields.get("useSignificantDigits", false));
                } else if (name.equals("currencyPluralInfo")) {
                    setCurrencyPluralInfo((CurrencyPluralInfo) readFields.get("currencyPluralInfo", (Object) null));
                } else if (name.equals("mathContext")) {
                    setMathContextICU((MathContext) readFields.get("mathContext", (Object) null));
                } else if (name.equals("negPrefixPattern")) {
                    str6 = (String) readFields.get("negPrefixPattern", (Object) null);
                } else if (name.equals("negSuffixPattern")) {
                    str8 = (String) readFields.get("negSuffixPattern", (Object) null);
                } else if (name.equals("negativePrefix")) {
                    str5 = (String) readFields.get("negativePrefix", (Object) null);
                } else if (name.equals("negativeSuffix")) {
                    str7 = (String) readFields.get("negativeSuffix", (Object) null);
                } else if (name.equals("posPrefixPattern")) {
                    str2 = (String) readFields.get("posPrefixPattern", (Object) null);
                } else if (name.equals("posSuffixPattern")) {
                    str4 = (String) readFields.get("posSuffixPattern", (Object) null);
                } else if (name.equals("positivePrefix")) {
                    str = (String) readFields.get("positivePrefix", (Object) null);
                } else if (name.equals("positiveSuffix")) {
                    str3 = (String) readFields.get("positiveSuffix", (Object) null);
                } else if (name.equals("roundingIncrement")) {
                    setRoundingIncrement((BigDecimal) readFields.get("roundingIncrement", (Object) null));
                } else if (name.equals("symbols")) {
                    setDecimalFormatSymbols((DecimalFormatSymbols) readFields.get("symbols", (Object) null));
                }
            }
            if (str6 == null) {
                this.properties.setNegativePrefix(str5);
            } else {
                this.properties.setNegativePrefixPattern(str6);
            }
            if (str8 == null) {
                this.properties.setNegativeSuffix(str7);
            } else {
                this.properties.setNegativeSuffixPattern(str8);
            }
            if (str2 == null) {
                this.properties.setPositivePrefix(str);
            } else {
                this.properties.setPositivePrefixPattern(str2);
            }
            if (str4 == null) {
                this.properties.setPositiveSuffix(str3);
            } else {
                this.properties.setPositiveSuffixPattern(str4);
            }
            try {
                Field declaredField = NumberFormat.class.getDeclaredField("groupingUsed");
                declaredField.setAccessible(true);
                setGroupingUsed(((Boolean) declaredField.get(this)).booleanValue());
                Field declaredField2 = NumberFormat.class.getDeclaredField("parseIntegerOnly");
                declaredField2.setAccessible(true);
                setParseIntegerOnly(((Boolean) declaredField2.get(this)).booleanValue());
                Field declaredField3 = NumberFormat.class.getDeclaredField("maximumIntegerDigits");
                declaredField3.setAccessible(true);
                setMaximumIntegerDigits(((Integer) declaredField3.get(this)).intValue());
                Field declaredField4 = NumberFormat.class.getDeclaredField("minimumIntegerDigits");
                declaredField4.setAccessible(true);
                setMinimumIntegerDigits(((Integer) declaredField4.get(this)).intValue());
                Field declaredField5 = NumberFormat.class.getDeclaredField("maximumFractionDigits");
                declaredField5.setAccessible(true);
                setMaximumFractionDigits(((Integer) declaredField5.get(this)).intValue());
                Field declaredField6 = NumberFormat.class.getDeclaredField("minimumFractionDigits");
                declaredField6.setAccessible(true);
                setMinimumFractionDigits(((Integer) declaredField6.get(this)).intValue());
                Field declaredField7 = NumberFormat.class.getDeclaredField("currency");
                declaredField7.setAccessible(true);
                setCurrency((Currency) declaredField7.get(this));
                Field declaredField8 = NumberFormat.class.getDeclaredField("parseStrict");
                declaredField8.setAccessible(true);
                setParseStrict(((Boolean) declaredField8.get(this)).booleanValue());
                if (this.symbols == null) {
                    this.symbols = getDefaultSymbols();
                }
                this.exportedProperties = new Properties();
                refreshFormatter();
            } catch (IllegalArgumentException e) {
                throw new IOException(e);
            } catch (IllegalAccessException e2) {
                throw new IOException(e2);
            } catch (NoSuchFieldException e3) {
                throw new IOException(e3);
            } catch (SecurityException e4) {
                throw new IOException(e4);
            }
        } else if (fields.length > 1) {
            throw new IOException("Too many fields when reading serial version 5");
        } else {
            objectInputStream.readInt();
            this.properties = (Properties) objectInputStream.readObject();
            this.symbols = (DecimalFormatSymbols) objectInputStream.readObject();
            this.exportedProperties = new Properties();
            refreshFormatter();
        }
    }

    @Override // com.ibm.icu.text.NumberFormat
    public StringBuffer format(double d, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        FormatQuantity4 formatQuantity4 = new FormatQuantity4(d);
        this.formatter.format(formatQuantity4, stringBuffer, fieldPosition);
        formatQuantity4.populateUFieldPosition(fieldPosition);
        return stringBuffer;
    }

    @Override // com.ibm.icu.text.NumberFormat
    public StringBuffer format(long j, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        FormatQuantity4 formatQuantity4 = new FormatQuantity4(j);
        this.formatter.format(formatQuantity4, stringBuffer, fieldPosition);
        formatQuantity4.populateUFieldPosition(fieldPosition);
        return stringBuffer;
    }

    @Override // com.ibm.icu.text.NumberFormat
    public StringBuffer format(BigInteger bigInteger, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        FormatQuantity4 formatQuantity4 = new FormatQuantity4(bigInteger);
        this.formatter.format(formatQuantity4, stringBuffer, fieldPosition);
        formatQuantity4.populateUFieldPosition(fieldPosition);
        return stringBuffer;
    }

    @Override // com.ibm.icu.text.NumberFormat
    public StringBuffer format(BigDecimal bigDecimal, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        FormatQuantity4 formatQuantity4 = new FormatQuantity4(bigDecimal);
        this.formatter.format(formatQuantity4, stringBuffer, fieldPosition);
        formatQuantity4.populateUFieldPosition(fieldPosition);
        return stringBuffer;
    }

    @Override // com.ibm.icu.text.NumberFormat
    public StringBuffer format(com.ibm.icu.math.BigDecimal bigDecimal, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        FormatQuantity4 formatQuantity4 = new FormatQuantity4(bigDecimal.toBigDecimal());
        this.formatter.format(formatQuantity4, stringBuffer, fieldPosition);
        formatQuantity4.populateUFieldPosition(fieldPosition);
        return stringBuffer;
    }

    @Override // java.text.Format
    public AttributedCharacterIterator formatToCharacterIterator(Object obj) {
        if (!(obj instanceof Number)) {
            throw new IllegalArgumentException();
        }
        return this.formatter.formatToCharacterIterator(new FormatQuantity4((Number) obj));
    }

    @Override // com.ibm.icu.text.NumberFormat
    public StringBuffer format(CurrencyAmount currencyAmount, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        Properties properties2 = threadLocalProperties.get();
        Format.SingularFormat singularFormat = null;
        synchronized (this) {
            if (currencyAmount.getCurrency().equals(this.properties.getCurrency())) {
                singularFormat = this.formatter;
            } else {
                properties2.copyFrom(this.properties);
            }
        }
        if (singularFormat == null) {
            properties2.setCurrency(currencyAmount.getCurrency());
            singularFormat = Endpoint.fromBTA(properties2, this.symbols);
        }
        FormatQuantity4 formatQuantity4 = new FormatQuantity4(currencyAmount.getNumber());
        singularFormat.format(formatQuantity4, stringBuffer, fieldPosition);
        formatQuantity4.populateUFieldPosition(fieldPosition);
        return stringBuffer;
    }

    @Override // com.ibm.icu.text.NumberFormat
    public Number parse(String str, ParsePosition parsePosition) {
        Properties properties2 = threadLocalProperties.get();
        synchronized (this) {
            properties2.copyFrom(this.properties);
        }
        Number parse = Parse.parse(str, parsePosition, properties2, this.symbols);
        if (parse instanceof BigDecimal) {
            return new com.ibm.icu.math.BigDecimal((BigDecimal) parse);
        }
        return parse;
    }

    @Override // com.ibm.icu.text.NumberFormat
    public CurrencyAmount parseCurrency(CharSequence charSequence, ParsePosition parsePosition) {
        try {
            CurrencyAmount parseCurrency = Parse.parseCurrency(charSequence, parsePosition, this.properties, this.symbols);
            if (parseCurrency == null) {
                return null;
            }
            Number number = parseCurrency.getNumber();
            if (number instanceof BigDecimal) {
                return new CurrencyAmount(new com.ibm.icu.math.BigDecimal((BigDecimal) number), parseCurrency.getCurrency());
            }
            return parseCurrency;
        } catch (ParseException e) {
            return null;
        }
    }

    public synchronized DecimalFormatSymbols getDecimalFormatSymbols() {
        return (DecimalFormatSymbols) this.symbols.clone();
    }

    public synchronized void setDecimalFormatSymbols(DecimalFormatSymbols decimalFormatSymbols) {
        this.symbols = (DecimalFormatSymbols) decimalFormatSymbols.clone();
        refreshFormatter();
    }

    public synchronized String getNegativePrefix() {
        String negativePrefix;
        negativePrefix = this.exportedProperties.getNegativePrefix();
        return negativePrefix == null ? "" : negativePrefix;
    }

    public synchronized void setNegativePrefix(String str) {
        this.properties.setNegativePrefix(str);
        refreshFormatter();
    }

    public synchronized void setMultiplier(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Multiplier must be nonzero.");
        }
        int i2 = 0;
        int i3 = i;
        while (true) {
            if (i == 1) {
                break;
            }
            i2++;
            int i4 = i3 / 10;
            if (i4 * 10 != i3) {
                i2 = -1;
                break;
            }
            i3 = i4;
        }
        if (i2 != -1) {
            this.properties.setMagnitudeMultiplier(i2);
        } else {
            this.properties.setMultiplier(BigDecimal.valueOf((long) i));
        }
        refreshFormatter();
    }

    public synchronized void setRoundingIncrement(BigDecimal bigDecimal) {
        if (bigDecimal != null) {
            if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
                this.properties.setMaximumFractionDigits(Integer.MAX_VALUE);
                return;
            }
        }
        this.properties.setRoundingIncrement(bigDecimal);
        refreshFormatter();
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized int getRoundingMode() {
        RoundingMode roundingMode;
        roundingMode = this.exportedProperties.getRoundingMode();
        return roundingMode == null ? 0 : roundingMode.ordinal();
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized void setRoundingMode(int i) {
        this.properties.setRoundingMode(RoundingMode.valueOf(i));
        refreshFormatter();
    }

    public synchronized void setMathContext(java.math.MathContext mathContext) {
        this.properties.setMathContext(mathContext);
        refreshFormatter();
    }

    public synchronized void setMathContextICU(MathContext mathContext) {
        java.math.MathContext mathContext2;
        this.icuMathContextForm = mathContext.getForm();
        if (mathContext.getLostDigits()) {
            mathContext2 = new java.math.MathContext(mathContext.getDigits(), RoundingMode.UNNECESSARY);
        } else {
            mathContext2 = new java.math.MathContext(mathContext.getDigits(), RoundingMode.valueOf(mathContext.getRoundingMode()));
        }
        setMathContext(mathContext2);
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized void setMinimumIntegerDigits(int i) {
        this.properties.setMinimumIntegerDigits(i);
        refreshFormatter();
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized void setMaximumIntegerDigits(int i) {
        this.properties.setMaximumIntegerDigits(i);
        refreshFormatter();
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized void setMinimumFractionDigits(int i) {
        this.properties.setMinimumFractionDigits(i);
        refreshFormatter();
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized int getMaximumFractionDigits() {
        return this.exportedProperties.getMaximumFractionDigits();
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized void setMaximumFractionDigits(int i) {
        this.properties.setMaximumFractionDigits(i);
        refreshFormatter();
    }

    public synchronized void setSignificantDigitsUsed(boolean z) {
        if (z) {
            this.properties.setMinimumSignificantDigits(1);
            this.properties.setMaximumSignificantDigits(6);
        } else {
            this.properties.setMinimumSignificantDigits(-1);
            this.properties.setMaximumSignificantDigits(-1);
            this.properties.setSignificantDigitsMode(null);
        }
        refreshFormatter();
    }

    public synchronized void setMinimumSignificantDigits(int i) {
        this.properties.setMinimumSignificantDigits(i);
        refreshFormatter();
    }

    public synchronized void setMaximumSignificantDigits(int i) {
        this.properties.setMaximumSignificantDigits(i);
        refreshFormatter();
    }

    public synchronized void setFormatWidth(int i) {
        this.properties.setFormatWidth(i);
        refreshFormatter();
    }

    public synchronized void setPadCharacter(char c) {
        this.properties.setPadString(Character.toString(c));
        refreshFormatter();
    }

    public synchronized void setPadPosition(int i) {
        this.properties.setPadPosition(PaddingFormat.PadPosition.fromOld(i));
        refreshFormatter();
    }

    public synchronized void setScientificNotation(boolean z) {
        if (z) {
            this.properties.setMinimumExponentDigits(1);
        } else {
            this.properties.setMinimumExponentDigits(-1);
        }
        refreshFormatter();
    }

    public synchronized void setMinimumExponentDigits(byte b) {
        this.properties.setMinimumExponentDigits(b);
        refreshFormatter();
    }

    public synchronized void setExponentSignAlwaysShown(boolean z) {
        this.properties.setExponentSignAlwaysShown(z);
        refreshFormatter();
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized void setGroupingUsed(boolean z) {
        if (z) {
            this.properties.setGroupingSize(3);
        } else {
            this.properties.setGroupingSize(-1);
            this.properties.setSecondaryGroupingSize(-1);
        }
        refreshFormatter();
    }

    public synchronized void setGroupingSize(int i) {
        this.properties.setGroupingSize(i);
        refreshFormatter();
    }

    public synchronized void setSecondaryGroupingSize(int i) {
        this.properties.setSecondaryGroupingSize(i);
        refreshFormatter();
    }

    public synchronized void setDecimalSeparatorAlwaysShown(boolean z) {
        this.properties.setDecimalSeparatorAlwaysShown(z);
        refreshFormatter();
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized Currency getCurrency() {
        return this.properties.getCurrency();
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized void setCurrency(Currency currency) {
        this.properties.setCurrency(currency);
        if (currency != null) {
            this.symbols.setCurrency(currency);
            this.symbols.setCurrencySymbol(currency.getName(this.symbols.getULocale(), 0, null));
        }
        refreshFormatter();
    }

    public synchronized void setCurrencyUsage(Currency.CurrencyUsage currencyUsage) {
        this.properties.setCurrencyUsage(currencyUsage);
        refreshFormatter();
    }

    public synchronized void setCurrencyPluralInfo(CurrencyPluralInfo currencyPluralInfo) {
        this.properties.setCurrencyPluralInfo(currencyPluralInfo);
        refreshFormatter();
    }

    public synchronized void setParseBigDecimal(boolean z) {
        this.properties.setParseToBigDecimal(z);
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized void setParseStrict(boolean z) {
        this.properties.setParseMode(z ? Parse.ParseMode.STRICT : Parse.ParseMode.LENIENT);
    }

    @Override // com.ibm.icu.text.NumberFormat
    public synchronized void setParseIntegerOnly(boolean z) {
        this.properties.setParseIntegerOnly(z);
    }

    public synchronized void setDecimalPatternMatchRequired(boolean z) {
        this.properties.setDecimalPatternMatchRequired(z);
        refreshFormatter();
    }

    @Override // com.ibm.icu.text.NumberFormat, java.lang.Object
    public synchronized boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DecimalFormat)) {
            return false;
        }
        DecimalFormat decimalFormat = (DecimalFormat) obj;
        return this.properties.equals(decimalFormat.properties) && this.symbols.equals(decimalFormat.symbols);
    }

    @Override // com.ibm.icu.text.NumberFormat, java.lang.Object
    public synchronized int hashCode() {
        return this.properties.hashCode() ^ this.symbols.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(" { symbols@");
        sb.append(Integer.toHexString(this.symbols.hashCode()));
        synchronized (this) {
            this.properties.toStringBare(sb);
        }
        sb.append(" }");
        return sb.toString();
    }

    public synchronized String toPattern() {
        Properties copyFrom;
        copyFrom = threadLocalProperties.get().copyFrom(this.properties);
        if (CurrencyFormat.useCurrency(this.properties)) {
            copyFrom.setMinimumFractionDigits(this.exportedProperties.getMinimumFractionDigits());
            copyFrom.setMaximumFractionDigits(this.exportedProperties.getMaximumFractionDigits());
            copyFrom.setRoundingIncrement(this.exportedProperties.getRoundingIncrement());
        }
        return PatternString.propertiesToString(copyFrom);
    }

    @Deprecated
    public PluralRules.IFixedDecimal getFixedDecimal(double d) {
        FormatQuantity4 formatQuantity4 = new FormatQuantity4(d);
        this.formatter.format(formatQuantity4);
        return formatQuantity4;
    }

    /* access modifiers changed from: package-private */
    public void refreshFormatter() {
        if (this.exportedProperties != null) {
            this.formatter = Endpoint.fromBTA(this.properties, this.symbols);
            this.exportedProperties.clear();
            this.formatter.export(this.exportedProperties);
        }
    }

    /* access modifiers changed from: package-private */
    public void setPropertiesFromPattern(String str, boolean z) {
        PatternString.parseToExistingProperties(str, this.properties, z);
    }
}

package com.ibm.icu.text;

import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.math.BigDecimal;
import com.ibm.icu.text.DisplayContext;
import com.ibm.icu.util.Currency;
import com.ibm.icu.util.CurrencyAmount;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Locale;
import java.util.MissingResourceException;
public abstract class NumberFormat extends UFormat {
    static final /* synthetic */ boolean $assertionsDisabled = (!NumberFormat.class.desiredAssertionStatus());
    private static final char[] doubleCurrencySign = {164, 164};
    private static final String doubleCurrencyStr = new String(doubleCurrencySign);
    private static final long serialVersionUID = -2308460125733713944L;
    private static NumberFormatShim shim = null;
    private DisplayContext capitalizationSetting = DisplayContext.CAPITALIZATION_NONE;
    private Currency currency;
    private boolean groupingUsed = true;
    private byte maxFractionDigits = 3;
    private byte maxIntegerDigits = 40;
    private int maximumFractionDigits = 3;
    private int maximumIntegerDigits = 40;
    private byte minFractionDigits = 0;
    private byte minIntegerDigits = 1;
    private int minimumFractionDigits = 0;
    private int minimumIntegerDigits = 1;
    private boolean parseIntegerOnly = false;
    private boolean parseStrict;
    private int serialVersionOnStream = 2;

    public abstract StringBuffer format(double d, StringBuffer stringBuffer, FieldPosition fieldPosition);

    public abstract StringBuffer format(long j, StringBuffer stringBuffer, FieldPosition fieldPosition);

    public abstract StringBuffer format(BigDecimal bigDecimal, StringBuffer stringBuffer, FieldPosition fieldPosition);

    public abstract StringBuffer format(java.math.BigDecimal bigDecimal, StringBuffer stringBuffer, FieldPosition fieldPosition);

    public abstract StringBuffer format(BigInteger bigInteger, StringBuffer stringBuffer, FieldPosition fieldPosition);

    public abstract Number parse(String str, ParsePosition parsePosition);

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Long) {
            return format(((Long) obj).longValue(), stringBuffer, fieldPosition);
        }
        if (obj instanceof BigInteger) {
            return format((BigInteger) obj, stringBuffer, fieldPosition);
        }
        if (obj instanceof java.math.BigDecimal) {
            return format((java.math.BigDecimal) obj, stringBuffer, fieldPosition);
        }
        if (obj instanceof BigDecimal) {
            return format((BigDecimal) obj, stringBuffer, fieldPosition);
        }
        if (obj instanceof CurrencyAmount) {
            return format((CurrencyAmount) obj, stringBuffer, fieldPosition);
        }
        if (obj instanceof Number) {
            return format(((Number) obj).doubleValue(), stringBuffer, fieldPosition);
        }
        throw new IllegalArgumentException("Cannot format given Object as a Number");
    }

    @Override // java.text.Format
    public final Object parseObject(String str, ParsePosition parsePosition) {
        return parse(str, parsePosition);
    }

    public final String format(double d) {
        return format(d, new StringBuffer(), new FieldPosition(0)).toString();
    }

    public final String format(long j) {
        StringBuffer stringBuffer = new StringBuffer(19);
        format(j, stringBuffer, new FieldPosition(0));
        return stringBuffer.toString();
    }

    public StringBuffer format(CurrencyAmount currencyAmount, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        synchronized (this) {
            Currency currency2 = getCurrency();
            Currency currency3 = currencyAmount.getCurrency();
            boolean equals = currency3.equals(currency2);
            if (!equals) {
                setCurrency(currency3);
            }
            format(currencyAmount.getNumber(), stringBuffer, fieldPosition);
            if (!equals) {
                setCurrency(currency2);
            }
        }
        return stringBuffer;
    }

    public Number parse(String str) {
        ParsePosition parsePosition = new ParsePosition(0);
        Number parse = parse(str, parsePosition);
        if (parsePosition.getIndex() != 0) {
            return parse;
        }
        throw new ParseException("Unparseable number: \"" + str + '\"', parsePosition.getErrorIndex());
    }

    public CurrencyAmount parseCurrency(CharSequence charSequence, ParsePosition parsePosition) {
        Number parse = parse(charSequence.toString(), parsePosition);
        if (parse == null) {
            return null;
        }
        return new CurrencyAmount(parse, getEffectiveCurrency());
    }

    public void setParseIntegerOnly(boolean z) {
        this.parseIntegerOnly = z;
    }

    public void setParseStrict(boolean z) {
        this.parseStrict = z;
    }

    public DisplayContext getContext(DisplayContext.Type type) {
        return (type != DisplayContext.Type.CAPITALIZATION || this.capitalizationSetting == null) ? DisplayContext.CAPITALIZATION_NONE : this.capitalizationSetting;
    }

    public static final NumberFormat getInstance() {
        return getInstance(ULocale.getDefault(ULocale.Category.FORMAT), 0);
    }

    public static NumberFormat getInstance(ULocale uLocale) {
        return getInstance(uLocale, 0);
    }

    public static NumberFormat getNumberInstance(ULocale uLocale) {
        return getInstance(uLocale, 0);
    }

    public static NumberFormat getIntegerInstance(ULocale uLocale) {
        return getInstance(uLocale, 4);
    }

    public static NumberFormat getCurrencyInstance(Locale locale) {
        return getInstance(ULocale.forLocale(locale), 1);
    }

    public static NumberFormat getCurrencyInstance(ULocale uLocale) {
        return getInstance(uLocale, 1);
    }

    public static NumberFormat getPercentInstance(ULocale uLocale) {
        return getInstance(uLocale, 2);
    }

    /* access modifiers changed from: package-private */
    public static abstract class NumberFormatShim {
        /* access modifiers changed from: package-private */
        public abstract NumberFormat createInstance(ULocale uLocale, int i);

        NumberFormatShim() {
        }
    }

    private static NumberFormatShim getShim() {
        if (shim == null) {
            try {
                shim = (NumberFormatShim) Class.forName("com.ibm.icu.text.NumberFormatServiceShim").newInstance();
            } catch (MissingResourceException e) {
                throw e;
            } catch (Exception e2) {
                throw new RuntimeException(e2.getMessage());
            }
        }
        return shim;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.maximumIntegerDigits * 37) + this.maxFractionDigits;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        NumberFormat numberFormat = (NumberFormat) obj;
        return this.maximumIntegerDigits == numberFormat.maximumIntegerDigits && this.minimumIntegerDigits == numberFormat.minimumIntegerDigits && this.maximumFractionDigits == numberFormat.maximumFractionDigits && this.minimumFractionDigits == numberFormat.minimumFractionDigits && this.groupingUsed == numberFormat.groupingUsed && this.parseIntegerOnly == numberFormat.parseIntegerOnly && this.parseStrict == numberFormat.parseStrict && this.capitalizationSetting == numberFormat.capitalizationSetting;
    }

    @Override // java.text.Format, java.lang.Object
    public Object clone() {
        return (NumberFormat) super.clone();
    }

    public void setGroupingUsed(boolean z) {
        this.groupingUsed = z;
    }

    public void setMaximumIntegerDigits(int i) {
        this.maximumIntegerDigits = Math.max(0, i);
        if (this.minimumIntegerDigits > this.maximumIntegerDigits) {
            this.minimumIntegerDigits = this.maximumIntegerDigits;
        }
    }

    public void setMinimumIntegerDigits(int i) {
        this.minimumIntegerDigits = Math.max(0, i);
        if (this.minimumIntegerDigits > this.maximumIntegerDigits) {
            this.maximumIntegerDigits = this.minimumIntegerDigits;
        }
    }

    public int getMaximumFractionDigits() {
        return this.maximumFractionDigits;
    }

    public void setMaximumFractionDigits(int i) {
        this.maximumFractionDigits = Math.max(0, i);
        if (this.maximumFractionDigits < this.minimumFractionDigits) {
            this.minimumFractionDigits = this.maximumFractionDigits;
        }
    }

    public void setMinimumFractionDigits(int i) {
        this.minimumFractionDigits = Math.max(0, i);
        if (this.maximumFractionDigits < this.minimumFractionDigits) {
            this.maximumFractionDigits = this.minimumFractionDigits;
        }
    }

    public void setCurrency(Currency currency2) {
        this.currency = currency2;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public Currency getEffectiveCurrency() {
        Currency currency2 = getCurrency();
        if (currency2 != null) {
            return currency2;
        }
        ULocale locale = getLocale(ULocale.VALID_LOCALE);
        if (locale == null) {
            locale = ULocale.getDefault(ULocale.Category.FORMAT);
        }
        return Currency.getInstance(locale);
    }

    public int getRoundingMode() {
        throw new UnsupportedOperationException("getRoundingMode must be implemented by the subclass implementation.");
    }

    public void setRoundingMode(int i) {
        throw new UnsupportedOperationException("setRoundingMode must be implemented by the subclass implementation.");
    }

    public static NumberFormat getInstance(ULocale uLocale, int i) {
        if (i >= 0 && i <= 9) {
            return getShim().createInstance(uLocale, i);
        }
        throw new IllegalArgumentException("choice should be from NUMBERSTYLE to STANDARDCURRENCYSTYLE");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v17, resolved type: com.ibm.icu.text.RuleBasedNumberFormat */
    /* JADX WARN: Multi-variable type inference failed */
    static NumberFormat createInstance(ULocale uLocale, int i) {
        DecimalFormat decimalFormat;
        ULocale uLocale2;
        String str;
        String currencyPattern;
        String pattern = getPattern(uLocale, i);
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(uLocale);
        if ((i == 1 || i == 5 || i == 7 || i == 8 || i == 9) && (currencyPattern = decimalFormatSymbols.getCurrencyPattern()) != null) {
            pattern = currencyPattern;
        }
        if (i == 5) {
            pattern = pattern.replace("¤", doubleCurrencyStr);
        }
        NumberingSystem instance = NumberingSystem.getInstance(uLocale);
        if (instance == null) {
            return null;
        }
        if (instance == null || !instance.isAlgorithmic()) {
            DecimalFormat decimalFormat2 = new DecimalFormat(pattern, decimalFormatSymbols, i);
            if (i == 4) {
                decimalFormat2.setMaximumFractionDigits(0);
                decimalFormat2.setDecimalSeparatorAlwaysShown(false);
                decimalFormat2.setParseIntegerOnly(true);
            }
            if (i == 8) {
                decimalFormat2.setCurrencyUsage(Currency.CurrencyUsage.CASH);
            }
            if (i == 6) {
                decimalFormat2.setCurrencyPluralInfo(CurrencyPluralInfo.getInstance(uLocale));
            }
            decimalFormat = decimalFormat2;
        } else {
            int i2 = 4;
            String description = instance.getDescription();
            int indexOf = description.indexOf("/");
            int lastIndexOf = description.lastIndexOf("/");
            if (lastIndexOf > indexOf) {
                String substring = description.substring(0, indexOf);
                String substring2 = description.substring(indexOf + 1, lastIndexOf);
                str = description.substring(lastIndexOf + 1);
                uLocale2 = new ULocale(substring);
                if (substring2.equals("SpelloutRules")) {
                    i2 = 1;
                }
            } else {
                uLocale2 = uLocale;
                str = description;
            }
            RuleBasedNumberFormat ruleBasedNumberFormat = new RuleBasedNumberFormat(uLocale2, i2);
            ruleBasedNumberFormat.setDefaultRuleSet(str);
            decimalFormat = ruleBasedNumberFormat;
        }
        decimalFormat.setLocale(decimalFormatSymbols.getLocale(ULocale.VALID_LOCALE), decimalFormatSymbols.getLocale(ULocale.ACTUAL_LOCALE));
        return decimalFormat;
    }

    protected static String getPattern(ULocale uLocale, int i) {
        return getPatternForStyle(uLocale, i);
    }

    @Deprecated
    public static String getPatternForStyle(ULocale uLocale, int i) {
        String str;
        switch (i) {
            case 0:
            case 4:
            case 6:
                str = "decimalFormat";
                break;
            case 1:
                String keywordValue = uLocale.getKeywordValue("cf");
                if (keywordValue != null && keywordValue.equals("account")) {
                    str = "accountingFormat";
                    break;
                } else {
                    str = "currencyFormat";
                    break;
                }
            case 2:
                str = "percentFormat";
                break;
            case 3:
                str = "scientificFormat";
                break;
            case 5:
            case 8:
            case 9:
                str = "currencyFormat";
                break;
            case 7:
                str = "accountingFormat";
                break;
            default:
                if ($assertionsDisabled) {
                    str = "decimalFormat";
                    break;
                } else {
                    throw new AssertionError();
                }
        }
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b", uLocale);
        String findStringWithFallback = iCUResourceBundle.findStringWithFallback("NumberElements/" + NumberingSystem.getInstance(uLocale).getName() + "/patterns/" + str);
        if (findStringWithFallback == null) {
            return iCUResourceBundle.getStringWithFallback("NumberElements/latn/patterns/" + str);
        }
        return findStringWithFallback;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        if (this.serialVersionOnStream < 1) {
            this.maximumIntegerDigits = this.maxIntegerDigits;
            this.minimumIntegerDigits = this.minIntegerDigits;
            this.maximumFractionDigits = this.maxFractionDigits;
            this.minimumFractionDigits = this.minFractionDigits;
        }
        if (this.serialVersionOnStream < 2) {
            this.capitalizationSetting = DisplayContext.CAPITALIZATION_NONE;
        }
        if (this.minimumIntegerDigits > this.maximumIntegerDigits || this.minimumFractionDigits > this.maximumFractionDigits || this.minimumIntegerDigits < 0 || this.minimumFractionDigits < 0) {
            throw new InvalidObjectException("Digit count range invalid");
        }
        this.serialVersionOnStream = 2;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        this.maxIntegerDigits = this.maximumIntegerDigits > 127 ? Byte.MAX_VALUE : (byte) this.maximumIntegerDigits;
        this.minIntegerDigits = this.minimumIntegerDigits > 127 ? Byte.MAX_VALUE : (byte) this.minimumIntegerDigits;
        this.maxFractionDigits = this.maximumFractionDigits > 127 ? Byte.MAX_VALUE : (byte) this.maximumFractionDigits;
        this.minFractionDigits = this.minimumFractionDigits > 127 ? Byte.MAX_VALUE : (byte) this.minimumFractionDigits;
        objectOutputStream.defaultWriteObject();
    }

    public static class Field extends Format.Field {
        public static final Field CURRENCY = new Field("currency");
        public static final Field DECIMAL_SEPARATOR = new Field("decimal separator");
        public static final Field EXPONENT = new Field("exponent");
        public static final Field EXPONENT_SIGN = new Field("exponent sign");
        public static final Field EXPONENT_SYMBOL = new Field("exponent symbol");
        public static final Field FRACTION = new Field("fraction");
        public static final Field GROUPING_SEPARATOR = new Field("grouping separator");
        public static final Field INTEGER = new Field("integer");
        public static final Field PERCENT = new Field("percent");
        public static final Field PERMILLE = new Field("per mille");
        public static final Field SIGN = new Field("sign");
        static final long serialVersionUID = -4516273749929385842L;

        protected Field(String str) {
            super(str);
        }

        /* access modifiers changed from: protected */
        @Override // java.text.AttributedCharacterIterator.Attribute
        public Object readResolve() {
            if (getName().equals(INTEGER.getName())) {
                return INTEGER;
            }
            if (getName().equals(FRACTION.getName())) {
                return FRACTION;
            }
            if (getName().equals(EXPONENT.getName())) {
                return EXPONENT;
            }
            if (getName().equals(EXPONENT_SIGN.getName())) {
                return EXPONENT_SIGN;
            }
            if (getName().equals(EXPONENT_SYMBOL.getName())) {
                return EXPONENT_SYMBOL;
            }
            if (getName().equals(CURRENCY.getName())) {
                return CURRENCY;
            }
            if (getName().equals(DECIMAL_SEPARATOR.getName())) {
                return DECIMAL_SEPARATOR;
            }
            if (getName().equals(GROUPING_SEPARATOR.getName())) {
                return GROUPING_SEPARATOR;
            }
            if (getName().equals(PERCENT.getName())) {
                return PERCENT;
            }
            if (getName().equals(PERMILLE.getName())) {
                return PERMILLE;
            }
            if (getName().equals(SIGN.getName())) {
                return SIGN;
            }
            throw new InvalidObjectException("An invalid object.");
        }
    }
}

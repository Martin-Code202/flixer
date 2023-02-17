package com.ibm.icu.text;

import com.ibm.icu.impl.DontCareFieldPosition;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.SimpleCache;
import com.ibm.icu.impl.SimpleFormatterImpl;
import com.ibm.icu.impl.StandardPlural;
import com.ibm.icu.impl.UResource;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.ListFormatter;
import com.ibm.icu.util.Currency;
import com.ibm.icu.util.CurrencyAmount;
import com.ibm.icu.util.ICUException;
import com.ibm.icu.util.Measure;
import com.ibm.icu.util.MeasureUnit;
import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.concurrent.ConcurrentHashMap;
public class MeasureFormat extends UFormat {
    private static final Map<MeasureUnit, Integer> hmsTo012 = new HashMap();
    private static final Map<ULocale, String> localeIdToRangeFormat = new ConcurrentHashMap();
    private static final SimpleCache<ULocale, MeasureFormatData> localeMeasureFormatData = new SimpleCache<>();
    private static final SimpleCache<ULocale, NumericFormatters> localeToNumericDurationFormatters = new SimpleCache<>();
    static final long serialVersionUID = -7182021401701778240L;
    private final transient MeasureFormatData cache;
    private final transient ImmutableNumberFormat currencyFormat;
    private final transient FormatWidth formatWidth;
    private final transient ImmutableNumberFormat integerFormat;
    private final transient ImmutableNumberFormat numberFormat;
    private final transient NumericFormatters numericFormatters;
    private final transient PluralRules rules;

    static {
        hmsTo012.put(MeasureUnit.HOUR, 0);
        hmsTo012.put(MeasureUnit.MINUTE, 1);
        hmsTo012.put(MeasureUnit.SECOND, 2);
    }

    public enum FormatWidth {
        WIDE(ListFormatter.Style.DURATION, 6),
        SHORT(ListFormatter.Style.DURATION_SHORT, 5),
        NARROW(ListFormatter.Style.DURATION_NARROW, 1),
        NUMERIC(ListFormatter.Style.DURATION_NARROW, 1);
        
        private final int currencyStyle;
        private final ListFormatter.Style listFormatterStyle;

        private FormatWidth(ListFormatter.Style style, int i) {
            this.listFormatterStyle = style;
            this.currencyStyle = i;
        }

        /* access modifiers changed from: package-private */
        public ListFormatter.Style getListFormatterStyle() {
            return this.listFormatterStyle;
        }

        /* access modifiers changed from: package-private */
        public int getCurrencyStyle() {
            return this.currencyStyle;
        }
    }

    public static MeasureFormat getInstance(ULocale uLocale, FormatWidth formatWidth2) {
        return getInstance(uLocale, formatWidth2, NumberFormat.getInstance(uLocale));
    }

    public static MeasureFormat getInstance(ULocale uLocale, FormatWidth formatWidth2, NumberFormat numberFormat2) {
        PluralRules forLocale = PluralRules.forLocale(uLocale);
        NumericFormatters numericFormatters2 = null;
        MeasureFormatData measureFormatData = localeMeasureFormatData.get(uLocale);
        if (measureFormatData == null) {
            measureFormatData = loadLocaleData(uLocale);
            localeMeasureFormatData.put(uLocale, measureFormatData);
        }
        if (formatWidth2 == FormatWidth.NUMERIC && (numericFormatters2 = localeToNumericDurationFormatters.get(uLocale)) == null) {
            numericFormatters2 = loadNumericFormatters(uLocale);
            localeToNumericDurationFormatters.put(uLocale, numericFormatters2);
        }
        NumberFormat instance = NumberFormat.getInstance(uLocale);
        instance.setMaximumFractionDigits(0);
        instance.setMinimumFractionDigits(0);
        instance.setRoundingMode(1);
        return new MeasureFormat(uLocale, measureFormatData, formatWidth2, new ImmutableNumberFormat(numberFormat2), forLocale, numericFormatters2, new ImmutableNumberFormat(NumberFormat.getInstance(uLocale, formatWidth2.getCurrencyStyle())), new ImmutableNumberFormat(instance));
    }

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        int length = stringBuffer.length();
        FieldPosition fieldPosition2 = new FieldPosition(fieldPosition.getFieldAttribute(), fieldPosition.getField());
        if (obj instanceof Collection) {
            Collection collection = (Collection) obj;
            Measure[] measureArr = new Measure[collection.size()];
            int i = 0;
            for (Object obj2 : collection) {
                if (!(obj2 instanceof Measure)) {
                    throw new IllegalArgumentException(obj.toString());
                }
                i++;
                measureArr[i] = (Measure) obj2;
            }
            stringBuffer.append((CharSequence) formatMeasures(new StringBuilder(), fieldPosition2, measureArr));
        } else if (obj instanceof Measure[]) {
            stringBuffer.append((CharSequence) formatMeasures(new StringBuilder(), fieldPosition2, (Measure[]) obj));
        } else if (obj instanceof Measure) {
            stringBuffer.append((CharSequence) formatMeasure((Measure) obj, this.numberFormat, new StringBuilder(), fieldPosition2));
        } else {
            throw new IllegalArgumentException(obj.toString());
        }
        if (!(fieldPosition2.getBeginIndex() == 0 && fieldPosition2.getEndIndex() == 0)) {
            fieldPosition.setBeginIndex(fieldPosition2.getBeginIndex() + length);
            fieldPosition.setEndIndex(fieldPosition2.getEndIndex() + length);
        }
        return stringBuffer;
    }

    @Override // java.text.Format
    public Measure parseObject(String str, ParsePosition parsePosition) {
        throw new UnsupportedOperationException();
    }

    public StringBuilder formatMeasures(StringBuilder sb, FieldPosition fieldPosition, Measure... measureArr) {
        Number[] hms;
        if (measureArr.length == 0) {
            return sb;
        }
        if (measureArr.length == 1) {
            return formatMeasure(measureArr[0], this.numberFormat, sb, fieldPosition);
        }
        if (this.formatWidth == FormatWidth.NUMERIC && (hms = toHMS(measureArr)) != null) {
            return formatNumeric(hms, sb);
        }
        ListFormatter instance = ListFormatter.getInstance(getLocale(), this.formatWidth.getListFormatterStyle());
        if (fieldPosition != DontCareFieldPosition.INSTANCE) {
            return formatMeasuresSlowTrack(instance, sb, fieldPosition, measureArr);
        }
        String[] strArr = new String[measureArr.length];
        int i = 0;
        while (i < measureArr.length) {
            strArr[i] = formatMeasure(measureArr[i], i == measureArr.length + -1 ? this.numberFormat : this.integerFormat);
            i++;
        }
        return sb.append(instance.format(strArr));
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MeasureFormat)) {
            return false;
        }
        MeasureFormat measureFormat = (MeasureFormat) obj;
        return getWidth() == measureFormat.getWidth() && getLocale().equals(measureFormat.getLocale()) && getNumberFormat().equals(measureFormat.getNumberFormat());
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return (((getLocale().hashCode() * 31) + getNumberFormat().hashCode()) * 31) + getWidth().hashCode();
    }

    public FormatWidth getWidth() {
        return this.formatWidth;
    }

    public final ULocale getLocale() {
        return getLocale(ULocale.VALID_LOCALE);
    }

    public NumberFormat getNumberFormat() {
        return this.numberFormat.get();
    }

    /* access modifiers changed from: package-private */
    public MeasureFormat withLocale(ULocale uLocale) {
        return getInstance(uLocale, getWidth());
    }

    /* access modifiers changed from: package-private */
    public MeasureFormat withNumberFormat(NumberFormat numberFormat2) {
        return new MeasureFormat(getLocale(), this.cache, this.formatWidth, new ImmutableNumberFormat(numberFormat2), this.rules, this.numericFormatters, this.currencyFormat, this.integerFormat);
    }

    private MeasureFormat(ULocale uLocale, MeasureFormatData measureFormatData, FormatWidth formatWidth2, ImmutableNumberFormat immutableNumberFormat, PluralRules pluralRules, NumericFormatters numericFormatters2, ImmutableNumberFormat immutableNumberFormat2, ImmutableNumberFormat immutableNumberFormat3) {
        setLocale(uLocale, uLocale);
        this.cache = measureFormatData;
        this.formatWidth = formatWidth2;
        this.numberFormat = immutableNumberFormat;
        this.rules = pluralRules;
        this.numericFormatters = numericFormatters2;
        this.currencyFormat = immutableNumberFormat2;
        this.integerFormat = immutableNumberFormat3;
    }

    MeasureFormat() {
        this.cache = null;
        this.formatWidth = null;
        this.numberFormat = null;
        this.rules = null;
        this.numericFormatters = null;
        this.currencyFormat = null;
        this.integerFormat = null;
    }

    /* access modifiers changed from: package-private */
    public static class NumericFormatters {
        private DateFormat hourMinute;
        private DateFormat hourMinuteSecond;
        private DateFormat minuteSecond;

        public NumericFormatters(DateFormat dateFormat, DateFormat dateFormat2, DateFormat dateFormat3) {
            this.hourMinute = dateFormat;
            this.minuteSecond = dateFormat2;
            this.hourMinuteSecond = dateFormat3;
        }

        public DateFormat getHourMinute() {
            return this.hourMinute;
        }

        public DateFormat getMinuteSecond() {
            return this.minuteSecond;
        }

        public DateFormat getHourMinuteSecond() {
            return this.hourMinuteSecond;
        }
    }

    private static NumericFormatters loadNumericFormatters(ULocale uLocale) {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b/unit", uLocale);
        return new NumericFormatters(loadNumericDurationFormat(iCUResourceBundle, "hm"), loadNumericDurationFormat(iCUResourceBundle, "ms"), loadNumericDurationFormat(iCUResourceBundle, "hms"));
    }

    /* access modifiers changed from: package-private */
    public static final class UnitDataSink extends UResource.Sink {
        MeasureFormatData cacheData;
        String[] patterns;
        StringBuilder sb = new StringBuilder();
        String type;
        MeasureUnit unit;
        FormatWidth width;

        /* access modifiers changed from: package-private */
        public void setFormatterIfAbsent(int i, UResource.Value value, int i2) {
            if (this.patterns == null) {
                EnumMap<FormatWidth, String[]> enumMap = this.cacheData.unitToStyleToPatterns.get(this.unit);
                if (enumMap == null) {
                    enumMap = new EnumMap<>(FormatWidth.class);
                    this.cacheData.unitToStyleToPatterns.put(this.unit, enumMap);
                } else {
                    this.patterns = enumMap.get(this.width);
                }
                if (this.patterns == null) {
                    this.patterns = new String[MeasureFormatData.PATTERN_COUNT];
                    enumMap.put((EnumMap<FormatWidth, String[]>) this.width, (FormatWidth) this.patterns);
                }
            }
            if (this.patterns[i] == null) {
                this.patterns[i] = SimpleFormatterImpl.compileToStringMinMaxArguments(value.getString(), this.sb, i2, 1);
            }
        }

        /* access modifiers changed from: package-private */
        public void setDnamIfAbsent(UResource.Value value) {
            EnumMap<FormatWidth, String> enumMap = this.cacheData.unitToStyleToDnam.get(this.unit);
            if (enumMap == null) {
                enumMap = new EnumMap<>(FormatWidth.class);
                this.cacheData.unitToStyleToDnam.put(this.unit, enumMap);
            }
            if (enumMap.get(this.width) == null) {
                enumMap.put((EnumMap<FormatWidth, String>) this.width, (FormatWidth) value.getString());
            }
        }

        /* access modifiers changed from: package-private */
        public void consumePattern(UResource.Key key, UResource.Value value) {
            if (key.contentEquals("dnam")) {
                setDnamIfAbsent(value);
            } else if (key.contentEquals("per")) {
                setFormatterIfAbsent(MeasureFormatData.PER_UNIT_INDEX, value, 1);
            } else {
                setFormatterIfAbsent(StandardPlural.indexFromString(key), value, 0);
            }
        }

        /* access modifiers changed from: package-private */
        public void consumeSubtypeTable(UResource.Key key, UResource.Value value) {
            this.unit = MeasureUnit.internalGetInstance(this.type, key.toString());
            this.patterns = null;
            if (value.getType() == 2) {
                UResource.Table table = value.getTable();
                for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                    consumePattern(key, value);
                }
                return;
            }
            throw new ICUException("Data for unit '" + this.unit + "' is in an unknown format");
        }

        /* access modifiers changed from: package-private */
        public void consumeCompoundPattern(UResource.Key key, UResource.Value value) {
            if (key.contentEquals("per")) {
                this.cacheData.styleToPerPattern.put((EnumMap<FormatWidth, String>) this.width, (FormatWidth) SimpleFormatterImpl.compileToStringMinMaxArguments(value.getString(), this.sb, 2, 2));
            }
        }

        /* access modifiers changed from: package-private */
        public void consumeUnitTypesTable(UResource.Key key, UResource.Value value) {
            if (!key.contentEquals("currency")) {
                if (key.contentEquals("compound")) {
                    if (!this.cacheData.hasPerFormatter(this.width)) {
                        UResource.Table table = value.getTable();
                        for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                            consumeCompoundPattern(key, value);
                        }
                    }
                } else if (!key.contentEquals("coordinate")) {
                    this.type = key.toString();
                    UResource.Table table2 = value.getTable();
                    for (int i2 = 0; table2.getKeyAndValue(i2, key, value); i2++) {
                        consumeSubtypeTable(key, value);
                    }
                }
            }
        }

        UnitDataSink(MeasureFormatData measureFormatData) {
            this.cacheData = measureFormatData;
        }

        /* access modifiers changed from: package-private */
        public void consumeAlias(UResource.Key key, UResource.Value value) {
            FormatWidth widthFromKey = widthFromKey(key);
            if (widthFromKey != null) {
                FormatWidth widthFromAlias = widthFromAlias(value);
                if (widthFromAlias == null) {
                    throw new ICUException("Units data fallback from " + ((Object) key) + " to unknown " + value.getAliasString());
                } else if (this.cacheData.widthFallback[widthFromAlias.ordinal()] != null) {
                    throw new ICUException("Units data fallback from " + ((Object) key) + " to " + value.getAliasString() + " which falls back to something else");
                } else {
                    this.cacheData.widthFallback[widthFromKey.ordinal()] = widthFromAlias;
                }
            }
        }

        public void consumeTable(UResource.Key key, UResource.Value value) {
            FormatWidth widthFromKey = widthFromKey(key);
            this.width = widthFromKey;
            if (widthFromKey != null) {
                UResource.Table table = value.getTable();
                for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                    consumeUnitTypesTable(key, value);
                }
            }
        }

        static FormatWidth widthFromKey(UResource.Key key) {
            if (!key.startsWith("units")) {
                return null;
            }
            if (key.length() == 5) {
                return FormatWidth.WIDE;
            }
            if (key.regionMatches(5, "Short")) {
                return FormatWidth.SHORT;
            }
            if (key.regionMatches(5, "Narrow")) {
                return FormatWidth.NARROW;
            }
            return null;
        }

        static FormatWidth widthFromAlias(UResource.Value value) {
            String aliasString = value.getAliasString();
            if (!aliasString.startsWith("/LOCALE/units")) {
                return null;
            }
            if (aliasString.length() == 13) {
                return FormatWidth.WIDE;
            }
            if (aliasString.length() == 18 && aliasString.endsWith("Short")) {
                return FormatWidth.SHORT;
            }
            if (aliasString.length() != 19 || !aliasString.endsWith("Narrow")) {
                return null;
            }
            return FormatWidth.NARROW;
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                if (value.getType() == 3) {
                    consumeAlias(key, value);
                } else {
                    consumeTable(key, value);
                }
            }
        }
    }

    private static MeasureFormatData loadLocaleData(ULocale uLocale) {
        MeasureFormatData measureFormatData = new MeasureFormatData();
        ((ICUResourceBundle) UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b/unit", uLocale)).getAllItemsWithFallback("", new UnitDataSink(measureFormatData));
        return measureFormatData;
    }

    private static final FormatWidth getRegularWidth(FormatWidth formatWidth2) {
        if (formatWidth2 == FormatWidth.NUMERIC) {
            return FormatWidth.NARROW;
        }
        return formatWidth2;
    }

    private String getFormatterOrNull(MeasureUnit measureUnit, FormatWidth formatWidth2, int i) {
        String[] strArr;
        FormatWidth regularWidth = getRegularWidth(formatWidth2);
        EnumMap<FormatWidth, String[]> enumMap = this.cache.unitToStyleToPatterns.get(measureUnit);
        String[] strArr2 = enumMap.get(regularWidth);
        if (strArr2 != null && strArr2[i] != null) {
            return strArr2[i];
        }
        FormatWidth formatWidth3 = this.cache.widthFallback[regularWidth.ordinal()];
        if (formatWidth3 == null || (strArr = enumMap.get(formatWidth3)) == null || strArr[i] == null) {
            return null;
        }
        return strArr[i];
    }

    private String getFormatter(MeasureUnit measureUnit, FormatWidth formatWidth2, int i) {
        String formatterOrNull = getFormatterOrNull(measureUnit, formatWidth2, i);
        if (formatterOrNull != null) {
            return formatterOrNull;
        }
        throw new MissingResourceException("no formatting pattern for " + measureUnit + ", width " + formatWidth2 + ", index " + i, null, null);
    }

    @Deprecated
    public String getPluralFormatter(MeasureUnit measureUnit, FormatWidth formatWidth2, int i) {
        String formatterOrNull;
        if (i == StandardPlural.OTHER_INDEX || (formatterOrNull = getFormatterOrNull(measureUnit, formatWidth2, i)) == null) {
            return getFormatter(measureUnit, formatWidth2, StandardPlural.OTHER_INDEX);
        }
        return formatterOrNull;
    }

    private String formatMeasure(Measure measure, ImmutableNumberFormat immutableNumberFormat) {
        return formatMeasure(measure, immutableNumberFormat, new StringBuilder(), DontCareFieldPosition.INSTANCE).toString();
    }

    private StringBuilder formatMeasure(Measure measure, ImmutableNumberFormat immutableNumberFormat, StringBuilder sb, FieldPosition fieldPosition) {
        Number number = measure.getNumber();
        MeasureUnit unit = measure.getUnit();
        if (unit instanceof Currency) {
            return sb.append(this.currencyFormat.format(new CurrencyAmount(number, (Currency) unit), new StringBuffer(), fieldPosition));
        }
        StringBuffer stringBuffer = new StringBuffer();
        return QuantityFormatter.format(getPluralFormatter(unit, this.formatWidth, QuantityFormatter.selectPlural(number, immutableNumberFormat.nf, this.rules, stringBuffer, fieldPosition).ordinal()), stringBuffer, sb, fieldPosition);
    }

    /* access modifiers changed from: package-private */
    public static final class MeasureFormatData {
        static final int PATTERN_COUNT = (PER_UNIT_INDEX + 1);
        static final int PER_UNIT_INDEX = StandardPlural.COUNT;
        final EnumMap<FormatWidth, String> styleToPerPattern;
        final Map<MeasureUnit, EnumMap<FormatWidth, String>> unitToStyleToDnam;
        final Map<MeasureUnit, EnumMap<FormatWidth, String[]>> unitToStyleToPatterns;
        final FormatWidth[] widthFallback;

        private MeasureFormatData() {
            this.widthFallback = new FormatWidth[3];
            this.unitToStyleToPatterns = new HashMap();
            this.unitToStyleToDnam = new HashMap();
            this.styleToPerPattern = new EnumMap<>(FormatWidth.class);
        }

        /* access modifiers changed from: package-private */
        public boolean hasPerFormatter(FormatWidth formatWidth) {
            return this.styleToPerPattern.containsKey(formatWidth);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ImmutableNumberFormat {
        private NumberFormat nf;

        public ImmutableNumberFormat(NumberFormat numberFormat) {
            this.nf = (NumberFormat) numberFormat.clone();
        }

        public synchronized NumberFormat get() {
            return (NumberFormat) this.nf.clone();
        }

        public synchronized StringBuffer format(Number number, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            return this.nf.format(number, stringBuffer, fieldPosition);
        }

        public synchronized StringBuffer format(CurrencyAmount currencyAmount, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            return this.nf.format(currencyAmount, stringBuffer, fieldPosition);
        }
    }

    /* access modifiers changed from: package-private */
    public Object toTimeUnitProxy() {
        return new MeasureProxy(getLocale(), this.formatWidth, this.numberFormat.get(), 1);
    }

    /* access modifiers changed from: package-private */
    public Object toCurrencyProxy() {
        return new MeasureProxy(getLocale(), this.formatWidth, this.numberFormat.get(), 2);
    }

    private StringBuilder formatMeasuresSlowTrack(ListFormatter listFormatter, StringBuilder sb, FieldPosition fieldPosition, Measure... measureArr) {
        String[] strArr = new String[measureArr.length];
        FieldPosition fieldPosition2 = new FieldPosition(fieldPosition.getFieldAttribute(), fieldPosition.getField());
        int i = -1;
        int i2 = 0;
        while (i2 < measureArr.length) {
            ImmutableNumberFormat immutableNumberFormat = i2 == measureArr.length + -1 ? this.numberFormat : this.integerFormat;
            if (i == -1) {
                strArr[i2] = formatMeasure(measureArr[i2], immutableNumberFormat, new StringBuilder(), fieldPosition2).toString();
                if (fieldPosition2.getBeginIndex() != 0 || fieldPosition2.getEndIndex() != 0) {
                    i = i2;
                }
            } else {
                strArr[i2] = formatMeasure(measureArr[i2], immutableNumberFormat);
            }
            i2++;
        }
        ListFormatter.FormattedListBuilder format = listFormatter.format(Arrays.asList(strArr), i);
        if (format.getOffset() != -1) {
            fieldPosition.setBeginIndex(fieldPosition2.getBeginIndex() + format.getOffset() + sb.length());
            fieldPosition.setEndIndex(fieldPosition2.getEndIndex() + format.getOffset() + sb.length());
        }
        return sb.append(format.toString());
    }

    private static DateFormat loadNumericDurationFormat(ICUResourceBundle iCUResourceBundle, String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(iCUResourceBundle.getWithFallback(String.format("durationUnits/%s", str)).getString().replace("h", "H"));
        simpleDateFormat.setTimeZone(TimeZone.GMT_ZONE);
        return simpleDateFormat;
    }

    private static Number[] toHMS(Measure[] measureArr) {
        Integer num;
        int intValue;
        Number[] numberArr = new Number[3];
        int i = -1;
        for (Measure measure : measureArr) {
            if (measure.getNumber().doubleValue() < 0.0d || (num = hmsTo012.get(measure.getUnit())) == null || (intValue = num.intValue()) <= i) {
                return null;
            }
            i = intValue;
            numberArr[intValue] = measure.getNumber();
        }
        return numberArr;
    }

    private StringBuilder formatNumeric(Number[] numberArr, StringBuilder sb) {
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < numberArr.length; i3++) {
            if (numberArr[i3] != null) {
                i2 = i3;
                if (i == -1) {
                    i = i2;
                }
            } else {
                numberArr[i3] = 0;
            }
        }
        Date date = new Date((long) (((((Math.floor(numberArr[0].doubleValue()) * 60.0d) + Math.floor(numberArr[1].doubleValue())) * 60.0d) + Math.floor(numberArr[2].doubleValue())) * 1000.0d));
        if (i == 0 && i2 == 2) {
            return formatNumeric(date, this.numericFormatters.getHourMinuteSecond(), DateFormat.Field.SECOND, numberArr[i2], sb);
        }
        if (i == 1 && i2 == 2) {
            return formatNumeric(date, this.numericFormatters.getMinuteSecond(), DateFormat.Field.SECOND, numberArr[i2], sb);
        }
        if (i == 0 && i2 == 1) {
            return formatNumeric(date, this.numericFormatters.getHourMinute(), DateFormat.Field.MINUTE, numberArr[i2], sb);
        }
        throw new IllegalStateException();
    }

    private StringBuilder formatNumeric(Date date, DateFormat dateFormat, DateFormat.Field field, Number number, StringBuilder sb) {
        FieldPosition fieldPosition = new FieldPosition(0);
        String stringBuffer = this.numberFormat.format(number, new StringBuffer(), fieldPosition).toString();
        if (fieldPosition.getBeginIndex() == 0 && fieldPosition.getEndIndex() == 0) {
            throw new IllegalStateException();
        }
        FieldPosition fieldPosition2 = new FieldPosition(field);
        String stringBuffer2 = dateFormat.format(date, new StringBuffer(), fieldPosition2).toString();
        if (fieldPosition2.getBeginIndex() == 0 && fieldPosition2.getEndIndex() == 0) {
            sb.append(stringBuffer2);
        } else {
            sb.append((CharSequence) stringBuffer2, 0, fieldPosition2.getBeginIndex());
            sb.append((CharSequence) stringBuffer, 0, fieldPosition.getBeginIndex());
            sb.append((CharSequence) stringBuffer2, fieldPosition2.getBeginIndex(), fieldPosition2.getEndIndex());
            sb.append((CharSequence) stringBuffer, fieldPosition.getEndIndex(), stringBuffer.length());
            sb.append((CharSequence) stringBuffer2, fieldPosition2.getEndIndex(), stringBuffer2.length());
        }
        return sb;
    }

    private Object writeReplace() {
        return new MeasureProxy(getLocale(), this.formatWidth, this.numberFormat.get(), 0);
    }

    static class MeasureProxy implements Externalizable {
        private static final long serialVersionUID = -6033308329886716770L;
        private FormatWidth formatWidth;
        private HashMap<Object, Object> keyValues;
        private ULocale locale;
        private NumberFormat numberFormat;
        private int subClass;

        public MeasureProxy(ULocale uLocale, FormatWidth formatWidth2, NumberFormat numberFormat2, int i) {
            this.locale = uLocale;
            this.formatWidth = formatWidth2;
            this.numberFormat = numberFormat2;
            this.subClass = i;
            this.keyValues = new HashMap<>();
        }

        public MeasureProxy() {
        }

        @Override // java.io.Externalizable
        public void writeExternal(ObjectOutput objectOutput) {
            objectOutput.writeByte(0);
            objectOutput.writeUTF(this.locale.toLanguageTag());
            objectOutput.writeByte(this.formatWidth.ordinal());
            objectOutput.writeObject(this.numberFormat);
            objectOutput.writeByte(this.subClass);
            objectOutput.writeObject(this.keyValues);
        }

        @Override // java.io.Externalizable
        public void readExternal(ObjectInput objectInput) {
            objectInput.readByte();
            this.locale = ULocale.forLanguageTag(objectInput.readUTF());
            this.formatWidth = MeasureFormat.fromFormatWidthOrdinal(objectInput.readByte() & 255);
            this.numberFormat = (NumberFormat) objectInput.readObject();
            if (this.numberFormat == null) {
                throw new InvalidObjectException("Missing number format.");
            }
            this.subClass = objectInput.readByte() & 255;
            this.keyValues = (HashMap) objectInput.readObject();
            if (this.keyValues == null) {
                throw new InvalidObjectException("Missing optional values map.");
            }
        }

        private TimeUnitFormat createTimeUnitFormat() {
            int i;
            if (this.formatWidth == FormatWidth.WIDE) {
                i = 0;
            } else if (this.formatWidth == FormatWidth.SHORT) {
                i = 1;
            } else {
                throw new InvalidObjectException("Bad width: " + this.formatWidth);
            }
            TimeUnitFormat timeUnitFormat = new TimeUnitFormat(this.locale, i);
            timeUnitFormat.setNumberFormat(this.numberFormat);
            return timeUnitFormat;
        }

        private Object readResolve() {
            switch (this.subClass) {
                case 0:
                    return MeasureFormat.getInstance(this.locale, this.formatWidth, this.numberFormat);
                case 1:
                    return createTimeUnitFormat();
                case 2:
                    return new CurrencyFormat(this.locale);
                default:
                    throw new InvalidObjectException("Unknown subclass: " + this.subClass);
            }
        }
    }

    /* access modifiers changed from: private */
    public static FormatWidth fromFormatWidthOrdinal(int i) {
        FormatWidth[] values = FormatWidth.values();
        if (i < 0 || i >= values.length) {
            return FormatWidth.SHORT;
        }
        return values[i];
    }
}

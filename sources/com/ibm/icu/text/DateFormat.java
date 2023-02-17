package com.ibm.icu.text;

import com.ibm.icu.impl.RelativeDateFormat;
import com.ibm.icu.text.DisplayContext;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.GregorianCalendar;
import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.ULocale;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
public abstract class DateFormat extends UFormat {
    @Deprecated
    public static final List<String> DATE_SKELETONS = Arrays.asList("y", "QQQQ", "QQQ", "yQQQQ", "yQQQ", "MMMM", "MMM", "M", "yMMMM", "yMMM", "yM", "d", "yMMMMd", "yMMMd", "yMd", "EEEE", "E", "yMMMMEEEEd", "yMMMEd", "yMEd", "MMMMd", "MMMd", "Md", "MMMMEEEEd", "MMMEd", "MEd");
    @Deprecated
    public static final List<String> TIME_SKELETONS = Arrays.asList("j", "H", "m", "jm", "Hm", "s", "jms", "Hms", "ms");
    @Deprecated
    public static final List<String> ZONE_SKELETONS = Arrays.asList("VVVV", "vvvv", "v", "zzzz", "z", "ZZZZ");
    private static final long serialVersionUID = 7218322306649953788L;
    private EnumSet<BooleanAttribute> booleanAttributes = EnumSet.allOf(BooleanAttribute.class);
    protected Calendar calendar;
    private DisplayContext capitalizationSetting = DisplayContext.CAPITALIZATION_NONE;
    protected NumberFormat numberFormat;
    private int serialVersionOnStream = 1;

    public enum BooleanAttribute {
        PARSE_ALLOW_WHITESPACE,
        PARSE_ALLOW_NUMERIC,
        PARSE_MULTIPLE_PATTERNS_FOR_MATCH,
        PARSE_PARTIAL_LITERAL_MATCH,
        PARSE_PARTIAL_MATCH
    }

    public abstract StringBuffer format(Calendar calendar2, StringBuffer stringBuffer, FieldPosition fieldPosition);

    public abstract void parse(String str, Calendar calendar2, ParsePosition parsePosition);

    @Override // java.text.Format
    public final StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (obj instanceof Calendar) {
            return format((Calendar) obj, stringBuffer, fieldPosition);
        }
        if (obj instanceof Date) {
            return format((Date) obj, stringBuffer, fieldPosition);
        }
        if (obj instanceof Number) {
            return format(new Date(((Number) obj).longValue()), stringBuffer, fieldPosition);
        }
        throw new IllegalArgumentException("Cannot format given Object (" + obj.getClass().getName() + ") as a Date");
    }

    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        this.calendar.setTime(date);
        return format(this.calendar, stringBuffer, fieldPosition);
    }

    public Date parse(String str, ParsePosition parsePosition) {
        Date date = null;
        int index = parsePosition.getIndex();
        TimeZone timeZone = this.calendar.getTimeZone();
        this.calendar.clear();
        parse(str, this.calendar, parsePosition);
        if (parsePosition.getIndex() != index) {
            try {
                date = this.calendar.getTime();
            } catch (IllegalArgumentException e) {
                parsePosition.setIndex(index);
                parsePosition.setErrorIndex(index);
            }
        }
        this.calendar.setTimeZone(timeZone);
        return date;
    }

    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        return parse(str, parsePosition);
    }

    public static final DateFormat getTimeInstance(int i, ULocale uLocale) {
        return get(-1, i, uLocale, null);
    }

    public static final DateFormat getDateInstance(int i, ULocale uLocale) {
        return get(i, -1, uLocale, null);
    }

    public static final DateFormat getDateTimeInstance(int i, int i2, ULocale uLocale) {
        return get(i, i2, uLocale, null);
    }

    public void setCalendar(Calendar calendar2) {
        this.calendar = calendar2;
    }

    public void setNumberFormat(NumberFormat numberFormat2) {
        this.numberFormat = numberFormat2;
        this.numberFormat.setParseIntegerOnly(true);
    }

    public void setTimeZone(TimeZone timeZone) {
        this.calendar.setTimeZone(timeZone);
    }

    public DateFormat setBooleanAttribute(BooleanAttribute booleanAttribute, boolean z) {
        if (booleanAttribute.equals(BooleanAttribute.PARSE_PARTIAL_MATCH)) {
            booleanAttribute = BooleanAttribute.PARSE_PARTIAL_LITERAL_MATCH;
        }
        if (z) {
            this.booleanAttributes.add(booleanAttribute);
        } else {
            this.booleanAttributes.remove(booleanAttribute);
        }
        return this;
    }

    public boolean getBooleanAttribute(BooleanAttribute booleanAttribute) {
        if (booleanAttribute == BooleanAttribute.PARSE_PARTIAL_MATCH) {
            booleanAttribute = BooleanAttribute.PARSE_PARTIAL_LITERAL_MATCH;
        }
        return this.booleanAttributes.contains(booleanAttribute);
    }

    public void setContext(DisplayContext displayContext) {
        if (displayContext.type() == DisplayContext.Type.CAPITALIZATION) {
            this.capitalizationSetting = displayContext;
        }
    }

    public DisplayContext getContext(DisplayContext.Type type) {
        return (type != DisplayContext.Type.CAPITALIZATION || this.capitalizationSetting == null) ? DisplayContext.CAPITALIZATION_NONE : this.capitalizationSetting;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.numberFormat.hashCode();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DateFormat dateFormat = (DateFormat) obj;
        return ((this.calendar == null && dateFormat.calendar == null) || !(this.calendar == null || dateFormat.calendar == null || !this.calendar.isEquivalentTo(dateFormat.calendar))) && ((this.numberFormat == null && dateFormat.numberFormat == null) || !(this.numberFormat == null || dateFormat.numberFormat == null || !this.numberFormat.equals(dateFormat.numberFormat))) && this.capitalizationSetting == dateFormat.capitalizationSetting;
    }

    @Override // java.text.Format, java.lang.Object
    public Object clone() {
        DateFormat dateFormat = (DateFormat) super.clone();
        dateFormat.calendar = (Calendar) this.calendar.clone();
        if (this.numberFormat != null) {
            dateFormat.numberFormat = (NumberFormat) this.numberFormat.clone();
        }
        return dateFormat;
    }

    private static DateFormat get(int i, int i2, ULocale uLocale, Calendar calendar2) {
        if ((i2 != -1 && (i2 & 128) > 0) || (i != -1 && (i & 128) > 0)) {
            return new RelativeDateFormat(i2, i, uLocale, calendar2);
        }
        if (i2 < -1 || i2 > 3) {
            throw new IllegalArgumentException("Illegal time style " + i2);
        } else if (i < -1 || i > 3) {
            throw new IllegalArgumentException("Illegal date style " + i);
        } else {
            if (calendar2 == null) {
                calendar2 = Calendar.getInstance(uLocale);
            }
            try {
                DateFormat dateTimeFormat = calendar2.getDateTimeFormat(i, i2, uLocale);
                dateTimeFormat.setLocale(calendar2.getLocale(ULocale.VALID_LOCALE), calendar2.getLocale(ULocale.ACTUAL_LOCALE));
                return dateTimeFormat;
            } catch (MissingResourceException e) {
                return new SimpleDateFormat("M/d/yy h:mm a");
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        if (this.serialVersionOnStream < 1) {
            this.capitalizationSetting = DisplayContext.CAPITALIZATION_NONE;
        }
        if (this.booleanAttributes == null) {
            this.booleanAttributes = EnumSet.allOf(BooleanAttribute.class);
        }
        this.serialVersionOnStream = 1;
    }

    protected DateFormat() {
    }

    public static class Field extends Format.Field {
        public static final Field AM_PM = new Field("am pm", 9);
        public static final Field AM_PM_MIDNIGHT_NOON = new Field("am/pm/midnight/noon", -1);
        private static final Field[] CAL_FIELDS = new Field[CAL_FIELD_COUNT];
        private static final int CAL_FIELD_COUNT = new GregorianCalendar().getFieldCount();
        public static final Field DAY_OF_MONTH = new Field("day of month", 5);
        public static final Field DAY_OF_WEEK = new Field("day of week", 7);
        public static final Field DAY_OF_WEEK_IN_MONTH = new Field("day of week in month", 8);
        public static final Field DAY_OF_YEAR = new Field("day of year", 6);
        public static final Field DOW_LOCAL = new Field("local day of week", 18);
        public static final Field ERA = new Field("era", 0);
        public static final Field EXTENDED_YEAR = new Field("extended year", 19);
        private static final Map<String, Field> FIELD_NAME_MAP = new HashMap(CAL_FIELD_COUNT);
        public static final Field FLEXIBLE_DAY_PERIOD = new Field("flexible day period", -1);
        public static final Field HOUR0 = new Field("hour", 10);
        public static final Field HOUR1 = new Field("hour 1", -1);
        public static final Field HOUR_OF_DAY0 = new Field("hour of day", 11);
        public static final Field HOUR_OF_DAY1 = new Field("hour of day 1", -1);
        public static final Field JULIAN_DAY = new Field("Julian day", 20);
        public static final Field MILLISECOND = new Field("millisecond", 14);
        public static final Field MILLISECONDS_IN_DAY = new Field("milliseconds in day", 21);
        public static final Field MINUTE = new Field("minute", 12);
        public static final Field MONTH = new Field("month", 2);
        public static final Field QUARTER = new Field("quarter", -1);
        @Deprecated
        public static final Field RELATED_YEAR = new Field("related year", -1);
        public static final Field SECOND = new Field("second", 13);
        @Deprecated
        public static final Field TIME_SEPARATOR = new Field("time separator", -1);
        public static final Field TIME_ZONE = new Field("time zone", -1);
        public static final Field WEEK_OF_MONTH = new Field("week of month", 4);
        public static final Field WEEK_OF_YEAR = new Field("week of year", 3);
        public static final Field YEAR = new Field("year", 1);
        public static final Field YEAR_WOY = new Field("year for week of year", 17);
        private static final long serialVersionUID = -3627456821000730829L;
        private final int calendarField;

        protected Field(String str, int i) {
            super(str);
            this.calendarField = i;
            if (getClass() == Field.class) {
                FIELD_NAME_MAP.put(str, this);
                if (i >= 0 && i < CAL_FIELD_COUNT) {
                    CAL_FIELDS[i] = this;
                }
            }
        }

        /* access modifiers changed from: protected */
        @Override // java.text.AttributedCharacterIterator.Attribute
        public Object readResolve() {
            if (getClass() != Field.class) {
                throw new InvalidObjectException("A subclass of DateFormat.Field must implement readResolve.");
            }
            Field field = FIELD_NAME_MAP.get(getName());
            if (field != null) {
                return field;
            }
            throw new InvalidObjectException("Unknown attribute name.");
        }
    }
}

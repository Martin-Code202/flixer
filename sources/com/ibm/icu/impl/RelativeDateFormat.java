package com.ibm.icu.impl;

import com.ibm.icu.impl.UResource;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.BreakIterator;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.DisplayContext;
import com.ibm.icu.text.MessageFormat;
import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.MissingResourceException;
public class RelativeDateFormat extends DateFormat {
    private static final long serialVersionUID = 1131984966440549435L;
    private transient BreakIterator capitalizationBrkIter = null;
    private boolean capitalizationInfoIsSet = false;
    private boolean capitalizationOfRelativeUnitsForListOrMenu = false;
    private boolean capitalizationOfRelativeUnitsForStandAlone = false;
    private boolean combinedFormatHasDateAtStart = false;
    private MessageFormat fCombinedFormat;
    private DateFormat fDateFormat;
    private String fDatePattern = null;
    int fDateStyle;
    private SimpleDateFormat fDateTimeFormat = null;
    private transient List<URelativeString> fDates = null;
    ULocale fLocale;
    private String fTimePattern = null;
    int fTimeStyle;

    public static class URelativeString {
        public int offset;
        public String string;

        URelativeString(int i, String str) {
            this.offset = i;
            this.string = str;
        }
    }

    public RelativeDateFormat(int i, int i2, ULocale uLocale, Calendar calendar) {
        this.calendar = calendar;
        this.fLocale = uLocale;
        this.fTimeStyle = i;
        this.fDateStyle = i2;
        if (this.fDateStyle != -1) {
            DateFormat dateInstance = DateFormat.getDateInstance(this.fDateStyle & -129, uLocale);
            if (dateInstance instanceof SimpleDateFormat) {
                this.fDateTimeFormat = (SimpleDateFormat) dateInstance;
                this.fDatePattern = this.fDateTimeFormat.toPattern();
                if (this.fTimeStyle != -1) {
                    DateFormat timeInstance = DateFormat.getTimeInstance(this.fTimeStyle & -129, uLocale);
                    if (timeInstance instanceof SimpleDateFormat) {
                        this.fTimePattern = ((SimpleDateFormat) timeInstance).toPattern();
                    }
                }
            } else {
                throw new IllegalArgumentException("Can't create SimpleDateFormat for date style");
            }
        } else {
            DateFormat timeInstance2 = DateFormat.getTimeInstance(this.fTimeStyle & -129, uLocale);
            if (timeInstance2 instanceof SimpleDateFormat) {
                this.fDateTimeFormat = (SimpleDateFormat) timeInstance2;
                this.fTimePattern = this.fDateTimeFormat.toPattern();
            } else {
                throw new IllegalArgumentException("Can't create SimpleDateFormat for time style");
            }
        }
        initializeCalendar(null, this.fLocale);
        loadDates();
        initializeCombinedFormat(this.calendar, this.fLocale);
    }

    @Override // com.ibm.icu.text.DateFormat
    public StringBuffer format(Calendar calendar, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        String str = null;
        DisplayContext context = getContext(DisplayContext.Type.CAPITALIZATION);
        if (this.fDateStyle != -1) {
            str = getStringForDay(dayDifference(calendar));
        }
        if (this.fDateTimeFormat != null) {
            if (str == null || this.fDatePattern == null || !(this.fTimePattern == null || this.fCombinedFormat == null || this.combinedFormatHasDateAtStart)) {
                this.fDateTimeFormat.setContext(context);
            } else {
                if (str.length() > 0 && UCharacter.isLowerCase(str.codePointAt(0)) && (context == DisplayContext.CAPITALIZATION_FOR_BEGINNING_OF_SENTENCE || ((context == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU && this.capitalizationOfRelativeUnitsForListOrMenu) || (context == DisplayContext.CAPITALIZATION_FOR_STANDALONE && this.capitalizationOfRelativeUnitsForStandAlone)))) {
                    if (this.capitalizationBrkIter == null) {
                        this.capitalizationBrkIter = BreakIterator.getSentenceInstance(this.fLocale);
                    }
                    str = UCharacter.toTitleCase(this.fLocale, str, this.capitalizationBrkIter, 768);
                }
                this.fDateTimeFormat.setContext(DisplayContext.CAPITALIZATION_NONE);
            }
        }
        if (this.fDateTimeFormat == null || (this.fDatePattern == null && this.fTimePattern == null)) {
            if (this.fDateFormat != null) {
                if (str != null) {
                    stringBuffer.append(str);
                } else {
                    this.fDateFormat.format(calendar, stringBuffer, fieldPosition);
                }
            }
        } else if (this.fDatePattern == null) {
            this.fDateTimeFormat.applyPattern(this.fTimePattern);
            this.fDateTimeFormat.format(calendar, stringBuffer, fieldPosition);
        } else if (this.fTimePattern != null) {
            String str2 = this.fDatePattern;
            if (str != null) {
                str2 = "'" + str.replace("'", "''") + "'";
            }
            StringBuffer stringBuffer2 = new StringBuffer("");
            this.fCombinedFormat.format(new Object[]{this.fTimePattern, str2}, stringBuffer2, new FieldPosition(0));
            this.fDateTimeFormat.applyPattern(stringBuffer2.toString());
            this.fDateTimeFormat.format(calendar, stringBuffer, fieldPosition);
        } else if (str != null) {
            stringBuffer.append(str);
        } else {
            this.fDateTimeFormat.applyPattern(this.fDatePattern);
            this.fDateTimeFormat.format(calendar, stringBuffer, fieldPosition);
        }
        return stringBuffer;
    }

    @Override // com.ibm.icu.text.DateFormat
    public void parse(String str, Calendar calendar, ParsePosition parsePosition) {
        throw new UnsupportedOperationException("Relative Date parse is not implemented yet");
    }

    @Override // com.ibm.icu.text.DateFormat
    public void setContext(DisplayContext displayContext) {
        super.setContext(displayContext);
        if (!this.capitalizationInfoIsSet && (displayContext == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU || displayContext == DisplayContext.CAPITALIZATION_FOR_STANDALONE)) {
            initCapitalizationContextInfo(this.fLocale);
            this.capitalizationInfoIsSet = true;
        }
        if (this.capitalizationBrkIter != null) {
            return;
        }
        if (displayContext == DisplayContext.CAPITALIZATION_FOR_BEGINNING_OF_SENTENCE || ((displayContext == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU && this.capitalizationOfRelativeUnitsForListOrMenu) || (displayContext == DisplayContext.CAPITALIZATION_FOR_STANDALONE && this.capitalizationOfRelativeUnitsForStandAlone))) {
            this.capitalizationBrkIter = BreakIterator.getSentenceInstance(this.fLocale);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String getStringForDay(int i) {
        if (this.fDates == null) {
            loadDates();
        }
        for (URelativeString uRelativeString : this.fDates) {
            if (uRelativeString.offset == i) {
                return uRelativeString.string;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final class RelDateFmtDataSink extends UResource.Sink {
        private RelDateFmtDataSink() {
        }

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            if (value.getType() != 3) {
                UResource.Table table = value.getTable();
                for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                    try {
                        int parseInt = Integer.parseInt(key.toString());
                        if (RelativeDateFormat.this.getStringForDay(parseInt) == null) {
                            RelativeDateFormat.this.fDates.add(new URelativeString(parseInt, value.getString()));
                        }
                    } catch (NumberFormatException e) {
                        return;
                    }
                }
            }
        }
    }

    private synchronized void loadDates() {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b", this.fLocale);
        this.fDates = new ArrayList();
        iCUResourceBundle.getAllItemsWithFallback("fields/day/relative", new RelDateFmtDataSink());
    }

    private void initCapitalizationContextInfo(ULocale uLocale) {
        try {
            int[] intVector = ((ICUResourceBundle) UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b", uLocale)).getWithFallback("contextTransforms/relative").getIntVector();
            if (intVector.length >= 2) {
                this.capitalizationOfRelativeUnitsForListOrMenu = intVector[0] != 0;
                this.capitalizationOfRelativeUnitsForStandAlone = intVector[1] != 0;
            }
        } catch (MissingResourceException e) {
        }
    }

    private static int dayDifference(Calendar calendar) {
        Calendar calendar2 = (Calendar) calendar.clone();
        Date date = new Date(System.currentTimeMillis());
        calendar2.clear();
        calendar2.setTime(date);
        return calendar.get(20) - calendar2.get(20);
    }

    private Calendar initializeCalendar(TimeZone timeZone, ULocale uLocale) {
        if (this.calendar == null) {
            if (timeZone == null) {
                this.calendar = Calendar.getInstance(uLocale);
            } else {
                this.calendar = Calendar.getInstance(timeZone, uLocale);
            }
        }
        return this.calendar;
    }

    private MessageFormat initializeCombinedFormat(Calendar calendar, ULocale uLocale) {
        String str;
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b", uLocale);
        ICUResourceBundle findWithFallback = iCUResourceBundle.findWithFallback("calendar/" + calendar.getType() + "/DateTimePatterns");
        if (findWithFallback == null && !calendar.getType().equals("gregorian")) {
            findWithFallback = iCUResourceBundle.findWithFallback("calendar/gregorian/DateTimePatterns");
        }
        if (findWithFallback == null || findWithFallback.getSize() < 9) {
            str = "{1} {0}";
        } else {
            int i = 8;
            if (findWithFallback.getSize() >= 13) {
                if (this.fDateStyle >= 0 && this.fDateStyle <= 3) {
                    i = this.fDateStyle + 1 + 8;
                } else if (this.fDateStyle >= 128 && this.fDateStyle <= 131) {
                    i = ((this.fDateStyle + 1) - 128) + 8;
                }
            }
            if (findWithFallback.get(i).getType() == 8) {
                str = findWithFallback.get(i).getString(0);
            } else {
                str = findWithFallback.getString(i);
            }
        }
        this.combinedFormatHasDateAtStart = str.startsWith("{1}");
        this.fCombinedFormat = new MessageFormat(str, uLocale);
        return this.fCombinedFormat;
    }
}

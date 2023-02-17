package com.ibm.icu.util;

import com.ibm.icu.impl.CalendarUtil;
import com.ibm.icu.util.ULocale;
public final class EthiopicCalendar extends CECalendar {
    private static final long serialVersionUID = -2438495771339315608L;
    private int eraType;

    public EthiopicCalendar() {
        this(TimeZone.getDefault(), ULocale.getDefault(ULocale.Category.FORMAT));
    }

    public EthiopicCalendar(TimeZone timeZone, ULocale uLocale) {
        super(timeZone, uLocale);
        this.eraType = 0;
        setCalcTypeForLocale(uLocale);
    }

    @Override // com.ibm.icu.util.Calendar
    public String getType() {
        if (isAmeteAlemEra()) {
            return "ethiopic-amete-alem";
        }
        return "ethiopic";
    }

    public void setAmeteAlemEra(boolean z) {
        this.eraType = z ? 1 : 0;
    }

    public boolean isAmeteAlemEra() {
        return this.eraType == 1;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public int handleGetExtendedYear() {
        if (newerField(19, 1) == 19) {
            return internalGet(19, 1);
        }
        if (isAmeteAlemEra()) {
            return internalGet(1, 5501) - 5500;
        }
        if (internalGet(0, 1) == 1) {
            return internalGet(1, 1);
        }
        return internalGet(1, 1) - 5500;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public void handleComputeFields(int i) {
        int i2;
        int i3;
        int[] iArr = new int[3];
        jdToCE(i, getJDEpochOffset(), iArr);
        if (isAmeteAlemEra()) {
            i3 = 0;
            i2 = iArr[0] + 5500;
        } else if (iArr[0] > 0) {
            i3 = 1;
            i2 = iArr[0];
        } else {
            i3 = 0;
            i2 = iArr[0] + 5500;
        }
        internalSet(19, iArr[0]);
        internalSet(0, i3);
        internalSet(1, i2);
        internalSet(2, iArr[1]);
        internalSet(5, iArr[2]);
        internalSet(6, (iArr[1] * 30) + iArr[2]);
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.CECalendar, com.ibm.icu.util.Calendar
    @Deprecated
    public int handleGetLimit(int i, int i2) {
        if (!isAmeteAlemEra() || i != 0) {
            return super.handleGetLimit(i, i2);
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.CECalendar
    @Deprecated
    public int getJDEpochOffset() {
        return 1723856;
    }

    private void setCalcTypeForLocale(ULocale uLocale) {
        if ("ethiopic-amete-alem".equals(CalendarUtil.getCalendarType(uLocale))) {
            setAmeteAlemEra(true);
        } else {
            setAmeteAlemEra(false);
        }
    }
}

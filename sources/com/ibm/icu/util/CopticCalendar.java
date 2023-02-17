package com.ibm.icu.util;
public final class CopticCalendar extends CECalendar {
    private static final long serialVersionUID = 5903818751846742911L;

    public CopticCalendar() {
    }

    public CopticCalendar(TimeZone timeZone, ULocale uLocale) {
        super(timeZone, uLocale);
    }

    @Override // com.ibm.icu.util.Calendar
    public String getType() {
        return "coptic";
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public int handleGetExtendedYear() {
        if (newerField(19, 1) == 19) {
            return internalGet(19, 1);
        }
        if (internalGet(0, 1) == 0) {
            return 1 - internalGet(1, 1);
        }
        return internalGet(1, 1);
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.Calendar
    @Deprecated
    public void handleComputeFields(int i) {
        int i2;
        int i3;
        int[] iArr = new int[3];
        jdToCE(i, getJDEpochOffset(), iArr);
        if (iArr[0] <= 0) {
            i3 = 0;
            i2 = 1 - iArr[0];
        } else {
            i3 = 1;
            i2 = iArr[0];
        }
        internalSet(19, iArr[0]);
        internalSet(0, i3);
        internalSet(1, i2);
        internalSet(2, iArr[1]);
        internalSet(5, iArr[2]);
        internalSet(6, (iArr[1] * 30) + iArr[2]);
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.CECalendar
    @Deprecated
    public int getJDEpochOffset() {
        return 1824665;
    }
}

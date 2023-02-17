package com.ibm.icu.util;
public class BuddhistCalendar extends GregorianCalendar {
    private static final long serialVersionUID = 2583005278132380631L;

    public BuddhistCalendar() {
    }

    public BuddhistCalendar(TimeZone timeZone, ULocale uLocale) {
        super(timeZone, uLocale);
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.GregorianCalendar, com.ibm.icu.util.Calendar
    public int handleGetExtendedYear() {
        if (newerField(19, 1) == 19) {
            return internalGet(19, 1970);
        }
        return internalGet(1, 2513) - 543;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.GregorianCalendar, com.ibm.icu.util.Calendar
    public int handleComputeMonthStart(int i, int i2, boolean z) {
        return super.handleComputeMonthStart(i, i2, z);
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.GregorianCalendar, com.ibm.icu.util.Calendar
    public void handleComputeFields(int i) {
        super.handleComputeFields(i);
        internalSet(0, 0);
        internalSet(1, internalGet(19) + 543);
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.GregorianCalendar, com.ibm.icu.util.Calendar
    public int handleGetLimit(int i, int i2) {
        if (i == 0) {
            return 0;
        }
        return super.handleGetLimit(i, i2);
    }

    @Override // com.ibm.icu.util.GregorianCalendar, com.ibm.icu.util.Calendar
    public String getType() {
        return "buddhist";
    }
}

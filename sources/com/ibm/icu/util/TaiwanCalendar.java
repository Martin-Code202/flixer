package com.ibm.icu.util;
public class TaiwanCalendar extends GregorianCalendar {
    private static final long serialVersionUID = 2583005278132380631L;

    public TaiwanCalendar() {
    }

    public TaiwanCalendar(TimeZone timeZone, ULocale uLocale) {
        super(timeZone, uLocale);
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.GregorianCalendar, com.ibm.icu.util.Calendar
    public int handleGetExtendedYear() {
        if (newerField(19, 1) == 19 && newerField(19, 0) == 19) {
            return internalGet(19, 1970);
        }
        if (internalGet(0, 1) == 1) {
            return internalGet(1, 1) + 1911;
        }
        return (1 - internalGet(1, 1)) + 1911;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.GregorianCalendar, com.ibm.icu.util.Calendar
    public void handleComputeFields(int i) {
        super.handleComputeFields(i);
        int internalGet = internalGet(19) - 1911;
        if (internalGet > 0) {
            internalSet(0, 1);
            internalSet(1, internalGet);
            return;
        }
        internalSet(0, 0);
        internalSet(1, 1 - internalGet);
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.GregorianCalendar, com.ibm.icu.util.Calendar
    public int handleGetLimit(int i, int i2) {
        if (i != 0) {
            return super.handleGetLimit(i, i2);
        }
        if (i2 == 0 || i2 == 1) {
            return 0;
        }
        return 1;
    }

    @Override // com.ibm.icu.util.GregorianCalendar, com.ibm.icu.util.Calendar
    public String getType() {
        return "roc";
    }
}

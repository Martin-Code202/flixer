package com.ibm.icu.util;

import java.util.Date;
public class InitialTimeZoneRule extends TimeZoneRule {
    private static final long serialVersionUID = 1876594993064051206L;

    public InitialTimeZoneRule(String str, int i, int i2) {
        super(str, i, i2);
    }

    @Override // com.ibm.icu.util.TimeZoneRule
    public Date getNextStart(long j, int i, int i2, boolean z) {
        return null;
    }

    @Override // com.ibm.icu.util.TimeZoneRule
    public boolean isTransitionRule() {
        return false;
    }
}

package com.ibm.icu.text;

import java.text.FieldPosition;
import java.text.Format;
@Deprecated
public class UFieldPosition extends FieldPosition {
    private int countVisibleFractionDigits = -1;
    private long fractionDigits = 0;

    @Deprecated
    public UFieldPosition() {
        super(-1);
    }

    @Deprecated
    public UFieldPosition(Format.Field field, int i) {
        super(field, i);
    }

    @Deprecated
    public void setFractionDigits(int i, long j) {
        this.countVisibleFractionDigits = i;
        this.fractionDigits = j;
    }

    @Deprecated
    public int getCountVisibleFractionDigits() {
        return this.countVisibleFractionDigits;
    }

    @Deprecated
    public long getFractionDigits() {
        return this.fractionDigits;
    }
}

package com.ibm.icu.impl.number;
public class FormatQuantitySelector {
    public static FormatQuantityBCD from(int i) {
        return new FormatQuantity4(i);
    }
}

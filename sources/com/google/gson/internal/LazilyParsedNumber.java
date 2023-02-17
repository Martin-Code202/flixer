package com.google.gson.internal;

import java.math.BigDecimal;
public final class LazilyParsedNumber extends Number {
    private final String value;

    public LazilyParsedNumber(String str) {
        this.value = str;
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            return Integer.parseInt(this.value);
        } catch (NumberFormatException e) {
            try {
                return (int) Long.parseLong(this.value);
            } catch (NumberFormatException e2) {
                return new BigDecimal(this.value).intValue();
            }
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.value);
        } catch (NumberFormatException e) {
            return new BigDecimal(this.value).longValue();
        }
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.value);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.value);
    }

    @Override // java.lang.Object
    public String toString() {
        return this.value;
    }

    private Object writeReplace() {
        return new BigDecimal(this.value);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.value.hashCode();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazilyParsedNumber)) {
            return false;
        }
        LazilyParsedNumber lazilyParsedNumber = (LazilyParsedNumber) obj;
        return this.value == lazilyParsedNumber.value || this.value.equals(lazilyParsedNumber.value);
    }
}

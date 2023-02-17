package com.ibm.icu.impl.number;

import com.ibm.icu.impl.StandardPlural;
import com.ibm.icu.text.PluralRules;
import java.math.BigDecimal;
import java.math.MathContext;
public interface FormatQuantity extends PluralRules.IFixedDecimal {
    void adjustMagnitude(int i);

    void copyFrom(FormatQuantity formatQuantity);

    FormatQuantity createCopy();

    byte getDigit(int i);

    int getLowerDisplayMagnitude();

    int getMagnitude();

    StandardPlural getStandardPlural(PluralRules pluralRules);

    int getUpperDisplayMagnitude();

    @Override // com.ibm.icu.text.PluralRules.IFixedDecimal
    boolean isInfinite();

    @Override // com.ibm.icu.text.PluralRules.IFixedDecimal
    boolean isNaN();

    boolean isNegative();

    boolean isZero();

    void multiplyBy(BigDecimal bigDecimal);

    void roundToIncrement(BigDecimal bigDecimal, MathContext mathContext);

    void roundToInfinity();

    void roundToMagnitude(int i, MathContext mathContext);

    void setIntegerFractionLength(int i, int i2, int i3, int i4);
}

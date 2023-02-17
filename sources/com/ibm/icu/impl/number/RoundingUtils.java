package com.ibm.icu.impl.number;

import com.ibm.icu.impl.number.Rounder;
import java.math.MathContext;
import java.math.RoundingMode;
public class RoundingUtils {
    private static final MathContext[] MATH_CONTEXT_BY_ROUNDING_MODE_16_DIGITS = new MathContext[RoundingMode.values().length];
    private static final MathContext[] MATH_CONTEXT_BY_ROUNDING_MODE_UNLIMITED = new MathContext[RoundingMode.values().length];

    public static boolean getRoundingDirection(boolean z, boolean z2, int i, int i2, Object obj) {
        switch (i2) {
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return z2;
            case 3:
                return !z2;
            case 4:
                switch (i) {
                    case 1:
                        return true;
                    case 2:
                        return false;
                    case 3:
                        return false;
                }
            case 5:
                switch (i) {
                    case 1:
                        return true;
                    case 2:
                        return true;
                    case 3:
                        return false;
                }
            case 6:
                switch (i) {
                    case 1:
                        return true;
                    case 2:
                        return z;
                    case 3:
                        return false;
                }
        }
        throw new ArithmeticException("Rounding is required on " + obj.toString());
    }

    public static boolean roundsAtMidpoint(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                return false;
            default:
                return true;
        }
    }

    static {
        for (int i = 0; i < MATH_CONTEXT_BY_ROUNDING_MODE_16_DIGITS.length; i++) {
            MATH_CONTEXT_BY_ROUNDING_MODE_UNLIMITED[i] = new MathContext(0, RoundingMode.valueOf(i));
            MATH_CONTEXT_BY_ROUNDING_MODE_16_DIGITS[i] = new MathContext(16);
        }
    }

    public static MathContext getMathContextOrUnlimited(Rounder.IBasicRoundingProperties iBasicRoundingProperties) {
        MathContext mathContext = iBasicRoundingProperties.getMathContext();
        if (mathContext != null) {
            return mathContext;
        }
        RoundingMode roundingMode = iBasicRoundingProperties.getRoundingMode();
        if (roundingMode == null) {
            roundingMode = RoundingMode.HALF_EVEN;
        }
        return MATH_CONTEXT_BY_ROUNDING_MODE_UNLIMITED[roundingMode.ordinal()];
    }

    public static MathContext getMathContextOr16Digits(Rounder.IBasicRoundingProperties iBasicRoundingProperties) {
        MathContext mathContext = iBasicRoundingProperties.getMathContext();
        if (mathContext != null) {
            return mathContext;
        }
        RoundingMode roundingMode = iBasicRoundingProperties.getRoundingMode();
        if (roundingMode == null) {
            roundingMode = RoundingMode.HALF_EVEN;
        }
        return MATH_CONTEXT_BY_ROUNDING_MODE_16_DIGITS[roundingMode.ordinal()];
    }
}

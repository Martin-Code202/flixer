package com.ibm.icu.impl.number.formatters;

import com.ibm.icu.impl.number.Rounder;
import com.ibm.icu.impl.number.rounders.IncrementRounder;
import com.ibm.icu.impl.number.rounders.MagnitudeRounder;
import com.ibm.icu.impl.number.rounders.NoRounder;
import com.ibm.icu.impl.number.rounders.SignificantDigitsRounder;
public class RoundingFormat {

    public interface IProperties extends IncrementRounder.IProperties, MagnitudeRounder.IProperties, SignificantDigitsRounder.IProperties {
    }

    public static Rounder getDefaultOrNoRounder(IProperties iProperties) {
        Rounder defaultOrNull = getDefaultOrNull(iProperties);
        if (defaultOrNull == null) {
            return NoRounder.getInstance(iProperties);
        }
        return defaultOrNull;
    }

    public static Rounder getDefaultOrNull(IProperties iProperties) {
        if (SignificantDigitsRounder.useSignificantDigits(iProperties)) {
            return SignificantDigitsRounder.getInstance(iProperties);
        }
        if (IncrementRounder.useRoundingIncrement(iProperties)) {
            return IncrementRounder.getInstance(iProperties);
        }
        if (MagnitudeRounder.useFractionFormat(iProperties)) {
            return MagnitudeRounder.getInstance(iProperties);
        }
        return null;
    }
}

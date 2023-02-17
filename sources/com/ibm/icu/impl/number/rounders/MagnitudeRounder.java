package com.ibm.icu.impl.number.rounders;

import com.ibm.icu.impl.number.FormatQuantity;
import com.ibm.icu.impl.number.Rounder;
public class MagnitudeRounder extends Rounder {

    public interface IProperties extends Rounder.IBasicRoundingProperties {
    }

    public static boolean useFractionFormat(IProperties iProperties) {
        return (iProperties.getMinimumFractionDigits() == -1 && iProperties.getMaximumFractionDigits() == -1) ? false : true;
    }

    public static MagnitudeRounder getInstance(Rounder.IBasicRoundingProperties iBasicRoundingProperties) {
        return new MagnitudeRounder(iBasicRoundingProperties);
    }

    private MagnitudeRounder(Rounder.IBasicRoundingProperties iBasicRoundingProperties) {
        super(iBasicRoundingProperties);
    }

    @Override // com.ibm.icu.impl.number.Rounder
    public void apply(FormatQuantity formatQuantity) {
        formatQuantity.roundToMagnitude(-this.maxFrac, this.mathContext);
        applyDefaults(formatQuantity);
    }
}

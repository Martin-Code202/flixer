package com.ibm.icu.impl.number.rounders;

import com.ibm.icu.impl.number.FormatQuantity;
import com.ibm.icu.impl.number.Rounder;
public final class NoRounder extends Rounder {
    public static NoRounder getInstance(Rounder.IBasicRoundingProperties iBasicRoundingProperties) {
        return new NoRounder(iBasicRoundingProperties);
    }

    private NoRounder(Rounder.IBasicRoundingProperties iBasicRoundingProperties) {
        super(iBasicRoundingProperties);
    }

    @Override // com.ibm.icu.impl.number.Rounder
    public void apply(FormatQuantity formatQuantity) {
        applyDefaults(formatQuantity);
        formatQuantity.roundToInfinity();
    }
}

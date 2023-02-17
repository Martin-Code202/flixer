package com.ibm.icu.impl.number.rounders;

import com.ibm.icu.impl.number.FormatQuantity;
import com.ibm.icu.impl.number.Properties;
import com.ibm.icu.impl.number.Rounder;
import java.math.BigDecimal;
public class IncrementRounder extends Rounder {
    private final BigDecimal roundingIncrement;

    public interface IProperties extends Rounder.IBasicRoundingProperties {
        public static final BigDecimal DEFAULT_ROUNDING_INCREMENT = null;

        BigDecimal getRoundingIncrement();
    }

    public static boolean useRoundingIncrement(IProperties iProperties) {
        return iProperties.getRoundingIncrement() != IProperties.DEFAULT_ROUNDING_INCREMENT;
    }

    public static IncrementRounder getInstance(IProperties iProperties) {
        return new IncrementRounder(iProperties);
    }

    private IncrementRounder(IProperties iProperties) {
        super(iProperties);
        if (iProperties.getRoundingIncrement().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Rounding interval must be greater than zero");
        }
        this.roundingIncrement = iProperties.getRoundingIncrement();
    }

    @Override // com.ibm.icu.impl.number.Rounder
    public void apply(FormatQuantity formatQuantity) {
        formatQuantity.roundToIncrement(this.roundingIncrement, this.mathContext);
        applyDefaults(formatQuantity);
    }

    @Override // com.ibm.icu.impl.number.Rounder, com.ibm.icu.impl.number.Exportable
    public void export(Properties properties) {
        super.export(properties);
        properties.setRoundingIncrement(this.roundingIncrement);
    }
}

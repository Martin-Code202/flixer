package com.ibm.icu.impl.number.formatters;

import com.ibm.icu.impl.number.Format;
import com.ibm.icu.impl.number.FormatQuantity;
import com.ibm.icu.impl.number.ModifierHolder;
import com.ibm.icu.impl.number.Properties;
import java.math.BigDecimal;
public class BigDecimalMultiplier extends Format.BeforeFormat {
    private final BigDecimal multiplier;

    public interface IProperties {
        public static final BigDecimal DEFAULT_MULTIPLIER = null;

        BigDecimal getMultiplier();
    }

    public static boolean useMultiplier(IProperties iProperties) {
        return iProperties.getMultiplier() != IProperties.DEFAULT_MULTIPLIER;
    }

    public static BigDecimalMultiplier getInstance(IProperties iProperties) {
        if (iProperties.getMultiplier() != null) {
            return new BigDecimalMultiplier(iProperties);
        }
        throw new IllegalArgumentException("The multiplier must be present for MultiplierFormat");
    }

    private BigDecimalMultiplier(IProperties iProperties) {
        this.multiplier = iProperties.getMultiplier();
    }

    @Override // com.ibm.icu.impl.number.Format.BeforeFormat
    public void before(FormatQuantity formatQuantity, ModifierHolder modifierHolder) {
        formatQuantity.multiplyBy(this.multiplier);
    }

    @Override // com.ibm.icu.impl.number.Exportable
    public void export(Properties properties) {
        properties.setMultiplier(this.multiplier);
    }
}

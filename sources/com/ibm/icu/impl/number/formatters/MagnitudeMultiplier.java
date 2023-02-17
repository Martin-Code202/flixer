package com.ibm.icu.impl.number.formatters;

import com.ibm.icu.impl.number.Format;
import com.ibm.icu.impl.number.FormatQuantity;
import com.ibm.icu.impl.number.ModifierHolder;
import com.ibm.icu.impl.number.Properties;
public class MagnitudeMultiplier extends Format.BeforeFormat {
    private static final MagnitudeMultiplier DEFAULT = new MagnitudeMultiplier(0);
    final int delta;

    public interface IProperties {
        int getMagnitudeMultiplier();
    }

    public static boolean useMagnitudeMultiplier(IProperties iProperties) {
        return iProperties.getMagnitudeMultiplier() != 0;
    }

    public static Format.BeforeFormat getInstance(Properties properties) {
        if (properties.getMagnitudeMultiplier() == 0) {
            return DEFAULT;
        }
        return new MagnitudeMultiplier(properties.getMagnitudeMultiplier());
    }

    private MagnitudeMultiplier(int i) {
        this.delta = i;
    }

    @Override // com.ibm.icu.impl.number.Format.BeforeFormat
    public void before(FormatQuantity formatQuantity, ModifierHolder modifierHolder) {
        formatQuantity.adjustMagnitude(this.delta);
    }

    @Override // com.ibm.icu.impl.number.Exportable
    public void export(Properties properties) {
        properties.setMagnitudeMultiplier(this.delta);
    }
}

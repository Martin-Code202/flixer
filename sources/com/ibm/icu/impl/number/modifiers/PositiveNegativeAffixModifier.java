package com.ibm.icu.impl.number.modifiers;

import com.ibm.icu.impl.number.Format;
import com.ibm.icu.impl.number.FormatQuantity;
import com.ibm.icu.impl.number.Modifier;
import com.ibm.icu.impl.number.ModifierHolder;
import com.ibm.icu.impl.number.Properties;
public class PositiveNegativeAffixModifier extends Format.BeforeFormat implements Modifier.PositiveNegativeModifier {
    private final Modifier.AffixModifier negative;
    private final Modifier.AffixModifier positive;

    public PositiveNegativeAffixModifier(Modifier.AffixModifier affixModifier, Modifier.AffixModifier affixModifier2) {
        this.positive = affixModifier;
        this.negative = affixModifier2;
    }

    @Override // com.ibm.icu.impl.number.Modifier.PositiveNegativeModifier
    public Modifier getModifier(boolean z) {
        return z ? this.negative : this.positive;
    }

    @Override // com.ibm.icu.impl.number.Format.BeforeFormat
    public void before(FormatQuantity formatQuantity, ModifierHolder modifierHolder) {
        modifierHolder.add(getModifier(formatQuantity.isNegative()));
    }

    @Override // com.ibm.icu.impl.number.Exportable
    public void export(Properties properties) {
        exportPositiveNegative(properties, this.positive, this.negative);
    }

    static void exportPositiveNegative(Properties properties, Modifier modifier, Modifier modifier2) {
        properties.setPositivePrefix(modifier.getPrefix().isEmpty() ? null : modifier.getPrefix());
        properties.setPositiveSuffix(modifier.getSuffix().isEmpty() ? null : modifier.getSuffix());
        properties.setNegativePrefix(modifier2.getPrefix().isEmpty() ? null : modifier2.getPrefix());
        properties.setNegativeSuffix(modifier2.getSuffix().isEmpty() ? null : modifier2.getSuffix());
    }
}

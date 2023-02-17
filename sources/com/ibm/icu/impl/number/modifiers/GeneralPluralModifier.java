package com.ibm.icu.impl.number.modifiers;

import com.ibm.icu.impl.StandardPlural;
import com.ibm.icu.impl.number.Format;
import com.ibm.icu.impl.number.FormatQuantity;
import com.ibm.icu.impl.number.Modifier;
import com.ibm.icu.impl.number.ModifierHolder;
import com.ibm.icu.impl.number.Properties;
import com.ibm.icu.text.PluralRules;
public class GeneralPluralModifier extends Format.BeforeFormat implements Modifier.PositiveNegativePluralModifier {
    static final /* synthetic */ boolean $assertionsDisabled = (!GeneralPluralModifier.class.desiredAssertionStatus());
    private final Modifier[] mods = new Modifier[(StandardPlural.COUNT * 2)];

    public void put(StandardPlural standardPlural, Modifier modifier) {
        put(standardPlural, modifier, modifier);
    }

    public void put(StandardPlural standardPlural, Modifier modifier, Modifier modifier2) {
        if (!$assertionsDisabled && this.mods[standardPlural.ordinal() * 2] != null) {
            throw new AssertionError();
        } else if (!$assertionsDisabled && this.mods[(standardPlural.ordinal() * 2) + 1] != null) {
            throw new AssertionError();
        } else if (!$assertionsDisabled && modifier == null) {
            throw new AssertionError();
        } else if ($assertionsDisabled || modifier2 != null) {
            this.mods[standardPlural.ordinal() * 2] = modifier;
            this.mods[(standardPlural.ordinal() * 2) + 1] = modifier2;
        } else {
            throw new AssertionError();
        }
    }

    public Modifier getModifier(StandardPlural standardPlural, boolean z) {
        Modifier modifier = this.mods[(standardPlural.ordinal() * 2) + (z ? 1 : 0)];
        if (modifier == null) {
            modifier = this.mods[(StandardPlural.OTHER.ordinal() * 2) + (z ? 1 : 0)];
        }
        if (modifier != null) {
            return modifier;
        }
        throw new UnsupportedOperationException();
    }

    @Override // com.ibm.icu.impl.number.Format.BeforeFormat
    public void before(FormatQuantity formatQuantity, ModifierHolder modifierHolder, PluralRules pluralRules) {
        modifierHolder.add(getModifier(formatQuantity.getStandardPlural(pluralRules), formatQuantity.isNegative()));
    }

    @Override // com.ibm.icu.impl.number.Format.BeforeFormat
    public void before(FormatQuantity formatQuantity, ModifierHolder modifierHolder) {
        throw new UnsupportedOperationException();
    }

    @Override // com.ibm.icu.impl.number.Exportable
    public void export(Properties properties) {
        PositiveNegativeAffixModifier.exportPositiveNegative(properties, getModifier(StandardPlural.OTHER, false), getModifier(StandardPlural.OTHER, true));
    }
}

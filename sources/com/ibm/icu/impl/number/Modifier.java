package com.ibm.icu.impl.number;

import com.ibm.icu.impl.number.Format;
public interface Modifier {

    public interface AffixModifier extends Modifier {
    }

    public interface PositiveNegativeModifier extends Exportable {
        Modifier getModifier(boolean z);
    }

    public interface PositiveNegativePluralModifier extends Exportable {
    }

    int apply(NumberStringBuilder numberStringBuilder, int i, int i2);

    String getPrefix();

    String getSuffix();

    boolean isStrong();

    int length();

    public static abstract class BaseModifier extends Format.BeforeFormat implements Modifier, PositiveNegativeModifier {
        @Override // com.ibm.icu.impl.number.Format.BeforeFormat
        public void before(FormatQuantity formatQuantity, ModifierHolder modifierHolder) {
            modifierHolder.add(this);
        }

        @Override // com.ibm.icu.impl.number.Modifier.PositiveNegativeModifier
        public Modifier getModifier(boolean z) {
            return this;
        }
    }
}

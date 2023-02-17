package com.ibm.icu.impl.number.modifiers;

import com.ibm.icu.impl.number.Modifier;
import com.ibm.icu.impl.number.NumberStringBuilder;
import com.ibm.icu.impl.number.Properties;
import com.ibm.icu.text.NumberFormat;
public class ConstantAffixModifier extends Modifier.BaseModifier implements Modifier.AffixModifier {
    public static final Modifier.AffixModifier EMPTY = new ConstantAffixModifier();
    private final NumberFormat.Field field;
    private final String prefix;
    private final boolean strong;
    private final String suffix;

    public ConstantAffixModifier(String str, String str2, NumberFormat.Field field2, boolean z) {
        this.prefix = str == null ? "" : str;
        this.suffix = str2 == null ? "" : str2;
        this.field = field2;
        this.strong = z;
    }

    public ConstantAffixModifier() {
        this.prefix = "";
        this.suffix = "";
        this.field = null;
        this.strong = false;
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public int apply(NumberStringBuilder numberStringBuilder, int i, int i2) {
        return numberStringBuilder.insert(i2, this.suffix, this.field) + numberStringBuilder.insert(i, this.prefix, this.field);
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public int length() {
        return this.prefix.length() + this.suffix.length();
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public boolean isStrong() {
        return this.strong;
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public String getPrefix() {
        return this.prefix;
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public String getSuffix() {
        return this.suffix;
    }

    public String toString() {
        return String.format("<ConstantAffixModifier(%d) prefix:'%s' suffix:'%s'>", Integer.valueOf(length()), this.prefix, this.suffix);
    }

    @Override // com.ibm.icu.impl.number.Exportable
    public void export(Properties properties) {
        throw new UnsupportedOperationException();
    }
}

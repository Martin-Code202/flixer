package com.ibm.icu.impl.number.modifiers;

import com.ibm.icu.impl.number.Modifier;
import com.ibm.icu.impl.number.NumberStringBuilder;
import com.ibm.icu.impl.number.Properties;
import com.ibm.icu.text.NumberFormat;
public class ConstantMultiFieldModifier extends Modifier.BaseModifier implements Modifier.AffixModifier {
    public static final ConstantMultiFieldModifier EMPTY = new ConstantMultiFieldModifier();
    private final String prefix;
    private final char[] prefixChars;
    private final NumberFormat.Field[] prefixFields;
    private final boolean strong;
    private final String suffix;
    private final char[] suffixChars;
    private final NumberFormat.Field[] suffixFields;

    public ConstantMultiFieldModifier(NumberStringBuilder numberStringBuilder, NumberStringBuilder numberStringBuilder2, boolean z) {
        this.prefixChars = numberStringBuilder.toCharArray();
        this.suffixChars = numberStringBuilder2.toCharArray();
        this.prefixFields = numberStringBuilder.toFieldArray();
        this.suffixFields = numberStringBuilder2.toFieldArray();
        this.prefix = new String(this.prefixChars);
        this.suffix = new String(this.suffixChars);
        this.strong = z;
    }

    private ConstantMultiFieldModifier() {
        this.prefixChars = new char[0];
        this.suffixChars = new char[0];
        this.prefixFields = new NumberFormat.Field[0];
        this.suffixFields = new NumberFormat.Field[0];
        this.prefix = "";
        this.suffix = "";
        this.strong = false;
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public int apply(NumberStringBuilder numberStringBuilder, int i, int i2) {
        return numberStringBuilder.insert(i2, this.suffixChars, this.suffixFields) + numberStringBuilder.insert(i, this.prefixChars, this.prefixFields);
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public int length() {
        return this.prefixChars.length + this.suffixChars.length;
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

    public boolean contentEquals(NumberStringBuilder numberStringBuilder, NumberStringBuilder numberStringBuilder2) {
        return numberStringBuilder.contentEquals(this.prefixChars, this.prefixFields) && numberStringBuilder2.contentEquals(this.suffixChars, this.suffixFields);
    }

    public String toString() {
        return String.format("<ConstantMultiFieldModifier(%d) prefix:'%s' suffix:'%s'>", Integer.valueOf(length()), this.prefix, this.suffix);
    }

    @Override // com.ibm.icu.impl.number.Exportable
    public void export(Properties properties) {
        throw new UnsupportedOperationException();
    }
}

package com.ibm.icu.impl.number.modifiers;

import com.ibm.icu.impl.SimpleFormatterImpl;
import com.ibm.icu.impl.number.Modifier;
import com.ibm.icu.impl.number.NumberStringBuilder;
import com.ibm.icu.impl.number.Properties;
import com.ibm.icu.text.NumberFormat;
public class SimpleModifier extends Modifier.BaseModifier {
    static final /* synthetic */ boolean $assertionsDisabled = (!SimpleModifier.class.desiredAssertionStatus());
    private final String compiledPattern;
    private final NumberFormat.Field field;
    private final boolean strong;

    public SimpleModifier(String str, NumberFormat.Field field2, boolean z) {
        this.compiledPattern = str == null ? "\u0001\u0000" : str;
        this.field = field2;
        this.strong = z;
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public int apply(NumberStringBuilder numberStringBuilder, int i, int i2) {
        return formatAsPrefixSuffix(this.compiledPattern, numberStringBuilder, i, i2, this.field);
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public int length() {
        return formatAsPrefixSuffix(this.compiledPattern, null, -1, -1, this.field);
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public boolean isStrong() {
        return this.strong;
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public String getPrefix() {
        throw new UnsupportedOperationException();
    }

    @Override // com.ibm.icu.impl.number.Modifier
    public String getSuffix() {
        throw new UnsupportedOperationException();
    }

    public static int formatAsPrefixSuffix(String str, NumberStringBuilder numberStringBuilder, int i, int i2, NumberFormat.Field field2) {
        if ($assertionsDisabled || SimpleFormatterImpl.getArgumentLimit(str) == 1) {
            int i3 = 0;
            int i4 = 2;
            if (str.charAt(1) != 0) {
                int charAt = str.charAt(1) - 256;
                if (numberStringBuilder != null) {
                    numberStringBuilder.insert(i, str, 2, charAt + 2, field2);
                }
                i3 = charAt + 0;
                i4 = charAt + 3;
            }
            if (i4 >= str.length()) {
                return i3;
            }
            int charAt2 = str.charAt(i4) - 256;
            if (numberStringBuilder != null) {
                numberStringBuilder.insert(i2 + i3, str, i4 + 1, i4 + charAt2 + 1, field2);
            }
            return i3 + charAt2;
        }
        throw new AssertionError();
    }

    @Override // com.ibm.icu.impl.number.Exportable
    public void export(Properties properties) {
        throw new UnsupportedOperationException();
    }
}

package com.ibm.icu.impl.number.formatters;

import com.ibm.icu.impl.number.Format;
import com.ibm.icu.impl.number.FormatQuantity;
import com.ibm.icu.impl.number.NumberStringBuilder;
import com.ibm.icu.impl.number.Properties;
import com.ibm.icu.impl.number.formatters.CurrencyFormat;
import com.ibm.icu.text.DecimalFormatSymbols;
import com.ibm.icu.text.NumberFormat;
public class PositiveDecimalFormat implements Format.TargetFormat {
    private final boolean alwaysShowDecimal;
    private final int codePointZero;
    private final String decimalSeparator;
    private final String[] digitStrings;
    private final String groupingSeparator;
    private final String infinityString;
    private final int minimumGroupingDigits;
    private final String nanString;
    private final int primaryGroupingSize;
    private final int secondaryGroupingSize;

    public interface IProperties extends CurrencyFormat.IProperties {
        boolean getDecimalSeparatorAlwaysShown();

        int getGroupingSize();

        int getMinimumGroupingDigits();

        int getSecondaryGroupingSize();
    }

    public static boolean allowsDecimalPoint(IProperties iProperties) {
        return iProperties.getDecimalSeparatorAlwaysShown() || iProperties.getMaximumFractionDigits() != 0;
    }

    public PositiveDecimalFormat(DecimalFormatSymbols decimalFormatSymbols, IProperties iProperties) {
        int groupingSize = iProperties.getGroupingSize();
        int secondaryGroupingSize2 = iProperties.getSecondaryGroupingSize();
        this.primaryGroupingSize = groupingSize > 0 ? groupingSize : secondaryGroupingSize2 > 0 ? secondaryGroupingSize2 : 0;
        this.secondaryGroupingSize = secondaryGroupingSize2 > 0 ? secondaryGroupingSize2 : this.primaryGroupingSize;
        this.minimumGroupingDigits = iProperties.getMinimumGroupingDigits();
        this.alwaysShowDecimal = iProperties.getDecimalSeparatorAlwaysShown();
        this.infinityString = decimalFormatSymbols.getInfinity();
        this.nanString = decimalFormatSymbols.getNaN();
        if (CurrencyFormat.useCurrency(iProperties)) {
            this.groupingSeparator = decimalFormatSymbols.getMonetaryGroupingSeparatorString();
            this.decimalSeparator = decimalFormatSymbols.getMonetaryDecimalSeparatorString();
        } else {
            this.groupingSeparator = decimalFormatSymbols.getGroupingSeparatorString();
            this.decimalSeparator = decimalFormatSymbols.getDecimalSeparatorString();
        }
        int i = -1;
        String[] digitStringsLocal = decimalFormatSymbols.getDigitStringsLocal();
        int i2 = 0;
        while (true) {
            if (i2 >= digitStringsLocal.length) {
                break;
            }
            int codePointAt = Character.codePointAt(digitStringsLocal[i2], 0);
            if (Character.charCount(codePointAt) != digitStringsLocal[i2].length()) {
                i = -1;
                break;
            }
            if (i2 == 0) {
                i = codePointAt;
            } else if (codePointAt != i + i2) {
                i = -1;
                break;
            }
            i2++;
        }
        if (i != -1) {
            this.digitStrings = null;
            this.codePointZero = i;
            return;
        }
        this.digitStrings = decimalFormatSymbols.getDigitStrings();
        this.codePointZero = -1;
    }

    @Override // com.ibm.icu.impl.number.Format.TargetFormat
    public int target(FormatQuantity formatQuantity, NumberStringBuilder numberStringBuilder, int i) {
        if (formatQuantity.isInfinite()) {
            return numberStringBuilder.insert(i, this.infinityString, NumberFormat.Field.INTEGER) + 0;
        }
        if (formatQuantity.isNaN()) {
            return numberStringBuilder.insert(i, this.nanString, NumberFormat.Field.INTEGER) + 0;
        }
        int addIntegerDigits = addIntegerDigits(formatQuantity, numberStringBuilder, i) + 0;
        if (formatQuantity.getLowerDisplayMagnitude() < 0 || this.alwaysShowDecimal) {
            addIntegerDigits += numberStringBuilder.insert(i + addIntegerDigits, this.decimalSeparator, NumberFormat.Field.DECIMAL_SEPARATOR);
        }
        return addIntegerDigits + addFractionDigits(formatQuantity, numberStringBuilder, i + addIntegerDigits);
    }

    private int addIntegerDigits(FormatQuantity formatQuantity, NumberStringBuilder numberStringBuilder, int i) {
        int i2 = 0;
        int upperDisplayMagnitude = formatQuantity.getUpperDisplayMagnitude() + 1;
        for (int i3 = 0; i3 < upperDisplayMagnitude; i3++) {
            if (this.primaryGroupingSize > 0 && i3 == this.primaryGroupingSize && upperDisplayMagnitude - i3 >= this.minimumGroupingDigits) {
                i2 += numberStringBuilder.insert(i, this.groupingSeparator, NumberFormat.Field.GROUPING_SEPARATOR);
            } else if (this.secondaryGroupingSize > 0 && i3 > this.primaryGroupingSize && (i3 - this.primaryGroupingSize) % this.secondaryGroupingSize == 0) {
                i2 += numberStringBuilder.insert(i, this.groupingSeparator, NumberFormat.Field.GROUPING_SEPARATOR);
            }
            i2 += addDigit(formatQuantity.getDigit(i3), numberStringBuilder, i, NumberFormat.Field.INTEGER);
        }
        return i2;
    }

    private int addFractionDigits(FormatQuantity formatQuantity, NumberStringBuilder numberStringBuilder, int i) {
        int i2 = 0;
        int i3 = -formatQuantity.getLowerDisplayMagnitude();
        for (int i4 = 0; i4 < i3; i4++) {
            i2 += addDigit(formatQuantity.getDigit((-i4) - 1), numberStringBuilder, i + i2, NumberFormat.Field.FRACTION);
        }
        return i2;
    }

    private int addDigit(byte b, NumberStringBuilder numberStringBuilder, int i, NumberFormat.Field field) {
        if (this.codePointZero != -1) {
            return numberStringBuilder.insertCodePoint(i, this.codePointZero + b, field);
        }
        return numberStringBuilder.insert(i, this.digitStrings[b], field);
    }

    @Override // com.ibm.icu.impl.number.Exportable
    public void export(Properties properties) {
        int i = this.secondaryGroupingSize == this.primaryGroupingSize ? 0 : this.secondaryGroupingSize;
        properties.setDecimalSeparatorAlwaysShown(this.alwaysShowDecimal);
        properties.setGroupingSize(this.primaryGroupingSize);
        properties.setSecondaryGroupingSize(i);
        properties.setMinimumGroupingDigits(this.minimumGroupingDigits);
    }
}

package com.ibm.icu.impl.number.formatters;

import com.ibm.icu.impl.StandardPlural;
import com.ibm.icu.impl.number.modifiers.GeneralPluralModifier;
import com.ibm.icu.impl.number.modifiers.SimpleModifier;
import com.ibm.icu.text.DecimalFormatSymbols;
import com.ibm.icu.text.MeasureFormat;
import com.ibm.icu.util.MeasureUnit;
import com.ibm.icu.util.ULocale;
public class MeasureFormat {

    public interface IProperties {
        public static final MeasureFormat.FormatWidth DEFAULT_MEASURE_FORMAT_WIDTH = null;
        public static final MeasureUnit DEFAULT_MEASURE_UNIT = null;

        MeasureFormat.FormatWidth getMeasureFormatWidth();

        MeasureUnit getMeasureUnit();
    }

    public static boolean useMeasureFormat(IProperties iProperties) {
        return iProperties.getMeasureUnit() != IProperties.DEFAULT_MEASURE_UNIT;
    }

    public static GeneralPluralModifier getInstance(DecimalFormatSymbols decimalFormatSymbols, IProperties iProperties) {
        ULocale uLocale = decimalFormatSymbols.getULocale();
        MeasureUnit measureUnit = iProperties.getMeasureUnit();
        MeasureFormat.FormatWidth measureFormatWidth = iProperties.getMeasureFormatWidth();
        if (measureUnit == null) {
            throw new IllegalArgumentException("A measure unit is required for MeasureFormat");
        }
        if (measureFormatWidth == null) {
            measureFormatWidth = MeasureFormat.FormatWidth.WIDE;
        }
        com.ibm.icu.text.MeasureFormat instance = com.ibm.icu.text.MeasureFormat.getInstance(uLocale, measureFormatWidth);
        GeneralPluralModifier generalPluralModifier = new GeneralPluralModifier();
        for (StandardPlural standardPlural : StandardPlural.VALUES) {
            instance.getPluralFormatter(measureUnit, measureFormatWidth, standardPlural.ordinal());
            generalPluralModifier.put(standardPlural, new SimpleModifier(null, null, false));
        }
        return generalPluralModifier;
    }
}

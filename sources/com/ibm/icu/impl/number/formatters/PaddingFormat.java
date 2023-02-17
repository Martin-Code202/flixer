package com.ibm.icu.impl.number.formatters;

import com.ibm.icu.impl.number.Format;
import com.ibm.icu.impl.number.ModifierHolder;
import com.ibm.icu.impl.number.NumberStringBuilder;
import com.ibm.icu.impl.number.Properties;
import com.ibm.icu.text.NumberFormat;
public class PaddingFormat implements Format.AfterFormat {
    private final PadPosition paddingLocation;
    private final String paddingString;
    private final int paddingWidth;

    public interface IProperties {
        public static final PadPosition DEFAULT_PAD_POSITION = null;
        public static final String DEFAULT_PAD_STRING = null;

        int getFormatWidth();

        PadPosition getPadPosition();

        String getPadString();
    }

    public enum PadPosition {
        BEFORE_PREFIX,
        AFTER_PREFIX,
        BEFORE_SUFFIX,
        AFTER_SUFFIX;

        public static PadPosition fromOld(int i) {
            switch (i) {
                case 0:
                    return BEFORE_PREFIX;
                case 1:
                    return AFTER_PREFIX;
                case 2:
                    return BEFORE_SUFFIX;
                case 3:
                    return AFTER_SUFFIX;
                default:
                    throw new IllegalArgumentException("Don't know how to map " + i);
            }
        }
    }

    public static boolean usePadding(IProperties iProperties) {
        return iProperties.getFormatWidth() != 0;
    }

    public static Format.AfterFormat getInstance(IProperties iProperties) {
        return new PaddingFormat(iProperties.getFormatWidth(), iProperties.getPadString(), iProperties.getPadPosition());
    }

    private PaddingFormat(int i, String str, PadPosition padPosition) {
        this.paddingWidth = i > 0 ? i : 10;
        this.paddingString = str != null ? str : " ";
        this.paddingLocation = padPosition != null ? padPosition : PadPosition.BEFORE_PREFIX;
    }

    @Override // com.ibm.icu.impl.number.Format.AfterFormat
    public int after(ModifierHolder modifierHolder, NumberStringBuilder numberStringBuilder, int i, int i2) {
        int i3 = (this.paddingWidth - (i2 - i)) - modifierHolder.totalLength();
        if (i3 <= 0) {
            return modifierHolder.applyAll(numberStringBuilder, i, i2);
        }
        int i4 = 0;
        if (this.paddingLocation == PadPosition.AFTER_PREFIX) {
            i4 = addPadding(i3, numberStringBuilder, i) + 0;
        } else if (this.paddingLocation == PadPosition.BEFORE_SUFFIX) {
            i4 = addPadding(i3, numberStringBuilder, i2) + 0;
        }
        int applyAll = i4 + modifierHolder.applyAll(numberStringBuilder, i, i2 + i4);
        if (this.paddingLocation == PadPosition.BEFORE_PREFIX) {
            return applyAll + addPadding(i3, numberStringBuilder, i);
        }
        if (this.paddingLocation == PadPosition.AFTER_SUFFIX) {
            return applyAll + addPadding(i3, numberStringBuilder, i2 + applyAll);
        }
        return applyAll;
    }

    private int addPadding(int i, NumberStringBuilder numberStringBuilder, int i2) {
        for (int i3 = 0; i3 < i; i3++) {
            numberStringBuilder.insert(i2, this.paddingString, (NumberFormat.Field) null);
        }
        return this.paddingString.length() * i;
    }

    @Override // com.ibm.icu.impl.number.Exportable
    public void export(Properties properties) {
        properties.setFormatWidth(this.paddingWidth);
        properties.setPadString(this.paddingString);
        properties.setPadPosition(this.paddingLocation);
    }
}

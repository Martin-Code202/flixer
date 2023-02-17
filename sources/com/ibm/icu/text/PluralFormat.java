package com.ibm.icu.text;

import com.ibm.icu.impl.Utility;
import com.ibm.icu.text.MessagePattern;
import com.ibm.icu.text.PluralRules;
import com.ibm.icu.util.ULocale;
import java.io.ObjectInputStream;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Map;
public class PluralFormat extends UFormat {
    static final /* synthetic */ boolean $assertionsDisabled = (!PluralFormat.class.desiredAssertionStatus());
    private static final long serialVersionUID = 1;
    private transient MessagePattern msgPattern;
    private NumberFormat numberFormat = null;
    private transient double offset = 0.0d;
    private Map<String, String> parsedValues = null;
    private String pattern = null;
    private PluralRules pluralRules = null;
    private transient PluralSelectorAdapter pluralRulesWrapper = new PluralSelectorAdapter();
    private ULocale ulocale = null;

    /* access modifiers changed from: package-private */
    public interface PluralSelector {
        String select(Object obj, double d);
    }

    public PluralFormat() {
        init(null, PluralRules.PluralType.CARDINAL, ULocale.getDefault(ULocale.Category.FORMAT), null);
    }

    PluralFormat(ULocale uLocale, PluralRules.PluralType pluralType, String str, NumberFormat numberFormat2) {
        init(null, pluralType, uLocale, numberFormat2);
        applyPattern(str);
    }

    private void init(PluralRules pluralRules2, PluralRules.PluralType pluralType, ULocale uLocale, NumberFormat numberFormat2) {
        this.ulocale = uLocale;
        this.pluralRules = pluralRules2 == null ? PluralRules.forLocale(this.ulocale, pluralType) : pluralRules2;
        resetPattern();
        this.numberFormat = numberFormat2 == null ? NumberFormat.getInstance(this.ulocale) : numberFormat2;
    }

    private void resetPattern() {
        this.pattern = null;
        if (this.msgPattern != null) {
            this.msgPattern.clear();
        }
        this.offset = 0.0d;
    }

    public void applyPattern(String str) {
        this.pattern = str;
        if (this.msgPattern == null) {
            this.msgPattern = new MessagePattern();
        }
        try {
            this.msgPattern.parsePluralStyle(str);
            this.offset = this.msgPattern.getPluralOffset(0);
        } catch (RuntimeException e) {
            resetPattern();
            throw e;
        }
    }

    static int findSubMessage(MessagePattern messagePattern, int i, PluralSelector pluralSelector, Object obj, double d) {
        double d2;
        int countParts = messagePattern.countParts();
        MessagePattern.Part part = messagePattern.getPart(i);
        if (part.getType().hasNumericValue()) {
            d2 = messagePattern.getNumericValue(part);
            i++;
        } else {
            d2 = 0.0d;
        }
        String str = null;
        boolean z = false;
        int i2 = 0;
        do {
            int i3 = i + 1;
            MessagePattern.Part part2 = messagePattern.getPart(i);
            MessagePattern.Part.Type type = part2.getType();
            if (type == MessagePattern.Part.Type.ARG_LIMIT) {
                break;
            } else if ($assertionsDisabled || type == MessagePattern.Part.Type.ARG_SELECTOR) {
                if (messagePattern.getPartType(i3).hasNumericValue()) {
                    i3++;
                    if (d == messagePattern.getNumericValue(messagePattern.getPart(i3))) {
                        return i3;
                    }
                } else if (!z) {
                    if (!messagePattern.partSubstringMatches(part2, "other")) {
                        if (str == null) {
                            str = pluralSelector.select(obj, d - d2);
                            if (i2 != 0 && str.equals("other")) {
                                z = true;
                            }
                        }
                        if (!z && messagePattern.partSubstringMatches(part2, str)) {
                            i2 = i3;
                            z = true;
                        }
                    } else if (i2 == 0) {
                        i2 = i3;
                        if (str != null && str.equals("other")) {
                            z = true;
                        }
                    }
                }
                i = messagePattern.getLimitPartIndex(i3) + 1;
            } else {
                throw new AssertionError();
            }
        } while (i < countParts);
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final class PluralSelectorAdapter implements PluralSelector {
        static final /* synthetic */ boolean $assertionsDisabled = (!PluralFormat.class.desiredAssertionStatus());

        private PluralSelectorAdapter() {
        }

        @Override // com.ibm.icu.text.PluralFormat.PluralSelector
        public String select(Object obj, double d) {
            PluralRules.IFixedDecimal iFixedDecimal = (PluralRules.IFixedDecimal) obj;
            if ($assertionsDisabled || iFixedDecimal.getPluralOperand(PluralRules.Operand.n) == Math.abs(d)) {
                return PluralFormat.this.pluralRules.select(iFixedDecimal);
            }
            throw new AssertionError();
        }
    }

    public final String format(double d) {
        return format(Double.valueOf(d), d);
    }

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (!(obj instanceof Number)) {
            throw new IllegalArgumentException("'" + obj + "' is not a Number");
        }
        Number number = (Number) obj;
        stringBuffer.append(format(number, number.doubleValue()));
        return stringBuffer;
    }

    private String format(Number number, double d) {
        String str;
        PluralRules.IFixedDecimal iFixedDecimal;
        int index;
        if (this.msgPattern == null || this.msgPattern.countParts() == 0) {
            return this.numberFormat.format(number);
        }
        double d2 = d - this.offset;
        if (this.offset == 0.0d) {
            str = this.numberFormat.format(number);
        } else {
            str = this.numberFormat.format(d2);
        }
        if (this.numberFormat instanceof DecimalFormat) {
            iFixedDecimal = ((DecimalFormat) this.numberFormat).getFixedDecimal(d2);
        } else {
            iFixedDecimal = new PluralRules.FixedDecimal(d2);
        }
        int findSubMessage = findSubMessage(this.msgPattern, 0, this.pluralRulesWrapper, iFixedDecimal, d);
        StringBuilder sb = null;
        int limit = this.msgPattern.getPart(findSubMessage).getLimit();
        while (true) {
            findSubMessage++;
            MessagePattern.Part part = this.msgPattern.getPart(findSubMessage);
            MessagePattern.Part.Type type = part.getType();
            index = part.getIndex();
            if (type == MessagePattern.Part.Type.MSG_LIMIT) {
                break;
            } else if (type == MessagePattern.Part.Type.REPLACE_NUMBER || (type == MessagePattern.Part.Type.SKIP_SYNTAX && this.msgPattern.jdkAposMode())) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append((CharSequence) this.pattern, limit, index);
                if (type == MessagePattern.Part.Type.REPLACE_NUMBER) {
                    sb.append(str);
                }
                limit = part.getLimit();
            } else if (type == MessagePattern.Part.Type.ARG_START) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append((CharSequence) this.pattern, limit, index);
                findSubMessage = this.msgPattern.getLimitPartIndex(findSubMessage);
                int limit2 = this.msgPattern.getPart(findSubMessage).getLimit();
                MessagePattern.appendReducedApostrophes(this.pattern, index, limit2, sb);
                limit = limit2;
            }
        }
        if (sb == null) {
            return this.pattern.substring(limit, index);
        }
        return sb.append((CharSequence) this.pattern, limit, index).toString();
    }

    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public String parseType(String str, RbnfLenientScanner rbnfLenientScanner, FieldPosition fieldPosition) {
        int i;
        if (this.msgPattern == null || this.msgPattern.countParts() == 0) {
            fieldPosition.setBeginIndex(-1);
            fieldPosition.setEndIndex(-1);
            return null;
        }
        int i2 = 0;
        int countParts = this.msgPattern.countParts();
        int beginIndex = fieldPosition.getBeginIndex();
        if (beginIndex < 0) {
            beginIndex = 0;
        }
        String str2 = null;
        String str3 = null;
        int i3 = -1;
        while (i2 < countParts) {
            i2++;
            if (this.msgPattern.getPart(i2).getType() == MessagePattern.Part.Type.ARG_SELECTOR) {
                i2++;
                MessagePattern.Part part = this.msgPattern.getPart(i2);
                if (part.getType() == MessagePattern.Part.Type.MSG_START) {
                    i2++;
                    MessagePattern.Part part2 = this.msgPattern.getPart(i2);
                    if (part2.getType() == MessagePattern.Part.Type.MSG_LIMIT) {
                        String substring = this.pattern.substring(part.getLimit(), part2.getIndex());
                        if (rbnfLenientScanner != null) {
                            i = rbnfLenientScanner.findText(str, substring, beginIndex)[0];
                        } else {
                            i = str.indexOf(substring, beginIndex);
                        }
                        if (i >= 0 && i >= i3) {
                            if (str3 == null || substring.length() > str3.length()) {
                                i3 = i;
                                str3 = substring;
                                str2 = this.pattern.substring(part.getLimit(), part2.getIndex());
                            }
                        }
                    }
                }
            }
        }
        if (str2 != null) {
            fieldPosition.setBeginIndex(i3);
            fieldPosition.setEndIndex(str3.length() + i3);
            return str2;
        }
        fieldPosition.setBeginIndex(-1);
        fieldPosition.setEndIndex(-1);
        return null;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PluralFormat pluralFormat = (PluralFormat) obj;
        return Utility.objectEquals(this.ulocale, pluralFormat.ulocale) && Utility.objectEquals(this.pluralRules, pluralFormat.pluralRules) && Utility.objectEquals(this.msgPattern, pluralFormat.msgPattern) && Utility.objectEquals(this.numberFormat, pluralFormat.numberFormat);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.pluralRules.hashCode() ^ this.parsedValues.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("locale=" + this.ulocale);
        sb.append(", rules='" + this.pluralRules + "'");
        sb.append(", pattern='" + this.pattern + "'");
        sb.append(", format='" + this.numberFormat + "'");
        return sb.toString();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.pluralRulesWrapper = new PluralSelectorAdapter();
        this.parsedValues = null;
        if (this.pattern != null) {
            applyPattern(this.pattern);
        }
    }
}

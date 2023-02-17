package com.ibm.icu.text;

import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.text.MessagePattern;
import com.ibm.icu.text.PluralFormat;
import com.ibm.icu.text.PluralRules;
import com.ibm.icu.util.ICUUncheckedIOException;
import com.ibm.icu.util.ULocale;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.text.CharacterIterator;
import java.text.ChoiceFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
public class MessageFormat extends UFormat {
    static final /* synthetic */ boolean $assertionsDisabled = (!MessageFormat.class.desiredAssertionStatus());
    private static final String[] dateModifierList = {"", "short", "medium", "long", "full"};
    private static final String[] modifierList = {"", "currency", "percent", "integer"};
    private static final Locale rootLocale = new Locale("");
    static final long serialVersionUID = 7136212545847378652L;
    private static final String[] typeList = {"number", "date", "time", "spellout", "ordinal", SessionEndedEvent.DURATION};
    private transient Map<Integer, Format> cachedFormatters;
    private transient Set<Integer> customFormatArgStarts;
    private transient MessagePattern msgPattern;
    private transient PluralSelectorProvider ordinalProvider;
    private transient PluralSelectorProvider pluralProvider;
    private transient DateFormat stockDateFormatter;
    private transient NumberFormat stockNumberFormatter;
    private transient ULocale ulocale;

    public MessageFormat(String str) {
        this.ulocale = ULocale.getDefault(ULocale.Category.FORMAT);
        applyPattern(str);
    }

    public MessageFormat(String str, ULocale uLocale) {
        this.ulocale = uLocale;
        applyPattern(str);
    }

    public void applyPattern(String str) {
        try {
            if (this.msgPattern == null) {
                this.msgPattern = new MessagePattern(str);
            } else {
                this.msgPattern.parse(str);
            }
            cacheExplicitFormats();
        } catch (RuntimeException e) {
            resetPattern();
            throw e;
        }
    }

    public void applyPattern(String str, MessagePattern.ApostropheMode apostropheMode) {
        if (this.msgPattern == null) {
            this.msgPattern = new MessagePattern(apostropheMode);
        } else if (apostropheMode != this.msgPattern.getApostropheMode()) {
            this.msgPattern.clearPatternAndSetApostropheMode(apostropheMode);
        }
        applyPattern(str);
    }

    private int nextTopLevelArgStart(int i) {
        MessagePattern.Part.Type partType;
        if (i != 0) {
            i = this.msgPattern.getLimitPartIndex(i);
        }
        do {
            i++;
            partType = this.msgPattern.getPartType(i);
            if (partType == MessagePattern.Part.Type.ARG_START) {
                return i;
            }
        } while (partType != MessagePattern.Part.Type.MSG_LIMIT);
        return -1;
    }

    public void setFormatByArgumentIndex(int i, Format format) {
        if (this.msgPattern.hasNamedArguments()) {
            throw new IllegalArgumentException("This method is not available in MessageFormat objects that use alphanumeric argument names.");
        }
        int i2 = 0;
        while (true) {
            int nextTopLevelArgStart = nextTopLevelArgStart(i2);
            i2 = nextTopLevelArgStart;
            if (nextTopLevelArgStart < 0) {
                return;
            }
            if (this.msgPattern.getPart(i2 + 1).getValue() == i) {
                setCustomArgStartFormat(i2, format);
            }
        }
    }

    public void setFormat(int i, Format format) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int nextTopLevelArgStart = nextTopLevelArgStart(i3);
            i3 = nextTopLevelArgStart;
            if (nextTopLevelArgStart < 0) {
                throw new ArrayIndexOutOfBoundsException(i);
            } else if (i2 == i) {
                setCustomArgStartFormat(i3, format);
                return;
            } else {
                i2++;
            }
        }
    }

    public final StringBuffer format(Object[] objArr, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        format(objArr, null, new AppendableWrapper(stringBuffer), fieldPosition);
        return stringBuffer;
    }

    @Override // java.text.Format
    public final StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        format(obj, new AppendableWrapper(stringBuffer), fieldPosition);
        return stringBuffer;
    }

    @Override // java.text.Format
    public AttributedCharacterIterator formatToCharacterIterator(Object obj) {
        if (obj == null) {
            throw new NullPointerException("formatToCharacterIterator must be passed non-null object");
        }
        StringBuilder sb = new StringBuilder();
        AppendableWrapper appendableWrapper = new AppendableWrapper(sb);
        appendableWrapper.useAttributes();
        format(obj, appendableWrapper, (FieldPosition) null);
        AttributedString attributedString = new AttributedString(sb.toString());
        for (AttributeAndPosition attributeAndPosition : appendableWrapper.attributes) {
            attributedString.addAttribute(attributeAndPosition.key, attributeAndPosition.value, attributeAndPosition.start, attributeAndPosition.limit);
        }
        return attributedString.getIterator();
    }

    public Object[] parse(String str, ParsePosition parsePosition) {
        if (this.msgPattern.hasNamedArguments()) {
            throw new IllegalArgumentException("This method is not available in MessageFormat objects that use named argument.");
        }
        int i = -1;
        int i2 = 0;
        while (true) {
            int nextTopLevelArgStart = nextTopLevelArgStart(i2);
            i2 = nextTopLevelArgStart;
            if (nextTopLevelArgStart < 0) {
                break;
            }
            int value = this.msgPattern.getPart(i2 + 1).getValue();
            if (value > i) {
                i = value;
            }
        }
        Object[] objArr = new Object[(i + 1)];
        int index = parsePosition.getIndex();
        parse(0, str, parsePosition, objArr, null);
        if (parsePosition.getIndex() == index) {
            return null;
        }
        return objArr;
    }

    public Map<String, Object> parseToMap(String str, ParsePosition parsePosition) {
        HashMap hashMap = new HashMap();
        int index = parsePosition.getIndex();
        parse(0, str, parsePosition, null, hashMap);
        if (parsePosition.getIndex() == index) {
            return null;
        }
        return hashMap;
    }

    private void parse(int i, String str, ParsePosition parsePosition, Object[] objArr, Map<String, Object> map) {
        Object obj;
        int i2;
        Format format;
        if (str != null) {
            String patternString = this.msgPattern.getPatternString();
            int limit = this.msgPattern.getPart(i).getLimit();
            int index = parsePosition.getIndex();
            ParsePosition parsePosition2 = new ParsePosition(0);
            int i3 = i + 1;
            while (true) {
                MessagePattern.Part part = this.msgPattern.getPart(i3);
                MessagePattern.Part.Type type = part.getType();
                int index2 = part.getIndex() - limit;
                if (index2 == 0 || patternString.regionMatches(limit, str, index, index2)) {
                    index += index2;
                    int i4 = limit + index2;
                    if (type == MessagePattern.Part.Type.MSG_LIMIT) {
                        parsePosition.setIndex(index);
                        return;
                    }
                    if (type == MessagePattern.Part.Type.SKIP_SYNTAX || type == MessagePattern.Part.Type.INSERT_CHAR) {
                        limit = part.getLimit();
                    } else if ($assertionsDisabled || type == MessagePattern.Part.Type.ARG_START) {
                        int limitPartIndex = this.msgPattern.getLimitPartIndex(i3);
                        MessagePattern.ArgType argType = part.getArgType();
                        int i5 = i3 + 1;
                        MessagePattern.Part part2 = this.msgPattern.getPart(i5);
                        int i6 = 0;
                        String str2 = null;
                        if (objArr != null) {
                            i6 = part2.getValue();
                            obj = Integer.valueOf(i6);
                        } else {
                            if (part2.getType() == MessagePattern.Part.Type.ARG_NAME) {
                                str2 = this.msgPattern.getSubstring(part2);
                            } else {
                                str2 = Integer.toString(part2.getValue());
                            }
                            obj = str2;
                        }
                        int i7 = i5 + 1;
                        boolean z = false;
                        Object obj2 = null;
                        if (this.cachedFormatters != null && (format = this.cachedFormatters.get(Integer.valueOf(i7 - 2))) != null) {
                            parsePosition2.setIndex(index);
                            obj2 = format.parseObject(str, parsePosition2);
                            if (parsePosition2.getIndex() == index) {
                                parsePosition.setErrorIndex(index);
                                return;
                            } else {
                                z = true;
                                index = parsePosition2.getIndex();
                            }
                        } else if (argType == MessagePattern.ArgType.NONE || (this.cachedFormatters != null && this.cachedFormatters.containsKey(Integer.valueOf(i7 - 2)))) {
                            String literalStringUntilNextArgument = getLiteralStringUntilNextArgument(limitPartIndex);
                            if (literalStringUntilNextArgument.length() != 0) {
                                i2 = str.indexOf(literalStringUntilNextArgument, index);
                            } else {
                                i2 = str.length();
                            }
                            if (i2 < 0) {
                                parsePosition.setErrorIndex(index);
                                return;
                            }
                            String substring = str.substring(index, i2);
                            if (!substring.equals("{" + obj.toString() + "}")) {
                                z = true;
                                obj2 = substring;
                            }
                            index = i2;
                        } else if (argType == MessagePattern.ArgType.CHOICE) {
                            parsePosition2.setIndex(index);
                            double parseChoiceArgument = parseChoiceArgument(this.msgPattern, i7, str, parsePosition2);
                            if (parsePosition2.getIndex() == index) {
                                parsePosition.setErrorIndex(index);
                                return;
                            }
                            obj2 = Double.valueOf(parseChoiceArgument);
                            z = true;
                            index = parsePosition2.getIndex();
                        } else if (argType.hasPluralStyle() || argType == MessagePattern.ArgType.SELECT) {
                            throw new UnsupportedOperationException("Parsing of plural/select/selectordinal argument is not supported.");
                        } else {
                            throw new IllegalStateException("unexpected argType " + argType);
                        }
                        if (z) {
                            if (objArr != null) {
                                objArr[i6] = obj2;
                            } else if (map != null) {
                                map.put(str2, obj2);
                            }
                        }
                        limit = this.msgPattern.getPart(limitPartIndex).getLimit();
                        i3 = limitPartIndex;
                    } else {
                        throw new AssertionError("Unexpected Part " + part + " in parsed message.");
                    }
                    i3++;
                } else {
                    parsePosition.setErrorIndex(index);
                    return;
                }
            }
        }
    }

    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        if (!this.msgPattern.hasNamedArguments()) {
            return parse(str, parsePosition);
        }
        return parseToMap(str, parsePosition);
    }

    @Override // java.text.Format, java.lang.Object
    public Object clone() {
        DateFormat dateFormat;
        NumberFormat numberFormat;
        MessageFormat messageFormat = (MessageFormat) super.clone();
        if (this.customFormatArgStarts != null) {
            messageFormat.customFormatArgStarts = new HashSet();
            for (Integer num : this.customFormatArgStarts) {
                messageFormat.customFormatArgStarts.add(num);
            }
        } else {
            messageFormat.customFormatArgStarts = null;
        }
        if (this.cachedFormatters != null) {
            messageFormat.cachedFormatters = new HashMap();
            for (Map.Entry<Integer, Format> entry : this.cachedFormatters.entrySet()) {
                messageFormat.cachedFormatters.put(entry.getKey(), entry.getValue());
            }
        } else {
            messageFormat.cachedFormatters = null;
        }
        messageFormat.msgPattern = this.msgPattern == null ? null : (MessagePattern) this.msgPattern.clone();
        if (this.stockDateFormatter == null) {
            dateFormat = null;
        } else {
            dateFormat = (DateFormat) this.stockDateFormatter.clone();
        }
        messageFormat.stockDateFormatter = dateFormat;
        if (this.stockNumberFormatter == null) {
            numberFormat = null;
        } else {
            numberFormat = (NumberFormat) this.stockNumberFormatter.clone();
        }
        messageFormat.stockNumberFormatter = numberFormat;
        messageFormat.pluralProvider = null;
        messageFormat.ordinalProvider = null;
        return messageFormat;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MessageFormat messageFormat = (MessageFormat) obj;
        return Utility.objectEquals(this.ulocale, messageFormat.ulocale) && Utility.objectEquals(this.msgPattern, messageFormat.msgPattern) && Utility.objectEquals(this.cachedFormatters, messageFormat.cachedFormatters) && Utility.objectEquals(this.customFormatArgStarts, messageFormat.customFormatArgStarts);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.msgPattern.getPatternString().hashCode();
    }

    public static class Field extends Format.Field {
        public static final Field ARGUMENT = new Field("message argument field");
        private static final long serialVersionUID = 7510380454602616157L;

        protected Field(String str) {
            super(str);
        }

        /* access modifiers changed from: protected */
        @Override // java.text.AttributedCharacterIterator.Attribute
        public Object readResolve() {
            if (getClass() != Field.class) {
                throw new InvalidObjectException("A subclass of MessageFormat.Field must implement readResolve.");
            } else if (getName().equals(ARGUMENT.getName())) {
                return ARGUMENT;
            } else {
                throw new InvalidObjectException("Unknown attribute name.");
            }
        }
    }

    private DateFormat getStockDateFormatter() {
        if (this.stockDateFormatter == null) {
            this.stockDateFormatter = DateFormat.getDateTimeInstance(3, 3, this.ulocale);
        }
        return this.stockDateFormatter;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private NumberFormat getStockNumberFormatter() {
        if (this.stockNumberFormatter == null) {
            this.stockNumberFormatter = NumberFormat.getInstance(this.ulocale);
        }
        return this.stockNumberFormatter;
    }

    private void format(int i, PluralSelectorContext pluralSelectorContext, Object[] objArr, Map<String, Object> map, AppendableWrapper appendableWrapper, FieldPosition fieldPosition) {
        String str;
        Object obj;
        PluralSelectorProvider pluralSelectorProvider;
        Format format;
        CharSequence patternString = this.msgPattern.getPatternString();
        int limit = this.msgPattern.getPart(i).getLimit();
        int i2 = i + 1;
        while (true) {
            MessagePattern.Part part = this.msgPattern.getPart(i2);
            MessagePattern.Part.Type type = part.getType();
            appendableWrapper.append(patternString, limit, part.getIndex());
            if (type != MessagePattern.Part.Type.MSG_LIMIT) {
                limit = part.getLimit();
                if (type == MessagePattern.Part.Type.REPLACE_NUMBER) {
                    if (pluralSelectorContext.forReplaceNumber) {
                        appendableWrapper.formatAndAppend(pluralSelectorContext.formatter, pluralSelectorContext.number, pluralSelectorContext.numberString);
                    } else {
                        appendableWrapper.formatAndAppend(getStockNumberFormatter(), pluralSelectorContext.number);
                    }
                } else if (type != MessagePattern.Part.Type.ARG_START) {
                    continue;
                } else {
                    int limitPartIndex = this.msgPattern.getLimitPartIndex(i2);
                    MessagePattern.ArgType argType = part.getArgType();
                    int i3 = i2 + 1;
                    MessagePattern.Part part2 = this.msgPattern.getPart(i3);
                    boolean z = false;
                    Integer num = null;
                    String substring = this.msgPattern.getSubstring(part2);
                    if (objArr != null) {
                        int value = part2.getValue();
                        if (appendableWrapper.attributes != null) {
                            num = Integer.valueOf(value);
                        }
                        if (0 > value || value >= objArr.length) {
                            obj = null;
                            z = true;
                            str = num;
                        } else {
                            obj = objArr[value];
                            str = num;
                        }
                    } else {
                        String str2 = substring;
                        if (map == null || !map.containsKey(substring)) {
                            obj = null;
                            z = true;
                            str = str2;
                        } else {
                            obj = map.get(substring);
                            str = str2;
                        }
                    }
                    int i4 = i3 + 1;
                    int i5 = appendableWrapper.length;
                    if (z) {
                        appendableWrapper.append("{" + substring + "}");
                    } else if (obj == null) {
                        appendableWrapper.append("null");
                    } else if (pluralSelectorContext == null || pluralSelectorContext.numberArgIndex != i4 - 2) {
                        if (this.cachedFormatters == null || (format = this.cachedFormatters.get(Integer.valueOf(i4 - 2))) == null) {
                            if (argType == MessagePattern.ArgType.NONE || (this.cachedFormatters != null && this.cachedFormatters.containsKey(Integer.valueOf(i4 - 2)))) {
                                if (obj instanceof Number) {
                                    appendableWrapper.formatAndAppend(getStockNumberFormatter(), obj);
                                } else if (obj instanceof Date) {
                                    appendableWrapper.formatAndAppend(getStockDateFormatter(), obj);
                                } else {
                                    appendableWrapper.append(obj.toString());
                                }
                            } else if (argType == MessagePattern.ArgType.CHOICE) {
                                if (!(obj instanceof Number)) {
                                    throw new IllegalArgumentException("'" + obj + "' is not a Number");
                                }
                                formatComplexSubMessage(findChoiceSubMessage(this.msgPattern, i4, ((Number) obj).doubleValue()), null, objArr, map, appendableWrapper);
                            } else if (argType.hasPluralStyle()) {
                                if (!(obj instanceof Number)) {
                                    throw new IllegalArgumentException("'" + obj + "' is not a Number");
                                }
                                if (argType == MessagePattern.ArgType.PLURAL) {
                                    if (this.pluralProvider == null) {
                                        this.pluralProvider = new PluralSelectorProvider(this, PluralRules.PluralType.CARDINAL);
                                    }
                                    pluralSelectorProvider = this.pluralProvider;
                                } else {
                                    if (this.ordinalProvider == null) {
                                        this.ordinalProvider = new PluralSelectorProvider(this, PluralRules.PluralType.ORDINAL);
                                    }
                                    pluralSelectorProvider = this.ordinalProvider;
                                }
                                Number number = (Number) obj;
                                PluralSelectorContext pluralSelectorContext2 = new PluralSelectorContext(i4, substring, number, this.msgPattern.getPluralOffset(i4));
                                formatComplexSubMessage(PluralFormat.findSubMessage(this.msgPattern, i4, pluralSelectorProvider, pluralSelectorContext2, number.doubleValue()), pluralSelectorContext2, objArr, map, appendableWrapper);
                            } else if (argType == MessagePattern.ArgType.SELECT) {
                                formatComplexSubMessage(SelectFormat.findSubMessage(this.msgPattern, i4, obj.toString()), null, objArr, map, appendableWrapper);
                            } else {
                                throw new IllegalStateException("unexpected argType " + argType);
                            }
                        } else if ((format instanceof ChoiceFormat) || (format instanceof PluralFormat) || (format instanceof SelectFormat)) {
                            String format2 = format.format(obj);
                            if (format2.indexOf(123) >= 0 || (format2.indexOf(39) >= 0 && !this.msgPattern.jdkAposMode())) {
                                new MessageFormat(format2, this.ulocale).format(0, null, objArr, map, appendableWrapper, null);
                            } else if (appendableWrapper.attributes == null) {
                                appendableWrapper.append(format2);
                            } else {
                                appendableWrapper.formatAndAppend(format, obj);
                            }
                        } else {
                            appendableWrapper.formatAndAppend(format, obj);
                        }
                    } else if (pluralSelectorContext.offset == 0.0d) {
                        appendableWrapper.formatAndAppend(pluralSelectorContext.formatter, pluralSelectorContext.number, pluralSelectorContext.numberString);
                    } else {
                        appendableWrapper.formatAndAppend(pluralSelectorContext.formatter, obj);
                    }
                    fieldPosition = updateMetaData(appendableWrapper, i5, fieldPosition, str);
                    limit = this.msgPattern.getPart(limitPartIndex).getLimit();
                    i2 = limitPartIndex;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    private void formatComplexSubMessage(int i, PluralSelectorContext pluralSelectorContext, Object[] objArr, Map<String, Object> map, AppendableWrapper appendableWrapper) {
        int index;
        String str;
        if (!this.msgPattern.jdkAposMode()) {
            format(i, pluralSelectorContext, objArr, map, appendableWrapper, null);
            return;
        }
        String patternString = this.msgPattern.getPatternString();
        StringBuilder sb = null;
        int limit = this.msgPattern.getPart(i).getLimit();
        int i2 = i;
        while (true) {
            i2++;
            MessagePattern.Part part = this.msgPattern.getPart(i2);
            MessagePattern.Part.Type type = part.getType();
            index = part.getIndex();
            if (type == MessagePattern.Part.Type.MSG_LIMIT) {
                break;
            } else if (type == MessagePattern.Part.Type.REPLACE_NUMBER || type == MessagePattern.Part.Type.SKIP_SYNTAX) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append((CharSequence) patternString, limit, index);
                if (type == MessagePattern.Part.Type.REPLACE_NUMBER) {
                    if (pluralSelectorContext.forReplaceNumber) {
                        sb.append(pluralSelectorContext.numberString);
                    } else {
                        sb.append(getStockNumberFormatter().format(pluralSelectorContext.number));
                    }
                }
                limit = part.getLimit();
            } else if (type == MessagePattern.Part.Type.ARG_START) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append((CharSequence) patternString, limit, index);
                i2 = this.msgPattern.getLimitPartIndex(i2);
                int limit2 = this.msgPattern.getPart(i2).getLimit();
                MessagePattern.appendReducedApostrophes(patternString, index, limit2, sb);
                limit = limit2;
            }
        }
        if (sb == null) {
            str = patternString.substring(limit, index);
        } else {
            str = sb.append((CharSequence) patternString, limit, index).toString();
        }
        if (str.indexOf(123) >= 0) {
            MessageFormat messageFormat = new MessageFormat("", this.ulocale);
            messageFormat.applyPattern(str, MessagePattern.ApostropheMode.DOUBLE_REQUIRED);
            messageFormat.format(0, null, objArr, map, appendableWrapper, null);
            return;
        }
        appendableWrapper.append(str);
    }

    private String getLiteralStringUntilNextArgument(int i) {
        StringBuilder sb = new StringBuilder();
        String patternString = this.msgPattern.getPatternString();
        int limit = this.msgPattern.getPart(i).getLimit();
        int i2 = i + 1;
        while (true) {
            MessagePattern.Part part = this.msgPattern.getPart(i2);
            MessagePattern.Part.Type type = part.getType();
            sb.append((CharSequence) patternString, limit, part.getIndex());
            if (type == MessagePattern.Part.Type.ARG_START || type == MessagePattern.Part.Type.MSG_LIMIT) {
                break;
            } else if ($assertionsDisabled || type == MessagePattern.Part.Type.SKIP_SYNTAX || type == MessagePattern.Part.Type.INSERT_CHAR) {
                limit = part.getLimit();
                i2++;
            } else {
                throw new AssertionError("Unexpected Part " + part + " in parsed message.");
            }
        }
        return sb.toString();
    }

    private FieldPosition updateMetaData(AppendableWrapper appendableWrapper, int i, FieldPosition fieldPosition, Object obj) {
        if (appendableWrapper.attributes != null && i < appendableWrapper.length) {
            appendableWrapper.attributes.add(new AttributeAndPosition(obj, i, appendableWrapper.length));
        }
        if (fieldPosition == null || !Field.ARGUMENT.equals(fieldPosition.getFieldAttribute())) {
            return fieldPosition;
        }
        fieldPosition.setBeginIndex(i);
        fieldPosition.setEndIndex(appendableWrapper.length);
        return null;
    }

    private static int findChoiceSubMessage(MessagePattern messagePattern, int i, double d) {
        int countParts = messagePattern.countParts();
        int i2 = i + 2;
        while (true) {
            int limitPartIndex = messagePattern.getLimitPartIndex(i2) + 1;
            if (limitPartIndex < countParts) {
                int i3 = limitPartIndex + 1;
                MessagePattern.Part part = messagePattern.getPart(limitPartIndex);
                MessagePattern.Part.Type type = part.getType();
                if (type == MessagePattern.Part.Type.ARG_LIMIT) {
                    break;
                } else if ($assertionsDisabled || type.hasNumericValue()) {
                    double numericValue = messagePattern.getNumericValue(part);
                    i2 = i3 + 1;
                    if (messagePattern.getPatternString().charAt(messagePattern.getPatternIndex(i3)) == '<') {
                        if (d <= numericValue) {
                            break;
                        }
                    } else if (d < numericValue) {
                        break;
                    }
                } else {
                    throw new AssertionError();
                }
            } else {
                break;
            }
        }
        return i2;
    }

    private static double parseChoiceArgument(MessagePattern messagePattern, int i, String str, ParsePosition parsePosition) {
        int i2;
        int index = parsePosition.getIndex();
        int i3 = index;
        double d = Double.NaN;
        while (messagePattern.getPartType(i) != MessagePattern.Part.Type.ARG_LIMIT) {
            double numericValue = messagePattern.getNumericValue(messagePattern.getPart(i));
            int i4 = i + 2;
            int limitPartIndex = messagePattern.getLimitPartIndex(i4);
            int matchStringUntilLimitPart = matchStringUntilLimitPart(messagePattern, i4, limitPartIndex, str, index);
            if (matchStringUntilLimitPart >= 0 && (i2 = index + matchStringUntilLimitPart) > i3) {
                i3 = i2;
                d = numericValue;
                if (i3 == str.length()) {
                    break;
                }
            }
            i = limitPartIndex + 1;
        }
        if (i3 == index) {
            parsePosition.setErrorIndex(index);
        } else {
            parsePosition.setIndex(i3);
        }
        return d;
    }

    private static int matchStringUntilLimitPart(MessagePattern messagePattern, int i, int i2, String str, int i3) {
        int i4 = 0;
        String patternString = messagePattern.getPatternString();
        int limit = messagePattern.getPart(i).getLimit();
        while (true) {
            i++;
            MessagePattern.Part part = messagePattern.getPart(i);
            if (i == i2 || part.getType() == MessagePattern.Part.Type.SKIP_SYNTAX) {
                int index = part.getIndex() - limit;
                if (index != 0 && !str.regionMatches(i3, patternString, limit, index)) {
                    return -1;
                }
                i4 += index;
                if (i == i2) {
                    return i4;
                }
                limit = part.getLimit();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int findOtherSubMessage(int i) {
        int countParts = this.msgPattern.countParts();
        if (this.msgPattern.getPart(i).getType().hasNumericValue()) {
            i++;
        }
        do {
            int i2 = i + 1;
            MessagePattern.Part part = this.msgPattern.getPart(i);
            MessagePattern.Part.Type type = part.getType();
            if (type == MessagePattern.Part.Type.ARG_LIMIT) {
                return 0;
            }
            if (!$assertionsDisabled && type != MessagePattern.Part.Type.ARG_SELECTOR) {
                throw new AssertionError();
            } else if (this.msgPattern.partSubstringMatches(part, "other")) {
                return i2;
            } else {
                if (this.msgPattern.getPartType(i2).hasNumericValue()) {
                    i2++;
                }
                i = this.msgPattern.getLimitPartIndex(i2) + 1;
            }
        } while (i < countParts);
        return 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private int findFirstPluralNumberArg(int i, String str) {
        int i2 = i + 1;
        while (true) {
            MessagePattern.Part part = this.msgPattern.getPart(i2);
            MessagePattern.Part.Type type = part.getType();
            if (type == MessagePattern.Part.Type.MSG_LIMIT) {
                return 0;
            }
            if (type == MessagePattern.Part.Type.REPLACE_NUMBER) {
                return -1;
            }
            if (type == MessagePattern.Part.Type.ARG_START) {
                MessagePattern.ArgType argType = part.getArgType();
                if (str.length() != 0 && (argType == MessagePattern.ArgType.NONE || argType == MessagePattern.ArgType.SIMPLE)) {
                    if (this.msgPattern.partSubstringMatches(this.msgPattern.getPart(i2 + 1), str)) {
                        return i2;
                    }
                }
                i2 = this.msgPattern.getLimitPartIndex(i2);
            }
            i2++;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class PluralSelectorContext {
        String argName;
        boolean forReplaceNumber;
        Format formatter;
        Number number;
        int numberArgIndex;
        String numberString;
        double offset;
        int startIndex;

        private PluralSelectorContext(int i, String str, Number number2, double d) {
            this.startIndex = i;
            this.argName = str;
            if (d == 0.0d) {
                this.number = number2;
            } else {
                this.number = Double.valueOf(number2.doubleValue() - d);
            }
            this.offset = d;
        }

        public String toString() {
            throw new AssertionError("PluralSelectorContext being formatted, rather than its number");
        }
    }

    /* access modifiers changed from: package-private */
    public static final class PluralSelectorProvider implements PluralFormat.PluralSelector {
        static final /* synthetic */ boolean $assertionsDisabled = (!MessageFormat.class.desiredAssertionStatus());
        private MessageFormat msgFormat;
        private PluralRules rules;
        private PluralRules.PluralType type;

        public PluralSelectorProvider(MessageFormat messageFormat, PluralRules.PluralType pluralType) {
            this.msgFormat = messageFormat;
            this.type = pluralType;
        }

        @Override // com.ibm.icu.text.PluralFormat.PluralSelector
        public String select(Object obj, double d) {
            if (this.rules == null) {
                this.rules = PluralRules.forLocale(this.msgFormat.ulocale, this.type);
            }
            PluralSelectorContext pluralSelectorContext = (PluralSelectorContext) obj;
            pluralSelectorContext.numberArgIndex = this.msgFormat.findFirstPluralNumberArg(this.msgFormat.findOtherSubMessage(pluralSelectorContext.startIndex), pluralSelectorContext.argName);
            if (pluralSelectorContext.numberArgIndex > 0 && this.msgFormat.cachedFormatters != null) {
                pluralSelectorContext.formatter = (Format) this.msgFormat.cachedFormatters.get(Integer.valueOf(pluralSelectorContext.numberArgIndex));
            }
            if (pluralSelectorContext.formatter == null) {
                pluralSelectorContext.formatter = this.msgFormat.getStockNumberFormatter();
                pluralSelectorContext.forReplaceNumber = true;
            }
            if ($assertionsDisabled || pluralSelectorContext.number.doubleValue() == d) {
                pluralSelectorContext.numberString = pluralSelectorContext.formatter.format(pluralSelectorContext.number);
                if (!(pluralSelectorContext.formatter instanceof DecimalFormat)) {
                    return this.rules.select(d);
                }
                return this.rules.select(((DecimalFormat) pluralSelectorContext.formatter).getFixedDecimal(d));
            }
            throw new AssertionError();
        }
    }

    private void format(Object obj, AppendableWrapper appendableWrapper, FieldPosition fieldPosition) {
        if (obj == null || (obj instanceof Map)) {
            format(null, (Map) obj, appendableWrapper, fieldPosition);
        } else {
            format((Object[]) obj, null, appendableWrapper, fieldPosition);
        }
    }

    private void format(Object[] objArr, Map<String, Object> map, AppendableWrapper appendableWrapper, FieldPosition fieldPosition) {
        if (objArr == null || !this.msgPattern.hasNamedArguments()) {
            format(0, null, objArr, map, appendableWrapper, fieldPosition);
            return;
        }
        throw new IllegalArgumentException("This method is not available in MessageFormat objects that use alphanumeric argument names.");
    }

    private void resetPattern() {
        if (this.msgPattern != null) {
            this.msgPattern.clear();
        }
        if (this.cachedFormatters != null) {
            this.cachedFormatters.clear();
        }
        this.customFormatArgStarts = null;
    }

    private Format createAppropriateFormat(String str, String str2) {
        switch (findKeyword(str, typeList)) {
            case 0:
                switch (findKeyword(str2, modifierList)) {
                    case 0:
                        return NumberFormat.getInstance(this.ulocale);
                    case 1:
                        return NumberFormat.getCurrencyInstance(this.ulocale);
                    case 2:
                        return NumberFormat.getPercentInstance(this.ulocale);
                    case 3:
                        return NumberFormat.getIntegerInstance(this.ulocale);
                    default:
                        return new DecimalFormat(str2, new DecimalFormatSymbols(this.ulocale));
                }
            case 1:
                switch (findKeyword(str2, dateModifierList)) {
                    case 0:
                        return DateFormat.getDateInstance(2, this.ulocale);
                    case 1:
                        return DateFormat.getDateInstance(3, this.ulocale);
                    case 2:
                        return DateFormat.getDateInstance(2, this.ulocale);
                    case 3:
                        return DateFormat.getDateInstance(1, this.ulocale);
                    case 4:
                        return DateFormat.getDateInstance(0, this.ulocale);
                    default:
                        return new SimpleDateFormat(str2, this.ulocale);
                }
            case 2:
                switch (findKeyword(str2, dateModifierList)) {
                    case 0:
                        return DateFormat.getTimeInstance(2, this.ulocale);
                    case 1:
                        return DateFormat.getTimeInstance(3, this.ulocale);
                    case 2:
                        return DateFormat.getTimeInstance(2, this.ulocale);
                    case 3:
                        return DateFormat.getTimeInstance(1, this.ulocale);
                    case 4:
                        return DateFormat.getTimeInstance(0, this.ulocale);
                    default:
                        return new SimpleDateFormat(str2, this.ulocale);
                }
            case 3:
                RuleBasedNumberFormat ruleBasedNumberFormat = new RuleBasedNumberFormat(this.ulocale, 1);
                String trim = str2.trim();
                if (trim.length() != 0) {
                    try {
                        ruleBasedNumberFormat.setDefaultRuleSet(trim);
                    } catch (Exception e) {
                    }
                }
                return ruleBasedNumberFormat;
            case 4:
                RuleBasedNumberFormat ruleBasedNumberFormat2 = new RuleBasedNumberFormat(this.ulocale, 2);
                String trim2 = str2.trim();
                if (trim2.length() != 0) {
                    try {
                        ruleBasedNumberFormat2.setDefaultRuleSet(trim2);
                    } catch (Exception e2) {
                    }
                }
                return ruleBasedNumberFormat2;
            case 5:
                RuleBasedNumberFormat ruleBasedNumberFormat3 = new RuleBasedNumberFormat(this.ulocale, 3);
                String trim3 = str2.trim();
                if (trim3.length() != 0) {
                    try {
                        ruleBasedNumberFormat3.setDefaultRuleSet(trim3);
                    } catch (Exception e3) {
                    }
                }
                return ruleBasedNumberFormat3;
            default:
                throw new IllegalArgumentException("Unknown format type \"" + str + "\"");
        }
    }

    private static final int findKeyword(String str, String[] strArr) {
        String lowerCase = PatternProps.trimWhiteSpace(str).toLowerCase(rootLocale);
        for (int i = 0; i < strArr.length; i++) {
            if (lowerCase.equals(strArr[i])) {
                return i;
            }
        }
        return -1;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.ulocale.toLanguageTag());
        if (this.msgPattern == null) {
            this.msgPattern = new MessagePattern();
        }
        objectOutputStream.writeObject(this.msgPattern.getApostropheMode());
        objectOutputStream.writeObject(this.msgPattern.getPatternString());
        if (this.customFormatArgStarts != null && !this.customFormatArgStarts.isEmpty()) {
            objectOutputStream.writeInt(this.customFormatArgStarts.size());
            int i = 0;
            int i2 = 0;
            while (true) {
                int nextTopLevelArgStart = nextTopLevelArgStart(i2);
                i2 = nextTopLevelArgStart;
                if (nextTopLevelArgStart < 0) {
                    break;
                }
                if (this.customFormatArgStarts.contains(Integer.valueOf(i2))) {
                    objectOutputStream.writeInt(i);
                    objectOutputStream.writeObject(this.cachedFormatters.get(Integer.valueOf(i2)));
                }
                i++;
            }
        } else {
            objectOutputStream.writeInt(0);
        }
        objectOutputStream.writeInt(0);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.ulocale = ULocale.forLanguageTag((String) objectInputStream.readObject());
        MessagePattern.ApostropheMode apostropheMode = (MessagePattern.ApostropheMode) objectInputStream.readObject();
        if (this.msgPattern == null || apostropheMode != this.msgPattern.getApostropheMode()) {
            this.msgPattern = new MessagePattern(apostropheMode);
        }
        String str = (String) objectInputStream.readObject();
        if (str != null) {
            applyPattern(str);
        }
        for (int readInt = objectInputStream.readInt(); readInt > 0; readInt--) {
            setFormat(objectInputStream.readInt(), (Format) objectInputStream.readObject());
        }
        for (int readInt2 = objectInputStream.readInt(); readInt2 > 0; readInt2--) {
            objectInputStream.readInt();
            objectInputStream.readObject();
        }
    }

    private void cacheExplicitFormats() {
        if (this.cachedFormatters != null) {
            this.cachedFormatters.clear();
        }
        this.customFormatArgStarts = null;
        int countParts = this.msgPattern.countParts() - 2;
        int i = 1;
        while (i < countParts) {
            MessagePattern.Part part = this.msgPattern.getPart(i);
            if (part.getType() == MessagePattern.Part.Type.ARG_START && part.getArgType() == MessagePattern.ArgType.SIMPLE) {
                int i2 = i + 2;
                i = i2 + 1;
                String substring = this.msgPattern.getSubstring(this.msgPattern.getPart(i2));
                String str = "";
                MessagePattern.Part part2 = this.msgPattern.getPart(i);
                if (part2.getType() == MessagePattern.Part.Type.ARG_STYLE) {
                    str = this.msgPattern.getSubstring(part2);
                    i++;
                }
                setArgStartFormat(i, createAppropriateFormat(substring, str));
            }
            i++;
        }
    }

    private void setArgStartFormat(int i, Format format) {
        if (this.cachedFormatters == null) {
            this.cachedFormatters = new HashMap();
        }
        this.cachedFormatters.put(Integer.valueOf(i), format);
    }

    private void setCustomArgStartFormat(int i, Format format) {
        setArgStartFormat(i, format);
        if (this.customFormatArgStarts == null) {
            this.customFormatArgStarts = new HashSet();
        }
        this.customFormatArgStarts.add(Integer.valueOf(i));
    }

    /* access modifiers changed from: package-private */
    public static final class AppendableWrapper {
        private Appendable app;
        private List<AttributeAndPosition> attributes = null;
        private int length;

        public AppendableWrapper(StringBuilder sb) {
            this.app = sb;
            this.length = sb.length();
        }

        public AppendableWrapper(StringBuffer stringBuffer) {
            this.app = stringBuffer;
            this.length = stringBuffer.length();
        }

        public void useAttributes() {
            this.attributes = new ArrayList();
        }

        public void append(CharSequence charSequence) {
            try {
                this.app.append(charSequence);
                this.length += charSequence.length();
            } catch (IOException e) {
                throw new ICUUncheckedIOException(e);
            }
        }

        public void append(CharSequence charSequence, int i, int i2) {
            try {
                this.app.append(charSequence, i, i2);
                this.length += i2 - i;
            } catch (IOException e) {
                throw new ICUUncheckedIOException(e);
            }
        }

        public void append(CharacterIterator characterIterator) {
            this.length += append(this.app, characterIterator);
        }

        public static int append(Appendable appendable, CharacterIterator characterIterator) {
            try {
                int beginIndex = characterIterator.getBeginIndex();
                int endIndex = characterIterator.getEndIndex();
                int i = endIndex - beginIndex;
                if (beginIndex < endIndex) {
                    appendable.append(characterIterator.first());
                    while (true) {
                        beginIndex++;
                        if (beginIndex >= endIndex) {
                            break;
                        }
                        appendable.append(characterIterator.next());
                    }
                }
                return i;
            } catch (IOException e) {
                throw new ICUUncheckedIOException(e);
            }
        }

        public void formatAndAppend(Format format, Object obj) {
            if (this.attributes == null) {
                append(format.format(obj));
                return;
            }
            AttributedCharacterIterator formatToCharacterIterator = format.formatToCharacterIterator(obj);
            int i = this.length;
            append(formatToCharacterIterator);
            formatToCharacterIterator.first();
            int index = formatToCharacterIterator.getIndex();
            int endIndex = formatToCharacterIterator.getEndIndex();
            int i2 = i - index;
            while (index < endIndex) {
                Map<AttributedCharacterIterator.Attribute, Object> attributes2 = formatToCharacterIterator.getAttributes();
                int runLimit = formatToCharacterIterator.getRunLimit();
                if (attributes2.size() != 0) {
                    for (Map.Entry<AttributedCharacterIterator.Attribute, Object> entry : attributes2.entrySet()) {
                        this.attributes.add(new AttributeAndPosition(entry.getKey(), entry.getValue(), i2 + index, i2 + runLimit));
                    }
                }
                index = runLimit;
                formatToCharacterIterator.setIndex(index);
            }
        }

        public void formatAndAppend(Format format, Object obj, String str) {
            if (this.attributes != null || str == null) {
                formatAndAppend(format, obj);
            } else {
                append(str);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class AttributeAndPosition {
        private AttributedCharacterIterator.Attribute key;
        private int limit;
        private int start;
        private Object value;

        public AttributeAndPosition(Object obj, int i, int i2) {
            init(Field.ARGUMENT, obj, i, i2);
        }

        public AttributeAndPosition(AttributedCharacterIterator.Attribute attribute, Object obj, int i, int i2) {
            init(attribute, obj, i, i2);
        }

        public void init(AttributedCharacterIterator.Attribute attribute, Object obj, int i, int i2) {
            this.key = attribute;
            this.value = obj;
            this.start = i;
            this.limit = i2;
        }
    }
}

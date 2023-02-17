package com.ibm.icu.text;

import com.ibm.icu.impl.ICUConfig;
import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.util.Freezable;
import com.ibm.icu.util.ICUCloneNotSupportedException;
import java.util.ArrayList;
public final class MessagePattern implements Cloneable, Freezable<MessagePattern> {
    static final /* synthetic */ boolean $assertionsDisabled = (!MessagePattern.class.desiredAssertionStatus());
    private static final ArgType[] argTypes = ArgType.values();
    private static final ApostropheMode defaultAposMode = ApostropheMode.valueOf(ICUConfig.get("com.ibm.icu.text.MessagePattern.ApostropheMode", "DOUBLE_OPTIONAL"));
    private ApostropheMode aposMode;
    private volatile boolean frozen;
    private boolean hasArgNames;
    private boolean hasArgNumbers;
    private String msg;
    private boolean needsAutoQuoting;
    private ArrayList<Double> numericValues;
    private ArrayList<Part> parts;

    public enum ApostropheMode {
        DOUBLE_OPTIONAL,
        DOUBLE_REQUIRED
    }

    public MessagePattern() {
        this.parts = new ArrayList<>();
        this.aposMode = defaultAposMode;
    }

    public MessagePattern(ApostropheMode apostropheMode) {
        this.parts = new ArrayList<>();
        this.aposMode = apostropheMode;
    }

    public MessagePattern(String str) {
        this.parts = new ArrayList<>();
        this.aposMode = defaultAposMode;
        parse(str);
    }

    public MessagePattern parse(String str) {
        preParse(str);
        parseMessage(0, 0, 0, ArgType.NONE);
        postParse();
        return this;
    }

    public MessagePattern parsePluralStyle(String str) {
        preParse(str);
        parsePluralOrSelectStyle(ArgType.PLURAL, 0, 0);
        postParse();
        return this;
    }

    public MessagePattern parseSelectStyle(String str) {
        preParse(str);
        parsePluralOrSelectStyle(ArgType.SELECT, 0, 0);
        postParse();
        return this;
    }

    public void clear() {
        if (isFrozen()) {
            throw new UnsupportedOperationException("Attempt to clear() a frozen MessagePattern instance.");
        }
        this.msg = null;
        this.hasArgNumbers = false;
        this.hasArgNames = false;
        this.needsAutoQuoting = false;
        this.parts.clear();
        if (this.numericValues != null) {
            this.numericValues.clear();
        }
    }

    public void clearPatternAndSetApostropheMode(ApostropheMode apostropheMode) {
        clear();
        this.aposMode = apostropheMode;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MessagePattern messagePattern = (MessagePattern) obj;
        return this.aposMode.equals(messagePattern.aposMode) && (this.msg != null ? this.msg.equals(messagePattern.msg) : messagePattern.msg == null) && this.parts.equals(messagePattern.parts);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (((this.aposMode.hashCode() * 37) + (this.msg != null ? this.msg.hashCode() : 0)) * 37) + this.parts.hashCode();
    }

    public ApostropheMode getApostropheMode() {
        return this.aposMode;
    }

    /* access modifiers changed from: package-private */
    public boolean jdkAposMode() {
        return this.aposMode == ApostropheMode.DOUBLE_REQUIRED;
    }

    public String getPatternString() {
        return this.msg;
    }

    public boolean hasNamedArguments() {
        return this.hasArgNames;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.msg;
    }

    public int countParts() {
        return this.parts.size();
    }

    public Part getPart(int i) {
        return this.parts.get(i);
    }

    public Part.Type getPartType(int i) {
        return this.parts.get(i).type;
    }

    public int getPatternIndex(int i) {
        return this.parts.get(i).index;
    }

    public String getSubstring(Part part) {
        int i = part.index;
        return this.msg.substring(i, part.length + i);
    }

    public boolean partSubstringMatches(Part part, String str) {
        return part.length == str.length() && this.msg.regionMatches(part.index, str, 0, part.length);
    }

    public double getNumericValue(Part part) {
        Part.Type type = part.type;
        if (type == Part.Type.ARG_INT) {
            return (double) part.value;
        }
        if (type == Part.Type.ARG_DOUBLE) {
            return this.numericValues.get(part.value).doubleValue();
        }
        return -1.23456789E8d;
    }

    public double getPluralOffset(int i) {
        Part part = this.parts.get(i);
        if (part.type.hasNumericValue()) {
            return getNumericValue(part);
        }
        return 0.0d;
    }

    public int getLimitPartIndex(int i) {
        int i2 = this.parts.get(i).limitPartIndex;
        if (i2 < i) {
            return i;
        }
        return i2;
    }

    public static final class Part {
        private final int index;
        private final char length;
        private int limitPartIndex;
        private final Type type;
        private short value;

        private Part(Type type2, int i, int i2, int i3) {
            this.type = type2;
            this.index = i;
            this.length = (char) i2;
            this.value = (short) i3;
        }

        public Type getType() {
            return this.type;
        }

        public int getIndex() {
            return this.index;
        }

        public int getLimit() {
            return this.index + this.length;
        }

        public int getValue() {
            return this.value;
        }

        public ArgType getArgType() {
            Type type2 = getType();
            if (type2 == Type.ARG_START || type2 == Type.ARG_LIMIT) {
                return MessagePattern.argTypes[this.value];
            }
            return ArgType.NONE;
        }

        public enum Type {
            MSG_START,
            MSG_LIMIT,
            SKIP_SYNTAX,
            INSERT_CHAR,
            REPLACE_NUMBER,
            ARG_START,
            ARG_LIMIT,
            ARG_NUMBER,
            ARG_NAME,
            ARG_TYPE,
            ARG_STYLE,
            ARG_SELECTOR,
            ARG_INT,
            ARG_DOUBLE;

            public boolean hasNumericValue() {
                return this == ARG_INT || this == ARG_DOUBLE;
            }
        }

        public String toString() {
            return this.type.name() + "(" + ((this.type == Type.ARG_START || this.type == Type.ARG_LIMIT) ? getArgType().name() : Integer.toString(this.value)) + ")@" + this.index;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Part part = (Part) obj;
            return this.type.equals(part.type) && this.index == part.index && this.length == part.length && this.value == part.value && this.limitPartIndex == part.limitPartIndex;
        }

        public int hashCode() {
            return (((((this.type.hashCode() * 37) + this.index) * 37) + this.length) * 37) + this.value;
        }
    }

    public enum ArgType {
        NONE,
        SIMPLE,
        CHOICE,
        PLURAL,
        SELECT,
        SELECTORDINAL;

        public boolean hasPluralStyle() {
            return this == PLURAL || this == SELECTORDINAL;
        }
    }

    @Override // java.lang.Object
    public Object clone() {
        if (isFrozen()) {
            return this;
        }
        return cloneAsThawed();
    }

    public MessagePattern cloneAsThawed() {
        try {
            MessagePattern messagePattern = (MessagePattern) super.clone();
            messagePattern.parts = (ArrayList) this.parts.clone();
            if (this.numericValues != null) {
                messagePattern.numericValues = (ArrayList) this.numericValues.clone();
            }
            messagePattern.frozen = false;
            return messagePattern;
        } catch (CloneNotSupportedException e) {
            throw new ICUCloneNotSupportedException(e);
        }
    }

    public boolean isFrozen() {
        return this.frozen;
    }

    private void preParse(String str) {
        if (isFrozen()) {
            throw new UnsupportedOperationException("Attempt to parse(" + prefix(str) + ") on frozen MessagePattern instance.");
        }
        this.msg = str;
        this.hasArgNumbers = false;
        this.hasArgNames = false;
        this.needsAutoQuoting = false;
        this.parts.clear();
        if (this.numericValues != null) {
            this.numericValues.clear();
        }
    }

    private void postParse() {
    }

    private int parseMessage(int i, int i2, int i3, ArgType argType) {
        int indexOf;
        if (i3 > 32767) {
            throw new IndexOutOfBoundsException();
        }
        int size = this.parts.size();
        addPart(Part.Type.MSG_START, i, i2, i3);
        int i4 = i + i2;
        while (i4 < this.msg.length()) {
            i4++;
            char charAt = this.msg.charAt(i4);
            if (charAt == '\'') {
                if (i4 == this.msg.length()) {
                    addPart(Part.Type.INSERT_CHAR, i4, 0, 39);
                    this.needsAutoQuoting = true;
                } else {
                    char charAt2 = this.msg.charAt(i4);
                    if (charAt2 == '\'') {
                        i4++;
                        addPart(Part.Type.SKIP_SYNTAX, i4, 1, 0);
                    } else if (this.aposMode == ApostropheMode.DOUBLE_REQUIRED || charAt2 == '{' || charAt2 == '}' || ((argType == ArgType.CHOICE && charAt2 == '|') || (argType.hasPluralStyle() && charAt2 == '#'))) {
                        addPart(Part.Type.SKIP_SYNTAX, i4 - 1, 1, 0);
                        while (true) {
                            indexOf = this.msg.indexOf(39, i4 + 1);
                            if (indexOf < 0) {
                                i4 = this.msg.length();
                                addPart(Part.Type.INSERT_CHAR, i4, 0, 39);
                                this.needsAutoQuoting = true;
                                break;
                            } else if (indexOf + 1 >= this.msg.length() || this.msg.charAt(indexOf + 1) != '\'') {
                                break;
                            } else {
                                i4 = indexOf + 1;
                                addPart(Part.Type.SKIP_SYNTAX, i4, 1, 0);
                            }
                        }
                        i4 = indexOf + 1;
                        addPart(Part.Type.SKIP_SYNTAX, indexOf, 1, 0);
                    } else {
                        addPart(Part.Type.INSERT_CHAR, i4, 0, 39);
                        this.needsAutoQuoting = true;
                    }
                }
            } else if (argType.hasPluralStyle() && charAt == '#') {
                addPart(Part.Type.REPLACE_NUMBER, i4 - 1, 1, 0);
            } else if (charAt == '{') {
                i4 = parseArg(i4 - 1, 1, i3);
            } else if ((i3 > 0 && charAt == '}') || (argType == ArgType.CHOICE && charAt == '|')) {
                addLimitPart(size, Part.Type.MSG_LIMIT, i4 - 1, (argType == ArgType.CHOICE && charAt == '}') ? 0 : 1, i3);
                if (argType == ArgType.CHOICE) {
                    return i4 - 1;
                }
                return i4;
            }
        }
        if (i3 <= 0 || inTopLevelChoiceMessage(i3, argType)) {
            addLimitPart(size, Part.Type.MSG_LIMIT, i4, 0, i3);
            return i4;
        }
        throw new IllegalArgumentException("Unmatched '{' braces in message " + prefix());
    }

    private int parseArg(int i, int i2, int i3) {
        char charAt;
        int size = this.parts.size();
        ArgType argType = ArgType.NONE;
        addPart(Part.Type.ARG_START, i, i2, argType.ordinal());
        int skipWhiteSpace = skipWhiteSpace(i + i2);
        if (skipWhiteSpace == this.msg.length()) {
            throw new IllegalArgumentException("Unmatched '{' braces in message " + prefix());
        }
        int skipIdentifier = skipIdentifier(skipWhiteSpace);
        int parseArgNumber = parseArgNumber(skipWhiteSpace, skipIdentifier);
        if (parseArgNumber >= 0) {
            int i4 = skipIdentifier - skipWhiteSpace;
            if (i4 > 65535 || parseArgNumber > 32767) {
                throw new IndexOutOfBoundsException("Argument number too large: " + prefix(skipWhiteSpace));
            }
            this.hasArgNumbers = true;
            addPart(Part.Type.ARG_NUMBER, skipWhiteSpace, i4, parseArgNumber);
        } else if (parseArgNumber == -1) {
            int i5 = skipIdentifier - skipWhiteSpace;
            if (i5 > 65535) {
                throw new IndexOutOfBoundsException("Argument name too long: " + prefix(skipWhiteSpace));
            }
            this.hasArgNames = true;
            addPart(Part.Type.ARG_NAME, skipWhiteSpace, i5, 0);
        } else {
            throw new IllegalArgumentException("Bad argument syntax: " + prefix(skipWhiteSpace));
        }
        int skipWhiteSpace2 = skipWhiteSpace(skipIdentifier);
        if (skipWhiteSpace2 == this.msg.length()) {
            throw new IllegalArgumentException("Unmatched '{' braces in message " + prefix());
        }
        char charAt2 = this.msg.charAt(skipWhiteSpace2);
        if (charAt2 != '}') {
            if (charAt2 != ',') {
                throw new IllegalArgumentException("Bad argument syntax: " + prefix(skipWhiteSpace));
            }
            int skipWhiteSpace3 = skipWhiteSpace(skipWhiteSpace2 + 1);
            int i6 = skipWhiteSpace3;
            while (i6 < this.msg.length() && isArgTypeChar(this.msg.charAt(i6))) {
                i6++;
            }
            int i7 = i6 - skipWhiteSpace3;
            skipWhiteSpace2 = skipWhiteSpace(i6);
            if (skipWhiteSpace2 == this.msg.length()) {
                throw new IllegalArgumentException("Unmatched '{' braces in message " + prefix());
            } else if (i7 == 0 || !((charAt = this.msg.charAt(skipWhiteSpace2)) == ',' || charAt == '}')) {
                throw new IllegalArgumentException("Bad argument syntax: " + prefix(skipWhiteSpace));
            } else if (i7 > 65535) {
                throw new IndexOutOfBoundsException("Argument type name too long: " + prefix(skipWhiteSpace));
            } else {
                argType = ArgType.SIMPLE;
                if (i7 == 6) {
                    if (isChoice(skipWhiteSpace3)) {
                        argType = ArgType.CHOICE;
                    } else if (isPlural(skipWhiteSpace3)) {
                        argType = ArgType.PLURAL;
                    } else if (isSelect(skipWhiteSpace3)) {
                        argType = ArgType.SELECT;
                    }
                } else if (i7 == 13 && isSelect(skipWhiteSpace3) && isOrdinal(skipWhiteSpace3 + 6)) {
                    argType = ArgType.SELECTORDINAL;
                }
                this.parts.get(size).value = (short) argType.ordinal();
                if (argType == ArgType.SIMPLE) {
                    addPart(Part.Type.ARG_TYPE, skipWhiteSpace3, i7, 0);
                }
                if (charAt != '}') {
                    int i8 = skipWhiteSpace2 + 1;
                    if (argType == ArgType.SIMPLE) {
                        skipWhiteSpace2 = parseSimpleStyle(i8);
                    } else if (argType == ArgType.CHOICE) {
                        skipWhiteSpace2 = parseChoiceStyle(i8, i3);
                    } else {
                        skipWhiteSpace2 = parsePluralOrSelectStyle(argType, i8, i3);
                    }
                } else if (argType != ArgType.SIMPLE) {
                    throw new IllegalArgumentException("No style field for complex argument: " + prefix(skipWhiteSpace));
                }
            }
        }
        addLimitPart(size, Part.Type.ARG_LIMIT, skipWhiteSpace2, 1, argType.ordinal());
        return skipWhiteSpace2 + 1;
    }

    private int parseSimpleStyle(int i) {
        int i2 = 0;
        while (i < this.msg.length()) {
            i++;
            char charAt = this.msg.charAt(i);
            if (charAt == '\'') {
                int indexOf = this.msg.indexOf(39, i);
                if (indexOf < 0) {
                    throw new IllegalArgumentException("Quoted literal argument style text reaches to the end of the message: " + prefix(i));
                }
                i = indexOf + 1;
            } else if (charAt == '{') {
                i2++;
            } else if (charAt != '}') {
                continue;
            } else if (i2 > 0) {
                i2--;
            } else {
                int i3 = i - 1;
                int i4 = i3 - i;
                if (i4 > 65535) {
                    throw new IndexOutOfBoundsException("Argument style text too long: " + prefix(i));
                }
                addPart(Part.Type.ARG_STYLE, i, i4, 0);
                return i3;
            }
        }
        throw new IllegalArgumentException("Unmatched '{' braces in message " + prefix());
    }

    private int parseChoiceStyle(int i, int i2) {
        int skipWhiteSpace = skipWhiteSpace(i);
        if (skipWhiteSpace == this.msg.length() || this.msg.charAt(skipWhiteSpace) == '}') {
            throw new IllegalArgumentException("Missing choice argument pattern in " + prefix());
        }
        while (true) {
            int skipDouble = skipDouble(skipWhiteSpace);
            int i3 = skipDouble - skipWhiteSpace;
            if (i3 == 0) {
                throw new IllegalArgumentException("Bad choice pattern syntax: " + prefix(i));
            } else if (i3 > 65535) {
                throw new IndexOutOfBoundsException("Choice number too long: " + prefix(skipWhiteSpace));
            } else {
                parseDouble(skipWhiteSpace, skipDouble, true);
                int skipWhiteSpace2 = skipWhiteSpace(skipDouble);
                if (skipWhiteSpace2 == this.msg.length()) {
                    throw new IllegalArgumentException("Bad choice pattern syntax: " + prefix(i));
                }
                char charAt = this.msg.charAt(skipWhiteSpace2);
                if (charAt == '#' || charAt == '<' || charAt == 8804) {
                    addPart(Part.Type.ARG_SELECTOR, skipWhiteSpace2, 1, 0);
                    int parseMessage = parseMessage(skipWhiteSpace2 + 1, 0, i2 + 1, ArgType.CHOICE);
                    if (parseMessage == this.msg.length()) {
                        return parseMessage;
                    }
                    if (this.msg.charAt(parseMessage) != '}') {
                        skipWhiteSpace = skipWhiteSpace(parseMessage + 1);
                    } else if (inMessageFormatPattern(i2)) {
                        return parseMessage;
                    } else {
                        throw new IllegalArgumentException("Bad choice pattern syntax: " + prefix(i));
                    }
                } else {
                    throw new IllegalArgumentException("Expected choice separator (#<≤) instead of '" + charAt + "' in choice pattern " + prefix(i));
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0249, code lost:
        throw new java.lang.IllegalArgumentException("No message fragment after " + r12.toString().toLowerCase(java.util.Locale.ENGLISH) + " selector: " + prefix(r13));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int parsePluralOrSelectStyle(com.ibm.icu.text.MessagePattern.ArgType r12, int r13, int r14) {
        /*
        // Method dump skipped, instructions count: 596
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.text.MessagePattern.parsePluralOrSelectStyle(com.ibm.icu.text.MessagePattern$ArgType, int, int):int");
    }

    private static int parseArgNumber(CharSequence charSequence, int i, int i2) {
        boolean z;
        int i3;
        if (i >= i2) {
            return -2;
        }
        int i4 = i + 1;
        char charAt = charSequence.charAt(i);
        if (charAt == '0') {
            if (i4 == i2) {
                return 0;
            }
            i3 = 0;
            z = true;
        } else if ('1' > charAt || charAt > '9') {
            return -1;
        } else {
            i3 = charAt - '0';
            z = false;
        }
        while (i4 < i2) {
            i4++;
            char charAt2 = charSequence.charAt(i4);
            if ('0' > charAt2 || charAt2 > '9') {
                return -1;
            }
            if (i3 >= 214748364) {
                z = true;
            }
            i3 = (i3 * 10) + (charAt2 - '0');
        }
        if (z) {
            return -2;
        }
        return i3;
    }

    private int parseArgNumber(int i, int i2) {
        return parseArgNumber(this.msg, i, i2);
    }

    private void parseDouble(int i, int i2, boolean z) {
        if ($assertionsDisabled || i < i2) {
            int i3 = 0;
            int i4 = 0;
            int i5 = i + 1;
            char charAt = this.msg.charAt(i);
            if (charAt == '-') {
                i4 = 1;
                if (i5 != i2) {
                    i5++;
                    charAt = this.msg.charAt(i5);
                }
                throw new NumberFormatException("Bad syntax for numeric value: " + this.msg.substring(i, i2));
            } else if (charAt == '+') {
                if (i5 != i2) {
                    i5++;
                    charAt = this.msg.charAt(i5);
                }
                throw new NumberFormatException("Bad syntax for numeric value: " + this.msg.substring(i, i2));
            }
            if (charAt == 8734) {
                if (z && i5 == i2) {
                    addArgDoublePart(i4 != 0 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY, i, i2 - i);
                    return;
                }
                throw new NumberFormatException("Bad syntax for numeric value: " + this.msg.substring(i, i2));
            }
            while ('0' <= charAt && charAt <= '9' && (i3 = (i3 * 10) + (charAt - '0')) <= i4 + 32767) {
                if (i5 == i2) {
                    addPart(Part.Type.ARG_INT, i, i2 - i, i4 != 0 ? -i3 : i3);
                    return;
                } else {
                    i5++;
                    charAt = this.msg.charAt(i5);
                }
            }
            addArgDoublePart(Double.parseDouble(this.msg.substring(i, i2)), i, i2 - i);
            return;
        }
        throw new AssertionError();
    }

    static void appendReducedApostrophes(String str, int i, int i2, StringBuilder sb) {
        int i3 = -1;
        while (true) {
            int indexOf = str.indexOf(39, i);
            if (indexOf < 0 || indexOf >= i2) {
                break;
            } else if (indexOf == i3) {
                sb.append('\'');
                i++;
                i3 = -1;
            } else {
                sb.append((CharSequence) str, i, indexOf);
                i3 = indexOf + 1;
                i = i3;
            }
        }
        sb.append((CharSequence) str, i, i2);
    }

    private int skipWhiteSpace(int i) {
        return PatternProps.skipWhiteSpace(this.msg, i);
    }

    private int skipIdentifier(int i) {
        return PatternProps.skipIdentifier(this.msg, i);
    }

    private int skipDouble(int i) {
        while (i < this.msg.length() && (((r1 = this.msg.charAt(i)) >= '0' || "+-.".indexOf(r1) >= 0) && (r1 <= '9' || r1 == 'e' || r1 == 'E' || r1 == 8734))) {
            i++;
        }
        return i;
    }

    private static boolean isArgTypeChar(int i) {
        return (97 <= i && i <= 122) || (65 <= i && i <= 90);
    }

    private boolean isChoice(int i) {
        char charAt;
        int i2 = i + 1;
        char charAt2 = this.msg.charAt(i);
        if (charAt2 == 'c' || charAt2 == 'C') {
            int i3 = i2 + 1;
            char charAt3 = this.msg.charAt(i2);
            if (charAt3 == 'h' || charAt3 == 'H') {
                int i4 = i3 + 1;
                char charAt4 = this.msg.charAt(i3);
                if (charAt4 == 'o' || charAt4 == 'O') {
                    int i5 = i4 + 1;
                    char charAt5 = this.msg.charAt(i4);
                    if (charAt5 == 'i' || charAt5 == 'I') {
                        int i6 = i5 + 1;
                        char charAt6 = this.msg.charAt(i5);
                        if ((charAt6 == 'c' || charAt6 == 'C') && ((charAt = this.msg.charAt(i6)) == 'e' || charAt == 'E')) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean isPlural(int i) {
        char charAt;
        int i2 = i + 1;
        char charAt2 = this.msg.charAt(i);
        if (charAt2 == 'p' || charAt2 == 'P') {
            int i3 = i2 + 1;
            char charAt3 = this.msg.charAt(i2);
            if (charAt3 == 'l' || charAt3 == 'L') {
                int i4 = i3 + 1;
                char charAt4 = this.msg.charAt(i3);
                if (charAt4 == 'u' || charAt4 == 'U') {
                    int i5 = i4 + 1;
                    char charAt5 = this.msg.charAt(i4);
                    if (charAt5 == 'r' || charAt5 == 'R') {
                        int i6 = i5 + 1;
                        char charAt6 = this.msg.charAt(i5);
                        if ((charAt6 == 'a' || charAt6 == 'A') && ((charAt = this.msg.charAt(i6)) == 'l' || charAt == 'L')) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean isSelect(int i) {
        char charAt;
        int i2 = i + 1;
        char charAt2 = this.msg.charAt(i);
        if (charAt2 == 's' || charAt2 == 'S') {
            int i3 = i2 + 1;
            char charAt3 = this.msg.charAt(i2);
            if (charAt3 == 'e' || charAt3 == 'E') {
                int i4 = i3 + 1;
                char charAt4 = this.msg.charAt(i3);
                if (charAt4 == 'l' || charAt4 == 'L') {
                    int i5 = i4 + 1;
                    char charAt5 = this.msg.charAt(i4);
                    if (charAt5 == 'e' || charAt5 == 'E') {
                        int i6 = i5 + 1;
                        char charAt6 = this.msg.charAt(i5);
                        if ((charAt6 == 'c' || charAt6 == 'C') && ((charAt = this.msg.charAt(i6)) == 't' || charAt == 'T')) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean isOrdinal(int i) {
        char charAt;
        int i2 = i + 1;
        char charAt2 = this.msg.charAt(i);
        if (charAt2 == 'o' || charAt2 == 'O') {
            int i3 = i2 + 1;
            char charAt3 = this.msg.charAt(i2);
            if (charAt3 == 'r' || charAt3 == 'R') {
                int i4 = i3 + 1;
                char charAt4 = this.msg.charAt(i3);
                if (charAt4 == 'd' || charAt4 == 'D') {
                    int i5 = i4 + 1;
                    char charAt5 = this.msg.charAt(i4);
                    if (charAt5 == 'i' || charAt5 == 'I') {
                        int i6 = i5 + 1;
                        char charAt6 = this.msg.charAt(i5);
                        if (charAt6 == 'n' || charAt6 == 'N') {
                            int i7 = i6 + 1;
                            char charAt7 = this.msg.charAt(i6);
                            if ((charAt7 == 'a' || charAt7 == 'A') && ((charAt = this.msg.charAt(i7)) == 'l' || charAt == 'L')) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean inMessageFormatPattern(int i) {
        return i > 0 || this.parts.get(0).type == Part.Type.MSG_START;
    }

    private boolean inTopLevelChoiceMessage(int i, ArgType argType) {
        return i == 1 && argType == ArgType.CHOICE && this.parts.get(0).type != Part.Type.MSG_START;
    }

    private void addPart(Part.Type type, int i, int i2, int i3) {
        this.parts.add(new Part(type, i, i2, i3));
    }

    private void addLimitPart(int i, Part.Type type, int i2, int i3, int i4) {
        this.parts.get(i).limitPartIndex = this.parts.size();
        addPart(type, i2, i3, i4);
    }

    private void addArgDoublePart(double d, int i, int i2) {
        int i3;
        if (this.numericValues == null) {
            this.numericValues = new ArrayList<>();
            i3 = 0;
        } else {
            i3 = this.numericValues.size();
            if (i3 > 32767) {
                throw new IndexOutOfBoundsException("Too many numeric values");
            }
        }
        this.numericValues.add(Double.valueOf(d));
        addPart(Part.Type.ARG_DOUBLE, i, i2, i3);
    }

    private static String prefix(String str, int i) {
        StringBuilder sb = new StringBuilder(44);
        if (i == 0) {
            sb.append("\"");
        } else {
            sb.append("[at pattern index ").append(i).append("] \"");
        }
        if (str.length() - i <= 24) {
            sb.append(i == 0 ? str : str.substring(i));
        } else {
            int i2 = (i + 24) - 4;
            if (Character.isHighSurrogate(str.charAt(i2 - 1))) {
                i2--;
            }
            sb.append((CharSequence) str, i, i2).append(" ...");
        }
        return sb.append("\"").toString();
    }

    private static String prefix(String str) {
        return prefix(str, 0);
    }

    private String prefix(int i) {
        return prefix(this.msg, i);
    }

    private String prefix() {
        return prefix(this.msg, 0);
    }
}

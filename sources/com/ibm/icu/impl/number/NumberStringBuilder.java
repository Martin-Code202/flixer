package com.ibm.icu.impl.number;

import com.ibm.icu.text.NumberFormat;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class NumberStringBuilder implements CharSequence {
    static final /* synthetic */ boolean $assertionsDisabled = (!NumberStringBuilder.class.desiredAssertionStatus());
    private static final Map<NumberFormat.Field, Character> fieldToDebugChar = new HashMap();
    private char[] chars;
    private NumberFormat.Field[] fields;
    private int length;
    private int zero;

    static {
        fieldToDebugChar.put(NumberFormat.Field.SIGN, '-');
        fieldToDebugChar.put(NumberFormat.Field.INTEGER, 'i');
        fieldToDebugChar.put(NumberFormat.Field.FRACTION, 'f');
        fieldToDebugChar.put(NumberFormat.Field.EXPONENT, 'e');
        fieldToDebugChar.put(NumberFormat.Field.EXPONENT_SIGN, '+');
        fieldToDebugChar.put(NumberFormat.Field.EXPONENT_SYMBOL, 'E');
        fieldToDebugChar.put(NumberFormat.Field.DECIMAL_SEPARATOR, '.');
        fieldToDebugChar.put(NumberFormat.Field.GROUPING_SEPARATOR, ',');
        fieldToDebugChar.put(NumberFormat.Field.PERCENT, '%');
        fieldToDebugChar.put(NumberFormat.Field.PERMILLE, (char) 8240);
        fieldToDebugChar.put(NumberFormat.Field.CURRENCY, '$');
    }

    public NumberStringBuilder() {
        this(40);
    }

    public NumberStringBuilder(int i) {
        this.chars = new char[i];
        this.fields = new NumberFormat.Field[i];
        this.zero = i / 2;
        this.length = 0;
    }

    public NumberStringBuilder(NumberStringBuilder numberStringBuilder) {
        this(numberStringBuilder.chars.length);
        this.zero = numberStringBuilder.zero;
        this.length = numberStringBuilder.length;
        System.arraycopy(numberStringBuilder.chars, this.zero, this.chars, this.zero, this.length);
        System.arraycopy(numberStringBuilder.fields, this.zero, this.fields, this.zero, this.length);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.length;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        if (i >= 0 && i <= this.length) {
            return this.chars[this.zero + i];
        }
        throw new IndexOutOfBoundsException();
    }

    public int appendCodePoint(int i, NumberFormat.Field field) {
        return insertCodePoint(this.length, i, field);
    }

    public int insertCodePoint(int i, int i2, NumberFormat.Field field) {
        int charCount = Character.charCount(i2);
        int prepareForInsert = prepareForInsert(i, charCount);
        Character.toChars(i2, this.chars, prepareForInsert);
        this.fields[prepareForInsert] = field;
        if (charCount == 2) {
            this.fields[prepareForInsert + 1] = field;
        }
        return charCount;
    }

    public int append(CharSequence charSequence, NumberFormat.Field field) {
        return insert(this.length, charSequence, field);
    }

    public int insert(int i, CharSequence charSequence, NumberFormat.Field field) {
        if (charSequence.length() == 0) {
            return 0;
        }
        if (charSequence.length() == 1) {
            return insertCodePoint(i, charSequence.charAt(0), field);
        }
        return insert(i, charSequence, 0, charSequence.length(), field);
    }

    public int insert(int i, CharSequence charSequence, int i2, int i3, NumberFormat.Field field) {
        int i4 = i3 - i2;
        int prepareForInsert = prepareForInsert(i, i4);
        for (int i5 = 0; i5 < i4; i5++) {
            this.chars[prepareForInsert + i5] = charSequence.charAt(i2 + i5);
            this.fields[prepareForInsert + i5] = field;
        }
        return i4;
    }

    public int insert(int i, char[] cArr, NumberFormat.Field[] fieldArr) {
        if ($assertionsDisabled || fieldArr == null || cArr.length == fieldArr.length) {
            int length2 = cArr.length;
            if (length2 == 0) {
                return 0;
            }
            int prepareForInsert = prepareForInsert(i, length2);
            for (int i2 = 0; i2 < length2; i2++) {
                this.chars[prepareForInsert + i2] = cArr[i2];
                this.fields[prepareForInsert + i2] = fieldArr == null ? null : fieldArr[i2];
            }
            return length2;
        }
        throw new AssertionError();
    }

    public int append(NumberStringBuilder numberStringBuilder) {
        return insert(this.length, numberStringBuilder);
    }

    public int insert(int i, NumberStringBuilder numberStringBuilder) {
        if (this == numberStringBuilder) {
            throw new IllegalArgumentException("Cannot call insert/append on myself");
        }
        int i2 = numberStringBuilder.length;
        if (i2 == 0) {
            return 0;
        }
        int prepareForInsert = prepareForInsert(i, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            this.chars[prepareForInsert + i3] = numberStringBuilder.chars[numberStringBuilder.zero + i3];
            this.fields[prepareForInsert + i3] = numberStringBuilder.fields[numberStringBuilder.zero + i3];
        }
        return i2;
    }

    private int prepareForInsert(int i, int i2) {
        if (i == 0 && this.zero - i2 >= 0) {
            this.zero -= i2;
            this.length += i2;
            return this.zero;
        } else if (i != this.length || this.zero + this.length + i2 >= this.chars.length) {
            return prepareForInsertHelper(i, i2);
        } else {
            this.length += i2;
            return (this.zero + this.length) - i2;
        }
    }

    private int prepareForInsertHelper(int i, int i2) {
        if (this.length + i2 > this.chars.length) {
            char[] cArr = new char[((this.length + i2) * 2)];
            NumberFormat.Field[] fieldArr = new NumberFormat.Field[((this.length + i2) * 2)];
            int length2 = (cArr.length / 2) - ((this.length + i2) / 2);
            System.arraycopy(this.chars, this.zero, cArr, length2, i);
            System.arraycopy(this.chars, this.zero + i, cArr, length2 + i + i2, this.length - i);
            System.arraycopy(this.fields, this.zero, fieldArr, length2, i);
            System.arraycopy(this.fields, this.zero + i, fieldArr, length2 + i + i2, this.length - i);
            this.chars = cArr;
            this.fields = fieldArr;
            this.zero = length2;
            this.length += i2;
        } else {
            int length3 = (this.chars.length / 2) - ((this.length + i2) / 2);
            System.arraycopy(this.chars, this.zero, this.chars, length3, this.length);
            System.arraycopy(this.chars, length3 + i, this.chars, length3 + i + i2, this.length - i);
            System.arraycopy(this.fields, this.zero, this.fields, length3, this.length);
            System.arraycopy(this.fields, length3 + i, this.fields, length3 + i + i2, this.length - i);
            this.zero = length3;
            this.length += i2;
        }
        return this.zero + i;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        if (i < 0 || i2 > this.length || i2 < i) {
            throw new IndexOutOfBoundsException();
        }
        NumberStringBuilder numberStringBuilder = new NumberStringBuilder(this);
        numberStringBuilder.zero = this.zero + i;
        numberStringBuilder.length = i2 - i;
        return numberStringBuilder;
    }

    @Override // java.lang.CharSequence, java.lang.Object
    public String toString() {
        return new String(this.chars, this.zero, this.length);
    }

    public char[] toCharArray() {
        return Arrays.copyOfRange(this.chars, this.zero, this.zero + this.length);
    }

    public NumberFormat.Field[] toFieldArray() {
        return (NumberFormat.Field[]) Arrays.copyOfRange(this.fields, this.zero, this.zero + this.length);
    }

    public boolean contentEquals(char[] cArr, NumberFormat.Field[] fieldArr) {
        if (!(cArr.length == this.length && fieldArr.length == this.length)) {
            return false;
        }
        for (int i = 0; i < this.length; i++) {
            if (!(this.chars[this.zero + i] == cArr[i] && this.fields[this.zero + i] == fieldArr[i])) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0067, code lost:
        r10.setEndIndex((r7 - r9.zero) + r11);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void populateFieldPosition(java.text.FieldPosition r10, int r11) {
        /*
            r9 = this;
            java.text.Format$Field r3 = r10.getFieldAttribute()
            if (r3 != 0) goto L_0x001a
            int r0 = r10.getField()
            if (r0 != 0) goto L_0x000f
            com.ibm.icu.text.NumberFormat$Field r3 = com.ibm.icu.text.NumberFormat.Field.INTEGER
            goto L_0x001a
        L_0x000f:
            int r0 = r10.getField()
            r1 = 1
            if (r0 != r1) goto L_0x0019
            com.ibm.icu.text.NumberFormat$Field r3 = com.ibm.icu.text.NumberFormat.Field.FRACTION
            goto L_0x001a
        L_0x0019:
            return
        L_0x001a:
            boolean r0 = r3 instanceof com.ibm.icu.text.NumberFormat.Field
            if (r0 != 0) goto L_0x003f
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "You must pass an instance of com.ibm.icu.text.NumberFormat.Field as your FieldPosition attribute.  You passed: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.Class r2 = r3.getClass()
            java.lang.String r2 = r2.toString()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x003f:
            r4 = r3
            com.ibm.icu.text.NumberFormat$Field r4 = (com.ibm.icu.text.NumberFormat.Field) r4
            r5 = 0
            r6 = -1
            int r7 = r9.zero
        L_0x0046:
            int r0 = r9.zero
            int r1 = r9.length
            int r0 = r0 + r1
            if (r7 > r0) goto L_0x008f
            int r0 = r9.zero
            int r1 = r9.length
            int r0 = r0 + r1
            if (r7 >= r0) goto L_0x0059
            com.ibm.icu.text.NumberFormat$Field[] r0 = r9.fields
            r8 = r0[r7]
            goto L_0x005a
        L_0x0059:
            r8 = 0
        L_0x005a:
            if (r5 == 0) goto L_0x0070
            if (r4 == r8) goto L_0x0070
            com.ibm.icu.text.NumberFormat$Field r0 = com.ibm.icu.text.NumberFormat.Field.INTEGER
            if (r4 != r0) goto L_0x0067
            com.ibm.icu.text.NumberFormat$Field r0 = com.ibm.icu.text.NumberFormat.Field.GROUPING_SEPARATOR
            if (r8 != r0) goto L_0x0067
            goto L_0x008b
        L_0x0067:
            int r0 = r9.zero
            int r0 = r7 - r0
            int r0 = r0 + r11
            r10.setEndIndex(r0)
            goto L_0x008f
        L_0x0070:
            if (r5 != 0) goto L_0x007d
            if (r4 != r8) goto L_0x007d
            int r0 = r9.zero
            int r0 = r7 - r0
            int r0 = r0 + r11
            r10.setBeginIndex(r0)
            r5 = 1
        L_0x007d:
            com.ibm.icu.text.NumberFormat$Field r0 = com.ibm.icu.text.NumberFormat.Field.INTEGER
            if (r8 == r0) goto L_0x0085
            com.ibm.icu.text.NumberFormat$Field r0 = com.ibm.icu.text.NumberFormat.Field.DECIMAL_SEPARATOR
            if (r8 != r0) goto L_0x008b
        L_0x0085:
            int r0 = r9.zero
            int r0 = r7 - r0
            int r6 = r0 + 1
        L_0x008b:
            int r7 = r7 + 1
            goto L_0x0046
        L_0x008f:
            com.ibm.icu.text.NumberFormat$Field r0 = com.ibm.icu.text.NumberFormat.Field.FRACTION
            if (r4 != r0) goto L_0x009b
            if (r5 != 0) goto L_0x009b
            r10.setBeginIndex(r6)
            r10.setEndIndex(r6)
        L_0x009b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.number.NumberStringBuilder.populateFieldPosition(java.text.FieldPosition, int):void");
    }

    public AttributedCharacterIterator getIterator() {
        AttributedString attributedString = new AttributedString(toString());
        NumberFormat.Field field = null;
        int i = -1;
        for (int i2 = 0; i2 < this.length; i2++) {
            NumberFormat.Field field2 = this.fields[this.zero + i2];
            if (field == NumberFormat.Field.INTEGER && field2 == NumberFormat.Field.GROUPING_SEPARATOR) {
                attributedString.addAttribute(NumberFormat.Field.GROUPING_SEPARATOR, NumberFormat.Field.GROUPING_SEPARATOR, i2, i2 + 1);
            } else if (field != field2) {
                if (field != null) {
                    attributedString.addAttribute(field, field, i, i2);
                }
                field = field2;
                i = i2;
            }
        }
        if (field != null) {
            attributedString.addAttribute(field, field, i, this.length);
        }
        return attributedString.getIterator();
    }

    public NumberStringBuilder clear() {
        this.zero = this.chars.length / 2;
        this.length = 0;
        return this;
    }
}

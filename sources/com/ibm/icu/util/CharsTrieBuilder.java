package com.ibm.icu.util;

import com.ibm.icu.util.StringTrieBuilder;
import java.nio.CharBuffer;
import org.linphone.core.Privacy;
public final class CharsTrieBuilder extends StringTrieBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = (!CharsTrieBuilder.class.desiredAssertionStatus());
    private char[] chars;
    private int charsLength;
    private final char[] intUnits = new char[3];

    public CharsTrieBuilder add(CharSequence charSequence, int i) {
        addImpl(charSequence, i);
        return this;
    }

    public CharsTrie build(StringTrieBuilder.Option option) {
        return new CharsTrie(buildCharSequence(option), 0);
    }

    public CharSequence buildCharSequence(StringTrieBuilder.Option option) {
        buildChars(option);
        return CharBuffer.wrap(this.chars, this.chars.length - this.charsLength, this.charsLength);
    }

    private void buildChars(StringTrieBuilder.Option option) {
        if (this.chars == null) {
            this.chars = new char[1024];
        }
        buildImpl(option);
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.StringTrieBuilder
    @Deprecated
    public boolean matchNodesCanHaveValues() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.StringTrieBuilder
    @Deprecated
    public int getMaxBranchLinearSubNodeLength() {
        return 5;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.StringTrieBuilder
    @Deprecated
    public int getMinLinearMatch() {
        return 48;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.StringTrieBuilder
    @Deprecated
    public int getMaxLinearMatchLength() {
        return 16;
    }

    private void ensureCapacity(int i) {
        if (i > this.chars.length) {
            int length = this.chars.length;
            do {
                length *= 2;
            } while (length <= i);
            char[] cArr = new char[length];
            System.arraycopy(this.chars, this.chars.length - this.charsLength, cArr, cArr.length - this.charsLength, this.charsLength);
            this.chars = cArr;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.StringTrieBuilder
    @Deprecated
    public int write(int i) {
        int i2 = this.charsLength + 1;
        ensureCapacity(i2);
        this.charsLength = i2;
        this.chars[this.chars.length - this.charsLength] = (char) i;
        return this.charsLength;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.StringTrieBuilder
    @Deprecated
    public int write(int i, int i2) {
        int i3 = this.charsLength + i2;
        ensureCapacity(i3);
        this.charsLength = i3;
        int length = this.chars.length - this.charsLength;
        while (i2 > 0) {
            length++;
            i++;
            this.chars[length] = this.strings.charAt(i);
            i2--;
        }
        return this.charsLength;
    }

    private int write(char[] cArr, int i) {
        int i2 = this.charsLength + i;
        ensureCapacity(i2);
        this.charsLength = i2;
        System.arraycopy(cArr, 0, this.chars, this.chars.length - this.charsLength, i);
        return this.charsLength;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.StringTrieBuilder
    @Deprecated
    public int writeValueAndFinal(int i, boolean z) {
        int i2;
        if (0 > i || i > 16383) {
            if (i < 0 || i > 1073676287) {
                this.intUnits[0] = 32767;
                this.intUnits[1] = (char) (i >> 16);
                this.intUnits[2] = (char) i;
                i2 = 3;
            } else {
                this.intUnits[0] = (char) ((i >> 16) + 16384);
                this.intUnits[1] = (char) i;
                i2 = 2;
            }
            this.intUnits[0] = (char) (this.intUnits[0] | (z ? (char) 32768 : 0));
            return write(this.intUnits, i2);
        }
        return write((z ? Privacy.DEFAULT : 0) | i);
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.StringTrieBuilder
    @Deprecated
    public int writeValueAndType(boolean z, int i, int i2) {
        int i3;
        if (!z) {
            return write(i2);
        }
        if (i < 0 || i > 16646143) {
            this.intUnits[0] = 32704;
            this.intUnits[1] = (char) (i >> 16);
            this.intUnits[2] = (char) i;
            i3 = 3;
        } else if (i <= 255) {
            this.intUnits[0] = (char) ((i + 1) << 6);
            i3 = 1;
        } else {
            this.intUnits[0] = (char) (((i >> 10) & 32704) + 16448);
            this.intUnits[1] = (char) i;
            i3 = 2;
        }
        char[] cArr = this.intUnits;
        cArr[0] = (char) (cArr[0] | ((char) i2));
        return write(this.intUnits, i3);
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.util.StringTrieBuilder
    @Deprecated
    public int writeDeltaTo(int i) {
        int i2;
        int i3 = this.charsLength - i;
        if (!$assertionsDisabled && i3 < 0) {
            throw new AssertionError();
        } else if (i3 <= 64511) {
            return write(i3);
        } else {
            if (i3 <= 67043327) {
                this.intUnits[0] = (char) ((i3 >> 16) + 64512);
                i2 = 1;
            } else {
                this.intUnits[0] = 65535;
                this.intUnits[1] = (char) (i3 >> 16);
                i2 = 2;
            }
            this.intUnits[i2] = (char) i3;
            return write(this.intUnits, i2 + 1);
        }
    }
}

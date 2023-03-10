package com.ibm.icu.text;

import com.ibm.icu.impl.Norm2AllModes;
import com.ibm.icu.util.ICUCloneNotSupportedException;
public final class Normalizer implements Cloneable {
    @Deprecated
    public static final Mode COMPOSE = NFC;
    @Deprecated
    public static final Mode COMPOSE_COMPAT = NFKC;
    @Deprecated
    public static final Mode DECOMP = NFD;
    @Deprecated
    public static final Mode DECOMP_COMPAT = NFKD;
    @Deprecated
    public static final Mode DEFAULT = NFC;
    @Deprecated
    public static final Mode FCD = new FCDMode();
    public static final QuickCheckResult MAYBE = new QuickCheckResult(2);
    @Deprecated
    public static final Mode NFC = new NFCMode();
    @Deprecated
    public static final Mode NFD = new NFDMode();
    @Deprecated
    public static final Mode NFKC = new NFKCMode();
    @Deprecated
    public static final Mode NFKD = new NFKDMode();
    public static final QuickCheckResult NO = new QuickCheckResult(0);
    @Deprecated
    public static final Mode NONE = new NONEMode();
    @Deprecated
    public static final Mode NO_OP = NONE;
    public static final QuickCheckResult YES = new QuickCheckResult(1);
    private StringBuilder buffer = new StringBuilder();
    private int bufferPos;
    private int currentIndex;
    private Mode mode;
    private int nextIndex;
    private Normalizer2 norm2;
    private int options;
    private UCharacterIterator text;

    static final class FCD32ModeImpl {
        private static final ModeImpl INSTANCE = new ModeImpl(new FilteredNormalizer2(Norm2AllModes.getFCDNormalizer2(), Unicode32.INSTANCE));
    }

    static final class FCDModeImpl {
        private static final ModeImpl INSTANCE = new ModeImpl(Norm2AllModes.getFCDNormalizer2());
    }

    static final class NFC32ModeImpl {
        private static final ModeImpl INSTANCE = new ModeImpl(new FilteredNormalizer2(Normalizer2.getNFCInstance(), Unicode32.INSTANCE));
    }

    static final class NFCModeImpl {
        private static final ModeImpl INSTANCE = new ModeImpl(Normalizer2.getNFCInstance());
    }

    static final class NFD32ModeImpl {
        private static final ModeImpl INSTANCE = new ModeImpl(new FilteredNormalizer2(Normalizer2.getNFDInstance(), Unicode32.INSTANCE));
    }

    static final class NFDModeImpl {
        private static final ModeImpl INSTANCE = new ModeImpl(Normalizer2.getNFDInstance());
    }

    static final class NFKC32ModeImpl {
        private static final ModeImpl INSTANCE = new ModeImpl(new FilteredNormalizer2(Normalizer2.getNFKCInstance(), Unicode32.INSTANCE));
    }

    static final class NFKCModeImpl {
        private static final ModeImpl INSTANCE = new ModeImpl(Normalizer2.getNFKCInstance());
    }

    static final class NFKD32ModeImpl {
        private static final ModeImpl INSTANCE = new ModeImpl(new FilteredNormalizer2(Normalizer2.getNFKDInstance(), Unicode32.INSTANCE));
    }

    static final class NFKDModeImpl {
        private static final ModeImpl INSTANCE = new ModeImpl(Normalizer2.getNFKDInstance());
    }

    static final class Unicode32 {
        private static final UnicodeSet INSTANCE = new UnicodeSet("[:age=3.2:]").freeze();
    }

    /* access modifiers changed from: package-private */
    public static final class ModeImpl {
        private final Normalizer2 normalizer2;

        private ModeImpl(Normalizer2 normalizer22) {
            this.normalizer2 = normalizer22;
        }
    }

    @Deprecated
    public static abstract class Mode {
        /* access modifiers changed from: protected */
        @Deprecated
        public abstract Normalizer2 getNormalizer2(int i);

        @Deprecated
        protected Mode() {
        }
    }

    static final class NONEMode extends Mode {
        private NONEMode() {
        }

        /* access modifiers changed from: protected */
        @Override // com.ibm.icu.text.Normalizer.Mode
        public Normalizer2 getNormalizer2(int i) {
            return Norm2AllModes.NOOP_NORMALIZER2;
        }
    }

    static final class NFDMode extends Mode {
        private NFDMode() {
        }

        /* access modifiers changed from: protected */
        @Override // com.ibm.icu.text.Normalizer.Mode
        public Normalizer2 getNormalizer2(int i) {
            return (i & 32) != 0 ? NFD32ModeImpl.INSTANCE.normalizer2 : NFDModeImpl.INSTANCE.normalizer2;
        }
    }

    static final class NFKDMode extends Mode {
        private NFKDMode() {
        }

        /* access modifiers changed from: protected */
        @Override // com.ibm.icu.text.Normalizer.Mode
        public Normalizer2 getNormalizer2(int i) {
            return (i & 32) != 0 ? NFKD32ModeImpl.INSTANCE.normalizer2 : NFKDModeImpl.INSTANCE.normalizer2;
        }
    }

    static final class NFCMode extends Mode {
        private NFCMode() {
        }

        /* access modifiers changed from: protected */
        @Override // com.ibm.icu.text.Normalizer.Mode
        public Normalizer2 getNormalizer2(int i) {
            return (i & 32) != 0 ? NFC32ModeImpl.INSTANCE.normalizer2 : NFCModeImpl.INSTANCE.normalizer2;
        }
    }

    static final class NFKCMode extends Mode {
        private NFKCMode() {
        }

        /* access modifiers changed from: protected */
        @Override // com.ibm.icu.text.Normalizer.Mode
        public Normalizer2 getNormalizer2(int i) {
            return (i & 32) != 0 ? NFKC32ModeImpl.INSTANCE.normalizer2 : NFKCModeImpl.INSTANCE.normalizer2;
        }
    }

    static final class FCDMode extends Mode {
        private FCDMode() {
        }

        /* access modifiers changed from: protected */
        @Override // com.ibm.icu.text.Normalizer.Mode
        public Normalizer2 getNormalizer2(int i) {
            return (i & 32) != 0 ? FCD32ModeImpl.INSTANCE.normalizer2 : FCDModeImpl.INSTANCE.normalizer2;
        }
    }

    public static final class QuickCheckResult {
        private QuickCheckResult(int i) {
        }
    }

    @Deprecated
    public Normalizer(String str, Mode mode2, int i) {
        this.text = UCharacterIterator.getInstance(str);
        this.mode = mode2;
        this.options = i;
        this.norm2 = mode2.getNormalizer2(i);
    }

    @Override // java.lang.Object
    @Deprecated
    public Object clone() {
        try {
            Normalizer normalizer = (Normalizer) super.clone();
            normalizer.text = (UCharacterIterator) this.text.clone();
            normalizer.mode = this.mode;
            normalizer.options = this.options;
            normalizer.norm2 = this.norm2;
            normalizer.buffer = new StringBuilder(this.buffer);
            normalizer.bufferPos = this.bufferPos;
            normalizer.currentIndex = this.currentIndex;
            normalizer.nextIndex = this.nextIndex;
            return normalizer;
        } catch (CloneNotSupportedException e) {
            throw new ICUCloneNotSupportedException(e);
        }
    }

    @Deprecated
    public static String normalize(String str, Mode mode2, int i) {
        return mode2.getNormalizer2(i).normalize(str);
    }

    @Deprecated
    public static String normalize(String str, Mode mode2) {
        return normalize(str, mode2, 0);
    }

    @Deprecated
    public static QuickCheckResult quickCheck(String str, Mode mode2) {
        return quickCheck(str, mode2, 0);
    }

    @Deprecated
    public static QuickCheckResult quickCheck(String str, Mode mode2, int i) {
        return mode2.getNormalizer2(i).quickCheck(str);
    }

    @Deprecated
    public static boolean isNormalized(String str, Mode mode2, int i) {
        return mode2.getNormalizer2(i).isNormalized(str);
    }

    @Deprecated
    public int next() {
        if (this.bufferPos >= this.buffer.length() && !nextNormalize()) {
            return -1;
        }
        int codePointAt = this.buffer.codePointAt(this.bufferPos);
        this.bufferPos += Character.charCount(codePointAt);
        return codePointAt;
    }

    @Deprecated
    public int getIndex() {
        if (this.bufferPos < this.buffer.length()) {
            return this.currentIndex;
        }
        return this.nextIndex;
    }

    @Deprecated
    public int endIndex() {
        return this.text.getLength();
    }

    private void clearBuffer() {
        this.buffer.setLength(0);
        this.bufferPos = 0;
    }

    private boolean nextNormalize() {
        clearBuffer();
        this.currentIndex = this.nextIndex;
        this.text.setIndex(this.nextIndex);
        int nextCodePoint = this.text.nextCodePoint();
        if (nextCodePoint < 0) {
            return false;
        }
        StringBuilder appendCodePoint = new StringBuilder().appendCodePoint(nextCodePoint);
        while (true) {
            int nextCodePoint2 = this.text.nextCodePoint();
            if (nextCodePoint2 < 0) {
                break;
            } else if (this.norm2.hasBoundaryBefore(nextCodePoint2)) {
                this.text.moveCodePointIndex(-1);
                break;
            } else {
                appendCodePoint.appendCodePoint(nextCodePoint2);
            }
        }
        this.nextIndex = this.text.getIndex();
        this.norm2.normalize(appendCodePoint, this.buffer);
        return this.buffer.length() != 0;
    }
}

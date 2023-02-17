package com.ibm.icu.math;

import java.io.Serializable;
public final class MathContext implements Serializable {
    public static final MathContext DEFAULT = new MathContext(9, 1, false, 4);
    private static final int[] ROUNDS = {4, 7, 2, 1, 3, 5, 6, 0};
    private static final String[] ROUNDWORDS = {"ROUND_HALF_UP", "ROUND_UNNECESSARY", "ROUND_CEILING", "ROUND_DOWN", "ROUND_FLOOR", "ROUND_HALF_DOWN", "ROUND_HALF_EVEN", "ROUND_UP"};
    private static final long serialVersionUID = 7163376998892515376L;
    int digits;
    int form;
    boolean lostDigits;
    int roundingMode;

    public MathContext(int i, int i2) {
        this(i, i2, false, 4);
    }

    public MathContext(int i, int i2, boolean z, int i3) {
        if (i != 9) {
            if (i < 0) {
                throw new IllegalArgumentException("Digits too small: " + i);
            } else if (i > 999999999) {
                throw new IllegalArgumentException("Digits too large: " + i);
            }
        }
        if (i2 != 1 && i2 != 2 && i2 != 0) {
            throw new IllegalArgumentException("Bad form value: " + i2);
        } else if (!isValidRound(i3)) {
            throw new IllegalArgumentException("Bad roundingMode value: " + i3);
        } else {
            this.digits = i;
            this.form = i2;
            this.lostDigits = z;
            this.roundingMode = i3;
        }
    }

    public int getDigits() {
        return this.digits;
    }

    public int getForm() {
        return this.form;
    }

    public boolean getLostDigits() {
        return this.lostDigits;
    }

    public int getRoundingMode() {
        return this.roundingMode;
    }

    @Override // java.lang.Object
    public String toString() {
        String str;
        String str2 = null;
        if (this.form == 1) {
            str = "SCIENTIFIC";
        } else if (this.form == 2) {
            str = "ENGINEERING";
        } else {
            str = "PLAIN";
        }
        int length = ROUNDS.length;
        int i = 0;
        while (true) {
            if (length <= 0) {
                break;
            } else if (this.roundingMode == ROUNDS[i]) {
                str2 = ROUNDWORDS[i];
                break;
            } else {
                length--;
                i++;
            }
        }
        return "digits=" + this.digits + " form=" + str + " lostDigits=" + (this.lostDigits ? "1" : "0") + " roundingMode=" + str2;
    }

    private static boolean isValidRound(int i) {
        int length = ROUNDS.length;
        int i2 = 0;
        while (length > 0) {
            if (i == ROUNDS[i2]) {
                return true;
            }
            length--;
            i2++;
        }
        return false;
    }
}

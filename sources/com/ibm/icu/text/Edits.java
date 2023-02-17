package com.ibm.icu.text;

import java.nio.BufferOverflowException;
import java.util.Arrays;
import org.linphone.core.Privacy;
public final class Edits {
    private char[] array = new char[100];
    private int delta;
    private int length;

    public void reset() {
        this.delta = 0;
        this.length = 0;
    }

    private void setLastUnit(int i) {
        this.array[this.length - 1] = (char) i;
    }

    private int lastUnit() {
        if (this.length > 0) {
            return this.array[this.length - 1];
        }
        return 65535;
    }

    public void addUnchanged(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("addUnchanged(" + i + "): length must not be negative");
        }
        int lastUnit = lastUnit();
        if (lastUnit < 4095) {
            int i2 = 4095 - lastUnit;
            if (i2 >= i) {
                setLastUnit(lastUnit + i);
                return;
            } else {
                setLastUnit(4095);
                i -= i2;
            }
        }
        while (i >= 4096) {
            append(4095);
            i -= 4096;
        }
        if (i > 0) {
            append(i - 1);
        }
    }

    public void addReplace(int i, int i2) {
        int i3;
        int i4;
        if (i == i2 && 0 < i && i <= 6) {
            int lastUnit = lastUnit();
            if (4095 >= lastUnit || lastUnit >= 28671 || (lastUnit >> 12) != i || (lastUnit & 4095) >= 4095) {
                append(i << 12);
            } else {
                setLastUnit(lastUnit + 1);
            }
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("addReplace(" + i + ", " + i2 + "): both lengths must be non-negative");
        } else if (i != 0 || i2 != 0) {
            int i5 = i2 - i;
            if (i5 != 0) {
                if ((i5 <= 0 || this.delta < 0 || i5 <= Integer.MAX_VALUE - this.delta) && (i5 >= 0 || this.delta >= 0 || i5 >= Integer.MIN_VALUE - this.delta)) {
                    this.delta += i5;
                } else {
                    throw new IndexOutOfBoundsException();
                }
            }
            if (i < 61 && i2 < 61) {
                append((i << 6) | 28672 | i2);
            } else if (this.array.length - this.length >= 5 || growArray()) {
                int i6 = this.length + 1;
                if (i < 61) {
                    i3 = (i << 6) | 28672;
                } else if (i <= 32767) {
                    i3 = 32576;
                    i6++;
                    this.array[i6] = (char) (32768 | i);
                } else {
                    i3 = (((i >> 30) + 62) << 6) | 28672;
                    int i7 = i6 + 1;
                    this.array[i6] = (char) ((i >> 15) | Privacy.DEFAULT);
                    i6 = i7 + 1;
                    this.array[i7] = (char) (32768 | i);
                }
                if (i2 < 61) {
                    i4 = i3 | i2;
                } else if (i2 <= 32767) {
                    i4 = i3 | 61;
                    i6++;
                    this.array[i6] = (char) (32768 | i2);
                } else {
                    i4 = i3 | ((i2 >> 30) + 62);
                    int i8 = i6 + 1;
                    this.array[i6] = (char) ((i2 >> 15) | Privacy.DEFAULT);
                    i6 = i8 + 1;
                    this.array[i8] = (char) (32768 | i2);
                }
                this.array[this.length] = (char) i4;
                this.length = i6;
            }
        }
    }

    private void append(int i) {
        if (this.length < this.array.length || growArray()) {
            char[] cArr = this.array;
            int i2 = this.length;
            this.length = i2 + 1;
            cArr[i2] = (char) i;
        }
    }

    private boolean growArray() {
        int i;
        if (this.array.length == 100) {
            i = 2000;
        } else if (this.array.length == Integer.MAX_VALUE) {
            throw new BufferOverflowException();
        } else if (this.array.length >= 1073741823) {
            i = Integer.MAX_VALUE;
        } else {
            i = this.array.length * 2;
        }
        if (i - this.array.length < 5) {
            throw new BufferOverflowException();
        }
        this.array = Arrays.copyOf(this.array, i);
        return true;
    }

    public int lengthDelta() {
        return this.delta;
    }

    public boolean hasChanges() {
        if (this.delta != 0) {
            return true;
        }
        for (int i = 0; i < this.length; i++) {
            if (this.array[i] > 4095) {
                return true;
            }
        }
        return false;
    }

    public static final class Iterator {
        static final /* synthetic */ boolean $assertionsDisabled = (!Edits.class.desiredAssertionStatus());
        private final char[] array;
        private boolean changed;
        private final boolean coarse;
        private int destIndex;
        private int index;
        private final int length;
        private int newLength_;
        private int oldLength_;
        private final boolean onlyChanges_;
        private int remaining;
        private int replIndex;
        private int srcIndex;

        private Iterator(char[] cArr, int i, boolean z, boolean z2) {
            this.array = cArr;
            this.length = i;
            this.onlyChanges_ = z;
            this.coarse = z2;
        }

        private int readLength(int i) {
            if (i < 61) {
                return i;
            }
            if (i < 62) {
                if (!$assertionsDisabled && this.index >= this.length) {
                    throw new AssertionError();
                } else if ($assertionsDisabled || this.array[this.index] >= 32768) {
                    char[] cArr = this.array;
                    int i2 = this.index;
                    this.index = i2 + 1;
                    return cArr[i2] & 32767;
                } else {
                    throw new AssertionError();
                }
            } else if (!$assertionsDisabled && this.index + 2 > this.length) {
                throw new AssertionError();
            } else if (!$assertionsDisabled && this.array[this.index] < 32768) {
                throw new AssertionError();
            } else if ($assertionsDisabled || this.array[this.index + 1] >= 32768) {
                int i3 = ((i & 1) << 30) | ((this.array[this.index] & 32767) << 15) | (this.array[this.index + 1] & 32767);
                this.index += 2;
                return i3;
            } else {
                throw new AssertionError();
            }
        }

        private void updateIndexes() {
            this.srcIndex += this.oldLength_;
            if (this.changed) {
                this.replIndex += this.newLength_;
            }
            this.destIndex += this.newLength_;
        }

        private boolean noNext() {
            this.changed = false;
            this.newLength_ = 0;
            this.oldLength_ = 0;
            return false;
        }

        public boolean next() {
            return next(this.onlyChanges_);
        }

        private boolean next(boolean z) {
            char c;
            updateIndexes();
            if (this.remaining > 0) {
                this.remaining--;
                return true;
            } else if (this.index >= this.length) {
                return noNext();
            } else {
                char[] cArr = this.array;
                int i = this.index;
                this.index = i + 1;
                char c2 = cArr[i];
                if (c2 <= 4095) {
                    this.changed = false;
                    this.oldLength_ = c2 + 1;
                    while (this.index < this.length) {
                        char c3 = this.array[this.index];
                        c2 = c3;
                        if (c3 > 4095) {
                            break;
                        }
                        this.index++;
                        this.oldLength_ += c2 + 1;
                    }
                    this.newLength_ = this.oldLength_;
                    if (!z) {
                        return true;
                    }
                    updateIndexes();
                    if (this.index >= this.length) {
                        return noNext();
                    }
                    this.index++;
                }
                this.changed = true;
                if (c2 <= 28671) {
                    if (this.coarse) {
                        int i2 = ((c2 & 4095) + 1) * (c2 >> '\f');
                        this.newLength_ = i2;
                        this.oldLength_ = i2;
                    } else {
                        int i3 = c2 >> '\f';
                        this.newLength_ = i3;
                        this.oldLength_ = i3;
                        this.remaining = c2 & 4095;
                        return true;
                    }
                } else if ($assertionsDisabled || c2 <= 32767) {
                    this.oldLength_ = readLength((c2 >> 6) & 63);
                    this.newLength_ = readLength(c2 & '?');
                    if (!this.coarse) {
                        return true;
                    }
                } else {
                    throw new AssertionError();
                }
                while (this.index < this.length && (c = this.array[this.index]) > 4095) {
                    this.index++;
                    if (c <= 28671) {
                        int i4 = ((c & 4095) + 1) * (c >> '\f');
                        this.oldLength_ += i4;
                        this.newLength_ += i4;
                    } else if ($assertionsDisabled || c <= 32767) {
                        int readLength = readLength((c >> 6) & 63);
                        int readLength2 = readLength(c & '?');
                        this.oldLength_ += readLength;
                        this.newLength_ += readLength2;
                    } else {
                        throw new AssertionError();
                    }
                }
                return true;
            }
        }

        public boolean hasChange() {
            return this.changed;
        }

        public int oldLength() {
            return this.oldLength_;
        }

        public int newLength() {
            return this.newLength_;
        }

        public int sourceIndex() {
            return this.srcIndex;
        }

        public int replacementIndex() {
            return this.replIndex;
        }
    }

    public Iterator getCoarseIterator() {
        return new Iterator(this.array, this.length, false, true);
    }
}

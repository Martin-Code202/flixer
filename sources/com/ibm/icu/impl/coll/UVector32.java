package com.ibm.icu.impl.coll;
public final class UVector32 {
    private int[] buffer = new int[32];
    private int length = 0;

    public boolean isEmpty() {
        return this.length == 0;
    }

    public int size() {
        return this.length;
    }

    public int elementAti(int i) {
        return this.buffer[i];
    }

    public int[] getBuffer() {
        return this.buffer;
    }

    public void addElement(int i) {
        ensureAppendCapacity();
        int[] iArr = this.buffer;
        int i2 = this.length;
        this.length = i2 + 1;
        iArr[i2] = i;
    }

    public void removeAllElements() {
        this.length = 0;
    }

    private void ensureAppendCapacity() {
        if (this.length >= this.buffer.length) {
            int[] iArr = new int[(this.buffer.length <= 65535 ? this.buffer.length * 4 : this.buffer.length * 2)];
            System.arraycopy(this.buffer, 0, iArr, 0, this.length);
            this.buffer = iArr;
        }
    }
}

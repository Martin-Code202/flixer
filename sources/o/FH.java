package o;

import java.util.NoSuchElementException;
public final class FH extends EU {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f5664;

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f5665;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f5666;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final int f5667;

    public FH(int i, int i2, int i3) {
        this.f5667 = i3;
        this.f5664 = i2;
        this.f5666 = this.f5667 > 0 ? i <= i2 : i >= i2;
        this.f5665 = this.f5666 ? i : this.f5664;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f5666;
    }

    @Override // o.EU
    /* renamed from: ˏ */
    public int mo4855() {
        int i = this.f5665;
        if (i != this.f5664) {
            this.f5665 += this.f5667;
        } else if (!this.f5666) {
            throw new NoSuchElementException();
        } else {
            this.f5666 = false;
        }
        return i;
    }
}

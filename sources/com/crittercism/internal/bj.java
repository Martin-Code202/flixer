package com.crittercism.internal;
public final class bj {
    public int a = (bk.d - 1);
    public int b = bi.OK.ordinal();

    public bj(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public bj(Throwable th) {
        if (th != null) {
            this.a = bk.a(th);
            if (this.a == bk.d - 1) {
                this.b = bi.a(th).C;
            } else {
                this.b = Integer.parseInt(th.getMessage());
            }
        }
    }
}

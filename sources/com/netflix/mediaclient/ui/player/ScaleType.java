package com.netflix.mediaclient.ui.player;

import android.graphics.Matrix;
public enum ScaleType {
    CROP(0, "CROP"),
    ZOOM(1, "ZOOM"),
    FIT(2, "FIT"),
    MATRIX(3, "MATRIX");
    

    /* renamed from: ʽ  reason: contains not printable characters */
    Matrix f3659;

    /* renamed from: ˊ  reason: contains not printable characters */
    int f3660;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    String f3661;

    private ScaleType(int i, String str) {
        this.f3660 = i;
        this.f3661 = str;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public Matrix m2596() {
        return this.f3659;
    }
}

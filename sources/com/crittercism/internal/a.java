package com.crittercism.internal;

import android.util.SparseArray;
import java.text.ParseException;
public enum a {
    MOBILE(0),
    WIFI(1),
    UNKNOWN(2),
    NOT_CONNECTED(3);
    
    private static SparseArray<a> f;
    int e;

    static {
        SparseArray<a> sparseArray = new SparseArray<>();
        f = sparseArray;
        sparseArray.put(0, MOBILE);
        f.put(1, WIFI);
    }

    private a(int i) {
        this.e = i;
    }

    public static a a(int i) {
        a[] values = values();
        for (a aVar : values) {
            if (aVar.e == i) {
                return aVar;
            }
        }
        throw new ParseException("Unknown status code: " + Integer.toString(i), 0);
    }
}

package org.chromium.base;

import org.chromium.base.annotations.CalledByNative;
public abstract class Callback<T> {
    public abstract void onResult(T t);

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @CalledByNative
    private void onResultFromNative(Object obj) {
        onResult(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: org.chromium.base.Callback<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @CalledByNative
    private void onResultFromNative(boolean z) {
        onResult(Boolean.valueOf(z));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: org.chromium.base.Callback<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @CalledByNative
    private void onResultFromNative(int i) {
        onResult(Integer.valueOf(i));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: byte[] */
    /* JADX WARN: Multi-variable type inference failed */
    @CalledByNative
    private void onResultFromNative(byte[] bArr) {
        onResult(bArr);
    }
}

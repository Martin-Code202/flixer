package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* access modifiers changed from: package-private */
public final class zzehd implements Cloneable {
    private Object value;
    private zzehb<?, ?> zzngm;
    private List<zzehi> zzngn = new ArrayList();

    zzehd() {
    }

    private final byte[] toByteArray() {
        byte[] bArr = new byte[zzn()];
        zza(zzegy.zzaw(bArr));
        return bArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzcej */
    public zzehd clone() {
        zzehd zzehd = new zzehd();
        try {
            zzehd.zzngm = this.zzngm;
            if (this.zzngn == null) {
                zzehd.zzngn = null;
            } else {
                zzehd.zzngn.addAll(this.zzngn);
            }
            if (this.value != null) {
                if (this.value instanceof zzehg) {
                    zzehd.value = (zzehg) ((zzehg) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    zzehd.value = ((byte[]) this.value).clone();
                } else if (this.value instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.value;
                    byte[][] bArr2 = new byte[bArr.length][];
                    zzehd.value = bArr2;
                    for (int i = 0; i < bArr.length; i++) {
                        bArr2[i] = (byte[]) bArr[i].clone();
                    }
                } else if (this.value instanceof boolean[]) {
                    zzehd.value = ((boolean[]) this.value).clone();
                } else if (this.value instanceof int[]) {
                    zzehd.value = ((int[]) this.value).clone();
                } else if (this.value instanceof long[]) {
                    zzehd.value = ((long[]) this.value).clone();
                } else if (this.value instanceof float[]) {
                    zzehd.value = ((float[]) this.value).clone();
                } else if (this.value instanceof double[]) {
                    zzehd.value = ((double[]) this.value).clone();
                } else if (this.value instanceof zzehg[]) {
                    zzehg[] zzehgArr = (zzehg[]) this.value;
                    zzehg[] zzehgArr2 = new zzehg[zzehgArr.length];
                    zzehd.value = zzehgArr2;
                    for (int i2 = 0; i2 < zzehgArr.length; i2++) {
                        zzehgArr2[i2] = (zzehg) zzehgArr[i2].clone();
                    }
                }
            }
            return zzehd;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzehd)) {
            return false;
        }
        zzehd zzehd = (zzehd) obj;
        if (this.value == null || zzehd.value == null) {
            if (this.zzngn != null && zzehd.zzngn != null) {
                return this.zzngn.equals(zzehd.zzngn);
            }
            try {
                return Arrays.equals(toByteArray(), zzehd.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else if (this.zzngm != zzehd.zzngm) {
            return false;
        } else {
            return !this.zzngm.zzmju.isArray() ? this.value.equals(zzehd.value) : this.value instanceof byte[] ? Arrays.equals((byte[]) this.value, (byte[]) zzehd.value) : this.value instanceof int[] ? Arrays.equals((int[]) this.value, (int[]) zzehd.value) : this.value instanceof long[] ? Arrays.equals((long[]) this.value, (long[]) zzehd.value) : this.value instanceof float[] ? Arrays.equals((float[]) this.value, (float[]) zzehd.value) : this.value instanceof double[] ? Arrays.equals((double[]) this.value, (double[]) zzehd.value) : this.value instanceof boolean[] ? Arrays.equals((boolean[]) this.value, (boolean[]) zzehd.value) : Arrays.deepEquals((Object[]) this.value, (Object[]) zzehd.value);
        }
    }

    @Override // java.lang.Object
    public final int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzegy zzegy) {
        if (this.value != null) {
            zzehb<?, ?> zzehb = this.zzngm;
            Object obj = this.value;
            if (zzehb.zzngh) {
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    Object obj2 = Array.get(obj, i);
                    if (obj2 != null) {
                        zzehb.zza(obj2, zzegy);
                    }
                }
                return;
            }
            zzehb.zza(obj, zzegy);
            return;
        }
        for (zzehi zzehi : this.zzngn) {
            zzegy.zzhf(zzehi.tag);
            zzegy.zzay(zzehi.zzjaw);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzehi zzehi) {
        this.zzngn.add(zzehi);
    }

    /* access modifiers changed from: package-private */
    public final int zzn() {
        int i = 0;
        if (this.value != null) {
            zzehb<?, ?> zzehb = this.zzngm;
            Object obj = this.value;
            if (!zzehb.zzngh) {
                return zzehb.zzbw(obj);
            }
            int i2 = 0;
            int length = Array.getLength(obj);
            for (int i3 = 0; i3 < length; i3++) {
                if (Array.get(obj, i3) != null) {
                    i2 += zzehb.zzbw(Array.get(obj, i3));
                }
            }
            return i2;
        }
        for (zzehi zzehi : this.zzngn) {
            i += zzegy.zzhg(zzehi.tag) + 0 + zzehi.zzjaw.length;
        }
        return i;
    }
}

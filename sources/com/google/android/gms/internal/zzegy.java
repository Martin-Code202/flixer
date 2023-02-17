package com.google.android.gms.internal;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
public final class zzegy {
    private final ByteBuffer zzngf;

    private zzegy(ByteBuffer byteBuffer) {
        this.zzngf = byteBuffer;
        this.zzngf.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzegy(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    private static int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        int i4 = i + i2;
        while (i3 < length && i3 + i < i4) {
            char charAt = charSequence.charAt(i3);
            if (charAt >= 128) {
                break;
            }
            bArr[i + i3] = (byte) charAt;
            i3++;
        }
        if (i3 == length) {
            return i + length;
        }
        int i5 = i + i3;
        while (i3 < length) {
            char charAt2 = charSequence.charAt(i3);
            if (charAt2 < 128 && i5 < i4) {
                i5++;
                bArr[i5] = (byte) charAt2;
            } else if (charAt2 < 2048 && i5 <= i4 - 2) {
                int i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 6) | 960);
                i5 = i6 + 1;
                bArr[i6] = (byte) ((charAt2 & '?') | 128);
            } else if ((charAt2 < 55296 || 57343 < charAt2) && i5 <= i4 - 3) {
                int i7 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> '\f') | 480);
                int i8 = i7 + 1;
                bArr[i7] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i5 = i8 + 1;
                bArr[i8] = (byte) ((charAt2 & '?') | 128);
            } else if (i5 <= i4 - 4) {
                if (i3 + 1 != charSequence.length()) {
                    i3++;
                    char charAt3 = charSequence.charAt(i3);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                        int i9 = i5 + 1;
                        bArr[i5] = (byte) ((codePoint >>> 18) | 240);
                        int i10 = i9 + 1;
                        bArr[i9] = (byte) (((codePoint >>> 12) & 63) | 128);
                        int i11 = i10 + 1;
                        bArr[i10] = (byte) (((codePoint >>> 6) & 63) | 128);
                        i5 = i11 + 1;
                        bArr[i11] = (byte) ((codePoint & 63) | 128);
                    }
                }
                throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i3 - 1).toString());
            } else {
                throw new ArrayIndexOutOfBoundsException(new StringBuilder(37).append("Failed writing ").append(charAt2).append(" at index ").append(i5).toString());
            }
            i3++;
        }
        return i5;
    }

    private static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(zza(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (ArrayIndexOutOfBoundsException e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            zzb(charSequence, byteBuffer);
        }
    }

    public static int zzaf(int i, int i2) {
        return zzgs(i) + zzhd(i2);
    }

    public static zzegy zzaw(byte[] bArr) {
        return zzi(bArr, 0, bArr.length);
    }

    public static int zzb(int i, zzehg zzehg) {
        int zzgs = zzgs(i);
        int zzhi = zzehg.zzhi();
        return zzgs + zzhg(zzhi) + zzhi;
    }

    private static int zzb(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        while (true) {
            if (i >= length) {
                break;
            }
            char charAt = charSequence.charAt(i);
            if (charAt < 2048) {
                length += (127 - charAt) >>> 31;
                i++;
            } else {
                int length2 = charSequence.length();
                int i2 = 0;
                int i3 = i;
                while (i3 < length2) {
                    char charAt2 = charSequence.charAt(i3);
                    if (charAt2 < 2048) {
                        i2 += (127 - charAt2) >>> 31;
                    } else {
                        i2 += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i3) < 65536) {
                                throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i3).toString());
                            }
                            i3++;
                        }
                    }
                    i3++;
                }
                length += i2;
            }
        }
        if (length >= length) {
            return length;
        }
        throw new IllegalArgumentException(new StringBuilder(54).append("UTF-8 length does not fit in int: ").append(((long) length) + 4294967296L).toString());
    }

    private static void zzb(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 128) {
                byteBuffer.put((byte) charAt);
            } else if (charAt < 2048) {
                byteBuffer.put((byte) ((charAt >>> 6) | 960));
                byteBuffer.put((byte) ((charAt & '?') | 128));
            } else if (charAt < 55296 || 57343 < charAt) {
                byteBuffer.put((byte) ((charAt >>> '\f') | 480));
                byteBuffer.put((byte) (((charAt >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((charAt & '?') | 128));
            } else {
                if (i + 1 != charSequence.length()) {
                    i++;
                    char charAt2 = charSequence.charAt(i);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int codePoint = Character.toCodePoint(charAt, charAt2);
                        byteBuffer.put((byte) ((codePoint >>> 18) | 240));
                        byteBuffer.put((byte) (((codePoint >>> 12) & 63) | 128));
                        byteBuffer.put((byte) (((codePoint >>> 6) & 63) | 128));
                        byteBuffer.put((byte) ((codePoint & 63) | 128));
                    }
                }
                throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i - 1).toString());
            }
            i++;
        }
    }

    private final void zzcp(long j) {
        while ((-128 & j) != 0) {
            zzhe((((int) j) & 127) | 128);
            j >>>= 7;
        }
        zzhe((int) j);
    }

    public static int zzcq(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    private final void zzcr(long j) {
        if (this.zzngf.remaining() < 8) {
            throw new zzegz(this.zzngf.position(), this.zzngf.limit());
        }
        this.zzngf.putLong(j);
    }

    public static int zzg(int i, long j) {
        return zzgs(i) + zzcq(j);
    }

    public static int zzgs(int i) {
        return zzhg(i << 3);
    }

    public static int zzhd(int i) {
        if (i >= 0) {
            return zzhg(i);
        }
        return 10;
    }

    private final void zzhe(int i) {
        byte b = (byte) i;
        if (!this.zzngf.hasRemaining()) {
            throw new zzegz(this.zzngf.position(), this.zzngf.limit());
        }
        this.zzngf.put(b);
    }

    public static int zzhg(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (-268435456 & i) == 0 ? 4 : 5;
    }

    public static zzegy zzi(byte[] bArr, int i, int i2) {
        return new zzegy(bArr, 0, i2);
    }

    public static int zzm(int i, String str) {
        return zzgs(i) + zzrk(str);
    }

    public static int zzrk(String str) {
        int zzb = zzb(str);
        return zzhg(zzb) + zzb;
    }

    public final void zza(int i, double d) {
        zzu(i, 1);
        zzcr(Double.doubleToLongBits(d));
    }

    public final void zza(int i, long j) {
        zzu(i, 0);
        zzcp(j);
    }

    public final void zza(int i, zzehg zzehg) {
        zzu(i, 2);
        zzb(zzehg);
    }

    public final void zzay(byte[] bArr) {
        int length = bArr.length;
        if (this.zzngf.remaining() >= length) {
            this.zzngf.put(bArr, 0, length);
            return;
        }
        throw new zzegz(this.zzngf.position(), this.zzngf.limit());
    }

    public final void zzb(zzehg zzehg) {
        zzhf(zzehg.zzceo());
        zzehg.zza(this);
    }

    public final void zzc(int i, float f) {
        zzu(i, 5);
        int floatToIntBits = Float.floatToIntBits(f);
        if (this.zzngf.remaining() < 4) {
            throw new zzegz(this.zzngf.position(), this.zzngf.limit());
        }
        this.zzngf.putInt(floatToIntBits);
    }

    public final void zzccm() {
        if (this.zzngf.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", Integer.valueOf(this.zzngf.remaining())));
        }
    }

    public final void zze(int i, long j) {
        zzu(i, 0);
        zzcp(j);
    }

    public final void zzhf(int i) {
        while ((i & -128) != 0) {
            zzhe((i & 127) | 128);
            i >>>= 7;
        }
        zzhe(i);
    }

    public final void zzl(int i, String str) {
        zzu(i, 2);
        try {
            int zzhg = zzhg(str.length());
            if (zzhg == zzhg(str.length() * 3)) {
                int position = this.zzngf.position();
                if (this.zzngf.remaining() < zzhg) {
                    throw new zzegz(position + zzhg, this.zzngf.limit());
                }
                this.zzngf.position(position + zzhg);
                zza(str, this.zzngf);
                int position2 = this.zzngf.position();
                this.zzngf.position(position);
                zzhf((position2 - position) - zzhg);
                this.zzngf.position(position2);
                return;
            }
            zzhf(zzb(str));
            zza(str, this.zzngf);
        } catch (BufferOverflowException e) {
            zzegz zzegz = new zzegz(this.zzngf.position(), this.zzngf.limit());
            zzegz.initCause(e);
            throw zzegz;
        }
    }

    public final void zzl(int i, boolean z) {
        zzu(i, 0);
        byte b = (byte) (z ? 1 : 0);
        if (!this.zzngf.hasRemaining()) {
            throw new zzegz(this.zzngf.position(), this.zzngf.limit());
        }
        this.zzngf.put(b);
    }

    public final void zzu(int i, int i2) {
        zzhf((i << 3) | i2);
    }

    public final void zzv(int i, int i2) {
        zzu(i, 0);
        if (i2 >= 0) {
            zzhf(i2);
        } else {
            zzcp((long) i2);
        }
    }
}

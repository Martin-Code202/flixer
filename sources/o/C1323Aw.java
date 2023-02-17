package o;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* renamed from: o.Aw  reason: case insensitive filesystem */
public final class C1323Aw {

    /* renamed from: ʽ  reason: contains not printable characters */
    private static final byte[] f4545 = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final byte[] f4546 = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final byte[] f4547 = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final byte[] f4548 = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final byte[] f4549 = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: ॱ  reason: contains not printable characters */
    static final /* synthetic */ boolean f4550 = (!C1323Aw.class.desiredAssertionStatus());

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static final byte[] f4551 = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final byte[] m3803(int i) {
        if ((i & 16) == 16) {
            return f4546;
        }
        if ((i & 32) == 32) {
            return f4545;
        }
        return f4548;
    }

    /* access modifiers changed from: private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public static final byte[] m3797(int i) {
        if ((i & 16) == 16) {
            return f4547;
        }
        if ((i & 32) == 32) {
            return f4551;
        }
        return f4549;
    }

    private C1323Aw() {
    }

    /* access modifiers changed from: private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public static byte[] m3806(byte[] bArr, byte[] bArr2, int i, int i2) {
        m3798(bArr2, 0, i, bArr, 0, i2);
        return bArr;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static byte[] m3798(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        byte[] r3 = m3803(i4);
        int i5 = (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0) | (i2 > 2 ? (bArr[i + 2] << 24) >>> 24 : 0);
        switch (i2) {
            case 1:
                bArr2[i3] = r3[i5 >>> 18];
                bArr2[i3 + 1] = r3[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = 61;
                bArr2[i3 + 3] = 61;
                return bArr2;
            case 2:
                bArr2[i3] = r3[i5 >>> 18];
                bArr2[i3 + 1] = r3[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = r3[(i5 >>> 6) & 63];
                bArr2[i3 + 3] = 61;
                return bArr2;
            case 3:
                bArr2[i3] = r3[i5 >>> 18];
                bArr2[i3 + 1] = r3[(i5 >>> 12) & 63];
                bArr2[i3 + 2] = r3[(i5 >>> 6) & 63];
                bArr2[i3 + 3] = r3[i5 & 63];
                return bArr2;
            default:
                return bArr2;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m3795(byte[] bArr) {
        return m3796(bArr, 0, bArr.length, 0);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m3796(byte[] bArr, int i, int i2, int i3) {
        byte[] r2 = m3804(bArr, i, i2, i3);
        try {
            return new String(r2, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            return new String(r2);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static byte[] m3804(byte[] bArr, int i, int i2, int i3) {
        if (bArr == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        } else if (i < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i);
        } else if (i2 < 0) {
            throw new IllegalArgumentException("Cannot have length offset: " + i2);
        } else if (i + i2 > bArr.length) {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length)));
        } else if ((i3 & 2) != 0) {
            ByteArrayOutputStream byteArrayOutputStream = null;
            GZIPOutputStream gZIPOutputStream = null;
            Cif ifVar = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                ifVar = new Cif(byteArrayOutputStream, i3 | 1);
                gZIPOutputStream = new GZIPOutputStream(ifVar);
                gZIPOutputStream.write(bArr, i, i2);
                gZIPOutputStream.close();
                try {
                    gZIPOutputStream.close();
                } catch (Exception e) {
                }
                try {
                    ifVar.close();
                } catch (Exception e2) {
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e3) {
                }
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e4) {
                throw e4;
            } catch (Throwable th) {
                try {
                    gZIPOutputStream.close();
                } catch (Exception e5) {
                }
                try {
                    ifVar.close();
                } catch (Exception e6) {
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e7) {
                }
                throw th;
            }
        } else {
            boolean z = (i3 & 8) != 0;
            int i4 = ((i2 / 3) * 4) + (i2 % 3 > 0 ? 4 : 0);
            if (z) {
                i4 += i4 / 76;
            }
            byte[] bArr2 = new byte[i4];
            int i5 = 0;
            int i6 = 0;
            int i7 = i2 - 2;
            int i8 = 0;
            while (i5 < i7) {
                m3798(bArr, i5 + i, 3, bArr2, i6, i3);
                i8 += 4;
                if (z && i8 >= 76) {
                    bArr2[i6 + 4] = 10;
                    i6++;
                    i8 = 0;
                }
                i5 += 3;
                i6 += 4;
            }
            if (i5 < i2) {
                m3798(bArr, i5 + i, i2 - i5, bArr2, i6, i3);
                i6 += 4;
            }
            if (i6 > bArr2.length - 1) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i6];
            System.arraycopy(bArr2, 0, bArr3, 0, i6);
            return bArr3;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public static int m3807(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (bArr == null) {
            throw new IllegalArgumentException("Source array was null.");
        } else if (bArr2 == null) {
            throw new IllegalArgumentException("Destination array was null.");
        } else if (i < 0 || i + 3 >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i)));
        } else if (i2 < 0 || i2 + 2 >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(bArr2.length), Integer.valueOf(i2)));
        } else {
            byte[] r5 = m3797(i3);
            if (bArr[i + 2] == 61) {
                bArr2[i2] = (byte) ((((r5[bArr[i]] & 255) << 18) | ((r5[bArr[i + 1]] & 255) << 12)) >>> 16);
                return 1;
            } else if (bArr[i + 3] == 61) {
                int i4 = ((r5[bArr[i]] & 255) << 18) | ((r5[bArr[i + 1]] & 255) << 12) | ((r5[bArr[i + 2]] & 255) << 6);
                bArr2[i2] = (byte) (i4 >>> 16);
                bArr2[i2 + 1] = (byte) (i4 >>> 8);
                return 2;
            } else {
                int i5 = ((r5[bArr[i]] & 255) << 18) | ((r5[bArr[i + 1]] & 255) << 12) | ((r5[bArr[i + 2]] & 255) << 6) | (r5[bArr[i + 3]] & 255);
                bArr2[i2] = (byte) (i5 >> 16);
                bArr2[i2 + 1] = (byte) (i5 >> 8);
                bArr2[i2 + 2] = (byte) i5;
                return 3;
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m3802(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static byte[] m3805(byte[] bArr, int i, int i2, int i3) {
        if (bArr == null) {
            throw new IllegalArgumentException("Cannot decode null source array.");
        } else if (i < 0 || i + i2 > bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        } else if (i2 == 0) {
            return new byte[0];
        } else {
            if (i2 < 4) {
                throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + i2);
            }
            byte[] r5 = m3797(i3);
            byte[] bArr2 = new byte[((i2 * 3) / 4)];
            int i4 = 0;
            byte[] bArr3 = new byte[4];
            int i5 = 0;
            for (int i6 = i; i6 < i + i2; i6++) {
                byte b = r5[bArr[i6] & 255];
                if (b >= -5) {
                    if (b >= -1) {
                        i5++;
                        bArr3[i5] = bArr[i6];
                        if (i5 > 3) {
                            i4 += m3807(bArr3, 0, bArr2, i4, i3);
                            i5 = 0;
                            if (bArr[i6] == 61) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                } else {
                    throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", Integer.valueOf(bArr[i6] & 255), Integer.valueOf(i6)));
                }
            }
            byte[] bArr4 = new byte[i4];
            System.arraycopy(bArr2, 0, bArr4, 0, i4);
            return bArr4;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static byte[] m3800(String str) {
        return m3808(str, 0);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static byte[] m3808(String str, int i) {
        byte[] bArr;
        if (str == null) {
            throw new IllegalArgumentException("Input string was null.");
        }
        try {
            bArr = str.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException e) {
            bArr = str.getBytes();
        }
        byte[] r3 = m3805(bArr, 0, bArr.length, i);
        boolean z = (i & 4) != 0;
        if (r3 != null && r3.length >= 4 && !z && 35615 == ((r3[0] & 255) | ((r3[1] << 8) & 65280))) {
            ByteArrayInputStream byteArrayInputStream = null;
            GZIPInputStream gZIPInputStream = null;
            ByteArrayOutputStream byteArrayOutputStream = null;
            byte[] bArr2 = new byte[2048];
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayInputStream = new ByteArrayInputStream(r3);
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                while (true) {
                    int read = gZIPInputStream.read(bArr2);
                    if (read < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                r3 = byteArrayOutputStream.toByteArray();
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e2) {
                }
                try {
                    gZIPInputStream.close();
                } catch (Exception e3) {
                }
                try {
                    byteArrayInputStream.close();
                } catch (Exception e4) {
                }
            }
        }
        return r3;
    }

    /* renamed from: o.Aw$if  reason: invalid class name */
    public static class Cif extends FilterOutputStream {

        /* renamed from: ʻ  reason: contains not printable characters */
        private boolean f4552;

        /* renamed from: ʼ  reason: contains not printable characters */
        private int f4553;

        /* renamed from: ʽ  reason: contains not printable characters */
        private byte[] f4554;

        /* renamed from: ˊ  reason: contains not printable characters */
        private int f4555;

        /* renamed from: ˋ  reason: contains not printable characters */
        private boolean f4556;

        /* renamed from: ˎ  reason: contains not printable characters */
        private byte[] f4557;

        /* renamed from: ˏ  reason: contains not printable characters */
        private int f4558;

        /* renamed from: ॱ  reason: contains not printable characters */
        private int f4559;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        private boolean f4560;

        /* renamed from: ᐝ  reason: contains not printable characters */
        private byte[] f4561;

        public Cif(OutputStream outputStream, int i) {
            super(outputStream);
            this.f4560 = (i & 8) != 0;
            this.f4556 = (i & 1) != 0;
            this.f4555 = this.f4556 ? 3 : 4;
            this.f4557 = new byte[this.f4555];
            this.f4559 = 0;
            this.f4558 = 0;
            this.f4552 = false;
            this.f4561 = new byte[4];
            this.f4553 = i;
            this.f4554 = C1323Aw.m3797(i);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i) {
            if (this.f4552) {
                this.out.write(i);
            } else if (this.f4556) {
                byte[] bArr = this.f4557;
                int i2 = this.f4559;
                this.f4559 = i2 + 1;
                bArr[i2] = (byte) i;
                if (this.f4559 >= this.f4555) {
                    this.out.write(C1323Aw.m3806(this.f4561, this.f4557, this.f4555, this.f4553));
                    this.f4558 += 4;
                    if (this.f4560 && this.f4558 >= 76) {
                        this.out.write(10);
                        this.f4558 = 0;
                    }
                    this.f4559 = 0;
                }
            } else if (this.f4554[i & 127] > -5) {
                byte[] bArr2 = this.f4557;
                int i3 = this.f4559;
                this.f4559 = i3 + 1;
                bArr2[i3] = (byte) i;
                if (this.f4559 >= this.f4555) {
                    this.out.write(this.f4561, 0, C1323Aw.m3807(this.f4557, 0, this.f4561, 0, this.f4553));
                    this.f4559 = 0;
                }
            } else if (this.f4554[i & 127] != -5) {
                throw new IOException("Invalid character in Base64 data.");
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            if (this.f4552) {
                this.out.write(bArr, i, i2);
                return;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                write(bArr[i + i3]);
            }
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public void m3810() {
            if (this.f4559 <= 0) {
                return;
            }
            if (this.f4556) {
                this.out.write(C1323Aw.m3806(this.f4561, this.f4557, this.f4559, this.f4553));
                this.f4559 = 0;
                return;
            }
            throw new IOException("Base64 input not properly padded.");
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            m3810();
            super.close();
            this.f4557 = null;
            this.out = null;
        }
    }
}

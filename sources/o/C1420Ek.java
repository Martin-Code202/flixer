package o;

import com.netflix.msl.MslConstants;
import com.netflix.msl.MslException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* renamed from: o.Ek  reason: case insensitive filesystem */
public class C1420Ek {
    /* renamed from: ॱ  reason: contains not printable characters */
    public static byte[] m4900(MslConstants.CompressionAlgorithm compressionAlgorithm, byte[] bArr) {
        try {
            switch (compressionAlgorithm) {
                case GZIP:
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream.write(bArr);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (byteArray.length < bArr.length) {
                            return byteArray;
                        }
                        return null;
                    } finally {
                        gZIPOutputStream.close();
                    }
                case LZW:
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(bArr.length);
                    C1402Ds ds = new C1402Ds(byteArrayOutputStream2);
                    try {
                        ds.write(bArr);
                        byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                        if (byteArray2.length < bArr.length) {
                            return byteArray2;
                        }
                        return null;
                    } finally {
                        ds.close();
                    }
                default:
                    throw new MslException(CK.f4756, compressionAlgorithm.name());
            }
        } catch (IOException e) {
            throw new MslException(CK.f4762, "algo " + compressionAlgorithm.name() + " data " + C1418Ei.m4892(bArr), e);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static byte[] m4899(MslConstants.CompressionAlgorithm compressionAlgorithm, byte[] bArr) {
        try {
            switch (compressionAlgorithm) {
                case GZIP:
                    GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
                    try {
                        byte[] bArr2 = new byte[bArr.length];
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
                        while (true) {
                            if (bArr2.length > 0) {
                                int read = gZIPInputStream.read(bArr2);
                                if (read != -1) {
                                    byteArrayOutputStream.write(bArr2, 0, read);
                                }
                            }
                        }
                        return byteArrayOutputStream.toByteArray();
                    } finally {
                        gZIPInputStream.close();
                    }
                case LZW:
                    C1398Do r5 = new C1398Do(new ByteArrayInputStream(bArr));
                    try {
                        byte[] bArr3 = new byte[bArr.length];
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(bArr.length);
                        while (true) {
                            if (bArr3.length > 0) {
                                int read2 = r5.read(bArr3);
                                if (read2 != -1) {
                                    byteArrayOutputStream2.write(bArr3, 0, read2);
                                }
                            }
                        }
                        return byteArrayOutputStream2.toByteArray();
                    } finally {
                        r5.close();
                    }
                default:
                    throw new MslException(CK.f4756, compressionAlgorithm.name());
            }
        } catch (IOException e) {
            throw new MslException(CK.f4768, "algo " + compressionAlgorithm.name() + " data " + C1418Ei.m4892(bArr), e);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m4898(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            i |= bArr[i2] ^ bArr2[i2];
        }
        return i == 0;
    }
}

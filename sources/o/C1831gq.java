package o;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.linphone.core.Privacy;
/* renamed from: o.gq  reason: case insensitive filesystem */
public class C1831gq {
    /* renamed from: ˋ  reason: contains not printable characters */
    static String m6694(byte[] bArr, String str) {
        int i;
        if (!m6697(bArr)) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            if (bytes.length == 0) {
                C1283.m16865("MdxTargetCryptContext", "encrypt input data size is 0");
                return null;
            }
            try {
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, 32, 16, "AES");
                byte[] bArr2 = new byte[16];
                new Random().nextBytes(bArr2);
                instance.init(1, secretKeySpec, new IvParameterSpec(bArr2));
                byte[] doFinal = instance.doFinal(bytes);
                int length = doFinal.length;
                if (length == 0 || length > 32767) {
                    C1283.m16855("MdxTargetCryptContext", "incorrect encrypt ciphertext data size %x", Integer.valueOf(length));
                    return null;
                }
                int r13 = m6693(16) + 1 + 16 + m6693(length) + length;
                C1283.m16863("MdxTargetCryptContext", "data length %d, envelop length %d", Integer.valueOf(length), Integer.valueOf(r13));
                byte[] bArr3 = new byte[r13];
                bArr3[0] = 2;
                bArr3[1] = 16;
                System.arraycopy(bArr2, 0, bArr3, 2, 16);
                if (length > 16383) {
                    return null;
                }
                if (length <= 127) {
                    i = 18 + 1;
                    bArr3[18] = (byte) length;
                } else {
                    bArr3[18] = (byte) (((length >> 8) & 63) | 128);
                    i = 18 + 1 + 1;
                    bArr3[19] = (byte) (length & 255);
                }
                System.arraycopy(doFinal, 0, bArr3, i, length);
                return C1418Ei.m4892(bArr3);
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                C1283.m16855("MdxTargetCryptContext", "encrypt exception %s", e);
                return null;
            }
        } catch (InvalidAlgorithmParameterException e2) {
            C1283.m16855("MdxTargetCryptContext", "encrypt exception %s", e2);
            return null;
        } catch (InvalidKeyException e3) {
            C1283.m16855("MdxTargetCryptContext", "encrypt exception %s", e3);
            return null;
        } catch (BadPaddingException e4) {
            C1283.m16855("MdxTargetCryptContext", "encrypt exception %s", e4);
            return null;
        } catch (IllegalBlockSizeException e5) {
            C1283.m16855("MdxTargetCryptContext", "encrypt exception %s", e5);
            return null;
        } catch (UnsupportedEncodingException e6) {
            C1283.m16855("MdxTargetCryptContext", "encrypt exception %s", e6);
            return null;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    static String m6696(byte[] bArr, String str) {
        if (!m6697(bArr)) {
            return null;
        }
        byte[] r5 = C1418Ei.m4894(str);
        if (r5.length <= 17) {
            C1283.m16855("MdxTargetCryptContext", "decrypt input not enough for IV %d", Integer.valueOf(r5.length));
            return null;
        } else if (r5[0] == 2 || r5[1] == 16) {
            try {
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                instance.init(2, new SecretKeySpec(bArr, 32, 16, "AES"), new IvParameterSpec(r5, 2, 16));
                int i = 18;
                int i2 = 0;
                byte[] bArr2 = new byte[(r5.length - 18)];
                while (true) {
                    if (i < r5.length) {
                        int i3 = i + 1;
                        int i4 = r5[i] & 255;
                        if (i4 > 192) {
                            switch (i4) {
                                case 193:
                                    i4 = 16384;
                                    break;
                                case 194:
                                    i4 = Privacy.DEFAULT;
                                    break;
                                case 195:
                                    i4 = 49152;
                                    break;
                                case 196:
                                    i4 = 65536;
                                    break;
                                default:
                                    C1283.m16844("MdxTargetCryptContext", "has invlid chunk size %x", Integer.valueOf(i4));
                                    return null;
                            }
                        } else if ((i4 & 192) == 128) {
                            try {
                                if (i3 != r5.length) {
                                    i3++;
                                    i4 = ((i4 & 63) << 8) | (r5[i3] & 255);
                                }
                            } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                                C1283.m16855("MdxTargetCryptContext", "decrypt exception %s", e);
                                return null;
                            }
                        }
                        C1283.m16863("MdxTargetCryptContext", "has chunck size 0x%x", Integer.valueOf(i4));
                        if (i4 > 0) {
                            C1283.m16863("MdxTargetCryptContext", "copy buffer data from offset %d to %d", Integer.valueOf(i3), Integer.valueOf(i2));
                            if (i3 + i4 > r5.length) {
                                C1283.m16844("MdxTargetCryptContext", "has invlid chunk size %x", Integer.valueOf(i4));
                                return null;
                            }
                            System.arraycopy(r5, i3, bArr2, i2, i4);
                            i = i3 + i4;
                            i2 += i4;
                        }
                    }
                }
                if (i2 > 0) {
                    return new String(instance.doFinal(bArr2, 0, i2));
                }
                return null;
            } catch (InvalidAlgorithmParameterException e2) {
                C1283.m16855("MdxTargetCryptContext", "decrypt exception %s", e2);
                return null;
            } catch (InvalidKeyException e3) {
                C1283.m16855("MdxTargetCryptContext", "decrypt exception %s", e3);
                return null;
            } catch (BadPaddingException e4) {
                C1283.m16855("MdxTargetCryptContext", "decrypt exception %s", e4);
                return null;
            } catch (IllegalBlockSizeException e5) {
                C1283.m16855("MdxTargetCryptContext", "decrypt exception %s", e5);
                return null;
            }
        } else {
            C1283.m16855("MdxTargetCryptContext", "decrypt input has wrong version/iv_siz %d %d", Byte.valueOf(r5[0]), Byte.valueOf(r5[1]));
            return null;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    static String m6695(byte[] bArr, String str) {
        if (!m6697(bArr)) {
            return null;
        }
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(new SecretKeySpec(bArr, 0, 32, "HmacSHA256"));
            return C1418Ei.m4892(instance.doFinal(str.getBytes("UTF-8")));
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            C1283.m16855("MdxTargetCryptContext", "hmac has exception %s", e);
            return null;
        } catch (UnsupportedEncodingException e2) {
            C1283.m16855("MdxTargetCryptContext", "hmac has exception %s", e2);
            return null;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static boolean m6697(byte[] bArr) {
        return bArr != null && bArr.length >= 48;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static int m6693(int i) {
        if (i <= 127) {
            return 1;
        }
        if (i <= 32767) {
            return 2;
        }
        return -1;
    }
}

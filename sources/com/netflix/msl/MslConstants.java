package com.netflix.msl;

import java.nio.charset.Charset;
import java.util.Set;
public abstract class MslConstants {

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final Charset f4100 = Charset.forName("UTF-8");

    public enum CompressionAlgorithm {
        GZIP,
        LZW;

        /* renamed from: ॱ  reason: contains not printable characters */
        public static CompressionAlgorithm m3071(Set<CompressionAlgorithm> set) {
            CompressionAlgorithm[] values = values();
            for (int i = 0; i < values.length && set.size() > 0; i++) {
                CompressionAlgorithm compressionAlgorithm = values[i];
                if (set.contains(compressionAlgorithm)) {
                    return compressionAlgorithm;
                }
            }
            return null;
        }
    }

    public enum EncryptionAlgo {
        AES;

        /* renamed from: ˋ  reason: contains not printable characters */
        public static EncryptionAlgo m3072(String str) {
            return (EncryptionAlgo) valueOf(EncryptionAlgo.class, str);
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return name();
        }
    }

    public enum CipherSpec {
        AES_CBC_PKCS5Padding,
        AESWrap,
        RSA_ECB_PKCS1Padding;

        /* renamed from: ˊ  reason: contains not printable characters */
        public static CipherSpec m3070(String str) {
            if ("AES/CBC/PKCS5Padding".equals(str)) {
                return AES_CBC_PKCS5Padding;
            }
            if ("RSA/ECB/PKCS1Padding".equals(str)) {
                return RSA_ECB_PKCS1Padding;
            }
            return (CipherSpec) valueOf(CipherSpec.class, str);
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            switch (this) {
                case AES_CBC_PKCS5Padding:
                    return "AES/CBC/PKCS5Padding";
                case RSA_ECB_PKCS1Padding:
                    return "RSA/ECB/PKCS1Padding";
                default:
                    return name();
            }
        }
    }

    public enum SignatureAlgo {
        HmacSHA256,
        SHA256withRSA,
        AESCmac;

        /* renamed from: ॱ  reason: contains not printable characters */
        public static SignatureAlgo m3075(String str) {
            return (SignatureAlgo) valueOf(SignatureAlgo.class, str);
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return name();
        }
    }

    public enum ResponseCode {
        FAIL(1),
        TRANSIENT_FAILURE(2),
        ENTITY_REAUTH(3),
        USER_REAUTH(4),
        KEYX_REQUIRED(5),
        ENTITYDATA_REAUTH(6),
        USERDATA_REAUTH(7),
        EXPIRED(8),
        REPLAYED(9),
        SSOTOKEN_REJECTED(10);
        

        /* renamed from: ॱˊ  reason: contains not printable characters */
        private final int f4122;

        /* renamed from: ॱ  reason: contains not printable characters */
        public static ResponseCode m3073(int i) {
            ResponseCode[] values = values();
            for (ResponseCode responseCode : values) {
                if (responseCode.m3074() == i) {
                    return responseCode;
                }
            }
            throw new IllegalArgumentException("Unknown response code value " + i + ".");
        }

        private ResponseCode(int i) {
            this.f4122 = i;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public int m3074() {
            return this.f4122;
        }
    }
}

package com.netflix.mediaclient.acquisition.util.crypto;

import android.util.Base64;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;
import kotlin.TypeCastException;
import o.C1457Fr;
import o.Gd;
public final class SecureMOP {
    public static final SecureMOP INSTANCE = new SecureMOP();

    private SecureMOP() {
    }

    public final String encrypt(NetflixPublicKey netflixPublicKey, String str) {
        C1457Fr.m5025(netflixPublicKey, "nfPublicKey");
        C1457Fr.m5025(str, "payload");
        byte[] bytes = str.getBytes(Gd.f5691);
        C1457Fr.m5016((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        Cipher instance = Cipher.getInstance("RSA/NONE/OAEPPadding", "BC");
        instance.init(1, KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(netflixPublicKey.getModulus(), 16), new BigInteger(netflixPublicKey.getExponent(), 16))), new SecureRandom());
        String str2 = "{\"EDATA\":\"" + Base64.encodeToString(instance.doFinal(bytes), 2) + "\",\"AID\":" + netflixPublicKey.getAid() + ",\"KID\":" + netflixPublicKey.getKid() + '}';
        Charset charset = Gd.f5691;
        if (str2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes2 = str2.getBytes(charset);
        C1457Fr.m5016((Object) bytes2, "(this as java.lang.String).getBytes(charset)");
        return "{ \"VERSION\": 1, \"PAYLOAD\":\"" + Base64.encodeToString(bytes2, 10) + "\"}";
    }
}

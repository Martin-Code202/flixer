package com.netflix.msl.crypto;

import com.netflix.msl.MslInternalException;
import com.netflix.msl.util.MslContext;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.spec.OAEPParameterSpec;
import o.CY;
public class RsaCryptoContext extends CY {

    public enum Mode {
        ENCRYPT_DECRYPT_OAEP,
        ENCRYPT_DECRYPT_PKCS1,
        WRAP_UNWRAP,
        SIGN_VERIFY
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RsaCryptoContext(MslContext mslContext, String str, PrivateKey privateKey, PublicKey publicKey, Mode mode) {
        super(str, privateKey, publicKey, Mode.ENCRYPT_DECRYPT_PKCS1.equals(mode) ? "RSA/ECB/PKCS1Padding" : Mode.ENCRYPT_DECRYPT_OAEP.equals(mode) ? "RSA/ECB/OAEPPadding" : "nullOp", Mode.ENCRYPT_DECRYPT_OAEP.equals(mode) ? OAEPParameterSpec.DEFAULT : null, Mode.SIGN_VERIFY.equals(mode) ? "SHA256withRSA" : "nullOp");
        if (mode == Mode.WRAP_UNWRAP) {
            throw new MslInternalException("Wrap/unwrap unsupported.");
        }
    }
}

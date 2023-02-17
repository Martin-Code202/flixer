package o;

import android.content.Context;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
/* renamed from: o.gy  reason: case insensitive filesystem */
public class C1839gy implements CW {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Map<String, PublicKey> f7048 = new HashMap();

    /* renamed from: ˋ  reason: contains not printable characters */
    private final KeyFactory f7049;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Map<String, String> f7050 = new HashMap();

    /* renamed from: ˏ  reason: contains not printable characters */
    private Context f7051;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Map<String, PrivateKey> f7052 = new HashMap();

    public C1839gy(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context can not be null");
        }
        this.f7051 = context;
        try {
            this.f7049 = KeyFactory.getInstance("RSA");
            m6794();
            mo4321("APPBOOT", m6795());
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("Unable to get RSA key factory", e);
        }
    }

    @Override // o.AbstractC1397Dn
    /* renamed from: ˊ */
    public synchronized PublicKey mo4720(String str) {
        return this.f7048.get(str);
    }

    @Override // o.AbstractC1397Dn
    /* renamed from: ॱ */
    public synchronized PrivateKey mo4721(String str) {
        return this.f7052.get(str);
    }

    @Override // o.CW
    /* renamed from: ˎ */
    public synchronized void mo4321(String str, String str2) {
        m6796(str, str2, true);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m6796(String str, String str2, boolean z) {
        m6799(str, C1418Ei.m4894(str2));
        if (z) {
            m6797(str, str2);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m6799(String str, byte[] bArr) {
        try {
            PublicKey generatePublic = this.f7049.generatePublic(new X509EncodedKeySpec(bArr));
            if (!(generatePublic instanceof RSAPublicKey)) {
                throw new IllegalArgumentException("Public key is not an instance of RSAPublicKey.");
            }
            this.f7048.put(str, generatePublic);
        } catch (InvalidKeySpecException e) {
            throw new IllegalArgumentException("Public key can not be parsed", e);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private synchronized void m6798() {
        C1283.m16854("nf_msl_rsastore", "save:: started.");
        C0355 r2 = new C0355();
        C0572 r3 = new C0572();
        for (String str : this.f7050.keySet()) {
            C0355 r7 = new C0355();
            r7.m13986("identity", str);
            r7.m13986("encodedKey", this.f7050.get(str));
            r3.m14672(r7);
        }
        r2.m13986("publicKeys", r3);
        C1339Bl.m4039(this.f7051, "nf_msl_rsa_store_json", r2.toString());
        C1283.m16854("nf_msl_rsastore", "save:: done.");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m6797(String str, String str2) {
        if (C1349Bv.m4113(str) || C1349Bv.m4113(str2)) {
            C1283.m16865("nf_msl_rsastore", "Empty identity and/or raw public key. It should NOT happen!");
        } else if ("APPBOOT".equals(str)) {
            C1283.m16854("nf_msl_rsastore", "Do not add APPBOOT to persistence...");
        } else {
            this.f7050.put(str, str2);
            try {
                m6798();
            } catch (Throwable th) {
                C1283.m16856("nf_msl_rsastore", th, "Failed to save RSA store to persistenace: ", new Object[0]);
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m6794() {
        try {
            String r3 = C1339Bl.m4045(this.f7051, "nf_msl_rsa_store_json", (String) null);
            if (C1349Bv.m4113(r3)) {
                C1283.m16854("nf_msl_rsastore", "RSA store not found...");
                return;
            }
            C0572 r5 = new C0355(r3).m13971("publicKeys");
            if (r5 == null) {
                C1283.m16850("nf_msl_rsastore", "Public keys array NOT found!");
                return;
            }
            for (int i = 0; i < r5.m14673(); i++) {
                C0355 r7 = r5.m14667(i);
                m6796(r7.m13972("identity"), r7.m13972("encodedKey"), false);
            }
        } catch (Throwable th) {
            C1283.m16856("nf_msl_rsastore", th, "Failed to create public key JSON object: ", new Object[0]);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String m6795() {
        if (!C1337Bj.m4030()) {
            return "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAniUdnoFyqHUerpq3zqrStDVAdmDXg90ARWUjelG8L/JYmLC/z1AxlFoqcbwvcrLonaguZVW1WH8cZzl2EQGDMeydZyDq2zTNh+2mVvrPxiqoVx9rVOtQScJzxVYvbkcgxHEwQJMz1DsM+42bjuOsruNshvTCm+eq6he8SwvCGV4ny0pe/jwY+JZcO+CxTw7/zEHrn9nQo/8doOU8DaMrC20KaW0ss/R3dj5ofonouyRInr1nwpFPZzZvFf9lMJnxS0com8RDnTQpe2GsKt7HMl6p9eQiPCNXy8ACTD9kEwbM5WZoUj5T3eTY4VgCL7HTXZ09wta7M9utfHt3rvMctxCSrzR02SaSPA5LxnW0rzM9KYabZs+77wvXo1I0Cf6+pjWqsJjwhIYEQMlHw8q4l/I/CPdLNlqPH2KplapDGvZSTF1znTiQRowK3U65GJBb+Qdr1GBbVf+pYWRldujhW1+iU+wp8B4BFInLwLUgc/iFi/gN9xSWMDJiw79C02L59542l4CvsTJdAoNOZvdvEUxrpWS+ewP1y73fJvqX5Po5Hqm+h97Rg3ABVQ48lh5N8hSFB4gUX343QzxP/wT6keoCfDAzn99tutavJRExaboF32CJjA4yopgurkYUO5YgQigGiiV38Nrv2x8Aa0QX6+XhRmKksV6z90t/4mu9OQkCAwEAAQ==";
        }
        return "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEA1h/UVRYyyDMlfY4eEiGTAYH8enFcyOaAyW3ulv1X/lCZL8pdk4KywDxssdhvkj8ib7vrrK8ktf/aeTxzezR6HVcS9JZ9kIfTgGrTVnUHFjcYOBdPAaeJl7Mx8+ubAlYeMwsOaG/nHD96/7RkqxF0+FB4RKZTnfjTziZaIEkmLLb+ifyB5mvk8SVa7i8qJf2Dw2l/0uxp93558Dl9xeAOH3Hz3G7wgtxnL71BSOE8H9s7z4etQmuSdf++n++C9HeszauVohHhgtejw+qqf63a8R9/6MeJwh/VRJTw7nXM2PN+8ERpQzJR+AWOkHqbC2mgvSYEFMtBhodOxnp73bR7LMIAbObrTm7VDQBcav5wWlH+KPCaBR0VCRSy9GG23CHOsuWVln2idnDz/zFBHnVnWKVAanZ3Ot4LmM2nrJvSlrt1OiQSLaI+CJHO8InfVTQEXpduoiGkLpc1HcmWNF98JuA8ZX3tqmcncdHnEMG3A5hZVnM6MrsidcQTsojl/MuoXrMeuWkvQQUe4wklBHleLs6jA/Au0oT4Q34luCvG3C32N2XiUcAeFdGd3MuDlDjqG88A9CLd21eh1HqkHD76qeWGnwumLHyJmqL25Lmz4LMjJ/nkXaY9r4Fya2/I/aV9kt5lCaPY3Wb4nDivjPqM6iP9vHCKOMxwjvbE4DFgN60CAwEAAQ==";
    }
}

package o;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.eC  reason: case insensitive filesystem */
final class C1690eC {

    /* renamed from: ʻ  reason: contains not printable characters */
    final String f6445 = "ciphertext";

    /* renamed from: ʼ  reason: contains not printable characters */
    final int f6446 = 16;

    /* renamed from: ʽ  reason: contains not printable characters */
    final String f6447 = "iv";

    /* renamed from: ˊ  reason: contains not printable characters */
    final String f6448 = "movies";

    /* renamed from: ˊॱ  reason: contains not printable characters */
    final byte f6449 = 1;

    /* renamed from: ˋ  reason: contains not printable characters */
    final String f6450 = "movieId";

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private JSONObject f6451;

    /* renamed from: ˎ  reason: contains not printable characters */
    final String f6452 = "controllerESN";

    /* renamed from: ˏ  reason: contains not printable characters */
    final String f6453 = "priority";

    /* renamed from: ͺ  reason: contains not printable characters */
    final int f6454 = 128;

    /* renamed from: ॱ  reason: contains not printable characters */
    final String f6455 = "evenlopeId";

    /* renamed from: ॱॱ  reason: contains not printable characters */
    final String f6456 = "taglength";

    /* renamed from: ᐝ  reason: contains not printable characters */
    final String f6457 = "keyId";

    C1690eC(List<C2054pc> list, String str, String str2, byte[] bArr) {
        JSONArray jSONArray = new JSONArray();
        for (C2054pc pcVar : list) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("movieId", pcVar.f9381).put("priority", 0);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("movies", jSONArray).put("controllerESN", str);
            byte[] bArr2 = new byte[16];
            new Random(System.nanoTime()).nextBytes(bArr2);
            GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, bArr2);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            try {
                Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
                if (instance == null) {
                    C1283.m16865("CastPrefetchMessage", "cipher is null");
                    return;
                }
                new String();
                try {
                    instance.init(1, secretKeySpec, gCMParameterSpec);
                    String r10 = C1323Aw.m3795(instance.doFinal(jSONObject2.toString().getBytes()));
                    if (!r10.isEmpty()) {
                        this.f6451 = new JSONObject();
                        try {
                            this.f6451.put("evenlopeId", 1).put("keyId", str2).put("iv", C1323Aw.m3795(bArr2)).put("taglength", 128).put("ciphertext", r10);
                        } catch (IOException | JSONException e2) {
                        }
                    }
                } catch (InvalidAlgorithmParameterException | InvalidKeyException | BadPaddingException | IllegalBlockSizeException e3) {
                } catch (IOException e4) {
                }
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e5) {
                C1283.m16865("CastPrefetchMessage", "NoSuchAlgorithmException or NoSuchPaddingException for GCM encryption");
            }
        } catch (JSONException e6) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public String m6050() {
        if (this.f6451 != null) {
            return this.f6451.toString();
        }
        return null;
    }
}

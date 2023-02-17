package o;

import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Signature;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
public class CV {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static ThreadLocal<Map<String, KeyPairGenerator>> f5130 = new If();

    /* renamed from: ʽ  reason: contains not printable characters */
    private static ThreadLocal<Map<String, KeyAgreement>> f5131 = new If();

    /* renamed from: ˊ  reason: contains not printable characters */
    private static ThreadLocal<Map<String, MessageDigest>> f5132 = new If();

    /* renamed from: ˋ  reason: contains not printable characters */
    private static ThreadLocal<Map<String, KeyFactory>> f5133 = new If();

    /* renamed from: ˎ  reason: contains not printable characters */
    private static ThreadLocal<Map<String, Signature>> f5134 = new If();

    /* renamed from: ˏ  reason: contains not printable characters */
    private static ThreadLocal<Map<String, Cipher>> f5135 = new If();

    /* renamed from: ॱ  reason: contains not printable characters */
    private static ThreadLocal<Map<String, Mac>> f5136 = new If();

    static class If<T> extends ThreadLocal<Map<String, T>> {
        private If() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: ˏ  reason: contains not printable characters */
        public Map<String, T> initialValue() {
            return new HashMap();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Cipher m4317(String str) {
        Map<String, Cipher> map = f5135.get();
        if (!map.containsKey(str)) {
            map.put(str, Cipher.getInstance(str));
        }
        return map.get(str);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m4316(String str) {
        f5135.get().remove(str);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Signature m4319(String str) {
        Map<String, Signature> map = f5134.get();
        if (!map.containsKey(str)) {
            map.put(str, Signature.getInstance(str));
        }
        return map.get(str);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static Mac m4318(String str) {
        Map<String, Mac> map = f5136.get();
        if (!map.containsKey(str)) {
            map.put(str, Mac.getInstance(str));
        }
        return map.get(str);
    }
}

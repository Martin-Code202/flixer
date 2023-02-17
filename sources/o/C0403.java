package o;

import android.content.Context;
import android.os.Build;
import com.ibm.icu.text.MessageFormat;
import java.util.HashMap;
import java.util.MissingResourceException;
/* renamed from: o.ʝ  reason: contains not printable characters */
public class C0403 {

    /* renamed from: ॱ  reason: contains not printable characters */
    public static C0403 f13352 = new C0403("{EMPTY}");

    /* renamed from: ˊ  reason: contains not printable characters */
    private HashMap<String, Object> f13353 = new HashMap<>();

    /* renamed from: ˋ  reason: contains not printable characters */
    private MessageFormat f13354;

    /* renamed from: ˏ  reason: contains not printable characters */
    private android.icu.text.MessageFormat f13355;

    private C0403(String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f13355 = new android.icu.text.MessageFormat(str);
        } else {
            this.f13354 = new MessageFormat(str);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m14184() {
        new C0403("{EMPTY}");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static C0403 m14185(Context context, int i) {
        String string = context.getResources().getString(i);
        C1283.m16854("ICUMessageFormat", "Processing ICU string... " + string);
        try {
            return new C0403(string);
        } catch (IllegalArgumentException e) {
            return f13352;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C0403 m14187(int i) {
        this.f13353.put("quantity", Integer.valueOf(i));
        return this;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C0403 m14186(String str, Object obj) {
        this.f13353.put(str, obj);
        return this;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m14188() {
        if (this.f13355 != null) {
            return this.f13355.format(this.f13353);
        }
        try {
            return this.f13354.format(this.f13353);
        } catch (IllegalArgumentException | MissingResourceException e) {
            return "";
        }
    }

    public String toString() {
        return m14188();
    }
}

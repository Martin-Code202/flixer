package o;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import java.util.HashMap;
import java.util.Map;
/* renamed from: o.ⁱ  reason: contains not printable characters */
public class C1047 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C0443<String> f15177 = new C0443<>();

    /* renamed from: ˋ  reason: contains not printable characters */
    private Cif f15178;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AssetManager f15179;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Map<String, Typeface> f15180 = new HashMap();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Map<C0443<String>, Typeface> f15181 = new HashMap();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String f15182 = ".ttf";

    public C1047(Drawable.Callback callback, Cif ifVar) {
        this.f15178 = ifVar;
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.f15179 = null;
            return;
        }
        this.f15179 = ((View) callback).getContext().getAssets();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m16076(Cif ifVar) {
        this.f15178 = ifVar;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public Typeface m16075(String str, String str2) {
        this.f15177.m14309(str, str2);
        Typeface typeface = this.f15181.get(this.f15177);
        if (typeface != null) {
            return typeface;
        }
        Typeface r2 = m16073(m16074(str), str2);
        this.f15181.put(this.f15177, r2);
        return r2;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private Typeface m16074(String str) {
        String r4;
        Typeface typeface = this.f15180.get(str);
        if (typeface != null) {
            return typeface;
        }
        Typeface typeface2 = null;
        if (this.f15178 != null) {
            typeface2 = this.f15178.m7683(str);
        }
        if (!(this.f15178 == null || typeface2 != null || (r4 = this.f15178.m7682(str)) == null)) {
            typeface2 = Typeface.createFromAsset(this.f15179, r4);
        }
        if (typeface2 == null) {
            typeface2 = Typeface.createFromAsset(this.f15179, "fonts/" + str + this.f15182);
        }
        this.f15180.put(str, typeface2);
        return typeface2;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private Typeface m16073(Typeface typeface, String str) {
        int i = 0;
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        if (contains && contains2) {
            i = 3;
        } else if (contains) {
            i = 2;
        } else if (contains2) {
            i = 1;
        }
        if (typeface.getStyle() == i) {
            return typeface;
        }
        return Typeface.create(typeface, i);
    }
}

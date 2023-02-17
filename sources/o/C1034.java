package o;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* renamed from: o.ᵢ  reason: contains not printable characters */
public class C1034 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private AbstractC1871iF f15144;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f15145;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Map<String, C0436> f15146;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Context f15147;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Map<String, Bitmap> f15148 = new HashMap();

    public C1034(Drawable.Callback callback, String str, AbstractC1871iF iFVar, Map<String, C0436> map) {
        this.f15145 = str;
        if (!TextUtils.isEmpty(str) && this.f15145.charAt(this.f15145.length() - 1) != '/') {
            this.f15145 += '/';
        }
        if (!(callback instanceof View)) {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.f15146 = new HashMap();
            this.f15147 = null;
            return;
        }
        this.f15147 = ((View) callback).getContext();
        this.f15146 = map;
        m16038(iFVar);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m16038(AbstractC1871iF iFVar) {
        this.f15144 = iFVar;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public Bitmap m16040(String str) {
        Bitmap bitmap = this.f15148.get(str);
        if (bitmap != null) {
            return bitmap;
        }
        C0436 r4 = this.f15146.get(str);
        if (r4 == null) {
            return null;
        }
        if (this.f15144 != null) {
            Bitmap r3 = this.f15144.m7427(r4);
            if (r3 != null) {
                this.f15148.put(str, r3);
            }
            return r3;
        }
        try {
            if (TextUtils.isEmpty(this.f15145)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            InputStream open = this.f15147.getAssets().open(this.f15145 + r4.m14282());
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = true;
            options.inDensity = 160;
            Bitmap decodeStream = BitmapFactory.decodeStream(open, null, options);
            this.f15148.put(str, decodeStream);
            return decodeStream;
        } catch (IOException e) {
            Log.w("LOTTIE", "Unable to open asset.", e);
            return null;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m16041() {
        Iterator<Map.Entry<String, Bitmap>> it = this.f15148.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().recycle();
            it.remove();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m16039(Context context) {
        return (context == null && this.f15147 == null) || (context != null && this.f15147.equals(context));
    }
}

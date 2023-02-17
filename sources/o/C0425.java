package o;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
/* renamed from: o.ˀ  reason: contains not printable characters */
public class C0425 implements AbstractC0417 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Context f13416;

    public C0425(Context context) {
        this.f13416 = context;
    }

    @Override // o.AbstractC0417
    /* renamed from: ˏ */
    public int mo14225() {
        return m14233().y;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public Point m14233() {
        Point point = new Point();
        DisplayMetrics displayMetrics = this.f13416.getResources().getDisplayMetrics();
        point.x = displayMetrics.widthPixels;
        point.y = displayMetrics.heightPixels;
        return point;
    }
}

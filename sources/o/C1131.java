package o;

import android.text.TextUtils;
import com.netflix.cl.model.ThumbRating;
/* renamed from: o.ﮂ  reason: contains not printable characters */
public final class C1131 {
    /* renamed from: ॱ  reason: contains not printable characters */
    public static int m16286(int i) {
        if (i == 2) {
            return 2;
        }
        if (i == 1) {
            return 1;
        }
        return 0;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static int m16287(String str) {
        if (TextUtils.equals(str, "THUMBS_DOWN")) {
            return 2;
        }
        if (TextUtils.equals(str, "THUMBS_UP")) {
            return 1;
        }
        return 0;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static ThumbRating m16285(int i) {
        if (i == 2) {
            return ThumbRating.UP;
        }
        if (i == 1) {
            return ThumbRating.DOWN;
        }
        return ThumbRating.UNRATED;
    }
}

package o;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Constructor;
public class qP {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static Constructor<StaticLayout> f9538;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static boolean f9539 = false;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static synchronized StaticLayout m9945(CharSequence charSequence, int i, int i2, TextPaint textPaint, int i3, Layout.Alignment alignment, float f, float f2, boolean z, TextUtils.TruncateAt truncateAt, int i4, int i5) {
        synchronized (qP.class) {
            if (f9539 || Build.VERSION.SDK_INT < 19) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 23) {
                try {
                    f9538 = StaticLayout.class.getDeclaredConstructor(CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, TextDirectionHeuristic.class, Float.TYPE, Float.TYPE, Boolean.TYPE, TextUtils.TruncateAt.class, Integer.TYPE, Integer.TYPE);
                    f9538.setAccessible(true);
                    return f9538.newInstance(charSequence, Integer.valueOf(i), Integer.valueOf(i2), textPaint, Integer.valueOf(i3), alignment, TextDirectionHeuristics.LOCALE, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z), truncateAt, Integer.valueOf(i4), Integer.valueOf(i5));
                } catch (Exception e) {
                    f9539 = true;
                    Log.e("StaticLayoutWithMaxL", "Error instantiating StaticLayout with maxlines");
                    C1276.m16820().mo5729("Reflection error instantiating StaticLayout with maxlines", e);
                }
            } else if (Build.VERSION.SDK_INT >= 23) {
                StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, i, i2, textPaint, i3);
                obtain.setAlignment(alignment);
                obtain.setTextDirection(TextDirectionHeuristics.LOCALE);
                obtain.setLineSpacing(f2, f);
                obtain.setIncludePad(z);
                obtain.setEllipsizedWidth(i4);
                obtain.setMaxLines(i5);
                obtain.setEllipsize(truncateAt);
                return obtain.build();
            }
            return null;
        }
    }
}

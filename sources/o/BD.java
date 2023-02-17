package o;

import android.content.Context;
import com.netflix.mediaclient.R;
import java.util.Locale;
public class BD {
    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m3838(int i, Context context) {
        if ("iw".equals(Locale.getDefault().getLanguage())) {
            return context.getResources().getString(R.string.label_num_minutes_shorthand, Integer.valueOf(i / 60));
        }
        int i2 = i / 3600;
        int i3 = (i - (i2 * 3600)) / 60;
        if (i2 > 0) {
            if (i3 > 0) {
                return context.getResources().getString(R.string.label_num_minutes_hours, Integer.valueOf(i2), Integer.valueOf(i3));
            }
            return context.getResources().getString(R.string.label_num_hours, Integer.valueOf(i2));
        } else if (i3 > 0) {
            return context.getResources().getString(R.string.label_num_minutes_shorthand, Integer.valueOf(i3));
        } else {
            return "";
        }
    }
}

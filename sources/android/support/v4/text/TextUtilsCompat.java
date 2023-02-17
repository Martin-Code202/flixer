package android.support.v4.text;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;
public final class TextUtilsCompat {
    private static final Locale ROOT = new Locale("", "");

    public static int getLayoutDirectionFromLocale(Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (locale == null || locale.equals(ROOT)) {
            return 0;
        }
        String maximizeAndGetScript = ICUCompat.maximizeAndGetScript(locale);
        if (maximizeAndGetScript == null) {
            return getLayoutDirectionFromFirstChar(locale);
        }
        if (maximizeAndGetScript.equalsIgnoreCase("Arab") || maximizeAndGetScript.equalsIgnoreCase("Hebr")) {
            return 1;
        }
        return 0;
    }

    private static int getLayoutDirectionFromFirstChar(Locale locale) {
        switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
            case 0:
            default:
                return 0;
            case 1:
            case 2:
                return 1;
        }
    }
}

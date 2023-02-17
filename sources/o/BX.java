package o;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.netflix.mediaclient.util.l10n.BidiMarker;
import java.util.Locale;
public final class BX {
    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m3957() {
        return m3952(Locale.getDefault());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m3952(Locale locale) {
        return TextUtils.getLayoutDirectionFromLocale(locale) == 1;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m3949(String str, BidiMarker bidiMarker) {
        return m3954(m3956(str, bidiMarker), bidiMarker);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m3956(String str, BidiMarker bidiMarker) {
        if (str == null || !m3957()) {
            return str;
        }
        return bidiMarker.m3068() + str;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static CharSequence m3948(CharSequence charSequence, BidiMarker bidiMarker) {
        if (charSequence == null || !m3957()) {
            return charSequence;
        }
        return new SpannableStringBuilder().append(bidiMarker.m3068()).append(charSequence);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m3954(String str, BidiMarker bidiMarker) {
        if (str == null || !m3957()) {
            return str;
        }
        return str + bidiMarker.m3068();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m3950(View view) {
        if (view != null && m3957()) {
            view.setLayoutDirection(1);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static CharSequence m3953(CharSequence charSequence) {
        if (charSequence == null || !m3957()) {
            return charSequence;
        }
        return m3948(charSequence, BidiMarker.FORCED_RTL);
    }

    @TargetApi(25)
    /* renamed from: ˊ  reason: contains not printable characters */
    public static ContextWrapper m3947(Context context, Locale locale) {
        Locale.getDefault();
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        if (m3955()) {
            LocaleList localeList = new LocaleList(locale);
            LocaleList.setDefault(localeList);
            configuration.setLocales(localeList);
            context = context.createConfigurationContext(configuration);
        } else if (m3951()) {
            Locale.setDefault(locale);
            configuration.setLocale(locale);
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        } else {
            Locale.setDefault(locale);
            configuration.locale = locale;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        return new ContextWrapper(context);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static boolean m3955() {
        return Build.VERSION.SDK_INT > 25;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static boolean m3951() {
        return Build.VERSION.SDK_INT >= 21;
    }
}

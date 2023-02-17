package o;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.format.Formatter;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.util.l10n.BidiMarker;
import java.util.Locale;
public class BG {
    /* renamed from: ˋ  reason: contains not printable characters */
    public static CharSequence m3852(Context context, int i, String str) {
        if (context == null) {
            return "";
        }
        return m3857(context, context.getString(i), str);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static CharSequence m3857(Context context, String str, String str2) {
        if (context == null || C1349Bv.m4113(str2)) {
            return "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new StyleSpan(1), 0, str.length(), 0);
        spannableStringBuilder.append((CharSequence) " ");
        spannableStringBuilder.append((CharSequence) str2);
        return spannableStringBuilder;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static CharSequence m3848(Context context, int i, String str, int i2) {
        if (context == null || context.getResources() == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (i > 0) {
            sb.append(i).append("   ");
        }
        if (C1349Bv.m4107(str)) {
            sb.append(BX.m3949(str, BidiMarker.FORCED_LTR));
            sb.append("   ");
        }
        if (i2 > 0) {
            sb.append(BX.m3956(BD.m3838(i2, context), BidiMarker.FORCED_RTL));
        }
        return BX.m3956(sb.toString(), BidiMarker.FORCED_RTL);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static CharSequence m3853(Context context, pT pTVar) {
        if (context == null) {
            return "";
        }
        return m3848(context, pTVar.getYear(), pTVar.getCertification(), pTVar.getPlayable().getRuntime());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static CharSequence m3849(Context context, int i, String str, String str2) {
        if (context == null || context.getResources() == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (i > 0) {
            sb.append(i).append("   ");
        }
        if (C1349Bv.m4107(str)) {
            sb.append(BX.m3949(str, BidiMarker.FORCED_LTR));
            sb.append("   ");
        }
        if (C1349Bv.m4107(str2)) {
            sb.append(BX.m3956(str2, BidiMarker.FORCED_RTL));
        }
        return sb.toString();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static CharSequence m3858(Context context, pR pRVar) {
        if (context == null) {
            return "";
        }
        return m3849(context, pRVar.getYear(), pRVar.getCertification(), pRVar.getNumSeasonsLabel());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static CharSequence m3851(Context context, pP pPVar) {
        if (context == null) {
            return "";
        }
        return m3848(context, pPVar.getYear(), pPVar.getCertification(), pPVar.getPlayable().getRuntime());
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static String m3862(String str) {
        if (C1349Bv.m4113(str)) {
            throw new IllegalArgumentException("Empty uri string");
        }
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf <= 0 || lastIndexOf >= str.length() - 1) {
            C1283.m16865("UIStringUtils", "No filename found in URI - using hashcode: " + str);
            return String.valueOf(str.hashCode());
        }
        String substring = str.substring(lastIndexOf + 1);
        int indexOf = substring.indexOf(63);
        if (indexOf > 0) {
            return substring.substring(0, indexOf);
        }
        return substring;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m3855(String str) {
        if (str == null) {
            C1276.m16820().mo5725("uriStr is null");
            return null;
        } else if (C1349Bv.m4113(str)) {
            C1283.m16850("UIStringUtils", "Empty uri string");
            return null;
        } else {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return null;
            }
            return parse.getQuery();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m3859(String str) {
        if (C1349Bv.m4113(str)) {
            throw new IllegalArgumentException("Empty uri string");
        }
        Uri parse = Uri.parse(str);
        if (parse != null) {
            return parse.getPath();
        }
        String valueOf = String.valueOf(str.hashCode());
        C1283.m16865("UIStringUtils", "Could not parse uri: " + str + ", returning hash: " + valueOf);
        return valueOf;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m3860(String str, String str2, String str3) {
        return C1349Bv.m4116(str, str2, str3);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m3854(int i) {
        return NetflixApplication.getInstance().getString(R.string.label_percentage, new Object[]{Integer.valueOf(i)});
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static String m3861(Context context, long j) {
        String formatShortFileSize = Formatter.formatShortFileSize(context, j);
        if ("ro".equals(Locale.getDefault().getLanguage())) {
            return formatShortFileSize.replace("O", "B");
        }
        return formatShortFileSize;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static CharSequence m3850(Context context, String str, String str2) {
        String str3 = str + System.getProperty("line.separator") + str2;
        if (context == null) {
            return str3;
        }
        SpannableString spannableString = new SpannableString(str3);
        spannableString.setSpan(new TextAppearanceSpan(context, R.style.res_2131951984_primarytext_smallmedium), 0, str.length(), 33);
        spannableString.setSpan(new TextAppearanceSpan(context, R.style.res_2131952027_secondarytext_micro), str.length(), str3.length(), 33);
        return spannableString;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static CharSequence m3856(Context context, String str, String str2) {
        String property = System.getProperty("line.separator");
        String str3 = str + property + property + str2;
        if (context == null) {
            return str3;
        }
        SpannableString spannableString = new SpannableString(str3);
        spannableString.setSpan(new TextAppearanceSpan(context, R.style.res_2131951979_primarytext_mediumlarge), 0, str.length(), 33);
        spannableString.setSpan(new StyleSpan(1), 0, str.length(), 33);
        spannableString.setSpan(new TextAppearanceSpan(context, R.style.res_2131952032_secondarytext_smallmedium), str.length(), str3.length(), 33);
        return spannableString;
    }
}

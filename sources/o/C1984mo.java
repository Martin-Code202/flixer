package o;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.netflix.mediaclient.media.Subtitle;
import com.netflix.mediaclient.service.player.subtitles.text.ColorMapping;
import com.netflix.mediaclient.service.player.subtitles.text.FontFamilyMapping;
import com.netflix.mediaclient.service.player.subtitles.text.FontWeight;
import com.netflix.mediaclient.service.player.subtitles.text.HorizontalAlignment;
import com.netflix.mediaclient.service.player.subtitles.text.VerticalAlignment;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* renamed from: o.mo  reason: case insensitive filesystem */
public final class C1984mo {

    /* renamed from: ʼ  reason: contains not printable characters */
    private static final Pattern f8907 = Pattern.compile("^([0-9.]+)ms$");

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final mP f8908 = new mP("<%NF_DEFAULT_TEXT_STYLE%>", "FFFFFF", null, null, null, mO.m8853(), FontFamilyMapping.defaultType, false, false, FontWeight.Regular, null, null, null);

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final mP f8909 = new mP("<%NF_DEFAULT_TEXT_STYLE%>", "FFFFFF", null, null, null, mO.m8853(), FontFamilyMapping.monospace, false, false, FontWeight.Medium, null, null, null);

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final Pattern f8910 = Pattern.compile("^[0-9]*[.]?[0-9]*%$");

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final Pattern f8911 = Pattern.compile("^([0-9.]+)t$");

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final Pattern f8912 = Pattern.compile("^[0-9]{1,2}c$");

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static final Pattern f8913 = Pattern.compile("^([0-9]+):([0-9]+):([0-9.]+)$");

    /* renamed from: ᐝ  reason: contains not printable characters */
    private static final Pattern f8914 = Pattern.compile("^([0-9.]+)s$");

    /* renamed from: o.mo$If */
    public static class If {

        /* renamed from: ˊ  reason: contains not printable characters */
        public int f8915;

        /* renamed from: ˋ  reason: contains not printable characters */
        public int f8916;

        /* renamed from: ˎ  reason: contains not printable characters */
        public int f8917;

        /* renamed from: ˏ  reason: contains not printable characters */
        public int f8918;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Float m9057(String str, int i) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        Matcher matcher = f8910.matcher(str);
        if (matcher.find()) {
            return Float.valueOf(Float.valueOf(matcher.group().replaceAll("%", "")).floatValue() / 100.0f);
        }
        Matcher matcher2 = f8912.matcher(str.toLowerCase(Locale.US));
        if (matcher2.find()) {
            return Float.valueOf(Float.valueOf(matcher2.group().replaceAll("c", "")).floatValue() / ((float) i));
        }
        return null;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static long m9041(String str, double d) {
        if (C1349Bv.m4113(str)) {
            C1283.m16850("nf_subtitles_render", "dfxp-badtime: Time string us empty! Invalid time");
            return -1;
        }
        Matcher matcher = f8911.matcher(str);
        if (matcher.find()) {
            long r6 = m9040(matcher.group().replaceAll("t", ""));
            if (r6 == -1) {
                return r6;
            }
            return (long) (((double) r6) * d);
        }
        Matcher matcher2 = f8907.matcher(str);
        if (matcher2.find()) {
            return m9040(matcher2.group().replaceAll("ms", ""));
        }
        Matcher matcher3 = f8914.matcher(str);
        if (matcher3.find()) {
            long r62 = m9040(matcher3.group().replaceAll("s", ""));
            if (r62 == -1) {
                return r62;
            }
            return (long) (((double) r62) * d);
        }
        Matcher matcher4 = f8913.matcher(str);
        if (!matcher4.find()) {
            return -1;
        }
        String[] r5 = C1349Bv.m4118(matcher4.group(), ":");
        if (r5.length < 3) {
            return -1;
        }
        long r63 = m9040(r5[0]);
        long r8 = m9040(r5[1]);
        return ((3600 * r63) + (60 * r8) + m9040(r5[2])) * 1000;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static long m9040(String str) {
        try {
            return Long.parseLong(str);
        } catch (Throwable th) {
            C1283.m16847("nf_subtitles_render", "Parsing failed", th);
            return -1;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static int m9056(mP mPVar) {
        if (mPVar == null) {
            return 0;
        }
        if (mPVar.m8881() == null || FontWeight.Bold.m1171() > mPVar.m8881().m1171()) {
            if (!Boolean.TRUE.equals(mPVar.m8869())) {
                return 0;
            }
            C1283.m16854("nf_subtitles_render", "toTypeFaceStyle:: ITALIC");
            return 2;
        } else if (Boolean.TRUE.equals(mPVar.m8869())) {
            C1283.m16854("nf_subtitles_render", "toTypeFaceStyle:: BOLD ITALIC");
            return 3;
        } else {
            C1283.m16854("nf_subtitles_render", "toTypeFaceStyle:: BOLD");
            return 1;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static int m9044(HorizontalAlignment horizontalAlignment, VerticalAlignment verticalAlignment) {
        if (horizontalAlignment == null && verticalAlignment == null) {
            C1283.m16854("nf_subtitles_render", "toGravity default CENTER");
            return 17;
        } else if (horizontalAlignment == null) {
            return verticalAlignment.m1180();
        } else {
            if (verticalAlignment == null) {
                return horizontalAlignment.m1173();
            }
            int r2 = horizontalAlignment.m1173() + verticalAlignment.m1180();
            return horizontalAlignment.m1173() | verticalAlignment.m1180();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static Rect m9050(View view, lZ lZVar, lZ lZVar2) {
        if (view == null) {
            throw new IllegalArgumentException("Display area can not be null");
        }
        int i = 0;
        int i2 = 0;
        Rect rect = new Rect();
        if (lZVar != null) {
            i = (int) (((float) view.getWidth()) * lZVar.m8743());
            i2 = (int) (((float) view.getHeight()) * lZVar.m8744());
        } else {
            C1283.m16865("nf_subtitles_render", "Extent is null!");
        }
        if (lZVar2 != null) {
            rect.left = (int) (((float) view.getWidth()) * lZVar2.m8743());
            rect.top = (int) (((float) view.getHeight()) * lZVar2.m8744());
            rect.right = rect.left + i;
            rect.bottom = rect.top + i2;
            if (rect.bottom > view.getHeight()) {
                C1283.m16865("nf_subtitles_render", "Extent h is too big!");
            }
            if (rect.right > view.getWidth()) {
                C1283.m16865("nf_subtitles_render", "Extent w is too big!");
            }
        } else {
            C1283.m16865("nf_subtitles_render", "Origin is null!");
        }
        return rect;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static If m9059(View view, lZ lZVar, lZ lZVar2) {
        if (view == null) {
            throw new IllegalArgumentException("Display area can not be null");
        }
        int i = 0;
        int i2 = 0;
        If r4 = new If();
        if (lZVar != null) {
            i = (int) (((float) view.getWidth()) * lZVar.m8743());
            i2 = (int) (((float) view.getHeight()) * lZVar.m8744());
        } else {
            C1283.m16865("nf_subtitles_render", "Extent is null!");
        }
        if (lZVar2 != null) {
            r4.f8918 = (int) (((float) view.getWidth()) * lZVar2.m8743());
            r4.f8916 = (int) (((float) view.getHeight()) * lZVar2.m8744());
            r4.f8915 = (view.getWidth() - r4.f8918) - i;
            r4.f8917 = (view.getHeight() - r4.f8916) - i2;
        } else {
            C1283.m16865("nf_subtitles_render", "Origin is null!");
        }
        return r4;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static float m9049(mP mPVar) {
        float intValue = mPVar.m8876() != null ? ((float) mPVar.m8876().intValue()) / 100.0f : 1.0f;
        if (intValue <= 0.0f) {
            return 1.0f;
        }
        return intValue;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static Integer m9055(mP mPVar) {
        return ColorMapping.m1161(mPVar.m8882(), mPVar.m8879());
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static Integer m9045(mP mPVar) {
        return ColorMapping.m1161(mPVar.m8871(), mPVar.m8874());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static Integer m9051(mO mOVar) {
        if (mOVar != null) {
            return ColorMapping.m1161(null, mOVar.m8855());
        }
        return null;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static Rect m9042(Rect rect, Rect rect2) {
        return new Rect(Math.max(rect.left, rect2.left), Math.max(rect.top, rect2.top), Math.min(rect.right, rect2.right), Math.min(rect.bottom, rect2.bottom));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static Point m9053(Rect rect, Rect rect2) {
        if (!Rect.intersects(rect, rect2)) {
            return null;
        }
        Rect r1 = m9042(rect, rect2);
        Point point = new Point();
        point.x = 0;
        point.y = r1.height();
        return point;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static mP m9058(mP mPVar, mP mPVar2) {
        if (mPVar == null && mPVar2 == null) {
            C1283.m16854("nf_subtitles_render", "getDeviceDefaultTextStyle:: user and region defaults are null: proportional");
            return m9047((FontFamilyMapping) null);
        } else if (mPVar2 == null || !(mPVar == null || mPVar.m8866() == null)) {
            C1283.m16854("nf_subtitles_render", "getDeviceDefaultTextStyle:: user font family is NOT null, deciding based on it");
            return m9047(mPVar.m8866());
        } else {
            C1283.m16854("nf_subtitles_render", "getDeviceDefaultTextStyle:: user font family is null, depending on region");
            return m9047(mPVar2.m8866());
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static mP m9047(FontFamilyMapping fontFamilyMapping) {
        if (FontFamilyMapping.m1165(fontFamilyMapping)) {
            return f8908;
        }
        return f8909;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static FontWeight m9054(FontFamilyMapping fontFamilyMapping) {
        if (FontFamilyMapping.m1165(fontFamilyMapping)) {
            return FontWeight.Regular;
        }
        return FontWeight.Medium;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m9048(TextView textView, mP mPVar) {
        if (C1317As.m3758() >= 21 && textView != null) {
            FontFamilyMapping fontFamilyMapping = null;
            if (mPVar != null) {
                fontFamilyMapping = mPVar.m8866();
            }
            textView.setLetterSpacing(m9039(fontFamilyMapping));
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static float m9039(FontFamilyMapping fontFamilyMapping) {
        if (fontFamilyMapping == null || FontFamilyMapping.m1164(fontFamilyMapping)) {
            return 0.016f;
        }
        return 0.0f;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m9046(String str, int i) {
        StringBuilder sb = new StringBuilder();
        if (i > 1) {
            for (int i2 = 1; i2 < i; i2++) {
                sb.append('\n');
            }
        }
        if (!C1349Bv.m4113(str)) {
            sb.append(str);
        }
        sb.append(" ");
        return sb.toString();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m9052(LinearLayout linearLayout, mR mRVar) {
        mM mMVar;
        if (linearLayout == null || mRVar == null) {
            throw new IllegalArgumentException("region or block is null!");
        }
        mQ r2 = mRVar.m8901();
        HorizontalAlignment horizontalAlignment = HorizontalAlignment.center;
        if (!(r2 == null || r2.m8891() == null)) {
            C1283.m16854("nf_subtitles_render", "Horizontal alignment from region");
            horizontalAlignment = r2.m8891();
        }
        VerticalAlignment verticalAlignment = VerticalAlignment.bottom;
        if (!(r2 == null || r2.m8892() == null)) {
            C1283.m16854("nf_subtitles_render", "Vertical alignment from region");
            verticalAlignment = r2.m8892();
        }
        if (!(mRVar.m8904().size() <= 1 || (mMVar = mRVar.m8904().get(0)) == null || mMVar.m8847() == null)) {
            if (mMVar.m8847().m8883() != null) {
                C1283.m16854("nf_subtitles_render", "Horizontal alignment overide from p!");
                horizontalAlignment = mMVar.m8847().m8883();
            }
            if (mMVar.m8847().m8867() != null) {
                C1283.m16854("nf_subtitles_render", "Vertical alignment overide from p!");
                verticalAlignment = mMVar.m8847().m8867();
            }
        }
        linearLayout.setGravity(m9044(horizontalAlignment, verticalAlignment));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m9043(List<mM> list, int i) {
        int i2;
        return list != null && list.size() > (i2 = i + 1) && list.get(i2).m8849() < 1;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m9060(Subtitle[] subtitleArr, String str) {
        if (subtitleArr == null) {
            C1283.m16850(str, "Subtitles are null!");
        }
    }
}

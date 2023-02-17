package o;

import android.content.Context;
import com.netflix.cl.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
/* renamed from: o.nx  reason: case insensitive filesystem */
public final class C2020nx {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static BZ f9211;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static BZ f9212;

    /* renamed from: ˊ  reason: contains not printable characters */
    private Context f9213;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f9214;

    /* renamed from: ॱ  reason: contains not printable characters */
    private List<BZ> f9215 = new ArrayList();

    /* renamed from: ᐝ  reason: contains not printable characters */
    private BZ f9216;

    /* renamed from: ˊ  reason: contains not printable characters */
    public static BZ m9362(Context context) {
        BZ bz = f9212;
        if (bz != null) {
            C1283.m16854("nf_loc", "app locale");
            return bz;
        } else if (f9211 != null) {
            C1283.m16854("nf_loc", "Cached last used locale");
            return f9211;
        } else {
            C1283.m16854("nf_loc", "Try to find cached last used locale in case app crashed and system is loading LOLOMO");
            String r3 = C1339Bl.m4045(context, "app_locale_last_used", (String) null);
            if (r3 != null) {
                C1283.m16854("nf_loc", "Cached last used locale after crash");
                f9211 = new BZ(r3);
                return f9211;
            }
            C1283.m16854("nf_loc", "device locale");
            return m9367();
        }
    }

    public C2020nx(Context context) {
        this.f9213 = context;
        m9363();
        String r2 = C1339Bl.m4045(context, "app_locale_last_used", (String) null);
        if (r2 != null) {
            f9211 = new BZ(r2);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m9369(BZ bz) {
        f9212 = bz;
        if (bz != null) {
            C1339Bl.m4039(this.f9213, "app_locale_last_used", bz.m3973());
            Logger.INSTANCE.m127(new C0398(bz.m3976()));
            return;
        }
        C1339Bl.m4041(this.f9213, "app_locale_last_used");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m9363() {
        this.f9216 = new BZ(Locale.ENGLISH.getLanguage(), null, "English");
        this.f9215.add(this.f9216);
        this.f9215.add(new BZ(Locale.FRENCH.getLanguage(), null, "Français"));
        this.f9215.add(new BZ("es", null, "Español"));
        this.f9215.add(new BZ("pt", null, "Português"));
        this.f9215.add(new BZ(Locale.UK.getLanguage(), Locale.UK.getCountry(), "English-GB"));
        this.f9215.add(new BZ(Locale.ENGLISH.getLanguage(), "IE", "English-IE"));
        this.f9215.add(new BZ("sv", null, "Svenskt"));
        this.f9215.add(new BZ("nb", null, "Norske"));
        this.f9215.add(new BZ("da", null, "Dansk"));
        this.f9215.add(new BZ("fi", null, "Suomi"));
        this.f9215.add(new BZ("nl", null, "Nederlands"));
        this.f9215.add(new BZ(Locale.FRENCH.getLanguage(), Locale.CANADA.getCountry(), "Français-CA"));
        this.f9215.add(new BZ(Locale.GERMAN.getLanguage(), null, "Deutsch"));
        this.f9215.add(new BZ(Locale.ENGLISH.getLanguage(), "AU", "English-AU"));
        this.f9215.add(new BZ(Locale.ENGLISH.getLanguage(), "NZ", "English-NZ"));
        this.f9215.add(new BZ(Locale.JAPAN.getLanguage(), Locale.JAPAN.getCountry(), "日本語"));
        this.f9215.add(new BZ(Locale.ITALY.getLanguage(), Locale.ITALY.getCountry(), "italiano"));
        this.f9215.add(new BZ("pt", "PT", "Português-PT"));
        this.f9215.add(new BZ("es", "ES", "español-ES"));
        this.f9215.add(new BZ("ar", "MA", "Arabic"));
        this.f9215.add(new BZ(Locale.KOREAN.getLanguage(), null, "한국어/조선말"));
        this.f9215.add(new BZ(Locale.SIMPLIFIED_CHINESE.getLanguage(), Locale.SIMPLIFIED_CHINESE.getCountry(), "简化字"));
        this.f9215.add(new BZ(Locale.TRADITIONAL_CHINESE.getLanguage(), Locale.TRADITIONAL_CHINESE.getCountry(), "正體字/繁體字"));
        this.f9215.add(new BZ(Locale.SIMPLIFIED_CHINESE.getLanguage(), "SG", "简化字"));
        this.f9215.add(new BZ(Locale.TRADITIONAL_CHINESE.getLanguage(), "MO", "正體字/繁體字"));
        this.f9215.add(new BZ(Locale.TRADITIONAL_CHINESE.getLanguage(), "HK", "正體字/繁體字"));
        this.f9215.add(new BZ(Locale.CHINESE.getLanguage(), null, "简化字"));
        this.f9215.add(new BZ("es", "AD", "español-AD"));
        this.f9215.add(new BZ("tr", null, "Türkçe"));
        this.f9215.add(new BZ("pl", null, "polszczyzna"));
        this.f9215.add(new BZ("th", null, "Thai"));
        this.f9215.add(new BZ("ro", null, "limba română"));
        this.f9215.add(new BZ("he", null, "עברית‎"));
        this.f9215.add(new BZ("bg", null, "български"));
        this.f9215.add(new BZ("el", null, "ελληνικά"));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m9373(String str) {
        if (str == null || "".equals(str.trim())) {
            C1283.m16850("nf_loc", "Empty list of preferred languages, set to default");
            str = "";
        }
        this.f9214 = str;
        BZ r3 = m9368(str);
        if (r3 == null) {
            C1283.m16865("nf_loc", "Match is not found under application supported languages for prefered languages: " + str + ". Default to " + this.f9216);
            r3 = this.f9216;
        }
        m9374(r3);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public BZ m9375() {
        return m9362(this.f9213);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ˏ  reason: contains not printable characters */
    private BZ m9368(String str) {
        BZ bz = null;
        BZ[] r3 = m9364(str);
        if (r3.length < 1) {
            C1283.m16865("nf_loc", "Empty list of preferred languages, set default");
            return null;
        }
        for (int i = 0; i < r3.length; i++) {
            for (int i2 = 0; i2 < this.f9215.size(); i2++) {
                BZ bz2 = this.f9215.get(i2);
                if (r3[i] != 0 && (r3[i].equals(bz2) || r3[i].m3974(bz2))) {
                    if (r3[i].equals(bz2)) {
                        return bz2;
                    }
                    if (bz == null) {
                        bz = bz2;
                    }
                }
            }
        }
        return bz;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private BZ[] m9364(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        if (stringTokenizer.countTokens() < 1) {
            return new BZ[0];
        }
        BZ[] bzArr = new BZ[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            i++;
            bzArr[i] = new BZ(stringTokenizer.nextToken());
        }
        return bzArr;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m9374(BZ bz) {
        if (f9212 != null) {
            f9212.equals(bz);
        }
        m9369(bz);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized void m9372() {
        f9211 = null;
        C1339Bl.m4041(this.f9213, "app_locale_last_used");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static List<String> m9366(Context context) {
        String r2 = C1339Bl.m4045(context, "alertedLanguages", (String) null);
        ArrayList arrayList = new ArrayList();
        if (r2 != null) {
            for (String str : r2.split(",")) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m9371(Context context) {
        if (m9370(context)) {
            C1283.m16854("nf_loc", "skip setAlertedLanguage - was previously alerted");
            return;
        }
        List<String> r2 = m9366(context);
        r2.add(m9367().m3976());
        StringBuilder sb = new StringBuilder();
        for (String str : r2) {
            sb.append(str);
            sb.append(",");
        }
        C1339Bl.m4039(context, "alertedLanguages", sb.toString());
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m9365(Context context) {
        BZ r1 = m9367();
        for (BZ bz : new C2020nx(context).f9215) {
            if (r1.m3974(bz)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static BZ m9367() {
        Locale locale = Locale.getDefault();
        return new BZ(locale.getLanguage(), locale.getCountry(), locale.getDisplayLanguage());
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m9370(Context context) {
        List<String> r1 = m9366(context);
        BZ r2 = m9367();
        for (String str : r1) {
            if (C1349Bv.m4126(str, r2.m3976())) {
                return true;
            }
        }
        return false;
    }
}

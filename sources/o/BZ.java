package o;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import java.util.Locale;
import java.util.StringTokenizer;
public final class BZ {
    @SerializedName("language")
    private String language;
    @SerializedName("languageDescription")
    private String languageDescription;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f4635;

    /* renamed from: ˏ  reason: contains not printable characters */
    private Locale f4636;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f4637;

    public BZ(String str) {
        m3972(str, "raw");
        this.f4635 = str.trim();
        m3968();
        m3966();
    }

    public BZ(String str, String str2, String str3) {
        m3972(str, "language");
        m3972(str3, "languageDescription");
        this.language = str.trim().toLowerCase();
        this.f4637 = str2;
        if (this.f4637 != null) {
            this.f4637 = this.f4637.trim().toUpperCase();
        }
        this.languageDescription = str3.trim();
        m3970();
        m3966();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m3968() {
        StringTokenizer stringTokenizer = new StringTokenizer(this.f4635, "-");
        if (stringTokenizer.countTokens() < 1 || stringTokenizer.countTokens() > 2) {
            throw new IllegalArgumentException("Invalid format of raw: " + this.f4635);
        }
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (i == 0) {
                this.language = nextToken.toLowerCase();
            } else if (i == 1) {
                this.f4637 = nextToken.toUpperCase();
            } else {
                C1283.m16865("nf_user_locale", "Unexpected token in given prefered language. Token " + i + ": " + nextToken);
            }
            i++;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m3970() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.language);
        if (this.f4637 != null) {
            sb.append("-");
            sb.append(this.f4637);
        }
        this.f4635 = sb.toString();
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private void m3966() {
        if (this.f4637 == null || "".equals(this.f4637)) {
            this.f4636 = new Locale(this.language);
        } else {
            this.f4636 = new Locale(this.language, this.f4637);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m3972(String str, String str2) {
        if (str == null || "".equals(str.trim())) {
            throw new IllegalArgumentException(str2 + " argument can not be empty!");
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m3973() {
        return this.f4635;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m3976() {
        return this.language;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public Locale m3975() {
        return this.f4636;
    }

    public String toString() {
        return "UserLocale [language=" + this.language + ", languageDescription=" + this.languageDescription + ", locale=" + this.f4636 + ", raw=" + this.f4635 + ", region=" + this.f4637 + "]";
    }

    public int hashCode() {
        return (this.f4635 == null ? 0 : this.f4635.hashCode()) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof BZ)) {
            return false;
        }
        BZ bz = (BZ) obj;
        if (this.f4635 == null) {
            if (bz.f4635 != null) {
                return false;
            }
            return true;
        } else if (!this.f4635.equals(bz.f4635)) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m3974(BZ bz) {
        if (bz == null) {
            return false;
        }
        if (this.language == null) {
            if (bz.language != null) {
                return false;
            }
            return true;
        } else if (!this.language.equalsIgnoreCase(bz.language)) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static String m3971(Locale locale) {
        if (locale == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(locale.getLanguage());
        if (locale.getCountry() != null && !"".equals(locale.getCountry().trim())) {
            sb.append("-");
            sb.append(locale.getCountry());
        }
        return sb.toString();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static Locale m3969(Context context) {
        return context.getApplicationContext().getResources().getConfiguration().locale;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m3967(Context context) {
        return m3971(m3969(context));
    }
}

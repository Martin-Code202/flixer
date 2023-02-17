package o;

import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.service.player.subtitles.text.FontWeight;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: o.Bt  reason: case insensitive filesystem */
public final class C1347Bt {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final AtomicBoolean f4660 = new AtomicBoolean(false);

    /* renamed from: ॱ  reason: contains not printable characters */
    private static final Map<String, Typeface> f4661 = new HashMap();

    static {
        m4087();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m4087() {
        HashMap hashMap = new HashMap();
        C1283.m16854("nf_subtitles_typefactory", "Init typefaces ");
        FontWeight[] values = FontWeight.values();
        for (FontWeight fontWeight : values) {
            Typeface r8 = m4090(fontWeight);
            if (r8 == null) {
                C1283.m16865("nf_subtitles_typefactory", "No typeface for " + fontWeight);
                r8 = Typeface.SANS_SERIF;
            } else {
                C1283.m16854("nf_subtitles_typefactory", "Typeface for " + fontWeight + " is " + r8);
            }
            hashMap.put(fontWeight.name(), r8);
        }
        synchronized (f4661) {
            f4661.clear();
            f4661.putAll(hashMap);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static Typeface m4090(FontWeight fontWeight) {
        if (f4660.get()) {
            C1283.m16854("nf_subtitles_typefactory", "Forcing initializion for Android default font...");
            return m4088(fontWeight);
        }
        C1283.m16854("nf_subtitles_typefactory", "Initializing Netflix font...");
        return m4092(fontWeight);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static Typeface m4092(FontWeight fontWeight) {
        Typeface typeface = null;
        try {
            if (FontWeight.Thin == fontWeight) {
                typeface = ResourcesCompat.getFont(NetflixApplication.getInstance(), R.font.netflix_light);
            } else if (FontWeight.Light == fontWeight) {
                typeface = ResourcesCompat.getFont(NetflixApplication.getInstance(), R.font.netflix_light);
            } else if (FontWeight.Book == fontWeight) {
                typeface = ResourcesCompat.getFont(NetflixApplication.getInstance(), R.font.netflix_light);
            } else if (FontWeight.Regular == fontWeight) {
                typeface = ResourcesCompat.getFont(NetflixApplication.getInstance(), R.font.netflix_regular);
            } else if (FontWeight.Medium == fontWeight) {
                typeface = ResourcesCompat.getFont(NetflixApplication.getInstance(), R.font.netflix_regular);
            } else if (FontWeight.SemiBold == fontWeight) {
                typeface = ResourcesCompat.getFont(NetflixApplication.getInstance(), R.font.netflix_bold);
            } else if (FontWeight.Bold == fontWeight) {
                typeface = ResourcesCompat.getFont(NetflixApplication.getInstance(), R.font.netflix_bold);
            } else if (FontWeight.Black == fontWeight) {
                typeface = ResourcesCompat.getFont(NetflixApplication.getInstance(), R.font.netflix_bold);
            } else if (FontWeight.ExtraBlack == fontWeight) {
                typeface = ResourcesCompat.getFont(NetflixApplication.getInstance(), R.font.netflix_bold);
            }
            if (typeface == null) {
                C1283.m16865("nf_subtitles_typefactory", "No typeface for " + fontWeight);
                typeface = ResourcesCompat.getFont(NetflixApplication.getInstance(), R.font.netflix_regular);
            } else {
                C1283.m16854("nf_subtitles_typefactory", "Typeface for " + fontWeight + " is " + typeface);
            }
        } catch (Throwable th) {
            C1283.m16856("nf_subtitles_typefactory", th, "Unable to load Netflix font for " + fontWeight.name(), new Object[0]);
        }
        if (typeface == null) {
            return m4088(fontWeight);
        }
        return typeface;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static Typeface m4088(FontWeight fontWeight) {
        C1283.m16862("nf_subtitles_typefactory", "loadAndroidDefaultTypeFace");
        Typeface typeface = null;
        try {
            if (FontWeight.Thin == fontWeight) {
                typeface = Typeface.create("sans-serif-light", 0);
            } else if (FontWeight.Light == fontWeight) {
                typeface = Typeface.create("sans-serif-light", 0);
            } else if (FontWeight.Book == fontWeight) {
                typeface = Typeface.create("sans-serif-light", 0);
            } else if (FontWeight.Regular == fontWeight) {
                typeface = Typeface.create(Typeface.SANS_SERIF, 0);
            } else if (FontWeight.Medium == fontWeight) {
                typeface = Typeface.create("sans-serif-medium", 0);
            } else if (FontWeight.SemiBold == fontWeight) {
                typeface = Typeface.create(Typeface.SANS_SERIF, 1);
            } else if (FontWeight.Bold == fontWeight) {
                typeface = Typeface.create(Typeface.SANS_SERIF, 1);
            } else if (FontWeight.Black == fontWeight) {
                typeface = Typeface.create(Typeface.SANS_SERIF, 1);
            } else if (FontWeight.ExtraBlack == fontWeight) {
                typeface = Typeface.create(Typeface.SANS_SERIF, 1);
            }
            if (typeface == null) {
                C1283.m16865("nf_subtitles_typefactory", "No typeface for " + fontWeight);
                return Typeface.SANS_SERIF;
            }
            C1283.m16854("nf_subtitles_typefactory", "Typeface for " + fontWeight + " is " + typeface);
            return typeface;
        } catch (Throwable th) {
            C1283.m16856("nf_subtitles_typefactory", th, "Unable to load default font for " + fontWeight.name(), new Object[0]);
            return null;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    static Typeface m4086(FontWeight fontWeight) {
        if (fontWeight == null) {
            C1283.m16854("nf_subtitles_typefactory", "No font weight, use sans serif");
            return Typeface.SANS_SERIF;
        }
        Typeface typeface = f4661.get(fontWeight.name());
        if (typeface == null) {
            return Typeface.SANS_SERIF;
        }
        C1283.m16854("nf_subtitles_typefactory", "Found mapping " + typeface);
        return typeface;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    static Typeface m4089(mP mPVar) {
        return mPVar.m8866().m1168();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    static Typeface m4091() {
        return Typeface.SANS_SERIF;
    }
}

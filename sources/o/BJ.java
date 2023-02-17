package o;

import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.InvalidParameterException;
public final class BJ {
    /* renamed from: ˏ  reason: contains not printable characters */
    public static C0067 m3866(String str, String str2) {
        C0067 r3 = new C0067();
        r3.f4576 = str;
        r3.f4580 = str2;
        if (str2 == null || "".equals(str2.trim()) || str2.equals(str)) {
            r3.f4577 = false;
            try {
                if (C1349Bv.m4113(str)) {
                    return null;
                }
                String[] split = new URI(str).getPath().split("/");
                if (split.length >= 1) {
                    r3.f4579 = split[split.length - 1];
                } else {
                    throw new InvalidParameterException("expected at least one segment " + str);
                }
            } catch (URISyntaxException e) {
                throw new InvalidParameterException("Wrong catalogID URL " + str);
            } catch (NumberFormatException e2) {
                throw new InvalidParameterException("Invalid numbers in catalogID URL " + str);
            }
        } else {
            r3.f4577 = true;
            try {
                String[] split2 = new URI(str2).getPath().split("/");
                if (split2.length >= 2) {
                    r3.f4578 = split2[split2.length - 1];
                    r3.f4579 = split2[split2.length - 2];
                } else {
                    throw new InvalidParameterException("expected two path segments " + str2);
                }
            } catch (URISyntaxException e3) {
                throw new InvalidParameterException("URL syntax error " + str2);
            } catch (NumberFormatException e4) {
                throw new InvalidParameterException("Invalid numbers in URL " + str2);
            }
        }
        return r3;
    }

    /* renamed from: o.BJ$ˊ  reason: contains not printable characters */
    public static class C0067 {

        /* renamed from: ˊ  reason: contains not printable characters */
        public String f4576;

        /* renamed from: ˋ  reason: contains not printable characters */
        public boolean f4577;

        /* renamed from: ˎ  reason: contains not printable characters */
        public String f4578;

        /* renamed from: ˏ  reason: contains not printable characters */
        public String f4579;

        /* renamed from: ॱ  reason: contains not printable characters */
        public String f4580;

        public C0067(boolean z, String str, String str2, String str3, String str4) {
            this.f4577 = z;
            this.f4580 = str;
            this.f4576 = str2;
            this.f4578 = str3;
            this.f4579 = str4;
        }

        public C0067() {
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public VideoType m3868() {
            return this.f4577 ? VideoType.EPISODE : VideoType.MOVIE;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static AbstractC0573 m3867(int i) {
        return new C1040(i <= 0 ? 2500 : i, 1, 1.0f);
    }
}

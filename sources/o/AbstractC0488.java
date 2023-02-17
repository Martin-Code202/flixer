package o;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.netflix.mediaclient.repository.SecurityRepository;
import com.netflix.mediaclient.util.ConnectivityUtils;
import com.netflix.mediaclient.util.DeviceCategory;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.UUID;
/* renamed from: o.У  reason: contains not printable characters */
public abstract class AbstractC0488 implements AbstractC0518 {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final String f13570 = SecurityRepository.getEsnPrefix();

    /* renamed from: ˋ  reason: contains not printable characters */
    protected static final String f13571 = SecurityRepository.getEsnDelim();

    /* renamed from: ˎ  reason: contains not printable characters */
    protected static final String f13572 = SecurityRepository.getModelDelim();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected static String f13573;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected static String f13574;

    /* renamed from: ʻ  reason: contains not printable characters */
    protected String f13575;

    /* renamed from: ʼ  reason: contains not printable characters */
    protected String f13576;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected String f13577;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    protected String f13578;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected String f13579;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    protected String f13580;

    /* renamed from: ͺ  reason: contains not printable characters */
    protected String f13581;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected byte[] f13582;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    protected String f13583;

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public abstract byte[] mo14443(Context context);

    /* access modifiers changed from: protected */
    /* renamed from: ॱˊ  reason: contains not printable characters */
    public abstract String mo14450();

    /* access modifiers changed from: protected */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public abstract DeviceCategory mo14451();

    protected AbstractC0488() {
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    protected static String m14430(Context context) {
        String r1 = m14437(context);
        if (r1 == null) {
            r1 = m14436(context);
        }
        return C1349Bv.m4110(r1, f13572);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    protected static String m14433(Context context) {
        String str = Build.SERIAL;
        if (str == null) {
            str = m14436(context);
        }
        return C1349Bv.m4110(str, f13572);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    protected static String m14436(Context context) {
        String r2 = m14425(context);
        if (r2 == null) {
            C1283.m16865("ESN", "Device ID not found, use and save random id");
            return m14432(context);
        } else if (!"000000000000000".equalsIgnoreCase(r2)) {
            return r2;
        } else {
            C1283.m16865("ESN", "Emulator");
            return "1012UAR71QB0A91";
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m14446(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context can not be null");
        }
        m14439(context);
        m14434(context);
        m14429(context);
        mo14448();
        this.f13583 = C1339Bl.m4045(context, "nf_drm_esn", (String) null);
        C1339Bl.m4039(context, "nf_drm_esn", mo14449());
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏॱ  reason: contains not printable characters */
    public void mo14448() {
        int indexOf = f13570.indexOf("-");
        if (indexOf > 0) {
            this.f13576 = f13570.substring(0, indexOf);
        } else {
            this.f13576 = f13570;
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m14439(Context context) {
        String str;
        this.f13579 = m14427(mo14450());
        byte[] r6 = mo14443(context);
        this.f13582 = r6;
        try {
            str = C1324Ax.m3813(r6, SecurityRepository.getDeviceIdToken());
        } catch (Throwable th) {
            C1283.m16847("ESN", "===> Failed to hash device id. Use plain and report this", th);
            str = C1324Ax.m3822(this.f13582);
        }
        String r5 = m14427(str);
        StringBuilder sb = new StringBuilder();
        sb.append(f13570);
        sb.append(this.f13579).append(f13571);
        sb.append('0');
        sb.append(r5);
        this.f13577 = sb.toString();
        C1283.m16851("ESN", "is esn in new scheme:(true) %s", this.f13577);
        this.f13575 = m14428();
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private void m14434(Context context) {
        if (this.f13580 == null) {
            this.f13580 = m14427(m14435());
        }
        f13573 = m14424(context);
        StringBuilder sb = new StringBuilder();
        sb.append(f13570);
        sb.append(this.f13580).append(f13571).append(f13573);
        this.f13578 = sb.toString();
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private void m14429(Context context) {
        if (this.f13580 == null) {
            this.f13580 = m14427(m14435());
        }
        f13574 = m14438(context);
        StringBuilder sb = new StringBuilder();
        sb.append(f13570);
        sb.append(this.f13580).append(f13571).append(f13574);
        this.f13581 = sb.toString();
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static synchronized String m14424(Context context) {
        synchronized (AbstractC0488.class) {
            if (f13573 != null) {
                return f13573;
            }
            String r2 = m14430(context);
            try {
                f13573 = C1324Ax.m3815(r2, SecurityRepository.getDeviceIdToken());
            } catch (NoSuchAlgorithmException e) {
                C1283.m16847("ESN", "===> Failed to hash device id2. Use plain and report this", e);
                f13573 = r2;
            }
            return m14427(f13573);
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public static synchronized String m14438(Context context) {
        synchronized (AbstractC0488.class) {
            if (f13574 != null) {
                return f13574;
            }
            String r2 = m14433(context);
            try {
                f13574 = C1324Ax.m3813(r2.getBytes(Charset.forName("UTF-8")), SecurityRepository.getDeviceIdToken());
            } catch (Exception e) {
                C1283.m16847("ESN", "===> Failed to hash device id3. Use plain and report this", e);
                f13574 = r2;
            }
            return m14427(f13574);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m14427(String str) {
        if (str == null || "".equals(str.trim())) {
            return "";
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < upperCase.length(); i++) {
            char charAt = upperCase.charAt(i);
            if ((charAt < 'A' || charAt > 'Z') && !((charAt >= '0' && charAt <= '9') || charAt == '-' || charAt == '=')) {
                sb.append('=');
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public static String m14431() {
        return m14427(m14435());
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public static String m14428() {
        StringBuilder sb = new StringBuilder();
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        C1283.m16854("ESN", "BRAND " + str);
        C1283.m16854("ESN", "MODEL " + str2);
        int i = 0;
        if (str == null || "".equals(str.trim())) {
            sb.append("unknown");
        } else if (str.length() <= 10) {
            i = str.length();
            sb.append(str);
        } else {
            i = 10;
            sb.append(str.substring(0, 10));
        }
        sb.append("_");
        if (str2 == null || "".equals(str2.trim())) {
            sb.append("unknown");
        } else {
            int i2 = 31 - i;
            if (str2.length() <= i2) {
                sb.append(str2);
            } else {
                sb.append(str2.substring(0, i2));
            }
        }
        return sb.toString();
    }

    @Override // o.AbstractC0518
    /* renamed from: ᐝ  reason: contains not printable characters */
    public String mo14452() {
        return this.f13575;
    }

    @Override // o.AbstractC0518
    /* renamed from: ˋ  reason: contains not printable characters */
    public byte[] mo14444() {
        return this.f13582;
    }

    @Override // o.AbstractC0518
    /* renamed from: ॱ  reason: contains not printable characters */
    public String mo14449() {
        return this.f13577;
    }

    @Override // o.AbstractC0518
    /* renamed from: ˎ  reason: contains not printable characters */
    public String mo14445() {
        return this.f13578;
    }

    @Override // o.AbstractC0518
    /* renamed from: ˏ  reason: contains not printable characters */
    public String mo14447() {
        return this.f13581;
    }

    @Override // o.AbstractC0518
    /* renamed from: ˊ  reason: contains not printable characters */
    public String mo14442() {
        return this.f13576;
    }

    @Override // o.AbstractC0518
    /* renamed from: ʼ  reason: contains not printable characters */
    public String mo14441() {
        return this.f13583;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public static String m14435() {
        String str = Build.MODEL;
        if (str.length() > 45) {
            str = str.substring(0, 45);
        }
        return m14440() + C1349Bv.m4110(str, f13572) + "S";
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    protected static String m14440() {
        String str = Build.MANUFACTURER;
        if (str.length() < 5) {
            str = str + "       ";
        }
        return C1349Bv.m4124(str.substring(0, 5), f13572, false);
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private static synchronized String m14432(Context context) {
        String r2;
        synchronized (AbstractC0488.class) {
            r2 = C1339Bl.m4045(context, "nf_rnd_device_id", (String) null);
            if (r2 == null) {
                r2 = UUID.randomUUID().toString();
                C1339Bl.m4039(context, "nf_rnd_device_id", r2);
            }
        }
        return r2;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    protected static String m14425(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    protected static String m14426(Context context) {
        return ConnectivityUtils.m2961(context).getConnectionInfo().getMacAddress();
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private static String m14437(Context context) {
        String r2 = m14426(context);
        String str = Build.SERIAL;
        if (r2 == null && str == null) {
            C1283.m16865("ESN", "Both mac address and SERIAL are null!");
            return null;
        } else if (r2 == null) {
            return str;
        } else {
            if (str == null) {
                return r2;
            }
            return r2 + str;
        }
    }
}

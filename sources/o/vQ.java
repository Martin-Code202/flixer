package o;

import android.content.Context;
import android.os.Handler;
import com.netflix.mediaclient.R;
import io.realm.Realm;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
public class vQ implements AbstractC2102qv {

    /* renamed from: ˊ  reason: contains not printable characters */
    private Realm f11230;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final vS f11231 = new vS();

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f11232;

    /* renamed from: ˎ  reason: contains not printable characters */
    public vM m12032() {
        return this.f11231;
    }

    @Override // o.AbstractC2102qv
    /* renamed from: ˏ */
    public AbstractC1852hk mo10120(Handler handler, Context context, oS oSVar, AbstractC0933 r5, boolean z, AbstractC1853hl hlVar) {
        return vC.m11851(handler, context, oSVar, r5, z, hlVar);
    }

    @Override // o.AbstractC2102qv
    /* renamed from: ˎ */
    public String mo10118(Context context, long j, Locale locale) {
        return C0403.m14185(context, R.string.offline_message_download_frequency_warning_description).m14187(1).m14186("date", DateFormat.getDateInstance(1, locale).format(new Date(j))).m14188();
    }

    @Override // o.AbstractC2102qv
    /* renamed from: ˋ */
    public void mo10117(Map<String, pV> map) {
        this.f11231.m12039(m12031(), map, this.f11232);
    }

    @Override // o.AbstractC2102qv
    /* renamed from: ˎ */
    public pV mo10119(String str) {
        return this.f11231.mo11976(str);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private Realm m12031() {
        if (this.f11230 == null) {
            this.f11230 = C2093qn.m10094();
        }
        return this.f11230;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m12033(boolean z) {
        boolean z2 = z != this.f11232;
        this.f11232 = z;
        return z2;
    }
}

package o;

import android.content.Context;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.StatusCode;
/* renamed from: o.xp  reason: case insensitive filesystem */
public class C2321xp extends AbstractC2317xm {
    @Override // o.AbstractC2317xm, o.AbstractC1268
    /* renamed from: ˎ */
    public /* bridge */ /* synthetic */ C1278 mo10135() {
        return super.mo10135();
    }

    @Override // o.AbstractC2317xm, o.AbstractC1268
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ int mo10136() {
        return super.mo10136();
    }

    @Override // o.AbstractC2317xm, o.AbstractC1268
    /* renamed from: ॱ */
    public /* bridge */ /* synthetic */ Runnable mo10137() {
        return super.mo10137();
    }

    C2321xp(C1278 r1) {
        super(r1);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static C2321xp m12967(Context context, StatusCode statusCode) {
        C1283.m16865("nf_play_error", "Blacklisted device, offline not supported");
        return new C2321xp(new C1278("", context.getString(R.string.offline_disabled_generic, "(" + statusCode.m271() + ")"), context.getString(R.string.label_ok), null));
    }
}

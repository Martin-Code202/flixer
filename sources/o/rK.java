package o;

import android.content.Context;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.app.Status;
public class rK implements AbstractC1268 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private C1278 f9646;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Context f9647;

    public rK(Context context, Status status, final boolean z) {
        this.f9647 = context;
        String string = this.f9647.getString(R.string.label_delayed_crypto_initialization_failure, Integer.valueOf(status.mo302().m271()));
        C1339Bl.m4041(context, "nf_drm_esn");
        this.f9646 = new C1278("", string, context.getString(R.string.label_ok), new Runnable() { // from class: o.rK.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C1283.m16854("ErrorManager", "Waiting 1.5 second to exit app");
                    if (!z) {
                        wait(1500);
                    }
                } catch (Exception e) {
                    C1283.m16855("ErrorManager", "Wait is interrupted", e);
                }
                C1283.m16854("ErrorManager", "Kill app");
                C1317As.m3756(rK.this.f9647);
            }
        });
    }

    @Override // o.AbstractC1268
    /* renamed from: ˏ */
    public int mo10136() {
        return 0;
    }

    @Override // o.AbstractC1268
    /* renamed from: ॱ */
    public Runnable mo10137() {
        return null;
    }

    @Override // o.AbstractC1268
    /* renamed from: ˎ */
    public C1278 mo10135() {
        return this.f9646;
    }
}

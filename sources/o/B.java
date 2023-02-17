package o;

import android.content.Context;
import com.netflix.mediaclient.util.ConnectivityUtils;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class B {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final int f4565 = ((int) TimeUnit.MINUTES.toMillis(30));

    /* renamed from: ˊ  reason: contains not printable characters */
    private ConnectivityUtils.NetType f4566 = ConnectivityUtils.m2958(this.f4568);

    /* renamed from: ˎ  reason: contains not printable characters */
    ScheduledExecutorService f4567;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Context f4568;

    public B(Context context) {
        this.f4568 = context;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m3833(ScheduledExecutorService scheduledExecutorService, final oQ oQVar) {
        this.f4567 = scheduledExecutorService;
        this.f4567.scheduleAtFixedRate(new Runnable() { // from class: o.B.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C0721.m15050().m15056();
                    if (B.this.f4566 == ConnectivityUtils.NetType.wifi) {
                        String r2 = C0721.m15050().m15054();
                        C1283.m16854("nf_clientstats", "Sending log");
                        oQVar.mo5226(new C1541bP(r2));
                        C0721.m15050().m15058();
                    }
                } catch (NullPointerException e) {
                    C1283.m16847("nf_clientstats", "problem sending log", e);
                }
            }
        }, (long) f4565, (long) f4565, TimeUnit.MILLISECONDS);
    }
}

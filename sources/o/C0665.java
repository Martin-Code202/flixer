package o;

import android.content.Context;
import com.android.volley.Request;
import java.util.concurrent.BlockingQueue;
import org.chromium.net.ExperimentalCronetEngine;
/* renamed from: o.য  reason: contains not printable characters */
public class C0665 extends C1172 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final boolean f14031;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Context f14032;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final ExperimentalCronetEngine f14033;

    public C0665(Context context, ExperimentalCronetEngine experimentalCronetEngine, boolean z) {
        this.f14032 = context;
        this.f14033 = experimentalCronetEngine;
        this.f14031 = z;
    }

    @Override // o.C1172
    /* renamed from: ˎ  reason: contains not printable characters */
    public AbstractC1215 mo14859(BlockingQueue<Request> blockingQueue, AbstractC0419 r10, AbstractC1001 r11, AbstractC0450 r12, String str) {
        if (!m14860()) {
            C1283.m16848("nf_network", "creating NetworkDispatcher thread for %s", str);
            return new C1170(blockingQueue, r10, r11, r12, str);
        }
        C1283.m16848("nf_network", "creating AsynchronousNetworkDispatcher thread for %s", str);
        return new C0563(this.f14032, this.f14033, blockingQueue, r10, r11, r12, str);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m14860() {
        if (this.f14033 == null) {
            return false;
        }
        return this.f14031;
    }
}

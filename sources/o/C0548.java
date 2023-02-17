package o;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.service.logging.client.model.Version;
/* renamed from: o.ג  reason: contains not printable characters */
public final class C0548 implements AbstractC1219 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Context f13762;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final PendingIntent f13763;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC0939 f13764;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C0559 f13765;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final boolean f13766 = true;

    public C0548(Context context) {
        this.f13762 = context;
        this.f13763 = PendingIntent.getBroadcast(context, 0, new Intent(), 0);
        this.f13765 = new C0559();
        this.f13764 = new C1152(context);
    }

    @Override // o.AbstractC1219
    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean mo14591() {
        return true;
    }

    @Override // o.AbstractC1219
    /* renamed from: ॱ  reason: contains not printable characters */
    public int mo14592(C0552 r3) {
        this.f13762.sendBroadcast(m14589(r3));
        return 0;
    }

    @Override // o.AbstractC1219
    /* renamed from: ˎ  reason: contains not printable characters */
    public AbstractC0939 mo14590() {
        return this.f13764;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private Intent m14589(AbstractC0639 r4) {
        Intent r2 = m14588("SCHEDULE_TASK");
        r2.putExtras(this.f13765.m14638(r4, r2.getExtras()));
        return r2;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private Intent m14588(String str) {
        Intent intent = new Intent("com.google.android.gms.gcm.ACTION_SCHEDULE");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("scheduler_action", str);
        intent.putExtra(Version.APP, this.f13763);
        intent.putExtra(NetflixActivity.EXTRA_SOURCE, 8);
        intent.putExtra("source_version", 1);
        return intent;
    }
}

package o;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import com.netflix.mediaclient.R;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"InlinedApi"})
/* renamed from: o.Ai  reason: case insensitive filesystem */
class C1307Ai implements AbstractC2027oc {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AtomicBoolean f4432 = new AtomicBoolean(false);

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Context f4433;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final NotificationManager f4434;

    C1307Ai(Context context) {
        this.f4433 = context;
        this.f4434 = (NotificationManager) this.f4433.getSystemService("notification");
    }

    @Override // o.AbstractC2027oc
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo3631(final oS oSVar, Handler handler) {
        this.f4432.set(true);
        final Notification r2 = m3626(false);
        handler.post(new Runnable() { // from class: o.Ai.3
            @Override // java.lang.Runnable
            public void run() {
                oSVar.mo9579(20, r2);
            }
        });
    }

    @Override // o.AbstractC2027oc
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo3629(final oS oSVar, Handler handler) {
        this.f4432.set(true);
        final Notification r2 = m3626(true);
        handler.post(new Runnable() { // from class: o.Ai.4
            @Override // java.lang.Runnable
            public void run() {
                oSVar.mo9579(20, r2);
            }
        });
    }

    @Override // o.AbstractC2027oc
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo3630(final oS oSVar, Handler handler) {
        C1283.m16854("nf_voip", "Cancel notification");
        this.f4432.set(false);
        handler.post(new Runnable() { // from class: o.Ai.2
            @Override // java.lang.Runnable
            public void run() {
                oSVar.mo9578(20, true);
            }
        });
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private Notification m3626(boolean z) {
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        String string = this.f4433.getString(R.string.label_cs_netflix_help_center_title);
        String string2 = this.f4433.getString(R.string.label_cs_notification_hangup);
        if (z) {
            str = this.f4433.getString(R.string.label_cs_notification_status_connected);
        } else {
            str = this.f4433.getString(R.string.label_cs_notification_status_connecting);
        }
        Notification build = new NotificationCompat.Builder(this.f4433, "help_notification_channel").setOngoing(true).setVisibility(1).setOnlyAlertOnce(true).setCategory("call").setSmallIcon(R.drawable.ic_statusbar_call).setLargeIcon(m3625()).setPriority(2).setContentTitle(string).setContentText(str).setTicker(string).setContentIntent(m3628()).setDeleteIntent(m3627()).addAction(R.drawable.ic_call_end_ongoing_notification, string2, m3627()).setAutoCancel(false).setWhen(currentTimeMillis).setUsesChronometer(z).build();
        build.flags |= 64;
        this.f4434.notify(20, build);
        return build;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private Bitmap m3625() {
        return BitmapFactory.decodeResource(this.f4433.getResources(), R.drawable.ic_ongoing_notification);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private PendingIntent m3628() {
        return PendingIntent.getActivity(this.f4433, 0, ActivityC1313Ao.m3721(this.f4433), 268435456);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private PendingIntent m3627() {
        return PendingIntent.getBroadcast(this.f4433, 0, new Intent("com.netflix.mediaclient.intent.action.CALL_CANCEL").addCategory("com.netflix.mediaclient.intent.category.VOIP"), 268435456);
    }
}

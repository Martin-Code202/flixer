package o;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Handler;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import o.vC;
/* access modifiers changed from: package-private */
@TargetApi(24)
public class vG extends vC {
    public vG(Handler handler, Context context, oS oSVar, AbstractC0933 r4, boolean z, AbstractC1853hl hlVar) {
        super(handler, context, oSVar, r4, z, hlVar);
    }

    /* access modifiers changed from: protected */
    @Override // o.vC
    /* renamed from: ˋ */
    public void mo11875(Notification.Builder builder, pV pVVar) {
        builder.addAction(new Notification.Action.Builder(Icon.createWithResource(this.f11115, (int) R.drawable.ic_pause), this.f11115.getString(R.string.label_notification_stop_download), m11873(pVVar.mo6915())).build());
    }

    /* access modifiers changed from: protected */
    @Override // o.vC
    /* renamed from: ˎ */
    public void mo11880(Notification.Builder builder, pV pVVar, VideoType videoType) {
        builder.addAction(new Notification.Action.Builder(Icon.createWithResource(this.f11115, (int) R.drawable.notif_play), this.f11115.getString(R.string.label_notification_watch_download), m11876(pVVar.mo6915(), videoType)).build());
    }

    /* access modifiers changed from: protected */
    @Override // o.vC
    /* renamed from: ˊ */
    public void mo11871(Notification.Builder builder, pV pVVar) {
        builder.addAction(new Notification.Action.Builder(Icon.createWithResource(this.f11115, (int) R.drawable.ic_cancel_white_24dp), this.f11115.getString(R.string.label_notification_cancel_download), m11881(pVVar.mo6915())).build());
    }

    /* access modifiers changed from: protected */
    @Override // o.vC
    /* renamed from: ˎ */
    public void mo11879(Notification.Builder builder, pV pVVar) {
        builder.addAction(new Notification.Action.Builder(Icon.createWithResource(this.f11115, (int) R.drawable.ic_file_download_white_24dp), this.f11115.getString(R.string.label_notification_resume_download), m11882(pVVar.mo6915())).build());
    }

    /* access modifiers changed from: protected */
    @Override // o.vC
    /* renamed from: ˋ */
    public String mo11874(pV pVVar, vC.If r3) {
        return m11877(pVVar, r3);
    }

    /* access modifiers changed from: protected */
    @Override // o.vC
    /* renamed from: ॱ */
    public String mo11883(pV pVVar, vC.If r3) {
        return m11877(pVVar, r3);
    }

    /* access modifiers changed from: protected */
    @Override // o.vC
    /* renamed from: ˎ */
    public void mo11878(Notification.Builder builder) {
        builder.setSmallIcon(17301634);
    }

    /* access modifiers changed from: protected */
    @Override // o.vC
    /* renamed from: ˊ */
    public void mo11870(Notification.Builder builder) {
        builder.setSmallIcon(17301633);
    }

    /* access modifiers changed from: protected */
    @Override // o.vC
    /* renamed from: ˋ */
    public int mo11872() {
        return R.drawable.ic_nf_download_complete_white;
    }

    /* access modifiers changed from: protected */
    @Override // o.vC
    /* renamed from: ˊ */
    public int mo11869() {
        return R.drawable.ic_nf_download_error_white;
    }
}

package o;

import android.app.Notification;
import android.content.Context;
import android.os.Handler;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import o.vC;
/* access modifiers changed from: package-private */
public class vE extends vC {
    public vE(Handler handler, Context context, oS oSVar, AbstractC0933 r4, boolean z, AbstractC1853hl hlVar) {
        super(handler, context, oSVar, r4, z, hlVar);
    }

    /* access modifiers changed from: protected */
    @Override // o.vC
    /* renamed from: ˋ */
    public void mo11875(Notification.Builder builder, pV pVVar) {
        builder.addAction(R.drawable.ic_pause, this.f11115.getString(R.string.label_notification_stop_download), m11873(pVVar.mo6915()));
    }

    /* access modifiers changed from: protected */
    @Override // o.vC
    /* renamed from: ˎ */
    public void mo11880(Notification.Builder builder, pV pVVar, VideoType videoType) {
        builder.addAction(R.drawable.notif_play, this.f11115.getString(R.string.label_notification_watch_download), m11876(pVVar.mo6915(), videoType));
    }

    /* access modifiers changed from: protected */
    @Override // o.vC
    /* renamed from: ˊ */
    public void mo11871(Notification.Builder builder, pV pVVar) {
        builder.addAction(R.drawable.ic_cancel_white_24dp, this.f11115.getString(R.string.label_notification_cancel_download), m11881(pVVar.mo6915()));
    }

    /* access modifiers changed from: protected */
    @Override // o.vC
    /* renamed from: ˎ */
    public void mo11879(Notification.Builder builder, pV pVVar) {
        builder.addAction(R.drawable.ic_file_download_white_24dp, this.f11115.getString(R.string.label_notification_resume_download), m11882(pVVar.mo6915()));
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
        builder.setSmallIcon(R.drawable.ic_sb_netflix_n);
    }

    /* access modifiers changed from: protected */
    @Override // o.vC
    /* renamed from: ˊ */
    public void mo11870(Notification.Builder builder) {
        builder.setSmallIcon(R.drawable.ic_sb_netflix_n);
    }

    /* access modifiers changed from: protected */
    @Override // o.vC
    /* renamed from: ˋ */
    public int mo11872() {
        return R.drawable.ic_sb_netflix_n;
    }

    /* access modifiers changed from: protected */
    @Override // o.vC
    /* renamed from: ˊ */
    public int mo11869() {
        return R.drawable.ic_sb_netflix_n;
    }
}

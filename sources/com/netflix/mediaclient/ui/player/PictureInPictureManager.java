package com.netflix.mediaclient.ui.player;

import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.RemoteAction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Icon;
import android.util.Rational;
import com.netflix.mediaclient.R;
import java.util.ArrayList;
import o.C1276;
public class PictureInPictureManager {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final String f3459 = PictureInPictureManager.class.getSimpleName();

    /* renamed from: ʼ  reason: contains not printable characters */
    private iF f3460;

    /* renamed from: ˊ  reason: contains not printable characters */
    private IPlayerFragment f3461;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final PictureInPictureParams.Builder f3462 = new PictureInPictureParams.Builder();

    /* renamed from: ˏ  reason: contains not printable characters */
    private BroadcastReceiver f3463;

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f3464;

    public enum PipAction {
        PAUSE,
        PLAY
    }

    public static abstract class iF {
        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo2371(boolean z) {
        }
    }

    public PictureInPictureManager(IPlayerFragment iPlayerFragment, iF iFVar) {
        this.f3461 = iPlayerFragment;
        this.f3464 = false;
        this.f3460 = iFVar;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m2368() {
        return this.f3464;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m2366(boolean z) {
        this.f3464 = z;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m2370(PipAction pipAction) {
        int i;
        int i2;
        String str;
        int i3;
        switch (pipAction) {
            case PLAY:
                i3 = R.drawable.ic_play;
                str = "Play";
                i2 = 1;
                i = 1;
                break;
            case PAUSE:
                i3 = R.drawable.ic_pause;
                str = "Pause";
                i2 = 2;
                i = 2;
                break;
            default:
                return;
        }
        ArrayList arrayList = new ArrayList();
        Context r7 = this.f3461.mo2269();
        if (r7 != null) {
            arrayList.add(new RemoteAction(Icon.createWithResource(r7, i3), str, str, PendingIntent.getBroadcast(r7, i, new Intent("media_control").putExtra("control_type", i2), 0)));
            this.f3462.setActions(arrayList);
            this.f3461.m2242().setPictureInPictureParams(this.f3462.build());
            return;
        }
        C1276.m16820().mo5725("Fragment not attached to an activity, cannot update actions");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m2369(Rational rational) {
        this.f3462.setAspectRatio(rational);
        if (this.f3461.mo2226() != null) {
            this.f3461.mo2226().m12494();
        }
        this.f3461.m2242().enterPictureInPictureMode();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m2367(boolean z) {
        m2366(z);
        if (z) {
            this.f3463 = new BroadcastReceiver() { // from class: com.netflix.mediaclient.ui.player.PictureInPictureManager.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (intent != null && "media_control".equals(intent.getAction())) {
                        switch (intent.getIntExtra("control_type", 0)) {
                            case 1:
                                PictureInPictureManager.this.f3461.mo2247();
                                return;
                            case 2:
                                PictureInPictureManager.this.f3461.mo2240();
                                return;
                            default:
                                return;
                        }
                    }
                }
            };
            this.f3461.m2242().registerReceiver(this.f3463, new IntentFilter("media_control"));
        } else if (this.f3463 != null) {
            this.f3461.m2242().unregisterReceiver(this.f3463);
            this.f3463 = null;
        }
        this.f3460.mo2371(z);
    }
}

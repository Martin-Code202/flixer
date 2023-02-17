package o;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.netflix.mediaclient.android.app.BackgroundTask;
/* renamed from: o.a  reason: case insensitive filesystem */
public final class C1468a extends AbstractC1052 implements oH {

    /* renamed from: ˋ  reason: contains not printable characters */
    private AbstractC1268 f5889;

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1052
    /* renamed from: ʽ */
    public void mo1237() {
        C1283.m16854("ErrorAgent", "ErrorAgent::init done ");
        m16090(AbstractC0367.f13235);
        C1283.m16854("ErrorAgent", "ErrorAgent::init done ");
    }

    @Override // o.oH
    /* renamed from: ˊ  reason: contains not printable characters */
    public AbstractC1268 mo5360() {
        return this.f5889;
    }

    @Override // o.oH
    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized void mo5363(AbstractC1268 r3) {
        if (this.f5889 == r3) {
            C1283.m16854("ErrorAgent", "Current error is reported to user by UI!");
            this.f5889 = null;
        } else {
            C1283.m16850("ErrorAgent", "Current error is not one that UI just handled!");
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m5359(Context context) {
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("com.netflix.mediaclient.ui.error.ACTION_DISPLAY_ERROR"));
    }

    @Override // o.oH
    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean mo5362(AbstractC1268 r3) {
        if (r3 == null) {
            return false;
        }
        m5358(r3);
        if (this.f5889 == null) {
            C1283.m16854("ErrorAgent", "No previous errors, display this one");
            this.f5889 = r3;
            m5359(m16093());
            return true;
        } else if (this.f5889.mo10136() >= r3.mo10136()) {
            return false;
        } else {
            this.f5889 = r3;
            m5359(m16093());
            return true;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m5358(AbstractC1268 r3) {
        if (r3 != null && r3.mo10137() != null) {
            C1283.m16854("ErrorAgent", "Execute background task!!!");
            new BackgroundTask().m285(r3.mo10137());
        }
    }

    @Override // o.oH
    /* renamed from: ˋ  reason: contains not printable characters */
    public synchronized void mo5361() {
        this.f5889 = null;
    }
}

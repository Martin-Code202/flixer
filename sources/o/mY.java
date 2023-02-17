package o;

import android.content.BroadcastReceiver;
import com.netflix.mediaclient.android.app.BackgroundTask;
public class mY {

    /* renamed from: ˎ  reason: contains not printable characters */
    BroadcastReceiver.PendingResult f8864;

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8982() {
        if (this.f8864 != null) {
            this.f8864.finish();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m8981(BroadcastReceiver.PendingResult pendingResult, Runnable runnable) {
        this.f8864 = pendingResult;
        new BackgroundTask().m285(runnable);
    }

    public class iF {

        /* renamed from: ˋ  reason: contains not printable characters */
        mY f8866;

        public iF(mY mYVar) {
            this.f8866 = mYVar;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public void m8983() {
            this.f8866.m8982();
        }
    }
}

package o;

import android.view.View;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.service.configuration.persistent.Config_Ab9454_InPlayerPivots;
import com.netflix.mediaclient.ui.player.PlayerFragment;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
public abstract class vZ extends wF {

    /* renamed from: ˎ  reason: contains not printable characters */
    protected TextView f11300;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected AtomicBoolean f11301 = new AtomicBoolean(false);

    /* renamed from: ॱ  reason: contains not printable characters */
    protected View f11302;

    /* renamed from: ˋ  reason: contains not printable characters */
    public abstract void mo12112(boolean z);

    /* renamed from: ˎ  reason: contains not printable characters */
    public abstract void mo12114(ByteBuffer byteBuffer);

    /* renamed from: ॱ  reason: contains not printable characters */
    public abstract void mo12116();

    vZ(PlayerFragment playerFragment) {
        super(playerFragment);
        this.f11302 = playerFragment.getView().findViewById(R.id.current_time);
        this.f11300 = (TextView) playerFragment.getView().findViewById(R.id.current_timeLabel);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12110() {
        C1283.m16862("screen", "Hide time");
        BQ.m3916(this.f11302, false);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m12115() {
        C1283.m16862("screen", "Show time");
        BQ.m3916(this.f11302, true);
    }

    @Override // o.wF
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void mo12118() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m12111() {
        if (this.f11438 != null && this.f11438.m14535()) {
            if (this.f11438.mo2234().m12293()) {
                this.f11438.m2528();
                this.f11438.mo2234().m12288(false);
                if (!this.f11438.m14534().isTablet()) {
                    this.f11438.mo2226().mo12451();
                }
            }
            this.f11438.mo2234().m12297(false);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12113() {
        m12383("screen", this.f11300, "currentTimeLabel", this.f11438.mo2226().m12513());
        mo12116();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    static vZ m12109(PlayerFragment playerFragment) {
        if (C0650.m14799() || Config_Ab9454_InPlayerPivots.m517()) {
            return new C2262wd(playerFragment);
        }
        if (C2275wq.m12487(playerFragment.m14534().isTablet())) {
            return new C2263we(playerFragment);
        }
        return new C2265wg(playerFragment);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m12117(boolean z) {
        this.f11301.set(z);
    }
}

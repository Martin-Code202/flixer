package o;

import android.widget.RelativeLayout;
import com.netflix.mediaclient.ui.player.PlayerFragment;
import java.nio.ByteBuffer;
/* renamed from: o.wg  reason: case insensitive filesystem */
public class C2265wg extends vZ {
    C2265wg(PlayerFragment playerFragment) {
        super(playerFragment);
    }

    @Override // o.vZ
    /* renamed from: ˎ */
    public synchronized void mo12114(ByteBuffer byteBuffer) {
        this.f11438.mo2226().m12521(byteBuffer);
        C1283.m16854("screen", "Movie current time from startCurrentTime");
    }

    @Override // o.vZ
    /* renamed from: ˋ */
    public synchronized void mo12112(boolean z) {
        m12111();
    }

    @Override // o.vZ
    /* renamed from: ॱ */
    public void mo12116() {
        if (this.f11438 != null && this.f11302 != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f11302.getLayoutParams();
            layoutParams.setMargins(this.f11438.mo2226().m12501(this.f11302), 0, 0, 0);
            this.f11302.setLayoutParams(layoutParams);
            C1283.m16854("screen", "moveCurrentTimeWithTimeline set layout parameter!");
        }
    }
}

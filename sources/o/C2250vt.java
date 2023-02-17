package o;

import android.content.Intent;
/* renamed from: o.vt  reason: case insensitive filesystem */
public final class C2250vt extends AbstractC2242vl {
    C2250vt() {
        super("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_STATE");
    }

    @Override // o.AbstractC2245vo
    /* renamed from: ˋ */
    public void mo12131(AbstractC2238vh vhVar, Intent intent) {
        C1283.m16854("mdxui", "Remote state is changed");
        vhVar.mo12137(intent.getStringExtra("currentState"), intent.getIntExtra("time", 0), intent.getIntExtra("volume", 0), intent.getBooleanExtra("isInSkipIntroWindow", false), intent.getStringExtra("skipIntroText"));
    }
}

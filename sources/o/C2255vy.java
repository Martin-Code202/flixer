package o;

import android.content.Intent;
/* renamed from: o.vy  reason: case insensitive filesystem */
public final class C2255vy extends AbstractC2242vl {
    C2255vy() {
        super("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_TARGETLIST");
    }

    @Override // o.AbstractC2245vo
    /* renamed from: ˋ */
    public void mo12131(AbstractC2238vh vhVar, Intent intent) {
        C1283.m16854("mdxui", "Target list changed");
        vhVar.mo12136();
    }
}

package o;

import android.content.Intent;
/* renamed from: o.vm  reason: case insensitive filesystem */
public final class C2243vm extends AbstractC2242vl {
    C2243vm() {
        super("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_ERROR");
    }

    @Override // o.AbstractC2245vo
    /* renamed from: ˋ */
    public void mo12131(AbstractC2238vh vhVar, Intent intent) {
        C1283.m16854("mdxui", "Error");
        vhVar.mo12139(intent.getIntExtra("errorCode", 0), intent.getStringExtra("errorDesc"));
    }
}

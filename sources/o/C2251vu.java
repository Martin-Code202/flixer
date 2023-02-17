package o;

import android.content.Intent;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
/* renamed from: o.vu  reason: case insensitive filesystem */
public final class C2251vu extends AbstractC2242vl {
    C2251vu() {
        super("com.netflix.mediaclient.intent.action.MDXUPDATE_MOVIEMETADA");
    }

    @Override // o.AbstractC2245vo
    /* renamed from: ˋ */
    public void mo12131(AbstractC2238vh vhVar, Intent intent) {
        C1283.m16854("mdxui", "Video metadata update");
        vhVar.mo12138(intent.getIntExtra(SessionEndedEvent.DURATION, 0));
    }
}

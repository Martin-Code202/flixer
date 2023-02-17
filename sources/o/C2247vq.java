package o;

import android.content.Intent;
/* renamed from: o.vq  reason: case insensitive filesystem */
public final class C2247vq extends AbstractC2242vl {
    C2247vq() {
        super("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_CAPABILITY");
    }

    @Override // o.AbstractC2245vo
    /* renamed from: ˋ */
    public void mo12131(AbstractC2238vh vhVar, Intent intent) {
        C1283.m16854("mdxui", "Update capability");
        try {
            vhVar.mo12134(new C1702eO(intent.getStringExtra("stringBlob")));
        } catch (Exception e) {
            C1283.m16847("mdxui", "Failed to extract capability data ", e);
        }
    }
}

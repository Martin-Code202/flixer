package o;

import android.content.Intent;
/* renamed from: o.vk  reason: case insensitive filesystem */
public class C2241vk extends AbstractC2242vl {
    public C2241vk() {
        super("com.netflix.mediaclient.intent.action.MDX_ACTION__NETWORK_CONNECTIVITY_CHANGE");
    }

    @Override // o.AbstractC2245vo
    /* renamed from: ˋ */
    public void mo12131(AbstractC2238vh vhVar, Intent intent) {
        C1283.m16854("mdxui", "MDX_ACTION__NETWORK_CONNECTIVITY_CHANGE");
        vhVar.mo12144(intent.getBooleanExtra("networkConnected", true));
    }
}

package o;

import android.content.Intent;
import org.json.JSONException;
/* renamed from: o.vf  reason: case insensitive filesystem */
public final class C2236vf extends AbstractC2242vl {
    C2236vf() {
        super("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_DIALOGSHOW");
    }

    @Override // o.AbstractC2245vo
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo12131(AbstractC2238vh vhVar, Intent intent) {
        C1283.m16854("mdxui", "Show dialog");
        String stringExtra = intent.getStringExtra("stringBlob");
        try {
            vhVar.mo12135(new C2232vb(stringExtra));
        } catch (JSONException e) {
            C1283.m16847("mdxui", "Unable to display dialog, failed to process " + stringExtra, e);
        }
    }
}

package o;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
/* renamed from: o.ᔅ  reason: contains not printable characters */
public class ActivityC0860 extends Activity {
    /* access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0895.m15619("ProxyBillingActivity", "Launching Play Store billing flow");
        try {
            startIntentSenderForResult(((PendingIntent) getIntent().getParcelableExtra("BUY_INTENT")).getIntentSender(), 100, new Intent(), 0, 0, 0);
        } catch (IntentSender.SendIntentException e) {
            C0895.m15616("ProxyBillingActivity", "Got exception while trying to start a purchase flow: " + e);
            m15545(6, null);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            int r3 = C0895.m15617(intent, "ProxyBillingActivity");
            if (!(i2 == -1 && r3 == 0)) {
                C0895.m15616("ProxyBillingActivity", "Got purchases updated result with resultCode " + i2 + " and billing's responseCode: " + r3);
            }
            m15545(r3, intent == null ? null : intent.getExtras());
        } else {
            C0895.m15616("ProxyBillingActivity", "Got onActivityResult with wrong requestCode: " + i + "; skipping...");
        }
        finish();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m15545(int i, Bundle bundle) {
        Intent intent = new Intent("proxy_activity_response_intent_action");
        intent.putExtra("response_code_key", i);
        intent.putExtra("response_bundle_key", bundle);
        C0811.m15374(this).m15377(intent);
    }
}

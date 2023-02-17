package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
/* access modifiers changed from: package-private */
/* renamed from: o.ˁ  reason: contains not printable characters */
public class C0426 {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final C0427 f13417;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Context f13418;

    C0426(Context context, AbstractC0888 r4) {
        this.f13418 = context;
        this.f13417 = new C0427(r4);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m14235() {
        this.f13418.registerReceiver(this.f13417, new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED"));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˊ  reason: contains not printable characters */
    public AbstractC0888 m14234() {
        return this.f13417.f13420;
    }

    /* renamed from: o.ˁ$ˋ  reason: contains not printable characters */
    class C0427 extends BroadcastReceiver {

        /* renamed from: ॱ  reason: contains not printable characters */
        private final AbstractC0888 f13420;

        private C0427(AbstractC0888 r2) {
            this.f13420 = r2;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            this.f13420.onPurchasesUpdated(C0895.m15617(intent, "BillingBroadcastManager"), C0895.m15614(intent.getExtras()));
        }
    }
}

package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
public class iJ extends BroadcastReceiver {

    /* renamed from: ˊ  reason: contains not printable characters */
    private C1896ix f7536;

    public iJ(C1896ix ixVar) {
        this.f7536 = ixVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int intExtra = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("status", -1);
        if (intExtra == 2 || intExtra == 5) {
            this.f7536.m7785(true);
        }
    }
}

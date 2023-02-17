package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
/* renamed from: o.ｸ  reason: contains not printable characters */
public class C1255 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static int f15828 = 2;

    /* renamed from: ˋ  reason: contains not printable characters */
    private static int f15829 = 2;

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final String f15830 = C1255.class.getSimpleName();

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f15831;

    /* renamed from: ʼ  reason: contains not printable characters */
    private int f15832 = C1339Bl.m4037(this.f15835, "channelIdAppLaunches", 0);

    /* renamed from: ʽ  reason: contains not printable characters */
    private C1256 f15833;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f15834 = C1339Bl.m4045(this.f15835, "channelIdValue", (String) null);

    /* renamed from: ॱ  reason: contains not printable characters */
    private Context f15835;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private Handler f15836;

    public C1255(Context context, Handler handler) {
        this.f15835 = context;
        this.f15836 = handler;
        this.f15832++;
        C1339Bl.m4042(this.f15835, "channelIdAppLaunches", this.f15832);
        if (m16685()) {
            C1283.m16854(f15830, "need to request channelId");
            m16680();
            this.f15831++;
            m16676();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m16686() {
        C1283.m16851(f15830, "requestChannelId %s", this.f15834);
        m16682();
        return this.f15834;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m16687() {
        m16684();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m16682() {
        if (m16685()) {
            this.f15831++;
            m16676();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m16680() {
        this.f15833 = new C1256();
        this.f15835.registerReceiver(this.f15833, new IntentFilter("com.netflix.partner.activation.intent.action.CHANNEL_ID_RESPONSE"), "com.netflix.partner.activation.permission.CHANNEL_ID", this.f15836);
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m16684() {
        if (this.f15833 != null) {
            this.f15835.unregisterReceiver(this.f15833);
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean m16685() {
        if (!C1349Bv.m4107(this.f15834) && !m16677() && !m16675()) {
            return true;
        }
        return false;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean m16677() {
        return this.f15832 > f15828;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean m16675() {
        return this.f15831 > f15829;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m16676() {
        C1283.m16851(f15830, "inquiring for channelId appLaunchCount: %d(%d), currentCheckCount: %d(%d)", Integer.valueOf(this.f15832), Integer.valueOf(f15828), Integer.valueOf(this.f15831), Integer.valueOf(f15829));
        Intent intent = new Intent("com.netflix.partner.activation.intent.action.CHANNEL_ID_REQUEST");
        intent.addFlags(32);
        this.f15835.sendBroadcast(intent, "com.netflix.partner.activation.permission.CHANNEL_ID");
    }

    /* renamed from: o.ｸ$ˋ  reason: contains not printable characters */
    public final class C1256 extends BroadcastReceiver {
        public C1256() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C1283.m16854(C1255.f15830, "dropping null intent");
                return;
            }
            String action = intent.getAction();
            C1283.m16863(C1255.f15830, "ChannelId receiver invoked and received Intent with Action %s", action);
            if (!"com.netflix.partner.activation.intent.action.CHANNEL_ID_RESPONSE".equals(action)) {
                C1283.m16865(C1255.f15830, "dropping intent! wrong action");
                return;
            }
            String stringExtra = intent.getStringExtra("channelId");
            if (!C1349Bv.m4107(stringExtra)) {
                return;
            }
            if (C1349Bv.m4107(C1255.this.f15834)) {
                C1283.m16865(C1255.f15830, "Ignoring channelId intent - already got");
                return;
            }
            C1339Bl.m4039(C1255.this.f15835, "channelIdValue", stringExtra);
            C1255.this.f15834 = stringExtra;
            C1283.m16851(C1255.f15830, "Got channelId : %s", C1255.this.f15834);
        }
    }
}

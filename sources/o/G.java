package o;

import android.content.Intent;
class G implements AbstractC2044ot {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final K f5683;

    G(K k) {
        this.f5683 = k;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m5050(String str, String str2, String str3) {
        C1283.m16854("nf_log_dial", "serverDiscovered");
        this.f5683.mo4783(new C1526bB(str, str2, str3));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m5051(Intent intent) {
        String action = intent.getAction();
        char c = 65535;
        switch (action.hashCode()) {
            case -1593870946:
                if (action.equals("com.netflix.mediaclient.intent.action.LOG_DIAL_SERVER_DISCOVERED")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                m5049(intent);
                return true;
            default:
                return false;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m5049(Intent intent) {
        m5050(intent.getStringExtra("uuid"), intent.getStringExtra("headers"), intent.getStringExtra("desc"));
    }
}

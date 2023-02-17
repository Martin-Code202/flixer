package o;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.netflix.cl.Logger;
class S {

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f5806;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f5807;

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f5808;

    S() {
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m5253(Context context) {
        C1283.m16854("nf_log_cl", "handleConnectivityChange started");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            C1283.m16865("nf_log_cl", "Connectivity manager is gone! Connectivity is lost!");
            m5252();
            return;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            C1283.m16865("nf_log_cl", "Connectivity manager exist, but no active connection! Connectivity is lost!");
            m5252();
            return;
        }
        boolean isConnectedOrConnecting = activeNetworkInfo.isConnectedOrConnecting();
        int type = activeNetworkInfo.getType();
        switch (type) {
            case 0:
            case 6:
                this.f5808 = false;
                this.f5806 = isConnectedOrConnecting;
                this.f5807 = false;
                if (isConnectedOrConnecting) {
                    Logger.INSTANCE.m127(new C1126());
                } else {
                    Logger.INSTANCE.m128(C1126.class);
                }
                Logger.INSTANCE.m128(C0465.class);
                Logger.INSTANCE.m128(C0449.class);
                return;
            case 1:
                this.f5808 = isConnectedOrConnecting;
                this.f5806 = false;
                this.f5807 = false;
                if (isConnectedOrConnecting) {
                    Logger.INSTANCE.m127(new C0449());
                } else {
                    Logger.INSTANCE.m128(C0449.class);
                }
                Logger.INSTANCE.m128(C0465.class);
                Logger.INSTANCE.m128(C1126.class);
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            default:
                C1283.m16854("nf_log_cl", "Not supported network type " + type);
                return;
            case 9:
                this.f5808 = false;
                this.f5806 = false;
                this.f5807 = isConnectedOrConnecting;
                if (isConnectedOrConnecting) {
                    Logger.INSTANCE.m127(new C0465());
                } else {
                    Logger.INSTANCE.m128(C0465.class);
                }
                Logger.INSTANCE.m128(C0449.class);
                Logger.INSTANCE.m128(C1126.class);
                return;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m5252() {
        m5251();
        Logger.INSTANCE.m128(C0465.class);
        Logger.INSTANCE.m128(C0449.class);
        Logger.INSTANCE.m128(C1126.class);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m5251() {
        this.f5808 = false;
        this.f5806 = false;
        this.f5807 = false;
    }
}

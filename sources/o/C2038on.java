package o;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.netflix.mediaclient.util.ConnectivityUtils;
/* access modifiers changed from: package-private */
/* renamed from: o.on  reason: case insensitive filesystem */
public class C2038on {

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final C2038on f9348 = new C2038on(ConnectivityUtils.NetType.wifi, "unknown", "defaultIpAddr");

    /* renamed from: ˊ  reason: contains not printable characters */
    final ConnectivityUtils.NetType f9349;

    /* renamed from: ˋ  reason: contains not printable characters */
    final String f9350;

    /* renamed from: ˎ  reason: contains not printable characters */
    final String f9351;

    public C2038on(ConnectivityUtils.NetType netType, String str, String str2) {
        this.f9349 = netType;
        this.f9350 = str != null ? str : "";
        this.f9351 = str2 != null ? str2 : "";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2038on onVar = (C2038on) obj;
        return this.f9349 == onVar.f9349 && this.f9350.equals(onVar.f9350) && this.f9351.equals(onVar.f9351);
    }

    public int hashCode() {
        return ((((this.f9349 != null ? this.f9349.hashCode() : 0) * 31) + this.f9350.hashCode()) * 31) + this.f9351.hashCode();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static C2038on m9680(Context context) {
        if (context == null) {
            return f9348;
        }
        String r2 = ConnectivityUtils.m2966(context);
        String str = "";
        ConnectivityUtils.NetType r4 = ConnectivityUtils.m2958(context);
        if (r4 != null) {
            switch (r4) {
                case wifi:
                    str = ConnectivityUtils.m2962(ConnectivityUtils.m2961(context));
                    break;
                case mobile:
                    str = ConnectivityUtils.m2963((TelephonyManager) context.getSystemService("phone"));
                    break;
                case wired:
                default:
                    str = "";
                    break;
            }
        }
        return new C2038on(r4, str, r2);
    }

    public String toString() {
        return "NetworkKey{mNetType=" + this.f9349 + ", mNetworkId='" + this.f9350 + "', mLocalIp='" + this.f9351 + "'}";
    }
}

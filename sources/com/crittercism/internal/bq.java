package com.crittercism.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import com.crittercism.internal.at;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;
public final class bq {
    av<at> a;
    ap b;
    private b c = b.UNKNOWN;
    private ConnectivityManager d;
    private ExecutorService e;
    private a f;

    @TargetApi(21)
    public bq(Context context, ExecutorService executorService, av<at> avVar, ap apVar) {
        this.e = executorService;
        this.a = avVar;
        this.b = apVar;
        if (ao.a(context, "android.permission.ACCESS_NETWORK_STATE") && Build.VERSION.SDK_INT >= 21) {
            this.d = (ConnectivityManager) context.getSystemService("connectivity");
            if (this.d != null) {
                NetworkRequest build = new NetworkRequest.Builder().addCapability(12).build();
                this.f = new a(this, (byte) 0);
                this.d.registerNetworkCallback(build, this.f);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public enum b {
        DISCONNECTED("disconnected"),
        TWO_G("2G"),
        THREE_G("3G"),
        LTE("LTE"),
        WIFI("wifi"),
        UNKNOWN("unknown");
        
        private String g;

        private b(String str) {
            this.g = str;
        }

        public static b a(NetworkInfo networkInfo) {
            if (networkInfo == null || !networkInfo.isConnected()) {
                return DISCONNECTED;
            }
            int type = networkInfo.getType();
            if (type == 0) {
                switch (networkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return TWO_G;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return THREE_G;
                    case 13:
                        return LTE;
                }
            } else if (type == 1) {
                return WIFI;
            }
            return UNKNOWN;
        }

        @Override // java.lang.Enum, java.lang.Object
        public final String toString() {
            return this.g;
        }
    }

    @TargetApi(21)
    class a extends ConnectivityManager.NetworkCallback {
        private a() {
        }

        /* synthetic */ a(bq bqVar, byte b) {
            this();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLost(Network network) {
            bq.a(bq.this);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLosing(Network network, int i) {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onAvailable(Network network) {
            bq.a(bq.this);
        }
    }

    static /* synthetic */ void a(bq bqVar) {
        b a2 = b.a(bqVar.d.getActiveNetworkInfo());
        if (bqVar.c != a2) {
            final at atVar = null;
            if (!(bqVar.c == b.UNKNOWN || a2 == b.UNKNOWN)) {
                if (bqVar.c == b.DISCONNECTED) {
                    atVar = at.a(at.c.c, a2.toString());
                } else if (a2 == b.DISCONNECTED) {
                    atVar = at.a(at.c.d, bqVar.c.toString());
                } else {
                    String bVar = bqVar.c.toString();
                    String bVar2 = a2.toString();
                    HashMap hashMap = new HashMap();
                    hashMap.put("change", Integer.valueOf(at.c.e - 1));
                    hashMap.put("oldType", bVar);
                    hashMap.put("newType", bVar2);
                    atVar = new at(at.b.e, new JSONObject(hashMap));
                }
            }
            bqVar.c = a2;
            if (atVar != null) {
                bqVar.e.submit(new Runnable() { // from class: com.crittercism.internal.bq.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (((Boolean) bq.this.b.a(ap.E)).booleanValue()) {
                            bq.this.a.a((av<at>) atVar);
                        }
                    }
                });
            }
        }
    }
}

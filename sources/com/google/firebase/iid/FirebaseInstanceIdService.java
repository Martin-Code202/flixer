package com.google.firebase.iid;

import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import java.io.IOException;
public class FirebaseInstanceIdService extends zzb {
    private static Object zzmlp = new Object();
    private static boolean zzmlq = false;
    private boolean zzmlr = false;

    /* access modifiers changed from: package-private */
    public static class zza extends BroadcastReceiver {
        private static BroadcastReceiver receiver;
        private int zzmls;

        private zza(int i) {
            this.zzmls = i;
        }

        static synchronized void zzl(Context context, int i) {
            synchronized (zza.class) {
                if (receiver == null) {
                    receiver = new zza(i);
                    context.getApplicationContext().registerReceiver(receiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (zza.class) {
                if (receiver == this) {
                    if (FirebaseInstanceIdService.zzen(context)) {
                        if (Log.isLoggable("FirebaseInstanceId", 3)) {
                            Log.d("FirebaseInstanceId", "connectivity changed. starting background sync.");
                        }
                        context.getApplicationContext().unregisterReceiver(this);
                        receiver = null;
                        zzq.zzbys().zze(context, FirebaseInstanceIdService.zzfy(this.zzmls));
                    }
                }
            }
        }
    }

    static void zza(Context context, FirebaseInstanceId firebaseInstanceId) {
        synchronized (zzmlp) {
            if (zzmlq) {
                return;
            }
        }
        zzs zzbyl = firebaseInstanceId.zzbyl();
        if (zzbyl == null || zzbyl.zzqk(zzj.zzhts) || FirebaseInstanceId.zzbyn().zzbyq() != null) {
            zzem(context);
        }
    }

    private final void zza(Intent intent, String str) {
        boolean zzen = zzen(this);
        int intExtra = intent == null ? 10 : intent.getIntExtra("next_retry_delay_in_seconds", 0);
        if (intExtra < 10 && !zzen) {
            intExtra = 30;
        } else if (intExtra < 10) {
            intExtra = 10;
        } else if (intExtra > 28800) {
            intExtra = 28800;
        }
        Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(str).length() + 47).append("background sync failed: ").append(str).append(", retry in ").append(intExtra).append("s").toString());
        synchronized (zzmlp) {
            ((AlarmManager) getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + ((long) (intExtra * 1000)), zzq.zza(this, 0, zzfy(intExtra << 1), 134217728));
            zzmlq = true;
        }
        if (!zzen) {
            if (this.zzmlr) {
                Log.d("FirebaseInstanceId", "device not connected. Connectivity change received registered");
            }
            zza.zzl(this, intExtra);
        }
    }

    private final void zza(Intent intent, boolean z, boolean z2) {
        synchronized (zzmlp) {
            zzmlq = false;
        }
        if (zzl.zzdf(this) != null) {
            FirebaseInstanceId instance = FirebaseInstanceId.getInstance();
            zzs zzbyl = instance.zzbyl();
            if (zzbyl == null || zzbyl.zzqk(zzj.zzhts)) {
                try {
                    String zzbym = instance.zzbym();
                    if (zzbym != null) {
                        if (this.zzmlr) {
                            Log.d("FirebaseInstanceId", "get master token succeeded");
                        }
                        zza(this, instance);
                        if (z2 || zzbyl == null || (zzbyl != null && !zzbym.equals(zzbyl.zzkoo))) {
                            onTokenRefresh();
                            return;
                        }
                        return;
                    }
                    zza(intent, "returned token is null");
                } catch (IOException e) {
                    zza(intent, e.getMessage());
                } catch (SecurityException e2) {
                    Log.e("FirebaseInstanceId", "Unable to get master token", e2);
                }
            } else {
                zzk zzbyn = FirebaseInstanceId.zzbyn();
                for (String zzbyq = zzbyn.zzbyq(); zzbyq != null; zzbyq = zzbyn.zzbyq()) {
                    String[] split = zzbyq.split("!");
                    if (split.length == 2) {
                        String str = split[0];
                        String str2 = split[1];
                        char c = 65535;
                        try {
                            switch (str.hashCode()) {
                                case 83:
                                    if (str.equals("S")) {
                                        c = 0;
                                        break;
                                    }
                                    break;
                                case 85:
                                    if (str.equals("U")) {
                                        c = 1;
                                        break;
                                    }
                                    break;
                            }
                            switch (c) {
                                case 0:
                                    FirebaseInstanceId.getInstance().zzqb(str2);
                                    if (!this.zzmlr) {
                                        break;
                                    } else {
                                        Log.d("FirebaseInstanceId", "subscribe operation succeeded");
                                        continue;
                                    }
                                case 1:
                                    FirebaseInstanceId.getInstance().zzqc(str2);
                                    if (!this.zzmlr) {
                                        break;
                                    } else {
                                        Log.d("FirebaseInstanceId", "unsubscribe operation succeeded");
                                        continue;
                                    }
                                default:
                                    continue;
                            }
                        } catch (IOException e3) {
                            zza(intent, e3.getMessage());
                            return;
                        }
                    }
                    zzbyn.zzqe(zzbyq);
                }
                Log.d("FirebaseInstanceId", "topic sync succeeded");
            }
        }
    }

    static void zzem(Context context) {
        if (zzl.zzdf(context) != null) {
            synchronized (zzmlp) {
                if (!zzmlq) {
                    zzq.zzbys().zze(context, zzfy(0));
                    zzmlq = true;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean zzen(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* access modifiers changed from: private */
    public static Intent zzfy(int i) {
        Intent intent = new Intent("ACTION_TOKEN_REFRESH_RETRY");
        intent.putExtra("next_retry_delay_in_seconds", i);
        return intent;
    }

    private static String zzp(Intent intent) {
        String stringExtra = intent.getStringExtra("subtype");
        return stringExtra == null ? "" : stringExtra;
    }

    private final zzj zzqd(String str) {
        if (str == null) {
            return zzj.zza(this, null);
        }
        Bundle bundle = new Bundle();
        bundle.putString("subtype", str);
        return zzj.zza(this, bundle);
    }

    @Override // com.google.firebase.iid.zzb
    public void handleIntent(Intent intent) {
        String action = intent.getAction();
        if (action == null) {
            action = "";
        }
        char c = 65535;
        switch (action.hashCode()) {
            case -1737547627:
                if (action.equals("ACTION_TOKEN_REFRESH_RETRY")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                zza(intent, false, false);
                return;
            default:
                String zzp = zzp(intent);
                zzj zzqd = zzqd(zzp);
                String stringExtra = intent.getStringExtra("CMD");
                if (this.zzmlr) {
                    String valueOf = String.valueOf(intent.getExtras());
                    Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + String.valueOf(zzp).length() + 18 + String.valueOf(stringExtra).length()).append("Service command ").append(zzp).append(" ").append(stringExtra).append(" ").append(valueOf).toString());
                }
                if (null != intent.getStringExtra("unregistered")) {
                    zzj.zzbyo().zzhu(zzp == null ? "" : zzp);
                    zzj.zzbyp().zzi(intent);
                    return;
                } else if ("gcm.googleapis.com/refresh".equals(intent.getStringExtra(NetflixActivity.EXTRA_FROM))) {
                    zzj.zzbyo().zzhu(zzp);
                    zza(intent, false, true);
                    return;
                } else if ("RST".equals(stringExtra)) {
                    zzqd.zzass();
                    zza(intent, true, true);
                    return;
                } else if ("RST_FULL".equals(stringExtra)) {
                    if (!zzj.zzbyo().isEmpty()) {
                        zzqd.zzass();
                        zzj.zzbyo().zzasw();
                        zza(intent, true, true);
                        return;
                    }
                    return;
                } else if ("SYNC".equals(stringExtra)) {
                    zzj.zzbyo().zzhu(zzp);
                    zza(intent, false, true);
                    return;
                } else if ("PING".equals(stringExtra)) {
                    Bundle extras = intent.getExtras();
                    String zzdf = zzl.zzdf(this);
                    if (zzdf == null) {
                        Log.w("FirebaseInstanceId", "Unable to respond to ping due to missing target package");
                        return;
                    }
                    Intent intent2 = new Intent("com.google.android.gcm.intent.SEND");
                    intent2.setPackage(zzdf);
                    intent2.putExtras(extras);
                    zzl.zzd(this, intent2);
                    intent2.putExtra("google.to", "google.com/iid");
                    intent2.putExtra("google.message_id", zzl.zzasv());
                    sendOrderedBroadcast(intent2, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
                    return;
                } else {
                    return;
                }
        }
    }

    public void onTokenRefresh() {
    }

    /* access modifiers changed from: protected */
    @Override // com.google.firebase.iid.zzb
    public final Intent zzn(Intent intent) {
        return zzq.zzbys().zzmmd.poll();
    }

    @Override // com.google.firebase.iid.zzb
    public final boolean zzo(Intent intent) {
        this.zzmlr = Log.isLoggable("FirebaseInstanceId", 3);
        if (intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE) == null && intent.getStringExtra("registration_id") == null) {
            return false;
        }
        String zzp = zzp(intent);
        if (this.zzmlr) {
            String valueOf = String.valueOf(zzp);
            Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Register result in service ".concat(valueOf) : new String("Register result in service "));
        }
        zzqd(zzp);
        zzj.zzbyp().zzi(intent);
        return true;
    }
}

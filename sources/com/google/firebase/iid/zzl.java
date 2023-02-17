package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.zzp;
import com.google.android.gms.iid.MessengerCompat;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.service.logging.client.model.Version;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.Iterator;
import java.util.Random;
public final class zzl {
    private static PendingIntent zzhrl;
    private static String zzhtv = null;
    private static boolean zzhtw = false;
    private static int zzhtx = 0;
    private static int zzhty = 0;
    private static int zzhtz = 0;
    private static BroadcastReceiver zzhua = null;
    private Context zzahy;
    private Messenger zzhrp;
    private Messenger zzhuc;
    private MessengerCompat zzhud;
    private long zzhue;
    private long zzhuf;
    private int zzhug;
    private int zzhuh;
    private long zzhui;
    private final SimpleArrayMap<String, zzp> zzmlw = new SimpleArrayMap<>();

    public zzl(Context context) {
        this.zzahy = context;
    }

    private static String zza(KeyPair keyPair, String... strArr) {
        try {
            byte[] bytes = TextUtils.join("\n", strArr).getBytes("UTF-8");
            try {
                PrivateKey privateKey = keyPair.getPrivate();
                Signature instance = Signature.getInstance(privateKey instanceof RSAPrivateKey ? "SHA256withRSA" : "SHA256withECDSA");
                instance.initSign(privateKey);
                instance.update(bytes);
                return FirebaseInstanceId.zzm(instance.sign());
            } catch (GeneralSecurityException e) {
                Log.e("InstanceID/Rpc", "Unable to sign registration request", e);
                return null;
            }
        } catch (UnsupportedEncodingException e2) {
            Log.e("InstanceID/Rpc", "Unable to encode string", e2);
            return null;
        }
    }

    private static boolean zza(PackageManager packageManager) {
        for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(new Intent("com.google.iid.TOKEN_REQUEST"), 0)) {
            if (zza(packageManager, resolveInfo.activityInfo.packageName, "com.google.iid.TOKEN_REQUEST")) {
                zzhtw = true;
                return true;
            }
        }
        return false;
    }

    private static boolean zza(PackageManager packageManager, String str, String str2) {
        if (0 == packageManager.checkPermission("com.google.android.c2dm.permission.SEND", str)) {
            return zzb(packageManager, str);
        }
        Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(str2).length() + String.valueOf(str).length() + 56).append("Possible malicious package ").append(str).append(" declares ").append(str2).append(" without permission").toString());
        return false;
    }

    private final void zzasu() {
        if (this.zzhrp == null) {
            zzdf(this.zzahy);
            this.zzhrp = new Messenger(new zzm(this, Looper.getMainLooper()));
        }
    }

    public static synchronized String zzasv() {
        String num;
        synchronized (zzl.class) {
            int i = zzhtz;
            zzhtz = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    private final Intent zzb(Bundle bundle, KeyPair keyPair) {
        String zzasv = zzasv();
        zzo zzo = new zzo(null);
        synchronized (this.zzmlw) {
            this.zzmlw.put(zzasv, zzo);
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zzhui == 0 || elapsedRealtime > this.zzhui) {
            zzasu();
            if (zzhtv == null) {
                throw new IOException("MISSING_INSTANCEID_SERVICE");
            }
            this.zzhue = SystemClock.elapsedRealtime();
            Intent intent = new Intent(zzhtw ? "com.google.iid.TOKEN_REQUEST" : "com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(zzhtv);
            bundle.putString("gmsv", Integer.toString(FirebaseInstanceId.zzao(this.zzahy, zzdf(this.zzahy))));
            bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
            bundle.putString("app_ver", Integer.toString(FirebaseInstanceId.zzej(this.zzahy)));
            bundle.putString("app_ver_name", FirebaseInstanceId.zzdd(this.zzahy));
            bundle.putString("cliv", "fiid-11400000");
            bundle.putString("appid", FirebaseInstanceId.zza(keyPair));
            String zzm = FirebaseInstanceId.zzm(keyPair.getPublic().getEncoded());
            bundle.putString("pub2", zzm);
            bundle.putString("sig", zza(keyPair, this.zzahy.getPackageName(), zzm));
            intent.putExtras(bundle);
            zzd(this.zzahy, intent);
            this.zzhue = SystemClock.elapsedRealtime();
            intent.putExtra("kid", new StringBuilder(String.valueOf(zzasv).length() + 5).append("|ID|").append(zzasv).append("|").toString());
            intent.putExtra("X-kid", new StringBuilder(String.valueOf(zzasv).length() + 5).append("|ID|").append(zzasv).append("|").toString());
            boolean equals = "com.google.android.gsf".equals(zzhtv);
            if (Log.isLoggable("InstanceID/Rpc", 3)) {
                String valueOf = String.valueOf(intent.getExtras());
                Log.d("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 8).append("Sending ").append(valueOf).toString());
            }
            if (equals) {
                synchronized (this) {
                    if (zzhua == null) {
                        zzhua = new zzn(this);
                        if (Log.isLoggable("InstanceID/Rpc", 3)) {
                            Log.d("InstanceID/Rpc", "Registered GSF callback receiver");
                        }
                        IntentFilter intentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
                        intentFilter.addCategory(this.zzahy.getPackageName());
                        this.zzahy.registerReceiver(zzhua, intentFilter, "com.google.android.c2dm.permission.SEND", null);
                    }
                }
                this.zzahy.startService(intent);
            } else {
                intent.putExtra("google.messenger", this.zzhrp);
                if (!(this.zzhuc == null && this.zzhud == null)) {
                    Message obtain = Message.obtain();
                    obtain.obj = intent;
                    try {
                        if (this.zzhuc != null) {
                            this.zzhuc.send(obtain);
                        } else {
                            this.zzhud.send(obtain);
                        }
                    } catch (RemoteException unused) {
                        if (Log.isLoggable("InstanceID/Rpc", 3)) {
                            Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                        }
                    }
                }
                if (zzhtw) {
                    this.zzahy.sendBroadcast(intent);
                } else {
                    this.zzahy.startService(intent);
                }
            }
            try {
                Intent zzbyr = zzo.zzbyr();
                synchronized (this.zzmlw) {
                    this.zzmlw.remove(zzasv);
                }
                return zzbyr;
            } catch (Throwable th) {
                synchronized (this.zzmlw) {
                    this.zzmlw.remove(zzasv);
                    throw th;
                }
            }
        } else {
            Log.w("InstanceID/Rpc", new StringBuilder(78).append("Backoff mode, next request attempt: ").append(this.zzhui - elapsedRealtime).append(" interval: ").append(this.zzhuh).toString());
            throw new IOException("RETRY_LATER");
        }
    }

    private final void zzb(String str, Intent intent) {
        synchronized (this.zzmlw) {
            zzp remove = this.zzmlw.remove(str);
            if (remove == null) {
                String valueOf = String.valueOf(str);
                Log.w("InstanceID/Rpc", valueOf.length() != 0 ? "Missing callback for ".concat(valueOf) : new String("Missing callback for "));
                return;
            }
            remove.zzq(intent);
        }
    }

    private static boolean zzb(PackageManager packageManager, String str) {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
            zzhtv = applicationInfo.packageName;
            zzhty = applicationInfo.uid;
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private final void zzbj(String str, String str2) {
        synchronized (this.zzmlw) {
            if (str == null) {
                for (int i = 0; i < this.zzmlw.size(); i++) {
                    this.zzmlw.valueAt(i).onError(str2);
                }
                this.zzmlw.clear();
            } else {
                zzp remove = this.zzmlw.remove(str);
                if (remove == null) {
                    String valueOf = String.valueOf(str);
                    Log.w("InstanceID/Rpc", valueOf.length() != 0 ? "Missing callback for ".concat(valueOf) : new String("Missing callback for "));
                    return;
                }
                remove.onError(str2);
            }
        }
    }

    public static synchronized void zzd(Context context, Intent intent) {
        synchronized (zzl.class) {
            if (zzhrl == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                zzhrl = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra(Version.APP, zzhrl);
        }
    }

    public static String zzdf(Context context) {
        boolean z;
        if (zzhtv != null) {
            return zzhtv;
        }
        zzhtx = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        if (!zzp.isAtLeastO()) {
            Iterator<ResolveInfo> it = packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0).iterator();
            while (true) {
                if (it.hasNext()) {
                    if (zza(packageManager, it.next().serviceInfo.packageName, "com.google.android.c2dm.intent.REGISTER")) {
                        zzhtw = false;
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                return zzhtv;
            }
        }
        if (zza(packageManager)) {
            return zzhtv;
        }
        Log.w("InstanceID/Rpc", "Failed to resolve IID implementation package, falling back");
        if (zzb(packageManager, "com.google.android.gms")) {
            zzhtw = zzp.isAtLeastO();
            return zzhtv;
        } else if (zzp.zzalk() || !zzb(packageManager, "com.google.android.gsf")) {
            Log.w("InstanceID/Rpc", "Google Play services is missing, unable to get tokens");
            return null;
        } else {
            zzhtw = false;
            return zzhtv;
        }
    }

    /* access modifiers changed from: package-private */
    public final Intent zza(Bundle bundle, KeyPair keyPair) {
        Intent zzb = zzb(bundle, keyPair);
        if (zzb == null || !zzb.hasExtra("google.messenger")) {
            return zzb;
        }
        Intent zzb2 = zzb(bundle, keyPair);
        if (zzb2 == null || !zzb2.hasExtra("google.messenger")) {
            return zzb2;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Message message) {
        if (message != null) {
            if (message.obj instanceof Intent) {
                Intent intent = (Intent) message.obj;
                intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof MessengerCompat) {
                        this.zzhud = (MessengerCompat) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.zzhuc = (Messenger) parcelableExtra;
                    }
                }
                zzi((Intent) message.obj);
                return;
            }
            Log.w("InstanceID/Rpc", "Dropping invalid message");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzi(Intent intent) {
        if (intent == null) {
            if (Log.isLoggable("InstanceID/Rpc", 3)) {
                Log.d("InstanceID/Rpc", "Unexpected response: null");
            }
        } else if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("registration_id");
            if (stringExtra == null) {
                stringExtra = intent.getStringExtra("unregistered");
            }
            if (stringExtra == null) {
                String stringExtra2 = intent.getStringExtra(ExceptionClEvent.CATEGORY_VALUE);
                if (stringExtra2 == null) {
                    String valueOf = String.valueOf(intent.getExtras());
                    Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 49).append("Unexpected response, no error or registration id ").append(valueOf).toString());
                    return;
                }
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    String valueOf2 = String.valueOf(stringExtra2);
                    Log.d("InstanceID/Rpc", valueOf2.length() != 0 ? "Received InstanceID error ".concat(valueOf2) : new String("Received InstanceID error "));
                }
                String str = null;
                if (stringExtra2.startsWith("|")) {
                    String[] split = stringExtra2.split("\\|");
                    if (!SignupConstants.Key.ID.equals(split[1])) {
                        String valueOf3 = String.valueOf(stringExtra2);
                        Log.w("InstanceID/Rpc", valueOf3.length() != 0 ? "Unexpected structured response ".concat(valueOf3) : new String("Unexpected structured response "));
                    }
                    if (split.length > 2) {
                        str = split[2];
                        stringExtra2 = split[3];
                        if (stringExtra2.startsWith(":")) {
                            stringExtra2 = stringExtra2.substring(1);
                        }
                    } else {
                        stringExtra2 = "UNKNOWN";
                    }
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, stringExtra2);
                }
                zzbj(str, stringExtra2);
                long longExtra = intent.getLongExtra("Retry-After", 0);
                if (longExtra > 0) {
                    this.zzhuf = SystemClock.elapsedRealtime();
                    this.zzhuh = ((int) longExtra) * 1000;
                    this.zzhui = SystemClock.elapsedRealtime() + ((long) this.zzhuh);
                    Log.w("InstanceID/Rpc", new StringBuilder(52).append("Explicit request from server to backoff: ").append(this.zzhuh).toString());
                } else if (("SERVICE_NOT_AVAILABLE".equals(stringExtra2) || "AUTHENTICATION_FAILED".equals(stringExtra2)) && "com.google.android.gsf".equals(zzhtv)) {
                    this.zzhug++;
                    if (this.zzhug >= 3) {
                        if (this.zzhug == 3) {
                            this.zzhuh = new Random().nextInt(1000) + 1000;
                        }
                        this.zzhuh <<= 1;
                        this.zzhui = SystemClock.elapsedRealtime() + ((long) this.zzhuh);
                        Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(stringExtra2).length() + 31).append("Backoff due to ").append(stringExtra2).append(" for ").append(this.zzhuh).toString());
                    }
                }
            } else {
                this.zzhue = SystemClock.elapsedRealtime();
                this.zzhui = 0;
                this.zzhug = 0;
                this.zzhuh = 0;
                String str2 = null;
                if (stringExtra.startsWith("|")) {
                    String[] split2 = stringExtra.split("\\|");
                    if (!SignupConstants.Key.ID.equals(split2[1])) {
                        String valueOf4 = String.valueOf(stringExtra);
                        Log.w("InstanceID/Rpc", valueOf4.length() != 0 ? "Unexpected structured response ".concat(valueOf4) : new String("Unexpected structured response "));
                    }
                    str2 = split2[2];
                    if (split2.length > 4) {
                        if ("SYNC".equals(split2[3])) {
                            FirebaseInstanceId.zzek(this.zzahy);
                        } else if ("RST".equals(split2[3])) {
                            Context context = this.zzahy;
                            zzj.zza(this.zzahy, null);
                            FirebaseInstanceId.zza(context, zzj.zzbyo());
                            intent.removeExtra("registration_id");
                            zzb(str2, intent);
                            return;
                        }
                    }
                    String str3 = split2[split2.length - 1];
                    if (str3.startsWith(":")) {
                        str3 = str3.substring(1);
                    }
                    intent.putExtra("registration_id", str3);
                }
                if (str2 != null) {
                    zzb(str2, intent);
                } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Ignoring response without a request ID");
                }
            }
        } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
            String valueOf5 = String.valueOf(intent.getAction());
            Log.d("InstanceID/Rpc", valueOf5.length() != 0 ? "Unexpected response ".concat(valueOf5) : new String("Unexpected response "));
        }
    }
}

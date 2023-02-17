package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.api.internal.zzk;
import com.google.android.gms.common.internal.zzbf;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.util.zzq;
import com.google.android.gms.internal.zzeam;
import com.google.android.gms.internal.zzean;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
public class FirebaseApp {
    private static final Object zzaqc = new Object();
    static final Map<String, FirebaseApp> zzhtm = new ArrayMap();
    private static final List<String> zzlfz = Arrays.asList("com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId");
    private static final List<String> zzlga = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    private static final List<String> zzlgb = Arrays.asList("com.google.android.gms.measurement.AppMeasurement");
    private static final List<String> zzlgc = Arrays.asList(new String[0]);
    private static final Set<String> zzlgd = Collections.emptySet();
    private final Context mApplicationContext;
    private final String mName;
    private final FirebaseOptions zzlge;
    private final AtomicBoolean zzlgf = new AtomicBoolean(false);
    private final AtomicBoolean zzlgg = new AtomicBoolean();
    private final List<Object> zzlgh = new CopyOnWriteArrayList();
    private final List<zza> zzlgi = new CopyOnWriteArrayList();
    private final List<Object> zzlgj = new CopyOnWriteArrayList();
    private zzc zzlgl;

    public interface zza {
        void zzbe(boolean z);
    }

    public interface zzc {
    }

    /* access modifiers changed from: package-private */
    @TargetApi(24)
    public static class zzd extends BroadcastReceiver {
        private static AtomicReference<zzd> zzlgm = new AtomicReference<>();
        private final Context mApplicationContext;

        private zzd(Context context) {
            this.mApplicationContext = context;
        }

        /* access modifiers changed from: private */
        public static void zzef(Context context) {
            if (zzlgm.get() == null) {
                zzd zzd = new zzd(context);
                if (zzlgm.compareAndSet(null, zzd)) {
                    context.registerReceiver(zzd, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            synchronized (FirebaseApp.zzaqc) {
                for (FirebaseApp firebaseApp : FirebaseApp.zzhtm.values()) {
                    firebaseApp.zzbnq();
                }
            }
            this.mApplicationContext.unregisterReceiver(this);
        }
    }

    private FirebaseApp(Context context, String str, FirebaseOptions firebaseOptions) {
        this.mApplicationContext = (Context) zzbp.zzu(context);
        this.mName = zzbp.zzgg(str);
        this.zzlge = (FirebaseOptions) zzbp.zzu(firebaseOptions);
        this.zzlgl = new zzeam();
    }

    public static FirebaseApp getInstance() {
        FirebaseApp firebaseApp;
        synchronized (zzaqc) {
            firebaseApp = zzhtm.get("[DEFAULT]");
            if (firebaseApp == null) {
                String zzall = zzq.zzall();
                throw new IllegalStateException(new StringBuilder(String.valueOf(zzall).length() + 116).append("Default FirebaseApp is not initialized in this process ").append(zzall).append(". Make sure to call FirebaseApp.initializeApp(Context) first.").toString());
            }
        }
        return firebaseApp;
    }

    public static FirebaseApp initializeApp(Context context) {
        synchronized (zzaqc) {
            if (zzhtm.containsKey("[DEFAULT]")) {
                return getInstance();
            }
            FirebaseOptions fromResource = FirebaseOptions.fromResource(context);
            if (fromResource == null) {
                return null;
            }
            return initializeApp(context, fromResource);
        }
    }

    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions) {
        return initializeApp(context, firebaseOptions, "[DEFAULT]");
    }

    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions, String str) {
        FirebaseApp firebaseApp;
        zzean.zzep(context);
        if (context.getApplicationContext() instanceof Application) {
            zzk.zza((Application) context.getApplicationContext());
            zzk.zzafz().zza(new zza());
        }
        String trim = str.trim();
        Context applicationContext = context.getApplicationContext() == null ? context : context.getApplicationContext();
        synchronized (zzaqc) {
            zzbp.zza(!zzhtm.containsKey(trim), new StringBuilder(String.valueOf(trim).length() + 33).append("FirebaseApp name ").append(trim).append(" already exists!").toString());
            zzbp.zzb(applicationContext, "Application context cannot be null.");
            firebaseApp = new FirebaseApp(applicationContext, trim, firebaseOptions);
            zzhtm.put(trim, firebaseApp);
        }
        zzean.zze(firebaseApp);
        firebaseApp.zza(FirebaseApp.class, firebaseApp, zzlfz);
        if (firebaseApp.zzbnn()) {
            firebaseApp.zza(FirebaseApp.class, firebaseApp, zzlga);
            firebaseApp.zza(Context.class, firebaseApp.getApplicationContext(), zzlgb);
        }
        return firebaseApp;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.lang.Class<?> */
    /* JADX WARN: Multi-variable type inference failed */
    private final <T> void zza(Class<T> cls, T t, Iterable<String> iterable) {
        boolean isDeviceProtectedStorage = ContextCompat.isDeviceProtectedStorage(this.mApplicationContext);
        if (isDeviceProtectedStorage) {
            zzd.zzef(this.mApplicationContext);
        }
        for (String str : iterable) {
            if (isDeviceProtectedStorage) {
                try {
                    if (zzlgc.contains(str)) {
                    }
                } catch (ClassNotFoundException unused) {
                    if (zzlgd.contains(str)) {
                        throw new IllegalStateException(String.valueOf(str).concat(" is missing, but is required. Check if it has been removed by Proguard."));
                    }
                    Log.d("FirebaseApp", String.valueOf(str).concat(" is not linked. Skipping initialization."));
                } catch (NoSuchMethodException unused2) {
                    throw new IllegalStateException(String.valueOf(str).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
                } catch (InvocationTargetException e) {
                    Log.wtf("FirebaseApp", "Firebase API initialization failure.", e);
                } catch (IllegalAccessException e2) {
                    String valueOf = String.valueOf(str);
                    Log.wtf("FirebaseApp", valueOf.length() != 0 ? "Failed to initialize ".concat(valueOf) : new String("Failed to initialize "), e2);
                }
            }
            Method method = Class.forName(str).getMethod("getInstance", cls);
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                method.invoke(null, t);
            }
        }
    }

    public static void zzbe(boolean z) {
        synchronized (zzaqc) {
            ArrayList arrayList = new ArrayList(zzhtm.values());
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                FirebaseApp firebaseApp = (FirebaseApp) obj;
                if (firebaseApp.zzlgf.get()) {
                    firebaseApp.zzbz(z);
                }
            }
        }
    }

    private final void zzbnm() {
        zzbp.zza(!this.zzlgg.get(), "FirebaseApp was deleted");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zzbnq() {
        zza(FirebaseApp.class, this, zzlfz);
        if (zzbnn()) {
            zza(FirebaseApp.class, this, zzlga);
            zza(Context.class, this.mApplicationContext, zzlgb);
        }
    }

    private final void zzbz(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (zza zza2 : this.zzlgi) {
            zza2.zzbe(z);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseApp)) {
            return false;
        }
        return this.mName.equals(((FirebaseApp) obj).getName());
    }

    public Context getApplicationContext() {
        zzbnm();
        return this.mApplicationContext;
    }

    public String getName() {
        zzbnm();
        return this.mName;
    }

    public FirebaseOptions getOptions() {
        zzbnm();
        return this.zzlge;
    }

    public int hashCode() {
        return this.mName.hashCode();
    }

    public String toString() {
        return zzbf.zzt(this).zzg("name", this.mName).zzg(SignupConstants.Key.PLAN_OPTIONS, this.zzlge).toString();
    }

    public final boolean zzbnn() {
        return "[DEFAULT]".equals(getName());
    }
}

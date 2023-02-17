package com.google.android.gms.cast.framework;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzavl;
import com.google.android.gms.internal.zzavm;
import com.google.android.gms.internal.zzawd;
import com.google.android.gms.internal.zzayy;
import com.google.android.gms.internal.zzazx;
import com.google.android.gms.internal.zzbed;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
public final class CastContext {
    private static final zzazx zzejc = new zzazx("CastContext");
    private static CastContext zzeof;
    private final Context zzeog;
    private final zzj zzeoh;
    private final SessionManager zzeoi;
    private final zze zzeoj;
    private final PrecacheManager zzeok;
    private final MediaNotificationManager zzeol;
    private final CastOptions zzeom;
    private zzawd zzeon = new zzawd(MediaRouter.getInstance(this.zzeog));

    private CastContext(Context context, CastOptions castOptions, List<SessionProvider> list) {
        this.zzeog = context.getApplicationContext();
        this.zzeom = castOptions;
        HashMap hashMap = new HashMap();
        zzavm zzavm = new zzavm(this.zzeog, castOptions, this.zzeon);
        hashMap.put(zzavm.getCategory(), zzavm.zzacl());
        if (list != null) {
            for (SessionProvider sessionProvider : list) {
                zzbp.zzb(sessionProvider, "Additional SessionProvider must not be null.");
                String zzh = zzbp.zzh(sessionProvider.getCategory(), "Category for SessionProvider must not be null or empty string.");
                zzbp.zzb(!hashMap.containsKey(zzh), String.format("SessionProvider for category %s already added", zzh));
                hashMap.put(zzh, sessionProvider.zzacl());
            }
        }
        this.zzeoh = zzavl.zza(this.zzeog, castOptions, this.zzeon, hashMap);
        zzp zzp = null;
        try {
            zzp = this.zzeoh.zzabz();
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "getDiscoveryManagerImpl", zzj.class.getSimpleName());
        }
        this.zzeoj = zzp == null ? null : new zze(zzp);
        zzv zzv = null;
        try {
            zzv = this.zzeoh.zzaby();
        } catch (RemoteException e2) {
            zzejc.zzb(e2, "Unable to call %s on %s.", "getSessionManagerImpl", zzj.class.getSimpleName());
        }
        this.zzeoi = zzv == null ? null : new SessionManager(zzv, this.zzeog);
        this.zzeol = new MediaNotificationManager(this.zzeoi);
        this.zzeok = this.zzeoi == null ? null : new PrecacheManager(this.zzeom, this.zzeoi, new zzayy(this.zzeog));
    }

    public static CastContext getSharedInstance(Context context) {
        zzbp.zzfy("Must be called from the main thread.");
        if (zzeof == null) {
            OptionsProvider zzbm = zzbm(context.getApplicationContext());
            zzeof = new CastContext(context, zzbm.getCastOptions(context.getApplicationContext()), zzbm.getAdditionalSessionProviders(context.getApplicationContext()));
        }
        return zzeof;
    }

    private static OptionsProvider zzbm(Context context) {
        try {
            Bundle bundle = zzbed.zzcr(context).getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                zzejc.zzc("Bundle is null", new Object[0]);
            }
            String string = bundle.getString("com.google.android.gms.cast.framework.OPTIONS_PROVIDER_CLASS_NAME");
            if (string != null) {
                return (OptionsProvider) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            }
            throw new IllegalStateException("The fully qualified name of the implementation of OptionsProvider must be provided as a metadata in the AndroidManifest.xml with key com.google.android.gms.cast.framework.OPTIONS_PROVIDER_CLASS_NAME.");
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | NullPointerException | InvocationTargetException e) {
            throw new IllegalStateException("Failed to initialize CastContext.", e);
        }
    }

    public final void addCastStateListener(CastStateListener castStateListener) {
        zzbp.zzfy("Must be called from the main thread.");
        zzbp.zzu(castStateListener);
        this.zzeoi.addCastStateListener(castStateListener);
    }

    public final CastOptions getCastOptions() {
        zzbp.zzfy("Must be called from the main thread.");
        return this.zzeom;
    }

    public final MediaRouteSelector getMergedSelector() {
        zzbp.zzfy("Must be called from the main thread.");
        try {
            return MediaRouteSelector.fromBundle(this.zzeoh.zzabx());
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "getMergedSelectorAsBundle", zzj.class.getSimpleName());
            return null;
        }
    }

    public final SessionManager getSessionManager() {
        zzbp.zzfy("Must be called from the main thread.");
        return this.zzeoi;
    }

    public final zze zzabt() {
        zzbp.zzfy("Must be called from the main thread.");
        return this.zzeoj;
    }

    public final IObjectWrapper zzabu() {
        try {
            return this.zzeoh.zzaca();
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "getWrappedThis", zzj.class.getSimpleName());
            return null;
        }
    }
}

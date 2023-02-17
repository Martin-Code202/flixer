package com.google.android.gms.internal;

import android.app.Service;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.zzd;
import com.google.android.gms.cast.framework.zzab;
import com.google.android.gms.cast.framework.zzh;
import com.google.android.gms.cast.framework.zzj;
import com.google.android.gms.cast.framework.zzl;
import com.google.android.gms.cast.framework.zzr;
import com.google.android.gms.cast.framework.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.dynamite.DynamiteModule;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
import java.util.Map;
public final class zzavl {
    private static final zzazx zzejc = new zzazx("CastDynamiteModule");

    public static zzd zza(Service service, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, CastMediaOptions castMediaOptions) {
        try {
            return zzbp(service.getApplicationContext()).zza(zzn.zzw(service), iObjectWrapper, iObjectWrapper2, castMediaOptions);
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "newMediaNotificationServiceImpl", zzavo.class.getSimpleName());
            return null;
        }
    }

    public static zzj zza(Context context, CastOptions castOptions, zzavq zzavq, Map<String, IBinder> map) {
        try {
            return zzbp(context).zza(zzn.zzw(context.getApplicationContext()), castOptions, zzavq, map);
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "newCastContextImpl", zzavo.class.getSimpleName());
            return null;
        }
    }

    public static zzl zza(Context context, CastOptions castOptions, IObjectWrapper iObjectWrapper, zzh zzh) {
        try {
            return zzbp(context).zza(castOptions, iObjectWrapper, zzh);
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "newCastSessionImpl", zzavo.class.getSimpleName());
            return null;
        }
    }

    public static zzr zza(Service service, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        try {
            return zzbp(service.getApplicationContext()).zza(zzn.zzw(service), iObjectWrapper, iObjectWrapper2);
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "newReconnectionServiceImpl", zzavo.class.getSimpleName());
            return null;
        }
    }

    public static zzt zza(Context context, String str, String str2, zzab zzab) {
        try {
            return zzbp(context).zza(str, str2, zzab);
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "newSessionImpl", zzavo.class.getSimpleName());
            return null;
        }
    }

    public static zzawl zza(Context context, AsyncTask<Uri, Long, Bitmap> asyncTask, zzawn zzawn, int i, int i2, boolean z, long j, int i3, int i4, int i5) {
        try {
            return zzbp(context.getApplicationContext()).zza(zzn.zzw(asyncTask), zzawn, i, i2, z, 2097152, 5, 333, SubtitleDownloadRetryPolicy.DEFAULT_INITIAL_INTERVAL_MS);
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "newFetchBitmapTaskImpl", zzavo.class.getSimpleName());
            return null;
        }
    }

    private static zzavo zzbp(Context context) {
        try {
            IBinder zzgv = DynamiteModule.zza(context, DynamiteModule.zzgpn, "com.google.android.gms.cast.framework.dynamite").zzgv("com.google.android.gms.cast.framework.internal.CastDynamiteModuleImpl");
            if (zzgv == null) {
                return null;
            }
            IInterface queryLocalInterface = zzgv.queryLocalInterface("com.google.android.gms.cast.framework.internal.ICastDynamiteModule");
            return queryLocalInterface instanceof zzavo ? (zzavo) queryLocalInterface : new zzavp(zzgv);
        } catch (DynamiteModule.zzc e) {
            throw new RuntimeException(e);
        }
    }
}

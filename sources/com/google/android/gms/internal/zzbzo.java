package com.google.android.gms.internal;

import android.content.ContentProviderClient;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.zzcl;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import java.util.HashMap;
import java.util.Map;
public final class zzbzo {
    private final Context mContext;
    private final Map<zzcl<LocationListener>, zzbzs> zzgzl = new HashMap();
    private final zzcae<zzbzk> zzhza;
    private ContentProviderClient zzhzl = null;
    private boolean zzhzm = false;
    private final Map<zzcl<LocationCallback>, zzbzp> zzhzn = new HashMap();

    public zzbzo(Context context, zzcae<zzbzk> zzcae) {
        this.mContext = context;
        this.zzhza = zzcae;
    }

    public final void removeAllListeners() {
        try {
            synchronized (this.zzgzl) {
                for (zzbzs zzbzs : this.zzgzl.values()) {
                    if (zzbzs != null) {
                        this.zzhza.zzajk().zza(zzcaa.zza(zzbzs, (zzbzf) null));
                    }
                }
                this.zzgzl.clear();
            }
            synchronized (this.zzhzn) {
                for (zzbzp zzbzp : this.zzhzn.values()) {
                    if (zzbzp != null) {
                        this.zzhza.zzajk().zza(zzcaa.zza(zzbzp, (zzbzf) null));
                    }
                }
                this.zzhzn.clear();
            }
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public final void zzasy() {
        if (this.zzhzm) {
            try {
                zzbk(false);
            } catch (RemoteException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public final void zzbk(boolean z) {
        this.zzhza.zzajj();
        this.zzhza.zzajk().zzbk(z);
        this.zzhzm = z;
    }
}

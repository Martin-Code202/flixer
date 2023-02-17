package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.analytics.zzj;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.stats.zza;
public final class zzana implements ServiceConnection {
    final /* synthetic */ zzamy zzdpd;
    private volatile zzaoj zzdpe;
    private volatile boolean zzdpf;

    protected zzana(zzamy zzamy) {
        this.zzdpd = zzamy;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzaoj zzaoj;
        zzbp.zzfy("AnalyticsServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                try {
                    this.zzdpd.zzdq("Service connected with null binder");
                } finally {
                    notifyAll();
                }
            } else {
                zzaoj zzaoj2 = null;
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(interfaceDescriptor)) {
                        if (iBinder == null) {
                            zzaoj = null;
                        } else {
                            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                            zzaoj = queryLocalInterface instanceof zzaoj ? (zzaoj) queryLocalInterface : new zzaok(iBinder);
                        }
                        zzaoj2 = zzaoj;
                        this.zzdpd.zzdm("Bound to IAnalyticsService interface");
                    } else {
                        this.zzdpd.zze("Got binder with a wrong descriptor", interfaceDescriptor);
                    }
                } catch (RemoteException unused) {
                    this.zzdpd.zzdq("Service connect failed to get IAnalyticsService");
                }
                if (zzaoj2 == null) {
                    try {
                        zza.zzakz();
                        this.zzdpd.getContext().unbindService(this.zzdpd.zzdoz);
                    } catch (IllegalArgumentException unused2) {
                    }
                } else if (!this.zzdpf) {
                    this.zzdpd.zzdp("onServiceConnected received after the timeout limit");
                    this.zzdpd.zzwa().zzc(new zzanb(this, zzaoj2));
                } else {
                    this.zzdpe = zzaoj2;
                }
                notifyAll();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzbp.zzfy("AnalyticsServiceConnection.onServiceDisconnected");
        this.zzdpd.zzwa().zzc(new zzanc(this, componentName));
    }

    public final zzaoj zzwy() {
        zzj.zzuj();
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
        Context context = this.zzdpd.getContext();
        intent.putExtra("app_package_name", context.getPackageName());
        zza zzakz = zza.zzakz();
        synchronized (this) {
            this.zzdpe = null;
            this.zzdpf = true;
            boolean zza = zzakz.zza(context, intent, this.zzdpd.zzdoz, 129);
            this.zzdpd.zza("Bind to service requested", Boolean.valueOf(zza));
            if (!zza) {
                this.zzdpf = false;
                return null;
            }
            try {
                wait(zzaod.zzdsj.get().longValue());
            } catch (InterruptedException unused) {
                this.zzdpd.zzdp("Wait for service connect was interrupted");
            }
            this.zzdpf = false;
            zzaoj zzaoj = this.zzdpe;
            this.zzdpe = null;
            if (zzaoj == null) {
                this.zzdpd.zzdq("Successfully bound to service but never got onServiceConnected callback");
            }
            return zzaoj;
        }
    }
}

package com.google.android.gms.cast.framework;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzavl;
import com.google.android.gms.internal.zzazx;
public abstract class Session {
    private static final zzazx zzejc = new zzazx("Session");
    private final zzt zzepr;
    private final zza zzeps = new zza();

    class zza extends zzac {
        private zza() {
        }

        @Override // com.google.android.gms.cast.framework.zzab
        public final void end(boolean z) {
            Session.this.end(z);
        }

        @Override // com.google.android.gms.cast.framework.zzab
        public final long getSessionRemainingTimeMs() {
            return Session.this.getSessionRemainingTimeMs();
        }

        @Override // com.google.android.gms.cast.framework.zzab
        public final void resume(Bundle bundle) {
            Session.this.resume(bundle);
        }

        @Override // com.google.android.gms.cast.framework.zzab
        public final void start(Bundle bundle) {
            Session.this.start(bundle);
        }

        @Override // com.google.android.gms.cast.framework.zzab
        public final IObjectWrapper zzacd() {
            return zzn.zzw(Session.this);
        }
    }

    protected Session(Context context, String str, String str2) {
        this.zzepr = zzavl.zza(context, str, str2, this.zzeps);
    }

    /* access modifiers changed from: protected */
    public abstract void end(boolean z);

    public long getSessionRemainingTimeMs() {
        zzbp.zzfy("Must be called from the main thread.");
        return 0;
    }

    public boolean isConnected() {
        zzbp.zzfy("Must be called from the main thread.");
        try {
            return this.zzepr.isConnected();
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "isConnected", zzt.class.getSimpleName());
            return false;
        }
    }

    public boolean isResuming() {
        zzbp.zzfy("Must be called from the main thread.");
        try {
            return this.zzepr.isResuming();
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "isResuming", zzt.class.getSimpleName());
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void notifyFailedToResumeSession(int i) {
        try {
            this.zzepr.notifyFailedToResumeSession(i);
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "notifyFailedToResumeSession", zzt.class.getSimpleName());
        }
    }

    /* access modifiers changed from: protected */
    public final void notifyFailedToStartSession(int i) {
        try {
            this.zzepr.notifyFailedToStartSession(i);
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "notifyFailedToStartSession", zzt.class.getSimpleName());
        }
    }

    /* access modifiers changed from: protected */
    public final void notifySessionEnded(int i) {
        try {
            this.zzepr.notifySessionEnded(i);
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "notifySessionEnded", zzt.class.getSimpleName());
        }
    }

    /* access modifiers changed from: protected */
    public abstract void resume(Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract void start(Bundle bundle);

    public final IObjectWrapper zzacb() {
        try {
            return this.zzepr.zzacb();
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "getWrappedObject", zzt.class.getSimpleName());
            return null;
        }
    }
}

package com.google.android.gms.cast.framework;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzazx;
public class SessionManager {
    private static final zzazx zzejc = new zzazx("SessionManager");
    private final Context mContext;
    private final zzv zzepu;

    public SessionManager(zzv zzv, Context context) {
        this.zzepu = zzv;
        this.mContext = context;
    }

    /* access modifiers changed from: package-private */
    public final void addCastStateListener(CastStateListener castStateListener) {
        zzbp.zzu(castStateListener);
        try {
            this.zzepu.zza(new zzd(castStateListener));
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "addCastStateListener", zzv.class.getSimpleName());
        }
    }

    public void addSessionManagerListener(SessionManagerListener<Session> sessionManagerListener) {
        zzbp.zzfy("Must be called from the main thread.");
        addSessionManagerListener(sessionManagerListener, Session.class);
    }

    public <T extends Session> void addSessionManagerListener(SessionManagerListener<T> sessionManagerListener, Class<T> cls) {
        zzbp.zzu(sessionManagerListener);
        zzbp.zzu(cls);
        zzbp.zzfy("Must be called from the main thread.");
        try {
            this.zzepu.zza(new zzae(sessionManagerListener, cls));
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "addSessionManagerListener", zzv.class.getSimpleName());
        }
    }

    public void endCurrentSession(boolean z) {
        zzbp.zzfy("Must be called from the main thread.");
        try {
            this.zzepu.zzb(true, z);
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "endCurrentSession", zzv.class.getSimpleName());
        }
    }

    public CastSession getCurrentCastSession() {
        zzbp.zzfy("Must be called from the main thread.");
        Session currentSession = getCurrentSession();
        if (currentSession == null || !(currentSession instanceof CastSession)) {
            return null;
        }
        return (CastSession) currentSession;
    }

    public Session getCurrentSession() {
        zzbp.zzfy("Must be called from the main thread.");
        try {
            return (Session) zzn.zzx(this.zzepu.zzacc());
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "getWrappedCurrentSession", zzv.class.getSimpleName());
            return null;
        }
    }

    public final IObjectWrapper zzabu() {
        try {
            return this.zzepu.zzaca();
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "getWrappedThis", zzv.class.getSimpleName());
            return null;
        }
    }
}

package com.google.android.gms.cast.framework;

import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
public final class zzae<T extends Session> extends zzy {
    private final SessionManagerListener<T> zzepv;
    private final Class<T> zzepw;

    public zzae(SessionManagerListener<T> sessionManagerListener, Class<T> cls) {
        this.zzepv = sessionManagerListener;
        this.zzepw = cls;
    }

    @Override // com.google.android.gms.cast.framework.zzx
    public final void zza(IObjectWrapper iObjectWrapper, boolean z) {
        Session session = (Session) zzn.zzx(iObjectWrapper);
        if (this.zzepw.isInstance(session)) {
            this.zzepv.onSessionResumed(this.zzepw.cast(session), z);
        }
    }

    @Override // com.google.android.gms.cast.framework.zzx
    public final IObjectWrapper zzabs() {
        return zzn.zzw(this.zzepv);
    }

    @Override // com.google.android.gms.cast.framework.zzx
    public final void zzc(IObjectWrapper iObjectWrapper, String str) {
        Session session = (Session) zzn.zzx(iObjectWrapper);
        if (this.zzepw.isInstance(session)) {
            this.zzepv.onSessionStarted(this.zzepw.cast(session), str);
        }
    }

    @Override // com.google.android.gms.cast.framework.zzx
    public final void zzd(IObjectWrapper iObjectWrapper, String str) {
        Session session = (Session) zzn.zzx(iObjectWrapper);
        if (this.zzepw.isInstance(session)) {
            this.zzepv.onSessionResuming(this.zzepw.cast(session), str);
        }
    }

    @Override // com.google.android.gms.cast.framework.zzx
    public final void zze(IObjectWrapper iObjectWrapper, int i) {
        Session session = (Session) zzn.zzx(iObjectWrapper);
        if (this.zzepw.isInstance(session)) {
            this.zzepv.onSessionStartFailed(this.zzepw.cast(session), i);
        }
    }

    @Override // com.google.android.gms.cast.framework.zzx
    public final void zzf(IObjectWrapper iObjectWrapper, int i) {
        Session session = (Session) zzn.zzx(iObjectWrapper);
        if (this.zzepw.isInstance(session)) {
            this.zzepv.onSessionEnded(this.zzepw.cast(session), i);
        }
    }

    @Override // com.google.android.gms.cast.framework.zzx
    public final void zzg(IObjectWrapper iObjectWrapper, int i) {
        Session session = (Session) zzn.zzx(iObjectWrapper);
        if (this.zzepw.isInstance(session)) {
            this.zzepv.onSessionResumeFailed(this.zzepw.cast(session), i);
        }
    }

    @Override // com.google.android.gms.cast.framework.zzx
    public final void zzh(IObjectWrapper iObjectWrapper, int i) {
        Session session = (Session) zzn.zzx(iObjectWrapper);
        if (this.zzepw.isInstance(session)) {
            this.zzepv.onSessionSuspended(this.zzepw.cast(session), i);
        }
    }

    @Override // com.google.android.gms.cast.framework.zzx
    public final void zzt(IObjectWrapper iObjectWrapper) {
        Session session = (Session) zzn.zzx(iObjectWrapper);
        if (this.zzepw.isInstance(session)) {
            this.zzepv.onSessionStarting(this.zzepw.cast(session));
        }
    }

    @Override // com.google.android.gms.cast.framework.zzx
    public final void zzu(IObjectWrapper iObjectWrapper) {
        Session session = (Session) zzn.zzx(iObjectWrapper);
        if (this.zzepw.isInstance(session)) {
            this.zzepv.onSessionEnding(this.zzepw.cast(session));
        }
    }
}

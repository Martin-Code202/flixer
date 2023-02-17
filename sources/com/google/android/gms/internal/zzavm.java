package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastMediaControlIntent;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionProvider;
public final class zzavm extends SessionProvider {
    private final CastOptions zzeom;
    private final zzawd zzepz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzavm(Context context, CastOptions castOptions, zzawd zzawd) {
        super(context, castOptions.getSupportedNamespaces().isEmpty() ? CastMediaControlIntent.categoryForCast(castOptions.getReceiverApplicationId()) : CastMediaControlIntent.categoryForCast(castOptions.getReceiverApplicationId(), castOptions.getSupportedNamespaces()));
        this.zzeom = castOptions;
        this.zzepz = zzawd;
    }

    @Override // com.google.android.gms.cast.framework.SessionProvider
    public final Session createSession(String str) {
        return new CastSession(getContext(), getCategory(), str, this.zzeom, Cast.CastApi, new zzavn(), new zzawp(getContext(), this.zzeom, this.zzepz));
    }

    @Override // com.google.android.gms.cast.framework.SessionProvider
    public final boolean isSessionRecoverable() {
        return this.zzeom.getResumeSavedSession();
    }
}

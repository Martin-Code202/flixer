package com.google.android.gms.cast.framework;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.dynamic.IObjectWrapper;
public abstract class SessionProvider {
    private final Context mApplicationContext;
    private final String mCategory;
    private final zza zzepx = new zza();

    class zza extends zzaa {
        private zza() {
        }

        @Override // com.google.android.gms.cast.framework.zzz
        public final String getCategory() {
            return SessionProvider.this.getCategory();
        }

        @Override // com.google.android.gms.cast.framework.zzz
        public final boolean isSessionRecoverable() {
            return SessionProvider.this.isSessionRecoverable();
        }

        @Override // com.google.android.gms.cast.framework.zzz
        public final IObjectWrapper zzfa(String str) {
            Session createSession = SessionProvider.this.createSession(str);
            if (createSession == null) {
                return null;
            }
            return createSession.zzacb();
        }
    }

    protected SessionProvider(Context context, String str) {
        this.mApplicationContext = ((Context) zzbp.zzu(context)).getApplicationContext();
        this.mCategory = zzbp.zzgg(str);
    }

    public abstract Session createSession(String str);

    public final String getCategory() {
        return this.mCategory;
    }

    public final Context getContext() {
        return this.mApplicationContext;
    }

    public abstract boolean isSessionRecoverable();

    public final IBinder zzacl() {
        return this.zzepx;
    }
}

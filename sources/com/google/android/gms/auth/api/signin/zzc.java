package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;
/* access modifiers changed from: package-private */
public final class zzc implements Comparator<Scope> {
    zzc() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Scope scope, Scope scope2) {
        return scope.zzaft().compareTo(scope2.zzaft());
    }
}

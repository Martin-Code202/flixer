package com.google.android.gms.internal;

import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.Status;
/* access modifiers changed from: package-private */
public final class zzazf implements Cast.ApplicationConnectionResult {
    private final String mSessionId;
    private final Status mStatus;
    private final ApplicationMetadata zzfbm;
    private final String zzfbn;
    private final boolean zzfbo;

    public zzazf(Status status) {
        this(status, null, null, null, false);
    }

    public zzazf(Status status, ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
        this.mStatus = status;
        this.zzfbm = applicationMetadata;
        this.zzfbn = str;
        this.mSessionId = str2;
        this.zzfbo = z;
    }

    @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
    public final ApplicationMetadata getApplicationMetadata() {
        return this.zzfbm;
    }

    @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
    public final String getApplicationStatus() {
        return this.zzfbn;
    }

    @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
    public final String getSessionId() {
        return this.mSessionId;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.mStatus;
    }

    @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
    public final boolean getWasLaunched() {
        return this.zzfbo;
    }
}

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
public class zzan extends GoogleApiClient {
    private final String zzflf;

    public zzan(String str) {
        this.zzflf = str;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException(this.zzflf);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        throw new UnsupportedOperationException(this.zzflf);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void connect() {
        throw new UnsupportedOperationException(this.zzflf);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void disconnect() {
        throw new UnsupportedOperationException(this.zzflf);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        throw new UnsupportedOperationException(this.zzflf);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnected() {
        throw new UnsupportedOperationException(this.zzflf);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void reconnect() {
        throw new UnsupportedOperationException(this.zzflf);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.zzflf);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.zzflf);
    }
}

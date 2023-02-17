package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzas;
import com.google.android.gms.common.internal.zzat;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.util.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
/* access modifiers changed from: package-private */
public abstract class zzg extends zzat {
    private int zzffn;

    protected zzg(byte[] bArr) {
        if (bArr.length != 25) {
            int length = bArr.length;
            String zza = zzk.zza(bArr, 0, bArr.length, false);
            Log.wtf("GoogleCertificates", new StringBuilder(String.valueOf(zza).length() + 51).append("Cert hash data has incorrect length (").append(length).append("):\n").append(zza).toString(), new Exception());
            bArr = Arrays.copyOfRange(bArr, 0, 25);
            zzbp.zzb(bArr.length == 25, new StringBuilder(55).append("cert hash data has incorrect length. length=").append(bArr.length).toString());
        }
        this.zzffn = Arrays.hashCode(bArr);
    }

    protected static byte[] zzfr(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        IObjectWrapper zzaez;
        if (obj == null || !(obj instanceof zzas)) {
            return false;
        }
        try {
            zzas zzas = (zzas) obj;
            if (zzas.zzafa() == hashCode() && (zzaez = zzas.zzaez()) != null) {
                return Arrays.equals(getBytes(), (byte[]) zzn.zzx(zzaez));
            }
            return false;
        } catch (RemoteException e) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public abstract byte[] getBytes();

    @Override // java.lang.Object
    public int hashCode() {
        return this.zzffn;
    }

    @Override // com.google.android.gms.common.internal.zzas
    public final IObjectWrapper zzaez() {
        return zzn.zzw(getBytes());
    }

    @Override // com.google.android.gms.common.internal.zzas
    public final int zzafa() {
        return hashCode();
    }
}

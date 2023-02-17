package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbp;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* access modifiers changed from: package-private */
public final class zzaoq {
    private int zzdtm;
    private ByteArrayOutputStream zzdtn = new ByteArrayOutputStream();
    private /* synthetic */ zzaop zzdto;

    public zzaoq(zzaop zzaop) {
        this.zzdto = zzaop;
    }

    public final byte[] getPayload() {
        return this.zzdtn.toByteArray();
    }

    public final boolean zze(zzaoi zzaoi) {
        zzbp.zzu(zzaoi);
        if (this.zzdtm + 1 > zzanv.zzya()) {
            return false;
        }
        String zza = this.zzdto.zza(zzaoi, false);
        if (zza == null) {
            this.zzdto.zzvy().zza(zzaoi, "Error formatting hit");
            return true;
        }
        byte[] bytes = zza.getBytes();
        int length = bytes.length;
        int i = length;
        if (length > zzanv.zzxw()) {
            this.zzdto.zzvy().zza(zzaoi, "Hit size exceeds the maximum size limit");
            return true;
        }
        if (this.zzdtn.size() > 0) {
            i++;
        }
        if (this.zzdtn.size() + i > zzaod.zzdry.get().intValue()) {
            return false;
        }
        try {
            if (this.zzdtn.size() > 0) {
                this.zzdtn.write(zzaop.zzdtl);
            }
            this.zzdtn.write(bytes);
            this.zzdtm++;
            return true;
        } catch (IOException e) {
            this.zzdto.zze("Failed to write payload when batching hits", e);
            return true;
        }
    }

    public final int zzza() {
        return this.zzdtm;
    }
}

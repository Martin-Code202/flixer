package com.google.android.gms.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import com.google.android.gms.internal.zzeb;
import com.google.android.gms.internal.zzed;
public final class zzc extends zzeb implements zzb {
    zzc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.iid.IMessengerCompat");
    }

    @Override // com.google.android.gms.iid.zzb
    public final void send(Message message) {
        Parcel zzax = zzax();
        zzed.zza(zzax, message);
        zzc(1, zzax);
    }
}

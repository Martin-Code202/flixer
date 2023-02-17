package com.google.android.gms.iid;

import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
public class MessengerCompat implements ReflectedParcelable {
    public static final Parcelable.Creator<MessengerCompat> CREATOR = new zzd();
    private Messenger zzhtt;
    private zzb zzhtu;

    public MessengerCompat(IBinder iBinder) {
        zzb zzb;
        if (Build.VERSION.SDK_INT >= 21) {
            this.zzhtt = new Messenger(iBinder);
            return;
        }
        if (iBinder == null) {
            zzb = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.iid.IMessengerCompat");
            zzb = queryLocalInterface instanceof zzb ? (zzb) queryLocalInterface : new zzc(iBinder);
        }
        this.zzhtu = zzb;
    }

    private final IBinder getBinder() {
        return this.zzhtt != null ? this.zzhtt.getBinder() : this.zzhtu.asBinder();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return getBinder().equals(((MessengerCompat) obj).getBinder());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.lang.Object
    public int hashCode() {
        return getBinder().hashCode();
    }

    public final void send(Message message) {
        if (this.zzhtt != null) {
            this.zzhtt.send(message);
        } else {
            this.zzhtu.send(message);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.zzhtt != null) {
            parcel.writeStrongBinder(this.zzhtt.getBinder());
        } else {
            parcel.writeStrongBinder(this.zzhtu.asBinder());
        }
    }
}

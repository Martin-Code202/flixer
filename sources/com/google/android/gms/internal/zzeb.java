package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
public class zzeb implements IInterface {
    private final IBinder zzajw;
    private final String zzajx;

    protected zzeb(IBinder iBinder, String str) {
        this.zzajw = iBinder;
        this.zzajx = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.zzajw;
    }

    /* access modifiers changed from: protected */
    public final Parcel zza(int i, Parcel parcel) {
        parcel = Parcel.obtain();
        try {
            this.zzajw.transact(i, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e) {
            throw e;
        } finally {
            parcel.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final Parcel zzax() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzajx);
        return obtain;
    }

    /* access modifiers changed from: protected */
    public final void zzb(int i, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.zzajw.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzc(int i, Parcel parcel) {
        try {
            this.zzajw.transact(i, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}

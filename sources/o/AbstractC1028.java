package o;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;
/* renamed from: o.ᵞ  reason: contains not printable characters */
public interface AbstractC1028 extends IInterface {
    /* renamed from: ˊ  reason: contains not printable characters */
    int mo16018(int i, String str, String str2, Bundle bundle);

    /* renamed from: ˋ  reason: contains not printable characters */
    int mo16019(int i, String str, String str2);

    /* renamed from: ˋ  reason: contains not printable characters */
    Bundle mo16020(int i, String str, String str2, String str3, Bundle bundle);

    /* renamed from: ˋ  reason: contains not printable characters */
    Bundle mo16021(int i, String str, String str2, String str3, String str4);

    /* renamed from: ˎ  reason: contains not printable characters */
    int mo16022(int i, String str, String str2);

    /* renamed from: ˏ  reason: contains not printable characters */
    Bundle mo16023(int i, String str, String str2, Bundle bundle);

    /* renamed from: ॱ  reason: contains not printable characters */
    int mo16024(int i, String str, String str2);

    /* renamed from: ॱ  reason: contains not printable characters */
    Bundle mo16025(int i, String str, String str2, String str3);

    /* renamed from: ॱ  reason: contains not printable characters */
    Bundle mo16026(int i, String str, String str2, String str3, String str4, Bundle bundle);

    /* renamed from: ॱ  reason: contains not printable characters */
    Bundle mo16027(int i, String str, List<String> list, String str2, String str3, String str4);

    /* renamed from: o.ᵞ$ˊ  reason: contains not printable characters */
    public static abstract class AbstractBinderC1029 extends Binder implements AbstractC1028 {
        public AbstractBinderC1029() {
            attachInterface(this, "com.android.vending.billing.IInAppBillingService");
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public static AbstractC1028 m16028(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof AbstractC1028)) {
                return new C1030(iBinder);
            }
            return (AbstractC1028) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            Bundle bundle;
            Bundle bundle2;
            Bundle bundle3;
            Bundle bundle4;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                    int r10 = mo16022(parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(r10);
                    return true;
                case 2:
                    parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                    int readInt = parcel.readInt();
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    if (0 != parcel.readInt()) {
                        bundle4 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle4 = null;
                    }
                    Bundle r11 = mo16023(readInt, readString, readString2, bundle4);
                    parcel2.writeNoException();
                    if (r11 != null) {
                        parcel2.writeInt(1);
                        r11.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 3:
                    parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                    Bundle r12 = mo16021(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (r12 != null) {
                        parcel2.writeInt(1);
                        r12.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 4:
                    parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                    Bundle r112 = mo16025(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (r112 != null) {
                        parcel2.writeInt(1);
                        r112.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 5:
                    parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                    int r102 = mo16024(parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(r102);
                    return true;
                case 6:
                    parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                    int r103 = mo16019(parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(r103);
                    return true;
                case 7:
                    parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                    Bundle r13 = mo16027(parcel.readInt(), parcel.readString(), parcel.createStringArrayList(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (r13 != null) {
                        parcel2.writeInt(1);
                        r13.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 8:
                    parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                    int readInt2 = parcel.readInt();
                    String readString3 = parcel.readString();
                    String readString4 = parcel.readString();
                    String readString5 = parcel.readString();
                    String readString6 = parcel.readString();
                    if (0 != parcel.readInt()) {
                        bundle3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle3 = null;
                    }
                    Bundle r132 = mo16026(readInt2, readString3, readString4, readString5, readString6, bundle3);
                    parcel2.writeNoException();
                    if (r132 != null) {
                        parcel2.writeInt(1);
                        r132.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 9:
                    parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                    int readInt3 = parcel.readInt();
                    String readString7 = parcel.readString();
                    String readString8 = parcel.readString();
                    String readString9 = parcel.readString();
                    if (0 != parcel.readInt()) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle2 = null;
                    }
                    Bundle r122 = mo16020(readInt3, readString7, readString8, readString9, bundle2);
                    parcel2.writeNoException();
                    if (r122 != null) {
                        parcel2.writeInt(1);
                        r122.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                case 10:
                    parcel.enforceInterface("com.android.vending.billing.IInAppBillingService");
                    int readInt4 = parcel.readInt();
                    String readString10 = parcel.readString();
                    String readString11 = parcel.readString();
                    if (0 != parcel.readInt()) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                    } else {
                        bundle = null;
                    }
                    int r113 = mo16018(readInt4, readString10, readString11, bundle);
                    parcel2.writeNoException();
                    parcel2.writeInt(r113);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.android.vending.billing.IInAppBillingService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o.ᵞ$ˊ$ˋ  reason: contains not printable characters */
        public static class C1030 implements AbstractC1028 {

            /* renamed from: ˋ  reason: contains not printable characters */
            private IBinder f15136;

            C1030(IBinder iBinder) {
                this.f15136 = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f15136;
            }

            @Override // o.AbstractC1028
            /* renamed from: ˎ */
            public int mo16022(int i, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f15136.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // o.AbstractC1028
            /* renamed from: ˏ */
            public Bundle mo16023(int i, String str, String str2, Bundle bundle) {
                Bundle bundle2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f15136.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (0 != obtain2.readInt()) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle2 = null;
                    }
                    return bundle2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // o.AbstractC1028
            /* renamed from: ˋ */
            public Bundle mo16021(int i, String str, String str2, String str3, String str4) {
                Bundle bundle;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.f15136.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (0 != obtain2.readInt()) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle = null;
                    }
                    return bundle;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // o.AbstractC1028
            /* renamed from: ॱ */
            public Bundle mo16025(int i, String str, String str2, String str3) {
                Bundle bundle;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f15136.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (0 != obtain2.readInt()) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle = null;
                    }
                    return bundle;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // o.AbstractC1028
            /* renamed from: ॱ */
            public int mo16024(int i, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f15136.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // o.AbstractC1028
            /* renamed from: ˋ */
            public int mo16019(int i, String str, String str2) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f15136.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // o.AbstractC1028
            /* renamed from: ॱ */
            public Bundle mo16027(int i, String str, List<String> list, String str2, String str3, String str4) {
                Bundle bundle;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeStringList(list);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.f15136.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (0 != obtain2.readInt()) {
                        bundle = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle = null;
                    }
                    return bundle;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // o.AbstractC1028
            /* renamed from: ॱ */
            public Bundle mo16026(int i, String str, String str2, String str3, String str4, Bundle bundle) {
                Bundle bundle2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f15136.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    if (0 != obtain2.readInt()) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle2 = null;
                    }
                    return bundle2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // o.AbstractC1028
            /* renamed from: ˋ */
            public Bundle mo16020(int i, String str, String str2, String str3, Bundle bundle) {
                Bundle bundle2;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f15136.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    if (0 != obtain2.readInt()) {
                        bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(obtain2);
                    } else {
                        bundle2 = null;
                    }
                    return bundle2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // o.AbstractC1028
            /* renamed from: ˊ */
            public int mo16018(int i, String str, String str2, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.android.vending.billing.IInAppBillingService");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f15136.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}

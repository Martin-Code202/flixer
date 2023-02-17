package o;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.gcm.PendingCallback;
/* renamed from: o.ʶ  reason: contains not printable characters */
public final class C0415 {
    /* renamed from: ॱ  reason: contains not printable characters */
    public AbstractC0560 m14224(Bundle bundle) {
        if (bundle == null) {
            Log.e("FJD.GooglePlayReceiver", "No callback received, terminating");
            return null;
        }
        bundle.setClassLoader(PendingCallback.class.getClassLoader());
        Parcelable parcelable = bundle.getParcelable("callback");
        if (parcelable == null) {
            Log.e("FJD.GooglePlayReceiver", "No callback received, terminating");
            return null;
        } else if (parcelable instanceof PendingCallback) {
            return new C0382(((PendingCallback) parcelable).getIBinder());
        } else {
            Log.e("FJD.GooglePlayReceiver", "Bad callback received, terminating");
            return null;
        }
    }
}
